package w9;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.r;
import androidx.core.widget.b;
import com.google.android.material.internal.l;
import x9.c;

/* JADX INFO: loaded from: classes.dex */
public final class a extends r {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[][] f13083q = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f13084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13085p;

    static {
        f13083q = new int[][]{new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public a(Context r10, AttributeSet r11) {
        super(ea.a.a(r10, r11, com.obric.cae.R.attr.radioButtonStyle, com.obric.cae.R.style.Widget_MaterialComponents_CompoundButton_RadioButton), r11, com.obric.cae.R.attr.radioButtonStyle);
        Context r12 = getContext();
        TypedArray r13 = l.d(r12, r11, g9.a.f7775p, com.obric.cae.R.attr.radioButtonStyle, com.obric.cae.R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (r13.hasValue(0) == false) goto L5;
        b.c(this, c.a(r12, r13, 0));
    L5:
        this.f13085p = r13.getBoolean(1, false);
        r13.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13084o != null) goto L6;
        int r8 = t2.b.z(this, com.obric.cae.R.attr.colorControlActivated);
        int r10 = t2.b.z(this, com.obric.cae.R.attr.colorOnSurface);
        int r11 = t2.b.z(this, com.obric.cae.R.attr.colorSurface);
        int[] r12 = {t2.b.K(1.0f, r11, r8), t2.b.K(0.54f, r11, r10), t2.b.K(0.38f, r11, r10), t2.b.K(0.38f, r11, r10)};
        this.f13084o = new ColorStateList(f13083q, r12);
    L6:
        return this.f13084o;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13085p == true) goto L5;
        return;
    L5:
        if (b.a(this) != null) goto L9;
        setUseMaterialThemeColors(true);
        return;
    }

    public void setUseMaterialThemeColors(boolean r8) {
        this.f13085p = r8;
        if (r8 == false) goto L6;
        ColorStateList r10 = getMaterialThemeColorsTintList();
    L5:
        b.c(this, r10);
        return;
    L6:
        r10 = null;
        goto L5
    }
}
