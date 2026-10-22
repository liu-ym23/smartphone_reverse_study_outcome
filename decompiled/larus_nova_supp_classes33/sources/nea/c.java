package nea;

import android.app.Application;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface c {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static volatile b b;

        static {
            a = new a();
        }

        public a() {
        }

        public final c a() {
            b r0 = b;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = b;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = b.b;     // Catch: Throwable -> L10
            b = r0;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        a = a.a;
    }

    Application getContext();
}
