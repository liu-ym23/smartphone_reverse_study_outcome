package com.larus.audioplayer.impl.manager;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.dora.api.IDoraService;
import com.larus.media.MediaResourceManager;
import com.larus.music.i;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.manager.GlobalAudioControllerImpl$asyncDoMediaCommandByDora$1", f = "GlobalAudioControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GlobalAudioControllerImpl$asyncDoMediaCommandByDora$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $command;
    final /* synthetic */ int $controlType;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ GlobalAudioControllerImpl this$0;

    public GlobalAudioControllerImpl$asyncDoMediaCommandByDora$1(String r1, int r2, GlobalAudioControllerImpl r3, int r4, Continuation<? super GlobalAudioControllerImpl$asyncDoMediaCommandByDora$1> r5) {
        this.$scene = r1;
        this.$controlType = r2;
        this.this$0 = r3;
        this.$command = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GlobalAudioControllerImpl$asyncDoMediaCommandByDora$1(this.$scene, this.$controlType, this.this$0, this.$command, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r7);
        final IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 != null) goto L8;
        FLogger.a.e("GlobalAudioControllerImpl", "asyncDoMediaCommandByDora getDoraService fails");
        return Unit.INSTANCE;
    L8:
        i1.c(this.$scene, this.$controlType, "dora");
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L13;
        r1.K0();
        boolean r3 = true;
        if (i.a.h() != true) goto L13;
    L14:
        if (r3 == false) goto L16;
        Lazy r2 = MediaResourceManager.a;
        final GlobalAudioControllerImpl r4 = this.this$0;
        com.larus.media.model.a r5 = r4.f;
        final int r6 = this.$command;
        MediaResourceManager.m(r5, new d(r8, r6, r4), new e(), 0, 8);
    L17:
        FLogger.a.i("GlobalAudioControllerImpl", "asyncMediaCommandByDora: " + this.$command);
        return Unit.INSTANCE;
    L16:
        r8.device().J0(this.$command);
        GlobalAudioControllerImpl.p(this.this$0, this.$command);
    L13:
        r3 = false;
        goto L14
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
