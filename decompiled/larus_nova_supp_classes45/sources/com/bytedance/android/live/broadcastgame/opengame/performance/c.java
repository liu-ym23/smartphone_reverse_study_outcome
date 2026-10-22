package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.utils.z1;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements z1 {
    public String a;
    public String b;
    public String c;
    public volatile JSONArray d;
    public final long e;
    public final /* synthetic */ z1 f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.e r2 = (com.bytedance.android.live.network.response.e) r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.performance.c$c, reason: collision with other inner class name */
    public static final class C0074c<T> implements Consumer {
        public static final C0074c a = null;

        static {
            a = new C0074c();
        }

        public C0074c() {
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            if ((r6 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r0 = (CustomApiServerException) r6;
            if (r0.getErrorCode() != 4014051) goto L7;
            f2.c("数据异常，未产生报告", 0);
        L9:
            ALogger.d("OpenPlatformPerfReporter", "/task/finish/ error: " + r6.getMessage());
            return;
        L7:
            f2.c(r0.getPrompt(), 0);
            goto L9
        L8:
            f2.c("请求失败，可尝试在开发者平台停止", 0);
            goto L9
        }
    }

    static {
    }

    public final void V1(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.f.V1(r2);
    }

    public final void a() {
        boolean r1 = false;
        if (this.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L14:
        ALogger.d("OpenPlatformPerfReporter", "appId: " + this.a + " or taskId: " + this.b + " is empty!!");
        return;
    L8:
        if (this.b.length() != 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L14;
        Lazy r2 = LiveOpenGameClient.d;
        V1(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).submitPerfTestTask(this.a, this.e, this.b).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, C0074c.a));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public c(OpenPlatformPerfRuntime r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "disposer");
        this.f = r2;
        this.e = r3;
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = new JSONArray();
    }
}
