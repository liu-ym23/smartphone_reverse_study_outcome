package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
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
    private static final String f18753kotlin = null;
    private static final Map<String, String> map = null;

    static {
        INSTANCE = new ClassMapperLite();
        f18753kotlin = CollectionsKt.q(CollectionsKt.listOf(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62);
        LinkedHashMap r5 = new LinkedHashMap();
        List r10 = CollectionsKt.listOf(new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int r11 = 0;
        int r12 = ProgressionUtilKt.getProgressionLastElement(0, r10.size() - 1, 2);
        if (r12 < 0) goto L8;
        int r13 = 0;
    L5:
        StringBuilder r14 = new StringBuilder();
        String r15 = f18753kotlin;
        r14.append(r15);
        r14.append('/');
        r14.append((String) r10.get(r13));
        int r16 = r13 + 1;
        r5.put(r14.toString(), r10.get(r16));
        StringBuilder r17 = new StringBuilder();
        r17.append(r15);
        r17.append('/');
        r5.put(j0.q(r17, (String) r10.get(r13), "Array"), "[" + ((String) r10.get(r16)));
        if (r13 == r12) goto L8;
        r13 = r13 + 2;
    L8:
        r5.put(f18753kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        map$lambda$0$add(r5, "Any", "java/lang/Object");
        map$lambda$0$add(r5, "Nothing", "java/lang/Void");
        map$lambda$0$add(r5, "Annotation", "java/lang/annotation/Annotation");
        Iterator r18 = CollectionsKt.listOf(new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"}).iterator();
    L10:
        if (r18.hasNext() == false) goto L12;
        String r19 = (String) r18.next();
        map$lambda$0$add(r5, r19, j0.C("java/lang/", r19));
        goto L10
    L12:
        Iterator r20 = CollectionsKt.listOf(new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"}).iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        String r21 = (String) r20.next();
        map$lambda$0$add(r5, j0.C("collections/", r21), j0.C("java/util/", r21));
        map$lambda$0$add(r5, j0.C("collections/Mutable", r21), j0.C("java/util/", r21));
        goto L14
    L16:
        map$lambda$0$add(r5, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(r5, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(r5, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(r5, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    L18:
        if (r11 >= 23) goto L20;
        String r22 = j0.g(r11, "Function");
        StringBuilder r23 = new StringBuilder();
        String r24 = f18753kotlin;
        r23.append(r24);
        r23.append("/jvm/functions/Function");
        r23.append(r11);
        map$lambda$0$add(r5, r22, r23.toString());
        map$lambda$0$add(r5, j0.g(r11, "reflect/KFunction"), j0.j(r24, "/reflect/KFunction"));
        r11 = r11 + 1;
        goto L18
    L20:
        Iterator r25 = CollectionsKt.listOf(new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"}).iterator();
    L22:
        if (r25.hasNext() == false) goto L24;
        String r26 = (String) r25.next();
        map$lambda$0$add(r5, j0.j(r26, ".Companion"), a.u(new StringBuilder(), f18753kotlin, "/jvm/internal/", r26, "CompanionObject"));
        goto L22
    L24:
        map = r5;
    }

    private ClassMapperLite() {
    }

    private static final void map$lambda$0$add(Map<String, String> r5, String r10, String r11) {
        r5.put(f18753kotlin + '/' + r10, "L" + r11 + ';');
    }

    @JvmStatic
    public static final String mapClass(String r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        String r10 = map.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return "L" + StringsKt.E(r5, '.', Typography.dollar) + ';';
    }
}
