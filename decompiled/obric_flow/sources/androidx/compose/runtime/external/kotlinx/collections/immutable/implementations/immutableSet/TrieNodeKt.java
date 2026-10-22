package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a7\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\r\u001aL\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00130\u0012H\u0082\b¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"LOG_MAX_BRANCHING_FACTOR", "", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", ExifInterface.LONGITUDE_EAST, "element", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final /* synthetic */ Object[] access$addElementAtIndex(Object[] r5, int r10, Object r11) {
        return addElementAtIndex(r5, r10, r11);
    }

    public static final /* synthetic */ Object[] access$removeCellAtIndex(Object[] r5, int r10) {
        return removeCellAtIndex(r5, r10);
    }

    private static final <E> Object[] addElementAtIndex(Object[] r5, int r10, E r11) {
        Object[] r12 = new Object[r5.length + 1];
        ArraysKt.f(r5, r12, 0, r10, 6);
        ArraysKt.copyInto(r5, r12, r10 + 1, r10, r5.length);
        r12[r10] = r11;
        return r12;
    }

    private static final int filterTo(Object[] r10, Object[] r11, int r12, Function1<Object, Boolean> r13) {
        int r5 = 0;
        int r14 = 0;
    L4:
        if (r5 >= r10.length) goto L17;
        boolean r15 = true;
        if (r14 > r5) goto L8;
        boolean r16 = true;
    L9:
        CommonFunctionsKt.m42assert(r16);
        if (r13.invoke(r10[r5]).booleanValue() == false) goto L16;
        r11[r12 + r14] = r10[r5];
        r14 = r14 + 1;
        if ((r12 + r14) <= r11.length) goto L15;
        r15 = false;
    L15:
        CommonFunctionsKt.m42assert(r15);
    L16:
        r5 = r5 + 1;
        goto L4
    L8:
        r16 = false;
        goto L9
    L17:
        return r14;
    }

    public static /* synthetic */ int filterTo$default(Object[] r5, Object[] r10, int r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = AnonymousClass1.INSTANCE;
    L8:
        int r15 = 0;
        int r16 = 0;
    L10:
        if (r15 >= r5.length) goto L23;
        boolean r17 = true;
        if (r16 > r15) goto L14;
        boolean r18 = true;
    L15:
        CommonFunctionsKt.m42assert(r18);
        if (((Boolean) r12.invoke(r5[r15])).booleanValue() == false) goto L22;
        r10[r11 + r16] = r5[r15];
        r16 = r16 + 1;
        if ((r11 + r16) <= r10.length) goto L21;
        r17 = false;
    L21:
        CommonFunctionsKt.m42assert(r17);
    L22:
        r15 = r15 + 1;
        goto L10
    L14:
        r18 = false;
        goto L15
    L23:
        return r16;
    }

    public static final int indexSegment(int r5, int r10) {
        return (r5 >> r10) & 31;
    }

    private static final Object[] removeCellAtIndex(Object[] r5, int r10) {
        Object[] r11 = new Object[r5.length - 1];
        ArraysKt.f(r5, r11, 0, r10, 6);
        ArraysKt.copyInto(r5, r11, r10, r10 + 1, r5.length);
        return r11;
    }
}
