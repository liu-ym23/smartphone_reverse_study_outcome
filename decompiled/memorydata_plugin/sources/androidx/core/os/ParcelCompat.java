package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelCompat {

    static class Api29Impl {
        private Api29Impl() {
        }

        static <T extends Parcelable> List<T> readParcelableList(Parcel r2, List<T> r3, ClassLoader r4) {
            return r2.readParcelableList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Parcelable.Creator<?> readParcelableCreator(Parcel r0, ClassLoader r1) {
            return r0.readParcelableCreator(r1);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T[] readArray(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T[]) r0.readArray(r1, r2);
        }

        static <T> ArrayList<T> readArrayList(Parcel r0, ClassLoader r1, Class<? extends T> r2) {
            return r0.readArrayList(r1, r2);
        }

        static <V, K> HashMap<K, V> readHashMap(Parcel r0, ClassLoader r1, Class<? extends K> r2, Class<? extends V> r3) {
            return r0.readHashMap(r1, r2, r3);
        }

        static <T> void readList(Parcel r2, List<? super T> r3, ClassLoader r4, Class<T> r5) {
            r2.readList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        static <K, V> void readMap(Parcel r2, Map<? super K, ? super V> r3, ClassLoader r4, Class<K> r5, Class<V> r6) {
            r2.readMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        static <T extends Parcelable> T readParcelable(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(r0.readParcelable(r1, r2), Parcelable.class, "com.obric.memorydata.plugin");
        }

        static <T> T[] readParcelableArray(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T[]) r0.readParcelableArray(r1, r2);
        }

        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r0, ClassLoader r1, Class<T> r2) {
            return r0.readParcelableCreator(r1, r2);
        }

        static <T> List<T> readParcelableList(Parcel r2, List<T> r3, ClassLoader r4, Class<T> r5) {
            return r2.readParcelableList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        static <T extends Serializable> T readSerializable(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(r0.readSerializable(r1, r2), Serializable.class, "com.obric.memorydata.plugin");
        }

        static <T> SparseArray<T> readSparseArray(Parcel r0, ClassLoader r1, Class<? extends T> r2) {
            return r0.readSparseArray(r1, r2);
        }
    }

    private ParcelCompat() {
    }

    public static <T> Object[] readArray(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readArray(r2, r3, r4);
    L7:
        return r2.readArray(r3);
    }

    public static <T> ArrayList<T> readArrayList(Parcel r2, ClassLoader r3, Class<? extends T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readArrayList(r2, r3, r4);
    L7:
        return r2.readArrayList(r3);
    }

    public static boolean readBoolean(Parcel r0) {
        if (r0.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static <K, V> HashMap<K, V> readHashMap(Parcel r2, ClassLoader r3, Class<? extends K> r4, Class<? extends V> r5) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readHashMap(r2, r3, r4, r5);
    L7:
        return r2.readHashMap(r3);
    }

    public static <T> void readList(Parcel r2, List<? super T> r3, ClassLoader r4, Class<T> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api33Impl.readList(r2, r6, r4, r5);
        return;
    L5:
        r2.readList(r6, r4);
    }

    public static <K, V> void readMap(Parcel r2, Map<? super K, ? super V> r3, ClassLoader r4, Class<K> r5, Class<V> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api33Impl.readMap(r2, r7, r4, r5, r6);
        return;
    L5:
        r2.readMap(r7, r4);
    }

    public static <T extends Parcelable> T readParcelable(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r5 = (T) r2.readParcelable(r3);
        if (r5 != null) goto L9;
    L13:
        return r5;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, r5) == true) goto L13;
        throw new BadParcelableException("Parcelable " + r5.getClass() + " is not a subclass of required class " + r4.getName() + " provided in the parameter");
    L5:
        return (T) Api33Impl.readParcelable(r2, r3, r4);
    }

    @Deprecated
    public static <T> T[] readParcelableArray(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        Parcelable[] r5 = r2.readParcelableArray(r3);
        if (r4.isAssignableFrom(Parcelable.class) == true) goto L9;
        T[] r6 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4, r5.length), Object[].class, "com.obric.memorydata.plugin"));
        int r0 = 0;
    L12:
        if (r0 >= r5.length) goto L17;
        r6[r0] = r4.cast(r5[r0]);     // Catch: ClassCastException -> L15
        r0 = r0 + 1;
    L16:
        throw new BadParcelableException("Parcelable at index " + r0 + " is not a subclass of required class " + r4.getName() + " provided in the parameter");
    L17:
        return r6;
    L9:
        return (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin"));
    L5:
        return (T[]) Api33Impl.readParcelableArray(r2, r3, r4);
    }

    public static <T> Parcelable[] readParcelableArrayTyped(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) ZeusTransformUtils.preCheckCast(Api33Impl.readParcelableArray(r2, r3, r4), Parcelable[].class, "com.obric.memorydata.plugin");
    L7:
        return r2.readParcelableArray(r3);
    }

    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readParcelableCreator(r2, r3, r4);
    L7:
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(r2, r3);
    }

    public static <T> List<T> readParcelableList(Parcel r2, List<T> r3, ClassLoader r4, Class<T> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readParcelableList(r2, r6, r4, r5);
    L7:
        return Api29Impl.readParcelableList(r2, r6, r4);
    }

    public static <T extends Serializable> T readSerializable(Parcel r2, ClassLoader r3, Class<T> r4) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return (T) Api33Impl.readSerializable(r2, r3, r4);
    L7:
        return (T) r2.readSerializable();
    }

    public static <T> SparseArray<T> readSparseArray(Parcel r2, ClassLoader r3, Class<? extends T> r4) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.readSparseArray(r2, r3, r4);
    L7:
        return r2.readSparseArray(r3);
    }

    public static void writeBoolean(Parcel r0, boolean r1) {
        r0.writeInt(r1 ? 1 : 0);
    }
}
