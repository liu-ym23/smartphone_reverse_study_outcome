package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.picker.base.view.ItemViewType;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$putOfflineRecordingAudioPath$1", f = "MmRecordingStatesSyncService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingStatesSyncService$putOfflineRecordingAudioPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $audioFilePath;
    final /* synthetic */ String $sessionKey;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$putOfflineRecordingAudioPath$1(MmRecordingStatesSyncService r1, String r2, String r3, Continuation<? super MmRecordingStatesSyncService$putOfflineRecordingAudioPath$1> r4) {
        this.this$0 = r1;
        this.$sessionKey = r2;
        this.$audioFilePath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingStatesSyncService$putOfflineRecordingAudioPath$1(this.this$0, this.$sessionKey, this.$audioFilePath, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r7);
        MmRecordingStatesSyncService r8 = this.this$0;
        MmRecordingStatesSyncService.Companion r0 = MmRecordingStatesSyncService.q;
        e r9 = r8.l();
        String r1 = this.$sessionKey;
        String r2 = this.$audioFilePath;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionKey");
        if (StringsKt.isBlank(r1) == true) goto L22;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L22;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        r9.a.H().putString("minutes_recording_v2_offline_audio_path_" + r1, r2);     // Catch: Throwable -> L16
        lvb.a.e(r9.b, "[offlineAudioPath] put, sessionKey:" + r1 + ", path:" + r2);     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L22;
        lvb.a.b(r9.b, "[offlineAudioPath] put failed, sessionKey:" + r1 + ", err=" + r6.getMessage());
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L8:
        if (StringsKt.isBlank(r2) == true) goto L11;
        r4 = false;
    L22:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
