package com.bytedance.bmmt.video;

import android.media.MediaCodecInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class MediaCodecUtils {
    static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    static final int[] DECODER_COLOR_FORMATS = null;
    static final int[] ENCODER_COLOR_FORMATS = null;
    static final int[] ENCODER_COLOR_FORMATS_FOR_HISI = null;
    static final String EXYNOS_PREFIX = "OMX.Exynos.";
    static final String HISI_PREFIX = "OMX.hisi.";
    static final String INTEL_PREFIX = "OMX.Intel.";
    static final String NVIDIA_PREFIX = "OMX.Nvidia.";
    static final String QCOM_PREFIX = "OMX.qcom.";
    static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES = null;
    static final String SPRD_PREFIX = "OMX.sprd.";
    private static final String TAG = "MediaCodecUtils";
    static final int[] TEXTURE_COLOR_FORMATS = null;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.MediaCodecUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard = null;

        static {
            int[] r0 = new int[BmmtVideoCodecStandard.values().length];
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard = r0;
            r0[BmmtVideoCodecStandard.VP8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.VP9.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[BmmtVideoCodecStandard.H264.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static int[] getTextureColorFormats() {
        return new int[]{2130708361};
    }

    static {
        SOFTWARE_IMPLEMENTATION_PREFIXES = new String[]{"OMX.google.", "OMX.SEC."};
        DECODER_COLOR_FORMATS = new int[]{19, 21, 2141391872, COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka, COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka, COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
        ENCODER_COLOR_FORMATS = new int[]{19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
        ENCODER_COLOR_FORMATS_FOR_HISI = new int[]{21, 19};
        TEXTURE_COLOR_FORMATS = getTextureColorFormats();
    }

    private MediaCodecUtils() {
    }

    public static boolean codecSupportsType(MediaCodecInfo r5, BmmtVideoCodecStandard r6) {
        String[] r7 = r5.getSupportedTypes();
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        String r3 = r7[r2];
        if (r6.mimeType().equals(r3) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static Map<String, String> getCodecProperties(BmmtVideoCodecStandard r2, boolean r3) {
        int r4 = AnonymousClass1.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecStandard[r2.ordinal()];
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        if (r4 != 3) goto L11;
        return new HashMap();
    L11:
        throw new IllegalArgumentException("Unsupported codec: " + r2);
    L13:
        return new HashMap();
    }

    public static Integer selectColorFormat(int[] r8, MediaCodecInfo.CodecCapabilities r9) {
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int r3 = r8[r2];
        int[] r4 = r9.colorFormats;
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L11;
        int r7 = r4[r6];
        if (r7 == r3) goto L9;
        r6 = r6 + 1;
        goto L5
    L9:
        return Integer.valueOf(r7);
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return null;
    }
}
