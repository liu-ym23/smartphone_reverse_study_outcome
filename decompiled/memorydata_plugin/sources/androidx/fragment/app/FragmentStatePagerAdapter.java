package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    public FragmentStatePagerAdapter(FragmentManager r2) {
        this(r2, 0);
    }

    public FragmentStatePagerAdapter(FragmentManager r3, int r4) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r3;
        this.mBehavior = r4;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r3, int r4, Object r5) {
        Fragment r6 = (Fragment) ZeusTransformUtils.preCheckCast(r5, Fragment.class, "com.obric.memorydata.plugin");
        if (this.mCurTransaction != null) goto L6;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L6:
        if (this.mSavedState.size() > r4) goto L8;
        this.mSavedState.add(null);
        goto L6
    L8:
        ArrayList<Fragment.SavedState> r7 = this.mSavedState;
        if (r6.isAdded() == false) goto L11;
        Fragment.SavedState r1 = this.mFragmentManager.saveFragmentInstanceState(r6);
    L12:
        r7.set(r4, r1);
        this.mFragments.set(r4, null);
        this.mCurTransaction.remove(r6);
        if (r6.equals(this.mCurrentPrimaryItem) == false) goto L18;
        this.mCurrentPrimaryItem = null;
        return;
    L18:
        return;
    L11:
        r1 = null;
        goto L12
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup r3) {
        FragmentTransaction r4 = this.mCurTransaction;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mExecutingFinishUpdate == false) goto L14;
    L12:
        this.mCurTransaction = null;
        return;
    L14:
        this.mExecutingFinishUpdate = true;     // Catch: Throwable -> L9
        r4.commitNowAllowingStateLoss();     // Catch: Throwable -> L9
        this.mExecutingFinishUpdate = false;
    L9:
        th = move-exception;
        this.mExecutingFinishUpdate = false;
        throw th;
    }

    public abstract Fragment getItem(int r1);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r5, int r6) {
        if (this.mFragments.size() <= r6) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.mFragments.get(r6), Fragment.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (this.mCurTransaction != null) goto L10;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L10:
        Fragment r1 = getItem(r6);
        if (this.mSavedState.size() <= r6) goto L16;
        Fragment.SavedState r2 = (Fragment.SavedState) ZeusTransformUtils.preCheckCast(this.mSavedState.get(r6), Fragment.SavedState.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        r1.setInitialSavedState(r2);
    L16:
        if (this.mFragments.size() > r6) goto L18;
        this.mFragments.add(null);
        goto L16
    L18:
        r1.setMenuVisibility(false);
        if (this.mBehavior != 0) goto L21;
        r1.setUserVisibleHint(false);
    L21:
        this.mFragments.set(r6, r1);
        this.mCurTransaction.add(r5.getId(), r1);
        if (this.mBehavior != 1) goto L24;
        this.mCurTransaction.setMaxLifecycle(r1, Lifecycle.State.STARTED);
    L24:
        return r1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r2, Object r3) {
        if (((Fragment) ZeusTransformUtils.preCheckCast(r3, Fragment.class, "com.obric.memorydata.plugin")).getView() != r2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r7, ClassLoader r8) {
        Parcelable r9 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L22;
        Bundle r10 = (Bundle) ZeusTransformUtils.preCheckCast(r9, Bundle.class, "com.obric.memorydata.plugin");
        r10.setClassLoader(r8);
        Parcelable[] r11 = r10.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        if (r11 == null) goto L10;
        int r2 = 0;
    L8:
        if (r2 >= r11.length) goto L10;
        this.mSavedState.add((Fragment.SavedState) ZeusTransformUtils.preCheckCast(r11[r2], Fragment.SavedState.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
    L10:
        Iterator<T> r12 = r10.keySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L33;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.startsWith(f.f1488a) == false) goto L12;
        int r4 = Integer.parseInt(r3.substring(1));
        Fragment r5 = this.mFragmentManager.getFragment(r10, r3);
        if (r5 != null) goto L18;
        Log.w(TAG, "Bad fragment at key " + r3);
    L18:
        if (this.mFragments.size() > r4) goto L20;
        this.mFragments.add(null);
        goto L18
    L20:
        r5.setMenuVisibility(false);
        this.mFragments.set(r4, r5);
        goto L12
    L33:
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        if (this.mSavedState.size() <= 0) goto L5;
        Bundle r0 = new Bundle();
        Fragment.SavedState[] r1 = new Fragment.SavedState[this.mSavedState.size()];
        this.mSavedState.toArray(r1);
        r0.putParcelableArray("states", r1);
    L6:
        int r2 = 0;
    L8:
        if (r2 >= this.mFragments.size()) goto L17;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(this.mFragments.get(r2), Fragment.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L16;
        if (r3.isAdded() == false) goto L16;
        if (r0 != null) goto L15;
        r0 = new Bundle();
    L15:
        this.mFragmentManager.putFragment(r0, f.f1488a + r2, r3);
    L16:
        r2 = r2 + 1;
        goto L8
    L17:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r3, int r4, Object r5) {
        Fragment r6 = (Fragment) ZeusTransformUtils.preCheckCast(r5, Fragment.class, "com.obric.memorydata.plugin");
        Fragment r7 = this.mCurrentPrimaryItem;
        if (r6 != r7) goto L5;
        return;
    L5:
        if (r7 == null) goto L13;
        r7.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L11:
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r6.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r6.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r6;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L18:
        this.mCurTransaction.setMaxLifecycle(r6, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup r3) {
        if (r3.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
