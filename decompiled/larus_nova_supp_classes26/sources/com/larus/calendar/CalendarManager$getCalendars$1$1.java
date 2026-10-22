package com.larus.calendar;

import android.database.Cursor;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/larus/calendar/CalendarManager$Calendar;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.calendar.CalendarManager$getCalendars$1$1", f = "CalendarManager.kt", i = {0}, l = {246}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class CalendarManager$getCalendars$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super CalendarManager.a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    public CalendarManager$getCalendars$1$1(Cursor r1, Continuation<? super CalendarManager$getCalendars$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CalendarManager$getCalendars$1$1 r0 = new CalendarManager$getCalendars$1$1(this.$it, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super CalendarManager.a> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00bc -> B:15:0x00bd). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 1;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        SequenceScope r4 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r19);
        CalendarManager$getCalendars$1$1 r5 = this;
    L15:
        r3 = 1;
    L10:
        if (r5.$it.moveToNext() == false) goto L17;
        long r6 = r5.$it.getLong(0);
        String r15 = r5.$it.getString(r3);
        String r11 = r5.$it.getString(2);
        String r14 = r5.$it.getString(3);
        String r13 = r5.$it.getString(4);
        int r16 = r5.$it.getInt(5);
        String r12 = r5.$it.getString(6);
        Object r17 = r1;
        CalendarManager.a r10 = new CalendarManager.a(r6, r15, r11, r13, r14, r16, r12);
        FLogger.a.d("CalendarManager", "------Calendar account:" + r6 + "---" + r15 + "---" + r14 + "----" + r13 + "-----" + r12);
        r5.L$0 = r4;
        r5.label = 1;
        if (r4.yield(r10, r5) != r17) goto L14;
        return r17;
    L14:
        r1 = r17;
        goto L15
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        r4 = (SequenceScope) this.L$0;
        r5 = this;
        goto L10
    }
}
