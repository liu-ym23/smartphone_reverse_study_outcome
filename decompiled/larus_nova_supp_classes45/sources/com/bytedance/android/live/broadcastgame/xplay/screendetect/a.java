package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.ik1;
import com.bytedance.android.livesdk.config.vz0;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public static final /* synthetic */ int c = 0;
    public final ik1 a;
    public final c b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.screendetect.a$a, reason: collision with other inner class name */
    public static final class C0106a {
        public static a a(c r2) {
            Intrinsics.checkNotNullParameter(r2, "screenDetectorParams");
            if (r2.a == false) goto L5;
            int r1 = f.k;
            Intrinsics.checkNotNullParameter(r2, "screenDetectorParams");
            return new f(r2);
        L5:
            int r3 = XplayAudienceScreenDetector.f;
            Intrinsics.checkNotNullParameter(r2, "screenDetectorParams");
            return new XplayAudienceScreenDetector(r2);
        }
    }

    static {
    }

    public abstract void e();

    public abstract void f();

    public final void g() {
        if (this.a.c() == true) goto L5;
        return;
    L5:
        e();
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "screenDetectorParams");
        this.b = r2;
        this.a = (ik1) vz0.a.getValue();
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (v.a() == false) goto L5;
    L6:
        XplayLog.c("XplayScreenDetect", r2);
        return;
    L5:
        if (this.a.d() == true) goto L6;
    }

    public static JSONObject a(a r1, Function1 r2) {
        Object r0 = new JSONObject();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "jsonObject");
        Intrinsics.checkNotNullParameter(r2, "block");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl((JSONObject) r2.invoke(r0));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == true) goto L12;
        r0 = r4;
    L12:
        return (JSONObject) r0;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ void d(a r2, String r3, JSONObject r4) {
        r2.c(r3, r4, new JSONObject(), new JSONObject());
    }

    public final void c(String r5, JSONObject r6, JSONObject r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r5, "serviceName");
        if (r6 != null) goto L5;
        JSONObject r0 = new JSONObject();
    L12:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.put("is_anchor", m2.b(this.b.a));     // Catch: Throwable -> L8
        r0.put("room_id", this.b.b);     // Catch: Throwable -> L8
        r0.put("anchor_id", this.b.c);     // Catch: Throwable -> L8
        this.b.getClass();     // Catch: Throwable -> L8
        r0.put("user_id", k.n(IUserService.class).user().n());     // Catch: Throwable -> L8
        r0.put("game_id", this.b.d);     // Catch: Throwable -> L8
        r0.put(OpenPlatformBaseDebugger.APP_ID, this.b.e);     // Catch: Throwable -> L8
        Result.constructor-impl(r0.put("game_name", this.b.f));     // Catch: Throwable -> L8
    L10:
        b(r5 + ": " + r6 + ' ' + r7 + ' ' + r8);
        LiveTracingMonitor.f(r5, LiveTracingMonitor.EventModule.XPLAY, r0, r7, r8);
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L5:
        r0 = r6;
        goto L12
    }
}
