package com.obric.assistant.live.receiver;

import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.audio.service.ObricAssistantBaseServiceDelegate;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.live.api.j;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.special_input.IObricSpecialInputService;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ISpecialInputTask$a;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.receiver.ObricLiveReceiver$Companion$1", f = "ObricLiveReceiver.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class ObricLiveReceiver$Companion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r28, Continuation r29) {
            rea.a r0 = (rea.a) r28;
            FLogger r1 = FLogger.a;
            r1.i("ObricLiveReceiver", "receive action " + r0);
            CoroutineScope r2 = ObricLiveReceiver.b;
            r1.i("ObricLiveReceiver", "handleAction() action:" + r0);
            if ((r0 instanceof rea.a.f) == true) goto L59;
            if ((r0 instanceof rea.a.b) == false) goto L11;
            r1.i("ObricLiveReceiver", "close tts");
            ObricLiveServiceDelegate.b.j();
            IAssistantInteractionServiceKt.getInteractionStateService().stopTtsPlay();
            IObricContinuousTalkService r3 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
            if (r3 == null) goto L9;
            r3.b();
        L9:
            ObricAssistantBaseServiceDelegate.b.b();
            goto L59
        L11:
            if ((r0 instanceof rea.a.C0069a) == false) goto L14;
            r1.i("ObricLiveReceiver", "close realtime call");
            IAssistantInteractionServiceKt.getInteractionStateService().endCall();
            goto L59
        L14:
            if ((r0 instanceof rea.a.e) == false) goto L17;
            IAssistantInteractionServiceKt.getInteractionStateService().muteMic();
            goto L59
        L17:
            if ((r0 instanceof rea.a.i) == false) goto L20;
            IAssistantInteractionServiceKt.getInteractionStateService().unMuteMic();
            goto L59
        L20:
            if ((r0 instanceof rea.a.d) == false) goto L40;
            Intent r4 = ((rea.a.d) r0).a;
            r1.i("ObricLiveReceiver", "jump to chat page");
            if (r4.getBooleanExtra("is_complex_task_scene", false) == false) goto L24;
            ObricInteractionScene r5 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        L25:
            ObricFloatChatPageData.a r6 = ObricFloatChatPageData.Companion;
            ObricFloatChatPageState r7 = (ObricFloatChatPageState) waa.a.b.getValue();
            r6.getClass();
            boolean r8 = r7 instanceof vda.d;
            r1.i("ObricLiveReceiver", "isFullScreen " + r8);
            if (r8 == true) goto L33;
            boolean r9 = t1.a.i();
            r1.i("ObricLiveReceiver", "isLockedScreenUseEnabled " + r9);
            if (r9 == false) goto L33;
            boolean r10 = j.a.c(r5);
            r1.i("ObricLiveReceiver", "isCreateWhenDeviceLocked " + r10);
            if (r10 == false) goto L33;
            boolean r11 = IKeyguardStateKt.getKeyguardState().isDeviceLocked();
            r1.i("ObricLiveReceiver", "isDeviceLocked " + r11);
            if (r11 == false) goto L33;
        L38:
            sea.e.c(true);
            ObricLiveServiceDelegate.b.g(r4);
        L33:
            KeyguardService r12 = KeyguardService.a;
            boolean r13 = r12.isKeyguardLocked();
            r1.i("ObricLiveReceiver", "isKeyguardLocked " + r13);
            if (r13 == false) goto L38;
            boolean r14 = ObricLiveServiceDelegate.b.a();
            r1.i("ObricLiveReceiver", "isCollapseNotificationPanelAvailable " + r14);
            if (r14 == false) goto L38;
            IKeyguardService$a.a(r12, new h(r4), false, false, false, false, null, 62);
            goto L59
        L24:
            r5 = ObricInteractionScene.DEFAULT;
            goto L25
        L40:
            if ((r0 instanceof rea.a.c) == false) goto L45;
            r1.i("ObricLiveReceiver", "enter dialogue");
            mea.b.a.getClass();
            r1.i("ObricStateIslandUtils", "COMPLEX_TASK_ASK_USER, OBRIC_LIVE_ISLAND_ICON_RIGHT_REPLY_WHITE, click");
            j r15 = j.a;
            r15.k();
            r15.m(true);
            ISpecialInputTask r16 = com.obric.assistant.special_input.c.a();
            if (r16 == null) goto L59;
            ISpecialInputTask$a.a(r16, com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "dynamic_island")), null, null, 26), true, false, false, null, 28);
            goto L59
        L45:
            if ((r0 instanceof rea.a.g) == false) goto L53;
            r1.i("ObricLiveReceiver", "open special input");
            mea.b.a.getClass();
            r1.i("ObricStateIslandUtils", "COMPLEX_TASK_ASK_USER, OBRIC_LIVE_ISLAND_ICON_RIGHT_REPLY_BLUE, click");
            IObricReporter.a.getClass();
            IObricReporter r17 = IObricReporter.a.a();
            if (r17 == null) goto L49;
            r17.n("mcp_input_icon", "mcp_input_window", false);
        L49:
            j.a.m(true);
            ISpecialInputTask r18 = com.obric.assistant.special_input.c.a();
            if (r18 == null) goto L59;
            ISpecialInputTask$a.a(r18, StateInfo.copy$default(com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "dynamic_island")), null, null, 26), 0, null, null, null, 0, true, false, null, 223, null), true, false, false, null, 28);
            goto L59
        L53:
            if ((r0 instanceof rea.a.h) == false) goto L59;
            r1.i("ObricLiveReceiver", "replay call for me");
            mea.b.a.getClass();
            IObricSpecialInputService r19 = (IObricSpecialInputService) ServiceManager.get().getService(IObricSpecialInputService.class);
            if (r19 != null) goto L57;
            r1.w("GRStateActionUtils", "replayCallForMe: IObricSpecialInputService is null");
            goto L59
        L57:
            r19.a();
        L59:
            return Unit.INSTANCE;
        }
    }

    public ObricLiveReceiver$Companion$1(Continuation<? super ObricLiveReceiver$Companion$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricLiveReceiver$Companion$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        kotlinx.coroutines.flow.b r5 = kotlinx.coroutines.flow.e.A(ObricLiveReceiver.d);
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r5.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
