package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String r10, int r11, Html.ImageGetter r12, Html.TagHandler r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Spanned r14 = HtmlCompat.fromHtml(r10, r11, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "fromHtml(this, flags, imageGetter, tagHandler)");
        return r14;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String r10, int r11, Html.ImageGetter r12, Html.TagHandler r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = null;
    L11:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Spanned r16 = HtmlCompat.fromHtml(r10, r11, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r16, "fromHtml(this, flags, imageGetter, tagHandler)");
        return r16;
    }

    public static final String toHtml(Spanned r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r12 = HtmlCompat.toHtml(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "toHtml(this, option)");
        return r12;
    }

    public static /* synthetic */ String toHtml$default(Spanned r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r14 = HtmlCompat.toHtml(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "toHtml(this, option)");
        return r14;
    }
}
