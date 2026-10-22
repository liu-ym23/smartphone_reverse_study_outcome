package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$handleRecordWakeUp$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LarkRecordMinutesManager$handleRecordWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $kw;
    final /* synthetic */ int $mode;
    final /* synthetic */ int $query;
    final /* synthetic */ int $state;
    final /* synthetic */ int $vuiId;
    int label;

    public LarkRecordMinutesManager$handleRecordWakeUp$1(int r1, int r2, int r3, int r4, String r5, Continuation<? super LarkRecordMinutesManager$handleRecordWakeUp$1> r6) {
        this.$state = r1;
        this.$mode = r2;
        this.$query = r3;
        this.$vuiId = r4;
        this.$kw = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new LarkRecordMinutesManager$handleRecordWakeUp$1(this.$state, this.$mode, this.$query, this.$vuiId, this.$kw, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L46;
        ResultKt.throwOnFailure(r15);
        LarkRecordMinutesManager r1 = LarkRecordMinutesManager.a;
        int r5 = this.$state;
        int r6 = this.$mode;
        int r7 = this.$query;
        int r16 = this.$vuiId;
        String r8 = this.$kw;
        r1.getClass();
        n1.d("LarkRecordMinutesManager", "GRecord handleRecordWakeUp in Lark record state:" + r5 + ", mode:" + r6 + ", query:" + r7 + ", vuiId:" + r16 + ", kw:" + r8);
        Object r0 = LarkRecordMinutesManager.d;
        monitor-enter(r0);
        int r4 = 0;
        if (LarkRecordMinutesManager.e != LarkRecordMinutesManager.RecordingLifecycle.IDLE) goto L9;
        boolean r2 = true;
    L10:
        String r3 = null;
        if (r2 == false) goto L13;
    L15:
        LarkRecordMinutesManager.e = LarkRecordMinutesManager.RecordingLifecycle.STARTING;     // Catch: Throwable -> L42
        LarkRecordMinutesManager.f = true;     // Catch: Throwable -> L42
        Job r10 = LarkRecordMinutesManager.h;     // Catch: Throwable -> L42
        if (r10 == null) goto L18;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);     // Catch: Throwable -> L42
    L18:
        LarkRecordMinutesManager.h = null;     // Catch: Throwable -> L42
        long r11 = LarkRecordMinutesManager.j + 1;     // Catch: Throwable -> L42
        LarkRecordMinutesManager.j = r11;     // Catch: Throwable -> L42
        LarkRecordMinutesManager.c r12 = new LarkRecordMinutesManager.c(r11, r2);     // Catch: Throwable -> L42
    L19:
        monitor-exit(r0);
        if (r12 != null) goto L23;
        n1.d("LarkRecordMinutesManager", "GRecord ignore duplicate device START callback, lifecycle=" + LarkRecordMinutesManager.e + ", vuiId=" + r16);
    L41:
        return Unit.INSTANCE;
    L23:
        if (r12.b == false) goto L25;
        LarkRecordMinutesManager.y();
    L25:
        LarkRecordMinutesManager.N();
        if (r6 != 16) goto L28;
        r3 = LarkRecordMinutesManager.i();
    L28:
        if (r3 == null) goto L30;
        LarkRecordMinutesManager.C = r3;
        String r9 = "recorder_app";
    L37:
        if (r6 != 17) goto L39;
        r4 = 1;
    L39:
        r1.F(new k(r16, r9, r4), r12.a, r5, r6, r7, r8);
        goto L41
    L30:
        switch(r6) {
            case 14: goto L35;
            case 15: goto L34;
            case 16: goto L33;
            case 17: goto L32;
            default: goto L31;
        };
    L31:
        r9 = "unknown";
        goto L37
    L32:
        r9 = "auto_enter_on_call_start";
        goto L37
    L33:
        r9 = "click_start_icon";
        goto L37
    L34:
        r9 = "gesture_control";
        goto L37
    L35:
        r9 = "voice_control";
        goto L37
    L13:
        if (LarkRecordMinutesManager.e == LarkRecordMinutesManager.RecordingLifecycle.START_REQUESTED) goto L15;
        r12 = null;
        goto L19
    L9:
        r2 = false;
    L42:
        th = move-exception;
        throw th;
    L46:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
