package com.larus.community.impl.template;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.network.http.y;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.ui.arch.vm.ComponentViewModel;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001dJ\u001c\u0010 \u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\u0016\u0010\"\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/larus/community/impl/template/TemplateCreateViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/template/TemplateCreateState;", "<init>", "()V", "hasSuccessBefore", "", "job", "Lkotlinx/coroutines/Job;", "defaultFirstTabItemInfo", "Lcom/larus/platform/api/creation/TabItemInfo;", "getDefaultFirstTabItemInfo", "()Lcom/larus/platform/api/creation/TabItemInfo;", "defaultFirstTabItemInfo$delegate", "Lkotlin/Lazy;", "_userInfoState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/community/impl/api/CommunityProfileOverviewResponse;", "userInfoState", "Landroidx/lifecycle/LiveData;", "getUserInfoState", "()Landroidx/lifecycle/LiveData;", "fetchTabList", "", "isMultiTab", "recommendType", "", "showDefaultFirst", "source", "", "fetchAvatarInfo", "userId", "internalFetch", "setError", "updateTabList", "tabList", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreateViewModel extends ComponentViewModel<TemplateCreateState> {
    private final MutableLiveData<com.larus.community.impl.api.c> _userInfoState;
    private final Lazy defaultFirstTabItemInfo$delegate;
    private volatile boolean hasSuccessBefore;
    private Job job;
    private final LiveData<com.larus.community.impl.api.c> userInfoState;

    /* JADX INFO: renamed from: com.larus.community.impl.template.TemplateCreateViewModel$fetchAvatarInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.template.TemplateCreateViewModel$fetchAvatarInfo$1", f = "TemplateCreateViewModel.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TemplateCreateViewModel this$0;

        public AnonymousClass1(String r1, TemplateCreateViewModel r2, Continuation<? super AnonymousClass1> r3) {
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
            com.larus.community.impl.api.c r11 = (com.larus.community.impl.api.c) ((com.larus.network.http.a) r10).b;
            if (r11 == null) goto L21;
            TemplateCreateViewModel.access$get_userInfoState$p(this.this$0).postValue(r11);
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
            com.larus.community.impl.api.q r5 = new com.larus.community.impl.api.q(this.$userId);
            this.L$0 = r12;
            this.label = 1;
            r4.getClass();
            r8 = CreationRecommendApi.a.b(r5, "template_create", this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.template.TemplateCreateViewModel$internalFetch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.template.TemplateCreateViewModel$internalFetch$1", f = "TemplateCreateViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $recommendType;
        final /* synthetic */ String $source;
        int label;
        final /* synthetic */ TemplateCreateViewModel this$0;

        public C01631(TemplateCreateViewModel r1, int r2, String r3, Continuation<? super C01631> r4) {
            this.this$0 = r1;
            this.$recommendType = r2;
            this.$source = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01631(this.this$0, this.$recommendType, this.$source, r5);
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
            TemplateCreateViewModel.access$setError(this.this$0);
        L30:
            return Unit.INSTANCE;
        L20:
            if (r2.longValue() != 0) goto L27;
            m29.a.a("TemplateCreateViewModel", new g());
            TemplateCreateViewModel.access$setHasSuccessBefore$p(this.this$0, true);
            com.larus.community.impl.api.o r10 = (com.larus.community.impl.api.o) ((com.larus.network.http.a) r9).b;
            TemplateCreateViewModel r3 = this.this$0;
            if (r10 == null) goto L25;
            List<TabItemInfo> r11 = r10.a();
            if (r11 == null) goto L25;
        L26:
            TemplateCreateViewModel.access$updateTabList(r3, r11);
        L25:
            r11 = CollectionsKt.emptyList();
            goto L26
        L28:
            TemplateCreateViewModel.access$setError(this.this$0);
            goto L30
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            if (TemplateCreateViewModel.access$getHasSuccessBefore$p(this.this$0) == true) goto L11;
            TemplateCreateViewModel.access$setState(this.this$0, new f());
        L11:
            CreationRecommendApi.a r12 = CreationRecommendApi.a;
            com.larus.community.impl.api.n r4 = new com.larus.community.impl.api.n(this.$recommendType);
            String r5 = this.$source;
            this.label = 1;
            r12.getClass();
            r7 = CreationRecommendApi.a.a(r4, r5, this);
            if (r7 != r0) goto L14;
            return r0;
        }
    }

    public static /* synthetic */ TemplateCreateState No(List r0, TemplateCreateState r1) {
        return updateTabList$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit Oo(TemplateCreateViewModel r0, TemplateCreateState r1) {
        return setError$lambda$3(r0, r1);
    }

    public static /* synthetic */ TemplateCreateState Po(TemplateCreateState r0) {
        return fetchTabList$lambda$1(r0);
    }

    public static /* synthetic */ TabItemInfo Qo() {
        return defaultFirstTabItemInfo_delegate$lambda$0();
    }

    public static /* synthetic */ String So() {
        return setError$lambda$2();
    }

    private static final String setError$lambda$2() {
        return "success in fetch tab list";
    }

    private final TabItemInfo getDefaultFirstTabItemInfo() {
        return (TabItemInfo) this.defaultFirstTabItemInfo$delegate.getValue();
    }

    private final void setError() {
        m29.a.a("TemplateCreateViewModel", new d());
        withState(new e(this));
    }

    public TemplateCreateViewModel() {
        this.defaultFirstTabItemInfo$delegate = LazyKt.lazy(new c());
        MutableLiveData<com.larus.community.impl.api.c> r0 = new MutableLiveData();
        this._userInfoState = r0;
        this.userInfoState = r0;
    }

    private static final TabItemInfo defaultFirstTabItemInfo_delegate$lambda$0() {
        return q29.f.a();
    }

    public final LiveData<com.larus.community.impl.api.c> getUserInfoState() {
        return this.userInfoState;
    }

    public static final /* synthetic */ boolean access$getHasSuccessBefore$p(TemplateCreateViewModel r0) {
        return r0.hasSuccessBefore;
    }

    public static final /* synthetic */ MutableLiveData access$get_userInfoState$p(TemplateCreateViewModel r0) {
        return r0._userInfoState;
    }

    public static final /* synthetic */ void access$setError(TemplateCreateViewModel r0) {
        r0.setError();
    }

    private static final TemplateCreateState fetchTabList$lambda$1(TemplateCreateState r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$setStateImmediate");
        return r7.copy(CollectionsKt.listOf(new TabItemInfo(null, null, null, null, 31)), r29.k.e.a);
    }

    private final void updateTabList(List<TabItemInfo> r4) {
        final List r0 = CollectionsKt.mutableListOf(new TabItemInfo[]{getDefaultFirstTabItemInfo()});
        r0.addAll(r4);
        setStateImmediate(new b(r0));
    }

    public final void fetchAvatarInfo(String r8) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, null), 2, null);
    }

    public static final /* synthetic */ void access$setHasSuccessBefore$p(TemplateCreateViewModel r0, boolean r1) {
        r0.hasSuccessBefore = r1;
    }

    public static final /* synthetic */ void access$setState(TemplateCreateViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$updateTabList(TemplateCreateViewModel r0, List r1) {
        r0.updateTabList(r1);
    }

    private final void internalFetch(int r10, String r11) {
        Job r0 = this.job;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.job = BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new C01631(this, r10, r11, null), 2, null);
    }

    private static final Unit setError$lambda$3(TemplateCreateViewModel r1, TemplateCreateState r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r2.getTabList().isEmpty() == false) goto L6;
        r1.updateTabList(CollectionsKt.emptyList());
    L6:
        return Unit.INSTANCE;
    }

    private static final TemplateCreateState updateTabList$lambda$5(List r1, TemplateCreateState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(r1, r29.k.e.a);
    }

    public final void fetchTabList(boolean r1, int r2, boolean r3, String r4) {
        if (r1 == true) goto L6;
        setStateImmediate(new a());
        return;
    L6:
        if (((TemplateCreateState) getState()).getTabList().isEmpty() == false) goto L9;
        if (r3 == false) goto L9;
        updateTabList(CollectionsKt.emptyList());
        this.hasSuccessBefore = true;
    L9:
        internalFetch(r2, r4);
    }

    public static /* synthetic */ void internalFetch$default(TemplateCreateViewModel r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.internalFetch(r1, r2);
    }
}
