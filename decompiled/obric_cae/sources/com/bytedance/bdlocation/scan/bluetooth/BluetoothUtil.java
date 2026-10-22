package com.bytedance.bdlocation.scan.bluetooth;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothUtil {
    public static final String BLE_SCAN_TRACE = "ble_scan_trace";
    public static final int SHAKE_TYPE = 1;
    public static final int UPLOAD_TYPE = 2;
    public static final byte[] hex = null;

    static {
        hex = "0123456789ABCDEF".getBytes();
    }

    public BluetoothUtil() {
    }

    public static String Bytes2HexString(byte[] r8) {
        byte[] r10 = new byte[r8.length * 2];
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L7;
        int r12 = r11 * 2;
        byte[] r13 = hex;
        r10[r12] = r13[(r8[r11] >> 4) & 15];
        r10[r12 + 1] = r13[r8[r11] & 15];
        r11 = r11 + 1;
        goto L4
    L7:
        return new String(r10);
    }

    public static int byteToInt(byte r8, byte r10) {
        return ((r8 & 255) * 256) + (r10 & 255);
    }

    public static double calculateAccuracy(int r8, double r10) {
        if (r10 != 0.0d) goto L6;
        return -1.0d;
    L6:
        double r11 = (r10 * 1.0d) / ((double) r8);
        if (r11 >= 1.0d) goto L11;
        return Math.pow(r11, 10.0d);
    L11:
        return (Math.pow(r11, 7.7095d) * 0.89976d) + 0.111d;
    }

    public static byte charToByte(char r8) {
        return (byte) "0123456789ABCDEF".indexOf(r8);
    }

    public static byte[] hexStringToBytes(String r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.equals("") == true) goto L13;
        String r10 = r8.toUpperCase();
        int r11 = r10.length() / 2;
        char[] r12 = r10.toCharArray();
        byte[] r13 = new byte[r11];
        int r14 = 0;
    L7:
        if (r14 >= r11) goto L9;
        int r15 = r14 * 2;
        int r16 = charToByte(r12[r15]) << 4;
        r13[r14] = (byte) (charToByte(r12[r15 + 1]) | r16);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L13:
        return null;
    }
}
