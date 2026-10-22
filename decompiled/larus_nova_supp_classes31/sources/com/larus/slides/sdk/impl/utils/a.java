package com.larus.slides.sdk.impl.utils;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(String r13) {
        HashMap r0 = new HashMap();
        if (r13 == null) goto L116;
        int r1 = r13.length() - 1;
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r4 > r1) goto L22;
        if (r5 == true) goto L9;
        int r7 = r4;
    L11:
        if (Intrinsics.compare(r13.charAt(r7), 32) > 0) goto L13;
        boolean r8 = true;
    L14:
        if (r5 == false) goto L15;
        if (r8 == false) goto L22;
        r1 = r1 - 1;
        goto L6
    L15:
        if (r8 == false) goto L16;
        r4 = r4 + 1;
        goto L6
    L16:
        r5 = true;
        goto L6
    L13:
        r8 = false;
        goto L14
    L9:
        r7 = r1;
    L22:
        if (r13.subSequence(r4, r1 + 1).toString().length() != 0) goto L24;
        boolean r2 = true;
    L25:
        if (r2 == true) goto L116;
        List r14 = new Regex("; ").split(r13, 0);
        if (r14.isEmpty() == true) goto L38;
        ListIterator r3 = r14.listIterator(r14.size());
    L31:
        if (r3.hasPrevious() == false) goto L38;
        if (((String) r3.previous()).length() != 0) goto L35;
        boolean r6 = true;
    L36:
        if (r6 == true) goto L31;
        List r15 = CollectionsKt.take(r14, r3.nextIndex() + 1);
    L39:
        String[] r16 = (String[]) r15.toArray(new String[0]);
        int r9 = r16.length;
        int r10 = 0;
    L40:
        if (r10 >= r9) goto L116;
        String r11 = r16[r10];
        int r12 = r11.length() - 1;
        int r17 = 0;
        boolean r18 = false;
    L42:
        if (r17 > r12) goto L58;
        if (r18 == true) goto L45;
        int r19 = r17;
    L47:
        if (Intrinsics.compare(r11.charAt(r19), 32) > 0) goto L49;
        boolean r110 = true;
    L50:
        if (r18 == false) goto L51;
        if (r110 == false) goto L58;
        r12 = r12 - 1;
        goto L42
    L51:
        if (r110 == false) goto L52;
        r17 = r17 + 1;
        goto L42
    L52:
        r18 = true;
        goto L42
    L49:
        r110 = false;
        goto L50
    L45:
        r19 = r12;
    L58:
        if (r11.subSequence(r17, r12 + 1).toString().length() != 0) goto L60;
        boolean r20 = true;
    L61:
        if (r20 == true) goto L115;
        int r21 = StringsKt.indexOf$default(r11, "=", 0, false, 6, null);
        if (r21 != (-1)) goto L82;
        int r22 = r11.length() - 1;
        int r23 = 0;
        boolean r24 = false;
    L66:
        if (r23 > r22) goto L81;
        if (r24 == true) goto L69;
        int r111 = r23;
    L71:
        if (Intrinsics.compare(r11.charAt(r111), 32) > 0) goto L73;
        boolean r112 = true;
    L74:
        if (r24 == false) goto L75;
        if (r112 == false) goto L81;
        r22 = r22 - 1;
        goto L66
    L75:
        if (r112 == false) goto L76;
        r23 = r23 + 1;
        goto L66
    L76:
        r24 = true;
        goto L66
    L73:
        r112 = false;
        goto L74
    L69:
        r111 = r22;
    L81:
        r0.put(r11.subSequence(r23, r22 + 1).toString(), "");
        goto L115
    L82:
        String r25 = r11.substring(0, r21);
        int r26 = r25.length() - 1;
        int r113 = 0;
        boolean r114 = false;
    L83:
        if (r113 > r26) goto L98;
        if (r114 == true) goto L86;
        int r115 = r113;
    L88:
        if (Intrinsics.compare(r25.charAt(r115), 32) > 0) goto L90;
        boolean r116 = true;
    L91:
        if (r114 == false) goto L92;
        if (r116 == false) goto L98;
        r26 = r26 - 1;
        goto L83
    L92:
        if (r116 == false) goto L93;
        r113 = r113 + 1;
        goto L83
    L93:
        r114 = true;
        goto L83
    L90:
        r116 = false;
        goto L91
    L86:
        r115 = r26;
    L98:
        String r27 = r25.subSequence(r113, r26 + 1).toString();
        String r28 = r11.substring(r21 + 1);
        int r29 = r28.length() - 1;
        int r30 = 0;
        boolean r117 = false;
    L99:
        if (r30 > r29) goto L114;
        if (r117 == true) goto L102;
        int r118 = r30;
    L104:
        if (Intrinsics.compare(r28.charAt(r118), 32) > 0) goto L106;
        boolean r119 = true;
    L107:
        if (r117 == false) goto L108;
        if (r119 == false) goto L114;
        r29 = r29 - 1;
        goto L99
    L108:
        if (r119 == false) goto L109;
        r30 = r30 + 1;
        goto L99
    L109:
        r117 = true;
        goto L99
    L106:
        r119 = false;
        goto L107
    L102:
        r118 = r29;
    L114:
        r0.put(r27, r28.subSequence(r30, r29 + 1).toString());
    L115:
        r10 = r10 + 1;
        goto L40
    L60:
        r20 = false;
        goto L61
    L35:
        r6 = false;
    L38:
        r15 = CollectionsKt.emptyList();
        goto L39
    L24:
        r2 = false;
    L116:
        return r0;
    }
}
