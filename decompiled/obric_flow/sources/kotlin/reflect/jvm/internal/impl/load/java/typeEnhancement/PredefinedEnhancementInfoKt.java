package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder\n*L\n1#1,254:1\n201#1:256\n13#2:255\n207#3:257\n207#3:258\n207#3:259\n207#3:260\n207#3:261\n207#3:262\n207#3:263\n207#3:264\n207#3:265\n207#3:266\n207#3:267\n207#3:268\n207#3:269\n207#3:270\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n*L\n52#1:256\n41#1:255\n53#1:257\n58#1:258\n63#1:259\n75#1:260\n80#1:261\n128#1:262\n148#1:263\n154#1:264\n160#1:265\n167#1:266\n172#1:267\n178#1:268\n184#1:269\n191#1:270\n*E\n"})
public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers NOT_NULLABLE = null;
    private static final JavaTypeQualifiers NOT_PLATFORM = null;
    private static final JavaTypeQualifiers NULLABLE = null;
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = null;

    static {
        NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
        NullabilityQualifier r5 = NullabilityQualifier.NOT_NULL;
        NOT_PLATFORM = new JavaTypeQualifiers(r5, null, false, false, 8, null);
        NOT_NULLABLE = new JavaTypeQualifiers(r5, null, true, false, 8, null);
        final SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        final String r11 = r10.javaLang("Object");
        final String r12 = r10.javaFunction("Predicate");
        final String r13 = r10.javaFunction("Function");
        final String r14 = r10.javaFunction("Consumer");
        final String r15 = r10.javaFunction("BiFunction");
        final String r16 = r10.javaFunction("BiConsumer");
        final String r17 = r10.javaFunction("UnaryOperator");
        final String r18 = r10.javaUtil("stream/Stream");
        final String r19 = r10.javaUtil("Optional");
        SignatureEnhancementBuilder r110 = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaUtil("Iterator")).function("forEachRemaining", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1(r14));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaLang("Iterable")).function("spliterator", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1(r10));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r111 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaUtil("Collection"));
        r111.function("removeIf", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1(r12));
        r111.function("stream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2(r18));
        r111.function("parallelStream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3(r18));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaUtil("List")).function("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1(r17));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r112 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaUtil("Map"));
        r112.function("forEach", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1(r16));
        r112.function("putIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2(r11));
        r112.function("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3(r11));
        r112.function("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4(r11));
        r112.function("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(r15));
        r112.function("compute", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6(r11, r15));
        r112.function("computeIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7(r11, r13));
        r112.function("computeIfPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8(r11, r15));
        r112.function("merge", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9(r11, r15));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r20 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r19);
        r20.function("empty", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1(r19));
        r20.function("of", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2(r11, r19));
        r20.function("ofNullable", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3(r11, r19));
        r20.function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4(r11));
        r20.function("ifPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5(r14));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaLang("ref/Reference")).function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r12).function("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaFunction("BiPredicate")).function("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r14).function("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r16).function("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r13).function("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r15).function("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1(r11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r10.javaFunction("Supplier")).function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1(r11));
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = r110.build();
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNOT_NULLABLE$p() {
        return NOT_NULLABLE;
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNOT_PLATFORM$p() {
        return NOT_PLATFORM;
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNULLABLE$p() {
        return NULLABLE;
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
