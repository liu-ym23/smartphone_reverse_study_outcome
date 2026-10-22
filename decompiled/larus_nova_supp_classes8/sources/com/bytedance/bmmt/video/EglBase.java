package com.bytedance.bmmt.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import javax.microedition.khronos.egl.EGLContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface EglBase {
    public static final int[] CONFIG_PIXEL_BUFFER = null;
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = null;
    public static final int[] CONFIG_PLAIN = null;
    public static final int[] CONFIG_RECORDABLE = null;
    public static final int[] CONFIG_RGBA = null;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT = 64;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int[] ES2_CONFIG_PIXEL_BUFFER = null;
    public static final int[] ES2_CONFIG_PIXEL_RGBA_BUFFER = null;
    public static final int[] ES2_CONFIG_PLAIN = null;
    public static final int[] ES2_CONFIG_RECORDABLE = null;
    public static final int[] ES2_CONFIG_RGBA = null;
    public static final int[] ES3_CONFIG_PIXEL_BUFFER = null;
    public static final int[] ES3_CONFIG_PIXEL_RGBA_BUFFER = null;
    public static final int[] ES3_CONFIG_PLAIN = null;
    public static final int[] ES3_CONFIG_RECORDABLE = null;
    public static final int[] ES3_CONFIG_RGBA = null;
    public static final String TAG = "EglBase";
    public static final Object lock = null;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.EglBase$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Object r0 = EglBase.lock;
        }

        public static EglBase create() {
            return create(null, getEGLConfig(EglVersion.getPreferredEglVersion(), Config.CONFIG_PLAIN));
        }

        public static void eglContextDestoryEnd() {
            EglBaseCheckerHelper.EglContextDestoryEnd();
        }

        public static void eglContextDestoryStart() {
            EglBaseCheckerHelper.EglContextDestoryStart();
        }

        public static EglBase create(Context r2) {
            return create(r2, getEGLConfig(EglVersion.getPreferredEglVersion(), Config.CONFIG_PLAIN));
        }

        public static EglBase createEgl10(int[] r2) {
            return new EglBase10(null, r2);
        }

        public static EglBase createEgl14(int[] r3) {
            return new EglBase14(EglVersion.getPreferredEglVersion(), null, r3);
        }

        public static void setEglContextChecker(EglContextChecker r0) {
            EglBaseCheckerHelper.setEglContextChecker(r0);
        }

        public static EglBase create(Context r2, int[] r3) {
            if (EglBase14.isEGL14Supported() == false) goto L9;
            if (r2 == null) goto L10;
            if ((r2 instanceof EglBase14.Context) == false) goto L9;
        L10:
            return new EglBase14(EglVersion.getPreferredEglVersion(), (EglBase14.Context) r2, r3);
        L9:
            return new EglBase10((EglBase10.Context) r2, r3);
        }

        public static EglBase createEgl10(EGLContext r3, int[] r4) {
            int[] r5 = createModifiedEGLConfigArray(r4, 12352, 64, 4);
            return new EglBase10(new EglBase10.Context(r3), r5);
        }

        public static EglBase createEgl14(android.opengl.EGLContext r4, int[] r5) {
            return new EglBase14(EglVersion.getPreferredEglVersion(), new EglBase14.Context(r4, EglVersion.getPreferredEglVersion()), r5);
        }

        public static int[] getEGLConfig(int r2, Config r3) {
            int r4 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$EglBase$Config[r3.ordinal()];
            if (r4 != 1) goto L5;
            if (r2 != 3) goto L28;
            return EglBase.ES3_CONFIG_RGBA;
        L28:
            return EglBase.ES2_CONFIG_RGBA;
        L5:
            if (r4 == 2) goto L21;
            if (r4 != 3) goto L8;
            if (r2 != 3) goto L20;
            return EglBase.ES3_CONFIG_PIXEL_RGBA_BUFFER;
        L20:
            return EglBase.ES2_CONFIG_PIXEL_RGBA_BUFFER;
        L8:
            if (r4 == 4) goto L13;
            if (r2 != 3) goto L12;
            return EglBase.ES3_CONFIG_PLAIN;
        L12:
            return EglBase.ES2_CONFIG_PLAIN;
        L13:
            if (r2 != 3) goto L16;
            return EglBase.ES3_CONFIG_RECORDABLE;
        L16:
            return EglBase.ES2_CONFIG_RECORDABLE;
        L21:
            if (r2 != 3) goto L24;
            return EglBase.ES3_CONFIG_PIXEL_BUFFER;
        L24:
            return EglBase.ES2_CONFIG_PIXEL_BUFFER;
        }

        public static int[] createModifiedEGLConfigArray(int[] r3, int r4, int r5, int r6) {
            int[] r7 = (int[]) r3.clone();
            int r0 = 0;
        L4:
            if (r0 >= r7.length) goto L13;
            if (r7[r0] != r4) goto L12;
            int r1 = r0 + 1;
            if (r1 >= r7.length) goto L12;
            if (r7[r1] != r5) goto L12;
            r7[r1] = r6;
        L12:
            r0 = r0 + 1;
        L13:
            return r7;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.EglBase$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$EglBase$Config = null;

        static {
            int[] r0 = new int[Config.values().length];
            $SwitchMap$com$bytedance$bmmt$video$EglBase$Config = r0;
            r0[Config.CONFIG_RGBA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$bmmt$video$EglBase$Config[Config.CONFIG_PIXEL_BUFFER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$bmmt$video$EglBase$Config[Config.CONFIG_PIXEL_RGBA_BUFFER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$bytedance$bmmt$video$EglBase$Config[Config.CONFIG_RECORDABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$bytedance$bmmt$video$EglBase$Config[Config.CONFIG_PLAIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Config extends Enum<Config> {
        private static final /* synthetic */ Config[] $VALUES = null;
        public static final Config CONFIG_PIXEL_BUFFER = null;
        public static final Config CONFIG_PIXEL_RGBA_BUFFER = null;
        public static final Config CONFIG_PLAIN = null;
        public static final Config CONFIG_RECORDABLE = null;
        public static final Config CONFIG_RGBA = null;

        private static /* synthetic */ Config[] $values() {
            return new Config[]{CONFIG_PLAIN, CONFIG_RGBA, CONFIG_PIXEL_BUFFER, CONFIG_PIXEL_RGBA_BUFFER, CONFIG_RECORDABLE};
        }

        static {
            CONFIG_PLAIN = new Config("CONFIG_PLAIN", 0);
            CONFIG_RGBA = new Config("CONFIG_RGBA", 1);
            CONFIG_PIXEL_BUFFER = new Config("CONFIG_PIXEL_BUFFER", 2);
            CONFIG_PIXEL_RGBA_BUFFER = new Config("CONFIG_PIXEL_RGBA_BUFFER", 3);
            CONFIG_RECORDABLE = new Config("CONFIG_RECORDABLE", 4);
            $VALUES = $values();
        }

        public static Config[] values() {
            return (Config[]) $VALUES.clone();
        }

        public static Config valueOf(String r1) {
            return (Config) r27.a.a(Config.class, r1);
        }

        private Config(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface Context {
        public static final long NO_CONTEXT = 0;

        android.opengl.EGLContext getEgl14Context();

        int getGLESVersion();

        long getNativeEglContext();
    }

    public interface EglContextChecker {
        void EglContextDestoryEnd();

        void EglContextDestoryStart();
    }

    public static class EglLock {
        public static boolean enableEglLock = true;

        public EglLock() {
        }
    }

    public static class EglVersion {
        public static final int EGL_VERSION_2 = 2;
        public static final int EGL_VERSION_3 = 3;
        private static int PREFERRED_EGL_VERSION = 2;

        public EglVersion() {
        }

        public static int getPreferredEglVersion() {
            return PREFERRED_EGL_VERSION;
        }

        public static void setPreferredEglVersion(int r0) {
            PREFERRED_EGL_VERSION = r0;
        }
    }

    void createDummyPbufferSurface();

    void createPbufferSurface(int r1, int r2);

    void createSurface(SurfaceTexture r1);

    void createSurface(Surface r1);

    void detachCurrent();

    EGLDisplay getDisplay();

    Context getEglBaseContext();

    int getGLESVersion();

    EGLSurface getSurface();

    boolean hasSurface();

    void makeCurrent();

    void release();

    void releaseSurface();

    int surfaceHeight();

    int surfaceWidth();

    void swapBuffers();

    void swapBuffers(long r1);

    static {
        lock = new Object();
        ES3_CONFIG_PLAIN = new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 64, 12344};
        int[] r0 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
        ES2_CONFIG_PLAIN = r0;
        ES3_CONFIG_RGBA = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12344};
        int[] r2 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        ES2_CONFIG_RGBA = r2;
        ES3_CONFIG_PIXEL_BUFFER = new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 64, 12339, 1, 12344};
        int[] r1 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
        ES2_CONFIG_PIXEL_BUFFER = r1;
        ES3_CONFIG_PIXEL_RGBA_BUFFER = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12339, 1, 12344};
        int[] r4 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
        ES2_CONFIG_PIXEL_RGBA_BUFFER = r4;
        ES3_CONFIG_RECORDABLE = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, EGL_RECORDABLE_ANDROID, 1, 12344};
        int[] r3 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};
        ES2_CONFIG_RECORDABLE = r3;
        CONFIG_PLAIN = r0;
        CONFIG_RGBA = r2;
        CONFIG_PIXEL_BUFFER = r1;
        CONFIG_PIXEL_RGBA_BUFFER = r4;
        CONFIG_RECORDABLE = r3;
    }
}
