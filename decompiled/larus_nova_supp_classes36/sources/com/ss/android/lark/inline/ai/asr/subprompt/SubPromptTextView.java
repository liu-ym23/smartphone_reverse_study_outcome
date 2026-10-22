package com.ss.android.lark.inline.ai.asr.subprompt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0015J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "savedWidth", "savedHeight", "colorfulShader", "Landroid/graphics/Shader;", "type", "", "setPadding", "", "left", "top", "right", "bottom", "setType", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateColorfulShader", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SubPromptTextView extends AppCompatTextView {
    public int a;
    public int b;
    public Shader c;
    public String d;

    public static final class a {
    }

    static {
    }

    public SubPromptTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SubPromptTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        this.c = new LinearGradient(0.0f, 0.0f, (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), ContextCompat.getColor(getContext(), 2131100164), ContextCompat.getColor(getContext(), 2131100165), Shader.TileMode.CLAMP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        TextPaint r0 = getPaint();
        if (r0 != null) goto L5;
    L11:
        super/*android.widget.TextView*/.onDraw(r4);
        return;
    L5:
        if (Intrinsics.areEqual(this.d, "primary") == true) goto L7;
    L9:
        Shader r1 = null;
    L10:
        r0.setShader(r1);
        goto L11
    L7:
        if (isEnabled() == false) goto L9;
        r1 = this.c;
        goto L10
    }

    public final void setType(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Log.i("SubPromptTextView", "setType, type = " + r3);
        this.d = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (this.a == getMeasuredWidth()) goto L5;
    L6:
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
        x();
        return;
    L5:
        if (this.b != getMeasuredHeight()) goto L6;
    }

    public SubPromptTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = "primary";
    }

    public /* synthetic */ SubPromptTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.setPadding(r1, r2, r3, r4);
        if (getMeasuredWidth() > 0) goto L5;
        return;
    L5:
        if (getMeasuredHeight() <= 0) goto L9;
        x();
        return;
    }
}
