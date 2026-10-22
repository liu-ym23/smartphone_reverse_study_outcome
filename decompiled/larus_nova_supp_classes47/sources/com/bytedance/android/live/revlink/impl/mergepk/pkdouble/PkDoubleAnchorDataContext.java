package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import androidx.lifecycle.LiveData;
import c21.k;
import c21.l;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.h;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.mergepk.params.LinkmicBizType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h6;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ª\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\b«\u0001¬\u0001\u00ad\u0001®\u0001B\u008f\u0001\u0012\u0007\u0010\u0098\u0001\u001a\u00020'\u0012\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001\u0012\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001\u0012\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u0001\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\n\u0010¡\u0001\u001a\u0005\u0018\u00010 \u0001\u0012\n\u0010£\u0001\u001a\u0005\u0018\u00010¢\u0001\u0012\n\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u0001\u0012\u0006\u0010S\u001a\u00020R\u0012\f\b\u0002\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001¢\u0006\u0006\b¨\u0001\u0010©\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J*\u0010+\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016J2\u00100\u001a\u00020\t2\u0006\u0010,\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016J \u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00132\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016J\"\u00104\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u0001022\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0016R\u0018\u0010:\u001a\u000608j\u0002`98\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0017\u0010=\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010BR\u0014\u0010F\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010BR\u0014\u0010G\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010BR\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010BR\u0016\u0010I\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010BR\u0019\u0010K\u001a\u0004\u0018\u00010J8\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0016\u0010P\u001a\u0004\u0018\u00010O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001a\u0010S\u001a\u00020R8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010Z\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0016\u0010^\u001a\u0004\u0018\u00010[8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0016\u0010b\u001a\u0004\u0018\u00010_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0016\u0010f\u001a\u0004\u0018\u00010c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010j\u001a\u0004\u0018\u00010g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010n\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010r\u001a\u0004\u0018\u00010o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0016\u0010v\u001a\u0004\u0018\u00010s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0016\u0010z\u001a\u0004\u0018\u00010w8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0016\u0010~\u001a\u0004\u0018\u00010{8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0019\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0083\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001a\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u0091\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R+\u0010\u0097\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0093\u00010\u0092\u0001j\n\u0012\u0005\u0012\u00030\u0093\u0001`\u0094\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001¨\u0006¯\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/a;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/b;", "Lcom/bytedance/android/live/revlink/link/biz/service/j;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/launcher/a;", "getPkAnchorLauncher", "", "getToken", "", "openBattleWhenLink", "openBattleWhenSwitch", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "Lcom/bytedance/android/livesdk/link/model/i6;", "message", "onLinkerMessage", "", "isCutShort", "", "reason", "isFinish", "isRoomClose", "finishBattle", "reportUiFirstLoad", "attach", "resetPeakData", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext$BattleOpenSource;", "requestSource", "pkOptOpenBattle", "logGameConnectionSuccess", "Lcom/bytedance/android/livesdk/link/model/p0;", "getLaunchBattleAttachedInfo", "pkBizOptOpenBattle", "inviteType", "Lcom/bytedance/android/livesdk/link/model/w2;", "battleShellConfig", "", "stayDuration", "Lcom/bytedance/android/live/revlink/impl/pk/utils/l;", "pageSource", "inviteBattle", "durationTime", "Lcom/bytedance/android/livesdk/link/model/aa;", "voteData", "isOnceMore", "startVoteBattleInvite", "startBreakThroughInvite", "Lcom/bytedance/android/livesdk/link/model/d4;", "customConfig", "startCustomizePlay", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/a;", "battleInviteParam", "startBattleInvite", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "doublePkContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "getDoublePkContext", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "mHasOpenBattle", "Z", "peakSwitchPlayMode", "Ljava/lang/Integer;", "isToVoteInPeak", "isToLinkInPeak", "canStartPkByDefault", "mFirstRemoteFrameRender", "mAllJoinChannel", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/c;", "pkAnchorLaunchContext", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/c;", "getPkAnchorLaunchContext", "()Lcom/bytedance/android/live/revlink/impl/control/launchcontext/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/a;", "context", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/a;", "getContext", "()Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/a;", "Lcom/bytedance/android/live/revenuelink/connect/g;", "getAnchorConnectUtils", "()Lcom/bytedance/android/live/revenuelink/connect/g;", "anchorConnectUtils", "Li41/a;", "getAutoMatchManager", "()Li41/a;", "autoMatchManager", "Lcom/bytedance/android/live/revlink/impl/monitor/LiveFullLinkPKMonitor;", "getLiveFullLinkPKMonitor", "()Lcom/bytedance/android/live/revlink/impl/monitor/LiveFullLinkPKMonitor;", "liveFullLinkPKMonitor", "Le21/b;", "getClientAttachedInfoObj", "()Le21/b;", "clientAttachedInfoObj", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "Lcom/bytedance/android/live/revlink/impl/pk/utils/q;", "getPkUtils", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/q;", "pkUtils", "Ld21/d;", "getMergePkHelper", "()Ld21/d;", "mergePkHelper", "Ld31/d;", "getRevLinkLogHelper", "()Ld31/d;", "revLinkLogHelper", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/f;", "getLinkPlayHelper", "()Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/f;", "linkPlayHelper", "Lcom/bytedance/android/live/revlink/impl/pk/service/c;", "getPKCustomizePlayDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/c;", "pKCustomizePlayDataService", "Lcom/bytedance/android/live/revlink/impl/pk/utils/j;", "getPKInviteControlUtils", "()Lcom/bytedance/android/live/revlink/impl/pk/utils/j;", "pKInviteControlUtils", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "getPKLinkBizDataService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/IPKLinkBizDataService;", "pKLinkBizDataService", "Lcom/bytedance/android/live/revlink/impl/pk/service/e;", "getPKPrecisionMatchService", "()Lcom/bytedance/android/live/revlink/impl/pk/service/e;", "pKPrecisionMatchService", "Lc21/f;", "getCurBattlePlayMode", "()Lc21/f;", "curBattlePlayMode", "getCurDuration", "()I", "curDuration", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getPkBaseState", "()Landroidx/lifecycle/LiveData;", "pkBaseState", "channelId", "guestUid", "Lld/a;", "linkDataSet", "Lwq2/f;", "dataCenterService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lyz0/f;", "messageService", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "messageManagerService", "Lx11/a;", "internalLinkService", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "extraBaseDataContext", "<init>", "(JLjava/lang/String;Lcom/bytedance/android/live/revlink/impl/control/launchcontext/c;Lld/a;Lwq2/f;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lcom/bytedance/android/livesdk/revenue/service/message/d;Lx11/a;Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/a;Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;)V", "Companion", "BattleOpenSource", "b", "c", "d", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkDoubleAnchorDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b, j {
    public static final b Companion = null;
    public static final String TAG = "ttlive_PkDoubleAnchorDataContext";
    private final boolean canStartPkByDefault;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a context;
    private final PkDoubleDataContext doublePkContext;
    private final boolean isToLinkInPeak;
    private final boolean isToVoteInPeak;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private boolean mAllJoinChannel;
    private boolean mFirstRemoteFrameRender;
    private boolean mHasOpenBattle;
    private final Integer peakSwitchPlayMode;
    private final com.bytedance.android.live.revlink.impl.control.launchcontext.c pkAnchorLaunchContext;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkDoubleAnchorDataContext r8) {
            super(1, r8, PkDoubleAnchorDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(yh6.c r2) {
            PkDoubleAnchorDataContext.access$onMessage((PkDoubleAnchorDataContext) ((CallableReference) this).receiver, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAnchorDataContext$BattleOpenSource;", "", "JoinChannel", "FirstFrame", "ReplySEI", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleOpenSource extends Enum<BattleOpenSource> {
        public static final BattleOpenSource FirstFrame = null;
        public static final BattleOpenSource JoinChannel = null;
        public static final BattleOpenSource ReplySEI = null;
        public static final /* synthetic */ BattleOpenSource[] a = null;

        static {
            BattleOpenSource r1 = new BattleOpenSource("JoinChannel", 0);
            JoinChannel = r1;
            BattleOpenSource r2 = new BattleOpenSource("FirstFrame", 1);
            FirstFrame = r2;
            BattleOpenSource r3 = new BattleOpenSource("ReplySEI", 2);
            ReplySEI = r3;
            a = new BattleOpenSource[]{r1, r2, r3};
        }

        public static BattleOpenSource valueOf(String r1) {
            return (BattleOpenSource) r27.a.a(BattleOpenSource.class, r1);
        }

        public static BattleOpenSource[] values() {
            return (BattleOpenSource[]) a.clone();
        }

        public BattleOpenSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkDoubleAnchorDataContext a;

        public a(PkDoubleAnchorDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            PkDoubleAnchorDataContext.access$getCd$p(this.a).dispose();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {
        public final IBattleConfigSetting a;
        public final v3 b;

        public c() {
            this(null, 3);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L10;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            IBattleConfigSetting r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            v3 r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CustomizePlay(selfData=" + this.a + ", clientAttachedInfo=" + this.b + ")";
        }

        public c(IBattleConfigSetting r2, int r3) {
            if ((r3 & 1) == 0) goto L5;
            r2 = null;
        L5:
            this.a = r2;
            this.b = null;
        }
    }

    public static final class d {
        public final long a;
        public final aa b;
        public final v3 c;

        public d() {
            this(0, null, 7);
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof d) == false) goto L12;
            d r7 = (d) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            aa r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            v3 r6 = this.c;
            if (r6 == null) goto L10;
            r3 = r6.hashCode();
        L10:
            return r5 + r3;
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "VoteOpenData(duration=" + this.a + ", voteSetting=" + this.b + ", clientAttachedInfo=" + this.c + ")";
        }

        public d(long r2, aa r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 300;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            this.a = r2;
            this.b = r4;
            this.c = null;
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void attach() {
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void reportUiFirstLoad() {
    }

    private final com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorConnectUtils();
    }

    private final i41.a getAutoMatchManager() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAutoMatchManager();
    }

    private final e21.b getClientAttachedInfoObj() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getClientAttachedInfoObj();
    }

    private final c21.f getCurBattlePlayMode() {
        return this.doublePkContext.getBasePKContext().getCurBattlePlayMode();
    }

    private final int getCurDuration() {
        return this.doublePkContext.getBasePKContext().getCurDuration();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f getLinkPlayHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkPlayHelper();
    }

    private final LiveFullLinkPKMonitor getLiveFullLinkPKMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    private final d21.d getMergePkHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMergePkHelper();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.c getPKCustomizePlayDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Yi();
    }

    private final com.bytedance.android.live.revlink.impl.pk.utils.j getPKInviteControlUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPKInviteControlUtils();
    }

    private final IPKLinkBizDataService getPKLinkBizDataService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    private final com.bytedance.android.live.revlink.impl.pk.service.e getPKPrecisionMatchService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.lo();
    }

    private final com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a getPkAnchorLauncher() {
        return this.doublePkContext.getBasePKContext().getPkAnchorLauncher();
    }

    private final LiveData<PkBaseStateMachine.c> getPkBaseState() {
        return this.doublePkContext.getBasePKContext().getPkBaseState();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    private final q getPkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkUtils();
    }

    private final d31.d getRevLinkLogHelper() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    private final String getToken() {
        if (u41.a.c.a() == false) goto L12;
        int r0 = h.a;
        StringBuilder r1 = new StringBuilder();
        com.bytedance.android.live.revenuelink.connect.g r2 = getAnchorConnectUtils();
        Integer r3 = null;
        if (r2 == null) goto L7;
        Long r4 = Long.valueOf(r2.getChannelId());
    L8:
        r1.append(String.valueOf(r4));
        w31.c r5 = getPkLinkUtils();
        if (r5 == null) goto L11;
        r3 = Integer.valueOf(r5.a());
    L11:
        r1.append(r3);
        r1.append(DataType.FALSE);
        r1.append(this.doublePkContext.getInviteType());
        return h.a(r1.toString());
    L7:
        r4 = null;
        goto L8
    L12:
        return "";
    }

    private final void openBattleWhenLink() {
        w31.c r1 = getPkLinkUtils();
        if (r1 == null) goto L5;
        String r2 = r1.r();
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        String r5 = "";
        if (r3 == true) goto L27;
        LinkmicBizType r8 = LinkmicBizType.LinkmicBizTypeOpenGame;
        w31.c r4 = getPkLinkUtils();
        if (r4 == null) goto L21;
        String r6 = r4.r();
        if (r6 == null) goto L21;
        String r9 = r6;
    L22:
        c21.h r7 = new c21.h(0, r8, r9, false, 57);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r10 = this.doublePkContext.getBasePKContext().getPkAnchorLauncher();
        if (r10 == null) goto L93;
        r10.k(new k(r7, "auto_match_bizStart"));
        return;
    L93:
        return;
    L21:
        r9 = "";
        goto L22
    L27:
        if (this.isToVoteInPeak == false) goto L30;
        long r12 = l51.a.f();
    L29:
        long r13 = r12;
        if (this.isToVoteInPeak == false) goto L39;
        IPKLinkBizDataService r14 = getPKLinkBizDataService();
        if (r14 == null) goto L39;
        aa r15 = r14.getPeakVoteSetting();
    L40:
        w31.c r16 = getPkLinkUtils();
        if (r16 == null) goto L45;
        IPKLinkBizDataService r17 = r16.g();
        if (r17 == null) goto L45;
        h9 r18 = r17.getSpecifyGiftConfig();
    L46:
        w31.c r19 = getPkLinkUtils();
        if (r19 == null) goto L51;
        IPKLinkBizDataService r20 = r19.g();
        if (r20 == null) goto L51;
        w2 r22 = r20.getBattleShellConfig();
    L52:
        String r110 = getToken();
        if (getMergePkHelper() == null) goto L62;
        w31.c r23 = getPkLinkUtils();
        if (r23 == null) goto L59;
        IPKLinkBizDataService r24 = r23.g();
        if (r24 == null) goto L59;
        int r25 = r24.getBattleInviteType();
    L60:
        BattleInviteType r26 = d21.d.d(r25);
        if (r26 == null) goto L62;
    L63:
        BattleInviteType r111 = r26;
        w31.c r27 = getPkLinkUtils();
        if (r27 == null) goto L66;
        String r112 = r27.l();
    L67:
        c21.e.a r113 = new c21.e.a(r13, 1, null, r111, r112, r110, null, null, 452);
        w31.c r28 = getPkLinkUtils();
        if (r28 == null) goto L76;
        IPKLinkBizDataService r29 = r28.g();
        if (r29 == null) goto L76;
        String r30 = r29.getFlexActivityId();
        if (r30 == null) goto L76;
        r5 = r30;
    L76:
        if (r5.length() <= 0) goto L78;
        boolean r210 = true;
    L79:
        if (r210 == false) goto L81;
        c21.e r32 = new c21.e(r113, new c21.f.e(r5), "FlexActivityPk");
    L88:
        c21.e r33 = r32;
    L89:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r34 = this.doublePkContext.getBasePKContext().getPkAnchorLauncher();
        if (r34 == null) goto L94;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r34, r33, null, null, 6);
        return;
    L94:
        return;
    L81:
        if (r15 == null) goto L83;
        r33 = new c21.e(r113, new c21.f.m(1, r15), "Vote");
        goto L89
    L83:
        if (r18 == null) goto L85;
        r32 = new c21.e(r113, new c21.f.l(1, PlayMode.PERSONAL_PK, r18), "SpecifyGiftPk");
        goto L88
    L85:
        if (r22 == null) goto L87;
        r32 = new c21.e(r113, new c21.f.k(1, PlayMode.PERSONAL_PK, r22), "ShellPk");
        goto L88
    L87:
        r32 = new c21.e(r113, new c21.f.h(1, PlayMode.PERSONAL_PK), "NormalPk");
        goto L88
    L78:
        r210 = false;
        goto L79
    L66:
        r112 = "";
    L59:
        r25 = 0;
    L62:
        r26 = BattleInviteType.UNKNOWN;
    L51:
        r22 = null;
    L45:
        r18 = null;
    L39:
        r15 = null;
        goto L40
    L30:
        w31.c r35 = getPkLinkUtils();
        if (r35 == null) goto L33;
        r12 = r35.a();
        goto L29
    L33:
        r12 = 0;
        goto L29
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b
    public p0 getLaunchBattleAttachedInfo() {
        com.bytedance.android.live.revlink.impl.control.launchcontext.c r0 = this.pkAnchorLaunchContext;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public void logGameConnectionSuccess() {
        this.doublePkContext.onToLinkInOpenGame();
    }

    private final void openBattleWhenSwitch() {
        IPKLinkBizDataService r0 = getPKLinkBizDataService();
        if (r0 == null) goto L5;
        d r1 = r0.getVoteSetting();
    L6:
        com.bytedance.android.live.revlink.impl.pk.service.c r2 = getPKCustomizePlayDataService();
        if (r2 == null) goto L11;
        PkCustomizePlayDataContext.a r3 = r2.getCustomizePkSelfData();
        if (r3 == null) goto L11;
        u2 r4 = r3.a;
    L12:
        w31.c r5 = getPkLinkUtils();
        if (r5 == null) goto L17;
        IPKLinkBizDataService r6 = r5.g();
        if (r6 == null) goto L17;
        w2 r7 = r6.getBattleShellConfig();
    L18:
        IPKLinkBizDataService r8 = getPKLinkBizDataService();
        int r9 = 0;
        if (r8 == null) goto L21;
        boolean r10 = r8.getIsBreakThrough();
    L22:
        w31.c r12 = getPkLinkUtils();
        if (r12 == null) goto L27;
        IPKLinkBizDataService r13 = r12.g();
        if (r13 == null) goto L27;
        h9 r14 = r13.getSpecifyGiftConfig();
    L28:
        w31.c r15 = getPkLinkUtils();
        if (r15 == null) goto L33;
        IPKLinkBizDataService r16 = r15.g();
        if (r16 == null) goto L33;
        IBattleConfigSetting r17 = r16.getBattleConfigSetting();
    L34:
        if (r1 == null) goto L37;
        long r18 = r1.a;
    L36:
        long r19 = r18;
        String r110 = getToken();
        if (getMergePkHelper() == null) goto L49;
        w31.c r20 = getPkLinkUtils();
        if (r20 == null) goto L47;
        IPKLinkBizDataService r22 = r20.g();
        if (r22 == null) goto L47;
        r9 = r22.getBattleInviteType();
    L47:
        BattleInviteType r23 = d21.d.d(r9);
        if (r23 == null) goto L49;
    L50:
        c21.e.a r24 = new c21.e.a(r19, 1, null, r23, null, r110, null, null, 468);
        if (r1 == null) goto L53;
        aa r25 = r1.b;
    L55:
        if (r25 == null) goto L57;
        c21.e r26 = new c21.e(r24, new c21.f.m(1, r1.b), "Vote");
    L70:
        c21.e r27 = r26;
    L71:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r28 = this.doublePkContext.getBasePKContext().getPkAnchorLauncher();
        if (r28 == null) goto L75;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r28, r27, null, null, 6);
        return;
    L75:
        return;
    L57:
        if (r4 == null) goto L59;
        r27 = new c21.e(r24, new c21.f.d(1, PlayMode.PERSONAL_PK, r4, null), "CustomPlay");
        goto L71
    L59:
        if (r7 == null) goto L61;
        r26 = new c21.e(r24, new c21.f.k(1, PlayMode.PERSONAL_PK, r7), "ShellPk");
        goto L70
    L61:
        if (r10 == false) goto L63;
        r27 = new c21.e(r24, new c21.f.a(1, null), "BreakThrough");
        goto L71
    L63:
        if (r14 == null) goto L65;
        r26 = new c21.e(r24, new c21.f.l(1, PlayMode.PERSONAL_PK, r14), "SpecifyGiftPk");
        goto L70
    L65:
        if (r17 != null) goto L67;
    L69:
        r26 = new c21.e(r24, new c21.f.h(1, PlayMode.PERSONAL_PK), "NormalPk");
        goto L70
    L67:
        if (r17.getModType() != PkBaseDataContext.PKModType.Custom.getType()) goto L69;
        r26 = new c21.e(r24, new c21.f.g(1, PlayMode.PERSONAL_PK, r17.getCustomConfig()), "NewCustomPlay");
        goto L70
    L53:
        r25 = null;
    L49:
        r23 = BattleInviteType.UNKNOWN;
        goto L50
    L37:
        if (r4 == null) goto L39;
        r18 = r4.getPkCustomDuration();
        goto L36
    L39:
        r18 = l51.a.j();
    L33:
        r17 = null;
    L27:
        r14 = null;
        goto L28
    L21:
        r10 = false;
    L17:
        r7 = null;
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void resetPeakData() {
        IPKLinkBizDataService r0 = getPKLinkBizDataService();
        if (r0 == null) goto L6;
        r0.resetPeakData();
        return;
    }

    public final PkDoubleDataContext getDoublePkContext() {
        return this.doublePkContext;
    }

    public final com.bytedance.android.live.revlink.impl.control.launchcontext.c getPkAnchorLaunchContext() {
        return this.pkAnchorLaunchContext;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.context;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkDoubleAnchorDataContext r0) {
        return r0.cd;
    }

    private final void onLinkerMessage(i6 r8) {
        StringBuilder r0 = new StringBuilder("receive link message isStarter=");
        w31.c r1 = getPkLinkUtils();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.e());
    L6:
        r0.append(r2);
        jy0.b.c(TAG, r0.toString(), null, 4);
        w31.c r3 = getPkLinkUtils();
        if (r3 != null) goto L9;
    L10:
        Intrinsics.checkNotNullParameter(r8, "$this$typeExt");
        int r4 = (int) r8.getType2();
        int r5 = 0;
        if (r4 != 6) goto L13;
        StringBuilder r6 = new StringBuilder("receive enter message userSize=");
        f1 r7 = r8.getEnter();
        if (r7 == null) goto L33;
        List r9 = r7.getLinkUsers();
        if (r9 == null) goto L33;
        int r10 = r9.size();
    L34:
        r6.append(r10);
        jy0.b.c(TAG, r6.toString(), null, 4);
        f1 r12 = r8.getEnter();
        if (r12 == null) goto L39;
        List r13 = r12.getLinkUsers();
        if (r13 == null) goto L39;
        r5 = r13.size();
    L39:
        if (r5 < 2) goto L45;
        pkOptOpenBattle(BattleOpenSource.JoinChannel);
        return;
    L45:
        return;
    L33:
        r10 = 0;
        goto L34
    L13:
        if (r4 != 11) goto L46;
        StringBuilder r14 = new StringBuilder("receive list change message userSize=");
        h6 r15 = r8.getLinkedListChange();
        if (r15 == null) goto L20;
        List r16 = r15.getLinkUsers();
        if (r16 == null) goto L20;
        int r17 = r16.size();
    L21:
        r14.append(r17);
        jy0.b.c(TAG, r14.toString(), null, 4);
        h6 r18 = r8.getLinkedListChange();
        if (r18 == null) goto L26;
        List r19 = r18.getLinkUsers();
        if (r19 == null) goto L26;
        r5 = r19.size();
    L26:
        if (r5 < 2) goto L43;
        pkOptOpenBattle(BattleOpenSource.JoinChannel);
        return;
    L43:
        return;
    L20:
        r17 = 0;
        goto L21
    L46:
        return;
    L9:
        if (r3.e() != true) goto L10;
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void onMessage(yh6.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof h1) == false) goto L8;
        onLinkerMessage((i6) ((vh7.c) r2).castTo(i6.class));
        return;
    }

    public String getLinkerID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
        return j.a.a(this, r2);
    }

    public String getUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$uid");
        return j.a.b(this, r2);
    }

    public void pkBizOptOpenBattle(BattleOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "requestSource");
        if (this.mHasOpenBattle == false) goto L5;
        return;
    L5:
        if (this.canStartPkByDefault == false) goto L7;
    L8:
        openBattleWhenLink();
        this.mHasOpenBattle = true;
        return;
    L7:
        if (this.isToVoteInPeak == true) goto L8;
    }

    public void pkOptOpenBattle(BattleOpenSource r5) {
        Intrinsics.checkNotNullParameter(r5, "requestSource");
        if (r5 != BattleOpenSource.FirstFrame) goto L6;
        this.mFirstRemoteFrameRender = true;
    L8:
        jy0.b.c(TAG, "pkOptOpenBattle mAllJoinChannel=" + this.mAllJoinChannel + " mFirstRemoteFrameRender=" + this.mFirstRemoteFrameRender + " mHasOpenBattle=" + this.mHasOpenBattle + " canStartPkByDefault=" + this.canStartPkByDefault + " isToVoteInPeak=" + this.isToVoteInPeak, null, 4);
        if (this.mAllJoinChannel == true) goto L11;
        return;
    L11:
        if (this.mFirstRemoteFrameRender == true) goto L13;
        return;
    L13:
        if (this.mHasOpenBattle == false) goto L15;
    L22:
        this.mFirstRemoteFrameRender = false;
        this.mAllJoinChannel = false;
        return;
    L15:
        if (this.canStartPkByDefault == false) goto L17;
    L18:
        LiveFullLinkPKMonitor r6 = getLiveFullLinkPKMonitor();
        if (r6 == null) goto L21;
        String r0 = IPKLinkBizDataService.OpenBattleSource.JoinChannel.getSource();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.i = r0;
    L21:
        openBattleWhenLink();
        this.mHasOpenBattle = true;
        goto L22
    L17:
        if (this.isToVoteInPeak == false) goto L22;
    L6:
        if (r5 != BattleOpenSource.JoinChannel) goto L8;
        this.mAllJoinChannel = true;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b
    public void startBattleInvite(com.bytedance.android.live.revlink.impl.pk.vm.pk.a r18) {
        Intrinsics.checkNotNullParameter(r18, "battleInviteParam");
        h9 r1 = r18.a.getSpecifyGiftConfig();
        if (r1 == null) goto L19;
        PkBaseStateMachine.c r2 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        if (r2 != null) goto L7;
    L11:
        String r13 = getToken();
        long r7 = r18.b;
        w31.c r0 = getPkLinkUtils();
        if (r0 == null) goto L14;
        String r3 = r0.l();
    L15:
        c21.e r4 = new c21.e(new c21.e.a(r7, 1, null, null, r3, r13, null, null, 460), new c21.f.l(1, PlayMode.PERSONAL_PK, r1), "SpecifyGiftPk");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r5 = getPkAnchorLauncher();
        if (r5 == null) goto L22;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r5, r4, null, null, 6);
        return;
    L22:
        return;
    L14:
        r3 = "";
        goto L15
    L7:
        if (r2.a() != true) goto L11;
        c21.b r6 = new c21.b(new l(BattleInviteType.AGAIN, r18.b, 0, false, r18.d, r18.e, 76), new c21.f.l(1, PlayMode.PERSONAL_PK, r1), "SpecifyGiftPk");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r8 = getPkAnchorLauncher();
        if (r8 == null) goto L20;
        r8.b(r6, null);
        return;
    L20:
        return;
    }

    public static final /* synthetic */ void access$onMessage(PkDoubleAnchorDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public void startBreakThroughInvite(boolean r26, long r27, com.bytedance.android.live.revlink.impl.pk.utils.l r29) {
        Intrinsics.checkNotNullParameter(r29, "pageSource");
        PkBaseStateMachine.c r0 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        String r1 = "";
        if (r0 != null) goto L5;
    L16:
        String r22 = getToken();
        w31.c r2 = getPkLinkUtils();
        if (r2 == null) goto L19;
        r1 = r2.l();
    L19:
        c21.e r3 = new c21.e(new c21.e.a(0, 1, null, null, r1, r22, null, null, 460), new c21.f.a(1, null), "BreakThrough");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r4 = getPkAnchorLauncher();
        if (r4 == null) goto L25;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r4, r3, null, null, 6);
        return;
    L25:
        return;
    L5:
        if (r0.a() != true) goto L16;
        BattleInviteType r14 = BattleInviteType.UNKNOWN;
        e21.b r5 = getClientAttachedInfoObj();
        if (r5 == null) goto L12;
        d31.d r8 = getRevLinkLogHelper();
        if (r8 == null) goto L11;
        r1 = r8.s();
    L11:
        v3 r17 = e21.b.b(r5, r29, "cooperation", null, null, r1, "2", 28);
    L13:
        c21.b r6 = new c21.b(new l(r14, 0, 0, false, r27, r17, 76), new c21.f.a(1, null), "BreakThrough");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r7 = getPkAnchorLauncher();
        if (r7 == null) goto L23;
        r7.b(r6, null);
        return;
    L23:
        return;
    L12:
        r17 = null;
        goto L13
    }

    public void startCustomizePlay(d4 r25, long r26, com.bytedance.android.live.revlink.impl.pk.utils.l r28) {
        Intrinsics.checkNotNullParameter(r28, "pageSource");
        if (r25 == null) goto L25;
        PkBaseStateMachine.c r1 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        String r2 = "";
        if (r1 != null) goto L7;
    L18:
        String r20 = getToken();
        long r14 = r25.getDuration();
        w31.c r3 = getPkLinkUtils();
        if (r3 == null) goto L21;
        r2 = r3.l();
    L21:
        c21.e r4 = new c21.e(new c21.e.a(r14, 1, null, null, r2, r20, null, null, 460), new c21.f.g(1, PlayMode.PERSONAL_PK, r25), "CustomPlay");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r0 = getPkAnchorLauncher();
        if (r0 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r0, r4, null, null, 6);
        return;
    L28:
        return;
    L7:
        if (r1.a() != true) goto L18;
        BattleInviteType r15 = BattleInviteType.AGAIN;
        long r16 = r25.getDuration();
        e21.b r5 = getClientAttachedInfoObj();
        if (r5 == null) goto L14;
        d31.d r9 = getRevLinkLogHelper();
        if (r9 == null) goto L13;
        r2 = r9.s();
    L13:
        v3 r22 = e21.b.b(r5, r28, "customize_pk", null, null, r2, "2", 28);
    L15:
        c21.b r6 = new c21.b(new l(r15, r16, 0, false, r26, r22, 76), new c21.f.g(1, PlayMode.PERSONAL_PK, r25), "CustomPlay");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r7 = getPkAnchorLauncher();
        if (r7 == null) goto L26;
        r7.b(r6, null);
        return;
    L26:
        return;
    L14:
        r22 = null;
        goto L15
    }

    public void finishBattle(boolean r2, int r3, boolean r4, boolean r5) {
        if (r4 == false) goto L5;
        this.doublePkContext.setFinisher(true);
    L5:
        this.doublePkContext.setRoomCloser(r5);
        if (r2 == false) goto L14;
        w31.c r6 = getPkLinkUtils();
        if (r6 == null) goto L14;
        if (r6.e() != true) goto L14;
        if (getPKInviteControlUtils() == null) goto L14;
        com.bytedance.android.live.revlink.impl.pk.utils.j.f();
    L14:
        if (r2 == true) goto L16;
        return;
    L16:
        if (r3 != 8) goto L18;
        this.doublePkContext.getBasePKContext().getStateMachineController().c(PkBaseStateMachine.Source.RtcLinkerLeave);
        return;
    L18:
        if (r3 == 11) goto L20;
        this.doublePkContext.getBasePKContext().getStateMachineController().c(PkBaseStateMachine.Source.CutShort);
        return;
    L20:
        this.doublePkContext.getBasePKContext().getStateMachineController().c(PkBaseStateMachine.Source.RoomClose);
    }

    public void inviteBattle(int r29, w2 r30, long r32, com.bytedance.android.live.revlink.impl.pk.utils.l r33) {
        Intrinsics.checkNotNullParameter(r33, "pageSource");
        w31.c r1 = getPkLinkUtils();
        if (r1 == null) goto L5;
        IPKLinkBizDataService r2 = r1.g();
    L6:
        String r3 = "";
        if (r2 == null) goto L12;
        String r4 = r2.getFlexActivityId();
        if (r4 == null) goto L12;
        String r12 = r4;
    L14:
        if (r12.length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L38;
        if (r2 == null) goto L38;
        IPKLinkBizDataService.d r6 = r2.getLinkTypeParams();
        if (r6 == null) goto L38;
        if (r6.a != 3) goto L38;
        com.bytedance.android.live.revlink.impl.pk.service.e r7 = getPKPrecisionMatchService();
        if (r7 == null) goto L28;
        Long r8 = r7.getLinkDuration();
        if (r8 == null) goto L28;
        long r9 = r8.longValue();
    L30:
        if (r9 <= 0) goto L38;
        if (r30 != null) goto L38;
        com.bytedance.android.live.revlink.impl.pk.service.e r10 = getPKPrecisionMatchService();
        if (r10 == null) goto L37;
        Long r13 = r10.getLinkDuration();
        if (r13 == null) goto L37;
        int r14 = (int) r13.longValue();
    L55:
        PkBaseStateMachine.c r15 = (PkBaseStateMachine.c) this.doublePkContext.getBasePKContext().getPkBaseState().getValue();
        if (r15 != null) goto L58;
    L86:
        String r23 = getToken();
        long r16 = r14;
        w31.c r17 = getPkLinkUtils();
        if (r17 == null) goto L89;
        r3 = r17.l();
    L89:
        c21.e.a r18 = new c21.e.a(r16, 1, null, null, r3, r23, null, null, 460);
        if ((getCurBattlePlayMode() instanceof c21.f.j) == false) goto L92;
        c21.e r0 = new c21.e(r18, c21.f.j.b, "SeasonRank");
    L101:
        c21.e r19 = r0;
    L102:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r20 = getPkAnchorLauncher();
        if (r20 == null) goto L108;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r20, r19, null, null, 6);
        return;
    L108:
        return;
    L92:
        if (r30 == null) goto L95;
        r19 = new c21.e(r18, new c21.f.k(1, PlayMode.PERSONAL_PK, r30), "ShellPk");
        goto L102
    L95:
        if (r12.length() <= 0) goto L97;
        boolean r110 = true;
    L98:
        if (r110 == false) goto L100;
        r0 = new c21.e(r18, new c21.f.e(r12), "FlexActivityPk");
        goto L101
    L100:
        r0 = new c21.e(r18, new c21.f.h(1, PlayMode.PERSONAL_PK), "NormalPk");
        goto L101
    L97:
        r110 = false;
        goto L98
    L58:
        if (r15.a() != true) goto L86;
        if (getMergePkHelper() == null) goto L63;
        BattleInviteType r22 = d21.d.d(r29);
        if (r22 == null) goto L63;
    L64:
        BattleInviteType r111 = r22;
        long r24 = r14;
        e21.b r25 = getClientAttachedInfoObj();
        if (r25 == null) goto L70;
        d31.d r26 = getRevLinkLogHelper();
        if (r26 == null) goto L69;
        r3 = r26.s();
    L69:
        v3 r27 = e21.b.b(r25, r33, "normal_pk", null, null, r3, "2", 28);
    L71:
        l r28 = new l(r111, r24, 0, false, r32, r27, 76);
        if ((getCurBattlePlayMode() instanceof c21.f.j) == false) goto L74;
        c21.b r34 = new c21.b(r28, c21.f.j.b, "SeasonRank");
    L83:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r35 = getPkAnchorLauncher();
        if (r35 == null) goto L106;
        r35.b(r34, null);
        return;
    L106:
        return;
    L74:
        if (r30 == null) goto L77;
        r34 = new c21.b(r28, new c21.f.k(1, PlayMode.PERSONAL_PK, r30), "ShellPk");
        goto L83
    L77:
        if (r12.length() <= 0) goto L79;
        boolean r112 = true;
    L80:
        if (r112 == false) goto L82;
        r34 = new c21.b(r28, new c21.f.e(r12), "FlexActivityPk");
        goto L83
    L82:
        r34 = new c21.b(r28, new c21.f.h(1, PlayMode.PERSONAL_PK), "NormalPk");
        goto L83
    L79:
        r112 = false;
        goto L80
    L70:
        r27 = null;
    L63:
        r22 = BattleInviteType.UNKNOWN;
    L37:
        r14 = l51.a.j();
    L28:
        r9 = 0;
    L38:
        if (r30 != null) goto L40;
    L41:
        if (r30 == null) goto L43;
    L47:
        boolean r36 = false;
    L48:
        if (r36 == false) goto L54;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r37 = getLinkPlayHelper();
        if (r37 == null) goto L54;
        if (r37.e() != true) goto L54;
        r14 = getCurDuration();
    L54:
        r14 = l51.a.j();
        goto L55
    L43:
        if ((getCurBattlePlayMode() instanceof c21.f.h) == false) goto L45;
    L46:
        r36 = true;
        goto L48
    L45:
        if ((getCurBattlePlayMode() instanceof c21.f.e) == false) goto L47;
    L40:
        if ((getCurBattlePlayMode() instanceof c21.f.k) == true) goto L46;
    L16:
        r5 = false;
    L12:
        r12 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b
    public void startVoteBattleInvite(long r25, aa r27, boolean r28, long r29, com.bytedance.android.live.revlink.impl.pk.utils.l r32) {
        Intrinsics.checkNotNullParameter(r32, "pageSource");
        PkBaseStateMachine.c r1 = (PkBaseStateMachine.c) getPkBaseState().getValue();
        String r2 = "";
        if (r1 != null) goto L5;
    L16:
        String r20 = getToken();
        w31.c r3 = getPkLinkUtils();
        if (r3 == null) goto L19;
        r2 = r3.l();
    L19:
        c21.e r4 = new c21.e(new c21.e.a(r25, 1, null, null, r2, r20, null, null, 460), new c21.f.m(1, r27), "Vote");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r0 = getPkAnchorLauncher();
        if (r0 == null) goto L25;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r0, r4, null, null, 6);
        return;
    L25:
        return;
    L5:
        if (r1.a() != true) goto L16;
        BattleInviteType r14 = BattleInviteType.UNKNOWN;
        e21.b r5 = getClientAttachedInfoObj();
        if (r5 == null) goto L12;
        d31.d r9 = getRevLinkLogHelper();
        if (r9 == null) goto L11;
        r2 = r9.s();
    L11:
        v3 r22 = e21.b.b(r5, r32, "vote", null, null, r2, "2", 28);
    L13:
        c21.b r6 = new c21.b(new l(r14, r25, 0, false, r29, r22, 76), new c21.f.m(1, r27), "Vote");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r7 = getPkAnchorLauncher();
        if (r7 == null) goto L23;
        r7.b(r6, null);
        return;
    L23:
        return;
    L12:
        r22 = null;
        goto L13
    }

    public PkDoubleAnchorDataContext(long r20, String r22, com.bytedance.android.live.revlink.impl.control.launchcontext.c r23, ld.a r24, wq2.f r25, com.bytedance.android.livesdk.revenue.service.room.c r26, com.bytedance.android.live.revlink.impl.global.c r27, yz0.f r28, com.bytedance.android.livesdk.revenue.service.message.d r29, x11.a r30, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r32, PkBaseDataContext r33) {
        Intrinsics.checkNotNullParameter(r32, "context");
        this.pkAnchorLaunchContext = r23;
        this.linkFakeGlobalService = r27;
        this.context = r32;
        CompositeDisposable r13 = new CompositeDisposable();
        this.cd = r13;
        final PkDoubleDataContext r12 = new PkDoubleDataContext(r20, r22, true, r24, r25, r26, r27, r28, r29, r30, getContext(), this, r33);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new PkDoubleAnchorDataContext$doublePkContext$1$1(r12)).getSecond(), r13);
        Unit r0 = Unit.INSTANCE;
        this.doublePkContext = r12;
        IPKLinkBizDataService r1 = getPKLinkBizDataService();
        String r3 = null;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getPeakSwitchPlayMode());
    L6:
        this.peakSwitchPlayMode = r2;
        int r4 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        boolean r5 = false;
        if (r2 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        this.isToVoteInPeak = r6;
        if (r2 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        this.isToLinkInPeak = r7;
        if (r2 != null) goto L24;
    L25:
        if (r2 != null) goto L28;
    L30:
        boolean r8 = false;
    L32:
        this.canStartPkByDefault = r8;
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r13);
        if (r28 == null) goto L39;
        Observable r9 = yz0.h.a.a(r28, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r9 == null) goto L39;
        final AnonymousClass2 r10 = new AnonymousClass2(this);
        Disposable r14 = r9.subscribe(new e(r10));
        if (r14 == null) goto L39;
        com.bytedance.revenue.platform.api.core.rx.f.a(r14, r13);
    L39:
        w31.c r15 = getPkLinkUtils();
        if (r15 == null) goto L44;
        IPKLinkBizDataService r16 = r15.g();
        if (r16 == null) goto L44;
        boolean r17 = r16.getIsRealOrganizer();
    L45:
        r12.setRealOrgnizer(r17);
        w31.c r18 = getPkLinkUtils();
        if (r18 != null) goto L48;
    L49:
        w31.c r19 = getPkLinkUtils();
        if (r19 != null) goto L52;
    L70:
        w31.c r34 = getPkLinkUtils();
        if (r34 == null) goto L73;
        r3 = r34.r();
    L73:
        if (r3 != null) goto L75;
    L76:
        r5 = true;
    L77:
        if (r5 == true) goto L99;
        w31.c r35 = getPkLinkUtils();
        if (r35 != null) goto L81;
    L82:
        w31.c r36 = getPkLinkUtils();
        if (r36 != null) goto L85;
    L95:
        i41.a r37 = getAutoMatchManager();
        if (r37 == null) goto L98;
        r37.g = "";
    L98:
        r12.getBasePKContext().getStateMachineController().j.a(PkBaseStateMachine.a.j.c);
        goto L99
    L85:
        if (r36.q() != true) goto L95;
        LinkmicBizType r38 = LinkmicBizType.LinkmicBizTypeOpenGame;
        w31.c r39 = getPkLinkUtils();
        if (r39 == null) goto L90;
        String r40 = r39.r();
        if (r40 == null) goto L90;
    L91:
        c21.h r42 = new c21.h(0, r38, r40, false, 57);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r43 = getPkAnchorLauncher();
        if (r43 == null) goto L94;
        r43.k(new k(r42, "switch_scene_bizStart"));
    L94:
        this.mHasOpenBattle = true;
    L90:
        r40 = "";
        goto L91
    L81:
        if (r35.e() == true) goto L95;
    L99:
        if (r8 == true) goto L103;
        if (r7 == false) goto L104;
        r12.onToLinkInPeak();
        r12.getBasePKContext().getStateMachineController().j.a(PkBaseStateMachine.a.h.c);
        PkBaseDataContext r44 = r12.getBasePKContext();
        i97.a r45 = i97.a.a;
        r44.setStartTimeMsField(System.currentTimeMillis());
        return;
    L104:
        return;
    L103:
        return;
    L75:
        if (r3.length() != 0) goto L77;
    L52:
        if (r19.q() != true) goto L70;
        w31.c r46 = getPkLinkUtils();
        if (r46 == null) goto L56;
        String r47 = r46.r();
    L57:
        if (r47 != null) goto L59;
    L62:
        boolean r48 = true;
    L63:
        if (r48 == false) goto L70;
        if (r8 == true) goto L66;
        if (r6 == false) goto L70;
    L66:
        LiveFullLinkPKMonitor r49 = getLiveFullLinkPKMonitor();
        if (r49 == null) goto L69;
        String r50 = IPKLinkBizDataService.OpenBattleSource.SwitchFromAnchor.getSource();
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        r49.i = r50;
    L69:
        openBattleWhenSwitch();
        this.mHasOpenBattle = true;
        goto L70
    L59:
        if (r47.length() == 0) goto L62;
        r48 = false;
        goto L63
    L56:
        r47 = null;
        goto L57
    L48:
        if (r18.e() == true) goto L70;
    L44:
        r17 = false;
        goto L45
    L28:
        if (r2.intValue() != 3) goto L30;
    L31:
        r8 = true;
        goto L32
    L24:
        if (r2.intValue() == 0) goto L31;
    L17:
        if (r2.intValue() != 1) goto L19;
        r7 = true;
        goto L20
    L10:
        if (r2.intValue() != 2) goto L12;
        r6 = true;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public /* synthetic */ PkDoubleAnchorDataContext(long r16, String r18, com.bytedance.android.live.revlink.impl.control.launchcontext.c r19, ld.a r20, wq2.f r22, com.bytedance.android.livesdk.revenue.service.room.c r23, com.bytedance.android.live.revlink.impl.global.c r24, yz0.f r25, com.bytedance.android.livesdk.revenue.service.message.d r26, x11.a r27, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r28, PkBaseDataContext r29, int r210, DefaultConstructorMarker r30) {
        if ((r210 & 2048) == 0) goto L5;
        PkBaseDataContext r14 = null;
    L6:
        this(r16, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r14);
        return;
    L5:
        r14 = r29;
        goto L6
    }
}
