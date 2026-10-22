package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationUtilKt {
    private static final Name DEPRECATED_LEVEL_NAME = null;
    private static final Name DEPRECATED_MESSAGE_NAME = null;
    private static final Name DEPRECATED_REPLACE_WITH_NAME = null;
    private static final Name REPLACE_WITH_EXPRESSION_NAME = null;
    private static final Name REPLACE_WITH_IMPORTS_NAME = null;

    static {
        Name r10 = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(r10, "identifier(\"message\")");
        DEPRECATED_MESSAGE_NAME = r10;
        Name r11 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(r11, "identifier(\"replaceWith\")");
        DEPRECATED_REPLACE_WITH_NAME = r11;
        Name r12 = Name.identifier("level");
        Intrinsics.checkNotNullExpressionValue(r12, "identifier(\"level\")");
        DEPRECATED_LEVEL_NAME = r12;
        Name r13 = Name.identifier("expression");
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(\"expression\")");
        REPLACE_WITH_EXPRESSION_NAME = r13;
        Name r14 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(r14, "identifier(\"imports\")");
        REPLACE_WITH_IMPORTS_NAME = r14;
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(final KotlinBuiltIns r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r12, "replaceWith");
        Intrinsics.checkNotNullParameter(r13, "level");
        BuiltInAnnotationDescriptor r14 = new BuiltInAnnotationDescriptor(r10, StandardNames.FqNames.replaceWith, MapsKt.mapOf(new Pair[]{TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(r12)), TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt.emptyList(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(r10)))}));
        FqName r15 = StandardNames.FqNames.deprecated;
        Name r16 = DEPRECATED_LEVEL_NAME;
        ClassId r17 = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        Intrinsics.checkNotNullExpressionValue(r17, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name r18 = Name.identifier(r13);
        Intrinsics.checkNotNullExpressionValue(r18, "identifier(level)");
        return new BuiltInAnnotationDescriptor(r10, r15, MapsKt.mapOf(new Pair[]{TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(r11)), TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(r14)), TuplesKt.to(r16, new EnumValue(r17, r18))}));
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = "";
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = "WARNING";
    L9:
        return createDeprecatedAnnotation(r10, r11, r12, r13);
    }
}
