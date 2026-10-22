package com.larus.voicecall.impl.subtitle;

import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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
@DebugMetadata(c = "com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleViewModel$1$1", f = "RealtimeCallSubtitleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSubtitleViewModel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.voicecall.impl.scene.m $scene;
    int label;
    final /* synthetic */ q0 this$0;

    public RealtimeCallSubtitleViewModel$1$1(com.larus.voicecall.impl.scene.m r1, q0 r2, Continuation<? super RealtimeCallSubtitleViewModel$1$1> r3) {
        this.$scene = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallSubtitleViewModel$1$1(this.$scene, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r13);
        com.larus.voicecall.impl.scene.m r14 = this.$scene;
        Integer r0 = null;
        if (r14 == null) goto L9;
        SceneModel r15 = r14.a;
        if (r15 == null) goto L9;
        Integer r16 = Boxing.boxInt(r15.getId());
    L11:
        if (Intrinsics.areEqual(r16, this.this$0.j) == true) goto L19;
        FLogger.a.i("RealtimeCallSubtitleViewModel", "scene mode change");
        this.this$0.p("init");
        q0.s(this.this$0, SubtitleListUpdateType.SCENE_MODE_CHANGE, null, null, null, null, null, null, null, 254);
        q0 r17 = this.this$0;
        com.larus.voicecall.impl.scene.m r1 = this.$scene;
        if (r1 == null) goto L17;
        SceneModel r2 = r1.a;
        if (r2 == null) goto L17;
        r0 = Boxing.boxInt(r2.getId());
    L17:
        r17.j = r0;
    L19:
        return Unit.INSTANCE;
    L9:
        r16 = null;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
