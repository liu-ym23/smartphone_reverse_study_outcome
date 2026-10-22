package com.larus.uaigc.createpage.component.instruction;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$jumpToCreateOrCompleteAvatar$1", f = "CreationEditorComponent.kt", i = {0, 1}, l = {4639, 4645}, m = "invokeSuspend", n = {"openNewChatPage", "openNewChatPage"}, s = {"I$0", "I$0"})
public final class CreationEditorComponent$jumpToCreateOrCompleteAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ny9.s $argumentData;
    final /* synthetic */ Long $targetInstructionItemId;
    final /* synthetic */ uy9.a $templateFeedAbility;
    int I$0;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$jumpToCreateOrCompleteAvatar$1(ny9.s r1, CreationEditorComponent r2, uy9.a r3, Long r4, Continuation<? super CreationEditorComponent$jumpToCreateOrCompleteAvatar$1> r5) {
        this.$argumentData = r1;
        this.this$0 = r2;
        this.$templateFeedAbility = r3;
        this.$targetInstructionItemId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreationEditorComponent$jumpToCreateOrCompleteAvatar$1(this.$argumentData, this.this$0, this.$templateFeedAbility, this.$targetInstructionItemId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = false;
        String r5 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r9);
    L73:
        wc9.e r10 = (wc9.e) r9;
        if (r10 == null) goto L76;
        String r4 = r10.a;
    L77:
        int r11 = r2;
    L81:
        Fragment r6 = s1a.a.c(this.this$0);
        if (r6 == null) goto L84;
        FragmentActivity r7 = r6.requireActivity();
    L85:
        com.bytedance.router.i r8 = SmartRouter.buildRoute(r7, "//flow/create_digital_avatar");
        r8.c.putExtra("argConversationId", r4);
        if (r11 == 0) goto L88;
        r3 = true;
    L88:
        r8.c.putExtra("need_router_to_chat", r3);
        r8.c.putExtra("is_from_template", "0");
        r8.c.putExtra("enter_method", "chat_action_bar");
        r8.c.putExtra("click_from", "ai_generate_board");
        uy9.a r12 = this.$templateFeedAbility;
        if (r12 == null) goto L91;
        String r13 = r12.PG();
    L92:
        r8.c.putExtra("click_create_replica_template_page_type", r13);
        r8.c.putExtra("click_create_replica_current_page", "template_page");
        r8.c.putExtra("target_instruction_item_id", this.$targetInstructionItemId);
        ny9.s r14 = this.$argumentData;
        if (r14 == null) goto L97;
        ChatParam r15 = r14.c();
        if (r15 == null) goto L97;
        String r16 = r15.c;
    L98:
        r8.c.putExtra("previous_page", r16);
        ny9.s r17 = this.$argumentData;
        if (r17 == null) goto L103;
        ChatParam r18 = r17.c();
        if (r18 == null) goto L103;
        String r19 = r18.b;
    L104:
        r8.c.putExtra("bot_id", r19);
        ny9.s r20 = this.$argumentData;
        if (r20 == null) goto L109;
        ChatParam r21 = r20.c();
        if (r21 == null) goto L109;
        r5 = r21.e;
    L109:
        r8.c.putExtra("chat_type", r5);
        r8.c.putExtra("ai_creation_recommend_from", "action_bar_template");
        r8.c.putExtra("enter_create_from", "from_creation_combine_panel");
        r8.e(1000);
        FLogger.a.i("CreationEditorComponent", "noAvatar so goto create avatar, conversation id: " + r4 + ' ');
        return Unit.INSTANCE;
    L103:
        r19 = null;
    L97:
        r16 = null;
        goto L98
    L91:
        r13 = null;
        goto L92
    L84:
        r7 = null;
        goto L85
    L76:
        r4 = null;
        goto L77
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        int r22 = this.I$0;
        ResultKt.throwOnFailure(r9);
    L36:
        wc9.e r23 = (wc9.e) r9;
        if (r23 == null) goto L39;
        r4 = r23.a;
    L40:
        r11 = r22;
        goto L81
    L39:
        r4 = null;
        goto L40
    L10:
        ResultKt.throwOnFailure(r9);
        ny9.s r24 = this.$argumentData;
        if (r24 != null) goto L13;
    L15:
        r11 = 0;
    L16:
        r4 = "";
        if (r11 == 0) goto L42;
        ILaunchCacheService r25 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r25 == null) goto L23;
        wc9.e r26 = r25.b();
        if (r26 == null) goto L23;
        String r27 = r26.a;
    L24:
        if (r27 == null) goto L28;
        r4 = r27;
    L28:
        if (r4.length() != 0) goto L30;
        boolean r28 = true;
    L31:
        if (r28 == false) goto L81;
        IConversationRepoService r29 = RepoDispatcherDelegate.b.f();
        this.I$0 = r11;
        this.label = 1;
        Object r30 = r29.f(this);
        if (r30 != r0) goto L35;
        return r0;
    L35:
        r22 = r11;
        r9 = r30;
        goto L36
    L30:
        r28 = false;
    L23:
        r27 = null;
        goto L24
    L42:
        ny9.s r31 = this.$argumentData;
        if (r31 == null) goto L47;
        ChatParam r32 = r31.c();
        if (r32 == null) goto L47;
        String r33 = r32.a;
    L48:
        if (r33 != null) goto L51;
        r33 = "";
    L51:
        if (r33.length() != 0) goto L53;
        boolean r34 = true;
    L54:
        if (r34 == false) goto L79;
        ILaunchCacheService r35 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r35 == null) goto L60;
        wc9.e r36 = r35.b();
        if (r36 == null) goto L60;
        String r37 = r36.a;
    L61:
        if (r37 == null) goto L65;
        r4 = r37;
    L65:
        if (r4.length() != 0) goto L67;
        boolean r38 = true;
    L68:
        if (r38 == false) goto L81;
        IConversationRepoService r39 = RepoDispatcherDelegate.b.f();
        this.I$0 = r11;
        this.label = 2;
        Object r40 = r39.f(this);
        if (r40 != r0) goto L72;
        return r0;
    L72:
        r2 = r11;
        r9 = r40;
        goto L73
    L67:
        r38 = false;
    L60:
        r37 = null;
        goto L61
    L79:
        r4 = r33;
        goto L81
    L53:
        r34 = false;
    L47:
        r33 = null;
        goto L48
    L13:
        if (r24.j() != true) goto L15;
        r11 = 1;
        goto L16
    }
}
