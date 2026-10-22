package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10208c;
    private final DeclarationDescriptor containingDeclaration;
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    private final Map<JavaTypeParameter, Integer> typeParameters;
    private final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext r10, DeclarationDescriptor r11, JavaTypeParameterListOwner r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r12, "typeParameterOwner");
        this.f10208c = r10;
        this.containingDeclaration = r11;
        this.typeParametersIndexOffset = r13;
        this.typeParameters = CollectionsKt.mapToIndex(r12.getTypeParameters());
        this.resolve = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaTypeParameterResolver r10) {
        return r10.f10208c;
    }

    public static final /* synthetic */ DeclarationDescriptor access$getContainingDeclaration$p(LazyJavaTypeParameterResolver r10) {
        return r10.containingDeclaration;
    }

    public static final /* synthetic */ Map access$getTypeParameters$p(LazyJavaTypeParameterResolver r10) {
        return r10.typeParameters;
    }

    public static final /* synthetic */ int access$getTypeParametersIndexOffset$p(LazyJavaTypeParameterResolver r10) {
        return r10.typeParametersIndexOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r10) {
        Intrinsics.checkNotNullParameter(r10, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor r11 = this.resolve.invoke(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return this.f10208c.getTypeParameterResolver().resolveTypeParameter(r10);
    }
}
