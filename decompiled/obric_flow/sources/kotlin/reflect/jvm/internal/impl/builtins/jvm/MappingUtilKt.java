package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nmappingUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 mappingUtil.kt\norg/jetbrains/kotlin/builtins/jvm/MappingUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1549#2:25\n1620#2,3:26\n1549#2:29\n1620#2,3:30\n*S KotlinDebug\n*F\n+ 1 mappingUtil.kt\norg/jetbrains/kotlin/builtins/jvm/MappingUtilKt\n*L\n20#1:25\n20#1:26,3\n21#1:29\n21#1:30,3\n*E\n"})
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r10, "to");
        r5.getDeclaredTypeParameters().size();
        r10.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion r11 = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> r12 = r5.getDeclaredTypeParameters();
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(((TypeParameterDescriptor) r14.next()).getTypeConstructor());
        goto L4
    L6:
        List<TypeParameterDescriptor> r15 = r10.getDeclaredTypeParameters();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L11;
        r16.add(TypeUtilsKt.asTypeProjection(((TypeParameterDescriptor) r17.next()).getDefaultType()));
        goto L8
    L11:
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(r11, MapsKt.toMap(CollectionsKt.zip(r13, r16)), false, 2, null);
    }
}
