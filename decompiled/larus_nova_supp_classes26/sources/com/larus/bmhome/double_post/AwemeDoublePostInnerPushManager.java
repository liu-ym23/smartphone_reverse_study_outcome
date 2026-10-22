package com.larus.bmhome.double_post;

import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AwemeDoublePostInnerPushManager {
    public static final AwemeDoublePostInnerPushManager a = null;
    public static final Lazy b = null;

    public AwemeDoublePostInnerPushManager() {
    }

    static {
        a = new AwemeDoublePostInnerPushManager();
        b = LazyKt.lazy(new a());
    }

    public final Object b(Continuation<? super Unit> r4) {
        if ((!((Keva) b.getValue()).getBoolean("aweme_inner_push_showed_".concat(AccountService.a.getUserId()), false)) == false) goto L14;
        Object r5 = a(new AwemeDoublePostInnerPushManager$showInnerPush$2(null), r4);
        if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        r5 = Unit.INSTANCE;
    L9:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r5;
    L12:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    }

    public final Object a(Function2<? super wc9.e, ? super Continuation<? super Unit>, ? extends Object> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1) == false) goto L7;
        AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1 r0 = (AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L24:
        wc9.e r11 = (wc9.e) r10;
    L25:
        r0.L$0 = null;
        r0.label = 2;
        if (r8.invoke(r11, r0) != r2) goto L29;
        return r2;
    L16:
        ResultKt.throwOnFailure(r10);
        ILaunchCacheService r12 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r12 == null) goto L21;
        r11 = r12.b();
        if (r11 == null) goto L21;
        FLogger.a.i("AwemeDoublePostInnerPushManager", "use lastCachedConversationInfo");
    L21:
        Flow r13 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2 r4 = new AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2(null);
        r0.L$0 = r8;
        r0.label = 1;
        r10 = kotlinx.coroutines.flow.e.t(r13, r4, r0);
        if (r10 != r2) goto L24;
        return r2;
    L7:
        r0 = new AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1(this, r9);
        goto L8
    }
}
