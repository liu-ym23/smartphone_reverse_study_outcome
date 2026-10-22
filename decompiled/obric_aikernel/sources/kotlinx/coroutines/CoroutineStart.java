package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final enum CoroutineStart extends Enum<CoroutineStart> {
    private static final /* synthetic */ CoroutineStart[] $VALUES = null;
    public static final CoroutineStart ATOMIC = null;
    public static final CoroutineStart DEFAULT = null;
    public static final CoroutineStart LAZY = null;
    public static final CoroutineStart UNDISPATCHED = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10226a = null;

        static {
            int[] r10 = new int[CoroutineStart.values().length];
            r10[CoroutineStart.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r10[CoroutineStart.ATOMIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r10[CoroutineStart.UNDISPATCHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r10[CoroutineStart.LAZY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f10226a = r10;
        }
    }

    private static final /* synthetic */ CoroutineStart[] $values() {
        return new CoroutineStart[]{DEFAULT, LAZY, ATOMIC, UNDISPATCHED};
    }

    static {
        DEFAULT = new CoroutineStart("DEFAULT", 0);
        LAZY = new CoroutineStart("LAZY", 1);
        ATOMIC = new CoroutineStart("ATOMIC", 2);
        UNDISPATCHED = new CoroutineStart("UNDISPATCHED", 3);
        $VALUES = $values();
    }

    private CoroutineStart(String r10, int r11) {
        super(r10, r11);
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public static CoroutineStart valueOf(String r10) {
        return (CoroutineStart) Enum.valueOf(CoroutineStart.class, r10);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) $VALUES.clone();
    }

    public final <T> void invoke(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        int r12 = a.f10226a[ordinal()];
        if (r12 != 1) goto L5;
        fc.a.c(r10, r11);
        return;
    L5:
        if (r12 != 2) goto L7;
        ContinuationKt.startCoroutine(r10, r11);
        return;
    L7:
        if (r12 != 3) goto L9;
        fc.b.a(r10, r11);
        return;
    L9:
        if (r12 != 4) goto L12;
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r10, R r11, Continuation<? super T> r12) {
        int r13 = a.f10226a[ordinal()];
        if (r13 != 1) goto L5;
        fc.a.e(r10, r11, r12, null, 4, null);
        return;
    L5:
        if (r13 != 2) goto L7;
        ContinuationKt.startCoroutine(r10, r11, r12);
        return;
    L7:
        if (r13 != 3) goto L9;
        fc.b.b(r10, r11, r12);
        return;
    L9:
        if (r13 != 4) goto L12;
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isLazy() {
        if (this != LAZY) goto L5;
        return true;
    L5:
        return false;
    }
}
