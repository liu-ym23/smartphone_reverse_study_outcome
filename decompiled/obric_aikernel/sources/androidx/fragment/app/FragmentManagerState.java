package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;
    ArrayList<FragmentState> mActive;
    ArrayList<String> mAdded;
    BackStackState[] mBackStack;
    int mBackStackIndex;
    ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    String mPrimaryNavActiveWho;
    ArrayList<String> mResultKeys;
    ArrayList<Bundle> mResults;

    static {
        CREATOR = new AnonymousClass1();
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
    }

    public FragmentManagerState(Parcel r10) {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
        this.mActive = r10.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = r10.createStringArrayList();
        this.mBackStack = (BackStackState[]) r10.createTypedArray(BackStackState.CREATOR);
        this.mBackStackIndex = r10.readInt();
        this.mPrimaryNavActiveWho = r10.readString();
        this.mResultKeys = r10.createStringArrayList();
        this.mResults = r10.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = r10.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeTypedList(this.mActive);
        r10.writeStringList(this.mAdded);
        r10.writeTypedArray(this.mBackStack, r11);
        r10.writeInt(this.mBackStackIndex);
        r10.writeString(this.mPrimaryNavActiveWho);
        r10.writeStringList(this.mResultKeys);
        r10.writeTypedList(this.mResults);
        r10.writeTypedList(this.mLaunchedFragments);
    }
}
