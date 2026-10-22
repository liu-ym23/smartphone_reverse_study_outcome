package androidx.core.text;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
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

    static class Api24Impl {
        private Api24Impl() {
        }

        static Spanned fromHtml(String r0, int r1) {
            return Html.fromHtml(r0, r1);
        }

        static Spanned fromHtml(String r2, int r3, Html.ImageGetter r4, Html.TagHandler r5) {
            return Html.fromHtml(r2, r3, (Html.ImageGetter) ZeusTransformUtils.wrapperContextForParams(r4, Html.ImageGetter.class, "com.obric.memorydata.plugin"), (Html.TagHandler) ZeusTransformUtils.wrapperContextForParams(r5, Html.TagHandler.class, "com.obric.memorydata.plugin"));
        }

        static String toHtml(Spanned r2, int r3) {
            return Html.toHtml((Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    private HtmlCompat() {
    }

    public static Spanned fromHtml(String r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r2, r3);
    L7:
        return Html.fromHtml(r2);
    }

    public static Spanned fromHtml(String r2, int r3, Html.ImageGetter r4, Html.TagHandler r5) {
        Html.ImageGetter r6 = (Html.ImageGetter) ZeusTransformUtils.wrapperContextForParams(r4, Html.ImageGetter.class, "com.obric.memorydata.plugin");
        Html.TagHandler r7 = (Html.TagHandler) ZeusTransformUtils.wrapperContextForParams(r5, Html.TagHandler.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r2, r3, r6, r7);
    L7:
        return Html.fromHtml(r2, r6, r7);
    }

    public static String toHtml(Spanned r2, int r3) {
        Spanned r4 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.toHtml(r4, r3);
    L7:
        return Html.toHtml(r4);
    }
}
