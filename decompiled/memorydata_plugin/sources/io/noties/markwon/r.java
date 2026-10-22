package io.noties.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
class r implements k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<k> f16662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k> f16663b;
    private final Set<k> c;

    r(List<k> r3) {
        List<k> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f16662a = r4;
        this.f16663b = new ArrayList(r4.size());
        this.c = new HashSet(3);
    }

    private static <P extends k> P a(List<k> r3, Class<P> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        P r0 = (P) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.memorydata.plugin");
        if (r4.isAssignableFrom(r0.getClass()) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private void a(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        if (this.f16663b.contains(r4) == false) goto L5;
        return;
    L5:
        if (this.c.contains(r4) == true) goto L13;
        this.c.add(r4);
        r4.a(this);
        this.c.remove(r4);
        if (this.f16663b.contains(r4) == true) goto L15;
        boolean r0 = io.noties.markwon.core.a.class.isAssignableFrom(r4.getClass());
        List<k> r2 = this.f16663b;
        if (r0 == false) goto L11;
        r2.add(0, r4);
        return;
    L11:
        r2.add(r4);
        return;
    L15:
        return;
    L13:
        throw new IllegalStateException("Cyclic dependency chain found: " + this.c);
    }

    private <P extends k> P b(Class<P> r4) {
        P r0 = (P) a(this.f16663b, r4);
        if (r0 != null) goto L9;
        r0 = (P) a(this.f16662a, r4);
        if (r0 == null) goto L8;
        a(r0);
        goto L9
    L8:
        throw new IllegalStateException("Requested plugin is not added: " + r4.getName() + ", plugins: " + this.f16662a);
    L9:
        return r0;
    }

    @Override // io.noties.markwon.k.b
    public <P extends k> P a(Class<P> r1) {
        return (P) b(r1);
    }

    List<k> a() {
        Iterator<k> r0 = this.f16662a.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        a((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return this.f16663b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.noties.markwon.k.b
    public <P extends k> void a(Class<P> r3, k.a<? super P> r4) {
        ((k.a) ZeusTransformUtils.wrapperContextForParams(r4, k.a.class, "com.obric.memorydata.plugin")).a(b(r3));
    }
}
