package com.obric.assistant.component;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricChatListComponent$scrollToMessageAlignBottom$1", f = "ObricChatListComponent.kt", i = {0}, l = {ApWakeEvent.WALKING_END}, m = "invokeSuspend", n = {"layoutManager"}, s = {"L$0"})
final class ObricChatListComponent$scrollToMessageAlignBottom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $highlight;
    final /* synthetic */ int $marginBottom;
    final /* synthetic */ String $targetMsgId;
    Object L$0;
    int label;
    final /* synthetic */ ObricChatListComponent this$0;

    public ObricChatListComponent$scrollToMessageAlignBottom$1(ObricChatListComponent r1, String r2, int r3, boolean r4, Continuation<? super ObricChatListComponent$scrollToMessageAlignBottom$1> r5) {
        this.this$0 = r1;
        this.$targetMsgId = r2;
        this.$marginBottom = r3;
        this.$highlight = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricChatListComponent$scrollToMessageAlignBottom$1(this.this$0, this.$targetMsgId, this.$marginBottom, this.$highlight, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        ViewGroup.MarginLayoutParams r4 = null;
        int r6 = 0;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        final LinearLayoutManager r2 = (LinearLayoutManager) this.L$0;
        ResultKt.throwOnFailure(r11);
    L49:
        ObricChatListComponent r12 = this.this$0;
        String r5 = this.$targetMsgId;
        int r7 = ObricChatListComponent.o;
        int r13 = r12.L2(r5);
        if (r13 >= 0) goto L53;
        FLogger.a.w("ObricChatListComponent", "scrollToMessageAlignBottom: targetMsgId[" + this.$targetMsgId + "] not found after delay");
        return Unit.INSTANCE;
    L53:
        com.larus.bmhome.chat.api.b0 r8 = this.this$0.N2();
        if ((r8 instanceof com.larus.bmhome.chat.api.b0) == false) goto L56;
        com.larus.bmhome.chat.api.b0 r9 = r8;
    L57:
        if (r9 == null) goto L60;
        r9.setBottomReached(false);
    L60:
        if (s1a.a.e(this.this$0) == false) goto L105;
        int r10 = this.$marginBottom;
        va8.m r14 = (va8.m) this.this$0.h.getValue();
        if (r14 == null) goto L66;
        va8.l r15 = r14.iX();
        if (r15 == null) goto L66;
        FrameLayout r16 = r15.getInput();
    L67:
        if (r16 != null) goto L69;
    L71:
        boolean r17 = false;
    L72:
        if (r17 == false) goto L92;
        Integer r18 = Integer.valueOf(r16.getHeight());
        if (r18.intValue() <= 0) goto L77;
        boolean r19 = true;
    L78:
        if (r19 == true) goto L81;
        r18 = null;
    L81:
        if (r18 == null) goto L83;
        int r20 = r18.intValue();
    L93:
        int r21 = r10 + r20;
        va8.m r22 = (va8.m) this.this$0.h.getValue();
        if (r22 == null) goto L104;
        va8.l r23 = r22.iX();
        if (r23 == null) goto L104;
        FrameLayout r24 = r23.z8();
        if (r24 == null) goto L104;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L102;
        r4 = (ViewGroup.MarginLayoutParams) r25;
    L102:
        if (r4 == null) goto L104;
        r6 = r4.bottomMargin;
    L104:
        int r26 = r21 + r6;
    L106:
        r2.scrollToPositionWithOffset(r13, r26);
        if (r13 != 0) goto L112;
        ld8.n r110 = (ld8.n) this.this$0.j.getValue();
        if (r110 == null) goto L112;
        r110.m60(BottomFloatingButtonAction.SCROLL_DOWN);
    L112:
        if (this.$highlight == false) goto L117;
        RecyclerView r111 = this.this$0.N2();
        if (r111 == null) goto L117;
        final ObricChatListComponent r27 = this.this$0;
        final String r28 = this.$targetMsgId;
        Boxing.boxBoolean(r111.post(new m(r27, r2, r28)));
    L117:
        return Unit.INSTANCE;
    L83:
        Integer r29 = Integer.valueOf(r16.getMeasuredHeight());
        if (r29.intValue() > 0) goto L87;
        r3 = false;
    L87:
        if (r3 == true) goto L90;
        r29 = null;
    L90:
        if (r29 == null) goto L92;
        r20 = r29.intValue();
        goto L93
    L77:
        r19 = false;
    L92:
        r20 = 0;
        goto L93
    L69:
        if (r16.getVisibility() != 0) goto L71;
        r17 = true;
    L66:
        r16 = null;
        goto L67
    L105:
        r26 = this.$marginBottom;
        goto L106
    L56:
        r9 = null;
        goto L57
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (((BaseComponentFeatureInternal) this.this$0).a.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L12;
        FLogger.a.i("ObricChatListComponent", "scrollToMessageAlignBottom: is not stared, ignore scroll");
        return Unit.INSTANCE;
    L12:
        ObricChatListComponent r112 = this.this$0;
        int r30 = ObricChatListComponent.o;
        if (r112.N2() != null) goto L16;
        FLogger.a.w("ObricChatListComponent", "scrollToMessageAlignBottom: message list is null");
        return Unit.INSTANCE;
    L16:
        int r113 = this.this$0.L2(this.$targetMsgId);
        if (r113 >= 0) goto L20;
        FLogger.a.w("ObricChatListComponent", "scrollToMessageAlignBottom: targetMsgId[" + this.$targetMsgId + "] not found");
        return Unit.INSTANCE;
    L20:
        RecyclerView r31 = this.this$0.N2();
        if (r31 == null) goto L23;
        RecyclerView.LayoutManager r32 = r31.getLayoutManager();
    L25:
        if ((r32 instanceof LinearLayoutManager) == false) goto L27;
        LinearLayoutManager r33 = (LinearLayoutManager) r32;
    L28:
        if (r33 != null) goto L31;
        FLogger.a.w("ObricChatListComponent", "scrollToMessageAlignBottom: layout manager is not LinearLayoutManager");
        return Unit.INSTANCE;
    L31:
        FLogger.a.i("ObricChatListComponent", "scrollToMessageAlignBottom: scrollToPositionWithOffset, targetPosition = " + r113 + ", marginBottom = " + this.$marginBottom);
        if (r113 <= 0) goto L36;
        IObricChatUIService r114 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r114 == null) goto L36;
        r114.g();
    L36:
        RecyclerView r115 = this.this$0.N2();
        if (r115 == null) goto L39;
        r115.stopScroll();
    L39:
        com.larus.bmhome.chat.api.b0 r116 = this.this$0.N2();
        if ((r116 instanceof com.larus.bmhome.chat.api.b0) == false) goto L42;
        com.larus.bmhome.chat.api.b0 r117 = r116;
    L43:
        if (r117 == null) goto L45;
        r117.setBottomReached(false);
    L45:
        this.L$0 = r33;
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L48;
        return r0;
    L48:
        r2 = r33;
        goto L49
    L42:
        r117 = null;
        goto L43
    L27:
        r33 = null;
        goto L28
    L23:
        r32 = null;
        goto L25
    }
}
