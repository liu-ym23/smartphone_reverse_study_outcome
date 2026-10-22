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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationTargetMapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n800#2,11:183\n1360#2:194\n1446#2,5:195\n1549#2:200\n1620#2,3:201\n*S KotlinDebug\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationTargetMapper\n*L\n153#1:183,11\n154#1:194\n154#1:195,5\n155#1:200\n155#1:201,3\n*E\n"})
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

    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationArgument r5) {
        if ((r5 instanceof JavaEnumValueAnnotationArgument) == false) goto L5;
        JavaEnumValueAnnotationArgument r10 = (JavaEnumValueAnnotationArgument) r5;
    L6:
        if (r10 == null) goto L15;
        Map<String, KotlinRetention> r11 = retentionNameList;
        Name r12 = r10.getEntryName();
        if (r12 == null) goto L10;
        String r13 = r12.asString();
    L11:
        KotlinRetention r14 = r11.get(r13);
        if (r14 != null) goto L14;
        return null;
    L14:
        return new EnumValue(ClassId.topLevel(StandardNames.FqNames.annotationRetention), Name.identifier(r14.name()));
    L10:
        r13 = null;
        goto L11
    L15:
        return null;
    L5:
        r10 = null;
        goto L6
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String r5) {
        EnumSet<KotlinTarget> r10 = targetNameLists.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return SetsKt.emptySet();
    }

    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(List<? extends JavaAnnotationArgument> r5) {
        Intrinsics.checkNotNullParameter(r5, "arguments");
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((r12 instanceof JavaEnumValueAnnotationArgument) == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L16;
        JavaEnumValueAnnotationArgument r15 = (JavaEnumValueAnnotationArgument) r14.next();
        JavaAnnotationTargetMapper r16 = INSTANCE;
        Name r17 = r15.getEntryName();
        if (r17 == null) goto L14;
        String r18 = r17.asString();
    L15:
        CollectionsKt.a(r13, r16.mapJavaTargetArgumentByName(r18));
        goto L10
    L14:
        r18 = null;
        goto L15
    L16:
        ArrayList r19 = new ArrayList(CollectionsKt.h(r13));
        Iterator r20 = r13.iterator();
    L18:
        if (r20.hasNext() == false) goto L21;
        KotlinTarget r21 = (KotlinTarget) r20.next();
        r19.add(new EnumValue(ClassId.topLevel(StandardNames.FqNames.annotationTarget), Name.identifier(r21.name())));
        goto L18
    L21:
        return new ArrayValue(r19, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }
}
