package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w {
    public static yb2.a a() {
        yb2.a r0 = new yb2.a();
        r0.b = com.bytedance.android.live.liveinteract.f.a(2131108439, new s());
        r0.a = com.bytedance.android.live.liveinteract.f.a(2131108438, new t());
        r0.c = com.bytedance.android.live.liveinteract.f.a(2131108437, new u());
        r0.e = com.bytedance.android.live.liveinteract.f.a(2131108438, new v());
        r0.g = BuildConfig.FLAVOR;
        r0.j = false;
        return r0;
    }

    public static int b(int r6, b5 r7, b5 r8, yb2.a r9) {
        if (r9 != null) goto L4;
        r9 = new yb2.a();
    L4:
        boolean r0 = true;
        int r1 = 0;
        if (r7 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        PieceType r3 = PieceType.STRING;
        if (r6 != r3.getPieceType()) goto L16;
        if (r7 == null) goto L16;
        if (r7.isUseHeighLight() == false) goto L16;
    L18:
        if (r7 != null) goto L20;
    L19:
        int r10 = 0;
    L27:
        int r5 = r9.e;
        if (r6 != r3.getPieceType()) goto L31;
        int r11 = r9.d;
    L40:
        if (r8 == null) goto L49;
        String r13 = r8.getColor();
        if (TextUtils.isEmpty(r13) == true) goto L49;
        r1 = Color.parseColor(r13);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
    L49:
        if (r2 == false) goto L52;
        if (r10 == 0) goto L52;
        return r10;
    L52:
        if (r0 == false) goto L55;
        if (r5 == 0) goto L55;
        return r5;
    L55:
        if (r1 == 0) goto L60;
        if (r8 == null) goto L60;
        if (r8.isUseRemoteColor() == false) goto L60;
        return r1;
    L60:
        if (r11 == 0) goto L62;
        return r11;
    L62:
        if (r1 == 0) goto L64;
        return r1;
    L64:
        return -1;
    L31:
        if (r6 != PieceType.USER.getPieceType()) goto L34;
        r11 = r9.a;
        goto L40
    L34:
        if (r6 != PieceType.GIFT.getPieceType()) goto L37;
        r11 = r9.b;
        goto L40
    L37:
        if (r6 != PieceType.PATTERN_REF.getPieceType()) goto L39;
        r11 = r9.c;
        goto L40
    L39:
        r11 = r9.d;
        goto L40
    L20:
        String r14 = r7.getColor();
        if (TextUtils.isEmpty(r14) == true) goto L19;
        r10 = Color.parseColor(r14);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
    L16:
        r0 = false;
        goto L18
    L7:
        if (r7.isUseRemoteColor() == false) goto L9;
        r2 = true;
        goto L10
    }
}
