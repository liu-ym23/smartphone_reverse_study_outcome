package com.lynx.xelement.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import com.bytedance.ies.xelement.input.p;
import com.lynx.animax.i;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.w0;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.r;
import io.reactivex.exceptions.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/input/LynxUIInput;", "Lcom/lynx/xelement/input/LynxUIBaseInput;", "Input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUIInput extends LynxUIBaseInput {
    public static final boolean p(LynxUIInput r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r11 != 0) goto L5;
    L14:
        r r5 = r10.getLynxContext().g;
        i r12 = new i(r10.getSign(), "confirm");
        Editable r13 = ((LynxEditTextView) r10.mView).getText();
        if (r13 == null) goto L17;
        String r14 = r13.toString();
    L18:
        r12.a("value", r14);
        r5.b(r12);
        if (r11 != 5) goto L21;
    L27:
        return false;
    L21:
        if (r10.f11211r == true) goto L24;
        r10.blur(null, null);
    L24:
        if (r10.f11211r == true) goto L27;
        return true;
    L17:
        r14 = null;
        goto L18
    L5:
        if (r11 == 2) goto L14;
        if (r11 == 3) goto L14;
        if (r11 == 4) goto L14;
        if (r11 == 5) goto L14;
        if (r11 == 6) goto L14;
        return false;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(y0 r5) {
        super.afterPropsUpdated(r5);
        ((LynxEditTextView) this.mView).setLineHeight((int) this.mFontSize);
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{this.f11212t, this.f11213u, this.f11214v});
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r5) {
        return l(r5);
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final void k(int r5) {
        StaticLayout r10 = a.a(((LynxEditTextView) this.mView).getHint(), (EditText) this.mView, Integer.MAX_VALUE);
        LynxContext r11 = getLynxContext();
        int r12 = getSign();
        w0 r13 = (w0) r11.f10151t.get();
        if (r13 == null) goto L5;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.g.f10812a).get(r12);
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        if ((r14 instanceof LynxUIBaseInputShadowNode) == false) goto L14;
        LynxUIBaseInputShadowNode r15 = (LynxUIBaseInputShadowNode) r14;
        int r16 = RangesKt.coerceAtLeast(r10.getHeight(), r5);
        if (r16 == r15.Z) goto L15;
        r15.Z = r16;
        r15.e = false;
        r15.n();
        r15.f10334a.i(r15.f10335b);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final LynxEditTextView l(Context r5) {
        LynxEditTextView r10 = super.l(r5);
        r10.setLines(1);
        r10.setSingleLine(true);
        r10.setGravity(16);
        r10.setHorizontallyScrolling(true);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setPadding(0, 0, 0, 0);
        r10.setOnEditorActionListener(new p(this, 1));
        return r10;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final int n() {
        return 16;
    }
}
