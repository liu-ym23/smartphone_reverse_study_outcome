package com.larus.audio;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import d78.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.RtcEngineInitManager$updateAudioLaunchDataFromLaunch$1", f = "RtcEngineInitManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RtcEngineInitManager$updateAudioLaunchDataFromLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $launchData;
    int label;
    final /* synthetic */ RtcEngineInitManager this$0;

    public RtcEngineInitManager$updateAudioLaunchDataFromLaunch$1(RtcEngineInitManager r1, d r2, Continuation<? super RtcEngineInitManager$updateAudioLaunchDataFromLaunch$1> r3) {
        this.this$0 = r1;
        this.$launchData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RtcEngineInitManager$updateAudioLaunchDataFromLaunch$1(this.this$0, this.$launchData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        RtcEngineInitManager r4 = this.this$0;
        d r0 = this.$launchData;
        int r1 = RtcEngineInitManager.h;
        r4.k(r0, "call_launch_success");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
