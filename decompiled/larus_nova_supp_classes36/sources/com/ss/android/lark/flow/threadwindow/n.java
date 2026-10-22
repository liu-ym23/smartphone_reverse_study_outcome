package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n {
    public static final boolean a(Message r6) {
        String r0 = r6.getRootId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L54;
        String r2 = r6.getParentId();
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L56;
        String r4 = r6.getThreadId();
        if (r4 != null) goto L22;
    L52:
        return true;
    L22:
        if (r4.length() <= 0) goto L24;
        boolean r5 = true;
    L25:
        String r7 = null;
        if (r5 == true) goto L29;
        r4 = null;
    L29:
        if (r4 == null) goto L52;
        String r8 = r6.getId();
        if (r8 != null) goto L34;
    L39:
        r8 = null;
    L40:
        String r9 = r6.getcId();
        if (r9 == null) goto L49;
        if (r9.length() <= 0) goto L45;
        boolean r10 = true;
    L46:
        if (r10 == false) goto L49;
        r7 = r9;
        goto L49
    L45:
        r10 = false;
    L49:
        if (Intrinsics.areEqual(r4, r8) == true) goto L52;
        if (Intrinsics.areEqual(r4, r7) == true) goto L52;
        return false;
    L34:
        if (r8.length() <= 0) goto L36;
        boolean r11 = true;
    L37:
        if (r11 == false) goto L39;
    L36:
        r11 = false;
        goto L37
    L24:
        r5 = false;
        goto L25
    L56:
        return false;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
        goto L17
    L54:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final String b(String r3) {
        if (r3 == null) goto L13;
        boolean r1 = false;
        if (r3.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
    L11:
        if (r1 == false) goto L13;
        return r3;
    L9:
        if (Intrinsics.areEqual(r3, "null") == true) goto L11;
        r1 = true;
        goto L11
    L6:
        r0 = false;
    L13:
        return null;
    }
}
