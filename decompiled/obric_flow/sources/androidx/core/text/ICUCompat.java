package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static String getScript(Locale r5) {
            return r5.getScript();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static ULocale addLikelySubtags(Object r5) {
            return ULocale.addLikelySubtags((ULocale) r5);
        }

        @DoNotInline
        public static ULocale forLocale(Locale r5) {
            return ULocale.forLocale(r5);
        }

        @DoNotInline
        public static String getScript(Object r5) {
            return ((ULocale) r5).getScript();
        }
    }

    private ICUCompat() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String addLikelySubtagsBelowApi21(Locale r5) {
        String r10 = r5.toString();
        Method r11 = sAddLikelySubtagsMethod;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r11 == null) goto L13;
        return (String) r11.invoke(null, new Object[]{r10});
    L13:
        return r10;
    L9:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L13
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String getScriptBelowApi21(String r5) {
        Method r10 = sGetScriptMethod;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r10 == null) goto L13;
        return (String) r10.invoke(null, new Object[]{r5});
    L13:
        return null;
    L9:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L13
    }

    @Nullable
    public static String maximizeAndGetScript(@NonNull Locale r5) {
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(r5)));
    }
}
