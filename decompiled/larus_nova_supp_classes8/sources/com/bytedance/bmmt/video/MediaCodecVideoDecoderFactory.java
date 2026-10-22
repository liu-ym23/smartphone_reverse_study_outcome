package com.bytedance.bmmt.video;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.bytedance.bmmt.base.Logging;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class MediaCodecVideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";
    private boolean enableAgfxSurfaceTextureHelper;

    public static VideoCodecDesc[] getSupportedCodecs() {
        ArrayList r0 = new ArrayList();
        BmmtVideoCodecStandard r1 = BmmtVideoCodecStandard.H264;
        MediaCodecInfo r2 = findCodecForType(r1);
        if (r2 == null) goto L9;
        if (isH264HighProfileSupported(r2, r1) == false) goto L7;
        r0.add(new VideoCodecDesc(r1, BmmtVideoCodecProfile.ProfileHigh));
    L7:
        r0.add(new VideoCodecDesc(r1, BmmtVideoCodecProfile.ProfileBaseline));
    L9:
        return (VideoCodecDesc[]) r0.toArray(new VideoCodecDesc[r0.size()]);
    }

    public MediaCodecVideoDecoderFactory() {
        this.enableAgfxSurfaceTextureHelper = false;
    }

    public static VideoDecoder createDecoder(VideoCodecDesc r9) {
        BmmtVideoCodecStandard r10 = r9.getStandard();
        MediaCodecInfo r0 = findCodecForType(r10);
        if (r0 != null) goto L5;
        return null;
    L5:
        MediaCodecInfo.CodecCapabilities r2 = r0.getCapabilitiesForType(r10.mimeType());
        int[] r3 = r2.colorFormats;
        int r4 = r3.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L8;
        Logging.w(TAG, "support codecColorFormat:" + r3[r5]);
        r5 = r5 + 1;
        goto L6
    L8:
        Integer r6 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, r2);
        if (r6 != null) goto L12;
        return null;
    L12:
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), r0.getName(), r10, r6.intValue());
    }

    public static void enableEglLock(boolean r2) {
        Logging.e(TAG, "MediaCodecVideoDecoderFactory enableEglLock:" + r2);
        EglBase.EglLock.enableEglLock = r2;
    }

    private static MediaCodecInfo findCodecForType(BmmtVideoCodecStandard r5) {
        int r1 = 0;
    L23:
        if (r1 >= MediaCodecList.getCodecCount()) goto L22;
        MediaCodecInfo r3 = MediaCodecList.getCodecInfoAt(r1);     // Catch: IllegalArgumentException -> L8 Exception -> L20
    L10:
        if (r3 == null) goto L19;
        if (r3.isEncoder() == true) goto L19;
        if (isSoftwareDecoder(r3) == true) goto L19;
        if (isSupportedCodec(r3, r5) == false) goto L19;
        return r3;
    L19:
        r1 = r1 + 1;
        goto L23
    L8:
        e = move-exception;
        Logging.e(TAG, "Cannot retrieve decoder codec info", e);     // Catch: Exception -> L20
        r3 = null;
    L22:
        return null;
    L20:
        e = move-exception;
        Logging.e(TAG, "findCodecForType got system error:", e);
        goto L22
    }

    private static boolean isSoftwareDecoder(MediaCodecInfo r3) {
    L33:
        e = move-exception;
        Logging.e(TAG, "check decoder softonly error.", e);
        return false;
    L4:
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        String r4 = r3.getName();     // Catch: Exception -> L33
        if (r4 != null) goto L10;
        return false;
    L10:
        String r5 = r4.toLowerCase();     // Catch: Exception -> L33
        if (r5.startsWith("arc.") == false) goto L14;
        return false;
    L14:
        if (r5.startsWith("omx.google.") == false) goto L16;
    L31:
        return true;
    L16:
        if (r5.startsWith("omx.ffmpeg.") == true) goto L31;
        if (r5.startsWith("omx.sec.") == false) goto L22;
        if (r5.contains(".sw.") == true) goto L31;
    L22:
        if (r5.startsWith("c2.android.") == true) goto L31;
        if (r5.equals("omx.qcom.video.decoder.hevcswvdec") == true) goto L31;
        if (r5.startsWith("c2.google.") == true) goto L31;
        if (r5.startsWith("omx.") == false) goto L30;
        return false;
    L30:
        if (r5.startsWith("c2.") == false) goto L31;
        return false;
    L6:
        return r3.isSoftwareOnly();
    }

    private static boolean isH264HighProfileSupported(MediaCodecInfo r4, BmmtVideoCodecStandard r5) {
        String r0 = r4.getName();
        int r1 = Build.VERSION.SDK_INT;
        if (r0.startsWith("OMX.qcom.") == false) goto L6;
        return true;
    L6:
        if (r1 >= 23) goto L8;
    L10:
        MediaCodecInfo.CodecCapabilities r6 = r4.getCapabilitiesForType(r5.mimeType());
        int r2 = 0;
    L11:
        MediaCodecInfo.CodecProfileLevel[] r3 = r6.profileLevels;
        if (r2 >= r3.length) goto L17;
        if (8 == r3[r2].profile) goto L15;
        r2 = r2 + 1;
        goto L11
    L15:
        return true;
    L17:
        return false;
    L8:
        if (r0.startsWith("OMX.Exynos.") == false) goto L10;
        return true;
    }

    private static boolean isSupportedCodec(MediaCodecInfo r2, BmmtVideoCodecStandard r3) {
        r2.getName();
        if (MediaCodecUtils.codecSupportsType(r2, r3) == true) goto L6;
        return false;
    L6:
        if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, r2.getCapabilitiesForType(r3.mimeType())) != null) goto L8;
        return false;
    L8:
        return true;
    }
}
