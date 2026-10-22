package androidx.fragment.app;

import ai.j0;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
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

    @Nullable
    String mName;
    ArrayList<Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    public static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        boolean mFromExpandedOp;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        public Op() {
        }

        public Op(int r5, Fragment r10) {
            this.mCmd = r5;
            this.mFragment = r10;
            this.mFromExpandedOp = false;
            Lifecycle.State r11 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r11;
            this.mCurrentMaxState = r11;
        }

        public Op(int r5, Fragment r10, boolean r11) {
            this.mCmd = r5;
            this.mFragment = r10;
            this.mFromExpandedOp = r11;
            Lifecycle.State r12 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r12;
            this.mCurrentMaxState = r12;
        }

        public Op(int r5, @NonNull Fragment r10, Lifecycle.State r11) {
            this.mCmd = r5;
            this.mFragment = r10;
            this.mFromExpandedOp = false;
            this.mOldMaxState = r10.mMaxState;
            this.mCurrentMaxState = r11;
        }

        public Op(Op r5) {
            this.mCmd = r5.mCmd;
            this.mFragment = r5.mFragment;
            this.mFromExpandedOp = r5.mFromExpandedOp;
            this.mEnterAnim = r5.mEnterAnim;
            this.mExitAnim = r5.mExitAnim;
            this.mPopEnterAnim = r5.mPopEnterAnim;
            this.mPopExitAnim = r5.mPopExitAnim;
            this.mOldMaxState = r5.mOldMaxState;
            this.mCurrentMaxState = r5.mCurrentMaxState;
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

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> r5, @Nullable Bundle r10) {
        FragmentFactory r11 = this.mFragmentFactory;
        if (r11 == null) goto L13;
        ClassLoader r12 = this.mClassLoader;
        if (r12 == null) goto L11;
        Fragment r13 = r11.instantiate(r12, r5.getName());
        if (r10 == null) goto L9;
        r13.setArguments(r10);
    L9:
        return r13;
    L11:
        throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
    L13:
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> r5, @Nullable Bundle r10, @Nullable String r11) {
        return add(createFragment(r5, r10), r11);
    }

    public void addOp(Op r5) {
        this.mOps.add(r5);
        r5.mEnterAnim = this.mEnterAnim;
        r5.mExitAnim = this.mExitAnim;
        r5.mPopEnterAnim = this.mPopEnterAnim;
        r5.mPopExitAnim = this.mPopExitAnim;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View r5, @NonNull String r10) {
        if (FragmentTransition.supportsTransition() == false) goto L20;
        String r11 = ViewCompat.getTransitionName(r5);
        if (r11 == null) goto L19;
        if (this.mSharedElementSourceNames != null) goto L10;
        this.mSharedElementSourceNames = new ArrayList();
        this.mSharedElementTargetNames = new ArrayList();
    L13:
        this.mSharedElementSourceNames.add(r11);
        this.mSharedElementTargetNames.add(r10);
        goto L20
    L10:
        if (this.mSharedElementTargetNames.contains(r10) == true) goto L17;
        if (this.mSharedElementSourceNames.contains(r11) == false) goto L13;
        throw new IllegalArgumentException(j0.k("A shared element with the source name '", r11, "' has already been added to the transaction."));
    L17:
        throw new IllegalArgumentException(j0.k("A shared element with the target name '", r10, "' has already been added to the transaction."));
    L19:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    L20:
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String r5) {
        if (this.mAllowAddToBackStack == false) goto L7;
        this.mAddToBackStack = true;
        this.mName = r5;
        return this;
    L7:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment r5) {
        addOp(new Op(7, r5));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    @MainThread
    public abstract void commitNow();

    @MainThread
    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment r5) {
        addOp(new Op(6, r5));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack == true) goto L7;
        this.mAllowAddToBackStack = false;
        return this;
    L7:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void doAddOp(int r5, Fragment r10, @Nullable String r11, int r12) {
        String r13 = r10.mPreviousWho;
        if (r13 == null) goto L5;
        FragmentStrictMode.onFragmentReuse(r10, r13);
    L5:
        Class<?> r14 = r10.getClass();
        int r15 = r14.getModifiers();
        if (r14.isAnonymousClass() == true) goto L38;
        if (Modifier.isPublic(r15) == false) goto L38;
        if (r14.isMemberClass() == false) goto L14;
        if (Modifier.isStatic(r15) == false) goto L38;
    L14:
        if (r11 == null) goto L23;
        String r16 = r10.mTag;
        if (r16 != null) goto L18;
    L22:
        r10.mTag = r11;
        goto L23
    L18:
        if (r11.equals(r16) == true) goto L22;
        StringBuilder r17 = new StringBuilder("Can't change tag of fragment ");
        r17.append(r10);
        r17.append(": was ");
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.t(r17, r10.mTag, " now ", r11));
    L23:
        if (r5 != 0) goto L25;
    L35:
        addOp(new Op(r12, r10));
        return;
    L25:
        if (r5 == (-1)) goto L34;
        int r18 = r10.mFragmentId;
        if (r18 == 0) goto L32;
        if (r18 == r5) goto L32;
        throw new IllegalStateException("Can't change container ID of fragment " + r10 + ": was " + r10.mFragmentId + " now " + r5);
    L32:
        r10.mFragmentId = r5;
        r10.mContainerId = r5;
        goto L35
    L34:
        throw new IllegalArgumentException("Can't add fragment " + r10 + " with tag " + r11 + " to container view with no id");
    L38:
        throw new IllegalStateException("Fragment " + r14.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment r5) {
        addOp(new Op(4, r5));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment r5) {
        addOp(new Op(3, r5));
        return this;
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int r5, @NonNull Class<? extends Fragment> r10, @Nullable Bundle r11) {
        return replace(r5, r10, r11, null);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable r5) {
        disallowAddToBackStack();
        if (this.mCommitRunnables != null) goto L5;
        this.mCommitRunnables = new ArrayList();
    L5:
        this.mCommitRunnables.add(r5);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean r5) {
        return setReorderingAllowed(r5);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int r5) {
        this.mBreadCrumbShortTitleRes = r5;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int r5) {
        this.mBreadCrumbTitleRes = r5;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int r5, @AnimRes @AnimatorRes int r10) {
        return setCustomAnimations(r5, r10, 0, 0);
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment r5, @NonNull Lifecycle.State r10) {
        addOp(new Op(10, r5, r10));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment r5) {
        addOp(new Op(8, r5));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean r5) {
        this.mReorderingAllowed = r5;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int r5) {
        this.mTransition = r5;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int r5) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment r5) {
        addOp(new Op(5, r5));
        return this;
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment r5, @Nullable String r10) {
        doAddOp(0, r5, r10, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int r5, @NonNull Fragment r10) {
        return replace(r5, r10, null);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int r5, @AnimRes @AnimatorRes int r10, @AnimRes @AnimatorRes int r11, @AnimRes @AnimatorRes int r12) {
        this.mEnterAnim = r5;
        this.mExitAnim = r10;
        this.mPopEnterAnim = r11;
        this.mPopExitAnim = r12;
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int r5, @NonNull Class<? extends Fragment> r10, @Nullable Bundle r11) {
        return add(r5, createFragment(r10, r11));
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int r5, @NonNull Class<? extends Fragment> r10, @Nullable Bundle r11, @Nullable String r12) {
        return replace(r5, createFragment(r10, r11), r12);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence r5) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = r5;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence r5) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = r5;
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int r5, @NonNull Fragment r10) {
        doAddOp(r5, r10, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int r5, @NonNull Fragment r10, @Nullable String r11) {
        if (r5 == 0) goto L6;
        doAddOp(r5, r10, r11, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int r5, @NonNull Class<? extends Fragment> r10, @Nullable Bundle r11, @Nullable String r12) {
        return add(r5, createFragment(r10, r11), r12);
    }

    @NonNull
    public FragmentTransaction add(@IdRes int r5, @NonNull Fragment r10, @Nullable String r11) {
        doAddOp(r5, r10, r11, 1);
        return this;
    }

    public FragmentTransaction(@NonNull FragmentFactory r5, @Nullable ClassLoader r10) {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = r5;
        this.mClassLoader = r10;
    }

    public FragmentTransaction add(@NonNull ViewGroup r5, @NonNull Fragment r10, @Nullable String r11) {
        r10.mContainer = r5;
        return add(r5.getId(), r10, r11);
    }

    public FragmentTransaction(@NonNull FragmentFactory r5, @Nullable ClassLoader r10, @NonNull FragmentTransaction r11) {
        this(r5, r10);
        Iterator<Op> r12 = r11.mOps.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Op r13 = r12.next();
        this.mOps.add(new Op(r13));
        goto L4
    L6:
        this.mEnterAnim = r11.mEnterAnim;
        this.mExitAnim = r11.mExitAnim;
        this.mPopEnterAnim = r11.mPopEnterAnim;
        this.mPopExitAnim = r11.mPopExitAnim;
        this.mTransition = r11.mTransition;
        this.mAddToBackStack = r11.mAddToBackStack;
        this.mAllowAddToBackStack = r11.mAllowAddToBackStack;
        this.mName = r11.mName;
        this.mBreadCrumbShortTitleRes = r11.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r11.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = r11.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r11.mBreadCrumbTitleText;
        if (r11.mSharedElementSourceNames == null) goto L10;
        ArrayList<String> r14 = new ArrayList();
        this.mSharedElementSourceNames = r14;
        r14.addAll(r11.mSharedElementSourceNames);
    L10:
        if (r11.mSharedElementTargetNames == null) goto L12;
        ArrayList<String> r15 = new ArrayList();
        this.mSharedElementTargetNames = r15;
        r15.addAll(r11.mSharedElementTargetNames);
    L12:
        this.mReorderingAllowed = r11.mReorderingAllowed;
    }
}
