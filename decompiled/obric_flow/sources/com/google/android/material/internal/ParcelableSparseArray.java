package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        int r5 = size();
        int[] r12 = new int[r5];
        Parcelable[] r13 = new Parcelable[r5];
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L5;
        r12[r14] = keyAt(r14);
        r13[r14] = valueAt(r14);
        r14 = r14 + 1;
        goto L3
    L5:
        r10.writeInt(r5);
        r10.writeIntArray(r12);
        r10.writeParcelableArray(r13, r11);
    }

    public ParcelableSparseArray(@NonNull Parcel r5, @Nullable ClassLoader r10) {
        int r11 = r5.readInt();
        int[] r12 = new int[r11];
        r5.readIntArray(r12);
        Parcelable[] r13 = r5.readParcelableArray(r10);
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        put(r12[r14], r13[r14]);
        r14 = r14 + 1;
        goto L3
    }
}
