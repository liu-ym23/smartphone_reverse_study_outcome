package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class IntentCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static <T> T[] getParcelableArrayExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<T> r11) {
            return (T[]) r5.getParcelableArrayExtra(r10, r11);
        }

        @DoNotInline
        public static <T> ArrayList<T> getParcelableArrayListExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<? extends T> r11) {
            return r5.getParcelableArrayListExtra(r10, r11);
        }

        @DoNotInline
        public static <T> T getParcelableExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<T> r11) {
            return (T) r5.getParcelableExtra(r10, r11);
        }

        @DoNotInline
        public static <T extends Serializable> T getSerializableExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<T> r11) {
            return (T) r5.getSerializableExtra(r10, r11);
        }
    }

    private IntentCompat() {
    }

    @NonNull
    public static Intent createManageUnusedAppRestrictionsIntent(@NonNull Context r5, @NonNull String r10) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r5.getPackageManager()) == false) goto L7;
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r10, null));
    L7:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static Parcelable[] getParcelableArrayExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<? extends Parcelable> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArrayExtra(r5, r10, r11);
    L7:
        return r5.getParcelableArrayExtra(r10);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> getParcelableArrayListExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<? extends T> r11) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api33Impl.getParcelableArrayListExtra(r5, r10, r11);
    L7:
        return r5.getParcelableArrayListExtra(r10);
    }

    @Nullable
    public static <T> T getParcelableExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r12 = (T) r5.getParcelableExtra(r10);
        if (r11.isInstance(r12) == true) goto L11;
        return null;
    L11:
        return r12;
    L5:
        return (T) Api33Impl.getParcelableExtra(r5, r10, r11);
    }

    @Nullable
    public static <T extends Serializable> T getSerializableExtra(@NonNull Intent r5, @Nullable String r10, @NonNull Class<T> r11) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        T r12 = (T) r5.getSerializableExtra(r10);
        if (r11.isInstance(r12) == true) goto L11;
        return null;
    L11:
        return r12;
    L5:
        return (T) Api33Impl.getSerializableExtra(r5, r10, r11);
    }

    @NonNull
    public static Intent makeMainSelectorActivity(@NonNull String r5, @NonNull String r10) {
        return Intent.makeMainSelectorActivity(r5, r10);
    }
}
