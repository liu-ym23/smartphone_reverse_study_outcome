package io.noties.markwon.core;

import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.a.g;
import io.noties.markwon.core.spans.h;
import io.noties.markwon.i;
import io.noties.markwon.n;
import io.noties.markwon.q;
import io.noties.markwon.t;
import io.noties.markwon.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/core/CorePlugin2;", "Lio/noties/markwon/core/CorePlugin;", "()V", "afterRender", "", "textView", "Landroid/widget/TextView;", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "reuseCharSequence", "", "configureVisitor", "builder", "Lio/noties/markwon/MarkwonVisitor$Builder;", "getImageSizeFromUrl", "Lio/noties/markwon/image/ImageSize;", "url", "", "image", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends io.noties.markwon.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q<String> f16426b = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/core/CorePlugin2$Companion;", "", "()V", "LINK_TITLE", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getLINK_TITLE", "()Lio/noties/markwon/Prop;", "setCommonLineHeight", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "loading", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final q<String> a() {
            return b.a();
        }

        public final void a(n r5, boolean r6) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "visitor");
            io.noties.markwon.core.c r7 = r4.a().a();
            Intrinsics.checkNotNullExpressionValue(r7, "visitor.configuration().theme()");
            boolean r2 = true;
            if (r7.i != 1.0f) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
        L12:
            r4.a(0, new h(r7.i, r7.j, r6));
            return;
        L8:
            if (r7.j == 1.0f) goto L11;
            r2 = false;
        L11:
            if (r2 == false) goto L12;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: io.noties.markwon.core.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "link", "Lorg/commonmark/node/Link;", "visit"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C0859b<N extends Node> implements n.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0859b<N> f16427a = null;

        static {
            f16427a = new C0859b();
        }

        C0859b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(n r7, Link r8) {
            n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "visitor");
            Intrinsics.checkNotNullParameter(r8, "link");
            int r9 = r6.f();
            r6.c((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"));
            CoreProps.g.b(r6.b(), r8.getDestination());
            q<String> r1 = b.f16425a.a();
            t r2 = r6.b();
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.getTitle(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == true) goto L11;
            String r5 = r8.getTitle();
        L20:
            r1.b(r2, r5);
            r6.b((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"), r9);
            return;
        L11:
            Node r10 = r8.firstChild;
            if (ZeusTransformUtils.instanceOf(r10, Text.class) == false) goto L14;
            Text r11 = (Text) ZeusTransformUtils.preCheckCast(r10, Text.class, "com.obric.memorydata.plugin");
        L15:
            if (r11 == null) goto L17;
            r5 = r11.getLiteral();
        L18:
            if (r5 != null) goto L20;
            r5 = "";
            goto L20
        L17:
            r5 = null;
            goto L18
        L14:
            r11 = null;
            goto L15
        L5:
            if (StringsKt.isBlank(r3) == true) goto L8;
            r4 = false;
            goto L9
        }

        @Override // io.noties.markwon.n.c
        public /* synthetic */ void a(n r3, Node r4) {
            a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (Link) ZeusTransformUtils.preCheckCast(r4, Link.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "image", "Lorg/commonmark/node/Image;", "visit"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c<N extends Node> implements n.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f16428a;

        c(b r1) {
            this.f16428a = r1;
        }

        public final void a(n r7, Image r8) {
            n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "visitor");
            Intrinsics.checkNotNullParameter(r8, "image");
            w r0 = r9.a().f().a(Image.class);
            if (r0 != null) goto L6;
            r9.c((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"));
            return;
        L6:
            int r2 = r9.f();
            r9.c((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin"));
            if (r2 != r9.f()) goto L9;
            r9.c().a(65532);
        L9:
            i r1 = r9.a();
            Intrinsics.checkNotNullExpressionValue(r1, "visitor.configuration()");
            Node r3 = r8.parent;
            Intrinsics.checkNotNullExpressionValue(r3, "image.parent");
            boolean r4 = ZeusTransformUtils.instanceOf(r3, Link.class);
            String r10 = r1.e().a(r8.getDestination());
            Intrinsics.checkNotNullExpressionValue(r10, "configuration\n          …rocess(image.destination)");
            t r5 = r9.b();
            Intrinsics.checkNotNullExpressionValue(r5, "visitor.renderProps()");
            g.f16398a.b(r5, r10);
            g.f16399b.b(r5, Boolean.valueOf(r4));
            g.c.b(r5, b.a(this.f16428a, r10));
            g.d.b(r5, Integer.valueOf(r2));
            g.e.b(r5, Integer.valueOf(r9.c().length()));
            r9.a(r2, r0.a(r1, r5));
        }

        @Override // io.noties.markwon.n.c
        public /* synthetic */ void a(n r3, Node r4) {
            a((n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), (Image) ZeusTransformUtils.preCheckCast(r4, Image.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f16425a = new a(null);
        q<String> r0 = q.a("link-title");
        Intrinsics.checkNotNullExpressionValue(r0, "of<String>(\"link-title\")");
        f16426b = r0;
    }

    public b() {
    }

    public static final /* synthetic */ io.noties.markwon.a.h a(b r0, String r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ q a() {
        return f16426b;
    }

    private final io.noties.markwon.a.h b(String r9) {
        Matcher r8 = Pattern.compile(":(\\d+):(\\d+):(\\d+):(\\d+):(\\d+):(\\d+)").matcher((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r8.find() == false) goto L20;
        String r10 = r8.group();
        Intrinsics.checkNotNullExpressionValue(r10, "extracted");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Integer r2 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L6;
        r12.add(r2);
        goto L6
    L10:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        if (r14.size() >= 4) goto L13;
        return null;
    L13:
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r14.get(2), Number.class, "com.obric.memorydata.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r14.get(0), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r14.get(3), Number.class, "com.obric.memorydata.plugin")).intValue() - ((Number) ZeusTransformUtils.preCheckCast(r14.get(1), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r15 <= 0) goto L19;
        if (r3 <= 0) goto L19;
        return new io.noties.markwon.a.h(new io.noties.markwon.a.h.a(r15, "px"), new io.noties.markwon.a.h.a(r3, "px"));
    L19:
        return (io.noties.markwon.a.h) ZeusTransformUtils.preCheckCast(null, io.noties.markwon.a.h.class, "com.obric.memorydata.plugin");
    L20:
        return null;
    }

    private final void b(n.b r4) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r4, n.b.class, "com.obric.memorydata.plugin")).a(Image.class, (n.c) ZeusTransformUtils.preCheckCast(new c(this), n.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.core.a, io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r2, Node r3, n r4) {
        n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "node");
        Intrinsics.checkNotNullParameter(r5, "visitor");
        a(r3, r5);
    }

    @Override // io.noties.markwon.core.a, io.noties.markwon.a, io.noties.markwon.k
    public void a(n.b r5) {
        n.b r6 = (n.b) ZeusTransformUtils.wrapperContextForParams(r5, n.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "builder");
        super.a(r6);
        r6.a(Link.class, (n.c) ZeusTransformUtils.preCheckCast(C0859b.f16427a, n.c.class, "com.obric.memorydata.plugin"));
        b(r6);
    }

    @Override // io.noties.markwon.core.a, io.noties.markwon.a, io.noties.markwon.k
    public void a(CharSequence r3, Node r4, n r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "node");
        Intrinsics.checkNotNullParameter(r7, "visitor");
        a(r4, r7);
    }
}
