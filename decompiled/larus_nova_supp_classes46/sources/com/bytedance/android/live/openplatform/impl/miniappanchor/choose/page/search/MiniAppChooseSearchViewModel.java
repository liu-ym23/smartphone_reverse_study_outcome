package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.api.ChooseApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.respository.MiniAppChooseSearchRepository;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/MiniAppChooseSearchViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBaseViewModel;", "", "onScopeInitialized", "loadHistoryList", "()Lkotlin/Unit;", "", "keyword", "deleteHistory", "(Ljava/lang/String;)Lkotlin/Unit;", "deleteAllHistory", "searchMiniApp", "", "getHistoryListSize", "saveHistoryList", "onCleared", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/respository/MiniAppChooseSearchRepository;", "repository", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/respository/MiniAppChooseSearchRepository;", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/LinkedList;", "historyListUiState", "Landroidx/lifecycle/MutableLiveData;", "getHistoryListUiState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/openplatform/impl/base/utils/b;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/p;", "searchResultUiState", "getSearchResultUiState", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseSearchViewModel extends MiniAppChooseBaseViewModel {
    private final MutableLiveData<LinkedList<String>> historyListUiState;
    private MiniAppChooseSearchRepository repository;
    private final MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> searchResultUiState;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MiniAppChooseSearchViewModel a;
        public final /* synthetic */ String b;

        public a(MiniAppChooseSearchViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            List r6 = (List) r5;
            MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> r0 = this.a.getSearchResultUiState();
            List r1 = r6;
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L10:
            if (r2 == false) goto L12;
            int r7 = qo0.a.a;
            qo0.a.c("choose_search", "search mini app success, keyword: " + this.b + ", result is empty");
            com.bytedance.android.live.openplatform.impl.base.utils.b r8 = new com.bytedance.android.live.openplatform.impl.base.utils.b(p.a.a);
        L13:
            r0.setValue(r8);
            return;
        L12:
            int r3 = qo0.a.a;
            qo0.a.c("choose_search", "search mini app success, keyword: " + this.b);
            r8 = new com.bytedance.android.live.openplatform.impl.base.utils.b(new p.d(r6));
            goto L13
        L5:
            if (r1.isEmpty() == true) goto L8;
            r2 = false;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MiniAppChooseSearchViewModel a;
        public final /* synthetic */ String b;

        public b(MiniAppChooseSearchViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            int r0 = qo0.a.a;
            qo0.a.b("choose_search", "search mini app fail, keyword: " + this.b, (Throwable) r3);
            this.a.getSearchResultUiState().setValue(new com.bytedance.android.live.openplatform.impl.base.utils.b(p.b.a));
        }
    }

    public final Unit deleteAllHistory() {
        MiniAppChooseSearchRepository r0 = this.repository;
        if (r0 == null) goto L9;
        LinkedList<String> r1 = r0.b.a;
        if (r1 == null) goto L11;
        qo0.a.c("choose_search", "delete all history");
        r1.clear();
        r0.b.a(r1);
    L11:
        return Unit.INSTANCE;
    L9:
        return null;
    }

    public final int getHistoryListSize() {
        MiniAppChooseSearchRepository r0 = this.repository;
        if (r0 == null) goto L8;
        LinkedList<String> r1 = r0.b.a;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.size();
    L8:
        return 0;
    }

    public final Unit loadHistoryList() {
        MiniAppChooseSearchRepository r0 = this.repository;
        if (r0 == null) goto L19;
        np0.b<LinkedList<String>> r2 = r0.b;
        m r1 = r0.a;
        r1.getClass();
        String r3 = r1.a.j(r1.b, "");     // Catch: JsonSyntaxException -> L16
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        LinkedList<String> r5 = new LinkedList();     // Catch: JsonSyntaxException -> L16
    L18:
        int r6 = qo0.a.a;
        qo0.a.c("choose_search", "load history list success: " + CollectionsKt.joinToString$default(r5, null, "[", "]", 0, null, null, 57, null));
        Unit r7 = Unit.INSTANCE;
        r2.a(r5);
        return Unit.INSTANCE;
    L14:
        r5 = (LinkedList) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r3, new l().getType());     // Catch: JsonSyntaxException -> L16
        goto L18
    L8:
        if (StringsKt.isBlank(r3) == true) goto L11;
        r4 = false;
    L16:
        e = move-exception;
        qo0.a.b("choose_search", "load local history list error", e);
        r5 = new LinkedList();
        goto L18
    L19:
        return null;
    }

    public final void saveHistoryList() {
        MiniAppChooseSearchRepository r0 = this.repository;
        if (r0 == null) goto L8;
        LinkedList<String> r1 = r0.b.a;
        if (r1 == null) goto L9;
        int r2 = qo0.a.a;
        qo0.a.c("choose_search", "save history list: " + CollectionsKt.joinToString$default(r1, null, "[", "]", 0, null, null, 57, null));
        m r3 = r0.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "newHistoryList");
        r3.a.m(r3.b, GsonProtectorUtils.toJson(GsonHelper.getDefault(), r1));
        return;
    L9:
        return;
    }

    public MiniAppChooseSearchViewModel() {
        this.historyListUiState = new MutableLiveData();
        this.searchResultUiState = new MutableLiveData();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel
    public void onCleared() {
        super.onCleared();
        qo0.a.c("choose_search", "on choose search vm cleared");
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel
    public void onScopeInitialized() {
        lp0.a r0 = getScope();
        Observable<LinkedList<String>> r1 = null;
        if (r0 == null) goto L5;
        MiniAppChooseSearchRepository r2 = (MiniAppChooseSearchRepository) lp0.b.b(r0, MiniAppChooseSearchRepository.class);
    L6:
        this.repository = r2;
        MutableLiveData<LinkedList<String>> r3 = this.historyListUiState;
        if (r2 == null) goto L9;
        r1 = r2.b.c;
    L9:
        subscribe(r3, r1, AnonymousClass1.INSTANCE);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final MutableLiveData<LinkedList<String>> getHistoryListUiState() {
        return this.historyListUiState;
    }

    public final MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> getSearchResultUiState() {
        return this.searchResultUiState;
    }

    public final Unit deleteHistory(String r5) {
        Intrinsics.checkNotNullParameter(r5, "keyword");
        MiniAppChooseSearchRepository r1 = this.repository;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "keyword");
        LinkedList<String> r0 = r1.b.a;
        if (r0 == null) goto L14;
        int r2 = qo0.a.a;
        qo0.a.c("choose_search", "delete history, keyword: " + r5);
        if (r0.contains(r5) == false) goto L10;
        r0.remove(r5);
    L10:
        r1.b.a(r0);
    L14:
        return Unit.INSTANCE;
    L12:
        return null;
    }

    public final void searchMiniApp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "keyword");
        this.searchResultUiState.setValue(new com.bytedance.android.live.openplatform.impl.base.utils.b(p.c.a));
        MiniAppChooseSearchRepository r1 = this.repository;
        if (r1 == null) goto L20;
        long r2 = getScene();
        long r4 = getRoomId();
        Intrinsics.checkNotNullParameter(r10, "keyword");
        int r0 = qo0.a.a;
        qo0.a.c("choose_search", "start search mini app, keyword: " + r10);
        LinkedList<String> r3 = r1.b.a;
        if (r3 == null) goto L14;
        qo0.a.c("choose_search", "add keyword to history: " + r10 + ", size: " + r3.size());
        if (r3.contains(r10) == false) goto L10;
        r3.remove(r10);
    L10:
        r3.add(r10);
        if (r3.size() <= 5) goto L13;
        r3.poll();
    L13:
        r1.b.a(r3);
    L14:
        Lazy r5 = LiveOpenPlatformClient.c;
        Observable r6 = ((ChooseApi) LiveOpenPlatformClient.a.a().a(ChooseApi.class)).searchMiniApp(r2, Long.valueOf(r4), r10).compose(RxUtil.rxSchedulerHelper()).map(kp0.a.a);
        if (r6 == null) goto L21;
        Disposable r11 = r6.subscribe(new a(this, r10), new b(this, r10));
        if (r11 == null) goto L22;
        autoDispose(r11);
        return;
    L22:
        return;
    L21:
        return;
    }
}
