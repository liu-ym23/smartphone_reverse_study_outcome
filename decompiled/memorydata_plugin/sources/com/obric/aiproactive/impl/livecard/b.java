package com.obric.aiproactive.impl.livecard;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/AiProactiveLiveCardPlainTextConverter;", "", "<init>", "()V", "fencedCodeFenceRegex", "Lkotlin/text/Regex;", "headingRegex", "blockquoteRegex", "horizontalRuleRegex", "imageRegex", "linkRegex", "referenceLinkRegex", "inlineCodeRegex", "boldRegex", "italicRegex", "strikeRegex", "inlineFormulaRegex", "unorderedListRegex", "orderedListRegex", "markdownEscapeRegex", "blankLinesRegex", "tableSeparatorRegex", "parenthesizedUrlRegex", "bareUrlRegex", "residualMarkdownTokenRegex", "toLossyPlainText", "", "markdown", "flattenTables", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6458b = null;
    private static final Regex c = null;
    private static final Regex d = null;
    private static final Regex e = null;
    private static final Regex f = null;
    private static final Regex g = null;
    private static final Regex h = null;
    private static final Regex i = null;
    private static final Regex j = null;
    private static final Regex k = null;
    private static final Regex l = null;
    private static final Regex m = null;
    private static final Regex n = null;
    private static final Regex o = null;
    private static final Regex p = null;
    private static final Regex q = null;
    private static final Regex r = null;
    private static final Regex s = null;
    private static final Regex t = null;
    private static final Regex u = null;

    static {
        f6457a = new b();
        f6458b = new Regex("(?m)^```[\\w-]*\\s*$");
        c = new Regex("(?m)^\\s{0,3}#{1,6}\\s+");
        d = new Regex("(?m)^\\s{0,3}>\\s?");
        e = new Regex("(?m)^\\s*([-*_]\\s*){3,}\\s*$");
        f = new Regex("!\\[([^\\]]*)]\\(([^)]+)\\)");
        g = new Regex("\\[([^\\]]+)]\\s*\\(([^)]+)\\)");
        h = new Regex("\\[([^\\]]+)]\\[([^\\]]*)]");
        i = new Regex("`([^`]+)`");
        j = new Regex("(\\*\\*|__)(.*?)\\1");
        k = new Regex("(\\*|_)(.*?)\\1");
        l = new Regex("~~(.*?)~~");
        m = new Regex("\\$([^$]+)\\$");
        n = new Regex("(?m)^\\s*[-+*]\\s+");
        o = new Regex("(?m)^\\s*\\d+\\.\\s+");
        p = new Regex("\\\\([\\\\`*_\\[\\]()#+\\-.!])");
        q = new Regex("\n{3,}");
        r = new Regex("^\\s*\\|?(\\s*:?-{3,}:?\\s*\\|)+\\s*:?-{3,}:?\\s*\\|?\\s*$");
        s = new Regex("\\((https?://[a-zA-Z0-9\\-._~:/?#@!$&'*+,;=%]+)\\)");
        t = new Regex("https?://[a-zA-Z0-9\\-._~:/?#@!$&'*+,;=%]+");
        u = new Regex("(?m)(?<!\\w)(\\*\\*|__|~~|`|#+)(?!\\w)");
    }

    private b() {
    }

    private static final CharSequence a(MatchResult r2) {
        MatchResult r3 = (MatchResult) ZeusTransformUtils.wrapperContextForParams(r2, MatchResult.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "matchResult");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getGroupValues().get(1), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L6;
        r4 = "[图片]";
    L6:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String b(String r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.lines((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$WxnCUgxTS7GjzzjK_dHOS78EbRs.INSTANCE, 30, null);
    }

    private static final CharSequence c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "line");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(new Regex("\\s{2,}").replace(r4, " "), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence d(String r12) {
        Intrinsics.checkNotNullParameter(r12, "line");
        if (r.matches((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        Object r13 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L23:
        return (CharSequence) r13;
    L7:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), '|', false, 2, null) == false) goto L22;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'|'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r1.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L10
    L12:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L14;
        r4.add(r6);
        goto L14
    L18:
        r7 = false;
        goto L19
    L21:
        r12 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L22:
        r13 = ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        goto L23
    }

    /* JADX INFO: renamed from: lambda$3t6SwTP0wp98nruxd7C-A-DS_xA, reason: not valid java name */
    public static /* synthetic */ CharSequence m233lambda$3t6SwTP0wp98nruxd7CADS_xA(String r0) {
        return c(r0);
    }

    public static /* synthetic */ CharSequence lambda$WxnCUgxTS7GjzzjK_dHOS78EbRs(String r0) {
        return d(r0);
    }

    public static /* synthetic */ CharSequence lambda$kBP22xCcywrg81UhC67mLXCiCAI(MatchResult r0) {
        return a(r0);
    }

    public final String a(String r13) {
        if (r13 != null) goto L5;
        String r1 = "";
    L6:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r1, "\r\n", "\n", false, 4, null), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(f6458b.replace(r14, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(c.replace(r15, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(d.replace(r16, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(e.replace(r17, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(f.replace(r18, $$Lambda$b$kBP22xCcywrg81UhC67mLXCiCAI.INSTANCE), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(g.replace(r19, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(h.replace(r110, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(s.replace(r111, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r113 = (CharSequence) ZeusTransformUtils.preCheckCast(t.replace(r112, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r114 = (CharSequence) ZeusTransformUtils.preCheckCast(i.replace(r113, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r115 = (CharSequence) ZeusTransformUtils.preCheckCast(j.replace(r114, "$2"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r116 = (CharSequence) ZeusTransformUtils.preCheckCast(k.replace(r115, "$2"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r117 = (CharSequence) ZeusTransformUtils.preCheckCast(l.replace(r116, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r118 = (CharSequence) ZeusTransformUtils.preCheckCast(m.replace(r117, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r119 = (CharSequence) ZeusTransformUtils.preCheckCast(n.replace(r118, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r120 = (CharSequence) ZeusTransformUtils.preCheckCast(o.replace(r119, ""), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r121 = (CharSequence) ZeusTransformUtils.preCheckCast(p.replace(r120, "$1"), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.lines((CharSequence) ZeusTransformUtils.preCheckCast(b(u.replace(r121, "")), CharSequence.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$3t6SwTP0wp98nruxd7CADS_xA.INSTANCE, 30, null), CharSequence.class, "com.obric.memorydata.plugin");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(q.replace(r12, "\n\n"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L5:
        r1 = r13;
        goto L6
    }
}
