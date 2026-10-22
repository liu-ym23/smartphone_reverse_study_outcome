package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = null;
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BackStackRecordState(BackStackRecord r10) {
        int r5 = r10.mOps.size();
        this.mOps = new int[r5 * 6];
        if (r10.mAddToBackStack == false) goto L14;
        this.mFragmentWhos = new ArrayList(r5);
        this.mOldMaxLifecycleStates = new int[r5];
        this.mCurrentMaxLifecycleStates = new int[r5];
        int r11 = 0;
        int r12 = 0;
    L5:
        if (r11 >= r5) goto L11;
        FragmentTransaction.Op r13 = r10.mOps.get(r11);
        int r14 = r12 + 1;
        this.mOps[r12] = r13.mCmd;
        ArrayList<String> r15 = this.mFragmentWhos;
        Fragment r16 = r13.mFragment;
        if (r16 == null) goto L9;
        String r17 = r16.mWho;
    L10:
        r15.add(r17);
        int[] r18 = this.mOps;
        r18[r14] = r13.mFromExpandedOp ? 1 : 0;
        r18[r12 + 2] = r13.mEnterAnim;
        r18[r12 + 3] = r13.mExitAnim;
        int r19 = r12 + 5;
        r18[r12 + 4] = r13.mPopEnterAnim;
        r12 = r12 + 6;
        r18[r19] = r13.mPopExitAnim;
        this.mOldMaxLifecycleStates[r11] = r13.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r11] = r13.mCurrentMaxState.ordinal();
        r11 = r11 + 1;
        goto L5
    L9:
        r17 = null;
        goto L10
    L11:
        this.mTransition = r10.mTransition;
        this.mName = r10.mName;
        this.mIndex = r10.mIndex;
        this.mBreadCrumbTitleRes = r10.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r10.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = r10.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r10.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = r10.mSharedElementSourceNames;
        this.mSharedElementTargetNames = r10.mSharedElementTargetNames;
        this.mReorderingAllowed = r10.mReorderingAllowed;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(@NonNull BackStackRecord r10) {
        int r5 = 0;
        int r11 = 0;
    L3:
        boolean r12 = true;
        if (r5 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r13 = new FragmentTransaction.Op();
        int r14 = r5 + 1;
        r13.mCmd = this.mOps[r5];
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Instantiate " + r10 + " op #" + r11 + " base fragment #" + this.mOps[r14]);
    L8:
        r13.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r11]];
        r13.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r11]];
        int[] r15 = this.mOps;
        int r16 = r5 + 2;
        if (r15[r14] != 0) goto L12;
        r12 = false;
    L12:
        r13.mFromExpandedOp = r12;
        int r17 = r15[r16];
        r13.mEnterAnim = r17;
        int r18 = r15[r5 + 3];
        r13.mExitAnim = r18;
        int r19 = r5 + 5;
        int r20 = r15[r5 + 4];
        r13.mPopEnterAnim = r20;
        r5 = r5 + 6;
        int r21 = r15[r19];
        r13.mPopExitAnim = r21;
        r10.mEnterAnim = r17;
        r10.mExitAnim = r18;
        r10.mPopEnterAnim = r20;
        r10.mPopExitAnim = r21;
        r10.addOp(r13);
        r11 = r11 + 1;
        goto L3
    L13:
        r10.mTransition = this.mTransition;
        r10.mName = this.mName;
        r10.mAddToBackStack = true;
        r10.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        r10.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        r10.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        r10.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        r10.mSharedElementSourceNames = this.mSharedElementSourceNames;
        r10.mSharedElementTargetNames = this.mSharedElementTargetNames;
        r10.mReorderingAllowed = this.mReorderingAllowed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager r5) {
        BackStackRecord r10 = new BackStackRecord(r5);
        fillInBackStackRecord(r10);
        r10.mIndex = this.mIndex;
        int r11 = 0;
    L4:
        if (r11 >= this.mFragmentWhos.size()) goto L9;
        String r12 = this.mFragmentWhos.get(r11);
        if (r12 == null) goto L8;
        FragmentTransaction.Op r13 = r10.mOps.get(r11);
        r13.mFragment = r5.findActiveFragment(r12);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        r10.bumpBackStackNesting(1);
        return r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        r5.writeIntArray(this.mOps);
        r5.writeStringList(this.mFragmentWhos);
        r5.writeIntArray(this.mOldMaxLifecycleStates);
        r5.writeIntArray(this.mCurrentMaxLifecycleStates);
        r5.writeInt(this.mTransition);
        r5.writeString(this.mName);
        r5.writeInt(this.mIndex);
        r5.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r5, 0);
        r5.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r5, 0);
        r5.writeStringList(this.mSharedElementSourceNames);
        r5.writeStringList(this.mSharedElementTargetNames);
        r5.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager r5, @NonNull Map<String, Fragment> r10) {
        BackStackRecord r11 = new BackStackRecord(r5);
        fillInBackStackRecord(r11);
        int r12 = 0;
    L4:
        if (r12 >= this.mFragmentWhos.size()) goto L13;
        String r13 = this.mFragmentWhos.get(r12);
        if (r13 == null) goto L12;
        Fragment r14 = r10.get(r13);
        if (r14 == null) goto L11;
        r11.mOps.get(r12).mFragment = r14;
        goto L12
    L11:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.u(new StringBuilder("Restoring FragmentTransaction "), this.mName, " failed due to missing saved state for Fragment (", r13, ")"));
    L12:
        r12 = r12 + 1;
        goto L4
    L13:
        return r11;
    }

    public BackStackRecordState(Parcel r5) {
        this.mOps = r5.createIntArray();
        this.mFragmentWhos = r5.createStringArrayList();
        this.mOldMaxLifecycleStates = r5.createIntArray();
        this.mCurrentMaxLifecycleStates = r5.createIntArray();
        this.mTransition = r5.readInt();
        this.mName = r5.readString();
        this.mIndex = r5.readInt();
        this.mBreadCrumbTitleRes = r5.readInt();
        Parcelable.Creator r10 = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mBreadCrumbTitleText = (CharSequence) r10.createFromParcel(r5);
        this.mBreadCrumbShortTitleRes = r5.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) r10.createFromParcel(r5);
        this.mSharedElementSourceNames = r5.createStringArrayList();
        this.mSharedElementTargetNames = r5.createStringArrayList();
        if (r5.readInt() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.mReorderingAllowed = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }
}
