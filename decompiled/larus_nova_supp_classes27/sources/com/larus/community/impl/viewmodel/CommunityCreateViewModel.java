package com.larus.community.impl.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.community.impl.api.c;
import com.larus.community.impl.api.n;
import com.larus.community.impl.api.o;
import com.larus.community.impl.api.q;
import com.larus.community.impl.template.g;
import com.larus.network.http.y;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import q29.f;
import r29.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 J\b\u0010$\u001a\u00020\u001eH\u0002J\u0016\u0010%\u001a\u00020\u001e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/larus/community/impl/viewmodel/CommunityCreateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "hasSuccessBefore", "", "job", "Lkotlinx/coroutines/Job;", "_tabListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/platform/api/creation/TabItemInfo;", "tabListLiveData", "Landroidx/lifecycle/LiveData;", "getTabListLiveData", "()Landroidx/lifecycle/LiveData;", "_pageStateLiveData", "Lcom/larus/community/impl/view/PageState;", "pageStateLiveData", "getPageStateLiveData", "_userInfoState", "Lcom/larus/community/impl/api/CommunityProfileOverviewResponse;", "userInfoState", "getUserInfoState", "defaultFirstTabItemInfo", "getDefaultFirstTabItemInfo", "()Lcom/larus/platform/api/creation/TabItemInfo;", "defaultFirstTabItemInfo$delegate", "Lkotlin/Lazy;", "fetchAvatarInfo", "", "userId", "", "fetchTabList", "isMultiTab", "source", "setError", "updateTabList", "tabList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommunityCreateViewModel extends ViewModel {
    private MutableLiveData<k> _pageStateLiveData;
    private MutableLiveData<List<TabItemInfo>> _tabListLiveData;
    private final MutableLiveData<c> _userInfoState;
    private final Lazy defaultFirstTabItemInfo$delegate;
    private volatile boolean hasSuccessBefore;
    private Job job;
    private final LiveData<k> pageStateLiveData;
    private final LiveData<List<TabItemInfo>> tabListLiveData;
    private final LiveData<c> userInfoState;

    /* JADX INFO: renamed from: com.larus.community.impl.viewmodel.CommunityCreateViewModel$fetchAvatarInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.viewmodel.CommunityCreateViewModel$fetchAvatarInfo$1", f = "CommunityCreateViewModel.kt", i = {0}, l = {55}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CommunityCreateViewModel this$0;

        public AnonymousClass1(String r1, CommunityCreateViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$userId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$userId, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
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
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
        L11:
            y r9 = (com.larus.network.http.a) r8;
            if ((r9 instanceof y) == false) goto L22;
            y r10 = r9;
            Long r3 = r10.g;
            if (r3 == null) goto L22;
            if (r3.longValue() != 0) goto L22;
            c r11 = (c) ((com.larus.network.http.a) r10).b;
            if (r11 == null) goto L21;
            CommunityCreateViewModel.access$get_userInfoState$p(this.this$0).postValue(r11);
        L24:
            return Unit.INSTANCE;
        L21:
            FLogger.a.e("ComponentViewModel", "error in fetch avatar info");
        L22:
            FLogger.a.e("ComponentViewModel", "error in fetch avatar info");
            goto L24
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            CreationRecommendApi.a r4 = CreationRecommendApi.a;
            q r5 = new q(this.$userId);
            this.L$0 = r12;
            this.label = 1;
            r4.getClass();
            r8 = CreationRecommendApi.a.b(r5, "community_create", this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.viewmodel.CommunityCreateViewModel$fetchTabList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.viewmodel.CommunityCreateViewModel$fetchTabList$1", f = "CommunityCreateViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $source;
        int label;
        final /* synthetic */ CommunityCreateViewModel this$0;

        public C01641(CommunityCreateViewModel r1, String r2, Continuation<? super C01641> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01641(this.this$0, this.$source, r4);
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
        L14:
            y r8 = (com.larus.network.http.a) r7;
            if ((r8 instanceof y) == false) goto L28;
            y r9 = r8;
            Long r2 = r9.g;
            if (r2 != null) goto L20;
        L27:
            CommunityCreateViewModel.access$setError(this.this$0);
        L30:
            return Unit.INSTANCE;
        L20:
            if (r2.longValue() != 0) goto L27;
            m29.a.a("CommunityCreateViewModel", new g());
            CommunityCreateViewModel.access$setHasSuccessBefore$p(this.this$0, true);
            CommunityCreateViewModel r3 = this.this$0;
            o r10 = (o) ((com.larus.network.http.a) r9).b;
            if (r10 == null) goto L25;
            List<TabItemInfo> r11 = r10.a();
            if (r11 == null) goto L25;
        L26:
            CommunityCreateViewModel.access$updateTabList(r3, r11);
            CommunityCreateViewModel.access$get_pageStateLiveData$p(this.this$0).postValue(k.e.a);
        L25:
            r11 = CollectionsKt.emptyList();
            goto L26
        L28:
            CommunityCreateViewModel.access$setError(this.this$0);
            goto L30
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            if (CommunityCreateViewModel.access$getHasSuccessBefore$p(this.this$0) == true) goto L11;
            CommunityCreateViewModel.access$get_pageStateLiveData$p(this.this$0).postValue(k.d.a);
        L11:
            CreationRecommendApi.a r12 = CreationRecommendApi.a;
            n r4 = new n(1);
            String r5 = this.$source;
            this.label = 1;
            r12.getClass();
            r7 = CreationRecommendApi.a.a(r4, r5, this);
            if (r7 != r0) goto L14;
            return r0;
        }
    }

    public static /* synthetic */ String Mo() {
        return setError$lambda$1();
    }

    private static final String setError$lambda$1() {
        return "success in fetch tab list";
    }

    public static /* synthetic */ TabItemInfo yo() {
        return defaultFirstTabItemInfo_delegate$lambda$0();
    }

    private final TabItemInfo getDefaultFirstTabItemInfo() {
        return (TabItemInfo) this.defaultFirstTabItemInfo$delegate.getValue();
    }

    private final void setError() {
        m29.a.a("CommunityCreateViewModel", new b());
    }

    public CommunityCreateViewModel() {
        MutableLiveData<List<TabItemInfo>> r0 = new MutableLiveData();
        this._tabListLiveData = r0;
        this.tabListLiveData = r0;
        MutableLiveData<k> r1 = new MutableLiveData();
        this._pageStateLiveData = r1;
        this.pageStateLiveData = r1;
        MutableLiveData<c> r2 = new MutableLiveData();
        this._userInfoState = r2;
        this.userInfoState = r2;
        this.defaultFirstTabItemInfo$delegate = LazyKt.lazy(new a());
    }

    private static final TabItemInfo defaultFirstTabItemInfo_delegate$lambda$0() {
        return f.a();
    }

    public final LiveData<k> getPageStateLiveData() {
        return this.pageStateLiveData;
    }

    public final LiveData<List<TabItemInfo>> getTabListLiveData() {
        return this.tabListLiveData;
    }

    public final LiveData<c> getUserInfoState() {
        return this.userInfoState;
    }

    public static final /* synthetic */ boolean access$getHasSuccessBefore$p(CommunityCreateViewModel r0) {
        return r0.hasSuccessBefore;
    }

    public static final /* synthetic */ MutableLiveData access$get_pageStateLiveData$p(CommunityCreateViewModel r0) {
        return r0._pageStateLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_userInfoState$p(CommunityCreateViewModel r0) {
        return r0._userInfoState;
    }

    public static final /* synthetic */ void access$setError(CommunityCreateViewModel r0) {
        r0.setError();
    }

    private final void updateTabList(List<TabItemInfo> r5) {
        MutableLiveData<List<TabItemInfo>> r0 = this._tabListLiveData;
        List r1 = CollectionsKt.mutableListOf(new TabItemInfo[]{getDefaultFirstTabItemInfo()});
        r1.addAll(r5);
        r0.postValue(r1);
    }

    public final void fetchAvatarInfo(String r8) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, null), 2, null);
    }

    public static final /* synthetic */ void access$setHasSuccessBefore$p(CommunityCreateViewModel r0, boolean r1) {
        r0.hasSuccessBefore = r1;
    }

    public static final /* synthetic */ void access$updateTabList(CommunityCreateViewModel r0, List r1) {
        r0.updateTabList(r1);
    }

    public final void fetchTabList(boolean r9, String r10) {
        if (r9 == true) goto L6;
        this._tabListLiveData.postValue(CollectionsKt.listOf(new TabItemInfo(null, null, null, null, 31)));
        this._pageStateLiveData.postValue(k.e.a);
        return;
    L6:
        if (this._tabListLiveData.getValue() == null) goto L14;
        List r11 = (List) this._tabListLiveData.getValue();
        if (r11 != null) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == true) goto L14;
    L15:
        Job r13 = this.job;
        if (r13 == null) goto L18;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L18:
        this.job = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01641(this, r10, null), 2, null);
        return;
    L10:
        if (r11.isEmpty() != true) goto L12;
        r12 = true;
    L14:
        updateTabList(CollectionsKt.emptyList());
        this._pageStateLiveData.postValue(k.e.a);
        goto L15
    }

    public static /* synthetic */ void fetchTabList$default(CommunityCreateViewModel r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.fetchTabList(r1, r2);
    }
}
