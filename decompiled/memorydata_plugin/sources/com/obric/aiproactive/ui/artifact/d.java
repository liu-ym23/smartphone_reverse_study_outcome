package com.obric.aiproactive.ui.artifact;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Document;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0002R\u000e\u0010\r\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentHtmlSanitizer;", "", "<init>", "()V", "sanitize", "", AILabCheckPermissionTask.KEY_SOURCE, "backgroundColor", "", "primaryTextColor", "secondaryTextColor", "lineColor", "linkColor", "CONTENT_SECURITY_POLICY", "BLOCKED_ELEMENT_SELECTOR", "buildSafeStyle", "cssColor", TypedValues.Custom.S_COLOR, "SAFE_HTML", "Lorg/jsoup/safety/Safelist;", "kotlin.jvm.PlatformType", "Lorg/jsoup/safety/Safelist;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.jsoup.b.b f6550b = null;

    static {
        f6549a = new d();
        f6550b = org.jsoup.b.b.a().a(new String[]{"p", "div", "span", "br", "hr", "h1", "h2", "h3", "h4", "h5", "h6", "strong", "b", "em", "i", "u", "s", "del", "sub", "sup", "blockquote", "pre", "code", "ul", "ol", "li", "table", "thead", "tbody", "tfoot", "tr", "th", "td", "details", "summary", "a"}).a("a", new String[]{"href", "title"}).a("th", new String[]{"colspan", "rowspan"}).a("td", new String[]{"colspan", "rowspan"}).a("a", "href", new String[]{LocationInfoConst.HTTPS}).a(false);
    }

    private d() {
    }

    private final String a(int r3) {
        String r2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
        return r2;
    }

    private final String a(int r3, int r4, int r5, int r6, int r7) {
        return StringsKt.trimIndent("\n            :root { color-scheme: light dark; }\n            * { box-sizing: border-box; max-width: 100%; }\n            html, body { margin: 0; padding: 0; background: " + a(r3) + "; color: " + a(r4) + "; }\n            body { padding: 0 20px 24px; font-family: sans-serif; font-size: 16px; line-height: 1.65; overflow-wrap: anywhere; }\n            h1, h2, h3, h4, h5, h6 { margin: 1.2em 0 .55em; line-height: 1.3; }\n            h1 { font-size: 1.55em; } h2 { font-size: 1.35em; } h3 { font-size: 1.18em; }\n            p, ul, ol, blockquote, pre, table { margin: .8em 0; }\n            a { color: " + a(r7) + "; text-decoration: none; }\n            blockquote { margin-left: 0; padding-left: 12px; color: " + a(r5) + "; border-left: 3px solid " + a(r6) + "; }\n            pre, code { white-space: pre-wrap; overflow-wrap: anywhere; font-family: monospace; }\n            pre { padding: 12px; border: 1px solid " + a(r6) + "; border-radius: 8px; }\n            table { width: 100%; table-layout: fixed; border-collapse: collapse; }\n            th, td { padding: 8px; border: 1px solid " + a(r6) + "; vertical-align: top; overflow-wrap: anywhere; }\n            hr { border: 0; border-top: 1px solid " + a(r6) + "; }\n        ");
    }

    public final String a(String r8, int r9, int r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r8, AILabCheckPermissionTask.KEY_SOURCE);
        Document r7 = org.jsoup.a.a(r8);
        r7.i("script, noscript, iframe, frame, frameset, object, embed, applet, form, input, button, select, option, textarea, meta, base, link, style, img, picture, source, video, audio, canvas, svg, math").remove();
        String r14 = new org.jsoup.b.a(f6550b).a(r7).b().R();
        Intrinsics.checkNotNullExpressionValue(r14, "html(...)");
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return null;
    L6:
        String r16 = "<!doctype html><html><head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=5\"><meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none'; style-src 'unsafe-inline'; img-src 'none'; media-src 'none'; font-src 'none'; connect-src 'none'; frame-src 'none'; object-src 'none'; form-action 'none'; base-uri 'none'\"><style>" + f6549a.a(r9, r10, r11, r12, r13) + "</style></head><body>" + r15 + "</body></html>";
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        return r16;
    }
}
