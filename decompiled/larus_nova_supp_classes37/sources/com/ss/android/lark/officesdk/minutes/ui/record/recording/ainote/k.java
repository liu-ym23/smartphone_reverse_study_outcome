package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public final /* synthetic */ MmAINotePanelAnimator a;

    public k(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View r4, View r5) {
        boolean r6 = false;
        if (r5 == null) goto L25;
        MmAINotePanelAnimator r0 = this.a;
        ViewGroup r1 = r0.a.f;
        r0.getClass();
        View r2 = r5;
    L6:
        if (r2 == null) goto L13;
        if (r2 == r1) goto L8;
        Object r3 = r2.getParent();
        if ((r3 instanceof View) == true) goto L11;
        r2 = null;
        goto L6
    L11:
        r2 = (View) r3;
        goto L6
    L8:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L17;
    L21:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L25;
        r6 = true;
        goto L25
    L17:
        if ((r5 instanceof EditText) == false) goto L19;
    L22:
        r8 = true;
        goto L23
    L19:
        if (r5.onCheckIsTextEditor() == false) goto L21;
    L13:
        r7 = false;
    L25:
        if (r6 == false) goto L39;
        MmAINotePanelAnimator r9 = this.a;
        if (r9.x(r9.u) <= 0) goto L40;
        MmAINotePanelAnimator r10 = this.a;
        if (r10.o == MmAINoteSheetState.FULL) goto L41;
        r10.p(MmAINotePanelAnimator.FullStateSource.KEYBOARD_PROMOTED, "focus_keyboard");
        return;
    L41:
        return;
    L40:
        return;
    }
}
