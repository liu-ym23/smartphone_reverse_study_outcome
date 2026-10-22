package com.larus.business.markdown.impl.markwon.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.a.k;
import io.noties.markwon.i;
import io.noties.markwon.n;
import io.noties.markwon.q;
import io.noties.markwon.t;
import io.noties.markwon.w;
import io.noties.markwon.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Document;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/ListItemVisitor;", "Lio/noties/markwon/MarkwonVisitor$NodeVisitor;", "Lorg/commonmark/node/ListItem;", "isMarkdownListBlockOptimized", "", "listItemSpaceHeight", "", "blockQuoteConfig", "Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "(ZLjava/lang/Integer;Lcom/larus/business/markdown/api/model/BlockQuoteConfig;)V", "Ljava/lang/Integer;", "visit", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "listItem", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements n.c<ListItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5199b;
    private final Integer c;
    private final com.larus.business.markdown.api.model.a d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/ListItemVisitor$Companion;", "", "()V", "listLevel", "", "node", "Lorg/commonmark/node/Node;", "listRealLevel", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0, Node r1) {
            return r0.a(r1);
        }

        private final int a(Node r2) {
            Node r1 = r2.parent;
            int r3 = 0;
        L3:
            if (r1 == null) goto L8;
            if (ZeusTransformUtils.instanceOf(r1, ListItem.class) == false) goto L7;
            r3 = r3 + 1;
        L7:
            r1 = r1.parent;
            goto L3
        L8:
            return r3;
        }

        public static final /* synthetic */ int b(a r0, Node r1) {
            return r0.b(r1);
        }

        private final int b(Node r4) {
            Node r3 = r4.parent;
            int r0 = 0;
        L3:
            Node r2 = r4;
            r4 = r3;
            if (ZeusTransformUtils.instanceOf(r4, Document.class) == true) goto L10;
            if (ZeusTransformUtils.instanceOf(r4, ListItem.class) == false) goto L8;
            r0 = r0 + 1;
        L8:
            Intrinsics.checkNotNullExpressionValue(r4, "parent");
            r3 = r4.parent;
            goto L3
        L10:
            if (ZeusTransformUtils.instanceOf(r2, ListBlock.class) == true) goto L12;
            return r0;
        L12:
            return r0 + (io.noties.markwon.core.b.a.a((ListBlock) ZeusTransformUtils.preCheckCast(r2, ListBlock.class, "com.obric.memorydata.plugin")) / Parsing.CODE_BLOCK_INDENT);
        }
    }

    static {
        f5198a = new a(null);
    }

    public b() {
        this(false, null, null, 7, null);
    }

    public b(boolean r1, Integer r2, com.larus.business.markdown.api.model.a r3) {
        this.f5199b = r1;
        this.c = r2;
        this.d = r3;
    }

    public /* synthetic */ b(boolean r2, Integer r3, com.larus.business.markdown.api.model.a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public void a(n r12, ListItem r13) {
        n r14 = (n) ZeusTransformUtils.wrapperContextForParams(r12, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "visitor");
        Intrinsics.checkNotNullParameter(r13, "listItem");
        boolean r2 = false;
        if (r13.extraInfoMap.get("start_self") != null) goto L5;
        boolean r0 = true;
    L6:
        Integer r4 = this.c;
        if (r4 == null) goto L15;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.getPrevious() == null) goto L11;
    L14:
        r14.d();
        int r6 = r14.f();
        r14.c().a(8203);
        r14.a(r6, io.noties.markwon.f.a.f16541a.b(r5));
        r14.d();
        goto L15
    L11:
        if (ZeusTransformUtils.instanceOf(r13.parent.parent, Document.class) == true) goto L15;
        if (r13.parent.getPrevious() != null) goto L14;
    L15:
        int r7 = r14.f();
        r14.c((Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"));
        q<Integer> r8 = CoreProps.f16409b;
        t r9 = r14.b();
        a r10 = f5198a;
        r8.b(r9, Integer.valueOf(a.a(r10, (Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"))));
        q<Integer> r11 = CoreProps.c;
        t r15 = r14.b();
        if (this.f5199b == false) goto L18;
        int r16 = a.b(r10, (Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"));
    L19:
        r11.b(r15, Integer.valueOf(r16));
        Node r17 = r13.parent;
        Intrinsics.checkNotNullExpressionValue(r17, "listItem.parent");
        CoreProps.e.b(r14.b(), Boolean.valueOf(r0));
        x r18 = null;
        if (ZeusTransformUtils.instanceOf(r17, OrderedList.class) == false) goto L29;
        Object r1 = r13.extraInfoMap.get("order_number");
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L24;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin");
    L25:
        if (r3 == null) goto L27;
        int r19 = r3.intValue();
    L28:
        CoreProps.f16408a.b(r14.b(), CoreProps.ListItemType.ORDERED);
        CoreProps.d.b(r14.b(), Integer.valueOf(r19));
        ((OrderedList) ZeusTransformUtils.preCheckCast(r17, OrderedList.class, "com.obric.memorydata.plugin")).setStartNumber(r19 + 1);
    L30:
        int r20 = r14.c().length();
        if (ZeusTransformUtils.instanceOf(r13.firstChild, ListBlock.class) == false) goto L40;
    L32:
        if (r7 >= r20) goto L38;
        if (r14.c().charAt(r7) == 8203) goto L37;
        if (r14.c().charAt(r7) != '\n') goto L38;
    L37:
        r7 = r7 + 1;
    L38:
        if (r7 < r20) goto L40;
        return;
    L40:
        com.larus.business.markdown.api.model.a r21 = this.d;
        if (r21 != null) goto L43;
    L45:
        if (r2 == false) goto L54;
        w r22 = r14.a().f().a(r13.getClass());
        if (ZeusTransformUtils.instanceOf(r22, k.class) == false) goto L49;
        k r23 = (k) ZeusTransformUtils.preCheckCast(r22, k.class, "com.obric.memorydata.plugin");
    L50:
        if (r23 == null) goto L52;
        x r24 = r14.c();
        i r25 = r14.a();
        Intrinsics.checkNotNullExpressionValue(r25, "visitor.configuration()");
        t r26 = r14.b();
        Intrinsics.checkNotNullExpressionValue(r26, "visitor.renderProps()");
        r18 = r24.a(r23.a(r25, r26, this.d, (Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin")), r7);
    L52:
        if (r18 != null) goto L56;
        b r110 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    L56:
        if (r14.d((Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin")) == false) goto L63;
        r14.d();
        return;
    L63:
        return;
    L49:
        r23 = null;
    L54:
        r14.b((Node) ZeusTransformUtils.preCheckCast(r13, Node.class, "com.obric.memorydata.plugin"), r7);
        goto L56
    L43:
        if (r21.a() != true) goto L45;
        r2 = true;
        goto L45
    L27:
        r19 = ((OrderedList) ZeusTransformUtils.preCheckCast(r17, OrderedList.class, "com.obric.memorydata.plugin")).getStartNumber();
        goto L28
    L24:
        r3 = null;
        goto L25
    L29:
        CoreProps.f16408a.b(r14.b(), CoreProps.ListItemType.BULLET);
        goto L30
    L18:
        r16 = 0;
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    @Override // io.noties.markwon.n.c
    public /* synthetic */ void a(n r3, Node r4) {
        a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (ListItem) ZeusTransformUtils.preCheckCast(r4, ListItem.class, "com.obric.memorydata.plugin"));
    }
}
