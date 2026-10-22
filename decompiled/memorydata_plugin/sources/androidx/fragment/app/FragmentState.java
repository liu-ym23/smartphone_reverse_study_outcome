package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
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

    FragmentState(Parcel r4) {
        this.mClassName = r4.readString();
        this.mWho = r4.readString();
        boolean r1 = true;
        if (r4.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mFromLayout = r0;
        this.mFragmentId = r4.readInt();
        this.mContainerId = r4.readInt();
        this.mTag = r4.readString();
        if (r4.readInt() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.mRetainInstance = r2;
        if (r4.readInt() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.mRemoving = r3;
        if (r4.readInt() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.mDetached = r5;
        this.mArguments = r4.readBundle();
        if (r4.readInt() != 0) goto L22;
        r1 = false;
    L22:
        this.mHidden = r1;
        this.mSavedFragmentState = r4.readBundle();
        this.mMaxLifecycleState = r4.readInt();
        return;
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    FragmentState(Fragment r2) {
        this.mClassName = r2.getClass().getName();
        this.mWho = r2.mWho;
        this.mFromLayout = r2.mFromLayout;
        this.mFragmentId = r2.mFragmentId;
        this.mContainerId = r2.mContainerId;
        this.mTag = r2.mTag;
        this.mRetainInstance = r2.mRetainInstance;
        this.mRemoving = r2.mRemoving;
        this.mDetached = r2.mDetached;
        this.mArguments = r2.mArguments;
        this.mHidden = r2.mHidden;
        this.mMaxLifecycleState = r2.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Fragment instantiate(FragmentFactory r2, ClassLoader r3) {
        Fragment r4 = r2.instantiate(r3, this.mClassName);
        Bundle r0 = this.mArguments;
        if (r0 == null) goto L5;
        r0.setClassLoader(r3);
    L5:
        r4.setArguments(this.mArguments);
        r4.mWho = this.mWho;
        r4.mFromLayout = this.mFromLayout;
        r4.mRestored = true;
        r4.mFragmentId = this.mFragmentId;
        r4.mContainerId = this.mContainerId;
        r4.mTag = this.mTag;
        r4.mRetainInstance = this.mRetainInstance;
        r4.mRemoving = this.mRemoving;
        r4.mDetached = this.mDetached;
        r4.mHidden = this.mHidden;
        r4.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        Bundle r1 = this.mSavedFragmentState;
        if (r1 != null) goto L9;
        r1 = new Bundle();
    L9:
        r4.mSavedFragmentState = r1;
        return r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("FragmentState{");
        r0.append(this.mClassName);
        r0.append(" (");
        r0.append(this.mWho);
        r0.append(")}:");
        if (this.mFromLayout == false) goto L6;
        r0.append(" fromLayout");
    L6:
        if (this.mContainerId == 0) goto L8;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mContainerId));
    L8:
        String r1 = this.mTag;
        if (r1 == null) goto L14;
        if (r1.isEmpty() == true) goto L14;
        r0.append(" tag=");
        r0.append(this.mTag);
    L14:
        if (this.mRetainInstance == false) goto L17;
        r0.append(" retainInstance");
    L17:
        if (this.mRemoving == false) goto L20;
        r0.append(" removing");
    L20:
        if (this.mDetached == false) goto L23;
        r0.append(" detached");
    L23:
        if (this.mHidden == false) goto L26;
        r0.append(" hidden");
    L26:
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mClassName);
        r1.writeString(this.mWho);
        r1.writeInt(this.mFromLayout ? 1 : 0);
        r1.writeInt(this.mFragmentId);
        r1.writeInt(this.mContainerId);
        r1.writeString(this.mTag);
        r1.writeInt(this.mRetainInstance ? 1 : 0);
        r1.writeInt(this.mRemoving ? 1 : 0);
        r1.writeInt(this.mDetached ? 1 : 0);
        r1.writeBundle(this.mArguments);
        r1.writeInt(this.mHidden ? 1 : 0);
        r1.writeBundle(this.mSavedFragmentState);
        r1.writeInt(this.mMaxLifecycleState);
    }
}
