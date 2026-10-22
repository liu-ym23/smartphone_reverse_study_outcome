package androidx.room.compiler.processing.ksp;

import com.squareup.javapoet.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\t0\t0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeMapper;", "", "<init>", "()V", "", "javaType", "swapWithKotlinType", "(Ljava/lang/String;)Ljava/lang/String;", "kotlinType", "Lcom/squareup/javapoet/x;", "getPrimitiveJavaTypeName", "(Ljava/lang/String;)Lcom/squareup/javapoet/x;", "qName", "", "isJavaPrimitiveType", "(Ljava/lang/String;)Z", "", "mapping", "Ljava/util/Map;", "", "kotlin.jvm.PlatformType", "kotlinTypeToJavaPrimitiveMapping", "", "javaPrimitiveQNames", "Ljava/util/Set;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspTypeMapper {
    public static final KspTypeMapper INSTANCE = null;
    private static final Set<String> javaPrimitiveQNames = null;
    private static final Map<String, x> kotlinTypeToJavaPrimitiveMapping = null;
    private static final Map<String, String> mapping = null;

    static {
        INSTANCE = new KspTypeMapper();
        mapping = new LinkedHashMap();
        Map<String, x> r5 = MapsKt.mapOf(new Pair[]{TuplesKt.to("kotlin.Byte", x.f), TuplesKt.to("kotlin.Short", x.g), TuplesKt.to("kotlin.Int", x.f15023h), TuplesKt.to("kotlin.Long", x.f15024i), TuplesKt.to("kotlin.Char", x.f15025j), TuplesKt.to("kotlin.Float", x.f15026k), TuplesKt.to("kotlin.Double", x.f15027l), TuplesKt.to("kotlin.Boolean", x.e)});
        kotlinTypeToJavaPrimitiveMapping = r5;
        Collection<x> r10 = r5.values();
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((x) r12.next()).toString());
        goto L4
    L6:
        javaPrimitiveQNames = r11;
        Iterator<Map.Entry<String, x>> r13 = kotlinTypeToJavaPrimitiveMapping.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry<String, x> r14 = r13.next();
        mapping.put(r14.getValue().toString(), r14.getKey());
        goto L8
    L10:
        Map<String, String> r15 = mapping;
        r15.put("java.lang.Object", "kotlin.Any");
        r15.put("java.lang.Cloneable", "kotlin.Cloneable");
        r15.put("java.lang.Comparable", "kotlin.Comparable");
        r15.put("java.lang.Enum", "kotlin.Enum");
        r15.put("java.lang.Annotation", "kotlin.Annotation");
        r15.put("java.lang.CharSequence", "kotlin.CharSequence");
        r15.put("java.lang.String", "kotlin.String");
        r15.put("java.lang.Number", "kotlin.Number");
        r15.put("java.lang.Throwable", "kotlin.Throwable");
        r15.put("java.lang.Byte", "kotlin.Byte");
        r15.put("java.lang.Short", "kotlin.Short");
        r15.put("java.lang.Integer", "kotlin.Int");
        r15.put("java.lang.Long", "kotlin.Long");
        r15.put("java.lang.Character", "kotlin.Char");
        r15.put("java.lang.Float", "kotlin.Float");
        r15.put("java.lang.Double", "kotlin.Double");
        r15.put("java.lang.Boolean", "kotlin.Boolean");
        r15.put("java.util.Iterator", "kotlin.collections.MutableIterator");
        r15.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r15.put("java.util.Collection", "kotlin.collections.MutableCollection");
        r15.put("java.util.Set", "kotlin.collections.MutableSet");
        r15.put("java.util.List", "kotlin.collections.MutableList");
        r15.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r15.put("java.util.Map", "kotlin.collections.MutableMap");
        r15.put("java.util.Map.Entry", "kotlin.collections.MutableEntry");
    }

    private KspTypeMapper() {
    }

    public final x getPrimitiveJavaTypeName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinType");
        return kotlinTypeToJavaPrimitiveMapping.get(r5);
    }

    public final boolean isJavaPrimitiveType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        return javaPrimitiveQNames.contains(r5);
    }

    public final String swapWithKotlinType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "javaType");
        String r10 = mapping.get(r5);
        if (r10 != null) goto L6;
        return r5;
    L6:
        return r10;
    }
}
