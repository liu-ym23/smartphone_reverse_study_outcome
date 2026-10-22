package com.lynx.xelement.input;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.x0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/lynx/xelement/input/LynxUITextArea;", "Lcom/lynx/xelement/input/LynxUIBaseInput;", NameKeys.UnloadStrategy_No_Strategy, "maxLines", NameKeys.UnloadStrategy_No_Strategy, "setMaxLines", NameKeys.UnloadStrategy_No_Strategy, "enable", "setEnableScrollBar", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxUITextArea extends LynxUIBaseInput {
    public static final /* synthetic */ int E = 0;
    public int A;
    public boolean B;
    public h C;
    public final j D;

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final boolean W() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final void P() {
        new LynxInputUtils();
        Layout r0 = LynxInputUtils.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, getWidth());
        if (r0.getHeight() == this.A) goto L7;
        c0(r0.getHeight());
        this.A = r0.getHeight();
        if (this.B == true) goto L7;
        EventEmitter r1 = getLynxContext().getEventEmitter();
        m7a.a r2 = new m7a.a(getSign(), SVGRenderEngine.LINE);
        r2.a(SVGRenderEngine.LINE, Integer.valueOf(r0.getLineCount()));
        r1.sendCustomEvent(r2);
    L7:
        this.B = false;
    }

    public final boolean b0() {
        int r0 = ((LynxEditTextView) this.mView).getImeOptions() & 255;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L15;
        if (r0 == 5) goto L15;
        if (r0 == 6) goto L15;
        return false;
    L15:
        return !this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        new LynxInputUtils();
        c0(LynxInputUtils.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, getWidth()).getHeight());
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.EditText, com.lynx.xelement.input.LynxEditTextView] */
    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final LynxEditTextView Q(Context r3) {
        ?? r4 = super.Q(r3);
        r4.setHorizontallyScrolling(false);
        r4.setSingleLine(false);
        r4.setGravity(48);
        r4.setPadding(0, 0, 0, 0);
        r4.setOnEditorActionListener(new i(this));
        return r4;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(x0 r9) {
        super.afterPropsUpdated(r9);
        h r10 = this.C;
        if (r10 == null) goto L5;
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{this.D, this.w, this.v, r10, this.u});
        Unit r11 = Unit.INSTANCE;
    L6:
        if (r11 != null) goto L9;
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{this.D, this.w, this.v, this.u});
        return;
    L9:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void c0(final int r5) {
        new LynxInputUtils();
        final Layout r0 = LynxInputUtils.a(((LynxEditTextView) this.mView).getHint(), (EditText) this.mView, getWidth());
        getLynxContext().findShadowNodeAndRunTask(getSign(), new k(r0, r5));
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r1) {
        return Q(r1);
    }

    @LynxProp(defaultBoolean = false, name = "enable-scroll-bar")
    public final void setEnableScrollBar(boolean r3) {
        ((LynxEditTextView) this.mView).setVerticalScrollBarEnabled(r3);
        ((LynxEditTextView) this.mView).setHorizontalScrollBarEnabled(false);
        ((LynxEditTextView) this.mView).setScrollbarFadingEnabled(true);
        ((LynxEditTextView) this.mView).setScrollBarDefaultDelayBeforeFade(1000);
        if (Build.VERSION.SDK_INT < 29) goto L6;
        ((LynxEditTextView) this.mView).setVerticalScrollbarThumbDrawable(new ColorDrawable(-3355444));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = Integer.MAX_VALUE, name = "maxlines")
    public final void setMaxLines(final int r3) {
        if (r3 > 0) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this.B = false;
        ((LynxEditTextView) this.mView).setMaxLines(r3);
        if (r3 != Integer.MAX_VALUE) goto L8;
        h r4 = 0;
    L9:
        this.C = r4;
        return;
    L8:
        r4 = new h(this, r3);
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.lynx.xelement.input.j] */
    public LynxUITextArea(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.A = -1;
        this.D = new j(this);
    }

    public static CharSequence a0(LynxUITextArea r5, int r6, CharSequence r7, int r8, int r9, Spanned r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.B = false;
        if (r6 == Integer.MAX_VALUE) goto L21;
        if (r6 <= 0) goto L21;
        if (r8 >= r9) goto L21;
        new LynxInputUtils();
        CharSequence r13 = r7.subSequence(r8, r9);
        int r14 = r13.length();
        int r15 = 0;
    L8:
        boolean r1 = true;
        if (r15 >= r14) goto L15;
        int r2 = ((r15 + r14) + 1) / 2;
        SpannableStringBuilder r3 = new SpannableStringBuilder(r10);
        r3.replace(r11, r12, r13.subSequence(0, r2));
        if (LynxInputUtils.a(r3, (EditText) r5.mView, r5.getWidth()).getLineCount() <= r6) goto L12;
        r14 = r2 - 1;
        goto L8
    L12:
        r15 = r2;
        goto L8
    L15:
        if (r15 < r13.length()) goto L18;
        r1 = false;
    L18:
        r5.B = r1;
        if (r1 == false) goto L21;
        EventEmitter r16 = r5.getLynxContext().getEventEmitter();
        m7a.a r17 = new m7a.a(r5.getSign(), SVGRenderEngine.LINE);
        r17.a(SVGRenderEngine.LINE, -1);
        r16.sendCustomEvent(r17);
        return r13.subSequence(0, r15);
    L21:
        return null;
    }
}
