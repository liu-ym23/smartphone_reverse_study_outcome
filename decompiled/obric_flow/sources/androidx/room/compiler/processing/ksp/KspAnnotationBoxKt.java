package androidx.room.compiler.processing.ksp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\b"}, d2 = {"readAs", "R", "", "returnType", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "readAsEnum", "enumClass", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KspAnnotationBoxKt {
    public static final /* synthetic */ Object access$readAs(Object r5, Class r10) {
        return readAs(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8, types: [R, java.lang.Object[]] */
    private static final <R> R readAs(Object r10, Class<R> r11) {
        if (r11.isArray() == false) goto L63;
        int r5 = 0;
        if ((r10 instanceof List) == false) goto L16;
        List r12 = new ArrayList();
        Iterator r13 = ((Iterable) r10).iterator();
    L8:
        if (r13.hasNext() == false) goto L28;
        Object r14 = r13.next();
        if (r14 == null) goto L12;
        Object r15 = readAs(r14, r11.getComponentType());
    L13:
        if (r15 == null) goto L8;
        r12.add(r15);
        goto L8
    L12:
        r15 = null;
    L28:
        if (r11.getComponentType().isPrimitive() == true) goto L30;
        Object r16 = Array.newInstance(r11.getComponentType(), r12.size());
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ?? r17 = (R) ((Object[]) r16);
        Iterator r18 = r12.iterator();
    L57:
        if (r18.hasNext() == false) goto L86;
        Object r19 = r18.next();
        int r20 = r5 + 1;
        if (r5 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        r17[r5] = r19;
        r5 = r20;
        goto L57
    L86:
        return r17;
    L30:
        if (Intrinsics.areEqual(r11, int[].class) == false) goto L33;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Int>");
        return (R) CollectionsKt.toIntArray(r12);
    L33:
        if (Intrinsics.areEqual(r11, double[].class) == false) goto L36;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Double>");
        return (R) CollectionsKt.toDoubleArray(r12);
    L36:
        if (Intrinsics.areEqual(r11, float[].class) == false) goto L39;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Float>");
        return (R) CollectionsKt.toFloatArray(r12);
    L39:
        if (Intrinsics.areEqual(r11, char[].class) == false) goto L42;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Char>");
        return (R) CollectionsKt.toCharArray(r12);
    L42:
        if (Intrinsics.areEqual(r11, byte[].class) == false) goto L45;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Byte>");
        return (R) CollectionsKt.toByteArray(r12);
    L45:
        if (Intrinsics.areEqual(r11, short[].class) == false) goto L48;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Short>");
        return (R) CollectionsKt.toShortArray(r12);
    L48:
        if (Intrinsics.areEqual(r11, long[].class) == false) goto L51;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Long>");
        return (R) CollectionsKt.toLongArray(r12);
    L51:
        if (Intrinsics.areEqual(r11, boolean[].class) == false) goto L54;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Boolean>");
        return (R) CollectionsKt.toBooleanArray(r12);
    L54:
        throw new IllegalStateException(("Unsupported primitive array type: " + r11).toString());
    L16:
        if ((r10 instanceof Object[]) == false) goto L26;
        Object[] r21 = (Object[]) r10;
        r12 = new ArrayList();
        int r22 = r21.length;
        int r23 = 0;
    L18:
        if (r23 >= r22) goto L28;
        Object r24 = r21[r23];
        if (r24 == null) goto L22;
        Object r25 = readAs(r24, r11.getComponentType());
    L23:
        if (r25 == null) goto L25;
        r12.add(r25);
    L25:
        r23 = r23 + 1;
        goto L18
    L22:
        r25 = null;
        goto L23
    L26:
        r12 = CollectionsKt.listOf(readAs(r10, r11.getComponentType()));
        goto L28
    L63:
        if (r11.isEnum() == true) goto L65;
        return r10;
    L65:
        return (R) readAsEnum(r10, r11);
    }

    private static final <R> R readAsEnum(Object r5, Class<R> r10) {
        if (r10.isAssignableFrom(r5.getClass()) == true) goto L5;
        return null;
    L5:
        return r10.cast(r5);
    }
}
