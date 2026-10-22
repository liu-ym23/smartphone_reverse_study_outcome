package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public FragmentPagerAdapter(@NonNull FragmentManager r5) {
        this(r5, 0);
    }

    private static String makeFragmentName(int r5, long r10) {
        return "android:switcher:" + r5 + ":" + r10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup r5, int r10, @NonNull Object r11) {
        Fragment r12 = (Fragment) r11;
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        this.mCurTransaction.detach(r12);
        if (r12.equals(this.mCurrentPrimaryItem) == false) goto L9;
        this.mCurrentPrimaryItem = null;
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup r5) {
        FragmentTransaction r10 = this.mCurTransaction;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mExecutingFinishUpdate == false) goto L14;
    L12:
        this.mCurTransaction = null;
        return;
    L14:
        this.mExecutingFinishUpdate = true;     // Catch: Throwable -> L9
        r10.commitNowAllowingStateLoss();     // Catch: Throwable -> L9
        this.mExecutingFinishUpdate = false;
    L9:
        th = move-exception;
        this.mExecutingFinishUpdate = false;
        throw th;
    }

    @NonNull
    public abstract Fragment getItem(int r5);

    public long getItemId(int r5) {
        return r5;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r5, int r10) {
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        long r11 = getItemId(r10);
        String r12 = makeFragmentName(r5.getId(), r11);
        Fragment r13 = this.mFragmentManager.findFragmentByTag(r12);
        if (r13 == null) goto L8;
        this.mCurTransaction.attach(r13);
    L10:
        if (r13 == this.mCurrentPrimaryItem) goto L15;
        r13.setMenuVisibility(false);
        if (this.mBehavior != 1) goto L14;
        this.mCurTransaction.setMaxLifecycle(r13, Lifecycle.State.STARTED);
        goto L15
    L14:
        r13.setUserVisibleHint(false);
    L15:
        return r13;
    L8:
        r13 = getItem(r10);
        this.mCurTransaction.add(r5.getId(), r13, makeFragmentName(r5.getId(), r11));
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r5, @NonNull Object r10) {
        if (((Fragment) r10).getView() != r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable r5, @Nullable ClassLoader r10) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup r5, int r10, @NonNull Object r11) {
        Fragment r12 = (Fragment) r11;
        Fragment r13 = this.mCurrentPrimaryItem;
        if (r12 != r13) goto L5;
        return;
    L5:
        if (r13 == null) goto L13;
        r13.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L11:
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r12.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r12.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r12;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L18:
        this.mCurTransaction.setMaxLifecycle(r12, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup r5) {
        if (r5.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentPagerAdapter(@NonNull FragmentManager r5, int r10) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r5;
        this.mBehavior = r10;
    }
}
