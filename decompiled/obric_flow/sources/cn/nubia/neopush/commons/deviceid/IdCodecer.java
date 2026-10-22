package cn.nubia.neopush.commons.deviceid;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class IdCodecer {
    public static final String FAKE_ID = "00000000";
    private static final String TAG = "IdCodecer";
    private static final char[] mDigits = null;

    static {
        mDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public IdCodecer() {
    }

    public static boolean allZeros(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L13;
        int r10 = 0;
    L6:
        if (r10 >= r5.length()) goto L7;
        if ('0' != r5.charAt(r10)) goto L11;
        r10 = r10 + 1;
        goto L6
    L11:
        return false;
    L7:
        return true;
    L13:
        return false;
    }

    public static String serialize(ArrayList<String> r5) {
        StringBuilder r10 = new StringBuilder();
        if (r5 == null) goto L16;
        if (r5.size() <= 0) goto L16;
        Iterator<String> r11 = r5.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();
        if (r12 == null) goto L8;
        r10.append("|");
        r10.append(r12);
        goto L8
    L10:
        if (r10.length() <= 0) goto L16;
        r10.append("|");
    L16:
        return r10.toString();
    }

    public static String sha256(String r5, byte[] r10) {
        if (TextUtils.isEmpty(r5) == false) goto L21;
        if (r10 != null) goto L6;
    L19:
        return null;
    L6:
        if (r10.length <= 0) goto L19;
    L21:
        MessageDigest r11 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r5) == true) goto L12;
        r11.update(r5.getBytes("UTF-8"));     // Catch: Exception -> L10
    L12:
        if (r10 != null) goto L14;
    L16:
        return toHexString(r11.digest());
    L14:
        if (r10.length <= 0) goto L16;
        r11.update(r10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static String toHexString(byte[] r5) {
        if (r5 == null) goto L9;
        StringBuilder r10 = new StringBuilder(r5.length * 2);
        int r11 = 0;
    L5:
        if (r11 >= r5.length) goto L7;
        char[] r12 = mDigits;
        r10.append(r12[(r5[r11] >> 4) & 15]);
        r10.append(r12[r5[r11] & 15]);
        r11 = r11 + 1;
        goto L5
    L7:
        return r10.toString();
    L9:
        return "";
    }

    public static void unserialize(String r5, ArrayList<String> r10, boolean r11) {
        if (TextUtils.isEmpty(r5) == true) goto L19;
        if (r10 == null) goto L25;
        int r12 = 0;
        String[] r13 = r5.split("\\|", 0);
        if (r13 == null) goto L26;
        int r14 = r13.length;
    L8:
        if (r12 >= r14) goto L27;
        String r15 = r13[r12];
        if (TextUtils.isEmpty(r15) == true) goto L18;
        if (r10.contains(r15) == true) goto L18;
        if (r11 == true) goto L16;
    L17:
        r10.add(r15);
        goto L18
    L16:
        if (allZeros(r15) == false) goto L17;
    L18:
        r12 = r12 + 1;
        goto L8
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }
}
