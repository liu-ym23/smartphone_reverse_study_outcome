package androidx.fragment.app;

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

    static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context r10) {
            this.mContext = r10;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String r10) {
            View r11 = new View(this.mContext);
            r11.setMinimumWidth(0);
            r11.setMinimumHeight(0);
            return r11;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String curTab;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r10) {
            super(r10);
            this.curTab = r10.readString();
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeString(this.curTab);
        }
    }

    static final class TabInfo {

        @Nullable
        final Bundle args;

        @NonNull
        final Class<?> clss;
        Fragment fragment;

        @NonNull
        final String tag;

        TabInfo(@NonNull String r10, @NonNull Class<?> r11, @Nullable Bundle r12) {
            this.tag = r10;
            this.clss = r11;
            this.args = r12;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r10) {
        super(r10, null);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r10, null);
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mTabs = new ArrayList();
        initFragmentTabHost(r10, r11);
    }

    @Nullable
    private FragmentTransaction doTabChanged(@Nullable String r10, @Nullable FragmentTransaction r11) {
        TabInfo r12 = getTabInfoForTag(r10);
        if (this.mLastTab == r12) goto L17;
        if (r11 != null) goto L6;
        r11 = this.mFragmentManager.beginTransaction();
    L6:
        TabInfo r13 = this.mLastTab;
        if (r13 == null) goto L11;
        Fragment r14 = r13.fragment;
        if (r14 == null) goto L11;
        r11.detach(r14);
    L11:
        if (r12 == null) goto L16;
        Fragment r15 = r12.fragment;
        if (r15 != null) goto L15;
        Fragment r16 = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), r12.clss.getName());
        r12.fragment = r16;
        r16.setArguments(r12.args);
        r11.add(this.mContainerId, r12.fragment, r12.tag);
        goto L16
    L15:
        r11.attach(r15);
    L16:
        this.mLastTab = r12;
    L17:
        return r11;
    }

    private void ensureContent() {
        if (this.mRealTabContent != null) goto L9;
        FrameLayout r10 = (FrameLayout) findViewById(this.mContainerId);
        this.mRealTabContent = r10;
        if (r10 == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
    }

    private void ensureHierarchy(Context r10) {
        if (findViewById(R.id.tabs) != null) goto L6;
        LinearLayout r11 = new LinearLayout(r10);
        r11.setOrientation(1);
        addView(r11, new FrameLayout.LayoutParams(-1, -1));
        TabWidget r12 = new TabWidget(r10);
        r12.setId(R.id.tabs);
        r12.setOrientation(0);
        r11.addView(r12, new LinearLayout.LayoutParams(-1, -2, 0.0f));
        FrameLayout r13 = new FrameLayout(r10);
        r13.setId(R.id.tabcontent);
        r11.addView(r13, new LinearLayout.LayoutParams(0, 0, 0.0f));
        FrameLayout r14 = new FrameLayout(r10);
        this.mRealTabContent = r14;
        r14.setId(this.mContainerId);
        r11.addView(r14, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return;
    }

    @Nullable
    private TabInfo getTabInfoForTag(String r10) {
        int r11 = this.mTabs.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        TabInfo r13 = this.mTabs.get(r12);
        if (r13.tag.equals(r10) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    private void initFragmentTabHost(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{R.attr.inflatedId}, 0, 0);
        this.mContainerId = r12.getResourceId(0, 0);
        r12.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec r10, @NonNull Class<?> r11, @Nullable Bundle r12) {
        r10.setContent(new DummyTabFactory(this.mContext));
        String r13 = r10.getTag();
        TabInfo r14 = new TabInfo(r13, r11, r12);
        if (this.mAttached == false) goto L9;
        Fragment r15 = this.mFragmentManager.findFragmentByTag(r13);
        r14.fragment = r15;
        if (r15 == null) goto L9;
        if (r15.isDetached() == true) goto L9;
        FragmentTransaction r16 = this.mFragmentManager.beginTransaction();
        r16.detach(r14.fragment);
        r16.commit();
    L9:
        this.mTabs.add(r14);
        addTab(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = getCurrentTabTag();
        int r11 = this.mTabs.size();
        FragmentTransaction r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L15;
        TabInfo r14 = this.mTabs.get(r13);
        Fragment r15 = this.mFragmentManager.findFragmentByTag(r14.tag);
        r14.fragment = r15;
        if (r15 == null) goto L14;
        if (r15.isDetached() == true) goto L14;
        if (r14.tag.equals(r10) == false) goto L11;
        this.mLastTab = r14;
        goto L14
    L11:
        if (r12 != null) goto L13;
        r12 = this.mFragmentManager.beginTransaction();
    L13:
        r12.detach(r14.fragment);
    L14:
        r13 = r13 + 1;
        goto L3
    L15:
        this.mAttached = true;
        FragmentTransaction r16 = doTabChanged(r10, r12);
        if (r16 == null) goto L24;
        r16.commit();
        this.mFragmentManager.executePendingTransactions();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setCurrentTabByTag(r11.curTab);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.curTab = getCurrentTabTag();
        return r10;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String r10) {
        if (this.mAttached == false) goto L7;
        FragmentTransaction r11 = doTabChanged(r10, null);
        if (r11 == null) goto L7;
        r11.commit();
    L7:
        TabHost.OnTabChangeListener r12 = this.mOnTabChangeListener;
        if (r12 == null) goto L11;
        r12.onTabChanged(r10);
        return;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener r10) {
        this.mOnTabChangeListener = r10;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context r10, @NonNull FragmentManager r11) {
        ensureHierarchy(r10);
        super.setup();
        this.mContext = r10;
        this.mFragmentManager = r11;
        ensureContent();
    }

    @Deprecated
    public void setup(@NonNull Context r10, @NonNull FragmentManager r11, int r12) {
        ensureHierarchy(r10);
        super.setup();
        this.mContext = r10;
        this.mFragmentManager = r11;
        this.mContainerId = r12;
        ensureContent();
        this.mRealTabContent.setId(r12);
        if (getId() != (-1)) goto L6;
        setId(R.id.tabhost);
        return;
    }
}
