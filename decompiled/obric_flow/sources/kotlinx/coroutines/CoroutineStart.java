package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u0002H\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0087\u0002¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "invoke", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CoroutineStart extends Enum<CoroutineStart> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CoroutineStart[] $VALUES = null;
    public static final CoroutineStart ATOMIC = null;
    public static final CoroutineStart DEFAULT = null;
    public static final CoroutineStart LAZY = null;
    public static final CoroutineStart UNDISPATCHED = null;

    private static final /* synthetic */ CoroutineStart[] $values() {
        return new CoroutineStart[]{DEFAULT, LAZY, ATOMIC, UNDISPATCHED};
    }

    static {
        DEFAULT = new CoroutineStart("DEFAULT", 0);
        LAZY = new CoroutineStart("LAZY", 1);
        ATOMIC = new CoroutineStart("ATOMIC", 2);
        UNDISPATCHED = new CoroutineStart("UNDISPATCHED", 3);
        CoroutineStart[] r5 = $values();
        $VALUES = r5;
        $ENTRIES = EnumEntriesKt.enumEntries(r5);
    }

    private CoroutineStart(String r5, int r10) {
        super(r5, r10);
    }

    public static EnumEntries<CoroutineStart> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public static CoroutineStart valueOf(String r5) {
        return (CoroutineStart) Enum.valueOf(CoroutineStart.class, r5);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) $VALUES.clone();
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r5, R r10, Continuation<? super T> r11) {
        int r12 = i0.f18924a[ordinal()];
        if (r12 != 1) goto L5;
        xt.a.b(r5, r10, r11);
        return;
    L5:
        if (r12 != 2) goto L7;
        ContinuationKt.startCoroutine(r5, r10, r11);
        return;
    L7:
        if (r12 != 3) goto L9;
        Continuation r13 = DebugProbesKt.probeCoroutineCreated(r11);
        CoroutineContext r14 = r13.getContext();     // Catch: Throwable -> L25
        Object r15 = kotlinx.coroutines.internal.v.c(r14, null);     // Catch: Throwable -> L25
        DebugProbesKt.probeCoroutineResumed(r13);     // Catch: Throwable -> L18
        if ((r5 instanceof BaseContinuationImpl) == true) goto L20;
        Object r16 = IntrinsicsKt.wrapWithContinuationImpl(r5, r10, r13);     // Catch: Throwable -> L18
    L21:
        kotlinx.coroutines.internal.v.a(r14, r15);     // Catch: Throwable -> L25
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        r13.resumeWith(Result.m124constructorimpl(r16));
        return;
    L35:
        return;
    L20:
        r16 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 2)).mo2invoke(r10, r13);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        kotlinx.coroutines.internal.v.a(r14, r15);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(th)));
        return;
    L9:
        if (r12 != 4) goto L12;
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
