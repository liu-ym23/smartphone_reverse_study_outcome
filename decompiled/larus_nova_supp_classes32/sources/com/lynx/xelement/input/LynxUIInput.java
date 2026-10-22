package com.lynx.xelement.input;

import android.content.Context;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/input/LynxUIInput;", "Lcom/lynx/xelement/input/LynxUIBaseInput;", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIInput extends LynxUIBaseInput {
    public static final /* synthetic */ int A = 0;

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final int R() {
        return 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        new LynxInputUtils();
        int r0 = LynxInputUtils.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, Integer.MAX_VALUE).getHeight();
        new LynxInputUtils();
        Layout r1 = LynxInputUtils.a(((LynxEditTextView) this.mView).getHint(), (EditText) this.mView, Integer.MAX_VALUE);
        ShadowNode r2 = getLynxContext().findShadowNodeBySign(getSign());
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof LynxUIBaseInputShadowNode) == false) goto L11;
        LynxUIBaseInputShadowNode r3 = (LynxUIBaseInputShadowNode) r2;
        int r4 = RangesKt.coerceAtLeast(r1.getHeight(), r0);
        if (r4 == r3.p0) goto L12;
        r3.p0 = r4;
        r3.e = false;
        r3.q();
        r3.a.j(r3.b);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.widget.EditText, com.lynx.xelement.input.LynxEditTextView] */
    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public LynxEditTextView Q(Context r2) {
        ?? r3 = super.Q(r2);
        if ((this instanceof LynxUIInputNG) == true) goto L5;
        r3.setLines(1);
        r3.setSingleLine(true);
        r3.setHorizontallyScrolling(true);
        r3.setEllipsize(TextUtils.TruncateAt.END);
    L5:
        r3.setGravity(16);
        r3.setPadding(0, 0, 0, 0);
        r3.setOnEditorActionListener(new g(this));
        return r3;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(x0 r4) {
        super.afterPropsUpdated(r4);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        ((LynxEditTextView) this.mView).setLineHeight((int) this.mFontSize);
    L5:
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{this.u, this.v, this.w});
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return Q(r1);
    }

    public LynxUIInput(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
