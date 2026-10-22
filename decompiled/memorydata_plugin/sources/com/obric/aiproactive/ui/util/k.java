package com.obric.aiproactive.ui.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002\u001a\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a8\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0000\u001a(\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a(\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\""}, d2 = {"agentRunTextInteractionPolicy", "Lcom/obric/aiproactive/ui/util/AgentRunTextInteractionPolicy;", "expanded", "", "normalizeAgentRunMarkdownHttpUrl", "", "rawUrl", "sanitizeAgentRunMarkdownAst", "Lorg/commonmark/node/Node;", "root", "sanitizeAgentRunMarkdownChildren", "", "parent", "unwrapAgentRunMarkdownNode", "node", "replaceAgentRunMarkdownNode", "replacement", "rewriteAgentRunMarkdownLinkSpans", "", "markdown", "Landroid/text/Spannable;", "alignAgentRunListMarkers", "textPaint", "Landroid/text/TextPaint;", "markerGapPx", "bulletDiameterPx", "orderedMarkerColor", "bulletMarkerColor", "alignAgentRunOrderedListMarkers", "markerColor", "alignAgentRunBulletListMarkers", "launchAgentRunHttpUrl", "widget", "Landroid/view/View;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class k {

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J6\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"com/obric/aiproactive/ui/util/ProactiveMarkdownRendererKt$rewriteAgentRunMarkdownLinkSpans$SafeLink", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "flags", "url", "", "<init>", "(IIILjava/lang/String;)V", "getStart", "()I", "getEnd", "getFlags", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(IIILjava/lang/String;)Lcom/obric/aiproactive/ui/util/ProactiveMarkdownRendererKt$rewriteAgentRunMarkdownLinkSpans$SafeLink;", "equals", "", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6889b;
        private final int c;
        private final String d;

        public a(int r2, int r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            this.f6888a = r2;
            this.f6889b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final int a() {
            return this.f6888a;
        }

        public final int b() {
            return this.f6889b;
        }

        public final int c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f6888a == r6.f6888a) goto L12;
            return false;
        L12:
            if (this.f6889b == r6.f6889b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f6888a) * 31) + Integer.hashCode(this.f6889b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "SafeLink(start=" + this.f6888a + ", end=" + this.f6889b + ", flags=" + this.c + ", url=" + this.d + ')';
        }
    }

    public static final int a(Spannable r12) {
        Spannable r13 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r12, Spannable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "markdown");
        int r3 = 0;
        Object[] r0 = r13.getSpans(0, r13.length(), CustomLinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(r0, "getSpans(...)");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r5 = r0.length;
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L16;
        CustomLinkSpan r7 = (CustomLinkSpan) ZeusTransformUtils.preCheckCast(r0[r6], CustomLinkSpan.class, "com.obric.memorydata.plugin");
        int r8 = r13.getSpanStart(r7);
        int r9 = r13.getSpanEnd(r7);
        String r10 = r7.getLink();
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        String r11 = a(r10);
        if (r11 == null) goto L12;
        if (r8 < 0) goto L12;
        if (r9 <= r8) goto L12;
        a r14 = new a(r8, r9, r13.getSpanFlags(r7), r11);
    L13:
        if (r14 == null) goto L15;
        r4.add(r14);
    L15:
        r6 = r6 + 1;
    L12:
        r14 = null;
        goto L13
    L16:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Object[] r15 = r13.getSpans(0, r13.length(), ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(r15, "getSpans(...)");
        int r2 = r15.length;
        int r16 = 0;
    L17:
        if (r16 >= r2) goto L19;
        r13.removeSpan(r15[r16]);
        r16 = r16 + 1;
        goto L17
    L19:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r17.hasNext() == false) goto L23;
        a r18 = (a) ZeusTransformUtils.preCheckCast(r17.next(), a.class, "com.obric.memorydata.plugin");
        r13.setSpan(new b(r18.d()), r18.a(), r18.b(), r18.c());
        r3 = r3 + 1;
        goto L21
    L23:
        return r3;
    }

    private static final int a(Spannable r8, int r9, int r10, int r11) {
        Spannable r12 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r8, Spannable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        io.noties.markwon.core.spans.d[] r0 = (io.noties.markwon.core.spans.d[]) ZeusTransformUtils.preCheckCast(r12.getSpans(0, r12.length(), io.noties.markwon.core.spans.d.class), io.noties.markwon.core.spans.d[].class, "com.obric.memorydata.plugin");
        int r13 = r9 + r10;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.length;
    L3:
        if (r3 >= r1) goto L11;
        io.noties.markwon.core.spans.d r2 = r0[r3];
        int r4 = r12.getSpanStart(r2);
        int r5 = r12.getSpanEnd(r2);
        if (r4 < 0) goto L9;
        if (r5 <= r4) goto L9;
        int r6 = r12.getSpanFlags(r2);
        r12.removeSpan(r2);
        r12.setSpan(new com.obric.aiproactive.ui.util.a(r13, r10, r11), r4, r5, r6);
    L9:
        r3 = r3 + 1;
        goto L3
    L11:
        return r0.length;
    }

    private static final int a(Spannable r15, TextPaint r16, int r17, int r18) {
        Spannable r1 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r15, Spannable.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        Object[] r3 = r1.getSpans(0, r1.length(), io.noties.markwon.core.spans.p.class);
        Intrinsics.checkNotNullExpressionValue(r3, "getSpans(...)");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r6 = r3.length;
    L3:
        Object r7 = null;
        if (r5 >= r6) goto L17;
        io.noties.markwon.core.spans.p r10 = (io.noties.markwon.core.spans.p) ZeusTransformUtils.preCheckCast(r3[r5], io.noties.markwon.core.spans.p.class, "com.obric.memorydata.plugin");
        int r12 = r1.getSpanStart(r10);
        int r13 = r1.getSpanEnd(r10);
        String r8 = r10.g;
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        String r11 = r8;
        if (r12 < 0) goto L14;
        if (r13 <= r12) goto L14;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
        Intrinsics.checkNotNull(r10);
        r7 = new c(r10, r11, r12, r13, r1.getSpanFlags(r10));
    L14:
        if (r7 == null) goto L16;
        r4.add(r7);
    L16:
        r5 = r5 + 1;
        goto L3
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r14.hasNext() == false) goto L25;
        float r19 = r16.measureText(((c) ZeusTransformUtils.preCheckCast(r14.next(), c.class, "com.obric.memorydata.plugin")).b());
    L22:
        if (r14.hasNext() == false) goto L24;
        r19 = Math.max(r19, r16.measureText(((c) ZeusTransformUtils.preCheckCast(r14.next(), c.class, "com.obric.memorydata.plugin")).b()));
        goto L22
    L24:
        r7 = Float.valueOf(r19);
    L25:
        if (r7 == null) goto L31;
        int r0 = ((int) Math.ceil(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue())) + r17;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r20.hasNext() == false) goto L31;
        c r21 = (c) ZeusTransformUtils.preCheckCast(r20.next(), c.class, "com.obric.memorydata.plugin");
        r1.removeSpan(r21.a());
        r1.setSpan(new d(r21.b(), r0, r18), r21.c(), r21.d(), r21.e());
    L31:
        return r9.size();
    }

    public static final int a(Spannable r2, TextPaint r3, int r4, int r5, int r6, int r7) {
        Spannable r8 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r2, Spannable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "markdown");
        Intrinsics.checkNotNullParameter(r3, "textPaint");
        return a(r8, r3, r4, r6) + a(r8, r4, r5, r7);
    }

    public static final e a(boolean r7) {
        return new e(r7, r7, r7, r7, r7);
    }

    public static final String a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "rawUrl");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L47;
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
        if (r1 == true) goto L47;
        if (StringsKt.startsWith(r9, "www.", true) == false) goto L48;
        r9 = ReportConsts.HTTPS + r9;
    L48:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        Object r7 = Result.m1421constructorimpl(new URI(r9));     // Catch: Throwable -> L25
    L28:
        if (Result.m1427isFailureimpl(r7) == false) goto L30;
        r7 = null;
    L30:
        URI r10 = (URI) ZeusTransformUtils.preCheckCast(r7, URI.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L33;
        return null;
    L33:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new String[]{"http", LocationInfoConst.HTTPS}), Iterable.class, "com.obric.memorydata.plugin");
        String r12 = r10.getScheme();
        if (r12 == null) goto L36;
        String r13 = r12.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r13, "toLowerCase(...)");
    L38:
        if (CollectionsKt.contains(r11, r13) == false) goto L47;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getHost(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L42;
    L43:
        r3 = true;
    L44:
        if (r3 == true) goto L47;
        return r9;
    L42:
        if (StringsKt.isBlank(r14) == false) goto L44;
    L36:
        r13 = null;
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L28
    L10:
        if (Character.isISOControl(r5) == true) goto L13;
        r6 = false;
        goto L14
    L17:
        r1 = false;
    L47:
        return null;
    }

    public static final Node a(Node r1) {
        Intrinsics.checkNotNullParameter(r1, "root");
        b(r1);
        return r1;
    }

    public static final /* synthetic */ void a(View r0, String r1) {
        b(r0, r1);
    }

    private static final void a(Node r0, Node r1) {
        r0.insertBefore(r1);
        r0.unlink();
    }

    private static final void b(View r5, String r6) {
        String r7 = a(r6);
        if (r7 != null) goto L10;
        return;
    L10:
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Intent r3 = new Intent("android.intent.action.VIEW", Uri.parse(r7));     // Catch: Throwable -> L7
        r3.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Throwable -> L7
        ZeusTransformUtils.startActivity(r8, r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.warn("AgentRunMarkdown", "open external web page failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final void b(Node r6) {
        Node r7 = r6.firstChild;
    L3:
        if (r7 == null) goto L35;
        Node r0 = r7.next;
        String r2 = "";
        if (ZeusTransformUtils.instanceOf(r7, Link.class) == false) goto L15;
        b(r7);
        String r1 = ((Link) ZeusTransformUtils.preCheckCast(r7, Link.class, "com.obric.memorydata.plugin")).getDestination();
        if (r1 == null) goto L10;
        r2 = r1;
    L10:
        String r3 = a(r2);
        if (r3 == null) goto L17;
        ((Link) ZeusTransformUtils.preCheckCast(r7, Link.class, "com.obric.memorydata.plugin")).setDestination(r3);
    L34:
        r7 = r0;
    L17:
        c(r7);
        goto L34
    L15:
        if (ZeusTransformUtils.instanceOf(r7, Image.class) == false) goto L19;
        b(r7);
        goto L17
    L19:
        if (ZeusTransformUtils.instanceOf(r7, HtmlInline.class) == false) goto L27;
        String r4 = ((HtmlInline) ZeusTransformUtils.preCheckCast(r7, HtmlInline.class, "com.obric.memorydata.plugin")).getLiteral();
        if (r4 == null) goto L24;
        r2 = r4;
    L24:
        Node r5 = new Text(r2);
    L25:
        a(r7, (Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
        goto L34
    L27:
        if (ZeusTransformUtils.instanceOf(r7, HtmlBlock.class) == false) goto L33;
        r5 = new Paragraph();
        String r8 = ((HtmlBlock) ZeusTransformUtils.preCheckCast(r7, HtmlBlock.class, "com.obric.memorydata.plugin")).getLiteral();
        if (r8 == null) goto L32;
        r2 = r8;
    L32:
        r5.appendChild((Node) ZeusTransformUtils.preCheckCast(new Text(r2), Node.class, "com.obric.memorydata.plugin"));
        goto L25
    L33:
        b(r7);
        goto L34
    }

    private static final void c(Node r2) {
        Node r0 = r2.firstChild;
    L3:
        if (r0 == null) goto L5;
        Node r1 = r0.next;
        r0.unlink();
        r2.insertBefore(r0);
        r0 = r1;
        goto L3
    L5:
        r2.unlink();
    }
}
