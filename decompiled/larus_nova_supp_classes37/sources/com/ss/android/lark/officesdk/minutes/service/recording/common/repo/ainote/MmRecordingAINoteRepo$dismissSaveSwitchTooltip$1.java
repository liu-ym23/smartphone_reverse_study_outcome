package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo$dismissSaveSwitchTooltip$1", f = "MmRecordingAINoteRepo.kt", i = {}, l = {1097, 1115}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAINoteRepo$dismissSaveSwitchTooltip$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $markConsumed;
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$dismissSaveSwitchTooltip$1(MmRecordingAINoteRepo r1, boolean r2, String r3, Continuation<? super MmRecordingAINoteRepo$dismissSaveSwitchTooltip$1> r4) {
        this.this$0 = r1;
        this.$markConsumed = r2;
        this.$reason = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingAINoteRepo$dismissSaveSwitchTooltip$1(this.this$0, this.$markConsumed, this.$reason, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r25);
    L41:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r25);
    L31:
        if (this.$markConsumed == false) goto L37;
        MmRecordingAINoteRepo r3 = this.this$0;
        String r4 = this.$reason;
        iub.k r5 = r3.j.f;
        if (r5 == null) goto L35;
        MmRecordingSource r6 = r5.a;
    L36:
        BuildersKt.launch$default(r3.f(), null, null, new MmRecordingAINoteRepo$completeSaveSwitchTooltipGuide$1(r3, r6, r4, null), 3, null);
        goto L37
    L35:
        r6 = null;
    L37:
        lvb.a.e(this.this$0.w, "[dismissSaveSwitchTooltip] markConsumed=" + this.$markConsumed + " reason=" + this.$reason + ' ' + this.this$0.r());
        MmRecordingAINoteRepo r7 = this.this$0;
        j.b r8 = j.b.a;
        this.label = 2;
        if (r7.k(r8, this) != r1) goto L41;
        return r1;
    L10:
        ResultKt.throwOnFailure(r25);
        c r9 = this.this$0.h();
        if (r9.l == false) goto L13;
    L16:
        MmRecordingAINoteRepo r10 = this.this$0;
        if (r9.k == false) goto L19;
    L22:
        boolean r17 = true;
    L24:
        if (this.$markConsumed == false) goto L26;
        boolean r16 = false;
    L27:
        c r11 = c.a(r9, false, 0, null, false, false, false, false, false, false, r16, r17, false, false, false, false, false, 61951);
        this.label = 1;
        if (r10.b(r11, this) != r1) goto L31;
        return r1;
    L26:
        r16 = r9.j;
        goto L27
    L19:
        if (this.$markConsumed == true) goto L22;
        r17 = false;
        goto L24
    L13:
        if (this.$markConsumed == true) goto L16;
        return Unit.INSTANCE;
    }
}
