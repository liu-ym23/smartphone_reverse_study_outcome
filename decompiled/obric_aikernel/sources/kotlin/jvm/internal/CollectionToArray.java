package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "CollectionToArray")
@SourceDebugExtension({"SMAP\nCollectionToArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,82:1\n57#1,22:83\n57#1,22:105\n26#2:127\n*S KotlinDebug\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n19#1:83,22\n31#1:105,22\n14#1:127\n*E\n"})
public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;

    static {
        EMPTY = new Object[0];
    }

    @JvmName(name = "toArray")
    public static final Object[] toArray(Collection<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        int r11 = r10.size();
        if (r11 == 0) goto L31;
        Iterator<?> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L31;
        Object[] r13 = new Object[r11];
        int r14 = 0;
    L9:
        int r15 = r14 + 1;
        r13[r14] = r12.next();
        if (r15 < r13.length) goto L22;
        if (r12.hasNext() == false) goto L32;
        int r16 = ((r15 * 3) + 1) >>> 1;
        if (r16 > r15) goto L20;
        if (r15 >= MAX_SIZE) goto L19;
        r16 = MAX_SIZE;
        goto L20
    L19:
        throw new OutOfMemoryError();
    L20:
        r13 = Arrays.copyOf(r13, r16);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(result, newSize)");
    L25:
        r14 = r15;
        goto L9
    L32:
        return r13;
    L22:
        if (r12.hasNext() == true) goto L25;
        Object[] r17 = Arrays.copyOf(r13, r15);
        Intrinsics.checkNotNullExpressionValue(r17, "copyOf(result, size)");
        return r17;
    L31:
        return EMPTY;
    }

    @JvmName(name = "toArray")
    public static final Object[] toArray(Collection<?> r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        Objects.requireNonNull(r11);
        int r12 = r10.size();
        int r13 = 0;
        if (r12 == 0) goto L5;
        Iterator<?> r14 = r10.iterator();
        if (r14.hasNext() == true) goto L13;
        if (r11.length <= 0) goto L43;
        r11[0] = null;
        return r11;
    L43:
        return r11;
    L13:
        if (r12 > r11.length) goto L15;
        Object[] r15 = r11;
    L16:
        int r16 = r13 + 1;
        r15[r13] = r14.next();
        if (r16 < r15.length) goto L29;
        if (r14.hasNext() == false) goto L45;
        int r17 = ((r16 * 3) + 1) >>> 1;
        if (r17 > r16) goto L27;
        if (r16 >= MAX_SIZE) goto L26;
        r17 = MAX_SIZE;
        goto L27
    L26:
        throw new OutOfMemoryError();
    L27:
        r15 = Arrays.copyOf(r15, r17);
        Intrinsics.checkNotNullExpressionValue(r15, "copyOf(result, newSize)");
    L34:
        r13 = r16;
        goto L16
    L45:
        return r15;
    L29:
        if (r14.hasNext() == true) goto L34;
        if (r15 != r11) goto L32;
        r11[r16] = null;
        return r11;
    L32:
        Object[] r18 = Arrays.copyOf(r15, r16);
        Intrinsics.checkNotNullExpressionValue(r18, "copyOf(result, size)");
        return r18;
    L15:
        Object r19 = Array.newInstance(r11.getClass().getComponentType(), r12);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r15 = (Object[]) r19;
        goto L16
    L5:
        if (r11.length <= 0) goto L41;
        r11[0] = null;
        return r11;
    L41:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] toArrayImpl(Collection<?> r10, Function0<Object[]> r11, Function1<? super Integer, Object[]> r12, Function2<? super Object[], ? super Integer, Object[]> r13) {
        int r14 = r10.size();
        if (r14 != 0) goto L7;
    L4:
        Object[] r15 = r11.invoke();
    L6:
        return r15;
    L7:
        Iterator<?> r16 = r10.iterator();
        if (r16.hasNext() == false) goto L4;
        Object[] r17 = r12.invoke(Integer.valueOf(r14));
        int r18 = 0;
        ?? r19 = r17;
    L11:
        int r20 = r18 + 1;
        r19[r18] = r16.next();
        if (r20 < r19.length) goto L24;
        if (r16.hasNext() == false) goto L15;
        int r21 = ((r20 * 3) + 1) >>> 1;
        if (r21 > r20) goto L22;
        if (r20 >= MAX_SIZE) goto L21;
        r21 = MAX_SIZE;
        goto L22
    L21:
        throw new OutOfMemoryError();
    L22:
        r19 = Arrays.copyOf(r19, r21);
        Intrinsics.checkNotNullExpressionValue(r19, "copyOf(result, newSize)");
    L26:
        r18 = r20;
        r19 = r19;
        goto L11
    L15:
        return r19;
    L24:
        if (r16.hasNext() == true) goto L26;
        r15 = r13.invoke(r19, Integer.valueOf(r20));
        goto L6
    }
}
