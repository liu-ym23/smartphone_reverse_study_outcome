package com.larus.uaigc.createpage.component.sendmessage;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r4, "content://", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean b(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r4, "file://", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static s0 d(String r2, String r3) {
        if (a(r2) == false) goto L9;
        CreationPendingResourceInputType r0 = CreationPendingResourceInputType.CONTENT_URI;
        if (r2 != null) goto L37;
        r2 = "";
    L37:
        return new s0(r0, r2);
    L9:
        if (b(r2) == false) goto L14;
        CreationPendingResourceInputType r1 = CreationPendingResourceInputType.FILE_URI;
        if (r2 != null) goto L38;
        r2 = "";
    L38:
        return new s0(r1, r2);
    L14:
        if (r2 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L23;
        return new s0(CreationPendingResourceInputType.LOCAL_PATH, r2);
    L23:
        if (a(r3) == false) goto L30;
        CreationPendingResourceInputType r5 = CreationPendingResourceInputType.CONTENT_URI;
        if (r3 != null) goto L27;
        r3 = "";
    L27:
        s0 r6 = new s0(r5, r3);
    L40:
        return r6;
    L30:
        if (b(r3) == false) goto L36;
        CreationPendingResourceInputType r7 = CreationPendingResourceInputType.FILE_URI;
        if (r3 != null) goto L34;
        r3 = "";
    L34:
        r6 = new s0(r7, r3);
        goto L40
    L36:
        return s0.c;
    L16:
        if (StringsKt.isBlank(r2) == true) goto L19;
        r4 = false;
        goto L20
    }

    public static s0 c(String r3, String r4, String r5, String r6) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L53;
        if (r4 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L21;
        s0 r8 = new s0(CreationPendingResourceInputType.REMOTE_URL, r4);
    L54:
        return r8;
    L21:
        if (a(r5) == false) goto L27;
        CreationPendingResourceInputType r9 = CreationPendingResourceInputType.CONTENT_URI;
        if (r5 != null) goto L25;
        r5 = "";
    L25:
        r8 = new s0(r9, r5);
        goto L54
    L27:
        if (b(r5) == false) goto L32;
        CreationPendingResourceInputType r10 = CreationPendingResourceInputType.FILE_URI;
        if (r5 != null) goto L31;
        r5 = "";
    L31:
        r8 = new s0(r10, r5);
        goto L54
    L32:
        if (r5 != null) goto L34;
    L37:
        if (r0 == true) goto L40;
        return new s0(CreationPendingResourceInputType.LOCAL_PATH, r5);
    L40:
        if (a(r6) == false) goto L46;
        CreationPendingResourceInputType r11 = CreationPendingResourceInputType.CONTENT_URI;
        if (r6 != null) goto L44;
        r6 = "";
    L44:
        r8 = new s0(r11, r6);
        goto L54
    L46:
        if (b(r6) == false) goto L52;
        CreationPendingResourceInputType r12 = CreationPendingResourceInputType.FILE_URI;
        if (r6 != null) goto L50;
        r6 = "";
    L50:
        r8 = new s0(r12, r6);
        goto L54
    L52:
        return s0.c;
    L34:
        if (StringsKt.isBlank(r5) == true) goto L37;
        r0 = false;
        goto L37
    L13:
        if (StringsKt.isBlank(r4) == true) goto L16;
        r7 = false;
        goto L17
    L53:
        return new s0(CreationPendingResourceInputType.TOS_KEY, r3);
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r2 = false;
        goto L9
    }
}
