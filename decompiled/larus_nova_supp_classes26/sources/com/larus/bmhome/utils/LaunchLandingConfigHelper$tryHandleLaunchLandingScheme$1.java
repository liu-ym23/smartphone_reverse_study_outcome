package com.larus.bmhome.utils;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.LaunchLandingConfigHelper$tryHandleLaunchLandingScheme$1", f = "LaunchLandingConfigHelper.kt", i = {1}, l = {126, 140}, m = "invokeSuspend", n = {"convInfo"}, s = {"L$0"})
public final class LaunchLandingConfigHelper$tryHandleLaunchLandingScheme$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $landingSchema;
    Object L$0;
    int label;
    final /* synthetic */ LaunchLandingConfigHelper this$0;

    public LaunchLandingConfigHelper$tryHandleLaunchLandingScheme$1(String r1, LaunchLandingConfigHelper r2, String r3, Context r4, Continuation<? super LaunchLandingConfigHelper$tryHandleLaunchLandingScheme$1> r5) {
        this.$botId = r1;
        this.this$0 = r2;
        this.$landingSchema = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LaunchLandingConfigHelper$tryHandleLaunchLandingScheme$1(this.$botId, this.this$0, this.$landingSchema, this.$context, r8);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        q3 r2 = (q3) this.L$0;
        ResultKt.throwOnFailure(r9);
    L22:
        BotModel r3 = (BotModel) r9;
        q3 r10 = r2;
    L23:
        i r4 = SmartRouter.buildRoute(this.$context, "//flow/chat_page");
        Pair[] r5 = new Pair[8];
        r5[0] = TuplesKt.to("landing_channel", ChatLandingChannel.UGC_LANDING.getChannel());
        r5[1] = TuplesKt.to("argConversationId", r10.a);
        Boolean r11 = null;
        if (r3 == null) goto L26;
        String r6 = r3.getBgImgUrl();
    L27:
        r5[2] = TuplesKt.to("argCvsBgImgUrl", r6);
        if (r3 == null) goto L30;
        String r7 = r3.getBgImgColor();
    L31:
        r5[3] = TuplesKt.to("argCvsBgImgColor", r7);
        if (r3 == null) goto L34;
        r11 = Boxing.boxBoolean(r3.getBgImgOpen());
    L34:
        r5[4] = TuplesKt.to("argCvsBgImgOpen", r11);
        r5[5] = TuplesKt.to("enter_method", "landing_page");
        r5[6] = TuplesKt.to("argPreviousPage", "chat_list");
        r5[7] = TuplesKt.to("is_from_ug", Boxing.boxBoolean(true));
        r4.c.putExtras(com.larus.utils.f.c(r5));
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
        LaunchLandingConfigHelper r12 = this.this$0;
        String r8 = this.$landingSchema;
        r12.getClass();
        LaunchLandingConfigHelper.f(r8, "success");
    L36:
        return Unit.INSTANCE;
    L30:
        r7 = null;
        goto L31
    L26:
        r6 = null;
        goto L27
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        r10 = (q3) r9;
        if ((r10.b instanceof com.larus.network.http.f) == false) goto L16;
        FLogger.a.e("BotUtils", "ConversationPageFragment findOrCreateConversationByBot Failed !!");
        LaunchLandingConfigHelper r13 = this.this$0;
        String r14 = this.$landingSchema;
        r13.getClass();
        LaunchLandingConfigHelper.f(r14, "fail");
        goto L36
    L16:
        FLogger.a.d("BotUtils", "safeNavigate -> " + r10.a);
        r3 = (BotModel) BotInfoCache.INSTANCE.get(r10.a);
        if (r3 != null) goto L23;
        RepoDispatcher.a.getClass();
        BotRepo r15 = RepoDispatcher.g;
        String r16 = r10.a;
        this.L$0 = r10;
        this.label = 2;
        Object r17 = r15.j1(r16, false, this);
        if (r17 != r0) goto L21;
        return r0;
    L21:
        r2 = r10;
        r9 = r17;
        goto L22
    L10:
        ResultKt.throwOnFailure(r9);
        FLogger.a.d("BotUtils", "ConversationPageFragment findOrCreateConversationByBot");
        LaunchLandingConfigHelperDelegate r18 = LaunchLandingConfigHelperDelegate.b;
        String r19 = this.$botId;
        this.label = 1;
        r9 = r18.d(r19, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
