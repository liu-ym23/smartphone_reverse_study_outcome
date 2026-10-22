package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public final /* synthetic */ MmAINoteFragment a;
    public final /* synthetic */ mwb.b b;

    public b(MmAINoteFragment r1, mwb.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View r4, View r5) {
        boolean r6 = false;
        if (r5 == null) goto L25;
        MmAINoteFragment r0 = this.a;
        ViewGroup r1 = this.b.f;
        int r2 = MmAINoteFragment.y;
        r0.getClass();
        View r3 = r5;
    L6:
        if (r3 == null) goto L13;
        if (r3 == r1) goto L8;
        Object r7 = r3.getParent();
        if ((r7 instanceof View) == true) goto L11;
        r3 = null;
        goto L6
    L11:
        r3 = (View) r7;
        goto L6
    L8:
        boolean r8 = true;
    L14:
        if (r8 == true) goto L17;
    L21:
        boolean r9 = false;
    L23:
        if (r9 == false) goto L25;
        r6 = true;
        goto L25
    L17:
        if ((r5 instanceof EditText) == false) goto L19;
    L22:
        r9 = true;
        goto L23
    L19:
        if (r5.onCheckIsTextEditor() == false) goto L21;
    L13:
        r8 = false;
    L25:
        this.a.fa0().dispatchEvent(new MmAINoteUIEvent.e(r6));
    }
}
