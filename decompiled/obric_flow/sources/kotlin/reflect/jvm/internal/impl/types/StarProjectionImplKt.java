package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStarProjectionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarProjectionImpl.kt\norg/jetbrains/kotlin/types/StarProjectionImplKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1549#2:102\n1620#2,3:103\n1549#2:106\n1620#2,3:107\n*S KotlinDebug\n*F\n+ 1 StarProjectionImpl.kt\norg/jetbrains/kotlin/types/StarProjectionImplKt\n*L\n66#1:102\n66#1:103,3\n73#1:106\n73#1:107,3\n*E\n"})
public final class StarProjectionImplKt {
    private static final KotlinType buildStarProjectionTypeByTypeParameters(final List<? extends TypeConstructor> r5, List<? extends KotlinType> r10, KotlinBuiltIns r11) {
        KotlinType r12 = TypeSubstitutor.create(new AnonymousClass1(r5)).substitute((KotlinType) CollectionsKt.first(r10), Variance.OUT_VARIANCE);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return r11.getDefaultBound();
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if ((r10 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L10;
        List<TypeParameterDescriptor> r11 = ((ClassifierDescriptorWithTypeParameters) r10).getTypeConstructor().getParameters();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L21;
        r12.add(((TypeParameterDescriptor) r13.next()).getTypeConstructor());
        goto L6
    L21:
        return buildStarProjectionTypeByTypeParameters(r12, r5.getUpperBounds(), DescriptorUtilsKt.getBuiltIns(r5));
    L10:
        if ((r10 instanceof FunctionDescriptor) == false) goto L18;
        List<TypeParameterDescriptor> r14 = ((FunctionDescriptor) r10).getTypeParameters();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L13:
        if (r16.hasNext() == false) goto L16;
        r15.add(((TypeParameterDescriptor) r16.next()).getTypeConstructor());
        goto L13
    L16:
        return buildStarProjectionTypeByTypeParameters(r15, r5.getUpperBounds(), DescriptorUtilsKt.getBuiltIns(r5));
    L18:
        throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }
}
