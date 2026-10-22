package com.bytedance.android.live.livepkaudience.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListSource;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.livepkaudience.list.l;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.WaitingListResult;
import com.bytedance.android.livesdk.chatroom.model.w1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dl0.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J \u0010\u0010\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J8\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0004R\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u000108078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0018078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010:R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010:R\"\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010:R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0018078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010:R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u0018078\u0006¢\u0006\f\n\u0004\b\u0019\u0010:\u001a\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010+R\u0019\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00180H8F¢\u0006\u0006\u001a\u0004\bL\u0010JR\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070H8F¢\u0006\u0006\u001a\u0004\bN\u0010JR\u001f\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t0H8F¢\u0006\u0006\u001a\u0004\bP\u0010J¨\u0006V"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/vm/PkGuestApplyViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/chatroom/model/WaitingListResult;", "data", "", "handleWaitingListData", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/WaitingListUser;", "list", "", "", "getUserIdList", "", "waitingUsers", "", "hasMore", "addFooter", "newList", "setApplyTitle", "forceRefresh", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", PbRequest.SwitchType.ROOM, "", "currentCursor", "", "waitingListType", "source", "fetchList", "getApplyWaitingCount", "count", "setApplyWaitingCount", BuildConfig.BUILD_TYPE, "mCurrentCursor", "Ljava/lang/String;", "getMCurrentCursor", "()Ljava/lang/String;", "setMCurrentCursor", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/livepkaudience/list/a;", "LOAD_MORE_ITEM", "Lcom/bytedance/android/live/livepkaudience/list/a;", "NO_MORE_ITEM", "mHasMore", "Z", "totalCount", "J", "getTotalCount", "()J", "setTotalCount", "(J)V", "mApplyWaitingCount", "mWaitingUserList", "Ljava/util/List;", "getMWaitingUserList", "()Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/message/Text;", "_waitingTitleData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "_sortTypeLiveData", "_userWaitingData", "_waitingListData", "_waitingListType", "getWaitingListType", "()Landroidx/lifecycle/MutableLiveData;", "Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "isRequesting", "Landroidx/lifecycle/LiveData;", "getWaitingTitleData", "()Landroidx/lifecycle/LiveData;", "waitingTitleData", "getSortTypeLiveData", "sortTypeLiveData", "getUserWaitingData", "userWaitingData", "getWaitingListData", "waitingListData", "<init>", "()V", "Companion", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkGuestApplyViewModel extends DataContext {
    public static final a Companion = null;
    public static final String TAG = "PkGuestApplyViewModel";
    private final com.bytedance.android.live.livepkaudience.list.a LOAD_MORE_ITEM;
    private final com.bytedance.android.live.livepkaudience.list.a NO_MORE_ITEM;
    private final MutableLiveData<Integer> _sortTypeLiveData;
    private final MutableLiveData<WaitingListUser> _userWaitingData;
    private final MutableLiveData<List<Object>> _waitingListData;
    private MutableLiveData<Integer> _waitingListType;
    private MutableLiveData<Text> _waitingTitleData;
    private boolean isRequesting;
    private long mApplyWaitingCount;
    private final CompositeDisposable mCompositeDisposable;
    private String mCurrentCursor;
    private boolean mHasMore;
    private final List<WaitingListUser> mWaitingUserList;
    private final Room room;
    private long totalCount;
    private final MutableLiveData<Integer> waitingListType;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PkGuestApplyViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public b(PkGuestApplyViewModel r1, long r2, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r7) {
            e r8 = (e) r7;
            if (r8 == null) goto L32;
            w1 r1 = (w1) r8.data;
            if (r1 == null) goto L32;
            m.r(this.b, r8.logId);
            tc0.c r9 = tc0.c.h();
            r9.Q = r1.getNow();
            this.a.setTotalCount(r1.getTotalCount());
            vh7.c r10 = r1.getDisplayText();
            if (r10 == null) goto L13;
            MutableLiveData r2 = PkGuestApplyViewModel.access$get_waitingTitleData$p(this.a);
            Text r11 = jm2.a.d(r10);
            if (r11 == null) goto L12;
            r2.setValue(r11);
            goto L13
        L12:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.message.Text");
        L13:
            PkGuestApplyViewModel.access$get_sortTypeLiveData$p(this.a).setValue(Integer.valueOf(r1.getSortType()));
            PkGuestApplyViewModel r12 = this.a;
            WaitingListResult r3 = jm2.a.d(r1);
            if (r3 == null) goto L31;
            PkGuestApplyViewModel.access$handleWaitingListData(r12, r3);
            if (this.c != WaitingListType.UNKNOWN.ordinal()) goto L18;
            int r13 = r1.getWaitingListType();
            PkGuestApplyViewModel.access$get_waitingListType$p(this.a).setValue(Integer.valueOf(r13));
        L18:
            PkGuestApplyViewModel r14 = this.a;
            PkGuestApplyViewModel.access$addFooter(r14, r14.getMWaitingUserList(), r1.getHasMore());
            if (this.a.getMCurrentCursor().length() != 0) goto L21;
            boolean r15 = true;
        L22:
            if (r15 == false) goto L24;
            PkGuestApplyViewModel.access$get_userWaitingData$p(this.a).setValue((WaitingListUser) jm2.a.d(r1.getCurrentUserWaitingInfo()));
        L24:
            String r16 = r1.getNextCursor();
            if (r16 == null) goto L28;
            this.a.setMCurrentCursor(r16);
        L28:
            if (PkGuestApplyViewModel.access$getMApplyWaitingCount$p(this.a) != 0) goto L32;
            PkGuestApplyViewModel.access$setMApplyWaitingCount$p(this.a, r1.getTotalCount());
            goto L32
        L21:
            r15 = false;
            goto L22
        L31:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.WaitingListResult");
        L32:
            PkGuestApplyViewModel.access$setRequesting$p(this.a, false);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkGuestApplyViewModel a;
        public final /* synthetic */ long b;

        public c(PkGuestApplyViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            PkGuestApplyViewModel.access$setRequesting$p(this.a, false);
            long r2 = this.b;
            m.q(r2, (Throwable) r5);
            x8.a.b(PkGuestApplyViewModel.TAG, "getWaitingList fail!", false);
        }
    }

    static {
        Companion = new a();
    }

    public final void release() {
        this.mCompositeDisposable.clear();
        this.mCurrentCursor = "";
        this._waitingTitleData.setValue(null);
        this._userWaitingData.setValue(null);
        this.mHasMore = true;
        this.mWaitingUserList.clear();
        this._waitingListData.setValue(null);
        this._sortTypeLiveData.setValue(null);
        this.isRequesting = false;
        tc0.c.h().Q = 0;
    }

    public PkGuestApplyViewModel() {
        this.mCurrentCursor = "";
        this.LOAD_MORE_ITEM = new com.bytedance.android.live.livepkaudience.list.a(0);
        this.NO_MORE_ITEM = new com.bytedance.android.live.livepkaudience.list.a(1);
        this.mHasMore = true;
        this.mWaitingUserList = new ArrayList();
        MutableLiveData<Text> r0 = new MutableLiveData();
        r0.setValue(null);
        Unit r2 = Unit.INSTANCE;
        this._waitingTitleData = r0;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L7;
        Room r4 = (Room) r3.getValue();
    L8:
        this.room = r4;
        MutableLiveData<Integer> r5 = new MutableLiveData();
        r5.setValue(40);
        this._sortTypeLiveData = r5;
        MutableLiveData<WaitingListUser> r6 = new MutableLiveData();
        r6.setValue(null);
        this._userWaitingData = r6;
        MutableLiveData<List<Object>> r7 = new MutableLiveData();
        r7.setValue(null);
        this._waitingListData = r7;
        MutableLiveData<Integer> r8 = new MutableLiveData();
        this._waitingListType = r8;
        this.waitingListType = r8;
        this.mCompositeDisposable = new CompositeDisposable();
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final long getApplyWaitingCount() {
        return this.mApplyWaitingCount;
    }

    public final String getMCurrentCursor() {
        return this.mCurrentCursor;
    }

    public final List<WaitingListUser> getMWaitingUserList() {
        return this.mWaitingUserList;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final LiveData<Integer> getSortTypeLiveData() {
        return this._sortTypeLiveData;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public final LiveData<WaitingListUser> getUserWaitingData() {
        return this._userWaitingData;
    }

    public final LiveData<List<Object>> getWaitingListData() {
        return this._waitingListData;
    }

    public final MutableLiveData<Integer> getWaitingListType() {
        return this.waitingListType;
    }

    public final LiveData<Text> getWaitingTitleData() {
        return this._waitingTitleData;
    }

    public static final /* synthetic */ long access$getMApplyWaitingCount$p(PkGuestApplyViewModel r2) {
        return r2.mApplyWaitingCount;
    }

    public static final /* synthetic */ MutableLiveData access$get_sortTypeLiveData$p(PkGuestApplyViewModel r0) {
        return r0._sortTypeLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_userWaitingData$p(PkGuestApplyViewModel r0) {
        return r0._userWaitingData;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitingListType$p(PkGuestApplyViewModel r0) {
        return r0._waitingListType;
    }

    public static final /* synthetic */ MutableLiveData access$get_waitingTitleData$p(PkGuestApplyViewModel r0) {
        return r0._waitingTitleData;
    }

    public static final /* synthetic */ boolean access$isRequesting$p(PkGuestApplyViewModel r0) {
        return r0.isRequesting;
    }

    private final List<Long> getUserIdList(List<WaitingListUser> r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L12;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        IBaseUser r1 = ((WaitingListUser) r5.next()).getUserFlex();
        if (r1 == null) goto L10;
        String r2 = r1.getIdString();
    L11:
        r0.add(Long.valueOf(d5.c(r2)));
        goto L6
    L10:
        r2 = null;
    L12:
        return r0;
    }

    private final void handleWaitingListData(WaitingListResult r6) {
        long r0 = r6.getTotalCount();
        List r2 = r6.getWaitingUserList();
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L7:
        if (r0 > r3) goto L9;
    L17:
        this.mWaitingUserList.clear();
    L18:
        List r7 = r6.getWaitingUserList();
        if (r7 == null) goto L22;
        this.mWaitingUserList.addAll(r7);
        return;
    L22:
        return;
    L9:
        if (this.mHasMore == false) goto L17;
        if (ListUtils.isEmpty(r6.getWaitingUserList()) == true) goto L18;
        if (ListUtils.isEmpty(this.mWaitingUserList) == true) goto L18;
        List<Long> r1 = getUserIdList(this.mWaitingUserList);
        r1.retainAll(getUserIdList(r6.getWaitingUserList()));
        if (r1.size() <= 0) goto L18;
        this.mWaitingUserList.clear();
        goto L18
    L5:
        r3 = 0;
        goto L7
    }

    private final void setApplyTitle(List<Object> r3) {
        if (r3.size() <= 0) goto L6;
        ListProtector.add(r3, 0, new l.a());
        return;
    }

    public final void setApplyWaitingCount(long r1) {
        this.mApplyWaitingCount = r1;
    }

    public final void setMCurrentCursor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCurrentCursor = r2;
    }

    public final void setTotalCount(long r1) {
        this.totalCount = r1;
    }

    public static final /* synthetic */ void access$handleWaitingListData(PkGuestApplyViewModel r0, WaitingListResult r1) {
        r0.handleWaitingListData(r1);
    }

    public static final /* synthetic */ void access$setMApplyWaitingCount$p(PkGuestApplyViewModel r0, long r1) {
        r0.mApplyWaitingCount = r1;
    }

    public static final /* synthetic */ void access$setRequesting$p(PkGuestApplyViewModel r0, boolean r1) {
        r0.isRequesting = r1;
    }

    public static final /* synthetic */ void access$set_waitingListType$p(PkGuestApplyViewModel r0, MutableLiveData r1) {
        r0._waitingListType = r1;
    }

    public static final /* synthetic */ void access$set_waitingTitleData$p(PkGuestApplyViewModel r0, MutableLiveData r1) {
        r0._waitingTitleData = r1;
    }

    private final void addFooter(List<? extends Object> r3, boolean r4) {
        if (r3 != null) goto L4;
    L9:
        ArrayList r0 = new ArrayList();
        Intrinsics.checkNotNull(r3);
        r0.addAll(r3);
        setApplyTitle(r0);
        if (r4 == false) goto L12;
        r0.add(this.LOAD_MORE_ITEM);
    L13:
        this._waitingListData.setValue(r0);
        this.mHasMore = r4;
        return;
    L12:
        r0.add(this.NO_MORE_ITEM);
        goto L13
    L4:
        if (r3.isEmpty() == false) goto L6;
        boolean r1 = true;
    L7:
        if (r1 != true) goto L9;
        return;
    L6:
        r1 = false;
        goto L7
    }

    public static final /* synthetic */ void access$addFooter(PkGuestApplyViewModel r0, List r1, boolean r2) {
        r0.addFooter(r1, r2);
    }

    public final void fetchList(boolean r11, Room r12, String r13, int r14, int r15) {
        if (this.mHasMore == true) goto L5;
        if (r11 == true) goto L5;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == false) goto L17;
        this.isRequesting = true;
        long r0 = System.currentTimeMillis();
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r12 == null) goto L14;
        long r17 = r12.id;
    L15:
        RxUtilKt.c(r2.getWaitingList(r17, r13, 50, r14, r15).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r0, r14), new c(this, r0)), this.mCompositeDisposable);
        return;
    L14:
        r17 = 0;
        goto L15
    L17:
        return;
    L5:
        if (r12 == null) goto L9;
        if (this.isRequesting == true) goto L9;
        r16 = true;
        goto L10
    }

    public static /* synthetic */ void fetchList$default(PkGuestApplyViewModel r6, boolean r7, Room r8, String r9, int r10, int r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = "";
    L5:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = WaitingListType.UNKNOWN.ordinal();
    L8:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = WaitingListSource.AUDIENCE_PANEL.ordinal();
    L11:
        r6.fetchList(r7, r8, r3, r4, r11);
    }
}
