package com.larus.bmhome.double_post;

import com.bytedance.keva.Keva;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.d3;
import com.larus.platform.model.NotificationType;
import com.larus.platform.service.AccountService;
import hq9.n3;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.AwemeDoublePostInnerPushManager$showInnerPush$2", f = "AwemeDoublePostInnerPushManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AwemeDoublePostInnerPushManager$showInnerPush$2 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public AwemeDoublePostInnerPushManager$showInnerPush$2(Continuation<? super AwemeDoublePostInnerPushManager$showInnerPush$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        AwemeDoublePostInnerPushManager$showInnerPush$2 r0 = new AwemeDoublePostInnerPushManager$showInnerPush$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((wc9.e) r1, (Continuation) r2);
    }

    public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r25);
        wc9.e r1 = (wc9.e) this.L$0;
        if (r1 == null) goto L22;
        UserSettingCacheManager.a.getClass();
        if (UserSettingCacheManager.h() == false) goto L9;
        String r2 = AppHost.a.getApplication().getString(2131901378);
    L10:
        String r7 = r2;
        Intrinsics.checkNotNull(r7);
        IconImage r3 = r1.b;
        if (r3 == null) goto L15;
        ImageObj r4 = r3.imageThumb;
        if (r4 == null) goto L15;
        String r5 = r4.url;
    L16:
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        n3 r6 = new n3(null, r5, AppHost.a.getApplication().getString(2131901380), r7, NotificationType.AWEME_FEED, 5000, "aweme_feed", null, null, null, null, null, null, null, false, null, false, null, 1048325);
        if (d3.a.c(r6) == false) goto L22;
        AwemeDoublePostInnerPushManager r8 = AwemeDoublePostInnerPushManager.a;
        String r9 = AccountService.a.getUserId();
        ((Keva) AwemeDoublePostInnerPushManager.b.getValue()).storeBoolean("aweme_inner_push_showed_".concat(r9), true);
    L15:
        r5 = null;
        goto L16
    L9:
        r2 = AppHost.a.getApplication().getString(2131901379);
    L22:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
