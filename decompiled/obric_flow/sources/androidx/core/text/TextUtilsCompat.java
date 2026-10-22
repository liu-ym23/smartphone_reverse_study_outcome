package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextUtilsCompat {
    private TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale r5) {
        return TextUtils.getLayoutDirectionFromLocale(r5);
    }

    @NonNull
    public static String htmlEncode(@NonNull String r5) {
        return TextUtils.htmlEncode(r5);
    }
}
