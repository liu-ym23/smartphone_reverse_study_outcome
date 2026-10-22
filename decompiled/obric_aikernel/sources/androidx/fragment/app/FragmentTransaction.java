package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

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

    static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        Op() {
        }

        Op(int r10, Fragment r11) {
            this.mCmd = r10;
            this.mFragment = r11;
            Lifecycle.State r12 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r12;
            this.mCurrentMaxState = r12;
        }

        Op(int r10, @NonNull Fragment r11, Lifecycle.State r12) {
            this.mCmd = r10;
            this.mFragment = r11;
            this.mOldMaxState = r11.mMaxState;
            this.mCurrentMaxState = r12;
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

    FragmentTransaction(@NonNull FragmentFactory r10, @Nullable ClassLoader r11) {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = r10;
        this.mClassLoader = r11;
    }

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> r10, @Nullable Bundle r11) {
        FragmentFactory r12 = this.mFragmentFactory;
        if (r12 == null) goto L13;
        ClassLoader r13 = this.mClassLoader;
        if (r13 == null) goto L11;
        Fragment r14 = r12.instantiate(r13, r10.getName());
        if (r11 == null) goto L9;
        r14.setArguments(r11);
    L9:
        return r14;
    L11:
        throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
    L13:
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    @NonNull
    public FragmentTransaction add(@IdRes int r10, @NonNull Fragment r11) {
        doAddOp(r10, r11, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int r10, @NonNull Fragment r11, @Nullable String r12) {
        doAddOp(r10, r11, r12, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int r10, @NonNull Class<? extends Fragment> r11, @Nullable Bundle r12) {
        return add(r10, createFragment(r11, r12));
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int r10, @NonNull Class<? extends Fragment> r11, @Nullable Bundle r12, @Nullable String r13) {
        return add(r10, createFragment(r11, r12), r13);
    }

    FragmentTransaction add(@NonNull ViewGroup r10, @NonNull Fragment r11, @Nullable String r12) {
        r11.mContainer = r10;
        return add(r10.getId(), r11, r12);
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment r10, @Nullable String r11) {
        doAddOp(0, r10, r11, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> r10, @Nullable Bundle r11, @Nullable String r12) {
        return add(createFragment(r10, r11), r12);
    }

    void addOp(Op r10) {
        this.mOps.add(r10);
        r10.mEnterAnim = this.mEnterAnim;
        r10.mExitAnim = this.mExitAnim;
        r10.mPopEnterAnim = this.mPopEnterAnim;
        r10.mPopExitAnim = this.mPopExitAnim;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View r10, @NonNull String r11) {
        if (FragmentTransition.supportsTransition() == false) goto L20;
        String r12 = ViewCompat.getTransitionName(r10);
        if (r12 == null) goto L19;
        if (this.mSharedElementSourceNames != null) goto L10;
        this.mSharedElementSourceNames = new ArrayList();
        this.mSharedElementTargetNames = new ArrayList();
    L13:
        this.mSharedElementSourceNames.add(r12);
        this.mSharedElementTargetNames.add(r11);
        goto L20
    L10:
        if (this.mSharedElementTargetNames.contains(r11) == true) goto L17;
        if (this.mSharedElementSourceNames.contains(r12) == false) goto L13;
        throw new IllegalArgumentException("A shared element with the source name '" + r12 + "' has already been added to the transaction.");
    L17:
        throw new IllegalArgumentException("A shared element with the target name '" + r11 + "' has already been added to the transaction.");
    L19:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    L20:
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String r10) {
        if (this.mAllowAddToBackStack == false) goto L7;
        this.mAddToBackStack = true;
        this.mName = r10;
        return this;
    L7:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment r10) {
        addOp(new Op(7, r10));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment r10) {
        addOp(new Op(6, r10));
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

    void doAddOp(int r10, Fragment r11, @Nullable String r12, int r13) {
        Class<?> r14 = r11.getClass();
        int r15 = r14.getModifiers();
        if (r14.isAnonymousClass() == true) goto L35;
        if (Modifier.isPublic(r15) == false) goto L35;
        if (r14.isMemberClass() == false) goto L11;
        if (Modifier.isStatic(r15) == false) goto L35;
    L11:
        if (r12 == null) goto L20;
        String r16 = r11.mTag;
        if (r16 != null) goto L15;
    L19:
        r11.mTag = r12;
        goto L20
    L15:
        if (r12.equals(r16) == true) goto L19;
        throw new IllegalStateException("Can't change tag of fragment " + r11 + ": was " + r11.mTag + " now " + r12);
    L20:
        if (r10 != 0) goto L22;
    L32:
        addOp(new Op(r13, r11));
        return;
    L22:
        if (r10 == (-1)) goto L31;
        int r17 = r11.mFragmentId;
        if (r17 == 0) goto L29;
        if (r17 == r10) goto L29;
        throw new IllegalStateException("Can't change container ID of fragment " + r11 + ": was " + r11.mFragmentId + " now " + r10);
    L29:
        r11.mFragmentId = r10;
        r11.mContainerId = r10;
        goto L32
    L31:
        throw new IllegalArgumentException("Can't add fragment " + r11 + " with tag " + r12 + " to container view with no id");
    L35:
        throw new IllegalStateException("Fragment " + r14.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment r10) {
        addOp(new Op(4, r10));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment r10) {
        addOp(new Op(3, r10));
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int r10, @NonNull Fragment r11) {
        return replace(r10, r11, null);
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int r10, @NonNull Fragment r11, @Nullable String r12) {
        if (r10 == 0) goto L6;
        doAddOp(r10, r11, r12, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int r10, @NonNull Class<? extends Fragment> r11, @Nullable Bundle r12) {
        return replace(r10, r11, r12, null);
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int r10, @NonNull Class<? extends Fragment> r11, @Nullable Bundle r12, @Nullable String r13) {
        return replace(r10, createFragment(r11, r12), r13);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable r10) {
        disallowAddToBackStack();
        if (this.mCommitRunnables != null) goto L5;
        this.mCommitRunnables = new ArrayList();
    L5:
        this.mCommitRunnables.add(r10);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean r10) {
        return setReorderingAllowed(r10);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int r10) {
        this.mBreadCrumbShortTitleRes = r10;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence r10) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = r10;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int r10) {
        this.mBreadCrumbTitleRes = r10;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence r10) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = r10;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int r10, @AnimRes @AnimatorRes int r11) {
        return setCustomAnimations(r10, r11, 0, 0);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int r10, @AnimRes @AnimatorRes int r11, @AnimRes @AnimatorRes int r12, @AnimRes @AnimatorRes int r13) {
        this.mEnterAnim = r10;
        this.mExitAnim = r11;
        this.mPopEnterAnim = r12;
        this.mPopExitAnim = r13;
        return this;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment r10, @NonNull Lifecycle.State r11) {
        addOp(new Op(10, r10, r11));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment r10) {
        addOp(new Op(8, r10));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean r10) {
        this.mReorderingAllowed = r10;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int r10) {
        this.mTransition = r10;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int r10) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment r10) {
        addOp(new Op(5, r10));
        return this;
    }
}
