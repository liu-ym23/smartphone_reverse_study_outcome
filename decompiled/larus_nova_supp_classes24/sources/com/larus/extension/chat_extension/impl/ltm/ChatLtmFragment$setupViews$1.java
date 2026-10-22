package com.larus.extension.chat_extension.impl.ltm;

import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.extension.chat_extension.impl.databinding.LarusPageChatLtmShowBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmFragment$setupViews$1", f = "ChatLtmFragment.kt", i = {0, 0}, l = {317}, m = "invokeSuspend", n = {"$this$launch", "cvsId"}, s = {"L$0", "L$1"})
final class ChatLtmFragment$setupViews$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChatLtmFragment this$0;

    public ChatLtmFragment$setupViews$1(ChatLtmFragment r1, Continuation<? super ChatLtmFragment$setupViews$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatLtmFragment$setupViews$1 r0 = new ChatLtmFragment$setupViews$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.extension.chat_extension.impl.ltm.d] */
    public final Object invokeSuspend(Object r70) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r9 = "";
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ChatLtmFragment r1 = (ChatLtmFragment) this.L$2;
        String r2 = (String) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r70);
        ChatLtmFragment r15 = r1;
        Object r4 = r70;
    L29:
        BotModel r5 = (BotModel) r4;
        if (r5 != null) goto L33;
        FLogger.a.e("ChatLtmFragment", "Cannot find bot " + r2);
        return Unit.INSTANCE;
    L33:
        r15.g = r5;
        BotServiceImpl r6 = com.larus.im.d.a();
        BotModel r7 = this.this$0.g;
        if (r7 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r7 = null;
    L36:
        String r10 = r7.getBotId();
        if (r10 == null) goto L40;
        r9 = r10;
    L40:
        r6.registerBotChangeListener(r9, this.this$0.m);
    L41:
        this.this$0.getClass();
        ChatLtmFragment r11 = this.this$0;
        String r12 = r11.h;
        BotModel r13 = r11.g;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r13 = null;
    L44:
        String r14 = r13.getBotId();
        String r16 = this.this$0.f;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        String r19 = null;
    L49:
        if (Intrinsics.areEqual(this.this$0.h, "bot_setting") == false) goto L51;
        String r17 = "setting";
    L52:
        a1.c(r14, null, null, null, r19, "memory_manage", null, null, r17, null, null, null, null, null, null, null, r12, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049795, -1, 7);
        final ChatLtmFragment r20 = this.this$0;
        LarusPageChatLtmShowBinding r21 = r20.i;
        if (r21 == null) goto L85;
        ChatLtmViewModel r22 = r20.V90();
        String r23 = r20.f;
        if (r23 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r23 = null;
    L57:
        r22.setConversationID(r23);
        r20.V90().setCurrentPage("memory_manage");
        r20.V90().setPreviousPage(r20.h);
        ChatLtmViewModel r24 = r20.V90();
        Bundle r25 = r20.getArguments();
        if (r25 == null) goto L60;
        String r26 = r25.getString("chat_ltm_target_memory_content");
    L61:
        r24.setTargetMemoryContent(r26);
        ChatLtmViewModel r27 = r20.V90();
        BotModel r29 = r20.g;
        if (r29 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r29 = null;
    L64:
        r27.setBotID(r29.getBotId());
        ChatLtmViewModel r30 = r20.V90();
        BotModel r31 = r20.g;
        if (r31 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r31 = null;
    L67:
        r30.setConfig(r31.getBotMemoryConfig());
        r21.d.setAdapter(r20.k);
        r21.d.setLayoutManager(new LinearLayoutManager(r20.getContext()));
        LarusPageChatLtmShowBinding r32 = r20.i;
        if (r32 == null) goto L72;
        RecyclerView r33 = r32.d;
        if (r33 == null) goto L72;
        RecyclerView.ItemAnimator r34 = r33.getItemAnimator();
    L74:
        if ((r34 instanceof SimpleItemAnimator) == false) goto L76;
        SimpleItemAnimator r35 = (SimpleItemAnimator) r34;
    L77:
        if (r35 == null) goto L79;
        r35.setSupportsChangeAnimations(false);
    L79:
        r20.V90().getItemListData().observe(r20.getViewLifecycleOwner(), new ChatLtmFragment.f(new d(r20)));
        r21.d.addOnItemTouchListener(new ChatLtmFragment$setupList$1$2(r20));
        LarusPageChatLtmShowBinding r36 = r20.i;
        if (r36 == null) goto L84;
        TextView r37 = r36.c;
        if (r37 == null) goto L84;
        r37.setText(r20.getString(2131908110, new Object[]{AppHost.a.getAppStringName()}));
    L84:
        Unit r38 = Unit.INSTANCE;
        goto L85
    L76:
        r35 = null;
    L72:
        r34 = null;
        goto L74
    L60:
        r26 = null;
    L85:
        final ChatLtmFragment r39 = this.this$0;
        LarusPageChatLtmShowBinding r40 = r39.i;
        if (r40 == null) goto L88;
        final NovaTitleBarEx r41 = r40.e;
        NovaTitleBarEx.i6(r41, 2131240955, null, r39.getString(2131898823), new e(r39, r41), 6);
        NovaTitleBarEx.Y5(r41, r39.getString(2131909293), null, null, 6);
    L88:
        final ChatLtmFragment r42 = this.this$0;
        LarusPageChatLtmShowBinding r43 = r42.i;
        if (r43 == null) goto L92;
        NovaTitleBarEx.b6(r43.e, 2131241477, false, null, null, new a(r42), 14);
    L92:
        return Unit.INSTANCE;
    L51:
        r17 = "memory_welcome_window";
        goto L52
    L47:
        r19 = r16;
        goto L49
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r70);
        CoroutineScope r44 = (CoroutineScope) this.L$0;
        String r45 = this.this$0.e;
        if (r45 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("botID");
        r45 = null;
    L12:
        if (r45.length() != 0) goto L14;
        boolean r46 = true;
    L15:
        if (r46 == false) goto L17;
        String r110 = "";
    L18:
        r15 = this.this$0;
        if (r15.g != null) goto L41;
        this.L$0 = r44;
        this.L$1 = r110;
        this.L$2 = r15;
        this.label = 1;
        IRepoDispatcherService r47 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r47 == null) goto L25;
        IBotRepoService r48 = r47.b();
        if (r48 == null) goto L25;
        r4 = IBotRepoService.b.a(r48, r110, false, null, false, this, 28);
    L26:
        if (r4 != r8) goto L28;
        return r8;
    L28:
        r2 = r110;
    L25:
        r4 = null;
        goto L26
    L17:
        r110 = r45;
        goto L18
    L14:
        r46 = false;
        goto L15
    }
}
