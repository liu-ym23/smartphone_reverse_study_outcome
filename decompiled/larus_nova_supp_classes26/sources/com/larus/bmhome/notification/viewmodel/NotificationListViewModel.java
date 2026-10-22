package com.larus.bmhome.notification.viewmodel;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.NotificationApi;
import com.larus.bmhome.chat.model.repo.b2;
import com.larus.bmhome.chat.resp.NoticeGroup;
import com.larus.bmhome.chat.resp.NotificationList;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.notification.cache.c;
import com.larus.bmhome.notification.cache.d;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.f;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 R2\u00020\u0001:\u0001RB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u0012J\u0015\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010;J&\u0010<\u001a\u0002092\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0002J\u001a\u0010=\u001a\u0002092\b\b\u0002\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0002J\u0012\u0010>\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000105J\u0014\u0010?\u001a\u0002092\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0002J\b\u0010@\u001a\u000209H\u0002J\u0015\u0010A\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010BJ\u0015\u0010C\u001a\u0002032\b\u0010D\u001a\u0004\u0018\u00010E¢\u0006\u0002\u0010FJ/\u0010G\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010D\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u000203J\u0006\u0010J\u001a\u00020EJ\b\u0010K\u001a\u000203H\u0014J\u0010\u0010L\u001a\u0002032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0006\u0010M\u001a\u00020\u0012J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J\b\u0010P\u001a\u00020\u0017H\u0002J\b\u0010Q\u001a\u00020\u0017H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0010\u001a\"\u0012\u001e\u0012\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR1\u0010\u0014\u001a\"\u0012\u001e\u0012\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f0\u00150\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 ¨\u0006S"}, d2 = {"Lcom/larus/bmhome/notification/viewmodel/NotificationListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "arguments", "Landroid/os/Bundle;", "repo", "Lcom/larus/bmhome/chat/model/repo/NotificationRepo;", "loadMoreNotificationListData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/chat/resp/NotificationList;", "getLoadMoreNotificationListData", "()Landroidx/lifecycle/MutableLiveData;", "refreshNotificationListData", "Lkotlin/Triple;", "", "getRefreshNotificationListData", "deleteNoticeLiveData", "Lkotlin/Pair;", "", "", "", "getDeleteNoticeLiveData", "refreshing", "loadingMore", "lastReadTime", "getLastReadTime", "()J", "setLastReadTime", "(J)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "nextCursor", "getNextCursor", "setNextCursor", "contentModifyVersion", "", "getContentModifyVersion", "()Ljava/lang/String;", "setContentModifyVersion", "(Ljava/lang/String;)V", "leaveNotifyTimestamp", "getLeaveNotifyTimestamp", "setLeaveNotifyTimestamp", "refreshNotificationList", "", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "showRetryPage", "fromResume", "deleteNotice", "Lkotlinx/coroutines/Job;", "noticeId", "(Ljava/lang/Long;)Lkotlinx/coroutines/Job;", "refreshNormalNotificationList", "refreshAggNotificationList", "loadMoreNotificationList", "loadMoreNormalNotificationList", "loadMoreAggNotificationList", "markSingleRead", "(Ljava/lang/Long;)V", "markTotalRead", "markCount", "", "(Ljava/lang/Integer;)V", "markRead", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lkotlinx/coroutines/Job;", "clearUnreadNotificationCount", "getUnreadNotificationCount", "onCleared", "init", "isAggNotificationPage", "getType", "getAggNoticeId", "getNoticeGroup", "getBotId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationListViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final int PAGE_SIZE = 20;
    private static final String TAG = "NotificationListViewModel";
    private Bundle arguments;
    private String contentModifyVersion;
    private final MutableLiveData<Pair<List<Long>, com.larus.network.http.a<Object>>> deleteNoticeLiveData;
    private boolean hasMore;
    private long lastReadTime;
    private long leaveNotifyTimestamp;
    private final MutableLiveData<com.larus.network.http.a<NotificationList>> loadMoreNotificationListData;
    private boolean loadingMore;
    private long nextCursor;
    private final MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> refreshNotificationListData;
    private boolean refreshing;
    private final b2 repo;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.NotificationListViewModel$deleteNotice$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.NotificationListViewModel$deleteNotice$1", f = "NotificationListViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $noticeId;
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        public AnonymousClass1(Long r1, NotificationListViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$noticeId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$noticeId, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L16:
            MutableLiveData<Pair<List<Long>, com.larus.network.http.a<Object>>> r2 = this.this$0.getDeleteNoticeLiveData();
            List r3 = CollectionsKt.listOf(this.$noticeId);
            r2.postValue(new Pair(r3, (com.larus.network.http.a) r8));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Long r9 = this.$noticeId;
            if (r9 == null) goto L19;
            if (r9.longValue() < 0) goto L19;
            b2 r10 = NotificationListViewModel.access$getRepo$p(this.this$0);
            Long r4 = this.$noticeId;
            this.label = 1;
            r10.getClass();
            NotificationApi r11 = b2.c();
            List r5 = CollectionsKt.listOf(r4);
            r11.getClass();
            r8 = NotificationApi.a(r5, this);
            if (r8 != r0) goto L16;
            return r0;
        L19:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.NotificationListViewModel$loadMoreAggNotificationList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.NotificationListViewModel$loadMoreAggNotificationList$1", f = "NotificationListViewModel.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        public C01471(NotificationListViewModel r1, Continuation<? super C01471> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01471(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L24:
            this.this$0.getLoadMoreNotificationListData().postValue((com.larus.network.http.a) r1);
            NotificationListViewModel.access$setLoadingMore$p(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            if (NotificationListViewModel.access$getLoadingMore$p(this.this$0) == false) goto L11;
        L26:
            FLogger.a.i(NotificationListViewModel.TAG, "loadMoreAggNotificationList: loadingMore = " + NotificationListViewModel.access$getLoadingMore$p(this.this$0) + ", hasMore = " + this.this$0.getHasMore());
            return Unit.INSTANCE;
        L11:
            if (this.this$0.getHasMore() == false) goto L26;
            if (NetworkUtils.isNetworkAvailable(this.this$0.getApplication()) == true) goto L17;
            MutableLiveData<com.larus.network.http.a<NotificationList>> r2 = this.this$0.getLoadMoreNotificationListData();
            AsyncThrowable.Companion.getClass();
            r2.postValue(new f(AsyncThrowable.access$getDEFAULT$cp(), null));
            return Unit.INSTANCE;
        L17:
            NotificationListViewModel.access$setLoadingMore$p(this.this$0, true);
            this.this$0.getLoadMoreNotificationListData().postValue(new w(null));
            if (this.this$0.getNextCursor() <= 0) goto L20;
            long r3 = this.this$0.getNextCursor();
        L21:
            FLogger.a.i(NotificationListViewModel.TAG, "loadMoreAggNotificationList: requesting... nextCursor = " + r3);
            b2 r4 = NotificationListViewModel.access$getRepo$p(this.this$0);
            long r5 = NotificationListViewModel.access$getAggNoticeId(this.this$0);
            long r7 = NotificationListViewModel.access$getNoticeGroup(this.this$0);
            long r9 = NotificationListViewModel.access$getBotId(this.this$0);
            String r12 = NotificationListViewModel.access$getType(this.this$0);
            this.label = 1;
            r4.getClass();
            b2.c().getClass();
            r1 = NotificationApi.b(r3, false, r5, r7, r9, r12, this);
            if (r1 != r11) goto L24;
            return r11;
        L20:
            r3 = System.currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.NotificationListViewModel$loadMoreNormalNotificationList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.NotificationListViewModel$loadMoreNormalNotificationList$1", f = "NotificationListViewModel.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        public C01481(NotificationListViewModel r1, DowngradeSource r2, Continuation<? super C01481> r3) {
            this.this$0 = r1;
            this.$downgradeSource = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01481(this.this$0, this.$downgradeSource, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L24:
            this.this$0.getLoadMoreNotificationListData().postValue((com.larus.network.http.a) r12);
            NotificationListViewModel.access$setLoadingMore$p(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            if (NotificationListViewModel.access$getLoadingMore$p(this.this$0) == false) goto L11;
        L26:
            FLogger.a.i(NotificationListViewModel.TAG, "loadMoreNotificationList: loadingMore = " + NotificationListViewModel.access$getLoadingMore$p(this.this$0) + ", hasMore = " + this.this$0.getHasMore());
            return Unit.INSTANCE;
        L11:
            if (this.this$0.getHasMore() == false) goto L26;
            if (NetworkUtils.isNetworkAvailable(this.this$0.getApplication()) == true) goto L17;
            MutableLiveData<com.larus.network.http.a<NotificationList>> r13 = this.this$0.getLoadMoreNotificationListData();
            AsyncThrowable.Companion.getClass();
            r13.postValue(new f(AsyncThrowable.access$getDEFAULT$cp(), null));
            return Unit.INSTANCE;
        L17:
            NotificationListViewModel.access$setLoadingMore$p(this.this$0, true);
            this.this$0.getLoadMoreNotificationListData().postValue(new w(null));
            if (this.this$0.getNextCursor() <= 0) goto L20;
            long r3 = this.this$0.getNextCursor();
        L21:
            long r5 = r3;
            FLogger.a.i(NotificationListViewModel.TAG, "loadMoreNotificationList: requesting... nextCursor = " + r5);
            b2 r14 = NotificationListViewModel.access$getRepo$p(this.this$0);
            DowngradeSource r8 = this.$downgradeSource;
            this.label = 1;
            b2 r2 = b2.a;
            r14.getClass();
            b2.c().getClass();
            r12 = NotificationApi.c(r5, false, r8, false, this);
            if (r12 != r0) goto L24;
            return r0;
        L20:
            r3 = System.currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.NotificationListViewModel$markRead$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.NotificationListViewModel$markRead$1", f = "NotificationListViewModel.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $lastReadTime;
        final /* synthetic */ Integer $markCount;
        final /* synthetic */ Long $noticeId;
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        public C01491(NotificationListViewModel r1, Long r2, Long r3, Integer r4, Continuation<? super C01491> r5) {
            this.this$0 = r1;
            this.$noticeId = r2;
            this.$lastReadTime = r3;
            this.$markCount = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01491(this.this$0, this.$noticeId, this.$lastReadTime, this.$markCount, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            FLogger.a.i(NotificationListViewModel.TAG, "markRead: requesting");
            b2 r8 = NotificationListViewModel.access$getRepo$p(this.this$0);
            int r2 = NoticeGroup.COMMON.getGroup();
            Long r3 = this.$noticeId;
            Long r4 = this.$lastReadTime;
            Integer r5 = this.$markCount;
            this.label = 1;
            r8.getClass();
            b2.c().getClass();
            if (NotificationApi.e(r2, r3, r4, r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.NotificationListViewModel$refreshAggNotificationList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.NotificationListViewModel$refreshAggNotificationList$1", f = "NotificationListViewModel.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $fromResume;
        final /* synthetic */ boolean $showRetryPage;
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        public C01501(NotificationListViewModel r1, boolean r2, boolean r3, Continuation<? super C01501> r4) {
            this.this$0 = r1;
            this.$showRetryPage = r2;
            this.$fromResume = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01501(this.this$0, this.$showRetryPage, this.$fromResume, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L15:
            this.this$0.getRefreshNotificationListData().postValue(new Triple((com.larus.network.http.a) r1, Boxing.boxBoolean(this.$showRetryPage), Boxing.boxBoolean(this.$fromResume)));
            NotificationListViewModel.access$setRefreshing$p(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            if (NotificationListViewModel.access$getRefreshing$p(this.this$0) == false) goto L12;
            FLogger.a.i(NotificationListViewModel.TAG, "refreshNotificationAggList: refreshing");
            return Unit.INSTANCE;
        L12:
            NotificationListViewModel.access$setRefreshing$p(this.this$0, true);
            long r3 = System.currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
            FLogger.a.i(NotificationListViewModel.TAG, "refreshNotificationAggList: requesting... nextCursor = " + r3);
            b2 r2 = NotificationListViewModel.access$getRepo$p(this.this$0);
            long r5 = NotificationListViewModel.access$getAggNoticeId(this.this$0);
            long r7 = NotificationListViewModel.access$getNoticeGroup(this.this$0);
            long r9 = NotificationListViewModel.access$getBotId(this.this$0);
            String r12 = NotificationListViewModel.access$getType(this.this$0);
            this.label = 1;
            r2.getClass();
            b2.c().getClass();
            r1 = NotificationApi.b(r3, true, r5, r7, r9, r12, this);
            if (r1 != r11) goto L15;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.NotificationListViewModel$refreshNormalNotificationList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.NotificationListViewModel$refreshNormalNotificationList$1", f = "NotificationListViewModel.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        final /* synthetic */ boolean $fromResume;
        final /* synthetic */ boolean $showRetryPage;
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        public C01511(NotificationListViewModel r1, boolean r2, boolean r3, DowngradeSource r4, Continuation<? super C01511> r5) {
            this.this$0 = r1;
            this.$showRetryPage = r2;
            this.$fromResume = r3;
            this.$downgradeSource = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01511(this.this$0, this.$showRetryPage, this.$fromResume, this.$downgradeSource, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L15:
            com.larus.network.http.a r15 = (com.larus.network.http.a) r14;
            this.this$0.getRefreshNotificationListData().postValue(new Triple(r15, Boxing.boxBoolean(this.$showRetryPage), Boxing.boxBoolean(this.$fromResume)));
            int r2 = d.a;
            Intrinsics.checkNotNullParameter(r15, "asyncResp");
            e10 r3 = e10.a;
            if (e10.x0().b() == false) goto L21;
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("saveNotificationList... asyncResp is Success = ");
            boolean r6 = r15 instanceof y;
            r5.append(r6);
            r4.i("NotifyTabCacheManager", r5.toString());
            if (r6 == false) goto L21;
            final NotificationList r16 = (NotificationList) r15.b;
            t0.a(new c(r16));
        L21:
            NotificationListViewModel.access$setRefreshing$p(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            if (NotificationListViewModel.access$getRefreshing$p(this.this$0) == false) goto L12;
            FLogger.a.i(NotificationListViewModel.TAG, "refreshNotificationList: refreshing");
            return Unit.INSTANCE;
        L12:
            NotificationListViewModel.access$setRefreshing$p(this.this$0, true);
            this.this$0.getRefreshNotificationListData().postValue(new Triple(new w(null), Boxing.boxBoolean(this.$showRetryPage), Boxing.boxBoolean(this.$fromResume)));
            long r7 = System.currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
            FLogger.a.i(NotificationListViewModel.TAG, "refreshNotificationList: requesting... nextCursor = " + r7);
            b2 r17 = NotificationListViewModel.access$getRepo$p(this.this$0);
            DowngradeSource r10 = this.$downgradeSource;
            this.label = 1;
            r17.getClass();
            b2.c().getClass();
            r14 = NotificationApi.c(r7, true, r10, true, this);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isAggNotificationPage() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r2 = this.arguments;     // Catch: Throwable -> L7
        if (r2 == null) goto L12;
        return r2.getBoolean("is_agg_notification_page");
    L12:
        return false;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return false;
    }

    private final long getAggNoticeId() {
        Bundle r0 = this.arguments;
        if (r0 == null) goto L9;
        String r1 = r0.getString("notice_id");
        if (r1 == null) goto L9;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    private final long getBotId() {
        Bundle r0 = this.arguments;
        if (r0 == null) goto L9;
        String r1 = r0.getString("bot_id");
        if (r1 == null) goto L9;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    private final long getNoticeGroup() {
        Bundle r0 = this.arguments;
        if (r0 == null) goto L9;
        String r1 = r0.getString("notice_group");
        if (r1 == null) goto L9;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    private final String getType() {
        Bundle r0 = this.arguments;
        if (r0 == null) goto L6;
        String r1 = r0.getString("notice_type");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void clearUnreadNotificationCount() {
        this.repo.getClass();
        b2.b.postValue(0);
    }

    public final int getUnreadNotificationCount() {
        this.repo.getClass();
        Integer r0 = (Integer) b2.b.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    private final Job loadMoreAggNotificationList() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01471(this, null), 3, null);
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        int r0 = d.a;
        FLogger.a.i("NotifyTabCacheManager", "onDestroy...");
        MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> r1 = d.c;
        if (r1 == null) goto L6;
        r1.removeObserver(d.d);
        return;
    }

    public final String getContentModifyVersion() {
        return this.contentModifyVersion;
    }

    public final MutableLiveData<Pair<List<Long>, com.larus.network.http.a<Object>>> getDeleteNoticeLiveData() {
        return this.deleteNoticeLiveData;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getLastReadTime() {
        return this.lastReadTime;
    }

    public final long getLeaveNotifyTimestamp() {
        return this.leaveNotifyTimestamp;
    }

    public final MutableLiveData<com.larus.network.http.a<NotificationList>> getLoadMoreNotificationListData() {
        return this.loadMoreNotificationListData;
    }

    public final long getNextCursor() {
        return this.nextCursor;
    }

    public final MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> getRefreshNotificationListData() {
        return this.refreshNotificationListData;
    }

    public NotificationListViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.repo = b2.a;
        this.loadMoreNotificationListData = new MutableLiveData();
        this.refreshNotificationListData = new MutableLiveData();
        this.deleteNoticeLiveData = new MutableLiveData();
        this.contentModifyVersion = "";
    }

    public static final /* synthetic */ long access$getAggNoticeId(NotificationListViewModel r2) {
        return r2.getAggNoticeId();
    }

    public static final /* synthetic */ long access$getBotId(NotificationListViewModel r2) {
        return r2.getBotId();
    }

    public static final /* synthetic */ boolean access$getLoadingMore$p(NotificationListViewModel r0) {
        return r0.loadingMore;
    }

    public static final /* synthetic */ long access$getNoticeGroup(NotificationListViewModel r2) {
        return r2.getNoticeGroup();
    }

    public static final /* synthetic */ boolean access$getRefreshing$p(NotificationListViewModel r0) {
        return r0.refreshing;
    }

    public static final /* synthetic */ b2 access$getRepo$p(NotificationListViewModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ String access$getType(NotificationListViewModel r0) {
        return r0.getType();
    }

    private final Job loadMoreNormalNotificationList(DowngradeSource r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01481(this, r7, null), 3, null);
    }

    public final Job deleteNotice(Long r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r7, this, null), 3, null);
    }

    public final void init(Bundle r4) {
        this.arguments = r4;
        this.leaveNotifyTimestamp = 0;
        int r5 = d.a;
        MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> r6 = this.refreshNotificationListData;
        Intrinsics.checkNotNullParameter(r6, "refreshNotificationListData");
        FLogger r0 = FLogger.a;
        r0.i("NotifyTabCacheManager", "init...");
        e10 r1 = e10.a;
        if (e10.x0().b() == true) goto L5;
        r0.i("NotifyTabCacheManager", "init: noticeListCacheEnable is false");
        return;
    L5:
        d.c = r6;
        if (r6 == null) goto L10;
        r6.observeForever(d.d);
        return;
    }

    public final void loadMoreNotificationList(DowngradeSource r2) {
        if (isAggNotificationPage() == false) goto L5;
        loadMoreAggNotificationList();
        return;
    L5:
        loadMoreNormalNotificationList(r2);
    }

    public final void markSingleRead(Long r3) {
        if (isAggNotificationPage() == false) goto L5;
        return;
    L5:
        markRead(r3, Long.valueOf(this.lastReadTime), 1);
    }

    public final void markTotalRead(Integer r3) {
        if (isAggNotificationPage() == false) goto L5;
        return;
    L5:
        markRead(null, Long.valueOf(this.lastReadTime), r3);
        this.repo.getClass();
        b2.b.postValue(0);
        int r4 = d.a;
        d.a = 0;
    }

    public final void setContentModifyVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentModifyVersion = r2;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setLastReadTime(long r1) {
        this.lastReadTime = r1;
    }

    public final void setLeaveNotifyTimestamp(long r1) {
        this.leaveNotifyTimestamp = r1;
    }

    public final void setNextCursor(long r1) {
        this.nextCursor = r1;
    }

    public static final /* synthetic */ void access$setLoadingMore$p(NotificationListViewModel r0, boolean r1) {
        r0.loadingMore = r1;
    }

    public static final /* synthetic */ void access$setRefreshing$p(NotificationListViewModel r0, boolean r1) {
        r0.refreshing = r1;
    }

    private final Job refreshAggNotificationList(boolean r7, boolean r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01501(this, r7, r8, null), 3, null);
    }

    private final Job markRead(Long r11, Long r12, Integer r13) {
        return BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C01491(this, r11, r12, r13, null), 3, null);
    }

    private final Job refreshNormalNotificationList(DowngradeSource r11, boolean r12, boolean r13) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01511(this, r12, r13, r11, null), 3, null);
    }

    public final void refreshNotificationList(DowngradeSource r2, boolean r3, boolean r4) {
        if (isAggNotificationPage() == false) goto L5;
        refreshAggNotificationList(r3, r4);
        return;
    L5:
        refreshNormalNotificationList(r2, r3, r4);
    }

    public static /* synthetic */ Job loadMoreNormalNotificationList$default(NotificationListViewModel r0, DowngradeSource r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.loadMoreNormalNotificationList(r1);
    }

    public static /* synthetic */ void loadMoreNotificationList$default(NotificationListViewModel r0, DowngradeSource r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.loadMoreNotificationList(r1);
    }

    public static /* synthetic */ Job refreshAggNotificationList$default(NotificationListViewModel r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.refreshAggNotificationList(r1, r2);
    }

    public static /* synthetic */ Job markRead$default(NotificationListViewModel r1, Long r2, Long r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        return r1.markRead(r2, r3, r4);
    }

    public static /* synthetic */ Job refreshNormalNotificationList$default(NotificationListViewModel r0, DowngradeSource r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = true;
    L9:
        return r0.refreshNormalNotificationList(r1, r2, r3);
    }

    public static /* synthetic */ void refreshNotificationList$default(NotificationListViewModel r0, DowngradeSource r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = true;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = false;
    L11:
        r0.refreshNotificationList(r1, r2, r3);
    }
}
