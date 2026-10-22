package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = null;

    public class a implements Parcelable.Creator<ParcelableSparseIntArray> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseIntArray createFromParcel(Parcel r8) {
            int r10 = r8.readInt();
            ParcelableSparseIntArray r11 = new ParcelableSparseIntArray(r10);
            int[] r12 = new int[r10];
            int[] r13 = new int[r10];
            r8.readIntArray(r12);
            r8.readIntArray(r13);
            int r14 = 0;
        L3:
            if (r14 >= r10) goto L5;
            r11.put(r12[r14], r13[r14]);
            r14 = r14 + 1;
            goto L3
        L5:
            return r11;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseIntArray[] newArray(int r8) {
            return new ParcelableSparseIntArray[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ParcelableSparseIntArray() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
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
        r8.writeInt(size());
        r8.writeIntArray(r11);
        r8.writeIntArray(r12);
    }
}
