package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.m;
import com.obric.cae.R;
import defpackage.c;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBar extends Toolbar {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Drawable f4901e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f4902f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f4903g0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f4904m;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r8) {
                return new SavedState(r8, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r8) {
                return new SavedState[r8];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r8, ClassLoader r10) {
                return new SavedState(r8, r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8, ClassLoader r10) {
            super(r8, r10);
            this.f4904m = r8.readString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeString(this.f4904m);
        }

        public SavedState(Toolbar.SavedState r8) {
            super(r8);
        }
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4905g;

        public ScrollingViewBehavior() {
            this.f4905g = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean d(CoordinatorLayout r8, View r10, View r11) {
            super.d(r8, r10, r11);
            if (this.f4905g == false) goto L5;
        L7:
            return false;
        L5:
            if ((r11 instanceof AppBarLayout) == false) goto L7;
            this.f4905g = true;
            AppBarLayout r12 = (AppBarLayout) r11;
            r12.setBackgroundColor(0);
            r12.setTargetElevation(0.0f);
            goto L7
        }

        public ScrollingViewBehavior(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.f4905g = false;
        }
    }

    private void setNavigationIconDecorative(boolean r8) {
        ImageButton r10 = m.a(this);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setClickable(!r8);
        r10.setFocusable(!r8);
        Drawable r11 = r10.getBackground();
        if (r11 == null) goto L8;
        this.f4901e0 = r11;
    L8:
        if (r8 == false) goto L10;
        Drawable r12 = null;
    L11:
        r10.setBackgroundDrawable(r12);
        return;
    L10:
        r12 = this.f4901e0;
        goto L11
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        super.addView(r8, r10, r11);
    }

    public View getCenterView() {
        return null;
    }

    public float getCompatElevation() {
        WeakHashMap<View, h0> r8 = w.f8437a;
        return w.i.i(this);
    }

    public float getCornerSize() {
        throw null;
    }

    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    public CharSequence getHint() {
        throw null;
    }

    public int getMenuResId() {
        return this.f4902f0;
    }

    public int getStrokeColor() {
        throw null;
    }

    public float getStrokeWidth() {
        throw null;
    }

    public CharSequence getText() {
        throw null;
    }

    public TextView getTextView() {
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void k(int r8) {
        Menu r10 = getMenu();
        boolean r11 = r10 instanceof f;
        if (r11 == false) goto L5;
        ((f) r10).y();
    L5:
        super.k(r8);
        this.f4902f0 = r8;
        if (r11 == false) goto L9;
        ((f) r10).x();
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.i0(this, null);
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName(EditText.class.getCanonicalName());
        r8.setEditable(isEnabled());
        CharSequence r10 = getText();
        boolean r11 = TextUtils.isEmpty(r10);
        r8.setHintText(getHint());
        r8.setShowingHintText(r11);
        if (r11 == false) goto L5;
        r10 = getHint();
    L5:
        r8.setText(r10);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        setText(r10.f4904m);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState((Toolbar.SavedState) super.onSaveInstanceState());
        CharSequence r10 = getText();
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        r8.f4904m = r11;
        return r8;
    L5:
        r11 = r10.toString();
        goto L6
    }

    public void setCenterView(View r8) {
        if (r8 == null) goto L5;
        addView(r8);
        return;
    }

    public void setDefaultScrollFlagsEnabled(boolean r8) {
        this.f4903g0 = r8;
        if ((getLayoutParams() instanceof AppBarLayout.c) == false) goto L13;
        AppBarLayout.c r10 = (AppBarLayout.c) getLayoutParams();
        if (this.f4903g0 == false) goto L10;
        if (r10.f4307a != 0) goto L14;
        r10.f4307a = 53;
        return;
    L14:
        return;
    L10:
        if (r10.f4307a != 53) goto L16;
        r10.f4307a = 0;
        return;
    L16:
        return;
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
    }

    public void setHint(int r8) {
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable r8) {
        super.setNavigationIcon(r8);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener r8) {
        super.setNavigationOnClickListener(r8);
        if (r8 != null) goto L5;
        boolean r10 = true;
    L6:
        setNavigationIconDecorative(r10);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void setOnLoadAnimationFadeInEnabled(boolean r8) {
        throw null;
    }

    public void setStrokeColor(int r8) {
        if (getStrokeColor() != r8) goto L5;
        return;
    L5:
        ColorStateList.valueOf(r8);
        throw null;
    }

    public void setStrokeWidth(float r8) {
        if (getStrokeWidth() != r8) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r8) {
    }

    public void setText(int r8) {
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r8) {
    }

    public void setHint(CharSequence r8) {
        throw null;
    }

    public void setText(CharSequence r8) {
        throw null;
    }
}
