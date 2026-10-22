package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.l;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionSubtitle$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1802}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSessionManager$listenSessionSubtitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSession a;
        public final /* synthetic */ MmRecordingSessionManager b;

        public a(MmRecordingSession r1, MmRecordingSessionManager r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r4, Continuation r5) {
            d r6 = (d) r4;
            if ((!r6.a.isEmpty()) == false) goto L10;
            MmRecordingSession r7 = this.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.b r1 = r7.q;
            String r8 = r7.e();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r8, "recordingId");
            if (StringsKt.isBlank(r8) == true) goto L10;
            if (r1.d == true) goto L10;
            r1.d = true;
            r1.a.tryEmit(new l.a(r8));
        L10:
            this.b.t.setValue(TuplesKt.to(this.a.e(), r6));
            Unit r9 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r9;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingSessionType.values().length];
            r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public MmRecordingSessionManager$listenSessionSubtitle$1(MmRecordingSession r1, MmRecordingSessionManager r2, Continuation<? super MmRecordingSessionManager$listenSessionSubtitle$1> r3) {
        this.$session = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSessionManager$listenSessionSubtitle$1(this.$session, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L29:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        RecordingSessionType r7 = this.$session.a;
        i1<d> r2 = null;
        if (b.a[r7.ordinal()] != 1) goto L17;
        MmStandaloneAIInterpretationRootRepo r8 = this.$session.h();
        if (r8 == null) goto L24;
        MmRecordingSubtitleRepo r9 = r8.b();
        if (r9 == null) goto L24;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r10 = r9.l();
        if (r10 == null) goto L24;
        r2 = r10.b();
    L24:
        if (r2 == null) goto L31;
        a r11 = new a(this.$session, this.this$0);
        this.label = 1;
        if (r2.collect(r11, this) != r0) goto L29;
        return r0;
    L31:
        return Unit.INSTANCE;
    L17:
        MmRecordingRepo r12 = this.$session.f();
        if (r12 == null) goto L24;
        MmRecordingSubtitleRepo r13 = r12.x();
        if (r13 == null) goto L24;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r14 = r13.l();
        if (r14 == null) goto L24;
        r2 = r14.b();
        goto L24
    }
}
