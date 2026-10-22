package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.keyboard.edittext2.utils.d;
import dab.c;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PreviewEntityLinkParser {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static n a(Context r14, final UrlInlinePreviewEntity r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "entity");
        final n r0 = new n();
        int r6 = UIUtils.getColor(r14, 2131106616);
        String r16 = r15.g;
        boolean r2 = true;
        if (r16 != null) goto L5;
    L8:
        boolean r17 = true;
    L10:
        if (r17 == false) goto L12;
    L14:
        String r4 = "";
        if (r15.h != 0) goto L17;
    L23:
        String r18 = r15.j;
        if (r18 != null) goto L26;
    L29:
        boolean r19 = true;
    L30:
        if (r19 == false) goto L32;
    L34:
        String r110 = r15.k;
        if (r110 != null) goto L37;
    L40:
        boolean r111 = true;
    L41:
        if (r111 == false) goto L43;
    L45:
        String r112 = r15.f;
        if (r112 != null) goto L48;
    L51:
        if (r2 == true) goto L57;
        String r3 = r15.f;
        if (r3 == null) goto L56;
        r4 = r3;
    L56:
        final c r113 = new c(2131255012, r6, r4, false);
    L65:
        LarkLinkExtend.f.b(new PreviewEntityLinkParser$parse$1(r0, r15, r113));
        return r0;
    L57:
        int r114 = r15.d;
        if (r114 == 0) goto L64;
        int r5 = r15.e;
        if (r5 == 0) goto L63;
        r6 = r5;
    L63:
        r113 = new c(r114, r6, "", false);
        goto L65
    L64:
        r113 = new dab.b(r15.c, 2131255012, true, r6, false, "");
        goto L65
    L48:
        if (r112.length() == 0) goto L51;
        r2 = false;
        goto L51
    L43:
        if (r15.m == false) goto L45;
        r113 = new dab.b("", 2131255012, true, r15.l, true, r15.k);
        goto L65
    L37:
        if (r110.length() == 0) goto L40;
        r111 = false;
        goto L41
    L32:
        if (r15.m == false) goto L34;
        r113 = new dab.b(r15.j, 2131255012, true, r15.l, true, "");
        goto L65
    L26:
        if (r18.length() == 0) goto L29;
        r19 = false;
        goto L30
    L17:
        if (r15.m == false) goto L23;
        if ((!d.a("messenger.im.disable_doubao_url_inline_icon_fix")) == false) goto L21;
        int r1 = r15.h;
    L22:
        r113 = new c(r1, r15.i, "", true);
        goto L65
    L21:
        r1 = r15.d;
        goto L22
    L12:
        if (r15.m == false) goto L14;
        r113 = new c(2131255012, r6, r15.g, true);
        goto L65
    L5:
        if (r16.length() == 0) goto L8;
        r17 = false;
        goto L10
    }
}
