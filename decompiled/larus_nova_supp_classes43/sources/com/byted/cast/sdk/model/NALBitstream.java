package com.byted.cast.sdk.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class NALBitstream {
    private int m_bits;
    private byte m_byte;
    private byte[] m_data;
    private int m_idx;
    private int m_len;
    private int m_zeros;

    public class vc_params_t {
        int height;
        int level;
        int nal_length_size;
        int profile;
        final /* synthetic */ NALBitstream this$0;
        int width;

        private vc_params_t(NALBitstream r1) {
            this.this$0 = r1;
        }
    }

    public int GetUE() {
        int r0 = 0;
    L4:
        if (this.m_idx >= this.m_len) goto L9;
        if (GetBit() != 0) goto L9;
        r0 = r0 + 1;
    L9:
        return GetWord(r0) + ((1 << r0) - 1);
    }

    public byte GetBYTE() {
        int r0 = this.m_idx;
        int r1 = this.m_len;
        if (r0 < r1) goto L5;
        return 0;
    L5:
        byte[] r10 = this.m_data;
        int r11 = r0 + 1;
        this.m_idx = r11;
        byte r12 = r10[r0];
        if (r12 != 0) goto L14;
        int r13 = this.m_zeros + 1;
        this.m_zeros = r13;
        if (r11 < r1) goto L10;
    L15:
        return r12;
    L10:
        if (r13 != 2) goto L15;
        if (r10[r11] != 3) goto L15;
        this.m_idx = r11 + 1;
        this.m_zeros = 0;
        goto L15
    L14:
        this.m_zeros = 0;
        goto L15
    }

    public int GetBit() {
        if (this.m_bits != 0) goto L5;
        this.m_byte = GetBYTE();
        this.m_bits = 8;
    L5:
        int r0 = this.m_bits - 1;
        this.m_bits = r0;
        return (this.m_byte >> r0) & 1;
    }

    public int GetSE() {
        int r0 = GetUE();
        if ((r0 & 1) != 1) goto L5;
        boolean r1 = true;
    L6:
        int r10 = (r0 + 1) >> 1;
        if (r1 == false) goto L9;
        return r10;
    L9:
        return -r10;
    L5:
        r1 = false;
        goto L6
    }

    public int GetWord(int r10) {
        int r0 = 0;
    L3:
        if (r10 <= 0) goto L5;
        r0 = (r0 << 1) | GetBit();
        r10 = r10 - 1;
        goto L3
    L5:
        return r0;
    }

    public NALBitstream(byte[] r1, int r10) {
        Init(r1, r10);
    }

    private void Init(byte[] r1, int r10) {
        this.m_data = r1;
        this.m_len = r1.length;
        this.m_idx = r10;
        this.m_bits = 0;
        this.m_byte = 0;
        this.m_zeros = 0;
    }
}
