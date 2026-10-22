package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
public final class ExceptionsConstructorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f10526a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f10527b = null;

    static {
        f10526a = e(Throwable.class, -1);
    L8:
        k r10 = q0.f10581a;
    L9:
        f10527b = r10;
        return;
    L4:
        if (o.a() == false) goto L6;
        r10 = q0.f10581a;     // Catch: Throwable -> L8
    L11:
        goto L9
    L6:
        r10 = c.f10541a;     // Catch: Throwable -> L8
        goto L11
    }

    public static final /* synthetic */ Function1 a(Class r10) {
        return b(r10);
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> b(Class<E> r13) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 r10 = ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE;
        if (f10526a == e(r13, 0)) goto L5;
        return r10;
    L5:
        Constructor<?>[] r14 = r13.getConstructors();
        ArrayList r11 = new ArrayList(r14.length);
        int r12 = r14.length;
        int r15 = 0;
    L6:
        Object r16 = null;
        if (r15 >= r12) goto L27;
        final Constructor<?> r17 = r14[r15];
        Class<?>[] r18 = r17.getParameterTypes();
        int r19 = r18.length;
        if (r19 != 0) goto L11;
        r16 = f(new ExceptionsConstructorKt$createConstructor$1$4(r17));
        int r20 = 0;
    L26:
        r11.add(TuplesKt.to(r16, r20));
        r15 = r15 + 1;
        goto L6
    L11:
        if (r19 == 1) goto L19;
        if (r19 == 2) goto L15;
    L13:
        r20 = -1;
        goto L26
    L15:
        if (Intrinsics.areEqual(r18[0], String.class) == false) goto L13;
        if (Intrinsics.areEqual(r18[1], Throwable.class) == false) goto L13;
        r16 = f(new ExceptionsConstructorKt$createConstructor$1$1(r17));
        r20 = 3;
        goto L26
    L19:
        Class<?> r21 = r18[0];
        if (Intrinsics.areEqual(r21, String.class) == false) goto L23;
        r16 = f(new ExceptionsConstructorKt$createConstructor$1$2(r17));
        r20 = 2;
        goto L26
    L23:
        if (Intrinsics.areEqual(r21, Throwable.class) == false) goto L13;
        r16 = f(new ExceptionsConstructorKt$createConstructor$1$3(r17));
        r20 = 1;
        goto L26
    L27:
        Iterator r110 = r11.iterator();
        if (r110.hasNext() == false) goto L39;
        r16 = r110.next();
        if (r110.hasNext() == false) goto L39;
        int r22 = ((Number) ((Pair) r16).getSecond()).intValue();
    L34:
        Object r23 = r110.next();
        int r24 = ((Number) ((Pair) r23).getSecond()).intValue();
        if (r22 >= r24) goto L38;
        r16 = r23;
        r22 = r24;
    L38:
        if (r110.hasNext() == true) goto L34;
    L39:
        Pair r25 = (Pair) r16;
        if (r25 == null) goto L54;
        Function1<Throwable, Throwable> r111 = (Function1) r25.getFirst();
        if (r111 != null) goto L45;
        return r10;
    L45:
        return r111;
    L54:
        return r10;
    }

    private static final int c(Class<?> r10, int r11) {
    L2:
        Field[] r12 = r10.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        if ((!Modifier.isStatic(r12[r14].getModifiers())) == false) goto L7;
        r15 = r15 + 1;
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r11 = r11 + r15;
        r10 = r10.getSuperclass();
        if (r10 != null) goto L2;
        return r11;
    }

    static /* synthetic */ int d(Class r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        return c(r10, r11);
    }

    private static final int e(Class<?> r10, int r11) {
        JvmClassMappingKt.getKotlinClass(r10);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.m32constructorimpl(Integer.valueOf(d(r10, 0, 1, null)));     // Catch: Throwable -> L5
    L7:
        Integer r14 = Integer.valueOf(r11);
        if (Result.m38isFailureimpl(r13) == false) goto L11;
        r13 = r14;
    L11:
        return ((Number) r13).intValue();
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Function1<Throwable, Throwable> f(final Function1<? super Throwable, ? extends Throwable> r10) {
        return new ExceptionsConstructorKt$safeCtor$1(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E g(E r10) {
        if ((r10 instanceof kotlinx.coroutines.g0) == false) goto L14;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Object r12 = Result.m32constructorimpl(((kotlinx.coroutines.g0) r10).createCopy());     // Catch: Throwable -> L6
    L9:
        if (Result.m38isFailureimpl(r12) == false) goto L12;
        r12 = null;
    L12:
        return (E) r12;
    L6:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L9
    L14:
        return (E) f10527b.a(r10.getClass()).invoke(r10);
    }
}
