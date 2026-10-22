package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ParcelableCompat {

    static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> r10) {
            this.mCallbacks = r10;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel r10) {
            return this.mCallbacks.createFromParcel(r10, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel r10, ClassLoader r11) {
            return this.mCallbacks.createFromParcel(r10, r11);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int r10) {
            return this.mCallbacks.newArray(r10);
        }
    }

    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> r10) {
        return new ParcelableCompatCreatorHoneycombMR2(r10);
    }
}
