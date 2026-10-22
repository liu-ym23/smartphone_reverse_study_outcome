package com.lynx.canvas;

import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PluginLoaderWrapper {
    private static final String TAG = "PluginLoaderWrapper";

    public PluginLoaderWrapper() {
    }

    private static native void nativeOnFinishCallback(long r0, String r2, boolean r3, String r4, String r5);

    public static boolean loadModuleService(KryptonApp r3, String r4) {
        if (KryptonAudioModule.moduleName().equals(r4) == false) goto L10;
        KryptonAudioModule r5 = (KryptonAudioModule) r3.getModule(KryptonAudioModule.class);
        if (r5 != null) goto L7;
        KryptonLLog.w(TAG, "no audio module found for " + r4);
        return false;
    L7:
        return r5.loadAudioModule();
    L10:
        if (KryptonRTCModule.moduleName().equals(r4) == false) goto L17;
        KryptonRTCModule r6 = (KryptonRTCModule) r3.getModule(KryptonRTCModule.class);
        if (r6 != null) goto L14;
        KryptonLLog.w(TAG, "no rtc module found for " + r4);
        return false;
    L14:
        return r6.load(null);
    L17:
        if (KryptonVECameraModule.moduleName().equals(r4) == false) goto L23;
        KryptonVECameraModule r7 = (KryptonVECameraModule) r3.getModule(KryptonVECameraModule.class);
        if (r7 != null) goto L21;
        KryptonLLog.w(TAG, "no ve-camera module found for " + r4);
        return false;
    L21:
        return r7.load(null);
    L23:
        KryptonLLog.w(TAG, "no module for " + r4);
        return false;
    }

    public static boolean preloadPluginSync(KryptonApp r3, String r4) {
        KryptonPluginLoaderService r5 = (KryptonPluginLoaderService) r3.getService(KryptonPluginLoaderService.class);
        if (r5 != null) goto L7;
        KryptonLLog.e(TAG, "plugin loader service not exits, default return true on sync load");
        return true;
    L7:
        if (r5.loadPluginSync(r4) == false) goto L10;
        KryptonLLog.i(TAG, "plugin " + r4 + " load sync success ");
        return true;
    L10:
        return false;
    }

    public static /* synthetic */ boolean access$000(KryptonApp r0, String r1, String r2) {
        return postLoadPluginSuccess(r0, r1, r2);
    }

    private static boolean postLoadPluginSuccess(KryptonApp r2, String r3, String r4) {
        if (KryptonRTCModule.moduleName().equals(r3) == false) goto L9;
        KryptonRTCModule r5 = (KryptonRTCModule) r2.getModule(KryptonRTCModule.class);
        if (r5 != null) goto L7;
        return true;
    L7:
        return r5.load(r4);
    L9:
        if (KryptonAudioModule.moduleName().equals(r3) == false) goto L20;
        KryptonAudioModule r6 = (KryptonAudioModule) r2.getModule(KryptonAudioModule.class);
        if (r6 != null) goto L13;
        return true;
    L13:
        if (r6.loadAudioModule() == true) goto L15;
    L17:
        return false;
    L15:
        if (r6.loadAudioEffectModule(r4) == false) goto L17;
        return true;
    L20:
        return true;
    }

    public static void preloadPlugin(KryptonApp r8, final long r9, final String r11) {
        final KryptonPluginLoaderService r0 = (KryptonPluginLoaderService) r8.getService(KryptonPluginLoaderService.class);
        if (r0 != null) goto L10;
        boolean r5 = postLoadPluginSuccess(r8, r11, null);
        if (r5 == false) goto L7;
        String r10 = "plugin loader service not exits, default return success";
    L8:
        String r6 = r10;
        KryptonLLog.w(TAG, r6);
        nativeOnFinishCallback(r9, r11, r5, r6, NameKeys.UnloadStrategy_No_Strategy);
        return;
    L7:
        r10 = "post load plugin failed";
        goto L8
    L10:
        KryptonLLog.i(TAG, "loading plugin " + r11 + " async ...");
        final WeakReference r7 = new WeakReference(r8);
        r0.loadPluginAsync(r11, new AnonymousClass1(r9, r11, r7, r0));
    }

    public static /* synthetic */ void access$100(long r0, String r2, boolean r3, String r4, String r5) {
        nativeOnFinishCallback(r0, r2, r3, r4, r5);
    }
}
