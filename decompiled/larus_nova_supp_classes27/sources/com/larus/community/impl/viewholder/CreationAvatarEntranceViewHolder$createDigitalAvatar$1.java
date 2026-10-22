package com.larus.community.impl.viewholder;

import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.viewholder.CreationAvatarEntranceViewHolder$createDigitalAvatar$1", f = "CreationAvatarEntranceViewHolder.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
final class CreationAvatarEntranceViewHolder$createDigitalAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationAvatarEntranceViewHolder this$0;

    public CreationAvatarEntranceViewHolder$createDigitalAvatar$1(CreationAvatarEntranceViewHolder r1, Continuation<? super CreationAvatarEntranceViewHolder$createDigitalAvatar$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationAvatarEntranceViewHolder$createDigitalAvatar$1(this.this$0, r3);
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
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L24:
        wc9.e r7 = (wc9.e) r6;
        if (r7 == null) goto L27;
        String r8 = r7.a;
    L28:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/create_digital_avatar");
        r2.c.putExtra("argConversationId", r8);
        r2.c.putExtra("need_router_to_chat", true);
        r2.c.putExtra("is_from_template", "0");
        r2.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "ai_generate_suggest_create_avatar");
        r2.c.putExtra("click_from", "ai_generate_suggest_create_avatar");
        r2.c.putExtra("click_create_replica_current_page", "template_page");
        r2.c.putExtra("enter_create_from", "from_private_profile_avatar_manage");
        zp9.f r9 = this.this$0.g;
        if (r9 == null) goto L33;
        zp9.g r10 = r9.e;
        if (r10 == null) goto L33;
        String r11 = r10.h;
    L34:
        r2.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r11);
        zp9.f r12 = this.this$0.g;
        if (r12 == null) goto L39;
        zp9.g r13 = r12.e;
        if (r13 == null) goto L39;
        String r14 = r13.c;
    L40:
        r2.c.putExtra("bot_id", r14);
        zp9.f r15 = this.this$0.g;
        if (r15 == null) goto L45;
        zp9.g r16 = r15.e;
        if (r16 == null) goto L45;
        r3 = r16.f;
    L45:
        r2.c.putExtra("chat_type", r3);
        r2.c.putExtra("ai_creation_recommend_from", "action_bar_template");
        r2.d();
        return Unit.INSTANCE;
    L39:
        r14 = null;
    L33:
        r11 = null;
        goto L34
    L27:
        r8 = null;
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ILaunchCacheService r17 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r17 == null) goto L13;
        wc9.e r18 = r17.b();
        if (r18 == null) goto L13;
        r8 = r18.a;
    L14:
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        if (r8.length() != 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L28;
        IConversationRepoService r20 = RepoDispatcherDelegate.b.f();
        this.label = 1;
        r6 = r20.f(this);
        if (r6 != r0) goto L24;
        return r0;
    L19:
        r4 = false;
    L13:
        r8 = null;
        goto L14
    }
}
