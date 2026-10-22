package com.larus.profile.impl.creation;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoUserContent;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$jumpToAvatar2VideoDoSame$1", f = "CreationDoSameAbility.kt", i = {}, l = {600}, m = "invokeSuspend", n = {}, s = {})
final class CreationDoSameAbility$jumpToAvatar2VideoDoSame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ UserCreation $userCreation;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$jumpToAvatar2VideoDoSame$1(CreationDoSameAbility r1, UserCreation r2, sq9.p r3, Continuation<? super CreationDoSameAbility$jumpToAvatar2VideoDoSame$1> r4) {
        this.this$0 = r1;
        this.$userCreation = r2;
        this.$doSameInitParams = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDoSameAbility$jumpToAvatar2VideoDoSame$1(this.this$0, this.$userCreation, this.$doSameInitParams, r5);
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
        String r4 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L24:
        wc9.e r12 = (wc9.e) r11;
        if (r12 == null) goto L27;
        String r13 = r12.a;
    L28:
        CreationDoSameAbility r2 = this.this$0;
        UserCreation r3 = this.$userCreation;
        sq9.p r5 = this.$doSameInitParams;
        int r6 = CreationDoSameAbility.f;
        r2.getClass();
        CreationDoSameAbility.v(r3, r5);
        Context r7 = this.this$0.a.getContext();
        if (r7 == null) goto L69;
        UserCreation r8 = this.$userCreation;
        sq9.p r9 = this.$doSameInitParams;
        CreationDoSameAbility r10 = this.this$0;
        com.bytedance.router.i r14 = SmartRouter.buildRoute(r7, "//flow/create_digital_avatar");
        r14.c.putExtra("argConversationId", r13);
        UserCreationContent r15 = r8.e;
        if (r15 == null) goto L35;
        VideoUserContent r16 = r15.e;
        if (r16 == null) goto L35;
        String r17 = r16.d;
    L36:
        r14.c.putExtra("actionbar_instruction_prompt", r17);
        r14.c.putExtra("need_router_to_chat", true);
        JSONObject r18 = new JSONObject();
        UserCreation r19 = r9.d;
        if (r19 == null) goto L39;
        String r20 = r19.a;
    L40:
        r18.put("id", r20);
        r18.put("recommend_from", r9.g);
        UserCreationTrackParams r21 = r8.n;
        if (r21 == null) goto L43;
        String r22 = r21.a;
    L44:
        r18.put("template_rec_req_id", r22);
        r18.put("template_rec_extra", r8.i);
        r18.put("from_template_id", r8.a);
        r18.put("tpl_tag_type", r8.q(false));
        r18.put("tpl_button_type", sq9.q.a(r9.l, r8, false, r9.m));
        Unit r23 = Unit.INSTANCE;
        r14.c.putExtra("creation_template", r18.toString());
        r14.c.putExtra("enter_method", r9.c);
        r14.c.putExtra("click_from", "use_template");
        r14.c.putExtra("click_create_replica_template_page_type", r9.n);
        r14.c.putExtra("click_create_replica_current_page", "template_page");
        UserCreationTrackParams r24 = r8.n;
        if (r24 == null) goto L47;
        String r25 = r24.d;
    L48:
        r14.c.putExtra("ai_generate_tab_id", r25);
        UserCreationTrackParams r26 = r8.n;
        if (r26 == null) goto L51;
        String r27 = r26.e;
    L52:
        r14.c.putExtra("ai_generate_tab_name", r27);
        UserCreationTrackParams r28 = r8.n;
        if (r28 == null) goto L55;
        String r29 = r28.f;
    L56:
        r14.c.putExtra("ai_generate_tab_type", r29);
        r14.c.putExtra("from_template_sub_type", zp9.d.c(r8));
        r14.c.putExtra("is_has_caption", String.valueOf(r8.z()));
        r14.c.putExtra("is_image_reference_public", String.valueOf(r8.D()));
        r14.c.putExtra("ai_creation_recommend_from", r9.g);
        r14.c.putExtra("previous_page", r9.b);
        r14.c.putExtra("is_from_avatar_creation", true);
        r14.c.putExtra("enter_create_from", "from_avatar_creation_dosame");
        r14.c.putExtra("select_instruction_type", 18);
        UserCreationContent r30 = r8.e;
        if (r30 == null) goto L61;
        VideoUserContent r31 = r30.e;
        if (r31 == null) goto L61;
        String r32 = r31.d;
    L62:
        r14.c.putExtra("avatar_dosame_default_prompt", r32);
        UserCreationContent r33 = r8.e;
        if (r33 == null) goto L67;
        VideoUserContent r34 = r33.e;
        if (r34 == null) goto L67;
        r4 = r34.h;
    L67:
        r14.c.putExtra("key_video_internal_resource", r4);
        r10.getClass();
        r14.c.putExtra("key_is_creation_private", CreationDoSameAbility.v(r8, r9));
        ArrayList r35 = new ArrayList();
        r35.addAll(sq9.g.c(sq9.g.d(r8)));
        r14.c.putExtra("avatar_ref_image", r35);
        r14.e(1000);
        FLogger.a.i("CreationDoSameAbility", "noAvatar so goto create avatar, conversation id: " + r13 + ' ');
    L61:
        r32 = null;
        goto L62
    L55:
        r29 = null;
        goto L56
    L51:
        r27 = null;
        goto L52
    L47:
        r25 = null;
        goto L48
    L43:
        r22 = null;
        goto L44
    L39:
        r20 = null;
    L35:
        r17 = null;
    L69:
        return Unit.INSTANCE;
    L27:
        r13 = null;
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ILaunchCacheService r110 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r110 == null) goto L13;
        wc9.e r111 = r110.b();
        if (r111 == null) goto L13;
        r13 = r111.a;
    L14:
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        if (r13.length() != 0) goto L19;
        boolean r36 = true;
    L20:
        if (r36 == false) goto L28;
        RepoDispatcher.a.getClass();
        ConversationRepo r112 = RepoDispatcher.f;
        this.label = 1;
        r11 = r112.f(this);
        if (r11 != r0) goto L24;
        return r0;
    L19:
        r36 = false;
    L13:
        r13 = null;
        goto L14
    }
}
