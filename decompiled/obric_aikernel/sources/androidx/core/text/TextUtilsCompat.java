package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT = null;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int getLayoutDirectionFromLocale(Locale r10) {
            return TextUtils.getLayoutDirectionFromLocale(r10);
        }
    }

    static {
        ROOT = new Locale("", "");
    }

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(@NonNull Locale r10) {
        byte r11 = Character.getDirectionality(r10.getDisplayName(r10).charAt(0));
        if (r11 != 1) goto L5;
    L7:
        return 1;
    L5:
        if (r11 == 2) goto L7;
        return 0;
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        if (r10 != null) goto L8;
        return 0;
    L8:
        if (r10.equals(ROOT) == true) goto L22;
        String r11 = ICUCompat.maximizeAndGetScript(r10);
        if (r11 != null) goto L14;
        return getLayoutDirectionFromFirstChar(r10);
    L14:
        if (r11.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) == false) goto L16;
        return 1;
    L16:
        if (r11.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG) == false) goto L23;
        return 1;
    L23:
        return 0;
    L22:
        return 0;
    L5:
        return Api17Impl.getLayoutDirectionFromLocale(r10);
    }

    @NonNull
    public static String htmlEncode(@NonNull String r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L8:
        if (r12 >= r10.length()) goto L28;
        char r13 = r10.charAt(r12);
        if (r13 != '\"') goto L12;
        String r14 = "&quot;";
    L25:
        r11.append(r14);
    L26:
        r12 = r12 + 1;
        goto L8
    L12:
        if (r13 != '<') goto L14;
        r14 = "&lt;";
        goto L25
    L14:
        if (r13 != '>') goto L16;
        r14 = "&gt;";
        goto L25
    L16:
        if (r13 != '&') goto L18;
        r14 = "&amp;";
        goto L25
    L18:
        if (r13 == '\'') goto L20;
        r11.append(r13);
        goto L26
    L20:
        r14 = "&#39;";
        goto L25
    L28:
        return r11.toString();
    L5:
        return TextUtils.htmlEncode(r10);
    }
}
