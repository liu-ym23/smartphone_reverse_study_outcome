package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static <T> T getParcelable(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<T> r11) {
            return (T) r5.getParcelable(r10, r11);
        }

        @DoNotInline
        public static <T> T[] getParcelableArray(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<T> r11) {
            return (T[]) r5.getParcelableArray(r10, r11);
        }

        @DoNotInline
        public static <T> ArrayList<T> getParcelableArrayList(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<? extends T> r11) {
            return r5.getParcelableArrayList(r10, r11);
        }

        @DoNotInline
        public static <T extends Serializable> T getSerializable(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<T> r11) {
            return (T) r5.getSerializable(r10, r11);
        }

        @DoNotInline
        public static <T> SparseArray<T> getSparseParcelableArray(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<? extends T> r11) {
            return r5.getSparseParcelableArray(r10, r11);
        }
    }

    private BundleCompat() {
    }

    @Nullable
    @Deprecated
    public static IBinder getBinder(@NonNull Bundle r5, @Nullable String r10) {
        return r5.getBinder(r10);
    }

    @Nullable
    public static <T> T getParcelable(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r12 = (T) r5.getParcelable(r10);
        if (r11.isInstance(r12) == true) goto L11;
        return null;
    L11:
        return r12;
    L5:
        return (T) Api33Impl.getParcelable(r5, r10, r11);
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static Parcelable[] getParcelableArray(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<? extends Parcelable> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArray(r5, r10, r11);
    L7:
        return r5.getParcelableArray(r10);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> getParcelableArrayList(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<? extends T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getParcelableArrayList(r5, r10, r11);
    L7:
        return r5.getParcelableArrayList(r10);
    }

    @Nullable
    public static <T extends Serializable> T getSerializable(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r12 = (T) r5.getSerializable(r10);
        if (r11.isInstance(r12) == true) goto L11;
        return null;
    L11:
        return r12;
    L5:
        return (T) Api33Impl.getSerializable(r5, r10, r11);
    }

    @Nullable
    public static <T> SparseArray<T> getSparseParcelableArray(@NonNull Bundle r5, @Nullable String r10, @NonNull Class<? extends T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getSparseParcelableArray(r5, r10, r11);
    L7:
        return r5.getSparseParcelableArray(r10);
    }

    @Deprecated
    public static void putBinder(@NonNull Bundle r5, @Nullable String r10, @Nullable IBinder r11) {
        r5.putBinder(r10, r11);
    }
}
