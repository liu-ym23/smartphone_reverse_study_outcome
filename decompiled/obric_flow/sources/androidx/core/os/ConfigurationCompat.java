package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationCompat {

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList getLocales(Configuration r5) {
            return r5.getLocales();
        }

        @DoNotInline
        public static void setLocales(@NonNull Configuration r5, @NonNull LocaleListCompat r10) {
            r5.setLocales((LocaleList) r10.unwrap());
        }
    }

    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration r5) {
        return LocaleListCompat.wrap(Api24Impl.getLocales(r5));
    }

    public static void setLocales(@NonNull Configuration r5, @NonNull LocaleListCompat r10) {
        Api24Impl.setLocales(r5, r10);
    }
}
