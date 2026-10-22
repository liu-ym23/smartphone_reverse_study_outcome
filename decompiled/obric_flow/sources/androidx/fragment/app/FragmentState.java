package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = null;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mMaxLifecycleState;
    final boolean mRemoving;
    final boolean mRetainInstance;
    final String mTag;
    final int mTargetRequestCode;
    final String mTargetWho;
    final boolean mUserVisibleHint;
    final String mWho;

    static {
        CREATOR = new AnonymousClass1();
    }

    public FragmentState(Fragment r5) {
        this.mClassName = r5.getClass().getName();
        this.mWho = r5.mWho;
        this.mFromLayout = r5.mFromLayout;
        this.mFragmentId = r5.mFragmentId;
        this.mContainerId = r5.mContainerId;
        this.mTag = r5.mTag;
        this.mRetainInstance = r5.mRetainInstance;
        this.mRemoving = r5.mRemoving;
        this.mDetached = r5.mDetached;
        this.mHidden = r5.mHidden;
        this.mMaxLifecycleState = r5.mMaxState.ordinal();
        this.mTargetWho = r5.mTargetWho;
        this.mTargetRequestCode = r5.mTargetRequestCode;
        this.mUserVisibleHint = r5.mUserVisibleHint;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Fragment instantiate(@NonNull FragmentFactory r5, @NonNull ClassLoader r10) {
        Fragment r11 = r5.instantiate(r10, this.mClassName);
        r11.mWho = this.mWho;
        r11.mFromLayout = this.mFromLayout;
        r11.mRestored = true;
        r11.mFragmentId = this.mFragmentId;
        r11.mContainerId = this.mContainerId;
        r11.mTag = this.mTag;
        r11.mRetainInstance = this.mRetainInstance;
        r11.mRemoving = this.mRemoving;
        r11.mDetached = this.mDetached;
        r11.mHidden = this.mHidden;
        r11.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        r11.mTargetWho = this.mTargetWho;
        r11.mTargetRequestCode = this.mTargetRequestCode;
        r11.mUserVisibleHint = this.mUserVisibleHint;
        return r11;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.x(128, "FragmentState{");
        r5.append(this.mClassName);
        r5.append(" (");
        r5.append(this.mWho);
        r5.append(")}:");
        if (this.mFromLayout == false) goto L6;
        r5.append(" fromLayout");
    L6:
        if (this.mContainerId == 0) goto L8;
        r5.append(" id=0x");
        r5.append(Integer.toHexString(this.mContainerId));
    L8:
        String r10 = this.mTag;
        if (r10 == null) goto L14;
        if (r10.isEmpty() == true) goto L14;
        r5.append(" tag=");
        r5.append(this.mTag);
    L14:
        if (this.mRetainInstance == false) goto L17;
        r5.append(" retainInstance");
    L17:
        if (this.mRemoving == false) goto L20;
        r5.append(" removing");
    L20:
        if (this.mDetached == false) goto L23;
        r5.append(" detached");
    L23:
        if (this.mHidden == false) goto L26;
        r5.append(" hidden");
    L26:
        if (this.mTargetWho == null) goto L29;
        r5.append(" targetWho=");
        r5.append(this.mTargetWho);
        r5.append(" targetRequestCode=");
        r5.append(this.mTargetRequestCode);
    L29:
        if (this.mUserVisibleHint == false) goto L32;
        r5.append(" userVisibleHint");
    L32:
        return r5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        r5.writeString(this.mClassName);
        r5.writeString(this.mWho);
        r5.writeInt(this.mFromLayout ? 1 : 0);
        r5.writeInt(this.mFragmentId);
        r5.writeInt(this.mContainerId);
        r5.writeString(this.mTag);
        r5.writeInt(this.mRetainInstance ? 1 : 0);
        r5.writeInt(this.mRemoving ? 1 : 0);
        r5.writeInt(this.mDetached ? 1 : 0);
        r5.writeInt(this.mHidden ? 1 : 0);
        r5.writeInt(this.mMaxLifecycleState);
        r5.writeString(this.mTargetWho);
        r5.writeInt(this.mTargetRequestCode);
        r5.writeInt(this.mUserVisibleHint ? 1 : 0);
    }

    public FragmentState(Parcel r5) {
        this.mClassName = r5.readString();
        this.mWho = r5.readString();
        boolean r10 = false;
        if (r5.readInt() == 0) goto L5;
        boolean r11 = true;
    L6:
        this.mFromLayout = r11;
        this.mFragmentId = r5.readInt();
        this.mContainerId = r5.readInt();
        this.mTag = r5.readString();
        if (r5.readInt() == 0) goto L9;
        boolean r12 = true;
    L10:
        this.mRetainInstance = r12;
        if (r5.readInt() == 0) goto L13;
        boolean r13 = true;
    L14:
        this.mRemoving = r13;
        if (r5.readInt() == 0) goto L17;
        boolean r14 = true;
    L18:
        this.mDetached = r14;
        if (r5.readInt() == 0) goto L21;
        boolean r15 = true;
    L22:
        this.mHidden = r15;
        this.mMaxLifecycleState = r5.readInt();
        this.mTargetWho = r5.readString();
        this.mTargetRequestCode = r5.readInt();
        if (r5.readInt() == 0) goto L25;
        r10 = true;
    L25:
        this.mUserVisibleHint = r10;
        return;
    L21:
        r15 = false;
        goto L22
    L17:
        r14 = false;
        goto L18
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L6
    }
}
