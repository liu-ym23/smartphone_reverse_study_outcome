package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface PlatformDependentDeclarationFilter {
    boolean isFunctionAvailable(ClassDescriptor r1, SimpleFunctionDescriptor r2);
}
