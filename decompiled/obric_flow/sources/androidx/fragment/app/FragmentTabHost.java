package androidx.fragment.app;

import ai.j0;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<TabInfo> mTabs;

    public static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context r5) {
            this.mContext = r5;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String r5) {
            View r10 = new View(this.mContext);
            r10.setMinimumWidth(0);
            r10.setMinimumHeight(0);
            return r10;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String curTab;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("FragmentTabHost.SavedState{");
            r5.append(Integer.toHexString(System.identityHashCode(this)));
            r5.append(" curTab=");
            return j0.q(r5, this.curTab, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeString(this.curTab);
        }

        public SavedState(Parcel r5) {
            super(r5);
            this.curTab = r5.readString();
        }
    }

    public static final class TabInfo {

        @Nullable
        final Bundle args;

        @NonNull
        final Class<?> clss;
        Fragment fragment;

        @NonNull
        final String tag;

        public TabInfo(@NonNull String r5, @NonNull Class<?> r10, @Nullable Bundle r11) {
            this.tag = r5;
            this.clss = r10;
            this.args = r11;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r5) {
        super(r5, null);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r5, null);
    }

    @Nullable
    private FragmentTransaction doTabChanged(@Nullable String r5, @Nullable FragmentTransaction r10) {
        TabInfo r11 = getTabInfoForTag(r5);
        if (this.mLastTab == r11) goto L17;
        if (r10 != null) goto L6;
        r10 = this.mFragmentManager.beginTransaction();
    L6:
        TabInfo r12 = this.mLastTab;
        if (r12 == null) goto L11;
        Fragment r13 = r12.fragment;
        if (r13 == null) goto L11;
        r10.detach(r13);
    L11:
        if (r11 == null) goto L16;
        Fragment r14 = r11.fragment;
        if (r14 != null) goto L15;
        Fragment r15 = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), r11.clss.getName());
        r11.fragment = r15;
        r15.setArguments(r11.args);
        r10.add(this.mContainerId, r11.fragment, r11.tag);
        goto L16
    L15:
        r10.attach(r14);
    L16:
        this.mLastTab = r11;
    L17:
        return r10;
    }

    private void ensureContent() {
        if (this.mRealTabContent != null) goto L9;
        FrameLayout r5 = (FrameLayout) findViewById(this.mContainerId);
        this.mRealTabContent = r5;
        if (r5 == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
    }

    private void ensureHierarchy(Context r10) {
        if (findViewById(R.id.tabs) != null) goto L6;
        LinearLayout r5 = new LinearLayout(r10);
        r5.setOrientation(1);
        addView(r5, new FrameLayout.LayoutParams(-1, -1));
        TabWidget r11 = new TabWidget(r10);
        r11.setId(R.id.tabs);
        r11.setOrientation(0);
        r5.addView(r11, new LinearLayout.LayoutParams(-1, -2, 0.0f));
        FrameLayout r12 = new FrameLayout(r10);
        r12.setId(R.id.tabcontent);
        r5.addView(r12, new LinearLayout.LayoutParams(0, 0, 0.0f));
        FrameLayout r13 = new FrameLayout(r10);
        this.mRealTabContent = r13;
        r13.setId(this.mContainerId);
        r5.addView(r13, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return;
    }

    @Nullable
    private TabInfo getTabInfoForTag(String r5) {
        int r10 = this.mTabs.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        TabInfo r12 = this.mTabs.get(r11);
        if (r12.tag.equals(r5) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return null;
    }

    private void initFragmentTabHost(Context r5, AttributeSet r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10, new int[]{R.attr.inflatedId}, 0, 0);
        this.mContainerId = r11.getResourceId(0, 0);
        r11.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec r5, @NonNull Class<?> r10, @Nullable Bundle r11) {
        r5.setContent(new DummyTabFactory(this.mContext));
        String r12 = r5.getTag();
        TabInfo r13 = new TabInfo(r12, r10, r11);
        if (this.mAttached == false) goto L9;
        Fragment r14 = this.mFragmentManager.findFragmentByTag(r12);
        r13.fragment = r14;
        if (r14 == null) goto L9;
        if (r14.isDetached() == true) goto L9;
        FragmentTransaction r15 = this.mFragmentManager.beginTransaction();
        r15.detach(r13.fragment);
        r15.commit();
    L9:
        this.mTabs.add(r13);
        addTab(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r5 = getCurrentTabTag();
        int r10 = this.mTabs.size();
        FragmentTransaction r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L15;
        TabInfo r13 = this.mTabs.get(r12);
        Fragment r14 = this.mFragmentManager.findFragmentByTag(r13.tag);
        r13.fragment = r14;
        if (r14 == null) goto L14;
        if (r14.isDetached() == true) goto L14;
        if (r13.tag.equals(r5) == false) goto L11;
        this.mLastTab = r13;
        goto L14
    L11:
        if (r11 != null) goto L13;
        r11 = this.mFragmentManager.beginTransaction();
    L13:
        r11.detach(r13.fragment);
    L14:
        r12 = r12 + 1;
        goto L3
    L15:
        this.mAttached = true;
        FragmentTransaction r15 = doTabChanged(r5, r11);
        if (r15 == null) goto L24;
        r15.commit();
        this.mFragmentManager.executePendingTransactions();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setCurrentTabByTag(r10.curTab);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.curTab = getCurrentTabTag();
        return r5;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String r5) {
        if (this.mAttached == false) goto L7;
        FragmentTransaction r10 = doTabChanged(r5, null);
        if (r10 == null) goto L7;
        r10.commit();
    L7:
        TabHost.OnTabChangeListener r11 = this.mOnTabChangeListener;
        if (r11 == null) goto L11;
        r11.onTabChanged(r5);
        return;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener r5) {
        this.mOnTabChangeListener = r5;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context r5, @NonNull FragmentManager r10) {
        ensureHierarchy(r5);
        super.setup();
        this.mContext = r5;
        this.mFragmentManager = r10;
        ensureContent();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r5, r10);
    }

    @Deprecated
    public void setup(@NonNull Context r5, @NonNull FragmentManager r10, int r11) {
        ensureHierarchy(r5);
        super.setup();
        this.mContext = r5;
        this.mFragmentManager = r10;
        this.mContainerId = r11;
        ensureContent();
        this.mRealTabContent.setId(r11);
        if (getId() != (-1)) goto L6;
        setId(R.id.tabhost);
        return;
    }
}
