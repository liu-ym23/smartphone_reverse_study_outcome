package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleManagerCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static String toLanguageTag(Locale r0) {
            return r0.toLanguageTag();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleListCompat getLocales(Configuration r0) {
            return LocaleListCompat.forLanguageTags(r0.getLocales().toLanguageTags());
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static LocaleList localeManagerGetApplicationLocales(Object r2) {
            return ((LocaleManager) ZeusTransformUtils.preCheckCast(r2, LocaleManager.class, "com.obric.memorydata.plugin")).getApplicationLocales();
        }

        static LocaleList localeManagerGetSystemLocales(Object r2) {
            return ((LocaleManager) ZeusTransformUtils.preCheckCast(r2, LocaleManager.class, "com.obric.memorydata.plugin")).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    public static LocaleListCompat getApplicationLocales(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Object r4 = getLocaleManagerForApplication(r3);
        if (r4 == null) goto L9;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r4));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    L11:
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r3));
    }

    static LocaleListCompat getConfigurationLocales(Configuration r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.getLocales(r2);
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r2.locale));
    L11:
        return LocaleListCompat.create(new Locale[]{r2.locale});
    }

    private static Object getLocaleManagerForApplication(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("locale");
    }

    public static LocaleListCompat getSystemLocales(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        LocaleListCompat r0 = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT < 33) goto L8;
        Object r5 = getLocaleManagerForApplication(r4);
        if (r5 != null) goto L10;
        return r0;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r5));
    L8:
        return getConfigurationLocales(Resources.getSystem().getConfiguration());
    }
}
