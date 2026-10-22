package androidx.fragment.app;

import ai.j0;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Fragment.SavedState> mSavedState;

    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager r5) {
        this(r5, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup r5, int r10, @NonNull Object r11) {
        Fragment r12 = (Fragment) r11;
        if (this.mCurTransaction != null) goto L6;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L6:
        if (this.mSavedState.size() > r10) goto L8;
        this.mSavedState.add(null);
        goto L6
    L8:
        ArrayList<Fragment.SavedState> r13 = this.mSavedState;
        if (r12.isAdded() == false) goto L11;
        Fragment.SavedState r14 = this.mFragmentManager.saveFragmentInstanceState(r12);
    L12:
        r13.set(r10, r14);
        this.mFragments.set(r10, null);
        this.mCurTransaction.remove(r12);
        if (r12.equals(this.mCurrentPrimaryItem) == false) goto L18;
        this.mCurrentPrimaryItem = null;
        return;
    L18:
        return;
    L11:
        r14 = null;
        goto L12
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

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r5, int r10) {
        if (this.mFragments.size() <= r10) goto L8;
        Fragment r11 = this.mFragments.get(r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (this.mCurTransaction != null) goto L10;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L10:
        Fragment r12 = getItem(r10);
        if (this.mSavedState.size() <= r10) goto L16;
        Fragment.SavedState r13 = this.mSavedState.get(r10);
        if (r13 == null) goto L16;
        r12.setInitialSavedState(r13);
    L16:
        if (this.mFragments.size() > r10) goto L18;
        this.mFragments.add(null);
        goto L16
    L18:
        r12.setMenuVisibility(false);
        if (this.mBehavior != 0) goto L21;
        r12.setUserVisibleHint(false);
    L21:
        this.mFragments.set(r10, r12);
        this.mCurTransaction.add(r5.getId(), r12);
        if (this.mBehavior != 1) goto L24;
        this.mCurTransaction.setMaxLifecycle(r12, Lifecycle.State.STARTED);
    L24:
        return r12;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r5, @NonNull Object r10) {
        if (((Fragment) r10).getView() != r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable r10, @Nullable ClassLoader r11) {
        if (r10 == null) goto L21;
        Bundle r12 = (Bundle) r10;
        r12.setClassLoader(r11);
        Parcelable[] r13 = r12.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        if (r13 == null) goto L9;
        int r5 = 0;
    L7:
        if (r5 >= r13.length) goto L9;
        this.mSavedState.add((Fragment.SavedState) r13[r5]);
        r5 = r5 + 1;
    L9:
        Iterator<T> r14 = r12.keySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L32;
        String r15 = (String) r14.next();
        if (r15.startsWith("f") == false) goto L11;
        int r16 = Integer.parseInt(r15.substring(1));
        Fragment r17 = this.mFragmentManager.getFragment(r12, r15);
        if (r17 != null) goto L17;
        Log.w(TAG, "Bad fragment at key ".concat(r15));
    L17:
        if (this.mFragments.size() > r16) goto L19;
        this.mFragments.add(null);
        goto L17
    L19:
        r17.setMenuVisibility(false);
        this.mFragments.set(r16, r17);
        goto L11
    L32:
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        if (this.mSavedState.size() <= 0) goto L5;
        Bundle r5 = new Bundle();
        Fragment.SavedState[] r10 = new Fragment.SavedState[this.mSavedState.size()];
        this.mSavedState.toArray(r10);
        r5.putParcelableArray("states", r10);
    L6:
        int r11 = 0;
    L8:
        if (r11 >= this.mFragments.size()) goto L17;
        Fragment r12 = this.mFragments.get(r11);
        if (r12 == null) goto L16;
        if (r12.isAdded() == false) goto L16;
        if (r5 != null) goto L15;
        r5 = new Bundle();
    L15:
        String r13 = j0.g(r11, "f");
        this.mFragmentManager.putFragment(r5, r13, r12);
    L16:
        r11 = r11 + 1;
        goto L8
    L17:
        return r5;
    L5:
        r5 = null;
        goto L6
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

    public FragmentStatePagerAdapter(@NonNull FragmentManager r5, int r10) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r5;
        this.mBehavior = r10;
    }
}
