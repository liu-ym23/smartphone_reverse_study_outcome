package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "vcdAuthorize")
public final class h5 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public Disposable a;
    public boolean b;
    public final a c;

    public static final class a implements IMiddlewareHostBusiness.AuthorizeCallback {
        public final /* synthetic */ h5 a;

        public final void onAuthorized() {
            h5 r0 = this.a;
            if (r0.b == true) goto L6;
            JSONObject r1 = new JSONObject();
            r1.put("status_code", 1);
            Unit r2 = Unit.INSTANCE;
            r0.finishWithResult(r1);
            return;
        }

        public final void onDisauthorized() {
            h5 r0 = this.a;
            if (r0.b == true) goto L6;
            r0.finishWithFailure();
            return;
        }

        public final void onInterrupted() {
            h5 r0 = this.a;
            if (r0.b == true) goto L6;
            r0.finishWithFailure();
            return;
        }

        public a(h5 r1) {
            this.a = r1;
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = true;
    }

    public h5() {
        this.c = new a(this);
    }

    public final void invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = r7.optString("type", "content");
        String r8 = r7.optString("content", BuildConfig.FLAVOR);
        if (r8.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        finishWithFailure();
        return;
    L8:
        Disposable r2 = null;
        if (UserSetting.b() == false) goto L14;
        IUserServiceV2 r3 = jc1.k.f(IUserServiceV2.class);
        if (r3 == null) goto L13;
        Single r4 = r3.updateCurrentUser(null, "VcdAuthorizeMethod");
    L15:
        if (r4 == null) goto L19;
        Single r9 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L19;
        r2 = r9.subscribe(new i5(this, r0, r6, r8), new j5(this));
    L19:
        this.a = r2;
        return;
    L13:
        r4 = null;
        goto L15
    L14:
        r4 = jc1.k.n(IUserService.class).user().j();
        goto L15
    L5:
        r1 = false;
        goto L6
    }
}
