package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.connect.d;
import com.bytedance.android.live.revenuelink.connect.f;
import com.bytedance.android.live.revenuelink.connect.m;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.vm.LinkingInvitePreloadUtils;
import com.bytedance.android.live.revlink.impl.pk.utils.i;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.ITopTip;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.k8;
import com.bytedance.android.livesdk.link.model.l8;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import j21.e;
import j21.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import q21.k;
import y31.s;
import yz0.h;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bs\u0010tJ8\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J<\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J \u0010\u0015\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0002J\u0014\u0010\u001f\u001a\u00020\f2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH\u0002J\u0019\u0010\"\u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0006\u0010$\u001a\u00020 J\b\u0010%\u001a\u00020\fH\u0014JD\u0010(\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016JD\u0010)\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010*\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\n008\u0006¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104R(\u00109\u001a\b\u0012\u0004\u0012\u000208078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010@\u001a\b\u0012\u0004\u0012\u00020?078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R#\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005078\u0006¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010<R$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\n078\u0006¢\u0006\f\n\u0004\bL\u0010:\u001a\u0004\bM\u0010<R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020N078\u0006¢\u0006\f\n\u0004\bO\u0010:\u001a\u0004\bP\u0010<R\"\u0010Q\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bQ\u0010S\"\u0004\bT\u0010UR$\u0010V\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010RR\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010cR\u0016\u0010e\u001a\u0004\u0018\u00010d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\n078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010:R\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0h8\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0016\u0010n\u001a\u0004\u0018\u00010m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006u"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/vm/MultiAnchorPkInviteViewModel;", "Landroidx/lifecycle/ViewModel;", "Lj21/b;", "Lcom/bytedance/android/livesdk/link/model/IRivalRankRecommendResponse;", "recsResp", "", "Lcom/bytedance/android/livesdk/link/model/p;", "users", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "inviteeList", "", "fromRefresh", "", "updatePersonalModel", "", "createRecsItem", "Lcom/bytedance/android/livesdk/link/model/b0;", "getCurrentAutoMatchInfo", "", "uid", "getAnchorLinkUser", "isInInviteeList", "T", "findCurrentDataByType", "()Ljava/lang/Object;", "dataList", "Ly31/k;", "findRecItems", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "", "feedTabType", "requestUpdatePage", "(Ljava/lang/Integer;)V", "getCurrentScene", "onCleared", "anchorList", "waitingList", "onPageUpdate", "onPageRecsFetch", "onInviteeOrApplicantListChanged", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/vm/a;", "personalPkService", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/vm/a;", "getPersonalPkService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/vm/a;", "Lio/reactivex/subjects/PublishSubject;", "onToastEvent", "Lio/reactivex/subjects/PublishSubject;", "getOnToastEvent", "()Lio/reactivex/subjects/PublishSubject;", "onDataFirstLoadEvent", "getOnDataFirstLoadEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/link/model/ITopTip;", "topBar", "Landroidx/lifecycle/MutableLiveData;", "getTopBar", "()Landroidx/lifecycle/MutableLiveData;", "setTopBar", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/bytedance/android/livesdk/link/model/l8;", "searchBar", "getSearchBar", "setSearchBar", "listDataModel", "getListDataModel", "Lcom/bytedance/android/live/revlink/impl/pk/utils/i;", "listExtraInfo", "Lcom/bytedance/android/live/revlink/impl/pk/utils/i;", "getListExtraInfo", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/i;", "setListExtraInfo", "(Lcom/bytedance/android/live/revlink/impl/pk/utils/i;)V", "anchorOverLimit", "getAnchorOverLimit", "Lq21/k;", "randomMatchDataModel", "getRandomMatchDataModel", "isTeamPkInvitePanel", "Z", "()Z", "setTeamPkInvitePanel", "(Z)V", "npkInvitePageSource", "Ljava/lang/String;", "getNpkInvitePageSource", "()Ljava/lang/String;", "setNpkInvitePageSource", "(Ljava/lang/String;)V", "isDataFirstLoad", "Lj21/e;", "pkPanelNetFacade", "Lj21/e;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/util/List;", "Lyz0/l;", "messageService", "Lyz0/l;", "_finishState", "Landroidx/lifecycle/LiveData;", "finishState", "Landroidx/lifecycle/LiveData;", "getFinishState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revenuelink/connect/f;", "connectService", "Lcom/bytedance/android/live/revenuelink/connect/f;", "Lcom/bytedance/android/live/revenuelink/connect/m;", "linkOutListener", "Lcom/bytedance/android/live/revenuelink/connect/m;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPkInviteViewModel extends ViewModel implements j21.b {
    private final MutableLiveData<Boolean> _finishState;
    private List<? extends p> anchorList;
    private final MutableLiveData<Boolean> anchorOverLimit;
    private final CompositeDisposable cd;
    private final f connectService;
    private final LiveData<Boolean> finishState;
    private boolean isDataFirstLoad;
    private boolean isTeamPkInvitePanel;
    private final m linkOutListener;
    private final MutableLiveData<List<Object>> listDataModel;
    private i listExtraInfo;
    private final l messageService;
    private String npkInvitePageSource;
    private final PublishSubject<Boolean> onDataFirstLoadEvent;
    private final PublishSubject<String> onToastEvent;
    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.a personalPkService;
    private final e pkPanelNetFacade;
    private final MutableLiveData<k> randomMatchDataModel;
    private MutableLiveData<l8> searchBar;
    private MutableLiveData<ITopTip> topBar;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkInviteViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(MultiAnchorPkInviteViewModel r8) {
            super(1, r8, MultiAnchorPkInviteViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            MultiAnchorPkInviteViewModel.access$onMessage((MultiAnchorPkInviteViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a extends d {
        public final /* synthetic */ MultiAnchorPkInviteViewModel a;

        public a(MultiAnchorPkInviteViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r1, i6 r2, ey.l r3) {
            Intrinsics.checkNotNullParameter(r2, "linkerMessage");
            k6 r4 = r2.castTo(i6.class).getReply();
            if (r4 != null) goto L5;
            return;
        L5:
            if (((int) r4.getReplyStatus()) != 1) goto L9;
            MultiAnchorPkInviteViewModel.access$get_finishState$p(this.a).postValue(Boolean.TRUE);
            return;
        }
    }

    public static final class b implements com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.a {
        public final /* synthetic */ MultiAnchorPkInviteViewModel a;

        @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.a
        public final void a() {
            e r0 = MultiAnchorPkInviteViewModel.access$getPkPanelNetFacade$p(this.a);
            r0.getClass();
            jy0.b.f("ttlive_anchor_link_panel", "refreshRecs fetchRecommendList", null, 4);
            r0.c(true);
        }

        public b(MultiAnchorPkInviteViewModel r1) {
            this.a = r1;
        }
    }

    public MultiAnchorPkInviteViewModel() {
        this.personalPkService = new b(this);
        this.onToastEvent = PublishSubject.create();
        this.onDataFirstLoadEvent = PublishSubject.create();
        this.topBar = new MutableLiveData();
        this.searchBar = new MutableLiveData();
        this.listDataModel = new MutableLiveData();
        this.anchorOverLimit = new MutableLiveData();
        this.randomMatchDataModel = new MutableLiveData();
        this.isDataFirstLoad = true;
        e r0 = new e(com.bytedance.android.live.revlink.impl.global.b.k());
        this.pkPanelNetFacade = r0;
        CompositeDisposable r1 = new CompositeDisposable();
        this.cd = r1;
        l r2 = (l) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), l.class);
        this.messageService = r2;
        MutableLiveData<Boolean> r3 = new MutableLiveData();
        this._finishState = r3;
        this.finishState = r3;
        f r4 = com.bytedance.android.live.revlink.impl.global.b.a();
        this.connectService = r4;
        a r5 = new a(this);
        this.linkOutListener = r5;
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.h = this;
        j21.j r6 = r0.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "listener");
        r6.e = r0;
        i11.b r7 = r6.a;
        if (r7 == null) goto L5;
        r7.i(r6.c);
    L5:
        r0.c.getClass();
        if (r2 == null) goto L12;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r8 = h.a.a(r2, com.bytedance.android.live.revenue.common.message.b.b, false, 6);
        if (r8 == null) goto L12;
        final AnonymousClass1 r9 = new AnonymousClass1(this);
        Disposable r10 = r8.subscribe(new c(r9));
        if (r10 == null) goto L12;
        RxUtilKt.c(r10, r1);
    L12:
        if (r4 == null) goto L15;
        r4.addLinkOutListener(7, r5);
        return;
    }

    private final /* synthetic */ <T> T findCurrentDataByType() {
        List r0 = (List) getListDataModel().getValue();
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        T r2 = (T) r1.next();
        Intrinsics.reifiedOperationMarker(3, "T");
        if ((r2 instanceof Object) == false) goto L9;
        return r2;
    }

    public final int getCurrentScene() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentMode();
    L7:
        if (v.a(r1, 4) == false) goto L10;
        return 1;
    L10:
        return 7;
    L5:
        r1 = 0;
        goto L7
    }

    public void onCleared() {
        super.onCleared();
        this.cd.dispose();
        e r0 = this.pkPanelNetFacade;
        j21.j r1 = r0.b;
        i11.b r2 = r1.a;
        if (r2 == null) goto L5;
        r2.l(r1.c);
    L5:
        r1.e = null;
        g r3 = r0.c;
        Disposable r4 = r3.a;
        if (r4 == null) goto L8;
        r4.dispose();
        r3.a = null;
    L8:
        r0.h = null;
        r0.i.dispose();
        f r5 = this.connectService;
        if (r5 == null) goto L12;
        r5.removeLinkOutListener(7, this.linkOutListener);
        r5.removeLinkOutListener(1, this.linkOutListener);
        return;
    }

    public final MutableLiveData<Boolean> getAnchorOverLimit() {
        return this.anchorOverLimit;
    }

    public final LiveData<Boolean> getFinishState() {
        return this.finishState;
    }

    public final MutableLiveData<List<Object>> getListDataModel() {
        return this.listDataModel;
    }

    public final i getListExtraInfo() {
        return this.listExtraInfo;
    }

    public final String getNpkInvitePageSource() {
        return this.npkInvitePageSource;
    }

    public final PublishSubject<Boolean> getOnDataFirstLoadEvent() {
        return this.onDataFirstLoadEvent;
    }

    public final PublishSubject<String> getOnToastEvent() {
        return this.onToastEvent;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.a getPersonalPkService() {
        return this.personalPkService;
    }

    public final MutableLiveData<k> getRandomMatchDataModel() {
        return this.randomMatchDataModel;
    }

    public final MutableLiveData<l8> getSearchBar() {
        return this.searchBar;
    }

    public final MutableLiveData<ITopTip> getTopBar() {
        return this.topBar;
    }

    public final boolean isTeamPkInvitePanel() {
        return this.isTeamPkInvitePanel;
    }

    public static final /* synthetic */ e access$getPkPanelNetFacade$p(MultiAnchorPkInviteViewModel r0) {
        return r0.pkPanelNetFacade;
    }

    public static final /* synthetic */ MutableLiveData access$get_finishState$p(MultiAnchorPkInviteViewModel r0) {
        return r0._finishState;
    }

    private final List<y31.k> findRecItems(List<?> r4) {
        ArrayList r0 = new ArrayList();
        if (r4 != null) goto L5;
    L13:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L13;
        Iterator<?> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Object r1 = r5.next();
        if ((r1 instanceof y31.k) == false) goto L9;
        r0.add(r1);
        goto L9
    }

    private final b0 getCurrentAutoMatchInfo(IRivalRankRecommendResponse r5) {
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.impl.global.b.I()) == false) goto L9;
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L9;
        b0 r1 = r0.currentAutoMatchInfo();
        if (r1 == null) goto L9;
        return r1;
    L9:
        j8 r6 = r5.getAutoMatchInfo();
        if (r6 != null) goto L14;
        b0 r7 = vh7.f.c(j8.class);
        j8 r2 = (j8) r7;
        r2.setWaitSec(45);
        r2.setAccelerateLimit(15);
        r2.setDefaultWaitLimit(60);
        k8 r3 = vh7.f.c(k8.class);
        r3.setInviteLimitSec(10);
        Unit r4 = Unit.INSTANCE;
        r2.setConfig(r3);
        return r7;
    L14:
        return r6;
    }

    private final void onMessage(yh6.c r3) {
        if ((r3 instanceof h1) == true) goto L5;
        return;
    L5:
        if (((int) ((h1) r3).castTo(i6.class).getType2()) != 31) goto L9;
        this._finishState.postValue(Boolean.TRUE);
        return;
    }

    @Override // j21.b
    public void onInviteeOrApplicantListChanged(List<? extends IBaseUser> r8) {
        Intrinsics.checkNotNullParameter(r8, "inviteeList");
        List<?> r0 = (List) this.listDataModel.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<y31.k> r1 = findRecItems(r0).iterator();
    L7:
        if (r1.hasNext() == false) goto L27;
        y31.k r2 = r1.next();
        m2 r3 = r2.a;
        if (r3 == null) goto L15;
        IRoom r4 = r3.getRoom();
        if (r4 == null) goto L15;
        IBaseUser r5 = r4.getOwner();
        if (r5 == null) goto L15;
        String r6 = iz.a.a(r5);
    L16:
        p r7 = getAnchorLinkUser(this.anchorList, r6);
        if (r7 == null) goto L7;
        if (r7.getStatus() == 2) goto L7;
        if (r7.getRoleType() != 4) goto L23;
    L25:
        boolean r9 = false;
    L26:
        r2.m = r9;
        goto L7
    L23:
        if (isInInviteeList(r8, r6) == false) goto L25;
        r9 = true;
    L15:
        r6 = null;
        goto L16
    L27:
        this.listDataModel.setValue(r0);
    }

    public final void requestUpdatePage(Integer r14) {
        e r0 = this.pkPanelNetFacade;
        if (r14 == null) goto L5;
        r0.getClass();
        r0.a = Integer.valueOf(r14.intValue());
    L5:
        g r15 = r0.c;
        Disposable r1 = r15.a;
        if (r1 == null) goto L8;
        r1.dispose();
        r15.a = null;
    L8:
        j21.j r16 = r0.b;
        r16.getClass();
        StringBuilder r2 = new StringBuilder("MultiAnchorLinkUserFetcher fetchLinkList ");
        com.bytedance.android.live.revlink.impl.service.internal.a r3 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r3 == null) goto L11;
        Integer r4 = Integer.valueOf(r3.getCurrentMode());
    L12:
        r2.append(r4);
        jy0.b.d("ttlive_anchor_link_panel", r2.toString());
        com.bytedance.android.live.revlink.impl.global.c r5 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r5 == null) goto L15;
        AnchorLinkOptUtils r6 = r5.vk();
    L17:
        if (r6 != null) goto L19;
    L38:
        i11.b r17 = r16.a;
        if (r17 == null) goto L41;
        r17.b(4, "show_in_link_invite_dialog");
    L41:
        com.bytedance.android.live.revlink.impl.global.c r18 = r0.j;
        if (r18 == null) goto L44;
        AnchorLinkOptUtils r19 = r18.vk();
    L45:
        if (r19 != null) goto L47;
        return;
    L47:
        if (r19.d() != true) goto L103;
        Integer r110 = r0.a;
        if (r110 == null) goto L52;
        int r111 = r110.intValue();
    L55:
        com.bytedance.android.live.revlink.impl.multianchor.vm.f r7 = com.bytedance.android.live.revlink.impl.global.b.p();
        if (r7 != null) goto L58;
    L100:
        jy0.b.f("ttlive_anchor_link_panel", "firstRefresh tabType=" + r111 + " noCache, request recommend list", null, 4);
        r0.c(false);
        return;
    L58:
        if (r7.a() != true) goto L100;
        if (r111 == 4) goto L100;
        LinkingInvitePreloadUtils r8 = e.d();
        if (r8 == null) goto L73;
        Pair<String, IRivalRankRecommendResponse> r9 = r8.a(r111);
        if (r9 == null) goto L73;
        String r10 = (String) r9.component1();
        IRivalRankRecommendResponse r12 = (IRivalRankRecommendResponse) r9.component2();
        if (r12 == null) goto L74;
        LinkingInvitePreloadUtils r112 = e.d();
        if (r112 == null) goto L69;
        r112.g(0, "hitCache");
    L69:
        d31.e r113 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r113 == null) goto L72;
        r113.e |= 8;
    L72:
        r0.e(r12);
        return;
    L74:
        LinkingInvitePreloadUtils r13 = e.d();
        if (r13 != null) goto L77;
    L97:
        LinkingInvitePreloadUtils r20 = e.d();
        if (r20 == null) goto L100;
        r20.g(2, r10);
        goto L100
    L77:
        if (t.a(r13.c) < 3000) goto L79;
    L83:
        boolean r22 = false;
    L84:
        if (r22 != true) goto L97;
        LinkingInvitePreloadUtils r23 = e.d();
        if (r23 == null) goto L88;
        r23.g(1, "preloading");
    L88:
        MultiAnchorPkLaunchContext r24 = com.bytedance.android.live.revlink.impl.global.b.x();
        if (r24 == null) goto L105;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.revlink.impl.multianchor.vm.h> r25 = r24.getPreloadCompleteEvent();
        if (r25 == null) goto L106;
        PublishSubject r26 = r25.onEvent();
        if (r26 == null) goto L107;
        Disposable r114 = r26.subscribe(new j21.f(r0, r111));
        if (r114 == null) goto L108;
        r0.i.add(r114);
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L79:
        if (r13.d == false) goto L83;
        if (r111 != r13.e) goto L83;
        r22 = true;
    L73:
        r10 = "";
        goto L74
    L52:
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L54;
        r111 = 3;
        goto L55
    L54:
        r111 = 6;
        goto L55
    L103:
        return;
    L44:
        r19 = null;
        goto L45
    L19:
        if (r6.d() != true) goto L38;
        com.bytedance.android.live.revlink.impl.service.internal.a r27 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r27 != null) goto L23;
    L31:
        i11.b r28 = r16.a;
        if (r28 == null) goto L38;
        List<p> r29 = r28.getOnlineUserList();
        if (r29 == null) goto L38;
        if ((!r29.isEmpty()) != true) goto L38;
        jy0.b.f("ttlive_anchor_link_panel", "intercept link fetchLinkList", null, 4);
        r16.c.b(7, null);
        goto L41
    L23:
        if (r27.k0(4) != true) goto L31;
        i11.b r30 = r16.b;
        if (r30 == null) goto L31;
        List<p> r32 = r30.getOnlineUserList();
        if (r32 == null) goto L31;
        if ((!r32.isEmpty()) != true) goto L31;
        jy0.b.f("ttlive_anchor_link_panel", "intercept pk fetchLinkList", null, 4);
        r16.d.a(1, null);
        goto L41
    L15:
        r6 = null;
        goto L17
    L11:
        r4 = null;
        goto L12
    }

    public final void setListExtraInfo(i r1) {
        this.listExtraInfo = r1;
    }

    public final void setNpkInvitePageSource(String r1) {
        this.npkInvitePageSource = r1;
    }

    public final void setSearchBar(MutableLiveData<l8> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchBar = r2;
    }

    public final void setTeamPkInvitePanel(boolean r1) {
        this.isTeamPkInvitePanel = r1;
    }

    public final void setTopBar(MutableLiveData<ITopTip> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.topBar = r2;
    }

    public static final /* synthetic */ void access$onMessage(MultiAnchorPkInviteViewModel r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    private final p getAnchorLinkUser(List<? extends p> r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<? extends p> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L15;
        p r1 = r6.next();
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L11;
        String r3 = iz.a.a(r2);
    L13:
        if (Intrinsics.areEqual(r3, r5) == false) goto L7;
        return r1;
    L11:
        r3 = null;
        goto L13
    L15:
        return null;
    }

    private final boolean isInInviteeList(List<? extends IBaseUser> r3, String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<? extends IBaseUser> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(iz.a.a(r5.next()), r4) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private final List<Object> createRecsItem(List<? extends p> r22, List<? extends IBaseUser> r23, IRivalRankRecommendResponse r24, boolean r25) {
        ArrayList r3 = new ArrayList();
        if (r24.getDisplayMultiMatch() == false) goto L7;
        b51.b r4 = b51.b.c0;
        r4.getClass();
        if (((Boolean) b51.b.b.getValue(r4, b51.b.a[0])).booleanValue() == true) goto L7;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L16;
        this.randomMatchDataModel.setValue(new k(getCurrentAutoMatchInfo(r24)));
        j8 r8 = r24.getAutoMatchInfo();
        if (r8 == null) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r9 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r9 == null) goto L16;
        r9.Jo(r8);
    L16:
        if (this.isDataFirstLoad == false) goto L18;
        this.isDataFirstLoad = false;
        this.onDataFirstLoadEvent.onNext(Boolean.valueOf(r5));
    L18:
        s2 r10 = r24.getTabRivals();
        if (r10 == null) goto L26;
        Map r12 = r10.getGroupRivals();
        if (r12 == null) goto L26;
        IGroupRivals r13 = (IGroupRivals) r12.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r13 == null) goto L26;
        List r14 = r13.getRivals();
        if (r14 == null) goto L26;
    L27:
        s2 r15 = r24.getTabRivals();
        if (r15 == null) goto L34;
        Map r16 = r15.getGroupRivals();
        if (r16 == null) goto L34;
        IGroupRivals r17 = (IGroupRivals) r16.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r17 == null) goto L34;
        String r18 = r17.getImprId();
    L35:
        s2 r19 = r24.getTabRivals();
        if (r19 == null) goto L43;
        Map r110 = r19.getGroupRivals();
        if (r110 == null) goto L43;
        IGroupRivals r111 = (IGroupRivals) r110.get(Long.valueOf(IGroupRivals.GroupType.GroupFeedFollowed.ordinal()));
        if (r111 == null) goto L43;
        String r112 = r111.getGroupName();
        if (r112 == null) goto L43;
    L45:
        if (r112.length() != 0) goto L47;
        boolean r113 = true;
    L48:
        if (r113 == false) goto L50;
        s1.B(2131922352);
    L50:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r14.iterator();
        int r6 = 0;
        int r116 = 0;
    L52:
        if (r115.hasNext() == false) goto L83;
        m2 r7 = (m2) r115.next();
        y31.k r20 = new y31.k();
        Iterator r117 = r115;
        r20.b = r7.getRoom();
        r20.e = r7.getServerInviteType();
        r20.f = r7.getRivalExtraInfo();
        r20.d = false;
        r20.h = r7.getBattleRivalTagList();
        r20.a = r7;
        r20.j = false;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r20.k = "";
        r20.l = null;
        r20.o = r5;
        r20.r = r6;
        if (r18 == null) goto L56;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r20.i = r18;
    L56:
        r20.g = 2;
        r24.getSkinType();
        IRoom r26 = r7.getRoom();
        if (r26 == null) goto L61;
        IBaseUser r27 = r26.getOwner();
        if (r27 == null) goto L61;
        String r118 = iz.a.a(r27);
    L62:
        p r28 = getAnchorLinkUser(r22, r118);
        if (r28 == null) goto L74;
        String r119 = r18;
        if (r28.getStatus() != 2) goto L68;
        boolean r29 = true;
    L76:
        if (r29 == true) goto L82;
        if (y31.l.a(r20, 1) == true) goto L81;
        r116 = r116 + 1;
    L81:
        r6 = r6 + 1;
        r114.add(r20);
    L82:
        r115 = r117;
        r18 = r119;
        goto L52
    L68:
        if (r28.getRoleType() != 4) goto L70;
    L72:
        boolean r30 = false;
    L73:
        r20.m = r30;
    L75:
        r29 = false;
        goto L76
    L70:
        if (isInInviteeList(r23, r118) == false) goto L72;
        r30 = true;
        goto L73
    L74:
        r119 = r18;
    L61:
        r118 = null;
        goto L62
    L83:
        String r120 = r18;
        if ((!r114.isEmpty()) == false) goto L86;
        s.a r32 = new s.a();
        r32.a = r112;
        r32.b = !this.isTeamPkInvitePanel;
        r3.add(r32);
        r3.addAll(r114);
    L86:
        IGroupRivals.GroupType r33 = IGroupRivals.GroupType.GroupFeedRecommend;
        int r34 = r33.ordinal();
        s2 r35 = r24.getTabRivals();
        if (r35 == null) goto L94;
        Map r36 = r35.getGroupRivals();
        if (r36 == null) goto L94;
        IGroupRivals r37 = (IGroupRivals) r36.get(Long.valueOf(r34));
        if (r37 == null) goto L94;
        List r38 = r37.getRivals();
        if (r38 == null) goto L94;
    L95:
        s2 r39 = r24.getTabRivals();
        if (r39 == null) goto L102;
        Map r40 = r39.getGroupRivals();
        if (r40 == null) goto L102;
        IGroupRivals r42 = (IGroupRivals) r40.get(Long.valueOf(r34));
        if (r42 == null) goto L102;
        String r121 = r42.getImprId();
    L103:
        s2 r43 = r24.getTabRivals();
        if (r43 == null) goto L111;
        Map r44 = r43.getGroupRivals();
        if (r44 == null) goto L111;
        IGroupRivals r0 = (IGroupRivals) r44.get(Long.valueOf(r33.ordinal()));
        if (r0 == null) goto L111;
        String r1 = r0.getGroupName();
        if (r1 == null) goto L111;
    L113:
        if (r1.length() != 0) goto L115;
        boolean r2 = true;
    L116:
        if (r2 == false) goto L122;
        if (r14.isEmpty() == false) goto L120;
        r1 = s1.B(2131917923);
        goto L122
    L120:
        r1 = s1.B(2131914806);
    L122:
        if ((!r38.isEmpty()) == false) goto L124;
        s.a r45 = new s.a();
        r45.a = r1;
        r45.b = false;
        r3.add(r45);
    L124:
        Iterator r46 = r38.iterator();
        int r47 = 0;
        int r48 = 0;
    L126:
        if (r46.hasNext() == false) goto L157;
        m2 r49 = (m2) r46.next();
        y31.k r50 = new y31.k();
        r50.b = r49.getRoom();
        r50.e = r49.getServerInviteType();
        r50.f = r49.getRivalExtraInfo();
        r50.d = false;
        r50.h = r49.getBattleRivalTagList();
        r50.a = r49;
        r50.j = true;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r50.k = "";
        r50.l = null;
        r50.o = r5;
        r50.r = r47;
        if (r121 == null) goto L130;
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r50.i = r121;
    L130:
        r50.g = 2;
        r24.getSkinType();
        IRoom r52 = r49.getRoom();
        if (r52 == null) goto L135;
        IBaseUser r53 = r52.getOwner();
        if (r53 == null) goto L135;
        String r54 = iz.a.a(r53);
    L136:
        p r122 = getAnchorLinkUser(r22, r54);
        if (r122 == null) goto L148;
        Iterator r123 = r46;
        boolean r124 = r5;
        if (r122.getStatus() != 2) goto L142;
        boolean r55 = true;
    L150:
        if (r55 == true) goto L155;
        r3.add(r50);
        r47 = r47 + 1;
        if (y31.l.a(r50, 1) == false) goto L155;
        r48 = r48 + 1;
    L155:
        r46 = r123;
        r5 = r124;
        goto L126
    L142:
        if (r122.getRoleType() != 4) goto L144;
    L146:
        boolean r56 = false;
    L147:
        r50.m = r56;
    L149:
        r55 = false;
        goto L150
    L144:
        if (isInInviteeList(r23, r54) == false) goto L146;
        r56 = true;
        goto L147
    L148:
        r123 = r46;
        r124 = r5;
    L135:
        r54 = null;
        goto L136
    L157:
        if ((true ^ r38.isEmpty()) == false) goto L161;
        d31.e r57 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r57 == null) goto L161;
        r57.g = r48 / r38.size();
    L161:
        int r58 = r14.size();
        if (r120 != null) goto L164;
        String r59 = r121;
    L165:
        this.listExtraInfo = new i(r116, r58, r59, r25);
        return r3;
    L164:
        r59 = r120;
        goto L165
    L115:
        r2 = false;
    L111:
        r1 = "";
    L102:
        r121 = null;
    L94:
        r38 = new ArrayList();
        goto L95
    L47:
        r113 = false;
    L43:
        r112 = "";
    L34:
        r18 = null;
    L26:
        r14 = new ArrayList();
    L7:
        r5 = false;
        goto L9
    }

    public static /* synthetic */ void requestUpdatePage$default(MultiAnchorPkInviteViewModel r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.requestUpdatePage(r1);
    }

    private final void updatePersonalModel(IRivalRankRecommendResponse r4, List<? extends p> r5, List<? extends IBaseUser> r6, boolean r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        this.searchBar.setValue(r4.getSearchBar());
        this.topBar.setValue(r4.getTopTip());
        r0.addAll(createRecsItem(r5, r6, r4, r7));
        this.listDataModel.setValue(r0);
        d31.e r8 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r8 == null) goto L8;
        int r9 = getCurrentScene();
        int r10 = d31.e.o;
        r8.d(r9, 2, 0);
        return;
    }

    @Override // j21.b
    public void onPageRecsFetch(List<? extends p> r2, List<? extends p> r3, List<? extends IBaseUser> r4, IRivalRankRecommendResponse r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "anchorList");
        Intrinsics.checkNotNullParameter(r3, "waitingList");
        Intrinsics.checkNotNullParameter(r4, "inviteeList");
        onPageUpdate(r2, r3, r4, r5, r6);
    }

    @Override // j21.b
    public void onPageUpdate(List<? extends p> r3, List<? extends p> r4, List<? extends IBaseUser> r5, IRivalRankRecommendResponse r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "anchorList");
        Intrinsics.checkNotNullParameter(r4, "waitingList");
        Intrinsics.checkNotNullParameter(r5, "inviteeList");
        this.anchorList = r3;
        MutableLiveData<Boolean> r8 = this.anchorOverLimit;
        if (r3.size() < 3) goto L5;
        boolean r0 = true;
    L6:
        r8.postValue(Boolean.valueOf(r0));
        updatePersonalModel(r6, r3, r5, r7);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ List createRecsItem$default(MultiAnchorPkInviteViewModel r0, List r1, List r2, IRivalRankRecommendResponse r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.createRecsItem(r1, r2, r3, r4);
    }

    public static /* synthetic */ void updatePersonalModel$default(MultiAnchorPkInviteViewModel r0, IRivalRankRecommendResponse r1, List r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.updatePersonalModel(r1, r2, r3, r4);
    }
}
