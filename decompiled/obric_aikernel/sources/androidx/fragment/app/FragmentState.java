package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = null;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mMaxLifecycleState;
    final boolean mRemoving;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;
    final String mWho;

    static {
        CREATOR = new AnonymousClass1();
    }

    FragmentState(Parcel r10) {
        this.mClassName = r10.readString();
        this.mWho = r10.readString();
        boolean r11 = true;
        if (r10.readInt() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.mFromLayout = r12;
        this.mFragmentId = r10.readInt();
        this.mContainerId = r10.readInt();
        this.mTag = r10.readString();
        if (r10.readInt() == 0) goto L9;
        boolean r13 = true;
    L10:
        this.mRetainInstance = r13;
        if (r10.readInt() == 0) goto L13;
        boolean r14 = true;
    L14:
        this.mRemoving = r14;
        if (r10.readInt() == 0) goto L17;
        boolean r15 = true;
    L18:
        this.mDetached = r15;
        this.mArguments = r10.readBundle();
        if (r10.readInt() != 0) goto L22;
        r11 = false;
    L22:
        this.mHidden = r11;
        this.mSavedFragmentState = r10.readBundle();
        this.mMaxLifecycleState = r10.readInt();
        return;
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    FragmentState(Fragment r10) {
        this.mClassName = r10.getClass().getName();
        this.mWho = r10.mWho;
        this.mFromLayout = r10.mFromLayout;
        this.mFragmentId = r10.mFragmentId;
        this.mContainerId = r10.mContainerId;
        this.mTag = r10.mTag;
        this.mRetainInstance = r10.mRetainInstance;
        this.mRemoving = r10.mRemoving;
        this.mDetached = r10.mDetached;
        this.mArguments = r10.mArguments;
        this.mHidden = r10.mHidden;
        this.mMaxLifecycleState = r10.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("FragmentState{");
        r10.append(this.mClassName);
        r10.append(" (");
        r10.append(this.mWho);
        r10.append(")}:");
        if (this.mFromLayout == false) goto L6;
        r10.append(" fromLayout");
    L6:
        if (this.mContainerId == 0) goto L8;
        r10.append(" id=0x");
        r10.append(Integer.toHexString(this.mContainerId));
    L8:
        String r11 = this.mTag;
        if (r11 == null) goto L14;
        if (r11.isEmpty() == true) goto L14;
        r10.append(" tag=");
        r10.append(this.mTag);
    L14:
        if (this.mRetainInstance == false) goto L17;
        r10.append(" retainInstance");
    L17:
        if (this.mRemoving == false) goto L20;
        r10.append(" removing");
    L20:
        if (this.mDetached == false) goto L23;
        r10.append(" detached");
    L23:
        if (this.mHidden == false) goto L26;
        r10.append(" hidden");
    L26:
        return r10.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.mClassName);
        r10.writeString(this.mWho);
        r10.writeInt(this.mFromLayout ? 1 : 0);
        r10.writeInt(this.mFragmentId);
        r10.writeInt(this.mContainerId);
        r10.writeString(this.mTag);
        r10.writeInt(this.mRetainInstance ? 1 : 0);
        r10.writeInt(this.mRemoving ? 1 : 0);
        r10.writeInt(this.mDetached ? 1 : 0);
        r10.writeBundle(this.mArguments);
        r10.writeInt(this.mHidden ? 1 : 0);
        r10.writeBundle(this.mSavedFragmentState);
        r10.writeInt(this.mMaxLifecycleState);
    }
}
