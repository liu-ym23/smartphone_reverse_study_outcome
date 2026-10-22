package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = null;

    class a implements Parcelable.Creator<ParcelableSparseIntArray> {
        a() {
        }

        @NonNull
        public ParcelableSparseIntArray a(@NonNull Parcel r10) {
            int r11 = r10.readInt();
            ParcelableSparseIntArray r12 = new ParcelableSparseIntArray(r11);
            int[] r13 = new int[r11];
            int[] r14 = new int[r11];
            r10.readIntArray(r13);
            r10.readIntArray(r14);
            int r15 = 0;
        L3:
            if (r15 >= r11) goto L5;
            r12.put(r13[r15], r14[r15]);
            r15 = r15 + 1;
            goto L3
        L5:
            return r12;
        }

        @NonNull
        public ParcelableSparseIntArray[] b(int r10) {
            return new ParcelableSparseIntArray[r10];
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ ParcelableSparseIntArray createFromParcel(@NonNull Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        public /* bridge */ /* synthetic */ ParcelableSparseIntArray[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(int r10) {
        super(r10);
    }

    public ParcelableSparseIntArray(@NonNull SparseIntArray r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        put(r10.keyAt(r11), r10.valueAt(r11));
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        int[] r12 = new int[size()];
        int[] r13 = new int[size()];
        int r14 = 0;
    L4:
        if (r14 >= size()) goto L6;
        r12[r14] = keyAt(r14);
        r13[r14] = valueAt(r14);
        r14 = r14 + 1;
        goto L4
    L6:
        r10.writeInt(size());
        r10.writeIntArray(r12);
        r10.writeIntArray(r13);
    }
}
