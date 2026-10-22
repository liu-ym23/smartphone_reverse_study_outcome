package wr8;

import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.social.userchat.start.core.StartTaskExecTime;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends xr8.a {
    public static CompletableDeferred<Boolean> a;
    public static final a b = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            CompletableDeferred<Boolean> r3 = d.a;
            b.c("onLogIn");
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            CompletableDeferred<Boolean> r3 = d.a;
            b.c("onLogout");
        }
    }

    public static final class b {
        public static void b() {
            d.a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }

        public static e a() {
            e r0 = (e) AuthModelDelegate.b.y().getValue();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return LaunchCacheDelegate.b.b();
        }

        public static void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "reason");
            if (d.a == null) goto L9;
            FLogger.a.i("MainBotPreFetchHelper", "cancel load deffer， reason is [" + r3 + ']');
            CompletableDeferred<Boolean> r4 = d.a;
            if (r4 == null) goto L7;
            r4.complete(Boolean.TRUE);
        L7:
            d.a = null;
            AccountService.a.D(d.b);
            return;
        }
    }

    @Override // xr8.a
    public final boolean a() {
        return false;
    }

    @Override // xr8.a
    public final void b() {
    }

    @Override // xr8.a
    public final int d() {
        return 50;
    }

    static {
        b = new a();
    }

    public d() {
        AccountService.a.E(b);
    }

    @Override // xr8.a
    public final void e() {
        b.c("skip preload task execute");
    }

    @Override // xr8.a
    public final StartTaskExecTime c() {
        return StartTaskExecTime.BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED;
    }
}
