package com.bytedance.android.livesdk.feed.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.media.IPlayable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.b1;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.bytedance.android.livesdk.feed.repository.FeedRepository;
import com.bytedance.common.utility.StringUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BaseFeedDataViewModel extends PagingViewModel<FeedItem> {
    protected MutableLiveData<List<ImageModel>> covers;
    private com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> dataPair;
    protected String eventType;
    private long extraId;
    protected Map<String, Object> extraMapForSaas;
    protected FeedDataKey feedDataKey;
    protected IFeedRepository feedRepository;
    protected MutableLiveData<BaseFeedRepository.ApiDataStatus> loadMoreApiStatus;
    protected MutableLiveData<Integer> loadMoreNum;
    private int pageSize;
    protected MutableLiveData<IPlayable> playItem;
    protected MutableLiveData<Integer> pos;
    private int prefetchSize;
    protected MutableLiveData<BaseFeedRepository.ApiDataStatus> refreshApiStatus;
    protected MutableLiveData<Integer> refreshNum;
    protected Listing<FeedItem> repoResult;
    private com.bytedance.android.livesdk.feed.feed.b shareExtra;
    protected String url;
    private hw1.a userCenter;
    private MutableLiveData<IBaseUser.Status> userStatus;

    public class a implements IFeedRepository.a {
        public final /* synthetic */ BaseFeedDataViewModel a;

        public final FeedDataKey a() {
            return this.a.feedDataKey();
        }

        public a(BaseFeedDataViewModel r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void To(BaseFeedDataViewModel r0, List r1) {
        r0.onLoadMoreCover(r1);
    }

    public static /* synthetic */ void Wo(BaseFeedDataViewModel r0, BaseFeedRepository.ApiDataStatus r1) {
        r0.lambda$registerFollowStatusChange$5(r1);
    }

    public static /* synthetic */ void Yo(BaseFeedDataViewModel r0, BaseFeedRepository.ApiDataStatus r1) {
        r0.lambda$start$3(r1);
    }

    public static /* synthetic */ void Zo(BaseFeedDataViewModel r0, IPlayable r1) {
        r0.lambda$start$1(r1);
    }

    public static /* synthetic */ void ap(BaseFeedDataViewModel r0, String r1) {
        r0.lambda$start$2(r1);
    }

    public static /* synthetic */ void bp(BaseFeedDataViewModel r0, Integer r1) {
        r0.lambda$start$0(r1);
    }

    public static /* synthetic */ void cp(BaseFeedDataViewModel r0, BaseFeedRepository.ApiDataStatus r1) {
        r0.lambda$start$4(r1);
    }

    public void mocRefresh(String r1) {
    }

    public void onStarted() {
    }

    public boolean scrollTop() {
        return false;
    }

    public FeedDataKey buildFeedDataKey() {
        return FeedDataKey.a(this.eventType, getUrl(), this.extraId);
    }

    public FeedDataKey feedDataKey() {
        if (this.feedDataKey != null) goto L6;
        this.feedDataKey = buildFeedDataKey();
    L6:
        return this.feedDataKey;
    }

    public void initParams() {
        this.feedRepository.Nd(new a(this));
    }

    public void registerFollowStatusChange() {
        this.loadMoreApiStatus.observeForever(new g(this));
    }

    public void start() {
        com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> r0 = this.feedRepository.p60(getUrl(), getExtraMapForSaas());     // Catch: Exception -> L7
        this.dataPair = r0;     // Catch: Exception -> L7
        this.repoResult = r0.a;     // Catch: Exception -> L7
        com.bytedance.android.livesdk.feed.feed.b r1 = r0.b;     // Catch: Exception -> L7
        this.shareExtra = r1;     // Catch: Exception -> L7
        r1.a.observeForever(new com.bytedance.android.livesdk.feed.viewmodel.a(this));     // Catch: Exception -> L7
        this.shareExtra.b.observeForever(new b(this));     // Catch: Exception -> L7
        register(this.repoResult);     // Catch: Exception -> L7
        registerFollowStatusChange();     // Catch: Exception -> L7
        register(this.feedRepository.GZ().observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new g60.c()));     // Catch: Exception -> L7
        register(this.feedRepository.CP().observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new g60.c()));     // Catch: Exception -> L7
        ItemRepository r2 = this.feedRepository;     // Catch: Exception -> L7
        if ((r2 instanceof BaseFeedRepository) == false) goto L5;
        register(((BaseFeedRepository) r2).d.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new g60.c()));     // Catch: Exception -> L7
        register(((BaseFeedRepository) this.feedRepository).e.observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), new g60.c()));     // Catch: Exception -> L7
    L5:
        mocRefresh("enter_auto");     // Catch: Exception -> L7
    L9:
        onStarted();
        return;
    L7:
        e = move-exception;
        ALogger.i("BaseFeedDataViewModel", e.getMessage());
        goto L9
    }

    public boolean refresh() {
        boolean r0 = super.refresh();
        if (r0 == false) goto L5;
        this.pos.setValue(0);
    L5:
        return r0;
    }

    private Map<String, Object> getExtraMapForSaas() {
        return this.extraMapForSaas;
    }

    public LiveData<List<ImageModel>> covers() {
        return this.covers;
    }

    public String event() {
        return this.eventType;
    }

    public IFeedRepository feedRepository() {
        return this.feedRepository;
    }

    public String getUrl() {
        return this.url;
    }

    public LiveData<Integer> loadMoreNum() {
        return this.loadMoreNum;
    }

    public LiveData<BaseFeedRepository.ApiDataStatus> loadMoreStatus() {
        return this.loadMoreApiStatus;
    }

    public LiveData<IPlayable> playItem() {
        return this.playItem;
    }

    public LiveData<Integer> pos() {
        return this.pos;
    }

    public LiveData<BaseFeedRepository.ApiDataStatus> refreshApiStatus() {
        return this.refreshApiStatus;
    }

    public LiveData<Integer> refreshNum() {
        return this.refreshNum;
    }

    public LiveData<IBaseUser.Status> userStatus() {
        return this.userStatus;
    }

    public static /* synthetic */ int access$000(BaseFeedDataViewModel r0) {
        return r0.pageSize;
    }

    public static /* synthetic */ int access$100(BaseFeedDataViewModel r0) {
        return r0.prefetchSize;
    }

    private void increaseUserRefresh(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r3, "enter_auto") == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r3, "detail_loadmore") == false) goto L10;
        return;
    L10:
        if (this.userCenter.isLogin() == true) goto L12;
        return;
    L12:
        Integer r4 = (Integer) this.refreshNum.getValue();
        if (r4 != null) goto L15;
        this.refreshNum.setValue(1);
        return;
    L15:
        this.refreshNum.setValue(Integer.valueOf(r4.intValue() + 1));
    }

    private /* synthetic */ void lambda$registerFollowStatusChange$5(BaseFeedRepository.ApiDataStatus r2) {
        if (r2 != BaseFeedRepository.ApiDataStatus.SUCCESS) goto L9;
        Integer r3 = (Integer) this.loadMoreNum.getValue();
        if (r3 != null) goto L7;
        r3 = 0;
    L7:
        this.loadMoreNum.setValue(Integer.valueOf(r3.intValue() + 1));
        return;
    }

    private /* synthetic */ void lambda$start$0(Integer r2) {
        this.pos.setValue(r2);
    }

    private /* synthetic */ void lambda$start$1(IPlayable r2) {
        this.playItem.setValue(r2);
    }

    private /* synthetic */ void lambda$start$2(String r1) throws Exception {
        increaseUserRefresh(r1);
    }

    private /* synthetic */ void lambda$start$3(BaseFeedRepository.ApiDataStatus r2) throws Exception {
        this.refreshApiStatus.setValue(r2);
    }

    private /* synthetic */ void lambda$start$4(BaseFeedRepository.ApiDataStatus r2) throws Exception {
        this.loadMoreApiStatus.setValue(r2);
    }

    private void onLoadMoreCover(List<ImageModel> r2) {
        this.covers.setValue(r2);
    }

    public final boolean refresh(String r3) {
        this.feedRepository.setReqFrom(r3, null);
        increaseUserRefresh(r3);
        boolean r0 = refresh();
        if (r0 == false) goto L5;
        mocRefresh(r3);
    L5:
        return r0;
    }

    public void setLiveForceParams(b1 r3) {
        IFeedRepository r0 = this.feedRepository;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof FeedRepository) == false) goto L11;
        FeedRepository r1 = (FeedRepository) r0;
        r1.w = r3;
        FeedRepository.a r2 = r1.t;
        if (r2 == null) goto L12;
        r2.m = r3;
        return;
    L12:
        return;
    }

    public void updateFeedDataKey(FeedDataKey r1) {
        this.feedDataKey = r1;
    }

    public void setReqFrom(String r2, String r3) {
        IFeedRepository r0 = this.feedRepository;
        if (r0 == null) goto L6;
        r0.setReqFrom(r2, r3);
        return;
    }

    public void updateUrlAndEvent(String r2, String r3) {
        if (StringUtils.isEmpty(r2) == true) goto L6;
        this.url = r2;
    L6:
        if (StringUtils.isEmpty(r3) == true) goto L9;
        this.eventType = r3;
        return;
    }

    public BaseFeedDataViewModel(IFeedRepository r3, com.bytedance.android.livesdk.feed.g r4, hw1.a r5) {
        this.pos = new MutableLiveData();
        this.playItem = new MutableLiveData();
        this.refreshNum = new MutableLiveData();
        this.loadMoreNum = new MutableLiveData();
        this.covers = new MutableLiveData();
        this.refreshApiStatus = new MutableLiveData();
        this.loadMoreApiStatus = new MutableLiveData();
        this.userStatus = new MutableLiveData();
        this.feedRepository = r3;
        if (r4 == null) goto L6;
        this.url = r4.url();
        this.pageSize = r4.f8();
        this.prefetchSize = r4.I9();
        this.eventType = r4.sR();
        this.userCenter = r5;
        this.extraId = r4.hC();
        this.extraMapForSaas = r4.SR();
        initParams();
        return;
    }
}
