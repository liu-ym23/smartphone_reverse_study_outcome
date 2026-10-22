package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.avlink.record.page.Action;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$tryStartRecordInternal$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LarkRecordMinutesManager$tryStartRecordInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $mode;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.avlink.record.util.LarkRecordMinutesManager$tryStartRecordInternal$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$tryStartRecordInternal$1$2", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            LarkRecordMinutesManager r3 = LarkRecordMinutesManager.a;
            Action r0 = Action.ERROR;
            r3.getClass();
            LarkRecordMinutesManager.z(r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.util.LarkRecordMinutesManager$tryStartRecordInternal$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$tryStartRecordInternal$1$3", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass3(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            LarkRecordMinutesManager.a.getClass();
            LarkRecordMinutesManager.B();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LarkRecordMinutesManager$tryStartRecordInternal$1(int r1, Continuation<? super LarkRecordMinutesManager$tryStartRecordInternal$1> r2) {
        this.$mode = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LarkRecordMinutesManager$tryStartRecordInternal$1 r0 = new LarkRecordMinutesManager$tryStartRecordInternal$1(this.$mode, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        int r11 = this.$mode;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        SessionService r3 = r2.d();     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        Integer r12 = Boxing.boxInt(r3.l(r11, true));     // Catch: Throwable -> L13
    L11:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r13);
        if (r4 == null) goto L19;
        n1.b("LarkRecordMinutesManager", "GRecord startVUI failed: " + r4.getMessage());
    L19:
        if (Result.isFailure-impl(r13) == false) goto L21;
        r13 = null;
    L21:
        Integer r14 = (Integer) r13;
        Object r5 = LarkRecordMinutesManager.d;
        monitor-enter(r5);
        LarkRecordMinutesManager.g = false;     // Catch: Throwable -> L38
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r5);
        if (r14 == null) goto L31;
        if (r14.intValue() != 0) goto L31;
    L34:
        if (LarkRecordMinutesManager.e != LarkRecordMinutesManager.RecordingLifecycle.STOP_PENDING) goto L37;
        BuildersKt.launch$default(LarkRecordMinutesManager.c, null, null, new AnonymousClass3(null), 3, null);
    L37:
        return Unit.INSTANCE;
    L31:
        if (LarkRecordMinutesManager.b(LarkRecordMinutesManager.a) == false) goto L34;
        n1.e("LarkRecordMinutesManager", "GRecord startVUI rejected, result=" + r14);
        BuildersKt.launch$default(LarkRecordMinutesManager.c, null, null, new AnonymousClass2(null), 3, null);
    L38:
        th = move-exception;
        throw th;
    L10:
        r12 = null;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
