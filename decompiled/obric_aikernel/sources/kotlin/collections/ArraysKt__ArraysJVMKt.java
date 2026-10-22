package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nArraysJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,61:1\n26#2:62\n*S KotlinDebug\n*F\n+ 1 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n18#1:62\n*E\n"})
class ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysJVMKt() {
    }

    public static final <T> T[] arrayOfNulls(T[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "reference");
        Object r12 = Array.newInstance(r10.getClass().getComponentType(), r11);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) r12);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepHashCode")
    public static final <T> int contentDeepHashCode(T[] r10) {
        return Arrays.deepHashCode(r10);
    }

    @SinceKotlin(version = "1.3")
    public static final void copyOfRangeToIndexCheck(int r10, int r11) {
        if (r10 > r11) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException("toIndex (" + r10 + ") is greater than size (" + r11 + ").");
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] r10) {
        if (r10 != null) goto L5;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    L5:
        return r10;
    }

    @InlineOnly
    private static final String toString(byte[] r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new String(r10, r11);
    }

    public static final /* synthetic */ <T> T[] toTypedArray(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) r10.toArray(new Object[0]);
    }
}
