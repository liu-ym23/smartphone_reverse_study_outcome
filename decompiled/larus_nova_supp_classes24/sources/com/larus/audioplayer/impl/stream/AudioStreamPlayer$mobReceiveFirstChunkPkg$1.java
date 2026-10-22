package com.larus.audioplayer.impl.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.larus.audioplayer.impl.stream.AudioStreamPlayer$mobReceiveFirstChunkPkg$1", f = "AudioStreamPlayer.kt", i = {0}, l = {1436}, m = "invokeSuspend", n = {"tartJson"}, s = {"L$0"})
final class AudioStreamPlayer$mobReceiveFirstChunkPkg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public AudioStreamPlayer$mobReceiveFirstChunkPkg$1(Continuation<? super AudioStreamPlayer$mobReceiveFirstChunkPkg$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AudioStreamPlayer$mobReceiveFirstChunkPkg$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        JSONObject r2 = (JSONObject) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L26
    L22:
        String r7 = (String) r6;     // Catch: Throwable -> L26
        JSONObject r3 = r2;
    L24:
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;     // Catch: Throwable -> L26
        r3.put("chat_type", r7);     // Catch: Throwable -> L26
        r3.put("podcast_generation_source", "deep_research");     // Catch: Throwable -> L26
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r4.reportEvent("podcast_stream_receive_first_package", r3);     // Catch: Throwable -> L26
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L33;
        FLogger.a.e("AudioStreamPlayer", "mobReceiveFirstChunkPkg err=" + r10);
    L33:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L26
        JSONObject r12 = AudioStreamPlayer.l;     // Catch: Throwable -> L26
        if (r12 != null) goto L14;
        r12 = new JSONObject();     // Catch: Throwable -> L26
    L14:
        r3 = new JSONObject(r12.toString());     // Catch: Throwable -> L26
        AudioStreamPlayer r13 = AudioStreamPlayer.a;     // Catch: Throwable -> L26
        String r14 = AudioStreamPlayer.m(r3, "conversation_id");     // Catch: Throwable -> L26
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L26
        if (r5 == null) goto L23;
        r5.P();     // Catch: Throwable -> L26
        ChatServiceImpl r15 = ChatServiceImpl.a;
        this.L$0 = r3;     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        r6 = r15.g(r14, this);     // Catch: Throwable -> L26
        if (r6 != r0) goto L21;
        return r0;
    L21:
        r2 = r3;
        goto L22
    L23:
        r7 = null;
    L26:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
