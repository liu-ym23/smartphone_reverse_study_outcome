package s2;

import android.util.Log;
import c2.k;
import defpackage.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c3.a.C0038a f12019b;

    /* JADX INFO: renamed from: s2.a$a, reason: collision with other inner class name */
    public static final class C0150a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12020a = null;

        static {
            f12020a = new a();
        }
    }

    public static void b(String r8) {
        if (k.d() == false) goto L6;
        Log.d("LaunchAnalysis", r8);
        return;
    }

    public final synchronized c a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f12018a != null) goto L6;
        this.f12018a = new c();     // Catch: Throwable -> L9
    L6:
        c r8 = this.f12018a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r8;
    }
}
