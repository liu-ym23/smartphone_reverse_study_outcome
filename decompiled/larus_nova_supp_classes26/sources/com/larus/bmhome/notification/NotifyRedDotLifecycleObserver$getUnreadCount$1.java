package com.larus.bmhome.notification;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.api.NotificationApi;
import com.larus.bmhome.chat.model.repo.b2;
import com.larus.bmhome.chat.resp.NoticeGroup;
import com.larus.bmhome.chat.resp.UnreadNotificationCount;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.notification.NotifyRedDotLifecycleObserver$getUnreadCount$1", f = "NotifyRedDotLifecycleObserver.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class NotifyRedDotLifecycleObserver$getUnreadCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ NotifyRedDotLifecycleObserver this$0;

    public NotifyRedDotLifecycleObserver$getUnreadCount$1(NotifyRedDotLifecycleObserver r1, String r2, Continuation<? super NotifyRedDotLifecycleObserver$getUnreadCount$1> r3) {
        this.this$0 = r1;
        this.$source = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NotifyRedDotLifecycleObserver$getUnreadCount$1(this.this$0, this.$source, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L19:
        UnreadNotificationCount r6 = (UnreadNotificationCount) r5;
        if (r6 == null) goto L26;
        Map r7 = r6.getUnreadCount();
        if (r7 == null) goto L26;
        Integer r8 = (Integer) r7.get(String.valueOf(NoticeGroup.COMMON.getGroup()));
        if (r8 == null) goto L26;
        int r9 = r8.intValue();
    L27:
        this.this$0.b.getClass();
        b2.b.postValue(Boxing.boxInt(r9));
        com.larus.bmhome.notification.cache.d.a = r9;
        return Unit.INSTANCE;
    L26:
        r9 = 0;
        goto L27
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (AccountService.a.isLogin().booleanValue() == true) goto L13;
        return Unit.INSTANCE;
    L13:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L15;
        FLogger.a.i("NotifyRedDotLifecycleObserver", "getUnreadCount: requesting");
        b2 r10 = this.this$0.b;
        List r2 = CollectionsKt.listOf(Boxing.boxInt(NoticeGroup.COMMON.getGroup()));
        String r3 = this.$source;
        this.label = 1;
        r10.getClass();
        b2.c().getClass();
        r5 = NotificationApi.d(r2, r3, this);
        if (r5 != r0) goto L19;
        return r0;
    L15:
        return Unit.INSTANCE;
    }
}
