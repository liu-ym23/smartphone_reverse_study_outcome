package d19;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final Context a;
    public final GLSurfaceView b;
    public final f c;

    public static final class a {
    }

    /* JADX INFO: renamed from: d19.b$b, reason: collision with other inner class name */
    public static final class C0123b implements GLSurfaceView.EGLConfigChooser {
        public final int a;

        /* JADX INFO: renamed from: d19.b$b$a */
        public static final class a {
        }

        static {
        }

        public C0123b(int r1) {
            this.a = r1;
        }

        public static final List<int[]> a(int r25) {
            return CollectionsKt.listOf(new int[][]{new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, r25, 12344}, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, r25, 12344}, new int[]{12324, 5, 12323, 6, 12322, 5, 12321, 8, 12325, 0, 12326, 0, 12352, r25, 12344}, new int[]{12321, 8, 12352, r25, 12344}});
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public final EGLConfig chooseConfig(EGL10 r110, EGLDisplay r20) {
            Intrinsics.checkNotNullParameter(r110, "egl");
            Intrinsics.checkNotNullParameter(r20, "display");
            if (this.a < 3) goto L5;
            int r11 = 64;
        L6:
            ArrayList r0 = new ArrayList();
            r0.addAll(a(r11));
            if (this.a < 3) goto L9;
            r0.addAll(a(4));
        L9:
            int[] r13 = new int[1];
            Iterator r14 = r0.iterator();
            int r7 = 0;
        L11:
            if (r14.hasNext() == false) goto L26;
            int r16 = r7 + 1;
            int[] r1 = (int[]) r14.next();
            int r10 = r7;
        L23:
            e = move-exception;
            FLogger.a.e("EdgeEffectEGLManager.SafeEGLConfigChooser", "Exception in eglChooseConfig for fallback level " + r10, e);
        L25:
            r7 = r16;
            goto L11
        L14:
            if (r110.eglChooseConfig(r20, r1, null, 0, r13) == false) goto L21;
            int r6 = r13[0];     // Catch: Exception -> L23
            if (r6 <= 0) goto L21;
            EGLConfig[] r8 = new EGLConfig[r6];     // Catch: Exception -> L23
            if (r110.eglChooseConfig(r20, r1, r8, r6, r13) == false) goto L21;
            FLogger.a.i("EdgeEffectEGLManager.SafeEGLConfigChooser", "eglChooseConfig success with fallback level " + r10);     // Catch: Exception -> L23
            return r8[0];
        L21:
            FLogger.a.w("EdgeEffectEGLManager.SafeEGLConfigChooser", "eglChooseConfig failed for fallback level " + r10);     // Catch: Exception -> L23
            goto L25
        L26:
            FLogger.a.e("EdgeEffectEGLManager.SafeEGLConfigChooser", "All custom fallback specs failed. Using simple default config.");
            ArrayList r2 = new ArrayList();
            r2.add(new int[]{12352, r11, 12344});
            if (this.a < 3) goto L29;
            r2.add(new int[]{12352, 4, 12344});
        L29:
            Iterator r3 = r2.iterator();
        L31:
            if (r3.hasNext() == false) goto L40;
            int[] r12 = (int[]) r3.next();
            if (r110.eglChooseConfig(r20, r12, null, 0, r13) == false) goto L31;
            int r9 = r13[0];
            if (r9 <= 0) goto L31;
            EGLConfig[] r15 = new EGLConfig[r9];
            if (r110.eglChooseConfig(r20, r12, r15, r9, r13) == false) goto L31;
            FLogger.a.i("EdgeEffectEGLManager.SafeEGLConfigChooser", "eglChooseConfig success with default spec");
            return r15[0];
        L40:
            FLogger r4 = FLogger.a;
            r4.w("EdgeEffectEGLManager.SafeEGLConfigChooser", "All specs failed. Trying to get any available EGL configuration.");
            int[] r5 = new int[1];
            if (r110.eglGetConfigs(r20, null, 0, r5) == false) goto L48;
            int r17 = r5[0];
            if (r17 <= 0) goto L48;
            EGLConfig[] r18 = new EGLConfig[r17];
            if (r110.eglGetConfigs(r20, r18, r17, r5) == false) goto L48;
            r4.w("EdgeEffectEGLManager.SafeEGLConfigChooser", "Successfully fallback to the first available EGL configuration");
            return r18[0];
        L48:
            r4.e("EdgeEffectEGLManager.SafeEGLConfigChooser", "Fatal: No EGL configuration available on this device.");
            return null;
        L5:
            r11 = 4;
            goto L6
        }
    }

    public static final class c implements GLSurfaceView.EGLContextFactory {
        public final int a;
        public final Function1<Integer, Unit> b;

        public static final class a {
        }

        static {
        }

        public c(int r2, d19.a r3) {
            Intrinsics.checkNotNullParameter(r3, "onVersionResolved");
            this.a = r2;
            this.b = r3;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public final EGLContext createContext(EGL10 r6, EGLDisplay r7, EGLConfig r8) {
            Intrinsics.checkNotNullParameter(r6, "egl");
            Intrinsics.checkNotNullParameter(r7, "display");
            Intrinsics.checkNotNullParameter(r8, "eglConfig");
            if (this.a < 3) goto L13;
            EGLContext r4 = EGL10.EGL_NO_CONTEXT;
            EGLContext r0 = r6.eglCreateContext(r7, r8, r4, new int[]{12440, 3, 12344});
            if (r0 != null) goto L7;
        L12:
            FLogger.a.w("EdgeEffectEGLManager.SafeEGLContextFactory", "Failed to create GLES 3.0 context, falling back to 2.0");
            goto L13
        L7:
            if (r0 == EGL10.EGL_NO_CONTEXT) goto L12;
            if (r6.eglGetError() != 12288) goto L12;
            FLogger.a.i("EdgeEffectEGLManager.SafeEGLContextFactory", "Successfully created GLES 3.0 context");
            this.b.invoke(3);
            return r0;
        L13:
            EGLContext r3 = EGL10.EGL_NO_CONTEXT;
            EGLContext r9 = r6.eglCreateContext(r7, r8, r3, new int[]{12440, 2, 12344});
            if (r9 != null) goto L16;
        L21:
            FLogger.a.e("EdgeEffectEGLManager.SafeEGLContextFactory", "Failed to create any GLES context");
            return null;
        L16:
            if (r9 == EGL10.EGL_NO_CONTEXT) goto L21;
            if (r6.eglGetError() != 12288) goto L21;
            FLogger.a.i("EdgeEffectEGLManager.SafeEGLContextFactory", "Successfully created GLES 2.0 context");
            this.b.invoke(2);
            return r9;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public final void destroyContext(EGL10 r4, EGLDisplay r5, EGLContext r6) {
            Intrinsics.checkNotNullParameter(r4, "egl");
            Intrinsics.checkNotNullParameter(r5, "display");
            Intrinsics.checkNotNullParameter(r6, "context");
            if (r4.eglDestroyContext(r5, r6) == true) goto L6;
            FLogger r0 = FLogger.a;
            r0.e("EdgeEffectEGLManager.SafeEGLContextFactory", "display:" + r5 + " context: " + r6);
            StringBuilder r7 = new StringBuilder("eglDestroyContext failed: ");
            r7.append(r4.eglGetError());
            r0.e("EdgeEffectEGLManager.SafeEGLContextFactory", r7.toString());
            return;
        }
    }

    static {
    }

    public b(Context r2, GLSurfaceView r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "renderer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
