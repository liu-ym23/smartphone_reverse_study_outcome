package com.larus.bmhome.chat.component.audio;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.audio.VolumeComponent$volumeListener$2$1$onVolumeChanged$1", f = "VolumeComponent.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class VolumeComponent$volumeListener$2$1$onVolumeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $readMessage;
    int label;

    public VolumeComponent$volumeListener$2$1$onVolumeChanged$1(Message r1, Continuation<? super VolumeComponent$volumeListener$2$1$onVolumeChanged$1> r2) {
        this.$readMessage = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VolumeComponent$volumeListener$2$1$onVolumeChanged$1(this.$readMessage, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("VolumeComponent", "[TTS] onVolumeChanged trigger auto read msg");
        RepoDispatcher.a.getClass();
        x1 r3 = RepoDispatcher.d.d.d;
        Message r4 = this.$readMessage;
        TtsScene r9 = TtsScene.Auto_Other;
        this.label = 1;
        if (x1$b.b(r3, r4, null, true, "volume_up", null, r9, this, 50) != r0) goto L12;
        return r0;
    }
}
