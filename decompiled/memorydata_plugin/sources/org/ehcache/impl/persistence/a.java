package org.ehcache.impl.persistence;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes7.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f18099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Character> f18100b = null;

    static {
        f18099a = d.a(a.class);
        HashSet r0 = new HashSet();
        f18100b = r0;
        r0.add('/');
        r0.add('\\');
        r0.add(Character.valueOf(Typography.less));
        r0.add(Character.valueOf(Typography.greater));
        r0.add(':');
        r0.add(Character.valueOf(Typography.quote));
        r0.add('|');
        r0.add('?');
        r0.add('*');
        r0.add('.');
    }

    a() {
    }

    private static String a(String r5) {
        StringBuilder r0 = new StringBuilder();
        byte[] r6 = a().digest(r5.getBytes(StandardCharsets.UTF_8));
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r3 = r6[r2];
        r0.append(Integer.toHexString((r3 & 240) >>> 4));
        r0.append(Integer.toHexString(r3 & 15));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    static String a(String r8, boolean r9) {
        int r0 = r8.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L15;
        char r4 = r8.charAt(r3);
        if (r4 > ' ') goto L7;
    L13:
        r1.append('%');
        r1.append(String.format("%04x", new Object[]{Integer.valueOf(r4)}));
    L14:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 >= 127) goto L13;
        if (f18100b.contains(Character.valueOf(r4)) == true) goto L13;
        if (r4 == '%') goto L13;
        r1.append(r4);
        goto L14
    L15:
        if (r9 == false) goto L18;
        r1.append("_").append(a(r8));
    L18:
        return r1.toString();
    }

    private static MessageDigest a() {
        return MessageDigest.getInstance("SHA-1");
    L5:
        throw new AssertionError("All JDKs must have SHA-1");
    }
}
