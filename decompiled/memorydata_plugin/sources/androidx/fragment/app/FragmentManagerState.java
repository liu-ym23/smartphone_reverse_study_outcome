package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;
    ArrayList<String> mActive;
    ArrayList<String> mAdded;
    BackStackRecordState[] mBackStack;
    int mBackStackIndex;
    ArrayList<String> mBackStackStateKeys;
    ArrayList<BackStackState> mBackStackStates;
    ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    String mPrimaryNavActiveWho;

    static {
        CREATOR = new AnonymousClass1();
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
    }

    public FragmentManagerState(Parcel r4) {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
        this.mActive = r4.createStringArrayList();
        this.mAdded = r4.createStringArrayList();
        this.mBackStack = (BackStackRecordState[]) ZeusTransformUtils.preCheckCast(r4.createTypedArray(BackStackRecordState.CREATOR), BackStackRecordState[].class, "com.obric.memorydata.plugin");
        this.mBackStackIndex = r4.readInt();
        this.mPrimaryNavActiveWho = r4.readString();
        this.mBackStackStateKeys = r4.createStringArrayList();
        this.mBackStackStates = r4.createTypedArrayList(BackStackState.CREATOR);
        this.mLaunchedFragments = r4.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeStringList(this.mActive);
        r2.writeStringList(this.mAdded);
        r2.writeTypedArray(this.mBackStack, r3);
        r2.writeInt(this.mBackStackIndex);
        r2.writeString(this.mPrimaryNavActiveWho);
        r2.writeStringList(this.mBackStackStateKeys);
        r2.writeTypedList(this.mBackStackStates);
        r2.writeTypedList(this.mLaunchedFragments);
    }
}
