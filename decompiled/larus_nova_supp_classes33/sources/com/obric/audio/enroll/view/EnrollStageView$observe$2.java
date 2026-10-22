package com.obric.audio.enroll.view;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.recorder.RecordState;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$observe$2", f = "EnrollStageView.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollStageView$observe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollStageView this$0;

    /* JADX INFO: renamed from: com.obric.audio.enroll.view.EnrollStageView$observe$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ EnrollStageView a;

        /* JADX INFO: renamed from: com.obric.audio.enroll.view.EnrollStageView$observe$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$observe$2$1$1", f = "EnrollStageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $taskId;
            int label;
            final /* synthetic */ EnrollStageView this$0;

            public C00331(EnrollStageView r1, String r2, Continuation<? super C00331> r3) {
                this.this$0 = r1;
                this.$taskId = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00331(this.this$0, this.$taskId, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r7) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L42;
                ResultKt.throwOnFailure(r7);
                if (this.this$0.getViewModel().getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L36;
                AtomicReference<com.obric.audio.enroll.b.a> r8 = com.obric.audio.enroll.b.a;
                String r9 = this.$taskId;
                EnrollStageView r0 = this.this$0;
                Intrinsics.checkNotNullParameter(r9, "taskId");
                Intrinsics.checkNotNullParameter(r0, "callback");
                if (StringsKt.isBlank(r9) == true) goto L10;
                com.obric.audio.enroll.b.a.set(new com.obric.audio.enroll.b.a(r9, r0));
            L10:
                int r10 = oia.a.a;
                FLogger.a.i("EnrollDoraWakeupService", "enableVUI");
                Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L16
                IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L16
                if (r12 == null) goto L18;
                Result.constructor-impl(Integer.valueOf(r12.d().e()));     // Catch: Throwable -> L16
            L18:
                int r13 = oia.a.a;
                IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L33
                if (r1 == null) goto L47;
                SessionService r2 = r1.d();     // Catch: Throwable -> L33
                if (r2 == null) goto L47;
                DeviceService r3 = r1.device();     // Catch: Throwable -> L33
                if (r3 != null) goto L28;
            L30:
                boolean r4 = false;
            L31:
                FLogger.a.i("EnrollDoraWakeupService", "startVUIForEnroll isOta3p5: " + r4);     // Catch: Throwable -> L33
                Result.constructor-impl(Integer.valueOf(r2.l(18, true)));     // Catch: Throwable -> L33
                goto L47
            L28:
                if (r3.n0("ota3p5") != true) goto L30;
                r4 = true;
            L47:
                return Unit.INSTANCE;
            L33:
                th = move-exception;
                Result.Companion r5 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            L16:
                th = move-exception;
                Result.Companion r6 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                goto L18
            L36:
                FLogger.a.i("EnrollStageView", "IEnrollService startRecord taskId=" + this.$taskId + " deviceType=" + this.this$0.getViewModel().getEnrollDeviceType());
                IEnrollService.a.getClass();
                IEnrollService r14 = IEnrollService.a.a();
                if (r14 == null) goto L39;
                r14.d(this.$taskId, this.this$0);
                return Unit.INSTANCE;
            L39:
                return null;
            L42:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.audio.enroll.view.EnrollStageView$observe$2$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.audio.enroll.view.EnrollStageView$observe$2$1$2", f = "EnrollStageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $taskId;
            int label;
            final /* synthetic */ EnrollStageView this$0;

            public AnonymousClass2(String r1, EnrollStageView r2, Continuation<? super AnonymousClass2> r3) {
                this.$taskId = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.$taskId, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r3);
                FLogger.a.i("EnrollStageView", "IEnrollService stopRecord taskId=" + this.$taskId + " deviceType=" + this.this$0.getViewModel().getEnrollDeviceType());
                IEnrollService.a.getClass();
                IEnrollService r4 = IEnrollService.a.a();
                if (r4 == null) goto L8;
                r4.a(this.$taskId);
            L8:
                if (this.this$0.getViewModel().getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L11;
                com.obric.audio.enroll.b.a.set(null);
                oia.a.b();
                oia.a.a();
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.audio.enroll.view.EnrollStageView$observe$2$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RecordState.values().length];
                r0[RecordState.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[RecordState.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public AnonymousClass1(EnrollStageView r1) {
            this.a = r1;
        }

        public final Object a(com.obric.audio.enroll.recorder.a r10, Continuation<? super Unit> r11) {
            if ((r11 instanceof EnrollStageView$observe$2$1$emit$1) == false) goto L7;
            EnrollStageView$observe$2$1$emit$1 r0 = (EnrollStageView$observe$2$1$emit$1) r11;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r12 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r12);
        L36:
            this.a.getViewModel().getAsrState().setValue(Boxing.boxInt(0));
        L53:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r12);
        L51:
            this.a.getViewModel().getAsrState().setValue(Boxing.boxInt(1));
            goto L53
        L16:
            ResultKt.throwOnFailure(r12);
            FLogger.a.i("EnrollStageView", "observe recordingEvent " + r10);
            Iterator<T> r13 = this.a.b.iterator();
        L18:
            if (r13.hasNext() == false) goto L25;
            T r4 = r13.next();
            if (((EnrollTeamView) r4).getIndex() != r10.a) goto L22;
            boolean r7 = true;
        L23:
            if (r7 == false) goto L18;
        L26:
            EnrollTeamView r5 = r4;
            if (r5 == null) goto L29;
            int r14 = a.a[r10.b.ordinal()];
            if (r14 == 1) goto L40;
            if (r14 != 2) goto L38;
            String r15 = r5.U5();
            CoroutineDispatcher r16 = Dispatchers.getIO();
            AnonymousClass2 r6 = new AnonymousClass2(r15, this.a, null);
            r0.label = 2;
            if (BuildersKt.withContext(r16, r6, r0) != r2) goto L36;
            return r2;
        L38:
            throw new NoWhenBranchMatchedException();
        L40:
            if (r5.k == false) goto L48;
            r5.k = false;
            UUID r17 = r5.g;
            if (r17 == null) goto L44;
            String r18 = r17.toString();
        L45:
            if (r18 != null) goto L47;
            r18 = "";
        L47:
            r5.g = UUID.randomUUID();
            FLogger.a.i("EnrollTeamView", "renewAsrTaskUuidForRetry oldTaskId=" + r18 + " newTaskId=" + r5.g + " index=" + r5.f);
            goto L48
        L44:
            r18 = null;
        L48:
            String r19 = r5.U5();
            CoroutineDispatcher r110 = Dispatchers.getIO();
            C00331 r8 = new C00331(this.a, r19, null);
            r0.label = 1;
            if (BuildersKt.withContext(r110, r8, r0) != r2) goto L51;
            return r2;
        L29:
            return Unit.INSTANCE;
        L22:
            r7 = false;
            goto L23
        L25:
            r4 = (T) null;
        L7:
            r0 = new EnrollStageView$observe$2$1$emit$1(this, r11);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((com.obric.audio.enroll.recorder.a) r1, r2);
        }
    }

    public EnrollStageView$observe$2(EnrollStageView r1, Continuation<? super EnrollStageView$observe$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollStageView$observe$2(this.this$0, r3);
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
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r6 = this.this$0.getViewModel().getRecordingEvent();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
