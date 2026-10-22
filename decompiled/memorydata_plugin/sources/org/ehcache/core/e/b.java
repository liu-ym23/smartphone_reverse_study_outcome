package org.ehcache.core.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.ehcache.config.ResourceType;
import org.ehcache.core.spi.store.Store;
import org.ehcache.core.spi.store.d;
import org.ehcache.spi.service.c;
import org.ehcache.spi.service.g;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    private static class a<X, Y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final X f18025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Y f18026b;

        a(X r1, Y r2) {
            this.f18025a = r1;
            this.f18026b = r2;
        }
    }

    private static /* synthetic */ a a(Collection r2, d.a r3) {
        Collection<org.ehcache.spi.service.d<?, ?>> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        d.a r5 = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.memorydata.plugin");
        return new a(Integer.valueOf(r5.a(r4)), r5);
    }

    public static Store.c a(g<c> r2, Collection<org.ehcache.spi.service.d<?, ?>> r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        final Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return (Store.c) ZeusTransformUtils.preCheckCast(r4.b(d.a.class).stream().map(new $$Lambda$b$_E64QVxXCtQQ0Gl9xGT8JInMHvc(r5)).filter($$Lambda$b$fm9K1sK1Qn6osM0ZB71vdtqO_hw.INSTANCE).max(Comparator.comparingInt($$Lambda$b$jikZc7AKfV2EGSwaM_Gvi_qCqoY.INSTANCE)).map($$Lambda$b$EHbbtHBkVTM6Dc1NCYgwm2BX8IA.INSTANCE).orElse(null), Store.c.class, "com.obric.memorydata.plugin");
    }

    public static Store.c a(g<c> r7, Set<ResourceType<?>> r8, Collection<org.ehcache.spi.service.d<?, ?>> r9) {
        g r10 = (g) ZeusTransformUtils.wrapperContextForParams(r7, g.class, "com.obric.memorydata.plugin");
        Set<ResourceType<?>> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Collection<org.ehcache.spi.service.d<?, ?>> r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.preCheckCast(r10.b(Store.c.class).stream().filter($$Lambda$b$gsbFiq13Tki39nz6nDJeu_ZtiS4.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r2 = r13.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L12;
        Store.c r5 = (Store.c) ZeusTransformUtils.preCheckCast(r2.next(), Store.c.class, "com.obric.memorydata.plugin");
        int r6 = r5.a(r11, r12);
        if (r6 > r4) goto L7;
        if (r6 == 0) goto L4;
        if (r6 != r4) goto L4;
        r0.add(r5);
        goto L4
    L7:
        r0.clear();
        r0.add(r5);
        r4 = r6;
        goto L4
    L12:
        if (r0.isEmpty() == false) goto L14;
        StringBuilder r14 = new StringBuilder("No Store.Provider found to handle configured resource types ");
        r14.append(r11);
        r14.append(" from ");
        a(r13, r14);
        throw new IllegalStateException(r14.toString());
    L14:
        if (r0.size() <= 1) goto L16;
        StringBuilder r15 = new StringBuilder("Multiple Store.Providers found to handle configured resource types ");
        r15.append(r11);
        r15.append(": ");
        a(r0, r15);
        throw new IllegalStateException(r15.toString());
    L16:
        return (Store.c) ZeusTransformUtils.preCheckCast(r0.get(0), Store.c.class, "com.obric.memorydata.plugin");
    }

    private static /* synthetic */ d.a a(a r2) {
        return (d.a) ZeusTransformUtils.preCheckCast(r2.f18026b, d.a.class, "com.obric.memorydata.plugin");
    }

    private static void a(Collection<Store.c> r4, StringBuilder r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        r5.append('{');
        Iterator r7 = r6.iterator();
        boolean r0 = false;
    L4:
        if (r7.hasNext() == false) goto L10;
        Store.c r2 = (Store.c) ZeusTransformUtils.preCheckCast(r7.next(), Store.c.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L8;
        r5.append(", ");
    L9:
        r5.append(r2.getClass().getName());
        goto L4
    L8:
        r0 = true;
        goto L9
    L10:
        r5.append('}');
    }

    private static /* synthetic */ boolean a(Store.c r2) {
        return !ZeusTransformUtils.instanceOf((Store.c) ZeusTransformUtils.wrapperContextForParams(r2, Store.c.class, "com.obric.memorydata.plugin"), d.a.class);
    }

    private static /* synthetic */ int b(a r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(r2.f18025a, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    private static /* synthetic */ boolean c(a r2) {
        if (((Integer) ZeusTransformUtils.preCheckCast(r2.f18025a, Integer.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ d.a lambda$EHbbtHBkVTM6Dc1NCYgwm2BX8IA(a r0) {
        return a(r0);
    }

    public static /* synthetic */ a lambda$_E64QVxXCtQQ0Gl9xGT8JInMHvc(Collection r0, d.a r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$fm9K1sK1Qn6osM0ZB71vdtqO_hw(a r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$gsbFiq13Tki39nz6nDJeu_ZtiS4(Store.c r0) {
        return a(r0);
    }

    public static /* synthetic */ int lambda$jikZc7AKfV2EGSwaM_Gvi_qCqoY(a r0) {
        return b(r0);
    }
}
