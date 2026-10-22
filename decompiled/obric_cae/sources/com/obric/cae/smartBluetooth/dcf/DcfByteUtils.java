package com.obric.cae.smartBluetooth.dcf;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DcfByteUtils {
    private DcfByteUtils() {
    }

    public static String byteToString(byte[] r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.length == 0) goto L14;
        StringBuilder r10 = new StringBuilder(r8.length * 2);
        int r11 = r8.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L10;
        byte r13 = r8[r12];
        r10.append(String.format(Locale.US, "%02x", new Object[]{Byte.valueOf(r13)}));
        r12 = r12 + 1;
        goto L7
    L10:
        return r10.toString();
    L14:
        return null;
    }
}
