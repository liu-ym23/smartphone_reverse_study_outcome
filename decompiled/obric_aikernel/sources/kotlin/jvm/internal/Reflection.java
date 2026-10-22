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

/* JADX INFO: loaded from: classes2.dex */
public class Reflection {
    private static final KClass[] EMPTY_K_CLASS_ARRAY = null;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
    private static final ReflectionFactory factory = null;

    static {
        ReflectionFactory r10 = null;
        r10 = (ReflectionFactory) ReflectionFactoryImpl.class.newInstance();     // Catch: Throwable -> L10
    L5:
        if (r10 != null) goto L8;
        r10 = new ReflectionFactory();
    L8:
        factory = r10;
        EMPTY_K_CLASS_ARRAY = new KClass[0];
    }

    public Reflection() {
    }

    public static KClass createKotlinClass(Class r10) {
        return factory.createKotlinClass(r10);
    }

    public static KClass createKotlinClass(Class r10, String r11) {
        return factory.createKotlinClass(r10, r11);
    }

    public static KFunction function(FunctionReference r10) {
        return factory.function(r10);
    }

    public static KClass getOrCreateKotlinClass(Class r10) {
        return factory.getOrCreateKotlinClass(r10);
    }

    public static KClass getOrCreateKotlinClass(Class r10, String r11) {
        return factory.getOrCreateKotlinClass(r10, r11);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] r10) {
        int r11 = r10.length;
        if (r11 == 0) goto L5;
        KClass[] r12 = new KClass[r11];
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        r12[r13] = getOrCreateKotlinClass(r10[r13]);
        r13 = r13 + 1;
        goto L7
    L9:
        return r12;
    L5:
        return EMPTY_K_CLASS_ARRAY;
    }

    @SinceKotlin(version = "1.4")
    public static KDeclarationContainer getOrCreateKotlinPackage(Class r10) {
        return factory.getOrCreateKotlinPackage(r10, "");
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class r10, String r11) {
        return factory.getOrCreateKotlinPackage(r10, r11);
    }

    @SinceKotlin(version = "1.6")
    public static KType mutableCollectionType(KType r10) {
        return factory.mutableCollectionType(r10);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 r10) {
        return factory.mutableProperty0(r10);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 r10) {
        return factory.mutableProperty1(r10);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 r10) {
        return factory.mutableProperty2(r10);
    }

    @SinceKotlin(version = "1.6")
    public static KType nothingType(KType r10) {
        return factory.nothingType(r10);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r10) {
        return factory.typeOf(getOrCreateKotlinClass(r10), Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r10, KTypeProjection r11) {
        return factory.typeOf(getOrCreateKotlinClass(r10), Collections.singletonList(r11), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r10, KTypeProjection r11, KTypeProjection r12) {
        return factory.typeOf(getOrCreateKotlinClass(r10), Arrays.asList(new KTypeProjection[]{r11, r12}), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(Class r10, KTypeProjection... r11) {
        return factory.typeOf(getOrCreateKotlinClass(r10), ArraysKt.toList(r11), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType nullableTypeOf(KClassifier r10) {
        return factory.typeOf(r10, Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.6")
    public static KType platformType(KType r10, KType r11) {
        return factory.platformType(r10, r11);
    }

    public static KProperty0 property0(PropertyReference0 r10) {
        return factory.property0(r10);
    }

    public static KProperty1 property1(PropertyReference1 r10) {
        return factory.property1(r10);
    }

    public static KProperty2 property2(PropertyReference2 r10) {
        return factory.property2(r10);
    }

    @SinceKotlin(version = "1.3")
    public static String renderLambdaToString(FunctionBase r10) {
        return factory.renderLambdaToString(r10);
    }

    @SinceKotlin(version = "1.1")
    public static String renderLambdaToString(Lambda r10) {
        return factory.renderLambdaToString(r10);
    }

    @SinceKotlin(version = "1.4")
    public static void setUpperBounds(KTypeParameter r10, KType r11) {
        factory.setUpperBounds(r10, Collections.singletonList(r11));
    }

    @SinceKotlin(version = "1.4")
    public static void setUpperBounds(KTypeParameter r10, KType... r11) {
        factory.setUpperBounds(r10, ArraysKt.toList(r11));
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r10) {
        return factory.typeOf(getOrCreateKotlinClass(r10), Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r10, KTypeProjection r11) {
        return factory.typeOf(getOrCreateKotlinClass(r10), Collections.singletonList(r11), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r10, KTypeProjection r11, KTypeProjection r12) {
        return factory.typeOf(getOrCreateKotlinClass(r10), Arrays.asList(new KTypeProjection[]{r11, r12}), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(Class r10, KTypeProjection... r11) {
        return factory.typeOf(getOrCreateKotlinClass(r10), ArraysKt.toList(r11), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType typeOf(KClassifier r10) {
        return factory.typeOf(r10, Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static KTypeParameter typeParameter(Object r10, String r11, KVariance r12, boolean r13) {
        return factory.typeParameter(r10, r11, r12, r13);
    }
}
