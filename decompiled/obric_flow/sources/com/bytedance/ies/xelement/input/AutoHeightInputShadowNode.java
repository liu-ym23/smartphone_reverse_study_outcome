package com.bytedance.ies.xelement.input;

import android.text.Editable;
import android.util.DisplayMetrics;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/input/AutoHeightInputShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "<init>", "()V", "Lpm/a;", "fontSize", "", "setFontTextSize", "(Lpm/a;)V", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AutoHeightInputShadowNode extends TextShadowNode {
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f6397a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f6398b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f6399c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f6400d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public LynxEditText f6401e0;

    public AutoHeightInputShadowNode() {
        this.f6398b0 = Float.MAX_VALUE;
        this.f6399c0 = Float.MAX_VALUE;
        this.f6400d0 = Float.MAX_VALUE;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long B(TextShadowNode r5, float r10, MeasureMode r11, float r12, MeasureMode r13) {
        Intrinsics.checkNotNullParameter(r5, "node");
        Intrinsics.checkNotNullParameter(r11, "widthMode");
        Intrinsics.checkNotNullParameter(r13, "heightMode");
        this.f6399c0 = r12;
        this.f6400d0 = r10;
        MeasureMode r14 = MeasureMode.f10340c;
        if (r13 != r14) goto L7;
        if (r11 != r14) goto L7;
        this.f6398b0 = Float.MAX_VALUE;
        return ym.h.b(r10, r12);
    L7:
        N();
        L();
        float r15 = Math.max(this.f6397a0, this.Z);
        this.f6399c0 = r15;
        if (r13 != MeasureMode.f10339b) goto L11;
        this.f6398b0 = Float.MAX_VALUE;
    L14:
        return ym.h.b(r10, this.f6399c0);
    L11:
        if (r13 != MeasureMode.d) goto L14;
        this.f6398b0 = r12;
        this.f6399c0 = Math.min(r15, r12);
        goto L14
    }

    public final void L() {
        LynxEditText r5 = this.f6401e0;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        if (r5.getMaxHeight() < 0) goto L15;
        LynxEditText r10 = this.f6401e0;
        Intrinsics.checkNotNull(r10);
        if (r10.getMinHeight() < 0) goto L16;
        LynxEditText r11 = this.f6401e0;
        Intrinsics.checkNotNull(r11);
        if (r11.getHint() == null) goto L17;
        LynxEditText r12 = this.f6401e0;
        Intrinsics.checkNotNull(r12);
        CharSequence r13 = r12.getHint();
        LynxEditText r14 = this.f6401e0;
        Intrinsics.checkNotNull(r14);
        this.Z = com.bytedance.android.anniex.base.service.e.a(r13, r14, (int) this.f6400d0).getHeight();
        LynxEditText r15 = this.f6401e0;
        Intrinsics.checkNotNull(r15);
        int r16 = r15.getMinHeight();
        LynxEditText r17 = this.f6401e0;
        Intrinsics.checkNotNull(r17);
        int r18 = r17.getMaxHeight();
        int r19 = Math.max(this.Z, r16);
        this.Z = r19;
        this.Z = Math.min(r19, r18);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final boolean M() {
        LynxEditText r5 = this.f6401e0;
        if (r5 == null) goto L13;
        Intrinsics.checkNotNull(r5);
        if (r5.getMaxHeight() < 0) goto L13;
        LynxEditText r10 = this.f6401e0;
        Intrinsics.checkNotNull(r10);
        if (r10.getMinHeight() < 0) goto L13;
        int r11 = Math.min(Math.max(this.f6397a0, this.Z), (int) this.f6398b0);
        LynxEditText r12 = this.f6401e0;
        Intrinsics.checkNotNull(r12);
        if (r12.getHeight() == r11) goto L13;
        n();
        return true;
    L13:
        return false;
    }

    public final void N() {
        LynxEditText r5 = this.f6401e0;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        if (r5.getMaxHeight() < 0) goto L15;
        LynxEditText r10 = this.f6401e0;
        Intrinsics.checkNotNull(r10);
        if (r10.getMinHeight() < 0) goto L16;
        LynxEditText r11 = this.f6401e0;
        Intrinsics.checkNotNull(r11);
        if (r11.getEditableText() == null) goto L17;
        LynxEditText r12 = this.f6401e0;
        Intrinsics.checkNotNull(r12);
        Editable r13 = r12.getEditableText();
        LynxEditText r14 = this.f6401e0;
        Intrinsics.checkNotNull(r14);
        this.f6397a0 = com.bytedance.android.anniex.base.service.e.a(r13, r14, (int) this.f6400d0).getHeight();
        LynxEditText r15 = this.f6401e0;
        Intrinsics.checkNotNull(r15);
        int r16 = r15.getMinHeight();
        LynxEditText r17 = this.f6401e0;
        Intrinsics.checkNotNull(r17);
        int r18 = r17.getMaxHeight();
        int r19 = Math.max(this.f6397a0, r16);
        this.f6397a0 = r19;
        this.f6397a0 = Math.min(r19, r18);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @c0(name = "font-size")
    public final void setFontTextSize(pm.a r11) {
        DisplayMetrics r5 = null;
        if (r11 != null) goto L9;
        b0 r12 = this.f10349m;
        if (r12 == null) goto L7;
        r5 = r12.f10152u;
    L7:
        setFontSize(com.lynx.tasm.utils.k.c("14px", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r5));
        return;
    L9:
        ReadableType r10 = r11.getType();
        if (r10 != null) goto L12;
        int r13 = -1;
    L14:
        if (r13 != 1) goto L16;
        setFontSize((float) r11.asDouble());
        return;
    L16:
        if (r13 == 2) goto L18;
        return;
    L18:
        String r14 = r11.asString();
        b0 r15 = this.f10349m;
        if (r15 == null) goto L21;
        r5 = r15.f10152u;
    L21:
        setFontSize(com.lynx.tasm.utils.k.c(r14, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r5));
        return;
    L12:
        r13 = a.f6431a[r10.ordinal()];
        goto L14
    }
}
