package io.noties.markwon.html;

import android.text.Spanned;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.BlockParserFactory;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/html/HtmlPlugin3;", "Lio/noties/markwon/html/HtmlPlugin;", "()V", "additionBlockTags", "", "", "justProcessedTextView", "Landroid/widget/TextView;", "tagNames", "", "afterSetText", "", "textView", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureParser", "builder", "Lorg/commonmark/parser/Parser$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "printLog", "span", "", "message", "Companion", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
public class i extends h {
    public static final a g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f16572a;
    private TextView h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/html/HtmlPlugin3$Companion;", "", "()V", "DATA_INLINE", "", "LOG_TAG", "TABLE_CELL_CLASS_NAME", "create", "Lio/noties/markwon/html/HtmlPlugin3;", "configure", "Lio/noties/markwon/html/HtmlPlugin$HtmlConfigure;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "htmlBlock", "Lorg/commonmark/node/HtmlBlock;", "visit"}, k = 3, mv = {1, 1, 15})
    static final class b<N extends Node> implements io.noties.markwon.n.c<HtmlBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f16573a;

        b(i r1) {
            this.f16573a = r1;
        }

        public final void a(io.noties.markwon.n r3, HtmlBlock r4) {
            io.noties.markwon.n r5 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "visitor");
            Intrinsics.checkParameterIsNotNull(r4, "htmlBlock");
            this.f16573a.a(r5, r4.getLiteral());
        }

        @Override // io.noties.markwon.n.c
        public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
            a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (HtmlBlock) ZeusTransformUtils.preCheckCast(r4, HtmlBlock.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "htmlInline", "Lorg/commonmark/node/HtmlInline;", "visit"}, k = 3, mv = {1, 1, 15})
    static final class c<N extends Node> implements io.noties.markwon.n.c<HtmlInline> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f16574a;

        c(i r1) {
            this.f16574a = r1;
        }

        public final void a(io.noties.markwon.n r7, HtmlInline r8) {
            io.noties.markwon.n r9 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r7, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r9, "visitor");
            Intrinsics.checkParameterIsNotNull(r8, "htmlInline");
            Node r0 = r8.parent;
            if (r0 == null) goto L7;
            Class<?> r1 = r0.getClass();
            if (r1 == null) goto L7;
            String r2 = r1.getName();
        L9:
            if (Intrinsics.areEqual(r2, "org.commonmark.ext.gfm.tables.TableCell") == false) goto L19;
            String r3 = r8.getLiteral();
            if (r3 != null) goto L13;
        L14:
            String r4 = r8.getLiteral();
            if (r4 == null) goto L19;
            if (StringsKt.startsWith$default(r4, "</data-inline", false, 2, null) != true) goto L19;
            return;
        L13:
            if (StringsKt.startsWith$default(r3, "<data-inline", false, 2, null) != true) goto L14;
            return;
        L19:
            this.f16574a.a(r9, r8.getLiteral());
            return;
        L7:
            r2 = null;
            goto L9
        }

        @Override // io.noties.markwon.n.c
        public /* synthetic */ void a(io.noties.markwon.n r3, Node r4) {
            a((io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin"), (HtmlInline) ZeusTransformUtils.preCheckCast(r4, HtmlInline.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        g = new a(null);
    }

    public i() {
        this.f16572a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    private final void a(Object r1, String r2) {
    }

    @Override // io.noties.markwon.html.h
    public h a(Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "tagNames");
        this.f16572a.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        h r3 = super.a(r5);
        Intrinsics.checkExpressionValueIsNotNull(r3, "super.additionBlockTags(tagNames)");
        return r3;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r5) {
        Intrinsics.checkParameterIsNotNull(r5, "textView");
        super.a(r5);
        ViewParent r4 = r5.getParent();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == true) goto L5;
        r4 = null;
    L5:
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        io.noties.markwon.html.a.e.a(r6);
    L8:
        CharSequence r7 = r5.getText();
        if (ZeusTransformUtils.instanceOf(r7, Spanned.class) == false) goto L13;
        int r3 = 0;
        io.noties.markwon.html.a.f[] r8 = (io.noties.markwon.html.a.f[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r7, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r7.length(), io.noties.markwon.html.a.f.class), io.noties.markwon.html.a.f[].class, "com.obric.memorydata.plugin");
        int r0 = r8.length;
    L11:
        if (r3 >= r0) goto L15;
        r8[r3].b(r5);
        r3 = r3 + 1;
        goto L11
    L15:
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r9, Spanned r10) {
        Spanned r11 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r10, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "textView");
        Intrinsics.checkParameterIsNotNull(r11, "markdown");
        super.a(r9, r11);
        this.h = r9;
        CharSequence r0 = r9.getText();
        if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == true) goto L5;
        CharSequence r2 = null;
    L6:
        Spanned r3 = (Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r3 == null) goto L11;
        io.noties.markwon.html.a.f[] r1 = (io.noties.markwon.html.a.f[]) ZeusTransformUtils.preCheckCast(r3.getSpans(0, r0.length(), io.noties.markwon.html.a.f.class), io.noties.markwon.html.a.f[].class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
    L12:
        Object[] r5 = r11.getSpans(0, r11.length(), io.noties.markwon.html.a.f.class);
        Intrinsics.checkExpressionValueIsNotNull(r5, "markdown.getSpans(0, mar…stomDataSpan::class.java)");
        List r6 = ArraysKt.toMutableList(r5);
        int r7 = r1.length;
    L14:
        if (r4 >= r7) goto L20;
        io.noties.markwon.html.a.f r8 = r1[r4];
        if (r6.remove(r8) == true) goto L18;
        r8.c(r9);
    L19:
        r4 = r4 + 1;
        goto L14
    L18:
        Intrinsics.checkExpressionValueIsNotNull(r8, "span");
        a(r8, "reuse span");
        r8.a(r9);
        goto L19
    L20:
        Iterator r12 = r6.iterator();
    L22:
        if (r12.hasNext() == false) goto L24;
        io.noties.markwon.html.a.f r13 = (io.noties.markwon.html.a.f) ZeusTransformUtils.preCheckCast(r12.next(), io.noties.markwon.html.a.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkExpressionValueIsNotNull(r13, "span");
        a(r13, "new span beforeAttach");
        r13.a(r9, r11);
        goto L22
    L24:
        return;
    L11:
        r1 = new io.noties.markwon.html.a.f[0];
        goto L12
    L5:
        r2 = r0;
        goto L6
    }

    @Override // io.noties.markwon.html.h, io.noties.markwon.a, io.noties.markwon.k
    public void a(io.noties.markwon.n.b r5) {
        io.noties.markwon.n.b r6 = (io.noties.markwon.n.b) ZeusTransformUtils.wrapperContextForParams(r5, io.noties.markwon.n.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "builder");
        r6.a(HtmlBlock.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(new b(this), io.noties.markwon.n.c.class, "com.obric.memorydata.plugin")).a(HtmlInline.class, (io.noties.markwon.n.c) ZeusTransformUtils.preCheckCast(new c(this), io.noties.markwon.n.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(Parser.Builder r5) {
        Intrinsics.checkParameterIsNotNull(r5, "builder");
        super.a(r5);
        io.noties.markwon.html.a.c.a r0 = new io.noties.markwon.html.a.c.a();
        r0.a().addAll((Collection) ZeusTransformUtils.preCheckCast(this.f16572a, Collection.class, "com.obric.memorydata.plugin"));
        r5.customBlockParserFactory((BlockParserFactory) ZeusTransformUtils.preCheckCast(r0, BlockParserFactory.class, "com.obric.memorydata.plugin"));
    }
}
