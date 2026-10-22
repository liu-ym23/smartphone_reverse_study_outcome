package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers NOT_NULLABLE = null;
    private static final JavaTypeQualifiers NOT_PLATFORM = null;
    private static final JavaTypeQualifiers NULLABLE = null;
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = null;

    static {
        NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
        NullabilityQualifier r10 = NullabilityQualifier.NOT_NULL;
        NOT_PLATFORM = new JavaTypeQualifiers(r10, null, false, false, 8, null);
        NOT_NULLABLE = new JavaTypeQualifiers(r10, null, true, false, 8, null);
        final SignatureBuildingComponents r11 = SignatureBuildingComponents.INSTANCE;
        final String r12 = r11.javaLang("Object");
        final String r13 = r11.javaFunction("Predicate");
        final String r14 = r11.javaFunction("Function");
        final String r15 = r11.javaFunction("Consumer");
        final String r16 = r11.javaFunction("BiFunction");
        final String r17 = r11.javaFunction("BiConsumer");
        final String r18 = r11.javaFunction("UnaryOperator");
        final String r19 = r11.javaUtil("stream/Stream");
        final String r20 = r11.javaUtil("Optional");
        SignatureEnhancementBuilder r110 = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaUtil("Iterator")).function("forEachRemaining", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1(r15));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaLang("Iterable")).function("spliterator", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1(r11));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r111 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaUtil("Collection"));
        r111.function("removeIf", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1(r13));
        r111.function("stream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2(r19));
        r111.function("parallelStream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3(r19));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaUtil("List")).function("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1(r18));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r112 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaUtil("Map"));
        r112.function("forEach", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1(r17));
        r112.function("putIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2(r12));
        r112.function("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3(r12));
        r112.function("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4(r12));
        r112.function("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(r16));
        r112.function("compute", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6(r12, r16));
        r112.function("computeIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7(r12, r14));
        r112.function("computeIfPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8(r12, r16));
        r112.function("merge", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9(r12, r16));
        SignatureEnhancementBuilder.ClassEnhancementBuilder r21 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r20);
        r21.function("empty", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1(r20));
        r21.function("of", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2(r12, r20));
        r21.function("ofNullable", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3(r12, r20));
        r21.function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4(r12));
        r21.function("ifPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5(r15));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaLang("ref/Reference")).function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r13).function("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaFunction("BiPredicate")).function("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r15).function("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r17).function("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r14).function("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r16).function("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1(r12));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(r110, r11.javaFunction("Supplier")).function("get", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1(r12));
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
