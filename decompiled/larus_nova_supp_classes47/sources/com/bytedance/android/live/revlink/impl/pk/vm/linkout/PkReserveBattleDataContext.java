package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.link.model.bridge.w;
import com.bytedance.android.livesdk.link.model.bridge.x;
import com.bytedance.android.livesdk.link.model.bridge.y;
import com.bytedance.android.livesdk.link.model.i2;
import com.bytedance.android.livesdk.link.model.k2;
import com.bytedance.android.livesdk.link.model.l2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001FB9\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\bD\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u0018\u0010\u0014\u001a\u00060\u0012j\u0002`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u001dj\b\u0012\u0004\u0012\u00020\r`\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R'\u0010$\u001a\u0012\u0012\u0004\u0012\u00020#0\u001dj\b\u0012\u0004\u0012\u00020#`\u001e8\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R'\u0010'\u001a\u0012\u0012\u0004\u0012\u00020&0\u001dj\b\u0012\u0004\u0012\u00020&`\u001e8\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0004\u0018\u0001088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u0004\u0018\u00010@8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/g;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "", "judgeCanStartInvite", "isBroadcastPaused", "handleInviteAvailable", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext$b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getBattleReserveState", "state", "setBattleReserveState", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "reserveBattleState", "Landroidx/lifecycle/MutableLiveData;", "getReserveBattleState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/link/model/l2;", "showReserveSettleDialog", "getShowReserveSettleDialog", "Lcom/bytedance/android/livesdk/link/model/i2;", "showReserveInviteDialog", "getShowReserveInviteDialog", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lld/a;", "linkDataSet", "Lld/a;", "Llr2/a;", "paidLiveService", "Llr2/a;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lox0/a;", "getModeMerge", "()Lox0/a;", "modeMerge", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "Li41/a;", "getAutoMatchManager", "()Li41/a;", "autoMatchManager", "<init>", "(Lcom/bytedance/android/livesdk/revenue/service/room/c;Lyz0/f;Lld/a;Llr2/a;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkReserveBattleDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.pk.service.g {
    private final CompositeDisposable cd;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;
    private final lr2.a paidLiveService;
    private final MutableLiveData<b> reserveBattleState;
    private IRoom room;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final MutableLiveData<i2> showReserveInviteDialog;
    private final MutableLiveData<l2> showReserveSettleDialog;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkReserveBattleDataContext r8) {
            super(1, r8, PkReserveBattleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkReserveBattleDataContext.access$onMessage((PkReserveBattleDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass3(PkReserveBattleDataContext r8) {
            super(1, r8, PkReserveBattleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkReserveBattleDataContext.access$onMessage((PkReserveBattleDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass4(PkReserveBattleDataContext r8) {
            super(1, r8, PkReserveBattleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkReserveBattleDataContext.access$onMessage((PkReserveBattleDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkReserveBattleDataContext a;

        public a(PkReserveBattleDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            PkReserveBattleDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$b$b, reason: collision with other inner class name */
        public static final class C0178b extends b {
            public static final C0178b a = null;

            static {
                a = new C0178b();
            }

            public C0178b() {
            }
        }

        public b() {
        }
    }

    private final i41.a getAutoMatchManager() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAutoMatchManager();
    }

    private final ox0.a getModeMerge() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getModeMerge();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    private final boolean handleInviteAvailable() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.Ig();
        if (r1 == null) goto L9;
        LiveData<PkBaseStateMachine.c> r2 = r1.getPkBaseState();
        if (r2 == null) goto L9;
        PkBaseStateMachine.c r3 = (PkBaseStateMachine.c) r2.getValue();
    L11:
        if (r3 != null) goto L13;
    L16:
        return true;
    L13:
        if ((r3 instanceof PkBaseStateMachine.c.C0130c) != true) goto L16;
        return false;
    L9:
        r3 = null;
        goto L11
    }

    private final boolean isBroadcastPaused() {
        ld.a r0 = this.linkDataSet;
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.Dc();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L9:
        if (r2 != null) goto L12;
    L13:
        if (r2 != null) goto L16;
    L18:
        return false;
    L16:
        if (r2.intValue() != 2) goto L18;
        return true;
    L12:
        if (r2.intValue() != 1) goto L13;
        return true;
    L7:
        r2 = null;
        goto L9
    }

    private final boolean judgeCanStartInvite() {
        if (isBroadcastPaused() == false) goto L5;
        return false;
    L5:
        lr2.a r0 = this.paidLiveService;
        if (r0 == null) goto L11;
        if (r0.isPaidLive() != true) goto L11;
        return false;
    L11:
        if (d51.c.A0.l() == true) goto L13;
        return false;
    L13:
        vh7.c r1 = this.room;
        if (r1 == null) goto L21;
        if (r1 == null) goto L21;
        IRoomLinkExt r2 = (IRoomLinkExt) r1.castTo(IRoomLinkExt.class);
        if (r2 == null) goto L21;
        if (r2.getMosaicStatus() != 1) goto L21;
        return false;
    L21:
        w31.c r3 = getPkLinkUtils();
        if (r3 == null) goto L38;
        IPKLinkBizDataService r4 = r3.g();
        if (r4 == null) goto L27;
        q11.c r5 = r4.mo747getPkLinkState();
        if (r5 == null) goto L27;
    L29:
        if ((r5 instanceof q11.c.C0296c) == false) goto L31;
    L34:
        boolean r6 = true;
    L35:
        if (r6 != true) goto L38;
        return false;
    L31:
        if ((r5 instanceof q11.c.a) == true) goto L34;
        r6 = false;
    L27:
        r5 = q11.c.b.b;
    L38:
        if (Intrinsics.areEqual((b) this.reserveBattleState.getValue(), b.C0178b.a) == false) goto L40;
        return false;
    L40:
        i41.a r7 = getAutoMatchManager();
        if (r7 != null) goto L43;
    L45:
        return true;
    L43:
        if (r7.f != true) goto L45;
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.g
    public LiveData<b> getBattleReserveState() {
        return this.reserveBattleState;
    }

    public final MutableLiveData<b> getReserveBattleState() {
        return this.reserveBattleState;
    }

    public final MutableLiveData<i2> getShowReserveInviteDialog() {
        return this.showReserveInviteDialog;
    }

    public final MutableLiveData<l2> getShowReserveSettleDialog() {
        return this.showReserveSettleDialog;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkReserveBattleDataContext r0) {
        return r0.cd;
    }

    private final void onMessage(yh6.c r3) {
        if ((r3 instanceof x) == false) goto L6;
        k2 r4 = ((vh7.c) r3).castTo(k2.class);
        int r0 = ToastUtil.a;
        ToastUtil.b(r4.getToast(), 0);
        return;
    L6:
        if ((r3 instanceof y) == false) goto L12;
        if (judgeCanStartInvite() == true) goto L10;
        return;
    L10:
        l2 r5 = ((vh7.c) r3).castTo(l2.class);
        this.reserveBattleState.setValue(b.C0178b.a);
        this.showReserveSettleDialog.setValue(r5);
        return;
    L12:
        if ((r3 instanceof w) == true) goto L14;
        return;
    L14:
        if (judgeCanStartInvite() == true) goto L17;
        return;
    L17:
        if (handleInviteAvailable() == true) goto L19;
        return;
    L19:
        i2 r6 = ((vh7.c) r3).castTo(i2.class);
        this.reserveBattleState.setValue(b.C0178b.a);
        this.showReserveInviteDialog.setValue(r6);
    }

    public void setBattleReserveState(b r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.reserveBattleState.setValue(r2);
    }

    public static final /* synthetic */ void access$onMessage(PkReserveBattleDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public PkReserveBattleDataContext(com.bytedance.android.livesdk.revenue.service.room.c r4, yz0.f r5, ld.a r6, lr2.a r7, com.bytedance.android.live.revlink.impl.global.c r8) {
        this.roomService = r4;
        this.messageService = r5;
        this.linkDataSet = r6;
        this.paidLiveService = r7;
        this.linkFakeGlobalService = r8;
        CompositeDisposable r9 = new CompositeDisposable();
        this.cd = r9;
        IRoomBase r10 = null;
        if (r4 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r12 = r4.getRoomContext();
    L6:
        this.roomContext = r12;
        MutableLiveData<b> r13 = new MutableLiveData();
        this.reserveBattleState = r13;
        this.showReserveSettleDialog = new MutableLiveData();
        this.showReserveInviteDialog = new MutableLiveData();
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r9);
        if (r12 == null) goto L9;
        r10 = r12.getCommonRoom();
    L9:
        this.room = (IRoom) r10;
        if (r5 == null) goto L16;
        com.bytedance.android.live.revenue.common.message.a r0 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r1 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r0, "$this$LINK_BATTLE_RESERVE_SETTLE");
        Observable r2 = yz0.h.a.a(r5, (yh6.b) CommonMessageTypeKt.K.getValue(), false, 6);
        if (r2 == null) goto L16;
        final AnonymousClass2 r3 = new AnonymousClass2(this);
        Disposable r14 = r2.subscribe(new c(r3));
        if (r14 == null) goto L16;
        com.bytedance.revenue.platform.api.core.rx.f.a(r14, r9);
    L16:
        if (r5 == null) goto L22;
        com.bytedance.android.live.revenue.common.message.a r15 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r16 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r15, "$this$LINK_BATTLE_RESERVE_INVITE");
        Observable r17 = yz0.h.a.a(r5, (yh6.b) CommonMessageTypeKt.L.getValue(), false, 6);
        if (r17 == null) goto L22;
        final AnonymousClass3 r18 = new AnonymousClass3(this);
        Disposable r19 = r17.subscribe(new c(r18));
        if (r19 == null) goto L22;
        com.bytedance.revenue.platform.api.core.rx.f.a(r19, r9);
    L22:
        if (r5 == null) goto L28;
        com.bytedance.android.live.revenue.common.message.a r20 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r22 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r20, "$this$BATTLE_RESERVE_REPLY_MESSAGE");
        Observable r23 = yz0.h.a.a(r5, (yh6.b) CommonMessageTypeKt.J.getValue(), false, 6);
        if (r23 == null) goto L28;
        final AnonymousClass4 r24 = new AnonymousClass4(this);
        Disposable r25 = r23.subscribe(new c(r24));
        if (r25 == null) goto L28;
        com.bytedance.revenue.platform.api.core.rx.f.a(r25, r9);
    L28:
        r13.setValue(b.a.a);
        return;
    L5:
        r12 = null;
        goto L6
    }
}
