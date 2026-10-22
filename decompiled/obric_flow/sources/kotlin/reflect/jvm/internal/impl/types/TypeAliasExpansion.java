package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasExpansion {
    public static final Companion Companion = null;
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    @SourceDebugExtension({"SMAP\nTypeAliasExpansion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasExpansion.kt\norg/jetbrains/kotlin/types/TypeAliasExpansion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1549#2:44\n1620#2,3:45\n*S KotlinDebug\n*F\n+ 1 TypeAliasExpansion.kt\norg/jetbrains/kotlin/types/TypeAliasExpansion$Companion\n*L\n34#1:44\n34#1:45,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final TypeAliasExpansion create(TypeAliasExpansion r10, TypeAliasDescriptor r11, List<? extends TypeProjection> r12) {
            Intrinsics.checkNotNullParameter(r11, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r12, "arguments");
            List<TypeParameterDescriptor> r13 = r11.getTypeConstructor().getParameters();
            ArrayList r5 = new ArrayList(CollectionsKt.h(r13));
            Iterator<T> r14 = r13.iterator();
        L4:
            if (r14.hasNext() == false) goto L7;
            r5.add(((TypeParameterDescriptor) r14.next()).getOriginal());
            goto L4
        L7:
            return new TypeAliasExpansion(r10, r11, r12, MapsKt.toMap(CollectionsKt.zip(r5, r12)), null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion r5, TypeAliasDescriptor r10, List r11, Map r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final TypeProjection getReplacement(TypeConstructor r5) {
        Intrinsics.checkNotNullParameter(r5, "constructor");
        ClassifierDescriptor r10 = r5.mo1402getDeclarationDescriptor();
        if ((r10 instanceof TypeParameterDescriptor) == true) goto L7;
        return null;
    L7:
        return this.mapping.get(r10);
    }

    public final boolean isRecursion(TypeAliasDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        if (Intrinsics.areEqual(this.descriptor, r5) == true) goto L9;
        TypeAliasExpansion r10 = this.parent;
        if (r10 == null) goto L7;
        boolean r11 = r10.isRecursion(r5);
    L8:
        if (r11 == true) goto L9;
        return false;
    L7:
        r11 = false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion r5, TypeAliasDescriptor r10, List<? extends TypeProjection> r11, Map<TypeParameterDescriptor, ? extends TypeProjection> r12) {
        this.parent = r5;
        this.descriptor = r10;
        this.arguments = r11;
        this.mapping = r12;
    }
}
