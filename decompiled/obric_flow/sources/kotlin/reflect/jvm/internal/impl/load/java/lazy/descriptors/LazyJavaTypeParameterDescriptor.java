package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLazyJavaTypeParameterDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaTypeParameterDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaTypeParameterDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1549#2:76\n1620#2,3:77\n*S KotlinDebug\n*F\n+ 1 LazyJavaTypeParameterDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaTypeParameterDescriptor\n*L\n62#1:76\n62#1:77,3\n*E\n"})
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18750c;
    private final JavaTypeParameter javaTypeParameter;

    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext r12, JavaTypeParameter r13, int r14, DeclarationDescriptor r15) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "javaTypeParameter");
        Intrinsics.checkNotNullParameter(r15, "containingDeclaration");
        super(r12.getStorageManager(), r15, new LazyJavaAnnotations(r12, r13, false, 4, null), r13.getName(), Variance.INVARIANT, false, r14, SourceElement.NO_SOURCE, r12.getComponents().getSupertypeLoopChecker());
        this.f18750c = r12;
        this.javaTypeParameter = r13;
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> r5 = this.javaTypeParameter.getUpperBounds();
        if (r5.isEmpty() == true) goto L5;
        Collection<JavaClassifierType> r10 = r5;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        JavaClassifierType r13 = (JavaClassifierType) r12.next();
        r11.add(this.f18750c.getTypeResolver().transformJavaType(r13, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, this, 3, null)));
        goto L8
    L10:
        return r11;
    L5:
        return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(this.f18750c.getModule().getBuiltIns().getAnyType(), this.f18750c.getModule().getBuiltIns().getNullableAnyType()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> r5) {
        Intrinsics.checkNotNullParameter(r5, "bounds");
        return this.f18750c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, r5, this.f18750c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError */
    public void mo1405reportSupertypeLoopError(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }
}
