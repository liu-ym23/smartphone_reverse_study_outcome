package com.bytedance.android.live.ktv.common.search.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.karaokestation.model.g;
import com.bytedance.android.live.ktv.common.karaokestation.model.h;
import com.bytedance.android.live.ktv.common.karaokestation.model.i;
import com.bytedance.android.live.ktv.common.karaokestation.model.l;
import com.bytedance.android.live.ktv.common.karaokestation.model.m;
import com.bytedance.android.live.ktv.common.karaokestation.model.r;
import com.bytedance.android.live.ktv.common.model.api.a0;
import com.bytedance.android.live.ktv.common.model.api.b0;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.model.api.z;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.plantform.utils.h0;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mb0.d;
import nb0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001pB\u000f\u0012\u0006\u0010k\u001a\u00020j¢\u0006\u0004\bm\u0010nJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002JK\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020#H\u0016J&\u0010*\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010(0'H\u0016J&\u0010,\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010(0'H\u0016J&\u0010.\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010(0'H\u0016J&\u00100\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010(0'H\u0016J\u0010\u00102\u001a\n\u0012\u0004\u0012\u00020/\u0018\u000101H\u0016J\u0018\u00104\u001a\u00020\u00052\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010(H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u00108\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010:\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020#H\u0016J;\u0010?\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010@R\u0016\u0010A\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010;\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010BR\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR'\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR'\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010E\u001a\u0004\bO\u0010LR'\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010E\u001a\u0004\bR\u0010LR'\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010E\u001a\u0004\bU\u0010LR'\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010E\u001a\u0004\bY\u0010ZR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u0003018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020/018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010@R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010bR\u0016\u0010c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010bR\u0016\u0010d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010`R\u0016\u0010e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010@R\u0016\u0010f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010`R\u0016\u0010g\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010`R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010bR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006q"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/viewmodel/CommonSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "", "history", "", "addSearchHistory", "keyWords", "", "isNew", "searchContentType", "isGuess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "requestCallback", "doSearch", "getSearchContentType", "", "historyCountPerPage", "updateHistoryCountPerPage", "hasMoreSearchResult", "Lxb0/a;", "extraRequestData", "updateExtraRequestData", "getExtraRequestData", "keyWord", "syncGuessWords", "removeSearchHistory", "syncHotWords", "loadSearchHistory", "hotWord", "isHistory", "onHotWordClick", "Lcom/bytedance/android/live/ktv/common/ordersong/feedback/a;", "getCurPredicateContent", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "observer", "observeHistoryListChange", "Lcom/bytedance/android/live/ktv/common/model/api/u;", "observeHotWordListChange", "Lcom/bytedance/android/live/ktv/common/model/api/s;", "observeGuessWordListChange", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "observeSearchedMusicListChange", "", "getSearchedMusicList", "panelList", "updateSearchedMusicList", "getCurSearchInitText", "text", "updateSearchInitText", "getCurSearchKeyword", "curSearchKeyword", "updateCurSearchKeyword", "predicateContent", "updatePredicateContent", "fromRequestPage", "subTab", "continueSearch", "I", "maxHistoryCount", "Lcom/bytedance/android/live/ktv/common/ordersong/feedback/a;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose$delegate", "Lkotlin/Lazy;", "getCompositeDispose", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Landroidx/lifecycle/MutableLiveData;", "historyList$delegate", "getHistoryList", "()Landroidx/lifecycle/MutableLiveData;", "historyList", "mSearchedMusicList$delegate", "getMSearchedMusicList", "mSearchedMusicList", "guessWordList$delegate", "getGuessWordList", "guessWordList", "hotWordList$delegate", "getHotWordList", "hotWordList", "Lcom/bytedance/android/livesdk/sharedpref/e;", "historyCache$delegate", "getHistoryCache", "()Lcom/bytedance/android/livesdk/sharedpref/e;", "historyCache", "histories", "Ljava/util/List;", "searchList", "currentSearchKeywords", "Ljava/lang/String;", "currentSearchPage", "Z", "isSearching", "lastSearchId", "lastQuerySource", "mSearchContentType", "mExtraRequestData", "Lxb0/a;", "searchInitText", "Lnb0/b;", "orderSongHandler", "Lnb0/b;", "<init>", "(Lnb0/b;)V", "Companion", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchViewModel extends ViewModel implements com.bytedance.android.live.ktv.common.search.viewmodel.a {
    public static final a Companion = null;
    public static final int HISTORY_COUNT_PER_PAGE = 8;
    public static final int MAX_HISTORY_COUNT = 10;
    public static final String TAG = "CommonSearchViewModel";
    private final Lazy compositeDispose$delegate;
    private String currentSearchKeywords;
    private int currentSearchPage;
    private final Lazy guessWordList$delegate;
    private boolean hasMoreSearchResult;
    private List<String> histories;
    private final Lazy historyCache$delegate;
    private int historyCountPerPage;
    private final Lazy historyList$delegate;
    private final Lazy hotWordList$delegate;
    private boolean isGuess;
    private boolean isSearching;
    private int lastQuerySource;
    private String lastSearchId;
    private xb0.a mExtraRequestData;
    private String mSearchContentType;
    private final Lazy mSearchedMusicList$delegate;
    private int maxHistoryCount;
    private final b orderSongHandler;
    private com.bytedance.android.live.ktv.common.ordersong.feedback.a predicateContent;
    private String searchInitText;
    private List<MusicPanel> searchList;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static com.bytedance.android.live.ktv.common.search.viewmodel.a a(ViewModelStoreOwner r2, b r3) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            Intrinsics.checkNotNullParameter(r3, "ktvOrderSongHandler");
            return new ViewModelProvider(r2, new CommonSearchViewModelFactory(r3)).get(CommonSearchViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDispose() {
        return (CompositeDisposable) this.compositeDispose$delegate.getValue();
    }

    private final MutableLiveData<List<s>> getGuessWordList() {
        return (MutableLiveData) this.guessWordList$delegate.getValue();
    }

    private final e<List<String>> getHistoryCache() {
        return (e) this.historyCache$delegate.getValue();
    }

    private final MutableLiveData<List<String>> getHistoryList() {
        return (MutableLiveData) this.historyList$delegate.getValue();
    }

    private final MutableLiveData<List<u>> getHotWordList() {
        return (MutableLiveData) this.hotWordList$delegate.getValue();
    }

    private final MutableLiveData<List<MusicPanel>> getMSearchedMusicList() {
        return (MutableLiveData) this.mSearchedMusicList$delegate.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.live.ktv.common.search.viewmodel.a newInstance(ViewModelStoreOwner r1, b r2) {
        Companion.getClass();
        return a.a(r1, r2);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public List<MusicPanel> getSearchedMusicList() {
        return (List) getMSearchedMusicList().getValue();
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void loadSearchHistory() {
        this.histories = (List) getHistoryCache().getValue();
        getHistoryList().setValue(this.histories);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void syncHotWords() {
        long r0 = System.currentTimeMillis();
        long r2 = this.orderSongHandler.getRoomInfo().a;
        int r4 = this.orderSongHandler.g();
        int r5 = g.a;
        g r6 = g.b.a;
        Function1<com.bytedance.android.live.network.response.e<a0>, Unit> r7 = new C03281(this);
        C03292 r8 = C03292.INSTANCE;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "failCallback");
        KtvCommonApi r9 = (KtvCommonApi) c.b().e(KtvCommonApi.class);
        if (r9 == null) goto L9;
        Observable<com.bytedance.android.live.network.response.e<a0>> r3 = r9.getHotWords(r2, r4);
        if (r3 == null) goto L9;
        Observable r11 = r3.compose(RxUtil.rxSchedulerHelper());
        if (r11 == null) goto L9;
        Disposable r1 = r11.subscribe(new h(r0, r7), new i(r0, r8));
    L10:
        if (r1 == null) goto L13;
        RxUtilKt.c(r1, getCompositeDispose());
        return;
    L13:
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public com.bytedance.android.live.ktv.common.ordersong.feedback.a getCurPredicateContent() {
        return this.predicateContent;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public String getCurSearchInitText() {
        return this.searchInitText;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public String getCurSearchKeyword() {
        return this.currentSearchKeywords;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public xb0.a getExtraRequestData() {
        return this.mExtraRequestData;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public String getSearchContentType() {
        return this.mSearchContentType;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public boolean hasMoreSearchResult() {
        return this.hasMoreSearchResult;
    }

    public CommonSearchViewModel(b r4) {
        Intrinsics.checkNotNullParameter(r4, "orderSongHandler");
        this.orderSongHandler = r4;
        if ((!h0.a.booleanValue()) == false) goto L5;
        int r5 = h0.c.intValue();
    L6:
        this.historyCountPerPage = r5;
        this.maxHistoryCount = 10;
        this.predicateContent = new com.bytedance.android.live.ktv.common.ordersong.feedback.a("", "");
        this.compositeDispose$delegate = LazyKt.lazy(CommonSearchViewModel$compositeDispose$2.INSTANCE);
        this.historyList$delegate = LazyKt.lazy(CommonSearchViewModel$historyList$2.INSTANCE);
        this.mSearchedMusicList$delegate = LazyKt.lazy(CommonSearchViewModel$mSearchedMusicList$2.INSTANCE);
        this.guessWordList$delegate = LazyKt.lazy(CommonSearchViewModel$guessWordList$2.INSTANCE);
        this.hotWordList$delegate = LazyKt.lazy(CommonSearchViewModel$hotWordList$2.INSTANCE);
        this.historyCache$delegate = LazyKt.lazy(CommonSearchViewModel$historyCache$2.INSTANCE);
        this.histories = new ArrayList();
        this.searchList = new ArrayList();
        this.currentSearchPage = 1;
        this.hasMoreSearchResult = true;
        this.lastSearchId = "";
        this.mSearchContentType = "";
        this.mExtraRequestData = new xb0.a(null, 7);
        this.searchInitText = "";
        return;
    L5:
        r5 = 8;
        goto L6
    }

    public static final /* synthetic */ int access$getCurrentSearchPage$p(CommonSearchViewModel r0) {
        return r0.currentSearchPage;
    }

    public static final /* synthetic */ MutableLiveData access$getGuessWordList$p(CommonSearchViewModel r0) {
        return r0.getGuessWordList();
    }

    public static final /* synthetic */ boolean access$getHasMoreSearchResult$p(CommonSearchViewModel r0) {
        return r0.hasMoreSearchResult;
    }

    public static final /* synthetic */ MutableLiveData access$getHotWordList$p(CommonSearchViewModel r0) {
        return r0.getHotWordList();
    }

    public static final /* synthetic */ int access$getLastQuerySource$p(CommonSearchViewModel r0) {
        return r0.lastQuerySource;
    }

    public static final /* synthetic */ String access$getLastSearchId$p(CommonSearchViewModel r0) {
        return r0.lastSearchId;
    }

    public static final /* synthetic */ xb0.a access$getMExtraRequestData$p(CommonSearchViewModel r0) {
        return r0.mExtraRequestData;
    }

    public static final /* synthetic */ MutableLiveData access$getMSearchedMusicList$p(CommonSearchViewModel r0) {
        return r0.getMSearchedMusicList();
    }

    public static final /* synthetic */ b access$getOrderSongHandler$p(CommonSearchViewModel r0) {
        return r0.orderSongHandler;
    }

    public static final /* synthetic */ List access$getSearchList$p(CommonSearchViewModel r0) {
        return r0.searchList;
    }

    public static final /* synthetic */ boolean access$isSearching$p(CommonSearchViewModel r0) {
        return r0.isSearching;
    }

    private final void addSearchHistory(String r3) {
        getHistoryList().setValue(null);
        this.histories.remove(r3);
        ListProtector.add(this.histories, 0, r3);
        if (this.histories.size() <= this.maxHistoryCount) goto L5;
        List<String> r4 = this.histories;
        ListProtector.remove(r4, r4.size() - 1);
    L5:
        e<List<String>> r5 = getHistoryCache();
        List<String> r0 = this.histories;
        r5.getClass();
        f.d(r5, r0);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void removeSearchHistory(String r2) {
        Intrinsics.checkNotNullParameter(r2, "history");
        this.histories.remove(r2);
        e<List<String>> r3 = getHistoryCache();
        List<String> r0 = this.histories;
        r3.getClass();
        f.d(r3, r0);
        getHistoryList().setValue(this.histories);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void syncGuessWords(String r11) {
        Intrinsics.checkNotNullParameter(r11, "keyWord");
        long r0 = System.currentTimeMillis();
        long r2 = this.orderSongHandler.getRoomInfo().a;
        int r4 = g.a;
        g r5 = g.b.a;
        int r6 = this.orderSongHandler.g();
        Function1<com.bytedance.android.live.network.response.e<z>, Unit> r7 = new C03261(this);
        C03272 r8 = C03272.INSTANCE;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "keyword");
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "failCallback");
        KtvCommonApi r9 = (KtvCommonApi) c.b().e(KtvCommonApi.class);
        if (r9 == null) goto L9;
        Observable<com.bytedance.android.live.network.response.e<z>> r12 = r9.getSearchSug(r11, r2, r6);
        if (r12 == null) goto L9;
        Observable r13 = r12.compose(RxUtil.rxSchedulerHelper());
        if (r13 == null) goto L9;
        Disposable r14 = r13.subscribe(new l(r0, r7), new m(r0, r8));
    L10:
        if (r14 == null) goto L13;
        RxUtilKt.c(r14, getCompositeDispose());
        return;
    L13:
        return;
    L9:
        r14 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void updateCurSearchKeyword(String r1) {
        this.currentSearchKeywords = r1;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void updateExtraRequestData(xb0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "extraRequestData");
        this.mExtraRequestData = r2;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void updateHistoryCountPerPage(int r2) {
        if ((!h0.a.booleanValue()) == true) goto L6;
        this.historyCountPerPage = r2;
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void updatePredicateContent(com.bytedance.android.live.ktv.common.ordersong.feedback.a r2) {
        Intrinsics.checkNotNullParameter(r2, "predicateContent");
        this.predicateContent = r2;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void updateSearchInitText(String r1) {
        this.searchInitText = r1;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void updateSearchedMusicList(List<MusicPanel> r3) {
        if (r3 == null) goto L6;
        List<MusicPanel> r4 = r3;
        if ((!r4.isEmpty()) != true) goto L6;
        getMSearchedMusicList().setValue(CollectionsKt.toMutableList(r4));
        return;
    L6:
        getMSearchedMusicList().setValue(getSearchedMusicList());
    }

    public static final /* synthetic */ void access$setCurrentSearchPage$p(CommonSearchViewModel r0, int r1) {
        r0.currentSearchPage = r1;
    }

    public static final /* synthetic */ void access$setHasMoreSearchResult$p(CommonSearchViewModel r0, boolean r1) {
        r0.hasMoreSearchResult = r1;
    }

    public static final /* synthetic */ void access$setLastQuerySource$p(CommonSearchViewModel r0, int r1) {
        r0.lastQuerySource = r1;
    }

    public static final /* synthetic */ void access$setLastSearchId$p(CommonSearchViewModel r0, String r1) {
        r0.lastSearchId = r1;
    }

    public static final /* synthetic */ void access$setMExtraRequestData$p(CommonSearchViewModel r0, xb0.a r1) {
        r0.mExtraRequestData = r1;
    }

    public static final /* synthetic */ void access$setSearchList$p(CommonSearchViewModel r0, List r1) {
        r0.searchList = r1;
    }

    public static final /* synthetic */ void access$setSearching$p(CommonSearchViewModel r0, boolean r1) {
        r0.isSearching = r1;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void observeGuessWordListChange(LifecycleOwner r2, Observer<List<s>> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        getGuessWordList().observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void observeHistoryListChange(LifecycleOwner r2, Observer<List<String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        getHistoryList().observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void observeHotWordListChange(LifecycleOwner r2, Observer<List<u>> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        getHotWordList().observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void observeSearchedMusicListChange(LifecycleOwner r2, Observer<List<MusicPanel>> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        getMSearchedMusicList().observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void onHotWordClick(String r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "hotWord");
        pb0.a r0 = pb0.b.a;
        Intrinsics.checkNotNullParameter(r9, "searchWord");
        Intrinsics.checkNotNullParameter("audience_sing", "function");
        pb0.a r2 = pb0.b.a;
        if (r2 == null) goto L6;
        r2.i(r9, j.d(), j.a(null), r11, com.bytedance.android.live.ktv.common.util.a.e());
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void continueSearch(String r7, String r8, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "fromRequestPage");
        Intrinsics.checkNotNullParameter(r8, "subTab");
        Intrinsics.checkNotNullParameter(r9, "requestCallback");
        String r11 = this.currentSearchKeywords;
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        doSearch(r11, false, this.mSearchContentType, this.isGuess, r9);
    }

    @Override // com.bytedance.android.live.ktv.common.search.viewmodel.a
    public void doSearch(String r8, boolean r9, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "keyWord");
        Intrinsics.checkNotNullParameter(r11, "searchContentType");
        this.mSearchContentType = r11;
        this.isGuess = r12;
        doSearch(r8, r9, r11, r12, AnonymousClass1.INSTANCE);
    }

    private final void doSearch(final String r23, final boolean r24, final String r25, boolean r26, final Function1<? super Boolean, Unit> r27) {
        this.mSearchContentType = r25;
        this.isGuess = r26;
        if (r24 == false) goto L6;
        addSearchHistory(r23);
        updateCurSearchKeyword(r23);
        this.currentSearchPage = 1;
        this.hasMoreSearchResult = true;
        this.lastSearchId = "";
        this.searchList.clear();
    L6:
        if (this.hasMoreSearchResult == true) goto L8;
        return;
    L8:
        if (this.isSearching == true) goto L43;
        if (r24 == false) goto L16;
        pb0.a r2 = pb0.b.a;
        String r3 = this.mExtraRequestData.b;
        if (r3 != null) goto L13;
        r3 = "搜索";
    L13:
        String r4 = this.orderSongHandler.h();
        Intrinsics.checkNotNullParameter(r23, "searchContent");
        pb0.a r5 = pb0.b.a;
        if (r5 == null) goto L16;
        r5.p(r23, r25, r3, r4);
    L16:
        mb0.c r6 = d.a;
        Intrinsics.checkNotNullParameter(r23, "keyword");
        mb0.c r7 = d.a;
        if (r7 == null) goto L19;
        r7.k(r23);
    L19:
        this.isSearching = true;
        long r14 = System.currentTimeMillis();
        String r11 = this.orderSongHandler.getRoomInfo().b;
        long r12 = this.orderSongHandler.getRoomInfo().a;
        int r1 = g.a;
        g r8 = g.b.a;
        int r9 = this.currentSearchPage;
        int r13 = this.historyCountPerPage;
        int r16 = this.orderSongHandler.g();
        String r15 = this.lastSearchId;
        KtvCommonApi.a.getClass();
        Intrinsics.checkNotNullParameter(r25, "type");
        if (Intrinsics.areEqual(r25, "ugc") == false) goto L25;
        if (r26 == false) goto L23;
        KtvCommonApi.Companion.QuerySource r0 = KtvCommonApi.Companion.QuerySource.SugWords;
    L31:
        int r18 = r0.ordinal();
        String r19 = this.orderSongHandler.getRequiredSongInfo();
        Function1<com.bytedance.android.live.network.response.e<b0>, Unit> r17 = new AnonymousClass2(this, r24, r25, r23, r27);
        Function1<Throwable, Unit> r21 = new AnonymousClass3(this, r27);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r23, "query");
        Intrinsics.checkNotNullParameter(r11, "anchorId");
        Intrinsics.checkNotNullParameter(r15, "searchId");
        Intrinsics.checkNotNullParameter(r17, "successCallback");
        Intrinsics.checkNotNullParameter(r21, "failCallback");
        KtvCommonApi r22 = (KtvCommonApi) c.b().e(KtvCommonApi.class);
        if (r22 == null) goto L38;
        Observable<com.bytedance.android.live.network.response.e<b0>> r28 = r22.searchSong(r23, d5.c(r11), r11, r12, r9, r13, r16, r15, r18, r19);
        if (r28 == null) goto L38;
        Observable r29 = r28.compose(RxUtil.rxSchedulerHelper());
        if (r29 == null) goto L38;
        Disposable r31 = r29.subscribe(new r(r14, r17), new com.bytedance.android.live.ktv.common.karaokestation.model.s(r14, r21));
    L39:
        if (r31 == null) goto L44;
        RxUtilKt.c(r31, getCompositeDispose());
        return;
    L44:
        return;
    L38:
        r31 = null;
        goto L39
    L23:
        r0 = KtvCommonApi.Companion.QuerySource.UserInput;
        goto L31
    L25:
        if (Intrinsics.areEqual(r25, "hot") == false) goto L28;
        r0 = KtvCommonApi.Companion.QuerySource.HotWords;
        goto L31
    L28:
        if (Intrinsics.areEqual(r25, "history") == false) goto L30;
        r0 = KtvCommonApi.Companion.QuerySource.SearchHistory;
        goto L31
    L30:
        r0 = KtvCommonApi.Companion.QuerySource.Unknown;
        goto L31
    }
}
