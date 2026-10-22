package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        r5.writeStringList(this.mActive);
        r5.writeStringList(this.mAdded);
        r5.writeTypedArray(this.mBackStack, r10);
        r5.writeInt(this.mBackStackIndex);
        r5.writeString(this.mPrimaryNavActiveWho);
        r5.writeStringList(this.mBackStackStateKeys);
        r5.writeTypedList(this.mBackStackStates);
        r5.writeTypedList(this.mLaunchedFragments);
    }

    public FragmentManagerState(Parcel r5) {
        this.mPrimaryNavActiveWho = null;
        this.mBackStackStateKeys = new ArrayList();
        this.mBackStackStates = new ArrayList();
        this.mActive = r5.createStringArrayList();
        this.mAdded = r5.createStringArrayList();
        this.mBackStack = (BackStackRecordState[]) r5.createTypedArray(BackStackRecordState.CREATOR);
        this.mBackStackIndex = r5.readInt();
        this.mPrimaryNavActiveWho = r5.readString();
        this.mBackStackStateKeys = r5.createStringArrayList();
        this.mBackStackStates = r5.createTypedArrayList(BackStackState.CREATOR);
        this.mLaunchedFragments = r5.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
