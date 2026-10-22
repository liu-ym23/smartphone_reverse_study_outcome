package com.bytedance.ies.uikit.tabhost;

import ai.j0;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f6257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6258c;
    public TabHost.OnTabChangeListener d;
    public boolean e;
    public boolean f;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6259a;

        static {
            CREATOR = new c();
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("FragmentTabHost.SavedState{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" curTab=");
            return j0.q(r5, this.f6259a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeString(this.f6259a);
        }
    }

    public FragmentTabHost(Context r5) {
        super(r5, null);
        this.f6256a = false;
        this.f6257b = new ArrayList();
        this.f = false;
        TypedArray r10 = r5.obtainStyledAttributes(null, new int[]{R.attr.inflatedId}, 0, 0);
        this.f6258c = r10.getResourceId(0, 0);
        r10.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.widget.TabHost, android.view.ViewGroup, android.view.View
    public final void dispatchWindowFocusChanged(boolean r5) {
        if (this.f6256a == false) goto L8;
        int r10 = getChildCount();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        getChildAt(r11).dispatchWindowFocusChanged(r5);
        r11 = r11 + 1;
        goto L5
    L7:
        return;
    L8:
        super.dispatchWindowFocusChanged(r5);
    }

    public Fragment getCurrentFragment() {
        return null;
    }

    public boolean getDispatchWindowFocusChangedToAllTab() {
        return this.f6256a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getCurrentTabTag();
        ArrayList r5 = this.f6257b;
        if (r5.size() > 0) goto L9;
        this.e = true;
        this.f = true;
        if (r5.size() > 0) goto L7;
        return;
    L7:
        r5.get(0).getClass();
        throw new ClassCastException();
    L9:
        r5.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e = false;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Context r5 = getContext();
        if (r5 != null) goto L6;
        return;
    L6:
        if (findViewById(R.id.tabs) != null) goto L9;
        LinearLayout r10 = new LinearLayout(r5);
        r10.setOrientation(1);
        addView(r10, new FrameLayout.LayoutParams(-1, -1));
        TabWidget r11 = new TabWidget(r5);
        r11.setId(R.id.tabs);
        r11.setOrientation(0);
        r10.addView(r11, new LinearLayout.LayoutParams(-1, -2, 0.0f));
        FrameLayout r12 = new FrameLayout(r5);
        r12.setId(R.id.tabcontent);
        r10.addView(r12, new LinearLayout.LayoutParams(0, 0, 0.0f));
        FrameLayout r13 = new FrameLayout(r5);
        r13.setId(this.f6258c);
        r10.addView(r13, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setCurrentTabByTag(r10.f6259a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.f6259a = getCurrentTabTag();
        return r5;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public final void onTabChanged(String r5) {
        if (this.e == false) goto L9;
        this.f = true;
        ArrayList r10 = this.f6257b;
        if (r10.size() <= 0) goto L9;
        r10.get(0).getClass();
        throw new ClassCastException();
    L9:
        TabHost.OnTabChangeListener r11 = this.d;
        if (r11 == null) goto L13;
        r11.onTabChanged(r5);
        return;
    }

    public void setDispatchWindowFocusChangedToAllTab(boolean r5) {
        this.f6256a = r5;
    }

    public void setHideWhenTabChanged(boolean r5) {
        if (this.f == true) goto L5;
        return;
    L5:
        Log.w("FragmentTabHost", "setHideWhenTabChanged after onTabChanged, ignore");
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener r5) {
        this.d = r5;
    }

    public void setOnTabSwitchListener(b r5) {
    }

    public void setSuperOnTabChangedListener(TabHost.OnTabChangeListener r5) {
        super.setOnTabChangedListener(r5);
    }

    public void setTabSwitchInterceptListener(a r5) {
    }

    @Override // android.widget.TabHost
    public final void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public FragmentTabHost(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f6256a = false;
        this.f6257b = new ArrayList();
        this.f = false;
        TypedArray r11 = r5.obtainStyledAttributes(r10, new int[]{R.attr.inflatedId}, 0, 0);
        this.f6258c = r11.getResourceId(0, 0);
        r11.recycle();
        super.setOnTabChangedListener(this);
    }
}
