package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getScript(Locale r0) {
            return r0.getScript();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale addLikelySubtags(Object r2) {
            return ULocale.addLikelySubtags((ULocale) ZeusTransformUtils.preCheckCast(r2, ULocale.class, "com.obric.memorydata.plugin"));
        }

        static ULocale forLocale(Locale r0) {
            return ULocale.forLocale(r0);
        }

        static String getScript(Object r2) {
            return ((ULocale) ZeusTransformUtils.preCheckCast(r2, ULocale.class, "com.obric.memorydata.plugin")).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        Class r0 = ZeusTransformUtils.forName("libcore.icu.ICU", "com.obric.memorydata.plugin");     // Catch: Exception -> L6
        sGetScriptMethod = r0.getMethod("getScript", new Class[]{String.class});     // Catch: Exception -> L6
        sAddLikelySubtagsMethod = r0.getMethod("addLikelySubtags", new Class[]{String.class});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        sGetScriptMethod = null;
        sAddLikelySubtagsMethod = null;
        Log.w(TAG, e);
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L20;
        sAddLikelySubtagsMethod = ZeusTransformUtils.forName("libcore.icu.ICU", "com.obric.memorydata.plugin").getMethod("addLikelySubtags", new Class[]{Locale.class});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private ICUCompat() {
    }

    private static String addLikelySubtagsBelowApi21(Locale r4) {
        String r5 = r4.toString();
        Method r1 = sAddLikelySubtagsMethod;     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        return (String) ZeusTransformUtils.preCheckCast(r1.invoke(null, new Object[]{r5}), String.class, "com.obric.memorydata.plugin");
    L9:
        return r5;
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }

    private static String getScriptBelowApi21(String r5) {
        Method r2 = sGetScriptMethod;     // Catch: Throwable -> L7
        if (r2 == null) goto L9;
        return (String) ZeusTransformUtils.preCheckCast(r2.invoke(null, new Object[]{r5}), String.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }

    public static String maximizeAndGetScript(Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(r4)));
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L19;
        String r5 = addLikelySubtagsBelowApi21(r4);
        if (r5 != null) goto L17;
        return null;
    L17:
        return getScriptBelowApi21(r5);
    L19:
        return Api21Impl.getScript((Locale) ZeusTransformUtils.preCheckCast(sAddLikelySubtagsMethod.invoke(null, new Object[]{r4}), Locale.class, "com.obric.memorydata.plugin"));
    L11:
        e = move-exception;
        Log.w(TAG, e);
        return Api21Impl.getScript(r4);
    }
}
