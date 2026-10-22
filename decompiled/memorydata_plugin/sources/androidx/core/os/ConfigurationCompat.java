package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static void setLocale(Configuration r1, LocaleListCompat r2) {
            if (r2.isEmpty() == true) goto L6;
            r1.setLocale(r2.get(0));
            return;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList getLocales(Configuration r0) {
            return r0.getLocales();
        }

        static void setLocales(Configuration r2, LocaleListCompat r3) {
            r2.setLocales((LocaleList) ZeusTransformUtils.preCheckCast(r3.unwrap(), LocaleList.class, "com.obric.memorydata.plugin"));
        }
    }

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
        if (Build.VERSION.SDK_INT < 17) goto L10;
        Api17Impl.setLocale(r2, r3);
        return;
    }
}
