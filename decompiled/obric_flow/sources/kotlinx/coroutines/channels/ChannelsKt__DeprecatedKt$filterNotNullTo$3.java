package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.x;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {514, 272}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class ChannelsKt__DeprecatedKt$filterNotNullTo$3<E, C extends x> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__DeprecatedKt$filterNotNullTo$3(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNullTo$3> r5) {
        super(r5);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:23:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005f -> B:23:0x0062). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label = (this.label | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        w r12 = null;
        if (r11 != 0) goto L38;
        ResultKt.throwOnFailure(r10);
        throw null;     // Catch: Throwable -> L31
    L31:
        th = th;
    L36:
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        p.d(r12, th);
        throw th;
    L38:
        if (r11 == 1) goto L14;
        if (r11 != 2) goto L13;
        k r13 = (k) this.L$2;
        w r14 = (w) this.L$1;
        x r15 = (x) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L10
        k r16 = r13;
    L23:
        this.L$0 = r15;     // Catch: Throwable -> L10
        this.L$1 = r14;     // Catch: Throwable -> L10
        this.L$2 = r16;     // Catch: Throwable -> L10
        this.label = 1;     // Catch: Throwable -> L10
        e r17 = (e) r16;     // Catch: Throwable -> L10
        r10 = r17.c(this);     // Catch: Throwable -> L10
        Object r18 = r17;
        if (r10 == r5) goto L43;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L26;
        e r19 = (e) r18;     // Catch: Throwable -> L10
        Object r20 = r19.d();     // Catch: Throwable -> L10
        r16 = r19;
        if (r20 == null) goto L23;
        this.L$0 = r15;     // Catch: Throwable -> L10
        this.L$1 = r14;     // Catch: Throwable -> L10
        this.L$2 = r19;     // Catch: Throwable -> L10
        this.label = 2;     // Catch: Throwable -> L10
        r16 = r19;
        if (r15.r(r20, this) != r5) goto L23;
        return r5;
    L26:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r14.cancel(null);
        return r15;
    L43:
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        k r22 = (k) this.L$2;
        r14 = (w) this.L$1;
        r15 = (x) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L10
        r18 = r22;
    L10:
        th = th;
        r12 = r14;
        goto L36
    }
}
