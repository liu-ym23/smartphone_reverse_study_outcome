package kotlin.reflect.jvm.internal.impl.builtins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nsuspendFunctionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 suspendFunctionTypes.kt\norg/jetbrains/kotlin/builtins/SuspendFunctionTypesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1549#2:66\n1620#2,3:67\n1#3:70\n*S KotlinDebug\n*F\n+ 1 suspendFunctionTypes.kt\norg/jetbrains/kotlin/builtins/SuspendFunctionTypesKt\n*L\n54#1:66\n54#1:67,3\n*E\n"})
public final class SuspendFunctionTypesKt {
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR = null;

    static {
        EmptyPackageFragmentDescriptor r5 = new EmptyPackageFragmentDescriptor(ErrorUtils.INSTANCE.getErrorModule(), StandardNames.COROUTINES_PACKAGE_FQ_NAME);
        ClassKind r10 = ClassKind.INTERFACE;
        Name r11 = StandardNames.CONTINUATION_INTERFACE_FQ_NAME.shortName();
        SourceElement r12 = SourceElement.NO_SOURCE;
        StorageManager r13 = LockBasedStorageManager.NO_LOCKS;
        MutableClassDescriptor r14 = new MutableClassDescriptor(r5, r10, false, false, r11, r12, r13);
        r14.setModality(Modality.ABSTRACT);
        r14.setVisibility(DescriptorVisibilities.PUBLIC);
        r14.setTypeParameterDescriptors(CollectionsKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(r14, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, r13)));
        r14.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = r14;
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType r13) {
        Intrinsics.checkNotNullParameter(r13, "suspendFunType");
        FunctionTypesKt.isSuspendFunctionType(r13);
        KotlinBuiltIns r5 = TypeUtilsKt.getBuiltIns(r13);
        Annotations r10 = r13.getAnnotations();
        KotlinType r11 = FunctionTypesKt.getReceiverTypeFromFunctionType(r13);
        List<KotlinType> r12 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r13);
        List<TypeProjection> r14 = FunctionTypesKt.getValueParameterTypesFromFunctionType(r13);
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        r15.add(((TypeProjection) r16.next()).getType());
        goto L4
    L7:
        return FunctionTypesKt.createFunctionType$default(r5, r10, r11, r12, CollectionsKt.plus(r15, KotlinTypeFactory.simpleType$default(TypeAttributes.Companion.getEmpty(), FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor(), CollectionsKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(r13))), false, null, 16, null)), null, TypeUtilsKt.getBuiltIns(r13).getNullableAnyType(), false, 128, null).makeNullableAsSpecified(r13.isMarkedNullable());
    }
}
