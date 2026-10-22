package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ca0.s;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.livesdk.gift.model.h3;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdk.link.model.t1;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001A\u0018\u00002\u00020\u0001Ba\u0012\u0016\u0010L\u001a\u0012\u0012\u0004\u0012\u00020I0\"j\b\u0012\u0004\u0012\u00020I`#\u0012\"\u0010M\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00120,j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0012`-\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\u0010U\u001a\u0004\u0018\u00010T¢\u0006\u0004\bj\u0010kJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\u0006\u0010\u001c\u001a\u00020\u0006R0\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00120\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0012`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R3\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00120\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0012`#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020(0\u001dj\b\u0012\u0004\u0012\u00020(`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010!R'\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0\"j\b\u0012\u0004\u0012\u00020(`#8\u0006¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R'\u0010.\u001a\u0012\u0012\u0004\u0012\u00020(0,j\b\u0012\u0004\u0012\u00020(`-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R'\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00150,j\b\u0012\u0004\u0012\u00020\u0015`-8\u0006¢\u0006\f\n\u0004\b2\u0010/\u001a\u0004\b3\u00101R'\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00150,j\b\u0012\u0004\u0012\u00020\u0015`-8\u0006¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00101R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107RB\u0010;\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020908j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u000209`:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u00060Dj\u0002`E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020I0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010L\u001a\u0012\u0012\u0004\u0012\u00020I0\"j\b\u0012\u0004\u0012\u00020I`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010%R0\u0010M\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00120,j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0012`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010/R\u0016\u0010O\u001a\u0004\u0018\u00010N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u0004\u0018\u00010Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u0004\u0018\u00010T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0016\u0010^\u001a\u0004\u0018\u00010[8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0016\u0010b\u001a\u0004\u0018\u00010_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0016\u0010f\u001a\u0004\u0018\u00010c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010i\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseScoreDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/a;", "pkInfo", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "source", "", "onShowPk", "sendFirstUpdateEvent", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "", "logId", "", "updateMessageFrom", "sendAudienceTimeDiffMonitor", "", "Laf2/b;", "newScoreList", "", "judgeIsNeedAdjustScore", "sendMonitor", "onShowPenal", "skippedPenal", "onFinish", "resetBattle", "clearIt", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcf2/a;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "_scoreState", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "scoreState", "Landroidx/lifecycle/LiveData;", "getScoreState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/a;", "_battleScoreData", "battleScoreData", "getBattleScoreData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "battleScoreUpdateByMsg", "Landroidx/lifecycle/MutableLiveData;", "getBattleScoreUpdateByMsg", "()Landroidx/lifecycle/MutableLiveData;", "scoreFirstUpdate", "getScoreFirstUpdate", "scoreTextEnable", "getScoreTextEnable", "scoreUpdateCount", "I", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "giftStore", "Ljava/util/HashMap;", "getGiftStore", "()Ljava/util/HashMap;", "setGiftStore", "(Ljava/util/HashMap;)V", "com/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseScoreDataContext$b", "giftSendResultListener", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseScoreDataContext$b;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$b;", "sideEffectObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "pkSideEffect", "baseScoreState", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lcom/bytedance/android/live/revenuelink/f;", "getRevenueLinkTraceMonitor", "()Lcom/bytedance/android/live/revenuelink/f;", "revenueLinkTraceMonitor", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/z;", "getMultiPkMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/z;", "multiPkMonitor", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "getLinkCrossRoomDataHolder", "()Lcom/bytedance/android/live/revlink/impl/LinkCrossRoomDataHolder;", "linkCrossRoomDataHolder", "getChannelId", "()J", "channelId", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MutableLiveData;Lld/a;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkBaseScoreDataContext extends DataContext {
    private final NextLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> _battleScoreData;
    private final NextLiveData<List<cf2.a>> _scoreState;
    private final MutableLiveData<List<cf2.a>> baseScoreState;
    private final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> battleScoreData;
    private final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> battleScoreUpdateByMsg;
    private final CompositeDisposable cd;
    private final b giftSendResultListener;
    private HashMap<String, Long> giftStore;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;
    private final LiveData<PkBaseStateMachine.b> pkSideEffect;
    private final MutableLiveData<Boolean> scoreFirstUpdate;
    private final LiveData<List<cf2.a>> scoreState;
    private final MutableLiveData<Boolean> scoreTextEnable;
    private int scoreUpdateCount;
    private final Observer<PkBaseStateMachine.b> sideEffectObserver;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseScoreDataContext$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(PkBaseScoreDataContext r8) {
            super(1, r8, PkBaseScoreDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkBaseScoreDataContext.access$onMessage((PkBaseScoreDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkBaseScoreDataContext a;

        public a(PkBaseScoreDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            cy0.e.a.getClass();
            j r1 = cy0.e.a.a;
            m.e.getClass();
            Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
            Intrinsics.checkNotNull(r0);
            ((com.bytedance.live.kmp.core.c) r0).removeGiftSendResultListener(PkBaseScoreDataContext.access$getGiftSendResultListener$p(this.a));
            PkBaseScoreDataContext.access$getPkSideEffect$p(this.a).removeObserver(PkBaseScoreDataContext.access$getSideEffectObserver$p(this.a));
            ld.a r2 = PkBaseScoreDataContext.access$getLinkDataSet$p(this.a);
            if (r2 == null) goto L7;
            NextLiveData r3 = r2.Lc();
            if (r3 == null) goto L7;
            r3.setValue(Boolean.FALSE);
        L7:
            ld.a r4 = PkBaseScoreDataContext.access$getLinkDataSet$p(this.a);
            if (r4 == null) goto L12;
            NextLiveData r5 = r4.isHugeRewardPk();
            if (r5 == null) goto L12;
            r5.setValue(Boolean.FALSE);
        L12:
            ld.a r6 = PkBaseScoreDataContext.access$getLinkDataSet$p(this.a);
            if (r6 == null) goto L17;
            NextLiveData r7 = r6.Jj();
            if (r7 == null) goto L17;
            r7.setValue(Boolean.FALSE);
        L17:
            PkBaseScoreDataContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b implements s {
        public final /* synthetic */ PkBaseScoreDataContext a;

        public b(PkBaseScoreDataContext r1) {
            this.a = r1;
        }

        public final void j(com.bytedance.android.livesdk.gift.platform.business.sendGift.f r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            h3 r0 = r4.e;
            if (r0 == null) goto L21;
            String r1 = r0.c;
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.length() <= 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L12;
            return;
        L12:
            if (r4.c == true) goto L14;
            return;
        L14:
            if ((PkBaseScoreDataContext.access$getPkSideEffect$p(this.a).getValue() instanceof PkBaseStateMachine.b.c) == false) goto L25;
            HashMap<String, Long> r3 = this.a.getGiftStore();
            h3 r5 = r4.e;
            if (r5 == null) goto L18;
            String r6 = r5.c;
        L19:
            r3.put(r6, Long.valueOf(com.bytedance.live.kmp.util.e.b()));
            return;
        L18:
            r6 = null;
            goto L19
        L25:
            return;
        L9:
            r2 = false;
            goto L10
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PkBaseScoreDataContext a;

        public c(PkBaseScoreDataContext r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            PkBaseStateMachine.b r9 = (PkBaseStateMachine.b) r8;
            if ((r9 instanceof PkBaseStateMachine.b.c) == false) goto L6;
            PkBaseStateMachine.c r10 = r9.b;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r0 = r10.a;
            PkBaseScoreDataContext.access$onShowPk(this.a, r0, r10.b);
            return;
        L6:
            if ((r9 instanceof PkBaseStateMachine.b.d) == false) goto L9;
            PkBaseScoreDataContext r1 = this.a;
            PkBaseStateMachine.c r12 = r9.b;
            PkBaseScoreDataContext.access$onShowPenal(r1, r12.a, r12.b);
            return;
        L9:
            if ((r9 instanceof PkBaseStateMachine.b.a) == false) goto L12;
            r9.a.a();
            PkBaseScoreDataContext r2 = this.a;
            boolean r3 = ((PkBaseStateMachine.b.a) r9).d;
            PkBaseStateMachine.c r13 = r9.b;
            PkBaseScoreDataContext.access$onFinish(r2, r3, r13.a, r13.b);
            return;
        L12:
            if ((r9 instanceof PkBaseStateMachine.b.C0129b) == false) goto L18;
            PkBaseScoreDataContext.onFinish$default(this.a, false, null, r9.b.b, 3, null);
            return;
        }
    }

    private final LinkCrossRoomDataHolder getLinkCrossRoomDataHolder() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    private final z getMultiPkMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiPkMonitor();
    }

    private final com.bytedance.android.live.revlink.impl.utils.s getRevLinkCommonUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    private final com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevenueLinkTraceMonitor();
    }

    private final void resetBattle() {
        this._scoreState.setValue(new ArrayList());
        this._battleScoreData.setValue(null);
        this.battleScoreUpdateByMsg.setValue(null);
        this.giftStore.clear();
        ld.a r0 = this.linkDataSet;
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.Lc();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.FALSE);
    L7:
        ld.a r2 = this.linkDataSet;
        if (r2 == null) goto L12;
        NextLiveData r3 = r2.isHugeRewardPk();
        if (r3 == null) goto L12;
        r3.setValue(Boolean.FALSE);
    L12:
        ld.a r4 = this.linkDataSet;
        if (r4 == null) goto L18;
        NextLiveData r5 = r4.Jj();
        if (r5 == null) goto L19;
        r5.setValue(Boolean.FALSE);
        return;
    L19:
        return;
    }

    private final void sendFirstUpdateEvent() {
        if (this.scoreUpdateCount != 0) goto L5;
        this.scoreFirstUpdate.setValue(Boolean.TRUE);
    L5:
        this.scoreUpdateCount++;
    }

    private final long getChannelId() {
        LinkCrossRoomDataHolder r0 = getLinkCrossRoomDataHolder();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    public final void clearIt() {
        onCleared();
    }

    public final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getBattleScoreData() {
        return this.battleScoreData;
    }

    public final MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getBattleScoreUpdateByMsg() {
        return this.battleScoreUpdateByMsg;
    }

    public final HashMap<String, Long> getGiftStore() {
        return this.giftStore;
    }

    public final MutableLiveData<Boolean> getScoreFirstUpdate() {
        return this.scoreFirstUpdate;
    }

    public final LiveData<List<cf2.a>> getScoreState() {
        return this.scoreState;
    }

    public final MutableLiveData<Boolean> getScoreTextEnable() {
        return this.scoreTextEnable;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkBaseScoreDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ b access$getGiftSendResultListener$p(PkBaseScoreDataContext r0) {
        return r0.giftSendResultListener;
    }

    public static final /* synthetic */ ld.a access$getLinkDataSet$p(PkBaseScoreDataContext r0) {
        return r0.linkDataSet;
    }

    public static final /* synthetic */ LiveData access$getPkSideEffect$p(PkBaseScoreDataContext r0) {
        return r0.pkSideEffect;
    }

    public static final /* synthetic */ Observer access$getSideEffectObserver$p(PkBaseScoreDataContext r0) {
        return r0.sideEffectObserver;
    }

    private final boolean judgeIsNeedAdjustScore(List<? extends af2.b> r10) {
        u41.c r0 = u41.c.f;
        r0.getClass();
        if (((Boolean) u41.c.b.getValue(r0, u41.c.a[0])).booleanValue() == true) goto L5;
        return true;
    L5:
        List r1 = (List) this.scoreState.getValue();
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        if (r1 == null) goto L10;
        Integer r2 = Integer.valueOf(r1.size());
    L12:
        if (r2.intValue() != 0) goto L14;
        return true;
    L14:
        if (r10 != null) goto L16;
        return false;
    L16:
        HashMap r3 = new HashMap();
        HashMap r4 = new HashMap();
        Iterator r5 = r1.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        cf2.a r6 = (cf2.a) r5.next();
        String r7 = r6.c;
        if (r7 == null) goto L18;
        r3.put(r7, Integer.valueOf((int) r6.a));
        r4.put(r7, r6.b);
        goto L18
    L22:
        Iterator<? extends af2.b> r12 = r10.iterator();
    L24:
        if (r12.hasNext() == false) goto L32;
        af2.b r8 = r12.next();
        long r9 = af2.c.b(r8);
        Integer r13 = (Integer) r3.get(af2.c.a(r8));
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
    L30:
        if (r9 < r14) goto L24;
        return true;
    L28:
        r14 = 0;
        goto L30
    L32:
        return false;
    L10:
        r2 = null;
        goto L12
    }

    private final void onMessage(yh6.c r9) {
        if ((r9 instanceof z0) == false) goto L76;
        k5 r10 = ((vh7.c) r9).castTo(k5.class);
        if (((int) r10.getType2()) == 202) goto L7;
        return;
    L7:
        if (r10.getChannelId() == 0) goto L14;
        if (getChannelId() == 0) goto L14;
        if (r10.getChannelId() == getChannelId()) goto L14;
        return;
    L14:
        if ((this.pkSideEffect.getValue() instanceof PkBaseStateMachine.b.c) == true) goto L16;
        return;
    L16:
        NextLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r0 = this._battleScoreData;
        List r2 = r10.getUserScores();
        if (r2 == null) goto L19;
        List r3 = CollectionsKt.toList(r2);
    L20:
        if (r3 != null) goto L22;
        r3 = CollectionsKt.emptyList();
    L22:
        r0.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r3, r10.getBreakthroughInfo(), PkBaseStateMachine.Source.BattleMsg.ordinal()));
        if (r10.getBreakthroughInfo() == null) goto L31;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r1 = this.battleScoreUpdateByMsg;
        List r4 = r10.getUserScores();
        if (r4 == null) goto L27;
        List r5 = CollectionsKt.toList(r4);
    L28:
        if (r5 != null) goto L30;
        r5 = CollectionsKt.emptyList();
    L30:
        r1.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r5, r10.getBreakthroughInfo(), 0));
        goto L31
    L27:
        r5 = null;
    L31:
        sendMonitor(r10.getScoreUpdateLogId(), r10.getUpdateMessageFrom());
        if (getMultiPkMonitor() == null) goto L40;
        Intrinsics.checkNotNullParameter(r10, "message");
        StringBuilder r6 = new StringBuilder("TYPE_BATTLE_DATA msgId=");
        r6.append(qj.a(r10));
        r6.append(": ");
        List r7 = r10.getUserScores();
        if (r7 == null) goto L38;
        List r8 = CollectionsKt.toList(r7);
        if (r8 == null) goto L38;
        String r12 = ef2.a.a(r8);
    L39:
        r6.append(r12);
        jy0.b.d("ttlive_anchor_link_multi_pk", r6.toString());
    L38:
        r12 = null;
    L40:
        List r13 = r10.getUserScores();
        if (r13 == null) goto L43;
        List<? extends af2.b> r14 = CollectionsKt.toList(r13);
    L45:
        if (judgeIsNeedAdjustScore(r14) == false) goto L64;
        ArrayList r15 = new ArrayList();
        List r16 = r10.getUserScores();
        if (r16 == null) goto L63;
        Iterator r17 = r16.iterator();
    L50:
        if (r17.hasNext() == false) goto L63;
        t1 r18 = (t1) r17.next();
        String r19 = r18.getUserId();
        com.bytedance.android.live.revlink.impl.utils.s r20 = getRevLinkCommonUtil();
        if (r20 == null) goto L54;
        String r22 = r20.c();
    L56:
        if (Intrinsics.areEqual(r19, r22) == true) goto L57;
        r15.add(new cf2.a(r18, null, null, null));
        goto L50
    L57:
        IBaseUser r23 = r10.getFromUser();
        IBattleBarConfig r24 = r10.getBattleBarConfig();
        Intrinsics.checkNotNullParameter(r10, "$this$fromUserId");
        r15.add(new cf2.a(r18, r23, r24, r10.get_fromUserId()));
        this.scoreTextEnable.setValue(Boolean.valueOf(r18.getNewScoreOpen()));
        ld.a r25 = this.linkDataSet;
        if (r25 == null) goto L50;
        NextLiveData r26 = r25.isHugeRewardPk();
        if (r26 == null) goto L50;
        r26.setValue(Boolean.valueOf(r18.isHugeRewardPk()));
        goto L50
    L54:
        r22 = null;
    L63:
        this._scoreState.setValue(r15);
        this.baseScoreState.setValue(r15);
        sendFirstUpdateEvent();
    L64:
        sendAudienceTimeDiffMonitor(r10.getScoreUpdateLogId(), r10.getUpdateMessageFrom());
        return;
    L43:
        r14 = null;
        goto L45
    L19:
        r3 = null;
        goto L20
    }

    public final void setGiftStore(HashMap<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.giftStore = r2;
    }

    public static final /* synthetic */ void access$onMessage(PkBaseScoreDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    private final void onShowPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r6, PkBaseStateMachine.Source r7) {
        if (judgeIsNeedAdjustScore(r6.c) == false) goto L49;
        List<a1> r0 = r6.c;
        List<cf2.a> r1 = null;
        if (r0 == null) goto L18;
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        String r4 = af2.c.a((a1) r3);
        com.bytedance.android.live.revlink.impl.utils.s r5 = getRevLinkCommonUtil();
        if (r5 == null) goto L12;
        String r8 = r5.c();
    L14:
        if (Intrinsics.areEqual(r4, r8) == false) goto L8;
    L17:
        a1 r9 = (a1) r3;
    L19:
        MutableLiveData<Boolean> r10 = this.scoreTextEnable;
        boolean r12 = false;
        if (r9 == null) goto L22;
        boolean r13 = r9.getNewScoreOpen();
    L23:
        r10.setValue(Boolean.valueOf(r13));
        ld.a r14 = this.linkDataSet;
        if (r14 == null) goto L30;
        NextLiveData r15 = r14.isHugeRewardPk();
        if (r15 == null) goto L30;
        if (r9 == null) goto L29;
        r12 = r9.isHugeRewardPk();
    L29:
        r15.setValue(Boolean.valueOf(r12));
    L30:
        ld.a r16 = this.linkDataSet;
        if (r16 == null) goto L39;
        NextLiveData r17 = r16.Jj();
        if (r17 == null) goto L39;
        if (r9 == null) goto L37;
        boolean r18 = r9.getScoreRelative();
    L38:
        r17.setValue(Boolean.valueOf(!r18));
        goto L39
    L37:
        r18 = true;
    L39:
        NextLiveData<List<cf2.a>> r19 = this._scoreState;
        List<a1> r20 = r6.c;
        if (r20 == null) goto L42;
        r1 = h.a(r20);
    L42:
        r19.setValue(r1);
        sendFirstUpdateEvent();
        List<a1> r22 = r6.c;
        if (r22 == null) goto L50;
        this._battleScoreData.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r22, r6.i, r7.ordinal()));
        return;
    L50:
        return;
    L22:
        r13 = false;
        goto L23
    L12:
        r8 = null;
        goto L14
    L16:
        r3 = null;
        goto L17
    L18:
        r9 = null;
        goto L19
    }

    private final void onShowPk(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r6, PkBaseStateMachine.Source r7) {
        resetBattle();
        if (r7 == PkBaseStateMachine.Source.MetaUpdate) goto L5;
        return;
    L5:
        if (judgeIsNeedAdjustScore(r6.c) == false) goto L52;
        List<a1> r0 = r6.c;
        List<cf2.a> r1 = null;
        if (r0 == null) goto L20;
        Iterator<T> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        String r4 = af2.c.a((a1) r3);
        com.bytedance.android.live.revlink.impl.utils.s r5 = getRevLinkCommonUtil();
        if (r5 == null) goto L14;
        String r8 = r5.c();
    L16:
        if (Intrinsics.areEqual(r4, r8) == false) goto L10;
    L19:
        a1 r9 = (a1) r3;
    L21:
        MutableLiveData<Boolean> r10 = this.scoreTextEnable;
        boolean r12 = false;
        if (r9 == null) goto L24;
        boolean r13 = r9.getNewScoreOpen();
    L25:
        r10.setValue(Boolean.valueOf(r13));
        ld.a r14 = this.linkDataSet;
        if (r14 == null) goto L32;
        NextLiveData r15 = r14.isHugeRewardPk();
        if (r15 == null) goto L32;
        if (r9 == null) goto L31;
        r12 = r9.isHugeRewardPk();
    L31:
        r15.setValue(Boolean.valueOf(r12));
    L32:
        ld.a r16 = this.linkDataSet;
        if (r16 == null) goto L41;
        NextLiveData r17 = r16.Jj();
        if (r17 == null) goto L41;
        if (r9 == null) goto L39;
        boolean r18 = r9.getScoreRelative();
    L40:
        r17.setValue(Boolean.valueOf(!r18));
        goto L41
    L39:
        r18 = true;
    L41:
        NextLiveData<List<cf2.a>> r19 = this._scoreState;
        List<a1> r20 = r6.c;
        if (r20 == null) goto L44;
        r1 = h.a(r20);
    L44:
        r19.setValue(r1);
        sendFirstUpdateEvent();
        List<a1> r22 = r6.c;
        if (r22 == null) goto L53;
        this._battleScoreData.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r22, r6.i, r7.ordinal()));
        return;
    L53:
        return;
    L24:
        r13 = false;
        goto L25
    L14:
        r8 = null;
        goto L16
    L18:
        r3 = null;
        goto L19
    L20:
        r9 = null;
        goto L21
    }

    private final void sendAudienceTimeDiffMonitor(String r12, int r13) {
        u41.d r0 = u41.d.n;
        r0.getClass();
        boolean r3 = false;
        if (((Boolean) u41.d.b.getValue(r0, u41.d.a[0])).booleanValue() == true) goto L11;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.length() <= 0) goto L8;
        r3 = true;
    L8:
        if (r3 != true) goto L36;
        this.giftStore.remove(r12);
        return;
    L36:
        return;
    L11:
        if (r12 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L19;
        return;
    L19:
        if (this.giftStore.get(r12) == null) goto L39;
        long r4 = com.bytedance.live.kmp.util.e.b();
        JSONObject r2 = new JSONObject();
        Long r14 = this.giftStore.get(r12);
        if (r14 != null) goto L24;
        r14 = 0L;
    L24:
        long r8 = r14.longValue();
        if (r8 != 0) goto L28;
        return;
    L28:
        if (r13 != 1) goto L30;
        r2.put("is_point_to_point_message", 1);
    L31:
        r2.put("time_since_send_gift", r4 - r8);
        com.bytedance.android.live.revenuelink.f r15 = getRevenueLinkTraceMonitor();
        if (r15 == null) goto L38;
        r15.b0("pk_audience_score_message_optimize", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r2);
        return;
    L38:
        return;
    L30:
        r2.put("is_point_to_point_message", 0);
        goto L31
    L39:
        return;
    L13:
        if (r12.length() == 0) goto L16;
        r1 = false;
        goto L17
    }

    private final void sendMonitor(String r12, int r13) {
        u41.d r0 = u41.d.n;
        r0.getClass();
        boolean r3 = false;
        if (((Boolean) u41.d.b.getValue(r0, u41.d.a[0])).booleanValue() == true) goto L11;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.length() <= 0) goto L8;
        r3 = true;
    L8:
        if (r3 != true) goto L36;
        this.giftStore.remove(r12);
        return;
    L36:
        return;
    L11:
        if (r12 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L19;
        return;
    L19:
        if (this.giftStore.get(r12) == null) goto L39;
        long r4 = com.bytedance.live.kmp.util.e.b();
        JSONObject r2 = new JSONObject();
        Long r14 = this.giftStore.get(r12);
        if (r14 != null) goto L24;
        r14 = 0L;
    L24:
        long r8 = r14.longValue();
        if (r8 != 0) goto L28;
        return;
    L28:
        if (r13 != 1) goto L30;
        r2.put("is_point_to_point_message", 1);
    L31:
        r2.put("time_since_send_gift", r4 - r8);
        com.bytedance.android.live.revenuelink.f r15 = getRevenueLinkTraceMonitor();
        if (r15 == null) goto L38;
        r15.b0("pk_audience_score_message_optimize", LiveTracingMonitorKt.EventModule.PK, r2);
        return;
    L38:
        return;
    L30:
        r2.put("is_point_to_point_message", 0);
        goto L31
    L39:
        return;
    L13:
        if (r12.length() == 0) goto L16;
        r1 = false;
        goto L17
    }

    public static final /* synthetic */ void access$onShowPenal(PkBaseScoreDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPenal(r1, r2);
    }

    public static final /* synthetic */ void access$onShowPk(PkBaseScoreDataContext r0, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2) {
        r0.onShowPk(r1, r2);
    }

    private final void onFinish(boolean r6, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r7, PkBaseStateMachine.Source r8) {
        if (r6 == false) goto L29;
        if (r7 == null) goto L29;
        if (judgeIsNeedAdjustScore(r7.c) == false) goto L29;
        MutableLiveData<Boolean> r9 = this.scoreTextEnable;
        List<a1> r0 = r7.c;
        List<cf2.a> r1 = null;
        if (r0 == null) goto L22;
        Iterator<T> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        String r4 = af2.c.a((a1) r3);
        com.bytedance.android.live.revlink.impl.utils.s r5 = getRevLinkCommonUtil();
        if (r5 == null) goto L14;
        String r10 = r5.c();
    L16:
        if (Intrinsics.areEqual(r4, r10) == false) goto L10;
    L19:
        a1 r12 = (a1) r3;
        if (r12 == null) goto L22;
        boolean r13 = r12.getNewScoreOpen();
    L23:
        r9.setValue(Boolean.valueOf(r13));
        NextLiveData<List<cf2.a>> r14 = this._scoreState;
        List<a1> r15 = r7.c;
        if (r15 == null) goto L26;
        r1 = h.a(r15);
    L26:
        r14.setValue(r1);
        sendFirstUpdateEvent();
        List<a1> r16 = r7.c;
        if (r16 == null) goto L29;
        this._battleScoreData.setValue(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a(r16, r7.i, r8.ordinal()));
        goto L29
    L14:
        r10 = null;
        goto L16
    L18:
        r3 = null;
    L22:
        r13 = false;
    L29:
        resetBattle();
    }

    public static final /* synthetic */ void access$onFinish(PkBaseScoreDataContext r0, boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, PkBaseStateMachine.Source r3) {
        r0.onFinish(r1, r2, r3);
    }

    public PkBaseScoreDataContext(LiveData<PkBaseStateMachine.b> r4, MutableLiveData<List<cf2.a>> r5, ld.a r6, com.bytedance.android.live.revlink.impl.global.c r7, yz0.f r8) {
        Intrinsics.checkNotNullParameter(r4, "pkSideEffect");
        Intrinsics.checkNotNullParameter(r5, "baseScoreState");
        this.pkSideEffect = r4;
        this.baseScoreState = r5;
        this.linkDataSet = r6;
        this.linkFakeGlobalService = r7;
        this.messageService = r8;
        NextLiveData<List<cf2.a>> r9 = new NextLiveData();
        this._scoreState = r9;
        this.scoreState = r9;
        NextLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r10 = new NextLiveData();
        this._battleScoreData = r10;
        this.battleScoreData = r10;
        this.battleScoreUpdateByMsg = new MutableLiveData();
        this.scoreFirstUpdate = new MutableLiveData();
        this.scoreTextEnable = new MutableLiveData();
        this.giftStore = new HashMap();
        b r12 = new b(this);
        this.giftSendResultListener = r12;
        CompositeDisposable r13 = new CompositeDisposable();
        this.cd = r13;
        c r14 = new c(this);
        this.sideEffectObserver = r14;
        if (r8 == null) goto L9;
        com.bytedance.android.live.revenue.common.message.a r0 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r1 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r0, "$this$LINK_MIC");
        Observable r15 = yz0.h.a.a(r8, (yh6.b) CommonMessageTypeKt.c.getValue(), false, 6);
        if (r15 == null) goto L9;
        final AnonymousClass1 r2 = new AnonymousClass1(this);
        Disposable r16 = r15.subscribe(new d(r2));
        if (r16 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, r13);
    L9:
        cy0.e.a.getClass();
        j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r17 = m.b(r3).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).addGiftSendResultListener(r12);
        r4.observeForever(r14);
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r13);
    }

    public static /* synthetic */ void onFinish$default(PkBaseScoreDataContext r0, boolean r1, com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, PkBaseStateMachine.Source r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = PkBaseStateMachine.Source.Init;
    L11:
        r0.onFinish(r1, r2, r3);
    }
}
