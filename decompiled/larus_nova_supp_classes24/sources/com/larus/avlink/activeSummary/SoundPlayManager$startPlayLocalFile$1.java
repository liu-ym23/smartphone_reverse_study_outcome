package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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
@DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$startPlayLocalFile$1", f = "SoundPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SoundPlayManager$startPlayLocalFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ boolean $ignoreDoraCall;
    final /* synthetic */ SoundPlayManager.b $listener;
    int label;
    final /* synthetic */ SoundPlayManager this$0;

    public SoundPlayManager$startPlayLocalFile$1(SoundPlayManager r1, String r2, SoundPlayManager.b r3, boolean r4, Continuation<? super SoundPlayManager$startPlayLocalFile$1> r5) {
        this.this$0 = r1;
        this.$filePath = r2;
        this.$listener = r3;
        this.$ignoreDoraCall = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SoundPlayManager$startPlayLocalFile$1(this.this$0, this.$filePath, this.$listener, this.$ignoreDoraCall, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        SoundPlayManager r6 = this.this$0;
        String r0 = this.$filePath;
        SoundPlayManager.b r1 = this.$listener;
        boolean r2 = this.$ignoreDoraCall;
        int r3 = SoundPlayManager.f;
        r6.c(r0, r1, r2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
