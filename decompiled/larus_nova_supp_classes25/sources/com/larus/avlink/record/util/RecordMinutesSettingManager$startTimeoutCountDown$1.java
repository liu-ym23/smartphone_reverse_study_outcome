package com.larus.avlink.record.util;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.avlink.record.page.Action;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.RecordMinutesSettingManager$startTimeoutCountDown$1", f = "RecordMinutesSettingManager.kt", i = {1, 2}, l = {687, 866, 693}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class RecordMinutesSettingManager$startTimeoutCountDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public RecordMinutesSettingManager$startTimeoutCountDown$1(Continuation<? super RecordMinutesSettingManager$startTimeoutCountDown$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new RecordMinutesSettingManager$startTimeoutCountDown$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L13;
        kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L10
    L33:
        ia8.e.a().h();     // Catch: Throwable -> L10
        Iterator<Function1<Action, Unit>> r16 = RecordMinutesSettingManager.g.iterator();     // Catch: Throwable -> L10
    L35:
        if (r16.hasNext() == false) goto L37;
        r16.next().invoke(Action.ERROR);     // Catch: Throwable -> L10
        goto L35
    L37:
        Iterator<Function1<Boolean, Unit>> r17 = RecordMinutesSettingManager.h.iterator();     // Catch: Throwable -> L10
    L39:
        if (r17.hasNext() == false) goto L55;
        r17.next().invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L10
    L55:
        RecordMinutesSettingManager.b = null;     // Catch: Throwable -> L10
        RecordMinutesSettingManager.a.getClass();     // Catch: Throwable -> L10
        RecordMinutesSettingManager.i = null;     // Catch: Throwable -> L10
    L57:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.unlock(null);
        return Unit.INSTANCE;
    L10:
        th = th;
        kotlinx.coroutines.sync.a r3 = r0;
    L61:
        r3.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
    L63:
        q r19 = RecordMinutesSettingManager.b;     // Catch: Throwable -> L52
        if (r19 != null) goto L26;
        r0 = r3;
        goto L57
    L26:
        if (Intrinsics.areEqual(r19.a, "") == true) goto L43;
        if (r19.b != 0) goto L43;
        n1.e("RecordMinutesSettingManager", "GRecord Timeout occurred! Session: " + r19 + ", have message not wakeup");     // Catch: Throwable -> L52
        IChatRepoService r8 = zh8.a.a;     // Catch: Throwable -> L52
        String r9 = r19.a;     // Catch: Throwable -> L52
        this.L$0 = r3;     // Catch: Throwable -> L52
        this.label = 3;     // Catch: Throwable -> L52
        if (r8.q1(r9, 100, null, null, this) != r1) goto L32;
        return r1;
    L32:
        r0 = r3;
    L43:
        if (r19.b != 0) goto L45;
    L54:
        r0 = r3;
        goto L55
    L45:
        if (Intrinsics.areEqual(r19.a, "") == false) goto L54;
        n1.e("RecordMinutesSettingManager", "GRecord Timeout occurred! Session: " + r19 + ", have wakeup not message");     // Catch: Throwable -> L52
        IDoraService r110 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L52
        if (r110 == null) goto L54;
        SessionService r111 = r110.d();     // Catch: Throwable -> L52
        if (r111 == null) goto L54;
        r111.y(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);     // Catch: Throwable -> L52
    L52:
        th = th;
        goto L61
    L15:
        ResultKt.throwOnFailure(r15);
    L19:
        r3 = RecordMinutesSettingManager.e;
        this.L$0 = r3;
        this.label = 2;
        if (r3.a(null, this) != r1) goto L63;
        return r1;
    L16:
        ResultKt.throwOnFailure(r15);
        this.label = 1;
        if (DelayKt.delay(20000, this) != r1) goto L19;
        return r1;
    }
}
