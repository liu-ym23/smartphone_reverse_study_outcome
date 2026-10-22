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
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;
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

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static Intent makeMainSelectorActivity(String r10, String r11) {
            return Intent.makeMainSelectorActivity(r10, r11);
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T[] getParcelableArrayExtra(@NonNull Intent r10, @Nullable String r11, @NonNull Class<T> r12) {
            return (T[]) r10.getParcelableArrayExtra(r11, r12);
        }

        @DoNotInline
        static <T> ArrayList<T> getParcelableArrayListExtra(@NonNull Intent r10, @Nullable String r11, @NonNull Class<? extends T> r12) {
            return r10.getParcelableArrayListExtra(r11, r12);
        }

        @DoNotInline
        static <T> T getParcelableExtra(@NonNull Intent r10, @Nullable String r11, @NonNull Class<T> r12) {
            return (T) r10.getParcelableExtra(r11, r12);
        }
    }

    private IntentCompat() {
    }

    @NonNull
    public static Intent createManageUnusedAppRestrictionsIntent(@NonNull Context r10, @NonNull String r11) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(r10.getPackageManager()) == false) goto L14;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 31) goto L7;
        Intent r13 = new Intent(PackageManagerCompat.ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", r11, null));
        if (r12 < 30) goto L12;
        return r13;
    L12:
        return r13.setPackage((String) Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(r10.getPackageManager())));
    L7:
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", r11, null));
    L14:
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static Parcelable[] getParcelableArrayExtra(@NonNull Intent r10, @Nullable String r11, @NonNull Class<? extends Parcelable> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return (Parcelable[]) Api33Impl.getParcelableArrayExtra(r10, r11, r12);
    L7:
        return r10.getParcelableArrayExtra(r11);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> getParcelableArrayListExtra(@NonNull Intent r10, @Nullable String r11, @NonNull Class<? extends T> r12) {
        if (BuildCompat.isAtLeastU() == false) goto L7;
        return Api33Impl.getParcelableArrayListExtra(r10, r11, r12);
    L7:
        return r10.getParcelableArrayListExtra(r11);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> T getParcelableExtra(@NonNull Intent r10, @Nullable String r11, @NonNull Class<T> r12) {
        if (BuildCompat.isAtLeastU() == true) goto L5;
        T r13 = (T) r10.getParcelableExtra(r11);
        if (r12.isInstance(r13) == true) goto L11;
        return null;
    L11:
        return r13;
    L5:
        return (T) Api33Impl.getParcelableExtra(r10, r11, r12);
    }

    @NonNull
    public static Intent makeMainSelectorActivity(@NonNull String r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        Intent r12 = new Intent(r10);
        r12.addCategory(r11);
        return r12;
    L5:
        return Api15Impl.makeMainSelectorActivity(r10, r11);
    }
}
