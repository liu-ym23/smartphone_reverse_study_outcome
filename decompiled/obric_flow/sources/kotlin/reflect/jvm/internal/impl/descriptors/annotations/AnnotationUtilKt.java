package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
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
        DEPRECATED_MESSAGE_NAME = Name.identifier("message");
        DEPRECATED_REPLACE_WITH_NAME = Name.identifier("replaceWith");
        DEPRECATED_LEVEL_NAME = Name.identifier("level");
        REPLACE_WITH_EXPRESSION_NAME = Name.identifier("expression");
        REPLACE_WITH_IMPORTS_NAME = Name.identifier("imports");
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(final KotlinBuiltIns r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r12, "replaceWith");
        Intrinsics.checkNotNullParameter(r13, "level");
        BuiltInAnnotationDescriptor r5 = new BuiltInAnnotationDescriptor(r10, StandardNames.FqNames.replaceWith, MapsKt.mapOf(new Pair[]{TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(r12)), TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt.emptyList(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(r10)))}));
        return new BuiltInAnnotationDescriptor(r10, StandardNames.FqNames.deprecated, MapsKt.mapOf(new Pair[]{TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(r11)), TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(r5)), TuplesKt.to(DEPRECATED_LEVEL_NAME, new EnumValue(ClassId.topLevel(StandardNames.FqNames.deprecationLevel), Name.identifier(r13)))}));
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns r5, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = "";
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = "WARNING";
    L9:
        return createDeprecatedAnnotation(r5, r10, r11, r12);
    }
}
