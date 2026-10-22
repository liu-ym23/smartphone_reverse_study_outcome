package io.noties.markwon.core;

import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.a.f;
import io.noties.markwon.core.a.g;
import io.noties.markwon.core.a.i;
import io.noties.markwon.core.a.m;
import io.noties.markwon.core.spans.j;
import io.noties.markwon.core.spans.o;
import io.noties.markwon.core.spans.t;
import io.noties.markwon.l;
import io.noties.markwon.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes6.dex */
public class a extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f16410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16411b;
    private final List<InterfaceC0858a> c;

    /* JADX INFO: renamed from: io.noties.markwon.core.a$a, reason: collision with other inner class name */
    public interface InterfaceC0858a {
        void a(n r1, Text r2, int r3);
    }

    public interface b {
        void a(n r1, String r2, int r3);
    }

    public a() {
        this.f16410a = new ArrayList(0);
        this.c = new ArrayList(0);
    }

    static /* synthetic */ List a(a r0) {
        return r0.f16410a;
    }

    static void a(n r4, String r5, String r6, Node r7) {
        n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
        r8.e(r7);
        int r0 = r8.f();
        r8.c().a(Typography.nbsp).a('\n').a(r8.a().c().a(r5, r6));
        r8.d();
        r8.c().a(Typography.nbsp);
        CoreProps.k.b(r8.b(), r5);
        r8.b(r7, r0);
        r8.f(r7);
    }

    static /* synthetic */ boolean a(Paragraph r0) {
        return c(r0);
    }

    static /* synthetic */ int b(Node r0) {
        return c(r0);
    }

    static /* synthetic */ List b(a r0) {
        return r0.c;
    }

    private void b(n.b r3) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r3, n.b.class, "com.obric.memorydata.plugin")).a(Text.class, new AnonymousClass1(this));
    }

    static /* synthetic */ boolean b(Paragraph r0) {
        return d(r0);
    }

    private static int c(Node r2) {
        Node r3 = r2.getParent();
        int r0 = 0;
    L3:
        if (r3 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, ListItem.class) == false) goto L7;
        r0 = r0 + 1;
    L7:
        r3 = r3.getParent();
        goto L3
    L8:
        return r0;
    }

    private static void c(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(StrongEmphasis.class, new AnonymousClass8());
    }

    private static boolean c(Paragraph r2) {
        Block r3 = r2.getParent();
        if (r3 == null) goto L8;
        Node r4 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r4, ListBlock.class) == true) goto L7;
        return false;
    L7:
        return ((ListBlock) ZeusTransformUtils.preCheckCast(r4, ListBlock.class, "com.obric.memorydata.plugin")).isTight();
    L8:
        return false;
    }

    private static void d(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(Emphasis.class, new AnonymousClass9());
    }

    private static boolean d(Paragraph r2) {
        Block r3 = r2.getParent();
        if (r3 == null) goto L8;
        Node r4 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r4, ListBlock.class) == true) goto L7;
        return false;
    L7:
        return !((ListBlock) ZeusTransformUtils.preCheckCast(r4, ListBlock.class, "com.obric.memorydata.plugin")).isTight();
    L8:
        return false;
    }

    private static void e(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(BlockQuote.class, new AnonymousClass10());
    }

    private static void f(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(Code.class, new AnonymousClass11());
    }

    private static void g(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(FencedCodeBlock.class, new AnonymousClass12());
    }

    private static void h(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(IndentedCodeBlock.class, new AnonymousClass13());
    }

    private static void i(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(Image.class, new AnonymousClass14());
    }

    private static void j(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(BulletList.class, new d());
    }

    private static void k(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(OrderedList.class, new d());
    }

    private static void l(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(ListItem.class, new AnonymousClass15());
    }

    private static void m(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(ThematicBreak.class, new AnonymousClass2());
    }

    private static void n(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(Heading.class, new AnonymousClass3());
    }

    private static void o(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(SoftLineBreak.class, new AnonymousClass4());
    }

    private static void p(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(HardLineBreak.class, new AnonymousClass5());
    }

    private static void q(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(Paragraph.class, new AnonymousClass6());
    }

    private static void r(n.b r2) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin")).a(Link.class, new AnonymousClass7());
    }

    public a a(InterfaceC0858a r3) {
        InterfaceC0858a r4 = (InterfaceC0858a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0858a.class, "com.obric.memorydata.plugin");
        this.c.add(r4);
        return this;
    }

    public a a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.f16410a.add(r4);
        return this;
    }

    public a a(boolean r1) {
        this.f16411b = r1;
        return this;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r1) {
        if (this.f16411b == false) goto L5;
        return;
    L5:
        if (r1.getMovementMethod() != null) goto L9;
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r2, Spanned r3) {
        Spanned r1 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin");
        o.a(r2, r1);
        if (ZeusTransformUtils.instanceOf(r1, Spannable.class) == false) goto L6;
        t.a((Spannable) ZeusTransformUtils.preCheckCast(r1, Spannable.class, "com.obric.memorydata.plugin"), r2);
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r5, Node r6, n r7) {
        n r8 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
        c r0 = r8.a().a();
        if (r0.i == 1.0f) goto L5;
    L6:
        r8.a(0, new j(r0.i, r0.j));
    L7:
        super.a(r5, r6, r8);
        return;
    L5:
        if (r0.j == 1.0f) goto L7;
        goto L6
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(l.a r3) {
        l.a r2 = (l.a) ZeusTransformUtils.wrapperContextForParams(r3, l.a.class, "com.obric.memorydata.plugin");
        io.noties.markwon.core.a.c r4 = new io.noties.markwon.core.a.c();
        r2.a(StrongEmphasis.class, new io.noties.markwon.core.a.l()).a(Emphasis.class, new f()).a(BlockQuote.class, new io.noties.markwon.core.a.b()).a(Code.class, new io.noties.markwon.core.a.d()).a(FencedCodeBlock.class, r4).a(IndentedCodeBlock.class, r4).a(ListItem.class, new io.noties.markwon.core.a.j()).a(Heading.class, new g()).a(Link.class, new i()).a(ThematicBreak.class, new m());
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(n.b r3) {
        n.b r4 = (n.b) ZeusTransformUtils.wrapperContextForParams(r3, n.b.class, "com.obric.memorydata.plugin");
        b(r4);
        c(r4);
        d(r4);
        e(r4);
        f(r4);
        g(r4);
        h(r4);
        i(r4);
        j(r4);
        k(r4);
        l(r4);
        m(r4);
        n(r4);
        o(r4);
        p(r4);
        q(r4);
        r(r4);
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(CharSequence r5, Node r6, n r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
        c r0 = r9.a().a();
        if (r0.i == 1.0f) goto L5;
    L6:
        r9.a(0, new j(r0.i, r0.j));
    L7:
        super.a(r8, r6, r9);
        return;
    L5:
        if (r0.j == 1.0f) goto L7;
        goto L6
    }
}
