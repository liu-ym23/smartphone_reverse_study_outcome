package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final TypeAliasExpansion create(TypeAliasExpansion r10, TypeAliasDescriptor r11, List<? extends TypeProjection> r12) {
            Intrinsics.checkNotNullParameter(r11, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r12, "arguments");
            List<TypeParameterDescriptor> r13 = r11.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r13, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<T> r15 = r13.iterator();
        L4:
            if (r15.hasNext() == false) goto L7;
            r14.add(((TypeParameterDescriptor) r15.next()).getOriginal());
            goto L4
        L7:
            return new TypeAliasExpansion(r10, r11, r12, MapsKt.toMap(CollectionsKt.zip(r14, r12)), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion r10, TypeAliasDescriptor r11, List<? extends TypeProjection> r12, Map<TypeParameterDescriptor, ? extends TypeProjection> r13) {
        this.parent = r10;
        this.descriptor = r11;
        this.arguments = r12;
        this.mapping = r13;
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion r10, TypeAliasDescriptor r11, List r12, Map r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final TypeProjection getReplacement(TypeConstructor r10) {
        Intrinsics.checkNotNullParameter(r10, "constructor");
        ClassifierDescriptor r11 = r10.mo1323getDeclarationDescriptor();
        if ((r11 instanceof TypeParameterDescriptor) == true) goto L7;
        return null;
    L7:
        return this.mapping.get(r11);
    }

    public final boolean isRecursion(TypeAliasDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        if (Intrinsics.areEqual(this.descriptor, r10) == true) goto L9;
        TypeAliasExpansion r11 = this.parent;
        if (r11 == null) goto L7;
        boolean r12 = r11.isRecursion(r10);
    L8:
        if (r12 == true) goto L9;
        return false;
    L7:
        r12 = false;
    L9:
        return true;
    }
}
