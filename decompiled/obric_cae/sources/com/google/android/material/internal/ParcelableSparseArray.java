package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = null;

    public class a implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r8) {
            return new ParcelableSparseArray(r8, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r8) {
            return new ParcelableSparseArray[r8];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final ParcelableSparseArray createFromParcel(Parcel r8, ClassLoader r10) {
            return new ParcelableSparseArray(r8, r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(Parcel r8, ClassLoader r10) {
        int r11 = r8.readInt();
        int[] r12 = new int[r11];
        r8.readIntArray(r12);
        Parcelable[] r13 = r8.readParcelableArray(r10);
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        put(r12[r14], r13[r14]);
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = size();
        int[] r12 = new int[r11];
        Parcelable[] r13 = new Parcelable[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r12[r14] = keyAt(r14);
        r13[r14] = valueAt(r14);
        r14 = r14 + 1;
        goto L3
    L5:
        r8.writeInt(r11);
        r8.writeIntArray(r12);
        r8.writeParcelableArray(r13, r10);
    }
}
