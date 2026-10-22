package kotlin.reflect.jvm.internal.impl.types;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n105#1,9:134\n105#1,9:143\n105#1,9:152\n766#2:161\n857#2,2:162\n*S KotlinDebug\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes\n*L\n74#1:134,9\n78#1:143,9\n82#1:152,9\n99#1:161\n99#1:162,2\n*E\n"})
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> implements Iterable<TypeAttribute<?>>, KMappedMarker {
    public static final Companion Companion = null;
    private static final TypeAttributes Empty = null;

    @SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ Collection access$getIndices(Companion r5) {
            return r5.getIndices();
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> r5) {
            Intrinsics.checkNotNullParameter(r5, "attributes");
            if (r5.isEmpty() == false) goto L6;
            return getEmpty();
        L6:
            return new TypeAttributes(r5, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public int customComputeIfAbsent(ConcurrentHashMap<String, Integer> r5, String r10, Function1<? super String, Integer> r11) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            Intrinsics.checkNotNullParameter(r11, "compute");
            Integer r12 = r5.get(r10);
            if (r12 != null) goto L16;
            monitor-enter(r5);
            Integer r13 = r5.get(r10);     // Catch: Throwable -> L8
            if (r13 != null) goto L10;
            Integer r14 = r11.invoke(r10);     // Catch: Throwable -> L8
            r5.putIfAbsent(r10, Integer.valueOf(r14.intValue()));     // Catch: Throwable -> L8
            r13 = r14;     // Catch: Throwable -> L8
        L10:
            int r15 = r13.intValue();     // Catch: Throwable -> L8
            monitor-exit(r5);
            return r15;
        L8:
            th = move-exception;
            throw th;
        L16:
            return r12.intValue();
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.access$getEmpty$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        Empty = new TypeAttributes(CollectionsKt.emptyList());
    }

    public /* synthetic */ TypeAttributes(List r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public static final /* synthetic */ TypeAttributes access$getEmpty$cp() {
        return Empty;
    }

    public final TypeAttributes add(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r5 = new ArrayList();
        Iterator r11 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        int r12 = ((Number) r11.next()).intValue();
        TypeAttribute<?> r13 = getArrayMap().get(r12);
        TypeAttribute<?> r14 = r10.getArrayMap().get(r12);
        if (r13 != null) goto L15;
        if (r14 == null) goto L14;
        TypeAttribute r15 = r14.add(r13);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r5, r15);
        goto L9
    L14:
        r15 = null;
        goto L16
    L15:
        r15 = r13.add(r14);
        goto L16
    L18:
        return Companion.create(r5);
    L5:
        if (r10.isEmpty() == false) goto L7;
        return this;
    }

    public final boolean contains(TypeAttribute<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "attribute");
        int r10 = Companion.getId(r5.getKey());
        if (getArrayMap().get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    public final TypeAttributes intersect(TypeAttributes r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r5 = new ArrayList();
        Iterator r11 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        int r12 = ((Number) r11.next()).intValue();
        TypeAttribute<?> r13 = getArrayMap().get(r12);
        TypeAttribute<?> r14 = r10.getArrayMap().get(r12);
        if (r13 != null) goto L15;
        if (r14 == null) goto L14;
        TypeAttribute r15 = r14.intersect(r13);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r5, r15);
        goto L9
    L14:
        r15 = null;
        goto L16
    L15:
        r15 = r13.intersect(r14);
        goto L16
    L18:
        return Companion.create(r5);
    L5:
        if (r10.isEmpty() == false) goto L7;
        return this;
    }

    public final TypeAttributes plus(TypeAttribute<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "attribute");
        if (contains(r5) == false) goto L6;
        return this;
    L6:
        if (isEmpty() == true) goto L8;
        List<? extends TypeAttribute<?>> r10 = CollectionsKt.plus(CollectionsKt.toList(this), r5);
        return Companion.create(r10);
    L8:
        return new TypeAttributes(r5);
    }

    public final TypeAttributes remove(TypeAttribute<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "attribute");
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        ArrayMap<TypeAttribute<?>> r10 = getArrayMap();
        ArrayList r11 = new ArrayList();
        Iterator<TypeAttribute<?>> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        TypeAttribute<?> r13 = r12.next();
        if (Intrinsics.areEqual(r13, r5) == true) goto L7;
        r11.add(r13);
        goto L7
    L12:
        if (r11.size() != getArrayMap().getSize()) goto L15;
        return this;
    L15:
        return Companion.create(r11);
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> r5) {
        Iterator<? extends TypeAttribute<?>> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        TypeAttribute<?> r11 = r10.next();
        registerComponent(r11.getKey(), r11);
        goto L4
    }

    private TypeAttributes(TypeAttribute<?> r5) {
        this(CollectionsKt.listOf(r5));
    }
}
