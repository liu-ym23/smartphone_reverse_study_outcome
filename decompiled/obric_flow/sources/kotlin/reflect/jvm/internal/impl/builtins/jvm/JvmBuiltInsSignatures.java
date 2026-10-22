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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmBuiltInsSignatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmBuiltInsSignatures.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSignatures\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,187:1\n13#2:188\n13#2:194\n13#2:200\n13#2:201\n13#2:202\n13#2:203\n13#2:204\n1446#3,5:189\n1446#3,5:195\n*S KotlinDebug\n*F\n+ 1 JvmBuiltInsSignatures.kt\norg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSignatures\n*L\n60#1:188\n160#1:194\n24#1:200\n68#1:201\n119#1:202\n138#1:203\n155#1:204\n61#1:189,5\n164#1:195,5\n*E\n"})
public final class JvmBuiltInsSignatures {
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES = null;
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> HIDDEN_METHOD_SIGNATURES = null;
    public static final JvmBuiltInsSignatures INSTANCE = null;
    private static final Set<String> MUTABLE_METHOD_SIGNATURES = null;
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> VISIBLE_METHOD_SIGNATURES = null;

    static {
        JvmBuiltInsSignatures r5 = new JvmBuiltInsSignatures();
        INSTANCE = r5;
        SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus(r10.inJavaUtil("Collection", new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        HIDDEN_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r5.buildPrimitiveValueMethodsSet(), r10.inJavaUtil("List", new String[]{"sort(Ljava/util/Comparator;)V"})), r10.inJavaLang("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), r10.inJavaLang("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), r10.inJavaLang("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), r10.inJavaLang("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"})), r10.inJavaLang("CharSequence", new String[]{"isEmpty()Z"}));
        VISIBLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r10.inJavaLang("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), r10.inJavaUtil("Iterator", new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"})), r10.inJavaLang("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), r10.inJavaLang("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), r10.inJavaUtil("Collection", new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"})), r10.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V"})), r10.inJavaUtil("Map", new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}));
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(r10.inJavaUtil("Collection", new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}), r10.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"})), r10.inJavaUtil("Map", new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}));
        Set<String> r11 = r5.buildPrimitiveStringConstructorsSet();
        String[] r12 = r10.constructors(new String[]{"D"});
        Set r13 = SetsKt.plus(r11, r10.inJavaLang("Float", (String[]) Arrays.copyOf(r12, r12.length)));
        String[] r14 = r10.constructors(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        HIDDEN_CONSTRUCTOR_SIGNATURES = SetsKt.plus(r13, r10.inJavaLang("String", (String[]) Arrays.copyOf(r14, r14.length)));
        String[] r15 = r10.constructors(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        VISIBLE_CONSTRUCTOR_SIGNATURES = r10.inJavaLang("Throwable", (String[]) Arrays.copyOf(r15, r15.length));
    }

    private JvmBuiltInsSignatures() {
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType r5 = JvmPrimitiveType.BOOLEAN;
        JvmPrimitiveType r11 = JvmPrimitiveType.BYTE;
        List r12 = CollectionsKt.listOf(new JvmPrimitiveType[]{r5, r11, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, r11, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        LinkedHashSet r13 = new LinkedHashSet();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        String r15 = ((JvmPrimitiveType) r14.next()).getWrapperFqName().shortName().asString();
        String[] r16 = r10.constructors(new String[]{"Ljava/lang/String;"});
        CollectionsKt.a(r13, r10.inJavaLang(r15, (String[]) Arrays.copyOf(r16, r16.length)));
        goto L4
    L6:
        return r13;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        List r5 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        JvmPrimitiveType r13 = (JvmPrimitiveType) r12.next();
        CollectionsKt.a(r11, r10.inJavaLang(r13.getWrapperFqName().shortName().asString(), new String[]{r13.getJavaKeywordName() + "Value()" + r13.getDesc()}));
        goto L4
    L6:
        return r11;
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

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (Intrinsics.areEqual(r5, StandardNames.FqNames.array) == false) goto L5;
    L8:
        return true;
    L5:
        if (StandardNames.isPrimitiveArray(r5) == true) goto L8;
        return false;
    }

    public final boolean isSerializableInJava(FqNameUnsafe r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (isArrayOrPrimitiveArray(r5) == false) goto L6;
        return true;
    L6:
        ClassId r10 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r5);
        if (r10 != null) goto L13;
        return false;
    L13:
        return Serializable.class.isAssignableFrom(Class.forName(r10.asSingleFqName().asString()));
    L12:
        return false;
    }
}
