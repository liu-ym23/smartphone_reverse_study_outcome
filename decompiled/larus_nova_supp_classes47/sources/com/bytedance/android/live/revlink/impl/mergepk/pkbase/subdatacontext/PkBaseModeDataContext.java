package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.g7;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u001f\u0012\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020-0\u001dj\b\u0012\u0004\u0012\u00020-`\u001e¢\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0002J\u001e\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0006\u0010\u0013\u001a\u00020\u0006R\u0018\u0010\u0016\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001dj\b\u0012\u0004\u0012\u00020\u0019`\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020-0\u001dj\b\u0012\u0004\u0012\u00020-`\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010 ¨\u00065"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseModeDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "", "onShowPk", "onShowPenal", "", "", "Lcom/bytedance/android/livesdk/link/model/g7;", "multiPkTeam", "updatePkModeHalfEnter", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "battleUserInfoMap", "updatePkMode", "resetBattle", "clearIt", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "_pkMode", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "pkMode", "Landroidx/lifecycle/LiveData;", "getPkMode", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/e;", "uidTeamIdMapper", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/e;", "userIdToTeamId", "Ljava/util/Map;", "getUserIdToTeamId", "()Ljava/util/Map;", "setUserIdToTeamId", "(Ljava/util/Map;)V", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$b;", "sideEffectObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "pkSideEffect", "<init>", "(Landroidx/lifecycle/LiveData;)V", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkBaseModeDataContext extends DataContext {
    public static final b Companion = null;
    public static final String TAG = "ttlive_PkBaseModeDataContext";
    private final NextLiveData<PlayMode> _pkMode;
    private final CompositeDisposable cd;
    private final LiveData<PlayMode> pkMode;
    private final LiveData<PkBaseStateMachine.b> pkSideEffect;
    private final Observer<PkBaseStateMachine.b> sideEffectObserver;
    private final com.bytedance.android.live.revlink.impl.multianchor.pk.e uidTeamIdMapper;
    private Map<String, Long> userIdToTeamId;

    public static final class a implements Action {
        public final /* synthetic */ PkBaseModeDataContext a;

        public a(PkBaseModeDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            PkBaseModeDataContext.access$getPkSideEffect$p(this.a).removeObserver(PkBaseModeDataContext.access$getSideEffectObserver$p(this.a));
            PkBaseModeDataContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PkBaseModeDataContext a;

        public c(PkBaseModeDataContext r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            PkBaseStateMachine.b r4 = (PkBaseStateMachine.b) r3;
            if ((r4 instanceof PkBaseStateMachine.b.c) == false) goto L6;
            PkBaseStateMachine.c r5 = r4.b;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r0 = r5.a;
            PkBaseModeDataContext.access$onShowPk(this.a, r0, r5.b);
            return;
        L6:
            if ((r4 instanceof PkBaseStateMachine.b.d) == false) goto L8;
            PkBaseModeDataContext r1 = this.a;
            PkBaseStateMachine.c r6 = r4.b;
            PkBaseModeDataContext.access$onShowPenal(r1, r6.a, r6.b);
            return;
        L8:
            PkBaseModeDataContext.access$resetBattle(this.a);
        }
    }

    static {
        Companion = new b();
    }

    private final void resetBattle() {
        this._pkMode.setValue(null);
    }

    public final void clearIt() {
        onCleared();
    }

    public final LiveData<PlayMode> getPkMode() {
        return this.pkMode;
    }

    public final Map<String, Long> getUserIdToTeamId() {
        return this.userIdToTeamId;
    }

    public PkBaseModeDataContext(LiveData<PkBaseStateMachine.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "pkSideEffect");
        this.pkSideEffect = r3;
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        NextLiveData<PlayMode> r1 = new NextLiveData();
        this._pkMode = r1;
        this.pkMode = r1;
        this.uidTeamIdMapper = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a;
        c r2 = new c(this);
        this.sideEffectObserver = r2;
        r3.observeForever(r2);
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r0);
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkBaseModeDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ LiveData access$getPkSideEffect$p(PkBaseModeDataContext r0) {
        return r0.pkSideEffect;
    }

    public static final /* synthetic */ Observer access$getSideEffectObserver$p(PkBaseModeDataContext r0) {
        return r0.sideEffectObserver;
    }

    public static final /* synthetic */ void access$resetBattle(PkBaseModeDataContext r0) {
        r0.resetBattle();
    }

    private final void updatePkMode(Map<String, ? extends IBattleUserInfo> r4) {
        this.uidTeamIdMapper.getClass();
        Map<String, Long> r5 = com.bytedance.android.live.revlink.impl.multianchor.pk.e.a(r4);
        if (r5 != null) goto L5;
    L8:
        this._pkMode.setValue(PlayMode.PERSONAL_PK);
    L9:
        jy0.b.f(TAG, "updatePkMode to " + ((PlayMode) this.pkMode.getValue()) + ", userIdToTeamId=" + r5, null, 4);
        return;
    L5:
        if (((HashMap) r5).isEmpty() == true) goto L8;
        this.userIdToTeamId = r5;
        this._pkMode.setValue(PlayMode.TEAM_PK);
        goto L9
    }

    private final void updatePkModeHalfEnter(Map<Long, ? extends g7> r4) {
        if (r4 != null) goto L4;
    L7:
        this._pkMode.setValue(PlayMode.PERSONAL_PK);
        jy0.b.f(TAG, "updatePkMode to " + ((PlayMode) this.pkMode.getValue()) + ", userIdToTeamId=" + this.userIdToTeamId, null, 4);
        return;
    L4:
        if ((!r4.isEmpty()) != true) goto L7;
        this.uidTeamIdMapper.getClass();
        this.userIdToTeamId = com.bytedance.android.live.revlink.impl.multianchor.pk.e.b(r4);
        this._pkMode.setValue(PlayMode.TEAM_PK);
    }

    public final void setUserIdToTeamId(Map<String, Long> r1) {
        this.userIdToTeamId = r1;
    }

    private final void onShowPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, PkBaseStateMachine.Source r3) {
        if (r3 != PkBaseStateMachine.Source.MetaUpdate) goto L6;
        updatePkModeHalfEnter(r2.d);
        return;
    }

    private final void onShowPk(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, PkBaseStateMachine.Source r3) {
        if (r3 != PkBaseStateMachine.Source.MetaUpdate) goto L5;
        updatePkModeHalfEnter(r2.d);
        return;
    L5:
        updatePkMode(r2.b);
    }

    public static final /* synthetic */ void access$onShowPenal(PkBaseModeDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPenal(r1, r2);
    }

    public static final /* synthetic */ void access$onShowPk(PkBaseModeDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPk(r1, r2);
    }
}
