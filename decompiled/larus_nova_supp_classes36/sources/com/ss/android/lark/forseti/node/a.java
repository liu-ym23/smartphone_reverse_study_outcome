package com.ss.android.lark.forseti.node;

import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.api.ui.c {
    public Boolean a;
    public final /* synthetic */ ForsetiNode b;

    public a(ForsetiNode r1) {
        this.b = r1;
        this.a = Boolean.FALSE;
    }

    public final void a(ForsetiNodeMode r7) {
        Intrinsics.checkNotNullParameter(r7, "mode");
        Boolean r0 = this.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        ForsetiNodeMode r2 = ForsetiNodeMode.INVISIBLE_R;
        boolean r3 = true;
        if (r7 != r2) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (Intrinsics.areEqual(r0, Boolean.valueOf(r5)) == false) goto L11;
        return;
    L11:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7 != r2) goto L14;
    L16:
        r3 = false;
    L17:
        Boolean r8 = Boolean.valueOf(r3);
        this.a = r8;
        ForsetiNodeFragment r1 = null;
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L29;
        ForsetiNodeFragment r9 = this.b.c;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L23:
        ForsetiNodePiece r10 = ForsetiNodeFragment.S90(r1.d);
        if (r10 == null) goto L26;
        r10.onStart();
    L26:
        ForsetiNodePiece r11 = ForsetiNodeFragment.S90(r1.d);
        if (r11 == null) goto L40;
        r11.onResume();
        return;
    L40:
        return;
    L22:
        r1 = r9;
        goto L23
    L29:
        ForsetiNodeFragment r12 = this.b.c;
        if (r12 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("nodeContainerFragment");
    L33:
        ForsetiNodePiece r13 = ForsetiNodeFragment.S90(r1.d);
        if (r13 == null) goto L36;
        r13.onPause();
    L36:
        ForsetiNodePiece r14 = ForsetiNodeFragment.S90(r1.d);
        if (r14 == null) goto L42;
        r14.onStop();
        return;
    L42:
        return;
    L32:
        r1 = r12;
        goto L33
    L14:
        if (r7 == ForsetiNodeMode.INVISIBLE_C) goto L16;
    L5:
        if (r7 == ForsetiNodeMode.INVISIBLE_C) goto L7;
        r5 = true;
        goto L9
    }
}
