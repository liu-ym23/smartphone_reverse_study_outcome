package com.larus.bmhome.chat.nestedmenu;

import android.view.View;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.bmhome.view.screenmenu.l0;
import di8.b0;
import di8.d0;
import di8.e0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final l0 a(d0 r45) {
        Intrinsics.checkNotNullParameter(r45, "<this>");
        b0 r0 = r45.getCenter();
        NestedMenuRightModel r2 = r45.getRight();
        String r3 = r0.a;
        if (r3 != null) goto L5;
        r3 = r2.c;
    L5:
        String r7 = r3;
        if (r7 == null) goto L9;
    L11:
        Boolean r4 = r0.k;
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r4, r5) == false) goto L16;
        String r6 = r0.l;
        if (r6 != null) goto L17;
        r6 = r0.i;
    L17:
        String r25 = r6;
        if (Intrinsics.areEqual(r0.k, r5) == false) goto L20;
        String r8 = r0.n;
    L21:
        String r26 = r8;
        CharSequence r9 = r0.b;
        boolean r15 = r45.a();
        String r10 = r0.c;
        Integer r11 = r0.d;
        Integer r14 = r0.o;
        Integer r12 = r45.getLeft().a;
        String r13 = r45.getLeft().b;
        boolean r16 = r2.a;
        Integer r17 = r2.e;
        if (r17 != null) goto L26;
        if (r16 == false) goto L27;
        r17 = Integer.valueOf(v19.c.b(2130971676, null, 2131241038));
        goto L26
    L27:
        Integer r18 = null;
    L28:
        String r19 = r2.f;
        boolean r110 = r45.getEnabled();
        Float r28 = r45.getAlpha();
        String r20 = r0.e;
        String r1 = r0.g;
        if (r45.isHeader() == false) goto L32;
        MenuItemType r29 = MenuItemType.HEADER;
    L36:
        final Function0<View> r21 = r45.getLeft().f;
        if (r21 == null) goto L39;
        e0 r34 = new e0(r21);
    L41:
        return new l0(0, 0, r7, r9, r10, r11, null, r12, r13, r16, r15, null, r18, r19, r110, false, null, null, null, r20, r25, r26, r1, r28, r29, null, null, null, null, r34, r2.c, r2.d, null, r14, r2.g, null, null, false, 537872450, DoraCallStateCode.DOUBAO_CMD_14);
    L39:
        r34 = 0;
        goto L41
    L32:
        if (r2.b != NestedMenuRightModel.Style.BUTTON) goto L34;
        MenuItemType r22 = MenuItemType.BUTTON;
    L35:
        r29 = r22;
        goto L36
    L34:
        r22 = MenuItemType.DEFAULT;
    L26:
        r18 = r17;
        goto L28
    L20:
        r8 = r0.j;
        goto L21
    L16:
        r6 = r0.i;
        goto L17
    L9:
        if (r0.b != null) goto L11;
        return null;
    }
}
