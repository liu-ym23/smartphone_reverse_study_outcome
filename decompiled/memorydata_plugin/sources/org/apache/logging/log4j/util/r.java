package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public final class r {
    private static int a(StringBuilder r1, int r2, char r3) {
        int r0 = r2 - 1;
        r1.setCharAt(r2, r3);
        int r4 = r0 - 1;
        r1.setCharAt(r0, '\\');
        return r4;
    }

    public static StringBuilder a(StringBuilder r1, Object r2) {
        return r1.append(Typography.quote).append(r2).append(Typography.quote);
    }

    public static StringBuilder a(StringBuilder r0, String r1, Object r2) {
        return r0.append(r1).append('=').append(Typography.quote).append(r2).append(Typography.quote);
    }

    public static void a(StringBuilder r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.capacity() <= r2) goto L8;
        r1.setLength(r2);
        r1.trimToSize();
        return;
    }

    public static void b(StringBuilder r8, int r9) {
        int r0 = 0;
    L4:
        if (r9 >= r8.length()) goto L16;
        char r1 = r8.charAt(r9);
        if (r1 == '\f') goto L14;
        if (r1 == '\r') goto L14;
        if (r1 == '\"') goto L14;
        if (r1 == '\\') goto L14;
        switch(r1) {
            case 8: goto L14;
            case 9: goto L14;
            case 10: goto L14;
            default: goto L12;
        };
    L12:
        if (Character.isISOControl(r1) == false) goto L15;
        r0 = r0 + 5;
    L15:
        r9 = r9 + 1;
    L14:
        r0 = r0 + 1;
        goto L15
    L16:
        int r10 = r8.length() - 1;
        r8.setLength(r8.length() + r0);
        int r2 = r8.length() - 1;
    L17:
        if (r2 <= r10) goto L35;
        char r3 = r8.charAt(r10);
        if (r3 == '\f') goto L33;
        if (r3 == '\r') goto L32;
        if (r3 == '\"') goto L31;
        if (r3 == '\\') goto L31;
        switch(r3) {
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            default: goto L25;
        };
    L28:
        r3 = 'n';
        goto L31
    L29:
        r3 = 't';
        goto L31
    L30:
        r3 = 'b';
        goto L31
    L25:
        if (Character.isISOControl(r3) == false) goto L27;
        int r6 = r2 - 1;
        r8.setCharAt(r2, b.a(r3 & 15));
        int r4 = r6 - 1;
        r8.setCharAt(r6, b.a((r3 & 240) >> 4));
        int r5 = r4 - 1;
        r8.setCharAt(r4, '0');
        int r7 = r5 - 1;
        r8.setCharAt(r5, '0');
        int r11 = r7 - 1;
        r8.setCharAt(r7, 'u');
        r2 = r11 - 1;
        r8.setCharAt(r11, '\\');
    L34:
        r10 = r10 - 1;
        goto L17
    L27:
        r8.setCharAt(r2, r3);
        r2 = r2 - 1;
    L31:
        r2 = a(r8, r2, r3);
        goto L34
    L32:
        r3 = 'r';
        goto L31
    L33:
        r3 = 'f';
        goto L31
    }

    public static void b(StringBuilder r1, Object r2) {
        if (c(r1, r2) == true) goto L6;
        r1.append(r2);
        return;
    }

    public static void c(StringBuilder r11, int r12) {
        int r0 = 0;
    L4:
        if (r12 >= r11.length()) goto L16;
        char r1 = r11.charAt(r12);
        if (r1 == '\"') goto L14;
        if (r1 == '<') goto L13;
        if (r1 == '>') goto L13;
        if (r1 == '&') goto L12;
        if (r1 == '\'') goto L14;
    L15:
        r12 = r12 + 1;
        goto L4
    L12:
        r0 = r0 + 4;
    L13:
        r0 = r0 + 3;
    L14:
        r0 = r0 + 5;
        goto L15
    L16:
        int r13 = r11.length() - 1;
        r11.setLength(r11.length() + r0);
        int r2 = r11.length() - 1;
    L17:
        if (r2 <= r13) goto L34;
        char r3 = r11.charAt(r13);
        if (r3 == '\"') goto L30;
        if (r3 == '<') goto L29;
        if (r3 != '>') goto L23;
        int r4 = r2 - 1;
        r11.setCharAt(r2, ';');
        int r5 = r4 - 1;
        r11.setCharAt(r4, 't');
        int r6 = r5 - 1;
        char r7 = 'g';
    L31:
        r11.setCharAt(r5, r7);
    L32:
        r2 = r6 - 1;
        r11.setCharAt(r6, Typography.amp);
    L33:
        r13 = r13 - 1;
        goto L17
    L23:
        if (r3 == '&') goto L27;
        if (r3 == '\'') goto L26;
        r11.setCharAt(r2, r3);
        r2 = r2 - 1;
        goto L33
    L26:
        int r8 = r2 - 1;
        r11.setCharAt(r2, ';');
        int r9 = r8 - 1;
        r11.setCharAt(r8, 's');
        int r10 = r9 - 1;
        r11.setCharAt(r9, 'o');
        int r14 = r10 - 1;
        r11.setCharAt(r10, 'p');
        r6 = r14 - 1;
        r11.setCharAt(r14, 'a');
        goto L32
    L27:
        int r15 = r2 - 1;
        r11.setCharAt(r2, ';');
        int r16 = r15 - 1;
        r11.setCharAt(r15, 'p');
        int r17 = r16 - 1;
        r11.setCharAt(r16, 'm');
        int r18 = r17 - 1;
        r11.setCharAt(r17, 'a');
        r11.setCharAt(r18, Typography.amp);
        r2 = r18 - 1;
        goto L33
    L29:
        int r19 = r2 - 1;
        r11.setCharAt(r2, ';');
        r5 = r19 - 1;
        r11.setCharAt(r19, 't');
        r6 = r5 - 1;
        r7 = 'l';
        goto L31
    L30:
        int r20 = r2 - 1;
        r11.setCharAt(r2, ';');
        int r21 = r20 - 1;
        r11.setCharAt(r20, 't');
        int r22 = r21 - 1;
        r11.setCharAt(r21, 'o');
        r5 = r22 - 1;
        r11.setCharAt(r22, 'u');
        r6 = r5 - 1;
        r7 = 'q';
        goto L31
    }

    public static boolean c(StringBuilder r2, Object r3) {
        if (r3 != null) goto L5;
    L40:
        r2.append((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L40;
        if (ZeusTransformUtils.instanceOf(r3, q.class) == false) goto L11;
        ((q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.memorydata.plugin")).formatTo(r2);
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, CharSequence.class) == false) goto L14;
        r2.append((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        return true;
    L14:
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L18;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L16:
        r2.append(r4);
        return true;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, Long.class) == false) goto L21;
        r2.append(((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin")).longValue());
        return true;
    L21:
        if (ZeusTransformUtils.instanceOf(r3, Double.class) == false) goto L24;
        r2.append(((Double) ZeusTransformUtils.preCheckCast(r3, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return true;
    L24:
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L27;
        r2.append(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return true;
    L27:
        if (ZeusTransformUtils.instanceOf(r3, Character.class) == false) goto L30;
        r2.append(((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin")).charValue());
        return true;
    L30:
        if (ZeusTransformUtils.instanceOf(r3, Short.class) == false) goto L33;
        r4 = ((Short) ZeusTransformUtils.preCheckCast(r3, Short.class, "com.obric.memorydata.plugin")).shortValue();
        goto L16
    L33:
        if (ZeusTransformUtils.instanceOf(r3, Float.class) == false) goto L36;
        r2.append(((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return true;
    L36:
        if (ZeusTransformUtils.instanceOf(r3, Byte.class) == false) goto L38;
        r4 = ((Byte) ZeusTransformUtils.preCheckCast(r3, Byte.class, "com.obric.memorydata.plugin")).byteValue();
        goto L16
    L38:
        return false;
    }
}
