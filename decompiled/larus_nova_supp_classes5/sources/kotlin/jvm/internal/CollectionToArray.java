package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;

    static {
        EMPTY = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "collection");
        int r0 = r4.size();
        if (r0 == 0) goto L32;
        Iterator<?> r5 = r4.iterator();
        if (r5.hasNext() == false) goto L32;
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L9:
        int r3 = r2 + 1;
        r1[r2] = r5.next();
        if (r3 < r1.length) goto L23;
        if (r5.hasNext() == false) goto L33;
        int r6 = ((r3 * 3) + 1) >>> 1;
        if (r6 > r3) goto L21;
        r6 = MAX_SIZE;
        if (r3 < MAX_SIZE) goto L21;
        throw new OutOfMemoryError();
    L21:
        r1 = Arrays.copyOf(r1, r6);
    L26:
        r2 = r3;
        goto L9
    L33:
        return r1;
    L23:
        if (r5.hasNext() == true) goto L26;
        return Arrays.copyOf(r1, r3);
    L32:
        return EMPTY;
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> r5, Object[] r6) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        if (r6 == null) goto L38;
        int r1 = r5.size();
        int r2 = 0;
        if (r1 == 0) goto L7;
        Iterator<?> r7 = r5.iterator();
        if (r7.hasNext() == true) goto L15;
        if (r6.length <= 0) goto L47;
        r6[0] = null;
        return r6;
    L47:
        return r6;
    L15:
        if (r1 > r6.length) goto L17;
        Object[] r3 = r6;
    L18:
        int r4 = r2 + 1;
        r3[r2] = r7.next();
        if (r4 < r3.length) goto L32;
        if (r7.hasNext() == false) goto L49;
        int r8 = ((r4 * 3) + 1) >>> 1;
        if (r8 > r4) goto L30;
        r8 = MAX_SIZE;
        if (r4 < MAX_SIZE) goto L30;
        throw new OutOfMemoryError();
    L30:
        r3 = Arrays.copyOf(r3, r8);
    L37:
        r2 = r4;
        goto L18
    L49:
        return r3;
    L32:
        if (r7.hasNext() == true) goto L37;
        if (r3 != r6) goto L36;
        r6[r4] = null;
        return r6;
    L36:
        return Arrays.copyOf(r3, r4);
    L17:
        Object r9 = Array.newInstance(r6.getClass().getComponentType(), r1);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r3 = (Object[]) r9;
        goto L18
    L7:
        if (r6.length <= 0) goto L45;
        r6[0] = null;
        return r6;
    L45:
        return r6;
    L38:
        throw null;
    }

    private static final Object[] toArrayImpl(Collection<?> r2, Function0<Object[]> r3, Function1<? super Integer, Object[]> r4, Function2<? super Object[], ? super Integer, Object[]> r5) {
        int r0 = r2.size();
        if (r0 == 0) goto L5;
        Iterator<?> r6 = r2.iterator();
        if (r6.hasNext() == false) goto L9;
        Object[] r7 = (Object[]) r4.invoke(Integer.valueOf(r0));
        int r8 = 0;
    L11:
        int r1 = r8 + 1;
        r7[r8] = r6.next();
        if (r1 < r7.length) goto L25;
        if (r6.hasNext() == false) goto L15;
        int r9 = ((r1 * 3) + 1) >>> 1;
        if (r9 > r1) goto L23;
        r9 = MAX_SIZE;
        if (r1 < MAX_SIZE) goto L23;
        throw new OutOfMemoryError();
    L23:
        r7 = Arrays.copyOf(r7, r9);
    L28:
        r8 = r1;
        goto L11
    L15:
        return r7;
    L25:
        if (r6.hasNext() == true) goto L28;
        return (Object[]) r5.invoke(r7, Integer.valueOf(r1));
    L9:
        return (Object[]) r3.invoke();
    L5:
        return (Object[]) r3.invoke();
    }
}
