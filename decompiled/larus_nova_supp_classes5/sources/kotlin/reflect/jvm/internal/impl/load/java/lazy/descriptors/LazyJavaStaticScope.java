package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(Name r2, Collection<PropertyDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    public LazyJavaStaticScope(LazyJavaResolverContext r3) {
        Intrinsics.checkNotNullParameter(r3, "c");
        super(r3, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod r8, List<? extends TypeParameterDescriptor> r9, KotlinType r10, List<? extends ValueParameterDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r8, "method");
        Intrinsics.checkNotNullParameter(r9, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(r10, "returnType");
        Intrinsics.checkNotNullParameter(r11, "valueParameters");
        return new LazyJavaScope.MethodSignatureData(r10, null, r11, r9, false, CollectionsKt.emptyList());
    }
}
