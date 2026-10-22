package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$mobStartRequest$1", f = "AudioStreamPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioStreamPlayer$mobStartRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAutoRetry;
    final /* synthetic */ int $loopIndex;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $seqNo;
    final /* synthetic */ String $url;
    int label;

    public AudioStreamPlayer$mobStartRequest$1(int r1, String r2, String r3, int r4, boolean r5, Continuation<? super AudioStreamPlayer$mobStartRequest$1> r6) {
        this.$seqNo = r1;
        this.$resourceId = r2;
        this.$url = r3;
        this.$loopIndex = r4;
        this.$isAutoRetry = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AudioStreamPlayer$mobStartRequest$1(this.$seqNo, this.$resourceId, this.$url, this.$loopIndex, this.$isAutoRetry, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r9);
        int r10 = this.$seqNo;
        String r0 = this.$resourceId;
        String r1 = this.$url;
        int r2 = this.$loopIndex;
        boolean r3 = this.$isAutoRetry;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r5 = AudioStreamPlayer.l;     // Catch: Throwable -> L14
        if (r5 != null) goto L8;
        r5 = new JSONObject();     // Catch: Throwable -> L14
    L8:
        JSONObject r6 = new JSONObject(r5.toString());     // Catch: Throwable -> L14
        com.larus.platform.service.o r7 = com.larus.platform.service.o.a;     // Catch: Throwable -> L14
        r6.put("podcast_seq_no", r10);     // Catch: Throwable -> L14
        r6.put("podcast_resource_id", r0);     // Catch: Throwable -> L14
        r6.put("podcast_url", r1);     // Catch: Throwable -> L14
        r6.put("podcast_loop_index", r2);     // Catch: Throwable -> L14
        if (r3 == false) goto L11;
        boolean r8 = true;
    L12:
        r6.put("is_auto_retry", r8);     // Catch: Throwable -> L14
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r7.reportEvent("deep_research_podcast_start_request", r6);     // Catch: Throwable -> L14
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L21;
        FLogger.a.e("AudioStreamPlayer", "mobReceiveFirstChunkPkg err=" + r13);
    L21:
        return Unit.INSTANCE;
    L11:
        r8 = false;
    L14:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
