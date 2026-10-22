package org.bouncycastle.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.util.ArrayList;
import org.bouncycastle.util.encoders.UTF8;

/* JADX INFO: loaded from: classes7.dex */
public final class Strings {
    private static String LINE_SEPARATOR;

    private static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        /* synthetic */ StringListImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public /* synthetic */ void add(int r3, Object r4) {
            add(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        }

        public void add(int r1, String r2) {
            super.add(r1, r2);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public /* synthetic */ boolean add(Object r3) {
            return add((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        public boolean add(String r1) {
            return super.add(r1);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public /* synthetic */ String get(int r2) {
            return (String) ZeusTransformUtils.preCheckCast(super.get(r2), String.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public /* synthetic */ Object set(int r3, Object r4) {
            return set(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        }

        public String set(int r1, String r2) {
            return (String) ZeusTransformUtils.preCheckCast(super.set(r1, r2), String.class, "com.obric.memorydata.plugin");
        }

        public String[] toStringArray() {
            int r0 = size();
            String[] r1 = new String[r0];
            int r2 = 0;
        L3:
            if (r2 == r0) goto L5;
            r1[r2] = (String) ZeusTransformUtils.preCheckCast(get(r2), String.class, "com.obric.memorydata.plugin");
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        public String[] toStringArray(int r7, int r8) {
            String[] r0 = new String[r8 - r7];
            int r1 = r7;
        L4:
            if (r1 == size()) goto L7;
            if (r1 == r8) goto L7;
            r0[r1 - r7] = (String) ZeusTransformUtils.preCheckCast(get(r1), String.class, "com.obric.memorydata.plugin");
            r1 = r1 + 1;
        L7:
            return r0;
        }
    }

    static {
        LINE_SEPARATOR = (String) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1()), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        return;
    L4:
        LINE_SEPARATOR = String.format("%n", new Object[0]);     // Catch: Exception -> L6
        return;
    L6:
        LINE_SEPARATOR = "\n";
    }

    public static char[] asCharArray(byte[] r4) {
        int r0 = r4.length;
        char[] r1 = new char[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = (char) (r4[r2] & 255);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String fromByteArray(byte[] r1) {
        return new String(asCharArray(r1));
    }

    public static String fromUTF8ByteArray(byte[] r3) {
        char[] r0 = new char[r3.length];
        int r4 = UTF8.transcodeToUTF16(r3, r0);
        if (r4 < 0) goto L7;
        return new String(r0, 0, r4);
    L7:
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    public static byte[] toByteArray(String r4) {
        int r0 = r4.length();
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = (byte) r4.charAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String toLowerCase(String r5) {
        char[] r0 = r5.toCharArray();
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 == r0.length) goto L11;
        char r3 = r0[r1];
        if ('A' > r3) goto L10;
        if ('Z' < r3) goto L10;
        r0[r1] = (char) ((r3 - 'A') + 97);
        r2 = true;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        if (r2 == true) goto L13;
        return r5;
    L13:
        return new String(r0);
    }

    public static void toUTF8ByteArray(char[] r6, OutputStream r7) {
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L29;
        char r1 = r6[r0];
        int r2 = r1;
        if (r1 >= 128) goto L9;
    L22:
        r7.write(r2);
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1 >= 2048) goto L13;
        int r3 = (r1 >> 6) | 192;
    L11:
        r7.write(r3);
        int r4 = r1;
    L21:
        r2 = (r4 & 63) | 128;
        goto L22
    L13:
        if (r1 >= 55296) goto L15;
    L27:
        r7.write((r1 >> '\f') | 224);
        r3 = ((r1 >> 6) & 63) | 128;
        goto L11
    L15:
        if (r1 > 57343) goto L27;
        r0 = r0 + 1;
        if (r0 >= r6.length) goto L26;
        char r5 = r6[r0];
        if (r1 > 56319) goto L24;
        int r8 = (((r1 & 1023) << 10) | (r5 & 1023)) + 65536;
        r7.write((r8 >> 18) | 240);
        r7.write(((r8 >> 12) & 63) | 128);
        r7.write(((r8 >> 6) & 63) | 128);
        r4 = r8;
        goto L21
    L24:
        throw new IllegalStateException("invalid UTF-16 codepoint");
    L26:
        throw new IllegalStateException("invalid UTF-16 codepoint");
    }

    public static byte[] toUTF8ByteArray(String r0) {
        return toUTF8ByteArray(r0.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        toUTF8ByteArray(r1, r0);     // Catch: IOException -> L6
        return r0.toByteArray();
    L7:
        throw new IllegalStateException("cannot encode string to byte array!");
    }

    public static String toUpperCase(String r5) {
        char[] r0 = r5.toCharArray();
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 == r0.length) goto L11;
        char r3 = r0[r1];
        if ('a' > r3) goto L10;
        if ('z' < r3) goto L10;
        r0[r1] = (char) ((r3 - 'a') + 65);
        r2 = true;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        if (r2 == true) goto L13;
        return r5;
    L13:
        return new String(r0);
    }
}
