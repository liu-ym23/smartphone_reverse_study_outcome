package com.bytedance.android.live.liveinteract.revenue.paid.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import cj0.h;
import cj0.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.revenue.g;
import com.bytedance.android.live.liveinteract.plantform.api.LinkPaidLinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.n;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.model.interact.NormalPaidLinkmicAddPriceStrategy;
import com.bytedance.android.livesdk.chatroom.model.interact.c1;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.model.interact.z2;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.u9;
import com.bytedance.android.livesdk.message.model.v9;
import com.bytedance.android.livesdk.message.model.w9;
import com.bytedance.android.livesdk.message.model.x9;
import com.bytedance.android.livesdk.message.model.y9;
import com.bytedance.android.livesdk.message.model.ya;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u0013\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J#\u0010\u0014\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J#\u0010\u0017\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J#\u0010\u0018\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120)H\u0016J\n\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010.\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020\u0010H\u0016J\b\u00100\u001a\u00020\u0006H\u0014R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020+0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020+0-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u00102\u001a\u0004\b4\u00105R\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002060-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00102R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002060-8\u0006¢\u0006\f\n\u0004\b8\u00102\u001a\u0004\b9\u00105R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00102R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120-8\u0006¢\u0006\f\n\u0004\b;\u00102\u001a\u0004\b<\u00105R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010CR\u0016\u0010D\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00120F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006U"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/viewmodel/PaidLinkMicViewModel;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", "Lcj0/c;", "Lcom/bytedance/android/livesdk/message/model/ILinkmicProfitMessage;", MultiLinkOpenSource.MESSAGE, "", "handleProfitMessage", "onPaidLinkMicOpen", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c1;", "info", "updateIncreasePriceData", "onPaidLinkMicClose", "onPaidLinkMicConfigUpdate", "logPaidConfigChangedAfter", "logPaidConfigChangedBefore", "", "waitingUserNeedLeave", "", "waitingUserToast", "normalPaidLinkMicConfigUpdate", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "cancelVideoGuestPaidLinkMicApply", "cancelInteractGuestPaidLinkMicApply", "cancelAudioGuestPaidLinkMicApply", "onPaidLinkMicAddPrice", "normalPaidLinkMicAddPrice", "Lcom/bytedance/android/livesdk/link/model/bridge/ILinkMicGuideMessageBridge;", "handleGuideMessage", "onNormalPaidLinkMicMigrateToPlay", "resetGuestIncreasePriceData", "Ltlc/d;", "onMessage", "", "roomId", "fetchUserPaidBenefitInfo", "fetchNormalPaidInfo", "isPaidLinkOn", "isIncreasePriceOn", "getIncreasePrice", "clearIncreaseUserList", "", "getIncreaseUserList", "Lcj0/k;", "currentPaidLinkMicState", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getPaidLinkMicStateObservable", "needIntercepted", "onCleared", "_paidLinkMicState", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "paidLinkMicState", "getPaidLinkMicState", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Ldj0/a;", "_paidLinkMicAddPriceState", "paidLinkMicAddPriceState", "getPaidLinkMicAddPriceState", "_paidLinkMicPlayModeGuideState", "paidLinkMicPlayModeGuideState", "getPaidLinkMicPlayModeGuideState", "Lcom/bytedance/android/live/liveinteract/voicechat/util/a;", "mPaidLinkLogger$delegate", "Lkotlin/Lazy;", "getMPaidLinkLogger", "()Lcom/bytedance/android/live/liveinteract/voicechat/util/a;", "mPaidLinkLogger", "Z", "increasePrice", "J", "", "mIncreasePriceUserList", "Ljava/util/List;", "Lio/reactivex/disposables/CompositeDisposable;", "composedDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "isAnchor", "()Z", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkMicViewModel extends ViewModel implements l, cj0.c {
    public static final b Companion = null;
    public static final long NormalPaidStart = 1;
    public static final String TAG = "PaidLinkMicViewModel";
    private NextLiveData<dj0.a> _paidLinkMicAddPriceState;
    private NextLiveData<String> _paidLinkMicPlayModeGuideState;
    private NextLiveData<k> _paidLinkMicState;
    private final CompositeDisposable composedDisposable;
    private final DataCenter dataCenter;
    private long increasePrice;
    private boolean isIncreasePriceOn;
    private List<String> mIncreasePriceUserList;
    private final Lazy mPaidLinkLogger$delegate;
    private final NextLiveData<dj0.a> paidLinkMicAddPriceState;
    private final NextLiveData<String> paidLinkMicPlayModeGuideState;
    private final NextLiveData<k> paidLinkMicState;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PaidLinkMicViewModel a;

        public a(PaidLinkMicViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List<? extends ILinkPlayerInfoBridge> r4 = (List) r3;
            com.bytedance.android.live.liveinteract.voicechat.util.a r0 = PaidLinkMicViewModel.access$getMPaidLinkLogger$p(this.a);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "newGuests");
            r0.a = r4;
            i<ILinkPlayerInfoBridge> r5 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
            if ((r5 instanceof y) == true) goto L5;
            r5 = null;
        L5:
            y r6 = (y) r5;
            if (r6 != null) goto L8;
        L10:
            boolean r7 = false;
        L12:
            if (r0.d == true) goto L14;
            return;
        L14:
            if (r0.a() == false) goto L16;
            return;
        L16:
            if (r0.c == true) goto L24;
            if (r7 == true) goto L19;
            return;
        L19:
            if (r0.b == true) goto L26;
            r0.b();
            r0.b = r7;
            return;
        L26:
            return;
        L24:
            return;
        L8:
            if (r6.u() == true) goto L10;
            r7 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PaidLinkMicViewModel a;

        public c(PaidLinkMicViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            com.bytedance.android.live.network.response.e r12 = (com.bytedance.android.live.network.response.e) r11;
            if (r12 == null) goto L26;
            k1 r13 = (k1) r12.data;
            if (r13 == null) goto L27;
            p2 r14 = r13.getLinkmicPlayModeInfo();
            if (r14 == null) goto L28;
            vh7.c r15 = r14.getNormalPaidLinkmicInfo();
            if (r15 != null) goto L12;
            return;
        L12:
            if (r15.getStatus() != 1) goto L14;
            boolean r0 = true;
        L15:
            PaidLinkMicViewModel r1 = this.a;
            c1 r2 = jm2.a.d(r15);
            if (r2 == null) goto L25;
            PaidLinkMicViewModel.access$updateIncreasePriceData(r1, r2);
            boolean r3 = r0;
            PaidLinkMicViewModel.access$get_paidLinkMicState$p(this.a).setValue(new k(r3, r15.getPaidCount(), r15.getLimitedTime(), true));
            if (r0 == false) goto L29;
            fj0.b r16 = fj0.b.b;
            if (PaidLinkMicViewModel.access$isAnchor$p(this.a) == false) goto L22;
            fj0.b.h(r16, null, null, 7);
            fj0.a r17 = fj0.b.a;
            r17.getClass();
            r17.e = System.currentTimeMillis();
        L23:
            PaidLinkMicViewModel.access$getMPaidLinkLogger$p(this.a).c();
            return;
        L22:
            fj0.b.e(null);
            goto L23
        L29:
            return;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.INormalPaidLinkmicInfo");
        L14:
            r0 = false;
            goto L15
        L28:
            return;
        L27:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            ALogger.e("ttlive_link_paid", "fetchNormalPaidInfo failed " + ((Throwable) r3));
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            z2 r4 = (z2) ((com.bytedance.android.live.network.response.e) r3).data;
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.getDiscountMode());
        L6:
            int r6 = r5.intValue();
            PaidLinkMicContext r0 = PaidLinkMicContext.Companion.getContext();
            if (r0 == null) goto L11;
            m<Integer> r1 = r0.getDiscountMode();
            if (r1 == null) goto L11;
            r1.setValue(Integer.valueOf(r6));
        L11:
            xs2.b.a().post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.c(r6));
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r3) {
            ALogger.e("ttlive_link_paid", "fetchUserPaidBenefitInfo failed " + ((Throwable) r3));
        }
    }

    static {
        Companion = new b();
    }

    public PaidLinkMicViewModel() {
        DataCenter r0 = null;
        this(r0, 1, r0);
    }

    private final com.bytedance.android.live.liveinteract.voicechat.util.a getMPaidLinkLogger() {
        return (com.bytedance.android.live.liveinteract.voicechat.util.a) this.mPaidLinkLogger$delegate.getValue();
    }

    private final void resetGuestIncreasePriceData() {
        this.isIncreasePriceOn = false;
        this.increasePrice = 0;
        this.mIncreasePriceUserList.clear();
        int r2 = fj0.e.a;
        fj0.b.a.f = 0;
    }

    @Override // cj0.c
    public void clearIncreaseUserList() {
        this.mIncreasePriceUserList.clear();
    }

    @Override // cj0.c
    public List<String> getIncreaseUserList() {
        int r0 = fj0.e.a;
        List<String> r1 = this.mIncreasePriceUserList;
        Intrinsics.checkNotNullParameter(r1, "increasePriceUserList");
        List<String> r2 = new ArrayList();
        if (Lists.isEmpty(r1) == true) goto L36;
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        ArrayList r4 = null;
        if (r3 == null) goto L10;
        i<ILinkPlayerInfoBridge> r5 = r3.getLinkUserInfoCenter();
        if (r5 == null) goto L10;
        Iterable r6 = r5.a();
    L11:
        if (r6 == null) goto L22;
        Iterable r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L20;
        IBaseUser r10 = ((ILinkPlayerInfoBridge) r9.next()).getUser();
        if (r10 == null) goto L18;
        String r11 = r10.getIdString();
    L19:
        r8.add(r11);
        goto L14
    L18:
        r11 = null;
        goto L19
    L20:
        r4 = r8;
    L22:
        if (Lists.isEmpty(r4) == true) goto L36;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r1.iterator();
    L26:
        if (r13.hasNext() == false) goto L35;
        Object r14 = r13.next();
        String r15 = (String) r14;
        if (r4 == null) goto L32;
        boolean r16 = true;
        if (r4.contains(r15) != true) goto L32;
    L33:
        if (r16 == false) goto L26;
        r12.add(r14);
    L32:
        r16 = false;
        goto L33
    L35:
        r2 = CollectionsKt.toMutableList(r12);
    L10:
        r6 = null;
    L36:
        this.mIncreasePriceUserList = r2;
        return r2;
    }

    @Override // cj0.c
    public boolean isPaidLinkOn() {
        k r0 = (k) this._paidLinkMicState.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a != true) goto L7;
        return true;
    }

    private final boolean isAnchor() {
        return Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
    }

    private final void logPaidConfigChangedAfter() {
        if (isAnchor() == false) goto L5;
        fj0.b.h(fj0.b.b, null, "change", 3);
        fj0.a r0 = fj0.b.a;
        r0.getClass();
        r0.e = System.currentTimeMillis();
        return;
    L5:
        fj0.a r1 = fj0.b.a;
        fj0.b.e(null);
    }

    private final void logPaidConfigChangedBefore() {
        if (isAnchor() == false) goto L5;
        fj0.b.d(fj0.b.b);
        return;
    L5:
        fj0.b.g(fj0.b.b);
    }

    private final void normalPaidLinkMicAddPrice() {
        if (isAnchor() == false) goto L12;
        if (hd0.c.f().h() == false) goto L19;
        PaidLinkMicContext r0 = PaidLinkMicContext.Companion.getContext();
        if (r0 == null) goto L20;
        m<Boolean> r1 = r0.getRefreshWaitingUserList();
        if (r1 == null) goto L21;
        r1.setValue(Boolean.TRUE);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L12:
        if (hd0.c.f().j() == false) goto L23;
        PaidLinkMicContext r2 = PaidLinkMicContext.Companion.getContext();
        if (r2 == null) goto L24;
        m<Boolean> r3 = r2.getRefreshWaitingUserList();
        if (r3 == null) goto L25;
        r3.setValue(Boolean.TRUE);
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // cj0.c
    public k currentPaidLinkMicState() {
        return (k) getPaidLinkMicState().getValue();
    }

    @Override // cj0.c
    public NextLiveData<k> getPaidLinkMicStateObservable() {
        return getPaidLinkMicState();
    }

    @Override // cj0.c
    public boolean needIntercepted() {
        return h.a();
    }

    public void onCleared() {
        super.onCleared();
        t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new C03071(this));
    L7:
        NextLiveData<k> r2 = this._paidLinkMicState;
        k r3 = (k) r2.getValue();
        if (r3 == null) goto L10;
        k r4 = k.a(r3, 14);
    L11:
        r2.setValue(r4);
        resetGuestIncreasePriceData();
        this.composedDisposable.clear();
        return;
    L10:
        r4 = null;
        goto L11
    }

    @Override // cj0.c
    public long getIncreasePrice() {
        return this.increasePrice;
    }

    public final NextLiveData<dj0.a> getPaidLinkMicAddPriceState() {
        return this.paidLinkMicAddPriceState;
    }

    public final NextLiveData<String> getPaidLinkMicPlayModeGuideState() {
        return this.paidLinkMicPlayModeGuideState;
    }

    @Override // cj0.c
    public NextLiveData<k> getPaidLinkMicState() {
        return this.paidLinkMicState;
    }

    @Override // cj0.c
    public boolean isIncreasePriceOn() {
        return this.isIncreasePriceOn;
    }

    public PaidLinkMicViewModel(DataCenter r4) {
        this.dataCenter = r4;
        NextLiveData<k> r0 = new NextLiveData();
        this._paidLinkMicState = r0;
        this.paidLinkMicState = r0;
        NextLiveData<dj0.a> r1 = new NextLiveData();
        this._paidLinkMicAddPriceState = r1;
        this.paidLinkMicAddPriceState = r1;
        NextLiveData<String> r2 = new NextLiveData();
        this._paidLinkMicPlayModeGuideState = r2;
        this.paidLinkMicPlayModeGuideState = r2;
        this.mPaidLinkLogger$delegate = LazyKt.lazy(new PaidLinkMicViewModel$mPaidLinkLogger$2(this));
        this.mIncreasePriceUserList = new ArrayList();
        CompositeDisposable r3 = new CompositeDisposable();
        this.composedDisposable = r3;
        t r5 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r5 == null) goto L7;
        j r6 = r5.getMessageManager();
        if (r6 == null) goto L7;
        r6.c(new AnonymousClass1(this));
    L7:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r7 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, r4);
        if (r7 == null) goto L15;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r8 = r7.N0();
        if (r8 == null) goto L16;
        Disposable r9 = r8.subscribe(new a(this));
        if (r9 == null) goto L17;
        RxUtilKt.c(r9, r3);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static final /* synthetic */ com.bytedance.android.live.liveinteract.voicechat.util.a access$getMPaidLinkLogger$p(PaidLinkMicViewModel r0) {
        return r0.getMPaidLinkLogger();
    }

    public static final /* synthetic */ NextLiveData access$get_paidLinkMicState$p(PaidLinkMicViewModel r0) {
        return r0._paidLinkMicState;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(PaidLinkMicViewModel r0) {
        return r0.isAnchor();
    }

    private final void handleGuideMessage(ILinkMicGuideMessageBridge r6) {
        if (r6.getGuidelineType() != 10) goto L6;
        onNormalPaidLinkMicMigrateToPlay(r6);
        return;
    }

    private final void handleProfitMessage(ILinkmicProfitMessage r3) {
        int r0 = r3.getMsgType();
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicOpen.getValue()) goto L6;
        onPaidLinkMicOpen(r3);
        return;
    L6:
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicClose.getValue()) goto L9;
        onPaidLinkMicClose(r3);
        return;
    L9:
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicConfigUpdate.getValue()) goto L12;
        onPaidLinkMicConfigUpdate(r3);
        return;
    L12:
        if (r0 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicAddPrice.getValue()) goto L18;
        onPaidLinkMicAddPrice(r3);
        return;
    }

    private final void onNormalPaidLinkMicMigrateToPlay(ILinkMicGuideMessageBridge r3) {
        if (isAnchor() == false) goto L15;
        ya r4 = r3.getNormalPaidLinkmicMigrateToPlayContent();
        String r0 = null;
        if (r4 == null) goto L7;
        String r1 = r4.getToast();
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        NextLiveData<String> r2 = this._paidLinkMicPlayModeGuideState;
        if (r4 == null) goto L13;
        r0 = r4.getToast();
    L13:
        r2.setValue(r0);
        return;
    L16:
        return;
    L7:
        r1 = null;
        goto L9
    }

    private final void onPaidLinkMicAddPrice(ILinkmicProfitMessage r15) {
        u9 r0 = r15.getNormalPaidLinkmicAddPriceContent();
        if (r0 == null) goto L8;
        normalPaidLinkMicAddPrice();
        if (this.mIncreasePriceUserList.contains(v9.a(r0)) == true) goto L8;
        this.mIncreasePriceUserList.add(v9.a(r0));
        this._paidLinkMicAddPriceState.setValue(new dj0.a(v9.a(r0), r0.getAddPriceValue()));
    L8:
        if (isAnchor() == false) goto L19;
        MultiLinkEventModule r1 = g.a;
        u9 r2 = r15.getNormalPaidLinkmicAddPriceContent();
        if (r2 == null) goto L12;
        String r3 = v9.a(r2);
    L13:
        u9 r4 = r15.getNormalPaidLinkmicAddPriceContent();
        if (r4 == null) goto L16;
        long r5 = r4.getAddPriceValue();
    L17:
        long r6 = r15.getMessageId();
        Intrinsics.checkNotNullParameter(r3, "uid");
        JSONObject r7 = new JSONObject();
        r7.put("add_price_user_id", r3);
        r7.put("add_price", r5);
        r7.put("msg_id", r6);
        nd0.c.p(nd0.c.a, LinkMonitorData.ReceivedNormalPaidLinkMicAddPrice, r7, g.a, 0, null, false, null, 120);
        return;
    L16:
        r5 = 0;
        goto L17
    L12:
        r3 = "";
        goto L13
    }

    private final void onPaidLinkMicClose(ILinkmicProfitMessage r14) {
        k r0 = (k) this._paidLinkMicState.getValue();
        if (r0 != null) goto L5;
    L10:
        NextLiveData<k> r1 = this._paidLinkMicState;
        k r2 = (k) r1.getValue();
        if (r2 == null) goto L13;
        k r3 = k.a(r2, 6);
    L14:
        r1.setValue(r3);
        w9 r4 = r14.getNormalPaidLinkmicCloseContent();
        if (r4 == null) goto L17;
        normalPaidLinkMicConfigUpdate(r4.getWaitingUserNeedLeave(), r4.getWaitingUserToast());
    L17:
        resetGuestIncreasePriceData();
        if (isAnchor() == true) goto L20;
        f2.b(2131918843, 0);
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.h());
    L20:
        j r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r5 == null) goto L26;
        LivePlayModeLogContext r6 = (LivePlayModeLogContext) r5.getValue();
        if (r6 == null) goto L26;
        r6.removePlayMode(11);
    L26:
        if (isAnchor() == false) goto L28;
        MultiLinkEventModule r7 = g.a;
        long r8 = r14.getMessageId();
        JSONObject r9 = new JSONObject();
        r9.put("msg_id", r8);
        nd0.c.p(nd0.c.a, LinkMonitorData.ReceivedNormalPaidLinkMicClose, r9, g.a, 0, null, false, null, 120);
    L28:
        getMPaidLinkLogger().d = false;
        return;
    L13:
        r3 = null;
        goto L14
    L5:
        if (r0.a != true) goto L10;
        fj0.b r10 = fj0.b.b;
        if (isAnchor() == false) goto L9;
        fj0.b.d(r10);
        goto L10
    L9:
        fj0.b.g(r10);
        goto L10
    }

    private final void onPaidLinkMicConfigUpdate(ILinkmicProfitMessage r20) {
        logPaidConfigChangedBefore();
        x9 r1 = r20.getNormalPaidLinkmicConfigUpdateContent();
        if (r1 == null) goto L17;
        normalPaidLinkMicConfigUpdate(r1.getWaitingUserNeedLeave(), r1.getWaitingUserToast());
        c1 r2 = r1.getNormalPaidLinkmicInfo();
        if (r2 == null) goto L15;
        updateIncreasePriceData(r2);
        NextLiveData<k> r3 = this._paidLinkMicState;
        if (((k) r3.getValue()) != null) goto L9;
        k r4 = null;
    L14:
        r3.setValue(r4);
        goto L15
    L9:
        if (r2.getStatus() != 1) goto L11;
        boolean r5 = true;
    L12:
        r4 = new k(r5, r2.getPaidCount(), r2.getLimitedTime(), false);
        goto L14
    L11:
        r5 = false;
    L15:
        logPaidConfigChangedAfter();
    L17:
        if (isAnchor() == false) goto L27;
        MultiLinkEventModule r6 = g.a;
        k r7 = (k) this._paidLinkMicState.getValue();
        long r8 = 0;
        if (r7 == null) goto L21;
        long r9 = r7.b;
    L22:
        k r10 = (k) this._paidLinkMicState.getValue();
        if (r10 == null) goto L25;
        r8 = r10.c;
    L25:
        long r11 = this.increasePrice;
        long r12 = r20.getMessageId();
        JSONObject r13 = new JSONObject();
        r13.put("money", r9);
        r13.put("time", r8);
        r13.put("premium_price", r11);
        r13.put("msg_id", r12);
        nd0.c.p(nd0.c.a, LinkMonitorData.ReceivedNormalPaidLinkMicConfigUpdate, r13, g.a, 0, null, false, null, 120);
        return;
    L21:
        r9 = 0;
        goto L22
    }

    private final void onPaidLinkMicOpen(ILinkmicProfitMessage r20) {
        j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r1 == null) goto L7;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L7;
        r2.addPlayMode(11);
    L7:
        y9 r3 = r20.getNormalPaidLinkmicOpenContent();
        if (r3 == null) goto L14;
        c1 r4 = r3.getNormalPaidLinkmicInfo();
        if (r4 == null) goto L12;
        updateIncreasePriceData(r4);
        this._paidLinkMicState.setValue(new k(true, r4.getPaidCount(), r4.getLimitedTime(), true));
    L12:
        normalPaidLinkMicConfigUpdate(r3.getWaitingUserNeedLeave(), r3.getWaitingUserToast());
    L14:
        if (isAnchor() == true) goto L16;
        f2.b(2131918847, 0);
    L16:
        fj0.b r5 = fj0.b.b;
        if (isAnchor() == false) goto L19;
        fj0.b.h(r5, null, null, 7);
        fj0.a r6 = fj0.b.a;
        r6.getClass();
        r6.e = System.currentTimeMillis();
    L21:
        if (isAnchor() == false) goto L30;
        MultiLinkEventModule r7 = g.a;
        k r8 = (k) this._paidLinkMicState.getValue();
        long r9 = 0;
        if (r8 == null) goto L25;
        long r10 = r8.b;
    L26:
        k r11 = (k) this._paidLinkMicState.getValue();
        if (r11 == null) goto L29;
        r9 = r11.c;
    L29:
        long r12 = this.increasePrice;
        long r13 = r20.getMessageId();
        JSONObject r14 = new JSONObject();
        r14.put("money", r10);
        r14.put("time", r9);
        r14.put("premium_price", r12);
        r14.put("msg_id", r13);
        nd0.c.p(nd0.c.a, LinkMonitorData.ReceivedNormalPaidLinkMicOpen, r14, g.a, 0, null, false, null, 120);
        goto L30
    L25:
        r10 = 0;
    L30:
        getMPaidLinkLogger().c();
        return;
    L19:
        fj0.b.e(null);
        goto L21
    }

    private final void updateIncreasePriceData(c1 r3) {
        if (r3.getAddPriceStrategy() == NormalPaidLinkmicAddPriceStrategy.Unkown.ordinal()) goto L5;
        boolean r0 = true;
    L6:
        this.isIncreasePriceOn = r0;
        this.increasePrice = r3.getAddPriceValue();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void fetchNormalPaidInfo(long r3) {
        RxUtilKt.c(((LinkPaidLinkApi) com.bytedance.android.live.network.c.b().e(LinkPaidLinkApi.class)).getPlayModeInfo(r3, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a), this.composedDisposable);
    }

    public final void fetchUserPaidBenefitInfo(long r3) {
        RxUtilKt.c(((LinkPaidLinkApi) com.bytedance.android.live.network.c.b().e(LinkPaidLinkApi.class)).getUserPaidBenefitInfo(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(e.a, f.a), this.composedDisposable);
    }

    public void onMessage(tlc.d r2) {
        if ((r2 instanceof ILinkmicProfitMessage) == false) goto L6;
        handleProfitMessage((ILinkmicProfitMessage) r2);
        return;
    L6:
        if ((r2 instanceof ILinkMicGuideMessageBridge) == false) goto L10;
        handleGuideMessage((ILinkMicGuideMessageBridge) r2);
        return;
    }

    public static final /* synthetic */ void access$set_paidLinkMicState$p(PaidLinkMicViewModel r0, NextLiveData r1) {
        r0._paidLinkMicState = r1;
    }

    public static final /* synthetic */ void access$updateIncreasePriceData(PaidLinkMicViewModel r0, c1 r1) {
        r0.updateIncreasePriceData(r1);
    }

    private final void cancelAudioGuestPaidLinkMicApply(Boolean r3, String r4) {
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L5;
        return;
    L5:
        if (hd0.c.f().j() == false) goto L23;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r5 = IVoiceChatGuestService.a.a();
        if (r5 == null) goto L9;
        IVoiceChatGuestService.b.a(r5, null, 7);
    L9:
        IVoiceChatGuestService r6 = IVoiceChatGuestService.a.a();
        if (r6 == null) goto L13;
        r6.hideFastMatchDialog();
    L13:
        if (r4 != null) goto L15;
    L18:
        boolean r0 = true;
    L19:
        if (r0 == true) goto L24;
        f2.c(r4, 0);
        return;
    L24:
        return;
    L15:
        if (r4.length() == 0) goto L18;
        r0 = false;
        goto L19
    }

    private final void cancelInteractGuestPaidLinkMicApply(Boolean r2, String r3) {
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L5;
    L20:
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r4 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r4 == null) goto L24;
        r4.w4();
        return;
    L24:
        return;
    L5:
        if (hd0.c.f().j() == false) goto L20;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r5 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r5 == null) goto L12;
        n r6 = r5.W4();
        if (r6 == null) goto L12;
        tf0.g.a(r6, "paid_change");
    L12:
        if (r3 != null) goto L14;
    L17:
        boolean r0 = true;
    L18:
        if (r0 == true) goto L20;
        f2.c(r3, 0);
        goto L20
    L14:
        if (r3.length() == 0) goto L17;
        r0 = false;
        goto L18
    }

    private final void cancelVideoGuestPaidLinkMicApply(Boolean r4, String r5) {
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L5;
    L17:
        rj0.l.n2.getClass();
        rj0.l r6 = rj0.l.a.a();
        if (r6 == null) goto L21;
        r6.w4();
        return;
    L21:
        return;
    L5:
        if (hd0.c.f().j() == false) goto L17;
        rj0.l.n2.getClass();
        rj0.l r7 = rj0.l.a.a();
        if (r7 == null) goto L9;
        r7.cancelApply(null, false, "paid_change");
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L17;
        f2.c(r5, 0);
        goto L17
    L11:
        if (r5.length() == 0) goto L14;
        r8 = false;
        goto L15
    }

    private final void normalPaidLinkMicConfigUpdate(Boolean r3, String r4) {
        if (isAnchor() == false) goto L5;
        return;
    L5:
        if (je0.d.N() == false) goto L8;
        cancelVideoGuestPaidLinkMicApply(r3, r4);
        return;
    L8:
        if (je0.d.f() != 4) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        cancelInteractGuestPaidLinkMicApply(r3, r4);
        return;
    L14:
        if (je0.d.u() == false) goto L20;
        cancelAudioGuestPaidLinkMicApply(r3, r4);
        return;
    L20:
        return;
    L10:
        r0 = false;
        goto L11
    }

    public /* synthetic */ PaidLinkMicViewModel(DataCenter r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
