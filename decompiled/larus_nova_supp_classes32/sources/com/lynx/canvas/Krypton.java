package com.lynx.canvas;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class Krypton {
    public static int FONT_STYLE_ITALIC = 1;
    public static int FONT_STYLE_NORMAL = 0;
    public static int FONT_WEIGHT_BOLD = 700;
    public static int FONT_WEIGHT_NORMAL = 400;
    private static final String TAG = "Krypton";
    private static volatile Krypton sInstance;
    private Context context;
    private volatile boolean hasInit;
    private ConcurrentHashMap<String, IKryptonJavaLogger> mLoggerDictionary;
    private IKryptonNativeLibraryLoader mNativeLibraryLoader;

    public interface IKryptonJavaLogger {
        void d(String r1, String r2);

        void e(String r1, String r2);

        void i(String r1, String r2);

        void v(String r1, String r2);

        void w(String r1, String r2);
    }

    public interface IKryptonNativeLibraryLoader {
        void loadLibrary(String r1) throws UnsatisfiedLinkError;
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public native void nativeRegisterLogger(String r1, long r2);

    public static Krypton inst() {
        if (sInstance != null) goto L15;
        monitor-enter(Krypton.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new Krypton();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Krypton.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private Krypton() {
        this.hasInit = false;
        this.mLoggerDictionary = new ConcurrentHashMap();
    }

    public Context getContext() {
        return this.context;
    }

    public ConcurrentHashMap<String, IKryptonJavaLogger> getLoggers() {
        return this.mLoggerDictionary;
    }

    public IKryptonNativeLibraryLoader getNativeLibraryLoader() {
        return this.mNativeLibraryLoader;
    }

    public boolean hasInitialized() {
        return this.hasInit;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_canvas_Krypton_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private static boolean isES3Supported(Context r2) {
        if (((ActivityManager) r2.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion < 196608) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public void registerFontLazyProvider(KryptonFontLazyProvider r2) {
        CanvasFontRegistry.GetInstance().registerFontLazyProvider(r2);
    }

    public void setNativeLibraryLoader(IKryptonNativeLibraryLoader r1) {
        this.mNativeLibraryLoader = r1;
    }

    private static boolean triggerLoadLibrary(String r1, boolean r2) {
        return inst().loadLibrary(r1, r2);
    }

    public synchronized void init(IKryptonNativeLibraryLoader r2, Context r3) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (isES3Supported(r3) == true) goto L9;
        KryptonLLog.e(TAG, "Krypton not support with device do not support ES3");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L9:
        if (this.hasInit == false) goto L13;
        KryptonLLog.w(TAG, "Krypton has already been initialized");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L13:
        this.mNativeLibraryLoader = r2;     // Catch: Throwable -> L24
        this.context = r3;     // Catch: Throwable -> L24
        if (loadLibrary("lynxbase", true) == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        if (loadLibrary("krypton", true) == true) goto L21;
        monitor-exit(this);
        return;
    L21:
        KryptonLLog.i(TAG, "Native Krypton Library load success ");     // Catch: Throwable -> L24
        this.hasInit = true;     // Catch: Throwable -> L24
        monitor-exit(this);
    }

    public boolean loadLibrary(String r7, boolean r8) {
        IKryptonNativeLibraryLoader r4 = this.mNativeLibraryLoader;     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        if (r4 == null) goto L6;
        r4.loadLibrary(r7);     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        KryptonLLog.i(TAG, "Native library load " + r7 + " success with native library loader");     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        return true;
    L6:
        INVOKESTATIC_com_lynx_canvas_Krypton_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r7);     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        KryptonLLog.i(TAG, "Native library load " + r7 + " success with System.loadLibrary");     // Catch: RuntimeException -> L9 UnsatisfiedLinkError -> L16
        return true;
    L9:
        e = move-exception;
        if (r8 == true) goto L12;
    L15:
        return false;
    L12:
        if (this.mNativeLibraryLoader != null) goto L14;
        KryptonLLog.e(TAG, "Native library load " + r7 + "from system with runtime exception " + e.getMessage());
        goto L15
    L14:
        KryptonLLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with runtime exception " + e.getMessage());
    L16:
        e = move-exception;
        if (r8 == true) goto L19;
    L22:
        return false;
    L19:
        if (this.mNativeLibraryLoader != null) goto L21;
        KryptonLLog.e(TAG, "Native library load " + r7 + "from system with error message " + e.getMessage());
        goto L22
    L21:
        KryptonLLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with error message " + e.getMessage());
        goto L22
    }

    public void registerLogger(String r2, IKryptonJavaLogger r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L7;
        this.mLoggerDictionary.remove(r2);
        return;
    L7:
        this.mLoggerDictionary.put(r2, r3);
    }

    public boolean registerFont(String r2, String r3, int r4, int r5) {
        return CanvasFontRegistry.GetInstance().registerFont(r2, r3, r4, r5);
    }
}
