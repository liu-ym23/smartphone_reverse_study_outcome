package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseBooleanArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        int[] r11 = new int[size()];
        boolean[] r12 = new boolean[size()];
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
        r5.writeBooleanArray(r12);
    }

    public ParcelableSparseBooleanArray(int r5) {
        super(r5);
    }

    public ParcelableSparseBooleanArray(@NonNull SparseBooleanArray r5) {
        super(r5.size());
        int r10 = 0;
    L4:
        if (r10 >= r5.size()) goto L6;
        put(r5.keyAt(r10), r5.valueAt(r10));
        r10 = r10 + 1;
        goto L4
    }
}
