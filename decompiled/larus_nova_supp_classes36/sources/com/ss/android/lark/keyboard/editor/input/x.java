package com.ss.android.lark.keyboard.editor.input;

import android.view.View;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ RichTextInputShrinkPlugin a;

    public x(RichTextInputShrinkPlugin r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        InputStateController r5 = this.a.Q().a();
        if (r5 == null) goto L7;
        cya.h r6 = r5.d();
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.a());
    L9:
        if (Intrinsics.areEqual(r7, 2) == false) goto L14;
        InputStateController r8 = this.a.Q().a();
        if (r8 == null) goto L31;
        r8.pop();
        return;
    L31:
        return;
    L14:
        if (Intrinsics.areEqual(r7, 4) == false) goto L25;
        InputStateController r9 = this.a.Q().a();
        if (r9 == null) goto L22;
        cya.h r0 = r9.d();
        if (r0 == null) goto L22;
        com.ss.android.lark.keyboard.base.n r1 = r0.a;
        if (r1 == null) goto L22;
        r1.b(com.ss.android.lark.keyboard.inputstate.b.h, Boolean.TRUE);
    L22:
        if (r9 == null) goto L33;
        r9.pop();
        return;
    L33:
        return;
    L25:
        if (Intrinsics.areEqual(r7, 8) == false) goto L29;
        com.ss.android.lark.keyboard.inputstate.d r10 = new com.ss.android.lark.keyboard.inputstate.d();
        ((cya.h) r10).a.b(com.ss.android.lark.keyboard.inputstate.d.i, Boolean.TRUE);
        InputStateController r2 = this.a.Q().a();
        if (r2 == null) goto L35;
        r2.b(r10);
        return;
    L35:
        return;
    L29:
        Log.e("RichTextInputShrinkPlugin", "close reply button: currently not in reply mode");
        return;
    L7:
        r7 = cya.h.b;
        goto L9
    }
}
