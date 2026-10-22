package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SuspendFunctionTypesKt {
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR = null;

    static {
        EmptyPackageFragmentDescriptor r10 = new EmptyPackageFragmentDescriptor(ErrorUtils.INSTANCE.getErrorModule(), StandardNames.COROUTINES_PACKAGE_FQ_NAME);
        ClassKind r11 = ClassKind.INTERFACE;
        Name r12 = StandardNames.CONTINUATION_INTERFACE_FQ_NAME.shortName();
        SourceElement r13 = SourceElement.NO_SOURCE;
        StorageManager r14 = LockBasedStorageManager.NO_LOCKS;
        MutableClassDescriptor r15 = new MutableClassDescriptor(r10, r11, false, false, r12, r13, r14);
        r15.setModality(Modality.ABSTRACT);
        r15.setVisibility(DescriptorVisibilities.PUBLIC);
        r15.setTypeParameterDescriptors(CollectionsKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(r15, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier("T"), 0, r14)));
        r15.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = r15;
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType r13) {
        Intrinsics.checkNotNullParameter(r13, "suspendFunType");
        FunctionTypesKt.isSuspendFunctionType(r13);
        KotlinBuiltIns r10 = TypeUtilsKt.getBuiltIns(r13);
        Annotations r11 = r13.getAnnotations();
        KotlinType r12 = FunctionTypesKt.getReceiverTypeFromFunctionType(r13);
        List<KotlinType> r14 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r13);
        List<TypeProjection> r15 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r13);
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        r16.add(((TypeProjection) r17.next()).getType());
        goto L4
    L6:
        TypeAttributes r18 = TypeAttributes.Companion.getEmpty();
        TypeConstructor r19 = FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r19, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List r20 = CollectionsKt.plus(r16, KotlinTypeFactory.simpleType$default(r18, r19, CollectionsKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(r13))), false, null, 16, null));
        SimpleType r21 = TypeUtilsKt.getBuiltIns(r13).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r21, "suspendFunType.builtIns.nullableAnyType");
        return FunctionTypesKt.createFunctionType$default(r10, r11, r12, r14, r20, null, r21, false, 128, null).makeNullableAsSpecified(r13.isMarkedNullable());
    }
}
