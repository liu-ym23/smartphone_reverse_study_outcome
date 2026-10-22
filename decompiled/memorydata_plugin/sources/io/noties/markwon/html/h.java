package io.noties.markwon.html;

import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class h extends io.noties.markwon.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final p.a f16567b;
    protected final a c;
    protected m d;
    protected o e;
    protected g f;

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, u> f16570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f16571b;
        private final Set<String> c;
        private boolean d;
        private boolean e;

        public a() {
            this.f16570a = new HashMap(2);
            this.f16571b = new HashSet();
            this.c = new HashSet();
        }

        static /* synthetic */ Set a(a r0) {
            return r0.f16571b;
        }

        static /* synthetic */ Set b(a r0) {
            return r0.c;
        }

        private void c() {
            if (this.e == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Builder has been already built");
        }

        void a(u r5) {
            c();
            Iterator<String> r0 = r5.b().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
            this.f16570a.put(r1, r5);
            goto L4
        }

        boolean a() {
            return this.d;
        }

        Map<String, u> b() {
            c();
            this.e = true;
            return Collections.unmodifiableMap(this.f16570a);
        }

        void b(u r5) {
            Iterator<String> r0 = r5.b().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
            if (this.f16570a.containsKey(r1) == true) goto L4;
            this.f16570a.put(r1, r5);
            goto L4
        }
    }

    public h() {
        this.f = new g();
        this.f16567b = new p.a();
        this.c = new a();
    }

    public h a(u r2) {
        this.c.a(r2);
        return this;
    }

    public h a(Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        a.a(this.c).addAll(r4);
        return this;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(TextView r1, Node r2, io.noties.markwon.n r3) {
        io.noties.markwon.n r4 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        o r5 = this.e;
        if (r5 == null) goto L7;
        r5.a(r4, this.d);
        return;
    L7:
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(io.noties.markwon.i.a r5) {
        p.a r6 = this.f16567b;
        if (this.c.a() == true) goto L5;
        this.c.b(io.noties.markwon.html.tag.e.a());
        this.c.b(new io.noties.markwon.html.tag.g());
        this.c.b(new io.noties.markwon.html.tag.a());
        this.c.b(new io.noties.markwon.html.tag.l());
        this.c.b(new io.noties.markwon.html.tag.m());
        this.c.b(new io.noties.markwon.html.tag.k());
        this.c.b(new io.noties.markwon.html.tag.j());
        this.c.b(new io.noties.markwon.html.tag.n());
        this.c.b(new io.noties.markwon.html.tag.h());
        this.c.b(new io.noties.markwon.html.tag.b());
        this.c.b(new io.noties.markwon.html.tag.c());
    L5:
        Map<String, u> r0 = this.c.b();
        this.d = n.a(this.f, r0, a.a(this.c), a.b(this.c));
        this.e = r6.a(r0).a();
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(io.noties.markwon.n.b r3) {
        ((io.noties.markwon.n.b) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.b.class, "com.obric.memorydata.plugin")).a(HtmlBlock.class, new AnonymousClass2(this)).a(HtmlInline.class, new AnonymousClass1(this));
    }

    public void a(io.noties.markwon.n r3, String r4) {
        io.noties.markwon.n r5 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.d.a(r5.c(), r4);
        return;
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(CharSequence r2, Node r3, io.noties.markwon.n r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        io.noties.markwon.n r6 = (io.noties.markwon.n) ZeusTransformUtils.wrapperContextForParams(r4, io.noties.markwon.n.class, "com.obric.memorydata.plugin");
        o r7 = this.e;
        if (r7 == null) goto L7;
        r7.a(r6, this.d);
        return;
    L7:
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    public h b(Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        a.b(this.c).addAll(r4);
        return this;
    }
}
