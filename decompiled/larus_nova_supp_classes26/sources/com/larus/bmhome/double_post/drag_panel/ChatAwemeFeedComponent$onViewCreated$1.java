package com.larus.bmhome.double_post.drag_panel;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.drag_panel.ChatAwemeFeedComponent$onViewCreated$1", f = "ChatAwemeFeedComponent.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
public final class ChatAwemeFeedComponent$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatAwemeFeedComponent this$0;

    public ChatAwemeFeedComponent$onViewCreated$1(ChatAwemeFeedComponent r1, Continuation<? super ChatAwemeFeedComponent$onViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatAwemeFeedComponent$onViewCreated$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.bmhome.double_post.drag_panel.i] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.double_post.drag_panel.m] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        if (((Boolean) r10).booleanValue() == false) goto L50;
        final ChatAwemeFeedComponent r11 = this.this$0;
        int r2 = ChatAwemeFeedComponent.V;
        LarusPageChatBinding r3 = r11.p3();
        if (r3 == null) goto L52;
        r3.b.setEnable(true);
        r3.b.setScrollListener(new d0(r11, r3));
        LarusPageChatBinding r4 = r11.p3();
        if (r4 == null) goto L21;
        ChatConstraintLayout r5 = r4.a;
        if (r5 == null) goto L21;
        r5.postDelayed(new j(r11), 300);
    L21:
        u7 r6 = r11.B3();
        if (r6 == null) goto L24;
        MessageAdapter r7 = r6.MF();
    L26:
        if ((r7 instanceof MessageAdapter) == true) goto L29;
        r7 = null;
    L29:
        if (r7 == null) goto L31;
        r7.p1(new p(r11));
    L31:
        LarusPageChatBinding r8 = r11.p3();
        if (r8 == null) goto L45;
        IChatMessageShareAbility r9 = (IChatMessageShareAbility) r11.v.getValue();
        if (r9 == null) goto L36;
        r9.A60(new c0(r8, r11));
    L36:
        ld8.n r12 = (ld8.n) r11.z.getValue();
        if (r12 == null) goto L39;
        r12.AE(BottomFloatingButtonType.BACK_CHAT_BUTTON, new k(r11));
    L39:
        f1 r13 = d.a(r11).getAbility(f1.class);
        if (r13 == null) goto L43;
        r13.Yj(new m(r11));
    L43:
        if (r11.z3().getShouldFullyDisplay() == false) goto L45;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), null, null, new ChatAwemeFeedComponent$addListener$1$4(r11, null), 3, null);
    L45:
        AppHost.a.a().j(r11.U);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(r11, r11), r11, l0.class);
        if (r11.z3().getSupportFullScreen() == false) goto L52;
        if (r11.z3().getSupportFullScreenNavi() == false) goto L52;
        r11.S = new ChatAwemeFeedComponent$b(r3.g, new i(r11));
        goto L52
    L24:
        r7 = null;
    L52:
        return Unit.INSTANCE;
    L50:
        FLogger.a.i("ChatAwemeFeedComponent", "preCheck failed");
        goto L52
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ChatAwemeFeedComponent r14 = this.this$0;
        this.label = 1;
        r10 = ChatAwemeFeedComponent.Y2(r14, this);
        if (r10 != r0) goto L12;
        return r0;
    }
}
