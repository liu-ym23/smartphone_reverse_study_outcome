package com.obric.oui.tab.optimize;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import ps.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u0006%"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "selected", "", "setSelected", "(Z)V", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", Constant.TITLE, "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "getSelectedIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectedIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "selectedIconDrawable", "e", "getUnselectedIconDrawable", "setUnselectedIconDrawable", "unselectedIconDrawable", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItem extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f14688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f14690c;
    public Drawable d;
    public Drawable e;

    @JvmOverloads
    public OBottomTabItem(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final void a(int r5, int r10, int r11) {
        ColorStateList r12 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{r5, r10});
        this.f14689b.setImageTintList(r12);
        this.f14690c.setTextColor(r12);
    }

    public final ImageView getIcon() {
        return this.f14689b;
    }

    public final Drawable getSelectedIconDrawable() {
        return this.d;
    }

    public final TextView getTitle() {
        return this.f14690c;
    }

    public final Drawable getUnselectedIconDrawable() {
        return this.e;
    }

    @JvmOverloads
    public final void setImageAndTextTintColor(int r5) {
        a(r5, ContextCompat.getColor(getContext(), R$color.oui_text_3b), ContextCompat.getColor(getContext(), R$color.oui_accent_bg_low_contrast));
    }

    @Override // android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        Drawable r10 = this.d;
        if (r10 == null) goto L11;
        Drawable r11 = this.e;
        if (r11 == null) goto L11;
        ImageView r12 = this.f14689b;
        if (r5 == false) goto L10;
        r12.setImageDrawable(r10);
    L12:
        TextView r13 = this.f14690c;
        if (r5 == false) goto L15;
        r13.setTextAppearance(R$style.Label_S_Thick);
        return;
    L15:
        r13.setTextAppearance(R$style.Label_S);
        return;
    L10:
        r12.setImageDrawable(r11);
    L11:
        a.g("optimize.OBottomTabItem", "please set selectedIconDrawable and unselectedIconDrawable");
        goto L12
    }

    public final void setSelectedIconDrawable(Drawable r5) {
        this.d = r5;
    }

    public final void setUnselectedIconDrawable(Drawable r5) {
        this.e = r5;
    }

    @JvmOverloads
    public OBottomTabItem(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r5).inflate(R$layout.o_tab_bottom_item, this, true);
        this.f14688a = (FrameLayout) findViewById(R$id.icon_container);
        this.f14689b = (ImageView) findViewById(R$id.icon);
        this.f14690c = (TextView) findViewById(R$id.title);
        a(ContextCompat.getColor(getContext(), R$color.oui_accent_fg), ContextCompat.getColor(getContext(), R$color.oui_text_3b), ContextCompat.getColor(getContext(), R$color.oui_accent_bg_low_contrast));
    }
}
