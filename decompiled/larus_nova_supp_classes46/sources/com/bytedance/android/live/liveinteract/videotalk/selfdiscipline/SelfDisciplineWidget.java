package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.k2;
import com.bytedance.android.live.base.model.message.l2;
import com.bytedance.android.live.base.model.message.m2;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g0;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.api.PunchInfo;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.api.SelfDisciplineApi;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.api.SelfDisciplinePunchInfoResponse;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineManageDialog;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog.SelfDisciplineManagerDialogV2;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.e0;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.o1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.rb;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002bh\b\u0007\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0086\u0001B\t¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0016\u0010\u001c\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u0012\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\u0012\u0010&\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0014H\u0002J \u0010-\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00142\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u0007H\u0016J\u0012\u00101\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0006\u00102\u001a\u00020\u0007J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u000207H\u0016J)\u00109\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\u0012\u0010=\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010@\u001a\u00020\u00072\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140>H\u0016J\b\u0010A\u001a\u00020\u0007H\u0016J\b\u0010B\u001a\u00020\u0014H\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\b\u0010E\u001a\u00020DH\u0016J0\u0010J\u001a\u00020\u00072&\u0010I\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020G\u0018\u00010Fj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020G\u0018\u0001`HH\u0016J0\u0010K\u001a\u00020\u00072&\u0010I\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020G\u0018\u00010Fj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020G\u0018\u0001`HH\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\u001c\u0010P\u001a\u0016\u0012\u0004\u0012\u00020N\u0018\u00010Mj\n\u0012\u0004\u0012\u00020N\u0018\u0001`OH\u0016R\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010W\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010]R\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00120e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR \u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020m0l0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010s\u001a\u00020p8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010v\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0014\u0010y\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bz\u0010uR\u0016\u0010~\u001a\u0004\u0018\u00010{8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u001f\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u007f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0087\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lkj0/b;", "Lvlc/l;", "Lio/reactivex/disposables/Disposable;", "", "bind", "", "initDataContext", "attachDataMergeHandler", "detachDataMergeHandler", "initObservers", "initCommonObserver", "initGuestObserver", "isFastStart", "autoStartStragyte", "registerSettingChanged", "unRegisterSettingChanged", "", "settingValue", "", "source", "startIfNeededForAnchor", "start", "fetchPlayModeInfoIfNeeded", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "list", "updateDurationHolder", "onSelfLeave", "fetchSelfDisciplineInfo", "logPlayModeStart", "logPlayModeEnd", "showToastIfNeeded", "Lcom/bytedance/android/live/base/model/message/k2;", "content", "onConfigChanged", "Lcom/bytedance/android/live/base/model/message/l2;", "onReceiveLike", "status", "monitorUpdateSelfDisciplineStatusStack", "target", "onSetStatusSuccess", "", "punchDuration", "onSetStatusSuccessV2", "onCreate", "Ltlc/d;", MultiLinkOpenSource.MESSAGE, "onMessage", "fetchPunchInfo", "onResume", "onPause", "showManagePanel", "supportSelfDiscipline", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "getToolbarBehavior", "setSelfDisciplineStatus", "(ILjava/lang/String;Ljava/lang/Long;)V", "canShowContributionPanelItem", "isSelfDisciplineOn", "logUpdateRoomIntro", "", "logMap", "addExtraLog", "fastStartSelfDiscipline", "getSelfDisciplineModeName", "onDestroy", "Lxh0/h;", "getPlayModeInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "tryStartPlayMode", "tryStopPlayMode", "isOpen", "Ljava/util/ArrayList;", "Lxh0/f;", "Lkotlin/collections/ArrayList;", "getIncompatibleSourceList", "Lvlc/d;", "mMessageManager", "Lvlc/d;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mLeaveDisposable", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineContext;", "mDataContext", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineContext;", "punching", "Z", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/handler/g0;", "dataMergeHandler", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/handler/g0;", "hasCallStartIfNeed", "com/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineWidget$u", "videoFloatManagerListener", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineWidget$u;", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "mLinkStateObserver", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "com/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineWidget$i", "mUserCallback", "Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/SelfDisciplineWidget$i;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "settingObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mRoom", "getMIsAnchor", "()Z", "mIsAnchor", "getModeName", "()Ljava/lang/String;", "modeName", "isEngineOn", "Ltf0/o;", "getMWindowManager", "()Ltf0/o;", "mWindowManager", "Lcom/bytedance/android/live/liveinteract/plantform/base/i;", "getMInfoCenter", "()Lcom/bytedance/android/live/liveinteract/plantform/base/i;", "mInfoCenter", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineWidget extends AbsPlayModeWidget implements kj0.b, vlc.l {
    public static final a Companion = null;
    public static final int MAX_DURATION_GAP = 2;
    public static final int MAX_START_DURATION = 3;
    public static final int RECORD_SHOW_DURATION = 3;
    public static final String TAG = "SelfDisciplineWidget";
    public static final int TYPE_BACKGROUND = 1;
    public static final int TYPE_FOREGROUND = 2;
    public static final int TYPE_SMALL_WINDOW = 3;
    public static final int UNKNOWN = 0;
    private final CompositeDisposable compositeDisposable;
    private g0 dataMergeHandler;
    private boolean hasCallStartIfNeed;
    private SelfDisciplineContext mDataContext;
    private Disposable mLeaveDisposable;
    private final Observer<Integer> mLinkStateObserver;
    private vlc.d mMessageManager;
    private final i mUserCallback;
    private boolean punching;
    private final com.ss.android.ugc.aweme.compat.nullable.Observer<List<y>> settingObserver;
    private u videoFloatManagerListener;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public b(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            if (SelfDisciplineWidget.access$getHasCallStartIfNeed$p(this.a) == true) goto L6;
            SelfDisciplineWidget.access$setHasCallStartIfNeed$p(this.a, true);
            SelfDisciplineWidget.access$startIfNeededForAnchor(this.a, ((Number) b6.Q.getValue()).intValue(), "back_up");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public c(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            List<PunchInfo> r0 = ((SelfDisciplinePunchInfoResponse) r4.data).getPunchInfos();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            List<PunchInfo> r5 = ((SelfDisciplinePunchInfoResponse) r4.data).getPunchInfos();
            Intrinsics.checkNotNull(r5);
            PunchInfo r6 = (PunchInfo) ListProtector.get(r5, 0);
            SelfDisciplineWidget.access$getMDataContext$p(this.a).getLastPunchStatus().setValue(Integer.valueOf(r6.getPunchStatus()));
            return;
        L12:
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
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
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.c.a("getPunchInfo failed " + ((Throwable) r3).getMessage());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public e(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            p2 r6 = ((k1) ((com.bytedance.android.live.network.response.e) r5).data).getLinkmicPlayModeInfo();
            if (r6 == null) goto L27;
            o1 r7 = r6.getSelfDisciplineInfo();
            if (r7 == null) goto L28;
            SelfDisciplineWidget.access$getMDataContext$p(this.a).getStatus().setValue(1);
            com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
            if (r0 == null) goto L11;
            LivePlayModeLogContext r1 = (LivePlayModeLogContext) r0.getValue();
            if (r1 == null) goto L11;
            r1.addPlayMode(17);
        L11:
            String r2 = r7.getCurrentTarget();
            if (r2 != null) goto L14;
        L25:
            SelfDisciplineWidget.access$getMDataContext$p(this.a).getCurrentTargetDuration().setValue(Long.valueOf(r7.getPunchDuration()));
            return;
        L14:
            if ((true ^ StringsKt.isBlank(r2)) == true) goto L17;
            r2 = null;
        L17:
            if (r2 == null) goto L25;
            SelfDisciplineWidget.access$getMDataContext$p(this.a).getCurrentTarget().setValue(r2);
            tf0.o r3 = SelfDisciplineWidget.access$getMWindowManager$p(this.a);
            if (r3 == null) goto L21;
            r3.K();
        L21:
            tf0.o r4 = SelfDisciplineWidget.access$getMWindowManager$p(this.a);
            if (r4 == null) goto L24;
            SelfDisciplineContext.Companion.e();
            r4.m(17);
        L24:
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.e();
            goto L25
        L28:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public f(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = ((Widget) this.a).context;
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public g(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            SelfDisciplineWidget.access$onSelfLeave(this.a);
            return;
        }
    }

    public static final class h<T> implements Observer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
        L10:
            if (r3 != null) goto L13;
            return;
        L13:
            if (r3.intValue() == 2) goto L15;
            return;
        L15:
            if (SelfDisciplineContext.Companion.e() == false) goto L21;
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.c();
            return;
        L21:
            return;
        L6:
            if (r3.intValue() != 0) goto L10;
            if (SelfDisciplineContext.Companion.e() == false) goto L18;
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.d();
            return;
        }
    }

    public static final class i extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {
        public final /* synthetic */ SelfDisciplineWidget a;

        public i(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r2) {
            if (r2 == null) goto L5;
            SelfDisciplineWidget.access$updateDurationHolder(this.a, r2);
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Response r2 = (Response) r1;
        }
    }

    public static final class k<T> implements Consumer {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.c.a("sendSelfSignal failed");
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Response r2 = (Response) r1;
        }
    }

    public static final class m<T> implements Consumer {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.c.a("sendSelfSignal failed");
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public n(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            SelfDisciplineWidget.access$getMDataContext$p(this.a).isLeaving().setValue(Boolean.FALSE);
            com.bytedance.android.live.liveinteract.plantform.base.i r5 = SelfDisciplineWidget.access$getMInfoCenter$p(this.a);
            if (r5 == null) goto L5;
            r5.W4();
        L5:
            g0 r6 = SelfDisciplineWidget.access$getDataMergeHandler$p(this.a);
            if (r6 == null) goto L9;
            r6.d(false, null);
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Long e;

        public o(SelfDisciplineWidget r1, int r2, long r3, String r5, Long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r8) {
            int r0 = nd0.g.a;
            nd0.g.l(this.b, ((Number) b6.Q.getValue()).intValue(), com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.a, this.c, ((Response) r8).logId);
            SelfDisciplineWidget.access$onSetStatusSuccessV2(this.a, this.b, this.d, this.e.longValue());
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public p(SelfDisciplineWidget r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            ApiServerException r8 = (Throwable) r7;
            int r0 = nd0.g.a;
            nd0.g.k(this.b, ((Number) b6.Q.getValue()).intValue(), com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.a, this.c, r8);
            if ((r8 instanceof ApiServerException) == false) goto L9;
            ApiServerException r1 = r8;
            String r2 = r1.getPrompt();
            if (r2 == null) goto L9;
            if ((!StringsKt.isBlank(r2)) != true) goto L9;
            Toast.makeText(((Widget) this.a).context, r1.getPrompt(), 0).show();
            return;
        L9:
            ExceptionUtils.handleException(((Widget) this.a).context, r8);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public q(SelfDisciplineWidget r1, int r2, long r3, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r8) {
            int r0 = nd0.g.a;
            nd0.g.l(this.b, ((Number) b6.Q.getValue()).intValue(), com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.a, this.c, ((Response) r8).logId);
            SelfDisciplineWidget.access$onSetStatusSuccess(this.a, this.b, this.d);
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public r(SelfDisciplineWidget r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            ApiServerException r8 = (Throwable) r7;
            int r0 = nd0.g.a;
            nd0.g.k(this.b, ((Number) b6.Q.getValue()).intValue(), com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.a, this.c, r8);
            if ((r8 instanceof ApiServerException) == false) goto L9;
            ApiServerException r1 = r8;
            String r2 = r1.getPrompt();
            if (r2 == null) goto L9;
            if ((!StringsKt.isBlank(r2)) != true) goto L9;
            Toast.makeText(((Widget) this.a).context, r1.getPrompt(), 0).show();
            return;
        L9:
            ExceptionUtils.handleException(((Widget) this.a).context, r8);
        }
    }

    public static final class s<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public s(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            List r7 = (List) r6;
            Integer r1 = null;
            if (r7 == null) goto L17;
            Iterator<T> r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L13;
            T r2 = r8.next();
            if (((y) r2).getKey() != 76) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == false) goto L6;
        L14:
            y r4 = (y) r2;
            if (r4 == null) goto L17;
            r1 = Integer.valueOf(r4.getValue());
            goto L17
        L10:
            r3 = false;
            goto L11
        L13:
            r2 = null;
        L17:
            ALogger.e("ttlive_link", "SelfDisciplineWidget#settingObserver, self_discipline_setting = " + r1);
            if (r1 != null) goto L20;
            return;
        L20:
            if (je0.d.r() == true) goto L22;
            return;
        L22:
            if (SelfDisciplineWidget.access$getHasCallStartIfNeed$p(this.a) == true) goto L32;
            SelfDisciplineWidget.access$setHasCallStartIfNeed$p(this.a, true);
            SelfDisciplineWidget.access$startIfNeededForAnchor(this.a, r1.intValue(), "first_setting_changed");
            return;
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ SelfDisciplineWidget a;

        public t(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r5 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
            r5.getClass();
            Intrinsics.checkNotNullParameter("convenient_discipline_page", "<set-?>");
            r5.b = "convenient_discipline_page";
            this.a.showManagePanel("convenient_discipline_page");
        }
    }

    public static final class u implements IVideoFloatManager.VideoFloatManagerListener {
        public final /* synthetic */ SelfDisciplineWidget a;

        public static final class a<T> implements Consumer {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Response r2 = (Response) r1;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
                com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.c.a("sendSelfSignal failed");
            }
        }

        public final void onClose(boolean r1) {
        }

        public final void onClick() {
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.c.a(" videoFloatManagerListener onClick");
        }

        public final void onReturnClick() {
            com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.c.a(" videoFloatManagerListener onReturnClick");
        }

        public final void onShow() {
            SelfDisciplineContext.Companion.getClass();
            if (SelfDisciplineContext.a.a() != 1) goto L10;
            SelfDisciplineWidget r0 = this.a;
            com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.k(r0, ((Widget) r0).dataCenter).getRoom();
            if (r1 == null) goto L11;
            IRoom r2 = (IRoom) r1.getValue();
            if (r2 == null) goto L12;
            long r3 = r2.getId();
            SelfDisciplineWidget.access$bind(this.a, ((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).sendSelfSignal(r3, 3).compose(RxUtil.rxSchedulerHelper()).subscribe(a.a, b.a));
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void onViewReleased() {
            IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewReleased(this);
        }

        public u(SelfDisciplineWidget r1) {
            this.a = r1;
        }

        public final void onMuteButtonClick(boolean r1) {
            IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onMuteButtonClick(this, r1);
        }

        public final void onShow(int r1, int r2, int r3, int r4) {
            IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onShow(this, r1, r2, r3, r4);
        }

        public final void onViewPositionChanged(int r1, int r2, int r3, int r4) {
            IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewPositionChanged(this, r1, r2, r3, r4);
        }
    }

    static {
        Companion = new a();
    }

    private final void attachDataMergeHandler() {
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r0 == null) goto L9;
        g0 r1 = new g0();
        this.dataMergeHandler = r1;
        Intrinsics.checkNotNull(r1);
        r0.M0(r1);
        return;
    }

    private final void detachDataMergeHandler() {
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L5;
        return;
    L5:
        g0 r0 = this.dataMergeHandler;
        if (r0 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r1 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r1 == null) goto L12;
        r1.d1(r0);
        return;
    L12:
        return;
    }

    @Override // xh0.b
    public ArrayList<xh0.f> getIncompatibleSourceList() {
        IncompatibleTag r3 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new xh0.f[]{new xh0.f(r3, 5), new xh0.f(r3, 7, ""), new xh0.f(r3, 16, ""), new xh0.f(r3, 11, ""), new xh0.f(r3, 6, ""), new xh0.f(r3, 29, "")});
    }

    private final void autoStartStragyte() {
        if (((Boolean) vm2.h.B5.getValue(null, vm2.h.a[338(0x152, float:4.74E-43)])).booleanValue() == false) goto L5;
        registerSettingChanged();
        Disposable r0 = Observable.timer(5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        this.compositeDisposable.add(r0);
        return;
    L5:
        startIfNeededForAnchor(((Number) b6.Q.getValue()).intValue(), "start_when_on_create");
    }

    private final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getMInfoCenter() {
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L6;
        return r1;
    L6:
        rj0.l.n2.getClass();
        rj0.l r2 = rj0.l.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getLinkUserInfoCenter();
    }

    private final boolean getMIsAnchor() {
        return a0.d(((Widget) this).dataCenter, false);
    }

    private final IRoom getMRoom() {
        return a0.n(((Widget) this).dataCenter);
    }

    private final tf0.o getMWindowManager() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L6;
        tf0.o r1 = r0.windowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        rj0.k.m2.getClass();
        rj0.k r2 = rj0.k.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.windowManager();
    }

    private final String getModeName() {
        SelfDisciplineContext.Companion.getClass();
        return SelfDisciplineContext.a.c();
    }

    private final void initCommonObserver() {
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.mMessageManager = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.SELF_DISCIPLINE_MESSAGE.getKey(), this);
    L5:
        vlc.d r1 = this.mMessageManager;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.SELF_DISCIPLINE_PUNCH_MESSAGE.getKey(), this);
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = getMInfoCenter();
        if (r2 == null) goto L12;
        r2.Q4(this.mUserCallback);
        return;
    }

    private final void initDataContext() {
        Pair r0 = com.bytedance.live.datacontext.d.a(SelfDisciplineWidget$initDataContext$pair$1.INSTANCE);
        SelfDisciplineContext r1 = (SelfDisciplineContext) r0.getFirst();
        r1.m359getService().d(this);
        com.bytedance.live.datacontext.b.a(r1, kj0.a.class);
        this.mDataContext = r1;
        com.bytedance.live.datacontext.m<Long> r2 = r1.getCurrentTargetDuration();
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.P;
        r2.setValue(Long.valueOf(((o1) r3.getValue()).getPunchDuration()));
        com.bytedance.live.datacontext.m<String> r4 = r1.getCurrentTarget();
        String r5 = ((o1) r3.getValue()).getCurrentTarget();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4.setValue(r5);
        this.compositeDisposable.add((Disposable) r0.getSecond());
    }

    private final boolean isEngineOn() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    private final boolean isFastStart() {
        com.bytedance.live.datacontext.n r0 = com.bytedance.android.live.liveinteract.api.utils.m.g(((MiddlewareRoomWidget) this).dataContext).a();
        if (r0 == null) goto L9;
        ArrayList r1 = (ArrayList) r0.getValue();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.contains(17) != true) goto L9;
    L10:
        if (r2 == false) goto L16;
        com.bytedance.live.datacontext.n r3 = com.bytedance.android.live.liveinteract.api.utils.m.g(((MiddlewareRoomWidget) this).dataContext).a();
        if (r3 == null) goto L16;
        ArrayList r4 = (ArrayList) r3.getValue();
        if (r4 == null) goto L16;
        r4.remove(17);
    L16:
        ALogger.d(TAG, "isFastStart " + r2);
        return r2;
    L9:
        r2 = false;
        goto L10
    }

    private final void onSelfLeave() {
        Disposable r0 = this.mLeaveDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        tf0.o r1 = getMWindowManager();
        if (r1 == null) goto L8;
        r1.K();
    L8:
        tf0.o r2 = getMWindowManager();
        if (r2 == null) goto L11;
        SelfDisciplineContext.Companion.e();
        r2.m(17);
    L11:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3 = getMInfoCenter();
        if (r3 == null) goto L26;
        Iterable r4 = r3.getOnlineUserList();
        if (r4 == null) goto L26;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r7) == false) goto L17;
        r5.add(r7);
        goto L17
    L21:
        ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r5);
        if (r8 == null) goto L26;
        g0 r9 = this.dataMergeHandler;
        if (r9 == null) goto L26;
        r9.d(true, r8);
    L26:
        this.mLeaveDisposable = Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this));
    }

    private final void registerSettingChanged() {
        IInteractService.linkMicSettings.observe(this, this.settingObserver, true);
    }

    private final void start() {
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.access$isContinue$cp() == false) goto L5;
        int r0 = 4;
    L6:
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.P;
        String r4 = ((o1) r3.getValue()).getCurrentTarget();
        if (r4 != null) goto L9;
        return;
    L9:
        if (SelfDisciplineContext.a.a() != 1) goto L11;
        setSelfDisciplineStatus(r0, r4, Long.valueOf(((o1) r3.getValue()).getPunchDuration()));
        return;
    L11:
        kj0.b.a.a(this, r0, r4, 4);
        return;
    L5:
        r0 = 1;
        goto L6
    }

    private final void unRegisterSettingChanged() {
        IInteractService.linkMicSettings.removeObserver(this.settingObserver);
    }

    @Override // kj0.b
    public boolean canShowContributionPanelItem() {
        boolean r0 = tb1.d.a;
        if (SelfDisciplineContext.Companion.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ((Widget) this).dataCenter.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE)).booleanValue() == false) goto L7;
        return true;
    }

    @Override // kj0.b
    public void fastStartSelfDiscipline() {
        startIfNeededForAnchor(((Number) b6.Q.getValue()).intValue(), "api_for_external");
    }

    public final void fetchPunchInfo() {
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        ArrayList r1 = new ArrayList();
        r1.add(r0);
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = GsonProtectorUtils.toJson(GsonHelper.get(), r1);
        com.bytedance.android.livesdk.chatroom.o r3 = com.bytedance.android.live.liveinteract.api.utils.m.l(((Widget) this).dataCenter, 0L);
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L11;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L12;
        long r6 = r5.getId();
        bind(((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).getPunchInfo(r6, (String) r2.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // xh0.b
    public xh0.h getPlayModeInfo() {
        return new xh0.h(17, s1.B(2131922418));
    }

    @Override // kj0.b
    public c0.b getToolbarBehavior() {
        return new com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.e();
    }

    @Override // kj0.b
    public boolean isSelfDisciplineOn() {
        return SelfDisciplineContext.Companion.e();
    }

    @Override // kj0.b
    public boolean supportSelfDiscipline() {
        boolean r0 = tb1.d.a;
        if (je0.d.O() == false) goto L21;
        SelfDisciplineContext.Companion.getClass();
        if (((Boolean) vm2.d.M4.getValue(null, vm2.d.a[296(0x128, float:4.15E-43)])).booleanValue() == false) goto L17;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L17;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L17;
        String r3 = e0.a(r2, "live_video_enable_self_discipline");
        if (StringsKt.isBlank(r3) == false) goto L15;
    L16:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L22;
        return true;
    L22:
        return false;
    L15:
        if (Intrinsics.areEqual(r3, "2") == true) goto L16;
    L17:
        r4 = false;
        goto L18
    L21:
        return false;
    }

    public SelfDisciplineWidget() {
        this.compositeDisposable = new CompositeDisposable();
        this.videoFloatManagerListener = new u(this);
        this.mLinkStateObserver = h.a;
        this.mUserCallback = new i(this);
        this.settingObserver = new s(this);
    }

    private final void fetchPlayModeInfoIfNeeded() {
        if (getMIsAnchor() == true) goto L16;
        z5 r0 = getMRoom().getLinkerDetail();
        if (r0 == null) goto L7;
        List r1 = r0.getPlayModes();
    L8:
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L17;
        fetchSelfDisciplineInfo();
        return;
    L17:
        return;
    L10:
        if (r1.contains(17L) == false) goto L12;
        r2 = true;
        goto L13
    L7:
        r1 = null;
        goto L8
    }

    private final void fetchSelfDisciplineInfo() {
        bind(((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).getPlayModeInfo(getMRoom().getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this), new f(this)));
    }

    private final void initGuestObserver() {
        if (getMIsAnchor() == true) goto L11;
        hd0.c.f().c(this.mLinkStateObserver);
        SelfDisciplineContext r0 = this.mDataContext;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L7:
        Disposable r1 = r0.isLeaving().a().subscribe(new g(this));
        if (r1 == null) goto L12;
        bind(r1);
        return;
    L12:
        return;
    }

    private final void initObservers() {
        initCommonObserver();
        initGuestObserver();
        IMiddlewareLiveVideoFloatWindowService r0 = jc1.k.f(IMiddlewareLiveVideoFloatWindowService.class);
        if (r0 == null) goto L6;
        r0.addFloatManagerListenerForOuter(this.videoFloatManagerListener);
        return;
    }

    private final void logPlayModeEnd() {
        if (getMIsAnchor() == false) goto L9;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r0 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        SelfDisciplineContext r1 = this.mDataContext;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L7:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.b((String) r1.getCurrentTarget().getValue());
        return;
    L9:
        if (isEngineOn() == false) goto L11;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.d();
        return;
    L11:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r2 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        LinkedHashMap r3 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r3);
        TalkRoomLogUtils.B0(r3, null, null, 6);
        TalkRoomLogUtils.V0(r3);
        r3.put("play_mode", "self_discipline");
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r4 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r4.getClass();
        r3.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r4.d)));
        r3.put("enter_from_merge", com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a.a());
        r3.put("enter_method", com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a.b());
        zi0.d.b(r3, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r3, new Object[]{IRoom.class});
    }

    private final void logPlayModeStart() {
        if (getMIsAnchor() == false) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r0 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        SelfDisciplineContext r1 = this.mDataContext;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L7:
        String r2 = (String) r1.getCurrentTarget().getValue();
        SelfDisciplineContext r3 = this.mDataContext;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L10:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a(r2, ((Number) r3.getCurrentTargetDuration().getValue()).longValue());
        return;
    L12:
        if (isEngineOn() == false) goto L14;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.c();
        return;
    L14:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.e();
    }

    private final void showToastIfNeeded() {
        if (getMIsAnchor() == false) goto L5;
    L11:
        f2.c(s1.C(2131922437, new Object[]{getModeName()}), 0);
        return;
    L5:
        if (getMIsAnchor() == true) goto L13;
        SelfDisciplineContext r0 = this.mDataContext;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L10:
        if (((Number) r0.getStatus().getValue()).intValue() == 1) goto L11;
        return;
    }

    public String getSelfDisciplineModeName() {
        return getModeName();
    }

    @Override // xh0.b
    public boolean isOpen() {
        return isSelfDisciplineOn();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        attachDataMergeHandler();
        initDataContext();
        initObservers();
        autoStartStragyte();
        fetchPlayModeInfoIfNeeded();
        z5 r0 = getMRoom().getLinkerDetail();
        if (r0 == null) goto L5;
        List r1 = r0.getPlayModes();
    L6:
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        fetchPunchInfo();
        return;
    L14:
        return;
    L8:
        if (r1.contains(17L) == false) goto L10;
        r2 = true;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        SelfDisciplineContext.a r0 = SelfDisciplineContext.Companion;
        if (r0.e() == false) goto L6;
        logPlayModeEnd();
    L6:
        if (r0.e() == true) goto L8;
    L12:
        unRegisterSettingChanged();
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r1 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter("null", "<set-?>");
        r1.b = "null";
        hd0.c.f().e(this.mLinkStateObserver);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = getMInfoCenter();
        if (r2 == null) goto L15;
        r2.T4(this.mUserCallback);
    L15:
        vlc.d r3 = this.mMessageManager;
        if (r3 == null) goto L18;
        r3.removeMessageListener(this);
    L18:
        IMiddlewareLiveVideoFloatWindowService r4 = jc1.k.f(IMiddlewareLiveVideoFloatWindowService.class);
        if (r4 == null) goto L21;
        r4.removeFloatManagerListenerForOuter(this.videoFloatManagerListener);
    L21:
        this.compositeDisposable.dispose();
        Disposable r5 = this.mLeaveDisposable;
        if (r5 == null) goto L24;
        r5.dispose();
    L24:
        detachDataMergeHandler();
        return;
    L8:
        if (this.punching == false) goto L12;
        if (getMIsAnchor() == true) goto L12;
        this.punching = false;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.e = 0;
        goto L12
    }

    public void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        gd0.i r1 = r0.getInteractFloatWindowService();
        if (r1 == null) goto L9;
        if (((com.bytedance.android.live.liveinteract.service.g) r1).b() != true) goto L9;
        boolean r2 = true;
    L10:
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.a.a() == 1) goto L13;
        return;
    L13:
        if (this.punching == false) goto L33;
        if (r2 == true) goto L34;
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter).getRoom();
        if (r3 == null) goto L21;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L21;
        bind(((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).sendSelfSignal(r4.getId(), 1).compose(RxUtil.rxSchedulerHelper()).subscribe(j.a, k.a));
    L21:
        if (getMIsAnchor() == true) goto L35;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r5 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        SelfDisciplineContext r6 = this.mDataContext;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L25:
        String r7 = (String) r6.getCurrentTarget().getValue();
        SelfDisciplineContext r8 = this.mDataContext;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L28:
        long r9 = ((Number) r8.getCurrentTargetDuration().getValue()).longValue();
        Intrinsics.checkNotNullParameter(r7, "target");
        LinkedHashMap r10 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r10);
        TalkRoomLogUtils.B0(r10, null, null, 6);
        TalkRoomLogUtils.V0(r10);
        r10.put("discipline_theme", r7);
        r10.put("discipline_time_target", String.valueOf(r9 / ((long) 60)));
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r11 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r11.getClass();
        r10.put("room_info", com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a.c());
        r10.put("play_mode", u0.b());
        long r12 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r11.e);
        r10.put("duration", String.valueOf(r12));
        if (r12 <= 0) goto L36;
        j0.l().sendLog("livesdk_audience_discipline_in_progress_watch_duration", r10, new Object[]{IRoom.class});
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.a.a() == 1) goto L5;
        return;
    L5:
        if (this.punching == false) goto L14;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter).getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        long r2 = r1.getId();
        bind(((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).sendSelfSignal(r2, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(l.a, m.a));
    L11:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r3 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r3.e = System.currentTimeMillis();
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_videotalk_selfdiscipline_SelfDisciplineWidget_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(SelfDisciplineManageDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ g0 access$getDataMergeHandler$p(SelfDisciplineWidget r0) {
        return r0.dataMergeHandler;
    }

    public static final /* synthetic */ boolean access$getHasCallStartIfNeed$p(SelfDisciplineWidget r0) {
        return r0.hasCallStartIfNeed;
    }

    public static final /* synthetic */ SelfDisciplineContext access$getMDataContext$p(SelfDisciplineWidget r1) {
        SelfDisciplineContext r2 = r1.mDataContext;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L5:
        return r2;
    }

    public static final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.base.i access$getMInfoCenter$p(SelfDisciplineWidget r0) {
        return r0.getMInfoCenter();
    }

    public static final /* synthetic */ tf0.o access$getMWindowManager$p(SelfDisciplineWidget r0) {
        return r0.getMWindowManager();
    }

    public static final /* synthetic */ void access$onSelfLeave(SelfDisciplineWidget r0) {
        r0.onSelfLeave();
    }

    private final boolean bind(Disposable r2) {
        return this.compositeDisposable.add(r2);
    }

    private final void monitorUpdateSelfDisciplineStatusStack(int r14) {
        if (((Boolean) vm2.e.P.getValue(null, vm2.e.a[40])).booleanValue() == false) goto L6;
        String r0 = Log.getStackTraceString(new Throwable("call setSelfDisciplineStatus"));
        int r1 = nd0.g.a;
        com.bytedance.android.livesdk.sharedpref.e r2 = b6.Q;
        int r3 = ((Number) r2.getValue()).intValue();
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r4 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        String r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "sourceFrom");
        Intrinsics.checkNotNullParameter(r0, "codeStack");
        JSONObject r8 = new JSONObject();
        r8.put("target_status", nd0.g.e(r14));
        r8.put("setting_value", r3);
        r8.put("source_from", r5);
        r8.put("code_stack", r0);
        nd0.c.o(nd0.c.a, LinkMonitorData.SelfDisciplineConfigStartApiMonitorData, r8, 0, null, false, 28);
        ALogger.e("ttlive_link", "SelfDisciplineWidget#monitorUpdateSelfDisciplineStatusStack, status = " + r14 + ", setting_value = " + ((Integer) r2.getValue()) + ", openSource = " + r4.a + ", stackTrace = " + r0);
        return;
    }

    private final void onConfigChanged(k2 r11) {
        if (r11 == null) goto L101;
        SelfDisciplineContext r0 = this.mDataContext;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L6:
        r0.getStatus().setValue(Integer.valueOf(r11.getStatus()));
        int r1 = r11.getStatus();
        String r4 = "";
        if (r1 != 1) goto L9;
    L78:
        SelfDisciplineContext r2 = this.mDataContext;
        if (r2 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L81:
        com.bytedance.live.datacontext.m<String> r3 = r2.getCurrentTarget();
        String r5 = r11.getCurrentTarget();
        if (r5 == null) goto L85;
        r4 = r5;
    L85:
        r3.setValue(r4);
        SelfDisciplineContext r6 = this.mDataContext;
        if (r6 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L88:
        r6.getCurrentTargetDuration().setValue(Long.valueOf(r11.getPunchDuration()));
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r12 == null) goto L93;
        LivePlayModeLogContext r13 = (LivePlayModeLogContext) r12.getValue();
        if (r13 == null) goto L93;
        r13.addPlayMode(17);
    L93:
        SelfDisciplineContext.Companion.getClass();
        SelfDisciplineContext.access$setContinue$cp(false);
        showToastIfNeeded();
        logPlayModeStart();
    L94:
        tf0.o r14 = getMWindowManager();
        if (r14 == null) goto L97;
        r14.K();
    L97:
        tf0.o r15 = getMWindowManager();
        if (r15 == null) goto L102;
        SelfDisciplineContext.Companion.e();
        r15.m(17);
        return;
    L102:
        return;
    L9:
        if (r1 != 2) goto L11;
        logPlayModeEnd();
        f2.c(s1.C(2131922421, new Object[]{getModeName()}), 0);
        com.bytedance.live.datacontext.j r16 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r16 == null) goto L53;
        LivePlayModeLogContext r17 = (LivePlayModeLogContext) r16.getValue();
        if (r17 == null) goto L53;
        r17.removePlayMode(17);
    L53:
        com.bytedance.android.livesdk.sharedpref.e r18 = b6.Q;
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, 2);
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r19 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r19.getClass();
        Intrinsics.checkNotNullParameter("null", "<set-?>");
        r19.b = "null";
        Intrinsics.checkNotNullParameter("auto_start", "<set-?>");
        r19.a = "auto_start";
        r19.c = 0;
        r19.d = 0;
        r19.e = 0;
        r19.f = 0;
        SelfDisciplineContext.a r110 = SelfDisciplineContext.Companion;
        SelfDisciplineContext r7 = r110.getContext();
        if (r7 == null) goto L58;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.isLeaving();
        if (r8 == null) goto L58;
        r8.setValue(Boolean.FALSE);
    L58:
        SelfDisciplineContext r9 = r110.getContext();
        if (r9 == null) goto L63;
        com.bytedance.live.datacontext.m<String> r10 = r9.getCurrentTarget();
        if (r10 == null) goto L63;
        r10.setValue("");
    L63:
        SelfDisciplineContext r20 = r110.getContext();
        if (r20 == null) goto L68;
        com.bytedance.live.datacontext.m<Long> r21 = r20.getCurrentTargetDuration();
        if (r21 == null) goto L68;
        r21.setValue(600L);
    L68:
        SelfDisciplineContext r22 = r110.getContext();
        if (r22 == null) goto L73;
        com.bytedance.live.datacontext.m<Integer> r23 = r22.getStatus();
        if (r23 == null) goto L73;
        r23.setValue(0);
    L73:
        SelfDisciplineContext r111 = r110.getContext();
        if (r111 == null) goto L94;
        ConcurrentHashMap<String, Long> r112 = r111.getDurationHolder();
        if (r112 == null) goto L94;
        r112.clear();
        goto L94
    L11:
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L78;
    L16:
        if (getMIsAnchor() == false) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r24 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        SelfDisciplineContext r25 = this.mDataContext;
        if (r25 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L20:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.b((String) r25.getCurrentTarget().getValue());
    L21:
        long r26 = r11.getPunchDuration();
        SelfDisciplineContext r27 = this.mDataContext;
        if (r27 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L25:
        if (r26 == ((Number) r27.getCurrentTargetDuration().getValue()).longValue()) goto L29;
        String r28 = r11.getToast();
        if (r28 == null) goto L29;
        f2.c(r28, 0);
    L29:
        SelfDisciplineContext r29 = this.mDataContext;
        if (r29 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L32:
        com.bytedance.live.datacontext.m<String> r30 = r29.getCurrentTarget();
        String r31 = r11.getCurrentTarget();
        if (r31 == null) goto L36;
        r4 = r31;
    L36:
        r30.setValue(r4);
        SelfDisciplineContext r32 = this.mDataContext;
        if (r32 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L39:
        r32.getCurrentTargetDuration().setValue(Long.valueOf(r11.getPunchDuration()));
        if (getMIsAnchor() == false) goto L94;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r113 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        SelfDisciplineContext r114 = this.mDataContext;
        if (r114 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L44:
        String r115 = (String) r114.getCurrentTarget().getValue();
        SelfDisciplineContext r33 = this.mDataContext;
        if (r33 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L47:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a(r115, ((Number) r33.getCurrentTargetDuration().getValue()).longValue());
        goto L94
    }

    private final void onReceiveLike(l2 r2) {
        if (r2 == null) goto L7;
        tf0.o r0 = getMWindowManager();
        if (r0 == null) goto L8;
        r0.B(r2);
        return;
    L8:
        return;
    }

    private final void updateDurationHolder(List<ILinkPlayerInfoBridge> r9) {
        if (SelfDisciplineContext.Companion.f() == false) goto L5;
        return;
    L5:
        SelfDisciplineContext r0 = this.mDataContext;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L8:
        Iterator<Map.Entry<String, Long>> r1 = r0.getDurationHolder().entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L29;
        Map.Entry<String, Long> r2 = r1.next();
        Iterator<T> r3 = r9.iterator();
    L12:
        Object r4 = null;
        if (r3.hasNext() == false) goto L20;
        Object r5 = r3.next();
        IBaseUser r6 = ((ILinkPlayerInfoBridge) r5).getUser();
        if (r6 == null) goto L18;
        r4 = r6.getIdString();
    L18:
        if (Intrinsics.areEqual(r4, r2.getKey()) == false) goto L12;
        r4 = r5;
    L20:
        ILinkPlayerInfoBridge r7 = (ILinkPlayerInfoBridge) r4;
        if (r7 == null) goto L22;
        if (r7.getSelfDisciplineDuration() < 3) goto L25;
        if ((r2.getValue().longValue() - r7.getSelfDisciplineDuration()) <= 2) goto L10;
        r2.setValue(Long.valueOf(r7.getSelfDisciplineDuration()));
        goto L10
    L25:
        r2.setValue(Long.valueOf(r7.getSelfDisciplineDuration()));
        goto L10
    L22:
        r1.remove();
        goto L10
    }

    @Override // kj0.b
    public void addExtraLog(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r1 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        Intrinsics.checkNotNullParameter(r4, "logMap");
        TalkRoomLogUtils.u0(r4);
        TalkRoomLogUtils.J0(r4);
        String r2 = null;
        TalkRoomLogUtils.B0(r4, null, null, 6);
        TalkRoomLogUtils.V0(r4);
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (je0.d.D() == false) goto L6;
        String r0 = "anchor";
    L9:
        r4.put("user_type", r0);
        r4.put("play_mode", u0.b());
        SelfDisciplineContext r3 = SelfDisciplineContext.Companion.getContext();
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.m<String> r5 = r3.getCurrentTarget();
        if (r5 == null) goto L14;
        r2 = (String) r5.getValue();
    L14:
        r4.put("discipline_theme", String.valueOf(r2));
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.getClass();
        r4.put("room_info", com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a.c());
        return;
    L6:
        if (hd0.c.f().h() == false) goto L8;
        r0 = "link_user";
        goto L9
    L8:
        r0 = "audience";
        goto L9
    }

    @Override // kj0.b
    public void logUpdateRoomIntro(String r5) {
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r0 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r1);
        TalkRoomLogUtils.B0(r1, null, null, 6);
        TalkRoomLogUtils.V0(r1);
        r1.put("play_mode", u0.b());
        r1.put("room_info", String.valueOf(r5));
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.getClass();
        if (SelfDisciplineContext.Companion.e() == false) goto L5;
        String r6 = "after_mode";
    L6:
        r1.put("edit_time", r6);
        j0.l().sendLog("livesdk_anchor_set_discipline_room_info_click", r1, new Object[]{IRoom.class});
        return;
    L5:
        r6 = "before_mode";
        goto L6
    }

    public void onMessage(tlc.d r21) {
        String r6 = "like";
        boolean r12 = true;
        if ((r21 instanceof m2) == false) goto L16;
        int r2 = nd0.g.a;
        m2 r3 = (m2) r21;
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        JSONObject r15 = new JSONObject();
        r15.put("msg_id", r3.getMessageId());
        int r9 = r3.getMsgType();
        if (r9 == 1) goto L8;
        if (r9 == 2) goto L9;
        r6 = "unknown: " + r3.getMsgType();
    L9:
        r15.put("msg_type", r6);
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveSelfDisciplineMsgMonitorData, r15, 0, null, false, 28);
        ALogger.d(TAG, "onMessage " + r21);
        int r1 = r3.getMsgType();
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L56;
        onReceiveLike(r3.getLikeContent());
        return;
    L56:
        return;
    L14:
        onConfigChanged(r3.getConfigContent());
        return;
    L8:
        r6 = "config";
        goto L9
    L16:
        if ((r21 instanceof rb) == false) goto L52;
        int r4 = nd0.g.a;
        rb r5 = (rb) r21;
        Intrinsics.checkNotNullParameter(r5, MultiLinkOpenSource.MESSAGE);
        JSONObject r16 = new JSONObject();
        r16.put("msg_id", r5.messageId());
        int r10 = r5.getMsgType();
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L22;
        r6 = "unknown: " + r5.getMsgType();
    L22:
        r16.put("msg_type", r6);
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveSelfDisciplineMsgMonitorData, r16, 0, null, false, 28);
        ALogger.d(TAG, "onMessage " + r21);
        int r7 = r5.getMsgType();
        if (r7 == 1) goto L37;
        if (r7 != 2) goto L26;
        String r8 = r5.getToastString();
        if (r8 != null) goto L32;
    L35:
        if (r12 == true) goto L54;
        f2.c(r5.getToastString(), 0);
        return;
    L54:
        return;
    L32:
        if (r8.length() == 0) goto L35;
        r12 = false;
        goto L35
    L26:
        if (r7 != 3) goto L57;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.e = 0;
        return;
    L57:
        return;
    L37:
        String r11 = r5.getToastString();
        if (r11 != null) goto L40;
    L43:
        boolean r13 = true;
    L44:
        if (r13 == false) goto L46;
    L48:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a.e = System.currentTimeMillis();
        this.punching = true;
        return;
    L46:
        if (r5.getPunchStatus() != 1) goto L48;
        f2.c(r5.getToastString(), 0);
        goto L48
    L40:
        if (r11.length() == 0) goto L43;
        r13 = false;
        goto L44
    L21:
        r6 = "config";
        goto L22
    }

    @Override // kj0.b
    public void showManagePanel(String r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L6;
        f2.b(2131922443, 0);
        return;
    L6:
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r1 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r1.a = r12;
        if (Intrinsics.areEqual(r12, "interaction_button") == false) goto L9;
        Intrinsics.checkNotNullParameter(r12, "source");
        LinkedHashMap r2 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r2);
        TalkRoomLogUtils.B0(r2, null, null, 6);
        TalkRoomLogUtils.V0(r2);
        r2.put("playmode_type", String.valueOf(8));
        r2.put("source", r12);
        r2.put("request_page", r12);
        j0.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r2, new Object[]{IRoom.class});
    L9:
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "source");
        JSONObject r6 = new JSONObject();
        r6.put("source_from", r12);
        nd0.c.o(nd0.c.a, LinkMonitorData.SelfDisciplineManagePanelOpenMonitorData, r6, 0, null, false, 28);
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.a.a() != 1) goto L12;
        INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_videotalk_selfdiscipline_SelfDisciplineWidget_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new SelfDisciplineManagerDialogV2(((Widget) this).context));
        return;
    L12:
        INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_videotalk_selfdiscipline_SelfDisciplineWidget_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new SelfDisciplineManageDialog(((Widget) this).context));
    }

    @Override // xh0.b
    public void tryStartPlayMode(HashMap<String, Object> r5) {
        Object r0 = null;
        if (r5 == null) goto L5;
        Object r1 = r5.get("status");
    L6:
        Integer r2 = (Integer) r1;
        if (r5 == null) goto L9;
        Object r3 = r5.get("target");
    L10:
        String r4 = (String) r3;
        if (r5 == null) goto L13;
        r0 = r5.get("punchDuration");
    L13:
        Long r6 = (Long) r0;
        if (r2 == null) goto L22;
        if (r4 == null) goto L24;
        SelfDisciplineContext.Companion.getClass();
        if (SelfDisciplineContext.a.a() != 1) goto L20;
        setSelfDisciplineStatus(r2.intValue(), r4, r6);
        return;
    L20:
        kj0.b.a.a(this, r2.intValue(), r4, 4);
        return;
    L24:
        return;
    L22:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // xh0.b
    public void tryStopPlayMode(HashMap<String, Object> r3) {
        if (r3 == null) goto L4;
        Object r4 = r3.get("status");
    L5:
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L9;
        kj0.b.a.a(this, r5.intValue(), "", 4);
        return;
    L9:
        return;
    L4:
        r4 = null;
        goto L5
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_videotalk_selfdiscipline_SelfDisciplineWidget_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(SelfDisciplineManagerDialogV2 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final /* synthetic */ boolean access$bind(SelfDisciplineWidget r0, Disposable r1) {
        return r0.bind(r1);
    }

    public static final /* synthetic */ void access$setDataMergeHandler$p(SelfDisciplineWidget r0, g0 r1) {
        r0.dataMergeHandler = r1;
    }

    public static final /* synthetic */ void access$setHasCallStartIfNeed$p(SelfDisciplineWidget r0, boolean r1) {
        r0.hasCallStartIfNeed = r1;
    }

    public static final /* synthetic */ void access$setMDataContext$p(SelfDisciplineWidget r0, SelfDisciplineContext r1) {
        r0.mDataContext = r1;
    }

    public static final /* synthetic */ void access$updateDurationHolder(SelfDisciplineWidget r0, List r1) {
        r0.updateDurationHolder(r1);
    }

    private final void onSetStatusSuccess(int r3, String r4) {
        if (r3 != 1) goto L5;
    L10:
        ((o1) b6.P.getValue()).setCurrentTarget(r4);
        return;
    L5:
        if (r3 != 3) goto L7;
        f2.c(s1.C(2131922440, new Object[]{getModeName()}), 0);
        ((o1) b6.P.getValue()).setCurrentTarget(r4);
        return;
    L7:
        if (r3 == 4) goto L10;
    }

    private final void startIfNeededForAnchor(int r9, String r10) {
        if (getMIsAnchor() == false) goto L44;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "source");
        JSONObject r3 = new JSONObject();
        r3.put("setting_value", r9);
        r3.put("source_from", r10);
        nd0.c.o(nd0.c.a, LinkMonitorData.SelfDisciplineStartIfMonitorData, r3, 0, r10, false, 20);
        if (SelfDisciplineContext.Companion.e() == false) goto L8;
        f2.c(s1.C(2131922437, new Object[]{getModeName()}), 0);
        return;
    L8:
        if (r9 == 0) goto L38;
        if (r9 != 1) goto L12;
        com.bytedance.live.datacontext.n r11 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).I();
        if (r11 == null) goto L20;
        Integer r12 = (Integer) r11.getValue();
    L21:
        if (r12 == null) goto L32;
        com.bytedance.live.datacontext.n r13 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).I();
        if (r13 == null) goto L25;
        Integer r14 = (Integer) r13.getValue();
    L26:
        if (r14 != null) goto L29;
        return;
    L29:
        if (r14.intValue() == 17) goto L32;
        return;
    L25:
        r14 = null;
    L32:
        if (isFastStart() == false) goto L35;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r15 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r15.getClass();
        Intrinsics.checkNotNullParameter("convenient_discipline_page", "<set-?>");
        r15.a = "convenient_discipline_page";
        Intrinsics.checkNotNullParameter("convenient_discipline_page", "<set-?>");
        r15.b = "convenient_discipline_page";
        start();
        return;
    L35:
        if (((Boolean) vm2.d.O4.getValue(null, vm2.d.a[298(0x12a, float:4.18E-43)])).booleanValue() == false) goto L48;
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r16 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r16.getClass();
        Intrinsics.checkNotNullParameter("auto_start", "<set-?>");
        r16.a = "auto_start";
        start();
        return;
    L48:
        return;
    L20:
        r12 = null;
        goto L21
    L12:
        if (r9 == 2) goto L15;
        return;
    L15:
        if (isFastStart() == false) goto L45;
        start();
        com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a r17 = com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.b.a;
        r17.getClass();
        Intrinsics.checkNotNullParameter("convenient_discipline_page", "<set-?>");
        r17.b = "convenient_discipline_page";
        Intrinsics.checkNotNullParameter("convenient_discipline_page", "<set-?>");
        r17.a = "convenient_discipline_page";
        return;
    L45:
        return;
    L38:
        if (isFastStart() == false) goto L50;
        Disposable r18 = Observable.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this));
        if (r18 == null) goto L51;
        bind(r18);
        return;
    L51:
        return;
    L50:
        return;
    }

    public static final /* synthetic */ void access$onSetStatusSuccess(SelfDisciplineWidget r0, int r1, String r2) {
        r0.onSetStatusSuccess(r1, r2);
    }

    public static final /* synthetic */ void access$startIfNeededForAnchor(SelfDisciplineWidget r0, int r1, String r2) {
        r0.startIfNeededForAnchor(r1, r2);
    }

    private final void onSetStatusSuccessV2(int r2, String r3, long r4) {
        if (r2 != 1) goto L5;
    L10:
        com.bytedance.android.livesdk.sharedpref.e r5 = b6.P;
        ((o1) r5.getValue()).setCurrentTarget(r3);
        ((o1) r5.getValue()).setPunchDuration(r4);
        return;
    L5:
        if (r2 != 3) goto L7;
        com.bytedance.android.livesdk.sharedpref.e r6 = b6.P;
        ((o1) r6.getValue()).setCurrentTarget(r3);
        ((o1) r6.getValue()).setPunchDuration(r4);
        return;
    L7:
        if (r2 == 4) goto L10;
    }

    @Override // kj0.b
    public void setSelfDisciplineStatus(int r12, String r13, Long r14) {
        Intrinsics.checkNotNullParameter(r13, "target");
        boolean r0 = true;
        if (r12 != 1) goto L17;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r1 = MultiRevenueDataContext.a.d();
        if (r1 == null) goto L17;
        xh0.g r2 = r1.a(17, null);
        if (r2 == null) goto L17;
        if (r2.c == true) goto L17;
        if (r2.e.length() > 0) goto L14;
        r0 = false;
    L14:
        if (r0 == false) goto L17;
        f2.c(r2.e, 0);
        return;
    L17:
        monitorUpdateSelfDisciplineStatusStack(r12);
        long r3 = System.currentTimeMillis();
        if (r14 == null) goto L20;
        bind(((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).setStatus(getMRoom().getId(), r12, r13, r14.longValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(this, r12, r3, r13, r14), new p(this, r12, r3)));
        return;
    L20:
        bind(((SelfDisciplineApi) com.bytedance.android.live.network.c.b().e(SelfDisciplineApi.class)).setStatus(getMRoom().getId(), r12, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(this, r12, r3, r13), new r(this, r12, r3)));
    }

    public static final /* synthetic */ void access$onSetStatusSuccessV2(SelfDisciplineWidget r0, int r1, String r2, long r3) {
        r0.onSetStatusSuccessV2(r1, r2, r3);
    }
}
