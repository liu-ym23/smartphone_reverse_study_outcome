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
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u8.c;
import u8.e;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/button/OProgressButton;", "Lcom/obric/oui/button/OButton;", "", "isProgressMode", "", "setProgressMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OProgressButton extends OButton {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f6270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Integer f6271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f6272w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f6273x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f6274y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6275z;

    @JvmOverloads
    public OProgressButton(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OProgressButton(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 0, null, 24, null);
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.OProgressButton);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…tyleable.OProgressButton)");
        this.f6272w = r13.getColor(l.OProgressButton_android_textColor, ContextCompat.getColor(r10, c.oui_on_accent_default));
        this.f6273x = r13.getColor(l.OProgressButton_oui_progress_button_uncovered_text_color, ContextCompat.getColor(r10, c.oui_accent_6_bg));
        this.f6274y = r13.getResourceId(l.OProgressButton_oui_progress_bg_resource, e.o_button_progress_drawable_primary);
        r13.recycle();
        Drawable r14 = getBackground();
        if ((r14 instanceof ColorDrawable) == false) goto L6;
        this.f6271v = Integer.valueOf(((ColorDrawable) r14).getColor());
        return;
    }

    public /* synthetic */ OProgressButton(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = 0;
    L5:
        this(r10, r11, r12);
    }

    private final void h() {
        setBackgroundResource(this.f6274y);
        Drawable r10 = getBackground();
        if ((r10 instanceof LayerDrawable) == false) goto L11;
        Drawable r11 = ((LayerDrawable) r10).findDrawableByLayerId(R.id.progress);
        if ((r11 instanceof ClipDrawable) == true) goto L7;
        r11 = null;
    L7:
        ClipDrawable r12 = (ClipDrawable) r11;
        Integer r13 = this.f6271v;
        if (r13 == null) goto L11;
        if (r12 == null) goto L11;
        Intrinsics.checkNotNull(r13);
        r12.setTint(r13.intValue());
    L11:
        j();
    }

    private final void i() {
        if (this.f6270u == false) goto L5;
        h();
        return;
    L5:
        TextPaint r10 = getPaint();
        Intrinsics.checkNotNullExpressionValue(r10, "paint");
        r10.setShader(null);
        if (this.f6271v == null) goto L8;
        Integer r11 = this.f6271v;
        Intrinsics.checkNotNull(r11);
        setBackground(new ColorDrawable(r11.intValue()));
    L8:
        j();
    }

    private final void j() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r10 = this.f6275z / 100.0f;
        float r11 = getWidth();
        float r12 = RangesKt.coerceIn(r10, 0.0f, 1.0f);
        if (r12 > 0.0f) goto L10;
        TextPaint r13 = getPaint();
        Intrinsics.checkNotNullExpressionValue(r13, "paint");
        r13.setShader(null);
        int r14 = this.f6273x;
    L8:
        setTextColor(r14);
        invalidate();
        return;
    L10:
        if (r12 < 1.0f) goto L12;
        TextPaint r15 = getPaint();
        Intrinsics.checkNotNullExpressionValue(r15, "paint");
        r15.setShader(null);
    L13:
        r14 = this.f6272w;
        goto L8
    L12:
        int r16 = this.f6272w;
        int r17 = this.f6273x;
        LinearGradient r18 = new LinearGradient(0.0f, 0.0f, r11, 0.0f, new int[]{r16, r16, r17, r17}, new float[]{0.0f, r12, r12, 1.0f}, Shader.TileMode.CLAMP);
        TextPaint r19 = getPaint();
        Intrinsics.checkNotNullExpressionValue(r19, "paint");
        r19.setShader(r18);
        goto L13
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (this.f6270u == false) goto L6;
        j();
        return;
    }

    public final void setProgressMode(boolean r10) {
        if (this.f6270u == r10) goto L6;
        this.f6270u = r10;
        i();
        return;
    }
}
