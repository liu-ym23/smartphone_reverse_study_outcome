package com.larus.audioplayer.impl.manager;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.manager.GlobalAudioControllerImpl$doSetSystemVolumeByDora$1", f = "GlobalAudioControllerImpl.kt", i = {0, 0}, l = {403}, m = "invokeSuspend", n = {"doraAbsVolumeSupported", "realLevel"}, s = {"I$0", "I$1"})
final class GlobalAudioControllerImpl$doSetSystemVolumeByDora$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $controlType;
    final /* synthetic */ double $ratio;
    final /* synthetic */ String $scene;
    final /* synthetic */ IDoraService $service;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ GlobalAudioControllerImpl this$0;

    public GlobalAudioControllerImpl$doSetSystemVolumeByDora$1(IDoraService r1, GlobalAudioControllerImpl r2, double r3, String r5, int r6, Continuation<? super GlobalAudioControllerImpl$doSetSystemVolumeByDora$1> r7) {
        this.$service = r1;
        this.this$0 = r2;
        this.$ratio = r3;
        this.$scene = r5;
        this.$controlType = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new GlobalAudioControllerImpl$doSetSystemVolumeByDora$1(this.$service, this.this$0, this.$ratio, this.$scene, this.$controlType, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r14);
    L16:
        int r15 = this.$service.device().O0();
        if (r15 != r2) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L22;
        String r4 = null;
    L23:
        String r10 = r4;
        FLogger.a.i("GlobalAudioControllerImpl", "setSystemVolumeByDora with level " + r2 + " and resultLevel " + r15);
        i1.b(this.$scene, this.$controlType, "dora", r9, r10, Boxing.boxInt(r2), Boxing.boxInt(r3));
        return Unit.INSTANCE;
    L22:
        r4 = "unequal_volume";
        goto L23
    L19:
        r9 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        r3 = this.$service.device().N0();
        if (r3 == 1) goto L12;
        FLogger.a.i("GlobalAudioControllerImpl", "asyncDoSetSystemVolumeByDora but not supported:" + r3);
        GlobalAudioControllerImpl r5 = this.this$0;
        double r6 = this.$ratio;
        String r8 = this.$scene;
        int r11 = this.$controlType;
        Integer r12 = Boxing.boxInt(r3);
        int r16 = GlobalAudioControllerImpl.g;
        r5.s(r6, r8, r11, r12);
        return Unit.INSTANCE;
    L12:
        i1.c(this.$scene, this.$controlType, "dora");
        int r17 = (int) ((((double) 16) * this.$ratio) + ((double) 0));
        this.$service.device().K0(r17);
        FLogger.a.i("GlobalAudioControllerImpl", "setSystemVolumeByDora with level " + r17);
        this.I$0 = r3;
        this.I$1 = r17;
        this.label = 1;
        if (DelayKt.delay(1500, this) != r0) goto L15;
        return r0;
    L15:
        r2 = r17;
        goto L16
    }
}
