package com.larus.audioplayer.impl.manager;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.larus.audioplayer.impl.manager.GlobalAudioControllerImpl$asyncDoMediaCommandBySystem$1", f = "GlobalAudioControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GlobalAudioControllerImpl$asyncDoMediaCommandBySystem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $command;
    final /* synthetic */ int $controlType;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ GlobalAudioControllerImpl this$0;

    public GlobalAudioControllerImpl$asyncDoMediaCommandBySystem$1(int r1, String r2, int r3, GlobalAudioControllerImpl r4, Continuation<? super GlobalAudioControllerImpl$asyncDoMediaCommandBySystem$1> r5) {
        this.$command = r1;
        this.$scene = r2;
        this.$controlType = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GlobalAudioControllerImpl$asyncDoMediaCommandBySystem$1(this.$command, this.$scene, this.$controlType, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r8);
        Object r9 = AppHost.a.getApplication().getSystemService("audio");
        if ((r9 instanceof AudioManager) == false) goto L7;
        final AudioManager r10 = (AudioManager) r9;
    L8:
        if (r10 == null) goto L34;
        int r0 = this.$command;
        String r1 = this.$scene;
        int r2 = this.$controlType;
        GlobalAudioControllerImpl r3 = this.this$0;
        if (r0 != 2) goto L12;
        final int r4 = 126;
    L23:
        i1.c(r1, r2, "system");
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L28;
        r5.K0();
        if (i.a.h() != true) goto L28;
        boolean r6 = true;
    L29:
        if (r6 == false) goto L31;
        Lazy r7 = MediaResourceManager.a;
        MediaResourceManager.m(r3.f, new f(r4, r10), new g(), 0, 8);
    L32:
        FLogger.a.i("GlobalAudioControllerImpl", "asyncMediaCommandBySystem: " + r0);
        goto L34
    L31:
        KeyEvent r11 = new KeyEvent(0, r4);
        KeyEvent r12 = new KeyEvent(1, r4);
        r10.dispatchMediaKeyEvent(r11);
        r10.dispatchMediaKeyEvent(r12);
    L28:
        r6 = false;
        goto L29
    L12:
        if (r0 != 3) goto L14;
        r4 = 127;
        goto L23
    L14:
        if (r0 != 4) goto L16;
        r4 = 88;
        goto L23
    L16:
        if (r0 == 5) goto L19;
        FLogger.a.e("GlobalAudioControllerImpl", "asyncMediaCommandBySystem wrong command: " + r0);
        return Unit.INSTANCE;
    L19:
        r4 = 87;
    L34:
        return Unit.INSTANCE;
    L7:
        r10 = null;
        goto L8
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
