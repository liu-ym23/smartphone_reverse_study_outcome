package com.larus.uaigc.instruction;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
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
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$createDigitalAvatar$1", f = "AvatarTemplateWidget.kt", i = {0, 1}, l = {439, 445}, m = "invokeSuspend", n = {"openNewChatPage", "openNewChatPage"}, s = {"I$0", "I$0"})
final class AvatarTemplateWidget$createDigitalAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ny9.s $argumentData;
    final /* synthetic */ ny9.u $hitPointData;
    final /* synthetic */ uy9.a $templateFeedAbility;
    int I$0;
    int label;
    final /* synthetic */ AvatarTemplateWidget this$0;

    public AvatarTemplateWidget$createDigitalAvatar$1(ny9.s r1, AvatarTemplateWidget r2, ny9.u r3, uy9.a r4, Continuation<? super AvatarTemplateWidget$createDigitalAvatar$1> r5) {
        this.$argumentData = r1;
        this.this$0 = r2;
        this.$hitPointData = r3;
        this.$templateFeedAbility = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AvatarTemplateWidget$createDigitalAvatar$1(this.$argumentData, this.this$0, this.$hitPointData, this.$templateFeedAbility, r8);
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
        if (r10 != null) goto L75;
    L40:
        String r4 = null;
    L41:
        int r11 = r2;
    L77:
        AvatarTemplateWidget r6 = this.this$0;
        int[] r7 = AvatarTemplateWidget.k;
        Fragment r8 = r6.getFragment();
        if (r8 == null) goto L80;
        FragmentActivity r12 = r8.requireActivity();
    L81:
        com.bytedance.router.i r13 = SmartRouter.buildRoute(r12, "//flow/create_digital_avatar");
        AvatarTemplateWidget r14 = this.this$0;
        r14.getClass();
        int r15 = CreationHostUiPolicy.f;
        Fragment r16 = r14.getFragment();
        if (r16 == null) goto L84;
        Bundle r17 = r16.getArguments();
    L85:
        r13.c.putExtra("from_ai_creation_applet", CreationHostUiPolicy.a.a(r17).a);
        r13.c.putExtra("argConversationId", r4);
        if (r11 == 0) goto L88;
        r3 = true;
    L88:
        r13.c.putExtra("need_router_to_chat", r3);
        r13.c.putExtra("is_from_template", "0");
        ny9.u r18 = this.$hitPointData;
        if (r18 == null) goto L91;
        String r19 = r18.getEnterMethod();
    L95:
        r13.c.putExtra("enter_method", r19);
        r13.c.putExtra("click_from", "ai_generate_board");
        uy9.a r20 = this.$templateFeedAbility;
        if (r20 == null) goto L98;
        String r21 = r20.PG();
    L99:
        r13.c.putExtra("click_create_replica_template_page_type", r21);
        r13.c.putExtra("click_create_replica_current_page", "template_page");
        ny9.s r22 = this.$argumentData;
        if (r22 == null) goto L104;
        ChatParam r23 = r22.c();
        if (r23 == null) goto L104;
        String r24 = r23.c;
    L105:
        r13.c.putExtra("previous_page", r24);
        ny9.s r25 = this.$argumentData;
        if (r25 == null) goto L110;
        ChatParam r26 = r25.c();
        if (r26 == null) goto L110;
        String r27 = r26.b;
    L111:
        r13.c.putExtra("bot_id", r27);
        ny9.s r28 = this.$argumentData;
        if (r28 == null) goto L116;
        ChatParam r29 = r28.c();
        if (r29 == null) goto L116;
        r5 = r29.e;
    L116:
        r13.c.putExtra("chat_type", r5);
        r13.c.putExtra("ai_creation_recommend_from", "action_bar_template");
        r13.c.putExtra("enter_create_from", "from_creation_combine_panel");
        r13.e(1000);
        FLogger.a.i("AvatarTemplateWidget", "noAvatar so goto create avatar, conversation id: " + r4 + ' ');
        return Unit.INSTANCE;
    L110:
        r27 = null;
    L104:
        r24 = null;
        goto L105
    L98:
        r21 = null;
        goto L99
    L91:
        ny9.s r30 = this.$argumentData;
        if (r30 == null) goto L94;
        r19 = r30.i();
        goto L95
    L94:
        r19 = null;
        goto L95
    L84:
        r17 = null;
        goto L85
    L80:
        r12 = null;
        goto L81
    L75:
        String r31 = r10.a;
    L39:
        r4 = r31;
        goto L41
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.I$0;
        ResultKt.throwOnFailure(r9);
    L36:
        wc9.e r32 = (wc9.e) r9;
        if (r32 == null) goto L40;
        r31 = r32.a;
        goto L39
    L10:
        ResultKt.throwOnFailure(r9);
        ny9.s r33 = this.$argumentData;
        if (r33 != null) goto L13;
    L15:
        r11 = 0;
    L16:
        r4 = "";
        if (r11 == 0) goto L42;
        ILaunchCacheService r34 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r34 == null) goto L23;
        wc9.e r35 = r34.b();
        if (r35 == null) goto L23;
        String r36 = r35.a;
    L24:
        if (r36 == null) goto L28;
        r4 = r36;
    L28:
        if (r4.length() != 0) goto L30;
        boolean r37 = true;
    L31:
        if (r37 == false) goto L77;
        IConversationRepoService r38 = RepoDispatcherDelegate.b.f();
        this.I$0 = r11;
        this.label = 1;
        Object r39 = r38.f(this);
        if (r39 != r0) goto L35;
        return r0;
    L35:
        r2 = r11;
        r9 = r39;
        goto L36
    L30:
        r37 = false;
    L23:
        r36 = null;
        goto L24
    L42:
        ny9.s r40 = this.$argumentData;
        if (r40 == null) goto L47;
        ChatParam r41 = r40.c();
        if (r41 == null) goto L47;
        String r42 = r41.a;
    L48:
        if (r42 != null) goto L51;
        r42 = "";
    L51:
        if (r42.length() != 0) goto L53;
        boolean r43 = true;
    L54:
        if (r43 == false) goto L76;
        ILaunchCacheService r44 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r44 == null) goto L60;
        wc9.e r45 = r44.b();
        if (r45 == null) goto L60;
        String r46 = r45.a;
    L61:
        if (r46 == null) goto L65;
        r4 = r46;
    L65:
        if (r4.length() != 0) goto L67;
        boolean r47 = true;
    L68:
        if (r47 == false) goto L77;
        IConversationRepoService r48 = RepoDispatcherDelegate.b.f();
        this.I$0 = r11;
        this.label = 2;
        Object r49 = r48.f(this);
        if (r49 != r0) goto L72;
        return r0;
    L72:
        r2 = r11;
        r9 = r49;
        goto L73
    L67:
        r47 = false;
    L60:
        r46 = null;
        goto L61
    L76:
        r4 = r42;
        goto L77
    L53:
        r43 = false;
    L47:
        r42 = null;
        goto L48
    L13:
        if (r33.j() != true) goto L15;
        r11 = 1;
        goto L16
    }
}
