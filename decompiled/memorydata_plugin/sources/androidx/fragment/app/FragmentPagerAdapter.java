package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

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
    public FragmentPagerAdapter(FragmentManager r2) {
        this(r2, 0);
    }

    public FragmentPagerAdapter(FragmentManager r2, int r3) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r2;
        this.mBehavior = r3;
    }

    private static String makeFragmentName(int r2, long r3) {
        return "android:switcher:" + r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r1, int r2, Object r3) {
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(r3, Fragment.class, "com.obric.memorydata.plugin");
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        this.mCurTransaction.detach(r4);
        if (r4.equals(this.mCurrentPrimaryItem) == false) goto L9;
        this.mCurrentPrimaryItem = null;
        return;
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

    public long getItemId(int r1) {
        return r1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r5, int r6) {
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        long r0 = getItemId(r6);
        String r2 = makeFragmentName(r5.getId(), r0);
        Fragment r3 = this.mFragmentManager.findFragmentByTag(r2);
        if (r3 == null) goto L8;
        this.mCurTransaction.attach(r3);
    L10:
        if (r3 == this.mCurrentPrimaryItem) goto L15;
        r3.setMenuVisibility(false);
        if (this.mBehavior != 1) goto L14;
        this.mCurTransaction.setMaxLifecycle(r3, Lifecycle.State.STARTED);
        goto L15
    L14:
        r3.setUserVisibleHint(false);
    L15:
        return r3;
    L8:
        r3 = getItem(r6);
        this.mCurTransaction.add(r5.getId(), r3, makeFragmentName(r5.getId(), r0));
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r2, Object r3) {
        if (((Fragment) ZeusTransformUtils.preCheckCast(r3, Fragment.class, "com.obric.memorydata.plugin")).getView() != r2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r1, ClassLoader r2) {
        Parcelable r0 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r1, Parcelable.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
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
