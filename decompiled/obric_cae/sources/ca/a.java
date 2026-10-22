package ca;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f3425b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3426a;

    /* JADX INFO: renamed from: ca.a$a, reason: collision with other inner class name */
    public class C0042a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f3427a;

        public C0042a(a r8) {
            this.f3427a = r8;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r8) {
            if (r8.what == 0) goto L6;
            return false;
        L6:
            a r10 = this.f3427a;
            b r11 = (b) r8.obj;
            Object r12 = r10.f3426a;
            monitor-enter(r12);
            if (r11 == null) goto L13;
            if (r11 == null) goto L13;
            monitor-exit(r12);     // Catch: Throwable -> L17
            return true;
        L13:
            r11.getClass();     // Catch: Throwable -> L17
            throw null;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }
    }

    public static class b {
    }

    public a() {
        this.f3426a = new Object();
        new Handler(Looper.getMainLooper(), new C0042a(this));
    }

    public static a a() {
        if (f3425b != null) goto L6;
        f3425b = new a();
    L6:
        return f3425b;
    }
}
