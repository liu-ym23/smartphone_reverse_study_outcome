package com.larus.bmhome.chat;

import android.net.Uri;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(IconImage r5, IconImage r6) {
        if (r5 != null) goto L6;
        if (r6 != null) goto L6;
        return true;
    L6:
        if (r5 == null) goto L58;
        if (r6 == null) goto L60;
        ImageObj r1 = r5.imageThumb;
        String r2 = null;
        if (r1 == null) goto L12;
        String r3 = r1.url;
    L13:
        ImageObj r4 = r6.imageThumb;
        if (r4 == null) goto L16;
        String r7 = r4.url;
    L18:
        if (com.larus.utils.o0.d(r7) == false) goto L20;
    L47:
        if (r7 == null) goto L51;
        Uri r8 = com.larus.utils.y0.j(r7);
        if (r8 == null) goto L51;
        String r9 = r8.getPath();
    L52:
        if (r3 == null) goto L57;
        Uri r10 = com.larus.utils.y0.j(r3);
        if (r10 == null) goto L57;
        r2 = r10.getPath();
    L57:
        return Intrinsics.areEqual(r9, r2);
    L51:
        r9 = null;
        goto L52
    L20:
        if (com.larus.utils.o0.d(r3) == true) goto L47;
        ImageObj r11 = r6.imageOri;
        if (r11 == null) goto L25;
        String r12 = r11.url;
    L26:
        ImageObj r13 = r5.imageOri;
        if (r13 == null) goto L29;
        String r14 = r13.url;
    L31:
        if (com.larus.utils.o0.d(r12) == false) goto L33;
    L36:
        if (r12 == null) goto L40;
        Uri r15 = com.larus.utils.y0.j(r12);
        if (r15 == null) goto L40;
        String r16 = r15.getPath();
    L41:
        if (r14 == null) goto L46;
        Uri r17 = com.larus.utils.y0.j(r14);
        if (r17 == null) goto L46;
        r2 = r17.getPath();
    L46:
        return Intrinsics.areEqual(r16, r2);
    L40:
        r16 = null;
        goto L41
    L33:
        if (com.larus.utils.o0.d(r14) == true) goto L36;
        return true;
    L29:
        r14 = null;
        goto L31
    L25:
        r12 = null;
        goto L26
    L16:
        r7 = null;
        goto L18
    L12:
        r3 = null;
        goto L13
    L60:
        return false;
    L58:
        return false;
    }
}
