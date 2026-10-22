package com.larus.camera.impl.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\r\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J*\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0002J \u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011¨\u0006-"}, d2 = {"Lcom/larus/camera/impl/widget/LinearGradientAutoFitTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startColor", "endColor", "minTextSize", "", "maxTextSize", "textSize15", "getTextSize15", "()F", "textSize15$delegate", "Lkotlin/Lazy;", "textSize14", "getTextSize14", "textSize14$delegate", "init", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", ShareType.TEXT, "", "start", "lengthBefore", "lengthAfter", "adjustTextSize", "applyGradient", "width", "height", "blendColors", "color1", "color2", "ratio", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinearGradientAutoFitTextView extends AppCompatTextView {
    public static final /* synthetic */ int g = 0;
    public int a;
    public int b;
    public float c;
    public float d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public LinearGradientAutoFitTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LinearGradientAutoFitTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int y(int r5, int r6, float r7) {
        float r0 = 1 - r7;
        float r1 = (((r5 >> 16) & 255) * r0) + (((r6 >> 16) & 255) * r7);
        float r2 = (((r5 >> 8) & 255) * r0) + (((r6 >> 8) & 255) * r7);
        return ((int) (((r5 & 255) * r0) + ((r6 & 255) * r7))) | (((((int) r1) << 16) | (-16777216)) | (((int) r2) << 8));
    }

    private final float getTextSize14() {
        return ((Number) this.f.getValue()).floatValue();
    }

    private final float getTextSize15() {
        return ((Number) this.e.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        CharSequence r0 = getText();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if (r0.length() > 30) goto L14;
        setTextSize(0, getTextSize15());
    L15:
        int r2 = getWidth();
        getHeight();
        int r4 = this.a;
        int r3 = this.b;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r2, 0.0f, new int[]{r4, r4, y(r4, this.b, 0.33f), y(this.a, this.b, 0.67f), r3, r3}, new float[]{0.0f, 0.4f, 0.45f, 0.55f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
        return;
    L14:
        setTextSize(0, getTextSize14());
        goto L15
    L8:
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinearGradientAutoFitTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = 2.0f;
        this.d = 100.0f;
        this.e = LazyKt.lazy(new n());
        this.f = LazyKt.lazy(new o());
        if (r3 == null) goto L5;
        TypedArray r5 = getContext().obtainStyledAttributes(r3, new int[]{2130971582, 2130972049, 2130972064, 2130972307});
        this.a = r5.getColor(3, 0);
        this.b = r5.getColor(0, 0);
        this.c = r5.getDimension(2, this.c);
        this.d = r5.getDimension(1, this.d);
        r5.recycle();
    L5:
        x();
    }

    public /* synthetic */ LinearGradientAutoFitTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        x();
    }

    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        x();
    }
}
