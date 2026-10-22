package com.bytedance.android.live.liveinteract.linkpanel.vm;

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
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.n;
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
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import zf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 A2\u00020\u0001:\u0002BCB\u0019\u0012\u0006\u00102\u001a\u000201\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\"\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010+0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\u001dR\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0019\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0019\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)078F¢\u0006\u0006\u001a\u0004\b;\u00109R\u001f\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010+078F¢\u0006\u0006\u001a\u0004\b=\u00109¨\u0006D"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/vm/VideoRoomAudiencePreApplyViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", PbRequest.SwitchType.ROOM, "", "doPrepareApply", "", "", "waitingUsers", "", "hasMore", "", "now", "addFooter", "isRefresh", "fetchList", "Landroid/content/Context;", "context", "checkAndPreApply", "cancelPreApply", BuildConfig.BUILD_TYPE, "", "mCurrentCursor", "Ljava/lang/String;", "Lzf0/d;", "LOAD_MORE_ITEM", "Lzf0/d;", "NO_MORE_ITEM", "mHasMore", "Z", "", "totalCount", "I", "getTotalCount", "()I", "setTotalCount", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/base/model/message/a5;", "_waitingTitleData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/liveinteract/plantform/model/c1;", "_userWaitingData", "", "_waitingListData", "Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isRequesting", "Lcom/bytedance/android/live/liveinteract/linkpanel/vm/VideoRoomAudiencePreApplyViewModel$b;", "callback", "Lcom/bytedance/android/live/liveinteract/linkpanel/vm/VideoRoomAudiencePreApplyViewModel$b;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Landroidx/lifecycle/LiveData;", "getWaitingTitleData", "()Landroidx/lifecycle/LiveData;", "waitingTitleData", "getUserWaitingData", "userWaitingData", "getWaitingListData", "waitingListData", "<init>", "(Lcom/bytedance/android/live/liveinteract/linkpanel/vm/VideoRoomAudiencePreApplyViewModel$b;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "b", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomAudiencePreApplyViewModel extends DataContext {
    public static final a Companion = null;
    public static final String TAG = "VideoRoomGuestPreApplyViewModel";
    private final zf0.d LOAD_MORE_ITEM;
    private final zf0.d NO_MORE_ITEM;
    private final MutableLiveData<c1> _userWaitingData;
    private final MutableLiveData<List<Object>> _waitingListData;
    private MutableLiveData<a5> _waitingTitleData;
    private final b callback;
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

    public interface b {
        void GB();

        void e30();
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VideoRoomAudiencePreApplyViewModel a;

        public c(VideoRoomAudiencePreApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            hd0.c.f().k(0);
            VideoRoomAudiencePreApplyViewModel.access$getCallback$p(this.a).GB();
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            ALogger.w(VideoRoomAudiencePreApplyViewModel.TAG, (Throwable) r2);
            hd0.c.f().k(0);
        }
    }

    public static final class e implements qh0.d<rh0.a> {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ VideoRoomAudiencePreApplyViewModel b;

        @Override // qh0.d
        public final void b(BaseCheckException r3) {
            Intrinsics.checkNotNullParameter(r3, "exception");
            InteractLinkFullLinkMonitor.e(OperateType.PRE_APPLY.ordinal(), 2, r3);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.U(r3);
            x.K(r3);
        }

        @Override // qh0.d
        public final void onResult(rh0.a r2) {
            VideoRoomAudiencePreApplyViewModel.access$doPrepareApply(this.b, this.a);
            InteractLinkFullLinkMonitor.f(OperateType.PRE_APPLY.ordinal(), 2);
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.V();
            x.L();
        }

        public e(IRoom r1, VideoRoomAudiencePreApplyViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VideoRoomAudiencePreApplyViewModel a;
        public final /* synthetic */ long b;

        public f(VideoRoomAudiencePreApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            m r0 = o3.d().A();
            if (r0 == null) goto L5;
            r0.setValue(Boolean.TRUE);
        L5:
            VideoRoomAudiencePreApplyViewModel.access$getCallback$p(this.a).e30();
            tc0.c.h().H = "advance_apply";
            tc0.c r1 = tc0.c.h();
            r1.K = LinkApplyType.PREPARE_APPLY.getValue();
            hd0.c.f().k(1);
            if (r6 == null) goto L15;
            r1 r7 = (r1) r6.data;
            if (r7 == null) goto L15;
            a5 r8 = r7.getDisplayText();
            if (r8 == null) goto L15;
            MutableLiveData r2 = VideoRoomAudiencePreApplyViewModel.access$get_waitingTitleData$p(this.a);
            if ((r8 instanceof a5) == true) goto L14;
            r8 = null;
        L14:
            r2.setValue(r8);
        L15:
            f2.b(2131917534, 0);
            n.r(System.currentTimeMillis() - this.b);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ VideoRoomAudiencePreApplyViewModel a;
        public final /* synthetic */ IRoom b;
        public final /* synthetic */ long c;

        public g(VideoRoomAudiencePreApplyViewModel r1, IRoom r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            new qh0.h(2, new VideoRoomAudiencePreApplyViewModel$doPrepareApply$2$1(this), VideoRoomAudiencePreApplyViewModel$doPrepareApply$2$2.INSTANCE).c(r6);
            ALogger.w("VideoTalkLinkIntegrationWidget", r6);
            hd0.c.f().k(0);
            if ((r6 instanceof ApiServerException) == true) goto L5;
            f2.b(2131919229, 0);
        L5:
            n.s(r6, System.currentTimeMillis() - this.c);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ VideoRoomAudiencePreApplyViewModel a;

        public h(VideoRoomAudiencePreApplyViewModel r1) {
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
            VideoRoomAudiencePreApplyViewModel.access$get_userWaitingData$p(this.a).setValue(r9.b());
            if (r9.b() == null) goto L12;
            VideoRoomAudiencePreApplyViewModel.access$get_waitingTitleData$p(this.a).setValue(jm2.a.d(r9.f()));
        L12:
            VideoRoomAudiencePreApplyViewModel.access$addFooter(this.a, r9.a(), r9.c(), r9.e());
            String r2 = r9.d();
            if (r2 == null) goto L16;
            VideoRoomAudiencePreApplyViewModel.access$setMCurrentCursor$p(this.a, r2);
        L16:
            if (r9.b() == null) goto L21;
            DataCenter r10 = VideoRoomAudiencePreApplyViewModel.access$getDataCenter$p(this.a);
            if (r10 == null) goto L20;
            r10.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
        L20:
            hd0.c.f().k(1);
            goto L25
        L21:
            DataCenter r11 = VideoRoomAudiencePreApplyViewModel.access$getDataCenter$p(this.a);
            if (r11 == null) goto L24;
            r11.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        L24:
            hd0.c.f().k(0);
        L25:
            VideoRoomAudiencePreApplyViewModel.access$setRequesting$p(this.a, false);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ VideoRoomAudiencePreApplyViewModel a;

        public i(VideoRoomAudiencePreApplyViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            VideoRoomAudiencePreApplyViewModel.access$setRequesting$p(this.a, false);
            ALogger.e("AudienceApplyViewModel", "getPrepareApplyList fail!");
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

    public final LiveData<a5> getWaitingTitleData() {
        return this._waitingTitleData;
    }

    public static final /* synthetic */ b access$getCallback$p(VideoRoomAudiencePreApplyViewModel r0) {
        return r0.callback;
    }

    public static final /* synthetic */ DataCenter access$getDataCenter$p(VideoRoomAudiencePreApplyViewModel r0) {
        return r0.dataCenter;
    }

    public static final /* synthetic */ String access$getMCurrentCursor$p(VideoRoomAudiencePreApplyViewModel r0) {
        return r0.mCurrentCursor;
    }

    public static final /* synthetic */ MutableLiveData access$get_userWaitingData$p(VideoRoomAudiencePreApplyViewModel r0) {
        return r0._userWaitingData;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitingTitleData$p(VideoRoomAudiencePreApplyViewModel r0) {
        return r0._waitingTitleData;
    }

    public static final /* synthetic */ boolean access$isRequesting$p(VideoRoomAudiencePreApplyViewModel r0) {
        return r0.isRequesting;
    }

    private final void doPrepareApply(IRoom r10) {
        long r0 = System.currentTimeMillis();
        Disposable r11 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApply(r10.getId(), 4, 2, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r0), new g(this, r10, r0));
        this.mCompositeDisposable.add(r11);
    }

    public final void cancelPreApply(IRoom r4) {
        if (r4 == null) goto L5;
        Disposable r5 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).prepareApplyCancel(r4.getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a);
        this.mCompositeDisposable.add(r5);
        return;
    }

    public final void setTotalCount(int r1) {
        this.totalCount = r1;
    }

    public VideoRoomAudiencePreApplyViewModel(b r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.callback = r2;
        this.dataCenter = r3;
        this.mCurrentCursor = "";
        this.LOAD_MORE_ITEM = new zf0.d(0);
        this.NO_MORE_ITEM = new zf0.d(1);
        this.mHasMore = true;
        MutableLiveData<a5> r4 = new MutableLiveData();
        r4.setValue(null);
        Unit r0 = Unit.INSTANCE;
        this._waitingTitleData = r4;
        MutableLiveData<c1> r5 = new MutableLiveData();
        r5.setValue(null);
        this._userWaitingData = r5;
        MutableLiveData<List<Object>> r6 = new MutableLiveData();
        r6.setValue(null);
        this._waitingListData = r6;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ void access$doPrepareApply(VideoRoomAudiencePreApplyViewModel r0, IRoom r1) {
        r0.doPrepareApply(r1);
    }

    public static final /* synthetic */ void access$setMCurrentCursor$p(VideoRoomAudiencePreApplyViewModel r0, String r1) {
        r0.mCurrentCursor = r1;
    }

    public static final /* synthetic */ void access$setRequesting$p(VideoRoomAudiencePreApplyViewModel r0, boolean r1) {
        r0.isRequesting = r1;
    }

    public static final /* synthetic */ void access$set_waitingTitleData$p(VideoRoomAudiencePreApplyViewModel r0, MutableLiveData r1) {
        r0._waitingTitleData = r1;
    }

    public final void checkAndPreApply(Context r6, IRoom r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7 == null) goto L6;
        OperateType r0 = OperateType.PRE_APPLY;
        ArrayList r1 = new ArrayList();
        r1.add(qh0.g.a(r0, 2));
        r1.add(new qh0.f.g(r6, r0, 2));
        r1.add(new qh0.f.c(r6, r0, 2));
        r1.add(new qh0.f.a(r6));
        r1.add(new qh0.f.d(r6, r0, 2, true));
        r1.add(new qh0.f.C0257f(r6, r0, 2, true));
        r1.add(new qh0.f.e(r6, r0));
        qh0.f.a(r1).a(new e(r7, this));
        return;
    }

    public final void fetchList(IRoom r4, boolean r5) {
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
        RxUtilKt.c(r8.getPrepareApplyList(r4.getId(), this.mCurrentCursor, 50).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this), new i(this)), this.mCompositeDisposable);
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
        if ((CollectionsKt.firstOrNull(r0) instanceof o.a) == false) goto L9;
        ListProtector.remove(r0, 0);
    L9:
        if ((CollectionsKt.lastOrNull(r0) instanceof zf0.d) == false) goto L11;
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
        ListProtector.add(r0, 0, new o.a());
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

    public static final /* synthetic */ void access$addFooter(VideoRoomAudiencePreApplyViewModel r0, List r1, boolean r2, long r3) {
        r0.addFooter(r1, r2, r3);
    }
}
