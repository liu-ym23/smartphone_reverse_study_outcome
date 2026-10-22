package com.larus.drive.sdk.impl.utils;

import com.larus.common_ui.icon.CommonFileIconType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d implements mbb.d {
    public d() {
    }

    public final Integer a(int r6, Long r7) {
        int r0 = f.a;
        if (r6 != 8) goto L6;
        int r8 = 2131255049;
    L33:
        return Integer.valueOf(r8);
    L6:
        if (r6 != 113) goto L13;
        if (r7 == null) goto L13;
        if (r7.longValue() != 147) goto L13;
        r8 = 2131254741;
    L13:
        if (r6 != 2) goto L15;
    L30:
        CommonFileIconType r9 = CommonFileIconType.AI_DOC;
    L31:
        h19.b.a.getClass();
        r8 = h19.b.a(r9);
        goto L33
    L15:
        if (r6 != 3) goto L17;
        r9 = CommonFileIconType.AI_SHEET;
        goto L31
    L17:
        if (r6 != 11) goto L19;
        r9 = CommonFileIconType.MINDNOTE;
        goto L31
    L19:
        if (r6 == 22) goto L30;
        if (r6 == 30) goto L27;
        if (r6 != 113) goto L24;
    L26:
        r9 = CommonFileIconType.MIAODA;
        goto L31
    L24:
        if (r6 == 114) goto L26;
        r9 = CommonFileIconType.UNKNOWN;
        goto L31
    L27:
        r9 = CommonFileIconType.AI_SLIDES;
        goto L31
    }
}
