package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmBuiltInsSignatures {
    private static final Set<String> DEPRECATED_LIST_METHODS = null;
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES = null;
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> HIDDEN_METHOD_SIGNATURES = null;
    public static final JvmBuiltInsSignatures INSTANCE = null;
    private static final Set<String> MUTABLE_METHOD_SIGNATURES = null;
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> VISIBLE_METHOD_SIGNATURES = null;

    private JvmBuiltInsSignatures() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        JvmBuiltInsSignatures r0 = new JvmBuiltInsSignatures();
        INSTANCE = r0;
        SignatureBuildingComponents r1 = SignatureBuildingComponents.INSTANCE;
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus(r1.inJavaUtil("Collection", new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        HIDDEN_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r0.buildPrimitiveValueMethodsSet(), r1.inJavaUtil("List", new String[]{"sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;"})), r1.inJavaLang("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), r1.inJavaLang("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), r1.inJavaLang("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), r1.inJavaLang("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"})), r1.inJavaLang("CharSequence", new String[]{"isEmpty()Z"}));
        DEPRECATED_LIST_METHODS = r1.inJavaUtil("List", new String[]{"getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;"});
        VISIBLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r1.inJavaLang("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), r1.inJavaUtil("Iterator", new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"})), r1.inJavaLang("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), r1.inJavaLang("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), r1.inJavaUtil("Collection", new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"})), r1.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;"})), r1.inJavaUtil("Map", new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}));
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(r1.inJavaUtil("Collection", new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}), r1.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;"})), r1.inJavaUtil("Map", new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}));
        Set<String> r2 = r0.buildPrimitiveStringConstructorsSet();
        String[] r3 = r1.constructors(new String[]{"D"});
        Set r4 = SetsKt.plus(r2, r1.inJavaLang("Float", (String[]) Arrays.copyOf(r3, r3.length)));
        String[] r5 = r1.constructors(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        HIDDEN_CONSTRUCTOR_SIGNATURES = SetsKt.plus(r4, r1.inJavaLang("String", (String[]) Arrays.copyOf(r5, r5.length)));
        String[] r6 = r1.constructors(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        VISIBLE_CONSTRUCTOR_SIGNATURES = r1.inJavaLang("Throwable", (String[]) Arrays.copyOf(r6, r6.length));
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        SignatureBuildingComponents r0 = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType r2 = JvmPrimitiveType.BYTE;
        List r1 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, r2, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, r2, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        LinkedHashSet r3 = new LinkedHashSet();
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r5 = ((JvmPrimitiveType) r4.next()).getWrapperFqName().shortName().asString();
        String[] r6 = r0.constructors(new String[]{"Ljava/lang/String;"});
        CollectionsKt.addAll(r3, r0.inJavaLang(r5, (String[]) Arrays.copyOf(r6, r6.length)));
        goto L4
    L6:
        return r3;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        SignatureBuildingComponents r0 = SignatureBuildingComponents.INSTANCE;
        List r1 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        LinkedHashSet r2 = new LinkedHashSet();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        JvmPrimitiveType r5 = (JvmPrimitiveType) r3.next();
        CollectionsKt.addAll(r2, r0.inJavaLang(r5.getWrapperFqName().shortName().asString(), new String[]{r5.getJavaKeywordName() + "Value()" + r5.getDesc()}));
        goto L4
    L6:
        return r2;
    }

    public final Set<String> getDEPRECATED_LIST_METHODS() {
        return DEPRECATED_LIST_METHODS;
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

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_kotlin_reflect_jvm_internal_impl_builtins_jvm_JvmBuiltInsSignatures_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (Intrinsics.areEqual(r2, StandardNames.FqNames.array) == false) goto L5;
    L8:
        return true;
    L5:
        if (StandardNames.isPrimitiveArray(r2) == true) goto L8;
        return false;
    }

    public final boolean isSerializableInJava(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (isArrayOrPrimitiveArray(r2) == false) goto L6;
        return true;
    L6:
        ClassId r3 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r2);
        if (r3 != null) goto L13;
        return false;
    L13:
        return Serializable.class.isAssignableFrom(INVOKESTATIC_kotlin_reflect_jvm_internal_impl_builtins_jvm_JvmBuiltInsSignatures_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3.asSingleFqName().asString()));
    L12:
        return false;
    }
}
