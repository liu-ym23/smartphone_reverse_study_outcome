package com.larus.doc.impl;

import android.view.View;
import com.larus.office.permission.DocPermissionFullData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r1 implements com.larus.office.base.component.permission.a.a {
    public final /* synthetic */ DocFragmentV2 a;

    public r1(DocFragmentV2 r1) {
        this.a = r1;
    }

    public final void a(DocPermissionFullData r9) {
        Intrinsics.checkNotNullParameter(r9, "permission");
        DocFragmentV2 r10 = this.a;
        int r0 = DocFragmentV2.O2;
        r10.X90();
        com.larus.office.base.component.permission.a r1 = r10.Ea0();
        if (r1 == null) goto L5;
        boolean r2 = r1.k9();
    L6:
        if (r1 == null) goto L8;
        boolean r3 = r1.canRead();
    L9:
        if (r1 == null) goto L11;
        boolean r4 = r1.p6();
    L12:
        if (r1 == null) goto L14;
        boolean r5 = r1.isOwner();
    L15:
        if (r1 == null) goto L17;
        boolean r6 = r1.canEdit();
    L18:
        if (r1 == null) goto L20;
        boolean r7 = r1.canCopy();
    L21:
        if (r2 == true) goto L26;
        if (r3 == false) goto L85;
        if (r4 == true) goto L26;
        if (r5 == true) goto L26;
        return;
    L85:
        return;
    L26:
        r10.Ba0(true);
        if (r6 == true) goto L41;
        if (r10.da0() != 1) goto L35;
        View r8 = r10.q;
        if (r8 == null) goto L53;
        View r11 = r8.findViewById(2131369314);
        if (r11 == null) goto L53;
        com.larus.office.base.utils.w.b(r11);
    L53:
        if (r7 == true) goto L67;
        if (r10.da0() != 1) goto L61;
        View r12 = r10.q;
        if (r12 == null) goto L78;
        View r13 = r12.findViewById(2131369311);
        if (r13 == null) goto L78;
        com.larus.office.base.utils.w.b(r13);
    L78:
        if (r6 == true) goto L83;
        if (r7 == true) goto L83;
        View r14 = r10.q;
        if (r14 == null) goto L86;
        com.larus.utils.e1.o(r14);
        return;
    L86:
        return;
    L83:
        DocFragment.za0(r10, false, 3);
        return;
    L61:
        View r15 = r10.q;
        if (r15 == null) goto L78;
        View r16 = r15.findViewById(2131369311);
        if (r16 == null) goto L78;
        r16.setAlpha(0.5f);
        goto L78
    L67:
        if (r10.da0() != 1) goto L73;
        View r17 = r10.q;
        if (r17 == null) goto L78;
        View r18 = r17.findViewById(2131369311);
        if (r18 == null) goto L78;
        com.larus.office.base.utils.w.a(r18);
        goto L78
    L73:
        View r20 = r10.q;
        if (r20 == null) goto L78;
        View r21 = r20.findViewById(2131369311);
        if (r21 == null) goto L78;
        r21.setAlpha(1.0f);
        goto L78
    L35:
        View r22 = r10.q;
        if (r22 == null) goto L53;
        View r23 = r22.findViewById(2131369314);
        if (r23 == null) goto L53;
        r23.setAlpha(0.5f);
        goto L53
    L41:
        if (r10.da0() != 1) goto L47;
        View r24 = r10.q;
        if (r24 == null) goto L53;
        View r25 = r24.findViewById(2131369314);
        if (r25 == null) goto L53;
        com.larus.office.base.utils.w.a(r25);
        goto L53
    L47:
        View r26 = r10.q;
        if (r26 == null) goto L53;
        View r27 = r26.findViewById(2131369314);
        if (r27 == null) goto L53;
        r27.setAlpha(1.0f);
        goto L53
    L20:
        r7 = false;
        goto L21
    L17:
        r6 = false;
        goto L18
    L14:
        r5 = false;
        goto L15
    L11:
        r4 = false;
        goto L12
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}
