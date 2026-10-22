package com.larus.drive.sdk.impl.utils;

import com.larus.common_ui.icon.CommonFileIconType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements mbb.e {
    public e() {
    }

    public final Integer a(int r2) {
        int r0 = f.a;
        if (r2 != 2) goto L5;
    L24:
        CommonFileIconType r3 = CommonFileIconType.AI_DOC;
    L25:
        h19.b.a.getClass();
        return h19.b.b(r3);
    L5:
        if (r2 != 3) goto L7;
        r3 = CommonFileIconType.AI_SHEET;
        goto L25
    L7:
        if (r2 != 8) goto L9;
        r3 = CommonFileIconType.BITABLE;
        goto L25
    L9:
        if (r2 != 11) goto L11;
        r3 = CommonFileIconType.MINDNOTE;
        goto L25
    L11:
        if (r2 == 22) goto L24;
        if (r2 != 30) goto L15;
        r3 = CommonFileIconType.AI_SLIDES;
        goto L25
    L15:
        if (r2 != 113) goto L17;
    L19:
        r3 = CommonFileIconType.MIAODA;
        goto L25
    L17:
        if (r2 == 114) goto L19;
        return null;
    }
}
