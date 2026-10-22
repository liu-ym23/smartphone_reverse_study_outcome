package com.lynx.xelement.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.view.View;
import android.widget.EditText;
import com.bytedance.ies.xelement.input.p;
import com.lynx.animax.i;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.r;
import io.reactivex.exceptions.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import po.j;
import po.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/lynx/xelement/input/LynxUITextArea;", "Lcom/lynx/xelement/input/LynxUIBaseInput;", "", "maxLines", "", "setMaxLines", "(I)V", "Input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUITextArea extends LynxUIBaseInput {
    public k A;
    public final j B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11217y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11218z;

    /* JADX WARN: Type inference failed for: r2v2, types: [po.j] */
    public LynxUITextArea(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f11217y = -1;
        this.B = new j(this);
    }

    public static final CharSequence p(LynxUITextArea r10, int r11, CharSequence r12, int r13, int r14, Spanned r15, int r16, int r17) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.getClass();
        if (r11 == Integer.MAX_VALUE) goto L19;
        CharSequence r5 = new SpannableStringBuilder(r12).subSequence(r13, r14);
        int r18 = r14;
    L6:
        if (r13 >= r18) goto L11;
        int r19 = (r13 + r18) / 2;
        SpannableStringBuilder r20 = new SpannableStringBuilder(r15);
        int r21 = r19 + 1;
        r20.replace(r16, r17, r5.subSequence(0, r21));
        if (a.a(r20, (EditText) r10.mView, r10.getWidth()).getLineCount() <= r11) goto L9;
        r18 = r19;
        goto L6
    L9:
        r13 = r21;
        goto L6
    L11:
        if (r18 >= r14) goto L13;
        boolean r22 = true;
    L14:
        r10.f11218z = r22;
        if (r22 == false) goto L18;
        r r23 = r10.getLynxContext().g;
        i r110 = new i(r10.getSign(), SVGRenderEngine.LINE);
        r110.a(SVGRenderEngine.LINE, -1);
        r23.b(r110);
    L18:
        return r12.subSequence(0, r18);
    L13:
        r22 = false;
        goto L14
    L19:
        return r12;
    }

    public static final String q(LynxUITextArea r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r11 = ((LynxEditTextView) r5.mView).getImeOptions() & 255;
        if (r11 != 2) goto L5;
    L13:
        boolean r12 = !r5.f11211r;
    L14:
        if (r12 == true) goto L16;
        return null;
    L16:
        if (Intrinsics.areEqual(r10.toString(), "\n") == false) goto L21;
        return "";
    L21:
        return null;
    L5:
        if (r11 == 3) goto L13;
        if (r11 == 4) goto L13;
        if (r11 == 5) goto L13;
        if (r11 == 6) goto L13;
        r12 = false;
        goto L14
    }

    public static final boolean r(LynxUITextArea r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r r10 = r5.getLynxContext().g;
        i r11 = new i(r5.getSign(), "confirm");
        Editable r12 = ((LynxEditTextView) r5.mView).getText();
        if (r12 == null) goto L5;
        String r13 = r12.toString();
    L6:
        r11.a("value", r13);
        r10.b(r11);
        int r14 = ((LynxEditTextView) r5.mView).getImeOptions() & 255;
        if (r14 != 2) goto L9;
    L17:
        boolean r15 = !r5.f11211r;
    L18:
        if (r15 == false) goto L21;
        r5.blur(null, null);
    L21:
        return r5.f11211r;
    L9:
        if (r14 == 3) goto L17;
        if (r14 == 4) goto L17;
        if (r14 == 5) goto L17;
        if (r14 == 6) goto L17;
        r15 = false;
        goto L18
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(y0 r12) {
        super.afterPropsUpdated(r12);
        k r13 = this.A;
        po.i r5 = this.f11214v;
        j r10 = this.B;
        po.i r11 = this.f11212t;
        if (r13 == null) goto L5;
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{r11, r10, this.f11213u, r13, r5});
        Unit r14 = Unit.INSTANCE;
    L6:
        if (r14 != null) goto L9;
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{r11, r10, this.f11213u, r5});
        return;
    L9:
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r5) {
        return l(r5);
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final LynxEditTextView l(Context r5) {
        LynxEditTextView r10 = super.l(r5);
        r10.setHorizontallyScrolling(false);
        r10.setSingleLine(false);
        r10.setGravity(48);
        r10.setPadding(0, 0, 0, 0);
        r10.setOnEditorActionListener(new p(this, 2));
        return r10;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final void m() {
        StaticLayout r5 = a.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, getWidth());
        if (r5.getHeight() != this.f11217y) goto L5;
        return;
    L5:
        if (this.f11218z == true) goto L9;
        k(r5.getHeight());
        this.f11217y = r5.getHeight();
        r r10 = getLynxContext().g;
        i r11 = new i(getSign(), SVGRenderEngine.LINE);
        r11.a(SVGRenderEngine.LINE, Integer.valueOf(r5.getLineCount()));
        r10.b(r11);
        return;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final boolean o() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [po.k] */
    @c0(defaultInt = 0, name = "maxlines")
    public final void setMaxLines(final int r5) {
        ((LynxEditTextView) this.mView).setMaxLines(r5);
        this.A = new k(this, r5);
    }
}
