package q0;

import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0138a f10099a;

    /* JADX INFO: renamed from: q0.a$a, reason: collision with other inner class name */
    public static class C0138a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f10100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f10101b;

        public C0138a(EditText r8) {
            this.f10100a = r8;
            g r10 = new g(r8);
            this.f10101b = r10;
            r8.addTextChangedListener(r10);
            if (q0.b.f10103b != null) goto L14;
            Object r11 = q0.b.f10102a;
            monitor-enter(r11);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (q0.b.f10103b != null) goto L9;
            q0.b.f10103b = new q0.b();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r11);     // Catch: Throwable -> L11
        L14:
            r8.setEditableFactory(q0.b.f10103b);
        }
    }

    public static class b {
    }

    public a(EditText r8) {
        t2.b.n(r8, "editText cannot be null");
        this.f10099a = new C0138a(r8);
    }
}
