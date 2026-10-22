package com.bytedance.ies.xelement.input;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxInputView;", "Lcom/bytedance/ies/xelement/input/LynxBaseInputView;", "", "isPassword", "", "setIsPassword", "(Z)V", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxInputView extends LynxBaseInputView {
    public static final /* synthetic */ int N = 0;
    public LynxEditText M;

    public LynxInputView(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null);
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void c(LynxEditText r5) {
        Intrinsics.checkNotNullParameter(r5, "editText");
        r5.setLines(1);
        r5.setSingleLine(true);
        r5.setHorizontallyScrolling(true);
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r5) {
        return k(r5);
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void i(LynxEditText r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "editText");
        switch(r10.hashCode()) {
            case -1034364087: goto L26;
            case 114715: goto L22;
            case 3556653: goto L18;
            case 95582509: goto L14;
            case 96619420: goto L10;
            case 1216985755: goto L6;
            default: goto L32;
        };
    L32:
        int r11 = r5.getSelectionStart();
        if (Intrinsics.areEqual(r10, "password") == true) goto L35;
        r5.setTransformationMethod(SingleLineTransformationMethod.getInstance());
    L36:
        r5.setSelection(r11);
        return;
    L35:
        r5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L36
    L6:
        if (r10.equals("password") == false) goto L32;
        r5.setInputType(128);
        goto L32
    L10:
        if (r10.equals(NotificationCompat.CATEGORY_EMAIL) == false) goto L32;
        r5.setInputType(32);
        goto L32
    L14:
        if (r10.equals("digit") == false) goto L32;
        r5.setInputType(8194);
        goto L32
    L18:
        if (r10.equals(MessageIndication.CONTENT_TYPE_TEXT) == false) goto L32;
        r5.setInputType(1);
        goto L32
    L22:
        if (r10.equals("tel") == false) goto L32;
        r5.setInputType(3);
        goto L32
    L26:
        if (r10.equals("number") == false) goto L32;
        if (this.K == false) goto L31;
        r5.setInputType(2);
        goto L32
    L31:
        r5.setInputType(12290);
        goto L32
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final LynxEditText k(Context r5) {
        LynxEditText r10 = super.k(r5);
        this.M = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L5:
        r10.setOnEditorActionListener(new p(this, 0));
        r10.setOnTouchListener(null);
        r10.setImeOptions(6);
        LynxEditText r11 = this.M;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        return null;
    L9:
        return r11;
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void l() {
        LynxEditText r5 = null;
        if (this.K == false) goto L15;
        LynxEditText r10 = this.M;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L8:
        if (r10.getInputType() != 12290) goto L26;
        LynxEditText r11 = this.M;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L13:
        r5.setInputType(2);
        return;
    L12:
        r5 = r11;
        goto L13
    L26:
        return;
    L15:
        LynxEditText r12 = this.M;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r12 = null;
    L19:
        if (r12.getInputType() != 2) goto L27;
        LynxEditText r13 = this.M;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L24:
        r5.setInputType(12290);
        return;
    L23:
        r5 = r13;
        goto L24
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final int m() {
        return 16;
    }

    @c0(defaultBoolean = false, name = "password")
    public final void setIsPassword(boolean r5) {
        LynxEditText r10 = null;
        if (r5 == false) goto L19;
        LynxEditText r11 = this.M;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L7:
        int r12 = r11.getSelectionStart();
        LynxEditText r13 = this.M;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L10:
        r13.setInputType(128);
        LynxEditText r14 = this.M;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r14 = null;
    L13:
        r14.setTransformationMethod(PasswordTransformationMethod.getInstance());
        LynxEditText r15 = this.M;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L17:
        r10.setSelection(r12);
        return;
    L16:
        r10 = r15;
        goto L17
    L19:
        LynxEditText r16 = this.M;
        if (r16 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r16 = null;
    L22:
        int r17 = r16.getSelectionStart();
        LynxEditText r18 = this.M;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r18 = null;
    L25:
        r18.setInputType(this.F);
        LynxEditText r19 = this.M;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r19 = null;
    L28:
        r19.setTransformationMethod(SingleLineTransformationMethod.getInstance());
        LynxEditText r20 = this.M;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L32:
        r10.setSelection(r17);
        return;
    L31:
        r10 = r20;
        goto L32
    }

    public LynxInputView(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
    }
}
