package com.larus.dora.o.impl.health.calendar;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.health.calendar.OHealthCalendarDialog$loadMonthIfNeeded$1", f = "OHealthCalendarDialog.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
public final class OHealthCalendarDialog$loadMonthIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ OHealthCalendarDialog this$0;

    public OHealthCalendarDialog$loadMonthIfNeeded$1(String r1, OHealthCalendarDialog r2, Continuation<? super OHealthCalendarDialog$loadMonthIfNeeded$1> r3) {
        this.$key = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OHealthCalendarDialog$loadMonthIfNeeded$1(this.$key, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        final d r8 = (d) r7;
        if (this.this$0.isAdded() == false) goto L14;
        if (r8 != null) goto L21;
        OHealthCalendarDialog.U90(this.this$0, this.$key, new j());
        Context r3 = this.this$0.getContext();
        if (r3 == null) goto L20;
        s.j(s.a, r3, r3.getString(2131908080), null, false, 28);
    L20:
        return Unit.INSTANCE;
    L21:
        OHealthCalendarDialog.U90(this.this$0, this.$key, new k(r8));
        LinearLayoutManager r9 = this.this$0.h;
        if (r9 != null) goto L24;
    L26:
        r2 = false;
    L27:
        if (r2 == false) goto L30;
        OHealthCalendarDialog.T90(this.this$0);
    L30:
        return Unit.INSTANCE;
    L24:
        if (r9.findFirstVisibleItemPosition() != 0) goto L26;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DoraOHealthCalendarRepo r10 = DoraOHealthCalendarRepo.a;
        String r4 = this.$key;
        this.label = 1;
        r7 = r10.a(r4, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
