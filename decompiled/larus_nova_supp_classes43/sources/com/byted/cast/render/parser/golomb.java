package com.byted.cast.render.parser;

import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.render.utils.NALBitstream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class golomb {
    private static final String TAG = "golomb";
    public int nStartBit;

    /* JADX INFO: renamed from: com.byted.cast.render.parser.golomb$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId = null;

        static {
            int[] r0 = new int[CodecId.values().length];
            $SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId = r0;
            r0[CodecId.H264.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId[CodecId.H265.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public golomb() {
        this.nStartBit = 0;
    }

    public SPS ParseH264(byte[] r14) {
        int r0 = 0;
        this.nStartBit = 0;
        SPS r1 = new SPS();
        skip_bits(32);
        skip_bits(1);
        skip_bits(2);
        if (read_u(5, r14) != 7) goto L95;
        r1.profile_idc = read_u(8, r14);
        skip_bits(8);
        r1.level_idc = read_u(8, r14);
        read_ue(r14);
        int r10 = r1.profile_idc;
        if (r10 != 100) goto L7;
    L28:
        int r11 = read_ue(r14);
        r1.chroma_format_idc = r11;
        if (r11 != 3) goto L31;
        skip_bits(1);
    L34:
        read_ue(r14);
        read_ue(r14);
        skip_bits(1);
        if (read_u(1, r14) == 1) goto L37;
    L57:
        read_ue(r14);
        int r12 = read_ue(r14);
        r1.pic_order_cnt_type = r12;
        if (r12 != 0) goto L60;
        read_ue(r14);
    L68:
        read_ue(r14);
        skip_bits(1);
        r1.mb_width = read_ue(r14) + 1;
        r1.mb_height = read_ue(r14) + 1;
        r1.frame_mbs_only_flag = read_u(1, r14);
        Logger.d(TAG, " mb_width=" + r1.mb_width + "  mb_height=" + r1.mb_height);
        if (r1.frame_mbs_only_flag != 0) goto L71;
        skip_bits(1);
    L71:
        skip_bits(1);
        int r13 = read_u(1, r14);
        r1.crop = r13;
        if (r13 == 0) goto L94;
        int r15 = read_ue(r14);
        int r16 = read_ue(r14);
        int r17 = read_ue(r14);
        int r18 = read_ue(r14);
        int r19 = r1.mb_width * 16;
        int r110 = r1.mb_height * 16;
        int r111 = r1.chroma_format_idc;
        if (r111 != 1) goto L76;
        int r112 = 1;
    L77:
        if (r111 == 1) goto L79;
        if (r111 == 2) goto L79;
    L80:
        int r20 = 1 << r0;
        int r21 = (2 - r1.frame_mbs_only_flag) << r112;
        int r113 = 536870911 / r20;
        if (r15 > r113) goto L92;
        if (r16 > r113) goto L92;
        int r114 = 536870911 / r21;
        if (r17 > r114) goto L92;
        if (r18 > r114) goto L92;
        if (((r15 + r16) * r20) >= r19) goto L92;
        if (((r17 + r18) * r21) >= r110) goto L92;
        r1.crop_left = r15 * r20;
        r1.crop_right = r16 * r20;
        r1.crop_top = r17 * r21;
        r1.crop_bottom = r18 * r21;
    L96:
        r1.width = ((r1.mb_width * 16) - r1.crop_left) - r1.crop_right;
        r1.height = ((r1.mb_height * 16) - r1.crop_top) - r1.crop_bottom;
        r1.bVaild = true;
        Logger.i(TAG, " w=" + r1.width + " h=" + r1.height);
        return r1;
    L92:
        Logger.e(TAG, " overrun crop");
        return r1;
    L79:
        r0 = 1;
        goto L80
    L76:
        r112 = 0;
        goto L77
    L94:
        r1.crop_left = 0;
        r1.crop_right = 0;
        r1.crop_top = 0;
        r1.crop_bottom = 0;
        goto L96
    L60:
        if (r12 != 1) goto L65;
        Integer r22 = Integer.valueOf(read_ue(r14));
        int r23 = 0;
    L63:
        if (r23 >= r22.intValue()) goto L68;
        read_se(r14);
        r23 = r23 + 1;
        goto L63
    L65:
        if (r12 == 2) goto L68;
        Logger.e(TAG, " pic_order_cnt_type=" + r1.pic_order_cnt_type);
        return r1;
    L37:
        if (r1.chroma_format_idc == 3) goto L39;
        int r24 = 8;
    L40:
        int r25 = 0;
    L41:
        if (r25 >= r24) goto L57;
        if (read_u(1, r14) != 1) goto L56;
        int r26 = 0;
        int r115 = 8;
        int r116 = 8;
    L46:
        if (r25 >= 6) goto L48;
        int r117 = 16;
    L49:
        if (r26 >= r117) goto L56;
        if (r115 == 0) goto L52;
        r115 = ((read_se(r14) + r116) + 256) % 256;
    L52:
        if (r115 == 0) goto L55;
        r116 = r115;
    L55:
        r26 = r26 + 1;
        goto L46
    L48:
        r117 = 64;
    L56:
        r25 = r25 + 1;
        goto L41
    L39:
        r24 = 12;
        goto L40
    L31:
        if (r11 <= 3) goto L34;
        Logger.e(TAG, " chroma_format_idc=" + r1.chroma_format_idc);
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
        goto L57
    L95:
        Logger.e(TAG, " ......369");
        goto L96
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

    public SPS Parse(byte[] r10, CodecId r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId[r11.ordinal()];
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
        SPS r1 = new SPS();
        if (r17.length >= 20) goto L6;
        Logger.e(TAG, "ParseSequenceParameterSet data.length<20");
        return r1;
    L6:
        NALBitstream r10 = new NALBitstream(r17, r18);
        r10.GetWord(32);
        r10.GetWord(16);
        r10.GetWord(4);
        int r11 = r10.GetWord(3);
        if (r11 <= 6) goto L10;
        Logger.e(TAG, "sps_max_sub_layers_minus1>6");
        return r1;
    L10:
        r10.GetWord(1);
        int r12 = 2;
        r10.GetWord(2);
        r10.GetWord(1);
        r1.profile_idc = r10.GetWord(5);
        r10.GetWord(32);
        r10.GetWord(1);
        r10.GetWord(1);
        r10.GetWord(1);
        r10.GetWord(1);
        r10.GetWord(44);
        r1.level_idc = r10.GetWord(8);
        byte[] r13 = new byte[6];
        byte[] r14 = new byte[6];
        int r15 = 0;
        int r16 = 0;
    L11:
        if (r16 >= r11) goto L13;
        r13[r16] = (byte) r10.GetWord(1);
        r14[r16] = (byte) r10.GetWord(1);
        r16 = r16 + 1;
        goto L11
    L13:
        if (r11 <= 0) goto L17;
        int r19 = r11;
    L15:
        if (r19 >= 8) goto L17;
        r10.GetWord(2);
        r19 = r19 + 1;
    L17:
        if (r15 >= r11) goto L26;
        if (r13[r15] == 0) goto L22;
        r10.GetWord(2);
        r10.GetWord(1);
        r10.GetWord(5);
        r10.GetWord(32);
        r10.GetWord(1);
        r10.GetWord(1);
        r10.GetWord(1);
        r10.GetWord(1);
        r10.GetWord(44);
    L22:
        if (r14[r15] == 0) goto L24;
        r10.GetWord(8);
    L24:
        r15 = r15 + 1;
        goto L17
    L26:
        if (r10.GetUE() <= 15) goto L29;
        Logger.e(TAG, "sps_seq_parameter_set_id>15");
        return r1;
    L29:
        int r0 = r10.GetUE();
        if (r0 <= 3) goto L33;
        Logger.e(TAG, "chroma_format_idc>3   " + r0);
        return r1;
    L33:
        if (r0 != 3) goto L35;
        r10.GetWord(1);
    L35:
        r1.width = r10.GetUE();
        r1.height = r10.GetUE();
        Logger.i(TAG, "width=" + r1.width + " height=" + r1.height);
        int r20 = r10.GetWord(1);
        Logger.i(TAG, "width=" + r1.width + " height=" + r1.height + " flag=" + r20);
        if (r20 == 0) goto L48;
        int r21 = r10.GetUE();
        int r22 = r10.GetUE();
        int r23 = r10.GetUE();
        int r110 = r10.GetUE();
        if (r0 == 1) goto L42;
        if (r0 == 2) goto L42;
        int r111 = 1;
    L43:
        if (r0 == 1) goto L46;
        r12 = 1;
    L46:
        r1.width -= (r21 + r22) * r111;
        r1.height -= (r23 + r110) * r12;
        Logger.i(TAG, "modify width=" + r1.width + " height=" + r1.height + " factor:" + r111 + "&" + r12);
    L42:
        r111 = 2;
    L48:
        if (r10.GetUE() == r10.GetUE()) goto L51;
        Logger.e(TAG, "bit_depth_luma_minus8 != bit_depth_chroma_minus8");
        return r1;
    L51:
        r1.bVaild = true;
        return r1;
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
