package com.larus.bmhome;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class NotificationControlManager$acquireCoordinatedSlot$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public NotificationControlManager$acquireCoordinatedSlot$1(Object r8) {
        super(0, r8, i0.class, "preemptNotification", "preemptNotification()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m31invoke() {
        i0 r0 = (i0) ((CallableReference) this).receiver;
        i0 r1 = i0.a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (i0.d != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        t0.a.post(new d0());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m31invoke();
        return Unit.INSTANCE;
    }
}
