package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.link.model.w4;
import com.bytedance.android.livesdk.link.model.x4;
import com.bytedance.android.livesdk.message.model.s8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002$'\u0018\u00002\u00020\u0001Bw\u0012.\u0010.\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190+0*j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190+`-\u0012\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u0002000*j\b\u0012\u0004\u0012\u000200`-\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b>\u0010?J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\u0005R'\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u00060 j\u0002`!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R<\u0010.\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190+0*j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00190+`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00101\u001a\u0012\u0012\u0004\u0012\u0002000*j\b\u0012\u0004\u0012\u000200`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00103\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u0004\u0018\u00010;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "", "Lcom/bytedance/android/livesdk/link/model/h7;", "mvpList", "updateMvpRankList", "clearIt", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/link/model/h7$b;", "leftMvpRankList$delegate", "Lcom/bytedance/live/datacontext/p;", "getLeftMvpRankList", "()Lcom/bytedance/live/datacontext/n;", "leftMvpRankList", "rightMvpRankList$delegate", "getRightMvpRankList", "rightMvpRankList", "", "lastUpdateContributor", "Ljava/util/List;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "lastPkResult", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "com/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext$battleStatsMetaObserver$1", "battleStatsMetaObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext$battleStatsMetaObserver$1;", "com/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext$pkResultObserver$1", "pkResultObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkContributorDataContext$pkResultObserver$1;", "Landroidx/lifecycle/LiveData;", "", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "pkResult", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/livesdk/link/model/c3;", "battleStatsMeta", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "messageManagerService", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lcom/bytedance/android/livesdk/revenue/service/message/d;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkContributorDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final LiveData<c3> battleStatsMeta;
    private final PkContributorDataContext$battleStatsMetaObserver$1 battleStatsMetaObserver;
    private final CompositeDisposable cd;
    private PkBaseResult lastPkResult;
    private List<h7> lastUpdateContributor;
    private final p leftMvpRankList$delegate;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final com.bytedance.android.livesdk.revenue.service.message.d messageManagerService;
    private final yz0.f messageService;
    private final LiveData<Map<String, PkBaseResult>> pkResult;
    private final PkContributorDataContext$pkResultObserver$1 pkResultObserver;
    private final p rightMvpRankList$delegate;
    private final IRoom room;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.PkContributorDataContext$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(PkContributorDataContext r8) {
            super(1, r8, PkContributorDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            PkContributorDataContext.access$onMessage((PkContributorDataContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.PkContributorDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkContributorDataContext r8) {
            super(1, r8, PkContributorDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            PkContributorDataContext.access$onMessage((PkContributorDataContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkContributorDataContext a;

        public a(PkContributorDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            PkContributorDataContext.access$getPkResult$p(this.a).removeObserver(PkContributorDataContext.access$getPkResultObserver$p(this.a));
            PkContributorDataContext.access$getBattleStatsMeta$p(this.a).removeObserver(PkContributorDataContext.access$getBattleStatsMetaObserver$p(this.a));
            PkContributorDataContext.access$getCd$p(this.a).clear();
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PkContributorDataContext.class, "leftMvpRankList", "getLeftMvpRankList()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PkContributorDataContext.class, "rightMvpRankList", "getRightMvpRankList()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    public final n<List<h7.b>> getLeftMvpRankList() {
        return (n) this.leftMvpRankList$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<List<h7.b>> getRightMvpRankList() {
        return (n) this.rightMvpRankList$delegate.a(this, $$delegatedProperties[1]);
    }

    public final void clearIt() {
        onCleared();
    }

    public static final /* synthetic */ LiveData access$getBattleStatsMeta$p(PkContributorDataContext r0) {
        return r0.battleStatsMeta;
    }

    public static final /* synthetic */ PkContributorDataContext$battleStatsMetaObserver$1 access$getBattleStatsMetaObserver$p(PkContributorDataContext r0) {
        return r0.battleStatsMetaObserver;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkContributorDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ PkBaseResult access$getLastPkResult$p(PkContributorDataContext r0) {
        return r0.lastPkResult;
    }

    public static final /* synthetic */ List access$getLastUpdateContributor$p(PkContributorDataContext r0) {
        return r0.lastUpdateContributor;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.global.c access$getLinkFakeGlobalService$p(PkContributorDataContext r0) {
        return r0.linkFakeGlobalService;
    }

    public static final /* synthetic */ LiveData access$getPkResult$p(PkContributorDataContext r0) {
        return r0.pkResult;
    }

    public static final /* synthetic */ PkContributorDataContext$pkResultObserver$1 access$getPkResultObserver$p(PkContributorDataContext r0) {
        return r0.pkResultObserver;
    }

    public static final /* synthetic */ IRoom access$getRoom$p(PkContributorDataContext r0) {
        return r0.room;
    }

    private final void onMessage(yh6.c r2) {
        if ((r2 instanceof r0) == false) goto L6;
        this.lastUpdateContributor.clear();
        getLeftMvpRankList().setValue(new ArrayList());
        getRightMvpRankList().setValue(new ArrayList());
        return;
    L6:
        if ((r2 instanceof s8) == false) goto L16;
        w4 r3 = ((vh7.c) r2).castTo(w4.class);
        this.lastUpdateContributor.clear();
        List<h7> r0 = this.lastUpdateContributor;
        List r4 = x4.a(r3);
        if (r4 == null) goto L12;
        List r5 = CollectionsKt.toList(r4);
        if (r5 == null) goto L12;
    L13:
        r0.addAll(r5);
        updateMvpRankList(this.lastUpdateContributor);
        return;
    L12:
        r5 = CollectionsKt.emptyList();
        goto L13
    }

    private final void updateMvpRankList(List<? extends h7> r4) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r4);
        this.lastUpdateContributor.clear();
        this.lastUpdateContributor.addAll(r0);
        if (r0.isEmpty() == false) goto L6;
        getLeftMvpRankList().setValue(new ArrayList());
        getRightMvpRankList().setValue(new ArrayList());
        return;
    L6:
        n<List<h7.b>> r5 = getLeftMvpRankList();
        List r1 = ((h7) ListProtector.get(r0, 0)).getRankList();
        List r2 = null;
        if (r1 == null) goto L9;
        List r3 = CollectionsKt.toList(r1);
    L10:
        r5.setValue(r3);
        if (r0.size() < 2) goto L17;
        n<List<h7.b>> r6 = getRightMvpRankList();
        List r7 = ((h7) ListProtector.get(r0, 1)).getRankList();
        if (r7 == null) goto L15;
        r2 = CollectionsKt.toList(r7);
    L15:
        r6.setValue(r2);
        return;
    L17:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public static final /* synthetic */ void access$onMessage(PkContributorDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$setLastPkResult$p(PkContributorDataContext r0, PkBaseResult r1) {
        r0.lastPkResult = r1;
    }

    public static final /* synthetic */ void access$setLastUpdateContributor$p(PkContributorDataContext r0, List r1) {
        r0.lastUpdateContributor = r1;
    }

    public static final /* synthetic */ void access$updateMvpRankList(PkContributorDataContext r0, List r1) {
        r0.updateMvpRankList(r1);
    }

    public PkContributorDataContext(LiveData<Map<String, PkBaseResult>> r6, LiveData<c3> r7, com.bytedance.android.livesdk.revenue.service.room.c r8, com.bytedance.android.live.revlink.impl.global.c r9, yz0.f r10, com.bytedance.android.livesdk.revenue.service.message.d r12) {
        Intrinsics.checkNotNullParameter(r6, "pkResult");
        Intrinsics.checkNotNullParameter(r7, "battleStatsMeta");
        this.pkResult = r6;
        this.battleStatsMeta = r7;
        this.roomService = r8;
        this.linkFakeGlobalService = r9;
        this.messageService = r10;
        this.messageManagerService = r12;
        this.leftMvpRankList$delegate = q.c(this);
        this.rightMvpRankList$delegate = q.c(this);
        this.lastUpdateContributor = new ArrayList();
        this.lastPkResult = PkBaseResult.NOT_FINISH;
        if (r8 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r13 = r8.getRoomContext();
        if (r13 == null) goto L7;
        IRoomBase r14 = r13.getCommonRoom();
    L8:
        this.room = (IRoom) r14;
        CompositeDisposable r15 = new CompositeDisposable();
        this.cd = r15;
        Observer r16 = new PkContributorDataContext$battleStatsMetaObserver$1(this);
        this.battleStatsMetaObserver = r16;
        Observer r17 = new PkContributorDataContext$pkResultObserver$1(this);
        this.pkResultObserver = r17;
        if (r10 == null) goto L15;
        Observable r2 = yz0.h.a.a(r10, CommonMessageTypeKt.b(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r2 == null) goto L15;
        final AnonymousClass1 r3 = new AnonymousClass1(this);
        Disposable r4 = r2.subscribe(new b(r3));
        if (r4 == null) goto L15;
        com.bytedance.revenue.platform.api.core.rx.f.a(r4, r15);
    L15:
        if (r10 == null) goto L21;
        com.bytedance.android.live.revenue.common.message.a r5 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r18 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r5, "$this$LINK_MIC_ARMIES");
        Observable r19 = yz0.h.a.a(r10, (yh6.b) CommonMessageTypeKt.y.getValue(), false, 6);
        if (r19 == null) goto L21;
        final AnonymousClass2 r0 = new AnonymousClass2(this);
        Disposable r110 = r19.subscribe(new b(r0));
        if (r110 == null) goto L21;
        com.bytedance.revenue.platform.api.core.rx.f.a(r110, r15);
    L21:
        r6.observeForever(r17);
        r7.observeForever(r16);
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r15);
        return;
    L7:
        r14 = null;
        goto L8
    }
}
