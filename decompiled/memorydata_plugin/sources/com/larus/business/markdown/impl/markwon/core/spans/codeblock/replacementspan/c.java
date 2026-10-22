package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan;

import android.content.Context;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.d;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.i;
import io.noties.markwon.l;
import io.noties.markwon.n;
import io.noties.markwon.scrollable.e;
import io.noties.markwon.t;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010$\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010$\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010+\u001a\u00020.H\u0016J\u001e\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020103H\u0002J\u0018\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\tH\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ReplacementCodePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "context", "Landroid/content/Context;", "getPayload", "Lkotlin/Function0;", "", "", "", "customCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "contentMaxWidth", "", "loading", "", "(Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;IZ)V", "getContentMaxWidth", "()I", "getContext", "()Landroid/content/Context;", "getCustomCodeHandler", "()Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomMarkDownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getGetPayload", "()Lkotlin/jvm/functions/Function0;", "getLoading", "()Z", "reuseCharSequence", "", "textView", "Landroid/widget/TextView;", "afterSetText", "", "beforeRender", "node", "Lorg/commonmark/node/Node;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureSpansFactory", "builder", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "needRemoveView", "oldSpan", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "newSpans", "", "printLog", "span", "message", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.larus.business.markdown.api.model.c f5219b;
    private final Context c;
    private final Function0<Map<String, Object>> d;
    private final com.larus.business.markdown.api.extplugin.a.a e;
    private final int f;
    private final boolean g;
    private TextView h;
    private CharSequence i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ReplacementCodePlugin$Companion;", "", "()V", "LOG_TAG", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "indentedCodeBlock", "Lorg/commonmark/node/FencedCodeBlock;", "visit"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b<N extends Node> implements n.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5220a;

        b(c r1) {
            this.f5220a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(n r12, FencedCodeBlock r13) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r12, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "visitor");
            Intrinsics.checkNotNullParameter(r13, "indentedCodeBlock");
            CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.getInfo(), CharSequence.class, "com.obric.memorydata.plugin");
            boolean r0 = false;
            if (r14 != null) goto L5;
        L8:
            boolean r15 = true;
        L9:
            if (r15 == false) goto L11;
            String r16 = "plaintext";
        L12:
            Intrinsics.checkNotNullExpressionValue(r16, "info");
            x r6 = null;
            if (StringsKt.startsWith$default(r16, "STDOUT", false, 2, null) == false) goto L15;
            return;
        L15:
            String r7 = r13.getLiteral();
            CodeBlockConfig r3 = this.f5220a.a().q();
            if (r3 != null) goto L18;
        L20:
            boolean r5 = false;
        L21:
            if (r5 == false) goto L24;
            String r8 = StringsKt.substringBefore$default(r16, " ", null, 2, null);
            com.larus.business.markdown.impl.markwon.custom.title.c r17 = com.larus.business.markdown.impl.markwon.custom.title.c.f5233a;
            int r9 = this.f5220a.b();
            Intrinsics.checkNotNullExpressionValue(r7, "code");
            r17.a(r9, r4, r8, r7, (Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f5220a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f5220a.a(), !this.f5220a.c());
            return;
        L24:
            r4.e((Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"));
            int r10 = r4.f();
            r4.c().a(Typography.nbsp);
            r4.b().b(CoreProps.l, r7);
            r4.b().b(CoreProps.k, r16);
            r4.b().b(d.a(), Integer.valueOf(r10));
            r4.b().b(d.b(), Integer.valueOf(r4.f()));
            CodeBlockConfig r11 = this.f5220a.a().q();
            if (r11 != null) goto L27;
        L29:
            if (r0 == false) goto L31;
            io.noties.markwon.scrollable.b r18 = new io.noties.markwon.scrollable.b(0.0f);
            r4.b().b(d.c(), r18);
            r4.a(r10, r18);
        L31:
            w r19 = r4.a().f().a(r13.getClass());
            if (ZeusTransformUtils.instanceOf(r19, com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.a.class) == false) goto L34;
            com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.a r110 = (com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.a) ZeusTransformUtils.preCheckCast(r19, com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.a.class, "com.obric.memorydata.plugin");
        L35:
            if (r110 == null) goto L37;
            x r111 = r4.c();
            i r1 = r4.a();
            Intrinsics.checkNotNullExpressionValue(r1, "visitor.configuration()");
            t r2 = r4.b();
            Intrinsics.checkNotNullExpressionValue(r2, "visitor.renderProps()");
            r6 = r111.a(r110.a(r1, r2, (Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin")), r10);
        L37:
            if (r6 != null) goto L39;
            r4.b((Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"), r10);
        L39:
            r4.f((Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"));
            return;
        L34:
            r110 = null;
            goto L35
        L27:
            if (r11.getEnableScroll() != true) goto L29;
            r0 = true;
            goto L29
        L18:
            if (r3.getEnableLineNumber() != true) goto L20;
            r5 = true;
            goto L21
        L11:
            r16 = r13.getInfo();
            goto L12
        L5:
            if (r14.length() == 0) goto L8;
            r15 = false;
            goto L9
        }

        @Override // io.noties.markwon.n.c
        public /* synthetic */ void a(n r3, Node r4) {
            a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (FencedCodeBlock) ZeusTransformUtils.preCheckCast(r4, FencedCodeBlock.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f5218a = new a(null);
    }

    public c(com.larus.business.markdown.api.model.c r3, Context r4, Function0<? extends Map<String, ? extends Object>> r5, com.larus.business.markdown.api.extplugin.a.a r6, int r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Function0<Map<String, Object>> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.extplugin.a.a r11 = (com.larus.business.markdown.api.extplugin.a.a) ZeusTransformUtils.wrapperContextForParams(r6, com.larus.business.markdown.api.extplugin.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "getPayload");
        this.f5219b = r3;
        this.c = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.d = r10;
        this.e = r11;
        this.f = r7;
        this.g = r8;
    }

    private final void a(Object r2, String r3) {
        Log.d("", "span[" + r2.hashCode() + "]:" + r3);
    }

    private final boolean a(com.larus.business.markdown.api.extplugin.a.b r7, List<com.larus.business.markdown.api.extplugin.a.b> r8) {
        com.larus.business.markdown.api.extplugin.a.b r9 = (com.larus.business.markdown.api.extplugin.a.b) ZeusTransformUtils.wrapperContextForParams(r7, com.larus.business.markdown.api.extplugin.a.b.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Integer r0 = r9.c();
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L5;
    L7:
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L6;
        if (Intrinsics.areEqual(((com.larus.business.markdown.api.extplugin.a.b) ZeusTransformUtils.preCheckCast(r12.next(), com.larus.business.markdown.api.extplugin.a.b.class, "com.obric.memorydata.plugin")).c(), r0) == false) goto L9;
        boolean r13 = true;
    L13:
        if (r13 == true) goto L15;
        return true;
    L15:
        a(r9, "skip onDetach, reused by new span at same pos");
        return false;
    L6:
        r13 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public final com.larus.business.markdown.api.model.c a() {
        return this.f5219b;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r6) {
        Intrinsics.checkNotNullParameter(r6, "textView");
        super.a(r6);
        CharSequence r0 = r6.getText();
        if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == false) goto L7;
        int r4 = 0;
        com.larus.business.markdown.api.extplugin.a.b[] r1 = (com.larus.business.markdown.api.extplugin.a.b[]) ZeusTransformUtils.preCheckCast(((Spanned) ZeusTransformUtils.preCheckCast(r0, Spanned.class, "com.obric.memorydata.plugin")).getSpans(0, r0.length(), com.larus.business.markdown.api.extplugin.a.b.class), com.larus.business.markdown.api.extplugin.a.b[].class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "spans");
        int r2 = r1.length;
    L5:
        if (r4 >= r2) goto L7;
        r1[r4].a(r6);
        r4 = r4 + 1;
    L7:
        this.h = null;
        this.i = null;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r9, Spanned r10) {
        Spanned r11 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r10, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "textView");
        Intrinsics.checkNotNullParameter(r11, "markdown");
        super.a(r9, r11);
        CharSequence r0 = r9.getText();
        com.larus.business.markdown.api.extplugin.a.b[] r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == false) goto L5;
        Spanned r2 = (Spanned) ZeusTransformUtils.preCheckCast(r0, Spanned.class, "com.obric.memorydata.plugin");
    L6:
        int r4 = 0;
        if (r2 == null) goto L9;
        r3 = (com.larus.business.markdown.api.extplugin.a.b[]) ZeusTransformUtils.preCheckCast(r2.getSpans(0, r0.length(), com.larus.business.markdown.api.extplugin.a.b.class), com.larus.business.markdown.api.extplugin.a.b[].class, "com.obric.memorydata.plugin");
    L9:
        if (r3 != null) goto L11;
        r3 = new com.larus.business.markdown.api.extplugin.a.b[0];
    L11:
        Object[] r1 = r11.getSpans(0, r11.length(), com.larus.business.markdown.api.extplugin.a.b.class);
        Intrinsics.checkNotNullExpressionValue(r1, "markdown.getSpans(0, mar…stomCodeSpan::class.java)");
        List<com.larus.business.markdown.api.extplugin.a.b> r5 = ArraysKt.toMutableList(r1);
        int r6 = r3.length;
    L13:
        if (r4 >= r6) goto L19;
        com.larus.business.markdown.api.extplugin.a.b r7 = r3[r4];
        boolean r8 = r5.remove(r7);
        Intrinsics.checkNotNullExpressionValue(r7, "span");
        if (r8 == true) goto L17;
        r7.a(r9, a(r7, r5));
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r7.a(r11, r7);
        a(r7, "reuse span");
        goto L18
    L19:
        Iterator<com.larus.business.markdown.api.extplugin.a.b> r12 = r5.iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        com.larus.business.markdown.api.extplugin.a.b r13 = (com.larus.business.markdown.api.extplugin.a.b) ZeusTransformUtils.preCheckCast(r12.next(), com.larus.business.markdown.api.extplugin.a.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "span");
        a(r13, "new span beforeAttach");
        r13.a(r9, r11);
        goto L21
    L23:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r2, Node r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        super.a(r2, r3);
        this.h = r2;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(l.a r22) {
        l.a r1 = (l.a) ZeusTransformUtils.wrapperContextForParams(r22, l.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "builder");
        CodeBlockConfig r4 = this.f5219b.q();
        if (r4 == null) goto L7;
        Integer r5 = r4.getTitleBgColor();
        if (r5 == null) goto L7;
        int r6 = r5.intValue();
    L8:
        int r7 = r6;
        CodeBlockConfig r8 = this.f5219b.q();
        if (r8 == null) goto L13;
        Integer r9 = r8.getCornerRadius();
        if (r9 == null) goto L13;
        float r10 = r9.intValue();
    L14:
        float r11 = r10;
        CodeBlockConfig r12 = this.f5219b.q();
        if (r12 == null) goto L17;
        boolean r13 = r12.getEnableScroll();
    L18:
        CodeBlockConfig r14 = this.f5219b.q();
        if (r14 == null) goto L21;
        boolean r15 = r14.getEnableLineNumber();
    L22:
        e r16 = new e(com.larus.business.markdown.impl.common.utils.c.j(), com.larus.business.markdown.impl.common.utils.c.c(), 0.0f, ContextCompat.getColor(this.c, ZeusTransformUtils.mapRes(R.color.neutral_30, TypedValues.Custom.S_COLOR, "neutral_30")));
        int r17 = ZeusTransformUtils.getResources(this.c, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
        CodeBlockConfig r18 = this.f5219b.q();
        if (r18 == null) goto L27;
        Integer r19 = r18.getLineNumberColor();
        if (r19 == null) goto L27;
        int r20 = r19.intValue();
    L28:
        int r110 = r20;
        int r111 = ContextCompat.getColor(this.c, ZeusTransformUtils.mapRes(R.color.neutral_100, TypedValues.Custom.S_COLOR, "neutral_100"));
        CodeBlockConfig r21 = this.f5219b.q();
        if (r21 == null) goto L33;
        Integer r23 = r21.getBlockBorderWidth();
        if (r23 == null) goto L33;
        float r24 = r23.intValue();
    L34:
        float r112 = r24;
        CodeBlockConfig r25 = this.f5219b.q();
        if (r25 == null) goto L39;
        Integer r26 = r25.getBlockBorderColor();
        if (r26 == null) goto L39;
        int r113 = r26.intValue();
    L40:
        CodeBlockConfig r27 = this.f5219b.q();
        if (r27 == null) goto L43;
        boolean r28 = r27.getEnableBlockBackground();
    L44:
        r1.a(FencedCodeBlock.class, (w) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.a(r7, r11, r13, r15, r16, r17, r110, r111, r112, r113, r28, this.d, this.e, this.f), w.class, "com.obric.memorydata.plugin"));
        return;
    L43:
        r28 = true;
    L39:
        r113 = 0;
    L33:
        r24 = com.larus.business.markdown.impl.common.utils.e.b((Number) ZeusTransformUtils.preCheckCast(Float.valueOf(0.5f), Number.class, "com.obric.memorydata.plugin"));
    L27:
        r20 = ContextCompat.getColor(this.c, ZeusTransformUtils.mapRes(R.color.neutral_30, TypedValues.Custom.S_COLOR, "neutral_30"));
        goto L28
    L21:
        r15 = false;
        goto L22
    L17:
        r13 = false;
    L13:
        r10 = com.larus.business.markdown.impl.common.utils.e.b((Number) ZeusTransformUtils.preCheckCast(12, Number.class, "com.obric.memorydata.plugin"));
    L7:
        r6 = ContextCompat.getColor(this.c, ZeusTransformUtils.mapRes(R.color.neutral_transparent_2, TypedValues.Custom.S_COLOR, "neutral_transparent_2"));
        goto L8
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(n.b r4) {
        n.b r5 = (n.b) ZeusTransformUtils.wrapperContextForParams(r4, n.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "builder");
        super.a(r5);
        r5.a(FencedCodeBlock.class, (n.c) ZeusTransformUtils.preCheckCast(new b(this), n.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(CharSequence r3, Node r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "node");
        super.a(r5, r4);
        this.i = r5;
    }

    public final int b() {
        return this.f;
    }

    public final boolean c() {
        return this.g;
    }

    public final Context getContext() {
        return this.c;
    }
}
