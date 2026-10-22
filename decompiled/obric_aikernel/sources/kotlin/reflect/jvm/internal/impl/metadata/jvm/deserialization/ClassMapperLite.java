package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = null;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f10216kotlin = null;
    private static final Map<String, String> map = null;

    static {
        INSTANCE = new ClassMapperLite();
        int r10 = 0;
        f10216kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        LinkedHashMap r11 = new LinkedHashMap();
        List r12 = CollectionsKt.listOf(new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int r13 = ProgressionUtilKt.getProgressionLastElement(0, r12.size() - 1, 2);
        if (r13 < 0) goto L8;
        int r14 = 0;
    L5:
        StringBuilder r15 = new StringBuilder();
        String r16 = f10216kotlin;
        r15.append(r16);
        r15.append('/');
        r15.append((String) r12.get(r14));
        int r17 = r14 + 1;
        r11.put(r15.toString(), r12.get(r17));
        r11.put(r16 + '/' + ((String) r12.get(r14)) + "Array", '[' + ((String) r12.get(r17)));
        if (r14 == r13) goto L8;
        r14 = r14 + 2;
    L8:
        r11.put(f10216kotlin + "/Unit", "V");
        map$lambda$0$add(r11, "Any", "java/lang/Object");
        map$lambda$0$add(r11, "Nothing", "java/lang/Void");
        map$lambda$0$add(r11, "Annotation", "java/lang/annotation/Annotation");
        Iterator r18 = CollectionsKt.listOf(new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"}).iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        String r19 = (String) r18.next();
        map$lambda$0$add(r11, r19, "java/lang/" + r19);
        goto L10
    L12:
        Iterator r20 = CollectionsKt.listOf(new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"}).iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        String r21 = (String) r20.next();
        map$lambda$0$add(r11, "collections/" + r21, "java/util/" + r21);
        map$lambda$0$add(r11, "collections/Mutable" + r21, "java/util/" + r21);
        goto L14
    L16:
        map$lambda$0$add(r11, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(r11, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(r11, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(r11, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    L18:
        if (r10 >= 23) goto L20;
        StringBuilder r22 = new StringBuilder();
        String r23 = f10216kotlin;
        r22.append(r23);
        r22.append("/jvm/functions/Function");
        r22.append(r10);
        map$lambda$0$add(r11, "Function" + r10, r22.toString());
        map$lambda$0$add(r11, "reflect/KFunction" + r10, r23 + "/reflect/KFunction");
        r10 = r10 + 1;
        goto L18
    L20:
        Iterator r24 = CollectionsKt.listOf(new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"}).iterator();
    L22:
        if (r24.hasNext() == false) goto L24;
        String r25 = (String) r24.next();
        map$lambda$0$add(r11, r25 + ".Companion", f10216kotlin + "/jvm/internal/" + r25 + "CompanionObject");
        goto L22
    L24:
        map = r11;
    }

    private ClassMapperLite() {
    }

    private static final void map$lambda$0$add(Map<String, String> r10, String r11, String r12) {
        r10.put(f10216kotlin + '/' + r11, 'L' + r12 + ';');
    }

    @JvmStatic
    public static final String mapClass(String r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        String r11 = map.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return 'L' + StringsKt.replace$default(r10, '.', Typography.dollar, false, 4, null) + ';';
    }
}
