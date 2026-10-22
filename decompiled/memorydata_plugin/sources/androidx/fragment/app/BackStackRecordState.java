package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

    BackStackRecordState(Parcel r4) {
        this.mOps = r4.createIntArray();
        this.mFragmentWhos = r4.createStringArrayList();
        this.mOldMaxLifecycleStates = r4.createIntArray();
        this.mCurrentMaxLifecycleStates = r4.createIntArray();
        this.mTransition = r4.readInt();
        this.mName = r4.readString();
        this.mIndex = r4.readInt();
        this.mBreadCrumbTitleRes = r4.readInt();
        this.mBreadCrumbTitleText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r4), CharSequence.class, "com.obric.memorydata.plugin");
        this.mBreadCrumbShortTitleRes = r4.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r4), CharSequence.class, "com.obric.memorydata.plugin");
        this.mSharedElementSourceNames = r4.createStringArrayList();
        this.mSharedElementTargetNames = r4.createStringArrayList();
        if (r4.readInt() == 0) goto L5;
        boolean r5 = true;
    L6:
        this.mReorderingAllowed = r5;
        return;
    L5:
        r5 = false;
        goto L6
    }

    BackStackRecordState(BackStackRecord r8) {
        int r0 = r8.mOps.size();
        this.mOps = new int[r0 * 6];
        if (r8.mAddToBackStack == false) goto L14;
        this.mFragmentWhos = new ArrayList(r0);
        this.mOldMaxLifecycleStates = new int[r0];
        this.mCurrentMaxLifecycleStates = new int[r0];
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L11;
        FragmentTransaction.Op r3 = (FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r8.mOps.get(r1), FragmentTransaction.Op.class, "com.obric.memorydata.plugin");
        int r5 = r2 + 1;
        this.mOps[r2] = r3.mCmd;
        ArrayList<String> r4 = this.mFragmentWhos;
        if (r3.mFragment == null) goto L9;
        String r6 = r3.mFragment.mWho;
    L10:
        r4.add(r6);
        int r7 = r5 + 1;
        this.mOps[r5] = r3.mFromExpandedOp ? 1 : 0;
        int r9 = r7 + 1;
        this.mOps[r7] = r3.mEnterAnim;
        int r10 = r9 + 1;
        this.mOps[r9] = r3.mExitAnim;
        int r11 = r10 + 1;
        this.mOps[r10] = r3.mPopEnterAnim;
        this.mOps[r11] = r3.mPopExitAnim;
        this.mOldMaxLifecycleStates[r1] = r3.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r1] = r3.mCurrentMaxState.ordinal();
        r1 = r1 + 1;
        r2 = r11 + 1;
        goto L5
    L9:
        r6 = null;
        goto L10
    L11:
        this.mTransition = r8.mTransition;
        this.mName = r8.mName;
        this.mIndex = r8.mIndex;
        this.mBreadCrumbTitleRes = r8.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r8.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = r8.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r8.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = r8.mSharedElementSourceNames;
        this.mSharedElementTargetNames = r8.mSharedElementTargetNames;
        this.mReorderingAllowed = r8.mReorderingAllowed;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(BackStackRecord r8) {
        int r1 = 0;
        int r2 = 0;
    L3:
        boolean r4 = true;
        if (r1 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r3 = new FragmentTransaction.Op();
        int r6 = r1 + 1;
        r3.mCmd = this.mOps[r1];
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Instantiate " + r8 + " op #" + r2 + " base fragment #" + this.mOps[r6]);
    L8:
        r3.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r2]];
        r3.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r2]];
        int r5 = r6 + 1;
        if (this.mOps[r6] != 0) goto L12;
        r4 = false;
    L12:
        r3.mFromExpandedOp = r4;
        int r7 = r5 + 1;
        r3.mEnterAnim = this.mOps[r5];
        int r9 = r7 + 1;
        r3.mExitAnim = this.mOps[r7];
        int r10 = r9 + 1;
        r3.mPopEnterAnim = this.mOps[r9];
        r3.mPopExitAnim = this.mOps[r10];
        r8.mEnterAnim = r3.mEnterAnim;
        r8.mExitAnim = r3.mExitAnim;
        r8.mPopEnterAnim = r3.mPopEnterAnim;
        r8.mPopExitAnim = r3.mPopExitAnim;
        r8.addOp(r3);
        r2 = r2 + 1;
        r1 = r10 + 1;
        goto L3
    L13:
        r8.mTransition = this.mTransition;
        r8.mName = this.mName;
        r8.mAddToBackStack = true;
        r8.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        r8.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        r8.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        r8.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        r8.mSharedElementSourceNames = this.mSharedElementSourceNames;
        r8.mSharedElementTargetNames = this.mSharedElementTargetNames;
        r8.mReorderingAllowed = this.mReorderingAllowed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager r7) {
        BackStackRecord r0 = new BackStackRecord(r7);
        fillInBackStackRecord(r0);
        r0.mIndex = this.mIndex;
        int r1 = 0;
    L4:
        if (r1 >= this.mFragmentWhos.size()) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.mFragmentWhos.get(r1), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        FragmentTransaction.Op r3 = (FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r0.mOps.get(r1), FragmentTransaction.Op.class, "com.obric.memorydata.plugin");
        r3.mFragment = r7.findActiveFragment(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        r0.bumpBackStackNesting(1);
        return r0;
    }

    public BackStackRecord instantiate(FragmentManager r6, Map<String, Fragment> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        BackStackRecord r0 = new BackStackRecord(r6);
        fillInBackStackRecord(r0);
        int r9 = 0;
    L4:
        if (r9 >= this.mFragmentWhos.size()) goto L13;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.mFragmentWhos.get(r9), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r8.get(r2), Fragment.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        ((FragmentTransaction.Op) ZeusTransformUtils.preCheckCast(r0.mOps.get(r9), FragmentTransaction.Op.class, "com.obric.memorydata.plugin")).mFragment = r3;
        goto L12
    L11:
        throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + r2 + ")");
    L12:
        r9 = r9 + 1;
        goto L4
    L13:
        return r0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeIntArray(this.mOps);
        r2.writeStringList(this.mFragmentWhos);
        r2.writeIntArray(this.mOldMaxLifecycleStates);
        r2.writeIntArray(this.mCurrentMaxLifecycleStates);
        r2.writeInt(this.mTransition);
        r2.writeString(this.mName);
        r2.writeInt(this.mIndex);
        r2.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r2, 0);
        r2.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r2, 0);
        r2.writeStringList(this.mSharedElementSourceNames);
        r2.writeStringList(this.mSharedElementTargetNames);
        r2.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
