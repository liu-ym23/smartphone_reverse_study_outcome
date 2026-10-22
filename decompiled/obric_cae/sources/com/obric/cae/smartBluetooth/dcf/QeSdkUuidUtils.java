package com.obric.cae.smartBluetooth.dcf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class QeSdkUuidUtils {
    private static final UUID BASE_UUID = null;
    private static final int BIT_INDEX_OF_16_BIT_UUID = 32;

    static {
        BASE_UUID = UUID.fromString("00000000-0000-1000-8000-00805F9B34FB");
    }

    private QeSdkUuidUtils() {
    }

    public static short get16BitUuid(UUID r8) {
        if (is16BitUuid(r8) == false) goto L7;
        return (short) (r8.getMostSignificantBits() >> 32);
    L7:
        throw new IllegalArgumentException("Not a 16-bit Bluetooth UUID: " + r8);
    }

    public static boolean is16BitUuid(UUID r8) {
        long r10 = r8.getLeastSignificantBits();
        UUID r11 = BASE_UUID;
        if (r10 == r11.getLeastSignificantBits()) goto L5;
    L7:
        return false;
    L5:
        if ((r8.getMostSignificantBits() & (-281470681743361L)) != r11.getMostSignificantBits()) goto L7;
        return true;
    }

    public static UUID to128BitUuid(short r8) {
        long r10 = (((long) r8) & 65535) << 32;
        UUID r11 = BASE_UUID;
        return new UUID(r10 | r11.getMostSignificantBits(), r11.getLeastSignificantBits());
    }

    public static byte[] toBytes(short r8) {
        UUID r10 = to128BitUuid(r8);
        ByteBuffer r11 = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN);
        r11.putLong(r10.getLeastSignificantBits());
        r11.putLong(r10.getMostSignificantBits());
        return r11.array();
    }
}
