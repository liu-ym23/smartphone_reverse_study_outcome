package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BuildCompat {

    @ChecksSdkIntAtLeast(extension = 1000000)
    @SuppressLint({"CompileTimeConstant"})
    public static final int AD_SERVICES_EXTENSION_INT = 0;

    @ChecksSdkIntAtLeast(extension = 30)
    @SuppressLint({"CompileTimeConstant"})
    public static final int R_EXTENSION_INT = 0;

    @ChecksSdkIntAtLeast(extension = 31)
    @SuppressLint({"CompileTimeConstant"})
    public static final int S_EXTENSION_INT = 0;

    @ChecksSdkIntAtLeast(extension = 33)
    @SuppressLint({"CompileTimeConstant"})
    public static final int T_EXTENSION_INT = 0;

    @RequiresApi(30)
    private static final class Extensions30Impl {
        static final int AD_SERVICES = 0;
        static final int R = 0;
        static final int S = 0;
        static final int TIRAMISU = 0;

        static {
            R = SdkExtensions.getExtensionVersion(30);
            S = SdkExtensions.getExtensionVersion(31);
            TIRAMISU = SdkExtensions.getExtensionVersion(33);
            AD_SERVICES = SdkExtensions.getExtensionVersion(1000000);
        }

        private Extensions30Impl() {
        }
    }

    @RequiresOptIn
    public @interface PrereleaseSdkCheck {
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        int r11 = 0;
        if (r10 < 30) goto L5;
        int r12 = Extensions30Impl.R;
    L6:
        R_EXTENSION_INT = r12;
        if (r10 < 30) goto L9;
        int r13 = Extensions30Impl.S;
    L10:
        S_EXTENSION_INT = r13;
        if (r10 < 30) goto L13;
        int r14 = Extensions30Impl.TIRAMISU;
    L14:
        T_EXTENSION_INT = r14;
        if (r10 < 30) goto L17;
        r11 = Extensions30Impl.AD_SERVICES;
    L17:
        AD_SERVICES_EXTENSION_INT = r11;
        return;
    L13:
        r14 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    private BuildCompat() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    @Deprecated
    public static boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 25)
    @Deprecated
    public static boolean isAtLeastNMR1() {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 26)
    @Deprecated
    public static boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 27)
    @Deprecated
    public static boolean isAtLeastOMR1() {
        if (Build.VERSION.SDK_INT < 27) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 28)
    @Deprecated
    public static boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    protected static boolean isAtLeastPreReleaseCodename(@NonNull String r10, @NonNull String r11) {
        if ("REL".equals(r11) == false) goto L5;
        return false;
    L5:
        Locale r12 = Locale.ROOT;
        if (r11.toUpperCase(r12).compareTo(r10.toUpperCase(r12)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 29)
    @Deprecated
    public static boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 30)
    @Deprecated
    public static boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    @ChecksSdkIntAtLeast(api = 31, codename = "S")
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    public static boolean isAtLeastS() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 31) goto L5;
    L10:
        return true;
    L5:
        if (r10 >= 30) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("S", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    @ChecksSdkIntAtLeast(api = 32, codename = "Sv2")
    @PrereleaseSdkCheck
    @Deprecated
    public static boolean isAtLeastSv2() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 32) goto L5;
    L10:
        return true;
    L5:
        if (r10 >= 31) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Sv2", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    @ChecksSdkIntAtLeast(api = 33, codename = "Tiramisu")
    @PrereleaseSdkCheck
    public static boolean isAtLeastT() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 33) goto L5;
    L10:
        return true;
    L5:
        if (r10 >= 32) goto L7;
    L9:
        return false;
    L7:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L9;
        goto L9
    }

    @ChecksSdkIntAtLeast(codename = "UpsideDownCake")
    @PrereleaseSdkCheck
    public static boolean isAtLeastU() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME) == false) goto L7;
        return true;
    }
}
