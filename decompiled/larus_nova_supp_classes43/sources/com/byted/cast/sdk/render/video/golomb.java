package com.byted.cast.sdk.render.video;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.model.NALBitstream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class golomb {
    private static final String TAG = "golomb";
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    public int nStartBit;

    /* JADX INFO: renamed from: com.byted.cast.sdk.render.video.golomb$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID = null;

        static {
            int[] r0 = new int[RTCSetting.VCODEC_ID.values().length];
            $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID = r0;
            r0[RTCSetting.VCODEC_ID.H264.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID[RTCSetting.VCODEC_ID.H265.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public golomb(ContextManager.CastContext r10) {
        this.nStartBit = 0;
        this.mCastContext = r10;
        this.mLogger = ContextManager.getLogger(r10);
    }

    public SPS ParseH264(byte[] r13) {
        int r0 = 0;
        this.nStartBit = 0;
        SPS r1 = new SPS();
        skip_bits(32);
        skip_bits(1);
        skip_bits(2);
        if (read_u(5, r13) != 7) goto L73;
        r1.profile_idc = read_u(8, r13);
        skip_bits(8);
        r1.level_idc = read_u(8, r13);
        read_ue(r13);
        int r10 = r1.profile_idc;
        if (r10 != 100) goto L7;
    L28:
        int r11 = read_ue(r13);
        r1.chroma_format_idc = r11;
        if (r11 != 3) goto L31;
        skip_bits(1);
    L34:
        read_ue(r13);
        read_ue(r13);
        skip_bits(2);
    L35:
        read_ue(r13);
        int r12 = read_ue(r13);
        r1.pic_order_cnt_type = r12;
        if (r12 != 0) goto L38;
        read_ue(r13);
    L46:
        read_ue(r13);
        skip_bits(1);
        r1.mb_width = read_ue(r13) + 1;
        r1.mb_height = read_ue(r13) + 1;
        r1.frame_mbs_only_flag = read_u(1, r13);
        this.mLogger.e(TAG, " mb_width=" + r1.mb_width + "  mb_height=" + r1.mb_height);
        if (r1.frame_mbs_only_flag != 0) goto L49;
        skip_bits(1);
    L49:
        skip_bits(1);
        int r14 = read_u(1, r13);
        r1.crop = r14;
        if (r14 == 0) goto L72;
        int r15 = read_ue(r13);
        int r16 = read_ue(r13);
        int r17 = read_ue(r13);
        int r18 = read_ue(r13);
        int r19 = r1.mb_width * 16;
        int r20 = r1.mb_height * 16;
        int r110 = r1.chroma_format_idc;
        if (r110 != 1) goto L54;
        int r111 = 1;
    L55:
        if (r110 == 1) goto L57;
        if (r110 == 2) goto L57;
    L58:
        int r21 = 1 << r0;
        int r22 = (2 - r1.frame_mbs_only_flag) << r111;
        int r112 = 536870911 / r21;
        if (r15 > r112) goto L70;
        if (r16 > r112) goto L70;
        int r113 = 536870911 / r22;
        if (r17 > r113) goto L70;
        if (r18 > r113) goto L70;
        if (((r15 + r16) * r21) >= r19) goto L70;
        if (((r17 + r18) * r22) >= r20) goto L70;
        r1.crop_left = r15 * r21;
        r1.crop_right = r16 * r21;
        r1.crop_top = r17 * r22;
        r1.crop_bottom = r18 * r22;
    L74:
        r1.width = ((r1.mb_width * 16) - r1.crop_left) - r1.crop_right;
        r1.height = ((r1.mb_height * 16) - r1.crop_top) - r1.crop_bottom;
        r1.bVaild = true;
        this.mLogger.i(TAG, " w=" + r1.width + " h=" + r1.height);
        return r1;
    L70:
        this.mLogger.e(TAG, " overrun crop");
        return r1;
    L57:
        r0 = 1;
        goto L58
    L54:
        r111 = 0;
        goto L55
    L72:
        r1.crop_left = 0;
        r1.crop_right = 0;
        r1.crop_top = 0;
        r1.crop_bottom = 0;
        goto L74
    L38:
        if (r12 != 1) goto L43;
        Integer r23 = Integer.valueOf(read_ue(r13));
        int r24 = 0;
    L41:
        if (r24 >= r23.intValue()) goto L46;
        read_se(r13);
        r24 = r24 + 1;
        goto L41
    L43:
        if (r12 == 2) goto L46;
        this.mLogger.e(TAG, " pic_order_cnt_type=" + r1.pic_order_cnt_type);
        return r1;
    L31:
        if (r11 <= 3) goto L34;
        this.mLogger.e(TAG, " chroma_format_idc=" + r1.chroma_format_idc);
        return r1;
    L7:
        if (r10 == 110) goto L28;
        if (r10 == 122) goto L28;
        if (r10 == 244) goto L28;
        if (r10 == 44) goto L28;
        if (r10 == 83) goto L28;
        if (r10 == 86) goto L28;
        if (r10 == 118) goto L28;
        if (r10 == 128) goto L28;
        if (r10 == 138) goto L28;
        if (r10 == 144) goto L28;
        r1.chroma_format_idc = 1;
        r1.bit_depth_chroma = 8;
        r1.bit_depth_luma = 8;
        goto L35
    L73:
        this.mLogger.e(TAG, " ......369");
        goto L74
    }

    public int read_se(byte[] r10) {
        int r11 = read_ue(r10);
        if ((r11 & 1) == 0) goto L6;
        return (r11 + 1) / 2;
    L6:
        return -(r11 / 2);
    }

    public int read_ue(byte[] r10) {
        int r0 = 0;
    L3:
        int r1 = this.nStartBit;
        if (r1 >= (r10.length * 8)) goto L9;
        if ((r10[r1 / 8] & (128 >> (r1 % 8))) != 0) goto L9;
        r0 = r0 + 1;
        this.nStartBit = r1 + 1;
    L9:
        this.nStartBit = r1 + 1;
        return ((1 << r0) - 1) + read_u(r0, r10);
    }

    public void skip_bits(int r10) {
        this.nStartBit += r10;
    }

    public SPS Parse(byte[] r10, RTCSetting.VCODEC_ID r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID[r11.ordinal()];
        int r0 = 4;
        int r1 = 0;
        if (r12 == 1) goto L47;
        if (r12 != 2) goto L64;
        if (((r10[4] & 126) >> 1) != 32) goto L64;
    L11:
        if (r0 >= r10.length) goto L22;
        if (r10[r0 + 0] != 0) goto L21;
        if (r10[r0 + 1] != 0) goto L21;
        if (r10[r0 + 2] != 0) goto L21;
        if (r10[r0 + 3] != 1) goto L21;
    L23:
        if (r0 == 0) goto L64;
        int r13 = r0 + 4;
        if (((r10[r13] & 126) >> 1) != 33) goto L64;
        int r14 = r13;
    L30:
        if (r14 >= r10.length) goto L41;
        if (r10[r14 + 0] != 0) goto L40;
        if (r10[r14 + 1] != 0) goto L40;
        if (r10[r14 + 2] != 0) goto L40;
        if (r10[r14 + 3] != 1) goto L40;
        r1 = r14;
    L40:
        r14 = r14 + 1;
    L41:
        if (r1 != 0) goto L45;
        if ((r10[r13] & 126) != 33) goto L64;
    L45:
        return ParseSequenceParameterSet(r10, r0);
    L21:
        r0 = r0 + 1;
        goto L11
    L22:
        r0 = 0;
    L64:
        return new SPS();
    L47:
        if ((r10[4] & 31) != 7) goto L64;
    L49:
        if (r0 >= r10.length) goto L60;
        if (r10[r0 + 0] != 0) goto L59;
        if (r10[r0 + 1] != 0) goto L59;
        if (r10[r0 + 2] != 0) goto L59;
        if (r10[r0 + 3] != 1) goto L59;
        r1 = r0;
    L59:
        r0 = r0 + 1;
    L60:
        if (r1 == 0) goto L64;
        return ParseH264(r10);
    }

    public SPS ParseSequenceParameterSet(byte[] r17, int r18) {
        SPS r10 = new SPS();
        if (r17.length >= 20) goto L6;
        this.mLogger.e(TAG, "ParseSequenceParameterSet data.length<20");
        return r10;
    L6:
        NALBitstream r11 = new NALBitstream(r17, r18);
        r11.GetWord(32);
        r11.GetWord(16);
        r11.GetWord(4);
        int r12 = r11.GetWord(3);
        if (r12 <= 6) goto L10;
        this.mLogger.e(TAG, "sps_max_sub_layers_minus1>6");
        return r10;
    L10:
        r11.GetWord(1);
        int r13 = 2;
        r11.GetWord(2);
        r11.GetWord(1);
        r10.profile_idc = r11.GetWord(5);
        r11.GetWord(32);
        r11.GetWord(1);
        r11.GetWord(1);
        r11.GetWord(1);
        r11.GetWord(1);
        r11.GetWord(44);
        r10.level_idc = r11.GetWord(8);
        byte[] r14 = new byte[6];
        byte[] r15 = new byte[6];
        int r16 = 0;
    L11:
        if (r16 >= r12) goto L13;
        r14[r16] = (byte) r11.GetWord(1);
        r15[r16] = (byte) r11.GetWord(1);
        r16 = r16 + 1;
        goto L11
    L13:
        if (r12 <= 0) goto L17;
        int r19 = r12;
    L15:
        if (r19 >= 8) goto L17;
        r11.GetWord(2);
        r19 = r19 + 1;
    L17:
        int r110 = 0;
    L18:
        if (r110 >= r12) goto L27;
        if (r14[r110] == 0) goto L23;
        r11.GetWord(2);
        r11.GetWord(1);
        r11.GetWord(5);
        r11.GetWord(32);
        r11.GetWord(1);
        r11.GetWord(1);
        r11.GetWord(1);
        r11.GetWord(1);
        r11.GetWord(44);
    L23:
        if (r15[r110] == 0) goto L25;
        r11.GetWord(8);
    L25:
        r110 = r110 + 1;
        goto L18
    L27:
        if (r11.GetUE() <= 15) goto L30;
        this.mLogger.e(TAG, "sps_seq_parameter_set_id>15");
        return r10;
    L30:
        int r1 = r11.GetUE();
        if (r1 <= 3) goto L34;
        this.mLogger.e(TAG, "chroma_format_idc>3   " + r1);
        return r10;
    L34:
        if (r1 != 3) goto L36;
        r11.GetWord(1);
    L36:
        r10.width = r11.GetUE();
        r10.height = r11.GetUE();
        this.mLogger.i(TAG, "bytelink width=" + r10.width + " height=" + r10.height);
        int r20 = r11.GetWord(1);
        this.mLogger.i(TAG, "width=" + r10.width + " height=" + r10.height + " flag=" + r20);
        if (r20 == 0) goto L49;
        int r21 = r11.GetUE();
        int r22 = r11.GetUE();
        int r111 = r11.GetUE();
        int r112 = r11.GetUE();
        if (r1 == 1) goto L43;
        if (r1 == 2) goto L43;
        int r113 = 1;
    L44:
        if (r1 == 1) goto L47;
        r13 = 1;
    L47:
        r10.width -= (r21 + r22) * r113;
        r10.height -= (r111 + r112) * r13;
        this.mLogger.i(TAG, "modify width=" + r10.width + " height=" + r10.height + " factor:" + r113 + "&" + r13);
    L43:
        r113 = 2;
    L49:
        if (r11.GetUE() == r11.GetUE()) goto L52;
        this.mLogger.e(TAG, "bit_depth_luma_minus8 != bit_depth_chroma_minus8");
        return r10;
    L52:
        r10.bVaild = true;
        return r10;
    }

    public int read_u(int r10, byte[] r11) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r10) goto L8;
        r1 = r1 << 1;
        int r12 = this.nStartBit;
        if ((r11[r12 / 8] & (128 >> (r12 % 8))) == 0) goto L7;
        r1 = r1 + 1;
    L7:
        this.nStartBit = r12 + 1;
        r0 = r0 + 1;
        goto L3
    L8:
        return r1;
    }
}
