package com.bytedance.common.a;

import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0109a f1957a;

    /* JADX INFO: renamed from: com.bytedance.common.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.common.a.a$a, reason: collision with other inner class name */
    private static class C0109a {
        private C0109a() {
        }

        /* synthetic */ C0109a(AnonymousClass1 r1) {
            this();
        }

        public long a(ActivityManager.MemoryInfo r1) {
            return 0;
        }
    }

    private static class b extends C0109a {
        private b() {
            super(null);
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.a.a.C0109a
        public long a(ActivityManager.MemoryInfo r1) {
            return r1.totalMem;
        }
    }

    static {
        AnonymousClass1 r1 = null;
        if (Build.VERSION.SDK_INT < 16) goto L5;
        C0109a r0 = new b(r1);
    L6:
        f1957a = r0;
        return;
    L5:
        r0 = new C0109a(r1);
        goto L6
    }

    public static long a(ActivityManager.MemoryInfo r2) {
        return f1957a.a(r2);
    }
}
