package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.BreakThroughStateMachine;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.d;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001,\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B]\u0012\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020/0\u0019j\b\u0012\u0004\u0012\u00020/`\u001a\u0012\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020/0\u0019j\b\u0012\u0004\u0012\u00020/`\u001a\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020302\u0012\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020)0\u0019j\b\u0012\u0004\u0012\u00020)`\u001a¢\u0006\u0004\b:\u0010;J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0006\u0010\u000f\u001a\u00020\u0007R\u0018\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0019j\b\u0012\u0004\u0012\u00020\u0015`\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR&\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0014j\b\u0012\u0004\u0012\u00020\u001f`\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0018R2\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0019j\b\u0012\u0004\u0012\u00020\u001f`\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020/0\u0019j\b\u0012\u0004\u0012\u00020/`\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001cR$\u00101\u001a\u0012\u0012\u0004\u0012\u00020/0\u0019j\b\u0012\u0004\u0012\u00020/`\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010\u001cR\u001a\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u00106\u001a\u0012\u0012\u0004\u0012\u00020)0\u0019j\b\u0012\u0004\u0012\u00020)`\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010\u001cR\u0016\u00109\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/BaseBreakThroughDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/a;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "", "onShowPk", "onShowPenal", "", "skippedPenal", "onFinish", "clearIt", "resetState", "attach", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/d;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_playState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "playState", "Landroidx/lifecycle/LiveData;", "getPlayState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/livesdk/link/model/n3;", "_breakthroughInfo", "breakthroughInfo", "getBreakthroughInfo", "setBreakthroughInfo", "(Landroidx/lifecycle/LiveData;)V", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/BreakThroughStateMachine;", "stateMachine", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/BreakThroughStateMachine;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$b;", "sideEffectObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "com/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/BaseBreakThroughDataContext$battleScoreDataObserver$1", "battleScoreDataObserver", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subplaymode/BaseBreakThroughDataContext$battleScoreDataObserver$1;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/a;", "scoreData", "scoreUpdateByMsg", "Lkotlin/Function0;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "getCurrentState", "Lkotlin/jvm/functions/Function0;", "pkSideEffect", "getBattleScoreData", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/a;", "battleScoreData", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function0;Landroidx/lifecycle/LiveData;)V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BaseBreakThroughDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a {
    public static final b Companion = null;
    public static final String TAG = "BaseBreakThroughDataContext";
    private MutableLiveData<n3> _breakthroughInfo;
    private final MutableLiveData<d> _playState;
    private final BaseBreakThroughDataContext$battleScoreDataObserver$1 battleScoreDataObserver;
    private LiveData<n3> breakthroughInfo;
    private final CompositeDisposable cd;
    private final Function0<PkBaseStateMachine.c> getCurrentState;
    private final LiveData<PkBaseStateMachine.b> pkSideEffect;
    private final LiveData<d> playState;
    private final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> scoreData;
    private final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> scoreUpdateByMsg;
    private final Observer<PkBaseStateMachine.b> sideEffectObserver;
    private final BreakThroughStateMachine stateMachine;

    public static final class a implements Action {
        public final /* synthetic */ BaseBreakThroughDataContext a;

        public a(BaseBreakThroughDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            BaseBreakThroughDataContext.access$getPkSideEffect$p(this.a).removeObserver(BaseBreakThroughDataContext.access$getSideEffectObserver$p(this.a));
            BaseBreakThroughDataContext.access$getScoreUpdateByMsg$p(this.a).removeObserver(BaseBreakThroughDataContext.access$getBattleScoreDataObserver$p(this.a));
            BaseBreakThroughDataContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BaseBreakThroughDataContext a;

        public c(BaseBreakThroughDataContext r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            PkBaseStateMachine.b r5 = (PkBaseStateMachine.b) r4;
            if ((r5 instanceof PkBaseStateMachine.b.c) == false) goto L6;
            PkBaseStateMachine.c r6 = r5.b;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r0 = r6.a;
            BaseBreakThroughDataContext.access$onShowPk(this.a, r0, r6.b);
            return;
        L6:
            if ((r5 instanceof PkBaseStateMachine.b.d) == false) goto L9;
            BaseBreakThroughDataContext r1 = this.a;
            PkBaseStateMachine.c r7 = r5.b;
            BaseBreakThroughDataContext.access$onShowPenal(r1, r7.a, r7.b);
            return;
        L9:
            if ((r5 instanceof PkBaseStateMachine.b.a) == false) goto L12;
            r5.a.a();
            BaseBreakThroughDataContext.access$onFinish(this.a, ((PkBaseStateMachine.b.a) r5).d, r5.b.a);
            return;
        L12:
            if ((r5 instanceof PkBaseStateMachine.b.C0129b) == false) goto L18;
            BaseBreakThroughDataContext.onFinish$default(this.a, false, null, 3, null);
            return;
        }
    }

    static {
        Companion = new b();
    }

    public final void attach() {
        this.pkSideEffect.observeForever(this.sideEffectObserver);
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a getBattleScoreData() {
        return (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) this.scoreData.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a
    public void resetState() {
        this._playState.setValue(d.a.b);
    }

    public final void clearIt() {
        onCleared();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a
    public LiveData<n3> getBreakthroughInfo() {
        return this.breakthroughInfo;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a
    public LiveData<d> getPlayState() {
        return this.playState;
    }

    public static final /* synthetic */ BaseBreakThroughDataContext$battleScoreDataObserver$1 access$getBattleScoreDataObserver$p(BaseBreakThroughDataContext r0) {
        return r0.battleScoreDataObserver;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(BaseBreakThroughDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Function0 access$getGetCurrentState$p(BaseBreakThroughDataContext r0) {
        return r0.getCurrentState;
    }

    public static final /* synthetic */ LiveData access$getPkSideEffect$p(BaseBreakThroughDataContext r0) {
        return r0.pkSideEffect;
    }

    public static final /* synthetic */ LiveData access$getScoreUpdateByMsg$p(BaseBreakThroughDataContext r0) {
        return r0.scoreUpdateByMsg;
    }

    public static final /* synthetic */ Observer access$getSideEffectObserver$p(BaseBreakThroughDataContext r0) {
        return r0.sideEffectObserver;
    }

    public static final /* synthetic */ BreakThroughStateMachine access$getStateMachine$p(BaseBreakThroughDataContext r0) {
        return r0.stateMachine;
    }

    public static final /* synthetic */ MutableLiveData access$get_breakthroughInfo$p(BaseBreakThroughDataContext r0) {
        return r0._breakthroughInfo;
    }

    public static final /* synthetic */ MutableLiveData access$get_playState$p(BaseBreakThroughDataContext r0) {
        return r0._playState;
    }

    public void setBreakthroughInfo(LiveData<n3> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.breakthroughInfo = r2;
    }

    public static final /* synthetic */ void access$set_breakthroughInfo$p(BaseBreakThroughDataContext r0, MutableLiveData r1) {
        r0._breakthroughInfo = r1;
    }

    private final void onFinish(boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2) {
        if ((getPlayState().getValue() instanceof d.a) == false) goto L5;
        return;
    L5:
        MutableLiveData<n3> r3 = this._breakthroughInfo;
        if (r2 == null) goto L8;
        n3 r4 = r2.i;
    L9:
        r3.setValue(r4);
        this.stateMachine.a(com.bytedance.android.live.revlink.impl.pk.vm.pk.b.a.a);
        return;
    L8:
        r4 = null;
        goto L9
    }

    private final void onShowPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        n3 r3 = r1.i;
        if (r3 != null) goto L5;
        return;
    L5:
        this._breakthroughInfo.setValue(r3);
        this.stateMachine.a(com.bytedance.android.live.revlink.impl.pk.vm.pk.b.C0188b.a);
    }

    private final void onShowPk(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, PkBaseStateMachine.Source r3) {
        IBaseBattleSetting r4 = r2.a;
        if (r4 == null) goto L9;
        IBattleConfigSetting r5 = r4.getBattleConfigSetting();
        if (r5 == null) goto L9;
        if (r5.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L9;
    L10:
        this._breakthroughInfo.setValue(r2.i);
        this.stateMachine.a(com.bytedance.android.live.revlink.impl.pk.vm.pk.b.d.a);
        return;
    L9:
        if (r2.i != null) goto L10;
        this._breakthroughInfo.setValue(null);
        this.stateMachine.a(com.bytedance.android.live.revlink.impl.pk.vm.pk.b.a.a);
    }

    public static final /* synthetic */ void access$onFinish(BaseBreakThroughDataContext r0, boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2) {
        r0.onFinish(r1, r2);
    }

    public static final /* synthetic */ void access$onShowPenal(BaseBreakThroughDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPenal(r1, r2);
    }

    public static final /* synthetic */ void access$onShowPk(BaseBreakThroughDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPk(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseBreakThroughDataContext(LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r2, LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r3, Function0<? extends PkBaseStateMachine.c> r4, LiveData<PkBaseStateMachine.b> r5) {
        Intrinsics.checkNotNullParameter(r2, "scoreData");
        Intrinsics.checkNotNullParameter(r3, "scoreUpdateByMsg");
        Intrinsics.checkNotNullParameter(r4, "getCurrentState");
        Intrinsics.checkNotNullParameter(r5, "pkSideEffect");
        this.scoreData = r2;
        this.scoreUpdateByMsg = r3;
        this.getCurrentState = r4;
        this.pkSideEffect = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.cd = r6;
        MutableLiveData<d> r7 = new MutableLiveData();
        this._playState = r7;
        this.playState = r7;
        MutableLiveData<n3> r8 = new MutableLiveData();
        this._breakthroughInfo = r8;
        this.breakthroughInfo = r8;
        this.stateMachine = new BreakThroughStateMachine(new BaseBreakThroughDataContext$stateMachine$1(this));
        this.sideEffectObserver = new c(this);
        androidx.lifecycle.Observer r9 = new BaseBreakThroughDataContext$battleScoreDataObserver$1(this);
        this.battleScoreDataObserver = r9;
        f.a(getOnCleared().subscribe(new a(this)), r6);
        r3.observeForever(r9);
    }

    public static /* synthetic */ void onFinish$default(BaseBreakThroughDataContext r0, boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        r0.onFinish(r1, r2);
    }
}
