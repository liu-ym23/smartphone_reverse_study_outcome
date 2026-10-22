package com.larus.bot.impl.feature.discover;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bot.impl.common.util.RecommendBotHelper;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.settings.value.e10;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import tx9.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\f\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\u0012J0\u0010-\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/bot/impl/feature/discover/BotDiscoverModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "botRepo", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "ugcBotRepo", "Lcom/larus/bot/impl/repository/UgcBotRepo;", "pageSize", "", "refreshData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "getRefreshData", "()Landroidx/lifecycle/MutableLiveData;", "needShowNetErrorToast", "", "getNeedShowNetErrorToast", "()Z", "setNeedShowNetErrorToast", "(Z)V", "isUseCacheData", "needPreloadBotList", "getNeedPreloadBotList", "needPreloadBotList$delegate", "Lkotlin/Lazy;", "cachedConversationIdList", "", "", "Lkotlinx/coroutines/Job;", "tagId", "", "tabName", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;)Lkotlinx/coroutines/Job;", "saveDiscoverFirstPageData", "", "recommendData", "(Lcom/larus/bmhome/chat/bean/RecommendBotData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDiscoverFirstPageData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasDiscoverFirstPageData", "getFirstPageData", "(Ljava/lang/Long;Ljava/lang/String;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindObserver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverModel extends AndroidViewModel {
    private final IBotRepoService botRepo;
    private volatile List<String> cachedConversationIdList;
    private final boolean isUseCacheData;
    private final Lazy needPreloadBotList$delegate;
    private boolean needShowNetErrorToast;
    private final int pageSize;
    private final MutableLiveData<ic8.o0> refreshData;
    private final UgcBotRepo ugcBotRepo;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverModel$bindObserver$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverModel$bindObserver$1", f = "BotDiscoverModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotDiscoverModel this$0;

        /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverModel$bindObserver$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ BotDiscoverModel a;

            public a(BotDiscoverModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                List r3 = (List) r1;
                if (r3 == null) goto L6;
                BotDiscoverModel.access$setCachedConversationIdList$p(this.a, r3);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(BotDiscoverModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1 r6 = RepoDispatcherDelegate.b.f().y();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverModel$getFirstPageData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverModel", f = "BotDiscoverModel.kt", i = {}, l = {75, 86}, m = "getFirstPageData", n = {}, s = {})
    public static final class C01971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotDiscoverModel this$0;

        public C01971(BotDiscoverModel r1, Continuation<? super C01971> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return BotDiscoverModel.access$getFirstPageData(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.discover.BotDiscoverModel$refreshData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverModel$refreshData$1", f = "BotDiscoverModel.kt", i = {2}, l = {46, 50, 57}, m = "invokeSuspend", n = {"data"}, s = {"L$0"})
    public static final class C01981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        final /* synthetic */ String $tabName;
        final /* synthetic */ Long $tagId;
        Object L$0;
        int label;
        final /* synthetic */ BotDiscoverModel this$0;

        public C01981(BotDiscoverModel r1, Long r2, String r3, DowngradeSource r4, Continuation<? super C01981> r5) {
            this.this$0 = r1;
            this.$tagId = r2;
            this.$tabName = r3;
            this.$downgradeSource = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01981(this.this$0, this.$tagId, this.$tabName, this.$downgradeSource, r8);
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
            boolean r4 = true;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ic8.o0 r2 = (ic8.o0) this.L$0;
            ResultKt.throwOnFailure(r8);
        L31:
            ic8.o0 r9 = r2;
        L32:
            long r3 = 1;
            if (r9 == null) goto L35;
            long r5 = 1;
        L36:
            if (r9 == null) goto L42;
            List r10 = r9.b();
            if (r10 == null) goto L42;
            if ((!r10.isEmpty()) != true) goto L42;
        L43:
            if (r4 == true) goto L46;
            r3 = 0;
        L46:
            e3.a(Boxing.boxLong(r5), Boxing.boxLong(r3));
            return Unit.INSTANCE;
        L42:
            r4 = false;
            goto L43
        L35:
            r5 = 0;
            goto L36
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r8);
        L23:
            r9 = (ic8.o0) r8;
            if (r9 == null) goto L26;
        L27:
            this.this$0.getRefreshData().postValue(r9);
            BotDiscoverModel r6 = this.this$0;
            this.L$0 = r9;
            this.label = 3;
            if (BotDiscoverModel.access$saveDiscoverFirstPageData(r6, r9, this) != r0) goto L30;
            return r0;
        L30:
            r2 = r9;
            goto L31
        L26:
            if (BotDiscoverModel.access$isUseCacheData$p(this.this$0) == true) goto L32;
        L11:
            ResultKt.throwOnFailure(r8);
        L15:
            ic8.o0 r11 = (ic8.o0) r8;
            if (r11 != null) goto L18;
        L20:
            BotDiscoverModel r12 = this.this$0;
            Long r7 = this.$tagId;
            String r13 = this.$tabName;
            DowngradeSource r14 = this.$downgradeSource;
            this.label = 2;
            r8 = BotDiscoverModel.access$getFirstPageData(r12, r7, r13, r14, this);
            if (r8 != r0) goto L23;
            return r0;
        L18:
            if (BotDiscoverModel.access$isUseCacheData$p(this.this$0) == false) goto L20;
            this.this$0.getRefreshData().postValue(r11);
            goto L20
        L12:
            ResultKt.throwOnFailure(r8);
            BotDiscoverModel r15 = this.this$0;
            this.label = 1;
            r8 = BotDiscoverModel.access$getDiscoverFirstPageData(r15, this);
            if (r8 != r0) goto L15;
            return r0;
        }
    }

    public static /* synthetic */ boolean yo() {
        return needPreloadBotList_delegate$lambda$0();
    }

    private final void bindObserver() {
        if (FeatureKitDelegate.b.r0().b() == false) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    private static final boolean needPreloadBotList_delegate$lambda$0() {
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        Boolean r2 = ((au9.e) com.larus.utils.l0.a(new au9.e(0), new com.larus.settings.value.j())).a();
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.booleanValue();
    }

    public final boolean getNeedPreloadBotList() {
        return ((Boolean) this.needPreloadBotList$delegate.getValue()).booleanValue();
    }

    public final boolean hasDiscoverFirstPageData() {
        return this.ugcBotRepo.e().getBoolean("key_has_recommend_bot_first_page_data", false);
    }

    public final boolean getNeedShowNetErrorToast() {
        return this.needShowNetErrorToast;
    }

    public final MutableLiveData<ic8.o0> getRefreshData() {
        return this.refreshData;
    }

    public BotDiscoverModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.botRepo = RepoDispatcherDelegate.b.b();
        Lazy<UgcBotRepo> r3 = UgcBotRepo.d;
        this.ugcBotRepo = UgcBotRepo.a.a();
        this.pageSize = 20;
        this.refreshData = new MutableLiveData();
        e10 r4 = e10.a;
        this.isUseCacheData = Intrinsics.areEqual(e10.s0().b(), Boolean.TRUE);
        this.needPreloadBotList$delegate = LazyKt.lazy(new r0());
        bindObserver();
    }

    public static final /* synthetic */ boolean access$isUseCacheData$p(BotDiscoverModel r0) {
        return r0.isUseCacheData;
    }

    private final Object getDiscoverFirstPageData(Continuation<? super ic8.o0> r2) {
        return this.ugcBotRepo.d(r2);
    }

    public final void setNeedShowNetErrorToast(boolean r1) {
        this.needShowNetErrorToast = r1;
    }

    public static final /* synthetic */ Object access$getDiscoverFirstPageData(BotDiscoverModel r0, Continuation r1) {
        return r0.getDiscoverFirstPageData(r1);
    }

    public static final /* synthetic */ void access$setCachedConversationIdList$p(BotDiscoverModel r0, List r1) {
        r0.cachedConversationIdList = r1;
    }

    private final Object saveDiscoverFirstPageData(ic8.o0 r2, Continuation<? super Unit> r3) {
        Object r4 = this.ugcBotRepo.k(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$saveDiscoverFirstPageData(BotDiscoverModel r0, ic8.o0 r1, Continuation r2) {
        return r0.saveDiscoverFirstPageData(r1, r2);
    }

    public final Job refreshData(Long r11, String r12, DowngradeSource r13) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01981(this, r11, r12, r13, null), 3, null);
    }

    private final Object getFirstPageData(Long r18, String r19, DowngradeSource r20, Continuation<? super ic8.o0> r21) {
        if ((r21 instanceof C01971) == false) goto L7;
        C01971 r2 = (C01971) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ic8.o0 r5 = (ic8.o0) r2.L$1;
        Object r6 = r2.L$0;
        ResultKt.throwOnFailure(r1);
    L32:
        r5.h((List) r1);
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        Object r7 = r1;
        Object r8 = r15;
    L19:
        ic8.o0 r9 = (ic8.o0) r7;
        if (r9 == null) goto L34;
        List<RecommendBot> r10 = r9.b();
        if (r10 != null) goto L24;
        return r7;
    L24:
        if (FeatureKitDelegate.b.r0().b() == false) goto L36;
        RecommendBotHelper r11 = RecommendBotHelper.a;
        List<String> r12 = this.cachedConversationIdList;
        if (r12 != null) goto L28;
        r12 = CollectionsKt.emptyList();
    L28:
        r2.L$0 = r7;
        r2.L$1 = r9;
        r2.label = 2;
        Object r13 = r11.a(r10, r12, r2);
        if (r13 != r8) goto L31;
        return r8;
    L31:
        r1 = r13;
        r6 = r7;
        r5 = r9;
        goto L32
    L36:
        return r7;
    L34:
        return r7;
    L16:
        ResultKt.throwOnFailure(r1);
        IBotRepoService r14 = this.botRepo;
        int r16 = this.pageSize;
        r2.label = 1;
        r8 = r15;
        r7 = IBotRepoService.b.b(r14, 2, 1, r16, r18, false, null, "first_request", r19, null, r20, r2, 304);
        if (r7 != r8) goto L19;
        return r8;
    L7:
        r2 = new C01971(this, r21);
        goto L8
    }

    public static final /* synthetic */ Object access$getFirstPageData(BotDiscoverModel r0, Long r1, String r2, DowngradeSource r3, Continuation r4) {
        return r0.getFirstPageData(r1, r2, r3, r4);
    }

    public static /* synthetic */ Job refreshData$default(BotDiscoverModel r0, Long r1, String r2, DowngradeSource r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.refreshData(r1, r2, r3);
    }

    public static /* synthetic */ Object getFirstPageData$default(BotDiscoverModel r0, Long r1, String r2, DowngradeSource r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.getFirstPageData(r1, r2, r3, r4);
    }
}
