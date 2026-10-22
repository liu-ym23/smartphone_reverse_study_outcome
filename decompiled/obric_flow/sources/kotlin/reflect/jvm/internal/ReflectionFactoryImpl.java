package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectLambdaKt;

/* JADX INFO: loaded from: classes3.dex */
public class ReflectionFactoryImpl extends ReflectionFactory {
    public ReflectionFactoryImpl() {
    }

    public static void clearCaches() {
        CachesKt.clearCaches();
        ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
    }

    private static KDeclarationContainerImpl getOwner(CallableReference r5) {
        KDeclarationContainer r10 = r5.getOwner();
        if ((r10 instanceof KDeclarationContainerImpl) == false) goto L6;
        return (KDeclarationContainerImpl) r10;
    L6:
        return EmptyContainerForLocal.INSTANCE;
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class r5) {
        return new KClassImpl(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KFunction function(FunctionReference r5) {
        return new KFunctionImpl(getOwner(r5), r5.getName(), r5.getSignature(), r5.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class r5) {
        return CachesKt.getOrCreateKotlinClass(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class r5, String r10) {
        return CachesKt.getOrCreateKotlinPackage(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType mutableCollectionType(KType r5) {
        return TypeOfImplKt.createMutableCollectionKType(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r5) {
        return new KMutableProperty0Impl(getOwner(r5), r5.getName(), r5.getSignature(), r5.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r5) {
        return new KMutableProperty1Impl(getOwner(r5), r5.getName(), r5.getSignature(), r5.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r5) {
        return new KMutableProperty2Impl(getOwner(r5), r5.getName(), r5.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType nothingType(KType r5) {
        return TypeOfImplKt.createNothingType(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType platformType(KType r5, KType r10) {
        return TypeOfImplKt.createPlatformKType(r5, r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty0 property0(PropertyReference0 r5) {
        return new KProperty0Impl(getOwner(r5), r5.getName(), r5.getSignature(), r5.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty1 property1(PropertyReference1 r5) {
        return new KProperty1Impl(getOwner(r5), r5.getName(), r5.getSignature(), r5.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty2 property2(PropertyReference2 r5) {
        return new KProperty2Impl(getOwner(r5), r5.getName(), r5.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(Lambda r5) {
        return renderLambdaToString(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public void setUpperBounds(KTypeParameter r5, List<KType> r10) {
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType typeOf(KClassifier r5, List<KTypeProjection> r10, boolean r11) {
        if ((r5 instanceof ClassBasedDeclarationContainer) == false) goto L7;
        return CachesKt.getOrCreateKType(((ClassBasedDeclarationContainer) r5).getJClass(), r10, r11);
    L7:
        return KClassifiers.createType(r5, r10, r11, Collections.emptyList());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KTypeParameter typeParameter(Object r5, String r10, KVariance r11, boolean r12) {
        if ((r5 instanceof KClass) == false) goto L6;
        List<KTypeParameter> r13 = ((KClass) r5).getTypeParameters();
    L8:
        Iterator<KTypeParameter> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L15;
        KTypeParameter r15 = r14.next();
        if (r15.getName().equals(r10) == false) goto L10;
        return r15;
    L15:
        throw new IllegalArgumentException("Type parameter " + r10 + " is not found in container: " + r5);
    L6:
        if ((r5 instanceof KCallable) == false) goto L17;
        r13 = ((KCallable) r5).getTypeParameters();
        goto L8
    L17:
        throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class r5, String r10) {
        return new KClassImpl(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class r5, String r10) {
        return CachesKt.getOrCreateKotlinClass(r5);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(FunctionBase r5) {
        KFunction r10 = ReflectLambdaKt.reflect(r5);
        if (r10 == null) goto L9;
        KFunctionImpl r11 = UtilKt.asKFunctionImpl(r10);
        if (r11 == null) goto L9;
        return ReflectionObjectRenderer.INSTANCE.renderLambda(r11.getDescriptor());
    L9:
        return super.renderLambdaToString(r5);
    }
}
