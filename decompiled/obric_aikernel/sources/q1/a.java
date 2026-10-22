package q1;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f12452a;

    /* JADX INFO: renamed from: q1.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0280a {
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(C0280a r10) {
            this();
        }

        public long a(ActivityManager.MemoryInfo r10) {
            return 0;
        }
    }

    @TargetApi(16)
    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(C0280a r10) {
            this();
        }

        @Override // q1.a.b
        public long a(ActivityManager.MemoryInfo r10) {
            return r10.totalMem;
        }
    }

    static {
        C0280a r10 = null;
        if (Build.VERSION.SDK_INT < 16) goto L5;
        b r11 = new c(r10);
    L6:
        f12452a = r11;
        return;
    L5:
        r11 = new b(r10);
        goto L6
    }

    public static long a(ActivityManager.MemoryInfo r10) {
        return f12452a.a(r10);
    }
}
