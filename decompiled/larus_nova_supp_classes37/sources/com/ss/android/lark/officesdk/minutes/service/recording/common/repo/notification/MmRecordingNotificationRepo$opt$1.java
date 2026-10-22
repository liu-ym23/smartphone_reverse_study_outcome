package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingNotificationRepo$opt$1 implements c {
    public final /* synthetic */ MmRecordingNotificationRepo a;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    public final i1<a> b() {
        return this.a.g();
    }

    @Override // fvb.a
    public final void onDestroy() {
        this.a.i();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    public final Object m() {
        return (a) c.a.a(this);
    }

    public MmRecordingNotificationRepo$opt$1(MmRecordingNotificationRepo r1) {
        this.a = r1;
    }

    public final Object T0(b r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1) == false) goto L7;
        MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1 r0 = (MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L35:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (b) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        a r4 = (a) m();
        if ((r11 instanceof b.d) == false) goto L23;
        a r14 = a.a(r4, ((b.d) r11).a, false, false, false, 14);
    L31:
        MmRecordingNotificationRepo r15 = this.a;
        r0.L$0 = null;
        r0.label = 2;
        if (r15.b(r14, r0) != r2) goto L35;
        return r2;
    L23:
        if ((r11 instanceof b.a) == false) goto L26;
        r14 = a.a(r4, false, true, false, false, 13);
        goto L31
    L26:
        if ((r11 instanceof b.c) == false) goto L29;
        r14 = a.a(r4, false, false, ((b.c) r11).a, false, 11);
        goto L31
    L29:
        if ((r11 instanceof b.C0044b) == false) goto L37;
        r14 = a.a(r4, false, false, false, ((b.C0044b) r11).a, 7);
        goto L31
    L37:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r13);
        MmRecordingNotificationRepo r16 = this.a;
        r0.L$0 = r11;
        r0.label = 1;
        if (r16.k(r11, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1(this, r12);
        goto L8
    }
}
