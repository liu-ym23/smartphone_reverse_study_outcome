package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelCompat {

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static <T extends Parcelable> List<T> readParcelableList(@NonNull Parcel r10, @NonNull List<T> r11, @Nullable ClassLoader r12) {
            return r10.readParcelableList(r11, r12);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static Parcelable.Creator<?> readParcelableCreator(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            return r10.readParcelableCreator(r11);
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T[] readArray(Parcel r10, ClassLoader r11, Class<T> r12) {
            return (T[]) r10.readArray(r11, r12);
        }

        @DoNotInline
        static <T> ArrayList<T> readArrayList(Parcel r10, ClassLoader r11, Class<? extends T> r12) {
            return r10.readArrayList(r11, r12);
        }

        @DoNotInline
        static <V, K> HashMap<K, V> readHashMap(Parcel r10, ClassLoader r11, Class<? extends K> r12, Class<? extends V> r13) {
            return r10.readHashMap(r11, r12, r13);
        }

        @DoNotInline
        static <T> void readList(@NonNull Parcel r10, @NonNull List<? super T> r11, @Nullable ClassLoader r12, @NonNull Class<T> r13) {
            r10.readList(r11, r12, r13);
        }

        @DoNotInline
        static <K, V> void readMap(Parcel r10, Map<? super K, ? super V> r11, ClassLoader r12, Class<K> r13, Class<V> r14) {
            r10.readMap(r11, r12, r13, r14);
        }

        @DoNotInline
        static <T extends Parcelable> T readParcelable(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
            return (T) r10.readParcelable(r11, r12);
        }

        @DoNotInline
        static <T> T[] readParcelableArray(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
            return (T[]) r10.readParcelableArray(r11, r12);
        }

        @DoNotInline
        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r10, ClassLoader r11, Class<T> r12) {
            return r10.readParcelableCreator(r11, r12);
        }

        @DoNotInline
        static <T> List<T> readParcelableList(@NonNull Parcel r10, @NonNull List<T> r11, @Nullable ClassLoader r12, @NonNull Class<T> r13) {
            return r10.readParcelableList(r11, r12, r13);
        }

        @DoNotInline
        static <T extends Serializable> T readSerializable(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
            return (T) r10.readSerializable(r11, r12);
        }

        @DoNotInline
        static <T> SparseArray<T> readSparseArray(Parcel r10, ClassLoader r11, Class<? extends T> r12) {
            return r10.readSparseArray(r11, r12);
        }
    }

    private ParcelCompat() {
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> Object[] readArray(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readArray(r10, r11, r12);
    L7:
        return r10.readArray(r11);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<? extends T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readArrayList(r10, r11, r12);
    L7:
        return r10.readArrayList(r11);
    }

    public static boolean readBoolean(@NonNull Parcel r10) {
        if (r10.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<? extends K> r12, @NonNull Class<? extends V> r13) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readHashMap(r10, r11, r12, r13);
    L7:
        return r10.readHashMap(r11);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> void readList(@NonNull Parcel r10, @NonNull List<? super T> r11, @Nullable ClassLoader r12, @NonNull Class<T> r13) {
        if (BuildCompat.isAtLeastU() == false) goto L5;
        Api33Impl.readList(r10, r11, r12, r13);
        return;
    L5:
        r10.readList(r11, r12);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <K, V> void readMap(@NonNull Parcel r10, @NonNull Map<? super K, ? super V> r11, @Nullable ClassLoader r12, @NonNull Class<K> r13, @NonNull Class<V> r14) {
        if (BuildCompat.isAtLeastU() == false) goto L5;
        Api33Impl.readMap(r10, r11, r12, r13, r14);
        return;
    L5:
        r10.readMap(r11, r12);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T r13 = (T) r10.readParcelable(r11);
        if (r13 != null) goto L9;
    L13:
        return r13;
    L9:
        if (r12.isInstance(r13) == true) goto L13;
        throw new BadParcelableException("Parcelable " + r13.getClass() + " is not a subclass of required class " + r12.getName() + " provided in the parameter");
    L5:
        return (T) Api33Impl.readParcelable(r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Deprecated
    @Nullable
    public static <T> T[] readParcelableArray(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T[] r13 = (T[]) r10.readParcelableArray(r11);
        if (r12.isAssignableFrom(Parcelable.class) == false) goto L9;
        return r13;
    L9:
        T[] r14 = (T[]) ((Object[]) Array.newInstance(r12, r13.length));
        int r15 = 0;
    L11:
        if (r15 >= r13.length) goto L16;
        r14[r15] = r12.cast(r13[r15]);     // Catch: ClassCastException -> L14
        r15 = r15 + 1;
    L15:
        throw new BadParcelableException("Parcelable at index " + r15 + " is not a subclass of required class " + r12.getName() + " provided in the parameter");
    L16:
        return r14;
    L5:
        return (T[]) Api33Impl.readParcelableArray(r10, r11, r12);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> Parcelable[] readParcelableArrayTyped(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return (Parcelable[]) Api33Impl.readParcelableArray(r10, r11, r12);
    L7:
        return r10.readParcelableArray(r11);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(30)
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readParcelableCreator(r10, r11, r12);
    L7:
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(r10, r11);
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(api = 29)
    public static <T> List<T> readParcelableList(@NonNull Parcel r10, @NonNull List<T> r11, @Nullable ClassLoader r12, @NonNull Class<T> r13) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readParcelableList(r10, r11, r12, r13);
    L7:
        return Api29Impl.readParcelableList(r10, r11, r12);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T extends Serializable> T readSerializable(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return (T) Api33Impl.readSerializable(r10, r11, r12);
    L7:
        return (T) r10.readSerializable();
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel r10, @Nullable ClassLoader r11, @NonNull Class<? extends T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.readSparseArray(r10, r11, r12);
    L7:
        return r10.readSparseArray(r11);
    }

    public static void writeBoolean(@NonNull Parcel r10, boolean r11) {
        r10.writeInt(r11 ? 1 : 0);
    }
}
