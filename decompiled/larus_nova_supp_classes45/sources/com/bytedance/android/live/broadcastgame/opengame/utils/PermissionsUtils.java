package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.app.Activity;
import android.app.Fragment;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PermissionsUtils {
    public static final Lazy a = null;

    public static final class a implements c {
        public final Handler a;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.utils.PermissionsUtils$a$a, reason: collision with other inner class name */
        public static final class RunnableC0088a implements Runnable {
            public final /* synthetic */ String[] a;

            public RunnableC0088a(String[] r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Arrays.fill(new int[this.a.length], 0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a() {
            this.a = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.PermissionsUtils.c
        public void requestPermissions(Activity r1, String[] r2, b r3) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            Intrinsics.checkNotNullParameter(r2, "permissions");
            this.a.post(new RunnableC0088a(r2));
        }
    }

    public interface b {
    }

    public interface c {
        void requestPermissions(Activity r1, String[] r2, b r3);
    }

    public static final class d implements c {
        public d() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.PermissionsUtils.c
        public void requestPermissions(Activity r1, String[] r2, b r3) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            Intrinsics.checkNotNullParameter(r2, "permissions");
            Fragment r4 = r1.getFragmentManager().findFragmentByTag("permissions");
            if (r4 == null) goto L7;
            PermissionFragment r5 = (PermissionFragment) r4;
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.utils.PermissionFragment");
        }
    }

    static {
        a = LazyKt.lazy(PermissionsUtils$IMPL$2.INSTANCE);
    }

    public final void requestPermissions(Activity r2, String[] r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "permissions");
        ((c) a.getValue()).requestPermissions(r2, r3, r4);
    }
}
