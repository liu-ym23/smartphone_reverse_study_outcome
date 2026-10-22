package androidx.core.text;

import android.annotation.SuppressLint;
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
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Spanned fromHtml(String r5, int r10) {
            return Html.fromHtml(r5, r10);
        }

        @DoNotInline
        public static String toHtml(Spanned r5, int r10) {
            return Html.toHtml(r5, r10);
        }

        @DoNotInline
        public static Spanned fromHtml(String r5, int r10, Html.ImageGetter r11, Html.TagHandler r12) {
            return Html.fromHtml(r5, r10, r11, r12);
        }
    }

    private HtmlCompat() {
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String r5, int r10) {
        return Api24Impl.fromHtml(r5, r10);
    }

    @NonNull
    public static String toHtml(@NonNull Spanned r5, int r10) {
        return Api24Impl.toHtml(r5, r10);
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String r5, int r10, @Nullable Html.ImageGetter r11, @Nullable Html.TagHandler r12) {
        return Api24Impl.fromHtml(r5, r10, r11, r12);
    }
}
