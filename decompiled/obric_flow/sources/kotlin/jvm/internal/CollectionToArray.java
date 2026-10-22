package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "CollectionToArray")
@SourceDebugExtension({"SMAP\nCollectionToArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n1#1,88:1\n63#1,22:89\n63#1,22:111\n*S KotlinDebug\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n22#1:89,22\n37#1:111,22\n*E\n"})
public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;

    static {
        EMPTY = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    @JvmName(name = "toArray")
    public static final Object[] toArray(Collection<?> r5, Object[] r10) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        r10.getClass();
        int r11 = r5.size();
        int r12 = 0;
        if (r11 == 0) goto L5;
        Iterator<?> r13 = r5.iterator();
        if (r13.hasNext() == true) goto L13;
        if (r10.length <= 0) goto L44;
        r10[0] = null;
        return r10;
    L44:
        return r10;
    L13:
        if (r11 > r10.length) goto L15;
        Object[] r14 = r10;
    L16:
        int r15 = r12 + 1;
        r14[r12] = r13.next();
        if (r15 < r14.length) goto L31;
        if (r13.hasNext() == false) goto L46;
        int r16 = ((r15 * 3) + 1) >>> 1;
        if (r16 > r15) goto L28;
        r16 = MAX_SIZE;
        if (r15 < MAX_SIZE) goto L28;
        throw new OutOfMemoryError();
    L28:
        r14 = Arrays.copyOf(r14, r16);
    L29:
        r12 = r15;
        goto L16
    L46:
        return r14;
    L31:
        if (r13.hasNext() == true) goto L29;
        if (r14 != r10) goto L35;
        r10[r15] = null;
        return r10;
    L35:
        return Arrays.copyOf(r14, r15);
    L15:
        Object r17 = Array.newInstance(r10.getClass().getComponentType(), r11);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r14 = (Object[]) r17;
        goto L16
    L5:
        if (r10.length <= 0) goto L42;
        r10[0] = null;
        return r10;
    L42:
        return r10;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] toArrayImpl(Collection<?> r5, Function0<Object[]> r10, Function1<? super Integer, Object[]> r11, Function2<? super Object[], ? super Integer, Object[]> r12) {
        int r13 = r5.size();
        if (r13 == 0) goto L5;
        Iterator<?> r14 = r5.iterator();
        if (r14.hasNext() == false) goto L9;
        Object[] r15 = r11.invoke(Integer.valueOf(r13));
        int r16 = 0;
        ?? r17 = r15;
    L11:
        int r18 = r16 + 1;
        r17[r16] = r14.next();
        if (r18 < r17.length) goto L26;
        if (r14.hasNext() == false) goto L15;
        int r19 = ((r18 * 3) + 1) >>> 1;
        if (r19 > r18) goto L23;
        r19 = MAX_SIZE;
        if (r18 < MAX_SIZE) goto L23;
        throw new OutOfMemoryError();
    L23:
        r17 = Arrays.copyOf(r17, r19);
    L24:
        r16 = r18;
        r17 = r17;
        goto L11
    L15:
        return r17;
    L26:
        if (r14.hasNext() == true) goto L24;
        return r12.mo2invoke(r17, Integer.valueOf(r18));
    L9:
        return r10.invoke();
    L5:
        return r10.invoke();
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    @JvmName(name = "toArray")
    public static final Object[] toArray(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        int r10 = r5.size();
        if (r10 == 0) goto L32;
        Iterator<?> r11 = r5.iterator();
        if (r11.hasNext() == false) goto L32;
        Object[] r12 = new Object[r10];
        int r13 = 0;
    L9:
        int r14 = r13 + 1;
        r12[r13] = r11.next();
        if (r14 < r12.length) goto L24;
        if (r11.hasNext() == false) goto L33;
        int r15 = ((r14 * 3) + 1) >>> 1;
        if (r15 > r14) goto L21;
        r15 = MAX_SIZE;
        if (r14 < MAX_SIZE) goto L21;
        throw new OutOfMemoryError();
    L21:
        r12 = Arrays.copyOf(r12, r15);
    L22:
        r13 = r14;
        goto L9
    L33:
        return r12;
    L24:
        if (r11.hasNext() == true) goto L22;
        return Arrays.copyOf(r12, r14);
    L32:
        return EMPTY;
    }
}
