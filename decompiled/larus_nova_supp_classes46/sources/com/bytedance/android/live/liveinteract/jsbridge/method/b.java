package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetConcertStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.qa;
import w20.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends r2<qa, LiveGetConcertStatusResultModel> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final void invoke(Object r6, CallContext r7) {
        qa r8 = (qa) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r9 = r8.getType();
        String r0 = "";
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        String r1 = r8.a();
        if (r1 == null) goto L9;
        r0 = r1;
    L9:
        JsonObject r10 = r8.b();
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L14;
        gd2.f r3 = r2.getConcertStageService();
        if (r3 == null) goto L14;
        JsonObject r4 = r3.g(new hd2.a(r0, r9, r10));
    L15:
        LiveGetConcertStatusResultModel r5 = new LiveGetConcertStatusResultModel();
        r5.a(LiveGetConcertStatusResultModel.Code.Success);
        r5.b(r4);
        r5.c("get success");
        ALogger.i("DynamicGetConcertStatusMethod", "DynamicGetConcertStatusMethod#invoke type=" + r9 + " bizId=" + r0 + " extra=" + r10 + ", resultData=" + r4);
        finishWithResult(r5);
        return;
    L14:
        r4 = null;
        goto L15
    }
}
