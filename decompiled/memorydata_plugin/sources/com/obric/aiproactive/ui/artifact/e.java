package com.obric.aiproactive.ui.artifact;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"resolveDocumentPreviewKind", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewKind;", "mimeType", "", "displayName", "normalizePreviewHttpsUrl", "rawUrl", "resolveDocumentPreviewKindFromExtension", "MIME_MARKDOWN", "MIME_X_MARKDOWN", "MIME_HTML", "MIME_TEXT", "MIME_BINARY", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final DocumentPreviewKind a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "mimeType");
        Intrinsics.checkNotNullParameter(r4, "displayName");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringBefore$default(r3, ';', null, 2, null), CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
        switch(r5.hashCode()) {
            case -1082243251: goto L20;
            case -533161071: goto L16;
            case 352322758: goto L13;
            case 817335912: goto L9;
            case 1178484637: goto L6;
            default: goto L26;
        };
    L26:
        return null;
    L6:
        if (r5.equals("application/octet-stream") == true) goto L24;
        return null;
    L24:
        return b(r4);
    L9:
        if (r5.equals("text/plain") == true) goto L24;
        return null;
    L13:
        if (r5.equals("text/x-markdown") == true) goto L25;
        return null;
    L25:
        return DocumentPreviewKind.MARKDOWN;
    L16:
        if (r5.equals("text/markdown") == true) goto L25;
        return null;
    L20:
        if (r5.equals("text/html") == true) goto L23;
        return null;
    L23:
        return DocumentPreviewKind.HTML;
    }

    public static final String a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "rawUrl");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L38;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 0;
    L6:
        if (r4 >= r0.length()) goto L17;
        char r5 = r0.charAt(r4);
        if (CharsKt.isWhitespace(r5) == false) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L15;
        r4 = r4 + 1;
        goto L6
    L15:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L38;
        URI r2 = new URI(r9);     // Catch: URISyntaxException -> L39
        if (StringsKt.equals(r2.getScheme(), LocationInfoConst.HTTPS, true) == false) goto L34;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.getHost(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L34;
        if (r2.getUserInfo() != null) goto L34;
        r3 = true;
        goto L34
    L26:
        if (StringsKt.isBlank(r7) == true) goto L29;
        r10 = false;
    L34:
        if (r3 == false) goto L37;
        return r9;
    L37:
        return null;
    L10:
        if (Character.isISOControl(r5) == true) goto L13;
        r6 = false;
        goto L14
    L17:
        r1 = false;
    L38:
        return null;
    }

    private static final DocumentPreviewKind b(String r2) {
        String r3 = StringsKt.substringAfterLast(r2, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
        int r0 = r3.hashCode();
        if (r0 == 3479) goto L22;
        if (r0 == 103649) goto L18;
        if (r0 == 3213227) goto L15;
        if (r0 == 246938863) goto L12;
    L23:
        return null;
    L12:
        if (r3.equals("markdown") == false) goto L23;
    L25:
        return DocumentPreviewKind.MARKDOWN;
    L15:
        if (r3.equals("html") == false) goto L23;
    L26:
        return DocumentPreviewKind.HTML;
    L18:
        if (r3.equals("htm") == true) goto L26;
    L22:
        if (r3.equals("md") == true) goto L25;
        goto L23
    }
}
