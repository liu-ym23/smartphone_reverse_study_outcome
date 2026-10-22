package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleManagerCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static String toLanguageTag(Locale r5) {
            return r5.toLanguageTag();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleListCompat getLocales(Configuration r5) {
            return LocaleListCompat.forLanguageTags(r5.getLocales().toLanguageTags());
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static LocaleList localeManagerGetApplicationLocales(Object r5) {
            return ((LocaleManager) r5).getApplicationLocales();
        }

        @DoNotInline
        public static LocaleList localeManagerGetSystemLocales(Object r5) {
            return ((LocaleManager) r5).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getApplicationLocales(@NonNull Context r5) {
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Object r10 = getLocaleManagerForApplication(r5);
        if (r10 == null) goto L9;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r10));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    L11:
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r5));
    }

    @VisibleForTesting
    public static LocaleListCompat getConfigurationLocales(Configuration r5) {
        return Api24Impl.getLocales(r5);
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context r5) {
        return r5.getSystemService("locale");
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getSystemLocales(@NonNull Context r5) {
        LocaleListCompat r10 = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r11 = getLocaleManagerForApplication(r5);
        if (r11 != null) goto L10;
        return r10;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r11));
    L8:
        return getConfigurationLocales(Resources.getSystem().getConfiguration());
    }
}
