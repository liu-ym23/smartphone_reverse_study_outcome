package com.bytedance.android.live.liveinteract.linkpanel.vm;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.p;
import com.bytedance.android.live.liveinteract.linkpanel.util.z;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R3\u0010)\u001a\u001e\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010(0%0$8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R3\u0010.\u001a\u001e\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010(0%0$8\u0006¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,¨\u00064"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/vm/AdminInviteAndApplyViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "", "disposeWaitingList", "disposeInviteList", "", "count", "", "cursor", "", "waitingListType", "getWaitingList", "getInviteList", "", "isAnchorOrAdmin", "fetchInviteList", "fetchList", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mRoom$delegate", "Lkotlin/Lazy;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mRoom", "Lio/reactivex/disposables/Disposable;", "waitingListDisposable", "Lio/reactivex/disposables/Disposable;", "getWaitingListDisposable", "()Lio/reactivex/disposables/Disposable;", "setWaitingListDisposable", "(Lio/reactivex/disposables/Disposable;)V", "inviteListDisposable", "getInviteListDisposable", "setInviteListDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/plantform/model/m0;", "", "waitingListResponse", "Landroidx/lifecycle/MutableLiveData;", "getWaitingListResponse", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/liveinteract/plantform/model/a1;", "inviteListResponse", "getInviteListResponse", "<init>", "()V", "Companion", "b", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdminInviteAndApplyViewModel extends DataContext {
    public static final b Companion = null;
    public static final String TAG = "AdminInviteAndApplyViewModel";
    private final CompositeDisposable compositeDisposable;
    private Disposable inviteListDisposable;
    private final MutableLiveData<Pair<com.bytedance.android.live.network.response.e<a1>, Throwable>> inviteListResponse;
    private final Lazy mRoom$delegate;
    private Disposable waitingListDisposable;
    private final MutableLiveData<Pair<com.bytedance.android.live.network.response.e<m0>, Throwable>> waitingListResponse;

    public static final class a implements Action {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;

        public a(AdminInviteAndApplyViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            AdminInviteAndApplyViewModel.access$getCompositeDisposable$p(this.a).clear();
            AdminInviteAndApplyViewModel.access$disposeWaitingList(this.a);
            AdminInviteAndApplyViewModel.access$disposeInviteList(this.a);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;
        public final /* synthetic */ long b;

        public c(AdminInviteAndApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            ALogger.i("panel_first_frame_opt_tag", "fetchInviteList ;; duration == " + (System.currentTimeMillis() - this.b) + " ;; logId == " + r7.logId);
            Map<String, cm2.a> r0 = p.a;
            p.d("invite_panel", this.b);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.b;
            String r3 = r7.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r2, r3);
            this.a.getInviteListResponse().setValue(new Pair(r7, null));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;
        public final /* synthetic */ long b;

        public d(AdminInviteAndApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r1, r5);
            this.a.getInviteListResponse().setValue(new Pair(null, r5));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;
        public final /* synthetic */ long b;

        public e(AdminInviteAndApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            String r3 = r6.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r1, r3);
            this.a.getInviteListResponse().setValue(new Pair(r6, null));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;
        public final /* synthetic */ long b;

        public f(AdminInviteAndApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r1, r5);
            this.a.getInviteListResponse().setValue(new Pair(null, r5));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;

        public g(AdminInviteAndApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.getInviteListResponse().setValue(new Pair((com.bytedance.android.live.network.response.e) r4, null));
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;

        public h(AdminInviteAndApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.getInviteListResponse().setValue(new Pair(null, (Throwable) r4));
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;
        public final /* synthetic */ long b;

        public i(AdminInviteAndApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            ALogger.i("panel_first_frame_opt_tag", "getLinkWaitingList ;; duration == " + (System.currentTimeMillis() - this.b) + " ;; logId == " + r7.logId);
            Map<String, cm2.a> r0 = p.a;
            p.d("apply_panel", this.b);
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.b;
            String r3 = r7.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r2, r3);
            this.a.getWaitingListResponse().setValue(new Pair(r7, null));
            x.Q(((m0) r7.data).getTotalCount(), false, true);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ AdminInviteAndApplyViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ IRoom c;

        public j(AdminInviteAndApplyViewModel r1, long r2, IRoom r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r1, r5);
            x.H(r5, this.c.getId(), this.c.getOwnerUserIdString());
            this.a.getWaitingListResponse().setValue(new Pair(null, r5));
        }
    }

    static {
        Companion = new b();
    }

    public final IRoom getMRoom() {
        return (IRoom) this.mRoom$delegate.getValue();
    }

    private final void disposeInviteList() {
        Disposable r0 = this.inviteListDisposable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    private final void disposeWaitingList() {
        Disposable r0 = this.waitingListDisposable;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public AdminInviteAndApplyViewModel() {
        this.mRoom$delegate = LazyKt.lazy(AdminInviteAndApplyViewModel$mRoom$2.INSTANCE);
        CompositeDisposable r0 = new CompositeDisposable();
        this.compositeDisposable = r0;
        Disposable r1 = getOnCleared().subscribe(new a(this));
        if (r1 == null) goto L5;
        RxUtilKt.c(r1, r0);
    L5:
        MutableLiveData<Pair<com.bytedance.android.live.network.response.e<m0>, Throwable>> r2 = new MutableLiveData();
        r2.setValue(new Pair(null, null));
        Unit r3 = Unit.INSTANCE;
        this.waitingListResponse = r2;
        MutableLiveData<Pair<com.bytedance.android.live.network.response.e<a1>, Throwable>> r4 = new MutableLiveData();
        r4.setValue(new Pair(null, null));
        this.inviteListResponse = r4;
    }

    public final void fetchList() {
        IRoom r0 = getMRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        disposeInviteList();
        if (vm2.d.k() == false) goto L12;
        long r1 = System.currentTimeMillis();
        LinkAnchorApi r4 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r5 = r0.getId();
        t61 r2 = z.a();
        if (r2 == null) goto L10;
        long r8 = r2.d1();
    L11:
        this.inviteListDisposable = r4.getInviteList(r5, 1, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r1), new f(this, r1));
        return;
    L10:
        r8 = 20;
        goto L11
    L12:
        this.inviteListDisposable = ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAllList(r0.getId(), r0.getOwnerUserIdString(), d5.c(r0.getOwnerUserIdString()), 1, 1, false, "fetchInviteList").subscribe(new g(this), new h(this));
    }

    public final void getInviteList() {
        if (o.t(gh0.a.d()) == true) goto L5;
        fetchList();
        return;
    L5:
        if (gh0.a.d() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        fetchInviteList(r0);
        return;
    L7:
        if (o.I() == true) goto L10;
        r0 = false;
        goto L11
    }

    public final Disposable getInviteListDisposable() {
        return this.inviteListDisposable;
    }

    public final MutableLiveData<Pair<com.bytedance.android.live.network.response.e<a1>, Throwable>> getInviteListResponse() {
        return this.inviteListResponse;
    }

    public final Disposable getWaitingListDisposable() {
        return this.waitingListDisposable;
    }

    public final MutableLiveData<Pair<com.bytedance.android.live.network.response.e<m0>, Throwable>> getWaitingListResponse() {
        return this.waitingListResponse;
    }

    public static final /* synthetic */ void access$disposeInviteList(AdminInviteAndApplyViewModel r0) {
        r0.disposeInviteList();
    }

    public static final /* synthetic */ void access$disposeWaitingList(AdminInviteAndApplyViewModel r0) {
        r0.disposeWaitingList();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(AdminInviteAndApplyViewModel r0) {
        return r0.compositeDisposable;
    }

    public final void fetchInviteList(boolean r11) {
        IRoom r0 = getMRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        disposeInviteList();
        LinkAnchorApi r4 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r5 = r0.getId();
        if (r11 == false) goto L8;
        byte r7 = (byte) 3;
    L9:
        t61 r12 = z.a();
        if (r12 == null) goto L12;
        long r8 = r12.d1();
    L13:
        this.inviteListDisposable = r4.getInviteList(r5, r7, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r1), new d(this, r1));
        return;
    L12:
        r8 = 20;
        goto L13
    L8:
        r7 = 2;
        goto L9
    }

    public final void setInviteListDisposable(Disposable r1) {
        this.inviteListDisposable = r1;
    }

    public final void setWaitingListDisposable(Disposable r1) {
        this.waitingListDisposable = r1;
    }

    public final void getWaitingList(long r13, String r15, int r16) {
        Intrinsics.checkNotNullParameter(r15, "cursor");
        long r10 = System.currentTimeMillis();
        IRoom r1 = getMRoom();
        if (r1 != null) goto L5;
        return;
    L5:
        disposeWaitingList();
        this.waitingListDisposable = ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(r1.getId(), r13, r15, r16, WaitingListSource.ANCHOR_PANEL.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r10), new j(this, r10, r1));
    }

    public static /* synthetic */ void getWaitingList$default(AdminInviteAndApplyViewModel r0, long r1, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L9;
        t61 r2 = z.a();
        if (r2 == null) goto L7;
        r1 = r2.f7();
        goto L9
    L7:
        r1 = 10;
    L9:
        if ((r5 & 2) == 0) goto L12;
        r3 = "";
    L12:
        if ((r5 & 4) == 0) goto L14;
        r4 = WaitingListType.UNKNOWN.ordinal();
    L14:
        r0.getWaitingList(r1, r3, r4);
    }
}
