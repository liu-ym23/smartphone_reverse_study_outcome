package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1735#2,6:217\n12744#2,2:225\n1627#2,6:229\n12744#2,2:235\n1627#2,6:238\n37#3,2:223\n26#4:227\n26#4:228\n1#5:237\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:217,6\n131#1:225,2\n141#1:229,6\n173#1:235,2\n194#1:238,6\n106#1:223,2\n133#1:227\n135#1:228\n*E\n"})
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f10552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10553b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10554c = null;

    static {
        f10552a = new a.a().a();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m32constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());     // Catch: Throwable -> L5
    L8:
        if (Result.m35exceptionOrNullimpl(r11) == null) goto L11;
        r11 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    L11:
        f10553b = (String) r11;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L14
        Object r13 = Result.m32constructorimpl(h0.class.getCanonicalName());     // Catch: Throwable -> L14
    L17:
        if (Result.m35exceptionOrNullimpl(r13) == null) goto L20;
        r13 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    L20:
        f10554c = (String) r13;
        return;
    L14:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final /* synthetic */ Throwable a(Throwable r10, CoroutineStackFrame r11) {
        return i(r10, r11);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> b(E r10) {
        Throwable r11 = r10.getCause();
        if (r11 == null) goto L17;
        if (Intrinsics.areEqual(r11.getClass(), r10.getClass()) == false) goto L17;
        StackTraceElement[] r12 = r10.getStackTrace();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L12;
        if (g(r12[r14]) == true) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        boolean r15 = true;
    L13:
        if (r15 == false) goto L21;
        return TuplesKt.to(r11, r12);
    L21:
        return TuplesKt.to(r10, new StackTraceElement[0]);
    L12:
        r15 = false;
    L17:
        return TuplesKt.to(r10, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E c(E r10, E r11, ArrayDeque<StackTraceElement> r12) {
        r12.addFirst(f10552a);
        StackTraceElement[] r13 = r10.getStackTrace();
        int r14 = f(r13, f10553b);
        int r15 = 0;
        if (r14 != (-1)) goto L6;
        r11.setStackTrace((StackTraceElement[]) r12.toArray(new StackTraceElement[0]));
        return r11;
    L6:
        StackTraceElement[] r16 = new StackTraceElement[r12.size() + r14];
        int r17 = 0;
    L7:
        if (r17 >= r14) goto L9;
        r16[r17] = r13[r17];
        r17 = r17 + 1;
        goto L7
    L9:
        Iterator<StackTraceElement> r18 = r12.iterator();
    L11:
        if (r18.hasNext() == false) goto L13;
        int r19 = r15 + 1;
        r16[r15 + r14] = r18.next();
        r15 = r19;
        goto L11
    L13:
        r11.setStackTrace(r16);
        return r11;
    }

    private static final ArrayDeque<StackTraceElement> d(CoroutineStackFrame r10) {
        ArrayDeque<StackTraceElement> r11 = new ArrayDeque();
        StackTraceElement r12 = r10.getStackTraceElement();
        if (r12 == null) goto L5;
        r11.add(r12);
    L5:
        r10 = r10.getCallerFrame();
        if (r10 == null) goto L7;
        StackTraceElement r13 = r10.getStackTraceElement();
        if (r13 == null) goto L5;
        r11.add(r13);
        goto L5
    L7:
        return r11;
    }

    private static final boolean e(StackTraceElement r10, StackTraceElement r11) {
        if (r10.getLineNumber() == r11.getLineNumber()) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r10.getMethodName(), r11.getMethodName()) == false) goto L11;
        if (Intrinsics.areEqual(r10.getFileName(), r11.getFileName()) == false) goto L11;
        if (Intrinsics.areEqual(r10.getClassName(), r11.getClassName()) == false) goto L11;
        return true;
    }

    private static final int f(StackTraceElement[] r10, String r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (Intrinsics.areEqual(r11, r10[r13].getClassName()) == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r13;
    L8:
        return -1;
    }

    public static final boolean g(StackTraceElement r10) {
        return StringsKt.startsWith$default(r10.getClassName(), a.b.c(), false, 2, null);
    }

    private static final void h(StackTraceElement[] r10, ArrayDeque<StackTraceElement> r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (g(r10[r13]) == true) goto L9;
        r13 = r13 + 1;
    L9:
        int r14 = r13 + 1;
        int r15 = r10.length - 1;
        if (r14 <= r15) goto L12;
        return;
    L12:
        if (e(r10[r15], r11.getLast()) == false) goto L14;
        r11.removeLast();
    L14:
        r11.addFirst(r10[r15]);
        if (r15 == r14) goto L21;
        r15 = r15 - 1;
        goto L12
    L21:
        return;
    L8:
        r13 = -1;
        goto L9
    }

    private static final <E extends Throwable> E i(E r10, CoroutineStackFrame r11) {
        Pair r12 = b(r10);
        Throwable r13 = (Throwable) r12.component1();
        StackTraceElement[] r14 = (StackTraceElement[]) r12.component2();
        Throwable r15 = ExceptionsConstructorKt.g(r13);
        if (r15 != null) goto L5;
        return r10;
    L5:
        ArrayDeque<StackTraceElement> r16 = d(r11);
        if (r16.isEmpty() == false) goto L8;
        return r10;
    L8:
        if (r13 == r10) goto L11;
        h(r14, r16);
    L11:
        return (E) c(r13, r15, r16);
    }

    public static final <E extends Throwable> E j(E r10) {
        if (kotlinx.coroutines.n0.d() == true) goto L5;
        return r10;
    L5:
        Throwable r11 = ExceptionsConstructorKt.g(r10);
        if (r11 != null) goto L9;
        return r10;
    L9:
        return (E) k(r11);
    }

    private static final <E extends Throwable> E k(E r10) {
        StackTraceElement[] r11 = r10.getStackTrace();
        int r12 = r11.length;
        int r13 = r11.length - 1;
        if (r13 < 0) goto L10;
    L4:
        int r14 = r13 - 1;
        if (Intrinsics.areEqual(f10554c, r11[r13].getClassName()) == true) goto L11;
        if (r14 < 0) goto L10;
        r13 = r14;
    L11:
        int r15 = r13 + 1;
        int r16 = f(r11, f10553b);
        int r17 = 0;
        if (r16 != (-1)) goto L14;
        int r18 = 0;
    L15:
        int r19 = (r12 - r13) - r18;
        StackTraceElement[] r20 = new StackTraceElement[r19];
    L16:
        if (r17 >= r19) goto L21;
        if (r17 != 0) goto L19;
        StackTraceElement r21 = f10552a;
    L20:
        r20[r17] = r21;
        r17 = r17 + 1;
        goto L16
    L19:
        r21 = r11[(r15 + r17) - 1];
        goto L20
    L21:
        r10.setStackTrace(r20);
        return r10;
    L14:
        r18 = r12 - r16;
    L10:
        r13 = -1;
        goto L11
    }

    @PublishedApi
    public static final <E extends Throwable> E l(E r10) {
        E r11 = (E) r10.getCause();
        if (r11 != null) goto L5;
    L15:
        return r10;
    L5:
        if (Intrinsics.areEqual(r11.getClass(), r10.getClass()) == false) goto L15;
        StackTraceElement[] r12 = r10.getStackTrace();
        int r13 = r12.length;
        boolean r14 = false;
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L13;
        if (g(r12[r15]) == true) goto L11;
        r15 = r15 + 1;
        goto L8
    L11:
        r14 = true;
    L13:
        if (r14 == false) goto L15;
        return r11;
    }
}
