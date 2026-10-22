package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;

/* JADX INFO: loaded from: classes3.dex */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    public SingleModuleClassResolver() {
    }

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver r5 = this.resolver;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass r5) {
        Intrinsics.checkNotNullParameter(r5, "javaClass");
        return getResolver().resolveClass(r5);
    }

    public final void setResolver(JavaDescriptorResolver r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.resolver = r5;
    }
}
