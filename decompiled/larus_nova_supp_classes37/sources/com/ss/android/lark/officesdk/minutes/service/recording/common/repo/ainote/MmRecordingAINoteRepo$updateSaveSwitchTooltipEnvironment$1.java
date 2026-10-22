package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo$updateSaveSwitchTooltipEnvironment$1", f = "MmRecordingAINoteRepo.kt", i = {}, l = {1064, 1065}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteRepo$updateSaveSwitchTooltipEnvironment$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean $editorFocused;
    final /* synthetic */ Boolean $keyboardVisible;
    final /* synthetic */ Boolean $panelExpanded;
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$updateSaveSwitchTooltipEnvironment$1(MmRecordingAINoteRepo r1, Boolean r2, Boolean r3, Boolean r4, String r5, Continuation<? super MmRecordingAINoteRepo$updateSaveSwitchTooltipEnvironment$1> r6) {
        this.this$0 = r1;
        this.$panelExpanded = r2;
        this.$editorFocused = r3;
        this.$keyboardVisible = r4;
        this.$reason = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmRecordingAINoteRepo$updateSaveSwitchTooltipEnvironment$1(this.this$0, this.$panelExpanded, this.$editorFocused, this.$keyboardVisible, this.$reason, r9);
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
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r25);
    L25:
        MmRecordingAINoteRepo r3 = this.this$0;
        String r4 = this.$reason;
        this.label = 2;
        int r5 = MmRecordingAINoteRepo.z;
        if (r3.A(r4, this) != r1) goto L29;
        return r1;
    L10:
        ResultKt.throwOnFailure(r25);
        c r6 = this.this$0.h();
        Boolean r7 = this.$panelExpanded;
        if (r7 == null) goto L13;
        boolean r8 = r7.booleanValue();
    L14:
        boolean r20 = r8;
        Boolean r9 = this.$editorFocused;
        if (r9 == null) goto L17;
        boolean r10 = r9.booleanValue();
    L18:
        boolean r21 = r10;
        Boolean r11 = this.$keyboardVisible;
        if (r11 == null) goto L21;
        boolean r12 = r11.booleanValue();
    L22:
        c r13 = c.a(r6, false, 0, null, false, false, false, false, false, false, false, false, false, false, r20, r21, r12, 8191);
        MmRecordingAINoteRepo r14 = this.this$0;
        this.label = 1;
        if (r14.b(r13, this) != r1) goto L25;
        return r1;
    L21:
        r12 = r6.p;
        goto L22
    L17:
        r10 = r6.o;
        goto L18
    L13:
        r8 = r6.n;
        goto L14
    }
}
