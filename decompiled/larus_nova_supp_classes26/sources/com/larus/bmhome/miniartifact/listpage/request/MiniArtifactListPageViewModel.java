package com.larus.bmhome.miniartifact.listpage.request;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.miniartifact.input.MiniArtifactInputComponent;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\fJA\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00130\u00152!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00130\u0015H\u0002J\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010!\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002J\"\u0010\"\u001a\u00020\u00132\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\fJ\u0010\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006*"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/MiniArtifactListPageViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/miniartifact/listpage/request/MiniAppTemplateChooseState;", "<init>", "()V", "haveCache", "", "getHaveCache", "()Z", "setHaveCache", "(Z)V", "getMyArtifactListUrl", "", "getTemplatePageTitle", "getTipTitle", "getTipSubTitle", "getTemplateEmptyHint", "getMyArtifactTitle", "requestMiniAppListPage", "", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/bmhome/miniartifact/listpage/request/MiniArtifactListPageResponseData;", "onError", "Lkotlin/ParameterName;", "name", "errMsg", "filterValidTemplateList", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "templateList", "processData", "data", "showEmpty", "showSuccess", "list", "showFailEmpty", "setupLoadingStatus", "getInputEntranceUrl", "fetchMiniAppListPage", "isRetry", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageViewModel extends ComponentViewModel<MiniAppTemplateChooseState> {
    public static final a Companion = null;
    public static final String LOAD_TEMPLATE_LIST_PAGE_URL = "https://activity.doubao.com/codeassist/miniartifact/dev/template/list";
    private boolean haveCache;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.miniartifact.listpage.request.MiniArtifactListPageViewModel$requestMiniAppListPage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.miniartifact.listpage.request.MiniArtifactListPageViewModel$requestMiniAppListPage$1", f = "MiniArtifactListPageViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onError;
        final /* synthetic */ Function1<MiniArtifactListPageResponseData, Unit> $onSuccess;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super MiniArtifactListPageResponseData, Unit> r1, Function1<? super String, Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.$onSuccess = r1;
            this.$onError = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$onSuccess, this.$onError, r4);
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
        L11:
            y r15 = (com.larus.network.http.a) r14;
            if ((r15 instanceof y) == false) goto L15;
            this.$onSuccess.invoke((MiniArtifactListPageResponseData) ((com.larus.network.http.a) r15).b);
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r15 instanceof com.larus.network.http.f) == false) goto L18;
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("load error reason:");
            com.larus.network.http.f r16 = (com.larus.network.http.f) r15;
            r3.append(r16.d.getCode());
            r3.append(r16.d.getMessage());
            r2.i("MiniArtifactListPage", r3.toString());
            this.$onError.invoke(r16.d.getCode() + r16.d.getMessage());
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            JSONObject r4 = new JSONObject();
            this.label = 1;
            r14 = HttpExtKt.k("Basic", MiniArtifactListPageResponseData.class, MiniArtifactListPageViewModel.LOAD_TEMPLATE_LIST_PAGE_URL, r4, null, null, false, null, null, null, this, 1008);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit No(boolean r0, String r1, long r2, boolean r4, MiniAppTemplateChooseState r5) {
        return fetchMiniAppListPage$lambda$9$lambda$8(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ Unit Oo(MiniArtifactListPageViewModel r0, long r1, boolean r3, MiniAppTemplateChooseState r4) {
        return fetchMiniAppListPage$lambda$7$lambda$6(r0, r1, r3, r4);
    }

    public static /* synthetic */ MiniAppTemplateChooseState Po(MiniAppTemplateChooseState r0) {
        return showFailEmpty$lambda$3(r0);
    }

    public static /* synthetic */ MiniAppTemplateChooseState Qo(MiniArtifactListPageResponseData r0, List r1, MiniAppTemplateChooseState r2) {
        return showSuccess$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit So(MiniArtifactListPageResponseData r0, MiniArtifactListPageViewModel r1, long r2, boolean r4, String r5) {
        return fetchMiniAppListPage$lambda$9(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ MiniAppTemplateChooseState To(MiniAppTemplateChooseState r0) {
        return setupLoadingStatus$lambda$4(r0);
    }

    public static /* synthetic */ MiniAppTemplateChooseState Wo(MiniArtifactListPageResponseData r0, MiniAppTemplateChooseState r1) {
        return showEmpty$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit Yo(MiniArtifactListPageViewModel r0, long r1, boolean r3, MiniArtifactListPageResponseData r4) {
        return fetchMiniAppListPage$lambda$7(r0, r1, r3, r4);
    }

    private final void showFailEmpty() {
        setState(new e());
    }

    public final void setupLoadingStatus() {
        setState(new com.larus.bmhome.miniartifact.listpage.request.a());
    }

    public final String getInputEntranceUrl() {
        InputEntrance r0 = ((MiniAppTemplateChooseState) getState()).getInputEntrance();
        if (r0 == null) goto L5;
        String r1 = r0.getInputPreviewWebUrl();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getMyArtifactListUrl() {
        ApplicationEntrance r0 = ((MiniAppTemplateChooseState) getState()).getApplicationEntrance();
        if (r0 == null) goto L5;
        String r1 = r0.getEntranceWebUrl();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getMyArtifactTitle() {
        return ((MiniAppTemplateChooseState) getState()).getMyArtifactTitle();
    }

    public final String getTemplateEmptyHint() {
        return ((MiniAppTemplateChooseState) getState()).getTemplateEmptyHint();
    }

    public final String getTemplatePageTitle() {
        return ((MiniAppTemplateChooseState) getState()).getTemplatePageTitle();
    }

    public final String getTipSubTitle() {
        ApplicationEntrance r0 = ((MiniAppTemplateChooseState) getState()).getApplicationEntrance();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTipSubTitle();
    }

    public final String getTipTitle() {
        ApplicationEntrance r0 = ((MiniAppTemplateChooseState) getState()).getApplicationEntrance();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTipTitle();
    }

    public MiniArtifactListPageViewModel() {
    }

    public final boolean getHaveCache() {
        return this.haveCache;
    }

    private final List<ApplicationTemplate> filterValidTemplateList(List<ApplicationTemplate> r9) {
        if (r9 == null) goto L25;
        ArrayList r1 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L19;
        Object r2 = r10.next();
        ApplicationTemplate r3 = (ApplicationTemplate) r2;
        if (r3 == null) goto L10;
        Long r4 = r3.getTemplateInvalidTimestamp();
    L11:
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L6;
        r1.add(r2);
        goto L6
    L13:
        if (r3.getTemplateInvalidTimestamp().longValue() <= AppHost.a.getAppClock().currentTimeMillis()) goto L15;
        r5 = true;
        goto L16
    L10:
        r4 = null;
        goto L11
    L19:
        return CollectionsKt.filterNotNull(r1);
    L25:
        return null;
    }

    private final void processData(MiniArtifactListPageResponseData r3) {
        if (r3 == null) goto L4;
        List<ApplicationTemplate> r0 = r3.getApplicationTemplateList();
    L5:
        List<ApplicationTemplate> r1 = filterValidTemplateList(r0);
        List<ApplicationTemplate> r2 = r1;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        showEmpty(r3);
        return;
    L14:
        showSuccess(r1, r3);
        return;
    L8:
        if (r2.isEmpty() == true) goto L11;
        r4 = false;
        goto L12
    L4:
        r0 = null;
        goto L5
    }

    private static final MiniAppTemplateChooseState setupLoadingStatus$lambda$4(MiniAppTemplateChooseState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return MiniAppTemplateChooseState.copy$default(r12, false, PageStatus.LOADING, null, null, null, null, null, null, 253, null);
    }

    private final void showEmpty(final MiniArtifactListPageResponseData r2) {
        setState(new d(r2));
    }

    private static final MiniAppTemplateChooseState showFailEmpty$lambda$3(MiniAppTemplateChooseState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return MiniAppTemplateChooseState.copy$default(r12, false, PageStatus.FAIL, null, null, null, null, null, null, 29, null);
    }

    public final void fetchMiniAppListPage(final boolean r9) {
        final long r5 = AppHost.a.getAppClock().currentTimeMillis();
        MiniArtifactListPageResponseData r1 = (MiniArtifactListPageResponseData) ((Gson) dr8.c.b.getValue()).fromJson(((Keva) dr8.c.a.getValue()).getString("mini_artifact_list_page", ""), MiniArtifactListPageResponseData.class);     // Catch: Exception -> L5
    L7:
        final MiniArtifactListPageResponseData r3 = r1;
        if (r3 == null) goto L10;
        FLogger.a.i("MiniArtifactListPage", "fetchMiniAppListPage use cache");
        this.haveCache = true;
        processData(r3);
    L10:
        requestMiniAppListPage(new b(this, r5, r9), new c(r3, this, r5, r9));
        return;
    L5:
        e = move-exception;
        FLogger.a.d("MiniArtifactListPage", "getMiniAppListPageData error:" + e);
        r1 = null;
        goto L7
    }

    public final void setHaveCache(boolean r1) {
        this.haveCache = r1;
    }

    private final void requestMiniAppListPage(Function1<? super MiniArtifactListPageResponseData, Unit> r7, Function1<? super String, Unit> r8) {
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new AnonymousClass1(r7, r8, null), 2, null);
    }

    private static final MiniAppTemplateChooseState showEmpty$lambda$1(MiniArtifactListPageResponseData r13, MiniAppTemplateChooseState r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$setState");
        ApplicationEntrance r0 = null;
        if (r13 == null) goto L5;
        String r5 = r13.getTemplatePageTitle();
    L6:
        if (r13 == null) goto L8;
        String r6 = r13.getTemplateEmptyHint();
    L9:
        if (r13 == null) goto L13;
        ApplicationEntrance r1 = r13.getApplicationEntrance();
        if (r1 == null) goto L13;
        String r7 = r1.getEntranceTitle();
    L14:
        PageStatus r4 = PageStatus.EMPTY;
        if (r13 == null) goto L17;
        InputEntrance r9 = r13.getInputEntrance();
    L18:
        if (r13 == null) goto L21;
        r0 = r13.getApplicationEntrance();
    L21:
        return MiniAppTemplateChooseState.copy$default(r14, false, r4, r5, r6, r7, null, r9, r0, 1, null);
    L17:
        r9 = null;
    L13:
        r7 = null;
        goto L14
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    private final void showSuccess(final List<ApplicationTemplate> r2, final MiniArtifactListPageResponseData r3) {
        setState(new f(r3, r2));
    }

    private static final MiniAppTemplateChooseState showSuccess$lambda$2(MiniArtifactListPageResponseData r13, List r14, MiniAppTemplateChooseState r15) {
        Intrinsics.checkNotNullParameter(r15, "$this$setState");
        ApplicationEntrance r0 = null;
        if (r13 == null) goto L5;
        String r5 = r13.getTemplatePageTitle();
    L6:
        if (r13 == null) goto L8;
        String r6 = r13.getTemplateEmptyHint();
    L9:
        if (r13 == null) goto L13;
        ApplicationEntrance r1 = r13.getApplicationEntrance();
        if (r1 == null) goto L13;
        String r7 = r1.getEntranceTitle();
    L14:
        PageStatus r4 = PageStatus.SUCCESS;
        if (r13 == null) goto L17;
        InputEntrance r9 = r13.getInputEntrance();
    L18:
        if (r13 == null) goto L21;
        r0 = r13.getApplicationEntrance();
    L21:
        return MiniAppTemplateChooseState.copy$default(r15, false, r4, r5, r6, r7, r14, r9, r0, 1, null);
    L17:
        r9 = null;
    L13:
        r7 = null;
        goto L14
    L8:
        r6 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public static /* synthetic */ void fetchMiniAppListPage$default(MiniArtifactListPageViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.fetchMiniAppListPage(r1);
    }

    private static final Unit fetchMiniAppListPage$lambda$7(final MiniArtifactListPageViewModel r3, long r4, final boolean r6, MiniArtifactListPageResponseData r7) {
        FLogger.a.i("MiniArtifactListPage", "fetchMiniAppListPage from network onSuccess");
        Lazy r0 = dr8.c.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (r7 != null) goto L6;
        ((Keva) dr8.c.a.getValue()).clear();     // Catch: Throwable -> L8
    L12:
    L10:
        r3.processData(r7);
        final long r2 = AppHost.a.getAppClock().currentTimeMillis() - r4;
        r3.withState(new h(r3, r2, r6));
        return Unit.INSTANCE;
    L6:
        String r5 = ((Gson) dr8.c.b.getValue()).toJson(r7);     // Catch: Throwable -> L8
        ((Keva) dr8.c.a.getValue()).storeString("mini_artifact_list_page", r5);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private static final Unit fetchMiniAppListPage$lambda$7$lambda$6(MiniArtifactListPageViewModel r9, long r10, boolean r12, MiniAppTemplateChooseState r13) {
        Intrinsics.checkNotNullParameter(r13, "it");
        int r0 = ar8.a.a;
        if (r13.getPageStatus() != PageStatus.SUCCESS) goto L5;
        String r1 = "success";
    L6:
        String r2 = r1;
        boolean r3 = r9.haveCache;
        List<ApplicationTemplate> r11 = r13.getCurrentRenderTemplateList();
        if (r11 == null) goto L9;
        int r4 = r11.size();
    L10:
        int r14 = MiniArtifactInputComponent.A;
        ar8.a.c(r2, r3, "", r4, r10, !r12, MiniArtifactInputComponent.a.a());
        return Unit.INSTANCE;
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = "empty";
        goto L6
    }

    private static final Unit fetchMiniAppListPage$lambda$9(MiniArtifactListPageResponseData r6, MiniArtifactListPageViewModel r7, long r8, final boolean r10, final String r11) {
        Intrinsics.checkNotNullParameter(r11, "errMsg");
        FLogger.a.i("MiniArtifactListPage", "fetchMiniAppListPage from network onError");
        if (r6 == null) goto L5;
        final boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        r7.showFailEmpty();
    L8:
        final long r3 = AppHost.a.getAppClock().currentTimeMillis() - r8;
        r7.withState(new g(r1, r11, r3, r10));
        return Unit.INSTANCE;
    L5:
        r1 = false;
        goto L6
    }

    private static final Unit fetchMiniAppListPage$lambda$9$lambda$8(boolean r9, String r10, long r11, boolean r13, MiniAppTemplateChooseState r14) {
        Intrinsics.checkNotNullParameter(r14, "it");
        int r0 = ar8.a.a;
        List<ApplicationTemplate> r15 = r14.getCurrentRenderTemplateList();
        if (r15 == null) goto L5;
        int r4 = r15.size();
    L6:
        boolean r7 = !r13;
        int r16 = MiniArtifactInputComponent.A;
        ar8.a.c("fail", r9, r10, r4, r11, r7, MiniArtifactInputComponent.a.a());
        return Unit.INSTANCE;
    L5:
        r4 = 0;
        goto L6
    }
}
