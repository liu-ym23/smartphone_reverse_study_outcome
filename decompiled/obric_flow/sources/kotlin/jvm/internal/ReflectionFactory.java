package kotlin.jvm.internal;

import java.util.List;
import kotlin.SinceKotlin;
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

/* JADX INFO: loaded from: classes3.dex */
public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public ReflectionFactory() {
    }

    public KClass createKotlinClass(Class r5) {
        return new ClassReference(r5);
    }

    public KFunction function(FunctionReference r5) {
        return r5;
    }

    public KClass getOrCreateKotlinClass(Class r5) {
        return new ClassReference(r5);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class r5, String r10) {
        return new PackageReference(r5, r10);
    }

    @SinceKotlin(version = "1.6")
    public KType mutableCollectionType(KType r5) {
        TypeReference r10 = (TypeReference) r5;
        return new TypeReference(r5.getClassifier(), r5.getArguments(), r10.getPlatformTypeUpperBound$kotlin_stdlib(), r10.getFlags$kotlin_stdlib() | 2);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r5) {
        return r5;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r5) {
        return r5;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r5) {
        return r5;
    }

    @SinceKotlin(version = "1.6")
    public KType nothingType(KType r5) {
        TypeReference r10 = (TypeReference) r5;
        return new TypeReference(r5.getClassifier(), r5.getArguments(), r10.getPlatformTypeUpperBound$kotlin_stdlib(), r10.getFlags$kotlin_stdlib() | 4);
    }

    @SinceKotlin(version = "1.6")
    public KType platformType(KType r5, KType r10) {
        return new TypeReference(r5.getClassifier(), r5.getArguments(), r10, ((TypeReference) r5).getFlags$kotlin_stdlib());
    }

    public KProperty0 property0(PropertyReference0 r5) {
        return r5;
    }

    public KProperty1 property1(PropertyReference1 r5) {
        return r5;
    }

    public KProperty2 property2(PropertyReference2 r5) {
        return r5;
    }

    @SinceKotlin(version = "1.1")
    public String renderLambdaToString(Lambda r5) {
        return renderLambdaToString(r5);
    }

    @SinceKotlin(version = "1.4")
    public void setUpperBounds(KTypeParameter r5, List<KType> r10) {
        ((TypeParameterReference) r5).setUpperBounds(r10);
    }

    @SinceKotlin(version = "1.4")
    public KType typeOf(KClassifier r5, List<KTypeProjection> r10, boolean r11) {
        return new TypeReference(r5, r10, r11);
    }

    @SinceKotlin(version = "1.4")
    public KTypeParameter typeParameter(Object r5, String r10, KVariance r11, boolean r12) {
        return new TypeParameterReference(r5, r10, r11, r12);
    }

    public KClass createKotlinClass(Class r5, String r10) {
        return new ClassReference(r5);
    }

    public KClass getOrCreateKotlinClass(Class r5, String r10) {
        return new ClassReference(r5);
    }

    @SinceKotlin(version = "1.3")
    public String renderLambdaToString(FunctionBase r5) {
        String r10 = r5.getClass().getGenericInterfaces()[0].toString();
        if (r10.startsWith(KOTLIN_JVM_FUNCTIONS) == true) goto L5;
        return r10;
    L5:
        return r10.substring(21);
    }
}
