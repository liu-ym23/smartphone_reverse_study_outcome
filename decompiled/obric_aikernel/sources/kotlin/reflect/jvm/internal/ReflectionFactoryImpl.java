package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
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
        KClassCacheKt.clearKClassCache();
        ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
    }

    private static KDeclarationContainerImpl getOwner(CallableReference r10) {
        KDeclarationContainer r11 = r10.getOwner();
        if ((r11 instanceof KDeclarationContainerImpl) == false) goto L6;
        return (KDeclarationContainerImpl) r11;
    L6:
        return EmptyContainerForLocal.INSTANCE;
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class r10) {
        return new KClassImpl(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class r10, String r11) {
        return new KClassImpl(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KFunction function(FunctionReference r10) {
        return new KFunctionImpl(getOwner(r10), r10.getName(), r10.getSignature(), r10.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class r10) {
        return KClassCacheKt.getOrCreateKotlinClass(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class r10, String r11) {
        return KClassCacheKt.getOrCreateKotlinClass(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class r10, String r11) {
        return new KPackageImpl(r10, r11);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType mutableCollectionType(KType r10) {
        return TypeOfImplKt.createMutableCollectionKType(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r10) {
        return new KMutableProperty0Impl(getOwner(r10), r10.getName(), r10.getSignature(), r10.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r10) {
        return new KMutableProperty1Impl(getOwner(r10), r10.getName(), r10.getSignature(), r10.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r10) {
        return new KMutableProperty2Impl(getOwner(r10), r10.getName(), r10.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType nothingType(KType r10) {
        return TypeOfImplKt.createNothingType(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType platformType(KType r10, KType r11) {
        return TypeOfImplKt.createPlatformKType(r10, r11);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty0 property0(PropertyReference0 r10) {
        return new KProperty0Impl(getOwner(r10), r10.getName(), r10.getSignature(), r10.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty1 property1(PropertyReference1 r10) {
        return new KProperty1Impl(getOwner(r10), r10.getName(), r10.getSignature(), r10.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty2 property2(PropertyReference2 r10) {
        return new KProperty2Impl(getOwner(r10), r10.getName(), r10.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(FunctionBase r10) {
        KFunction r11 = ReflectLambdaKt.reflect(r10);
        if (r11 == null) goto L9;
        KFunctionImpl r12 = UtilKt.asKFunctionImpl(r11);
        if (r12 == null) goto L9;
        return ReflectionObjectRenderer.INSTANCE.renderLambda(r12.getDescriptor());
    L9:
        return super.renderLambdaToString(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(Lambda r10) {
        return renderLambdaToString(r10);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public void setUpperBounds(KTypeParameter r10, List<KType> r11) {
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType typeOf(KClassifier r10, List<KTypeProjection> r11, boolean r12) {
        return KClassifiers.createType(r10, r11, r12, Collections.emptyList());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KTypeParameter typeParameter(Object r10, String r11, KVariance r12, boolean r13) {
        if ((r10 instanceof KClass) == false) goto L6;
        List<KTypeParameter> r14 = ((KClass) r10).getTypeParameters();
    L8:
        Iterator<KTypeParameter> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L15;
        KTypeParameter r16 = r15.next();
        if (r16.getName().equals(r11) == false) goto L10;
        return r16;
    L15:
        throw new IllegalArgumentException("Type parameter " + r11 + " is not found in container: " + r10);
    L6:
        if ((r10 instanceof KCallable) == false) goto L17;
        r14 = ((KCallable) r10).getTypeParameters();
        goto L8
    L17:
        throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + r10);
    }
}
