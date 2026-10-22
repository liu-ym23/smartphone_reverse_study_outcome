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
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import fja.d;
import hja.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/button/OProgressButton;", "Lcom/obric/oui/button/OButton;", "", "isProgressMode", "", "setProgressMode", "", "progressPercentage", "setProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OProgressButton extends OButton {
    public boolean q;
    public final Integer r;
    public final int s;
    public final int t;
    public final int u;
    public int v;
    public float w;
    public d x;

    @Override // com.obric.oui.button.OButton, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    @Override // com.obric.oui.button.OButton
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r1) {
    }

    public final void f() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        float r0 = this.w / 100.0f;
        float r5 = getWidth();
        float r1 = RangesKt.coerceIn(r0, 0.0f, 1.0f);
        if (r1 > 0.0f) goto L9;
        getPaint().setShader(null);
        setTextColor(this.t);
    L12:
        invalidate();
        return;
    L9:
        if (r1 < 1.0f) goto L11;
        getPaint().setShader(null);
        setTextColor(this.s);
        goto L12
    L11:
        int r9 = this.s;
        int r10 = this.t;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r5, 0.0f, new int[]{r9, r9, r10, r10}, new float[]{0.0f, r1, r1, 1.0f}, Shader.TileMode.CLAMP));
        setTextColor(this.s);
        goto L12
    }

    public final void d(float r3) {
        Drawable r0 = getBackground();
        if ((r0 instanceof LayerDrawable) == false) goto L12;
        Drawable r1 = ((LayerDrawable) r0).findDrawableByLayerId(R.id.progress);
        if ((r1 instanceof ClipDrawable) == false) goto L7;
        ClipDrawable r2 = (ClipDrawable) r1;
    L8:
        if (r2 == null) goto L13;
        r2.setLevel((int) (r3 * 100));
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void e(int r7) {
        if (this.v != r7) goto L5;
        return;
    L5:
        this.v = r7;
        if (this.q == true) goto L8;
        return;
    L8:
        d r0 = this.x;
        if (r0 == null) goto L12;
        int r2 = d.d;
        r0.a(false);
    L12:
        float r8 = Math.abs(this.w - r7);
        int r3 = 100;
        if (r8 <= 10.0f) goto L15;
        r3 = (int) (100 + ((50 * r8) / 10));
    L15:
        com.obric.common.oea.foundation.animation.builder.d.a r9 = new com.obric.common.oea.foundation.animation.builder.d.a();
        float r1 = this.w;
        float r4 = this.v;
        Token$Easing r5 = Token$Easing.OUI_ANIMATION_EASING_LINEAR;
        Intrinsics.checkNotNullParameter(r5, "easing");
        r9.b(r1, r4, new a(r3, 0, r5), null);
        Function3<String, Object, Object, Unit> r6 = new OProgressButton$updateProgress$1(this);
        Intrinsics.checkNotNullParameter(r6, "callback");
        r9.d = r6;
        Function2<Boolean, Throwable, Unit> r10 = new OProgressButton$updateProgress$2(this);
        Intrinsics.checkNotNullParameter(r10, "callback");
        r9.e = r10;
        this.x = r9.a().a();
        if (this.q == false) goto L19;
        f();
        return;
    }

    public final void setProgress(int r3) {
        if (this.v != r3) goto L5;
        return;
    L5:
        d r0 = this.x;
        if (r0 == null) goto L9;
        int r1 = d.d;
        r0.a(false);
    L9:
        this.v = r3;
        float r4 = r3;
        this.w = r4;
        d(r4);
        if (this.q == false) goto L13;
        f();
        return;
    }

    public final void setProgressMode(boolean r3) {
        if (this.q == r3) goto L26;
        this.q = r3;
        ClipDrawable r0 = null;
        if (r3 == false) goto L21;
        Drawable r4 = ContextCompat.getDrawable(getContext(), this.u);
        if (r4 != null) goto L9;
        Drawable r5 = null;
    L10:
        setBackground(r5);
        Drawable r6 = getBackground();
        if ((r6 instanceof LayerDrawable) == false) goto L20;
        Drawable r7 = ((LayerDrawable) r6).findDrawableByLayerId(R.id.progress);
        if ((r7 instanceof ClipDrawable) == false) goto L15;
        r0 = (ClipDrawable) r7;
    L15:
        Integer r8 = this.r;
        if (r8 == null) goto L20;
        if (r0 == null) goto L20;
        Intrinsics.checkNotNull(r8);
        r0.setTint(r8.intValue());
    L20:
        d(this.w);
        f();
        return;
    L9:
        r5 = r4.mutate();
        goto L10
    L21:
        getPaint().setShader(null);
        setTextColor(this.s);
        if (this.r == null) goto L24;
        Integer r1 = this.r;
        Intrinsics.checkNotNull(r1);
        setBackground(new ColorDrawable(r1.intValue()));
    L24:
        invalidate();
        return;
    }

    public OProgressButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OProgressButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 24);
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{R.attr.textColor, 2130973229, 2130973230, 2130973231});
        this.s = r5.getColor(0, ContextCompat.getColor(r2, 2131105292));
        this.t = r5.getColor(3, ContextCompat.getColor(r2, 2131104006));
        this.u = r5.getResourceId(1, 2131244109);
        r5.recycle();
        Drawable r6 = getBackground();
        if ((r6 instanceof ColorDrawable) == false) goto L6;
        this.r = Integer.valueOf(((ColorDrawable) r6).getColor());
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.q == false) goto L6;
        f();
        return;
    }
}
