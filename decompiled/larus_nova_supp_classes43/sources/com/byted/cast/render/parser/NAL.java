package com.byted.cast.render.parser;

import com.byted.cast.mediacommon.render.parameters.CodecId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class NAL {
    public static final int H265_NAL_TYPE_IDR_W_RADL = 19;
    public static final int H265_NAL_TYPE_SEI = 39;
    public static final int H265_NAL_TYPE_VPS = 32;
    public static final int NAL_TYPE_IDR = 5;
    public static final int NAL_TYPE_P = 1;
    public static final int NAL_TYPE_SEI = 6;
    public static final int NAL_TYPE_SPS = 7;
    private static final String TAG = "NAL";
    public byte[] buf;
    public long frameIndex;
    public int length;
    public int type;
    public CodecId vCodecId;

    public static int detectNALType(NAL r10) {
        CodecId r0 = r10.vCodecId;
        CodecId r1 = CodecId.H264;
        if (r0 != r1) goto L5;
        int r11 = r10.buf[4] & 31;
    L7:
        if (r0 != r1) goto L9;
        if (r11 != 7) goto L9;
    L13:
        r10.type = 7;
    L30:
        return r10.type;
    L9:
        CodecId r12 = CodecId.H265;
        if (r0 != r12) goto L15;
        if (r11 == 32) goto L13;
    L15:
        if (r0 != r1) goto L17;
        if (r11 != 5) goto L17;
    L20:
        r10.type = 5;
    L17:
        if (r0 != r12) goto L22;
        if (r11 == 19) goto L20;
    L22:
        if (r0 != r1) goto L24;
        if (r11 != 6) goto L24;
    L27:
        r10.type = 6;
    L24:
        if (r0 == r12) goto L26;
    L28:
        r10.type = 1;
        goto L30
    L26:
        if (r11 != 39) goto L28;
    L5:
        r11 = (r10.buf[4] >> 1) & 63;
        goto L7
    }

    public NAL(byte[] r10, int r11, CodecId r12) {
        this.frameIndex = 0;
        this.buf = r10;
        this.length = r11;
        this.vCodecId = r12;
    }
}
