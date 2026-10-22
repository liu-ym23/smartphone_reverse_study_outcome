package com.cronutils.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <T> T a(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    private static String a(String r6, Object... r7) {
        String r8 = String.valueOf(r6);
        StringBuilder r0 = new StringBuilder(r8.length() + (r7.length * 16));
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r7.length) goto L9;
        int r3 = r8.indexOf("%s", r2);
        if (r3 == (-1)) goto L9;
        r0.append(r8.substring(r2, r3));
        r0.append(r7[r1]);
        r2 = r3 + 2;
        r1 = r1 + 1;
    L9:
        r0.append(r8.substring(r2));
        if (r1 >= r7.length) goto L17;
        r0.append(" [");
        int r9 = r1 + 1;
        r0.append(r7[r1]);
    L13:
        if (r9 >= r7.length) goto L15;
        r0.append(", ");
        r0.append(r7[r9]);
        r9 = r9 + 1;
        goto L13
    L15:
        r0.append(']');
    L17:
        return r0.toString();
    }

    public static <T extends Collection<?>> T a(T r2, Object r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        if (r4.isEmpty() == true) goto L8;
        return r4;
    L8:
        throw new IllegalArgumentException(String.valueOf(r3));
    L10:
        throw new NullPointerException(String.valueOf(r3));
    }

    public static void a(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static void a(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(a(r1, r2));
    }
}
