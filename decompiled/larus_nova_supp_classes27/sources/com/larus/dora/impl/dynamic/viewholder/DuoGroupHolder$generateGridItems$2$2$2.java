package com.larus.dora.impl.dynamic.viewholder;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.audio.bean.RecommendScene;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.DuoGroupHolder$generateGridItems$2$2$2", f = "DuoGroupHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DuoGroupHolder$generateGridItems$2$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    public DuoGroupHolder$generateGridItems$2$2$2(Context r1, Continuation<? super DuoGroupHolder$generateGridItems$2$2$2> r2) {
        this.$context = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DuoGroupHolder$generateGridItems$2$2$2(this.$context, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        Object r6 = ServiceManager.get().getService(IDoraService.class);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larus.dora.impl.DoraServiceImpl");
        BotModel r7 = ((DoraServiceImpl) r6).F;
        com.bytedance.router.i r0 = SmartRouter.buildRoute(this.$context, "//flow/single_tts_speaker_setting");
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("select_speaker_argument", r7);
        r1[1] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, "bot_setting");
        r1[2] = TuplesKt.to("key_enter_method", "setting");
        r1[3] = TuplesKt.to("key_voice_recommend_param", ni8.a.a(r7, RecommendScene.CHAT_SETTING));
        wc9.e r8 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r8 == null) goto L7;
        String r9 = r8.a;
    L8:
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        r1[4] = TuplesKt.to("conversation_id", r9);
        Bundle r10 = com.larus.utils.f.c(r1);
        r0.c.putExtras(r10);
        r0.c.addFlags(536870912);
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.e(100);
        return Unit.INSTANCE;
    L7:
        r9 = null;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
