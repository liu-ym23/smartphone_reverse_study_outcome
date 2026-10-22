package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsSignatures {
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES = null;
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> HIDDEN_METHOD_SIGNATURES = null;
    public static final JvmBuiltInsSignatures INSTANCE = null;
    private static final Set<String> MUTABLE_METHOD_SIGNATURES = null;
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> VISIBLE_METHOD_SIGNATURES = null;

    static {
        JvmBuiltInsSignatures r10 = new JvmBuiltInsSignatures();
        INSTANCE = r10;
        SignatureBuildingComponents r11 = SignatureBuildingComponents.INSTANCE;
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus(r11.inJavaUtil("Collection", new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        HIDDEN_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r10.buildPrimitiveValueMethodsSet(), r11.inJavaUtil("List", new String[]{"sort(Ljava/util/Comparator;)V"})), r11.inJavaLang("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), r11.inJavaLang("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), r11.inJavaLang("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), r11.inJavaLang("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"})), r11.inJavaLang("CharSequence", new String[]{"isEmpty()Z"}));
        VISIBLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r11.inJavaLang("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), r11.inJavaUtil("Iterator", new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"})), r11.inJavaLang("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), r11.inJavaLang("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), r11.inJavaUtil("Collection", new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"})), r11.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V"})), r11.inJavaUtil("Map", new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}));
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(r11.inJavaUtil("Collection", new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}), r11.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"})), r11.inJavaUtil("Map", new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}));
        Set<String> r12 = r10.buildPrimitiveStringConstructorsSet();
        String[] r13 = r11.constructors(new String[]{"D"});
        Set r14 = SetsKt.plus(r12, r11.inJavaLang("Float", (String[]) Arrays.copyOf(r13, r13.length)));
        String[] r15 = r11.constructors(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        HIDDEN_CONSTRUCTOR_SIGNATURES = SetsKt.plus(r14, r11.inJavaLang("String", (String[]) Arrays.copyOf(r15, r15.length)));
        String[] r16 = r11.constructors(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        VISIBLE_CONSTRUCTOR_SIGNATURES = r11.inJavaLang("Throwable", (String[]) Arrays.copyOf(r16, r16.length));
    }

    private JvmBuiltInsSignatures() {
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType r11 = JvmPrimitiveType.BYTE;
        List r12 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, r11, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, r11, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        LinkedHashSet r13 = new LinkedHashSet();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        String r15 = ((JvmPrimitiveType) r14.next()).getWrapperFqName().shortName().asString();
        Intrinsics.checkNotNullExpressionValue(r15, "it.wrapperFqName.shortName().asString()");
        String[] r16 = r10.constructors(new String[]{"Ljava/lang/String;"});
        CollectionsKt.addAll(r13, r10.inJavaLang(r15, (String[]) Arrays.copyOf(r16, r16.length)));
        goto L4
    L6:
        return r13;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        List r11 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        JvmPrimitiveType r14 = (JvmPrimitiveType) r13.next();
        String r15 = r14.getWrapperFqName().shortName().asString();
        Intrinsics.checkNotNullExpressionValue(r15, "it.wrapperFqName.shortName().asString()");
        CollectionsKt.addAll(r12, r10.inJavaLang(r15, new String[]{r14.getJavaKeywordName() + "Value()" + r14.getDesc()}));
        goto L4
    L6:
        return r12;
    }

    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if (Intrinsics.areEqual(r10, StandardNames.FqNames.array) == false) goto L5;
    L8:
        return true;
    L5:
        if (StandardNames.isPrimitiveArray(r10) == true) goto L8;
        return false;
    }

    public final boolean isSerializableInJava(FqNameUnsafe r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if (isArrayOrPrimitiveArray(r10) == false) goto L6;
        return true;
    L6:
        ClassId r11 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r10);
        if (r11 != null) goto L13;
        return false;
    L13:
        return Serializable.class.isAssignableFrom(Class.forName(r11.asSingleFqName().asString()));
    L12:
        return false;
    }
}
