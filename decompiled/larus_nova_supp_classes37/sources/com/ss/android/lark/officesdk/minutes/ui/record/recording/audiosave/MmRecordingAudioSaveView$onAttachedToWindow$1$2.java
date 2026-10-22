package com.ss.android.lark.officesdk.minutes.ui.record.recording.audiosave;

import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "audioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.audiosave.MmRecordingAudioSaveView$onAttachedToWindow$1$2", f = "MmRecordingAudioSaveView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAudioSaveView$onAttachedToWindow$1$2 extends SuspendLambda implements Function2<MmAudioSaveType, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAudioSaveView this$0;

    public MmRecordingAudioSaveView$onAttachedToWindow$1$2(MmRecordingAudioSaveView r1, Continuation<? super MmRecordingAudioSaveView$onAttachedToWindow$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingAudioSaveView$onAttachedToWindow$1$2 r0 = new MmRecordingAudioSaveView$onAttachedToWindow$1$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(MmAudioSaveType r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MmAudioSaveType) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r9);
        MmAudioSaveType r10 = (MmAudioSaveType) this.L$0;
        MmRecordingAudioSaveView r0 = this.this$0;
        int r1 = MmRecordingAudioSaveView.i;
        r0.getClass();
        int r2 = b.a;
        int r5 = 8;
        b.g(MmUiLogScene.AUDIO_SAVE, "updateAudioSaveState", "updateAudioSaveState audioSaveType=" + r10, null, 8);
        boolean r3 = r10.isSave();
        View r4 = r0.g;
        boolean r6 = false;
        if (r3 == false) goto L7;
        int r7 = 0;
    L8:
        r4.setVisibility(r7);
        View r8 = r0.h;
        if (r3 == true) goto L11;
        r5 = 0;
    L11:
        r8.setVisibility(r5);
        TextView r11 = r0.e;
        if (r10 != MmAudioSaveType.FORCE_NOT_SAVE) goto L14;
        boolean r12 = true;
    L15:
        int r13 = 2131106610;
        if (r12 == false) goto L18;
        int r14 = 2131106610;
    L19:
        r11.setTextColor(ContextCompat.getColor(r0.getContext(), r14));
        TextView r15 = r0.f;
        if (r10 != MmAudioSaveType.FORCE_SAVE) goto L22;
        r6 = true;
    L22:
        if (r6 == true) goto L25;
        r13 = 2131106622;
    L25:
        r15.setTextColor(ContextCompat.getColor(r0.getContext(), r13));
        return Unit.INSTANCE;
    L18:
        r14 = 2131106622;
        goto L19
    L14:
        r12 = false;
        goto L15
    L7:
        r7 = 8;
        goto L8
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
