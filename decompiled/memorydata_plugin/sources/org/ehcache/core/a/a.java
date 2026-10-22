package org.ehcache.core.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.ehcache.config.d;
import org.ehcache.config.g;
import org.ehcache.core.a.a;
import org.ehcache.spi.service.e;

/* JADX INFO: loaded from: classes7.dex */
public class a<B extends a<B>> implements g<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, org.ehcache.config.b<?, ?>> f18004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<e<?, ?>> f18005b;
    private final ClassLoader c;

    public a() {
        this.f18004a = Collections.emptyMap();
        this.f18005b = Collections.emptyList();
        this.c = null;
    }

    public a(a<?> r3, Collection<e<?, ?>> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        this.f18004a = r3.f18004a;
        this.f18005b = Collections.unmodifiableCollection(r5);
        this.c = r3.c;
    }

    private static /* synthetic */ boolean a(e r2, e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        e<?, ?> r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        if (r5.a(r4) == true) goto L5;
    L8:
        return true;
    L5:
        if (r4.a(r5) == false) goto L8;
        return false;
    }

    public static /* synthetic */ boolean lambda$OpgildxqJ0x3sU5qJUtrY1noXZA(e r0, e r1) {
        return a(r0, r1);
    }

    @Override // org.ehcache.config.a
    public /* synthetic */ d a() {
        return c();
    }

    @Override // org.ehcache.config.g
    public /* synthetic */ g a(e r3) {
        return b((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin"));
    }

    public B b(Collection<e<?, ?>> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (getClass().equals(a.class) == false) goto L7;
        return (B) new a(this, r4);
    L7:
        throw new AssertionError();
    }

    public B b(e<?, ?> r3) {
        final e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(this.f18005b);
        r0.removeIf(new $$Lambda$a$OpgildxqJ0x3sU5qJUtrY1noXZA(r4));
        r0.add(r4);
        return (B) b(r0);
    }

    public d c() {
        Map<String, org.ehcache.config.b<?, ?>> r1 = this.f18004a;
        ClassLoader r2 = this.c;
        Collection<e<?, ?>> r5 = this.f18005b;
        return new b(r1, r2, (e[]) ZeusTransformUtils.preCheckCast(r5.toArray(new e[r5.size()]), e[].class, "com.obric.memorydata.plugin"));
    }
}
