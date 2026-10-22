package com.larus.share.impl.panel;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.panel.SharePanelDialog$observePublishInsertEvent$1", f = "SharePanelDialog.kt", i = {}, l = {507}, m = "invokeSuspend", n = {}, s = {})
final class SharePanelDialog$observePublishInsertEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SharePanelDialog this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ SharePanelDialog a;

        public a(SharePanelDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            com.larus.bmhome.share.panel.k r6 = (com.larus.bmhome.share.panel.k) r4;
            if ((r6 instanceof com.larus.bmhome.share.panel.k.b) == false) goto L6;
            Pair r7 = TuplesKt.to("set_private", "publish");
        L8:
            String r8 = (String) r7.component1();
            String r9 = (String) r7.component2();
            FLogger.a.i("SharePanelDialog", "收到 PublishInsertEvent: " + r8 + " -> " + r9);
            SharePanelAdapter r0 = this.a.o;
            if (r0 == null) goto L18;
            Boxing.boxBoolean(r0.D2(r8, r9));
        L18:
            return Unit.INSTANCE;
        L6:
            if ((r6 instanceof com.larus.bmhome.share.panel.k.c) == false) goto L13;
            r7 = TuplesKt.to("publish", "set_private");
            goto L8
        L13:
            if ((r6 instanceof com.larus.bmhome.share.panel.k.a) == false) goto L17;
            return Unit.INSTANCE;
        L17:
            throw new NoWhenBranchMatchedException();
        }
    }

    public SharePanelDialog$observePublishInsertEvent$1(SharePanelDialog r1, Continuation<? super SharePanelDialog$observePublishInsertEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SharePanelDialog$observePublishInsertEvent$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        a1 r6 = com.larus.bmhome.share.panel.l.b;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
