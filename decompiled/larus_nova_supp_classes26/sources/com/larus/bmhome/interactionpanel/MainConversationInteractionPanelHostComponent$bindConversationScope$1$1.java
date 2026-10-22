package com.larus.bmhome.interactionpanel;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.cotdetail.CotDetailDialogFragment;
import com.larus.bmhome.chat.cotdetail.CotDetailFragment;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.ComplexTaskDisplayType;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.interactionpanel.MainConversationInteractionPanelHostComponent$bindConversationScope$1$1", f = "MainConversationInteractionPanelHostComponent.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
final class MainConversationInteractionPanelHostComponent$bindConversationScope$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ MainConversationInteractionPanelHostComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.interactionpanel.MainConversationInteractionPanelHostComponent$bindConversationScope$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "snapshot", "Lcom/larus/bmhome/interactionpanel/InteractionPanelSnapshot;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.interactionpanel.MainConversationInteractionPanelHostComponent$bindConversationScope$1$1$1", f = "MainConversationInteractionPanelHostComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<v, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MainConversationInteractionPanelHostComponent this$0;

        public AnonymousClass1(MainConversationInteractionPanelHostComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(v r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((v) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L71;
            ResultKt.throwOnFailure(r9);
            v r10 = (v) this.L$0;
            MainConversationInteractionPanelHostComponent r0 = this.this$0;
            int r1 = MainConversationInteractionPanelHostComponent.u;
            r0.getClass();
            m r11 = r10.c;
            ICoreInputAbility r2 = s1a.d.a(r0).getAbility(ICoreInputAbility.class);
            if (r2 == null) goto L7;
            MessageModifyMode r3 = r2.FF();
        L8:
            if (r3 != null) goto L10;
            boolean r4 = true;
        L11:
            if (r4 == false) goto L13;
            if (r11 == null) goto L18;
            m r5 = r0.r;
            if (r5 == null) goto L24;
            o r6 = r5.a;
        L26:
            if (Intrinsics.areEqual(r6, r11.a) == false) goto L28;
            boolean r7 = r0.Y2().update(r11, "main_conversation");
            FLogger.a.d("InteractionPanelHost", "update active entry, key=" + r11.a + ", updated=" + r7);
            r0.h3();
            r0.r = r11;
        L69:
            return Unit.INSTANCE;
        L28:
            if (r5 == null) goto L30;
            r0.Y2().a(r5, "active_changed");
        L30:
            r0.h3();
            boolean r8 = r0.Y2().b(r11, "main_conversation");
            FLogger r12 = FLogger.a;
            r12.i("InteractionPanelHost", "render active entry, key=" + r11.a + ", rendered=" + r8);
            FragmentActivity r13 = AppHost.a.a().getCurrentActivity();
            if ((r13 instanceof FragmentActivity) == false) goto L33;
            FragmentActivity r14 = r13;
        L34:
            if (r14 == null) goto L61;
            CotDetailDialogFragment r15 = r14.getSupportFragmentManager().findFragmentByTag("CotDetailDialogFragment");
            if ((r15 instanceof CotDetailDialogFragment) == false) goto L39;
            CotDetailDialogFragment r16 = r15;
        L40:
            if (r16 == null) goto L61;
            CotDetailFragment r17 = r16.getChildFragmentManager().findFragmentById(2131367980);
            if ((r17 instanceof CotDetailFragment) == false) goto L45;
            CotDetailFragment r18 = r17;
        L46:
            if (r18 == null) goto L61;
            Bundle r19 = r18.getArguments();
            if (r19 == null) goto L51;
            String r20 = r19.getString("interaction_display_type");
        L53:
            if (Intrinsics.areEqual(r20, ComplexTaskDisplayType.SUB_AGENT.getValue()) == false) goto L61;
            r12.i("InteractionPanelHost", "close subagent cot detail fragment");
            r16.dismissAllowingStateLoss();     // Catch: Exception -> L57
        L57:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r21 = DialogFragmentLancet.sLastShowStack;
            if (r21 == null) goto L61;
            com.bytedance.crash.d.d(r21, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L61
        L51:
            r20 = null;
            goto L53
        L45:
            r18 = null;
            goto L46
        L39:
            r16 = null;
        L61:
            if (r8 == false) goto L63;
            r0.h3();
        L64:
            if (r8 == true) goto L67;
            r11 = null;
        L67:
            r0.r = r11;
            goto L69
        L63:
            r0.pC();
            goto L64
        L33:
            r14 = null;
            goto L34
        L24:
            r6 = null;
            goto L26
        L18:
            if (r0.r == null) goto L20;
            r0.Y2().a(r0.r, "active_cleared");
            r0.r = null;
        L20:
            r0.pC();
            goto L69
        L13:
            if (r0.r == null) goto L15;
            r0.Y2().a(r0.r, "host_gate_blocked");
            r0.r = null;
        L15:
            r0.pC();
            goto L69
        L10:
            r4 = false;
            goto L11
        L7:
            r3 = null;
            goto L8
        L71:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MainConversationInteractionPanelHostComponent$bindConversationScope$1$1(MainConversationInteractionPanelHostComponent r1, String r2, Continuation<? super MainConversationInteractionPanelHostComponent$bindConversationScope$1$1> r3) {
        this.this$0 = r1;
        this.$conversationId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MainConversationInteractionPanelHostComponent$bindConversationScope$1$1(this.this$0, this.$conversationId, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        i1 r7 = this.this$0.m.h(new n.a(this.$conversationId));
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
