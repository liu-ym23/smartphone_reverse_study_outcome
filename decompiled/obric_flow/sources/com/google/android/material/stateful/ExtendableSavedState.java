package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = null;

    @NonNull
    public final SimpleArrayMap<String, Bundle> extendableStates;

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ ExtendableSavedState(Parcel r5, ClassLoader r10, AnonymousClass1 r11) {
        this(r5, r10);
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.extendableStates + "}";
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        super.writeToParcel(r10, r11);
        int r12 = this.extendableStates.size();
        r10.writeInt(r12);
        String[] r5 = new String[r12];
        Bundle[] r13 = new Bundle[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r5[r14] = this.extendableStates.keyAt(r14);
        r13[r14] = this.extendableStates.valueAt(r14);
        r14 = r14 + 1;
        goto L3
    L5:
        r10.writeStringArray(r5);
        r10.writeTypedArray(r13, 0);
    }

    public ExtendableSavedState(Parcelable r5) {
        super(r5);
        this.extendableStates = new SimpleArrayMap();
    }

    private ExtendableSavedState(@NonNull Parcel r10, ClassLoader r11) {
        super(r10, r11);
        int r12 = r10.readInt();
        String[] r5 = new String[r12];
        r10.readStringArray(r5);
        Bundle[] r13 = new Bundle[r12];
        r10.readTypedArray(r13, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        this.extendableStates.put(r5[r14], r13[r14]);
        r14 = r14 + 1;
        goto L3
    }
}
