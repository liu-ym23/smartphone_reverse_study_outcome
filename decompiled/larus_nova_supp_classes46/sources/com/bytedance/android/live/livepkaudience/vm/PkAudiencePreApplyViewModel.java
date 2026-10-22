package com.bytedance.android.live.livepkaudience.vm;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.b1;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.r1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dl0.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\u00020\u0001:\u0001?B\u0011\u0012\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\"\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010+0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\u001dR\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)048F¢\u0006\u0006\u001a\u0004\b8\u00106R\u001f\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010+048F¢\u0006\u0006\u001a\u0004\b:\u00106¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/vm/PkAudiencePreApplyViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", PbRequest.SwitchType.ROOM, "", "doPrepareApply", "", "", "waitingUsers", "", "hasMore", "", "now", "addFooter", "isRefresh", "fetchList", "Landroid/content/Context;", "context", "checkAndPreApply", "cancelPreApply", BuildConfig.BUILD_TYPE, "", "mCurrentCursor", "Ljava/lang/String;", "Lcom/bytedance/android/live/livepkaudience/list/a;", "LOAD_MORE_ITEM", "Lcom/bytedance/android/live/livepkaudience/list/a;", "NO_MORE_ITEM", "mHasMore", "Z", "", "totalCount", "I", "getTotalCount", "()I", "setTotalCount", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/message/Text;", "_waitingTitleData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/liveinteract/plantform/model/c1;", "_userWaitingData", "", "_waitingListData", "Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isRequesting", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Landroidx/lifecycle/LiveData;", "getWaitingTitleData", "()Landroidx/lifecycle/LiveData;", "waitingTitleData", "getUserWaitingData", "userWaitingData", "getWaitingListData", "waitingListData", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudiencePreApplyViewModel extends DataContext {
    public static final a Companion = null;
    public static final String TAG = "PkAudiencePreApplyViewModel";
    private final com.bytedance.android.live.livepkaudience.list.a LOAD_MORE_ITEM;
    private final com.bytedance.android.live.livepkaudience.list.a NO_MORE_ITEM;
    private final MutableLiveData<c1> _userWaitingData;
    private final MutableLiveData<List<Object>> _waitingListData;
    private MutableLiveData<Text> _waitingTitleData;
    private final DataCenter dataCenter;
    private boolean isRequesting;
    private final CompositeDisposable mCompositeDisposable;
    private String mCurrentCursor;
    private boolean mHasMore;
    private int totalCount;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkAudiencePreApplyViewModel a;

        public b(PkAudiencePreApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            hd0.c.f().k(0);
            f2.b(2131918112, 0);
            DataCenter r5 = PkAudiencePreApplyViewModel.access$getDataCenter$p(this.a);
            if (r5 == null) goto L6;
            r5.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.w(PkAudiencePreApplyViewModel.TAG, "", (Throwable) r3);
            hd0.c.f().k(0);
        }
    }

    public static final class d implements qh0.d<rh0.a> {
        public final /* synthetic */ Room a;
        public final /* synthetic */ PkAudiencePreApplyViewModel b;

        @Override // qh0.d
        public final void b(BaseCheckException r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            m.a.getClass();
            m.v(r2);
            x.K(r2);
        }

        @Override // qh0.d
        public final void onResult(rh0.a r2) {
            PkAudiencePreApplyViewModel.access$doPrepareApply(this.b, this.a);
            m.B(m.a, "check_link_permission_success");
            x.L();
        }

        public d(Room r1, PkAudiencePreApplyViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PkAudiencePreApplyViewModel a;
        public final /* synthetic */ long b;

        public e(PkAudiencePreApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            tc0.c.h().H = "advance_apply";
            tc0.c r0 = tc0.c.h();
            r0.K = LinkApplyType.PREPARE_APPLY.getValue();
            hd0.c.f().k(1);
            if (r12 == null) goto L12;
            r1 r13 = (r1) r12.data;
            if (r13 == null) goto L12;
            a5 r14 = r13.getDisplayText();
            if (r14 == null) goto L12;
            MutableLiveData r1 = PkAudiencePreApplyViewModel.access$get_waitingTitleData$p(this.a);
            if ((r14 instanceof Text) == true) goto L11;
            r14 = null;
        L11:
            r1.setValue((Text) r14);
        L12:
            long r2 = this.b;
            long r7 = System.currentTimeMillis() - r2;
            m r15 = m.a;
            JSONObject r9 = new JSONObject();
            m.a.getClass();
            m.z("audience_pre_apply", 0, "", r7, r9);
            f2.b(2131917534, 0);
            DataCenter r16 = PkAudiencePreApplyViewModel.access$getDataCenter$p(this.a);
            if (r16 == null) goto L16;
            r16.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkAudiencePreApplyViewModel a;
        public final /* synthetic */ Room b;
        public final /* synthetic */ long c;

        public f(PkAudiencePreApplyViewModel r1, Room r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            new qh0.h(2, new PkAudiencePreApplyViewModel$doPrepareApply$2$1(this), PkAudiencePreApplyViewModel$doPrepareApply$2$2.INSTANCE).c(r6);
            ALogger.w(PkAudiencePreApplyViewModel.TAG, "", r6);
            hd0.c.f().k(0);
            if ((r6 instanceof ApiServerException) == true) goto L5;
            f2.b(2131919229, 0);
        L5:
            long r0 = this.c;
            m.s(r6, System.currentTimeMillis() - r0);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PkAudiencePreApplyViewModel a;

        public g(PkAudiencePreApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Response r8 = (Response) r7;
            if (r8 == null) goto L25;
            b1 r9 = (b1) r8.data;
            if (r9 == null) goto L25;
            this.a.setTotalCount(r9.g());
            c1 r1 = r9.b();
            if (r1 == null) goto L9;
            r1.b = r9.e();
        L9:
            PkAudiencePreApplyViewModel.access$get_userWaitingData$p(this.a).setValue(r9.b());
            if (r9.b() == null) goto L12;
            PkAudiencePreApplyViewModel.access$get_waitingTitleData$p(this.a).setValue(jm2.a.d(r9.f()));
        L12:
            PkAudiencePreApplyViewModel.access$addFooter(this.a, r9.a(), r9.c(), r9.e());
            String r2 = r9.d();
            if (r2 == null) goto L16;
            PkAudiencePreApplyViewModel.access$setMCurrentCursor$p(this.a, r2);
        L16:
            if (r9.b() == null) goto L21;
            DataCenter r10 = PkAudiencePreApplyViewModel.access$getDataCenter$p(this.a);
            if (r10 == null) goto L20;
            r10.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
        L20:
            hd0.c.f().k(1);
            goto L25
        L21:
            DataCenter r11 = PkAudiencePreApplyViewModel.access$getDataCenter$p(this.a);
            if (r11 == null) goto L24;
            r11.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        L24:
            hd0.c.f().k(0);
        L25:
            PkAudiencePreApplyViewModel.access$setRequesting$p(this.a, false);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ PkAudiencePreApplyViewModel a;

        public h(PkAudiencePreApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            PkAudiencePreApplyViewModel.access$setRequesting$p(this.a, false);
            ALogger.e(PkAudiencePreApplyViewModel.TAG, "getPrepareApplyList fail!");
        }
    }

    static {
        Companion = new a();
    }

    public final void release() {
        this.mCompositeDisposable.clear();
        this.mCurrentCursor = "";
        this._waitingTitleData.setValue(null);
        this.mHasMore = true;
        this._waitingListData.setValue(null);
        this.isRequesting = false;
        tc0.c.h().Q = 0;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final LiveData<c1> getUserWaitingData() {
        return this._userWaitingData;
    }

    public final LiveData<List<Object>> getWaitingListData() {
        return this._waitingListData;
    }

    public final LiveData<Text> getWaitingTitleData() {
        return this._waitingTitleData;
    }

    public PkAudiencePreApplyViewModel(DataCenter r3) {
        this.dataCenter = r3;
        this.mCurrentCursor = "";
        this.LOAD_MORE_ITEM = new com.bytedance.android.live.livepkaudience.list.a(0);
        this.NO_MORE_ITEM = new com.bytedance.android.live.livepkaudience.list.a(1);
        this.mHasMore = true;
        MutableLiveData<Text> r4 = new MutableLiveData();
        r4.setValue(null);
        Unit r1 = Unit.INSTANCE;
        this._waitingTitleData = r4;
        MutableLiveData<c1> r5 = new MutableLiveData();
        r5.setValue(null);
        this._userWaitingData = r5;
        MutableLiveData<List<Object>> r6 = new MutableLiveData();
        r6.setValue(null);
        this._waitingListData = r6;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ DataCenter access$getDataCenter$p(PkAudiencePreApplyViewModel r0) {
        return r0.dataCenter;
    }

    public static final /* synthetic */ String access$getMCurrentCursor$p(PkAudiencePreApplyViewModel r0) {
        return r0.mCurrentCursor;
    }

    public static final /* synthetic */ MutableLiveData access$get_userWaitingData$p(PkAudiencePreApplyViewModel r0) {
        return r0._userWaitingData;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitingTitleData$p(PkAudiencePreApplyViewModel r0) {
        return r0._waitingTitleData;
    }

    public static final /* synthetic */ boolean access$isRequesting$p(PkAudiencePreApplyViewModel r0) {
        return r0.isRequesting;
    }

    private final void doPrepareApply(Room r10) {
        long r0 = System.currentTimeMillis();
        Disposable r11 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApply(r10.id, 4, 2, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r0), new f(this, r10, r0));
        this.mCompositeDisposable.add(r11);
    }

    public final void cancelPreApply(Room r4) {
        if (r4 == null) goto L5;
        Disposable r5 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApplyCancel(r4.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), c.a);
        this.mCompositeDisposable.add(r5);
        return;
    }

    public final void setTotalCount(int r1) {
        this.totalCount = r1;
    }

    public static final /* synthetic */ void access$doPrepareApply(PkAudiencePreApplyViewModel r0, Room r1) {
        r0.doPrepareApply(r1);
    }

    public static final /* synthetic */ void access$setMCurrentCursor$p(PkAudiencePreApplyViewModel r0, String r1) {
        r0.mCurrentCursor = r1;
    }

    public static final /* synthetic */ void access$setRequesting$p(PkAudiencePreApplyViewModel r0, boolean r1) {
        r0.isRequesting = r1;
    }

    public static final /* synthetic */ void access$set_waitingTitleData$p(PkAudiencePreApplyViewModel r0, MutableLiveData r1) {
        r0._waitingTitleData = r1;
    }

    public final void checkAndPreApply(Context r6, Room r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7 == null) goto L6;
        OperateType r0 = OperateType.PRE_APPLY;
        ArrayList r1 = new ArrayList();
        r1.add(qh0.g.a(r0, 2));
        r1.add(new qh0.f.g(r6, r0, 2));
        r1.add(new qh0.f.c(r6, r0, 2));
        r1.add(new qh0.f.d(r6, r0, 2, true));
        r1.add(new qh0.f.C0257f(r6, r0, 2, true));
        r1.add(new qh0.f.e(r6, r0));
        qh0.f.a(r1).a(new d(r7, this));
        return;
    }

    public final void fetchList(Room r4, boolean r5) {
        if (r5 == false) goto L12;
        this.mCurrentCursor = "";
        List r6 = (List) this._waitingListData.getValue();
        if (r6 == null) goto L7;
        r6.clear();
    L7:
        if (r4 != null) goto L9;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L21;
        this.isRequesting = true;
        LinkApi r8 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Intrinsics.checkNotNull(r4);
        RxUtilKt.c(r8.getPrepareApplyList(r4.id, this.mCurrentCursor, 50).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this), new h(this)), this.mCompositeDisposable);
        return;
    L21:
        return;
    L9:
        if (this.isRequesting == true) goto L17;
    L16:
        r7 = true;
        goto L18
    L12:
        if (this.mHasMore == false) goto L17;
        if (r4 == null) goto L17;
        if (this.isRequesting == true) goto L17;
        goto L16
    }

    private final void addFooter(List<? extends Object> r8, boolean r9, long r10) {
        ArrayList r0 = new ArrayList();
        List r1 = (List) this._waitingListData.getValue();
        if (r1 == null) goto L6;
        r0.addAll(r1);
    L6:
        if ((CollectionsKt.firstOrNull(r0) instanceof com.bytedance.android.live.livepkaudience.list.m.a) == false) goto L9;
        ListProtector.remove(r0, 0);
    L9:
        if ((CollectionsKt.lastOrNull(r0) instanceof com.bytedance.android.live.livepkaudience.list.a) == false) goto L11;
        ListProtector.remove(r0, CollectionsKt.getLastIndex(r0));
    L11:
        List<? extends Object> r11 = r8;
        if (r11 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L21;
        r0.addAll(r11);
    L21:
        if (r0.size() <= 0) goto L52;
        Iterator r12 = r0.iterator();
        int r3 = 0;
    L24:
        if (r12.hasNext() == false) goto L48;
        Object r4 = r12.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        if ((r4 instanceof c1) == false) goto L47;
        c1 r6 = (c1) r4;
        r6.b = r10;
        c1 r7 = (c1) this._userWaitingData.getValue();
        if (r6.f() == null) goto L47;
        String r13 = null;
        if (r7 == null) goto L35;
        IBaseUser r14 = r7.f();
    L36:
        if (r14 == null) goto L47;
        IBaseUser r15 = r6.f();
        if (r15 == null) goto L40;
        String r16 = r15.getIdString();
    L41:
        IBaseUser r17 = r7.f();
        if (r17 == null) goto L45;
        r13 = r17.getIdString();
    L45:
        if (Intrinsics.areEqual(r16, r13) == false) goto L47;
        r7.g(r5);
        this._userWaitingData.setValue(r7);
        goto L47
    L40:
        r16 = null;
        goto L41
    L35:
        r14 = null;
    L47:
        r3 = r5;
        goto L24
    L48:
        ListProtector.add(r0, 0, new com.bytedance.android.live.livepkaudience.list.m.a());
        if (r9 == false) goto L51;
        r0.add(this.LOAD_MORE_ITEM);
        goto L52
    L51:
        r0.add(this.NO_MORE_ITEM);
    L52:
        this._waitingListData.setValue(r0);
        this.mHasMore = r9;
        return;
    L14:
        if (r11.isEmpty() == true) goto L17;
        r2 = false;
        goto L18
    }

    public static final /* synthetic */ void access$addFooter(PkAudiencePreApplyViewModel r0, List r1, boolean r2, long r3) {
        r0.addFooter(r1, r2, r3);
    }
}
