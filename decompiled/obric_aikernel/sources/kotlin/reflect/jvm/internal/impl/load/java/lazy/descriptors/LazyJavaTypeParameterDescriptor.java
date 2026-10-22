package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10214c;
    private final JavaTypeParameter javaTypeParameter;

    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext r12, JavaTypeParameter r13, int r14, DeclarationDescriptor r15) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "javaTypeParameter");
        Intrinsics.checkNotNullParameter(r15, "containingDeclaration");
        super(r12.getStorageManager(), r15, new LazyJavaAnnotations(r12, r13, false, 4, null), r13.getName(), Variance.INVARIANT, false, r14, SourceElement.NO_SOURCE, r12.getComponents().getSupertypeLoopChecker());
        this.f10214c = r12;
        this.javaTypeParameter = r13;
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> r10 = this.javaTypeParameter.getUpperBounds();
        if (r10.isEmpty() == false) goto L6;
        SimpleType r11 = this.f10214c.getModule().getBuiltIns().getAnyType();
        Intrinsics.checkNotNullExpressionValue(r11, "c.module.builtIns.anyType");
        SimpleType r12 = this.f10214c.getModule().getBuiltIns().getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(r12, "c.module.builtIns.nullableAnyType");
        return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(r11, r12));
    L6:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        JavaClassifierType r15 = (JavaClassifierType) r14.next();
        r13.add(this.f10214c.getTypeResolver().transformJavaType(r15, JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, this, 3, null)));
        goto L8
    L10:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> r10) {
        Intrinsics.checkNotNullParameter(r10, "bounds");
        return this.f10214c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, r10, this.f10214c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError */
    protected void mo1326reportSupertypeLoopError(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }
}
