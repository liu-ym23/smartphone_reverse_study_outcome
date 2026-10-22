package com.lark.kmp.containerization;

import buc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class Container implements b {
    public final b a;
    public final e<Map<KClass<?>, ServiceEntry>> b;
    public final e<Map<KClass<?>, List<ServiceEntry.LazyFactory>>> c;

    public static abstract class ServiceEntry {

        public static final class LazyFactory extends ServiceEntry {
            public final Function0<Object> a;
            public final Lazy b;

            public LazyFactory(Function0<? extends Object> r10) {
                Intrinsics.checkNotNullParameter(r10, "factory");
                this.a = r10;
                this.b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Container$ServiceEntry$LazyFactory$instance$2(this));
            }
        }

        public static final class a extends ServiceEntry {
        }

        public ServiceEntry() {
        }
    }

    public Container(b r1) {
        this.a = r1;
        this.b = buc.b.d(MapsKt.emptyMap());
        this.c = buc.b.d(MapsKt.emptyMap());
    }

    @Override // com.lark.kmp.containerization.b
    public final <T> T a(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "symbol");
        ServiceEntry r0 = (ServiceEntry) ((Map) this.b.c()).get(r10);
        if (r0 != null) goto L5;
        b r1 = this.a;
        if (r1 != null) goto L16;
        return null;
    L16:
        return (T) r1.a(r10);
    L5:
        if ((r0 instanceof ServiceEntry.a) == false) goto L8;
        ServiceEntry.a r11 = (ServiceEntry.a) r0;
        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type T of com.lark.kmp.containerization.Container.get");
        return null;
    L8:
        if ((r0 instanceof ServiceEntry.LazyFactory) == false) goto L12;
        T r12 = (T) ((ServiceEntry.LazyFactory) r0).b.getValue();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of com.lark.kmp.containerization.Container.get");
        return r12;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.lark.kmp.containerization.b
    public final <T> List<T> b(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "symbol");
        List r0 = (List) ((Map) this.c.c()).get(r10);
        if (r0 == null) goto L8;
        List r1 = r0;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r12 = r1.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        Object r13 = ((ServiceEntry.LazyFactory) r12.next()).b.getValue();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type T of com.lark.kmp.containerization.Container.getAll");
        r11.add(r13);
        goto L6
    L15:
        return r11;
    L8:
        b r14 = this.a;
        if (r14 == null) goto L12;
        return r14.b(r10);
    L12:
        return CollectionsKt.emptyList();
    }

    @Override // com.lark.kmp.containerization.b
    public final <T> void c(KClass<T> r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "symbol");
        Intrinsics.checkNotNullParameter(r11, "factory");
        e<Map<KClass<?>, ServiceEntry>> r0 = this.b;
    L3:
        Object r1 = r0.c();
        if (r0.a(r1, MapsKt.plus((Map) r1, TuplesKt.to(r10, new ServiceEntry.LazyFactory(r11)))) == false) goto L3;
    }
}
