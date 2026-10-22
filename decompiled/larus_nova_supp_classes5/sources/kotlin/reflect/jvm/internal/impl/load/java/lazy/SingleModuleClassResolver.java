package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    public SingleModuleClassResolver() {
    }

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver r0 = this.resolver;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass r2) {
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        return getResolver().resolveClass(r2);
    }

    public final void setResolver(JavaDescriptorResolver r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resolver = r2;
    }
}
