package com.bytedance.android.live.effect.api;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.SaaSLiveResourceStrategy;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.ILiveWrappedVESdkService;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0002J\u0006\u0010#\u001a\u00020!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/effect/api/VESDKUtils;", "", "()V", "ALGORITHM_RES_CACHE_DIR", "", "getALGORITHM_RES_CACHE_DIR", "()Ljava/lang/String;", "EFFECT_CACHE_DIR", "getEFFECT_CACHE_DIR", "FRAME_ZIP_FILE_NAME", "ORI_PIC_DIR_SUFFIX", "getORI_PIC_DIR_SUFFIX", "RES_CACHE_DIR", "getRES_CACHE_DIR", "RES_DOWNLOAD_MODEL_DIR", "getRES_DOWNLOAD_MODEL_DIR", "SDCARD_CACHE_DIR", "getSDCARD_CACHE_DIR", "SDCARD_CACHE_NAME", "getSDCARD_CACHE_NAME", "SDCARD_EXTERNAL_PATH", "getSDCARD_EXTERNAL_PATH", "TAG", "VIDEO_CACHE_DIR", "getVIDEO_CACHE_DIR", "VIDEO_CACHE_TMP_DIR", "getVIDEO_CACHE_TMP_DIR", "is64Bit", "", "loadVESDK", "activity", "Landroid/content/Context;", "reloadSo", "", "context", "vesdkSetEffectResourceFinder", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class VESDKUtils {
    private static final String ALGORITHM_RES_CACHE_DIR = null;
    private static final String EFFECT_CACHE_DIR = null;
    public static final String FRAME_ZIP_FILE_NAME = "video_frame.zip";
    public static final VESDKUtils INSTANCE = null;
    private static final String ORI_PIC_DIR_SUFFIX = null;
    private static final String RES_CACHE_DIR = null;
    private static final String RES_DOWNLOAD_MODEL_DIR = null;
    private static final String SDCARD_CACHE_DIR = null;
    private static final String SDCARD_CACHE_NAME = null;
    private static final String TAG = "VideoUtils";
    private static final String VIDEO_CACHE_DIR = null;
    private static final String VIDEO_CACHE_TMP_DIR = null;

    private VESDKUtils() {
    }

    static {
        VESDKUtils r0 = new VESDKUtils();
        INSTANCE = r0;
        SDCARD_CACHE_NAME = "/ttlivesdk/";
        String r1 = r0.getSDCARD_EXTERNAL_PATH() + "/ttlivesdk/";
        SDCARD_CACHE_DIR = r1;
        String r2 = r1 + ".res/";
        RES_CACHE_DIR = r2;
        RES_DOWNLOAD_MODEL_DIR = r1 + ".download_model/";
        VIDEO_CACHE_DIR = r1 + ".ssvideo/";
        VIDEO_CACHE_TMP_DIR = r1 + ".ssvideo_cache/";
        ALGORITHM_RES_CACHE_DIR = r1 + ".algo_res/";
        EFFECT_CACHE_DIR = r2 + NewBroadcastMonitor.STAGE.EFFECT;
        ORI_PIC_DIR_SUFFIX = "/ttlivesdk/.pic";
    }

    private final boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return Process.is64Bit();
    }

    public final void vesdkSetEffectResourceFinder() {
        int r0 = xn0.b.a;
        monitor-enter(xn0.b.class);
        HashMap r1 = new HashMap();     // Catch: Throwable -> L12
        int r2 = xn0.a.a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r1, "env");     // Catch: Throwable -> L12
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L12
        ILiveWrappedEffectSDKService r3 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L12
        if (r3 == null) goto L7;
        r3.multiMediaEnv_initialize((String) r1.get("bundle_type"), (String) r1.get("host_build_type"));     // Catch: Throwable -> L12
    L7:
        monitor-exit(xn0.b.class);
        xn0.b.a();
        ILiveWrappedVESdkService.Companion.getClass();
        ILiveWrappedVESdkService r4 = ILiveWrappedVESdkService.a.a();
        if (r4 == null) goto L17;
        r4.getVESDK();
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final String getSDCARD_EXTERNAL_PATH() {
        String r0 = jc1.a.b().getFilesDir().getPath();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getALGORITHM_RES_CACHE_DIR() {
        return ALGORITHM_RES_CACHE_DIR;
    }

    public final String getEFFECT_CACHE_DIR() {
        return EFFECT_CACHE_DIR;
    }

    public final String getORI_PIC_DIR_SUFFIX() {
        return ORI_PIC_DIR_SUFFIX;
    }

    public final String getRES_CACHE_DIR() {
        return RES_CACHE_DIR;
    }

    public final String getRES_DOWNLOAD_MODEL_DIR() {
        return RES_DOWNLOAD_MODEL_DIR;
    }

    public final String getSDCARD_CACHE_DIR() {
        return SDCARD_CACHE_DIR;
    }

    public final String getSDCARD_CACHE_NAME() {
        return SDCARD_CACHE_NAME;
    }

    public final String getVIDEO_CACHE_DIR() {
        return VIDEO_CACHE_DIR;
    }

    public final String getVIDEO_CACHE_TMP_DIR() {
        return VIDEO_CACHE_TMP_DIR;
    }

    @JvmStatic
    public static final synchronized boolean loadVESDK(Context r4) {
        monitor-enter(VESDKUtils.class);
        Intrinsics.checkNotNullParameter(r4, "activity");     // Catch: Throwable -> L41
        VESDKUtils r1 = INSTANCE;     // Catch: UnsatisfiedLinkError -> L7 Throwable -> L41
        r1.reloadSo(r4);     // Catch: UnsatisfiedLinkError -> L7 Throwable -> L41
        r1.vesdkSetEffectResourceFinder();     // Catch: UnsatisfiedLinkError -> L7 Throwable -> L41
    L10:
        ILiveWrappedVESdkService.Companion.getClass();     // Catch: Throwable -> L41
        ILiveWrappedVESdkService r5 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r5 == null) goto L13;
        r5.getVESDK();     // Catch: Throwable -> L41
    L13:
        ILiveWrappedVESdkService r6 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r6 == null) goto L16;
        r6.getVEConfigCenter();     // Catch: Throwable -> L41
    L16:
        ILiveWrappedVESdkService r7 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r7 == null) goto L19;
        r7.getVESDK();     // Catch: Throwable -> L41
    L19:
        ILiveWrappedVESdkService r8 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r8 == null) goto L22;
        r8.getVESDK();     // Catch: Throwable -> L41
    L22:
        ILiveWrappedVESdkService r9 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r9 == null) goto L26;
        r9.getVESDK();     // Catch: Throwable -> L41
    L26:
        if (INSTANCE.is64Bit() == false) goto L33;
        ILiveWrappedVESdkService r11 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r11 == null) goto L30;
        r11.getVESDK();     // Catch: Throwable -> L41
    L30:
        ILiveWrappedVESdkService r12 = ILiveWrappedVESdkService.a.a();     // Catch: Throwable -> L41
        if (r12 == null) goto L33;
        r12.getVESDK();     // Catch: Throwable -> L41
    L33:
        monitor-exit(VESDKUtils.class);
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L41
        Logger.w(TAG, "initDownloadableModel UnsatisfiedLinkError", e);     // Catch: Throwable -> L41
        VESDKUtils r2 = INSTANCE;     // Catch: Throwable -> L41
        r2.reloadSo(r4);     // Catch: Throwable -> L41
        r2.vesdkSetEffectResourceFinder();     // Catch: UnsatisfiedLinkError -> L36 Throwable -> L41
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L41
        Logger.w(TAG, "reloadSo UnsatisfiedLinkError", e);     // Catch: Throwable -> L41
        return false;
    L41:
        th = move-exception;
        throw th;
    }

    private final void reloadSo(Context r3) {
        String[] r0 = (String[]) ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(SaaSLiveResourceStrategy.getLoadHostLibraryList(), "npth_unw"), "vehook"), "bmf_hydra_lite"), "ttvesdk");
        SaaSLiveResourceStrategy.loadHostLibraryByList(r3, VESDKUtils.class.getClassLoader(), r0);
    }
}
