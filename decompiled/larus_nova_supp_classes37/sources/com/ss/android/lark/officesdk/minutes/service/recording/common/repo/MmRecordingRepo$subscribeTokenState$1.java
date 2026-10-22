package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.y;
import iub.k;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1", f = "MmRecordingRepo.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeTokenState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingRepo a;

        public AnonymousClass1(MmRecordingRepo r1) {
            this.a = r1;
        }

        public final Object a(Result<MmCreateAudioResponse> r22, Continuation<? super Unit> r23) {
            if ((r23 instanceof MmRecordingRepo$subscribeTokenState$1$1$emit$1) == false) goto L7;
            MmRecordingRepo$subscribeTokenState$1$1$emit$1 r2 = (MmRecordingRepo$subscribeTokenState$1$1$emit$1) r23;
            int r3 = r2.label;
            if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
            r2.label = r3 - Integer.MIN_VALUE;
        L8:
            Object r1 = r2.result;
            Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = r2.label;
            if (r5 == 0) goto L14;
            if (r5 != 1) goto L13;
            MmCreateAudioResponse r6 = (MmCreateAudioResponse) r2.L$2;
            MmRecordingRepo r7 = (MmRecordingRepo) r2.L$1;
            Object r8 = r2.L$0;
            ResultKt.throwOnFailure(r1);
        L26:
            lvb.a.e(r7.c, "[onMinutesTokenReady] meetingId=" + r6.getMeetingId() + ", finalAudioType=" + r6.getFinalAudioType() + ", topicLength=" + r6.getTopic().length());
            r7.t = MmRecordingCommonParam.copy$default(r7.t, y.b(r6.getObjectToken()), null, false, null, r7.a.w.a, null, null, null, null, null, null, 2030, null);
            r7.b.N().k(r7.a, r7.t);
            MmRecordingSession r9 = r7.a;
            k r10 = r9.f;
            if (r10 == null) goto L29;
            MmRecordingSource r11 = r10.a;
        L31:
            if (r11 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L33;
            BuildersKt.launch$default(r9.u, null, null, new MmRecordingRepo$onMinutesTokenReady$1(r7, r6, null), 3, null);
        L33:
            r7.w().l().e(r6);
            r7.s().m().e(r6);
            MmRecordingLocationRepo r12 = r7.v();
            if (r12 == null) goto L38;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r13 = r12.m();
            if (r13 == null) goto L38;
            r13.E(r6.getObjectToken());
        L38:
            r7.i().l().L(r6.getObjectToken());
            r7.a.b.A().C(r7.a.e(), r6.getMeetingId(), r6.getObjectToken());
            Object r14 = r8;
        L39:
            Result.box-impl(r14);
        L41:
            return Unit.INSTANCE;
        L29:
            r11 = null;
            goto L31
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r1);
            if (r22 == null) goto L41;
            r14 = r22.unbox-impl();
            r7 = this.a;
            if (Result.isSuccess-impl(r14) == false) goto L39;
            MmCreateAudioResponse r15 = (MmCreateAudioResponse) r14;
            if (Intrinsics.areEqual(r7.w, r15.getObjectToken()) == false) goto L22;
            lvb.a.b(r7.c, "[subscribeTokenState] skip same token: " + r7.w);
            return Unit.INSTANCE;
        L22:
            String r16 = r15.getObjectToken();
            Intrinsics.checkNotNullParameter(r16, "<set-?>");
            r7.w = r16;
            MmRecordingSession r17 = r7.a;
            MmRecordingRepo$subscribeTokenState$1$1$1$1 r18 = new MmRecordingRepo$subscribeTokenState$1$1$1$1(r15, null);
            r2.L$0 = r14;
            r2.L$1 = r7;
            r2.L$2 = r15;
            r2.label = 1;
            if (r17.s(r18, r2) != r4) goto L25;
            return r4;
        L25:
            r8 = r14;
            r6 = r15;
        L7:
            r2 = new MmRecordingRepo$subscribeTokenState$1$1$emit$1(this, r23);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((Result) r1, r2);
        }
    }

    public MmRecordingRepo$subscribeTokenState$1(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeTokenState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingRepo$subscribeTokenState$1(this.this$0, r3);
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
        b1 r6 = this.this$0.a.i().o;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
