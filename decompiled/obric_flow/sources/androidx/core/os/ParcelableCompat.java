package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ParcelableCompat {

    public static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> r5) {
            this.mCallbacks = r5;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel r5) {
            return this.mCallbacks.createFromParcel(r5, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int r5) {
            return this.mCallbacks.newArray(r5);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel r5, ClassLoader r10) {
            return this.mCallbacks.createFromParcel(r5, r10);
        }
    }

    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> r5) {
        return new ParcelableCompatCreatorHoneycombMR2(r5);
    }
}
