package com.bytedance.android.annie.bridge.method.calendar;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lcom/bytedance/android/annie/bridge/method/calendar/b;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.annie.bridge.method.calendar.CalendarCreateReducer$getCalendars$1$1", f = "CalendarCreateReducer.kt", i = {0}, l = {210}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
final class CalendarCreateReducer$getCalendars$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super b>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    public CalendarCreateReducer$getCalendars$1$1(Cursor r1, Continuation<? super CalendarCreateReducer$getCalendars$1$1> r10) {
        this.$it = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CalendarCreateReducer$getCalendars$1$1 r0 = new CalendarCreateReducer$getCalendars$1$1(this.$it, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((SequenceScope) r1, (Continuation) r10);
    }

    public final Object invoke(SequenceScope<? super b> r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        SequenceScope r11 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r18);
    L11:
        if (this.$it.moveToNext() == false) goto L16;
        long r12 = this.$it.getLong(0);
        String r13 = this.$it.getString(1);
        String r14 = this.$it.getString(2);
        String r15 = this.$it.getString(3);
        b r16 = new b(r12, r13, r14, this.$it.getString(4), r15, this.$it.getInt(5), this.$it.getString(6), this.$it.getInt(7));
        this.L$0 = r11;
        this.label = 1;
        if (r11.yield(r16, this) != r1) goto L11;
        return r1;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        r11 = (SequenceScope) this.L$0;
        goto L11
    }
}
