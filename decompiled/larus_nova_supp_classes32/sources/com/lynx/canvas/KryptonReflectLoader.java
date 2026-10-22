package com.lynx.canvas;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonReflectLoader {
    public static final String TAG = "KryptonReflectLoader";
    private static volatile KryptonReflectLoader sInstance;
    private Class<KryptonAudioModule> mAudioModuleClass;
    private KryptonRTCModule mDefaultRTCModuleInstance;
    private KryptonVECameraModule mDefaultVECameraModuleInstance;
    private Class<KryptonEffectConfigService> mEffectConfigServiceClass;
    private Class<KryptonLiveModule> mKryptonDefaultLiveModuleClass;
    private boolean mNoAudioModule;
    private boolean mNoEffectConfig;
    private boolean mNoLiveModule;
    private boolean mNoRTCModule;
    private boolean mNoVECameraModule;
    private boolean mNoVideoPlayerService;
    private boolean mUseAurumAudioEngine;
    private KryptonVideoPlayerService mVideoPlayerServiceInstance;

    private KryptonReflectLoader() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static KryptonReflectLoader inst() {
        if (sInstance != null) goto L15;
        monitor-enter(KryptonReflectLoader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new KryptonReflectLoader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(KryptonReflectLoader.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void loadAudioModuleClass() {
        if (this.mUseAurumAudioEngine == false) goto L5;
        String r2 = "KryptonAurumAudioModule";
    L6:
        String r3 = "com.lynx.canvas.audio.".concat(r2);
        Class<KryptonAudioModule> r4 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3);     // Catch: ClassCastException -> L12 ClassNotFoundException -> L14
        if (KryptonAudioModule.class.isAssignableFrom(r4) == false) goto L10;
        this.mAudioModuleClass = r4;     // Catch: ClassCastException -> L12 ClassNotFoundException -> L14
    L16:
        return;
    L10:
        KryptonLLog.e(TAG, "reflect find " + r3 + " instance type error");     // Catch: ClassCastException -> L12 ClassNotFoundException -> L14
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, "can not cast to KryptonAudioModule: " + r3 + e.getMessage());
        return;
    L14:
        KryptonLLog.w(TAG, "find module class not found: " + r3 + ", maybe audio module is not used.");
        return;
    L5:
        r2 = "KryptonAudioModuleImpl";
        goto L6
    }

    private void loadDefaultLiveModule() {
        Class<KryptonLiveModule> r1 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.live.KryptonDefaultLiveModule");     // Catch: ClassCastException -> L8 ClassNotFoundException -> L10
        if (KryptonLiveModule.class.isAssignableFrom(r1) == false) goto L6;
        this.mKryptonDefaultLiveModuleClass = r1;     // Catch: ClassCastException -> L8 ClassNotFoundException -> L10
    L12:
        return;
    L6:
        KryptonLLog.e(TAG, "reflect find default KryptonLiveModule instance type error");     // Catch: ClassCastException -> L8 ClassNotFoundException -> L10
    L8:
        e = move-exception;
        KryptonLLog.e(TAG, "can not cast to KryptonLiveModule: com.lynx.canvas.live.KryptonDefaultLiveModule" + e.getMessage());
        return;
    L10:
        KryptonLLog.w(TAG, "find module class not found: com.lynx.canvas.live.KryptonDefaultLiveModule, maybe Krypton/Live is not used.");
    }

    private void loadDefaultRTCModule() {
        Object r1 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.rtc.KryptonDefaultRTCModule").getMethod("inst", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (KryptonRTCModule.class.isInstance(r1) == false) goto L6;
        this.mDefaultRTCModuleInstance = (KryptonRTCModule) r1;     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L16:
        return;
    L6:
        KryptonLLog.e(TAG, "reflect find module for com.lynx.canvas.rtc.KryptonDefaultRTCModule instance type error");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L14:
        KryptonLLog.w(TAG, "find module class not found: com.lynx.canvas.rtc.KryptonDefaultRTCModule, maybe Krypton/RTC is not used.");
        return;
    L10:
        e = e;
    L11:
        KryptonLLog.e(TAG, "invoke method inst in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule failed " + e.getMessage());
        return;
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, "find module inst method not found in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule" + e.getMessage());
        return;
    L8:
        e = e;
        goto L11
    }

    private void loadDefaultVECameraModule() {
        Object r1 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.vecamera.KryptonDefaultVECameraModule").getMethod("inst", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (KryptonVECameraModule.class.isInstance(r1) == false) goto L6;
        this.mDefaultVECameraModuleInstance = (KryptonVECameraModule) r1;     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L16:
        return;
    L6:
        KryptonLLog.w(TAG, "reflect find module for com.lynx.canvas.vecamera.KryptonDefaultVECameraModule instance type error");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L14:
        KryptonLLog.w(TAG, "find module class not found: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule, maybe Krypton/VECamera is not used.");
        return;
    L10:
        e = e;
    L11:
        KryptonLLog.w(TAG, "invoke method inst in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule failed " + e.getMessage());
        return;
    L12:
        e = move-exception;
        KryptonLLog.w(TAG, "find module inst method not found in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule" + e.getMessage());
        return;
    L8:
        e = e;
        goto L11
    }

    private boolean loadEffectConfigService() {
        if (loadEffectConfigService("com.bytedance.ies.bullet.lynx.element.LynxCanvasEffectHandler") == false) goto L5;
    L8:
        return true;
    L5:
        if (loadEffectConfigService("com.bytedance.lynx.hybrid.hybrid_canvas.LynxCanvasEffectHandler") == true) goto L8;
        return false;
    }

    private boolean loadVideoPlayerService() {
        if (loadVideoPlayerService("com.bytedance.ies.bullet.lynx.element.LynxCanvasTTPlayer") == false) goto L5;
    L8:
        return true;
    L5:
        if (loadVideoPlayerService("com.bytedance.lynx.hybrid.hybrid_canvas.LynxCanvasTTPlayer") == true) goto L8;
        return false;
    }

    private KryptonAudioModule newAudioModuleInstance() {
        Class<KryptonAudioModule> r0 = this.mAudioModuleClass;
        if (r0 != null) goto L19;
        return null;
    L19:
        return r0.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        e = move-exception;
        KryptonLLog.w(TAG, "create mAudioModuleClass instance error " + e.getMessage());
        return null;
    }

    private KryptonLiveModule newKryptonDefaultLiveModuleInstance() {
        Class<KryptonLiveModule> r0 = this.mKryptonDefaultLiveModuleClass;
        if (r0 != null) goto L19;
        return null;
    L19:
        return r0.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        e = move-exception;
        KryptonLLog.w(TAG, "create mKryptonDefaultLiveModuleClass instance error" + e.getMessage());
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private boolean loadEffectConfigService(String r5) {
        Class<KryptonEffectConfigService> r2 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r5);     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        if (KryptonEffectConfigService.class.isAssignableFrom(r2) == false) goto L7;
        this.mEffectConfigServiceClass = r2;     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        KryptonLLog.i(TAG, "found effect config service class: " + r5);     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        return true;
    L7:
        KryptonLLog.e(TAG, "reflect find service for LynxCanvasEffectHandler instance type error");     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        return false;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, "service class can not cast to KryptonEffectConfigService: " + r5 + e.getMessage());
        return false;
    L11:
        KryptonLLog.w(TAG, "find service class not found: " + r5);
        return false;
    }

    private boolean loadVideoPlayerService(String r8) {
        Class r3 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r8);     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        final Constructor r4 = r3.getConstructor(new Class[]{Context.class, Map.class});     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (KryptonVideoPlayer.class.isAssignableFrom(r3) == false) goto L8;
        if (r4 == null) goto L8;
        this.mVideoPlayerServiceInstance = new AnonymousClass1(this, r4);     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        KryptonLLog.i(TAG, "found video player service class: " + r8);     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        return true;
    L8:
        KryptonLLog.e(TAG, "reflect find service for LynxCanvasTTPlayer instance type error");     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L15:
        return false;
    L14:
        KryptonLLog.w(TAG, "find service class not found: " + r8);
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, "not find construct method for " + r8 + e.getMessage());
    L10:
        e = move-exception;
        KryptonLLog.e(TAG, "security exception for " + r8 + e.getMessage());
        goto L15
    }

    public <T extends KryptonService> T getHybridServiceInstance(Class<T> r4) {
        boolean r1 = true;
        if (KryptonVideoPlayerService.class.isAssignableFrom(r4) == false) goto L16;
        if (this.mVideoPlayerServiceInstance != null) goto L14;
        if (this.mNoVideoPlayerService == true) goto L14;
        loadVideoPlayerService();
        if (this.mVideoPlayerServiceInstance == null) goto L12;
        r1 = false;
    L12:
        this.mNoVideoPlayerService = r1;
    L14:
        return this.mVideoPlayerServiceInstance;
    L16:
        if (KryptonEffectConfigService.class.isAssignableFrom(r4) == true) goto L18;
    L38:
        return null;
    L18:
        if (this.mEffectConfigServiceClass == null) goto L20;
    L26:
        Class<KryptonEffectConfigService> r5 = this.mEffectConfigServiceClass;
        if (r5 == null) goto L38;
        return r5.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L34:
        e = move-exception;
        KryptonLLog.w(TAG, "create HybridCanvasEffectConfigServiceClass instance error " + e.getMessage());
        goto L38
    L20:
        if (this.mNoEffectConfig == true) goto L26;
        loadEffectConfigService();
        if (this.mEffectConfigServiceClass == null) goto L25;
        r1 = false;
    L25:
        this.mNoEffectConfig = r1;
        goto L26
    }

    public <T extends KryptonModule> T getModuleDefaultInstance(Class<T> r4, KryptonApp r5) {
        boolean r1 = true;
        if (KryptonAudioModule.class.isAssignableFrom(r4) == false) goto L16;
        this.mUseAurumAudioEngine = r5.getFeatureFlag().getUseAurumAudioEngine();
        if (this.mAudioModuleClass != null) goto L14;
        if (this.mNoAudioModule == true) goto L14;
        loadAudioModuleClass();
        if (this.mAudioModuleClass == null) goto L12;
        r1 = false;
    L12:
        this.mNoAudioModule = r1;
    L14:
        return newAudioModuleInstance();
    L16:
        if (KryptonRTCModule.class.isAssignableFrom(r4) == false) goto L29;
        if (this.mDefaultRTCModuleInstance != null) goto L27;
        if (this.mNoRTCModule == true) goto L27;
        loadDefaultRTCModule();
        if (this.mDefaultRTCModuleInstance == null) goto L25;
        r1 = false;
    L25:
        this.mNoRTCModule = r1;
    L27:
        return this.mDefaultRTCModuleInstance;
    L29:
        if (KryptonLiveModule.class.isAssignableFrom(r4) == false) goto L42;
        if (this.mKryptonDefaultLiveModuleClass != null) goto L40;
        if (this.mNoLiveModule == true) goto L40;
        loadDefaultLiveModule();
        if (this.mKryptonDefaultLiveModuleClass == null) goto L38;
        r1 = false;
    L38:
        this.mNoLiveModule = r1;
    L40:
        return newKryptonDefaultLiveModuleInstance();
    L42:
        if (KryptonVECameraModule.class.isAssignableFrom(r4) == true) goto L44;
        return null;
    L44:
        if (this.mDefaultVECameraModuleInstance != null) goto L53;
        if (this.mNoVECameraModule == true) goto L53;
        loadDefaultVECameraModule();
        if (this.mDefaultVECameraModuleInstance == null) goto L51;
        r1 = false;
    L51:
        this.mNoVECameraModule = r1;
    L53:
        return this.mDefaultVECameraModuleInstance;
    }
}
