package androidx.core.os;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel r10, ClassLoader r11);

    T[] newArray(int r10);
}
