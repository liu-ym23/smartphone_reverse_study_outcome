package com.obric.cae.smartBluetooth.dcf;

import com.obric.cae.log.CaeLog;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DcfAdvertisement {
    private static final int DE_SET_LENGTH_LENGTH = 2;
    private static final int HEADER_LENGTH = 1;
    private static final int HEADER_VERSION_BITMASK = 224;
    private static final int HEADER_VERSION_OFFSET = 5;
    private static final int HEADER_VISIBILITY_OFFSET = 4;
    private static final int IV_LENGTH = 16;
    private static final int PRIVATE_VISIBILITY = 0;
    private static final int PUBLIC_VISIBILITY = 1;
    private static final String TAG = "DcfAdvertisement";
    private static final int TYPE_VISIBILITY_BITMASK = 16;
    public static final short VERSION_1 = 1;
    private int mDataElementSetLength;
    private final List<DcfDataElement> mDataElements;
    private final List<byte[]> mDataElementsBytes;

    public DcfAdvertisement(List<DcfDataElement> r8) {
        this.mDataElements = r8;
        this.mDataElementsBytes = new ArrayList(r8.size());
        Iterator<DcfDataElement> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        byte[] r11 = convertDataElementToBytes(r10.next());
        this.mDataElementsBytes.add(r11);
        this.mDataElementSetLength += r11.length;
        goto L4
    }

    private byte[] convertDataElementToBytes(DcfDataElement r8) {
        byte[] r10 = r8.getData();
        byte[] r11 = new DcfDataElementHeader(1, r8.getTag(), r10.length).toBytes();
        byte[] r12 = new byte[r11.length + r10.length];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        System.arraycopy(r10, 0, r12, r11.length, r10.length);
        return r12;
    }

    public static DcfAdvertisement fromBytes(byte[] r11) {
        if (r11 != null) goto L5;
    L45:
        String r12 = "Empty DCF service data";
    L14:
        CaeLog.w(TAG, r12);
        return null;
    L5:
        if (r11.length == 0) goto L45;
        ArrayList r8 = new ArrayList();
        ByteBuffer r13 = ByteBuffer.wrap(r11);
        byte r10 = r13.get();
        short r14 = (short) ((r10 & 224) >> 5);
        short r15 = (short) ((r10 & BWDLDataStructure.DataLinkParamStructure.WIFI_P2P) >> 4);
        if (r14 != 1) goto L44;
        if (r15 != 1) goto L44;
        if (r13.remaining() >= 16) goto L16;
        r12 = "Illegal IV length in DCF message";
        goto L14
    L16:
        r13.get(new byte[16]);
        if (r13.remaining() >= 2) goto L19;
        r12 = "Illegal DataElement set length in DCF message";
        goto L14
    L19:
        int r16 = (r13.get() & 255) | ((r13.get() & 255) << 8);
        CaeLog.d(TAG, "DataElement set length = " + r16);
        if (r13.remaining() >= r16) goto L22;
        r12 = "Illegal DataElement set data in DCF message";
        goto L14
    L22:
        byte[] r17 = new byte[r16];
        r13.get(r17);
        AtomicInteger r18 = new AtomicInteger();
    L24:
        if (r18.get() >= r16) goto L43;
        byte[] r19 = DcfDataElementHeader.getHeader(r17, r18.get());
        if (r19 == null) goto L41;
        if (r19.length == 0) goto L41;
        r18.addAndGet(r19.length);
        DcfDataElementHeader r20 = DcfDataElementHeader.fromBytes(1, r19);
        if (r20 == null) goto L32;
        int r21 = r20.getDataLength();
        if (r21 < 0) goto L39;
        if ((r18.get() + r21) > r16) goto L39;
        r8.add(new DcfDataElement(r20.getTag(), Arrays.copyOfRange(r17, r18.get(), r18.get() + r21)));
        r18.addAndGet(r21);
    L39:
        StringBuilder r110 = new StringBuilder("Illegal DataElement length in DCF message, length=");
        r110.append(r21);
    L40:
        r12 = r110.toString();
        goto L14
    L32:
        r12 = "Illegal DataElement header format in DCF message";
    L41:
        r12 = "Illegal DataElement header in DCF message";
        goto L14
    L43:
        return new DcfAdvertisement(r8);
    L44:
        r110 = new StringBuilder("Unsupported DCF message version");
        r110.append(r14);
        goto L40
    }

    private static byte[] generateInitializationVector() {
        UUID r8 = UUID.randomUUID();
        ByteBuffer r10 = ByteBuffer.allocate(16);
        r10.putLong(r8.getMostSignificantBits());
        r10.putLong(r8.getLeastSignificantBits());
        return r10.array();
    }

    public List<DcfDataElement> getDataElements() {
        return this.mDataElements;
    }

    public byte[] toBytes() {
        ByteBuffer r8 = ByteBuffer.allocate(this.mDataElementSetLength + 19);
        r8.put(BWDLDataStructure.DataLinkParamStructure.NFC);
        r8.put(generateInitializationVector());
        r8.put((byte) (this.mDataElementSetLength & 255));
        r8.put((byte) ((this.mDataElementSetLength >> 8) & 255));
        Iterator<byte[]> r10 = this.mDataElementsBytes.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r8.put(r10.next());
        goto L4
    L7:
        return r8.array();
    }
}
