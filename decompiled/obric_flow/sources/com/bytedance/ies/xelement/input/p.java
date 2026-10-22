package com.bytedance.ies.xelement.input;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.xelement.input.LynxUIInput;
import com.lynx.xelement.input.LynxUITextArea;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxUI f6464b;

    public /* synthetic */ p(LynxUI r5, int r10) {
        this.f6463a = r10;
        this.f6464b = r5;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r5, int r10, KeyEvent r11) {
        LynxUI r12 = this.f6464b;
        switch(this.f6463a) {
            case 0: goto L8;
            case 1: goto L7;
            default: goto L5;
        };
    L8:
        int r13 = LynxInputView.N;
        LynxInputView r14 = (LynxInputView) r12;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        if (r10 == 0) goto L21;
        if (r10 == 2) goto L21;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        if (r10 == 5) goto L21;
        if (r10 == 6) goto L21;
        return false;
    L21:
        if (r14.f6418v == false) goto L29;
        com.lynx.tasm.r r15 = r14.getLynxContext().g;
        com.lynx.animax.i r16 = new com.lynx.animax.i(r14.getSign(), "confirm");
        LynxEditText r17 = r14.M;
        String r18 = null;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r17 = null;
    L25:
        Editable r19 = r17.getText();
        if (r19 == null) goto L28;
        r18 = r19.toString();
    L28:
        r16.a("value", r18);
        r15.b(r16);
    L29:
        if (r10 == 5) goto L32;
        r14.setFocus(false);
        return true;
    L32:
        return false;
    L5:
        return LynxUITextArea.r((LynxUITextArea) r12);
    L7:
        return LynxUIInput.p((LynxUIInput) r12, r10);
    }
}
