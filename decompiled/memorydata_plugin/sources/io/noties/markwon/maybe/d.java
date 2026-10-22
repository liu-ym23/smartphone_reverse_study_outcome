package io.noties.markwon.maybe;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/maybe/MaybeHtmlProcessor;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "origin", "Ljava/util/concurrent/atomic/AtomicReference;", "", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "createMaybeNode", "Lio/noties/markwon/maybe/MaybeNode;", "Lorg/commonmark/node/HtmlInline;", "literal", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "Companion", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
public final class d extends io.noties.markwon.inlineparser.i {
    public static final a e = null;
    private static final Set<String> g = null;
    private static final Pattern h = null;
    private static final Pattern i = null;
    private static final Pattern j = null;
    private static final Pattern k = null;
    private static final Pattern l = null;
    private final AtomicReference<String> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/maybe/MaybeHtmlProcessor$Companion;", "", "()V", "endTagNotFinishPattern", "Ljava/util/regex/Pattern;", "maybeAttribute", "", "maybeCommentOrDeclare", "maybeTag", "maybeTagName", XSDatatype.FACET_PATTERN, "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "startPattern", "startTagFinishWithPropertiesNotFinishPattern", "kotlin.jvm.PlatformType", "startTagNotFinishPattern", "supportedTags", "", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        e = new a(null);
        g = SetsKt.setOf(new String[]{"img", "a", "blockquote", "sub", "sup", "b", "strong", "s", "del", "u", "ins", "ol", "ul", "i", "em", "cite", "dfn", "h1", "h2", "h3", "h4", "h5", "h6", "p", "div", "span"});
        Pattern r0 = Pattern.compile("(^<![-\\w][^>]*$)|(^<[A-Za-z][-_/\\w\\d]*(\\s+[^>]*)?(?!>)$)");
        Intrinsics.checkExpressionValueIsNotNull(r0, "Pattern.compile(\"($maybe…tOrDeclare)|($maybeTag)\")");
        h = r0;
        Pattern r1 = Pattern.compile("^<$", 0);
        Intrinsics.checkExpressionValueIsNotNull(r1, "java.util.regex.Pattern.compile(this, flags)");
        i = r1;
        j = Pattern.compile("^<[A-Za-z0-9]*$");
        k = Pattern.compile("^<[A-Za-z0-9]+ [^>\\n]*$");
        Pattern r2 = Pattern.compile("^</[A-Za-z0-9]*$", 0);
        Intrinsics.checkExpressionValueIsNotNull(r2, "java.util.regex.Pattern.compile(this, flags)");
        l = r2;
    }

    public d(AtomicReference<String> r2) {
        Intrinsics.checkParameterIsNotNull(r2, "origin");
        this.f = r2;
    }

    private final g<HtmlInline> b(String r3) {
        HtmlInline r4 = new HtmlInline();
        r4.setLiteral("");
        g<HtmlInline> r1 = new g(r4);
        r1.appendChild((Node) ZeusTransformUtils.preCheckCast(a(""), Node.class, "com.obric.memorydata.plugin"));
        return r1;
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return Typography.less;
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        if (a(i) == null) goto L6;
        String r0 = this.f16626a.d();
        Intrinsics.checkExpressionValueIsNotNull(r0, "context.input()");
        return (Node) ZeusTransformUtils.preCheckCast(b(r0), Node.class, "com.obric.memorydata.plugin");
    L6:
        String r1 = a(j);
        if (r1 == null) goto L20;
        String r2 = r1.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(r2, "(this as java.lang.String).substring(startIndex)");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), r2, false, 2, null) == false) goto L10;
    L16:
        if (((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")) == null) goto L46;
        String r3 = this.f16626a.d();
        Intrinsics.checkExpressionValueIsNotNull(r3, "context.input()");
        return (Node) ZeusTransformUtils.preCheckCast(b(r3), Node.class, "com.obric.memorydata.plugin");
    L46:
        return null;
    L14:
        r5 = null;
        goto L16
    L20:
        String r6 = a(k);
        if (r6 == null) goto L26;
        String r7 = r6.substring(1, StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), " ", 0, false, 6, null));
        Intrinsics.checkExpressionValueIsNotNull(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (g.contains(r7) == false) goto L47;
        String r8 = this.f16626a.d();
        Intrinsics.checkExpressionValueIsNotNull(r8, "context.input()");
        return (Node) ZeusTransformUtils.preCheckCast(b(r8), Node.class, "com.obric.memorydata.plugin");
    L47:
        return null;
    L26:
        String r9 = a(l);
        if (r9 == null) goto L48;
        String r10 = r9.substring(2);
        Intrinsics.checkExpressionValueIsNotNull(r10, "(this as java.lang.String).substring(startIndex)");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        if (r11.hasNext() == false) goto L34;
        Object r12 = r11.next();
        if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin"), r10, false, 2, null) == false) goto L30;
    L36:
        if (((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin")) == null) goto L49;
        String r13 = this.f16626a.d();
        Intrinsics.checkExpressionValueIsNotNull(r13, "context.input()");
        return (Node) ZeusTransformUtils.preCheckCast(b(r13), Node.class, "com.obric.memorydata.plugin");
    L49:
        return null;
    L34:
        r12 = null;
        goto L36
    L48:
        return null;
    }
}
