package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Iterable<kotlin.reflect.jvm.internal.impl.types.TypeAttribute<?>>, kotlin.jvm.internal.markers.KMappedMarker] */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> {
    public static final Companion Companion = null;
    private static final TypeAttributes Empty = null;

    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ Collection access$getIndices(Companion r10) {
            return r10.getIndices();
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> r10) {
            Intrinsics.checkNotNullParameter(r10, "attributes");
            if (r10.isEmpty() == false) goto L6;
            return getEmpty();
        L6:
            return new TypeAttributes(r10, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public <T extends TypeAttribute<?>> int customComputeIfAbsent(ConcurrentHashMap<KClass<? extends TypeAttribute<?>>, Integer> r10, KClass<T> r11, Function1<? super KClass<? extends TypeAttribute<?>>, Integer> r12) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "kClass");
            Intrinsics.checkNotNullParameter(r12, "compute");
            Integer r13 = r10.get(r11);
            if (r13 != null) goto L15;
            monitor-enter(r10);
            Integer r14 = r10.get(r11);     // Catch: Throwable -> L11
            if (r14 != null) goto L8;
            Integer r15 = r12.invoke(r11);     // Catch: Throwable -> L11
            r10.putIfAbsent(r11, Integer.valueOf(r15.intValue()));     // Catch: Throwable -> L11
            r14 = r15;     // Catch: Throwable -> L11
        L8:
            Intrinsics.checkNotNullExpressionValue(r14, "this[kClass] ?: compute(…putIfAbsent(kClass, it) }");     // Catch: Throwable -> L11
            int r16 = r14.intValue();     // Catch: Throwable -> L11
            monitor-exit(r10);
            return r16;
        L11:
            th = move-exception;
            throw th;
        L15:
            return r13.intValue();
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.access$getEmpty$cp();
        }
    }

    static {
        Companion = new Companion(null);
        Empty = new TypeAttributes(CollectionsKt.emptyList());
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> r10) {
        Iterator<? extends TypeAttribute<?>> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        TypeAttribute<?> r12 = r11.next();
        registerComponent(r12.getKey(), r12);
        goto L4
    }

    public /* synthetic */ TypeAttributes(List r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    private TypeAttributes(TypeAttribute<?> r10) {
        this(CollectionsKt.listOf(r10));
    }

    public static final /* synthetic */ TypeAttributes access$getEmpty$cp() {
        return Empty;
    }

    public final TypeAttributes add(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r11 = new ArrayList();
        Iterator r12 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        int r13 = ((Number) r12.next()).intValue();
        TypeAttribute<?> r14 = getArrayMap().get(r13);
        TypeAttribute<?> r15 = r10.getArrayMap().get(r13);
        if (r14 != null) goto L15;
        if (r15 == null) goto L14;
        TypeAttribute r16 = r15.add(r14);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r11, r16);
        goto L9
    L14:
        r16 = null;
        goto L16
    L15:
        r16 = r14.add(r15);
        goto L16
    L18:
        return Companion.create(r11);
    L5:
        if (r10.isEmpty() == false) goto L7;
        return this;
    }

    public final boolean contains(TypeAttribute<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "attribute");
        int r11 = Companion.getId(r10.getKey());
        if (getArrayMap().get(r11) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    public final TypeAttributes intersect(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r11 = new ArrayList();
        Iterator r12 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        int r13 = ((Number) r12.next()).intValue();
        TypeAttribute<?> r14 = getArrayMap().get(r13);
        TypeAttribute<?> r15 = r10.getArrayMap().get(r13);
        if (r14 != null) goto L15;
        if (r15 == null) goto L14;
        TypeAttribute r16 = r15.intersect(r14);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r11, r16);
        goto L9
    L14:
        r16 = null;
        goto L16
    L15:
        r16 = r14.intersect(r15);
        goto L16
    L18:
        return Companion.create(r11);
    L5:
        if (r10.isEmpty() == false) goto L7;
        return this;
    }

    public final TypeAttributes plus(TypeAttribute<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "attribute");
        if (contains(r10) == false) goto L6;
        return this;
    L6:
        if (isEmpty() == true) goto L8;
        List<? extends TypeAttribute<?>> r11 = CollectionsKt.plus(CollectionsKt.toList(this), r10);
        return Companion.create(r11);
    L8:
        return new TypeAttributes(r10);
    }

    public final TypeAttributes remove(TypeAttribute<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "attribute");
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        ArrayMap<TypeAttribute<?>> r11 = getArrayMap();
        ArrayList r12 = new ArrayList();
        Iterator<TypeAttribute<?>> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        TypeAttribute<?> r14 = r13.next();
        if ((!Intrinsics.areEqual(r14, r10)) == false) goto L7;
        r12.add(r14);
        goto L7
    L12:
        if (r12.size() != getArrayMap().getSize()) goto L15;
        return this;
    L15:
        return Companion.create(r12);
    }
}
