package com.lynx.tasm.utils;

import android.util.Pair;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public c() {
    }

    public static boolean a(String r1) {
        if (r1.endsWith(".woff") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.endsWith(".woff2") == true) goto L8;
        return false;
    }

    public static String d(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r6.length()) goto L16;
        if (r6.charAt(r1) == ' ') goto L14;
        if (r6.charAt(r1) == '\"') goto L14;
        if (r6.charAt(r1) != '\'') goto L16;
    L14:
        r1 = r1 + 1;
    L16:
        if (r1 < r6.length()) goto L18;
        return null;
    L18:
        int r0 = r6.length() - 1;
    L19:
        if (r0 <= r1) goto L28;
        if (r6.charAt(r0) == ' ') goto L26;
        if (r6.charAt(r0) == '\"') goto L26;
        if (r6.charAt(r0) != '\'') goto L28;
    L26:
        r0 = r0 - 1;
    L28:
        return r6.substring(r1, r0 + 1);
    }

    public static String e(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = r5.length();
        if (r5.startsWith("'") == false) goto L8;
    L11:
        int r3 = 1;
    L13:
        if (r5.endsWith("'") == false) goto L15;
    L16:
        r1 = r1 - 1;
    L17:
        if (r3 <= r1) goto L20;
        return null;
    L20:
        return r5.substring(r3, r1);
    L15:
        if (r5.endsWith("\"") == false) goto L17;
    L8:
        if (r5.startsWith("\"") == true) goto L11;
        r3 = 0;
        goto L13
    }

    public static FontFace b(LynxContext r10, String r11) {
        if (r11 != null) goto L6;
        c(r10, "Font-family is empty", NameKeys.UnloadStrategy_No_Strategy);
        return null;
    L6:
        Map r12 = r10.getFontFaces(r11);
        if (r12 != null) goto L9;
        return null;
    L9:
        FontFace r0 = new FontFace();
        Iterator r13 = r12.values().iterator();
        boolean r2 = false;
    L11:
        if (r13.hasNext() == false) goto L71;
        Object r3 = r13.next();
        if ((r3 instanceof String) == false) goto L14;
        String r4 = (String) r3;
        int r5 = r4.length();
        int r6 = 0;
    L16:
        boolean r7 = true;
        if (r6 >= r5) goto L65;
        int r8 = r4.indexOf("url(", r6);
        int r9 = r4.indexOf("local(", r6);
        if (r8 != (-1)) goto L23;
        if (r9 == (-1)) goto L65;
    L23:
        if (r8 == (-1)) goto L44;
        if (r9 == (-1)) goto L44;
        if (r8 >= r9) goto L35;
        int r14 = r4.indexOf(")", r8);
        if (r14 == (-1)) goto L64;
        int r15 = r14 + 2;
        String r16 = e(r4.substring(r8 + 4, r14));
        if (r16 == null) goto L64;
        if (a(r16) == false) goto L34;
    L61:
        r6 = r15;
        r2 = true;
        goto L16
    L34:
        List<Pair<FontFace.TYPE, String>> r17 = r0.a;
        ArrayList r18 = (ArrayList) r17;
        r18.add(new Pair(FontFace.TYPE.URL, r16));
    L63:
        r6 = r15;
    L64:
        r7 = false;
        goto L65
    L35:
        int r19 = r4.indexOf(")", r9);
        if (r19 == (-1)) goto L64;
        r15 = r19 + 2;
        String r20 = e(r4.substring(r9 + 6, r19));
        if (r20 == null) goto L64;
        if (a(r20) == true) goto L61;
        List<Pair<FontFace.TYPE, String>> r21 = r0.a;
        ArrayList r22 = (ArrayList) r21;
        r22.add(new Pair(FontFace.TYPE.LOCAL, r20));
    L44:
        if (r8 == (-1)) goto L54;
        int r23 = r4.indexOf(")", r8);
        if (r23 == (-1)) goto L64;
        r15 = r23 + 2;
        String r24 = e(r4.substring(r8 + 4, r23));
        if (r24 == null) goto L64;
        if (a(r24) == true) goto L61;
        List<Pair<FontFace.TYPE, String>> r25 = r0.a;
        ArrayList r26 = (ArrayList) r25;
        r26.add(new Pair(FontFace.TYPE.URL, r24));
        goto L63
    L54:
        int r27 = r4.indexOf(")", r9);
        if (r27 == (-1)) goto L64;
        r15 = r27 + 2;
        String r28 = e(r4.substring(r9 + 6, r27));
        if (r28 == null) goto L64;
        if (a(r28) == true) goto L61;
        List<Pair<FontFace.TYPE, String>> r29 = r0.a;
        ArrayList r30 = (ArrayList) r29;
        r30.add(new Pair(FontFace.TYPE.LOCAL, r28));
    L65:
        if (r7 == true) goto L67;
        c(r10, "Src format error", r4);
    L67:
        if (r2 == false) goto L11;
        if (((ArrayList) r0.a).isEmpty() == false) goto L11;
        r10.reportResourceError(r4, LynxResourceModule.FONT_TYPE, new LynxError(30204, "The woff file format is not supported on Android"));
        LLog.e("FontFaceParser", "The woff file format is not supported on Android,src:".concat(r4));
        goto L11
    L14:
        c(r10, "Src is not string", r3.toString());
        goto L11
    L71:
        return r0;
    }

    public static void c(LynxContext r2, String r3, String r4) {
        r2.reportResourceError(r4, LynxResourceModule.FONT_TYPE, new LynxError(30201, r3));
        LLog.e("FontFaceParser", r3 + ",src:" + r4);
    }
}
