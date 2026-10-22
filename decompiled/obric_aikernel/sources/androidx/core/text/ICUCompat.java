package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String getScript(Locale r10) {
            return r10.getScript();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static ULocale addLikelySubtags(Object r10) {
            return ULocale.addLikelySubtags((ULocale) r10);
        }

        @DoNotInline
        static ULocale forLocale(Locale r10) {
            return ULocale.forLocale(r10);
        }

        @DoNotInline
        static String getScript(Object r10) {
            return ((ULocale) r10).getScript();
        }
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 21) goto L9;
        Class<?> r11 = Class.forName("libcore.icu.ICU");     // Catch: Exception -> L6
        sGetScriptMethod = r11.getMethod("getScript", new Class[]{String.class});     // Catch: Exception -> L6
        sAddLikelySubtagsMethod = r11.getMethod("addLikelySubtags", new Class[]{String.class});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        sGetScriptMethod = null;
        sAddLikelySubtagsMethod = null;
        Log.w(TAG, e);
        return;
    L9:
        if (r10 >= 24) goto L20;
        sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private ICUCompat() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String addLikelySubtagsBelowApi21(Locale r10) {
        String r11 = r10.toString();
        Method r12 = sAddLikelySubtagsMethod;     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        return (String) r12.invoke(null, new Object[]{r11});
    L9:
        return r11;
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String getScriptBelowApi21(String r10) {
        Method r11 = sGetScriptMethod;     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        return (String) r11.invoke(null, new Object[]{r10});
    L9:
        return null;
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }

    @Nullable
    public static String maximizeAndGetScript(@NonNull Locale r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 24) goto L7;
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(r10)));
    L7:
        if (r11 >= 21) goto L19;
        String r12 = addLikelySubtagsBelowApi21(r10);
        if (r12 != null) goto L17;
        return null;
    L17:
        return getScriptBelowApi21(r12);
    L19:
        return Api21Impl.getScript((Locale) sAddLikelySubtagsMethod.invoke(null, new Object[]{r10}));
    L11:
        e = move-exception;
        Log.w(TAG, e);
        return Api21Impl.getScript(r10);
    }
}
