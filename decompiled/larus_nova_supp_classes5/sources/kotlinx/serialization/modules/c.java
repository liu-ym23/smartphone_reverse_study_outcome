package kotlinx.serialization.modules;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import juc.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends d {
    public final Map<KClass<?>, a> a;
    public final Map<KClass<?>, Map<KClass<?>, juc.d<?>>> b;
    public final Map<KClass<?>, Function1<?, n<?>>> c;
    public final Map<KClass<?>, Map<String, juc.d<?>>> d;
    public final Map<KClass<?>, Function1<String, juc.c<?>>> e;
    public final boolean f;

    @Override // kotlinx.serialization.modules.d
    public final boolean d() {
        return this.f;
    }

    @Override // kotlinx.serialization.modules.d
    public final void a(g r8) {
        Intrinsics.checkNotNullParameter(r8, "collector");
        Iterator<Map.Entry<KClass<?>, a>> r0 = this.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry<KClass<?>, a> r1 = r0.next();
        KClass<?> r3 = r1.getKey();
        a r2 = r1.getValue();
        if ((r2 instanceof a.C0024a) == true) goto L7;
        if ((r2 instanceof a.b) == false) goto L12;
        r8.a(r3, ((a.b) r2).a);
        goto L4
    L12:
        throw new NoWhenBranchMatchedException();
    L7:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        juc.d<?> r4 = ((a.C0024a) r2).a;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        r8.b(r3, r4);
        goto L4
    L13:
        Iterator<Map.Entry<KClass<?>, Map<KClass<?>, juc.d<?>>>> r5 = this.b.entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        Map.Entry<KClass<?>, Map<KClass<?>, juc.d<?>>> r6 = r5.next();
        KClass<?> r7 = r6.getKey();
        Iterator<Map.Entry<KClass<?>, juc.d<?>>> r9 = r6.getValue().entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L15;
        Map.Entry<KClass<?>, juc.d<?>> r10 = r9.next();
        KClass<?> r11 = r10.getKey();
        juc.d<?> r12 = r10.getValue();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        r8.e(r7, r11, r12);
        goto L18
    L20:
        Iterator<Map.Entry<KClass<?>, Function1<?, n<?>>>> r13 = this.c.entrySet().iterator();
    L22:
        if (r13.hasNext() == false) goto L24;
        Map.Entry<KClass<?>, Function1<?, n<?>>> r14 = r13.next();
        KClass<?> r15 = r14.getKey();
        Function1<?, n<?>> r16 = r14.getValue();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
        r8.d(r15, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r16, 1));
        goto L22
    L24:
        Iterator<Map.Entry<KClass<?>, Function1<String, juc.c<?>>>> r17 = this.e.entrySet().iterator();
    L26:
        if (r17.hasNext() == false) goto L28;
        Map.Entry<KClass<?>, Function1<String, juc.c<?>>> r18 = r17.next();
        KClass<?> r19 = r18.getKey();
        Function1<String, juc.c<?>> r20 = r18.getValue();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
        r8.c(r19, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r20, 1));
        goto L26
    }

    @Override // kotlinx.serialization.modules.d
    public final <T> juc.d<T> b(KClass<T> r2, List<? extends juc.d<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        Intrinsics.checkNotNullParameter(r3, "typeArgumentsSerializers");
        a r4 = this.a.get(r2);
        if (r4 == null) goto L5;
        juc.d<?> r5 = r4.a(r3);
    L7:
        if ((r5 instanceof juc.d) == true) goto L9;
        return null;
    L9:
        return (juc.d<T>) r5;
    L5:
        r5 = null;
        goto L7
    }

    @Override // kotlinx.serialization.modules.d
    public final <T> juc.c<T> e(KClass<? super T> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "baseClass");
        Map<String, juc.d<?>> r0 = this.d.get(r4);
        if (r0 == null) goto L5;
        juc.d<?> r1 = r0.get(r5);
    L7:
        if ((r1 instanceof juc.d) == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        Function1<String, juc.c<?>> r6 = this.e.get(r4);
        if (TypeIntrinsics.isFunctionOfArity(r6, 1) == false) goto L16;
        Function1<String, juc.c<?>> r7 = r6;
    L17:
        if (r7 != null) goto L19;
        return null;
    L19:
        return (juc.c) r7.invoke(r5);
    L16:
        r7 = null;
        goto L17
    L12:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    @Override // kotlinx.serialization.modules.d
    public final <T> n<T> f(KClass<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "baseClass");
        Intrinsics.checkNotNullParameter(r5, "value");
        if (r4.isInstance(r5) == true) goto L5;
        return null;
    L5:
        Map<KClass<?>, juc.d<?>> r0 = this.b.get(r4);
        if (r0 == null) goto L8;
        juc.d<?> r1 = r0.get(Reflection.getOrCreateKotlinClass(r5.getClass()));
    L10:
        if ((r1 instanceof n) == false) goto L12;
        juc.d<?> r2 = r1;
    L13:
        if (r2 == null) goto L15;
        return r2;
    L15:
        Function1<?, n<?>> r6 = this.c.get(r4);
        if (TypeIntrinsics.isFunctionOfArity(r6, 1) == false) goto L18;
        Function1<?, n<?>> r7 = r6;
    L19:
        if (r7 != null) goto L21;
        return null;
    L21:
        return (n) r7.invoke(r5);
    L18:
        r7 = null;
        goto L19
    L12:
        r2 = null;
        goto L13
    L8:
        r1 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Map<KClass<?>, ? extends a> r2, Map<KClass<?>, ? extends Map<KClass<?>, ? extends juc.d<?>>> r3, Map<KClass<?>, ? extends Function1<?, ? extends n<?>>> r4, Map<KClass<?>, ? extends Map<String, ? extends juc.d<?>>> r5, Map<KClass<?>, ? extends Function1<? super String, ? extends juc.c<?>>> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(r3, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(r4, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(r5, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(r6, "polyBase2DefaultDeserializerProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
