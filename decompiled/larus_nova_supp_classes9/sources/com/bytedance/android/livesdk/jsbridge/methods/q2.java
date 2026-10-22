package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.DoLiveCertResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.s8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "doLiveCert")
public final class q2 extends w20.m0<s8, DoLiveCertResultModel> {
    public final String a;
    public final CompositeDisposable b;

    public final void onTerminate() {
        this.b.clear();
    }

    public q2() {
        this.a = "OpenLiveFaceCert";
        this.b = new CompositeDisposable();
    }

    public final void invoke(Object r4, CallContext r5) {
        s8 r6 = (s8) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        IUserService r0 = jc1.k.f(IUserService.class);
        IHostContext r1 = jc1.k.f(IHostContext.class);
        if (r0 == null) goto L39;
        if (r1 == null) goto L39;
        if (r0.user().isLogin() == false) goto L39;
        Context r7 = r5.getContext();
        if ((r7 instanceof Activity) == false) goto L38;
        v80.c r2 = new v80.c();
        ((v80.h) r2).a = r7;
        Boolean r8 = r6.c();
        if (r8 == null) goto L13;
        r2.d = r8.booleanValue();
    L13:
        String r9 = r6.e();
        if (r9 == null) goto L16;
        Intrinsics.checkNotNullParameter(r9, "identityCode");
        r2.c.put("identity_code", r9);
    L16:
        String r10 = r6.f();
        if (r10 == null) goto L19;
        Intrinsics.checkNotNullParameter(r10, "identityName");
        r2.c.put("identity_name", r10);
    L19:
        String r11 = r6.h();
        if (r11 == null) goto L22;
        r2.a("scene", r11);
    L22:
        String r13 = r6.d();
        if (r13 == null) goto L25;
        r2.a("flow", r13);
    L25:
        String r14 = r6.i();
        if (r14 == null) goto L28;
        r2.a("ticket", r14);
    L28:
        String r15 = r6.a();
        if (r15 == null) goto L31;
        r2.a("cert_app_id", r15);
    L31:
        String r16 = r6.g();
        if (r16 == null) goto L34;
        r2.a("mode", r16);
    L34:
        JSONObject r17 = r6.b();
        if (r17 == null) goto L37;
        Intrinsics.checkNotNullParameter(r17, "extra");
    L37:
        ALogger.i("[LiveVerifyFullTracer]", this.a + "， flow = " + r6.d() + ", scene = " + r6.h() + "， face_Only = " + r6.c());
        p2 r18 = new p2(this);
        Intrinsics.checkNotNullParameter(r18, "callback");
        r2.b = r18;
        x80.c.a(3).a.a(r2);
        return;
    L38:
        finishWithFailure(new Throwable("context is not Activity instance."));
        return;
    L39:
        DoLiveCertResultModel r19 = new DoLiveCertResultModel();
        r19.c(DoLiveCertResultModel.Code.Failed);
        r19.h("ocr service proxy is unavaliable");
        Unit r20 = Unit.INSTANCE;
        finishWithResult(r19);
    }
}
