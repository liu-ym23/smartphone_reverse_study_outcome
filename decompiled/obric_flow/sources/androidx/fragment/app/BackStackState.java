package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BackStackState(List<String> r5, List<BackStackRecordState> r10) {
        this.mFragments = r5;
        this.mTransactions = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public List<BackStackRecord> instantiate(@NonNull FragmentManager r10, Map<String, Fragment> r11) {
        HashMap r5 = new HashMap(this.mFragments.size());
        Iterator<String> r12 = this.mFragments.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        String r13 = r12.next();
        Fragment r14 = r11.get(r13);
        if (r14 != null) goto L7;
        Bundle r15 = r10.getFragmentStore().setSavedState(r13, null);
        if (r15 == null) goto L4;
        ClassLoader r16 = r10.getHost().getContext().getClassLoader();
        Fragment r17 = ((FragmentState) r15.getParcelable("state")).instantiate(r10.getFragmentFactory(), r16);
        r17.mSavedFragmentState = r15;
        if (r15.getBundle("savedInstanceState") != null) goto L13;
        r17.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
    L13:
        Bundle r18 = r15.getBundle("arguments");
        if (r18 == null) goto L16;
        r18.setClassLoader(r16);
    L16:
        r17.setArguments(r18);
        r5.put(r17.mWho, r17);
        goto L4
    L7:
        r5.put(r14.mWho, r14);
        goto L4
    L17:
        ArrayList r19 = new ArrayList();
        Iterator<BackStackRecordState> r20 = this.mTransactions.iterator();
    L19:
        if (r20.hasNext() == false) goto L21;
        r19.add(r20.next().instantiate(r10, r5));
        goto L19
    L21:
        return r19;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        r5.writeStringList(this.mFragments);
        r5.writeTypedList(this.mTransactions);
    }

    public BackStackState(@NonNull Parcel r5) {
        this.mFragments = r5.createStringArrayList();
        this.mTransactions = r5.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
