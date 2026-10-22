package com.larus.bmhome.chat.manager;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper;
import com.larus.bmhome.view.screenmenu.ScreenMenuLayout;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1", f = "ChatListScreenMenuManager.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
final class ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Deferred<z0> $actionBarItemDeferred;
    final /* synthetic */ String $botId;
    final /* synthetic */ di8.o0 $forkUiConfig;
    final /* synthetic */ View $hostView;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> $onForkResult;
    final /* synthetic */ Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> $onForkUnEnableClick;
    final /* synthetic */ x0 $screenMenu;
    final /* synthetic */ View $sourceView;
    final /* synthetic */ wc9.e $targetConversation;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1(x0 r1, View r2, View r3, di8.o0 r4, Function1<? super com.larus.bmhome.chat.nestedmenu.c, Unit> r5, Function1<? super com.larus.bmhome.chat.nestedmenu.c, Unit> r6, wc9.e r7, Deferred<z0> r8, LifecycleOwner r9, String r10, Continuation<? super ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1> r11) {
        this.$screenMenu = r1;
        this.$sourceView = r2;
        this.$hostView = r3;
        this.$forkUiConfig = r4;
        this.$onForkUnEnableClick = r5;
        this.$onForkResult = r6;
        this.$targetConversation = r7;
        this.$actionBarItemDeferred = r8;
        this.$lifecycleOwner = r9;
        this.$botId = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1(this.$screenMenu, this.$sourceView, this.$hostView, this.$forkUiConfig, this.$onForkUnEnableClick, this.$onForkResult, this.$targetConversation, this.$actionBarItemDeferred, this.$lifecycleOwner, this.$botId, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        Object r4 = r21;
    L11:
        z0 r10 = (z0) r4;
        if (this.$screenMenu.h() == false) goto L43;
        if (this.$sourceView.isAttachedToWindow() == false) goto L43;
        View r5 = this.$hostView;
        if (r5 != null) goto L18;
    L20:
        r3 = false;
    L21:
        if (r3 == false) goto L43;
        if (r10 != null) goto L29;
        FLogger.a.i("ChatListScreenMenuManager", "side nav fork action bar unavailable");
        IMainBotNestedMenuService.Companion r6 = IMainBotNestedMenuService.a;
        NestedMenuScene r7 = NestedMenuScene.SETTINGS;
        di8.o0 r12 = di8.o0.a(this.$forkUiConfig, false, null, false, this.$sourceView.getContext().getString(2131905626), true, 33554039);
        View r8 = this.$hostView;
        View r11 = this.$sourceView;
        if (IMainBotNestedMenuService.a.a(r6, r7, "fork_conv", r8, r11, r11, null, r12, null, this.$onForkUnEnableClick, this.$onForkResult, 256) == false) goto L28;
        t19.s r9 = t19.s.a;
        Context r13 = this.$sourceView.getContext();
        r9.getClass();
        t19.s.b(r13, 2131905626, false);
    L28:
        return Unit.INSTANCE;
    L29:
        IMainBotNestedMenuService.Companion r14 = IMainBotNestedMenuService.a;
        NestedMenuScene r15 = NestedMenuScene.SETTINGS;
        ReplyOption r16 = IConvReplyModeRecordHelper.a.b(this.$targetConversation.a);
        if (r16 != null) goto L35;
        com.larus.bmhome.actionbar.model.p0 r17 = r10.o;
        if (r17 == null) goto L34;
        r16 = r17.b();
        goto L35
    L34:
        r16 = null;
    L35:
        di8.o0 r18 = di8.o0.a(this.$forkUiConfig, false, null, false, null, true, 33554175);
        View r19 = this.$hostView;
        View r20 = this.$sourceView;
        if (IMainBotNestedMenuService.a.a(r14, r15, "fork_conv", r19, r20, r20, r10, r18, r16, this.$onForkUnEnableClick, this.$onForkResult, 256) == true) goto L41;
        ScreenMenuLayout r22 = this.$screenMenu.a;
        if (r22 == null) goto L41;
        r22.setMenuMask(false);
    L41:
        return Unit.INSTANCE;
    L18:
        if (r5.isAttachedToWindow() != true) goto L20;
    L43:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        IActionBarService r23 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1 r24 = new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1(this.$actionBarItemDeferred, r23, this.$lifecycleOwner, this.$botId, null);
        this.label = 1;
        r4 = TimeoutKt.c(5000, r24, this);
        if (r4 != r1) goto L11;
        return r1;
    }
}
