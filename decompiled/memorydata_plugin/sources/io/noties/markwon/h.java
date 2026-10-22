package io.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
class h implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f16548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k> f16549b;
    private TextView.BufferType c;
    private g.b d;
    private io.noties.markwon.b.a e;
    private boolean f;

    h(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.f16549b = new ArrayList(3);
        this.c = TextView.BufferType.SPANNABLE;
        this.f = true;
        this.f16548a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    private static List<k> a(List<k> r2) {
        return new r((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // io.noties.markwon.g.a
    public g.a a(io.noties.markwon.b.a r3) {
        this.e = (io.noties.markwon.b.a) ZeusTransformUtils.wrapperContextForParams(r3, io.noties.markwon.b.a.class, "com.obric.memorydata.plugin");
        return this;
    }

    @Override // io.noties.markwon.g.a
    public g.a a(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        this.f16549b.add(r4);
        return this;
    }

    @Override // io.noties.markwon.g.a
    public g.a a(Iterable<? extends k> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r0);
        this.f16549b.add(r0);
        goto L4
    L6:
        return this;
    }

    @Override // io.noties.markwon.g.a
    public g a() {
        if (this.f16549b.isEmpty() == true) goto L11;
        List<k> r0 = a(this.f16549b);
        Parser.Builder r1 = new Parser.Builder();
        io.noties.markwon.core.c.a r2 = io.noties.markwon.core.c.a(this.f16548a);
        i.a r3 = new i.a();
        p.a r4 = new p.a();
        m.a r5 = new m.a();
        Iterator<k> r6 = r0.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        k r7 = (k) ZeusTransformUtils.preCheckCast(r6.next(), k.class, "com.obric.memorydata.plugin");
        r7.a(r1);
        r7.a(r2);
        r7.a(r3);
        r7.a(r4);
        r7.a(r5);
        goto L6
    L8:
        i r11 = r3.a(r2.a(), r5.a());
        o r10 = o.a(r4, r11);
        return new j(this.c, this.d, r1.build(), r10, r11, Collections.unmodifiableList(r0), this.f, this.e);
    L11:
        throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
    }
}
