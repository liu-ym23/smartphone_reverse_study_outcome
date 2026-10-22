package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.model.BgListItemConfig;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.a.j;
import io.noties.markwon.core.a.k;
import io.noties.markwon.core.spans.q;
import io.noties.markwon.ext.tables.m;
import io.noties.markwon.html.r;
import io.noties.markwon.html.u;
import io.noties.markwon.l;
import io.noties.markwon.n;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.commonmark.internal.DocumentParser;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.BlockParserFactory;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010%\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020(\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u000207X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkwonStruct;", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "context", "Landroid/content/Context;", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "loading", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "maxContentWidth", "", "payload", "", "", "", "(Landroid/content/Context;Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;ZLcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/lang/Integer;Ljava/util/Map;)V", "getCustomMarkDownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "getDrawableLruPool", "()Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "drawableLruPool$delegate", "Lkotlin/Lazy;", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "getDrawablePool", "()Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawablePool$delegate", "imageSize", "Landroid/graphics/Rect;", "getImageSize", "()Landroid/graphics/Rect;", "imageSize$delegate", "getLoading", "()Z", "markdownLinkResolver", "Lkotlin/Function3;", "Landroid/view/View;", "", "getMarkdownLinkResolver", "()Lkotlin/jvm/functions/Function3;", "markdownLinkResolver$delegate", "markdownLinkResolverV2", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "getMarkdownLinkResolverV2", "()Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "markdownLinkResolverV2$delegate", "markdownSettings", "Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "getMarkdownSettings", "()Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "markdownSettings$delegate", "markwon", "Lio/noties/markwon/Markwon;", "getMarkwon", "()Lio/noties/markwon/Markwon;", "getMaxContentWidth", "()Ljava/lang/Integer;", "setMaxContentWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements com.larus.business.markdown.api.model.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.larus.business.markdown.impl.common.a f5249b;
    private final boolean c;
    private final com.larus.business.markdown.api.model.c d;
    private Integer e;
    private Map<String, ? extends Object> f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;
    private final io.noties.markwon.g m;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"com/larus/business/markdown/impl/markwon/MarkwonStruct$markwon$1", "Lio/noties/markwon/AbstractMarkwonPlugin;", "afterRender", "", "textView", "Landroid/widget/TextView;", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "reuseCharSequence", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends io.noties.markwon.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f5250a;

        a(g r1) {
            this.f5250a = r1;
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(TextView r3, Node r4, n r5) {
            n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "node");
            Intrinsics.checkNotNullParameter(r6, "visitor");
            t r7 = r6.b();
            g r2 = this.f5250a;
            if (r3 == null) goto L7;
            CharSequence r8 = r3.getText();
            if (r8 == null) goto L7;
            r7.b(f.b(), r8);
        L7:
            Integer r9 = r2.d();
            if (r9 == null) goto L10;
            int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
            r7.b(f.a(), Integer.valueOf(r10));
        L10:
            Map<String, Object> r11 = r2.e();
            if (r11 == null) goto L14;
            r7.b(f.c(), r11);
            return;
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(CharSequence r3, Node r4, n r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "node");
            Intrinsics.checkNotNullParameter(r7, "visitor");
            t r8 = r7.b();
            g r2 = this.f5250a;
            if (r6 == null) goto L5;
            r8.b(f.b(), r6);
        L5:
            Integer r9 = r2.d();
            if (r9 == null) goto L8;
            int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
            r8.b(f.a(), Integer.valueOf(r10));
        L8:
            Map<String, Object> r11 = r2.e();
            if (r11 == null) goto L12;
            r8.b(f.c(), r11);
            return;
        }
    }

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/larus/business/markdown/impl/markwon/MarkwonStruct$markwon$10", "Lio/noties/markwon/AbstractMarkwonPlugin;", "afterRender", "", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "configureConfiguration", "builder", "Lio/noties/markwon/MarkwonConfiguration$Builder;", "configureParser", "Lorg/commonmark/parser/Parser$Builder;", "configureSpansFactory", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "configureTheme", "Lio/noties/markwon/core/MarkwonTheme$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends io.noties.markwon.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f5251a;

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "emphasis", "Lorg/commonmark/node/Emphasis;", "visit"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a<N extends Node> implements n.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<N> f5252a = null;

            static {
                f5252a = new a();
            }

            a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void a(n r4, Emphasis r5) {
                n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "visitor");
                Intrinsics.checkNotNullParameter(r5, "emphasis");
                int r6 = r3.f();
                r3.c((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"));
                r3.b((Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin"), r6);
                Node r7 = r5.lastChild;
                if (ZeusTransformUtils.instanceOf(r7, Text.class) == false) goto L5;
                Text r8 = (Text) ZeusTransformUtils.preCheckCast(r7, Text.class, "com.obric.memorydata.plugin");
            L6:
                if (r8 == null) goto L11;
                String r9 = r8.getLiteral();
                Intrinsics.checkNotNullExpressionValue(r9, "it.literal");
                if (f.a(r9) == false) goto L12;
                int r10 = r3.f();
                r3.c().a(Typography.nbsp);
                r3.a(r10, new q(com.larus.business.markdown.impl.common.utils.c.a(ZeusTransformUtils.mapRes(R.dimen.dp_3, "dimen", "dp_3"))));
                return;
            L12:
                return;
            L11:
                return;
            L5:
                r8 = null;
                goto L6
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(n r3, Node r4) {
                a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (Emphasis) ZeusTransformUtils.preCheckCast(r4, Emphasis.class, "com.obric.memorydata.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.g$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/business/markdown/impl/markwon/MarkwonStruct$markwon$10$configureVisitor$2", "Lio/noties/markwon/BlockHandlerDef;", "blockEnd", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "node", "Lorg/commonmark/node/Node;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class C0219b extends io.noties.markwon.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f5253a;

            C0219b(g r1) {
                this.f5253a = r1;
            }

            @Override // io.noties.markwon.b, io.noties.markwon.n.a
            public void a(n r4, Node r5) {
                n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r6, "visitor");
                Intrinsics.checkNotNullParameter(r5, "node");
                Function1<Node, Integer> r0 = this.f5253a.c().n();
                if (r0 == null) goto L7;
                Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r5), Integer.class, "com.obric.memorydata.plugin");
                if (r1 == null) goto L7;
                int r3 = r1.intValue();
            L11:
                if (r3 > 0) goto L14;
                return;
            L14:
                if (r6.d(r5) == true) goto L16;
                return;
            L16:
                if (ZeusTransformUtils.instanceOf(r5.next, HtmlBlock.class) == true) goto L20;
                r6.d();
                int r7 = r6.f();
                r6.c().a(" ");
                r6.a(r7, io.noties.markwon.f.a.f16541a.b(r3));
                r6.d();
                return;
            L20:
                return;
            L7:
                Integer r8 = this.f5253a.c().l();
                if (r8 == null) goto L10;
                r3 = r8.intValue();
                goto L11
            L10:
                r3 = com.larus.business.markdown.impl.common.utils.c.f();
                goto L11
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "indentedCodeBlock", "Lorg/commonmark/node/FencedCodeBlock;", "visit"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class c<N extends Node> implements n.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f5254a;

            c(g r1) {
                this.f5254a = r1;
            }

            public final void a(n r12, FencedCodeBlock r13) {
                n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r12, n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "visitor");
                Intrinsics.checkNotNullParameter(r13, "indentedCodeBlock");
                com.larus.business.markdown.impl.markwon.custom.title.c r2 = com.larus.business.markdown.impl.markwon.custom.title.c.f5233a;
                Integer r14 = this.f5254a.d();
                boolean r0 = false;
                if (r14 == null) goto L5;
                int r3 = r14.intValue();
            L6:
                CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.getInfo(), CharSequence.class, "com.obric.memorydata.plugin");
                if (r15 != null) goto L9;
            L10:
                r0 = true;
            L11:
                if (r0 == false) goto L13;
                String r16 = "plaintext";
            L14:
                String r6 = r13.getLiteral();
                Intrinsics.checkNotNullExpressionValue(r6, "indentedCodeBlock.literal");
                r2.a(r3, r4, r16, r6, (Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5254a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f5254a.c(), !this.f5254a.b());
                return;
            L13:
                String r17 = r13.getInfo();
                Intrinsics.checkNotNullExpressionValue(r17, "indentedCodeBlock.info");
                r16 = StringsKt.substringBefore$default(r17, " ", null, 2, null);
                goto L14
            L9:
                if (r15.length() != 0) goto L11;
            L5:
                r3 = 0;
                goto L6
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(n r3, Node r4) {
                a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (FencedCodeBlock) ZeusTransformUtils.preCheckCast(r4, FencedCodeBlock.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tableTitle", "Lio/noties/markwon/ext/tables/TableTitle;", "visit"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class d<N extends Node> implements n.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f5255a;

            d(g r1) {
                this.f5255a = r1;
            }

            public final void a(n r10, io.noties.markwon.ext.tables.n r11) {
                n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r10, n.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "visitor");
                Intrinsics.checkNotNullParameter(r11, "tableTitle");
                com.larus.business.markdown.impl.markwon.custom.title.c r2 = com.larus.business.markdown.impl.markwon.custom.title.c.f5233a;
                Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5255a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
                Integer r12 = this.f5255a.d();
                if (r12 == null) goto L5;
                int r13 = r12.intValue();
            L6:
                r2.a(r3, r13, r5, r11, this.f5255a.c(), !this.f5255a.b());
                return;
            L5:
                r13 = 0;
                goto L6
            }

            @Override // io.noties.markwon.n.c
            public /* synthetic */ void a(n r3, Node r4) {
                a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (io.noties.markwon.ext.tables.n) ZeusTransformUtils.preCheckCast(r4, io.noties.markwon.ext.tables.n.class, "com.obric.memorydata.plugin"));
            }
        }

        b(g r1) {
            this.f5251a = r1;
        }

        private static final void a(g r1, View r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "link");
            Function3 r4 = g.e(r1);
            if (r4 == null) goto L6;
            r4.invoke(r2, r3, false);
            return;
        }

        public static /* synthetic */ void lambda$AXege6Bt_sWquPCaS_54aebL6nY(g r0, View r1, String r2) {
            a(r0, r1, r2);
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(io.noties.markwon.core.c.a r7) {
            Intrinsics.checkNotNullParameter(r7, "builder");
            Integer r0 = this.f5251a.c().e();
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L10:
            int r3 = 0;
            r7.a(r1).a(false).i(18);
            Float r2 = this.f5251a.c().h();
            if (r2 == null) goto L13;
            r7.b(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).floatValue());
        L13:
            Float r4 = this.f5251a.c().g();
            if (r4 == null) goto L16;
            r7.a(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue());
        L16:
            ThematicBreakConfig r5 = this.f5251a.c().p();
            if (r5 == null) goto L21;
            Integer r6 = r5.getBgColor();
            if (r6 == null) goto L21;
            int r8 = r6.intValue();
        L22:
            r7.p(r8);
            ThematicBreakConfig r9 = this.f5251a.c().p();
            if (r9 == null) goto L27;
            Integer r10 = r9.getHeight();
            if (r10 == null) goto L27;
            int r11 = r10.intValue();
        L28:
            r7.q(r11);
            CodeBlockConfig r12 = this.f5251a.c().q();
            if (r12 == null) goto L33;
            Integer r13 = r12.getBackgroundColor();
            if (r13 == null) goto L33;
            int r14 = r13.intValue();
        L34:
            r7.l(r14);
            CodeBlockConfig r15 = this.f5251a.c().q();
            if (r15 == null) goto L39;
            Integer r16 = r15.getBlockBackgroundColor();
            if (r16 == null) goto L39;
            int r17 = r16.intValue();
        L40:
            r7.m(r17);
            CodeBlockConfig r18 = this.f5251a.c().q();
            if (r18 == null) goto L45;
            Integer r19 = r18.getCodeBlockTextColor();
            if (r19 == null) goto L45;
            r7.k(((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).intValue());
        L45:
            CodeBlockConfig r20 = this.f5251a.c().q();
            if (r20 == null) goto L50;
            Integer r21 = r20.getCodeTextColor();
            if (r21 == null) goto L50;
            int r22 = r21.intValue();
        L51:
            r7.j(r22);
            CodeBlockConfig r23 = this.f5251a.c().q();
            if (r23 == null) goto L56;
            Integer r24 = r23.getBlockMargin();
            if (r24 == null) goto L56;
            int r25 = r24.intValue();
        L57:
            r7.n(r25);
            com.larus.business.markdown.api.model.a r26 = this.f5251a.c().o();
            if (r26 == null) goto L62;
            Integer r27 = r26.c();
            if (r27 == null) goto L62;
            int r28 = r27.intValue();
        L63:
            r7.d(r28);
            com.larus.business.markdown.api.model.a r29 = this.f5251a.c().o();
            if (r29 == null) goto L68;
            Integer r30 = r29.b();
            if (r30 == null) goto L68;
            int r31 = r30.intValue();
        L69:
            r7.c(r31);
            com.larus.business.markdown.api.model.a r32 = this.f5251a.c().o();
            if (r32 == null) goto L75;
            Integer r33 = r32.e();
            if (r33 == null) goto L75;
            r7.b(((Number) ZeusTransformUtils.preCheckCast(r33, Number.class, "com.obric.memorydata.plugin")).intValue());
        L75:
            if (this.f5251a.c().f() == 0) goto L77;
            r7.e(this.f5251a.c().f());
        L77:
            ListStyle r34 = this.f5251a.c().x();
            if (r34 == null) goto L80;
            boolean r35 = r34.getEnableListInLooseListMargin();
        L81:
            r7.c(!r35);
            com.larus.business.markdown.api.model.f r36 = this.f5251a.c().v();
            if (r36 == null) goto L86;
            Integer r37 = r36.a();
            if (r37 == null) goto L86;
            int r38 = r37.intValue();
        L87:
            r7.g(r38);
            com.larus.business.markdown.api.model.f r39 = this.f5251a.c().v();
            if (r39 == null) goto L92;
            Integer r40 = r39.b();
            if (r40 == null) goto L92;
            r3 = r40.intValue();
        L92:
            r7.f(r3);
            return;
        L86:
            r38 = 0;
            goto L87
        L80:
            r35 = false;
        L68:
            r31 = 0;
        L62:
            r28 = 0;
        L56:
            r25 = com.larus.business.markdown.impl.common.utils.e.a((Number) ZeusTransformUtils.preCheckCast(16, Number.class, "com.obric.memorydata.plugin"));
        L50:
            r22 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_100, TypedValues.Custom.S_COLOR, "neutral_100"));
        L39:
            r17 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_transparent_1, TypedValues.Custom.S_COLOR, "neutral_transparent_1"));
        L33:
            r14 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_transparent_1, TypedValues.Custom.S_COLOR, "neutral_transparent_1"));
        L27:
            r11 = com.larus.business.markdown.impl.common.utils.c.a();
        L21:
            r8 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_transparent_2, TypedValues.Custom.S_COLOR, "neutral_transparent_2"));
            goto L22
        L5:
            Context r41 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (this.f5251a.c().d() == false) goto L8;
            int r42 = R.color.additional_purple_premium_1;
            String r43 = "additional_purple_premium_1";
        L9:
            r1 = ContextCompat.getColor(r41, ZeusTransformUtils.mapRes(r42, TypedValues.Custom.S_COLOR, r43));
            goto L10
        L8:
            r42 = R.color.primary_50;
            r43 = "primary_50";
            goto L9
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(io.noties.markwon.i.a r3) {
            Intrinsics.checkNotNullParameter(r3, "builder");
            com.larus.business.markdown.api.depend.i r0 = g.c(this.f5251a);
            if (r0 == null) goto L5;
            io.noties.markwon.d r2 = (io.noties.markwon.d) ZeusTransformUtils.preCheckCast(r0, io.noties.markwon.d.class, "com.obric.memorydata.plugin");
        L6:
            r3.a(r2);
            return;
        L5:
            final g r4 = this.f5251a;
            r2 = new $$Lambda$g$b$AXege6Bt_sWquPCaS_54aebL6nY(r4);
            goto L6
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(l.a r21) {
            l.a r1 = (l.a) ZeusTransformUtils.wrapperContextForParams(r21, l.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "builder");
            r1.a(Link.class, (w) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.a.e(g.d(this.f5251a).k()), w.class, "com.obric.memorydata.plugin"));
            r1.a(ThematicBreak.class, (w) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.a.n(this.f5251a.c().p()), w.class, "com.obric.memorydata.plugin"));
            com.larus.business.markdown.api.model.a r3 = this.f5251a.c().o();
            if (r3 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == true) goto L23;
            com.larus.business.markdown.api.model.a r7 = this.f5251a.c().o();
            if (r7 == null) goto L14;
            Integer r8 = r7.d();
            if (r8 == null) goto L14;
            int r9 = r8.intValue();
        L15:
            com.larus.business.markdown.api.model.a r10 = this.f5251a.c().o();
            if (r10 == null) goto L20;
            Integer r11 = r10.e();
            if (r11 == null) goto L20;
            int r12 = r11.intValue();
        L21:
            r1.a(BlockQuote.class, (w) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.a.b(r9, r12), w.class, "com.obric.memorydata.plugin"));
        L20:
            r12 = 0;
        L14:
            r9 = 0;
        L23:
            if (this.f5251a.c().k() == null) goto L40;
            BgListItemConfig r13 = this.f5251a.c().k();
            Integer r14 = null;
            if (r13 == null) goto L27;
            Integer r15 = Integer.valueOf(r13.getBgColor());
        L28:
            BgListItemConfig r16 = this.f5251a.c().k();
            if (r16 == null) goto L31;
            Integer r17 = Integer.valueOf(r16.getBgMargin());
        L32:
            BgListItemConfig r18 = this.f5251a.c().k();
            if (r18 == null) goto L35;
            Float r19 = r18.getBgRadius();
        L36:
            BgListItemConfig r110 = this.f5251a.c().k();
            if (r110 == null) goto L39;
            r14 = r110.getLeading();
        L39:
            Object r6 = new io.noties.markwon.core.a.a(r15, r17, r19, r14);
        L41:
            r1.a(ListItem.class, (w) ZeusTransformUtils.preCheckCast((j) ZeusTransformUtils.preCheckCast(r6, j.class, "com.obric.memorydata.plugin"), w.class, "com.obric.memorydata.plugin"));
            r1.a(Heading.class, (w) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.a.h(this.f5251a.c().i(), this.f5251a.c().w()), w.class, "com.obric.memorydata.plugin"));
            CodeBlockConfig r20 = this.f5251a.c().q();
            if (r20 == null) goto L46;
            Integer r22 = r20.getTitleBgColor();
            if (r22 == null) goto L46;
            int r23 = r22.intValue();
        L47:
            int r24 = r23;
            CodeBlockConfig r25 = this.f5251a.c().q();
            if (r25 == null) goto L52;
            Integer r26 = r25.getCornerRadius();
            if (r26 == null) goto L52;
            float r27 = r26.intValue();
        L53:
            float r28 = r27;
            CodeBlockConfig r29 = this.f5251a.c().q();
            if (r29 == null) goto L56;
            boolean r30 = r29.getEnableScroll();
        L57:
            CodeBlockConfig r31 = this.f5251a.c().q();
            if (r31 == null) goto L60;
            boolean r111 = r31.getEnableLineNumber();
        L61:
            io.noties.markwon.scrollable.e r112 = new io.noties.markwon.scrollable.e(com.larus.business.markdown.impl.common.utils.c.j(), com.larus.business.markdown.impl.common.utils.c.c(), 0.0f, ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_30, TypedValues.Custom.S_COLOR, "neutral_30")));
            int r113 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
            CodeBlockConfig r5 = this.f5251a.c().q();
            if (r5 == null) goto L66;
            Integer r32 = r5.getLineNumberColor();
            if (r32 == null) goto L66;
            int r33 = r32.intValue();
        L67:
            int r114 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_100, TypedValues.Custom.S_COLOR, "neutral_100"));
            CodeBlockConfig r34 = this.f5251a.c().q();
            if (r34 == null) goto L72;
            Integer r35 = r34.getBlockBorderWidth();
            if (r35 == null) goto L72;
            float r36 = r35.intValue();
        L73:
            CodeBlockConfig r37 = this.f5251a.c().q();
            if (r37 == null) goto L78;
            Integer r38 = r37.getBlockBorderColor();
            if (r38 == null) goto L78;
            int r115 = r38.intValue();
        L79:
            CodeBlockConfig r39 = this.f5251a.c().q();
            if (r39 == null) goto L82;
            boolean r116 = r39.getEnableBlockBackground();
        L83:
            r1.a(FencedCodeBlock.class, (w) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.spans.a.b(r24, r28, r30, r111, r112, r113, r33, r114, r36, r115, r116), w.class, "com.obric.memorydata.plugin"));
            TableConfig r40 = this.f5251a.c().r();
            if (r40 == null) goto L86;
            int r41 = r40.getTableTitleBgColor();
            String r42 = TypedValues.Custom.S_COLOR;
        L87:
            r1.a(io.noties.markwon.ext.tables.n.class, (w) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.custom.title.e(r41, com.larus.business.markdown.impl.common.utils.e.b((Number) ZeusTransformUtils.preCheckCast(8, Number.class, "com.obric.memorydata.plugin")), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_transparent_3_web, r42, "neutral_transparent_3_web"))), w.class, "com.obric.memorydata.plugin"));
            return;
        L86:
            Context r43 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            int r44 = R.color.neutral_transparent_2;
            r42 = TypedValues.Custom.S_COLOR;
            r41 = ContextCompat.getColor(r43, ZeusTransformUtils.mapRes(r44, r42, "neutral_transparent_2"));
            goto L87
        L82:
            r116 = true;
        L78:
            r115 = 0;
        L72:
            r36 = com.larus.business.markdown.impl.common.utils.e.b((Number) ZeusTransformUtils.preCheckCast(Float.valueOf(0.5f), Number.class, "com.obric.memorydata.plugin"));
        L66:
            r33 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_30, TypedValues.Custom.S_COLOR, "neutral_30"));
            goto L67
        L60:
            r111 = false;
            goto L61
        L56:
            r30 = false;
        L52:
            r27 = com.larus.business.markdown.impl.common.utils.e.b((Number) ZeusTransformUtils.preCheckCast(12, Number.class, "com.obric.memorydata.plugin"));
        L46:
            r23 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(g.b(this.f5251a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.neutral_transparent_2, TypedValues.Custom.S_COLOR, "neutral_transparent_2"));
            goto L47
        L35:
            r19 = null;
            goto L36
        L31:
            r17 = null;
            goto L32
        L27:
            r15 = null;
            goto L28
        L40:
            r6 = new k(this.f5251a.c().t(), this.f5251a.c().x());
            goto L41
        L5:
            if (r3.a() != true) goto L7;
            r4 = true;
            goto L8
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(n.b r7) {
            n.b r8 = (n.b) ZeusTransformUtils.wrapperContextForParams(r7, n.b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "builder");
            super.a(r8);
            r8.a(ListItem.class, (n.c) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.c.b(g.d(this.f5251a).j(), this.f5251a.c().m(), this.f5251a.c().o()), n.c.class, "com.obric.memorydata.plugin"));
            r8.a(SoftLineBreak.class, (n.c) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.c.c(), n.c.class, "com.obric.memorydata.plugin")).a(Emphasis.class, (n.c) ZeusTransformUtils.preCheckCast(a.f5252a, n.c.class, "com.obric.memorydata.plugin"));
            r8.a((n.a) ZeusTransformUtils.preCheckCast(new C0219b(this.f5251a), n.a.class, "com.obric.memorydata.plugin"));
            r8.a(FencedCodeBlock.class, (n.c) ZeusTransformUtils.preCheckCast(new c(this.f5251a), n.c.class, "com.obric.memorydata.plugin"));
            r8.a(io.noties.markwon.ext.tables.n.class, (n.c) ZeusTransformUtils.preCheckCast(new d(this.f5251a), n.c.class, "com.obric.memorydata.plugin"));
            com.larus.business.markdown.api.model.a r0 = this.f5251a.c().o();
            boolean r2 = true;
            if (r0 != null) goto L5;
        L7:
            r2 = false;
        L8:
            if (r2 == false) goto L11;
            r8.a(BlockQuote.class, (n.c) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.c.a(this.f5251a.c()), n.c.class, "com.obric.memorydata.plugin"));
            return;
        L11:
            return;
        L5:
            if (r0.a() != true) goto L7;
            goto L7
        }

        @Override // io.noties.markwon.a
        public void a(Node r3, n r4) {
            n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "node");
            Intrinsics.checkNotNullParameter(r5, "visitor");
            io.noties.markwon.core.b.f16425a.a(r5, this.f5251a.b());
        }

        @Override // io.noties.markwon.a, io.noties.markwon.k
        public void a(Parser.Builder r4) {
            Intrinsics.checkNotNullParameter(r4, "builder");
            Set<Class<? extends Block>> r0 = DocumentParser.getDefaultBlockParserTypes();
            Intrinsics.checkNotNullExpressionValue(r0, "getDefaultBlockParserTypes()");
            Set<Class<? extends Block>> r1 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
            if (this.f5251a.b() == false) goto L5;
            r1.remove(FencedCodeBlock.class);
        L5:
            r1.remove(IndentedCodeBlock.class);
            r1.remove(Heading.class);
            if (g.d(this.f5251a).j() == false) goto L8;
            r1.remove(ListBlock.class);
            r4.customBlockParserFactory((BlockParserFactory) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.b.b.C0860b(), BlockParserFactory.class, "com.obric.memorydata.plugin"));
        L8:
            r4.enabledBlockTypes(r1);
            r4.customBlockParserFactory((BlockParserFactory) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.b.a(), BlockParserFactory.class, "com.obric.memorydata.plugin"));
        }
    }

    public g(Context r36, com.larus.business.markdown.impl.common.a r37, boolean r38, com.larus.business.markdown.api.model.c r39, Integer r40, Map<String, ? extends Object> r41) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r41, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r37, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(r39, "customMarkDownInfo");
        Context r4 = ZeusTransformUtils.wrapperContext(r3, "com.obric.memorydata.plugin");
        this.f5248a = r4;
        this.f5249b = r37;
        this.c = r38;
        this.d = r39;
        this.e = r40;
        this.f = r5;
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$markdownSettings$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$drawablePool$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$drawableLruPool$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.j = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$imageSize$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.k = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$markdownLinkResolver$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$markdownLinkResolverV2$2(this), Function0.class, "com.obric.memorydata.plugin"));
        io.noties.markwon.g.a r1 = io.noties.markwon.g.a(r4).a(r37.h()).a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new a(this), io.noties.markwon.k.class, "com.obric.memorydata.plugin")).a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new io.noties.markwon.core.b(), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        com.larus.business.markdown.api.extplugin.image.c r6 = com.larus.business.markdown.api.extplugin.image.d.a();
        if (r6 == null) goto L5;
        r1.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new io.noties.markwon.ext.a.a(g(), f().l()), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        r1.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(r6.a(c().b(), c().a(), d(), c().j(), i(), f().g(), e()), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
    L5:
        io.noties.markwon.ext.tables.l.a r2 = new io.noties.markwon.ext.tables.l.a();
        TableConfig r7 = c().r();
        if (r7 == null) goto L10;
        Integer r8 = r7.getTableBorderColor();
        if (r8 == null) goto L10;
        int r9 = r8.intValue();
    L11:
        io.noties.markwon.ext.tables.l.a r10 = r2.a(r9);
        TableConfig r11 = c().r();
        if (r11 == null) goto L16;
        Integer r12 = r11.getTableOddRowBackgroundColor();
        if (r12 == null) goto L16;
        int r13 = r12.intValue();
    L17:
        io.noties.markwon.ext.tables.l.a r14 = r10.c(r13);
        TableConfig r15 = c().r();
        if (r15 == null) goto L22;
        Integer r16 = r15.getTableHeaderRowBackgroundColor();
        if (r16 == null) goto L22;
        int r17 = r16.intValue();
    L23:
        io.noties.markwon.ext.tables.l.a r18 = r14.d(r17);
        TableConfig r19 = c().r();
        if (r19 == null) goto L28;
        Integer r20 = r19.getTableBorderWidth();
        if (r20 == null) goto L28;
        int r21 = r20.intValue();
    L29:
        io.noties.markwon.ext.tables.l.a r22 = r18.b(r21);
        TableConfig r23 = c().r();
        int r24 = 0;
        if (r23 == null) goto L34;
        Integer r25 = r23.getTableWidth();
        if (r25 == null) goto L34;
    L36:
        int r110 = r25.intValue();
    L38:
        TableConfig r26 = c().r();
        if (r26 == null) goto L43;
        Integer r27 = r26.getCellMaxWidth();
        if (r27 == null) goto L43;
        int r28 = r27.intValue();
    L44:
        int r29 = r28;
        TableConfig r30 = c().r();
        if (r30 == null) goto L49;
        Integer r31 = r30.getCellVerticalPadding();
        if (r31 == null) goto L49;
        int r32 = r31.intValue();
    L50:
        int r210 = r32;
        TableConfig r33 = c().r();
        if (r33 == null) goto L55;
        Integer r34 = r33.getCellHorizontalPadding();
        if (r34 == null) goto L55;
        int r35 = r34.intValue();
    L56:
        int r211 = r35;
        TableConfig r42 = c().r();
        if (r42 == null) goto L61;
        Integer r43 = r42.getBottomRoundCornerRadius();
        if (r43 == null) goto L61;
        int r44 = r43.intValue();
    L62:
        float r45 = r44;
        TableConfig r46 = c().r();
        if (r46 == null) goto L67;
        Integer r47 = r46.getTopRoundCornerRadius();
        if (r47 == null) goto L67;
        int r48 = r47.intValue();
    L68:
        float r49 = r48;
        TableConfig r50 = c().r();
        boolean r111 = false;
        if (r50 == null) goto L81;
        Float r51 = r50.getTableTextSize();
        if (r51 == null) goto L81;
        if (((Number) ZeusTransformUtils.preCheckCast(r51, Number.class, "com.obric.memorydata.plugin")).floatValue() <= 0) goto L75;
        boolean r52 = true;
    L76:
        if (r52 == true) goto L79;
        r51 = null;
    L79:
        if (r51 == null) goto L81;
        float r53 = r51.floatValue();
    L82:
        float r212 = r53;
        TableConfig r54 = c().r();
        if (r54 == null) goto L87;
        Integer r55 = r54.getTableTextColor();
        if (r55 == null) goto L87;
        int r56 = r55.intValue();
    L88:
        int r213 = r56;
        i r57 = new i();
        TableConfig r58 = c().r();
        if (r58 == null) goto L91;
        boolean r214 = r58.getEnableTableWidthMatchParent();
    L92:
        Intrinsics.checkNotNullExpressionValue(r22, "tableBorderWidth(customM….tableBorderWidth?: dp_1)");
        m r59 = new m(r22, r110, 0, r29, r210, r211, 0, r212, 0.0f, r45, r49, r213, r214, (io.noties.markwon.ext.tables.d) ZeusTransformUtils.preCheckCast(r57, io.noties.markwon.ext.tables.d.class, "com.obric.memorydata.plugin"), 1, 320, null);
        io.noties.markwon.scrollable.e r60 = new io.noties.markwon.scrollable.e(com.larus.business.markdown.impl.common.utils.c.j(), com.larus.business.markdown.impl.common.utils.c.c(), 0.0f, ContextCompat.getColor(r4, ZeusTransformUtils.mapRes(R.color.neutral_50, TypedValues.Custom.S_COLOR, "neutral_50")));
        TableConfig r61 = c().r();
        if (r61 == null) goto L95;
        boolean r62 = r61.getCopyExcelStyle();
    L96:
        io.noties.markwon.g.a r63 = r1.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new io.noties.markwon.ext.tables.h(r59, r60, new io.noties.markwon.ext.tables.g(r62)), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        com.larus.business.markdown.impl.common.b r64 = com.larus.business.markdown.impl.common.b.f5171a;
        Boolean r65 = c().z();
        if (r65 == null) goto L99;
        boolean r66 = r65.booleanValue();
    L100:
        io.noties.markwon.g.a r67 = r63.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(r64.a(r4, r66), io.noties.markwon.k.class, "com.obric.memorydata.plugin")).a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new c(f().i()), io.noties.markwon.k.class, "com.obric.memorydata.plugin")).a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.phone.a(c().s(), (Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$markwon$4(this), Function0.class, "com.obric.memorydata.plugin")), io.noties.markwon.k.class, "com.obric.memorydata.plugin")).a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(io.noties.markwon.inlineparser.m.a(), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        if (f().a().b() == true) goto L110;
        com.larus.business.markdown.api.extplugin.latex.a r68 = com.larus.business.markdown.api.extplugin.latex.b.a();
        if (r68 == null) goto L110;
        com.larus.business.markdown.api.model.a.a r69 = f().a();
        com.larus.business.markdown.api.model.a.b r112 = c().B();
        Integer r70 = d();
        if (r70 == null) goto L108;
        int r113 = r70.intValue();
    L109:
        r67.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(r68.a(r4, r69, r112, r113, g(), h(), f().l()), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        goto L110
    L108:
        r113 = 0;
    L110:
        r.f16609a.a(f().d());
        io.noties.markwon.html.e.a r71 = io.noties.markwon.html.e.f16564a;
        List<com.larus.business.markdown.api.depend.a> r72 = f().f();
        Map<String, com.larus.business.markdown.api.extplugin.b.a> r73 = f().n();
        if (r73 != null) goto L113;
        r73 = MapsKt.emptyMap();
    L113:
        Boolean r74 = c().y();
        if (r74 == null) goto L117;
        boolean r75 = r74.booleanValue();
    L120:
        io.noties.markwon.html.h r76 = r71.a(r72, r73, r75);
        Iterator r77 = ((Iterable) ZeusTransformUtils.preCheckCast(c().c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L122:
        if (r77.hasNext() == false) goto L124;
        r76.a((u) ZeusTransformUtils.preCheckCast(r77.next(), u.class, "com.obric.memorydata.plugin"));
        goto L122
    L124:
        Unit r78 = Unit.INSTANCE;
        io.noties.markwon.g.a r79 = r67.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(r76, io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        CodeBlockConfig r80 = c().q();
        if (r80 != null) goto L127;
    L129:
        boolean r81 = false;
    L130:
        if (r81 == true) goto L132;
        r79.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(io.noties.markwon.syntax.h.a(new io.noties.a.h((io.noties.a.e) ZeusTransformUtils.preCheckCast(new io.noties.markwon.syntax.a(), io.noties.a.e.class, "com.obric.memorydata.plugin")), (io.noties.markwon.syntax.d) ZeusTransformUtils.preCheckCast(io.noties.markwon.syntax.e.a(0), io.noties.markwon.syntax.d.class, "com.obric.memorydata.plugin"), "c"), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
    L132:
        io.noties.markwon.g.a r82 = r79.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(io.noties.markwon.ext.strikethrough.a.a(), io.noties.markwon.k.class, "com.obric.memorydata.plugin")).a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(io.noties.markwon.ext.tasklist.c.a(ContextCompat.getColor(this.f5248a, ZeusTransformUtils.mapRes(R.color.primary_50, TypedValues.Custom.S_COLOR, "primary_50")), ContextCompat.getColor(this.f5248a, ZeusTransformUtils.mapRes(R.color.primary_50, TypedValues.Custom.S_COLOR, "primary_50")), ContextCompat.getColor(this.f5248a, ZeusTransformUtils.mapRes(R.color.static_white, TypedValues.Custom.S_COLOR, "static_white"))), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        if (b() == false) goto L135;
        r82.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new io.noties.markwon.maybe.h(r24, r24, 3, r111), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
    L135:
        io.noties.markwon.g.a r83 = r82.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new b(this), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        List<io.noties.markwon.a> r84 = c().u();
        if (r84 == null) goto L139;
        r83.a((Iterable) ZeusTransformUtils.preCheckCast(r84, Iterable.class, "com.obric.memorydata.plugin"));
    L139:
        if (f().o() == false) goto L149;
        CodeBlockConfig r85 = c().q();
        if (r85 == null) goto L143;
        boolean r86 = Intrinsics.areEqual(r85.getDisableReplacementSpan(), true);
    L144:
        if (r86 == true) goto L149;
        com.larus.business.markdown.api.model.c r87 = c();
        Context r88 = this.f5248a;
        Function0 r114 = (Function0) ZeusTransformUtils.preCheckCast(new MarkwonStruct$markwon$11$2(this), Function0.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.extplugin.a.a r115 = f().h();
        Integer r89 = d();
        if (r89 == null) goto L148;
        r24 = r89.intValue();
    L148:
        r83.a((io.noties.markwon.k) ZeusTransformUtils.preCheckCast(new com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.c(r87, r88, r114, r115, r24, b()), io.noties.markwon.k.class, "com.obric.memorydata.plugin"));
        goto L149
    L143:
        r86 = false;
    L149:
        io.noties.markwon.g r90 = r83.a();
        Intrinsics.checkNotNullExpressionValue(r90, "builderNoCore(context)\n …       }\n        .build()");
        this.m = r90;
        return;
    L127:
        if (r80.getEnableSyntaxHighlight() == true) goto L129;
        r81 = true;
        goto L130
    L117:
        if ((ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L119;
        r75 = true;
        goto L120
    L119:
        r75 = false;
        goto L120
    L99:
        r66 = false;
        goto L100
    L95:
        r62 = false;
        goto L96
    L91:
        r214 = false;
    L87:
        r56 = ContextCompat.getColor(r4, ZeusTransformUtils.mapRes(R.color.neutral_100, TypedValues.Custom.S_COLOR, "neutral_100"));
        goto L88
    L75:
        r52 = false;
    L81:
        r53 = com.larus.business.markdown.impl.common.utils.c.f();
    L67:
        r48 = com.larus.business.markdown.impl.common.utils.c.c();
    L61:
        r44 = com.larus.business.markdown.impl.common.utils.c.c();
    L55:
        r35 = com.larus.business.markdown.impl.common.utils.c.f();
    L49:
        r32 = com.larus.business.markdown.impl.common.utils.c.d();
    L43:
        r28 = com.larus.business.markdown.impl.common.utils.c.k();
    L34:
        r25 = d();
        if (r25 != null) goto L36;
        r110 = 0;
    L28:
        r21 = com.larus.business.markdown.impl.common.utils.c.a();
    L22:
        r17 = ContextCompat.getColor(r4, android.R.color.transparent);
    L16:
        r13 = ContextCompat.getColor(r4, ZeusTransformUtils.mapRes(R.color.neutral_transparent_2, TypedValues.Custom.S_COLOR, "neutral_transparent_2"));
    L10:
        r9 = ContextCompat.getColor(r4, ZeusTransformUtils.mapRes(R.color.neutral_transparent_2, TypedValues.Custom.S_COLOR, "neutral_transparent_2"));
        goto L11
    }

    public static final /* synthetic */ com.larus.business.markdown.impl.common.a a(g r0) {
        return r0.f5249b;
    }

    public static final /* synthetic */ Context b(g r0) {
        return r0.f5248a;
    }

    public static final /* synthetic */ com.larus.business.markdown.api.depend.i c(g r0) {
        return r0.k();
    }

    public static final /* synthetic */ com.larus.business.markdown.impl.common.utils.d d(g r0) {
        return r0.f();
    }

    public static final /* synthetic */ Function3 e(g r0) {
        return r0.j();
    }

    private final com.larus.business.markdown.impl.common.utils.d f() {
        return (com.larus.business.markdown.impl.common.utils.d) ZeusTransformUtils.preCheckCast(this.g.getValue(), com.larus.business.markdown.impl.common.utils.d.class, "com.obric.memorydata.plugin");
    }

    private final com.larus.business.markdown.api.b.c g() {
        return (com.larus.business.markdown.api.b.c) ZeusTransformUtils.preCheckCast(this.h.getValue(), com.larus.business.markdown.api.b.c.class, "com.obric.memorydata.plugin");
    }

    private final com.larus.business.markdown.api.b.b h() {
        return (com.larus.business.markdown.api.b.b) ZeusTransformUtils.preCheckCast(this.i.getValue(), com.larus.business.markdown.api.b.b.class, "com.obric.memorydata.plugin");
    }

    private final Rect i() {
        return (Rect) ZeusTransformUtils.preCheckCast(this.j.getValue(), Rect.class, "com.obric.memorydata.plugin");
    }

    private final Function3<View, String, Boolean, Unit> j() {
        return (Function3) ZeusTransformUtils.preCheckCast(this.k.getValue(), Function3.class, "com.obric.memorydata.plugin");
    }

    private final com.larus.business.markdown.api.depend.i k() {
        return (com.larus.business.markdown.api.depend.i) ZeusTransformUtils.preCheckCast(this.l.getValue(), com.larus.business.markdown.api.depend.i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.larus.business.markdown.api.model.e
    public io.noties.markwon.g a() {
        return this.m;
    }

    public boolean b() {
        return this.c;
    }

    public com.larus.business.markdown.api.model.c c() {
        return this.d;
    }

    public Integer d() {
        return this.e;
    }

    public Map<String, Object> e() {
        return this.f;
    }
}
