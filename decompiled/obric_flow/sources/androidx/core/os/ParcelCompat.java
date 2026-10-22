package androidx.core.os;

import ai.j0;
import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static <T extends Parcelable> List<T> readParcelableList(@NonNull Parcel r5, @NonNull List<T> r10, @Nullable ClassLoader r11) {
            return r5.readParcelableList(r10, r11);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static Parcelable.Creator<?> readParcelableCreator(@NonNull Parcel r5, @Nullable ClassLoader r10) {
            return r5.readParcelableCreator(r10);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static <T> T[] readArray(Parcel r5, ClassLoader r10, Class<T> r11) {
            return (T[]) r5.readArray(r10, r11);
        }

        @DoNotInline
        public static <T> ArrayList<T> readArrayList(Parcel r5, ClassLoader r10, Class<? extends T> r11) {
            return r5.readArrayList(r10, r11);
        }

        @DoNotInline
        public static <V, K> HashMap<K, V> readHashMap(Parcel r5, ClassLoader r10, Class<? extends K> r11, Class<? extends V> r12) {
            return r5.readHashMap(r10, r11, r12);
        }

        @DoNotInline
        public static <T> void readList(@NonNull Parcel r5, @NonNull List<? super T> r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
            r5.readList(r10, r11, r12);
        }

        @DoNotInline
        public static <K, V> void readMap(Parcel r5, Map<? super K, ? super V> r10, ClassLoader r11, Class<K> r12, Class<V> r13) {
            r5.readMap(r10, r11, r12, r13);
        }

        @DoNotInline
        public static <T extends Parcelable> T readParcelable(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
            return (T) r5.readParcelable(r10, r11);
        }

        @DoNotInline
        public static <T> T[] readParcelableArray(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
            return (T[]) r5.readParcelableArray(r10, r11);
        }

        @DoNotInline
        public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r5, ClassLoader r10, Class<T> r11) {
            return r5.readParcelableCreator(r10, r11);
        }

        @DoNotInline
        public static <T> List<T> readParcelableList(@NonNull Parcel r5, @NonNull List<T> r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
            return r5.readParcelableList(r10, r11, r12);
        }

        @DoNotInline
        public static <T extends Serializable> T readSerializable(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
            return (T) r5.readSerializable(r10, r11);
        }

        @DoNotInline
        public static <T> SparseArray<T> readSparseArray(Parcel r5, ClassLoader r10, Class<? extends T> r11) {
            return r5.readSparseArray(r10, r11);
        }
    }

    private ParcelCompat() {
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> Object[] readArray(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readArray(r5, r10, r11);
    L7:
        return r5.readArray(r10);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<? extends T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readArrayList(r5, r10, r11);
    L7:
        return r5.readArrayList(r10);
    }

    public static boolean readBoolean(@NonNull Parcel r5) {
        if (r5.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<? extends K> r11, @NonNull Class<? extends V> r12) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readHashMap(r5, r10, r11, r12);
    L7:
        return r5.readHashMap(r10);
    }

    public static <T> void readList(@NonNull Parcel r5, @NonNull List<? super T> r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api33Impl.readList(r5, r10, r11, r12);
        return;
    L5:
        r5.readList(r10, r11);
    }

    public static <K, V> void readMap(@NonNull Parcel r5, @NonNull Map<? super K, ? super V> r10, @Nullable ClassLoader r11, @NonNull Class<K> r12, @NonNull Class<V> r13) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api33Impl.readMap(r5, r10, r11, r12, r13);
        return;
    L5:
        r5.readMap(r10, r11);
    }

    @Nullable
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r12 = (T) r5.readParcelable(r10);
        if (r12 != null) goto L9;
    L13:
        return r12;
    L9:
        if (r11.isInstance(r12) == true) goto L13;
        throw new BadParcelableException("Parcelable " + r12.getClass() + " is not a subclass of required class " + r11.getName() + " provided in the parameter");
    L5:
        return (T) Api33Impl.readParcelable(r5, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Deprecated
    public static <T> T[] readParcelableArray(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T[] r12 = (T[]) r5.readParcelableArray(r10);
        if (r11.isAssignableFrom(Parcelable.class) == false) goto L9;
        return r12;
    L9:
        T[] r13 = (T[]) ((Object[]) Array.newInstance(r11, r12.length));
        int r14 = 0;
    L11:
        if (r14 >= r12.length) goto L16;
        r13[r14] = r11.cast(r12[r14]);     // Catch: ClassCastException -> L14
        r14 = r14 + 1;
    L14:
        StringBuilder r15 = j0.s(r14, "Parcelable at index ", " is not a subclass of required class ");
        r15.append(r11.getName());
        r15.append(" provided in the parameter");
        throw new BadParcelableException(r15.toString());
    L16:
        return r13;
    L5:
        return (T[]) Api33Impl.readParcelableArray(r5, r10, r11);
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> Parcelable[] readParcelableArrayTyped(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) Api33Impl.readParcelableArray(r5, r10, r11);
    L7:
        return r5.readParcelableArray(r10);
    }

    @Nullable
    @RequiresApi(30)
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readParcelableCreator(r5, r10, r11);
    L7:
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(r5, r10);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static <T> List<T> readParcelableList(@NonNull Parcel r5, @NonNull List<T> r10, @Nullable ClassLoader r11, @NonNull Class<T> r12) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readParcelableList(r5, r10, r11, r12);
    L7:
        return Api29Impl.readParcelableList(r5, r10, r11);
    }

    @Nullable
    public static <T extends Serializable> T readSerializable(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return (T) Api33Impl.readSerializable(r5, r10, r11);
    L7:
        return (T) r5.readSerializable();
    }

    @Nullable
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel r5, @Nullable ClassLoader r10, @NonNull Class<? extends T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readSparseArray(r5, r10, r11);
    L7:
        return r5.readSparseArray(r10);
    }

    public static void writeBoolean(@NonNull Parcel r5, boolean r10) {
        r5.writeInt(r10 ? 1 : 0);
    }
}
