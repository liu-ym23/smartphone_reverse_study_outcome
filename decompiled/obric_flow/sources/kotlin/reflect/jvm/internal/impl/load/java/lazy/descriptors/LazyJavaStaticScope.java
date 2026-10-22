package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    public LazyJavaStaticScope(LazyJavaResolverContext r5) {
        Intrinsics.checkNotNullParameter(r5, "c");
        super(r5, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(Name r5, Collection<PropertyDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod r10, List<? extends TypeParameterDescriptor> r11, KotlinType r12, List<? extends ValueParameterDescriptor> r13) {
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(r12, "returnType");
        Intrinsics.checkNotNullParameter(r13, "valueParameters");
        return new LazyJavaScope.MethodSignatureData(r12, null, r13, r11, false, CollectionsKt.emptyList());
    }
}
