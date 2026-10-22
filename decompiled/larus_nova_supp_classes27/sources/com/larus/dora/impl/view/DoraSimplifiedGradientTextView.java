package com.larus.dora.impl.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/view/DoraSimplifiedGradientTextView;", "Lcom/larus/dora/impl/view/DoraTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLayout", "", "changed", "", "left", "top", "right", "bottom", "updateGradient", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSimplifiedGradientTextView extends DoraTextView {
    public DoraSimplifiedGradientTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraSimplifiedGradientTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public DoraSimplifiedGradientTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DoraSimplifiedGradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        if (r9 == true) goto L5;
        return;
    L5:
        if (getWidth() <= 0) goto L24;
        int[] r5 = {-13146369, -5740801, -35979, -19867};
        CharSequence r14 = getText();
        Float r15 = null;
        if (r14 == null) goto L9;
        String r16 = r14.toString();
    L10:
        if (r16 != null) goto L12;
        r16 = "";
    L12:
        Float r17 = Float.valueOf(getPaint().measureText(r16));
        if (r17.floatValue() <= 0.0f) goto L15;
        boolean r18 = true;
    L16:
        if (r18 == false) goto L18;
        r15 = r17;
    L18:
        if (r15 == null) goto L20;
        float r20 = r15.floatValue();
    L21:
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r20, 0.0f, r5, null, Shader.TileMode.CLAMP));
        invalidate();
        return;
    L20:
        r20 = getWidth();
        goto L21
    L15:
        r18 = false;
        goto L16
    L9:
        r16 = null;
        goto L10
    }
}
