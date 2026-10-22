package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
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
import kotlin.reflect.jvm.internal.ReflectionFactoryImpl;

/* JADX INFO: loaded from: classes3.dex */
public class Reflection {
    private static final KClass[] EMPTY_K_CLASS_ARRAY = null;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
    private static final ReflectionFactory factory = null;

    static {
        ReflectionFactory r5 = null;
        r5 = (ReflectionFactory) ReflectionFactoryImpl.class.newInstance();     // Catch: Throwable -> L10
    L5:
        if (r5 != null) goto L8;
        r5 = new ReflectionFactory();
    L8:
        factory = r5;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public Reflection() {
    }

    public static KClass createKotlinClass(Class r5) {
        return factory.createKotlinClass(r5);
    }

    public static KFunction function(FunctionReference r5) {
        return factory.function(r5);
    }

    public static KClass getOrCreateKotlinClass(Class r5) {
        return factory.getOrCreateKotlinClass(r5);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] r5) {
        int r10 = r5.length;
        if (r10 == 0) goto L5;
        KClass[] r11 = new KClass[r10];
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        r11[r12] = getOrCreateKotlinClass(r5[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    L5:
        return EMPTY_K_CLASS_ARRAY;
    }

    @SinceKotlin(version = "1.4")
    public static KDeclarationContainer getOrCreateKotlinPackage(Class r5) {
        return factory.getOrCreateKotlinPackage(r5, "");
    }

    @SinceKotlin(version = "1.6")
    public static KType mutableCollectionType(KType r5) {
        return factory.mutableCollectionType(r5);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 r5) {
        return factory.mutableProperty0(r5);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 r5) {
        return factory.mutableProperty1(r5);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 r5) {
        return factory.mutableProperty2(r5);
    }

    @SinceKotlin(version = "1.6")
    public static KType nothingType(KType r5) {
        return factory.nothingType(r5);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(KClassifier r5) {
        return factory.typeOf(r5, Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.6")
    public static KType platformType(KType r5, KType r10) {
        return factory.platformType(r5, r10);
    }

    public static KProperty0 property0(PropertyReference0 r5) {
        return factory.property0(r5);
    }

    public static KProperty1 property1(PropertyReference1 r5) {
        return factory.property1(r5);
    }

    public static KProperty2 property2(PropertyReference2 r5) {
        return factory.property2(r5);
    }

    @SinceKotlin(version = "1.1")
    public static String renderLambdaToString(Lambda r5) {
        return factory.renderLambdaToString(r5);
    }

    @SinceKotlin(version = "1.4")
    public static void setUpperBounds(KTypeParameter r5, KType r10) {
        factory.setUpperBounds(r5, Collections.singletonList(r10));
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(KClassifier r5) {
        return factory.typeOf(r5, Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static KTypeParameter typeParameter(Object r5, String r10, KVariance r11, boolean r12) {
        return factory.typeParameter(r5, r10, r11, r12);
    }

    public static KClass createKotlinClass(Class r5, String r10) {
        return factory.createKotlinClass(r5, r10);
    }

    public static KClass getOrCreateKotlinClass(Class r5, String r10) {
        return factory.getOrCreateKotlinClass(r5, r10);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class r5, String r10) {
        return factory.getOrCreateKotlinPackage(r5, r10);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r5) {
        return factory.typeOf(getOrCreateKotlinClass(r5), Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.3")
    public static String renderLambdaToString(FunctionBase r5) {
        return factory.renderLambdaToString(r5);
    }

    @SinceKotlin(version = "1.4")
    public static void setUpperBounds(KTypeParameter r5, KType... r10) {
        factory.setUpperBounds(r5, ArraysKt.toList(r10));
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r5) {
        return factory.typeOf(getOrCreateKotlinClass(r5), Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r5, KTypeProjection r10) {
        return factory.typeOf(getOrCreateKotlinClass(r5), Collections.singletonList(r10), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r5, KTypeProjection r10) {
        return factory.typeOf(getOrCreateKotlinClass(r5), Collections.singletonList(r10), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r5, KTypeProjection r10, KTypeProjection r11) {
        return factory.typeOf(getOrCreateKotlinClass(r5), Arrays.asList(new KTypeProjection[]{r10, r11}), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r5, KTypeProjection r10, KTypeProjection r11) {
        return factory.typeOf(getOrCreateKotlinClass(r5), Arrays.asList(new KTypeProjection[]{r10, r11}), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r5, KTypeProjection... r10) {
        return factory.typeOf(getOrCreateKotlinClass(r5), ArraysKt.toList(r10), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r5, KTypeProjection... r10) {
        return factory.typeOf(getOrCreateKotlinClass(r5), ArraysKt.toList(r10), false);
    }
}
