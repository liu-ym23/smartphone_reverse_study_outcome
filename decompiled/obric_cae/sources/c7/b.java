package c7;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3370a = null;

    public static class a implements b {
        @Override // c7.b
        public final boolean a(d r8, URI r10) {
            return true;
        }
    }

    /* JADX INFO: renamed from: c7.b$b, reason: collision with other inner class name */
    public static class C0041b implements b {
        @Override // c7.b
        public final boolean a(d r8, URI r10) {
            return d.b(r8.f3378m, r10.getHost());
        }
    }

    static {
        f3370a = new a();
        new C0041b();
    }

    boolean a(d r8, URI r10);
}
