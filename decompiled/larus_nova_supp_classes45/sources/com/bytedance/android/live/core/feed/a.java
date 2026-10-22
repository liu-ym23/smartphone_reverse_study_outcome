package com.bytedance.android.live.core.feed;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static a c;
    public static final C0139a d = null;
    public boolean a;
    public long b;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.feed.a$a, reason: collision with other inner class name */
    public static final class C0139a {
        public C0139a() {
        }

        @JvmStatic
        public final synchronized a a() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (a.c != null) goto L6;
            a.c = new a();     // Catch: Throwable -> L9
        L6:
            a r0 = a.c;     // Catch: Throwable -> L9
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r0;
        }
    }

    @JvmStatic
    public static final synchronized a a() {
        monitor-enter(a.class);
        a r1 = d.a();     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        d = new C0139a();
    }

    public a() {
        this.b = -1;
    }

    public final boolean b(Long r6) {
        if (r6 == null) goto L8;
        r6.longValue();
        if (this.b != r6.longValue()) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public final boolean c(Long r3) {
        if (r3 == null) goto L11;
        long r0 = r3.longValue();
        if (this.a == false) goto L8;
        nn2.a r4 = nn2.a.d;
        if (nn2.a.a.a().b(r0) == true) goto L8;
        return true;
    L8:
        return false;
    L11:
        return this.a;
    }
}
