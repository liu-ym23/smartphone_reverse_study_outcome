package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;

    static {
        EMPTY = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "collection");
        int r0 = r6.size();
        if (r0 == 0) goto L31;
        Iterator r7 = r6.iterator();
        if (r7.hasNext() == false) goto L31;
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L9:
        int r3 = r2 + 1;
        r1[r2] = r7.next();
        if (r3 < r1.length) goto L22;
        if (r7.hasNext() == false) goto L32;
        int r4 = ((r3 * 3) + 1) >>> 1;
        if (r4 > r3) goto L20;
        if (r3 >= MAX_SIZE) goto L19;
        r4 = MAX_SIZE;
        goto L20
    L19:
        throw new OutOfMemoryError();
    L20:
        r1 = Arrays.copyOf(r1, r4);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(...)");
    L25:
        r2 = r3;
        goto L9
    L32:
        return r1;
    L22:
        if (r7.hasNext() == true) goto L25;
        Object[] r8 = Arrays.copyOf(r1, r3);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(...)");
        return r8;
    L31:
        return EMPTY;
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> r6, Object[] r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "collection");
        Objects.requireNonNull(r7);
        int r0 = r8.size();
        int r3 = 0;
        if (r0 == 0) goto L5;
        Iterator r9 = r8.iterator();
        if (r9.hasNext() == true) goto L13;
        if (r7.length <= 0) goto L43;
        r7[0] = null;
        return r7;
    L43:
        return r7;
    L13:
        if (r0 > r7.length) goto L15;
        Object[] r1 = r7;
    L16:
        int r2 = r3 + 1;
        r1[r3] = r9.next();
        if (r2 < r1.length) goto L29;
        if (r9.hasNext() == false) goto L45;
        int r4 = ((r2 * 3) + 1) >>> 1;
        if (r4 > r2) goto L27;
        if (r2 >= MAX_SIZE) goto L26;
        r4 = MAX_SIZE;
        goto L27
    L26:
        throw new OutOfMemoryError();
    L27:
        r1 = Arrays.copyOf(r1, r4);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(...)");
    L34:
        r3 = r2;
        goto L16
    L45:
        return r1;
    L29:
        if (r9.hasNext() == true) goto L34;
        if (r1 != r7) goto L32;
        r7[r2] = null;
        return r7;
    L32:
        Object[] r10 = Arrays.copyOf(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(...)");
        return r10;
    L15:
        Object r5 = Array.newInstance(r7.getClass().getComponentType(), r0);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r1 = (Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin");
        goto L16
    L5:
        if (r7.length <= 0) goto L41;
        r7[0] = null;
        return r7;
    L41:
        return r7;
    }

    private static final Object[] toArrayImpl(Collection<?> r3, Function0<Object[]> r4, Function1<? super Integer, Object[]> r5, Function2<? super Object[], ? super Integer, Object[]> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        if (r0 != 0) goto L7;
    L4:
        Object r11 = r8.invoke();
    L6:
        return (Object[]) ZeusTransformUtils.preCheckCast(r11, Object[].class, "com.obric.memorydata.plugin");
    L7:
        Iterator r12 = r7.iterator();
        if (r12.hasNext() == false) goto L4;
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r9.invoke(Integer.valueOf(r0)), Object[].class, "com.obric.memorydata.plugin");
        int r14 = 0;
    L11:
        int r1 = r14 + 1;
        r13[r14] = r12.next();
        if (r1 < r13.length) goto L24;
        if (r12.hasNext() == false) goto L15;
        int r15 = ((r1 * 3) + 1) >>> 1;
        if (r15 > r1) goto L22;
        if (r1 >= MAX_SIZE) goto L21;
        r15 = MAX_SIZE;
        goto L22
    L21:
        throw new OutOfMemoryError();
    L22:
        r13 = Arrays.copyOf(r13, r15);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(...)");
    L26:
        r14 = r1;
        goto L11
    L15:
        return r13;
    L24:
        if (r12.hasNext() == true) goto L26;
        r11 = r10.invoke(r13, Integer.valueOf(r1));
        goto L6
    }
}
