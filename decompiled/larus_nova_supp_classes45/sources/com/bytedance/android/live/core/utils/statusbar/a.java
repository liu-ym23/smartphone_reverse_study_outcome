package com.bytedance.android.live.core.utils.statusbar;

import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static volatile a a;
    public static final C0173a b = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.statusbar.a$a, reason: collision with other inner class name */
    public static final class C0173a {
        public final a a() {
            a r0 = a.a;
            if (r0 != null) goto L15;
            monitor-enter(this);
            r0 = a.a;     // Catch: Throwable -> L9
            if (r0 != null) goto L11;
            r0 = new a();     // Catch: Throwable -> L9
            a.a = r0;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r0;
        }

        public C0173a() {
        }
    }

    static {
        b = new C0173a();
    }

    public a() {
        new LinkedHashSet();
    }

    public static void a(int r2, StatusBarInfoType r3) {
        Intrinsics.checkNotNullParameter(r3, "StatusBarInfoType");
        ALogger.i("ImmersiveStatusBarMgr", "statusbar " + r3.name() + ", result = " + r2);
    }
}
