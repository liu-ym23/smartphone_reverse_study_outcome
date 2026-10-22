package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, TypedValues.TransitionType.S_TO);
        r10.getDeclaredTypeParameters().size();
        r11.getDeclaredTypeParameters().size();
        TypeConstructorSubstitution.Companion r12 = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> r13 = r10.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "from.declaredTypeParameters");
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(((TypeParameterDescriptor) r15.next()).getTypeConstructor());
        goto L4
    L6:
        List<TypeParameterDescriptor> r16 = r11.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r16, "to.declaredTypeParameters");
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L8:
        if (r18.hasNext() == false) goto L11;
        SimpleType r19 = ((TypeParameterDescriptor) r18.next()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r19, "it.defaultType");
        r17.add(TypeUtilsKt.asTypeProjection(r19));
        goto L8
    L11:
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(r12, MapsKt.toMap(CollectionsKt.zip(r14, r17)), false, 2, null);
    }
}
