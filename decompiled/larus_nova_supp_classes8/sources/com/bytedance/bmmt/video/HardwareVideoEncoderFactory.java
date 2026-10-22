package com.bytedance.bmmt.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.bmmt.base.Logging;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class HardwareVideoEncoderFactory {
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HwVideoEncoderFactory";

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.HardwareVideoEncoderFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard = null;

        static {
            int[] r0 = new int[BmmtVideoCodecStandard.values().length];
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard = r0;
            r0[BmmtVideoCodecStandard.H264.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.ByteVC1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.VP8.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.VP9.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public HardwareVideoEncoderFactory() {
    }

    public static VideoCodecDesc[] getSupportedCodecs() {
        ArrayList r0 = new ArrayList();
        int r4 = 0;
        BmmtVideoCodecStandard[] r2 = {BmmtVideoCodecStandard.ByteVC1, BmmtVideoCodecStandard.H264, BmmtVideoCodecStandard.VP8};
    L3:
        if (r4 >= 3) goto L22;
        BmmtVideoCodecStandard r3 = r2[r4];
        MediaCodecInfo r5 = findCodecForType(r3);
        if (r5 == null) goto L20;
        if (r3 != BmmtVideoCodecStandard.ByteVC1) goto L12;
        if (isSupportedCodec(r5, r3) == false) goto L12;
        r0.add(new VideoCodecDesc(r3, BmmtVideoCodecProfile.ByteVC1ProfileMain));
    L12:
        if (r3 != BmmtVideoCodecStandard.H264) goto L18;
        if (isH264HighProfileSupported(r5) == false) goto L16;
        r0.add(new VideoCodecDesc(r3, BmmtVideoCodecProfile.ProfileHigh));
    L16:
        r0.add(new VideoCodecDesc(r3, BmmtVideoCodecProfile.ProfileBaseline));
    L18:
        if (r3 != BmmtVideoCodecStandard.VP8) goto L20;
        r0.add(new VideoCodecDesc(r3, BmmtVideoCodecProfile.VP8ProfileMain));
    L20:
        r4 = r4 + 1;
        goto L3
    L22:
        return (VideoCodecDesc[]) r0.toArray(new VideoCodecDesc[r0.size()]);
    }

    public static VideoEncoder createEncoder(VideoCodecDesc r12) {
        BmmtVideoCodecStandard r0 = r12.getStandard();
        MediaCodecInfo r1 = findCodecForType(r0);
        if (r1 != null) goto L5;
        return null;
    L5:
        String r5 = r1.getName();
        String r3 = r0.mimeType();
        Integer r7 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, r1.getCapabilitiesForType(r3));
        if (r7 != null) goto L9;
        return null;
    L9:
        if (r5.contains("OMX.hisi.") == false) goto L11;
        int[] r4 = MediaCodecUtils.ENCODER_COLOR_FORMATS_FOR_HISI;
    L12:
        Integer r8 = MediaCodecUtils.selectColorFormat(r4, r1.getCapabilitiesForType(r3));
        if (r8 != null) goto L16;
        return null;
    L16:
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), r5, r12, r7, r8, getKeyFrameIntervalSec(r0), getForcedKeyFrameIntervalMs(r0, r5), r1.getCapabilitiesForType(r3));
    L11:
        r4 = MediaCodecUtils.ENCODER_COLOR_FORMATS;
        goto L12
    }

    private static MediaCodecInfo findCodecForType(BmmtVideoCodecStandard r5) {
        int r1 = MediaCodecList.getCodecCount();     // Catch: Exception -> L22
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L21;
        MediaCodecInfo r3 = MediaCodecList.getCodecInfoAt(r2);     // Catch: IllegalArgumentException -> L8
    L9:
        if (r3 == null) goto L20;
        if (r3.isEncoder() == false) goto L20;
        if (isSoftwareOnly(r3) == true) goto L20;
        if (isInBlackList(r3) == true) goto L20;
        if (isSupportedCodec(r3, r5) == false) goto L20;
        return r3;
    L20:
        r2 = r2 + 1;
    L8:
        r3 = null;
    L21:
        return null;
    }

    private static int getKeyFrameIntervalSec(BmmtVideoCodecStandard r3) {
        int r0 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[r3.ordinal()];
        if (r0 != 1) goto L5;
    L15:
        return 720;
    L5:
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L9;
        return 100;
    L9:
        if (r0 != 4) goto L12;
        return 100;
    L12:
        throw new IllegalArgumentException("Unsupported VideoCodecType " + r3);
    }

    private static boolean isH264HighProfileSupported(MediaCodecInfo r3) {
        String r4 = DeviceInfoAndroid.GetDeviceModel();
        String r0 = DeviceInfoAndroid.GetDeviceBrand();
        if (DeviceInfoAndroid.GetCpuModel().contains("Amlogic") == false) goto L5;
        return false;
    L5:
        if (r4.equalsIgnoreCase("T730") == false) goto L10;
        if (r0.equalsIgnoreCase("VHD") == false) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT <= 23) goto L14;
        return true;
    L14:
        return false;
    }

    private static boolean isHardwareSupportedInCurrentSdkByteVC1(MediaCodecInfo r2) {
        String r3 = r2.getName();
        if (r3.startsWith("OMX.qcom.") == false) goto L5;
        return true;
    L5:
        r3.startsWith("OMX.Exynos.");
        return true;
    }

    private static boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo r2) {
        String r3 = r2.getName();
        if (r3.startsWith("OMX.qcom.") == false) goto L6;
        return true;
    L6:
        if (r3.startsWith("OMX.sprd.") == false) goto L8;
        return true;
    L8:
        r3.startsWith("OMX.Exynos.");
        return true;
    }

    private static boolean isHardwareSupportedInCurrentSdkVP8(MediaCodecInfo r2) {
        String r3 = r2.getName();
        if (r3.startsWith("OMX.qcom.") == false) goto L6;
        return true;
    L6:
        if (r3.startsWith("OMX.Exynos.") == true) goto L8;
        r3.startsWith("OMX.Intel.");
        return true;
    L8:
        if (Build.VERSION.SDK_INT >= 23) goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean isInBlackList(MediaCodecInfo r1) {
        String r2 = r1.getName();
        if (r2.startsWith("OMX.Nvidia") == false) goto L5;
    L10:
        return true;
    L5:
        if (r2.startsWith("OMX.Intel") == true) goto L10;
        if (r2.startsWith("OMX.TI.DUCATI1.VIDEO.H264E") == true) goto L10;
        return false;
    }

    private static boolean isSoftwareOnly(MediaCodecInfo r3) {
    L31:
        e = move-exception;
        Logging.e(TAG, "check encoder softonly error.", e);
        return false;
    L4:
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        String r4 = r3.getName();     // Catch: Exception -> L31
        if (r4 != null) goto L10;
        return false;
    L10:
        String r5 = r4.toLowerCase();     // Catch: Exception -> L31
        if (r5.startsWith("arc.") == false) goto L14;
        return false;
    L14:
        if (r5.startsWith("omx.google.") == false) goto L16;
    L29:
        return true;
    L16:
        if (r5.startsWith("omx.ffmpeg.") == true) goto L29;
        if (r5.startsWith("omx.sec.") == false) goto L22;
        if (r5.contains(".sw.") == true) goto L29;
    L22:
        if (r5.startsWith("c2.android.") == true) goto L29;
        if (r5.startsWith("c2.google.") == true) goto L29;
        if (r5.startsWith("omx.") == false) goto L28;
        return false;
    L28:
        if (r5.startsWith("c2.") == false) goto L29;
        return false;
    L6:
        return r3.isSoftwareOnly();
    }

    private static int getForcedKeyFrameIntervalMs(BmmtVideoCodecStandard r1, String r2) {
        if (r1 == BmmtVideoCodecStandard.VP8) goto L5;
        return 0;
    L5:
        if (r2.startsWith("OMX.qcom.") == false) goto L19;
        int r3 = Build.VERSION.SDK_INT;
        if (r3 != 21) goto L9;
    L16:
        return 15000;
    L9:
        if (r3 == 22) goto L16;
        if (r3 != 23) goto L15;
        return QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS;
    L15:
        if (r3 > 23) goto L16;
        return 0;
    L19:
        return 0;
    }

    private static boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo r1, BmmtVideoCodecStandard r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[r2.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L13;
        if (r3 == 3) goto L11;
        return false;
    L11:
        return isHardwareSupportedInCurrentSdkVP8(r1);
    L13:
        return isHardwareSupportedInCurrentSdkByteVC1(r1);
    L15:
        return isHardwareSupportedInCurrentSdkH264(r1);
    }

    private static boolean isSupportedCodec(MediaCodecInfo r3, BmmtVideoCodecStandard r4) {
        if (MediaCodecUtils.codecSupportsType(r3, r4) == true) goto L11;
        return false;
    L11:
        MediaCodecInfo.CodecCapabilities r0 = r3.getCapabilitiesForType(r4.mimeType());     // Catch: IllegalArgumentException -> L10
        if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, r0) != null) goto L9;
        return false;
    L9:
        return isHardwareSupportedInCurrentSdk(r3, r4);
    L10:
        return false;
    }

    public static boolean isBitrateModeSupported(MediaCodecInfo r1, BmmtVideoCodecStandard r2, int r3) {
        MediaCodecInfo.CodecCapabilities r4 = r1.getCapabilitiesForType(r2.mimeType());
        if (r4 != null) goto L6;
        Logging.e(TAG, "get capability return null.");
        return false;
    L6:
        MediaCodecInfo.EncoderCapabilities r5 = r4.getEncoderCapabilities();
        if (r5 != null) goto L11;
        Logging.e(TAG, "get EncoderCapabilities return null.");
        return false;
    L11:
        return r5.isBitrateModeSupported(r3);
    }
}
