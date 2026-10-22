package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1$initAudioSaveState$3", f = "MmRecordingAudioSaveRepo.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAudioSaveRepo$opt$2$1$initAudioSaveState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ MmRecordingAudioSaveRepo this$0;
    final /* synthetic */ MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingAudioSaveRepo$opt$2$1$initAudioSaveState$3(MmRecordingAudioSaveRepo r1, String r2, MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmRecordingAudioSaveRepo$opt$2$1$initAudioSaveState$3> r4) {
        this.this$0 = r1;
        this.$scene = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingAudioSaveRepo$opt$2$1$initAudioSaveState$3(this.this$0, this.$scene, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
        Object r12 = ((Result) r11).unbox-impl();
    L11:
        MmRecordingAudioSaveRepo r3 = this.this$0;
        String r4 = this.$scene;
        MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r5 = this.this$1;
        if (Result.isSuccess-impl(r12) == false) goto L28;
        kvb.a r6 = (kvb.a) r12;
        if (r6 == null) goto L18;
        String[] r7 = r6.a();
        if (r7 == null) goto L18;
        int r8 = r7.length;
    L19:
        lvb.a.e(r3.l, "[" + r4 + "] getUserGuide success, guideCount=" + r8);
        if (r6 == null) goto L26;
        String[] r9 = r6.a();
        if (r9 == null) goto L26;
        if (ArraysKt.contains(r9, "MM_AUDIO_RETENTION_ONBOARDING") != true) goto L26;
    L27:
        r3.j(new MmRecordingAudioSaveRepo$opt$2$1$initAudioSaveState$3$1$1(r3, r5, r2, null));
    L26:
        r2 = false;
    L18:
        r8 = 0;
    L28:
        MmRecordingAudioSaveRepo r10 = this.this$0;
        String r13 = this.$scene;
        Throwable r14 = Result.exceptionOrNull-impl(r12);
        if (r14 == null) goto L32;
        lvb.a.b(r10.l, "[" + r13 + "] getUserGuide failed: " + r14);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MmRecordingNetHelper r15 = this.this$0.j.G();
        MmRecordingSource r16 = this.this$0.k;
        this.label = 1;
        r12 = r15.q(r16, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
