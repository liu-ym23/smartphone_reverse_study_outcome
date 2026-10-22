package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE = 8197;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN = 4100;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    String mName;
    ArrayList<Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        boolean mFromExpandedOp;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        Op() {
        }

        Op(int r1, Fragment r2) {
            this.mCmd = r1;
            this.mFragment = r2;
            this.mFromExpandedOp = false;
            this.mOldMaxState = Lifecycle.State.RESUMED;
            this.mCurrentMaxState = Lifecycle.State.RESUMED;
        }

        Op(int r1, Fragment r2, Lifecycle.State r3) {
            this.mCmd = r1;
            this.mFragment = r2;
            this.mFromExpandedOp = false;
            this.mOldMaxState = r2.mMaxState;
            this.mCurrentMaxState = r3;
        }

        Op(int r1, Fragment r2, boolean r3) {
            this.mCmd = r1;
            this.mFragment = r2;
            this.mFromExpandedOp = r3;
            this.mOldMaxState = Lifecycle.State.RESUMED;
            this.mCurrentMaxState = Lifecycle.State.RESUMED;
        }

        Op(Op r2) {
            this.mCmd = r2.mCmd;
            this.mFragment = r2.mFragment;
            this.mFromExpandedOp = r2.mFromExpandedOp;
            this.mEnterAnim = r2.mEnterAnim;
            this.mExitAnim = r2.mExitAnim;
            this.mPopEnterAnim = r2.mPopEnterAnim;
            this.mPopExitAnim = r2.mPopExitAnim;
            this.mOldMaxState = r2.mOldMaxState;
            this.mCurrentMaxState = r2.mCurrentMaxState;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    FragmentTransaction(FragmentFactory r2, ClassLoader r3) {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = r2;
        this.mClassLoader = r3;
    }

    FragmentTransaction(FragmentFactory r3, ClassLoader r4, FragmentTransaction r5) {
        this(r3, r4);
        Iterator<Op> r6 = r5.mOps.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Op r7 = (Op) ZeusTransformUtils.preCheckCast(r6.next(), Op.class, "com.obric.memorydata.plugin");
        this.mOps.add(new Op(r7));
        goto L4
    L6:
        this.mEnterAnim = r5.mEnterAnim;
        this.mExitAnim = r5.mExitAnim;
        this.mPopEnterAnim = r5.mPopEnterAnim;
        this.mPopExitAnim = r5.mPopExitAnim;
        this.mTransition = r5.mTransition;
        this.mAddToBackStack = r5.mAddToBackStack;
        this.mAllowAddToBackStack = r5.mAllowAddToBackStack;
        this.mName = r5.mName;
        this.mBreadCrumbShortTitleRes = r5.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r5.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = r5.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r5.mBreadCrumbTitleText;
        if (r5.mSharedElementSourceNames == null) goto L10;
        ArrayList<String> r8 = new ArrayList();
        this.mSharedElementSourceNames = r8;
        r8.addAll(r5.mSharedElementSourceNames);
    L10:
        if (r5.mSharedElementTargetNames == null) goto L12;
        ArrayList<String> r9 = new ArrayList();
        this.mSharedElementTargetNames = r9;
        r9.addAll(r5.mSharedElementTargetNames);
    L12:
        this.mReorderingAllowed = r5.mReorderingAllowed;
    }

    private Fragment createFragment(Class<? extends Fragment> r2, Bundle r3) {
        FragmentFactory r0 = this.mFragmentFactory;
        if (r0 == null) goto L13;
        ClassLoader r1 = this.mClassLoader;
        if (r1 == null) goto L11;
        Fragment r4 = r0.instantiate(r1, r2.getName());
        if (r3 == null) goto L9;
        r4.setArguments(r3);
    L9:
        return r4;
    L11:
        throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
    L13:
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public FragmentTransaction add(int r3, Fragment r4) {
        doAddOp(r3, r4, null, 1);
        return this;
    }

    public FragmentTransaction add(int r2, Fragment r3, String r4) {
        doAddOp(r2, r3, r4, 1);
        return this;
    }

    public final FragmentTransaction add(int r1, Class<? extends Fragment> r2, Bundle r3) {
        return add(r1, createFragment(r2, r3));
    }

    public final FragmentTransaction add(int r1, Class<? extends Fragment> r2, Bundle r3, String r4) {
        return add(r1, createFragment(r2, r3), r4);
    }

    FragmentTransaction add(ViewGroup r1, Fragment r2, String r3) {
        r2.mContainer = r1;
        return add(r1.getId(), r2, r3);
    }

    public FragmentTransaction add(Fragment r3, String r4) {
        doAddOp(0, r3, r4, 1);
        return this;
    }

    public final FragmentTransaction add(Class<? extends Fragment> r1, Bundle r2, String r3) {
        return add(createFragment(r1, r2), r3);
    }

    void addOp(Op r2) {
        this.mOps.add(r2);
        r2.mEnterAnim = this.mEnterAnim;
        r2.mExitAnim = this.mExitAnim;
        r2.mPopEnterAnim = this.mPopEnterAnim;
        r2.mPopExitAnim = this.mPopExitAnim;
    }

    public FragmentTransaction addSharedElement(View r3, String r4) {
        if (FragmentTransition.supportsTransition() == false) goto L20;
        String r5 = ViewCompat.getTransitionName(r3);
        if (r5 == null) goto L19;
        if (this.mSharedElementSourceNames != null) goto L10;
        this.mSharedElementSourceNames = new ArrayList();
        this.mSharedElementTargetNames = new ArrayList();
    L13:
        this.mSharedElementSourceNames.add(r5);
        this.mSharedElementTargetNames.add(r4);
        goto L20
    L10:
        if (this.mSharedElementTargetNames.contains(r4) == true) goto L17;
        if (this.mSharedElementSourceNames.contains(r5) == false) goto L13;
        throw new IllegalArgumentException("A shared element with the source name '" + r5 + "' has already been added to the transaction.");
    L17:
        throw new IllegalArgumentException("A shared element with the target name '" + r4 + "' has already been added to the transaction.");
    L19:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    L20:
        return this;
    }

    public FragmentTransaction addToBackStack(String r2) {
        if (this.mAllowAddToBackStack == false) goto L7;
        this.mAddToBackStack = true;
        this.mName = r2;
        return this;
    L7:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction attach(Fragment r3) {
        addOp(new Op(7, r3));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public FragmentTransaction detach(Fragment r3) {
        addOp(new Op(6, r3));
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack == true) goto L7;
        this.mAllowAddToBackStack = false;
        return this;
    L7:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    void doAddOp(int r4, Fragment r5, String r6, int r7) {
        if (r5.mPreviousWho == null) goto L5;
        FragmentStrictMode.onFragmentReuse(r5, r5.mPreviousWho);
    L5:
        Class<?> r0 = r5.getClass();
        int r1 = r0.getModifiers();
        if (r0.isAnonymousClass() == true) goto L39;
        if (Modifier.isPublic(r1) == false) goto L39;
        if (r0.isMemberClass() == false) goto L14;
        if (Modifier.isStatic(r1) == false) goto L39;
    L14:
        if (r6 != null) goto L16;
    L23:
        if (r4 != 0) goto L25;
    L36:
        addOp(new Op(r7, r5));
        return;
    L25:
        if (r4 == (-1)) goto L35;
        if (r5.mFragmentId != 0) goto L29;
    L33:
        r5.mFragmentId = r4;
        r5.mContainerId = r4;
        goto L36
    L29:
        if (r5.mFragmentId == r4) goto L33;
        throw new IllegalStateException("Can't change container ID of fragment " + r5 + ": was " + r5.mFragmentId + " now " + r4);
    L35:
        throw new IllegalArgumentException("Can't add fragment " + r5 + " with tag " + r6 + " to container view with no id");
    L16:
        if (r5.mTag != null) goto L18;
    L22:
        r5.mTag = r6;
        goto L23
    L18:
        if (r6.equals(r5.mTag) == true) goto L22;
        throw new IllegalStateException("Can't change tag of fragment " + r5 + ": was " + r5.mTag + " now " + r6);
    L39:
        throw new IllegalStateException("Fragment " + r0.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public FragmentTransaction hide(Fragment r3) {
        addOp(new Op(4, r3));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public FragmentTransaction remove(Fragment r3) {
        addOp(new Op(3, r3));
        return this;
    }

    public FragmentTransaction replace(int r2, Fragment r3) {
        return replace(r2, r3, null);
    }

    public FragmentTransaction replace(int r2, Fragment r3, String r4) {
        if (r2 == 0) goto L6;
        doAddOp(r2, r3, r4, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public final FragmentTransaction replace(int r2, Class<? extends Fragment> r3, Bundle r4) {
        return replace(r2, r3, r4, null);
    }

    public final FragmentTransaction replace(int r1, Class<? extends Fragment> r2, Bundle r3, String r4) {
        return replace(r1, createFragment(r2, r3), r4);
    }

    public FragmentTransaction runOnCommit(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        disallowAddToBackStack();
        if (this.mCommitRunnables != null) goto L5;
        this.mCommitRunnables = new ArrayList();
    L5:
        this.mCommitRunnables.add(r4);
        return this;
    }

    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean r1) {
        return setReorderingAllowed(r1);
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(int r1) {
        this.mBreadCrumbShortTitleRes = r1;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = r4;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(int r1) {
        this.mBreadCrumbTitleRes = r1;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = r4;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int r2, int r3) {
        return setCustomAnimations(r2, r3, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int r1, int r2, int r3, int r4) {
        this.mEnterAnim = r1;
        this.mExitAnim = r2;
        this.mPopEnterAnim = r3;
        this.mPopExitAnim = r4;
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment r3, Lifecycle.State r4) {
        addOp(new Op(10, r3, r4));
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment r3) {
        addOp(new Op(8, r3));
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean r1) {
        this.mReorderingAllowed = r1;
        return this;
    }

    public FragmentTransaction setTransition(int r1) {
        this.mTransition = r1;
        return this;
    }

    @Deprecated
    public FragmentTransaction setTransitionStyle(int r1) {
        return this;
    }

    public FragmentTransaction show(Fragment r3) {
        addOp(new Op(5, r3));
        return this;
    }
}
