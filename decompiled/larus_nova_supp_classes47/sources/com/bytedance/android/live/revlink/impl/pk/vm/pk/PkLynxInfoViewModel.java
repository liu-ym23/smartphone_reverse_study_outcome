package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.android.livesdk.link.model.bridge.o;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.v;
import com.bytedance.android.livesdk.link.model.c2;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.link.model.q9;
import com.bytedance.android.livesdk.link.model.r9;
import com.bytedance.android.livesdk.link.model.s9;
import com.bytedance.android.livesdk.link.model.t0;
import com.bytedance.android.livesdk.link.model.t9;
import com.bytedance.android.livesdk.link.model.w4;
import com.bytedance.android.livesdk.link.model.x4;
import com.bytedance.android.livesdk.message.model.s8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0004WZ]`\u0018\u0000 x2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001yB5\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010j\u001a\u0004\u0018\u00010i\u0012\b\u0010m\u001a\u0004\u0018\u00010l\u0012\b\u0010p\u001a\u0004\u0018\u00010o¢\u0006\u0004\bv\u0010wJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\u0012\u0010\u001d\u001a\u00020\u00062\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001bJ\b\u0010\u001e\u001a\u00020\u0006H\u0016R$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001fj\b\u0012\u0004\u0012\u00020\u000f` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000f0#j\b\u0012\u0004\u0012\u00020\u000f`$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020)0\u001fj\b\u0012\u0004\u0012\u00020)` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\"R*\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0#j\b\u0012\u0004\u0012\u00020)`$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001fj\b\u0012\u0004\u0012\u00020\b` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\"R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u001fj\b\u0012\u0004\u0012\u00020\u0013` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\"R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00130#j\b\u0012\u0004\u0012\u00020\u0013`$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u0010(R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001fj\b\u0012\u0004\u0012\u00020\f` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010\"R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\f0#j\b\u0012\u0004\u0012\u00020\f`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R@\u0010:\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0706j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020)07j\b\u0012\u0004\u0012\u00020)`9`88\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R*\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000406j\b\u0012\u0004\u0012\u00020\u0004`88\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b?\u0010=R*\u0010@\u001a\u0012\u0012\u0004\u0012\u00020)06j\b\u0012\u0004\u0012\u00020)`88\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=RB\u0010C\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0B06j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0B`88\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010;\u001a\u0004\bD\u0010=R\u0018\u0010G\u001a\u00060Ej\u0002`F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010M\u001a\n\u0018\u00010Kj\u0004\u0018\u0001`L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010JR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u0004\u0018\u00010i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010m\u001a\u0004\u0018\u00010l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u0004\u0018\u00010o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u0004\u0018\u00010r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006z"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/ViewModel;", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/e;", "", "trigger", "", "setTopSecKillTrigger", "Lcom/bytedance/android/livesdk/link/model/r9;", "teamTaskInfo", "", "calculateTeamTaskRatio", "", Constants.OperatorKey.KEY_COST_TIME, "handleTimeLeft", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/g;", "state", "updateTeamTaskState", "resetData", "Lcom/bytedance/android/livesdk/link/model/ITeamTask;", "getTeamTask", "getTeamTaskRatio", "ratio", "setTeamTaskRatio", "getTopSecKillTrigger", "onCleared", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "clearIt", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_pkTeamTaskState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "pkTeamTaskState", "Landroidx/lifecycle/LiveData;", "getPkTeamTaskState", "()Landroidx/lifecycle/LiveData;", "", "_pkTeamTaskLynxData", "pkTeamTaskLynxData", "getPkTeamTaskLynxData", "_pkTeamTaskInfo", "_pkTeamTask", "pkTeamTask", "getPkTeamTask", "_pkTeamTaskResult", "pkTeamTaskResult", "teamTaskRewardBeginSecond", "J", "teamTaskRewardEndSecond", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Ljava/util/ArrayList;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "Lkotlin/collections/ArrayList;", "handlePkConsecutiveWin", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getHandlePkConsecutiveWin", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "handleTeamTaskOverLine", "getHandleTeamTaskOverLine", "handleBattlePowerMessage", "getHandleBattlePowerMessage", "", "handleFirstUpdateMessage", "getHandleFirstUpdateMessage", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "isAnchor", "Z", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "teamTask", "Lcom/bytedance/android/livesdk/link/model/ITeamTask;", "teamTaskRatio", "F", "topSecKillTrigger", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkTeamTaskStateMachine;", "stateMachine", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkTeamTaskStateMachine;", "com/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$pkStateObserver$1", "pkStateObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$pkStateObserver$1;", "com/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$timeLeftObserver$1", "timeLeftObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$timeLeftObserver$1;", "com/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$battleStatsMetaObserver$1", "battleStatsMetaObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$battleStatsMetaObserver$1;", "com/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$pkTeamTaskResultObserver$1", "pkTeamTaskResultObserver", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/PkLynxInfoViewModel$pkTeamTaskResultObserver$1;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "pkBaseDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/c;", "pkDataContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/c;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "<init>", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/c;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkLynxInfoViewModel extends ViewModel implements e {
    public static final a Companion = null;
    public static final long PK_TEAM_TASK_RESULT_FAILURE = 2;
    public static final long PK_TEAM_TASK_RESULT_SUCCEED = 1;
    public static final String TAG = "PkLynxInfoViewModel";
    private final MutableLiveData<ITeamTask> _pkTeamTask;
    private final MutableLiveData<r9> _pkTeamTaskInfo;
    private final MutableLiveData<String> _pkTeamTaskLynxData;
    private final MutableLiveData<Long> _pkTeamTaskResult;
    private final MutableLiveData<g> _pkTeamTaskState;
    private final PkLynxInfoViewModel$battleStatsMetaObserver$1 battleStatsMetaObserver;
    private final CompositeDisposable cd;
    private final NextLiveData<String> handleBattlePowerMessage;
    private final NextLiveData<Map<String, String>> handleFirstUpdateMessage;
    private final NextLiveData<ArrayList<String>> handlePkConsecutiveWin;
    private final NextLiveData<Boolean> handleTeamTaskOverLine;
    private final boolean isAnchor;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;
    private final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e pkBaseDataContext;
    private final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c pkDataContext;
    private final PkLynxInfoViewModel$pkStateObserver$1 pkStateObserver;
    private final LiveData<ITeamTask> pkTeamTask;
    private final LiveData<String> pkTeamTaskLynxData;
    private final LiveData<Long> pkTeamTaskResult;
    private final PkLynxInfoViewModel$pkTeamTaskResultObserver$1 pkTeamTaskResultObserver;
    private final LiveData<g> pkTeamTaskState;
    private final IRoom room;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final PkTeamTaskStateMachine stateMachine;
    private ITeamTask teamTask;
    private float teamTaskRatio;
    private long teamTaskRewardBeginSecond;
    private long teamTaskRewardEndSecond;
    private final PkLynxInfoViewModel$timeLeftObserver$1 timeLeftObserver;
    private boolean topSecKillTrigger;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.PkLynxInfoViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(PkLynxInfoViewModel r8) {
            super(1, r8, PkLynxInfoViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((PkLynxInfoViewModel) ((CallableReference) this).receiver).onMessage(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.PkLynxInfoViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkLynxInfoViewModel r8) {
            super(1, r8, PkLynxInfoViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((PkLynxInfoViewModel) ((CallableReference) this).receiver).onMessage(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.PkLynxInfoViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass3(PkLynxInfoViewModel r8) {
            super(1, r8, PkLynxInfoViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((PkLynxInfoViewModel) ((CallableReference) this).receiver).onMessage(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.PkLynxInfoViewModel$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass4(PkLynxInfoViewModel r8) {
            super(1, r8, PkLynxInfoViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((PkLynxInfoViewModel) ((CallableReference) this).receiver).onMessage(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    private final void resetData() {
        this._pkTeamTaskLynxData.setValue(null);
        this._pkTeamTaskInfo.setValue(null);
        this._pkTeamTask.setValue(null);
        this._pkTeamTaskResult.setValue(0L);
    }

    public void onCleared() {
        super.onCleared();
        this.pkBaseDataContext.getPkBaseState().removeObserver(this.pkStateObserver);
        this.pkBaseDataContext.getBaseTimeLeft().removeObserver(this.timeLeftObserver);
        this.pkBaseDataContext.getBattleStatsMeta().removeObserver(this.battleStatsMetaObserver);
        this.pkTeamTaskResult.removeObserver(this.pkTeamTaskResultObserver);
        this.cd.clear();
    }

    public void clearIt() {
        onCleared();
    }

    public NextLiveData<String> getHandleBattlePowerMessage() {
        return this.handleBattlePowerMessage;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public NextLiveData<Map<String, String>> getHandleFirstUpdateMessage() {
        return this.handleFirstUpdateMessage;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public NextLiveData<ArrayList<String>> getHandlePkConsecutiveWin() {
        return this.handlePkConsecutiveWin;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public NextLiveData<Boolean> getHandleTeamTaskOverLine() {
        return this.handleTeamTaskOverLine;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public LiveData<ITeamTask> getPkTeamTask() {
        return this.pkTeamTask;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public LiveData<String> getPkTeamTaskLynxData() {
        return this.pkTeamTaskLynxData;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public LiveData<g> getPkTeamTaskState() {
        return this.pkTeamTaskState;
    }

    public ITeamTask getTeamTask() {
        return this.teamTask;
    }

    public float getTeamTaskRatio() {
        return this.teamTaskRatio;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public boolean getTopSecKillTrigger() {
        return this.topSecKillTrigger;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.mergepk.pkbase.e access$getPkBaseDataContext$p(PkLynxInfoViewModel r0) {
        return r0.pkBaseDataContext;
    }

    public static final /* synthetic */ w31.c access$getPkLinkUtils$p(PkLynxInfoViewModel r0) {
        return r0.getPkLinkUtils();
    }

    public static final /* synthetic */ IRoom access$getRoom$p(PkLynxInfoViewModel r0) {
        return r0.room;
    }

    public static final /* synthetic */ PkTeamTaskStateMachine access$getStateMachine$p(PkLynxInfoViewModel r0) {
        return r0.stateMachine;
    }

    public static final /* synthetic */ ITeamTask access$getTeamTask$p(PkLynxInfoViewModel r0) {
        return r0.teamTask;
    }

    public static final /* synthetic */ float access$getTeamTaskRatio$p(PkLynxInfoViewModel r0) {
        return r0.teamTaskRatio;
    }

    public static final /* synthetic */ long access$getTeamTaskRewardBeginSecond$p(PkLynxInfoViewModel r2) {
        return r2.teamTaskRewardBeginSecond;
    }

    public static final /* synthetic */ long access$getTeamTaskRewardEndSecond$p(PkLynxInfoViewModel r2) {
        return r2.teamTaskRewardEndSecond;
    }

    public static final /* synthetic */ MutableLiveData access$get_pkTeamTask$p(PkLynxInfoViewModel r0) {
        return r0._pkTeamTask;
    }

    public static final /* synthetic */ MutableLiveData access$get_pkTeamTaskInfo$p(PkLynxInfoViewModel r0) {
        return r0._pkTeamTaskInfo;
    }

    public static final /* synthetic */ MutableLiveData access$get_pkTeamTaskLynxData$p(PkLynxInfoViewModel r0) {
        return r0._pkTeamTaskLynxData;
    }

    public static final /* synthetic */ MutableLiveData access$get_pkTeamTaskResult$p(PkLynxInfoViewModel r0) {
        return r0._pkTeamTaskResult;
    }

    public static final /* synthetic */ MutableLiveData access$get_pkTeamTaskState$p(PkLynxInfoViewModel r0) {
        return r0._pkTeamTaskState;
    }

    public static final /* synthetic */ void access$resetData(PkLynxInfoViewModel r0) {
        r0.resetData();
    }

    private final float calculateTeamTaskRatio(r9 r7) {
        if (r7 != null) goto L5;
        return 0.0f;
    L5:
        int r1 = r7.getRole();
        if (r1 != ITeamTask.Role.RoleAttacker.ordinal()) goto L9;
        return (r7.getRatio() * 1.0f) / (r7.getRatio() + ((long) 100));
    L9:
        if (r1 == ITeamTask.Role.RoleDefender.ordinal()) goto L11;
        return 0.0f;
    L11:
        return 1 - ((r7.getRatio() * 1.0f) / (r7.getRatio() + ((long) 100)));
    }

    private final void handleTimeLeft(long r12) {
        LiveData<ITeamTask> r0 = getPkTeamTask();
        if (r0 == null) goto L96;
        ITeamTask r1 = (ITeamTask) r0.getValue();
        if (r1 == null) goto L97;
        q9 r2 = r1.getTeamTaskConfig();
        if (r2 == null) goto L98;
        Map r3 = r2.getTeamTaskPeriodConfig();
        if (r3 == null) goto L99;
        ITeamTask.Period r4 = ITeamTask.Period.PeriodTips;
        s9 r5 = (s9) r3.get(Long.valueOf(r4.ordinal()));
        long r6 = 0;
        if (r5 == null) goto L13;
        long r7 = r5.getEndSecond();
    L15:
        if (r12 <= r7) goto L23;
        s9 r8 = (s9) r3.get(Long.valueOf(r4.ordinal()));
        if (r8 == null) goto L19;
        long r9 = r8.getBeginSecond();
    L21:
        if (r12 > r9) goto L23;
        this.stateMachine.a(h.b.a);
        return;
    L19:
        r9 = 0;
    L23:
        ITeamTask.Period r10 = ITeamTask.Period.PeriodNotice;
        s9 r13 = (s9) r3.get(Long.valueOf(r10.ordinal()));
        if (r13 == null) goto L26;
        long r14 = r13.getEndSecond();
    L28:
        if (r12 <= r14) goto L36;
        s9 r15 = (s9) r3.get(Long.valueOf(r10.ordinal()));
        if (r15 == null) goto L32;
        long r16 = r15.getBeginSecond();
    L34:
        if (r12 > r16) goto L36;
        this.stateMachine.a(new h.f(0));
        return;
    L32:
        r16 = 0;
    L36:
        ITeamTask.Period r17 = ITeamTask.Period.PeriodTask;
        s9 r18 = (s9) r3.get(Long.valueOf(r17.ordinal()));
        if (r18 == null) goto L39;
        long r19 = r18.getEndSecond();
    L41:
        if (r12 <= r19) goto L49;
        s9 r20 = (s9) r3.get(Long.valueOf(r17.ordinal()));
        if (r20 == null) goto L45;
        long r22 = r20.getBeginSecond();
    L47:
        if (r12 > r22) goto L49;
        this.stateMachine.a(h.C0192h.a);
        return;
    L45:
        r22 = 0;
    L49:
        long r23 = this.teamTaskRewardEndSecond;
        long r24 = this.teamTaskRewardBeginSecond;
        if (r23 <= r12) goto L53;
    L74:
        s9 r25 = (s9) r3.get(Long.valueOf(r17.ordinal()));
        if (r25 == null) goto L78;
        r6 = r25.getEndSecond();
    L78:
        if (r12 > (r6 - 5)) goto L85;
        Long r26 = (Long) this.pkTeamTaskResult.getValue();
        if (r26 != null) goto L83;
    L84:
        this.stateMachine.a(h.c.a);
        return;
    L83:
        if (r26.longValue() != 1) goto L84;
    L85:
        long r27 = this.teamTaskRewardEndSecond;
        if (r12 <= r27) goto L88;
        return;
    L88:
        if (r12 < (r27 - 3)) goto L106;
        Long r110 = (Long) this.pkTeamTaskResult.getValue();
        if (r110 != null) goto L93;
        return;
    L93:
        if (r110.longValue() != 1) goto L107;
        this.stateMachine.a(h.a.a);
        return;
    L107:
        return;
    L106:
        return;
    L53:
        if (r24 < r12) goto L74;
        ITeamTask r28 = (ITeamTask) getPkTeamTask().getValue();
        if (r28 == null) goto L60;
        q9 r29 = r28.getTeamTaskConfig();
        if (r29 == null) goto L60;
        if (r29.getTaskType() == ITeamTask.Type.TypeInstantKill.ordinal()) goto L74;
    L60:
        Long r30 = (Long) this.pkTeamTaskResult.getValue();
        if (r30 == null) goto L74;
        if (r30.longValue() != 1) goto L74;
        ITeamTask r32 = (ITeamTask) getPkTeamTask().getValue();
        if (r32 == null) goto L73;
        q9 r33 = r32.getTeamTaskConfig();
        if (r33 == null) goto L73;
        if (r33.getTaskType() != ITeamTask.Type.TypeFansClubUserCount.ordinal()) goto L73;
        if ((this.teamTaskRewardBeginSecond - r12) > 1) goto L74;
    L73:
        this.stateMachine.a(h.e.a);
        return;
    L39:
        r19 = 0;
        goto L41
    L26:
        r14 = 0;
        goto L28
    L13:
        r7 = 0;
        goto L15
    L99:
        return;
    L98:
        return;
    L97:
        return;
    }

    private final void setTopSecKillTrigger(boolean r1) {
        this.topSecKillTrigger = r1;
    }

    private final void updateTeamTaskState(g r4) {
        Long r1 = 0L;
        if (Intrinsics.areEqual(r4, g.e.b) == false) goto L10;
        Long r5 = (Long) this.pkBaseDataContext.getBaseTimeLeft().getValue();
        if (r5 == null) goto L8;
        r1 = r5;
    L8:
        r1.longValue();
        return;
    L10:
        if (Intrinsics.areEqual(r4, g.h.b) == false) goto L28;
        Long r6 = (Long) this.pkBaseDataContext.getBaseTimeLeft().getValue();
        if (r6 == null) goto L15;
        r1 = r6;
    L15:
        r1.longValue();
        LiveData<ITeamTask> r7 = getPkTeamTask();
        if (r7 == null) goto L29;
        ITeamTask r8 = (ITeamTask) r7.getValue();
        if (r8 == null) goto L30;
        q9 r9 = r8.getTeamTaskConfig();
        if (r9 == null) goto L31;
        Map r10 = r9.getTeamTaskPeriodConfig();
        if (r10 == null) goto L32;
        s9 r12 = (s9) r10.get(Long.valueOf(ITeamTask.Period.PeriodTask.ordinal()));
        if (r12 == null) goto L33;
        r12.getEndSecond();
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void onMessage(yh6.c r7) {
        Intrinsics.checkNotNullParameter(r7, "_message");
        String r1 = null;
        if ((r7 instanceof u0) == false) goto L38;
        g5 r8 = ((vh7.c) r7).castTo(g5.class);
        this._pkTeamTaskLynxData.setValue(r8.getTeamTaskJson());
        ITeamTask r9 = r8.getTeamTask();
        if (r9 == null) goto L83;
        this.teamTask = r9;
        this._pkTeamTask.setValue(r9);
        q9 r0 = r9.getTeamTaskConfig();
        if (r0 != null) goto L9;
    L11:
        Map r10 = r9.getTeamTaskInfoMap();
        if (r10 == null) goto L17;
        IRoom r2 = this.room;
        if (r2 == null) goto L16;
        r1 = IRoomKt_androidKt.getAnchorId(r2);
    L16:
        r1 = (r9) r10.get(String.valueOf(r1));
    L17:
        if (r1 == null) goto L84;
        this._pkTeamTaskInfo.setValue(r1);
        this._pkTeamTaskResult.setValue(Long.valueOf(r1.getTeamTaskResult()));
        t9 r12 = r1.getTeamTaskReward();
        if (r12 != null) goto L21;
    L22:
        t9 r13 = r1.getTeamTaskReward();
        if (r13 == null) goto L25;
        long r4 = r13.getBeginSecond();
    L26:
        this.teamTaskRewardBeginSecond = r4;
    L27:
        t9 r14 = r1.getTeamTaskReward();
        if (r14 != null) goto L30;
    L31:
        t9 r15 = r1.getTeamTaskReward();
        if (r15 == null) goto L34;
        long r3 = r15.getEndSecond();
    L35:
        this.teamTaskRewardEndSecond = r3;
    L36:
        this.teamTaskRatio = calculateTeamTaskRatio(r1);
        return;
    L34:
        r3 = 90;
        goto L35
    L30:
        if (r14.getEndSecond() == 0) goto L36;
    L25:
        r4 = 120;
        goto L26
    L21:
        if (r12.getBeginSecond() == 0) goto L27;
    L84:
        return;
    L9:
        if (r0.getTaskType() != ITeamTask.Type.TypeSummitInstantKill.ordinal()) goto L11;
        setTopSecKillTrigger(true);
        goto L11
    L83:
        return;
    L38:
        if ((r7 instanceof v) == false) goto L45;
        c2 r16 = ((vh7.c) r7).castTo(c2.class);
        if (r16 == null) goto L86;
        String r17 = r16.getBattlePowerContainerInfo();
        if (r17 == null) goto L87;
        getHandleBattlePowerMessage().postValue(r17);
        return;
    L87:
        return;
    L86:
        return;
    L45:
        if ((r7 instanceof s8) == false) goto L80;
        PkBaseStateMachine.c r5 = this.pkBaseDataContext.getCurPKBaseState();
        r5.getClass();
        if ((r5 instanceof PkBaseStateMachine.c.C0130c) == false) goto L89;
        w4 r18 = ((vh7.c) r7).castTo(w4.class);
        if (r18 == null) goto L90;
        String r6 = r18.getTopShowText();
        if (r6 == null) goto L91;
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("content_desc", r6);
        List r20 = x4.a(r18);
        if (r20 == null) goto L55;
        int r22 = ((ArrayList) r20).size();
    L56:
        if (r22 <= 0) goto L78;
        List r23 = x4.a(r18);
        if (r23 == null) goto L63;
        String r24 = (h7) ListProtector.get(r23, 0);
        if (r24 == null) goto L63;
        r1 = r24;
    L63:
        if (r1 == null) goto L67;
        List r25 = r1.getRankList();
        if (r25 == null) goto L67;
        int r26 = r25.size();
    L68:
        if (r26 <= 0) goto L78;
        if (r1 == null) goto L76;
        List r27 = r1.getRankList();
        if (r27 == null) goto L76;
        h7.b r28 = (h7.b) ListProtector.get(r27, 0);
        if (r28 == null) goto L76;
        String r29 = r28.getUserId();
        if (r29 == null) goto L76;
    L77:
        r19.put("first_user_id", r29);
    L76:
        r29 = "";
    L67:
        r26 = 0;
    L78:
        getHandleFirstUpdateMessage().postValue(r19);
        return;
    L55:
        r22 = 0;
        goto L56
    L91:
        return;
    L90:
        return;
    L89:
        return;
    L80:
        if ((r7 instanceof o) == false) goto L93;
        t0 r30 = ((vh7.c) r7).castTo(t0.class);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vm.pk.e
    public void setTeamTaskRatio(float r1) {
        this.teamTaskRatio = r1;
    }

    public static final /* synthetic */ float access$calculateTeamTaskRatio(PkLynxInfoViewModel r0, r9 r1) {
        return r0.calculateTeamTaskRatio(r1);
    }

    public static final /* synthetic */ void access$handleTimeLeft(PkLynxInfoViewModel r0, long r1) {
        r0.handleTimeLeft(r1);
    }

    public static final /* synthetic */ void access$setTeamTask$p(PkLynxInfoViewModel r0, ITeamTask r1) {
        r0.teamTask = r1;
    }

    public static final /* synthetic */ void access$setTeamTaskRatio$p(PkLynxInfoViewModel r0, float r1) {
        r0.teamTaskRatio = r1;
    }

    public static final /* synthetic */ void access$setTeamTaskRewardBeginSecond$p(PkLynxInfoViewModel r0, long r1) {
        r0.teamTaskRewardBeginSecond = r1;
    }

    public static final /* synthetic */ void access$setTeamTaskRewardEndSecond$p(PkLynxInfoViewModel r0, long r1) {
        r0.teamTaskRewardEndSecond = r1;
    }

    public static final /* synthetic */ void access$setTopSecKillTrigger(PkLynxInfoViewModel r0, boolean r1) {
        r0.setTopSecKillTrigger(r1);
    }

    public static final /* synthetic */ void access$updateTeamTaskState(PkLynxInfoViewModel r0, g r1) {
        r0.updateTeamTaskState(r1);
    }

    public PkLynxInfoViewModel(com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r10, com.bytedance.android.livesdk.revenue.service.room.c r12, com.bytedance.android.live.revlink.impl.global.c r13, yz0.f r14) {
        Intrinsics.checkNotNullParameter(r9, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r10, "pkDataContext");
        this.pkBaseDataContext = r9;
        this.pkDataContext = r10;
        this.roomService = r12;
        this.linkFakeGlobalService = r13;
        this.messageService = r14;
        MutableLiveData<g> r15 = new MutableLiveData();
        this._pkTeamTaskState = r15;
        this.pkTeamTaskState = r15;
        MutableLiveData<String> r16 = new MutableLiveData();
        this._pkTeamTaskLynxData = r16;
        this.pkTeamTaskLynxData = r16;
        this._pkTeamTaskInfo = new MutableLiveData();
        MutableLiveData<ITeamTask> r17 = new MutableLiveData();
        this._pkTeamTask = r17;
        this.pkTeamTask = r17;
        MutableLiveData<Long> r18 = new MutableLiveData();
        this._pkTeamTaskResult = r18;
        this.pkTeamTaskResult = r18;
        this.teamTaskRewardBeginSecond = 120;
        this.teamTaskRewardEndSecond = 90;
        this.handlePkConsecutiveWin = new NextLiveData();
        this.handleTeamTaskOverLine = new NextLiveData();
        this.handleBattlePowerMessage = new NextLiveData();
        this.handleFirstUpdateMessage = new NextLiveData();
        CompositeDisposable r19 = new CompositeDisposable();
        this.cd = r19;
        if (r12 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r12.getRoomContext();
        if (r1 == null) goto L7;
        boolean r2 = r1.getCommonIsAnchor();
    L8:
        this.isAnchor = r2;
        if (r12 == null) goto L13;
        com.bytedance.android.livesdk.revenue.room.a r110 = r12.getRoomContext();
        if (r110 == null) goto L13;
        IRoomBase r111 = r110.getCommonRoom();
    L14:
        this.room = (IRoom) r111;
        this.stateMachine = new PkTeamTaskStateMachine(new PkLynxInfoViewModel$stateMachine$1(this));
        Observer r112 = new PkLynxInfoViewModel$pkStateObserver$1(this);
        this.pkStateObserver = r112;
        Observer r3 = new PkLynxInfoViewModel$timeLeftObserver$1(this);
        this.timeLeftObserver = r3;
        Observer r4 = new PkLynxInfoViewModel$battleStatsMetaObserver$1(this);
        this.battleStatsMetaObserver = r4;
        Observer r5 = new PkLynxInfoViewModel$pkTeamTaskResultObserver$1(this);
        this.pkTeamTaskResultObserver = r5;
        if (r14 == null) goto L21;
        Observable r6 = yz0.h.a.a(r14, CommonMessageTypeKt.c(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r6 == null) goto L21;
        final AnonymousClass1 r7 = new AnonymousClass1(this);
        Disposable r8 = r6.subscribe(new b(r7));
        if (r8 == null) goto L21;
        com.bytedance.revenue.platform.api.core.rx.f.a(r8, r19);
    L21:
        if (r14 == null) goto L27;
        com.bytedance.android.live.revenue.common.message.a r20 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r22 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r20, "$this$BATTLE_POWER_CONTAINER_MESSAGE");
        Observable r23 = yz0.h.a.a(r14, (yh6.b) CommonMessageTypeKt.o.getValue(), false, 6);
        if (r23 == null) goto L27;
        final AnonymousClass2 r24 = new AnonymousClass2(this);
        Disposable r25 = r23.subscribe(new b(r24));
        if (r25 == null) goto L27;
        com.bytedance.revenue.platform.api.core.rx.f.a(r25, r19);
    L27:
        if (r14 == null) goto L33;
        com.bytedance.android.live.revenue.common.message.a r26 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r27 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r26, "$this$LINK_MIC_ARMIES");
        Observable r28 = yz0.h.a.a(r14, (yh6.b) CommonMessageTypeKt.y.getValue(), false, 6);
        if (r28 == null) goto L33;
        final AnonymousClass3 r29 = new AnonymousClass3(this);
        Disposable r30 = r28.subscribe(new b(r29));
        if (r30 == null) goto L33;
        com.bytedance.revenue.platform.api.core.rx.f.a(r30, r19);
    L33:
        if (r14 == null) goto L39;
        com.bytedance.android.live.revenue.common.message.a r32 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r33 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r32, "$this$BATTLE_AUXILIARY_MESSAGE");
        Observable r113 = yz0.h.a.a(r14, (yh6.b) CommonMessageTypeKt.z.getValue(), false, 6);
        if (r113 == null) goto L39;
        final AnonymousClass4 r0 = new AnonymousClass4(this);
        Disposable r114 = r113.subscribe(new b(r0));
        if (r114 == null) goto L39;
        com.bytedance.revenue.platform.api.core.rx.f.a(r114, r19);
    L39:
        r9.getPkBaseState().observeForever(r112);
        r9.getBaseTimeLeft().observeForever(r3);
        r9.getBattleStatsMeta().observeForever(r4);
        r18.observeForever(r5);
        return;
    L13:
        r111 = null;
    L7:
        r2 = false;
        goto L8
    }
}
