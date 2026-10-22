package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s0 implements am3.c<ProfileText> {
    public static ProfileText a(am3.g r19) throws Exception {
        ProfileText r1 = new ProfileText();
        r1.pieces = new ArrayList();
        long r2 = r19.c();
    L3:
        int r4 = r19.f();
        int r5 = -1;
        if (r4 == (-1)) goto L68;
        if (r4 != 1) goto L7;
        List<ProfileTextPiece> r6 = r1.pieces;
        ProfileTextPiece r7 = new ProfileTextPiece();
        long r8 = r19.c();
    L9:
        int r11 = r19.f();
        if (r11 == r5) goto L67;
        if (r11 == 1) goto L64;
        int r12 = 2;
        if (r11 == 2) goto L63;
        if (r11 != 3) goto L16;
        ProfileTextPieceString r13 = new ProfileTextPieceString();
        long r14 = r19.c();
    L38:
        int r15 = r19.f();
        if (r15 == r5) goto L62;
        if (r15 != 1) goto L42;
        ProfileTextFormat r16 = new ProfileTextFormat();
        long r17 = r19.c();
        ProfileText r18 = r1;
    L46:
        int r3 = r19.f();
        if (r3 == r5) goto L61;
        if (r3 != 1) goto L50;
        r16.fontType = r19.i();
    L60:
        r5 = -1;
        goto L46
    L50:
        if (r3 != 2) goto L52;
        r16.fontSize = r19.i();
        goto L60
    L52:
        if (r3 != 3) goto L54;
        r16.fontStyle = r19.i();
        goto L60
    L54:
        if (r3 == 4) goto L56;
        am3.h.e(r19);
        goto L60
    L56:
        r16.fontColor = am3.h.c(r19);
        goto L60
    L61:
        r19.d(r17);
        r13.format = r16;
        r1 = r18;
        r5 = -1;
        goto L38
    L42:
        if (r15 != 2) goto L43;
        r13.value = am3.h.c(r19);
        goto L38
    L43:
        am3.h.e(r19);
        goto L38
    L62:
        r19.d(r14);
        r7.stringValue = r13;
    L66:
        r5 = -1;
        goto L9
    L16:
        if (r11 != 4) goto L17;
        ProfileTextPieceImage r110 = new ProfileTextPieceImage();
        long r111 = r19.c();
    L19:
        int r112 = r19.f();
        if (r112 == r5) goto L36;
        if (r112 == 1) goto L34;
        if (r112 != r12) goto L23;
        ProfileImageFormat r113 = new ProfileImageFormat();
        long r114 = r111;
        long r115 = r19.c();
    L25:
        int r116 = r19.f();
        if (r116 == r5) goto L33;
        if (r116 != 1) goto L29;
        r113.imageRadius = Float.intBitsToFloat(r19.g());
        goto L25
    L29:
        if (r116 != 2) goto L30;
        r113.isImageFillet = am3.h.a(r19);
        goto L25
    L30:
        am3.h.e(r19);
        goto L25
    L33:
        r19.d(r115);
        r110.imageFormat = r113;
        r111 = r114;
    L35:
        r12 = 2;
        goto L19
    L23:
        am3.h.e(r19);
        goto L19
    L34:
        r110.imageModel = (py.k) vh7.f.a(r19, py.k.class);
        goto L35
    L36:
        r19.d(r111);
        r7.imageValue = r110;
        goto L9
    L17:
        am3.h.e(r19);
        goto L9
    L63:
        r7.alignment = r19.i();
    L65:
        r1 = r1;
        goto L66
    L64:
        r7.type = r19.i();
        goto L65
    L67:
        r19.d(r8);
        r6.add(r7);
        r1 = r1;
        goto L3
    L7:
        am3.h.e(r19);
        goto L3
    L68:
        ProfileText r117 = r1;
        r19.d(r2);
        return r117;
    }
}
