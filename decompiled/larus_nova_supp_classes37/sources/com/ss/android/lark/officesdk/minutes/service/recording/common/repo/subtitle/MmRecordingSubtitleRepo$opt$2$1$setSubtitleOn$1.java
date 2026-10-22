package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1", f = "MmRecordingSubtitleRepo.kt", i = {0, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6}, l = {548, 564, 565, 569, 570, 577, 578, 587, 590}, m = "invokeSuspend", n = {"startTs", "startTs", "startTs", "response", "startTs", "cost", "response", "startTs", "cost", "response", "startTs", "cost", "response", "startTs", "cost"}, s = {"J$0", "J$0", "J$0", "L$3", "J$0", "J$1", "L$2", "J$0", "J$1", "L$3", "J$0", "J$1", "L$2", "J$0", "J$1"})
final class MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isOn;
    final /* synthetic */ String $meetingId;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSubtitleRepo this$1;

    public MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, boolean r2, MmRecordingSubtitleRepo r3, String r4, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1> r5) {
        this.this$0 = r1;
        this.$isOn = r2;
        this.this$1 = r3;
        this.$meetingId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1(this.this$0, this.$isOn, this.this$1, this.$meetingId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r23);
    L90:
        return Unit.INSTANCE;
    L7:
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2 = (MmRecordingSubtitleRepo$opt$2.AnonymousClass1) this.L$1;
        Object r3 = this.L$0;
        ResultKt.throwOnFailure(r23);
    L86:
        this.L$0 = r3;
        this.L$1 = null;
        this.label = 9;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r2, true, this) != r1) goto L90;
        return r1;
    L8:
        long r5 = this.J$1;
        long r9 = this.J$0;
        UpdateLiveRecordingSettingResponse r4 = (UpdateLiveRecordingSettingResponse) this.L$2;
        MmRecordingSubtitleRepo r11 = (MmRecordingSubtitleRepo) this.L$1;
        Object r12 = this.L$0;
        ResultKt.throwOnFailure(r23);
        String r17 = "[setSubtitleOn] failed, cost=";
        String r7 = " ms, status=";
    L78:
        qvb.a.a.h("status:" + r4.mstatus);
        String r8 = r17;
        lvb.a.b(r11.m, r8 + r5 + r7 + r4.mstatus + ", failToast: " + r4.mfail_toast_i18n_key);
        Object r6 = r12;
    L80:
        r3 = r6;
        MmRecordingSubtitleRepo r10 = this.this$1;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r13 = this.this$0;
        Throwable r14 = Result.exceptionOrNull-impl(r3);
        if (r14 == null) goto L90;
        long r15 = System.currentTimeMillis() - r9;
        lvb.a.b(r10.m, r8 + r15 + " ms, error=" + r14);
        qvb.a.a.h(String.valueOf(r14.getMessage()));
        MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1$2$1 r16 = new MmRecordingSubtitleRepo$opt$2$1$setSubtitleOn$1$2$1(r10, r13, null);
        this.L$0 = r3;
        this.L$1 = r13;
        this.L$2 = null;
        this.label = 8;
        if (r10.e.b(r16, this) != r1) goto L85;
        return r1;
    L85:
        r2 = r13;
        goto L86
    L9:
        r5 = this.J$1;
        r9 = this.J$0;
        r4 = (UpdateLiveRecordingSettingResponse) this.L$3;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r18 = (MmRecordingSubtitleRepo$opt$2.AnonymousClass1) this.L$2;
        MmRecordingSubtitleRepo r19 = (MmRecordingSubtitleRepo) this.L$1;
        Object r110 = this.L$0;
        ResultKt.throwOnFailure(r23);
        r17 = "[setSubtitleOn] failed, cost=";
        r7 = " ms, status=";
    L74:
        this.L$0 = r110;
        this.L$1 = r19;
        this.L$2 = r4;
        this.L$3 = null;
        this.J$0 = r9;
        this.J$1 = r5;
        this.label = 7;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r18, true, this) != r1) goto L77;
        return r1;
    L77:
        r11 = r19;
        r12 = r110;
        goto L78
    L10:
        long r20 = this.J$1;
        r9 = this.J$0;
        UpdateLiveRecordingSettingResponse r21 = (UpdateLiveRecordingSettingResponse) this.L$2;
        MmRecordingSubtitleRepo r111 = (MmRecordingSubtitleRepo) this.L$1;
        Object r112 = this.L$0;
        ResultKt.throwOnFailure(r23);
        r17 = "[setSubtitleOn] failed, cost=";
        String r113 = " ms, status=";
    L69:
        lvb.a.e(r111.m, "[setSubtitleOn] degraded, cost=" + r20 + r113 + r21.mstatus);
        r6 = r112;
    L41:
        r8 = r17;
        goto L80
    L11:
        long r22 = this.J$1;
        long r114 = this.J$0;
        r21 = (UpdateLiveRecordingSettingResponse) this.L$3;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r24 = (MmRecordingSubtitleRepo$opt$2.AnonymousClass1) this.L$2;
        MmRecordingSubtitleRepo r115 = (MmRecordingSubtitleRepo) this.L$1;
        Object r116 = this.L$0;
        ResultKt.throwOnFailure(r23);
        r17 = "[setSubtitleOn] failed, cost=";
        r113 = " ms, status=";
    L65:
        this.L$0 = r116;
        this.L$1 = r115;
        this.L$2 = r21;
        this.L$3 = null;
        this.J$0 = r114;
        this.J$1 = r22;
        this.label = 5;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r24, false, this) != r1) goto L68;
        return r1;
    L68:
        r20 = r22;
        r9 = r114;
        r111 = r115;
        r112 = r116;
        goto L69
    L12:
        long r25 = this.J$0;
        r6 = this.L$0;
        ResultKt.throwOnFailure(r23);
        r17 = "[setSubtitleOn] failed, cost=";
    L52:
        r9 = r25;
        goto L41
    L13:
        r9 = this.J$0;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r26 = (MmRecordingSubtitleRepo$opt$2.AnonymousClass1) this.L$1;
        Object r27 = this.L$0;
        ResultKt.throwOnFailure(r23);
        r17 = "[setSubtitleOn] failed, cost=";
    L48:
        this.L$0 = r27;
        this.L$1 = null;
        this.J$0 = r9;
        this.label = 3;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r26, false, this) != r1) goto L51;
        return r1;
    L51:
        r6 = r27;
        r25 = r9;
        goto L52
    L14:
        r9 = this.J$0;
        ResultKt.throwOnFailure(r23);
        r6 = ((Result) r23).unbox-impl();
    L26:
        MmRecordingSubtitleRepo r117 = this.this$1;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r118 = this.this$0;
        boolean r119 = this.$isOn;
        if (Result.isSuccess-impl(r6) == false) goto L79;
        UpdateLiveRecordingSettingResponse r120 = (UpdateLiveRecordingSettingResponse) r6;
        r5 = System.currentTimeMillis() - r9;
        String r121 = r117.m;
        StringBuilder r28 = new StringBuilder("[setSubtitleOn] status: ");
        r28.append(r120.mstatus);
        r28.append(", cost=");
        r28.append(r5);
        r17 = "[setSubtitleOn] failed, cost=";
        r28.append(" ms");
        lvb.a.e(r121, r28.toString());
        UpdateLiveRecordingSettingResponse.Status r29 = r120.mstatus;
        Intrinsics.checkNotNullParameter(r29, "<this>");
        int r30 = g.a.a[r29.ordinal()];
        r113 = " ms, status=";
        if (r30 == 1) goto L38;
        if (r30 != 2) goto L32;
        SubtitleOpenResult r31 = SubtitleOpenResult.FAILURE;
    L39:
        if (r31 != null) goto L43;
        lvb.a.b(r117.m, "[setSubtitleOn] ignored unknown status=" + r120.mstatus + ", cost=" + r5 + " ms");
        goto L41
    L43:
        if (r31 != SubtitleOpenResult.SUCCESS) goto L54;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r32 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.d.d();
        lvb.a.e(r117.m, "[setSubtitleOn] success, cost=" + r5 + " ms");
        this.L$0 = r6;
        this.L$1 = r118;
        this.J$0 = r9;
        this.label = 2;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r118, r119, r31, this) != r1) goto L47;
        return r1;
    L47:
        r27 = r6;
        r26 = r118;
        goto L48
    L54:
        if (r31 != SubtitleOpenResult.DEGRADED) goto L70;
        iub.k r33 = r117.j.f;
        if (r33 == null) goto L58;
        MmRecordingSource r34 = r33.a;
    L60:
        if (g.b(r34) == false) goto L70;
        this.L$0 = r6;
        this.L$1 = r117;
        this.L$2 = r118;
        this.L$3 = r120;
        this.J$0 = r9;
        this.J$1 = r5;
        this.label = 4;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r118, r119, r31, this) != r1) goto L64;
        return r1;
    L64:
        r115 = r117;
        r116 = r6;
        r21 = r120;
        r24 = r118;
        r114 = r9;
        r22 = r5;
        goto L65
    L58:
        r34 = null;
    L70:
        r7 = r113;
        this.L$0 = r6;
        this.L$1 = r117;
        this.L$2 = r118;
        this.L$3 = r120;
        this.J$0 = r9;
        this.J$1 = r5;
        this.label = 6;
        if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r118, r119, r31, this) != r1) goto L73;
        return r1;
    L73:
        r110 = r6;
        r4 = r120;
        r19 = r117;
        r18 = r118;
        goto L74
    L32:
        if (r30 != 3) goto L34;
    L36:
        r31 = SubtitleOpenResult.DEGRADED;
        goto L39
    L34:
        if (r30 == 4) goto L36;
        r31 = SubtitleOpenResult.FAILURE;
        goto L39
    L38:
        r31 = SubtitleOpenResult.SUCCESS;
        goto L39
    L79:
        r8 = "[setSubtitleOn] failed, cost=";
        goto L80
    L15:
        ResultKt.throwOnFailure(r23);
        if (Intrinsics.areEqual(((d) this.this$0.m()).d, Boxing.boxBoolean(this.$isOn)) == false) goto L20;
        lvb.a.e(this.this$1.m, "[setSubtitleOn] no change, isOn=" + this.$isOn);
        return Unit.INSTANCE;
    L20:
        if (StringsKt.isBlank(this.$meetingId) == false) goto L23;
        lvb.a.b(this.this$1.m, "[setSubtitleOn] failed, meetingId is empty");
        return Unit.INSTANCE;
    L23:
        lvb.a.e(this.this$1.m, "[setSubtitleOn] meetingId=" + this.$meetingId + ", isOn=" + this.$isOn);
        r9 = System.currentTimeMillis();
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r35 = this.this$0.e;
        String r122 = this.$meetingId;
        boolean r123 = this.$isOn;
        this.J$0 = r9;
        this.label = 1;
        r6 = r35.b(r122, r123, this);
        if (r6 != r1) goto L26;
        return r1;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
