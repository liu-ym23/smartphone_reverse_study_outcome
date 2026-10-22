package kotlinx.coroutines.sync;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class MutexKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i0 f10702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i0 f10703b = null;

    static {
        f10702a = new i0("NO_OWNER");
        f10703b = new i0("ALREADY_LOCKED_BY_OWNER");
    }

    public static final a a(boolean r10) {
        return new MutexImpl(r10);
    }

    public static /* synthetic */ a b(boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return a(r10);
    }

    public static final /* synthetic */ i0 c() {
        return f10702a;
    }

    public static final /* synthetic */ i0 d() {
        return f10703b;
    }

    public static final <T> Object e(a r10, Object r11, Function0<? extends T> r12, Continuation<? super T> r13) {
        if ((r13 instanceof MutexKt$withLock$1) == false) goto L7;
        MutexKt$withLock$1 r14 = (MutexKt$withLock$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        r12 = (Function0) r14.L$2;
        r11 = r14.L$1;
        r10 = (a) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L23:
        T r19 = r12.invoke();     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        r10.c(r11);
        InlineMarker.finallyEnd(1);
        return r19;
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.c(r11);
        InlineMarker.finallyEnd(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r14.L$0 = r10;
        r14.L$1 = r11;
        r14.L$2 = r12;
        r14.label = 1;
        if (r10.b(r11, r14) != r17) goto L23;
        return r17;
    L7:
        r14 = new MutexKt$withLock$1(r13);
        goto L8
    }
}
