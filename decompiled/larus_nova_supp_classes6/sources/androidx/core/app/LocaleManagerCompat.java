package androidx.core.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.os.LocaleListCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class LocaleManagerCompat {
    private LocaleManagerCompat() {
    }

    public static LocaleListCompat getApplicationLocales(Context r2) {
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Object r3 = getLocaleManagerForApplication(r2);
        if (r3 == null) goto L9;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r3));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    L11:
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r2));
    }

    public static LocaleListCompat getConfigurationLocales(Configuration r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.getLocales(r2);
    L7:
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r2.locale));
    }

    private static Object getLocaleManagerForApplication(Context r1) {
        return r1.getSystemService("locale");
    }

    public static LocaleListCompat getSystemLocales(Context r3) {
        LocaleListCompat r0 = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r4 = getLocaleManagerForApplication(r3);
        if (r4 != null) goto L10;
        return r0;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r4));
    L8:
        return getConfigurationLocales(Resources.getSystem().getConfiguration());
    }
}
