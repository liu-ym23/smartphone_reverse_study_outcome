package kotlin.collections;

import g8.g;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.JvmFunctionSignature$FakeJavaAnnotationConstructor$special$$inlined$sortedBy$1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/ArraysKt__ArraysJVMKt", "kotlin/collections/ArraysKt__ArraysKt", "kotlin/collections/ArraysKt___ArraysJvmKt", "kotlin/collections/ArraysKt___ArraysKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class ArraysKt extends ArraysKt___ArraysKt {
    private ArraysKt() {
    }

    public static /* bridge */ /* synthetic */ void a(int r5, int r10, int[] r11, int[] r12, int r13) {
        ArraysKt___ArraysJvmKt.copyInto(r11, r12, r5, r10, r13);
    }

    public static /* bridge */ /* synthetic */ void b(long[] r5, long[] r10, int r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.copyInto(r5, r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ void c(short[] r5, short[] r10, int r11, int r12, int r13) {
        ArraysKt___ArraysJvmKt.copyInto(r5, r10, r11, r12, r13);
    }

    public static /* bridge */ /* synthetic */ void d(int r10, int r11, int[] r12, int[] r13) {
        ArraysKt___ArraysJvmKt.copyInto$default(r12, r13, 0, 0, r10, r11, null);
    }

    public static /* bridge */ /* synthetic */ void e(byte[] r10, int r11, int r12, byte[] r13) {
        ArraysKt___ArraysJvmKt.copyInto$default(r10, r13, 0, r11, r12, 2, null);
    }

    public static /* bridge */ /* synthetic */ Object[] f(Object[] r10, Object[] r11, int r12, int r13, int r14) {
        return ArraysKt___ArraysJvmKt.copyInto$default(r10, r11, r12, 0, r13, r14, null);
    }

    public static /* bridge */ /* synthetic */ char[] g(char[] r5, int r10) {
        return ArraysKt___ArraysJvmKt.copyOfRange(r5, 0, r10);
    }

    public static /* bridge */ /* synthetic */ List h(Object[] r5) {
        return ArraysKt___ArraysKt.drop(r5, 1);
    }

    public static /* bridge */ /* synthetic */ void i(int[] r10, int r11) {
        ArraysKt___ArraysJvmKt.fill$default(r10, r11, 0, 0, 6, null);
    }

    public static /* bridge */ /* synthetic */ void j(Object[] r10, g r11) {
        ArraysKt___ArraysJvmKt.fill$default(r10, r11, 0, 0, 6, null);
    }

    public static /* bridge */ /* synthetic */ void k(Object[] r10, StringBuilder r11, Function1 r12) {
        ArraysKt___ArraysKt.joinTo$default(r10, r11, null, "<", ">", 0, null, r12, 50, null);
    }

    public static /* bridge */ /* synthetic */ String l(Object[] r10, CharSequence r11, CharSequence r12, CharSequence r13, Function1 r14, int r15) {
        return ArraysKt___ArraysKt.joinToString$default(r10, r11, r12, r13, 0, null, r14, r15, null);
    }

    public static /* bridge */ /* synthetic */ void m(Comparator r5, int r10, Object[] r11) {
        ArraysKt___ArraysJvmKt.sortWith(r11, r5, 0, r10);
    }

    public static /* bridge */ /* synthetic */ List n(Object[] r5, JvmFunctionSignature$FakeJavaAnnotationConstructor$special$$inlined$sortedBy$1 r10) {
        return ArraysKt___ArraysKt.sortedWith(r5, r10);
    }

    public static /* bridge */ /* synthetic */ List o(Object[] r5) {
        return ArraysKt___ArraysKt.take(r5, 25);
    }
}
