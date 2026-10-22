package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
public final class ListBuilderKt {
    public static final /* synthetic */ boolean access$subarrayContentEquals(Object[] r10, int r11, int r12, List r13) {
        return subarrayContentEquals(r10, r11, r12, r13);
    }

    public static final /* synthetic */ int access$subarrayContentHashCode(Object[] r10, int r11, int r12) {
        return subarrayContentHashCode(r10, r11, r12);
    }

    public static final /* synthetic */ String access$subarrayContentToString(Object[] r10, int r11, int r12) {
        return subarrayContentToString(r10, r11, r12);
    }

    public static final <E> E[] arrayOfUninitializedElements(int r10) {
        if (r10 < 0) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == false) goto L9;
        return (E[]) new Object[r10];
    L9:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L4:
        r11 = false;
        goto L5
    }

    public static final <T> T[] copyOfUninitializedElements(T[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        T[] r12 = (T[]) Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    public static final <E> void resetAt(E[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10[r11] = null;
    }

    public static final <E> void resetRange(E[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
    L3:
        if (r11 >= r12) goto L5;
        resetAt(r10, r11);
        r11 = r11 + 1;
        goto L3
    }

    private static final <T> boolean subarrayContentEquals(T[] r10, int r11, int r12, List<?> r13) {
        if (r12 == r13.size()) goto L5;
        return false;
    L5:
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (Intrinsics.areEqual(r10[r11 + r14], r13.get(r14)) == false) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static final <T> int subarrayContentHashCode(T[] r10, int r11, int r12) {
        int r13 = 1;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L9;
        T r15 = r10[r11 + r14];
        int r16 = r13 * 31;
        if (r15 == null) goto L7;
        int r17 = r15.hashCode();
    L8:
        r13 = r16 + r17;
        r14 = r14 + 1;
        goto L3
    L7:
        r17 = 0;
        goto L8
    L9:
        return r13;
    }

    private static final <T> String subarrayContentToString(T[] r10, int r11, int r12) {
        StringBuilder r13 = new StringBuilder((r12 * 3) + 2);
        r13.append("[");
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L7;
        if (r14 <= 0) goto L6;
        r13.append(", ");
    L6:
        r13.append(r10[r11 + r14]);
        r14 = r14 + 1;
        goto L3
    L7:
        r13.append("]");
        String r15 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "sb.toString()");
        return r15;
    }
}
