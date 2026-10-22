package kotlin.reflect.jvm.internal.impl.types;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> {
    public static final Companion Companion = null;
    private static final TypeAttributes Empty = null;

    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.access$getEmpty$cp();
        }

        private Companion() {
        }

        public static final /* synthetic */ Collection access$getIndices(Companion r0) {
            return r0.getIndices();
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> r3) {
            Intrinsics.checkNotNullParameter(r3, "attributes");
            if (r3.isEmpty() == false) goto L6;
            return getEmpty();
        L6:
            return new TypeAttributes(r3, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public int customComputeIfAbsent(ConcurrentHashMap<String, Integer> r2, String r3, Function1<? super String, Integer> r4) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "compute");
            Integer r0 = r2.get(r3);
            if (r0 != null) goto L17;
            monitor-enter(r2);
            Integer r1 = r2.get(r3);     // Catch: Throwable -> L13
            if (r1 == null) goto L9;
            int r5 = r1.intValue();     // Catch: Throwable -> L13
        L10:
            monitor-exit(r2);
            return r5;
        L9:
            Object r6 = r4.invoke(r3);     // Catch: Throwable -> L13
            r2.putIfAbsent(r3, Integer.valueOf(((Number) r6).intValue()));     // Catch: Throwable -> L13
            r5 = ((Number) r6).intValue();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        L17:
            return r0.intValue();
        }
    }

    public /* synthetic */ TypeAttributes(List r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    static {
        Companion = new Companion(null);
        Empty = new TypeAttributes(CollectionsKt.emptyList());
    }

    public static final /* synthetic */ TypeAttributes access$getEmpty$cp() {
        return Empty;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> r3) {
        Iterator<? extends TypeAttribute<?>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        TypeAttribute<?> r0 = r4.next();
        registerComponent(r0.getKey(), r0);
        goto L4
    }

    public final TypeAttributes add(TypeAttributes r6) {
        Intrinsics.checkNotNullParameter(r6, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r0 = new ArrayList();
        Iterator r1 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        int r2 = ((Number) r1.next()).intValue();
        TypeAttribute<?> r3 = getArrayMap().get(r2);
        TypeAttribute<?> r4 = r6.getArrayMap().get(r2);
        if (r3 != null) goto L15;
        if (r4 == null) goto L14;
        TypeAttribute r5 = r4.add(r3);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r0, r5);
        goto L9
    L14:
        r5 = null;
        goto L16
    L15:
        r5 = r3.add(r4);
        goto L16
    L18:
        return Companion.create(r0);
    L5:
        if (r6.isEmpty() == false) goto L7;
        return this;
    }

    public final boolean contains(TypeAttribute<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "attribute");
        int r3 = Companion.getId(r2.getKey());
        if (getArrayMap().get(r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final TypeAttributes intersect(TypeAttributes r6) {
        Intrinsics.checkNotNullParameter(r6, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r0 = new ArrayList();
        Iterator r1 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        int r2 = ((Number) r1.next()).intValue();
        TypeAttribute<?> r3 = getArrayMap().get(r2);
        TypeAttribute<?> r4 = r6.getArrayMap().get(r2);
        if (r3 != null) goto L15;
        if (r4 == null) goto L14;
        TypeAttribute r5 = r4.intersect(r3);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r0, r5);
        goto L9
    L14:
        r5 = null;
        goto L16
    L15:
        r5 = r3.intersect(r4);
        goto L16
    L18:
        return Companion.create(r0);
    L5:
        if (r6.isEmpty() == false) goto L7;
        return this;
    }

    public final TypeAttributes plus(TypeAttribute<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "attribute");
        if (contains(r2) == false) goto L6;
        return this;
    L6:
        if (isEmpty() == true) goto L8;
        List<? extends TypeAttribute<?>> r3 = CollectionsKt.plus(CollectionsKt.toList(this), r2);
        return Companion.create(r3);
    L8:
        return new TypeAttributes(r2);
    }

    public final TypeAttributes remove(TypeAttribute<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "attribute");
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        ArrayMap<TypeAttribute<?>> r0 = getArrayMap();
        ArrayList r1 = new ArrayList();
        Iterator<TypeAttribute<?>> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        TypeAttribute<?> r3 = r2.next();
        if ((!Intrinsics.areEqual(r3, r5)) == false) goto L7;
        r1.add(r3);
        goto L7
    L12:
        if (r1.size() != getArrayMap().getSize()) goto L15;
        return this;
    L15:
        return Companion.create(r1);
    }

    private TypeAttributes(TypeAttribute<?> r1) {
        this(CollectionsKt.listOf(r1));
    }
}
