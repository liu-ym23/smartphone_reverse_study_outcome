package com.larus.uaigc.createpage.component.digitalavatar;

import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$createDigitalAvatar$1", f = "DigitalAvatarComponent.kt", i = {0, 1}, l = {208, 214}, m = "invokeSuspend", n = {"openNewChatPage", "openNewChatPage"}, s = {"I$0", "I$0"})
public final class DigitalAvatarComponent$createDigitalAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ab8.a $templateInfo;
    int I$0;
    int label;
    final /* synthetic */ DigitalAvatarComponent this$0;

    public DigitalAvatarComponent$createDigitalAvatar$1(DigitalAvatarComponent r1, ab8.a r2, Continuation<? super DigitalAvatarComponent$createDigitalAvatar$1> r3) {
        this.this$0 = r1;
        this.$templateInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DigitalAvatarComponent$createDigitalAvatar$1(this.this$0, this.$templateInfo, r4);
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
        com.bytedance.router.i r6 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/create_digital_avatar");
        DigitalAvatarComponent r7 = this.this$0;
        int r8 = DigitalAvatarComponent.C;
        r7.getClass();
        int r12 = CreationHostUiPolicy.f;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r6.c.putExtra("from_ai_creation_applet", CreationHostUiPolicy.a.a(com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getArguments()).a);
        r6.c.putExtra("argConversationId", r4);
        if (r11 == 0) goto L80;
        boolean r13 = true;
    L81:
        r6.c.putExtra("need_router_to_chat", r13);
        if (this.$templateInfo == null) goto L84;
        r3 = true;
    L84:
        r6.c.putExtra("is_from_template", l3.f(Boxing.boxBoolean(r3)));
        ab8.a r14 = this.$templateInfo;
        if (r14 == null) goto L89;
        UserCreation r15 = r14.a;
        if (r15 == null) goto L89;
        String r16 = r15.a;
    L90:
        r6.c.putExtra("template_id", r16);
        r6.c.putExtra("enter_method", "chat_action_bar");
        r6.c.putExtra("click_from", "ai_replica_action_bar");
        uy9.a r17 = (uy9.a) this.this$0.u.getValue();
        if (r17 == null) goto L93;
        String r18 = r17.PG();
    L94:
        r6.c.putExtra("click_create_replica_template_page_type", r18);
        r6.c.putExtra("click_create_replica_current_page", "template_page");
        ny9.s r19 = this.this$0.B3();
        if (r19 == null) goto L99;
        ChatParam r20 = r19.c();
        if (r20 == null) goto L99;
        String r21 = r20.c;
    L100:
        r6.c.putExtra("previous_page", r21);
        ny9.s r22 = this.this$0.B3();
        if (r22 == null) goto L105;
        ChatParam r23 = r22.c();
        if (r23 == null) goto L105;
        String r24 = r23.b;
    L106:
        r6.c.putExtra("bot_id", r24);
        ny9.s r25 = this.this$0.B3();
        if (r25 == null) goto L111;
        ChatParam r26 = r25.c();
        if (r26 == null) goto L111;
        String r27 = r26.e;
    L112:
        r6.c.putExtra("chat_type", r27);
        r6.c.putExtra("ai_creation_recommend_from", "action_bar_template");
        ab8.a r28 = this.$templateInfo;
        if (r28 == null) goto L126;
        JSONObject r29 = new JSONObject();
        UserCreation r30 = r28.a;
        if (r30 == null) goto L117;
        String r31 = r30.a;
    L118:
        r29.put("id", r31);
        Unit r32 = Unit.INSTANCE;
        r6.j("creation_template", r29.toString());
        UserCreation r33 = r28.a;
        if (r33 == null) goto L125;
        UserCreationContent r34 = r33.e;
        if (r34 == null) goto L125;
        UserCreationUserAvatar r35 = r34.c;
        if (r35 == null) goto L125;
        r5 = r35.c;
    L125:
        r6.j("actionbar_instruction_prompt", r5);
        goto L126
    L117:
        r31 = null;
    L126:
        r6.c.addFlags(268435456);
        r6.d();
        FLogger.a.i("DigitalAvatarComponent", "noAvatar so goto create avatar, conversation id: " + r4 + ' ');
        return Unit.INSTANCE;
    L111:
        r27 = null;
    L105:
        r24 = null;
    L99:
        r21 = null;
        goto L100
    L93:
        r18 = null;
    L89:
        r16 = null;
        goto L90
    L80:
        r13 = false;
        goto L81
    L75:
        String r36 = r10.a;
    L39:
        r4 = r36;
        goto L41
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.I$0;
        ResultKt.throwOnFailure(r9);
    L36:
        wc9.e r37 = (wc9.e) r9;
        if (r37 == null) goto L40;
        r36 = r37.a;
        goto L39
    L10:
        ResultKt.throwOnFailure(r9);
        DigitalAvatarComponent r38 = this.this$0;
        int r39 = DigitalAvatarComponent.C;
        ny9.s r40 = r38.B3();
        if (r40 != null) goto L13;
    L15:
        r11 = 0;
    L16:
        r4 = "";
        if (r11 == 0) goto L42;
        ILaunchCacheService r41 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r41 == null) goto L23;
        wc9.e r42 = r41.b();
        if (r42 == null) goto L23;
        String r43 = r42.a;
    L24:
        if (r43 == null) goto L28;
        r4 = r43;
    L28:
        if (r4.length() != 0) goto L30;
        boolean r44 = true;
    L31:
        if (r44 == false) goto L77;
        IConversationRepoService r45 = RepoDispatcherDelegate.b.f();
        this.I$0 = r11;
        this.label = 1;
        Object r46 = r45.f(this);
        if (r46 != r0) goto L35;
        return r0;
    L35:
        r2 = r11;
        r9 = r46;
        goto L36
    L30:
        r44 = false;
    L23:
        r43 = null;
        goto L24
    L42:
        ny9.s r47 = this.this$0.B3();
        if (r47 == null) goto L47;
        ChatParam r48 = r47.c();
        if (r48 == null) goto L47;
        String r49 = r48.a;
    L48:
        if (r49 != null) goto L51;
        r49 = "";
    L51:
        if (r49.length() != 0) goto L53;
        boolean r50 = true;
    L54:
        if (r50 == false) goto L76;
        ILaunchCacheService r51 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r51 == null) goto L60;
        wc9.e r52 = r51.b();
        if (r52 == null) goto L60;
        String r53 = r52.a;
    L61:
        if (r53 == null) goto L65;
        r4 = r53;
    L65:
        if (r4.length() != 0) goto L67;
        boolean r54 = true;
    L68:
        if (r54 == false) goto L77;
        IConversationRepoService r55 = RepoDispatcherDelegate.b.f();
        this.I$0 = r11;
        this.label = 2;
        Object r56 = r55.f(this);
        if (r56 != r0) goto L72;
        return r0;
    L72:
        r2 = r11;
        r9 = r56;
        goto L73
    L67:
        r54 = false;
    L60:
        r53 = null;
        goto L61
    L76:
        r4 = r49;
        goto L77
    L53:
        r50 = false;
    L47:
        r49 = null;
        goto L48
    L13:
        if (r40.j() != true) goto L15;
        r11 = 1;
        goto L16
    }
}
