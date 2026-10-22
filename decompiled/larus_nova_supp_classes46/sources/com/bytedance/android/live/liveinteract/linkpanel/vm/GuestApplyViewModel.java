package com.bytedance.android.live.liveinteract.linkpanel.vm;

import am2.x;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.util.p;
import com.bytedance.android.live.liveinteract.linkpanel.util.w;
import com.bytedance.android.live.liveinteract.linkpanel.util.z;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.AddPriceSteps;
import com.bytedance.android.live.liveinteract.plantform.model.GetInfoBeforeAddPriceResponse;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.model.w1;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0081\u0001B\u0007¢\u0006\u0004\b~\u0010\u007fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J \u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J0\u0010\u0019\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J \u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J&\u0010\u001c\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0002JB\u0010\"\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\b\u001a\u00020\u0002J(\u0010'\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00042\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0016J.\u0010.\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016J\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\b\u00102\u001a\u0004\u0018\u00010\u000fJ\u0006\u00103\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0004J\u0006\u00106\u001a\u00020\tJ\u0006\u00107\u001a\u00020\tJ\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004R\"\u0010:\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010BR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010GR\"\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010G\u001a\u0004\bN\u0010I\"\u0004\b\u0012\u0010KR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0\u000e8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001e\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010W\u001a\u0004\bX\u0010YR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00160S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010VR\u001c\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010VR\"\u0010\\\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010VR\u001c\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010]0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010VR\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010VR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00020S8\u0006¢\u0006\f\n\u0004\b`\u0010V\u001a\u0004\ba\u0010bR\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00160S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010VR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160S8\u0006¢\u0006\f\n\u0004\b\u0017\u0010V\u001a\u0004\bd\u0010bR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010ER\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\"\u0010l\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010G\u001a\u0004\bm\u0010I\"\u0004\bn\u0010KR\"\u0010o\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010G\u001a\u0004\bp\u0010I\"\u0004\bq\u0010KR\u0019\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0r8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00160r8F¢\u0006\u0006\u001a\u0004\bv\u0010tR\u0019\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0r8F¢\u0006\u0006\u001a\u0004\bx\u0010tR\u001f\u0010{\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e0r8F¢\u0006\u0006\u001a\u0004\bz\u0010tR\u0019\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010]0r8F¢\u0006\u0006\u001a\u0004\b|\u0010t¨\u0006\u0082\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/vm/GuestApplyViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "", "isIncreasePriceOn", "", "getFetchWaitingListCount", "Lcom/bytedance/android/livesdk/chatroom/model/w1;", "data", "isTabChanged", "", "handleWaitingListData", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "list", "", "", "getUserIdList", "waitingUserList", "setAddPriceAudienceNum", "", "waitingUsers", "hasMore", "", "waitingListType", "showPaidListTab", "addFooter", "addPaidQueueItem", "newList", "setApplyTitle", "forceRefresh", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", PbRequest.SwitchType.ROOM, "currentCursor", "source", "fetchList", "mode", "expectedAddPriceValue", "Lkotlin/Function0;", "onFailed", "getInfoBeforeAddPrice", "getRankAfterIncreasePrice", "getPaidCount", "roomId", "paidCount", "addPriceCount", "expectedLineUp", "normalPaidLinkMicAddPrice", "getPreAddPriceCount", "getNextAddPriceCount", "getCurrentUserPaidAmount", "getLineUp", "getApplyWaitingCount", "count", "setApplyWaitingCount", "clearAddPriceData", BuildConfig.BUILD_TYPE, "getCurrentWaitingUserOffset", "getCurrentWaitingUserPaidAmount", "mCurrentCursor", "Ljava/lang/String;", "getMCurrentCursor", "()Ljava/lang/String;", "setMCurrentCursor", "(Ljava/lang/String;)V", "Lzf0/d;", "LOAD_MORE_ITEM", "Lzf0/d;", "NO_MORE_ITEM", "mHasMore", "Z", "totalCount", "J", "getTotalCount", "()J", "setTotalCount", "(J)V", "mApplyWaitingCount", "addPriceAudienceNum", "getAddPriceAudienceNum", "mWaitingUserList", "Ljava/util/List;", "getMWaitingUserList", "()Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/base/model/message/a5;", "_waitingTitleData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "_sortTypeLiveData", "_userWaitingData", "_waitingListData", "Lcom/bytedance/android/live/liveinteract/plantform/model/GetInfoBeforeAddPriceResponse;", "_afterIncreasePriceData", "_addPriceState", "addPriceState", "getAddPriceState", "()Landroidx/lifecycle/MutableLiveData;", "_waitingListType", "getWaitingListType", "Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isRequesting", "Lkotlin/Pair;", "mPaidQueuePair", "Lkotlin/Pair;", "lynxCurrentUserWaitingOffset", "getLynxCurrentUserWaitingOffset", "setLynxCurrentUserWaitingOffset", "lynxCurrentUserPaidAmount", "getLynxCurrentUserPaidAmount", "setLynxCurrentUserPaidAmount", "Landroidx/lifecycle/LiveData;", "getWaitingTitleData", "()Landroidx/lifecycle/LiveData;", "waitingTitleData", "getSortTypeLiveData", "sortTypeLiveData", "getUserWaitingData", "userWaitingData", "getWaitingListData", "waitingListData", "getAfterIncreasePriceData", "afterIncreasePriceData", "<init>", "()V", "Companion", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestApplyViewModel extends DataContext {
    public static final a Companion = null;
    public static final String TAG = "GuestApplyViewModel";
    private final zf0.d LOAD_MORE_ITEM;
    private final zf0.d NO_MORE_ITEM;
    private MutableLiveData<Boolean> _addPriceState;
    private final MutableLiveData<GetInfoBeforeAddPriceResponse> _afterIncreasePriceData;
    private final MutableLiveData<Integer> _sortTypeLiveData;
    private final MutableLiveData<n0> _userWaitingData;
    private final MutableLiveData<List<Object>> _waitingListData;
    private MutableLiveData<Integer> _waitingListType;
    private MutableLiveData<a5> _waitingTitleData;
    private long addPriceAudienceNum;
    private final MutableLiveData<Boolean> addPriceState;
    private boolean isRequesting;
    private long lynxCurrentUserPaidAmount;
    private long lynxCurrentUserWaitingOffset;
    private long mApplyWaitingCount;
    private final CompositeDisposable mCompositeDisposable;
    private String mCurrentCursor;
    private boolean mHasMore;
    private Pair<Integer, Integer> mPaidQueuePair;
    private final List<n0> mWaitingUserList;
    private final IRoom room;
    private long totalCount;
    private final MutableLiveData<Integer> waitingListType;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GuestApplyViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ IRoom d;
        public final /* synthetic */ int e;

        public b(GuestApplyViewModel r1, long r2, boolean r4, IRoom r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            ALogger.i("panel_first_frame_opt_tag", "getWaitingList ;; duration == " + (System.currentTimeMillis() - this.b));
            if (r8 == null) goto L38;
            w1 r1 = (w1) r8.data;
            if (r1 == null) goto L38;
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            long r3 = this.b;
            String r9 = r8.logId;
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r3, r9);
            tc0.c.h().Q = r1.getNow();
            this.a.setTotalCount(r1.getTotalCount());
            GuestApplyViewModel.access$setMPaidQueuePair$p(this.a, new Pair(Integer.valueOf((int) r1.getNormalListTotalCount()), Integer.valueOf((int) r1.getPaidListTotalCount())));
            vh7.c r10 = r1.getDisplayText();
            if (r10 == null) goto L13;
            MutableLiveData r4 = GuestApplyViewModel.access$get_waitingTitleData$p(this.a);
            a5 r11 = jm2.a.d(r10);
            if (r11 == null) goto L12;
            r4.setValue(r11);
            goto L13
        L12:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.IText");
        L13:
            GuestApplyViewModel.access$get_sortTypeLiveData$p(this.a).setValue(Integer.valueOf(r1.getSortType()));
            GuestApplyViewModel.access$handleWaitingListData(this.a, r1, this.c);
            if (o.x(this.d) == true) goto L16;
        L18:
            int r12 = this.e;
            if (r12 != WaitingListType.UNKNOWN.ordinal()) goto L21;
            r12 = r1.getWaitingListType();
            GuestApplyViewModel.access$get_waitingListType$p(this.a).setValue(Integer.valueOf(r12));
        L21:
            GuestApplyViewModel r5 = this.a;
            GuestApplyViewModel.access$addFooter(r5, r5.getMWaitingUserList(), r1.getHasMore(), r12, r1.getShowPaidListTab());
            if (o.x(this.d) == false) goto L27;
            if (GuestApplyViewModel.access$isIncreasePriceOn(this.a) == false) goto L27;
            GuestApplyViewModel.access$get_userWaitingData$p(this.a).setValue((n0) jm2.a.d(r1.getCurrentUserWaitingInfo()));
        L32:
            String r13 = r1.getNextCursor();
            if (r13 == null) goto L36;
            this.a.setMCurrentCursor(r13);
        L36:
            if (GuestApplyViewModel.access$getMApplyWaitingCount$p(this.a) != 0) goto L38;
            GuestApplyViewModel.access$setMApplyWaitingCount$p(this.a, r1.getTotalCount());
        L27:
            if (this.a.getMCurrentCursor().length() != 0) goto L29;
            boolean r14 = true;
        L30:
            if (r14 == false) goto L32;
            GuestApplyViewModel.access$get_userWaitingData$p(this.a).setValue((n0) jm2.a.d(r1.getCurrentUserWaitingInfo()));
            goto L32
        L29:
            r14 = false;
            goto L30
        L16:
            if (GuestApplyViewModel.access$isIncreasePriceOn(this.a) == false) goto L18;
            GuestApplyViewModel r15 = this.a;
            GuestApplyViewModel.access$setAddPriceAudienceNum(r15, r15.getMWaitingUserList());
        L38:
            GuestApplyViewModel.access$setRequesting$p(this.a, false);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GuestApplyViewModel a;
        public final /* synthetic */ long b;

        public c(GuestApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            p.f("apply_panel", r5, null, null, 12);
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r1, r5);
            GuestApplyViewModel.access$setRequesting$p(this.a, false);
            ALogger.e(GuestApplyViewModel.TAG, "getWaitingList fail!");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GuestApplyViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public d(GuestApplyViewModel r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            GuestApplyViewModel.access$get_afterIncreasePriceData$p(this.a).setValue(r12.data);
            if (this.b != 1) goto L13;
            MultiLinkEventModule r0 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
            long r1 = this.c;
            String r7 = r12.logId;
            GetInfoBeforeAddPriceResponse r2 = (GetInfoBeforeAddPriceResponse) r12.data;
            long r3 = 0;
            if (r2 == null) goto L7;
            long r5 = r2.getAddPriceValue();
        L8:
            GetInfoBeforeAddPriceResponse r13 = (GetInfoBeforeAddPriceResponse) r12.data;
            if (r13 == null) goto L11;
            r3 = r13.getRankAfterAddPrice();
        L11:
            Intrinsics.checkNotNullParameter(r7, "logId");
            JSONObject r8 = new JSONObject();
            r8.put("add_price", r5);
            r8.put("rank", r3);
            nd0.c.s(nd0.c.a, LinkMonitorData.GetInfoBeforeAddPrice, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.b(r1), r7, r8, 96);
            return;
        L7:
            r5 = 0;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public e(Function0 r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r11) {
            Throwable r5 = (Throwable) r11;
            ALogger.e(GuestApplyViewModel.TAG, r5.getMessage());
            Function0 r12 = this.a;
            if (r12 == null) goto L6;
            Unit r13 = (Unit) r12.invoke();
        L6:
            if (this.b != 1) goto L9;
            MultiLinkEventModule r14 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
            long r0 = this.c;
            JSONObject r6 = new JSONObject();
            nd0.c.r(nd0.c.a, LinkMonitorData.GetInfoBeforeAddPrice, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.b(r0), r5, r6, 32);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GuestApplyViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;

        public f(GuestApplyViewModel r1, int r2, int r3, int r4, int r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r20) {
            com.bytedance.android.live.network.response.a r1 = (com.bytedance.android.live.network.response.a) r20;
            GuestApplyViewModel.access$get_addPriceState$p(this.a).setValue(Boolean.TRUE);
            if (((IInteractService) k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L6;
            long r2 = this.b;
            int r4 = fj0.e.a;
            fj0.b.a.f = r2;
        L6:
            if (this.c != 3) goto L13;
            long r10 = this.a.getCurrentWaitingUserOffset();
            int r3 = this.b;
            int r5 = this.d;
            int r12 = this.e;
            long r13 = ((long) r3) + this.a.getCurrentWaitingUserPaidAmount();
            long r15 = this.a.getCurrentWaitingUserPaidAmount();
            LinkedHashMap r9 = new LinkedHashMap();
            m.G(r9);
            m.B(r9, null, 6);
            l0.e(r9);
            r9.put("line_up", String.valueOf(r10));
            if (r15 <= 0) goto L10;
            String r11 = "priority";
        L11:
            r9.put("user_tab", r11);
            r9.put("function_type2", "live");
            r9.put("pay_amt", String.valueOf(r3));
            r9.put("expected_line_up", String.valueOf(r5));
            r9.put("pay_cnt", String.valueOf(r12));
            r9.put("pay_amt_all", String.valueOf(r13));
            j0.l().sendLog("livesdk_audience_connection_priority_pay_success", r9, new Object[]{IRoom.class});
            goto L13
        L10:
            r11 = "normal";
        L13:
            if (this.c != 1) goto L15;
            MultiLinkEventModule r6 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
            long r14 = this.f;
            String r7 = r1.logId;
            int r8 = this.e;
            Intrinsics.checkNotNullParameter(r7, "logId");
            JSONObject r16 = new JSONObject();
            r16.put("add_price", r8);
            nd0.c.s(nd0.c.a, LinkMonitorData.NormalPaidLinkMicAddPrice, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.b(r14), r7, r16, 96);
        L15:
            IRoom r17 = this.a.getRoom();
            if (r17 == null) goto L19;
            String r18 = r17.getOwnerUserIdString();
            if (r18 == null) goto L19;
        L20:
            IRoom r19 = this.a.getRoom();
            if (r19 == null) goto L23;
            Long r21 = Long.valueOf(r19.getId());
        L24:
            String r22 = String.valueOf(r21);
            String r23 = String.valueOf(this.a.getPaidCount());
            String r110 = String.valueOf(this.a.getRankAfterIncreasePrice());
            long r111 = ((long) this.b) + this.a.getCurrentWaitingUserPaidAmount();
            Intrinsics.checkNotNullParameter(r18, "anchorId");
            Intrinsics.checkNotNullParameter(r22, "roomId");
            Intrinsics.checkNotNullParameter(r23, "addPrice");
            Intrinsics.checkNotNullParameter(r110, "expectedLineUp");
            LinkedHashMap r112 = new LinkedHashMap();
            m.G(r112);
            m.B(r112, null, 6);
            l0.e(r112);
            r112.put("anchor_id", r18);
            r112.put("room_id", r22);
            r112.put("play_mode", w.c());
            r112.put("time", String.valueOf(w.b()));
            r112.put("recharge_price", String.valueOf(w.a()));
            r112.put("line_up", r110);
            r112.put("add_price", r23);
            r112.put("expected_line_up", r110);
            r112.put("amt_all", String.valueOf(r111));
            j0.l().sendLog("livesdk_guest_connection_rechargeble_premium_success", r112, new Object[]{IRoom.class, x.class});
            f2.c(s1.B(2131917419), 0);
            return;
        L23:
            r21 = null;
        L19:
            r18 = "";
            goto L20
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ GuestApplyViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public g(GuestApplyViewModel r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r11) {
            CustomApiServerException r5 = (Throwable) r11;
            if ((r5 instanceof CustomApiServerException) == false) goto L14;
            CustomApiServerException r12 = r5;
            if (r12.getErrorCode() != 40001) goto L8;
            f2.c(r12.getPrompt(), 0);
            x2 r13 = new x2(1, "live_detail", "", "");
            xs2.b.a().post(r13);
            goto L14
        L8:
            if (r12.getErrorCode() != 4004243) goto L11;
            f2.c(s1.B(2131923425), 0);
            goto L14
        L11:
            if (r12.getErrorCode() != 4004403) goto L13;
            f2.c(r12.getPrompt(), 0);
            goto L14
        L13:
            f2.c(s1.B(2131917418), 0);
        L14:
            GuestApplyViewModel.access$get_addPriceState$p(this.a).setValue(Boolean.FALSE);
            if (this.b != 1) goto L18;
            MultiLinkEventModule r14 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
            long r0 = this.c;
            JSONObject r6 = new JSONObject();
            nd0.c.r(nd0.c.a, LinkMonitorData.NormalPaidLinkMicAddPrice, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.b(r0), r5, r6, 32);
            return;
        }
    }

    static {
        Companion = new a();
    }

    public final void clearAddPriceData() {
        this._afterIncreasePriceData.setValue(null);
    }

    public final void release() {
        this.mCompositeDisposable.clear();
        this.mCurrentCursor = "";
        this._waitingTitleData.setValue(null);
        this._userWaitingData.setValue(null);
        this.mHasMore = true;
        this.mWaitingUserList.clear();
        this._waitingListData.setValue(null);
        this._afterIncreasePriceData.setValue(null);
        this.addPriceAudienceNum = 0;
        this.isRequesting = false;
        tc0.c.h().Q = 0;
    }

    public GuestApplyViewModel() {
        this.mCurrentCursor = "";
        this.LOAD_MORE_ITEM = new zf0.d(0);
        this.NO_MORE_ITEM = new zf0.d(1);
        this.mHasMore = true;
        this.mWaitingUserList = new ArrayList();
        MutableLiveData<a5> r0 = new MutableLiveData();
        r0.setValue(null);
        Unit r3 = Unit.INSTANCE;
        this._waitingTitleData = r0;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L5;
        IRoom r2 = (IRoom) r1.getValue();
    L6:
        this.room = r2;
        MutableLiveData<Integer> r4 = new MutableLiveData();
        r4.setValue(40);
        this._sortTypeLiveData = r4;
        MutableLiveData<n0> r5 = new MutableLiveData();
        r5.setValue(null);
        this._userWaitingData = r5;
        MutableLiveData<List<Object>> r6 = new MutableLiveData();
        r6.setValue(null);
        this._waitingListData = r6;
        MutableLiveData<GetInfoBeforeAddPriceResponse> r7 = new MutableLiveData();
        r7.setValue(null);
        this._afterIncreasePriceData = r7;
        MutableLiveData<Boolean> r8 = new MutableLiveData();
        this._addPriceState = r8;
        this.addPriceState = r8;
        MutableLiveData<Integer> r9 = new MutableLiveData();
        this._waitingListType = r9;
        this.waitingListType = r9;
        this.mCompositeDisposable = new CompositeDisposable();
        this.mPaidQueuePair = new Pair(0, 0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final long getFetchWaitingListCount() {
        t61 r0 = z.a();
        if (r0 != null) goto L5;
    L10:
        return 50;
    L5:
        if (u61.a(r0) != true) goto L10;
        t61 r1 = z.a();
        if (r1 != null) goto L12;
        return 10;
    L12:
        return r1.f7();
    }

    private final boolean isIncreasePriceOn() {
        return o.y();
    }

    public final long getCurrentUserPaidAmount() {
        return getCurrentWaitingUserPaidAmount();
    }

    public final long getCurrentWaitingUserOffset() {
        if (getUserWaitingData().getValue() == null) goto L7;
        n0 r0 = (n0) getUserWaitingData().getValue();
        if (r0 != null) goto L12;
        return 0;
    L12:
        return r0.getOffset();
    L7:
        long r3 = this.lynxCurrentUserWaitingOffset;
        if (r3 != 0) goto L10;
        return 0;
    L10:
        return r3;
    }

    public final long getCurrentWaitingUserPaidAmount() {
        if (getUserWaitingData().getValue() == null) goto L7;
        n0 r0 = (n0) getUserWaitingData().getValue();
        if (r0 != null) goto L12;
        return 0;
    L12:
        return r0.getPaidAmount();
    L7:
        long r3 = this.lynxCurrentUserPaidAmount;
        if (r3 != 0) goto L10;
        return 0;
    L10:
        return r3;
    }

    public final String getLineUp() {
        n0 r0 = (n0) getUserWaitingData().getValue();
        Long r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.getOffset());
    L7:
        if (r2 == null) goto L16;
        n0 r3 = (n0) getUserWaitingData().getValue();
        if (r3 != null) goto L11;
    L12:
        n0 r4 = (n0) getUserWaitingData().getValue();
        if (r4 == null) goto L33;
        r1 = Long.valueOf(r4.getOffset());
    L33:
        return String.valueOf(r1);
    L11:
        if (r3.getOffset() != 0) goto L12;
    L16:
        long r5 = this.lynxCurrentUserWaitingOffset;
        if (r5 != 0) goto L34;
        n0 r6 = tc0.c.h().P;
        if (r6 == null) goto L22;
        Long r7 = Long.valueOf(r6.getOffset());
    L23:
        if (r7 == null) goto L35;
        n0 r8 = tc0.c.h().P;
        if (r8 != null) goto L27;
    L28:
        n0 r9 = tc0.c.h().P;
        if (r9 == null) goto L32;
        r1 = Long.valueOf(r9.getOffset());
    L32:
        return String.valueOf(r1);
    L27:
        if (r8.getOffset() != 0) goto L28;
        return null;
    L35:
        return null;
    L22:
        r7 = null;
        goto L23
    L34:
        return String.valueOf(r5);
    L5:
        r2 = null;
        goto L7
    }

    public final long getNextAddPriceCount() {
        GetInfoBeforeAddPriceResponse r0 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r0 == null) goto L5;
        long r1 = r0.getMaxAddPriceValue();
    L6:
        GetInfoBeforeAddPriceResponse r2 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r2 == null) goto L9;
        long r3 = r2.getAddPriceValue();
    L10:
        GetInfoBeforeAddPriceResponse r4 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r4 == null) goto L23;
        List<AddPriceSteps> r5 = r4.getAddPriceSteps();
        if (r5 == null) goto L23;
        Iterator<T> r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        AddPriceSteps r7 = (AddPriceSteps) r6.next();
        if (r3 < r7.getLeftClosedInterval()) goto L16;
        if (r3 > r7.getRightClosedInterval()) goto L16;
        r3 = r3 + r7.getStep();
    L23:
        if (r3 < r1) goto L26;
        return r1;
    L26:
        return r3;
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 10000;
        goto L6
    }

    public final int getPaidCount() {
        GetInfoBeforeAddPriceResponse r0 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r0 == null) goto L5;
        int r1 = (int) r0.getAddPriceValue();
    L6:
        if (r1 <= 0) goto L11;
        GetInfoBeforeAddPriceResponse r2 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r2 == null) goto L24;
        long r3 = r2.getAddPriceValue();
    L25:
        return (int) r3;
    L24:
        return 0;
    L11:
        IService r4 = k.f(IInteractService.class);
        Intrinsics.checkNotNull(r4);
        cj0.a r5 = ((IInteractService) r4).paidLinkMicContext();
        if (r5 == null) goto L16;
        cj0.c r6 = r5.getWidget();
        if (r6 == null) goto L16;
        long r7 = r6.getIncreasePrice();
    L18:
        if (r7 <= 0) goto L26;
        cj0.a r8 = ((IInteractService) k.n(IInteractService.class)).paidLinkMicContext();
        if (r8 == null) goto L27;
        cj0.c r9 = r8.getWidget();
        if (r9 == null) goto L28;
        r3 = r9.getIncreasePrice();
        goto L25
    L28:
        return 0;
    L27:
        return 0;
    L26:
        return 0;
    L16:
        r7 = 0;
        goto L18
    L5:
        r1 = 0;
        goto L6
    }

    public final long getPreAddPriceCount() {
        GetInfoBeforeAddPriceResponse r0 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        long r1 = 0;
        if (r0 == null) goto L5;
        long r3 = r0.getAddPriceValue();
    L6:
        GetInfoBeforeAddPriceResponse r2 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r2 == null) goto L22;
        List<AddPriceSteps> r4 = r2.getAddPriceSteps();
        if (r4 == null) goto L22;
        Iterator<T> r5 = r4.iterator();
        long r6 = 0;
    L12:
        if (r5.hasNext() == false) goto L21;
        AddPriceSteps r7 = (AddPriceSteps) r5.next();
        if (r6 != 0) goto L17;
        r6 = r7.getLeftClosedInterval();
    L17:
        if (r3 < r7.getLeftClosedInterval()) goto L12;
        if (r3 > r7.getRightClosedInterval()) goto L12;
        r3 = r3 - r7.getStep();
    L24:
        if (r3 <= r6) goto L26;
        return r3;
    L26:
        return r6;
    L21:
        r1 = r6;
    L22:
        r6 = r1;
        goto L24
    L5:
        r3 = 0;
        goto L6
    }

    public final int getRankAfterIncreasePrice() {
        GetInfoBeforeAddPriceResponse r0 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r0 == null) goto L5;
        int r1 = (int) r0.getRankAfterAddPrice();
    L6:
        if (r1 <= 0) goto L11;
        GetInfoBeforeAddPriceResponse r2 = (GetInfoBeforeAddPriceResponse) getAfterIncreasePriceData().getValue();
        if (r2 != null) goto L13;
        return 0;
    L13:
        return (int) r2.getRankAfterAddPrice();
    L11:
        return ((int) this.addPriceAudienceNum) + 1;
    L5:
        r1 = 0;
        goto L6
    }

    public final long getAddPriceAudienceNum() {
        return this.addPriceAudienceNum;
    }

    public final MutableLiveData<Boolean> getAddPriceState() {
        return this.addPriceState;
    }

    public final LiveData<GetInfoBeforeAddPriceResponse> getAfterIncreasePriceData() {
        return this._afterIncreasePriceData;
    }

    public final long getApplyWaitingCount() {
        return this.mApplyWaitingCount;
    }

    public final long getLynxCurrentUserPaidAmount() {
        return this.lynxCurrentUserPaidAmount;
    }

    public final long getLynxCurrentUserWaitingOffset() {
        return this.lynxCurrentUserWaitingOffset;
    }

    public final String getMCurrentCursor() {
        return this.mCurrentCursor;
    }

    public final List<n0> getMWaitingUserList() {
        return this.mWaitingUserList;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    public final LiveData<Integer> getSortTypeLiveData() {
        return this._sortTypeLiveData;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public final LiveData<n0> getUserWaitingData() {
        return this._userWaitingData;
    }

    public final LiveData<List<Object>> getWaitingListData() {
        return this._waitingListData;
    }

    public final MutableLiveData<Integer> getWaitingListType() {
        return this.waitingListType;
    }

    public final LiveData<a5> getWaitingTitleData() {
        return this._waitingTitleData;
    }

    public static final /* synthetic */ long access$getMApplyWaitingCount$p(GuestApplyViewModel r2) {
        return r2.mApplyWaitingCount;
    }

    public static final /* synthetic */ Pair access$getMPaidQueuePair$p(GuestApplyViewModel r0) {
        return r0.mPaidQueuePair;
    }

    public static final /* synthetic */ MutableLiveData access$get_addPriceState$p(GuestApplyViewModel r0) {
        return r0._addPriceState;
    }

    public static final /* synthetic */ MutableLiveData access$get_afterIncreasePriceData$p(GuestApplyViewModel r0) {
        return r0._afterIncreasePriceData;
    }

    public static final /* synthetic */ MutableLiveData access$get_sortTypeLiveData$p(GuestApplyViewModel r0) {
        return r0._sortTypeLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_userWaitingData$p(GuestApplyViewModel r0) {
        return r0._userWaitingData;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitingListType$p(GuestApplyViewModel r0) {
        return r0._waitingListType;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitingTitleData$p(GuestApplyViewModel r0) {
        return r0._waitingTitleData;
    }

    public static final /* synthetic */ boolean access$isIncreasePriceOn(GuestApplyViewModel r0) {
        return r0.isIncreasePriceOn();
    }

    public static final /* synthetic */ boolean access$isRequesting$p(GuestApplyViewModel r0) {
        return r0.isRequesting;
    }

    private final List<String> getUserIdList(List<? extends n0> r3) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L16;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L16;
        vh7.c r1 = jm2.a.d((n0) r4.next());
        if (r1 == null) goto L15;
        IBaseUser r2 = ((n0) r1).getUserFlex();
        if (r2 == null) goto L12;
        String r5 = r2.getIdString();
    L13:
        r0.add(r5);
        goto L6
    L12:
        r5 = null;
        goto L13
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.IWaitingListUser");
    L16:
        return r0;
    }

    private final void setAddPriceAudienceNum(List<? extends n0> r5) {
        long r0 = 0;
        if (r5 == null) goto L10;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        if (((n0) r6.next()).isAddPrice() == false) goto L6;
        r0 = r0 + 1;
    L10:
        this.addPriceAudienceNum = r0;
    }

    public final void setApplyWaitingCount(long r1) {
        this.mApplyWaitingCount = r1;
    }

    public final void setLynxCurrentUserPaidAmount(long r1) {
        this.lynxCurrentUserPaidAmount = r1;
    }

    public final void setLynxCurrentUserWaitingOffset(long r1) {
        this.lynxCurrentUserWaitingOffset = r1;
    }

    public final void setMCurrentCursor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCurrentCursor = r2;
    }

    public final void setTotalCount(long r1) {
        this.totalCount = r1;
    }

    public final void setAddPriceAudienceNum(long r1) {
        this.addPriceAudienceNum = r1;
    }

    public static final /* synthetic */ void access$setAddPriceAudienceNum(GuestApplyViewModel r0, List r1) {
        r0.setAddPriceAudienceNum(r1);
    }

    public static final /* synthetic */ void access$setMApplyWaitingCount$p(GuestApplyViewModel r0, long r1) {
        r0.mApplyWaitingCount = r1;
    }

    public static final /* synthetic */ void access$setMPaidQueuePair$p(GuestApplyViewModel r0, Pair r1) {
        r0.mPaidQueuePair = r1;
    }

    public static final /* synthetic */ void access$setRequesting$p(GuestApplyViewModel r0, boolean r1) {
        r0.isRequesting = r1;
    }

    public static final /* synthetic */ void access$set_addPriceState$p(GuestApplyViewModel r0, MutableLiveData r1) {
        r0._addPriceState = r1;
    }

    public static final /* synthetic */ void access$set_waitingListType$p(GuestApplyViewModel r0, MutableLiveData r1) {
        r0._waitingListType = r1;
    }

    public static final /* synthetic */ void access$set_waitingTitleData$p(GuestApplyViewModel r0, MutableLiveData r1) {
        r0._waitingTitleData = r1;
    }

    private final void handleWaitingListData(w1 r6, boolean r7) {
        long r0 = r6.getTotalCount();
        List r2 = r6.getWaitingUserList();
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L7:
        if (r0 > r3) goto L9;
    L18:
        this.mWaitingUserList.clear();
    L19:
        List r8 = r6.getWaitingUserList();
        if (r8 == null) goto L23;
        this.mWaitingUserList.addAll(r8);
        return;
    L23:
        return;
    L9:
        if (this.mHasMore == false) goto L18;
        if (r7 == true) goto L18;
        if (ListUtils.isEmpty(r6.getWaitingUserList()) == true) goto L19;
        if (ListUtils.isEmpty(this.mWaitingUserList) == true) goto L19;
        List<String> r9 = getUserIdList(this.mWaitingUserList);
        r9.retainAll(getUserIdList(r6.getWaitingUserList()));
        if (r9.size() <= 0) goto L19;
        this.mWaitingUserList.clear();
        goto L19
    L5:
        r3 = 0;
        goto L7
    }

    public static final /* synthetic */ void access$handleWaitingListData(GuestApplyViewModel r0, w1 r1, boolean r2) {
        r0.handleWaitingListData(r1, r2);
    }

    private final void addPaidQueueItem(boolean r4, int r5, boolean r6) {
        if (r6 == true) goto L4;
        return;
    L4:
        if (o.z() == true) goto L13;
        ArrayList r7 = new ArrayList();
        r7.add(new zf0.f.a(r5, ApplyTitlePanelType.GUEST_APPLY, this.mPaidQueuePair));
        if (r5 != WaitingListType.PAID.ordinal()) goto L9;
        r7.add(new zf0.d(2));
    L10:
        this._waitingListData.setValue(r7);
        this.mHasMore = r4;
        return;
    L9:
        r7.add(new zf0.e.a());
        goto L10
    }

    private final void setApplyTitle(List<Object> r12, int r13, boolean r14) {
        if (o.x(this.room) == true) goto L5;
    L14:
        if (r14 == false) goto L23;
        cj0.a r15 = ((IInteractService) k.n(IInteractService.class)).paidLinkMicContext();
        if (r15 == null) goto L21;
        cj0.c r16 = r15.getWidget();
        if (r16 == null) goto L21;
        if (r16.isPaidLinkOn() == true) goto L23;
    L21:
        ListProtector.add(r12, 0, new zf0.f.a(r13, ApplyTitlePanelType.GUEST_APPLY, this.mPaidQueuePair));
        return;
    L23:
        if (r12.size() <= 0) goto L31;
        ListProtector.add(r12, 0, new zf0.m.a(false, 2, ApplyTitlePanelType.GUEST_APPLY));
        return;
    L31:
        return;
    L5:
        if (isIncreasePriceOn() == false) goto L14;
        long r17 = this.addPriceAudienceNum;
        if (r17 <= 0) goto L12;
        ApplyTitlePanelType r4 = ApplyTitlePanelType.GUEST_APPLY;
        ListProtector.add(r12, 0, new zf0.m.a(true, 1, r4));
        if (r12.size() <= (this.addPriceAudienceNum + 1)) goto L26;
        ListProtector.add(r12, (int) (r17 + 1), new zf0.m.a(true, 2, r4));
        return;
    L26:
        return;
    L12:
        if (r12.size() <= 0) goto L28;
        ListProtector.add(r12, 0, new zf0.m.a(false, 2, ApplyTitlePanelType.GUEST_APPLY));
        return;
    }

    public final void getInfoBeforeAddPrice(int r10, long r11, Function0<Unit> r13) {
        long r0 = System.currentTimeMillis();
        LinkAudienceApi r3 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r2 = this.room;
        if (r2 == null) goto L5;
        long r4 = r2.getRoomId();
    L6:
        RxUtilKt.c(r3.getInfoBeforeAddPrice(r4, r10, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r10, r0), new e(r13, r10, r0)), this.mCompositeDisposable);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private final void addFooter(List<? extends Object> r4, boolean r5, int r6, boolean r7) {
        if (r4 != null) goto L5;
    L11:
        ArrayList r8 = new ArrayList();
        Intrinsics.checkNotNull(r4);
        r8.addAll(r4);
        setApplyTitle(r8, r6, false);
        if (r5 == false) goto L14;
        r8.add(this.LOAD_MORE_ITEM);
    L15:
        this._waitingListData.setValue(r8);
        this.mHasMore = r5;
        return;
    L14:
        r8.add(this.NO_MORE_ITEM);
        goto L15
    L5:
        if (r4.isEmpty() == false) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L11;
        addPaidQueueItem(r5, r6, r7);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static final /* synthetic */ void access$addFooter(GuestApplyViewModel r0, List r1, boolean r2, int r3, boolean r4) {
        r0.addFooter(r1, r2, r3, r4);
    }

    public final void normalPaidLinkMicAddPrice(long r15, int r17, int r18, int r19, int r20) {
        long r6 = getCurrentWaitingUserPaidAmount();
        long r9 = System.currentTimeMillis();
        if (((Boolean) vm2.d.v1.getValue(null, vm2.d.a[123(0x7b, float:1.72E-43)])).booleanValue() == false) goto L16;
        IRoom r0 = this.room;
        SimpleDateFormat r1 = o.a;
        if (r0 == null) goto L13;
        z5 r2 = r0.getLinkerDetail();
        if (r2 == null) goto L13;
        List r3 = r2.getPlayModes();
        if (r3 == null) goto L13;
        if (r3.contains(Long.valueOf(11)) != true) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        int r5 = 1;
    L17:
        RxUtilKt.c(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).increasePriceApply(r15, r17, r5, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r17, r18, r20, r19, r9), new g(this, r18, r9)), this.mCompositeDisposable);
        return;
    L13:
        r4 = false;
    L16:
        r5 = r18;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getInfoBeforeAddPrice$default(GuestApplyViewModel r0, int r1, long r2, Function0 r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        r0.getInfoBeforeAddPrice(r1, r2, r4);
    }

    public final void fetchList(boolean r19, IRoom r20, String r21, int r22, int r23, boolean r24) {
        if (r19 == false) goto L6;
        this.mCurrentCursor = "";
    L6:
        if (this.mHasMore == true) goto L8;
        if (r19 == true) goto L8;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L21;
        this.isRequesting = true;
        long r8 = System.currentTimeMillis();
        LinkApi r10 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r20 == null) goto L18;
        long r1 = r20.getId();
    L19:
        RxUtilKt.c(r10.getWaitingList(r1, r21, getFetchWaitingListCount(), r22, r23).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r8, r24, r20, r22), new c(this, r8)), this.mCompositeDisposable);
        return;
    L18:
        r1 = 0;
        goto L19
    L21:
        return;
    L8:
        if (r20 == null) goto L13;
        if (this.isRequesting == false) goto L12;
        if (r24 == false) goto L13;
    L12:
        r0 = true;
        goto L14
    }

    public static /* synthetic */ void fetchList$default(GuestApplyViewModel r7, boolean r8, IRoom r9, String r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = "";
    L5:
        String r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r11 = WaitingListType.UNKNOWN.ordinal();
    L8:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L11;
        r12 = WaitingListSource.AUDIENCE_PANEL.ordinal();
    L11:
        int r5 = r12;
        if ((r14 & 32) == 0) goto L14;
        boolean r6 = false;
    L15:
        r7.fetchList(r8, r9, r3, r4, r5, r6);
        return;
    L14:
        r6 = r13;
        goto L15
    }
}
