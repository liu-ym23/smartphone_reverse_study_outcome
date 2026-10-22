package com.obric.cae.smartBluetooth.dcf;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DcfDataElementHeader {
    private static final int HEADER_FLAG_BITMASK = 128;
    private static final int HEADER_TAG_OFFSET = 7;
    private static final int HEADER_VALUE_BITMASK = 127;
    private final int mDataLength;
    private final int mTag;

    public DcfDataElementHeader(int r8, int r10, int r11) {
        if (r8 != 1) goto L10;
        if (r11 < 0) goto L8;
        this.mTag = r10;
        this.mDataLength = r11;
        return;
    L8:
        throw new IllegalArgumentException("Length should not be negative.");
    L10:
        throw new IllegalArgumentException("DcfDataElementHeader is only supported in V1.");
    }

    private List<Byte> convertTagToBytes(int r8) {
        ArrayList r10 = new ArrayList();
    L3:
        if (r8 <= 0) goto L5;
        byte r11 = (byte) (r8 & 127);
        r8 = r8 >> 7;
        r10.add(Byte.valueOf(r11));
        goto L3
    L5:
        int r12 = r10.size();
        int r13 = 0;
    L7:
        if (r13 >= (r12 - 1)) goto L9;
        r10.set(r13, Byte.valueOf((byte) (((Byte) r10.get(r13)).byteValue() | 128)));
        r13 = r13 + 1;
        goto L7
    L9:
        return r10;
    }

    public static DcfDataElementHeader fromBytes(int r8, byte[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L14;
        if ((r10[r12] & 128) != 0) goto L13;
        if (r12 == (r10.length - 1)) goto L13;
        return null;
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        int r13 = (r10[0] & 127) - (r10.length - 1);
        int r14 = r10.length - 1;
    L15:
        if (r14 <= 0) goto L18;
        r11 = (r11 << 7) | (r10[r14] & 127);
        r14 = r14 - 1;
        goto L15
    L18:
        return new DcfDataElementHeader(r8, r11, r13);
    }

    public static byte[] getHeader(byte[] r8, int r10) {
        ArrayList r11 = new ArrayList();
    L4:
        if (r10 >= r8.length) goto L14;
        byte r12 = r8[r10];
        r11.add(Byte.valueOf(r12));
        if ((r12 & 128) == 0) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        ByteBuffer r13 = ByteBuffer.allocate(r11.size());
        Iterator r14 = r11.iterator();
    L9:
        if (r14.hasNext() == false) goto L12;
        r13.put(((Byte) r14.next()).byteValue());
        goto L9
    L12:
        return r13.array();
    L14:
        return null;
    }

    public int getDataLength() {
        return this.mDataLength;
    }

    public int getTag() {
        return this.mTag;
    }

    public byte[] toBytes() {
        List<Byte> r8 = convertTagToBytes(this.mTag);
        int r10 = 1;
        byte[] r11 = new byte[r8.size() + 1];
        int r12 = this.mDataLength;
        r11[0] = (byte) (((r8.size() + r12) & 127) | 128);
        Iterator<Byte> r13 = r8.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r11[r10] = r13.next().byteValue();
        r10 = r10 + 1;
        goto L4
    L6:
        return r11;
    }

    public DcfDataElementHeader(int r8, DcfDataElement r10) {
        this(r8, r10.getTag(), r10.getData().length);
    }
}
