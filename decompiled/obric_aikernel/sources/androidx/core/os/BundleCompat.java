package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T getParcelable(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<T> r12) {
            return (T) r10.getParcelable(r11, r12);
        }

        @DoNotInline
        static <T> T[] getParcelableArray(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<T> r12) {
            return (T[]) r10.getParcelableArray(r11, r12);
        }

        @DoNotInline
        static <T> ArrayList<T> getParcelableArrayList(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<? extends T> r12) {
            return r10.getParcelableArrayList(r11, r12);
        }

        @DoNotInline
        static <T> SparseArray<T> getSparseParcelableArray(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<? extends T> r12) {
            return r10.getSparseParcelableArray(r11, r12);
        }
    }

    private BundleCompat() {
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> T getParcelable(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T r13 = (T) r10.getParcelable(r11);
        if (r12.isInstance(r13) == true) goto L11;
        return null;
    L11:
        return r13;
    L5:
        return (T) Api33Impl.getParcelable(r10, r11, r12);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static Parcelable[] getParcelableArray(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<? extends Parcelable> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArray(r10, r11, r12);
    L7:
        return r10.getParcelableArray(r11);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> getParcelableArrayList(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<? extends T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.getParcelableArrayList(r10, r11, r12);
    L7:
        return r10.getParcelableArrayList(r11);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> SparseArray<T> getSparseParcelableArray(@NonNull Bundle r10, @Nullable String r11, @NonNull Class<? extends T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.getSparseParcelableArray(r10, r11, r12);
    L7:
        return r10.getSparseParcelableArray(r11);
    }
}
