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
    public FragmentPagerAdapter(@NonNull FragmentManager r10) {
        this(r10, 0);
    }

    public FragmentPagerAdapter(@NonNull FragmentManager r10, int r11) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r10;
        this.mBehavior = r11;
    }

    private static String makeFragmentName(int r10, long r11) {
        return "android:switcher:" + r10 + ":" + r11;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        Fragment r13 = (Fragment) r12;
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        this.mCurTransaction.detach(r13);
        if (r13.equals(this.mCurrentPrimaryItem) == false) goto L9;
        this.mCurrentPrimaryItem = null;
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup r10) {
        FragmentTransaction r11 = this.mCurTransaction;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.mExecutingFinishUpdate == false) goto L14;
    L12:
        this.mCurTransaction = null;
        return;
    L14:
        this.mExecutingFinishUpdate = true;     // Catch: Throwable -> L9
        r11.commitNowAllowingStateLoss();     // Catch: Throwable -> L9
        this.mExecutingFinishUpdate = false;
    L9:
        th = move-exception;
        this.mExecutingFinishUpdate = false;
        throw th;
    }

    @NonNull
    public abstract Fragment getItem(int r10);

    public long getItemId(int r10) {
        return r10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r10, int r11) {
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        long r12 = getItemId(r11);
        String r13 = makeFragmentName(r10.getId(), r12);
        Fragment r14 = this.mFragmentManager.findFragmentByTag(r13);
        if (r14 == null) goto L8;
        this.mCurTransaction.attach(r14);
    L10:
        if (r14 == this.mCurrentPrimaryItem) goto L15;
        r14.setMenuVisibility(false);
        if (this.mBehavior != 1) goto L14;
        this.mCurTransaction.setMaxLifecycle(r14, Lifecycle.State.STARTED);
        goto L15
    L14:
        r14.setUserVisibleHint(false);
    L15:
        return r14;
    L8:
        r14 = getItem(r11);
        this.mCurTransaction.add(r10.getId(), r14, makeFragmentName(r10.getId(), r12));
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r10, @NonNull Object r11) {
        if (((Fragment) r11).getView() != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable r10, @Nullable ClassLoader r11) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        Fragment r13 = (Fragment) r12;
        Fragment r14 = this.mCurrentPrimaryItem;
        if (r13 != r14) goto L5;
        return;
    L5:
        if (r14 == null) goto L13;
        r14.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L11:
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r13.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r13.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r13;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L18:
        this.mCurTransaction.setMaxLifecycle(r13, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup r10) {
        if (r10.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
