package com.obric.assistant.automic;

import android.os.Parcelable;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.session.AiIslandVoiceInteractionSession;
import com.obric.assistant.voice.ContentScene;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.automic.ObricAutoMicServiceImpl$tryTurnOnMic$1", f = "ObricAutoMicServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoMicServiceImpl$tryTurnOnMic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Parcelable $args;
    final /* synthetic */ boolean $autoTime;
    final /* synthetic */ ContentScene $scene;
    int label;
    final /* synthetic */ ObricAutoMicServiceImpl this$0;

    public ObricAutoMicServiceImpl$tryTurnOnMic$1(ObricAutoMicServiceImpl r1, ContentScene r2, Parcelable r3, boolean r4, Continuation<? super ObricAutoMicServiceImpl$tryTurnOnMic$1> r5) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$args = r3;
        this.$autoTime = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricAutoMicServiceImpl$tryTurnOnMic$1(this.this$0, this.$scene, this.$args, this.$autoTime, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r6);
        ObricAutoMicServiceImpl r7 = this.this$0;
        int r0 = ObricAutoMicServiceImpl.i;
        r7.getClass();
        AiIslandVoiceInteractionSession r8 = ObricAutoMicServiceImpl.p();
        if (r8 == null) goto L8;
        Boxing.boxBoolean(r8.k(this.$scene, this.$args));
    L8:
        if (this.$autoTime == false) goto L14;
        ObricAutoMicServiceImpl r9 = this.this$0;
        ContentScene r1 = this.$scene;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "scene");
        FLogger.a.i("ObricAutoMicServiceImpl", "startCountDownTimer..." + r9.b);
        PthreadTimer r2 = r9.b;
        if (r2 == null) goto L12;
        r2.cancel();
    L12:
        PthreadTimer r3 = new PthreadTimer("ObricAutoMicServiceImpl");
        r3.schedule(new e(r9, r1), 15000);
        r9.b = r3;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
