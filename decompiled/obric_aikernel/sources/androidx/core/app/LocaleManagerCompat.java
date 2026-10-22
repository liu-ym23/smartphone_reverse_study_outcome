package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleManagerCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String toLanguageTag(Locale r10) {
            return r10.toLanguageTag();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleListCompat getLocales(Configuration r10) {
            return LocaleListCompat.forLanguageTags(r10.getLocales().toLanguageTags());
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static LocaleList localeManagerGetSystemLocales(Object r10) {
            return ((LocaleManager) r10).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    @VisibleForTesting
    static LocaleListCompat getConfigurationLocales(Configuration r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 24) goto L7;
        return Api24Impl.getLocales(r10);
    L7:
        if (r11 < 21) goto L11;
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r10.locale));
    L11:
        return LocaleListCompat.create(new Locale[]{r10.locale});
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context r10) {
        return r10.getSystemService("locale");
    }

    @NonNull
    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static LocaleListCompat getSystemLocales(@NonNull Context r10) {
        LocaleListCompat r11 = LocaleListCompat.getEmptyLocaleList();
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r12 = getLocaleManagerForApplication(r10);
        if (r12 != null) goto L10;
        return r11;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r12));
    L8:
        return getConfigurationLocales(r10.getApplicationContext().getResources().getConfiguration());
    }
}
