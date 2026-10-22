package com.larus.bmhome.tipoff;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffDialogFragment$loadOnlineReasonList$1", f = "TipOffDialogFragment.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
final class TipOffDialogFragment$loadOnlineReasonList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TipOffDialogFragment this$0;

    public TipOffDialogFragment$loadOnlineReasonList$1(TipOffDialogFragment r1, Continuation<? super TipOffDialogFragment$loadOnlineReasonList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        TipOffDialogFragment$loadOnlineReasonList$1 r0 = new TipOffDialogFragment$loadOnlineReasonList$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L21
    L13:
        b r9 = (b) ((com.larus.network.http.a) r8).b;     // Catch: Throwable -> L21
        if (r9 == null) goto L18;
        List<ReportReason> r10 = r9.a();     // Catch: Throwable -> L21
        if (r10 == null) goto L18;
        List r11 = CollectionsKt.filterNotNull(r10);     // Catch: Throwable -> L21
    L19:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L21
    L23:
        TipOffDialogFragment r4 = this.this$0;
        Throwable r5 = Result.exceptionOrNull-impl(r12);
        if (r5 == null) goto L27;
        FLogger.a.e("TipOffDialogFragment", "loadOnlineReasonList failed, reportType=" + r4.g, r5);
    L27:
        if (Result.isFailure-impl(r12) == true) goto L30;
        r2 = r12;
    L30:
        List r6 = (List) r2;
        List r13 = r6;
        if (r13 != null) goto L33;
    L36:
        if (r3 == false) goto L38;
        TipOffDialogFragment r14 = this.this$0;
        int r7 = TipOffDialogFragment.w;
        r14.V90(r14.U90());
    L44:
        return Unit.INSTANCE;
    L38:
        TipOffDialogFragment r15 = this.this$0;
        List r16 = r6;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L40:
        if (r18.hasNext() == false) goto L42;
        ReportReason r19 = (ReportReason) r18.next();
        r17.add(new com.larus.bmhome.auth.ReportReason(r19.b(), r19.a()));
        goto L40
    L42:
        int r20 = TipOffDialogFragment.w;
        r15.V90(r17);
        goto L44
    L33:
        if (r13.isEmpty() == true) goto L36;
        r3 = false;
    L18:
        r11 = null;
        goto L19
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r21 = (CoroutineScope) this.L$0;
        TipOffDialogFragment r22 = this.this$0;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L21
        int r24 = TipOffApi.a;     // Catch: Throwable -> L21
        String r25 = String.valueOf(r22.g);     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r8 = TipOffApi.a(r25, this);     // Catch: Throwable -> L21
        if (r8 != r0) goto L13;
        return r0;
    L21:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
