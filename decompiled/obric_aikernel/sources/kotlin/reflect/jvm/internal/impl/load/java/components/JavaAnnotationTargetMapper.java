package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaAnnotationTargetMapper {
    public static final JavaAnnotationTargetMapper INSTANCE = null;
    private static final Map<String, KotlinRetention> retentionNameList = null;
    private static final Map<String, EnumSet<KotlinTarget>> targetNameLists = null;

    static {
        INSTANCE = new JavaAnnotationTargetMapper();
        targetNameLists = MapsKt.mapOf(new Pair[]{TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE))});
        retentionNameList = MapsKt.mapOf(new Pair[]{TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE)});
    }

    private JavaAnnotationTargetMapper() {
    }

    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationArgument r10) {
        if ((r10 instanceof JavaEnumValueAnnotationArgument) == false) goto L5;
        JavaEnumValueAnnotationArgument r11 = (JavaEnumValueAnnotationArgument) r10;
    L6:
        if (r11 == null) goto L15;
        Map<String, KotlinRetention> r12 = retentionNameList;
        Name r13 = r11.getEntryName();
        if (r13 == null) goto L10;
        String r14 = r13.asString();
    L11:
        KotlinRetention r15 = r12.get(r14);
        if (r15 == null) goto L16;
        ClassId r16 = ClassId.topLevel(StandardNames.FqNames.annotationRetention);
        Intrinsics.checkNotNullExpressionValue(r16, "topLevel(StandardNames.F…ames.annotationRetention)");
        Name r17 = Name.identifier(r15.name());
        Intrinsics.checkNotNullExpressionValue(r17, "identifier(retention.name)");
        return new EnumValue(r16, r17);
    L16:
        return null;
    L10:
        r14 = null;
        goto L11
    L15:
        return null;
    L5:
        r11 = null;
        goto L6
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String r10) {
        EnumSet<KotlinTarget> r11 = targetNameLists.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return SetsKt.emptySet();
    }

    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(List<? extends JavaAnnotationArgument> r10) {
        Intrinsics.checkNotNullParameter(r10, "arguments");
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((r13 instanceof JavaEnumValueAnnotationArgument) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L16;
        JavaEnumValueAnnotationArgument r16 = (JavaEnumValueAnnotationArgument) r15.next();
        JavaAnnotationTargetMapper r17 = INSTANCE;
        Name r18 = r16.getEntryName();
        if (r18 == null) goto L14;
        String r19 = r18.asString();
    L15:
        CollectionsKt.addAll(r14, r17.mapJavaTargetArgumentByName(r19));
        goto L10
    L14:
        r19 = null;
        goto L15
    L16:
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r21 = r14.iterator();
    L18:
        if (r21.hasNext() == false) goto L21;
        KotlinTarget r22 = (KotlinTarget) r21.next();
        ClassId r23 = ClassId.topLevel(StandardNames.FqNames.annotationTarget);
        Intrinsics.checkNotNullExpressionValue(r23, "topLevel(StandardNames.FqNames.annotationTarget)");
        Name r24 = Name.identifier(r22.name());
        Intrinsics.checkNotNullExpressionValue(r24, "identifier(kotlinTarget.name)");
        r20.add(new EnumValue(r23, r24));
        goto L18
    L21:
        return new ArrayValue(r20, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }
}
