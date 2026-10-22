package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE = null;

    static {
        INSTANCE = new TypeMappingConfigurationImpl();
    }

    private TypeMappingConfigurationImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType commonSupertype(Collection<? extends KotlinType> r11) {
        Intrinsics.checkNotNullParameter(r11, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + CollectionsKt.q(r11, null, null, null, 0, null, null, 63));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedFullInternalNameForClass(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public String getPredefinedInternalNameForClass(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    /* JADX INFO: renamed from: getPredefinedTypeForClass, reason: avoid collision after fix types in other method */
    public JvmType getPredefinedTypeForClass2(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public KotlinType preprocessType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(KotlinType r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "kotlinType");
        Intrinsics.checkNotNullParameter(r10, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public /* bridge */ /* synthetic */ JvmType getPredefinedTypeForClass(ClassDescriptor r5) {
        return getPredefinedTypeForClass2(r5);
    }
}
