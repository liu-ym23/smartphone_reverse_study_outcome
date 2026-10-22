package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b¨\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HtmlKt {
    public static final Spanned parseAsHtml(String r2, int r3, Html.ImageGetter r4, Html.TagHandler r5) {
        return HtmlCompat.fromHtml(r2, r3, (Html.ImageGetter) ZeusTransformUtils.wrapperContextForParams(r4, Html.ImageGetter.class, "com.obric.memorydata.plugin"), (Html.TagHandler) ZeusTransformUtils.wrapperContextForParams(r5, Html.TagHandler.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String r1, int r2, Html.ImageGetter r3, Html.TagHandler r4, int r5, Object r6) {
        Html.ImageGetter r7 = (Html.ImageGetter) ZeusTransformUtils.wrapperContextForParams(r3, Html.ImageGetter.class, "com.obric.memorydata.plugin");
        Html.TagHandler r8 = (Html.TagHandler) ZeusTransformUtils.wrapperContextForParams(r4, Html.TagHandler.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = null;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = null;
    L12:
        return HtmlCompat.fromHtml(r1, r2, r7, r8);
    }

    public static final String toHtml(Spanned r2, int r3) {
        return HtmlCompat.toHtml((Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ String toHtml$default(Spanned r1, int r2, int r3, Object r4) {
        Spanned r5 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r1, Spanned.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        return HtmlCompat.toHtml(r5, r2);
    }
}
