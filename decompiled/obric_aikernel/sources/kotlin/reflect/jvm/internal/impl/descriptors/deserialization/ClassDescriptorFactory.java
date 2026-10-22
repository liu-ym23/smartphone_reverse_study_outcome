package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface ClassDescriptorFactory {
    ClassDescriptor createClass(ClassId r10);

    Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r10);

    boolean shouldCreateClass(FqName r10, Name r11);
}
