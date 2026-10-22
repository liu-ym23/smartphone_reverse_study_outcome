package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nValueClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1549#2:47\n1620#2,3:48\n1549#2:51\n1620#2,3:52\n1549#2:55\n1620#2,3:56\n*S KotlinDebug\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n*L\n25#1:47\n25#1:48,3\n29#1:51\n29#1:52,3\n32#1:55\n32#1:56,3\n*E\n"})
public final class ValueClassUtilKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
    public static final <T extends SimpleTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(ProtoBuf.Class r5, NameResolver r10, TypeTable r11, Function1<? super ProtoBuf.Type, ? extends T> r12, Function1<? super Name, ? extends T> r13) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        Intrinsics.checkNotNullParameter(r12, "typeDeserializer");
        Intrinsics.checkNotNullParameter(r13, "typeOfPublicProperty");
        if (r5.getMultiFieldValueClassUnderlyingNameCount() <= 0) goto L26;
        List<Integer> r14 = r5.getMultiFieldValueClassUnderlyingNameList();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        r15.add(NameResolverUtilKt.getName(r10, ((Integer) r16.next()).intValue()));
        goto L6
    L8:
        Pair r17 = TuplesKt.to(Integer.valueOf(r5.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(r5.getMultiFieldValueClassUnderlyingTypeCount()));
        if (Intrinsics.areEqual(r17, TuplesKt.to(Integer.valueOf(r15.size()), 0)) == false) goto L15;
        List<Integer> r18 = r5.getMultiFieldValueClassUnderlyingTypeIdList();
        ?? r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L17;
        r19.add(r11.get(((Integer) r20.next()).intValue()));
    L17:
        ArrayList r21 = new ArrayList(CollectionsKt.h(r19));
        Iterator r22 = r19.iterator();
    L19:
        if (r22.hasNext() == false) goto L22;
        r21.add(r12.invoke(r22.next()));
        goto L19
    L22:
        return new MultiFieldValueClassRepresentation(CollectionsKt.zip(r15, r21));
    L15:
        if (Intrinsics.areEqual(r17, TuplesKt.to(0, Integer.valueOf(r15.size()))) == false) goto L24;
        r19 = r5.getMultiFieldValueClassUnderlyingTypeList();
        goto L17
    L24:
        throw new IllegalStateException(("class " + NameResolverUtilKt.getName(r10, r5.getFqName()) + " has illegal multi-field value class representation").toString());
    L26:
        if (r5.hasInlineClassUnderlyingPropertyName() == false) goto L37;
        Name r23 = NameResolverUtilKt.getName(r10, r5.getInlineClassUnderlyingPropertyName());
        ProtoBuf.Type r24 = ProtoTypeTableUtilKt.inlineClassUnderlyingType(r5, r11);
        if (r24 == null) goto L31;
        T r25 = r12.invoke(r24);
        if (r25 == null) goto L31;
    L34:
        return new InlineClassRepresentation(r23, r25);
    L31:
        r25 = r13.invoke(r23);
        if (r25 != null) goto L34;
        throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(r10, r5.getFqName()) + " with property " + r23).toString());
    L37:
        return null;
    }
}
