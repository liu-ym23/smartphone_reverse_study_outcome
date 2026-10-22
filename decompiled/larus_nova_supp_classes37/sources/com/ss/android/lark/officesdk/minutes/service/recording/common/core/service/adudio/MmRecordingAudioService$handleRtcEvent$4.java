package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import android.widget.Toast;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService$handleRtcEvent$4", f = "MmRecordingAudioService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioService$handleRtcEvent$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nub.d $event;
    int label;
    final /* synthetic */ MmRecordingAudioService this$0;

    public MmRecordingAudioService$handleRtcEvent$4(MmRecordingAudioService r1, nub.d r2, Continuation<? super MmRecordingAudioService$handleRtcEvent$4> r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingAudioService$handleRtcEvent$4(this.this$0, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r8);
        long r0 = System.currentTimeMillis();
        MmRecordingAudioService r9 = this.this$0;
        if ((r0 - r9.o) < 3000) goto L13;
        r9.o = r0;
        lvb.a.b(r9.e, "MicCaptureError");
        MmRecordingAudioService.o(this.this$0, "audio", null, "mic_capture_error", this.$event.getClass().getSimpleName(), 2);
        kub.c r10 = (kub.c) this.this$0.b.u(kub.c.class);
        if (r10 == null) goto L10;
        String r11 = r10.getAppDisplayName();
        if (r11 == null) goto L10;
    L11:
        Toast.makeText(UIHelper.getContext(), UIHelper.mustacheFormat(2131892865, "APP_DISPLAY_NAME", r11), 0).show();
    L10:
        r11 = "";
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
