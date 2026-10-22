package com.larus.bmhome.notification.cache;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.NotificationList;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.notification.cache.NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1", f = "NotifyTabCacheManager.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
final class NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $interval;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.notification.cache.NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.cache.NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1$1", f = "NotifyTabCacheManager.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $interval;
        int label;

        public AnonymousClass1(long r1, Continuation<? super AnonymousClass1> r3) {
            this.$interval = r1;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$interval, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.$interval;
            this.label = 1;
            if (DelayKt.delay(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1(long r1, Continuation<? super NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1> r3) {
        this.$interval = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NotifyTabCacheManager$tryStartLoadNotificationListFromCache$1(this.$interval, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> r14 = d.c;
        if (r14 == null) goto L80;
        long r2 = this.$interval;
        Triple r15 = (Triple) r14.getValue();
        if (r15 == null) goto L16;
        com.larus.network.http.a r4 = (com.larus.network.http.a) r15.getFirst();
    L18:
        if ((r4 instanceof y) == true) goto L80;
        FLogger.a.i("NotifyTabCacheManager", "tryStartLoadNotificationListFromCache: result is not Success, result = " + r15);
        e10 r5 = e10.a;
        int r6 = 0;
        if (e10.x0().b() == false) goto L54;
        AccountService r7 = AccountService.a;
        String r8 = r7.getUserId().concat("_notify_list_data");
        Lazy r9 = d.b;
        if (((Keva) r9.getValue()).contains(r8) == false) goto L54;
        String r10 = "";
        String r11 = ((Keva) r9.getValue()).getString(r7.getUserId().concat("_notify_list_data"), "");
        if (r11 == null) goto L81;
        r10 = r11;
    L81:
    L36:
        e = move-exception;
        FLogger.a.e("NotifyTabCacheManager", "getNoticeList: error", e);
    L38:
        NotificationList r12 = null;
    L39:
        if (r12 == null) goto L50;
        List r16 = r12.getNoticeList();
        if (r16 == null) goto L50;
        List r17 = CollectionsKt.filterNotNull(r16);
        if (r17 == null) goto L50;
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L46:
        if (r18.hasNext() == false) goto L51;
        if (((Notice) r18.next()).getHasRead() == true) goto L46;
        r19 = r19 + 1;
    L51:
        int r20 = d.a;
        if (r19 == r20) goto L55;
        FLogger.a.i("NotifyTabCacheManager", "tryLoadNotificationListFromCache: cacheNoticeListUnreadCount = " + r19 + " != currentTabUnreadCount = " + r20 + ", ");
    L55:
        if (r12 == null) goto L67;
        MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> r21 = d.c;
        if (r21 == null) goto L67;
        y r22 = new y(r12, null, 14);
        if (r15 == null) goto L61;
        boolean r23 = ((Boolean) r15.getSecond()).booleanValue();
    L62:
        Boolean r24 = Boxing.boxBoolean(r23);
        if (r15 == null) goto L65;
        boolean r110 = ((Boolean) r15.getThird()).booleanValue();
    L66:
        r21.postValue(new Triple(r22, r24, Boxing.boxBoolean(r110)));
        goto L67
    L65:
        r110 = false;
        goto L66
    L61:
        r23 = false;
    L67:
        int r111 = com.larus.bmhome.notification.util.a.a;
        Long r25 = Boxing.boxLong(r2);
        if (r12 == null) goto L74;
        List r112 = r12.getNoticeList();
        if (r112 == null) goto L74;
        List r113 = CollectionsKt.filterNotNull(r112);
        if (r113 == null) goto L74;
        r6 = r113.size();
    L74:
        Integer r26 = Boxing.boxInt(r6);
        Integer r114 = Boxing.boxInt(d.a);
        if (r12 == null) goto L77;
        String r115 = "1";
    L78:
        com.larus.bmhome.notification.util.a.a("consume", "1", r25, r26, r114, r115);
        goto L80
    L77:
        r115 = TriggerSendLoading.NO_LOADING;
    L50:
        r19 = 0;
        goto L51
    L30:
        if (r10.length() > 0) goto L33;
        r3 = false;
    L33:
        if (r3 == false) goto L38;
        r12 = (NotificationList) new Gson().fromJson(r10, NotificationList.class);     // Catch: Exception -> L36
    L54:
        r12 = null;
        goto L55
    L16:
        r4 = null;
    L80:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r116 = Dispatchers.getIO();
        AnonymousClass1 r27 = new AnonymousClass1(this.$interval, null);
        this.label = 1;
        if (BuildersKt.withContext(r116, r27, this) != r0) goto L11;
        return r0;
    }
}
