package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$updateSubtitleOpenResult$2", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {840}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$updateSubtitleOpenResult$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isOn;
    final /* synthetic */ SubtitleOpenResult $result;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSubtitleRepo this$1;

    public MmRecordingSubtitleRepo$opt$2$1$updateSubtitleOpenResult$2(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, MmRecordingSubtitleRepo r2, boolean r3, SubtitleOpenResult r4, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$updateSubtitleOpenResult$2> r5) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$isOn = r3;
        this.$result = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new MmRecordingSubtitleRepo$opt$2$1$updateSubtitleOpenResult$2(this.this$0, this.this$1, this.$isOn, this.$result, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
    L38:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        d r3 = (d) this.this$0.m();
        iub.k r4 = this.this$1.j.f;
        if (r4 == null) goto L11;
        MmRecordingSource r5 = r4.a;
    L12:
        MmRecordingSource r14 = r5;
        boolean r6 = this.$isOn;
        SubtitleOpenResult r7 = this.$result;
        Intrinsics.checkNotNullParameter(r3, "currentEntity");
        Intrinsics.checkNotNullParameter(r7, "result");
        boolean r8 = g.b(r14);
        SubtitleOpenResult r11 = SubtitleOpenResult.SUCCESS;
        if (r7 != r11) goto L15;
        Boolean r9 = Boolean.valueOf(r6);
    L16:
        Boolean r12 = r9;
        if (r7 != r11) goto L20;
    L25:
        boolean r15 = false;
    L27:
        if (r7 != r11) goto L30;
        boolean r16 = false;
    L34:
        d r10 = d.a(r3, null, 0, false, r12, false, r15, r16, 23);
        lvb.a.e(this.this$1.m, "[subtitleOpenResult] source=" + r14 + ", isOn=" + this.$isOn + ", result=" + this.$result + ", before(on=" + r3.d + ", failed=" + r3.f + ", degraded=" + r3.g + "), after(on=" + r10.d + ", failed=" + r10.f + ", degraded=" + r10.g + ')');
        MmRecordingSubtitleRepo r13 = this.this$1;
        this.label = 1;
        if (r13.b(r10, this) != r1) goto L38;
        return r1;
    L30:
        if (r7 != SubtitleOpenResult.DEGRADED) goto L33;
        if (r8 == false) goto L33;
        r16 = true;
    L33:
        r16 = r3.g;
        goto L34
    L20:
        if (r7 != SubtitleOpenResult.DEGRADED) goto L24;
        if (r8 == true) goto L25;
    L24:
        if (r3.g == true) goto L25;
        r15 = true;
        goto L27
    L15:
        r9 = r3.d;
        goto L16
    L11:
        r5 = null;
        goto L12
    }
}
