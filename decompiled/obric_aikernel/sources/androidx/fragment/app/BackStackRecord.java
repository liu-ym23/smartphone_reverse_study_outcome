package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    BackStackRecord(@NonNull FragmentManager r10) {
        FragmentFactory r11 = r10.getFragmentFactory();
        if (r10.getHost() == null) goto L5;
        ClassLoader r12 = r10.getHost().getContext().getClassLoader();
    L6:
        super(r11, r12);
        this.mIndex = -1;
        this.mManager = r10;
        return;
    L5:
        r12 = null;
        goto L6
    }

    private static boolean isFragmentPostponed(FragmentTransaction.Op r10) {
        Fragment r11 = r10.mFragment;
        if (r11 != null) goto L5;
    L15:
        return false;
    L5:
        if (r11.mAdded == false) goto L15;
        if (r11.mView == null) goto L15;
        if (r11.mDetached == true) goto L15;
        if (r11.mHidden == true) goto L15;
        if (r11.isPostponed() == false) goto L15;
        return true;
    }

    void bumpBackStackNesting(int r10) {
        if (this.mAddToBackStack == true) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "Bump nesting in " + this + " by " + r10);
    L8:
        int r11 = this.mOps.size();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L16;
        FragmentTransaction.Op r13 = this.mOps.get(r12);
        Fragment r14 = r13.mFragment;
        if (r14 == null) goto L15;
        r14.mBackStackNesting += r10;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v(TAG, "Bump nesting of " + r13.mFragment + " to " + r13.mFragment.mBackStackNesting);
    L15:
        r12 = r12 + 1;
        goto L9
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean r10) {
        if (this.mCommitted == true) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v(TAG, "Commit: " + this);
        PrintWriter r11 = new PrintWriter(new LogWriter(TAG));
        dump("  ", r11);
        r11.close();
    L7:
        this.mCommitted = true;
        if (this.mAddToBackStack == false) goto L10;
        int r12 = this.mManager.allocBackStackIndex();
    L11:
        this.mIndex = r12;
        this.mManager.enqueueAction(this, r10);
        return this.mIndex;
    L10:
        r12 = -1;
        goto L11
    L14:
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction detach(@NonNull Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.detach(r10);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    void doAddOp(int r10, Fragment r11, @Nullable String r12, int r13) {
        super.doAddOp(r10, r11, r12, r13);
        r11.mFragmentManager = this.mManager;
    }

    public void dump(String r10, PrintWriter r11) {
        dump(r10, r11, true);
    }

    public void dump(String r10, PrintWriter r11, boolean r12) {
        if (r12 == false) goto L27;
        r11.print(r10);
        r11.print("mName=");
        r11.print(this.mName);
        r11.print(" mIndex=");
        r11.print(this.mIndex);
        r11.print(" mCommitted=");
        r11.println(this.mCommitted);
        if (this.mTransition == 0) goto L7;
        r11.print(r10);
        r11.print("mTransition=#");
        r11.print(Integer.toHexString(this.mTransition));
    L7:
        if (this.mEnterAnim == 0) goto L9;
    L10:
        r11.print(r10);
        r11.print("mEnterAnim=#");
        r11.print(Integer.toHexString(this.mEnterAnim));
        r11.print(" mExitAnim=#");
        r11.println(Integer.toHexString(this.mExitAnim));
    L12:
        if (this.mPopEnterAnim == 0) goto L14;
    L15:
        r11.print(r10);
        r11.print("mPopEnterAnim=#");
        r11.print(Integer.toHexString(this.mPopEnterAnim));
        r11.print(" mPopExitAnim=#");
        r11.println(Integer.toHexString(this.mPopExitAnim));
    L17:
        if (this.mBreadCrumbTitleRes == 0) goto L19;
    L20:
        r11.print(r10);
        r11.print("mBreadCrumbTitleRes=#");
        r11.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        r11.print(" mBreadCrumbTitleText=");
        r11.println(this.mBreadCrumbTitleText);
    L22:
        if (this.mBreadCrumbShortTitleRes == 0) goto L24;
    L25:
        r11.print(r10);
        r11.print("mBreadCrumbShortTitleRes=#");
        r11.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        r11.print(" mBreadCrumbShortTitleText=");
        r11.println(this.mBreadCrumbShortTitleText);
        goto L27
    L24:
        if (this.mBreadCrumbShortTitleText == null) goto L27;
    L19:
        if (this.mBreadCrumbTitleText == null) goto L22;
    L14:
        if (this.mPopExitAnim == 0) goto L17;
    L9:
        if (this.mExitAnim == 0) goto L12;
    L27:
        if (this.mOps.isEmpty() == true) goto L57;
        r11.print(r10);
        r11.println("Operations:");
        int r13 = this.mOps.size();
        int r14 = 0;
    L29:
        if (r14 >= r13) goto L62;
        FragmentTransaction.Op r15 = this.mOps.get(r14);
        switch(r15.mCmd) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            default: goto L32;
        };
    L32:
        String r16 = "cmd=" + r15.mCmd;
    L44:
        r11.print(r10);
        r11.print("  Op #");
        r11.print(r14);
        r11.print(": ");
        r11.print(r16);
        r11.print(" ");
        r11.println(r15.mFragment);
        if (r12 == false) goto L56;
        if (r15.mEnterAnim == 0) goto L49;
    L50:
        r11.print(r10);
        r11.print("enterAnim=#");
        r11.print(Integer.toHexString(r15.mEnterAnim));
        r11.print(" exitAnim=#");
        r11.println(Integer.toHexString(r15.mExitAnim));
    L52:
        if (r15.mPopEnterAnim == 0) goto L54;
    L55:
        r11.print(r10);
        r11.print("popEnterAnim=#");
        r11.print(Integer.toHexString(r15.mPopEnterAnim));
        r11.print(" popExitAnim=#");
        r11.println(Integer.toHexString(r15.mPopExitAnim));
        goto L56
    L54:
        if (r15.mPopExitAnim == 0) goto L56;
    L49:
        if (r15.mExitAnim == 0) goto L52;
    L56:
        r14 = r14 + 1;
        goto L29
    L33:
        r16 = "OP_SET_MAX_LIFECYCLE";
        goto L44
    L34:
        r16 = "UNSET_PRIMARY_NAV";
        goto L44
    L35:
        r16 = "SET_PRIMARY_NAV";
        goto L44
    L36:
        r16 = "ATTACH";
        goto L44
    L37:
        r16 = "DETACH";
        goto L44
    L38:
        r16 = "SHOW";
        goto L44
    L39:
        r16 = "HIDE";
        goto L44
    L40:
        r16 = "REMOVE";
        goto L44
    L41:
        r16 = "REPLACE";
        goto L44
    L42:
        r16 = "ADD";
        goto L44
    L43:
        r16 = "NULL";
        goto L44
    L62:
        return;
    }

    void executeOps() {
        int r10 = this.mOps.size();
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L31;
        FragmentTransaction.Op r12 = this.mOps.get(r11);
        Fragment r13 = r12.mFragment;
        if (r13 == null) goto L9;
        r13.setPopDirection(false);
        r13.setNextTransition(this.mTransition);
        r13.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
    L9:
        switch(r12.mCmd) {
            case 1: goto L20;
            case 2: goto L11;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        this.mManager.setMaxLifecycle(r13, r12.mCurrentMaxState);
    L22:
        if (this.mReorderingAllowed == true) goto L29;
        if (r12.mCmd == 1) goto L29;
        if (r13 == null) goto L29;
        if (FragmentManager.USE_STATE_MANAGER == true) goto L29;
        this.mManager.moveFragmentToExpectedState(r13);
    L29:
        r11 = r11 + 1;
        goto L4
    L13:
        this.mManager.setPrimaryNavigationFragment(null);
        goto L22
    L14:
        this.mManager.setPrimaryNavigationFragment(r13);
        goto L22
    L15:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r13, false);
        this.mManager.attachFragment(r13);
        goto L22
    L16:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.detachFragment(r13);
        goto L22
    L17:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r13, false);
        this.mManager.showFragment(r13);
        goto L22
    L18:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.hideFragment(r13);
        goto L22
    L19:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.removeFragment(r13);
        goto L22
    L20:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r13, false);
        this.mManager.addFragment(r13);
        goto L22
    L11:
        throw new IllegalArgumentException("Unknown cmd: " + r12.mCmd);
    L31:
        if (this.mReorderingAllowed == false) goto L33;
        return;
    L33:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L44;
        FragmentManager r14 = this.mManager;
        r14.moveToState(r14.mCurState, true);
        return;
    }

    void executePopOps(boolean r10) {
        int r11 = this.mOps.size() - 1;
    L3:
        if (r11 < 0) goto L30;
        FragmentTransaction.Op r12 = this.mOps.get(r11);
        Fragment r13 = r12.mFragment;
        if (r13 == null) goto L8;
        r13.setPopDirection(true);
        r13.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
        r13.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
    L8:
        switch(r12.mCmd) {
            case 1: goto L19;
            case 2: goto L10;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this.mManager.setMaxLifecycle(r13, r12.mOldMaxState);
    L21:
        if (this.mReorderingAllowed == true) goto L28;
        if (r12.mCmd == 3) goto L28;
        if (r13 == null) goto L28;
        if (FragmentManager.USE_STATE_MANAGER == true) goto L28;
        this.mManager.moveFragmentToExpectedState(r13);
    L28:
        r11 = r11 - 1;
        goto L3
    L12:
        this.mManager.setPrimaryNavigationFragment(r13);
        goto L21
    L13:
        this.mManager.setPrimaryNavigationFragment(null);
        goto L21
    L14:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r13, true);
        this.mManager.detachFragment(r13);
        goto L21
    L15:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.attachFragment(r13);
        goto L21
    L16:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r13, true);
        this.mManager.hideFragment(r13);
        goto L21
    L17:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.showFragment(r13);
        goto L21
    L18:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.addFragment(r13);
        goto L21
    L19:
        r13.setAnimations(r12.mEnterAnim, r12.mExitAnim, r12.mPopEnterAnim, r12.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r13, true);
        this.mManager.removeFragment(r13);
        goto L21
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r12.mCmd);
    L30:
        if (this.mReorderingAllowed == true) goto L43;
        if (r10 == true) goto L33;
        return;
    L33:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L45;
        FragmentManager r14 = this.mManager;
        r14.moveToState(r14.mCurState, true);
        return;
    L45:
        return;
    }

    Fragment expandOps(ArrayList<Fragment> r17, Fragment r18) {
        Fragment r10 = r18;
        int r11 = 0;
    L4:
        if (r11 >= this.mOps.size()) goto L36;
        FragmentTransaction.Op r12 = this.mOps.get(r11);
        int r13 = r12.mCmd;
        if (r13 != 1) goto L8;
    L34:
        r17.add(r12.mFragment);
    L35:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r13 == 2) goto L21;
        if (r13 != 3) goto L11;
    L18:
        r17.remove(r12.mFragment);
        Fragment r14 = r12.mFragment;
        if (r14 != r10) goto L35;
        this.mOps.add(r11, new FragmentTransaction.Op(9, r14));
        r11 = r11 + 1;
        r10 = null;
        goto L35
    L11:
        if (r13 == 6) goto L18;
        if (r13 == 7) goto L34;
        if (r13 != 8) goto L35;
        this.mOps.add(r11, new FragmentTransaction.Op(9, r10));
        r11 = r11 + 1;
        r10 = r12.mFragment;
        goto L35
    L21:
        Fragment r15 = r12.mFragment;
        int r16 = r15.mContainerId;
        int r19 = r17.size() - 1;
        boolean r110 = false;
    L22:
        if (r19 < 0) goto L31;
        Fragment r111 = r17.get(r19);
        if (r111.mContainerId != r16) goto L30;
        if (r111 != r15) goto L27;
        r110 = true;
        goto L30
    L27:
        if (r111 != r10) goto L29;
        this.mOps.add(r11, new FragmentTransaction.Op(9, r111));
        r11 = r11 + 1;
        r10 = null;
    L29:
        FragmentTransaction.Op r112 = new FragmentTransaction.Op(3, r111);
        r112.mEnterAnim = r12.mEnterAnim;
        r112.mPopEnterAnim = r12.mPopEnterAnim;
        r112.mExitAnim = r12.mExitAnim;
        r112.mPopExitAnim = r12.mPopExitAnim;
        this.mOps.add(r11, r112);
        r17.remove(r111);
        r11 = r11 + 1;
    L30:
        r19 = r19 - 1;
        goto L22
    L31:
        if (r110 == false) goto L33;
        this.mOps.remove(r11);
        r11 = r11 - 1;
        goto L35
    L33:
        r12.mCmd = 1;
        r17.add(r15);
        goto L35
    L36:
        return r10;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> r10, @NonNull ArrayList<Boolean> r11) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "Run: " + this);
    L5:
        r10.add(this);
        r11.add(Boolean.FALSE);
        if (this.mAddToBackStack == false) goto L10;
        this.mManager.addBackStackState(this);
        return true;
    L10:
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes == 0) goto L7;
        return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
    L7:
        return this.mBreadCrumbShortTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes == 0) goto L7;
        return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
    L7:
        return this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.mName;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction hide(@NonNull Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.hide(r10);
    }

    boolean interactsWith(int r10) {
        int r11 = this.mOps.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        Fragment r13 = this.mOps.get(r12).mFragment;
        if (r13 == null) goto L7;
        int r14 = r13.mContainerId;
    L8:
        if (r14 == 0) goto L12;
        if (r14 != r10) goto L12;
        return true;
    L12:
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = 0;
        goto L8
    L13:
        return false;
    }

    boolean interactsWith(ArrayList<BackStackRecord> r10, int r11, int r12) {
        if (r12 != r11) goto L5;
        return false;
    L5:
        int r13 = this.mOps.size();
        int r14 = -1;
        int r15 = 0;
    L6:
        if (r15 >= r13) goto L28;
        Fragment r16 = this.mOps.get(r15).mFragment;
        if (r16 == null) goto L10;
        int r17 = r16.mContainerId;
    L11:
        if (r17 == 0) goto L27;
        if (r17 == r14) goto L27;
        int r18 = r11;
    L14:
        if (r18 >= r12) goto L26;
        BackStackRecord r19 = r10.get(r18);
        int r20 = r19.mOps.size();
        int r21 = 0;
    L16:
        if (r21 >= r20) goto L25;
        Fragment r22 = r19.mOps.get(r21).mFragment;
        if (r22 == null) goto L20;
        int r23 = r22.mContainerId;
    L21:
        if (r23 == r17) goto L22;
        r21 = r21 + 1;
        goto L16
    L22:
        return true;
    L20:
        r23 = 0;
        goto L21
    L25:
        r18 = r18 + 1;
        goto L14
    L26:
        r14 = r17;
    L27:
        r15 = r15 + 1;
        goto L6
    L10:
        r17 = 0;
        goto L11
    L28:
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    boolean isPostponed() {
        int r10 = 0;
    L4:
        if (r10 >= this.mOps.size()) goto L10;
        if (isFragmentPostponed(this.mOps.get(r10)) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.remove(r10);
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables == null) goto L11;
        int r10 = 0;
    L6:
        if (r10 >= this.mCommitRunnables.size()) goto L8;
        this.mCommitRunnables.get(r10).run();
        r10 = r10 + 1;
        goto L6
    L8:
        this.mCommitRunnables = null;
        return;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment r10, @NonNull Lifecycle.State r11) {
        if (r10.mFragmentManager != this.mManager) goto L18;
        if (r11 != Lifecycle.State.INITIALIZED) goto L12;
        if (r10.mState <= (-1)) goto L12;
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r11 + " after the Fragment has been created");
    L12:
        if (r11 == Lifecycle.State.DESTROYED) goto L16;
        return super.setMaxLifecycle(r10, r11);
    L16:
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r11 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    L18:
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }

    void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mOps.size()) goto L9;
        FragmentTransaction.Op r12 = this.mOps.get(r11);
        if (isFragmentPostponed(r12) == false) goto L8;
        r12.mFragment.setOnStartEnterTransitionListener(r10);
    L8:
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment r10) {
        if (r10 == null) goto L11;
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L11;
        if (r11 == this.mManager) goto L11;
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L11:
        return super.setPrimaryNavigationFragment(r10);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment r10) {
        FragmentManager r11 = r10.mFragmentManager;
        if (r11 == null) goto L10;
        if (r11 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + r10.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.show(r10);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("BackStackEntry{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex < 0) goto L6;
        r10.append(" #");
        r10.append(this.mIndex);
    L6:
        if (this.mName == null) goto L8;
        r10.append(" ");
        r10.append(this.mName);
    L8:
        r10.append("}");
        return r10.toString();
    }

    Fragment trackAddedFragmentsInPop(ArrayList<Fragment> r10, Fragment r11) {
        int r12 = this.mOps.size() - 1;
    L3:
        if (r12 < 0) goto L16;
        FragmentTransaction.Op r13 = this.mOps.get(r12);
        int r14 = r13.mCmd;
        if (r14 != 1) goto L7;
    L14:
        r10.remove(r13.mFragment);
    L15:
        r12 = r12 - 1;
        goto L3
    L7:
        if (r14 == 3) goto L13;
        switch(r14) {
            case 6: goto L13;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L15;
        };
    L10:
        r13.mCurrentMaxState = r13.mOldMaxState;
        goto L15
    L11:
        r11 = r13.mFragment;
        goto L15
    L12:
        r11 = null;
    L13:
        r10.add(r13.mFragment);
        goto L15
    L16:
        return r11;
    }
}
