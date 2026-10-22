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
    boolean mBeingSaved;
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    public BackStackRecord(@NonNull FragmentManager r5) {
        FragmentFactory r10 = r5.getFragmentFactory();
        if (r5.getHost() == null) goto L5;
        ClassLoader r11 = r5.getHost().getContext().getClassLoader();
    L6:
        super(r10, r11);
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = r5;
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void bumpBackStackNesting(int r10) {
        if (this.mAddToBackStack == true) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + r10);
    L8:
        int r5 = this.mOps.size();
        int r11 = 0;
    L9:
        if (r11 >= r5) goto L16;
        FragmentTransaction.Op r12 = this.mOps.get(r11);
        Fragment r13 = r12.mFragment;
        if (r13 == null) goto L15;
        r13.mBackStackNesting += r10;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v("FragmentManager", "Bump nesting of " + r12.mFragment + " to " + r12.mFragment.mBackStackNesting);
    L15:
        r11 = r11 + 1;
        goto L9
    }

    public void collapseOps() {
        int r5 = this.mOps.size() - 1;
    L3:
        if (r5 < 0) goto L19;
        FragmentTransaction.Op r10 = this.mOps.get(r5);
        if (r10.mFromExpandedOp == false) goto L18;
        if (r10.mCmd != 8) goto L10;
        r10.mFromExpandedOp = false;
        this.mOps.remove(r5 - 1);
        r5 = r5 - 1;
        goto L18
    L10:
        int r11 = r10.mFragment.mContainerId;
        r10.mCmd = 2;
        r10.mFromExpandedOp = false;
        int r12 = r5 - 1;
    L11:
        if (r12 < 0) goto L18;
        FragmentTransaction.Op r13 = this.mOps.get(r12);
        if (r13.mFromExpandedOp == false) goto L17;
        if (r13.mFragment.mContainerId != r11) goto L17;
        this.mOps.remove(r12);
        r5 = r5 - 1;
    L17:
        r12 = r12 - 1;
    L18:
        r5 = r5 - 1;
        goto L3
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public int commitInternal(boolean r5) {
        if (this.mCommitted == true) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v("FragmentManager", "Commit: " + this);
        PrintWriter r10 = new PrintWriter(new LogWriter("FragmentManager"));
        dump("  ", r10);
        r10.close();
    L7:
        this.mCommitted = true;
        if (this.mAddToBackStack == false) goto L10;
        this.mIndex = this.mManager.allocBackStackIndex();
    L11:
        this.mManager.enqueueAction(this, r5);
        return this.mIndex;
    L10:
        this.mIndex = -1;
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
    public FragmentTransaction detach(@NonNull Fragment r5) {
        FragmentManager r10 = r5.mFragmentManager;
        if (r10 == null) goto L10;
        if (r10 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + r5.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.detach(r5);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void doAddOp(int r5, Fragment r10, @Nullable String r11, int r12) {
        super.doAddOp(r5, r10, r11, r12);
        r10.mFragmentManager = this.mManager;
    }

    public void dump(String r5, PrintWriter r10) {
        dump(r5, r10, true);
    }

    public void executeOps() {
        int r5 = this.mOps.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L21;
        FragmentTransaction.Op r11 = this.mOps.get(r10);
        Fragment r12 = r11.mFragment;
        if (r12 == null) goto L8;
        r12.mBeingSaved = this.mBeingSaved;
        r12.setPopDirection(false);
        r12.setNextTransition(this.mTransition);
        r12.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
    L8:
        switch(r11.mCmd) {
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
        this.mManager.setMaxLifecycle(r12, r11.mCurrentMaxState);
    L20:
        r10 = r10 + 1;
        goto L3
    L12:
        this.mManager.setPrimaryNavigationFragment(null);
        goto L20
    L13:
        this.mManager.setPrimaryNavigationFragment(r12);
        goto L20
    L14:
        r12.setAnimations(r11.mEnterAnim, r11.mExitAnim, r11.mPopEnterAnim, r11.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r12, false);
        this.mManager.attachFragment(r12);
        goto L20
    L15:
        r12.setAnimations(r11.mEnterAnim, r11.mExitAnim, r11.mPopEnterAnim, r11.mPopExitAnim);
        this.mManager.detachFragment(r12);
        goto L20
    L16:
        r12.setAnimations(r11.mEnterAnim, r11.mExitAnim, r11.mPopEnterAnim, r11.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r12, false);
        this.mManager.showFragment(r12);
        goto L20
    L17:
        r12.setAnimations(r11.mEnterAnim, r11.mExitAnim, r11.mPopEnterAnim, r11.mPopExitAnim);
        this.mManager.hideFragment(r12);
        goto L20
    L18:
        r12.setAnimations(r11.mEnterAnim, r11.mExitAnim, r11.mPopEnterAnim, r11.mPopExitAnim);
        this.mManager.removeFragment(r12);
        goto L20
    L19:
        r12.setAnimations(r11.mEnterAnim, r11.mExitAnim, r11.mPopEnterAnim, r11.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r12, false);
        this.mManager.addFragment(r12);
        goto L20
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r11.mCmd);
    }

    public void executePopOps() {
        int r5 = this.mOps.size() - 1;
    L3:
        if (r5 < 0) goto L21;
        FragmentTransaction.Op r10 = this.mOps.get(r5);
        Fragment r11 = r10.mFragment;
        if (r11 == null) goto L8;
        r11.mBeingSaved = this.mBeingSaved;
        r11.setPopDirection(true);
        r11.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
        r11.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
    L8:
        switch(r10.mCmd) {
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
        this.mManager.setMaxLifecycle(r11, r10.mOldMaxState);
    L20:
        r5 = r5 - 1;
        goto L3
    L12:
        this.mManager.setPrimaryNavigationFragment(r11);
        goto L20
    L13:
        this.mManager.setPrimaryNavigationFragment(null);
        goto L20
    L14:
        r11.setAnimations(r10.mEnterAnim, r10.mExitAnim, r10.mPopEnterAnim, r10.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r11, true);
        this.mManager.detachFragment(r11);
        goto L20
    L15:
        r11.setAnimations(r10.mEnterAnim, r10.mExitAnim, r10.mPopEnterAnim, r10.mPopExitAnim);
        this.mManager.attachFragment(r11);
        goto L20
    L16:
        r11.setAnimations(r10.mEnterAnim, r10.mExitAnim, r10.mPopEnterAnim, r10.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r11, true);
        this.mManager.hideFragment(r11);
        goto L20
    L17:
        r11.setAnimations(r10.mEnterAnim, r10.mExitAnim, r10.mPopEnterAnim, r10.mPopExitAnim);
        this.mManager.showFragment(r11);
        goto L20
    L18:
        r11.setAnimations(r10.mEnterAnim, r10.mExitAnim, r10.mPopEnterAnim, r10.mPopExitAnim);
        this.mManager.addFragment(r11);
        goto L20
    L19:
        r11.setAnimations(r10.mEnterAnim, r10.mExitAnim, r10.mPopEnterAnim, r10.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r11, true);
        this.mManager.removeFragment(r11);
        goto L20
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r10.mCmd);
    }

    public Fragment expandOps(ArrayList<Fragment> r17, Fragment r18) {
        Fragment r5 = r18;
        int r10 = 0;
    L4:
        if (r10 >= this.mOps.size()) goto L36;
        FragmentTransaction.Op r11 = this.mOps.get(r10);
        int r12 = r11.mCmd;
        if (r12 != 1) goto L8;
    L34:
        r17.add(r11.mFragment);
    L35:
        r10 = r10 + 1;
        goto L4
    L8:
        if (r12 == 2) goto L21;
        if (r12 != 3) goto L11;
    L18:
        r17.remove(r11.mFragment);
        Fragment r13 = r11.mFragment;
        if (r13 != r5) goto L35;
        this.mOps.add(r10, new FragmentTransaction.Op(9, r13));
        r10 = r10 + 1;
        r5 = null;
        goto L35
    L11:
        if (r12 == 6) goto L18;
        if (r12 == 7) goto L34;
        if (r12 != 8) goto L35;
        this.mOps.add(r10, new FragmentTransaction.Op(9, r5, true));
        r11.mFromExpandedOp = true;
        r10 = r10 + 1;
        r5 = r11.mFragment;
        goto L35
    L21:
        Fragment r14 = r11.mFragment;
        int r15 = r14.mContainerId;
        int r16 = r17.size() - 1;
        boolean r19 = false;
    L22:
        if (r16 < 0) goto L31;
        Fragment r110 = r17.get(r16);
        if (r110.mContainerId != r15) goto L30;
        if (r110 != r14) goto L27;
        r19 = true;
        goto L30
    L27:
        if (r110 != r5) goto L29;
        this.mOps.add(r10, new FragmentTransaction.Op(9, r110, true));
        r10 = r10 + 1;
        r5 = null;
    L29:
        FragmentTransaction.Op r111 = new FragmentTransaction.Op(3, r110, true);
        r111.mEnterAnim = r11.mEnterAnim;
        r111.mPopEnterAnim = r11.mPopEnterAnim;
        r111.mExitAnim = r11.mExitAnim;
        r111.mPopExitAnim = r11.mPopExitAnim;
        this.mOps.add(r10, r111);
        r17.remove(r110);
        r10 = r10 + 1;
    L30:
        r16 = r16 - 1;
        goto L22
    L31:
        if (r19 == false) goto L33;
        this.mOps.remove(r10);
        r10 = r10 - 1;
        goto L35
    L33:
        r11.mCmd = 1;
        r11.mFromExpandedOp = true;
        r17.add(r14);
        goto L35
    L36:
        return r5;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> r5, @NonNull ArrayList<Boolean> r10) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "Run: " + this);
    L5:
        r5.add(this);
        r10.add(Boolean.FALSE);
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
    public FragmentTransaction hide(@NonNull Fragment r5) {
        FragmentManager r10 = r5.mFragmentManager;
        if (r10 == null) goto L10;
        if (r10 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + r5.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.hide(r5);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction remove(@NonNull Fragment r5) {
        FragmentManager r10 = r5.mFragmentManager;
        if (r10 == null) goto L10;
        if (r10 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + r5.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.remove(r5);
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables == null) goto L11;
        int r5 = 0;
    L6:
        if (r5 >= this.mCommitRunnables.size()) goto L8;
        this.mCommitRunnables.get(r5).run();
        r5 = r5 + 1;
        goto L6
    L8:
        this.mCommitRunnables = null;
        return;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment r5, @NonNull Lifecycle.State r10) {
        if (r5.mFragmentManager != this.mManager) goto L18;
        if (r10 != Lifecycle.State.INITIALIZED) goto L12;
        if (r5.mState <= (-1)) goto L12;
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r10 + " after the Fragment has been created");
    L12:
        if (r10 == Lifecycle.State.DESTROYED) goto L16;
        return super.setMaxLifecycle(r5, r10);
    L16:
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r10 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    L18:
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment r5) {
        if (r5 == null) goto L11;
        FragmentManager r10 = r5.mFragmentManager;
        if (r10 == null) goto L11;
        if (r10 == this.mManager) goto L11;
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + r5.toString() + " is already attached to a FragmentManager.");
    L11:
        return super.setPrimaryNavigationFragment(r5);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    @NonNull
    public FragmentTransaction show(@NonNull Fragment r5) {
        FragmentManager r10 = r5.mFragmentManager;
        if (r10 == null) goto L10;
        if (r10 == this.mManager) goto L10;
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + r5.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.show(r5);
    }

    public String toString() {
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.x(128, "BackStackEntry{");
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex < 0) goto L6;
        r5.append(" #");
        r5.append(this.mIndex);
    L6:
        if (this.mName == null) goto L8;
        r5.append(" ");
        r5.append(this.mName);
    L8:
        r5.append("}");
        return r5.toString();
    }

    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> r10, Fragment r11) {
        int r5 = this.mOps.size() - 1;
    L3:
        if (r5 < 0) goto L16;
        FragmentTransaction.Op r12 = this.mOps.get(r5);
        int r13 = r12.mCmd;
        if (r13 != 1) goto L7;
    L14:
        r10.remove(r12.mFragment);
    L15:
        r5 = r5 - 1;
        goto L3
    L7:
        if (r13 == 3) goto L13;
        switch(r13) {
            case 6: goto L13;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L15;
        };
    L10:
        r12.mCurrentMaxState = r12.mOldMaxState;
        goto L15
    L11:
        r11 = r12.mFragment;
        goto L15
    L12:
        r11 = null;
    L13:
        r10.add(r12.mFragment);
        goto L15
    L16:
        return r11;
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
        int r5 = this.mOps.size();
        int r13 = 0;
    L29:
        if (r13 >= r5) goto L62;
        FragmentTransaction.Op r14 = this.mOps.get(r13);
        switch(r14.mCmd) {
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
        String r15 = "cmd=" + r14.mCmd;
    L44:
        r11.print(r10);
        r11.print("  Op #");
        r11.print(r13);
        r11.print(": ");
        r11.print(r15);
        r11.print(" ");
        r11.println(r14.mFragment);
        if (r12 == false) goto L56;
        if (r14.mEnterAnim == 0) goto L49;
    L50:
        r11.print(r10);
        r11.print("enterAnim=#");
        r11.print(Integer.toHexString(r14.mEnterAnim));
        r11.print(" exitAnim=#");
        r11.println(Integer.toHexString(r14.mExitAnim));
    L52:
        if (r14.mPopEnterAnim == 0) goto L54;
    L55:
        r11.print(r10);
        r11.print("popEnterAnim=#");
        r11.print(Integer.toHexString(r14.mPopEnterAnim));
        r11.print(" popExitAnim=#");
        r11.println(Integer.toHexString(r14.mPopExitAnim));
        goto L56
    L54:
        if (r14.mPopExitAnim == 0) goto L56;
    L49:
        if (r14.mExitAnim == 0) goto L52;
    L56:
        r13 = r13 + 1;
        goto L29
    L33:
        r15 = "OP_SET_MAX_LIFECYCLE";
        goto L44
    L34:
        r15 = "UNSET_PRIMARY_NAV";
        goto L44
    L35:
        r15 = "SET_PRIMARY_NAV";
        goto L44
    L36:
        r15 = "ATTACH";
        goto L44
    L37:
        r15 = "DETACH";
        goto L44
    L38:
        r15 = "SHOW";
        goto L44
    L39:
        r15 = "HIDE";
        goto L44
    L40:
        r15 = "REMOVE";
        goto L44
    L41:
        r15 = "REPLACE";
        goto L44
    L42:
        r15 = "ADD";
        goto L44
    L43:
        r15 = "NULL";
        goto L44
    L62:
        return;
    }

    public BackStackRecord(@NonNull BackStackRecord r5) {
        FragmentFactory r10 = r5.mManager.getFragmentFactory();
        if (r5.mManager.getHost() == null) goto L5;
        ClassLoader r11 = r5.mManager.getHost().getContext().getClassLoader();
    L6:
        super(r10, r11, r5);
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = r5.mManager;
        this.mCommitted = r5.mCommitted;
        this.mIndex = r5.mIndex;
        this.mBeingSaved = r5.mBeingSaved;
        return;
    L5:
        r11 = null;
        goto L6
    }
}
