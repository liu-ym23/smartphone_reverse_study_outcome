package com.larus.profile.impl.creation;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$jumpToAvatarDoSame$1", f = "CreationDoSameAbility.kt", i = {}, l = {1604}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDoSameAbility$jumpToAvatarDoSame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ UserCreation $userCreation;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$jumpToAvatarDoSame$1(CreationDoSameAbility r1, UserCreation r2, sq9.p r3, Continuation<? super CreationDoSameAbility$jumpToAvatarDoSame$1> r4) {
        this.this$0 = r1;
        this.$userCreation = r2;
        this.$doSameInitParams = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDoSameAbility$jumpToAvatarDoSame$1(this.this$0, this.$userCreation, this.$doSameInitParams, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = "";
        boolean r3 = false;
        String r5 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L24:
        wc9.e r13 = (wc9.e) r12;
        if (r13 == null) goto L27;
        String r14 = r13.a;
    L28:
        Context r4 = this.this$0.a.getContext();
        if (r4 == null) goto L114;
        UserCreation r6 = this.$userCreation;
        sq9.p r7 = this.$doSameInitParams;
        CreationDoSameAbility r8 = this.this$0;
        com.bytedance.router.i r9 = SmartRouter.buildRoute(r4, "//flow/create_digital_avatar");
        r9.c.putExtra("argConversationId", r14);
        CreationDynamicInfo r10 = r6.h;
        if (r10 == null) goto L35;
        TplInfo r11 = r10.e;
        if (r11 == null) goto L35;
        String r15 = r11.a;
    L37:
        if (Intrinsics.areEqual(r15, TplType.AI_REPLICA) == false) goto L44;
        UserCreationContent r16 = r6.e;
        if (r16 == null) goto L67;
        UserCreationImage r17 = r16.a;
        if (r17 == null) goto L67;
        r2 = r17.c;
    L68:
        r9.c.putExtra("actionbar_instruction_prompt", r2);
        r9.c.putExtra("need_router_to_chat", true);
        JSONObject r18 = new JSONObject();
        UserCreation r19 = r7.d;
        if (r19 == null) goto L71;
        String r20 = r19.a;
    L72:
        r18.put("id", r20);
        r18.put("recommend_from", r7.g);
        UserCreationTrackParams r21 = r6.n;
        if (r21 == null) goto L75;
        String r22 = r21.a;
    L76:
        r18.put("template_rec_req_id", r22);
        r18.put("template_rec_extra", r6.i);
        r18.put("from_template_id", r6.a);
        r18.put("tpl_tag_type", r6.q(false));
        r18.put("tpl_button_type", sq9.q.a(r7.l, r6, false, r7.m));
        Unit r23 = Unit.INSTANCE;
        r9.c.putExtra("creation_template", r18.toString());
        r9.c.putExtra("enter_method", r7.c);
        r9.c.putExtra("click_from", "use_template");
        r9.c.putExtra("click_create_replica_template_page_type", r7.n);
        r9.c.putExtra("click_create_replica_current_page", "template_page");
        UserCreationTrackParams r24 = r6.n;
        if (r24 == null) goto L79;
        String r25 = r24.d;
    L80:
        r9.c.putExtra("ai_generate_tab_id", r25);
        UserCreationTrackParams r26 = r6.n;
        if (r26 == null) goto L83;
        String r27 = r26.e;
    L84:
        r9.c.putExtra("ai_generate_tab_name", r27);
        UserCreationTrackParams r28 = r6.n;
        if (r28 == null) goto L87;
        String r29 = r28.f;
    L88:
        r9.c.putExtra("ai_generate_tab_type", r29);
        r9.c.putExtra("from_template_sub_type", zp9.d.c(r6));
        r9.c.putExtra("is_has_caption", String.valueOf(r6.z()));
        r9.c.putExtra("is_image_reference_public", String.valueOf(r6.D()));
        r9.c.putExtra("ai_creation_recommend_from", r7.g);
        r9.c.putExtra("previous_page", r7.b);
        r9.c.putExtra("is_from_avatar_creation", true);
        CreationDynamicInfo r30 = r6.h;
        if (r30 == null) goto L93;
        TplInfo r31 = r30.e;
        if (r31 == null) goto L93;
        String r32 = r31.a;
    L95:
        if (Intrinsics.areEqual(r32, TplType.AI_REPLICA) == true) goto L106;
        CreationDynamicInfo r33 = r6.h;
        if (r33 == null) goto L101;
        TplInfo r34 = r33.e;
        if (r34 == null) goto L101;
        String r35 = r34.a;
    L103:
        if (Intrinsics.areEqual(r35, TplType.AI_REPLICA) == false) goto L105;
    L107:
        r9.c.putExtra("is_mock_avatar", r3);
        r9.c.putExtra("enter_create_from", "from_avatar_creation_dosame");
        r9.c.putExtra("select_instruction_type", 4);
        UserCreationContent r36 = r6.e;
        if (r36 == null) goto L112;
        UserCreationUserAvatar r37 = r36.c;
        if (r37 == null) goto L112;
        r5 = r37.c;
    L112:
        r9.c.putExtra("avatar_dosame_default_prompt", r5);
        ArrayList r38 = new ArrayList();
        r38.addAll(sq9.g.c(sq9.g.d(r6)));
        r9.c.putExtra("avatar_ref_image", r38);
        r9.e(1000);
        FLogger.a.i("CreationDoSameAbility", "noAvatar so goto create avatar, conversation id: " + r14 + ' ');
        goto L114
    L105:
        if (((Boolean) r8.e.getValue()).booleanValue() == true) goto L107;
    L101:
        r35 = null;
    L106:
        r3 = true;
    L93:
        r32 = null;
        goto L95
    L87:
        r29 = null;
        goto L88
    L83:
        r27 = null;
        goto L84
    L79:
        r25 = null;
        goto L80
    L75:
        r22 = null;
        goto L76
    L71:
        r20 = null;
    L67:
        r2 = null;
        goto L68
    L44:
        if (Intrinsics.areEqual(r7.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L62;
        TplDetail r39 = is9.a.c(r6);
        if (r39 == null) goto L53;
        Integer r40 = r39.a;
        if (r40 == null) goto L53;
        if (r40.intValue() != 2) goto L53;
        boolean r41 = true;
    L54:
        if (r41 == false) goto L62;
        TplDetail r42 = is9.a.c(r6);
        if (r42 == null) goto L58;
        String r43 = r42.i;
    L59:
        if (r43 == null) goto L68;
        r2 = r43;
        goto L68
    L58:
        r43 = null;
    L53:
        r41 = false;
    L62:
        UserCreationContent r44 = r6.e;
        if (r44 == null) goto L67;
        UserCreationUserAvatar r45 = r44.c;
        if (r45 == null) goto L67;
        r2 = r45.c;
    L35:
        r15 = null;
    L114:
        return Unit.INSTANCE;
    L27:
        r14 = null;
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        ILaunchCacheService r110 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r110 == null) goto L13;
        wc9.e r111 = r110.b();
        if (r111 == null) goto L13;
        r14 = r111.a;
    L14:
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        if (r14.length() != 0) goto L19;
        boolean r46 = true;
    L20:
        if (r46 == false) goto L28;
        RepoDispatcher.a.getClass();
        ConversationRepo r112 = RepoDispatcher.f;
        this.label = 1;
        r12 = r112.f(this);
        if (r12 != r0) goto L24;
        return r0;
    L19:
        r46 = false;
    L13:
        r14 = null;
        goto L14
    }
}
