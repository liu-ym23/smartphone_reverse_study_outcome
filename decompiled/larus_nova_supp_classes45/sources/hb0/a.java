package hb0;

import android.opengl.EGL14;
import android.opengl.EGLContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a {
    public static final C0235a b = null;
    public EGLContext a;

    /* JADX INFO: renamed from: hb0.a$a, reason: collision with other inner class name */
    public static class C0235a extends a {
        public C0235a() {
            this.a = EGL14.EGL_NO_CONTEXT;
        }
    }

    public a() {
    }

    static {
        b = new C0235a();
    }
}
