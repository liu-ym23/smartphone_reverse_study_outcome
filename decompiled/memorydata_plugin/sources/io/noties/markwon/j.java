package io.noties.markwon;

import android.os.Looper;
import android.text.Spanned;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
class j extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView.BufferType f16639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parser f16640b;
    private final io.noties.markwon.b.a c;
    private final o d;
    private final i e;
    private final List<k> f;
    private final g.b g;
    private final boolean h;

    j(TextView.BufferType r3, g.b r4, Parser r5, o r6, i r7, List<k> r8, boolean r9, io.noties.markwon.b.a r10) {
        g.b r11 = (g.b) ZeusTransformUtils.wrapperContextForParams(r4, g.b.class, "com.obric.memorydata.plugin");
        List<k> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        io.noties.markwon.b.a r13 = (io.noties.markwon.b.a) ZeusTransformUtils.wrapperContextForParams(r10, io.noties.markwon.b.a.class, "com.obric.memorydata.plugin");
        this.f16639a = r3;
        this.g = r11;
        this.f16640b = r5;
        this.d = r6;
        this.e = r7;
        this.f = r12;
        this.h = r9;
        this.c = r13;
    }

    static /* synthetic */ List a(j r0) {
        return r0.f;
    }

    @Override // io.noties.markwon.g
    public Spanned a(Node r2) {
        return a(r2, null);
    }

    public Spanned a(Node r2, TextView r3) {
        return a(r2, r3, null);
    }

    @Override // io.noties.markwon.g
    public Spanned a(Node r6, TextView r7, s r8) {
        s r9 = (s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.memorydata.plugin");
        Iterator<k> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).a(r7, r6);
        goto L4
    L6:
        n r1 = this.d.a();
        if (r9 == null) goto L9;
        CoreProps.j.b(r1.b(), new HashMap());
    L9:
        r6.accept(r1);
        Iterator<k> r5 = this.f.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        ((k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.memorydata.plugin")).a(r7, r6, r1);
        goto L11
    L13:
        if (r9 == null) goto L16;
        r9.a((HashMap) ZeusTransformUtils.preCheckCast(CoreProps.j.a(r1.b()), HashMap.class, "com.obric.memorydata.plugin"));
    L16:
        return r1.c().b();
    }

    @Override // io.noties.markwon.g
    public Spanned a(Node r6, CharSequence r7, s r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        s r10 = (s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.memorydata.plugin");
        Iterator<k> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).a(r9, r6);
        goto L4
    L6:
        n r1 = this.d.a();
        if (r10 == null) goto L9;
        CoreProps.j.b(r1.b(), new HashMap());
    L9:
        r6.accept(r1);
        Iterator<k> r5 = this.f.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        ((k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.memorydata.plugin")).a(r9, r6, r1);
        goto L11
    L13:
        if (r10 == null) goto L16;
        r10.a((HashMap) ZeusTransformUtils.preCheckCast(CoreProps.j.a(r1.b()), HashMap.class, "com.obric.memorydata.plugin"));
    L16:
        return r1.c().b();
    }

    @Override // io.noties.markwon.g
    public Node a(String r5, boolean r6) {
        Iterator<k> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r5 = ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).a(r5);
        goto L4
    L7:
        if (this.c == null) goto L19;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L13;
        return this.c.a(r5, r6);
    L13:
        if (this.c.a() == false) goto L17;
        return this.c.a(r5, r6);
    L17:
        return this.f16640b.parse(r5);
    L19:
        return this.f16640b.parse(r5);
    }

    @Override // io.noties.markwon.g
    public void a(final TextView r12, Spanned r13, v r14) {
        Spanned r15 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r13, Spanned.class, "com.obric.memorydata.plugin");
        final v r16 = (v) ZeusTransformUtils.wrapperContextForParams(r14, v.class, "com.obric.memorydata.plugin");
        final long r8 = System.currentTimeMillis();
        Iterator<k> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin")).a(r12, r15);
        goto L4
    L6:
        final long r6 = System.currentTimeMillis();
        g.b r1 = this.g;
        if (r1 == null) goto L9;
        r1.a(r12, r15, this.f16639a, new AnonymousClass1(this, r12, r16, r6, r8));
        return;
    L9:
        r12.setText(r15, this.f16639a);
        long r2 = System.currentTimeMillis();
        Iterator<k> r11 = this.f.iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        ((k) ZeusTransformUtils.preCheckCast(r11.next(), k.class, "com.obric.memorydata.plugin")).a(r12);
        goto L11
    L13:
        long r17 = System.currentTimeMillis();
        if (r16 == null) goto L20;
        r16.a(r6 - r8, r2 - r6, r17 - r2);
        return;
    }
}
