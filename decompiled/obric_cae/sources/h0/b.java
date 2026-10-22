package h0;

import android.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static ULocale a(Object r8) {
        return ULocale.addLikelySubtags((ULocale) r8);
    }

    public static ULocale b(Locale r8) {
        return ULocale.forLocale(r8);
    }

    public static String c(Object r8) {
        return ((ULocale) r8).getScript();
    }
}
