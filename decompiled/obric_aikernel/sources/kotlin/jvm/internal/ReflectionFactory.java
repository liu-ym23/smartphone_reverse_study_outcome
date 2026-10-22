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

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public ReflectionFactory() {
    }

    public KClass createKotlinClass(Class r10) {
        return new ClassReference(r10);
    }

    public KClass createKotlinClass(Class r10, String r11) {
        return new ClassReference(r10);
    }

    public KFunction function(FunctionReference r10) {
        return r10;
    }

    public KClass getOrCreateKotlinClass(Class r10) {
        return new ClassReference(r10);
    }

    public KClass getOrCreateKotlinClass(Class r10, String r11) {
        return new ClassReference(r10);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class r10, String r11) {
        return new PackageReference(r10, r11);
    }

    @SinceKotlin(version = "1.6")
    public KType mutableCollectionType(KType r10) {
        TypeReference r11 = (TypeReference) r10;
        return new TypeReference(r10.getClassifier(), r10.getArguments(), r11.getPlatformTypeUpperBound$kotlin_stdlib(), r11.getFlags$kotlin_stdlib() | 2);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r10) {
        return r10;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r10) {
        return r10;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r10) {
        return r10;
    }

    @SinceKotlin(version = "1.6")
    public KType nothingType(KType r10) {
        TypeReference r11 = (TypeReference) r10;
        return new TypeReference(r10.getClassifier(), r10.getArguments(), r11.getPlatformTypeUpperBound$kotlin_stdlib(), r11.getFlags$kotlin_stdlib() | 4);
    }

    @SinceKotlin(version = "1.6")
    public KType platformType(KType r10, KType r11) {
        return new TypeReference(r10.getClassifier(), r10.getArguments(), r11, ((TypeReference) r10).getFlags$kotlin_stdlib());
    }

    public KProperty0 property0(PropertyReference0 r10) {
        return r10;
    }

    public KProperty1 property1(PropertyReference1 r10) {
        return r10;
    }

    public KProperty2 property2(PropertyReference2 r10) {
        return r10;
    }

    @SinceKotlin(version = "1.3")
    public String renderLambdaToString(FunctionBase r10) {
        String r11 = r10.getClass().getGenericInterfaces()[0].toString();
        if (r11.startsWith(KOTLIN_JVM_FUNCTIONS) == true) goto L5;
        return r11;
    L5:
        return r11.substring(21);
    }

    @SinceKotlin(version = "1.1")
    public String renderLambdaToString(Lambda r10) {
        return renderLambdaToString(r10);
    }

    @SinceKotlin(version = "1.4")
    public void setUpperBounds(KTypeParameter r10, List<KType> r11) {
        ((TypeParameterReference) r10).setUpperBounds(r11);
    }

    @SinceKotlin(version = "1.4")
    public KType typeOf(KClassifier r10, List<KTypeProjection> r11, boolean r12) {
        return new TypeReference(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    public KTypeParameter typeParameter(Object r10, String r11, KVariance r12, boolean r13) {
        return new TypeParameterReference(r10, r11, r12, r13);
    }
}
