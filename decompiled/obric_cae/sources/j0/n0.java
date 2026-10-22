package j0;

import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8429a;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsController f8430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Window f8431b;

        public a(Window r8) {
            this(r8.getInsetsController());
            this.f8431b = r8;
        }

        public a(WindowInsetsController r8) {
            new n.h();
            this.f8430a = r8;
        }
    }

    public static class b {
    }

    public n0(Window r8) {
        this.f8429a = new a(r8);
    }

    @Deprecated
    public n0(WindowInsetsController r8) {
        this.f8429a = new a(r8);
    }
}
