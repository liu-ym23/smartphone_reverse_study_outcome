package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeMappingConfiguration<T> {
    KotlinType commonSupertype(Collection<KotlinType> r5);

    String getPredefinedFullInternalNameForClass(ClassDescriptor r5);

    String getPredefinedInternalNameForClass(ClassDescriptor r5);

    T getPredefinedTypeForClass(ClassDescriptor r5);

    KotlinType preprocessType(KotlinType r5);

    void processErrorType(KotlinType r5, ClassDescriptor r10);
}
