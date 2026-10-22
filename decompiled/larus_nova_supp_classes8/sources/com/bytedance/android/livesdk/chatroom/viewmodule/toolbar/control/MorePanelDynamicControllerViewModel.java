package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import am2.x;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.PanelWidget;
import com.bytedance.android.live.base.model.morepanel.AreaPattern;
import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.PanelButtonStatusSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x2;
import com.bytedance.android.livesdk.config.ga0;
import com.bytedance.android.livesdk.config.ia0;
import com.bytedance.android.livesdk.config.ja0;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.depend.model.live.LoadStrategy;
import com.bytedance.android.livesdkapi.depend.model.live.MorePanelData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalScene;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u008e\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u00052\u00020\u0007:\u0002\u008e\u0001B\u0013\u0012\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017H\u0002J\u001e\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010%\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001aH\u0002J\u0016\u0010*\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150(H\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016J<\u00102\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010.2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0018\u00010.H\u0016J\u0010\u00105\u001a\u00020\b2\u0006\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u00020\bH\u0014J\u0012\u00108\u001a\u0004\u0018\u00010!2\u0006\u00107\u001a\u00020#H\u0016J\u0012\u00108\u001a\u0004\u0018\u00010!2\u0006\u00109\u001a\u00020\u001aH\u0016J\b\u0010:\u001a\u00020\u0012H\u0016J\u0012\u0010<\u001a\u0004\u0018\u00010;2\u0006\u00107\u001a\u00020#H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J\u0016\u0010@\u001a\u00020\b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020#0>H\u0016J\"\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120.H\u0016J\b\u0010C\u001a\u00020\u0012H\u0016J\b\u0010D\u001a\u00020\u0012H\u0016J$\u0010G\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u000b2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0.H\u0016J\b\u0010H\u001a\u00020\bH\u0016J\u0010\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020IH\u0016J\u0010\u0010N\u001a\u00020\b2\u0006\u0010M\u001a\u00020LH\u0016J\u0010\u0010O\u001a\u00020\b2\u0006\u0010M\u001a\u00020LH\u0016R\u0014\u0010P\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ZR\u0016\u0010[\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR$\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010^\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0014\u0010_\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b_\u0010ZR\u0014\u0010`\u001a\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010ZR\u0016\u0010c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010g\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010fR\u0016\u0010h\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010dR\u0018\u0010i\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR$\u0010l\u001a\u0004\u0018\u00010k8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010t\u001a\u0010\u0012\f\u0012\n s*\u0004\u0018\u00010L0L0r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR \u0010v\u001a\b\u0012\u0004\u0012\u00020L0\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\"\u0010z\u001a\u0010\u0012\f\u0012\n s*\u0004\u0018\u00010L0L0r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010uR \u0010{\u001a\b\u0012\u0004\u0012\u00020L0\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b{\u0010w\u001a\u0004\b|\u0010yR(\u0010~\u001a\u0004\u0018\u00010}8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001d\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0006¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008f\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/MorePanelDynamicControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/c;", "Lcom/bytedance/android/live/base/model/PanelWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/d;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/d;", "Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/k;", "", "sendPreLoadStatLog", "setLocalCacheDataFromBackend", "", "duration", "monitorReqTime", "afterDataChanged", "sendFirstClickStatLog", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/MorePanelInfoData;", "resp", "", "saveData", "patter", "", "getSavePatternDataDebugString", "", "newData", "getSaveDataDebugString", "", "from", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "getRequestObservable", "buildCommonParams", "widget", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/f;", "getStyleInfo", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/b;", "localButton", "canShowBySettingConfig", "showType", "matchScreenOrientation", "Lkotlin/Function0;", "msg", "printALog", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/control/a;", "dialogInterface", "checkDataBeforeShowDialog", "Lkotlin/Function1;", "successCallback", "", "failedCallback", "requestData", "Lio/reactivex/disposables/Disposable;", "dis", "bindDisposable", "onCleared", "model", "getServerConfigStyleInfo", "serverId", "needDynamicStatus", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/h;", "getDynamicStatus", "needDynamicSort", "", "list", "dynamicSort", "filter", "getDynamicData", "hasDynamicData", "isRequesting", "delayMills", "task", "showGuideEffect", "cancelShowEffect", "Llp1/a;", "buttonModel", "checkClickEffectButton", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/g$b;", "item", "notifyGuideButtonOnClick", "notifyGuideEffectOnShow", "HIDE_STATUS", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/h;", "Lio/reactivex/disposables/CompositeDisposable;", "cDispose", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/util/ArrayList;", "localCacheData", "Ljava/util/ArrayList;", "panelPatternCache", "Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;", "Z", "requestIsError", "mSuccessCallback", "Lkotlin/jvm/functions/Function1;", "mFailedCallback", "debugMode", "TAG", "Ljava/lang/String;", "isFirstClick", "initTime", "J", "preLoadDelayTime", "I", "maxPreLoadDelay", "reqTimeout", "showGuideEffectDp", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/BubbleEnv;", "bubbleEnv", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/BubbleEnv;", "getBubbleEnv", "()Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/BubbleEnv;", "setBubbleEnv", "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/BubbleEnv;)V", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "_onGuideButtonClick", "Lio/reactivex/subjects/PublishSubject;", "onGuideButtonClick", "Lio/reactivex/Observable;", "getOnGuideButtonClick", "()Lio/reactivex/Observable;", "_onGuideEffectShow", "onGuideEffectShow", "getOnGuideEffectShow", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/e;", "theGuideButton", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/e;", "getTheGuideButton", "()Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/e;", "setTheGuideButton", "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/data/e;)V", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getServerPanelPattern", "()Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;", "serverPanelPattern", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MorePanelDynamicControllerViewModel extends ViewModel implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c<PanelWidget>, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d<AreaPattern>, k {
    public static final Companion Companion = null;
    private static final String MONITOR_NAME = "ttlive_request_more_panel_info_time";
    private static final String logName = "livesdk_more_panel_first_click_stat_log";
    private static final String preLoadLogName = "livesdk_more_panel_pre_load_stat_log";
    private final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h HIDE_STATUS;
    private final String TAG;
    private final PublishSubject<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> _onGuideButtonClick;
    private final PublishSubject<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> _onGuideEffectShow;
    private BubbleEnv bubbleEnv;
    private CompositeDisposable cDispose;
    private final DataCenter dataCenter;
    private final boolean debugMode;
    private long initTime;
    private boolean isFirstClick;
    private boolean isRequesting;
    private ArrayList<PanelWidget> localCacheData;
    private Function1<? super Throwable, Unit> mFailedCallback;
    private Function1<? super Boolean, Unit> mSuccessCallback;
    private int maxPreLoadDelay;
    private final Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> onGuideButtonClick;
    private final Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> onGuideEffectShow;
    private AreaPattern panelPatternCache;
    private int preLoadDelayTime;
    private long reqTimeout;
    private boolean requestIsError;
    private Disposable showGuideEffectDp;
    private com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e theGuideButton;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static ViewModel a(DataCenter r4) {
            RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4, 0, 2);
            if (r5 == null) goto L7;
            com.bytedance.live.datacontext.j r6 = r5.getMorePanelDynamicController();
            if (r6 == null) goto L7;
            ViewModel r7 = (ViewModel) r6.getValue();
        L9:
            if ((r7 instanceof Object) == true) goto L12;
            return null;
        L12:
            return r7;
        L7:
            r7 = null;
            goto L9
        }

        @JvmStatic
        public static void b(final DataCenter r4) {
            if (t.a() == false) goto L11;
            if (r4 == null) goto L12;
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r4, 0, 2);
            if (r0 == null) goto L13;
            com.bytedance.live.datacontext.j r1 = r0.getMorePanelDynamicController();
            if (r1 == null) goto L14;
            r1.e(new MorePanelDynamicControllerViewModel$Companion$initOnce$1(r4));
            return;
        L14:
            return;
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MorePanelDynamicControllerViewModel a;

        public a(MorePanelDynamicControllerViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            MorePanelDynamicControllerViewModel.access$sendPreLoadStatLog(this.a);
            if (MorePanelDynamicControllerViewModel.access$isRequesting$p(this.a) == false) goto L5;
        L8:
            MorePanelDynamicControllerViewModel.access$printALog(this.a, MorePanelDynamicControllerViewModel$2$1.INSTANCE);
            return;
        L5:
            if ((!MorePanelDynamicControllerViewModel.access$getLocalCacheData$p(this.a).isEmpty()) == true) goto L8;
            this.a.requestData(1, null, null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MorePanelDynamicControllerViewModel a;
        public final /* synthetic */ long b;

        public b(MorePanelDynamicControllerViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            final com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            final long r0 = SystemClock.uptimeMillis();
            MorePanelDynamicControllerViewModel.access$printALog(this.a, new MorePanelDynamicControllerViewModel$requestData$3$1(this, r7, r0));
            MorePanelDynamicControllerViewModel.access$monitorReqTime(this.a, r0 - this.b);
            MorePanelDynamicControllerViewModel.access$setRequesting$p(this.a, false);
            MorePanelInfoData r8 = (MorePanelInfoData) ((ExtraResponse) r7).data;
            if (r8 == null) goto L12;
            final boolean r9 = MorePanelDynamicControllerViewModel.access$saveData(this.a, r8);
            MorePanelDynamicControllerViewModel.access$printALog(this.a, new MorePanelDynamicControllerViewModel$requestData$3$2$1(r9));
            if (r9 == false) goto L7;
            MorePanelDynamicControllerViewModel.access$afterDataChanged(this.a);
        L7:
            MorePanelDynamicControllerViewModel.access$setRequestIsError$p(this.a, false);
            Function1 r1 = MorePanelDynamicControllerViewModel.access$getMSuccessCallback$p(this.a);
            if (r1 == null) goto L10;
            Unit r10 = (Unit) r1.invoke(Boolean.valueOf(r9));
        L10:
            MorePanelDynamicControllerViewModel.access$setMSuccessCallback$p(this.a, null);
            MorePanelDynamicControllerViewModel.access$setMFailedCallback$p(this.a, null);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MorePanelDynamicControllerViewModel a;

        public c(MorePanelDynamicControllerViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final Throwable r4 = (Throwable) r3;
            MorePanelDynamicControllerViewModel.access$printALog(this.a, new MorePanelDynamicControllerViewModel$requestData$4$1(r4));
            MorePanelDynamicControllerViewModel.access$setRequesting$p(this.a, false);
            MorePanelDynamicControllerViewModel.access$setRequestIsError$p(this.a, true);
            Function1 r0 = MorePanelDynamicControllerViewModel.access$getMFailedCallback$p(this.a);
            if (r0 == null) goto L5;
            Unit r5 = (Unit) r0.invoke(r4);
        L5:
            MorePanelDynamicControllerViewModel.access$setMSuccessCallback$p(this.a, null);
            MorePanelDynamicControllerViewModel.access$setMFailedCallback$p(this.a, null);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MorePanelDynamicControllerViewModel a;
        public final /* synthetic */ Function1 b;

        public d(MorePanelDynamicControllerViewModel r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.b.invoke(this.a);
        }
    }

    static {
        Companion = new Companion();
    }

    private final void afterDataChanged() {
    }

    @JvmStatic
    public static final <T> T getInstance(DataCenter r1) {
        Companion.getClass();
        return (T) Companion.a(r1);
    }

    @JvmStatic
    public static final void initOnce(DataCenter r1) {
        Companion.getClass();
        Companion.b(r1);
    }

    private final void sendPreLoadStatLog() {
        Pair[] r1 = new Pair[2];
        if (hasDynamicData() == false) goto L5;
        String r2 = "1";
    L6:
        r1[0] = TuplesKt.to("hasData", r2);
        r1[1] = TuplesKt.to("preLoadDelayTime", String.valueOf(this.preLoadDelayTime));
        Map r3 = MapsKt.mapOf(r1);
        u.l().sendLog(preLoadLogName, r3, new Object[]{Room.class, x.class});
        return;
    L5:
        r2 = "0";
        goto L6
    }

    private final String buildCommonParams() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        RoomPermissionContext.a r2 = RoomPermissionContext.Companion;
        DataCenter r3 = this.dataCenter;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r4 = LiveRoomPermission.A;
        r2.getClass();
        r1.put("permission", RoomPermissionContext.a.e(r3, r4));
        r0.put("union_live", r1);
        JSONObject r5 = new JSONObject();
        boolean r6 = jc1.k.n(IInteractService.class).isMultiLinkScene();
        boolean r7 = RoomPermissionContext.a.e(this.dataCenter, LiveRoomPermission.u);
        boolean r8 = ((Boolean) vm2.h.M5.getValue(null, vm2.h.a[349(0x15d, float:4.89E-43)])).booleanValue();
        if (r7 == false) goto L7;
        if (r6 == false) goto L7;
        if (r8 == false) goto L7;
        boolean r9 = true;
    L8:
        r5.put("permission", r9);
        r0.put("linkmic_game", r5);
        r0.put("is_admin", com.bytedance.android.live.ktv.common.util.a.g());
        DataCenter r10 = this.dataCenter;
        if (r10 == null) goto L18;
        IExternalConfigJudger r11 = (IExternalConfigJudger) r10.get("data_live_exter_config_judger", null);
        if (r11 == null) goto L18;
        LiveExternalScene r12 = r11.getExternalScene();
        if (r12 == null) goto L18;
        String r13 = r12.getScene();
        if (r13 == null) goto L18;
        r0.put("live_distribution_scene", r13);
    L18:
        if (z.e(this.dataCenter, false) == true) goto L23;
        Integer r14 = MoreMixSharePanelUtils.INSTANCE.getMorePanelVersion();
        if (r14 == null) goto L23;
        r0.put("version", r14.intValue());
    L23:
        return r0.toString();
    L7:
        r9 = false;
        goto L8
    }

    private final void sendFirstClickStatLog() {
        if (this.initTime != (-1)) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis() - this.initTime;
        String r3 = "1";
        if (hasDynamicData() == false) goto L8;
        Object r2 = "1";
    L10:
        if (this.isRequesting == true) goto L13;
        r3 = "0";
    L13:
        Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("firstClickTime", String.valueOf(r0)), TuplesKt.to("hasData", r2), TuplesKt.to("isPreLoading", r3), TuplesKt.to("preLoadTime", String.valueOf(this.preLoadDelayTime))});
        u.l().sendLog(logName, r1, new Object[]{Room.class, x.class});
        return;
    L8:
        r2 = "0";
        goto L10
    }

    private final void setLocalCacheDataFromBackend() {
        if (this.isRequesting == false) goto L5;
        return;
    L5:
        if ((!this.localCacheData.isEmpty()) == true) goto L28;
        IRoomModuleService r1 = jc1.k.f(IRoomModuleService.class);
        if (r1 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.room.backend.g r3 = r1.getLiveRoomBackendUtils();
        if (r3 == null) goto L27;
        DataCenter r2 = this.dataCenter;
        if (r2 == null) goto L16;
        Room r4 = z.o(r2);
        if (r4 == null) goto L16;
        Long r5 = Long.valueOf(r4.id);
    L17:
        long r6 = r5.longValue();
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        C04391 r8 = C04391.INSTANCE;
        Function3<MorePanelInfoData, BackendGeneratedData, BackendItem, Unit> r10 = new C04402(this);
        CompositeDisposable r13 = this.cDispose;
        a50.a r9 = (a50.a) LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r9 != null) goto L20;
    L22:
        boolean r14 = false;
    L23:
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r3, r6, r7, MorePanelInfoData.class, r8, null, r10, null, null, r13, r14, false, 3152);
        return;
    L20:
        if (r9.h() != true) goto L22;
        r14 = true;
    L16:
        r5 = null;
        goto L17
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public void cancelShowEffect() {
        Disposable r0 = this.showGuideEffectDp;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d
    public boolean hasDynamicData() {
        return !this.localCacheData.isEmpty();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public boolean needDynamicSort() {
        int r0 = h.a;
        return !h.a(z.o(this.dataCenter));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public boolean needDynamicStatus() {
        int r0 = h.a;
        return !h.a(z.o(this.dataCenter));
    }

    public void onCleared() {
        printALog(C04361.INSTANCE);
        this.isRequesting = false;
        this.mSuccessCallback = null;
        this.mFailedCallback = null;
        SparseArray<Object> r0 = j.a;
        j.a.clear();
        this.cDispose.clear();
        cancelShowEffect();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d
    public /* bridge */ /* synthetic */ AreaPattern getServerPanelPattern() {
        return getServerPanelPattern();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public BubbleEnv getBubbleEnv() {
        return this.bubbleEnv;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> getOnGuideButtonClick() {
        return this.onGuideButtonClick;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> getOnGuideEffectShow() {
        return this.onGuideEffectShow;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e getTheGuideButton() {
        return this.theGuideButton;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d
    public boolean isRequesting() {
        return this.isRequesting;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.d
    public AreaPattern getServerPanelPattern() {
        return this.panelPatternCache;
    }

    public MorePanelDynamicControllerViewModel(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.dataCenter = r5;
        this.HIDE_STATUS = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h(2, PanelButtonStatusSource.DYNAMIC_CONFIG, "");
        this.cDispose = new CompositeDisposable();
        this.localCacheData = new ArrayList();
        boolean r0 = true;
        this.debugMode = true;
        this.TAG = "MorePanelDynamic";
        this.isFirstClick = true;
        this.initTime = -1;
        this.preLoadDelayTime = 1;
        this.maxPreLoadDelay = 10;
        this.reqTimeout = 10;
        this.initTime = SystemClock.uptimeMillis();
        if (x2.b == true) goto L6;
        ToolbarButton.ROOM_CHANNEL.setServerId(31);
        ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE.setServerId(5);
        ToolbarButton.SHARE.setServerId(20);
        ToolbarButton.LIVE_IM_ENTRANCE_MORE.setServerId(21);
        ToolbarButton.PROMPT.setServerId(1001);
        ToolbarButton.WISH_LIST.setServerId(1002);
        ToolbarButton.VOTE.setServerId(1003);
        ToolbarButton.MANAGE.setServerId(1004);
        ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE.setServerId(1005);
        ToolbarButton.DOU_PLUS_PROMOTE.setServerId(1005);
        ToolbarButton.BARRAGE_SETTING.setServerId(1006);
        ToolbarButton.GIFT_EFFECT.setServerId(1007);
        ToolbarButton.CLEAR_SCREEN.setServerId(1008);
        ToolbarButton.CLEAR_SCREEN_OPTIMIZE_OFF.setServerId(1008);
        ToolbarButton.CLEAR_SCREEN_OPTIMIZE_ON.setServerId(1008);
        ToolbarButton.CAST_SCREEN.setServerId(1009);
        ToolbarButton.PAD_AND_PC_PLAY.setServerId(1012);
        ToolbarButton.PLAY_SETTING.setServerId(1013);
        ToolbarButton.LIVE_FLOAT_WINDOW_PLAY.setServerId(1016);
        ToolbarButton.AUDIENCE_RECORD.setServerId(1035);
        ToolbarButton.RECORD_COMBINE.setServerId(1017);
        ToolbarButton.RECORD.setServerId(1017);
        ToolbarButton.VIP_IM.setServerId(1018);
        ToolbarButton.COLLECT.setServerId(1019);
        ToolbarButton.IN_ROOM_RESOLUTION.setServerId(1020);
        ToolbarButton.AUDIENCE_RESOLUTION.setServerId(1020);
        ToolbarButton.SCHEDULE_CLOSE.setServerId(1021);
        ToolbarButton.PREDICTOR_GUESS.setServerId(1022);
        ToolbarButton.REPORT.setServerId(1023);
        ToolbarButton.DISLIKE.setServerId(1024);
        ToolbarButton.LIKE_FEEDBACK.setServerId(1025);
        ToolbarButton.GIFT_CONSUMER_TOAST.setServerId(1026);
        ToolbarButton.MINOR_REFUND.setServerId(1027);
        ToolbarButton.REN_QI_BAO.setServerId(1028);
        ToolbarButton.LIVE_PICTURE_TYPE.setServerId(1029);
        ToolbarButton.LIVE_WIDGET.setServerId(1030);
        ToolbarButton.SHAKE_MATCH_SETTING.setServerId(1031);
        ToolbarButton.VS_INTERACTIVE.setServerId(1032);
        ToolbarButton.MARKETING_WIDGET_PIN_BUTTON.setServerId(1033);
        ToolbarButton.ASSEMBLED_SETTING.setServerId(1037);
        ToolbarButton.SHARE_TO_DAILY.setServerId(1034);
        ToolbarButton.AUDIO_SUBTITLE_SETTING.setServerId(1039);
        ToolbarButton.PLAY_QUALITY_OPT.setServerId(1044);
        ToolbarButton.AUDIENCE_PUBLIC_SCREEN_CONFIG.setServerId(1050);
        ToolbarButton.FollowerShare.setServerId(1053);
        ToolbarButton.SWITCH_ACCOUNT.setServerId(1054);
        ToolbarButton.COPY_LINK.setServerId(1056);
        ToolbarButton.QR_CODE.setServerId(1057);
        ToolbarButton.IM_LIST_VIRTUAL.setServerId(1058);
        ToolbarButton.WATCH_LATER.setServerId(1062);
        x2.b = true;
    L6:
        SparseArray<Object> r1 = j.a;
        setLocalCacheDataFromBackend();
        int r2 = h.a;
        Room r6 = z.o(r5);
        int r3 = t.a;
        if (r6 == null) goto L11;
        RoomOthersData r7 = r6.others;
        if (r7 == null) goto L11;
        MorePanelData r8 = r7.getMorePanelInfo();
    L12:
        if (r8 != null) goto L14;
    L15:
        if (r8 != null) goto L17;
    L19:
        r0 = false;
    L20:
        if (r0 == false) goto L22;
        this.preLoadDelayTime = ia0.a.getValue().intValue();
        int r9 = ja0.a.getValue().intValue();
        this.maxPreLoadDelay = r9;
        Random.Default r4 = Random.Default;
        int r10 = this.preLoadDelayTime;
        final int r11 = r4.nextInt(r10, r9 + r10);
        printALog(new AnonymousClass1(r11));
        RxUtilKt.c(Observable.timer(r11, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)), this.cDispose);
    L22:
        PublishSubject<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> r12 = PublishSubject.create();
        this._onGuideButtonClick = r12;
        this.onGuideButtonClick = r12;
        PublishSubject<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> r13 = PublishSubject.create();
        this._onGuideEffectShow = r13;
        this.onGuideEffectShow = r13;
        return;
    L17:
        if (r8.getLoadStrategy() != LoadStrategy.LoadStrategyUnknown.getValue()) goto L19;
    L14:
        if (r8.getLoadStrategy() == LoadStrategy.RequestWithRoomData.getValue()) goto L20;
    L11:
        r8 = null;
        goto L12
    }

    public static final /* synthetic */ void access$afterDataChanged(MorePanelDynamicControllerViewModel r0) {
        r0.afterDataChanged();
    }

    public static final /* synthetic */ ArrayList access$getLocalCacheData$p(MorePanelDynamicControllerViewModel r0) {
        return r0.localCacheData;
    }

    public static final /* synthetic */ Function1 access$getMFailedCallback$p(MorePanelDynamicControllerViewModel r0) {
        return r0.mFailedCallback;
    }

    public static final /* synthetic */ Function1 access$getMSuccessCallback$p(MorePanelDynamicControllerViewModel r0) {
        return r0.mSuccessCallback;
    }

    public static final /* synthetic */ AreaPattern access$getPanelPatternCache$p(MorePanelDynamicControllerViewModel r0) {
        return r0.panelPatternCache;
    }

    public static final /* synthetic */ boolean access$getRequestIsError$p(MorePanelDynamicControllerViewModel r0) {
        return r0.requestIsError;
    }

    public static final /* synthetic */ boolean access$isRequesting$p(MorePanelDynamicControllerViewModel r0) {
        return r0.isRequesting;
    }

    public static final /* synthetic */ void access$sendPreLoadStatLog(MorePanelDynamicControllerViewModel r0) {
        r0.sendPreLoadStatLog();
    }

    private final boolean canShowBySettingConfig(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b r5) {
        String r0 = ga0.a.getValue();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        if (r5 == null) goto L7;
        return StringsKt.contains$default(r0, r5.getComponentName(), false, 2, null);
    L7:
        return false;
    }

    private final Observable<com.bytedance.android.live.network.response.e<MorePanelInfoData>> getRequestObservable(int r6) {
        long r0 = z.o(this.dataCenter).id;
        String r2 = buildCommonParams();
        l.d().getClass();
        MorePanelControlApi r3 = (MorePanelControlApi) com.bytedance.android.live.network.c.b().e(MorePanelControlApi.class);
        if (r3 == null) goto L9;
        Observable<com.bytedance.android.live.network.response.e<MorePanelInfoData>> r7 = r3.queryMorePanelControlData(r0, r6, r2);
        if (r7 == null) goto L9;
        Observable r8 = r7.timeout(this.reqTimeout, TimeUnit.SECONDS);
        if (r8 == null) goto L9;
        return r8.compose(RxUtil.rxSchedulerHelper());
    L9:
        return null;
    }

    private final String getSaveDataDebugString(List<PanelWidget> r4) {
        StringBuilder r0 = new StringBuilder("fetch res:");
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        String r1 = ((PanelWidget) r5.next()).getName();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0.append(r1.concat(" "));
        goto L4
    L10:
        return r0.toString();
    }

    private final String getSavePatternDataDebugString(AreaPattern r5) {
        StringBuilder r0 = new StringBuilder("面板样式数据:");
        if (r5 == null) goto L19;
        List r6 = r5.getColumnElements();
        if (r6 == null) goto L19;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        ColumnElement r1 = (ColumnElement) r7.next();
        r0.append("\ntype:" + r1.getType());
        StringBuilder r2 = new StringBuilder("\twidget_ids:");
        List r3 = r1.getWidgetIds();
        if (r3 == null) goto L16;
        Object[] r4 = r3.toArray(new Integer[0]);
        if (r4 == null) goto L15;
        String r8 = Arrays.toString((Integer[]) r4);
    L17:
        r2.append(r8);
        r0.append(r2.toString());
        goto L8
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        r8 = null;
    L19:
        return r0.toString();
    }

    private final f getStyleInfo(PanelWidget r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        return new f(r4.getImageUrl(), r4.getTitle(), r4.getName());
    }

    private final boolean matchScreenOrientation(int r5) {
        if (r5 != 3) goto L6;
        return true;
    L6:
        if (((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L10;
        if (r5 == 1) goto L14;
    L12:
        return false;
    L14:
        return true;
    L10:
        if (r5 != 2) goto L12;
        return true;
    }

    private final void monitorReqTime(long r4) {
        LiveMonitor.a r0 = new LiveMonitor.a(MONITOR_NAME, LiveTracingMonitor.EventModule.common);
        r0.j(r4);
        r0.l(0);
        r0.c("live");
        r0.a().report();
    }

    private final void printALog(Function0<String> r2) {
        if (this.debugMode == true) goto L5;
        return;
    L5:
        ALogger.i(this.TAG, (String) r2.invoke());
    }

    private final boolean saveData(MorePanelInfoData r6) {
        final List<PanelWidget> r1 = null;
        if (r6 == null) goto L22;
        List<PanelArea> r7 = r6.getAreaList();
        if (r7 == null) goto L22;
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L15;
        Object r2 = r8.next();
        if (((PanelArea) r2).getType() != 2) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
    L16:
        PanelArea r4 = (PanelArea) r2;
        if (r4 == null) goto L22;
        AreaPattern r9 = r4.getAreaPattern();
        if (r9 == null) goto L21;
        this.panelPatternCache = r9;
    L21:
        r1 = r4.getDataList();
        goto L22
    L12:
        r3 = false;
        goto L13
    L15:
        r2 = null;
    L22:
        if (r1 == null) goto L24;
        printALog(new MorePanelDynamicControllerViewModel$saveData$$inlined$let$lambda$1(this, r1));
    L24:
        printALog(new C04382(this));
        boolean r10 = !this.localCacheData.equals(r1);
        if (r10 == false) goto L28;
        if (r1 == null) goto L28;
        this.localCacheData.clear();
        this.localCacheData.addAll(r1);
    L28:
        return r10;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d
    public void bindDisposable(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "dis");
        this.cDispose.add(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public void checkClickEffectButton(lp1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "buttonModel");
        if (r2.a() == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r3 = r2.c();
        if (r3 == null) goto L12;
        notifyGuideButtonOnClick(r3);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d
    public void checkDataBeforeShowDialog(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a r4) {
        Intrinsics.checkNotNullParameter(r4, "dialogInterface");
        boolean r1 = false;
        if (this.isFirstClick == false) goto L5;
        this.isFirstClick = false;
        sendFirstClickStatLog();
    L5:
        int r0 = h.a;
        Room r2 = z.o(this.dataCenter);
        if (h.a(r2) == false) goto L8;
        e r3 = new g();
    L20:
        r3.a(r4, this);
        return;
    L8:
        if (r2 == null) goto L12;
        RoomOthersData r5 = r2.others;
        if (r5 == null) goto L12;
        MorePanelData r6 = r5.getMorePanelInfo();
    L13:
        if (r6 != null) goto L15;
    L17:
        if (r1 == false) goto L19;
        r3 = new MorePanelBlockStrategy();
        goto L20
    L19:
        r3 = new MorePanelOnlyBlockOnceStrategy();
        goto L20
    L15:
        if (r6.getLoadStrategy() != LoadStrategy.Request.getValue()) goto L17;
        r1 = true;
    L12:
        r6 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public void dynamicSort(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        ArrayList<PanelWidget> r0 = this.localCacheData;
        if (r0.isEmpty() == false) goto L6;
        printALog(C04341.INSTANCE);
        return;
    L6:
        LinkedList r1 = new LinkedList(r9);
        r9.clear();
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L26;
        PanelWidget r3 = (PanelWidget) r2.next();
        Iterator r4 = r1.iterator();
    L10:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b r5 = null;
        if (r4.hasNext() == false) goto L18;
        Object r6 = r4.next();
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b) r6).getComponentId() != r3.getId()) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L10;
    L19:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b r8 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b) r6;
        if (r8 == null) goto L8;
        if (r1.remove(r8) == false) goto L24;
        r5 = r8;
    L24:
        if (r5 == null) goto L8;
        r9.add(r5);
        goto L8
    L15:
        r7 = false;
        goto L16
    L18:
        r6 = null;
        goto L19
    L26:
        Iterator r10 = r1.iterator();
    L28:
        if (r10.hasNext() == false) goto L30;
        r9.add((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b) r10.next());
        goto L28
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public List<PanelWidget> getDynamicData(Function1<? super PanelWidget, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "filter");
        ArrayList<PanelWidget> r0 = this.localCacheData;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((Boolean) r5.invoke(r3)).booleanValue() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h getDynamicStatus(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b r7) {
        Intrinsics.checkNotNullParameter(r7, "model");
        if (canShowBySettingConfig(r7) == false) goto L6;
        return null;
    L6:
        if (this.requestIsError == true) goto L8;
    L11:
        Iterator<T> r0 = this.localCacheData.iterator();
    L13:
        if (r0.hasNext() == false) goto L22;
        Object r2 = r0.next();
        PanelWidget r3 = (PanelWidget) r2;
        if (r3.getId() == r7.getComponentId()) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == false) goto L13;
    L23:
        PanelWidget r5 = (PanelWidget) r2;
        if (r5 != null) goto L28;
        return this.HIDE_STATUS;
    L28:
        if (r5.needGray() == false) goto L34;
        String r1 = r5.getToast();
        if (r1 != null) goto L33;
        r1 = "";
    L33:
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h(3, PanelButtonStatusSource.DYNAMIC_CONFIG, r1);
    L34:
        return null;
    L17:
        if (matchScreenOrientation(r3.getShowType()) == false) goto L19;
        r4 = true;
        goto L20
    L22:
        r2 = null;
        goto L23
    L8:
        if (this.localCacheData.isEmpty() == false) goto L11;
        printALog(C04351.INSTANCE);
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public f getServerConfigStyleInfo(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        Iterator<T> r0 = this.localCacheData.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((PanelWidget) r1).getId() != r5.getComponentId()) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return getStyleInfo((PanelWidget) r1);
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public void notifyGuideButtonOnClick(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this._onGuideButtonClick.onNext(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public void notifyGuideEffectOnShow(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this._onGuideEffectShow.onNext(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public void setBubbleEnv(BubbleEnv r1) {
        this.bubbleEnv = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public void setTheGuideButton(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1) {
        this.theGuideButton = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c
    public f getServerConfigStyleInfo(int r4) {
        Iterator<T> r0 = this.localCacheData.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((PanelWidget) r1).getId() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return getStyleInfo((PanelWidget) r1);
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public static final /* synthetic */ String access$getSaveDataDebugString(MorePanelDynamicControllerViewModel r0, List r1) {
        return r0.getSaveDataDebugString(r1);
    }

    public static final /* synthetic */ String access$getSavePatternDataDebugString(MorePanelDynamicControllerViewModel r0, AreaPattern r1) {
        return r0.getSavePatternDataDebugString(r1);
    }

    public static final /* synthetic */ void access$monitorReqTime(MorePanelDynamicControllerViewModel r0, long r1) {
        r0.monitorReqTime(r1);
    }

    public static final /* synthetic */ void access$printALog(MorePanelDynamicControllerViewModel r0, Function0 r1) {
        r0.printALog(r1);
    }

    public static final /* synthetic */ boolean access$saveData(MorePanelDynamicControllerViewModel r0, MorePanelInfoData r1) {
        return r0.saveData(r1);
    }

    public static final /* synthetic */ void access$setLocalCacheData$p(MorePanelDynamicControllerViewModel r0, ArrayList r1) {
        r0.localCacheData = r1;
    }

    public static final /* synthetic */ void access$setMFailedCallback$p(MorePanelDynamicControllerViewModel r0, Function1 r1) {
        r0.mFailedCallback = r1;
    }

    public static final /* synthetic */ void access$setMSuccessCallback$p(MorePanelDynamicControllerViewModel r0, Function1 r1) {
        r0.mSuccessCallback = r1;
    }

    public static final /* synthetic */ void access$setPanelPatternCache$p(MorePanelDynamicControllerViewModel r0, AreaPattern r1) {
        r0.panelPatternCache = r1;
    }

    public static final /* synthetic */ void access$setRequestIsError$p(MorePanelDynamicControllerViewModel r0, boolean r1) {
        r0.requestIsError = r1;
    }

    public static final /* synthetic */ void access$setRequesting$p(MorePanelDynamicControllerViewModel r0, boolean r1) {
        r0.isRequesting = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k
    public void showGuideEffect(long r2, Function1<? super k, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        cancelShowEffect();
        this.showGuideEffectDp = RxUtilKt.h(Observable.timer(r2, TimeUnit.MILLISECONDS)).subscribe(new d(this, r4));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d
    public void requestData(final int r2, Function1<? super Boolean, Unit> r3, Function1<? super Throwable, Unit> r4) {
        printALog(new C04371(r2));
        if (this.isRequesting == false) goto L14;
        printALog(AnonymousClass2.INSTANCE);
        if (r3 != null) goto L7;
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        if (this.mFailedCallback != null) goto L21;
        this.mFailedCallback = r4;
        return;
    L21:
        return;
    L7:
        if (this.mSuccessCallback != null) goto L9;
        this.mSuccessCallback = r3;
        goto L9
    L14:
        this.isRequesting = true;
        this.mSuccessCallback = r3;
        this.mFailedCallback = r4;
        long r5 = SystemClock.uptimeMillis();
        Observable<com.bytedance.android.live.network.response.e<MorePanelInfoData>> r6 = getRequestObservable(r2);
        if (r6 == null) goto L22;
        Disposable r7 = r6.subscribe(new b(this, r5), new c(this));
        if (r7 == null) goto L23;
        RxUtilKt.c(r7, this.cDispose);
        return;
    L23:
        return;
    }
}
