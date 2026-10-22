package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return LocaleListCompat.wrap(Api24Impl.getLocales(r2));
    L7:
        return LocaleListCompat.create(new Locale[]{r2.locale});
    }

    public static void setLocales(Configuration r2, LocaleListCompat r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.setLocales(r2, r3);
        return;
    L6:
        if (r3.isEmpty() == true) goto L10;
        r2.setLocale(r3.get(0));
        return;
    }
}
