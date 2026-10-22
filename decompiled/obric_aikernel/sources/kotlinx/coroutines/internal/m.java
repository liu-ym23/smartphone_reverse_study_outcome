package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n297#1,5:325\n302#1,12:331\n314#1:387\n301#1:389\n302#1,12:391\n314#1:420\n217#2,7:318\n224#2:346\n243#2,8:347\n225#2:355\n255#2:356\n256#2,2:367\n258#2:371\n227#2:372\n229#2:388\n1#3:330\n1#3:390\n1#3:421\n200#4,3:343\n203#4,14:373\n200#4,17:403\n200#4,17:422\n107#5,10:357\n118#5,2:369\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n282#1:325,5\n282#1:331,12\n282#1:387\n287#1:389\n287#1:391,12\n287#1:420\n282#1:318,7\n282#1:346\n282#1:347,8\n282#1:355\n282#1:356\n282#1:367,2\n282#1:371\n282#1:372\n282#1:388\n282#1:330\n287#1:390\n282#1:343,3\n282#1:373,14\n287#1:403,17\n313#1:422,17\n282#1:357,10\n282#1:369,2\n*E\n"})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i0 f10563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final i0 f10564b = null;

    static {
        f10563a = new i0("UNDEFINED");
        f10564b = new i0("REUSABLE_CLAIMED");
    }

    public static final /* synthetic */ i0 a() {
        return f10563a;
    }

    public static final <T> void b(Continuation<? super T> r10, Object r11, Function1<? super Throwable, Unit> r12) {
        if ((r10 instanceof l) == false) goto L43;
        l r13 = (l) r10;
        Object r14 = kotlinx.coroutines.e0.b(r11, r12);
        if (r13.f10559i.isDispatchNeeded(r13.getContext()) == false) goto L7;
        r13.f10561k = r14;
        r13.f10728h = 1;
        r13.f10559i.dispatch(r13.getContext(), r13);
        return;
    L7:
        kotlinx.coroutines.n0.a();
        f1 r15 = s2.f10631a.b();
        if (r15.j0() == false) goto L10;
        r13.f10561k = r14;
        r13.f10728h = 1;
        r15.f0(r13);
        return;
    L10:
        r15.h0(true);
        v1 r16 = (v1) r13.getContext().get(v1.f10723e);     // Catch: Throwable -> L37
        if (r16 != null) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r17 == true) goto L35;
        Continuation<T> r18 = r13.f10560j;     // Catch: Throwable -> L37
        Object r19 = r13.f10562l;     // Catch: Throwable -> L37
        CoroutineContext r20 = r18.getContext();     // Catch: Throwable -> L37
        Object r21 = ThreadContextKt.c(r20, r19);     // Catch: Throwable -> L37
        if (r21 == ThreadContextKt.f10533a) goto L22;
        a3<?> r22 = CoroutineContextKt.g(r18, r20, r21);     // Catch: Throwable -> L37
    L47:
        r13.f10560j.resumeWith(r11);     // Catch: Throwable -> L28
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L28
        if (r22 != null) goto L26;
    L27:
        ThreadContextKt.a(r20, r21);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (r22.j1() == false) goto L35;
    L28:
        th = move-exception;
        if (r22 != null) goto L31;
    L32:
        ThreadContextKt.a(r20, r21);     // Catch: Throwable -> L37
    L33:
        throw th;     // Catch: Throwable -> L37
    L31:
        if (r22.j1() == false) goto L33;
    L22:
        r22 = null;
    L35:
        if (r15.m0() == true) goto L35;
    L39:
        r15.c0(true);
        return;
    L14:
        if (r16.isActive() == true) goto L16;
        CancellationException r24 = r16.p();     // Catch: Throwable -> L37
        r13.b(r14, r24);     // Catch: Throwable -> L37
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L37
        r13.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r24)));     // Catch: Throwable -> L37
        r17 = true;
    L37:
        th = move-exception;
        r13.g(th, null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r15.c0(true);
        throw th;
    L43:
        r10.resumeWith(r11);
    }

    public static /* synthetic */ void c(Continuation r10, Object r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        b(r10, r11, r12);
    }

    public static final boolean d(l<? super Unit> r10) {
        Unit r11 = Unit.INSTANCE;
        kotlinx.coroutines.n0.a();
        f1 r12 = s2.f10631a.b();
        if (r12.k0() == false) goto L6;
        return false;
    L6:
        if (r12.j0() == false) goto L8;
        r10.f10561k = r11;
        r10.f10728h = 1;
        r12.f0(r10);
        return true;
    L8:
        r12.h0(true);
        r10.run();     // Catch: Throwable -> L13
    L10:
        if (r12.m0() == true) goto L10;
    L16:
        r12.c0(true);
        return false;
    L13:
        th = move-exception;
        r10.g(th, null);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r12.c0(true);
        throw th;
    }
}
