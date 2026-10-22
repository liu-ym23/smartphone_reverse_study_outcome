package com.obric.audio.enroll.sidauth;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "logTag");
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        FLogger.a.i(r9, "isAsrTextLongEnough false: empty text");
        return false;
    L12:
        StringBuilder r3 = new StringBuilder(r8.length());
        int r4 = 0;
    L14:
        if (r4 >= r8.length()) goto L33;
        int r5 = r8.codePointAt(r4);
        int r6 = Character.getType(r5);
        if (Character.isWhitespace(r5) == false) goto L18;
    L21:
        boolean r7 = true;
    L22:
        byte r10 = (byte) r6;
        if (r10 != 29) goto L25;
    L28:
        boolean r11 = true;
    L29:
        if (r7 == true) goto L32;
        if (r11 == true) goto L32;
        r3.appendCodePoint(r5);
    L32:
        r4 = r4 + Character.charCount(r5);
        goto L14
    L25:
        if (r10 == 30) goto L28;
        switch(r10) {
            case 20: goto L28;
            case 21: goto L28;
            case 22: goto L28;
            case 23: goto L28;
            case 24: goto L28;
            default: goto L27;
        };
    L27:
        r11 = false;
        goto L29
    L18:
        if (Character.isSpaceChar(r5) == true) goto L21;
        r7 = false;
        goto L22
    L33:
        String r12 = r3.toString();
        SidAuthSessionService.a.getClass();
        Lazy r13 = SidAuthSessionService.b;
        if (StringsKt.startsWith$default(r12, (String) r13.getValue(), false, 2, null) == false) goto L36;
        String r14 = StringsKt.removePrefix(r12, (String) r13.getValue());
    L37:
        int r15 = r14.codePointCount(0, r14.length());
        FLogger.a.i(r9, "isAsrTextLongEnough cleanedLen=" + r12.length() + " trimmedLen=" + r14.length() + " codePoints=" + r15);
        if (r15 >= 3) goto L46;
        return false;
    L46:
        return true;
    L36:
        r14 = r12;
        goto L37
    L5:
        if (r8.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
