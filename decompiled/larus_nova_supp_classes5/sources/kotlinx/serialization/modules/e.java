package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import juc.n;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import nuc.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e implements g {
    public final Map<KClass<?>, a> a;
    public final Map<KClass<?>, Map<KClass<?>, juc.d<?>>> b;
    public final Map<KClass<?>, Function1<?, n<?>>> c;
    public final Map<KClass<?>, Map<String, juc.d<?>>> d;
    public final Map<KClass<?>, Function1<String, juc.c<?>>> e;
    public boolean f;

    public final c f() {
        return new c(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public e() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void a(KClass<T> r2, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "provider");
        j(r2, new a.b(r3), false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void b(KClass<T> r2, juc.d<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "serializer");
        j(r2, new a.C0024a(r3), false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void c(KClass<Base> r2, Function1<? super String, ? extends juc.c<? extends Base>> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseClass");
        Intrinsics.checkNotNullParameter(r3, "defaultDeserializerProvider");
        g(r2, r3, false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void d(KClass<Base> r2, Function1<? super Base, ? extends n<? super Base>> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseClass");
        Intrinsics.checkNotNullParameter(r3, "defaultSerializerProvider");
        h(r2, r3, false);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base, Sub extends Base> void e(KClass<Base> r2, KClass<Sub> r3, juc.d<Sub> r4) {
        Intrinsics.checkNotNullParameter(r2, "baseClass");
        Intrinsics.checkNotNullParameter(r3, "actualClass");
        Intrinsics.checkNotNullParameter(r4, "actualSerializer");
        i(r2, r3, r4, false);
    }

    public final <Base> void g(KClass<Base> r3, Function1<? super String, ? extends juc.c<? extends Base>> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "baseClass");
        Intrinsics.checkNotNullParameter(r4, "defaultDeserializerProvider");
        Function1 r0 = (Function1) ((HashMap) this.e).get(r3);
        if (r0 != null) goto L5;
    L10:
        ((HashMap) this.e).put(r3, r4);
        return;
    L5:
        if (Intrinsics.areEqual(r0, r4) == true) goto L10;
        if (r5 == true) goto L10;
        throw new IllegalArgumentException("Default deserializers provider for " + r3 + " is already registered: " + r0);
    }

    public final <Base> void h(KClass<Base> r3, Function1<? super Base, ? extends n<? super Base>> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "baseClass");
        Intrinsics.checkNotNullParameter(r4, "defaultSerializerProvider");
        Function1 r0 = (Function1) ((HashMap) this.c).get(r3);
        if (r0 != null) goto L5;
    L10:
        ((HashMap) this.c).put(r3, r4);
        return;
    L5:
        if (Intrinsics.areEqual(r0, r4) == true) goto L10;
        if (r5 == true) goto L10;
        throw new IllegalArgumentException("Default serializers provider for " + r3 + " is already registered: " + r0);
    }

    public final <T> void j(KClass<T> r2, a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "forClass");
        Intrinsics.checkNotNullParameter(r3, "provider");
        if (r4 == true) goto L11;
        a r5 = (a) ((HashMap) this.a).get(r2);
        if (r5 == null) goto L11;
        if (Intrinsics.areEqual(r5, r3) == true) goto L11;
        throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + r2 + " already registered in this module");
    L11:
        ((HashMap) this.a).put(r2, r3);
        if (z1.c(r2) == false) goto L15;
        this.f = true;
        return;
    }

    public final <Base, Sub extends Base> void i(KClass<Base> r6, KClass<Sub> r7, juc.d<Sub> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "baseClass");
        Intrinsics.checkNotNullParameter(r7, "concreteClass");
        Intrinsics.checkNotNullParameter(r8, "concreteSerializer");
        String r0 = r8.getDescriptor().f();
        HashMap r1 = (HashMap) this.b;
        Object r2 = r1.get(r6);
        if (r2 != null) goto L5;
        r2 = new HashMap();
        r1.put(r6, r2);
    L5:
        Map r3 = (Map) r2;
        juc.d r4 = (juc.d) r3.get(r7);
        HashMap r5 = (HashMap) this.d;
        Object r10 = r5.get(r6);
        if (r10 != null) goto L8;
        r10 = new HashMap();
        r5.put(r6, r10);
    L8:
        Map r11 = (Map) r10;
        if (r9 == false) goto L14;
        if (r4 == null) goto L12;
        r11.remove(r4.getDescriptor().f());
    L12:
        r3.put(r7, r8);
        r11.put(r0, r8);
        return;
    L14:
        if (r4 != null) goto L16;
    L20:
        juc.d r12 = (juc.d) r11.get(r0);
        if (r12 == null) goto L34;
        Object r13 = ((HashMap) this.b).get(r6);
        Intrinsics.checkNotNull(r13);
        Iterator r14 = MapsKt.asSequence((Map) r13).iterator();
    L24:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        if (((Map.Entry) r15).getValue() != r12) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == false) goto L24;
    L33:
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + r6 + "' have the same serial name '" + r0 + "': '" + r7 + "' and '" + ((Map.Entry) r15) + '\'');
    L28:
        r16 = false;
        goto L29
    L31:
        r15 = null;
        goto L33
    L34:
        r3.put(r7, r8);
        r11.put(r0, r8);
        return;
    L16:
        if (Intrinsics.areEqual(r4, r8) == false) goto L19;
        juc.d r17 = (juc.d) r11.remove(r4.getDescriptor().f());
        goto L20
    L19:
        throw new SerializerAlreadyRegisteredException(r6, r7);
    }
}
