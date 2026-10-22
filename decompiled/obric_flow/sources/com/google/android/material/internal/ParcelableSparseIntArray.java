package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseIntArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        int[] r11 = new int[size()];
        int[] r12 = new int[size()];
        int r13 = 0;
    L4:
        if (r13 >= size()) goto L6;
        r11[r13] = keyAt(r13);
        r12[r13] = valueAt(r13);
        r13 = r13 + 1;
        goto L4
    L6:
        r5.writeInt(size());
        r5.writeIntArray(r11);
        r5.writeIntArray(r12);
    }

    public ParcelableSparseIntArray(int r5) {
        super(r5);
    }

    public ParcelableSparseIntArray(@NonNull SparseIntArray r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.size()) goto L6;
        put(r5.keyAt(r10), r5.valueAt(r10));
        r10 = r10 + 1;
        goto L4
    }
}
