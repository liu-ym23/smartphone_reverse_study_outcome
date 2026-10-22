package com.google.android.material.search;

import aa.f;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.obric.cae.R;
import defpackage.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class SearchView extends FrameLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SearchBar f4906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4907b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f4908m;

    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        public Behavior(Context r8, AttributeSet r10) {
            super(r8, r10);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean d(CoordinatorLayout r8, View r10, View r11) {
            SearchView r12 = (SearchView) r10;
            if (r12.f4906a == null) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L8;
        L10:
            return false;
        L8:
            if ((r11 instanceof SearchBar) == false) goto L10;
            r12.setupWithSearchBar((SearchBar) r11);
            goto L10
        L5:
            r13 = false;
            goto L6
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f4909m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4910n;

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
            this.f4909m = r8.readString();
            this.f4910n = r8.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable(this.f1731a, r10);
            r8.writeString(this.f4909m);
            r8.writeInt(this.f4910n);
        }
    }

    public interface a {
        void a();
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4911a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f4912b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ b[] f4913m = null;

        static {
            b r8 = new b("HIDING", 0);
            b r10 = new b("HIDDEN", 1);
            f4911a = r10;
            b r11 = new b("SHOWING", 2);
            b r12 = new b("SHOWN", 3);
            f4912b = r12;
            f4913m = new b[]{r8, r10, r11, r12};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f4913m.clone();
        }
    }

    private Window getActivityWindow() {
        Context r8 = getContext();
    L4:
        if ((r8 instanceof ContextWrapper) == false) goto L9;
        if ((r8 instanceof Activity) == true) goto L7;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L4
    L7:
        Activity r10 = (Activity) r8;
    L10:
        if (r10 != null) goto L13;
        return null;
    L13:
        return r10.getWindow();
    L9:
        r10 = null;
        goto L10
    }

    private float getOverlayElevation() {
        SearchBar r8 = this.f4906a;
        if (r8 == null) goto L7;
        return r8.getCompatElevation();
    L7:
        return getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int r8 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r8 > 0) goto L5;
        return 0;
    L5:
        return getResources().getDimensionPixelSize(r8);
    }

    private void setStatusBarSpacerEnabledInternal(boolean r8) {
        throw null;
    }

    private void setUpBackgroundViewElevationOverlay(float r8) {
    }

    private void setUpHeaderLayout(int r8) {
        if (r8 != (-1)) goto L5;
        return;
    L5:
        LayoutInflater.from(getContext()).inflate(r8, null, false);
        throw null;
    }

    private void setUpStatusBarSpacer(int r8) {
        throw null;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        super.addView(r8, r10, r11);
    }

    public v9.b getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    public b getCurrentTransitionState() {
        return this.f4908m;
    }

    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return null;
    }

    public CharSequence getHint() {
        throw null;
    }

    public TextView getSearchPrefix() {
        return null;
    }

    public CharSequence getSearchPrefixText() {
        throw null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f4907b;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        throw null;
    }

    public Toolbar getToolbar() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable r8 = getBackground();
        if ((r8 instanceof f) == false) goto L6;
        c.i0(this, (f) r8);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window r8 = getActivityWindow();
        if (r8 == null) goto L6;
        this.f4907b = r8.getAttributes().softInputMode;
        return;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.f1731a);
        setText(r10.f4909m);
        if (r10.f4910n != 0) goto L9;
        boolean r11 = true;
    L10:
        setVisible(r11);
        return;
    L9:
        r11 = false;
        goto L10
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        Editable r10 = getText();
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        r8.f4909m = r11;
        throw null;
    L5:
        r11 = r10.toString();
        goto L6
    }

    public void setAnimatedNavigationIcon(boolean r8) {
    }

    public void setAutoShowKeyboard(boolean r8) {
    }

    @Override // android.view.View
    public void setElevation(float r8) {
        super.setElevation(r8);
        setUpBackgroundViewElevationOverlay(r8);
    }

    public void setHint(int r8) {
        throw null;
    }

    public void setMenuItemsAnimated(boolean r8) {
    }

    public void setModalForAccessibility(boolean r8) {
        ViewGroup r10 = (ViewGroup) getRootView();
        if (r8 == false) goto L5;
        new HashMap(r10.getChildCount());
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r10.getChildCount()) goto L12;
        if (r10.getChildAt(r11) != this) goto L11;
        r11 = r11 + 1;
        goto L7
    L11:
        throw null;
    }

    public void setOnMenuItemClickListener(Toolbar.h r8) {
        throw null;
    }

    public void setSearchPrefixText(CharSequence r8) {
        throw null;
    }

    public void setStatusBarSpacerEnabled(boolean r8) {
        setStatusBarSpacerEnabledInternal(r8);
    }

    public void setText(int r8) {
        throw null;
    }

    public void setToolbarTouchscreenBlocksFocus(boolean r8) {
        throw null;
    }

    public void setTransitionState(b r8) {
        if (this.f4908m.equals(r8) == false) goto L6;
        return;
    L6:
        if (r8 != b.f4912b) goto L9;
        boolean r10 = true;
    L11:
        setModalForAccessibility(r10);
    L12:
        this.f4908m = r8;
        Iterator r11 = new LinkedHashSet(null).iterator();
    L14:
        if (r11.hasNext() == false) goto L18;
        ((a) r11.next()).a();
        goto L14
    L18:
        return;
    L9:
        if (r8 != b.f4911a) goto L12;
        r10 = false;
        goto L11
    }

    public void setUseWindowInsetsController(boolean r8) {
    }

    public void setVisible(boolean r8) {
        throw null;
    }

    public void setupWithSearchBar(SearchBar r8) {
        this.f4906a = r8;
        throw null;
    }

    public void setHint(CharSequence r8) {
        throw null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence r8) {
        throw null;
    }
}
