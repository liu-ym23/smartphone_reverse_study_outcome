package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.api.ChooseApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J(\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ \u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u000fH\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/MiniAppChooseListViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBaseViewModel;", "Lkotlin/Result;", "Lip0/b;", "result", "", "groupId", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/b;", "toEntranceCellListUiState", "(Ljava/lang/Object;J)Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/b;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/a;", "toBannerListUiState", "(Ljava/lang/Object;)Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/a;", "", "isPunished", "", "onScopeInitialized", "fetchMiniAppGroupedList", "", "getRecentlyUsedListSize", "", "getFeatureTipContent", "onCleared", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/repository/MiniAppListRepository;", "repository", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/repository/MiniAppListRepository;", "Landroidx/lifecycle/MutableLiveData;", "Lfp0/c;", "loadState", "Landroidx/lifecycle/MutableLiveData;", "getLoadState", "()Landroidx/lifecycle/MutableLiveData;", "recentlyUsedListUiState", "getRecentlyUsedListUiState", "recommendListUiState", "getRecommendListUiState", "bannerListUiState", "getBannerListUiState", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseListViewModel extends MiniAppChooseBaseViewModel {
    private final MutableLiveData<a> bannerListUiState;
    private final MutableLiveData<fp0.c> loadState;
    private final MutableLiveData<b> recentlyUsedListUiState;
    private final MutableLiveData<b> recommendListUiState;
    private MiniAppListRepository repository;

    private final boolean isPunished() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L11;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L11;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.punishStatus != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public final void fetchMiniAppGroupedList() {
        this.loadState.setValue(fp0.c.C0211c.a);
        MiniAppListRepository r0 = this.repository;
        if (r0 == null) goto L13;
        long r2 = getScene();
        long r4 = getRoomId();
        int r1 = qo0.a.a;
        qo0.a.c("choose_list", "fetch mini app grouped list, scene: " + r2 + ", roomId: " + r4);
        Lazy r3 = LiveOpenPlatformClient.c;
        ChooseApi r5 = (ChooseApi) LiveOpenPlatformClient.a.a().a(ChooseApi.class);
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r6 = r0.a.a;
        if (r6 == null) goto L8;
        String r7 = r6.hash;
        if (r7 == null) goto L8;
    L9:
        Disposable r8 = r5.fetchMiniList(r2, r4, r7).compose(RxUtil.rxSchedulerHelper()).map(new ip0.c(r0)).map(ip0.d.a).subscribe(new ip0.e(r0), new ip0.f(r0));
        if (r8 == null) goto L14;
        r0.autoDispose(r8);
        return;
    L14:
        return;
    L8:
        r7 = "";
        goto L9
    }

    public final String getFeatureTipContent() {
        MiniAppListRepository r0 = this.repository;
        if (r0 == null) goto L11;
        Result<ip0.b> r1 = r0.b.a;
        if (r1 == null) goto L7;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r2 = ip0.a.a(r1.unbox-impl(), 5);
    L8:
        if (r2 == null) goto L11;
        String r3 = r2.liveDesc;
        if (r3 == null) goto L11;
        return r3;
    L7:
        r2 = null;
    L11:
        return "";
    }

    public final int getRecentlyUsedListSize() {
        MiniAppListRepository r0 = this.repository;
        if (r0 == null) goto L16;
        Result<ip0.b> r1 = r0.b.a;
        List<MiniAppEntranceCell> r2 = null;
        if (r1 == null) goto L14;
        Object r3 = r1.unbox-impl();
        if (Result.isFailure-impl(r3) == false) goto L9;
        r3 = null;
    L9:
        ip0.b r4 = (ip0.b) r3;
        if (r4 == null) goto L14;
        Map<Long, List<MiniAppEntranceCell>> r5 = r4.a;
        if (r5 == null) goto L14;
        r2 = r5.get(2L);
    L14:
        if (r2 == null) goto L16;
        return r2.size();
    L16:
        return 0;
    }

    public MiniAppChooseListViewModel() {
        this.loadState = new MutableLiveData();
        this.recentlyUsedListUiState = new MutableLiveData();
        this.recommendListUiState = new MutableLiveData();
        this.bannerListUiState = new MutableLiveData();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel
    public void onCleared() {
        super.onCleared();
        qo0.a.c("choose_list", "on choose list vm cleared");
        MiniAppListRepository r0 = this.repository;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel
    public void onScopeInitialized() {
        lp0.a r0 = getScope();
        Observable<Result<ip0.b>> r1 = null;
        if (r0 == null) goto L5;
        MiniAppListRepository r2 = (MiniAppListRepository) lp0.b.b(r0, MiniAppListRepository.class);
    L6:
        this.repository = r2;
        MutableLiveData<fp0.c> r3 = this.loadState;
        if (r2 == null) goto L9;
        Observable<Result<ip0.b>> r4 = r2.b.c;
    L10:
        subscribe(r3, r4, new AnonymousClass1(this));
        MutableLiveData<b> r5 = this.recentlyUsedListUiState;
        MiniAppListRepository r6 = this.repository;
        if (r6 == null) goto L13;
        Observable<Result<ip0.b>> r7 = r6.b.c;
    L14:
        subscribe(r5, r7, new AnonymousClass2(this));
        MutableLiveData<b> r8 = this.recommendListUiState;
        MiniAppListRepository r9 = this.repository;
        if (r9 == null) goto L17;
        Observable<Result<ip0.b>> r10 = r9.b.c;
    L18:
        subscribe(r8, r10, new AnonymousClass3(this));
        MutableLiveData<a> r11 = this.bannerListUiState;
        MiniAppListRepository r12 = this.repository;
        if (r12 == null) goto L21;
        r1 = r12.b.c;
    L21:
        subscribe(r11, r1, new AnonymousClass4(this));
        return;
    L17:
        r10 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final MutableLiveData<a> getBannerListUiState() {
        return this.bannerListUiState;
    }

    public final MutableLiveData<fp0.c> getLoadState() {
        return this.loadState;
    }

    public final MutableLiveData<b> getRecentlyUsedListUiState() {
        return this.recentlyUsedListUiState;
    }

    public final MutableLiveData<b> getRecommendListUiState() {
        return this.recommendListUiState;
    }

    private final a toBannerListUiState(Object r5) {
        if (Result.isSuccess-impl(r5) == false) goto L24;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r1 = null;
        if (Result.isFailure-impl(r5) == false) goto L7;
        Object r0 = null;
    L8:
        ip0.b r2 = (ip0.b) r0;
        if (r2 == null) goto L11;
        r1 = r2.b;
    L11:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r6 = ip0.a.a(r5, 6);
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r3 = r1;
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L22;
        if (r6 == null) goto L22;
        return new a.c(r1, r6);
    L22:
        qo0.a.c("choose_list", "banner list is empty");
        return a.C0143a.a;
    L14:
        if (r3.isEmpty() == true) goto L17;
        r4 = false;
        goto L18
    L7:
        r0 = r5;
        goto L8
    L24:
        return a.b.a;
    }

    public static final /* synthetic */ a access$toBannerListUiState(MiniAppChooseListViewModel r0, Object r1) {
        return r0.toBannerListUiState(r1);
    }

    private final b toEntranceCellListUiState(Object r7, long r8) {
        if (Result.isSuccess-impl(r7) == false) goto L49;
        String r1 = null;
        if (Result.isFailure-impl(r7) == false) goto L7;
        Object r0 = null;
    L8:
        ip0.b r2 = (ip0.b) r0;
        if (r2 == null) goto L13;
        Map<Long, List<MiniAppEntranceCell>> r3 = r2.a;
        if (r3 == null) goto L13;
        List<MiniAppEntranceCell> r4 = r3.get(Long.valueOf(r8));
    L14:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r9 = ip0.a.a(r7, r8);
        List<MiniAppEntranceCell> r5 = r4;
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L47;
        if (r9 == null) goto L47;
        if (lp0.b.d(getScope()) == false) goto L51;
        if (isPunished() == false) goto L51;
        int r10 = qo0.a.a;
        StringBuilder r11 = new StringBuilder("room is punished, roomId: ");
        long r12 = 0;
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r13 == null) goto L36;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L36;
        Room r15 = (Room) r14.getValue();
        if (r15 == null) goto L36;
        r12 = r15.getRoomId();
    L36:
        r11.append(r12);
        r11.append(", appId: ");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r16 = AnchorMiniAppDataContext.a.a();
        if (r16 == null) goto L45;
        n<ShelfInfo> r17 = r16.m618getShelfInfo();
        if (r17 == null) goto L45;
        ShelfInfo r18 = (ShelfInfo) r17.getValue();
        if (r18 == null) goto L45;
        ShelfMicroAppInfo r19 = r18.appInfo;
        if (r19 == null) goto L45;
        r1 = r19.appId;
    L45:
        r11.append(r1);
        qo0.a.c("choose_list", r11.toString());
        return b.a.a;
    L51:
        return new b.c(r4, r9);
    L47:
        int r20 = qo0.a.a;
        qo0.a.c("choose_list", "list is empty, groupId: " + r8);
        return b.a.a;
    L17:
        if (r5.isEmpty() == true) goto L20;
        r6 = false;
    L13:
        r4 = null;
        goto L14
    L7:
        r0 = r7;
        goto L8
    L49:
        return b.C0144b.a;
    }

    public static final /* synthetic */ b access$toEntranceCellListUiState(MiniAppChooseListViewModel r0, Object r1, long r2) {
        return r0.toEntranceCellListUiState(r1, r2);
    }

    public static final /* synthetic */ fp0.c access$toLoadUiState(MiniAppChooseListViewModel r0, Object r1, Function1 r2) {
        return r0.toLoadUiState(r1, r2);
    }
}
