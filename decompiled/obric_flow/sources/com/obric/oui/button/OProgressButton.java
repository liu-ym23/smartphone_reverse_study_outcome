package com.obric.oui.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/button/OProgressButton;", "Lcom/obric/oui/button/OButton;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "isProgressMode", "", "setProgressMode", "(Z)V", "progressPercentage", "setProgress", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OProgressButton extends OButton {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12141p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f12142q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f12143r;
    public final int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f12144t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12145u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f12146v;

    @JvmOverloads
    public OProgressButton(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0);
    }

    public final void n(float r5) {
        Drawable r10 = getBackground();
        if ((r10 instanceof LayerDrawable) == false) goto L12;
        Drawable r11 = ((LayerDrawable) r10).findDrawableByLayerId(R.id.progress);
        if ((r11 instanceof ClipDrawable) == false) goto L7;
        ClipDrawable r12 = (ClipDrawable) r11;
    L8:
        if (r12 == null) goto L13;
        r12.setLevel((int) (r5 * 100));
        return;
    L13:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final void o() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r5 = this.f12146v / 100.0f;
        float r10 = getWidth();
        float r11 = RangesKt.coerceIn(r5, 0.0f, 1.0f);
        int r12 = this.s;
        if (r11 > 0.0f) goto L8;
        getPaint().setShader(null);
        setTextColor(r12);
    L12:
        invalidate();
        return;
    L8:
        int r13 = this.f12143r;
        if (r11 < 1.0f) goto L11;
        getPaint().setShader(null);
        setTextColor(r13);
        goto L12
    L11:
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r10, 0.0f, new int[]{r13, r13, r12, r12}, new float[]{0.0f, r11, r11, 1.0f}, Shader.TileMode.CLAMP));
        setTextColor(r13);
        goto L12
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (this.f12141p == false) goto L6;
        o();
        return;
    }

    @Override // com.obric.oui.button.OButton
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r5) {
    }

    public final void setProgress(int r5) {
        if (this.f12145u != r5) goto L5;
        return;
    L5:
        this.f12145u = r5;
        float r10 = r5;
        this.f12146v = r10;
        n(r10);
        if (this.f12141p == false) goto L9;
        o();
        return;
    }

    public final void setProgressMode(boolean r5) {
        if (this.f12141p == r5) goto L25;
        this.f12141p = r5;
        ClipDrawable r10 = null;
        Integer r11 = this.f12142q;
        if (r5 == false) goto L20;
        Drawable r12 = ContextCompat.getDrawable(getContext(), this.f12144t);
        if (r12 != null) goto L9;
        Drawable r13 = null;
    L10:
        setBackground(r13);
        Drawable r14 = getBackground();
        if ((r14 instanceof LayerDrawable) == false) goto L19;
        Drawable r15 = ((LayerDrawable) r14).findDrawableByLayerId(R.id.progress);
        if ((r15 instanceof ClipDrawable) == false) goto L15;
        r10 = (ClipDrawable) r15;
    L15:
        if (r11 == null) goto L19;
        if (r10 == null) goto L19;
        Intrinsics.checkNotNull(r11);
        r10.setTint(r11.intValue());
    L19:
        n(this.f12146v);
        o();
        return;
    L9:
        r13 = r12.mutate();
        goto L10
    L20:
        getPaint().setShader(null);
        setTextColor(this.f12143r);
        if (r11 == null) goto L23;
        Intrinsics.checkNotNull(r11);
        setBackground(new ColorDrawable(r11.intValue()));
    L23:
        invalidate();
        return;
    }

    @JvmOverloads
    public OProgressButton(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11, 24);
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OProgressButton);
        this.f12143r = r12.getColor(R$styleable.OProgressButton_android_textColor, ContextCompat.getColor(r5, R$color.oui_on_accent_default));
        this.s = r12.getColor(R$styleable.OProgressButton_oui_progress_button_uncovered_text_color, ContextCompat.getColor(r5, R$color.oui_accent_6_bg));
        this.f12144t = r12.getResourceId(R$styleable.OProgressButton_oui_progress_bg_resource, R$drawable.o_button_progress_drawable_primary);
        r12.recycle();
        Drawable r13 = getBackground();
        if ((r13 instanceof ColorDrawable) == false) goto L6;
        this.f12142q = Integer.valueOf(((ColorDrawable) r13).getColor());
        return;
    }
}
