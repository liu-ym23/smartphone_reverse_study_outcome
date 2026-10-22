package com.bytedance.ies.xelement.input;

import android.text.Editable;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.xelement.input.LynxEditTextView;
import com.lynx.xelement.input.LynxUIBaseInput;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxUI f6433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppCompatEditText f6434c;

    public /* synthetic */ b(LynxUI r5, AppCompatEditText r10, int r11) {
        this.f6432a = r11;
        this.f6433b = r5;
        this.f6434c = r10;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r10, boolean r11) {
        LynxUI r12 = this.f6433b;
        AppCompatEditText r5 = this.f6434c;
        switch(this.f6432a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LynxUIBaseInput r13 = (LynxUIBaseInput) r12;
        LynxUIBaseInput.c(r13, (LynxEditTextView) r5, r11);
        return;
    L6:
        int r14 = LynxBaseInputView.L;
        LynxBaseInputView r15 = (LynxBaseInputView) r12;
        Intrinsics.checkNotNullParameter(r15, "this$0");
        LynxEditText r16 = (LynxEditText) r5;
        Intrinsics.checkNotNullParameter(r16, "$this_apply");
        r15.f6414q = r11;
        String r17 = null;
        if (r11 == false) goto L42;
        if (r15.f6416t == false) goto L14;
        com.lynx.tasm.r r18 = r15.getLynxContext().g;
        com.lynx.animax.i r19 = new com.lynx.animax.i(r15.getSign(), "focus");
        Editable r20 = r16.getText();
        if (r20 == null) goto L13;
        r17 = r20.toString();
    L13:
        r19.a("value", r17);
        r18.b(r19);
    L14:
        LynxBaseUI r21 = r15.getParentBaseUI();
        LynxContext r22 = r15.getLynxContext();
        if (r22.f10140h != null) goto L25;
        UIBody.UIBodyView r23 = r22.l();
        if (r23 == null) goto L25;
        com.lynx.tasm.behavior.i r24 = r23.getLynxUIRendererInternal();
        if (r24 == null) goto L25;
        if ((r24 instanceof LynxUIRenderer) == false) goto L25;
        ((LynxUIRenderer) r24).b();
    L25:
        if (r21 == null) goto L35;
        if (Intrinsics.areEqual(r21.getTagName(), "x-overlay-ng") == true) goto L32;
        if (Intrinsics.areEqual(r21.getTagName(), "x-overlay") == true) goto L32;
        r21 = r21.getParentBaseUI();
    L32:
        a1 r25 = r21.getTouchEventDispatcher();
        if (r25 == null) goto L35;
        r25.g = r15;
    L35:
        a1 r26 = r15.getLynxContext().f10140h;
        if (r26 == null) goto L38;
        r26.g = r15;
    L38:
        o r27 = r15.H;
        if (r27.d() == false) goto L52;
        r27.e();
        return;
    L52:
        return;
    L42:
        if (r15.f6417u == false) goto L54;
        com.lynx.tasm.r r28 = r15.getLynxContext().g;
        com.lynx.animax.i r29 = new com.lynx.animax.i(r15.getSign(), "blur");
        Editable r30 = r16.getText();
        if (r30 == null) goto L46;
        r17 = r30.toString();
    L46:
        r29.a("value", r17);
        r28.b(r29);
        return;
    }
}
