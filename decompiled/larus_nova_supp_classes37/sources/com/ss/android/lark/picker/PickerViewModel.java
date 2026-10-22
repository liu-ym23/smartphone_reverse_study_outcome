package com.ss.android.lark.picker;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import z3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/PickerViewModel;", "Landroidx/lifecycle/ViewModel;", "pickerTracker", "Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "<init>", "(Lcom/ss/android/lark/picker/base/statistics/PickerTracker;)V", "getPickerTracker", "()Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "configDelegate", "Lkotlin/Function0;", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "getConfigDelegate", "()Lkotlin/jvm/functions/Function0;", "setConfigDelegate", "(Lkotlin/jvm/functions/Function0;)V", "searcher", "Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "getSearcher", "()Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "searcher$delegate", "Lkotlin/Lazy;", "spotlightSearcher", "getSpotlightSearcher", "spotlightSearcher$delegate", "createSearcher", "isSpotlight", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerViewModel extends ViewModel {
    private Function0<? extends SearcherConfig> configDelegate;
    private final PickerTracker pickerTracker;
    private final Lazy searcher$delegate;
    private final Lazy spotlightSearcher$delegate;

    /* JADX INFO: renamed from: com.ss.android.lark.picker.PickerViewModel$createSearcher$1, reason: invalid class name */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"com/ss/android/lark/picker/PickerViewModel$createSearcher$1", "Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "innerSearcher", "Lcom/ss/android/lark/picker/Searcher;", "config", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "getConfig", "()Lcom/ss/android/lark/picker/config/SearcherConfig;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/search/dto/SearchResponse;", "getCallback", "()Lcom/larksuite/framework/callback/IGetDataCallback;", "setCallback", "(Lcom/larksuite/framework/callback/IGetDataCallback;)V", "onSearch", "", "requestId", "", "context", "Lcom/ss/android/lark/search/dto/service/SearchContext;", "onLoadMore", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class AnonymousClass1 implements a {
        final /* synthetic */ boolean $isSpotlight;
        private IGetDataCallback<SearchResponse> callback;
        private final Searcher innerSearcher;
        final /* synthetic */ PickerViewModel this$0;

        public void onLoadMore(String r1, SearchContext r2, IGetDataCallback<SearchResponse> r3) {
            Intrinsics.checkNotNullParameter(r1, "requestId");
            Intrinsics.checkNotNullParameter(r3, "callback");
        }

        public final SearcherConfig getConfig() {
            Function0<SearcherConfig> r0 = this.this$0.getConfigDelegate();
            if (r0 != null) goto L7;
            return null;
        L7:
            return (SearcherConfig) r0.invoke();
        }

        public final IGetDataCallback<SearchResponse> getCallback() {
            return this.callback;
        }

        public static final /* synthetic */ Searcher access$getInnerSearcher$p(AnonymousClass1 r0) {
            return r0.innerSearcher;
        }

        public final void setCallback(IGetDataCallback<SearchResponse> r1) {
            this.callback = r1;
        }

        public AnonymousClass1(PickerViewModel r1, boolean r2) {
            this.this$0 = r1;
            this.$isSpotlight = r2;
            this.innerSearcher = new Searcher(r1.getPickerTracker());
        }

        public void onLoadMore(String r7, SearchContext r8) {
            Intrinsics.checkNotNullParameter(r7, "requestId");
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new PickerViewModel$createSearcher$1$onLoadMore$1(this, r7, null), 3, null);
        }

        public void onSearch(String r12, SearchContext r13, IGetDataCallback<SearchResponse> r14) {
            Intrinsics.checkNotNullParameter(r12, "requestId");
            Intrinsics.checkNotNullParameter(r13, "context");
            Intrinsics.checkNotNullParameter(r14, "callback");
            this.callback = r14;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new PickerViewModel$createSearcher$1$onSearch$1(this, r12, r13, this.$isSpotlight, r14, null), 3, null);
        }
    }

    public PickerViewModel() {
        PickerTracker r0 = null;
        this(r0, 1, r0);
    }

    public final a getSearcher() {
        return (a) this.searcher$delegate.getValue();
    }

    public final a getSpotlightSearcher() {
        return (a) this.spotlightSearcher$delegate.getValue();
    }

    public final Function0<SearcherConfig> getConfigDelegate() {
        return this.configDelegate;
    }

    public final PickerTracker getPickerTracker() {
        return this.pickerTracker;
    }

    public PickerViewModel(PickerTracker r1) {
        this.pickerTracker = r1;
        this.searcher$delegate = LazyKt.lazy(new PickerViewModel$searcher$2(this));
        this.spotlightSearcher$delegate = LazyKt.lazy(new PickerViewModel$spotlightSearcher$2(this));
    }

    private final a createSearcher(boolean r2) {
        return new AnonymousClass1(this, r2);
    }

    public final void setConfigDelegate(Function0<? extends SearcherConfig> r1) {
        this.configDelegate = r1;
    }

    public static final /* synthetic */ a access$createSearcher(PickerViewModel r0, boolean r1) {
        return r0.createSearcher(r1);
    }

    public /* synthetic */ PickerViewModel(PickerTracker r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
