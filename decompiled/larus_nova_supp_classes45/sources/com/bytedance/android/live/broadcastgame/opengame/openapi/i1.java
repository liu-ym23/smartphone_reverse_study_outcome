package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudLoginService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i1 extends BaseOpenMethod<JSONObject> {
    public final CloudExecutor h;
    public final Context i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i1 a;

        public b(i1 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IBaseUser r5 = (IBaseUser) r4;
            i1 r6 = this.a;
            r6.getClass();
            ALogger.i("UserLoginMethod_callLogin", "login start");
            int r0 = CloudLoginService.a;
            CloudLoginService.a(r6.h, new UserLoginMethod$callLogin$1(r6), new UserLoginMethod$callLogin$2(r6));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i1 a;

        public c(i1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.i("UserLoginMethod_call", "user not login host");
            this.a.n(OpenApiErrorInfo.NOT_LOGIN, null);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "login";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r5 = r3.optBoolean("force", true);
        if (jc1.k.n(IUserService.class).user().isLogin() == false) goto L5;
        ALogger.i("UserLoginMethod_callLogin", "login start");
        int r6 = CloudLoginService.a;
        CloudLoginService.a(this.h, new UserLoginMethod$callLogin$1(this), new UserLoginMethod$callLogin$2(this));
        return;
    L5:
        if (r5 == false) goto L7;
        com.bytedance.android.livesdk.user.f r7 = jc1.k.n(IUserService.class).user();
        Context r8 = this.i;
        com.bytedance.android.livesdk.user.l.a r0 = new com.bytedance.android.livesdk.user.l.a();
        r0.a = s1.B(2131915990);
        r0.d = "live_open_platform";
        r0.c = -1;
        j(r7.login(r8, new com.bytedance.android.livesdk.user.l(r0)).subscribe(new b(this), new c(this)));
        return;
    L7:
        n(OpenApiErrorInfo.NOT_LOGIN, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public i1(PluginContext r2, CloudExecutor r3, Context r4, Queue<Long> r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "cloudExecutor");
        Intrinsics.checkNotNullParameter(r4, "_context");
        super(r2, r5);
        this.h = r3;
        this.i = r4;
    }
}
