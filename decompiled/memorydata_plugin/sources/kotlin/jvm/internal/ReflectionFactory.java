package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
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

/* JADX INFO: loaded from: classes6.dex */
public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public ReflectionFactory() {
    }

    public KClass createKotlinClass(Class r1) {
        return new ClassReference(r1);
    }

    public KClass createKotlinClass(Class r1, String r2) {
        return new ClassReference(r1);
    }

    public KFunction function(FunctionReference r1) {
        return r1;
    }

    public KClass getOrCreateKotlinClass(Class r1) {
        return new ClassReference(r1);
    }

    public KClass getOrCreateKotlinClass(Class r1, String r2) {
        return new ClassReference(r1);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class r1, String r2) {
        return new PackageReference(r1, r2);
    }

    public KType mutableCollectionType(KType r4) {
        KType r3 = (KType) ZeusTransformUtils.wrapperContextForParams(r4, KType.class, "com.obric.memorydata.plugin");
        TypeReference r5 = (TypeReference) ZeusTransformUtils.preCheckCast(r3, TypeReference.class, "com.obric.memorydata.plugin");
        return new TypeReference(r3.getClassifier(), r3.getArguments(), r5.getPlatformTypeUpperBound$kotlin_stdlib(), r5.getFlags$kotlin_stdlib() | 2);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r1) {
        return r1;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r1) {
        return r1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r1) {
        return r1;
    }

    public KType nothingType(KType r4) {
        KType r3 = (KType) ZeusTransformUtils.wrapperContextForParams(r4, KType.class, "com.obric.memorydata.plugin");
        TypeReference r5 = (TypeReference) ZeusTransformUtils.preCheckCast(r3, TypeReference.class, "com.obric.memorydata.plugin");
        return new TypeReference(r3.getClassifier(), r3.getArguments(), r5.getPlatformTypeUpperBound$kotlin_stdlib(), r5.getFlags$kotlin_stdlib() | 4);
    }

    public KType platformType(KType r5, KType r6) {
        KType r4 = (KType) ZeusTransformUtils.wrapperContextForParams(r5, KType.class, "com.obric.memorydata.plugin");
        KType r7 = (KType) ZeusTransformUtils.wrapperContextForParams(r6, KType.class, "com.obric.memorydata.plugin");
        return new TypeReference(r4.getClassifier(), r4.getArguments(), r7, ((TypeReference) ZeusTransformUtils.preCheckCast(r4, TypeReference.class, "com.obric.memorydata.plugin")).getFlags$kotlin_stdlib());
    }

    public KProperty0 property0(PropertyReference0 r1) {
        return r1;
    }

    public KProperty1 property1(PropertyReference1 r1) {
        return r1;
    }

    public KProperty2 property2(PropertyReference2 r1) {
        return r1;
    }

    public String renderLambdaToString(FunctionBase r2) {
        String r1 = ((FunctionBase) ZeusTransformUtils.wrapperContextForParams(r2, FunctionBase.class, "com.obric.memorydata.plugin")).getClass().getGenericInterfaces()[0].toString();
        if (r1.startsWith(KOTLIN_JVM_FUNCTIONS) == true) goto L5;
        return r1;
    L5:
        return r1.substring(21);
    }

    public String renderLambdaToString(Lambda r1) {
        return renderLambdaToString(r1);
    }

    public void setUpperBounds(KTypeParameter r2, List<KType> r3) {
        KTypeParameter r1 = (KTypeParameter) ZeusTransformUtils.wrapperContextForParams(r2, KTypeParameter.class, "com.obric.memorydata.plugin");
        List<? extends KType> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ((TypeParameterReference) ZeusTransformUtils.preCheckCast(r1, TypeParameterReference.class, "com.obric.memorydata.plugin")).setUpperBounds(r4);
    }

    public KType typeOf(KClassifier r2, List<KTypeProjection> r3, boolean r4) {
        return new TypeReference((KClassifier) ZeusTransformUtils.wrapperContextForParams(r2, KClassifier.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    public KTypeParameter typeParameter(Object r1, String r2, KVariance r3, boolean r4) {
        return new TypeParameterReference(r1, r2, r3, r4);
    }
}
