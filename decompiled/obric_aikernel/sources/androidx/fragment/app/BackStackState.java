package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
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

    public BackStackState(Parcel r10) {
        this.mOps = r10.createIntArray();
        this.mFragmentWhos = r10.createStringArrayList();
        this.mOldMaxLifecycleStates = r10.createIntArray();
        this.mCurrentMaxLifecycleStates = r10.createIntArray();
        this.mTransition = r10.readInt();
        this.mName = r10.readString();
        this.mIndex = r10.readInt();
        this.mBreadCrumbTitleRes = r10.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        this.mBreadCrumbShortTitleRes = r10.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        this.mSharedElementSourceNames = r10.createStringArrayList();
        this.mSharedElementTargetNames = r10.createStringArrayList();
        if (r10.readInt() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.mReorderingAllowed = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public BackStackState(BackStackRecord r10) {
        int r11 = r10.mOps.size();
        this.mOps = new int[r11 * 5];
        if (r10.mAddToBackStack == false) goto L14;
        this.mFragmentWhos = new ArrayList(r11);
        this.mOldMaxLifecycleStates = new int[r11];
        this.mCurrentMaxLifecycleStates = new int[r11];
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r11) goto L11;
        FragmentTransaction.Op r14 = r10.mOps.get(r12);
        int r15 = r13 + 1;
        this.mOps[r13] = r14.mCmd;
        ArrayList<String> r16 = this.mFragmentWhos;
        Fragment r17 = r14.mFragment;
        if (r17 == null) goto L9;
        String r18 = r17.mWho;
    L10:
        r16.add(r18);
        int[] r19 = this.mOps;
        int r20 = r15 + 1;
        r19[r15] = r14.mEnterAnim;
        int r21 = r20 + 1;
        r19[r20] = r14.mExitAnim;
        int r22 = r21 + 1;
        r19[r21] = r14.mPopEnterAnim;
        r19[r22] = r14.mPopExitAnim;
        this.mOldMaxLifecycleStates[r12] = r14.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r12] = r14.mCurrentMaxState.ordinal();
        r12 = r12 + 1;
        r13 = r22 + 1;
        goto L5
    L9:
        r18 = null;
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager r10) {
        BackStackRecord r11 = new BackStackRecord(r10);
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r14 = new FragmentTransaction.Op();
        int r15 = r12 + 1;
        r14.mCmd = this.mOps[r12];
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "Instantiate " + r11 + " op #" + r13 + " base fragment #" + this.mOps[r15]);
    L8:
        String r16 = this.mFragmentWhos.get(r13);
        if (r16 == null) goto L11;
        Fragment r17 = r10.findActiveFragment(r16);
    L12:
        r14.mFragment = r17;
        r14.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r13]];
        r14.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r13]];
        int[] r18 = this.mOps;
        int r19 = r15 + 1;
        int r20 = r18[r15];
        r14.mEnterAnim = r20;
        int r21 = r19 + 1;
        int r22 = r18[r19];
        r14.mExitAnim = r22;
        int r23 = r21 + 1;
        int r24 = r18[r21];
        r14.mPopEnterAnim = r24;
        int r25 = r18[r23];
        r14.mPopExitAnim = r25;
        r11.mEnterAnim = r20;
        r11.mExitAnim = r22;
        r11.mPopEnterAnim = r24;
        r11.mPopExitAnim = r25;
        r11.addOp(r14);
        r13 = r13 + 1;
        r12 = r23 + 1;
        goto L4
    L11:
        r17 = null;
        goto L12
    L13:
        r11.mTransition = this.mTransition;
        r11.mName = this.mName;
        r11.mIndex = this.mIndex;
        r11.mAddToBackStack = true;
        r11.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        r11.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        r11.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        r11.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        r11.mSharedElementSourceNames = this.mSharedElementSourceNames;
        r11.mSharedElementTargetNames = this.mSharedElementTargetNames;
        r11.mReorderingAllowed = this.mReorderingAllowed;
        r11.bumpBackStackNesting(1);
        return r11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeIntArray(this.mOps);
        r10.writeStringList(this.mFragmentWhos);
        r10.writeIntArray(this.mOldMaxLifecycleStates);
        r10.writeIntArray(this.mCurrentMaxLifecycleStates);
        r10.writeInt(this.mTransition);
        r10.writeString(this.mName);
        r10.writeInt(this.mIndex);
        r10.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r10, 0);
        r10.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r10, 0);
        r10.writeStringList(this.mSharedElementSourceNames);
        r10.writeStringList(this.mSharedElementTargetNames);
        r10.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
