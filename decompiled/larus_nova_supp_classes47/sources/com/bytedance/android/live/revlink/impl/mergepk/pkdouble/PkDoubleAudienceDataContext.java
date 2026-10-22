package com.bytedance.android.live.revlink.impl.mergepk.pkdouble;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkStateMachineController;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.service.h;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.utils.PkEnterCheck;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.monitor.EventType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0098\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0099\u0001\u009a\u0001B\u008a\u0001\u0012\u0006\u0010I\u001a\u00020\u0006\u0012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\b\u0010X\u001a\u0004\u0018\u00010W\u0012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001\u0012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001\u0012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u0001\u0012\u0006\u0010[\u001a\u00020Z\u0012\f\b\u0002\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J \u0010\t\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016R\u0018\u0010&\u001a\u00060$j\u0002`%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010/R\u0014\u00100\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000b0<j\b\u0012\u0004\u0012\u00020\u000b`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00107R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010/R$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010.\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010O\u001a\u0004\u0018\u00010N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u0004\u0018\u00010Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u0004\u0018\u00010T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u0004\u0018\u00010W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001a\u0010[\u001a\u00020Z8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0016\u0010b\u001a\u0004\u0018\u00010_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0016\u0010f\u001a\u0004\u0018\u00010c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010j\u001a\u0004\u0018\u00010g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010n\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010r\u001a\u0004\u0018\u00010o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0016\u0010v\u001a\u0004\u0018\u00010s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0016\u0010z\u001a\u0004\u0018\u00010w8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0016\u0010~\u001a\u0004\u0018\u00010{8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0019\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u0002058BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u008a\u0001\u001a\f\u0018\u00010\u0086\u0001j\u0005\u0018\u0001`\u0087\u00018F¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAudienceDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/f;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/a;", "Lcom/bytedance/android/live/revlink/link/biz/service/j;", "Lkotlin/Function1;", "", "", "diffCheck", "getBattleStatsForAudienceBackup", "", "Lcom/bytedance/android/livesdk/link/model/p;", "linkUserList", "firstCreateLog", "", "fromType", "getBattleStatsForAudienceEnterRoom", "tryP1BattleIDBackup", "attach", "getAnchorList", "reportUiFirstLoad", "battleID", "notifyRoomUpdate", "channelId", "", "guestUserId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "guestUserEx", "resetPeakData", "matchType", Constants.Keys.duration, FileUtils.PICTURE_THEME, "Lcom/bytedance/android/live/revlink/impl/pk/service/IPkAudienceLoadService$LoadType;", "getLoadType", "getConnectSource", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "doublePkContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "getDoublePkContext", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleDataContext;", "startLoadBeginTimeMs", "J", "Ljava/lang/String;", "loadType", "Lcom/bytedance/android/live/revlink/impl/pk/service/IPkAudienceLoadService$LoadType;", "preloadBattleID", "Ljava/lang/Long;", "p1BattleID", "", "recordPreload", "Z", "recordP1", "Lcom/bytedance/android/live/revlink/impl/pk/utils/PkEnterCheck;", "pkCheck", "Lcom/bytedance/android/live/revlink/impl/pk/utils/PkEnterCheck;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchorList", "Ljava/util/ArrayList;", "isFirstCreate", "connectSource", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/a;", "anchorAudioPunishManager", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/a;", "getAnchorAudioPunishManager", "()Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/a;", "setAnchorAudioPunishManager", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/a;)V", "channelIdField", "getChannelIdField", "()J", "setChannelIdField", "(J)V", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/d;", "pkAudienceLaunchContext", "Lcom/bytedance/android/live/revlink/impl/control/launchcontext/d;", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "context", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "getContext", "()Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/h;", "getRevLinkPreloadService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/service/h;", "revLinkPreloadService", "Lcom/bytedance/android/live/revlink/impl/monitor/b;", "getPkEnterRoomTracer", "()Lcom/bytedance/android/live/revlink/impl/monitor/b;", "pkEnterRoomTracer", "Lcom/bytedance/android/live/revlink/impl/multianchor/utils/z;", "getMultiPkMonitor", "()Lcom/bytedance/android/live/revlink/impl/multianchor/utils/z;", "multiPkMonitor", "Lb21/d;", "getPkBaseMonitor", "()Lb21/d;", "pkBaseMonitor", "Lw31/a;", "getConnectionDataLogUtils", "()Lw31/a;", "connectionDataLogUtils", "Lcom/bytedance/android/live/revlink/impl/monitor/LiveFullLinkPKMonitor;", "getLiveFullLinkPKMonitor", "()Lcom/bytedance/android/live/revlink/impl/monitor/LiveFullLinkPKMonitor;", "liveFullLinkPKMonitor", "Lr31/a;", "getLinkNetwork", "()Lr31/a;", "linkNetwork", "Ld21/d;", "getMergePkHelper", "()Ld21/d;", "mergePkHelper", "Lcom/bytedance/android/live/revlink/impl/utils/s;", "getRevLinkCommonUtil", "()Lcom/bytedance/android/live/revlink/impl/utils/s;", "revLinkCommonUtil", "getInPk", "()Z", "inPk", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "guestUid", "Lwq2/f;", "dataCenterService", "Lyz0/f;", "messageService", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "messageManagerService", "Lx11/a;", "internalLinkService", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;", "extraBaseDataContext", "<init>", "(JLjava/lang/String;Lcom/bytedance/android/live/revlink/impl/control/launchcontext/d;Lld/a;Lwq2/f;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;Lcom/bytedance/android/livesdk/revenue/service/message/d;Lx11/a;Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/d;Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PkBaseDataContext;)V", "Companion", "BattleStatsFromType", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkDoubleAudienceDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.pk.service.f, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a, j {
    public static final b Companion = null;
    public static final String LOG_TAG = "ttlive_PkDoubleDataContext";
    public static final String TAG = "PkDoubleAudienceDataContext";
    private com.bytedance.android.live.revlink.impl.mergepk.pkbase.a anchorAudioPunishManager;
    private final ArrayList<p> anchorList;
    private final CompositeDisposable cd;
    private long channelIdField;
    private String connectSource;
    private final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d context;
    private final PkDoubleDataContext doublePkContext;
    private String guestUserId;
    private boolean isFirstCreate;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final IPkAudienceLoadService.LoadType loadType;
    private long p1BattleID;
    private final com.bytedance.android.live.revlink.impl.control.launchcontext.d pkAudienceLaunchContext;
    private final PkEnterCheck pkCheck;
    private Long preloadBattleID;
    private boolean recordP1;
    private boolean recordPreload;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private long startLoadBeginTimeMs;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/PkDoubleAudienceDataContext$BattleStatsFromType;", "", "Default", "OpenIM", "PKingInRoom", "SEI", "PKingNoBlood", "NoFinishIM", "Feed", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleStatsFromType extends Enum<BattleStatsFromType> {
        public static final BattleStatsFromType Default = null;
        public static final BattleStatsFromType Feed = null;
        public static final BattleStatsFromType NoFinishIM = null;
        public static final BattleStatsFromType OpenIM = null;
        public static final BattleStatsFromType PKingInRoom = null;
        public static final BattleStatsFromType PKingNoBlood = null;
        public static final BattleStatsFromType SEI = null;
        public static final /* synthetic */ BattleStatsFromType[] a = null;

        static {
            BattleStatsFromType r1 = new BattleStatsFromType("Default", 0);
            Default = r1;
            BattleStatsFromType r2 = new BattleStatsFromType("OpenIM", 1);
            OpenIM = r2;
            BattleStatsFromType r3 = new BattleStatsFromType("PKingInRoom", 2);
            PKingInRoom = r3;
            BattleStatsFromType r4 = new BattleStatsFromType("SEI", 3);
            SEI = r4;
            BattleStatsFromType r5 = new BattleStatsFromType("PKingNoBlood", 4);
            PKingNoBlood = r5;
            BattleStatsFromType r6 = new BattleStatsFromType("NoFinishIM", 5);
            NoFinishIM = r6;
            BattleStatsFromType r7 = new BattleStatsFromType("Feed", 6);
            Feed = r7;
            a = new BattleStatsFromType[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static BattleStatsFromType valueOf(String r1) {
            return (BattleStatsFromType) r27.a.a(BattleStatsFromType.class, r1);
        }

        public static BattleStatsFromType[] values() {
            return (BattleStatsFromType[]) a.clone();
        }

        public BattleStatsFromType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ PkDoubleAudienceDataContext a;

        public a(PkDoubleAudienceDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            h r0 = PkDoubleAudienceDataContext.access$getRevLinkPreloadService$p(this.a);
            if (r0 == null) goto L5;
            r0.g();
        L5:
            PkEnterCheck r1 = PkDoubleAudienceDataContext.access$getPkCheck$p(this.a);
            r1.k = null;
            r1.j.clear();
            PkDoubleAudienceDataContext.access$getCd$p(this.a).clear();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r2 = this.a.getAnchorAudioPunishManager();
            if (r2 == null) goto L9;
            r2.detach();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext$attach$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03571 implements h.c {
        public final /* synthetic */ PkDoubleAudienceDataContext a;
        public final /* synthetic */ int b;

        @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h.c
        public final void a() {
            jy0.b.c("ttlive_PkDoubleDataContext", "link_preload PkAudienceDataContext preload getBattleStats failed", null, 4);
            PkDoubleAudienceDataContext.access$getBattleStatsForAudienceEnterRoom(this.a, this.b);
        }

        public C03571(PkDoubleAudienceDataContext r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.service.h.c
        public final void b(final long r14, final long r16, final ExtraResponse<r, Extra> r18, boolean r19) {
            Intrinsics.checkNotNullParameter(r18, "preloadData");
            jy0.b.c("ttlive_PkDoubleDataContext", "link_preload hit preload cache logID: " + r18.logId + ", preload=" + ((r) r18.data), null, 4);
            PkDoubleAudienceDataContext.access$getPkEnterRoomTracer$p(this.a);
            PkDoubleAudienceDataContext.access$getPkEnterRoomTracer$p(this.a);
            r r0 = (r) r18.data;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getBattleStatsMeta() != null) goto L8;
            return;
        L8:
            if (r19 == false) goto L12;
            y41.f r1 = y41.f.N;
            r1.getClass();
            if (((Boolean) y41.f.u.getValue(r1, y41.f.a[19])).booleanValue() == false) goto L12;
            boolean r12 = true;
        L13:
            p0.a(0, false, r12, new PkDoubleAudienceDataContext$attach$1$notifyV2$1(this, r18, r16, r14), 3);
            return;
        L12:
            r12 = false;
            goto L13
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkDoubleAudienceDataContext a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1 c;

        public c(PkDoubleAudienceDataContext r1, String r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            z r0 = PkDoubleAudienceDataContext.access$getMultiPkMonitor$p(this.a);
            if (r0 == null) goto L5;
            z.p(r0, 1, this.a.getChannelIdField(), r9, this.b, "pkSeiCheck");
        L5:
            Function1 r1 = this.c;
            if (r1 == null) goto L15;
            if (r9 == null) goto L13;
            r r2 = (r) r9.data;
            if (r2 == null) goto L13;
            c3 r3 = r2.getBattleStatsMeta();
            if (r3 == null) goto L13;
            long r4 = r3.getBattleId();
        L14:
            Unit r5 = (Unit) r1.invoke(Long.valueOf(r4));
        L13:
            r4 = 0;
        L15:
            if (r9 == null) goto L23;
            r r6 = (r) r9.data;
            if (r6 != null) goto L19;
            return;
        L19:
            if (r6.getBattleStatsMeta() == null) goto L25;
            this.a.getDoublePkContext().setBattleStatsObtained(1);
            this.a.getDoublePkContext().getBasePKContext().notifyPkContext((r) r9.data, false);
            return;
        L25:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkDoubleAudienceDataContext a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public d(PkDoubleAudienceDataContext r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            Throwable r7 = (Throwable) r9;
            z r0 = PkDoubleAudienceDataContext.access$getMultiPkMonitor$p(this.a);
            if (r0 == null) goto L5;
            r0.o(1, this.a.getChannelIdField(), null, this.b, "pkSeiCheck", r7);
        L5:
            com.bytedance.android.live.revlink.impl.monitor.b r10 = PkDoubleAudienceDataContext.access$getPkEnterRoomTracer$p(this.a);
            if (r10 == null) goto L12;
            int r1 = this.c;
            t.a(this.d);
            if (r1 != BattleStatsFromType.PKingInRoom.ordinal()) goto L13;
            i97.a r2 = i97.a.a;
            r10.b = System.currentTimeMillis();
            return;
        L13:
            return;
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void resetPeakData() {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public String theme() {
        return "";
    }

    private final w31.a getConnectionDataLogUtils() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConnectionDataLogUtils();
    }

    private final boolean getInPk() {
        return this.doublePkContext.getBasePKContext().getCurPKBaseState().a();
    }

    private final r31.a getLinkNetwork() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkNetwork();
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

    private final z getMultiPkMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiPkMonitor();
    }

    private final b21.d getPkBaseMonitor() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkBaseMonitor();
    }

    private final com.bytedance.android.live.revlink.impl.monitor.b getPkEnterRoomTracer() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkEnterRoomTracer();
    }

    private final s getRevLinkCommonUtil() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    private final h getRevLinkPreloadService() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.wo();
    }

    private final void tryP1BattleIDBackup() {
        if (this.recordPreload == true) goto L5;
        return;
    L5:
        if (this.recordP1 == false) goto L19;
        long r0 = this.p1BattleID;
        Long r2 = this.preloadBattleID;
        if (r2 != null) goto L11;
    L12:
        d51.c r1 = d51.c.A0;
        r1.getClass();
        if (((Boolean) d51.c.F.getValue(r1, d51.c.a[30])).booleanValue() == false) goto L18;
        jy0.b.c("ttlive_PkDoubleDataContext", "link_preload battleID diff recall getBattleStats for backup", null, 4);
        PkStateMachineController.e(this.doublePkContext.getBasePKContext().getStateMachineController(), PkBaseStateMachine.Source.MetaUpdate, "enter_room_in_pk", this.channelIdField, 56);
        return;
    L18:
        return;
    L11:
        if (r0 != r2.longValue()) goto L12;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void attach() {
        if (this.loadType != IPkAudienceLoadService.LoadType.MessageLoad) goto L5;
        int r0 = BattleStatsFromType.OpenIM.ordinal();
    L6:
        BattleStatsFromType.OpenIM.ordinal();
        if (u41.b.i.b() == false) goto L21;
        h r5 = getRevLinkPreloadService();
        if (r5 == null) goto L21;
        s r1 = getRevLinkCommonUtil();
        if (r1 == null) goto L15;
        IRoomBase r2 = r1.a();
        if (r2 == null) goto L15;
        long r6 = IRoomKtKt.getId(r2);
    L16:
        i97.a r3 = i97.a.a;
        if (r5.a(r6, 0, System.currentTimeMillis(), false) != true) goto L21;
        jy0.b.c("ttlive_PkDoubleDataContext", "link_preload valid preload data register data listener", null, 4);
        h r4 = getRevLinkPreloadService();
        if (r4 == null) goto L22;
        r4.e(new C03571(this, r0));
    L22:
        jy0.b.c("ttlive_PkDoubleDataContext", "start pk by battle stats", null, 4);
        return;
    L15:
        r6 = 0;
    L21:
        getBattleStatsForAudienceEnterRoom(r0);
        goto L22
    L5:
        r0 = BattleStatsFromType.PKingInRoom.ordinal();
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public int duration() {
        IBaseBattleSetting r0 = this.doublePkContext.getBasePKContext().getCurBattleSetting();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return (int) r0.getDuration();
    }

    public final IRoom getRoom() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.roomService;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L7;
        IRoomBase r2 = r1.getCommonRoom();
    L9:
        return (IRoom) r2;
    L7:
        r2 = null;
        goto L9
    }

    public IBaseUser guestUserEx() {
        return (IBaseUser) this.doublePkContext.m605getGuestUser().getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public String guestUserId() {
        return this.doublePkContext.getGuestUid();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public int matchType() {
        return this.doublePkContext.getMatchTypeField();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.a
    public void reportUiFirstLoad() {
        if (this.startLoadBeginTimeMs <= 0) goto L46;
        u41.d r1 = u41.d.n;
        r1.getClass();
        if (((Boolean) u41.d.k.getValue(r1, u41.d.a[9])).booleanValue() == false) goto L47;
        i97.a r2 = i97.a.a;
        long r3 = System.currentTimeMillis() - this.startLoadBeginTimeMs;
        if (r3 <= 0) goto L43;
        LiveFullLinkPKMonitor r5 = getLiveFullLinkPKMonitor();
        if (r5 == null) goto L43;
        LogCommon r6 = LogCommon.PAGE_SOURCE_LOG;
        mz0.e<?> r7 = mz0.d.b(r6);
        String r9 = "";
        if (r7 == null) goto L17;
        Map<String, String> r8 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r7).getMap();
        if (r8 == null) goto L17;
        String r10 = r8.get("enter_from_merge");
        if (r10 == null) goto L17;
    L18:
        mz0.e<?> r12 = mz0.d.b(r6);
        if (r12 == null) goto L26;
        Map<String, String> r13 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r12).getMap();
        if (r13 == null) goto L26;
        String r14 = r13.get("enter_method");
        if (r14 == null) goto L26;
        r9 = r14;
    L26:
        Intrinsics.checkNotNullParameter(r10, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r9, "enterMethod");
        JSONObject r15 = new JSONObject();
        int r16 = y50.b.a;
        y50.b.a.c(r15, Constants.Keys.duration, r3);
        y50.b.a.d(r15, "enter_from_merge", r10);
        y50.b.a.d(r15, "enter_method", r9);
        Intrinsics.checkNotNullParameter(r15, "extra");
        y50.b.a.d(r15, "business_api_name", "live_pk_audience_load");
        r5.d(r15);
        JSONObject r17 = new JSONObject();
        JSONObject r18 = new JSONObject();
        JSONObject r19 = new JSONObject();
        Intrinsics.checkNotNullParameter(r19, "extra");
        Intrinsics.checkNotNullParameter(r18, "metric");
        EventModule r4 = EventModule.PK;
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        String r110 = r4.getValue();
        EventType r20 = EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r20, "eventType");
        String r111 = r20.getValue();
        Intrinsics.checkNotNullParameter(r19, "map");
        Iterator<String> r22 = r15.keys();
    L28:
        if (r22.hasNext() == false) goto L30;
        String r23 = r22.next();
        Object r112 = r15.get(r23);
        Intrinsics.checkNotNullParameter(r23, "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        r19.put(r23, r112);
        goto L28
    L30:
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        m.e.getClass();
        Object r25 = m.b(r24).b(n97.a.class);
        Intrinsics.checkNotNull(r25);
        ((com.bytedance.live.kmp.core.c) r25).g("ttlive_pk_business_api_call", r110, r111, r17, r18, r19);
        HashMap r26 = new HashMap();
        r26.put("business_api_name", "live_pk_audience_load");
        com.bytedance.android.livesdk.revenue.service.room.c r27 = r5.n;
        int r28 = 1;
        if (r27 == null) goto L37;
        com.bytedance.android.livesdk.revenue.room.a r29 = r27.getRoomContext();
        if (r29 == null) goto L37;
        if (r29.getCommonIsAnchor() != true) goto L37;
        r28 = 2;
    L40:
        r26.put("role_type", Integer.valueOf(r28));
        r26.put("android_event_key", "live_pk_audience_load");
        com.bytedance.android.live.revenuelink.f r30 = r5.i();
        if (r30 == null) goto L43;
        com.bytedance.android.live.revenuelink.f.a.a(r30, "ttlive_pk_business_api_call", LiveTracingMonitorKt.EventModule.PK, r26, r15);
    L37:
        Object r32 = m.b(r24).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r32);
        if (((com.bytedance.live.kmp.core.c) r32).Sl() == false) goto L40;
        r28 = 3;
    L17:
        r10 = "";
    L43:
        this.startLoadBeginTimeMs = 0;
        return;
    L47:
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public long channelId() {
        return this.channelIdField;
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.a getAnchorAudioPunishManager() {
        return this.anchorAudioPunishManager;
    }

    public List<p> getAnchorList() {
        return this.anchorList;
    }

    public final long getChannelIdField() {
        return this.channelIdField;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public String getConnectSource() {
        return this.connectSource;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.context;
    }

    public final PkDoubleDataContext getDoublePkContext() {
        return this.doublePkContext;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.f
    public IPkAudienceLoadService.LoadType getLoadType() {
        return this.loadType;
    }

    public static final /* synthetic */ ArrayList access$getAnchorList$p(PkDoubleAudienceDataContext r0) {
        return r0.anchorList;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkDoubleAudienceDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ boolean access$getInPk$p(PkDoubleAudienceDataContext r0) {
        return r0.getInPk();
    }

    public static final /* synthetic */ ld.a access$getLinkDataSet$p(PkDoubleAudienceDataContext r0) {
        return r0.linkDataSet;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.global.c access$getLinkFakeGlobalService$p(PkDoubleAudienceDataContext r0) {
        return r0.linkFakeGlobalService;
    }

    public static final /* synthetic */ z access$getMultiPkMonitor$p(PkDoubleAudienceDataContext r0) {
        return r0.getMultiPkMonitor();
    }

    public static final /* synthetic */ PkEnterCheck access$getPkCheck$p(PkDoubleAudienceDataContext r0) {
        return r0.pkCheck;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.monitor.b access$getPkEnterRoomTracer$p(PkDoubleAudienceDataContext r0) {
        return r0.getPkEnterRoomTracer();
    }

    public static final /* synthetic */ Long access$getPreloadBattleID$p(PkDoubleAudienceDataContext r0) {
        return r0.preloadBattleID;
    }

    public static final /* synthetic */ boolean access$getRecordPreload$p(PkDoubleAudienceDataContext r0) {
        return r0.recordPreload;
    }

    public static final /* synthetic */ s access$getRevLinkCommonUtil$p(PkDoubleAudienceDataContext r0) {
        return r0.getRevLinkCommonUtil();
    }

    public static final /* synthetic */ h access$getRevLinkPreloadService$p(PkDoubleAudienceDataContext r0) {
        return r0.getRevLinkPreloadService();
    }

    public static final /* synthetic */ void access$tryP1BattleIDBackup(PkDoubleAudienceDataContext r0) {
        r0.tryP1BattleIDBackup();
    }

    private final void firstCreateLog(List<? extends p> r12) {
        if (this.isFirstCreate == false) goto L80;
        w31.a r0 = getConnectionDataLogUtils();
        if (r0 != null) goto L7;
    L8:
        w31.a r1 = getConnectionDataLogUtils();
        String r2 = "";
        String r3 = null;
        if (r1 == null) goto L61;
        IPkAudienceLoadService.LoadType r4 = this.loadType;
        if (r4 != null) goto L13;
    L60:
        r2 = DataType.Normal;
        goto L61
    L13:
        if (r4 != IPkAudienceLoadService.LoadType.RoomSyncLoad) goto L59;
        ArrayList r5 = new ArrayList();
        if (r12 == null) goto L22;
        Iterator<T> r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L36;
        IBaseUser r6 = ((p) r13.next()).getUser();
        if (r6 == null) goto L18;
        r5.add(Long.valueOf(n.a(r6)));
    L36:
        Iterator r14 = r5.iterator();
    L38:
        if (r14.hasNext() == false) goto L60;
        long r7 = ((Number) r14.next()).longValue();
        if (r7 <= 0) goto L38;
        com.bytedance.android.live.revlink.impl.global.c r8 = r1.f;
        if (r8 == null) goto L44;
        s r9 = r8.getRevLinkCommonUtil();
    L45:
        if (r9 == null) goto L48;
        if (r7 == r9.d()) goto L38;
    L48:
        String r10 = String.valueOf(r7);
        mz0.e<?> r15 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r15 instanceof mz0.f) == true) goto L51;
        r15 = null;
    L51:
        mz0.f r16 = (mz0.f) r15;
        if (r16 == null) goto L55;
        String r17 = r16.b();
        if (r17 == null) goto L55;
    L57:
        if (Intrinsics.areEqual(r10, r17) == false) goto L38;
        r2 = "link_guide";
    L55:
        r17 = "";
        goto L57
    L44:
        r9 = null;
        goto L45
    L22:
        com.bytedance.android.live.revlink.impl.global.c r18 = r1.f;
        if (r18 == null) goto L25;
        q r19 = r18.getPkUtils();
    L26:
        if (r19 == null) goto L34;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r110 = r19.g();
        if (r110 == null) goto L34;
        LiveData<IBaseUser> r111 = r110.getGuestUser();
        if (r111 == null) goto L34;
        IBaseUser r112 = (IBaseUser) r111.getValue();
        if (r112 == null) goto L34;
        long r20 = n.a(r112);
    L35:
        r5.add(Long.valueOf(r20));
    L34:
        r20 = 0;
        goto L35
    L25:
        r19 = null;
        goto L26
    L59:
        r2 = "transform";
    L61:
        this.connectSource = r2;
        com.bytedance.android.live.revlink.impl.global.c r113 = this.linkFakeGlobalService;
        if (r113 == null) goto L64;
        C03581 r22 = C03581.INSTANCE;
        Intrinsics.checkNotNullParameter(r113, "$this$enterScope");
        Intrinsics.checkNotNullParameter(r22, "scope");
        r3 = (String) r22.invoke(new com.bytedance.android.live.revlink.link.biz.service.h(r113));
    L64:
        this.connectSource = String.valueOf(r3);
        this.isFirstCreate = false;
        return;
    L7:
        if (r0.a != true) goto L8;
        return;
    }

    private final void getBattleStatsForAudienceBackup(Function1<? super Long, Unit> r19) {
        i97.a r0 = i97.a.a;
        long r4 = SystemClock.elapsedRealtime();
        int r3 = BattleStatsFromType.PKingInRoom.ordinal();
        if (getMergePkHelper() == null) goto L5;
        String r1 = d21.d.c(r3);
    L6:
        String r2 = r1;
        jy0.b.f(TAG, "getBattleStatsForAudienceBackup channelId=" + this.channelIdField, null, 4);
        r31.a r5 = getLinkNetwork();
        if (r5 == null) goto L26;
        long r8 = this.channelIdField;
        long r10 = 2;
        s r6 = getRevLinkCommonUtil();
        if (r6 == null) goto L11;
        long r14 = r6.d();
    L12:
        long r15 = r14;
        IRoom r7 = getRoom();
        if (r7 == null) goto L15;
        String r17 = IRoomKt_androidKt.getOwnerUserIdString(r7);
    L16:
        Observable r9 = r5.O(r8, r10, 1, true, r2, r15, r17);
        if (r9 == null) goto L27;
        int r12 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Observable r13 = r9.subscribeOn(Schedulers.io());
        if (r13 == null) goto L28;
        Observable r16 = r13.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L29;
        Disposable r18 = r16.subscribe(new c(this, r2, r19), new d(this, r2, r3, r4));
        if (r18 == null) goto L30;
        com.bytedance.revenue.platform.api.core.rx.f.a(r18, this.cd);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L15:
        r17 = null;
        goto L16
    L11:
        r14 = 0;
        goto L12
    L26:
        return;
    L5:
        r1 = "";
        goto L6
    }

    private final void getBattleStatsForAudienceEnterRoom(final int r10) {
        jy0.b.f(TAG, "getBattleStatsForAudienceEnterRoom " + r10, null, 4);
        this.doublePkContext.getBasePKContext().getStateMachineController().d(PkBaseStateMachine.Source.MetaUpdate, "enter_room_in_pk", this.channelIdField, new C03591(this), new AnonymousClass2(this, r10), new C03603(this, r10));
    }

    public String getLinkerID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
        return j.a.a(this, r2);
    }

    public String getUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$uid");
        return j.a.b(this, r2);
    }

    public void notifyRoomUpdate(long r3) {
        PkEnterCheck r0 = this.pkCheck;
        r0.b = true;
        r0.c = r3;
        r0.c();
        this.recordP1 = true;
        this.p1BattleID = r3;
        tryP1BattleIDBackup();
    }

    public final void setAnchorAudioPunishManager(com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r1) {
        this.anchorAudioPunishManager = r1;
    }

    public final void setChannelIdField(long r1) {
        this.channelIdField = r1;
    }

    public static final /* synthetic */ void access$firstCreateLog(PkDoubleAudienceDataContext r0, List r1) {
        r0.firstCreateLog(r1);
    }

    public static final /* synthetic */ void access$getBattleStatsForAudienceBackup(PkDoubleAudienceDataContext r0, Function1 r1) {
        r0.getBattleStatsForAudienceBackup(r1);
    }

    public static final /* synthetic */ void access$getBattleStatsForAudienceEnterRoom(PkDoubleAudienceDataContext r0, int r1) {
        r0.getBattleStatsForAudienceEnterRoom(r1);
    }

    public static final /* synthetic */ void access$setPreloadBattleID$p(PkDoubleAudienceDataContext r0, Long r1) {
        r0.preloadBattleID = r1;
    }

    public static final /* synthetic */ void access$setRecordPreload$p(PkDoubleAudienceDataContext r0, boolean r1) {
        r0.recordPreload = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void firstCreateLog$default(PkDoubleAudienceDataContext r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.firstCreateLog(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getBattleStatsForAudienceBackup$default(PkDoubleAudienceDataContext r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.getBattleStatsForAudienceBackup(r1);
    }

    public PkDoubleAudienceDataContext(long r20, String r22, com.bytedance.android.live.revlink.impl.control.launchcontext.d r23, ld.a r24, wq2.f r25, com.bytedance.android.livesdk.revenue.service.room.c r26, com.bytedance.android.live.revlink.impl.global.c r27, yz0.f r28, com.bytedance.android.livesdk.revenue.service.message.d r29, x11.a r30, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r32, PkBaseDataContext r33) {
        Intrinsics.checkNotNullParameter(r32, "context");
        this.channelIdField = r20;
        this.pkAudienceLaunchContext = r23;
        this.linkDataSet = r24;
        this.roomService = r26;
        this.linkFakeGlobalService = r27;
        this.context = r32;
        CompositeDisposable r12 = new CompositeDisposable();
        this.cd = r12;
        PkDoubleDataContext r13 = new PkDoubleDataContext(this.channelIdField, r22, false, r24, r25, r26, r27, r28, r29, r30, getContext(), this, r33);
        this.doublePkContext = r13;
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) com.bytedance.live.datacontext.d.a(new AnonymousClass1(this)).getSecond(), r12);
        IPkAudienceLoadService.LoadType r1 = IPkAudienceLoadService.LoadType.RoomSyncLoad;
        this.loadType = r1;
        this.preloadBattleID = 0L;
        PkEnterCheck r5 = new PkEnterCheck(r27);
        this.pkCheck = r5;
        this.anchorList = new ArrayList();
        this.isFirstCreate = true;
        this.connectSource = "";
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r12);
        r5.a(new AnonymousClass3(this));
        com.bytedance.android.live.revlink.impl.audience.g r2 = null;
        boolean r6 = false;
        if (r23 == null) goto L5;
        this.channelIdField = 0;
        r13.setDurationField(0);
        this.guestUserId = null;
        r13.getBasePKContext().setStartTimeMsField(0);
        r13.setMatchTypeField(0);
        this.startLoadBeginTimeMs = 0;
    L5:
        d51.c r0 = d51.c.A0;
        r0.getClass();
        ReadOnlyProperty r3 = d51.c.U;
        KProperty[] r4 = d51.c.a;
        if (((Boolean) r3.getValue(r0, r4[45])).booleanValue() == false) goto L22;
        String r7 = this.guestUserId;
        if (r7 != null) goto L10;
    L13:
        b21.d r8 = getPkBaseMonitor();
        if (r8 == null) goto L22;
        Intrinsics.checkNotNullParameter(r1, "loadType");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("load_type", r1.getType());
        com.bytedance.android.live.revlink.impl.global.c r10 = r8.a;
        if (r10 == null) goto L18;
        r2 = r10.Ee();
    L18:
        if (r2 == null) goto L20;
        r2.d(r9);
    L20:
        b21.d.e(r8, "double_pk_guest_uid_error", r9, r1.getType(), null, 20);
        goto L22
    L10:
        if (r7.length() <= 0) goto L12;
        r6 = true;
    L12:
        if (r6 != true) goto L13;
    L22:
        if (((Boolean) d51.c.H.getValue(r0, r4[32])).booleanValue() == true) goto L25;
        attach();
        return;
    }

    public /* synthetic */ PkDoubleAudienceDataContext(long r16, String r18, com.bytedance.android.live.revlink.impl.control.launchcontext.d r19, ld.a r20, wq2.f r22, com.bytedance.android.livesdk.revenue.service.room.c r23, com.bytedance.android.live.revlink.impl.global.c r24, yz0.f r25, com.bytedance.android.livesdk.revenue.service.message.d r26, x11.a r27, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r28, PkBaseDataContext r29, int r210, DefaultConstructorMarker r30) {
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
