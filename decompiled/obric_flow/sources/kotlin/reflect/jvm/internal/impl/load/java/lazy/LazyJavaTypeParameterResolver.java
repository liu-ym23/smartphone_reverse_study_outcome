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
    private final LazyJavaResolverContext f18744c;
    private final DeclarationDescriptor containingDeclaration;
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    private final Map<JavaTypeParameter, Integer> typeParameters;
    private final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext r5, DeclarationDescriptor r10, JavaTypeParameterListOwner r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r11, "typeParameterOwner");
        this.f18744c = r5;
        this.containingDeclaration = r10;
        this.typeParametersIndexOffset = r12;
        this.typeParameters = CollectionsKt.mapToIndex(r11.getTypeParameters());
        this.resolve = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaTypeParameterResolver r5) {
        return r5.f18744c;
    }

    public static final /* synthetic */ DeclarationDescriptor access$getContainingDeclaration$p(LazyJavaTypeParameterResolver r5) {
        return r5.containingDeclaration;
    }

    public static final /* synthetic */ Map access$getTypeParameters$p(LazyJavaTypeParameterResolver r5) {
        return r5.typeParameters;
    }

    public static final /* synthetic */ int access$getTypeParametersIndexOffset$p(LazyJavaTypeParameterResolver r5) {
        return r5.typeParametersIndexOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter r5) {
        Intrinsics.checkNotNullParameter(r5, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor r10 = this.resolve.invoke(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f18744c.getTypeParameterResolver().resolveTypeParameter(r5);
    }
}
