package io.noties.markwon.maybe;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/maybe/MaybeTableProcessor;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "origin", "Ljava/util/concurrent/atomic/AtomicReference;", "", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "Companion", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
public final class j extends io.noties.markwon.inlineparser.i {
    public static final a e = null;
    private static final Pattern g = null;
    private final AtomicReference<String> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/maybe/MaybeTableProcessor$Companion;", "", "()V", "oneLine", "", XSDatatype.FACET_PATTERN, "Ljava/util/regex/Pattern;", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "twoLine", "splitCell", "", "input", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final List<String> a(String r9) {
            Intrinsics.checkParameterIsNotNull(r9, "input");
            int r8 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '\n', 0, false, 6, null);
            if (r8 <= 0) goto L5;
            r9 = r9.substring(0, r8);
            Intrinsics.checkExpressionValueIsNotNull(r9, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L5:
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'|'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r10.iterator();
        L7:
            if (r11.hasNext() == false) goto L13;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L12;
            r2.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString());
            goto L7
        L12:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L13:
            List<String> r12 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r12), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L19;
            r12.remove(CollectionsKt.getLastIndex(r12));
        L19:
            if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L21;
        L23:
            return r12;
        L21:
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r12), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L23;
            r12.remove(0);
            goto L23
        }
    }

    static {
        e = new a(null);
        Pattern r0 = Pattern.compile("^\\|.*\\|.*$|^\\|([^\\|\\n]*\\|)+ ?\\n *\\|?[- :\\|]*$");
        Intrinsics.checkExpressionValueIsNotNull(r0, "Pattern.compile(\"$oneLine|$twoLine\")");
        g = r0;
    }

    public j(AtomicReference<String> r2) {
        Intrinsics.checkParameterIsNotNull(r2, "origin");
        this.f = r2;
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return '|';
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        String r0 = this.f.get();
        Intrinsics.checkExpressionValueIsNotNull(r0, "origin.get()");
        String r1 = StringsKt.removeSuffix((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"));
        String r2 = this.f16626a.d();
        Intrinsics.checkExpressionValueIsNotNull(r2, "context.input()");
        if (StringsKt.endsWith$default(r1, r2, false, 2, null) == false) goto L12;
        String r3 = a(g);
        if (r3 == null) goto L12;
        TableBlock r4 = new TableBlock();
        TableHead r5 = new TableHead();
        TableRow r6 = new TableRow();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(e.a(r3), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        TableCell r9 = new TableCell();
        r9.setHeader(true);
        r9.setAlignment(TableCell.Alignment.LEFT);
        r9.appendChild((Node) ZeusTransformUtils.preCheckCast(a(r8), Node.class, "com.obric.memorydata.plugin"));
        r6.appendChild((Node) ZeusTransformUtils.preCheckCast(r9, Node.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        r4.appendChild((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
        r5.appendChild((Node) ZeusTransformUtils.preCheckCast(r6, Node.class, "com.obric.memorydata.plugin"));
        g r10 = new g(r4);
        r10.appendChild((Node) ZeusTransformUtils.preCheckCast(a(r3), Node.class, "com.obric.memorydata.plugin"));
        return (Node) ZeusTransformUtils.preCheckCast(r10, Node.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    }
}
