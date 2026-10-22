package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"InlinedApi"})
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Spanned fromHtml(String r10, int r11) {
            return Html.fromHtml(r10, r11);
        }

        @DoNotInline
        static Spanned fromHtml(String r10, int r11, Html.ImageGetter r12, Html.TagHandler r13) {
            return Html.fromHtml(r10, r11, r12, r13);
        }

        @DoNotInline
        static String toHtml(Spanned r10, int r11) {
            return Html.toHtml(r10, r11);
        }
    }

    private HtmlCompat() {
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String r10, int r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r10, r11);
    L7:
        return Html.fromHtml(r10);
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String r10, int r11, @Nullable Html.ImageGetter r12, @Nullable Html.TagHandler r13) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r10, r11, r12, r13);
    L7:
        return Html.fromHtml(r10, r12, r13);
    }

    @NonNull
    public static String toHtml(@NonNull Spanned r10, int r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.toHtml(r10, r11);
    L7:
        return Html.toHtml(r10);
    }
}
