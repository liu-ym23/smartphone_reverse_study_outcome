package io.noties.markwon.maybe;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.inlineparser.o;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybeLinkProcessor;", "Lio/noties/markwon/inlineparser/OpenBracketInlineProcessor;", "origin", "Ljava/util/concurrent/atomic/AtomicReference;", "", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "parse", "Lorg/commonmark/node/Node;", "Companion", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
public final class f extends o {
    public static final a e = null;
    private static final Pattern g = null;
    private static final Pattern h = null;
    private final AtomicReference<String> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/maybe/MaybeLinkProcessor$Companion;", "", "()V", XSDatatype.FACET_PATTERN, "Ljava/util/regex/Pattern;", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "title", "title$annotations", "getTitle", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        e = new a(null);
        Pattern r0 = Pattern.compile("^\\[.+\\]\\([^\\[\\)]*$");
        Intrinsics.checkExpressionValueIsNotNull(r0, "Pattern.compile(\"^\\\\[.+\\\\]\\\\([^\\\\[\\\\)]*$\")");
        g = r0;
        Pattern r1 = Pattern.compile("(?!\\[)([^\\]])*");
        Intrinsics.checkExpressionValueIsNotNull(r1, "Pattern.compile(\"(?!\\\\[)([^\\\\]])*\")");
        h = r1;
    }

    public f(AtomicReference<String> r2) {
        Intrinsics.checkParameterIsNotNull(r2, "origin");
        this.f = r2;
    }

    @Override // io.noties.markwon.inlineparser.o, io.noties.markwon.inlineparser.i
    public Node b() {
        String r0 = this.f.get();
        Intrinsics.checkExpressionValueIsNotNull(r0, "origin.get()");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        String r2 = this.f16626a.d();
        Intrinsics.checkExpressionValueIsNotNull(r2, "context.input()");
        if (StringsKt.endsWith$default(r1, r2, false, 2, null) == false) goto L13;
        String r3 = a(g);
        if (r3 == null) goto L13;
        Matcher r4 = h.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r4.find() == false) goto L9;
        String r5 = r4.group();
    L10:
        g r6 = new g(new Link("", r5));
        r6.appendChild((Node) ZeusTransformUtils.preCheckCast(a(r3), Node.class, "com.obric.memorydata.plugin"));
        return (Node) ZeusTransformUtils.preCheckCast(r6, Node.class, "com.obric.memorydata.plugin");
    L9:
        r5 = "";
    L13:
        return super.b();
    }
}
