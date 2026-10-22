package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.u2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.AudioLayoutDynamicHandler;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.PerfStrategyDynamicHandler;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AudioChatStageUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageItemId;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SubtitleUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.MessageProcessor;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.dynamic.DynamicRoomBattleRandomMatchVM;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.utils.g4;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfigV2;
import com.bytedance.android.livesdk.config.na0;
import com.bytedance.android.livesdk.config.oa1;
import com.bytedance.android.livesdk.config.tp;
import com.bytedance.android.livesdk.gecko.LiveGeckoConfig;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/MultiLinkDynamicWidgetNew;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lih0/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkDynamicWidgetNew extends PlatformMultiLinkWidget implements ih0.b, Observer<KVData> {
    public static final /* synthetic */ int A = 0;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i a;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v b;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.q c;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.k0 d;
    public AudioLayoutDynamicHandler e;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.f0 f;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.e g;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.k h;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i0 i;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.g j;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.b k;
    public PerfStrategyDynamicHandler l;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.h0 m;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.n n;
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.l o;
    public List<? extends lh0.b> p;
    public List<? extends lh0.b> q;
    public List<? extends lh0.b> r;
    public final Map<String, WeakReference<vlc.l>> s;
    public boolean t;
    public e0 u;
    public final CompositeDisposable v;
    public MessageProcessor w;
    public final Map<String, ih0.c> x;
    public final ViewGroup y;
    public final Long z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiLinkDynamicWidgetNew a;

        public b(MultiLinkDynamicWidgetNew r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            i1 r7 = (i1) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            MultiLinkDynamicWidgetNew r0 = this.a;
            int r1 = MultiLinkDynamicWidgetNew.A;
            r0.getClass();
            if (je0.d.B() == false) goto L31;
            boolean r2 = r7.b;
            View r3 = r0.y.findViewById(2131370478);
            if (r3 != null) goto L7;
        L11:
            e0 r4 = r0.u;
            if (r4 == null) goto L32;
            boolean r8 = r7.b;
            JSONObject r5 = new JSONObject();     // Catch: JSONException -> L22
            r5.put("visible", r8);     // Catch: JSONException -> L22
            ih0.c r9 = r4.d;     // Catch: JSONException -> L22
            if (r9 == null) goto L18;
            r9.sendJsEvent("H5_keyboardStatusChange", r5);     // Catch: JSONException -> L22
        L18:
            ih0.c r10 = r4.e;     // Catch: JSONException -> L22
            if (r10 == null) goto L33;
            r10.sendJsEvent("H5_keyboardStatusChange", r5);     // Catch: JSONException -> L22
            return;
        L33:
            return;
        L22:
            e = move-exception;
            StringBuilder r11 = new StringBuilder("sendKeyboardJsEvent error: ");
            if (TextUtils.isEmpty(e.getMessage()) == true) goto L26;
            String r12 = e.getMessage();
        L27:
            r11.append(r12);
            ALogger.d("MultiLinkMainHybridCardManager", r11.toString());
            return;
        L26:
            r12 = "";
            goto L27
        L32:
            return;
        L7:
            if (r2 == false) goto L9;
            int r13 = -s1.f(90.0f);
        L10:
            ObjectAnimator.ofFloat(r3, "translationY", new float[]{r13}).setDuration(300).start();
            goto L11
        L9:
            r13 = 0;
            goto L10
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MultiLinkDynamicWidgetNew a;
        public final /* synthetic */ boolean b;

        public c(MultiLinkDynamicWidgetNew r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            MultiLinkDynamicWidgetNew r0 = this.a;
            boolean r1 = this.b;
            int r2 = MultiLinkDynamicWidgetNew.A;
            r0.getClass();
            if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
        L69:
            Lazy r3 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.p(((Widget) this.a).dataCenter, "MultiLinkDynamicWidgetNew#runWithRoomVisible", "isRoomVisible = " + this.a.t + ", onCreateVisible = " + this.b);
            return;
        L5:
            if (r0.t == true) goto L68;
            r0.t = true;
            Iterator<T> r4 = r0.q.iterator();
        L8:
            if (r4.hasNext() == false) goto L12;
            lh0.b r5 = (lh0.b) r4.next();
            if (r5 == null) goto L8;
            r5.c();
            goto L8
        L12:
            MessageProcessor r6 = new MessageProcessor(((Widget) r0).dataCenter);
            r0.w = r6;
            r6.b();
            e0 r7 = r0.u;
            if (r7 == null) goto L67;
            ih0.c r8 = r7.d;
            if (r8 == null) goto L17;
            r8.r1();
        L17:
            ih0.c r9 = r7.e;
            if (r9 == null) goto L20;
            r9.r1();
        L20:
            if (r1 == true) goto L66;
            DataCenter r10 = r7.b;
            z5 r11 = null;
            if (r10 == null) goto L24;
            IRoom r12 = com.bytedance.android.live.core.utils.a0.o(r10);
        L25:
            Lazy r13 = MultiLinkWRDSPreloadManager.i;
            RoomLinkMicSyncData r14 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r12, false, 4, null);
            if (r14 == null) goto L28;
            LinkerBaseInfo r15 = r14.linkerBaseInfo;
        L29:
            Lazy r16 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.m(r7.b, "MultiLinkMainHybridCardManager", "开始尝试修正room.linkerDetail");
            if (r15 == null) goto L46;
            int r17 = r15.getUiLayout();
            if (r12 == null) goto L37;
            z5 r18 = r12.getLinkerDetail();
            if (r18 == null) goto L37;
            if (r17 == r18.getUiLayout()) goto L46;
        L37:
            if (r12 == null) goto L41;
            z5 r19 = r12.getLinkerDetail();
            if (r19 == null) goto L41;
            r19.setUiLayout(r15.getUiLayout());
        L41:
            DataCenter r20 = r7.b;
            StringBuilder r110 = new StringBuilder("修正room.linkerDetail.uiLayout, linkerBaseInfo=");
            r110.append(r15);
            r110.append(", linkerDetail=");
            if (r12 == null) goto L44;
            z5 r111 = r12.getLinkerDetail();
        L45:
            r110.append(r111);
            MultiLinkLoadWidgetUtils.m(r20, "MultiLinkMainHybridCardManager", r110.toString());
            goto L46
        L44:
            r111 = null;
        L46:
            if (r15 == null) goto L48;
            List<Long> r21 = r15.getPlayModes();
        L49:
            if (r21 == null) goto L66;
            List<Long> r22 = r15.getPlayModes();
            if (r12 == null) goto L55;
            z5 r112 = r12.getLinkerDetail();
            if (r112 == null) goto L55;
            List r113 = r112.getPlayModes();
        L57:
            if ((!Intrinsics.areEqual(r22, r113)) == false) goto L66;
            if (r12 == null) goto L62;
            z5 r23 = r12.getLinkerDetail();
            if (r23 == null) goto L62;
            r23.setPlayModes(r15.getPlayModes());
        L62:
            DataCenter r24 = r7.b;
            StringBuilder r114 = new StringBuilder("修正room.linkerDetail.uiLayout, linkerBaseInfo=");
            r114.append(r15);
            r114.append(", linkerDetail=");
            if (r12 == null) goto L65;
            r11 = r12.getLinkerDetail();
        L65:
            r114.append(r11);
            MultiLinkLoadWidgetUtils.m(r24, "MultiLinkMainHybridCardManager", r114.toString());
        L55:
            r113 = null;
            goto L57
        L48:
            r21 = null;
            goto L49
        L28:
            r15 = null;
            goto L29
        L24:
            r12 = null;
        L66:
            r7.r(true);
        L67:
            com.bytedance.android.livesdk.log.j0.l().addSendLogFilter(com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.class, com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.c);
        L68:
            r0.initDataContext();
            goto L69
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // ih0.b
    public final void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
    }

    @Override // ih0.b
    public final JsonObject Nm() {
        Intrinsics.checkNotNullParameter("adventure", "bizId");
        Intrinsics.checkNotNullParameter("state", "key");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r4 = this.a;
        JsonObject r5 = null;
        if (r4 == null) goto L10;
        Intrinsics.checkNotNullParameter("adventure", "bizId");
        Intrinsics.checkNotNullParameter("state", "key");
        e r0 = r4.d.get("adventure");
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter("state", "key");
        JsonElement r1 = r0.a.get("state");
        if (r1 == null) goto L9;
        r5 = r1.getAsJsonObject();
    L9:
        ALogger.i("MultiLinkDynamicWidget", "getBizState key: state, result=" + r5);
    L10:
        return r5;
    }

    @Override // ih0.b
    public final Map<Integer, List<Integer>> Pl() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r0 = this.b;
        if (r0 == null) goto L7;
        Map<Integer, List<Integer>> r1 = (Map) r0.h.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    @Override // ih0.b
    public final Object Xg() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    @Override // ih0.b
    public final ih0.c Z9() {
        e0 r0 = this.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // ih0.b
    public final Map<String, LayoutConfigModel> en() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r0 = this.b;
        if (r0 == null) goto L7;
        Map<String, LayoutConfigModel> r1 = (Map) r0.g.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return MapsKt.emptyMap();
    }

    public final void initDataContext() {
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiLinkDynamicWidgetNew$initDataContext$pair$1.INSTANCE);
        MultiLinkDynamicContext r1 = (MultiLinkDynamicContext) r0.getFirst();
        r1.getServiceMutable().setValue(this);
        r1.isFeed().d(Boolean.FALSE);
        if (((Boolean) oa1.a.getValue()).booleanValue() == false) goto L5;
        com.bytedance.live.datacontext.b.a(r1, "MultiLinkDynamicContext");
    L6:
        this.v.add((Disposable) r0.getSecond());
        return;
    L5:
        com.bytedance.live.datacontext.b.a(r1, com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.b.class);
        goto L6
    }

    @Override // ih0.b
    public final boolean isDynamicAnimating() {
        AudioLayoutDynamicHandler r0 = this.e;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiLinkDynamicWidgetNew#onCreate", "stack = " + Log.getStackTraceString(new Throwable()));
        int r2 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r3 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, this.z);
        if (r3 == null) goto L5;
        r3.c();
    L5:
        System.currentTimeMillis();
        long r4 = System.currentTimeMillis();
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        int r5 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        MultiSceneEnterRoomStatisticsUtils r6 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, 0L);
        if (r6 == null) goto L8;
        long r7 = r6.c();
    L9:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a = r7;
        ALogger.i("MultiLinkDynamicWidget-Time", "multilink dynamic widget start: " + (System.currentTimeMillis() - com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a));
        if (MultiLinkLoadWidgetUtils.g() == true) goto L12;
        initDataContext();
    L12:
        int r8 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(((Widget) this).dataCenter, this, null);
        this.a = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i(((Widget) this).context, ((Widget) this).dataCenter, this.y, this);
        this.b = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v(((Widget) this).context, ((Widget) this).dataCenter, this);
        this.c = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.q(((Widget) this).context, ((Widget) this).dataCenter, this, this);
        this.d = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.k0(((Widget) this).context, ((Widget) this).dataCenter);
        this.e = new AudioLayoutDynamicHandler(((Widget) this).context, ((Widget) this).dataCenter);
        this.f = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.f0(((Widget) this).context, ((Widget) this).dataCenter);
        this.g = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.e(((Widget) this).context, ((Widget) this).dataCenter);
        this.h = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.k(((Widget) this).context, ((Widget) this).dataCenter);
        this.i = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i0(Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.j(this).isAnchor(), Boolean.TRUE));
        this.j = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.g(((Widget) this).context, ((Widget) this).dataCenter);
        this.k = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.b(((Widget) this).context, ((Widget) this).dataCenter);
        this.l = new PerfStrategyDynamicHandler(((Widget) this).context, ((Widget) this).dataCenter, this);
        this.m = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.h0(((Widget) this).context, ((Widget) this).dataCenter, this);
        this.n = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.n(((Widget) this).context, ((Widget) this).dataCenter);
        this.o = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.l(((Widget) this).context, ((Widget) this).dataCenter, this);
        this.r = CollectionsKt.mutableListOf(new lh0.b[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.j, this.k, this.l, this.m, this.n});
        if (MultiLinkLoadWidgetUtils.g() == false) goto L22;
        this.p = CollectionsKt.mutableListOf(new lh0.b[]{this.a, this.b});
        this.q = CollectionsKt.mutableListOf(new lh0.b[]{this.c, this.d, this.e, this.f, this.g, this.h, this.j, this.k, this.l, this.m, this.n, this.o});
        List<? extends lh0.b> r9 = this.p;
        if (r9 == null) goto L28;
        Iterator<T> r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L28;
        lh0.b r11 = (lh0.b) r10.next();
        if (r11 == null) goto L18;
        r11.c();
    L28:
        Context r12 = ((Widget) this).context;
        if (r12 == null) goto L364;
        final e0 r13 = new e0(r12, ((Widget) this).dataCenter, this.y);
        this.u = r13;
        Long r14 = this.z;
        boolean r15 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L37;
        if (r14 != null) goto L34;
    L35:
        f2.c("room_id异常 " + r14, 0);
        goto L37
    L34:
        if (r14.longValue() <= 0) goto L35;
    L37:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L39;
    L41:
        boolean r16 = false;
    L42:
        if (r16 == true) goto L44;
    L53:
        String r17 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f();
        int r18 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a;
        Intrinsics.checkNotNullParameter(r17, "lynxUrl");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "loadRootWidget, lynxUrl: " + r17);
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a() == false) goto L57;
        JSONObject r19 = new JSONObject();
        r19.put("lynx_url", r17);
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("loadRootWidget, extra: %s", Arrays.copyOf(new Object[]{r19}, 1)));
        int r20 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_native_root_widget_load", 0, null, r19, 88);
    L57:
        g4 r21 = g4.b;
        r21.b("multi_link_main_lynx_load");
        long r111 = System.currentTimeMillis();
        if (r13.e == null) goto L60;
        long r36 = r4;
        String r35 = "MultiLinkDynamicWidgetNew#onCreate";
        r14 = r14;
        g4 r38 = r21;
        String r39 = "multi_link_main_lynx_load";
        String r42 = "MultiLinkDynamicWidget";
        String r22 = r17;
        long r40 = r111;
    L256:
        if (r13.d == null) goto L258;
    L257:
        String r23 = r42;
    L363:
        MultiLinkLoadWidgetUtils.m(r13.b, "MultiLinkMainHybridCardManager", "call onCreate spendTime = " + (System.currentTimeMillis() - r40));
        r38.a(r39);
    L365:
        ALogger.e(r23, "MultiLinkDynamicWidget， call onCreate");
        DataCenter r24 = ((Widget) this).dataCenter;
        if (r24 == null) goto L368;
        boolean r25 = true;
        r24.observe("data_multi_link_dynamic_layout_info_change", this, true);
    L369:
        DataCenter r26 = ((Widget) this).dataCenter;
        if (r26 == null) goto L372;
        r26.observeForever("data_multi_lick_dynamic_event_change", this, r25);
    L372:
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L375;
        r27.observeForever("data_multi_lick_dynamic_widget_start", this, r25);
    L375:
        DataCenter r28 = ((Widget) this).dataCenter;
        if (r28 == null) goto L378;
        r28.observeForever("data_multi_link_dynamic_guest_list_change", this, r25);
    L378:
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L381;
        r29.observeForever("data_multi_link_data_merge_center_init", this, r25);
    L381:
        DataCenter r30 = ((Widget) this).dataCenter;
        if (r30 == null) goto L384;
        r30.observeForever("data_multi_link_window_list_helper_init", this, r25);
    L384:
        jh0.c r31 = jh0.b.a;
        ALogger.i("DynamicBizExtController", "onDynamicWidgetCreate");
        jh0.c r32 = new jh0.c();
        jh0.b.a = r32;
        if (gh0.a.d() == true) goto L389;
        ALogger.i("DynamicBizLogHelper", "onDynamicWidgetCreate");
        hd0.c.f().c(r32.c);
    L389:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L391;
        MessageProcessor r33 = new MessageProcessor(((Widget) this).dataCenter);
        this.w = r33;
        r33.b();
        com.bytedance.android.livesdk.log.j0.l().addSendLogFilter(com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.class, com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.c);
    L391:
        ((ObservableSubscribeProxy) xs2.b.a().b(i1.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
        System.currentTimeMillis();
        MiddlewareRoomContext r34 = o3.c(((Widget) this).dataCenter);
        if (r34 == null) goto L398;
        com.bytedance.live.datacontext.n r37 = r34.isRoomVisible();
        if (r37 == null) goto L398;
        Boolean r41 = (Boolean) r37.getValue();
        if (r41 == null) goto L398;
        boolean r43 = r41.booleanValue();
    L399:
        runWithRoomVisible(new c(this, r43));
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, r35, "useTime = " + (System.currentTimeMillis() - r36));
        return;
    L398:
        r43 = false;
        goto L399
    L368:
        r25 = true;
        goto L369
    L258:
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        String r210 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.e();
        if (r14 != null) goto L266;
        com.bytedance.live.datacontext.m r44 = o3.j(r13.b).getRoom();
        if (r44 == null) goto L265;
        IRoom r45 = (IRoom) r44.getValue();
        if (r45 == null) goto L265;
        Long r211 = Long.valueOf(r45.getRoomId());
    L267:
        r0.element = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r22, r210, r211, false, 0, false, 48);
        long r212 = System.currentTimeMillis();
        int r46 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.c(((Uri) r0.element).toString(), "main", "root");
        int r47 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r48 = r13.b;
        if (r14 == null) goto L270;
        long r49 = r14.longValue();
    L271:
        MultiSceneEnterRoomStatisticsUtils r50 = MultiSceneEnterRoomStatisticsUtils.a.a(r48, Long.valueOf(r49));
        if (r50 == null) goto L274;
        r50.recordSubElementShow("lynx_container_load_start", System.currentTimeMillis());
    L274:
        Objects.toString((Uri) r0.element);
        if (d0.c.a() < d0.a) goto L277;
        boolean r51 = true;
    L278:
        DataCenter r52 = r13.b;
        StringBuilder r53 = new StringBuilder("[tag:MultiLinkHybridCardReuseManager]开始加载逻辑容器，使用缓存？ ");
        if (vm2.h.O().k() == false) goto L282;
        if (r51 == false) goto L282;
        boolean r54 = true;
    L283:
        r53.append(r54);
        MultiLinkLoadWidgetUtils.p(r52, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", r53.toString());
        if (vm2.h.O().k() == false) goto L289;
        if (r51 == false) goto L289;
        d0 r55 = d0.f;
        Context r56 = e0.a.a(r13.a);
        DataCenter r57 = r13.b;
        new MultiLinkMainHybridCardManager$obtainMainHybridComponent$1(r13);
        Long r58 = r14;
        ih0.c r59 = r55.b(r56, r58, r57);
        r13.d = r59;
        r13.p(r59);
        ih0.c r60 = r13.d;
        if (r60 == null) goto L301;
        r60.onLoadSuccess().subscribe(new q0(r60, r13, r58));
    L301:
        DataCenter r61 = r13.b;
        StringBuilder r62 = new StringBuilder("[tag:MultiLinkHybridCardReuseManager]加载AnnieCard成功！使用缓存？ ");
        if (vm2.h.O().k() == false) goto L305;
        if (r51 == false) goto L305;
        boolean r63 = true;
    L306:
        r62.append(r63);
        MultiLinkLoadWidgetUtils.p(r61, "MultiLinkMainHybridCardManager#obtainMainHybridComponent", r62.toString());
        ih0.c r65 = r13.d;
        if (r65 == null) goto L309;
        View r66 = r65.getHybridView();
    L310:
        e0.m(r66, r13.a);
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L313;
        float r67 = 100.0f;
    L314:
        ih0.c r68 = r13.d;
        if (r68 == null) goto L257;
        View r69 = r68.S0();
        if (r69 == null) goto L319;
        ViewParent r70 = r69.getParent();
    L321:
        if ((r70 instanceof ViewGroup) == true) goto L323;
        r70 = null;
    L323:
        ViewGroup r71 = (ViewGroup) r70;
        if (r71 == null) goto L331;
        ih0.c r72 = r13.d;
        if (r72 == null) goto L328;
        View r73 = r72.S0();
    L329:
        r71.removeView(r73);
        goto L331
    L328:
        r73 = null;
    L331:
        if ((r13.c instanceof ConstraintLayout) == false) goto L337;
        ConstraintLayout.LayoutParams r74 = new ConstraintLayout.LayoutParams(s1.f(r67), s1.f(r67));
        ((ViewGroup.MarginLayoutParams) r74).topMargin = s1.f(164.0f);
        r74.topToTop = 2131388184;
        ih0.c r75 = r13.d;
        if (r75 == null) goto L343;
        View r76 = r75.S0();
        if (r76 == null) goto L343;
        r76.setLayoutParams(r74);
    L343:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L349;
        ih0.c r77 = r13.d;
        if (r77 == null) goto L355;
        View r78 = r77.S0();
        if (r78 == null) goto L355;
        r78.setBackgroundColor(ColorProtector.parseColor("#55FF0000"));
    L355:
        ViewGroup r79 = r13.c;
        if (r79 == null) goto L362;
        ih0.c r80 = r13.d;
        if (r80 == null) goto L360;
        View r81 = r80.S0();
    L361:
        r79.addView(r81);
        goto L362
    L360:
        r81 = null;
    L362:
        r23 = r42;
        ALogger.i(r23, "start add main HybridCard");
        goto L363
    L349:
        ih0.c r82 = r13.d;
        if (r82 == null) goto L355;
        View r83 = r82.S0();
        if (r83 == null) goto L355;
        r83.setBackgroundColor(0);
        goto L355
    L337:
        FrameLayout.LayoutParams r84 = new FrameLayout.LayoutParams(s1.f(r67), s1.f(r67));
        r84.topMargin = s1.f(164.0f);
        ih0.c r85 = r13.d;
        if (r85 == null) goto L343;
        View r86 = r85.S0();
        if (r86 == null) goto L343;
        r86.setLayoutParams(r84);
        goto L343
    L319:
        r70 = null;
        goto L321
    L313:
        r67 = 0.01f;
        goto L314
    L309:
        r66 = null;
    L305:
        r63 = false;
    L289:
        Long r87 = r14;
        s0 r88 = new s0(r13, r0, r212, r87);
        long r213 = System.currentTimeMillis();
        Uri r89 = (Uri) r0.element;
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L292;
        int r90 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r91 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r13.a), (Uri) r0.element, r88, r213, r13.b, false);
    L293:
        r13.d = r91;
        r13.p(r91);
        e0.k(r13.d, r13.e(r87));
        ih0.c r92 = r13.d;
        if (r92 == null) goto L296;
        r92.onLoadSuccess().subscribe(new r0(r92, r13, r87));
    L296:
        ih0.c r93 = r13.d;
        if (r93 == null) goto L301;
        View r94 = r93.S0();
        if (r94 == null) goto L301;
        r94.setTag(2131389672, Boolean.FALSE);
        goto L301
    L292:
        r91 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(jc1.k.n(IBaseBrowserService.class).getHybridCard(e0.a.a(r13.a), (Uri) r0.element, r88));
    L282:
        r54 = false;
        goto L283
    L277:
        r51 = false;
        goto L278
    L270:
        r49 = 0;
    L265:
        r211 = null;
        goto L267
    L266:
        r211 = r14;
        goto L267
    L60:
        String r214 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r215 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        if (r14 != null) goto L68;
        com.bytedance.live.datacontext.m r112 = o3.j(r13.b).getRoom();
        if (r112 == null) goto L67;
        IRoom r113 = (IRoom) r112.getValue();
        if (r113 == null) goto L67;
        Long r216 = Long.valueOf(r113.getRoomId());
    L69:
        Uri r114 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r214, r215, r216, false, 0, false, 48);
        z0 r115 = z0.g;
        boolean r217 = z0.c();
        r35 = "MultiLinkDynamicWidgetNew#onCreate";
        DataCenter r95 = r13.b;
        r36 = r4;
        StringBuilder r96 = new StringBuilder("[tag:MultiLinkRenderWidgetReuseManager]开始加载渲染容器，使用缓存？ ");
        if (r217 == true) goto L72;
    L74:
        boolean r97 = false;
    L75:
        r96.append(r97);
        MultiLinkLoadWidgetUtils.p(r95, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent", r96.toString());
        r38 = r21;
        r39 = "multi_link_main_lynx_load";
        r40 = r111;
        if (r217 == true) goto L78;
    L113:
        r42 = "MultiLinkDynamicWidget";
        r22 = r17;
        long r116 = System.currentTimeMillis();
        x0 r98 = new x0(r13, r116, r114);
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L116;
        int r99 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r100 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r13.a), r114, r98, r116, r13.b, false);
    L122:
        r13.e = r100;
        r13.p(r100);
        ih0.c r101 = r13.e;
        if (r101 == null) goto L127;
        View r102 = r101.S0();
        if (r102 == null) goto L127;
        UtilityKotlinExtentionsKt.u(r102);
    L127:
        r13.l(r13.e(null));
        ih0.c r103 = r13.e;
        if (r103 == null) goto L131;
        r103.onLoadSuccess().subscribe(new u0(r103, r13, r14));
    L131:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L133;
    L135:
        boolean r104 = false;
    L136:
        if (r104 == true) goto L142;
        long r105 = z0.a;
        DataCenter r117 = r13.b;
        Disposable r218 = z0.e;
        if (r218 == null) goto L140;
        r218.dispose();
    L140:
        z0.e = RxUtilKt.h(Observable.timer(r105, TimeUnit.SECONDS)).subscribe(new a1(r117));
    L142:
        ih0.c r106 = r13.e;
        if (r106 == null) goto L147;
        View r107 = r106.S0();
        if (r107 == null) goto L147;
        r107.setTag(2131389672, Boolean.FALSE);
    L147:
        int r108 = com.bytedance.android.live.liveinteract.utils.w0.a;
        if (((MultiLinkRevenueEnterRoomOptConfigV2) tp.a.getValue()).getStartEventOpt() == true) goto L150;
    L158:
        ih0.c r109 = r13.e;
        if (r109 == null) goto L161;
        View r118 = r109.getHybridView();
    L162:
        e0.m(r118, r13.a);
        ViewGroup r119 = r13.c;
        if (r119 == null) goto L166;
        ViewGroup r120 = (ViewGroup) r119.findViewById(2131380433);
        if (r120 == null) goto L166;
    L167:
        ih0.c r121 = r13.e;
        if (r121 == null) goto L172;
        View r122 = r121.S0();
        if (r122 == null) goto L172;
        r122.setId(2131389673);
    L172:
        StringBuilder r123 = new StringBuilder("roomId=");
        com.bytedance.android.livesdk.chatroom.o r124 = o3.j(r13.b);
        if (r124 == null) goto L179;
        com.bytedance.live.datacontext.m r125 = r124.getRoom();
        if (r125 == null) goto L179;
        IRoom r126 = (IRoom) r125.getValue();
        if (r126 == null) goto L179;
        Long r127 = Long.valueOf(r126.getRoomId());
    L180:
        r123.append(r127);
        r123.append(", render HybridCard add to viewGroup, viewGroup = ");
        r123.append(r120);
        r123.append(", viewGroupId=");
        if (r120 == null) goto L183;
        Integer r128 = Integer.valueOf(r120.getId());
    L184:
        r123.append(r128);
        ALogger.i("MultiLinkMainHybridCardManager", r123.toString());
        if ((r120 instanceof ConstraintLayout) == false) goto L198;
        ViewGroup.LayoutParams r129 = new ConstraintLayout.LayoutParams(-1, -1);
        ((ConstraintLayout.LayoutParams) r129).topToTop = 2131388184;
        ih0.c r130 = r13.e;
        if (r130 == null) goto L191;
        View r131 = r130.S0();
        if (r131 == null) goto L191;
        r131.setLayoutParams(r129);
    L191:
        ih0.c r132 = r13.e;
        if (r132 == null) goto L194;
        View r133 = r132.S0();
    L195:
        if (r133 == null) goto L197;
        r120.addView(r133, r129);
    L227:
        DataCenter r134 = r13.b;
        if (r134 == null) goto L230;
        IRoom r135 = com.bytedance.android.live.core.utils.a0.o(r134);
    L232:
        if (je0.d.r() == true) goto L238;
        if (r135 == null) goto L238;
        z5 r136 = r135.getLinkerDetail();
        if (r136 == null) goto L238;
        Integer r137 = Integer.valueOf(r136.getUiLayout());
    L240:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(r137, 0, 6) == true) goto L246;
        ih0.c r138 = r13.e;
        if (r138 == null) goto L244;
        View r139 = r138.S0();
    L245:
        r3.k(r139);
        goto L246
    L244:
        r139 = null;
    L246:
        ih0.c r140 = r13.e;
        if (r140 == null) goto L251;
        j r141 = r13.f;
        if (r141 == null) goto L251;
        Intrinsics.checkNotNullParameter(r140, "widget");
        r141.a = r140;
    L251:
        j r142 = r13.f;
        if (r142 == null) goto L256;
        r142.d(com.bytedance.android.live.core.utils.a0.o(r13.b));
    L238:
        r137 = je0.d.h();
        goto L240
    L230:
        r135 = null;
        goto L232
    L197:
        LiveTracingMonitor.a("obtainRenderWidgetError", new Throwable("obtainRenderWidgetError"), "RenderWidget null! ConstraintLayout");
        goto L227
    L194:
        r133 = null;
        goto L195
    L198:
        FrameLayout.LayoutParams r143 = new FrameLayout.LayoutParams(-1, -1);
        ih0.c r144 = r13.e;
        if (r144 == null) goto L203;
        View r145 = r144.S0();
        if (r145 == null) goto L203;
        r145.setLayoutParams(r143);
    L203:
        ih0.c r146 = r13.e;
        if (r146 == null) goto L208;
        View r147 = r146.S0();
        if (r147 == null) goto L208;
        ViewParent r148 = r147.getParent();
    L210:
        if ((r148 instanceof ViewGroup) == true) goto L212;
        r148 = null;
    L212:
        ViewGroup r149 = (ViewGroup) r148;
        if (r149 == null) goto L219;
        ih0.c r150 = r13.e;
        if (r150 == null) goto L217;
        View r151 = r150.S0();
    L218:
        r149.removeView(r151);
        goto L219
    L217:
        r151 = null;
    L219:
        ih0.c r152 = r13.e;
        if (r152 == null) goto L222;
        View r153 = r152.S0();
    L223:
        if (r153 == null) goto L226;
        if (r120 == null) goto L227;
        r120.addView(r153, r143);
        goto L227
    L226:
        LiveTracingMonitor.a("obtainRenderWidgetError", new Throwable("obtainRenderWidgetError"), "RenderWidget null! FrameLayout");
        goto L227
    L222:
        r153 = null;
    L208:
        r148 = null;
        goto L210
    L183:
        r128 = null;
    L179:
        r127 = null;
    L166:
        r120 = r13.c;
        goto L167
    L161:
        r118 = null;
        goto L162
    L150:
        if (e0.j() == false) goto L158;
        JsonObject r154 = new JsonObject();
        r154.addProperty("lifecycle", "start");
        r154.addProperty("source", PbRequest.SwitchType.ROOM);
        if (MultiLinkLoadWidgetUtils.k() == false) goto L154;
        r154.add("client_settings_info", e0.d());
    L154:
        r13.i(r154);
        int r155 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.d(r114.toString(), "render", "root", System.currentTimeMillis() - r116);
        ih0.c r156 = r13.e;
        if (r156 == null) goto L157;
        r156.sendJsEvent("renderWidgetLifecycle", r154);
    L157:
        MultiLinkLoadWidgetUtils.m(r13.b, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent#onLoadSuccess", "[tag:MultiLinkRenderWidgetReuseManager]渲染容器发送logicWidgetLifecycle start, 创建View后直接发送, renderWidget: " + r13.e);
        goto L158
    L133:
        if (vm2.h.W().disablePreloadRenderWidget() == false) goto L135;
        r104 = true;
        goto L136
    L116:
        IBaseBrowserService r157 = jc1.k.f(IBaseBrowserService.class);
        if (r157 == null) goto L254;
        HybridCard r158 = r157.getHybridCard(e0.a.a(r13.a), r114, r98);
        if (r158 == null) goto L254;
        r100 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(r158);
    L254:
        r14 = r14;
        goto L256
    L78:
        if (vm2.h.O().i() == false) goto L113;
        Context r159 = e0.a.a(r13.a);
        r42 = "MultiLinkDynamicWidget";
        DataCenter r160 = r13.b;
        r22 = r17;
        new MultiLinkMainHybridCardManager$obtainRenderHybridComponent$1(r13);
        ih0.c r161 = r115.b(r159, r14, r160);
        if (r161 == null) goto L254;
        r13.e = r161;
        r13.p(r161);
        ih0.c r162 = r13.e;
        if (r162 == null) goto L85;
        r162.onLoadSuccess().subscribe(new t0(r162, r13, r14));
    L85:
        ih0.c r163 = r13.e;
        if (r163 == null) goto L88;
        r163.J();
    L88:
        JsonObject r164 = new JsonObject();
        r164.addProperty("lifecycle", "start");
        r164.addProperty("source", PbRequest.SwitchType.ROOM);
        r13.i(r164);
        if (MultiLinkLoadWidgetUtils.k() == false) goto L91;
        r164.add("client_settings_info", e0.d());
    L91:
        MultiLinkLoadWidgetUtils.p(r13.b, "MultiLinkMainHybridCardManager#obtainRenderHybridComponent", "[tag:MultiLinkRenderWidgetReuseManager]渲染容器发送logicWidgetLifecycle start, 使用缓存, renderWidget: " + r13.e);
        ih0.c r165 = r13.e;
        if (r165 == null) goto L94;
        r165.sendJsEvent("renderWidgetLifecycle", r164);
    L94:
        ih0.c r166 = r13.e;
        if (r166 == null) goto L99;
        View r167 = r166.S0();
        if (r167 == null) goto L99;
        UtilityKotlinExtentionsKt.w(r167);
    L99:
        r13.s();
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == true) goto L102;
    L112:
        r14 = r14;
        goto L158
    L102:
        if ((r13.e instanceof com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) == false) goto L112;
        w0 r168 = new w0(r13);
        ih0.c r169 = r13.e;
        if (r169 == null) goto L111;
        ((com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) r169).h.setTag(2131362966, r168);
        ih0.c r170 = r13.e;
        if (r170 == null) goto L109;
        ((com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) r170).j = new v0(r168, r114);
        goto L112
    L109:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.AnnieXCardImpl");
    L111:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.AnnieXCardImpl");
    L72:
        if (vm2.h.O().i() == false) goto L74;
        r97 = true;
    L67:
        r216 = null;
        goto L69
    L68:
        r216 = r14;
        goto L69
    L44:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L46;
    L48:
        boolean r171 = false;
    L49:
        if (r171 == true) goto L51;
    L52:
        DataCenter r172 = r13.b;
        int r173 = MultiSceneEnterRoomStatisticsUtils.u;
        r13.f = new j(r172, MultiSceneEnterRoomStatisticsUtils.a.a(r172, 0L));
        goto L53
    L51:
        if (je0.d.E(r13.b) == true) goto L53;
    L46:
        if (vm2.h.W().disableAnchorFS() == false) goto L48;
        r171 = true;
        goto L49
    L39:
        if (vm2.h.W().lynxFirstScreen() == false) goto L41;
        r16 = true;
        goto L42
    L364:
        r36 = r4;
        r35 = "MultiLinkDynamicWidgetNew#onCreate";
        r23 = "MultiLinkDynamicWidget";
        goto L365
    L22:
        Iterator<T> r174 = this.r.iterator();
    L24:
        if (r174.hasNext() == false) goto L28;
        lh0.b r175 = (lh0.b) r174.next();
        if (r175 == null) goto L24;
        r175.c();
        goto L24
    L8:
        r7 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiLinkDynamicWidgetNew#onDestroy", "MultiLinkDynamicWidgetNew onDestroy");
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        Dk("root", "stop", new JsonObject(), false);
        MessageProcessor r2 = this.w;
        if (r2 == null) goto L10;
        ALogger.e("MessageProcessor", "onDestroy.removeMessageListener:" + r2);
        vlc.d r3 = r2.c;
        if (r3 == null) goto L7;
        r3.removeMessageListener(r2);
    L7:
        DataCenter r4 = r2.d;
        if (r4 == null) goto L10;
        r4.removeObserver(r2);
    L10:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L13;
        r5.removeObserver("data_multi_link_dynamic_layout_info_change", this);
    L13:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L16;
        r6.removeObserver("data_multi_lick_dynamic_event_change", this);
    L16:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L19;
        r7.removeObserver("data_multi_lick_dynamic_widget_start", this);
    L19:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L22;
        r8.removeObserver("data_multi_link_dynamic_guest_list_change", this);
    L22:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L25;
        r9.removeObserver("data_multi_link_data_merge_center_init", this);
    L25:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L28;
        r10.removeObserver("data_multi_link_window_list_helper_init", this);
    L28:
        Boolean r11 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L48;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L33;
        r12.put("data_multi_link_dynamic_layout_info_change", null);
    L33:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L36;
        r13.put("data_multi_lick_dynamic_event_change", null);
    L36:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L39;
        r14.put("data_multi_lick_dynamic_widget_start", null);
    L39:
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L42;
        r15.put("data_multi_link_dynamic_guest_list_change", null);
    L42:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L45;
        r16.put("data_multi_link_data_merge_center_init", null);
    L45:
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L48;
        r17.removeObserver("data_multi_link_window_list_helper_init", this);
    L48:
        ((LinkedHashMap) this.x).clear();
        e0 r18 = this.u;
        if (r18 == null) goto L99;
        ALogger.i("MultiLinkDynamicWidget", "MultiLinkMainHybridCardManager onDestroy");
        ih0.c r19 = r18.d;
        if (r19 == null) goto L53;
        r19.J();
    L53:
        ih0.c r20 = r18.e;
        if (r20 == null) goto L56;
        r20.J();
    L56:
        j r21 = r18.f;
        if (r21 == null) goto L60;
        r21.a();
    L60:
        if (vm2.h.O().k() == false) goto L66;
        ih0.c r22 = r18.d;
        if (r22 == null) goto L64;
        View r23 = r22.getHybridView();
    L65:
        e0.m(r23, s1.getContext());
        int r24 = d0.a;
        d0.d(r18.d, r18.b, null);
    L75:
        int r25 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a;
        boolean r26 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r27 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f();
        Intrinsics.checkNotNullParameter(r27, "lynxUrl");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "unloadRootWidget, lynxUrl: " + r27);
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a() == false) goto L80;
        JSONObject r110 = new JSONObject();
        r110.put("lynx_url", r27);
        StringCompanionObject r28 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("unloadRootWidget, extra: %s", Arrays.copyOf(new Object[]{r110}, 1)));
        int r29 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_native_root_widget_unload", 0, null, r110, 88);
    L80:
        if (vm2.h.O().i() == false) goto L86;
        ih0.c r30 = r18.e;
        if (r30 == null) goto L84;
        View r31 = r30.getHybridView();
    L85:
        e0.m(r31, s1.getContext());
        int r32 = z0.b;
        z0.g(r18.e, r18.b, null);
    L92:
        r18.d = null;
        r18.e = null;
        r18.i.clear();
        r18.j.clear();
        Context r33 = r18.a;
        if ((r33 instanceof MutableContextWrapper) == true) goto L95;
        r33 = null;
    L95:
        MutableContextWrapper r34 = (MutableContextWrapper) r33;
        if (r34 == null) goto L98;
        r34.setBaseContext(s1.getContext());
    L98:
        r18.c = null;
        r18.b = new DataCenter();
        goto L99
    L84:
        r31 = null;
        goto L85
    L86:
        ih0.c r35 = r18.e;
        if (r35 == null) goto L89;
        r35.J();
    L89:
        ih0.c r36 = r18.e;
        if (r36 == null) goto L92;
        r36.release();
        goto L92
    L64:
        r23 = null;
        goto L65
    L66:
        ih0.c r37 = r18.d;
        if (r37 == null) goto L75;
        r37.release();
        ViewGroup r38 = r18.c;
        if (r38 == null) goto L75;
        ih0.c r39 = r18.d;
        if (r39 == null) goto L73;
        View r40 = r39.S0();
    L74:
        r38.removeView(r40);
        goto L75
    L73:
        r40 = null;
    L99:
        this.v.dispose();
        int r41 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(((Widget) this).dataCenter, null, null);
        Iterator<T> r42 = this.r.iterator();
    L101:
        if (r42.hasNext() == false) goto L105;
        lh0.b r43 = (lh0.b) r42.next();
        if (r43 == null) goto L101;
        r43.d();
        goto L101
    L105:
        ((LinkedHashMap) this.s).clear();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L116;
        MiddlewareRoomContext r44 = o3.c(((Widget) this).dataCenter);
        if (r44 == null) goto L113;
        com.bytedance.live.datacontext.n r45 = r44.isRoomVisible();
        if (r45 == null) goto L113;
        r11 = (Boolean) r45.getValue();
    L113:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L115;
        jh0.b.a();
    L115:
        com.bytedance.android.livesdk.log.j0.l().removeSendLogFilter(com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.class);
        return;
    L116:
        jh0.b.a();
        com.bytedance.android.livesdk.log.j0.l().removeSendLogFilter(com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.class);
    }

    @Override // ih0.b
    public final ih0.c oo() {
        Intrinsics.checkNotNullParameter("radio_stage", "itemId");
        Map<String, ih0.c> r0 = this.x;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ih0.c) ((LinkedHashMap) r0).get("radio_stage");
    }

    @Override // ih0.b
    public final ih0.c tb() {
        e0 r0 = this.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        Iterator<T> r0 = this.r.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        lh0.b r1 = (lh0.b) r0.next();
        goto L4
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L16;
        List<? extends lh0.b> r0 = this.p;
        if (r0 == null) goto L11;
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        lh0.b r2 = (lh0.b) r1.next();
    L11:
        if (this.t == false) goto L20;
        Iterator<T> r3 = this.q.iterator();
    L14:
        if (r3.hasNext() == false) goto L24;
        lh0.b r4 = (lh0.b) r3.next();
        goto L14
    L24:
        return;
    L20:
        return;
    L16:
        Iterator<T> r5 = this.r.iterator();
    L18:
        if (r5.hasNext() == false) goto L25;
        lh0.b r6 = (lh0.b) r5.next();
        goto L18
    }

    @Override // ih0.b
    public final void Ll(List<? extends tf0.e> r2) {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r0 = this.b;
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }

    @Override // ih0.b
    public final JsonObject T(ih0.e r17) {
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r3 = r17.c;
        uf2.d0 r5 = null;
        if (r3 != null) goto L6;
        ALogger.e("MultiLinkDynamicWidget", "get status but getExtraInfo is empty");
        return null;
    L6:
        boolean r7 = false;
        boolean r8 = false;
        r8 = false;
        r8 = false;
        int r9 = 0;
        r9 = 0;
        r9 = 0;
        r9 = 0;
        int r10 = 0;
        boolean r11 = false;
        r11 = false;
        boolean r12 = true;
        if (r17.b.length() != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L13;
        ALogger.e("MultiLinkDynamicWidget", "get status but fromBizId is empty");
        return null;
    L13:
        ALogger.i("MultiLinkDynamicWidget", "get status getExtraInfo=" + r3 + ", type = " + r17.getType());
        String r13 = "";
        switch(k.b[r17.getType().ordinal()]) {
            case 1: goto L372;
            case 2: goto L372;
            case 3: goto L372;
            case 4: goto L281;
            case 5: goto L281;
            case 6: goto L281;
            case 7: goto L281;
            case 8: goto L281;
            case 9: goto L281;
            case 10: goto L281;
            case 11: goto L281;
            case 12: goto L249;
            case 13: goto L249;
            case 14: goto L207;
            case 15: goto L207;
            case 16: goto L207;
            case 17: goto L207;
            case 18: goto L191;
            case 19: goto L66;
            case 20: goto L50;
            case 21: goto L36;
            case 22: goto L16;
            default: goto L15;
        };
    L15:
        return null;
    L16:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.l r4 = this.o;
        if (r4 == null) goto L428;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r0 = r17.c;
        if (r0 == null) goto L34;
        if (r0.has("type") != true) goto L34;
        JsonElement r1 = r0.get("type");
        if (r1 == null) goto L25;
        r5 = r1.getAsString();
    L25:
        if (r5 == null) goto L34;
        if (r5.hashCode() != (-127455574)) goto L34;
        if (r5.equals("particle_ready") == false) goto L34;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.m.a(r4.d);
    L34:
        return new JsonObject();
    L428:
        return null;
    L50:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.h0 r14 = this.m;
        if (r14 == null) goto L432;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r2 = r17.c;
        if (r2 == null) goto L433;
        ALogger.i(r14.d, "get status getExtraInfo=" + r2 + ", type = " + r17.getType());
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.g0.b[r17.getType().ordinal()] != 1) goto L434;
        IKtvService r15 = jc1.k.f(IKtvService.class);
        if (r15 == null) goto L62;
        JsonObject r16 = r15.handleDynamicJsbGetAction(r17.c);
        if (r16 == null) goto L62;
    L64:
        return r16;
    L62:
        r16 = new JsonObject();
        goto L64
    L434:
        return null;
    L433:
        return null;
    L432:
        return null;
    L207:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.q r18 = this.c;
        if (r18 == null) goto L441;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r19 = r17.c;
        if (r19 == null) goto L446;
        ALogger.i("MultiLinkDynamicWidget", "get status getExtraInfo=" + r19 + ", type = " + r17.getType());
        int r20 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.p.e[r17.getType().ordinal()];
        if (r20 == 1) goto L237;
        if (r20 == 2) goto L231;
        if (r20 != 3) goto L217;
    L219:
        int r21 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.p.d[r17.getType().ordinal()];
        if (r21 == 1) goto L224;
        if (r21 != 2) goto L225;
        r13 = "ktv_order_info";
    L225:
        IInteractService r22 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r22 == null) goto L442;
        JsonObject r23 = r17.c;
        if (r23 != null) goto L443;
        r23 = new JsonObject();
    L443:
        return r22.handleLinkLynxPanelJsbGetAction("emoji_interact_panel_type", r13, r23);
    L442:
        return null;
    L224:
        r13 = "interact_panel_config";
        goto L225
    L217:
        if (r20 == 4) goto L219;
        return null;
    L231:
        IInteractService r24 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r24 == null) goto L444;
        JsonObject r25 = r17.c;
        if (r25 != null) goto L445;
        r25 = new JsonObject();
    L445:
        return r24.handleLinkLynxPanelJsbGetAction("setting_panel_type", "setting_panel_config", r25);
    L444:
        return null;
    L237:
        com.bytedance.android.livesdk.chatroom.widget.j1 r26 = r18.f;
        if (r26 == null) goto L240;
        r5 = (cg6.a) r26.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L240:
        if (r5 == null) goto L245;
        hg6.h r27 = r5.Fn();
        if (r27 == null) goto L245;
        JsonObject r28 = r27.b(r17.c);
        if (r28 == null) goto L245;
    L247:
        return r28;
    L245:
        r28 = new JsonObject();
        goto L247
    L446:
        return null;
    L441:
        return null;
    L281:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r29 = this.a;
        if (r29 == null) goto L453;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r110 = r17.c;
        if (r110 == null) goto L460;
        String r111 = r17.b;
        ALogger.i("MultiLinkDynamicWidget", "get status getExtraInfo=" + r110 + ", type = " + r17.getType());
        switch(com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.h.b[r17.getType().ordinal()]) {
            case 1: goto L365;
            case 2: goto L361;
            case 3: goto L359;
            case 4: goto L338;
            case 5: goto L331;
            case 6: goto L322;
            case 7: goto L310;
            case 8: goto L289;
            default: goto L461;
        };
    L289:
        JsonObject r30 = new JsonObject();
        JsonObject r31 = r17.c;
        if (r31 == null) goto L295;
        JsonElement r32 = r31.get("channel_name");
        if (r32 == null) goto L295;
        String r33 = r32.getAsString();
        if (r33 == null) goto L295;
    L296:
        String r34 = r33.concat("/pages/root_widget/template.js");
        String r35 = LiveGeckoConfig.b();
        com.bytedance.android.livesdk.gecko.n r36 = com.bytedance.android.livesdk.gecko.n.b;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r34, "relativePath");
        LiveResourcesDistributionImpl r112 = r36.a;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r34, "relativePath");
        com.bytedance.android.livesdk.gecko.j r113 = r112.a;
        if (r113 != null) goto L299;
    L301:
        ALogger.i("MultiLinkDynamicWidget", "getChannelVersion -- accessKey--" + r35 + "; fileExists--" + r11);
        Intrinsics.checkNotNullParameter(r33, "channel");
        LiveResourcesDistributionImpl r37 = r36.a;
        r37.getClass();
        Intrinsics.checkNotNullParameter(r33, "channel");
        com.bytedance.android.livesdk.gecko.j r38 = r37.a;
        if (r38 == null) goto L304;
        r5 = r38.getChannelVersion(r33);
    L304:
        if (r5 == null) goto L309;
        String r39 = String.valueOf(r5.longValue());
        if (r39 == null) goto L309;
        r13 = r39;
    L309:
        r30.add("channel_info", GsonProtectorUtils.toJsonTree(new Gson(), new com.bytedance.android.live.liveinteract.plantform.model.b(r13)).getAsJsonObject());
    L458:
        return r30;
    L299:
        if (r113.d(r34) != true) goto L301;
        r11 = true;
    L295:
        r33 = "";
        goto L296
    L310:
        com.bytedance.live.datacontext.m r40 = com.bytedance.android.live.liveinteract.api.utils.m.n(r29.c, null, 2).getSeiTimePair();
        if (r40 == null) goto L314;
        com.bytedance.android.livesdk.chatroom.z0 r41 = (com.bytedance.android.livesdk.chatroom.z0) r40.getValue();
        if (r41 == null) goto L314;
    L315:
        r30 = new JsonObject();
        IInteractService r42 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r42 == null) goto L318;
        r7 = r42.isAudienceLinkEngineOn();
    L318:
        if (r7 == false) goto L320;
        long r114 = 0;
    L321:
        r30.addProperty("liveStreamDelayTime", String.valueOf(r114));
        goto L458
    L320:
        r114 = r41.b - r41.a;
    L314:
        r41 = new com.bytedance.android.livesdk.chatroom.z0(System.currentTimeMillis(), System.currentTimeMillis());
        goto L315
    L322:
        JsonObject r43 = new JsonObject();
        JsonObject r44 = (JsonObject) r29.c.get("data_room_cache_json", null);
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L326;
        if (r44 == null) goto L326;
        r43.add(PbRequest.SwitchType.ROOM, r44);
    L454:
        return r43;
    L326:
        com.bytedance.live.datacontext.m r45 = com.bytedance.android.live.liveinteract.api.utils.m.n(r29.c, null, 2).getRoom();
        if (r45 == null) goto L454;
        IRoom r46 = (IRoom) r45.getValue();
        if (r46 == null) goto L454;
        r43.add(PbRequest.SwitchType.ROOM, GsonProtectorUtils.toJsonTree(new Gson(), r46).getAsJsonObject());
        goto L454
    L331:
        DataCenter r47 = r29.c;
        if (r47 == null) goto L334;
        r5 = (EnterRoomInfoResult) r47.get("data_room_enter_info", null);
    L334:
        r43 = new JsonObject();
        if (r5 == null) goto L454;
        r43.add("enter_info", GsonProtectorUtils.toJsonTree(new Gson(), r5).getAsJsonObject());
        goto L454
    L338:
        String r48 = r110.get("dress_id").getAsString();
        String r49 = r110.get("config_name").getAsString();
        ALogger.d("MultiLinkDynamicWidget", "get Dress dressId = " + r48 + "; configName=" + r49);
        if (r48.length() != 0) goto L341;
        boolean r50 = true;
    L342:
        if (r50 == false) goto L344;
    L358:
        ALogger.e("MultiLinkDynamicWidget", "get Dress but dressId or configName is empty");
        return null;
    L344:
        if (r49.length() == 0) goto L347;
        r12 = false;
    L347:
        if (r12 == true) goto L358;
        zt0.d r51 = yt0.c.b();
        if (r51 == null) goto L352;
        com.bytedance.android.live.profit.dress.o r52 = r51.getDressModel(r48, 0, "MultiLinkDynamicWidget");
    L353:
        if (r52 == null) goto L455;
        r30 = new Gson().toJsonTree(r52).getAsJsonObject().getAsJsonObject(r49);     // Catch: Exception -> L356
        ALogger.d("MultiLinkDynamicWidget", "get Dress dressConfig = " + r30);     // Catch: Exception -> L356
    L356:
        e = move-exception;
        StringBuilder r53 = new StringBuilder("get Dress exception: ");
        e.printStackTrace();
        r53.append(Unit.INSTANCE);
        ALogger.e("MultiLinkDynamicWidget", r53.toString());
        return null;
    L455:
        return null;
    L352:
        r52 = null;
        goto L353
    L341:
        r50 = false;
        goto L342
    L359:
        JsonElement r54 = r29.f.get(r111 + '_' + r110.get("key").getAsString());
        r30 = new JsonObject();
        r30.add("value", r54);
        goto L458
    L361:
        e r55 = r29.d.get(r111);
        r30 = new JsonObject();
        if (r55 == null) goto L364;
        r5 = r55.a;
    L364:
        r30.add("value", r5);
        goto L458
    L365:
        e r56 = r29.d.get(r111);
        if (r56 == null) goto L459;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        if (f.b[r17.getType().ordinal()] != 1) goto L462;
        JsonObject r57 = new JsonObject();
        r57.addProperty("isShowing", Boolean.valueOf(r56.a()));
        return r57;
    L462:
        return null;
    L459:
        return null;
    L461:
        return null;
    L460:
        return null;
    L453:
        return null;
    L372:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r58 = this.b;
        if (r58 == null) goto L463;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r59 = r17.c;
        if (r59 == null) goto L480;
        ALogger.i(r58.d, "get status getExtraInfo=" + r59 + ", type = " + r17.getType());
        int r60 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.r.b[r17.getType().ordinal()];
        if (r60 == 1) goto L418;
        if (r60 == 2) goto L401;
        if (r60 == 3) goto L383;
        return null;
    L383:
        if (r58.b().isLiveTypeAudio() == false) goto L393;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L389;
        int r61 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r62 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(r58.c);
        if (r62 != null) goto L465;
        return null;
    L465:
        return r62.getLinkmicAreaFrameInfo();
    L389:
        qd0.a r63 = ((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService();
        if (r63 != null) goto L467;
        return null;
    L467:
        return r63.getLinkmicAreaFrameInfo();
    L393:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L397;
        int r65 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r66 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(r58.c);
        if (r66 != null) goto L469;
        return null;
    L469:
        return r66.getLinkmicAreaFrameInfo();
    L397:
        rj0.m r67 = ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService();
        if (r67 != null) goto L471;
        return null;
    L471:
        return r67.getLinkmicAreaFrameInfo();
    L401:
        if (r58.b().isLiveTypeAudio() == false) goto L411;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L407;
        int r68 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r69 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(r58.c);
        if (r69 != null) goto L473;
        return null;
    L473:
        return r69.getLinkmicSeatListInfo();
    L407:
        qd0.a r70 = ((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService();
        if (r70 != null) goto L475;
        return null;
    L475:
        return r70.getLinkmicSeatListInfo();
    L411:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L415;
        int r71 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r72 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(r58.c);
        if (r72 != null) goto L477;
        return null;
    L477:
        return r72.getLinkmicSeatListInfo();
    L415:
        rj0.m r73 = ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService();
        if (r73 != null) goto L479;
        return null;
    L479:
        return r73.getLinkmicSeatListInfo();
    L418:
        JsonObject r74 = new JsonObject();
        r74.addProperty("ui_layout", je0.d.h());
        r74.addProperty("scene", Integer.valueOf(je0.d.f()));
        JsonArray r75 = new JsonArray();
        Iterator<T> r76 = com.bytedance.android.live.liveinteract.plantform.utils.u0.d().iterator();
    L420:
        if (r76.hasNext() == false) goto L422;
        r75.add(Integer.valueOf(((Number) r76.next()).intValue()));
        goto L420
    L422:
        r74.add("play_mode", r75);
        return r74;
    L480:
        return null;
    L463:
        return null;
    L36:
        if (this.n == null) goto L429;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r77 = r17.c;
        if (r77 == null) goto L430;
        ALogger.i("KtvDynamicHandler", "get status getExtraInfo=" + r77 + ", type = " + r17.getType());
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.o.b[r17.getType().ordinal()] != 1) goto L431;
        IKtvService r78 = jc1.k.f(IKtvService.class);
        if (r78 == null) goto L47;
        JsonObject r79 = r78.handleKtvCommonJsbGetAction(r17.c, false);
        if (r79 == null) goto L47;
    L49:
        return r79;
    L47:
        r79 = new JsonObject();
        goto L49
    L431:
        return null;
    L430:
        return null;
    L429:
        return null;
    L66:
        if (this.g == null) goto L435;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r80 = r17.c;
        if (r80 == null) goto L436;
        ALogger.i("MultiLinkDynamicWidget", "get status getExtraInfo=" + r80 + ", type = " + r17.getType());
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.d.b[r17.getType().ordinal()] != 1) goto L437;
        JsonObject r81 = new JsonObject();
        String r82 = r80.get("type").getAsString();
        if (r82 == null) goto L189;
        switch(r82.hashCode()) {
            case -1822196135: goto L178;
            case -1094219786: goto L170;
            case -934592106: goto L135;
            case 245675462: goto L116;
            case 396970964: goto L98;
            case 735062463: goto L80;
            default: goto L189;
        };
    L80:
        if (r82.equals("big_head") == false) goto L189;
        HamletAvatarContext.a r83 = HamletAvatarContext.Companion;
        HamletAvatarContext r84 = r83.getContext();
        if (r84 == null) goto L88;
        com.bytedance.live.datacontext.j<gd0.g> r85 = r84.getHamletAvatarService();
        if (r85 == null) goto L88;
        gd0.g r86 = (gd0.g) r85.getValue();
        if (r86 == null) goto L88;
        boolean r87 = r86.kl();
    L89:
        HamletAvatarContext r88 = r83.getContext();
        if (r88 == null) goto L96;
        com.bytedance.live.datacontext.j<gd0.g> r89 = r88.getHamletAvatarService();
        if (r89 == null) goto L96;
        gd0.g r90 = (gd0.g) r89.getValue();
        if (r90 == null) goto L96;
        r8 = r90.mg(0);
    L96:
        ALogger.w("HamletAvatar", "get bighead status,  isAvatarRender=" + r87 + ", isFirstEnlargeUserTalking=" + r8);
        JsonObject r91 = new JsonObject();
        r91.addProperty("display", Boolean.valueOf(r87 ^ true));
        r91.addProperty("talking", Boolean.valueOf(r8));
        Unit r92 = Unit.INSTANCE;
        r81.add("avatar", r91);
    L88:
        r87 = true;
        goto L89
    L98:
        if (r82.equals("avatar_info") == false) goto L189;
        JsonArray r93 = new JsonArray();
        HamletAvatarContext r94 = HamletAvatarContext.Companion.getContext();
        if (r94 == null) goto L107;
        Map<Long, Float> r95 = r94.getDownloadAvatarProgressRecord();
        if (r95 == null) goto L107;
        Iterator<Map.Entry<Long, Float>> r96 = r95.entrySet().iterator();
    L105:
        if (r96.hasNext() == false) goto L107;
        Map.Entry<Long, Float> r97 = r96.next();
        long r98 = r97.getKey().longValue();
        float r99 = r97.getValue().floatValue();
        JsonObject r115 = new JsonObject();
        r115.addProperty("avatar_id", Long.valueOf(r98));
        r115.addProperty("progress", Float.valueOf(r99));
        Unit r100 = Unit.INSTANCE;
        r93.add(r115);
    L107:
        JsonObject r101 = new JsonObject();
        HamletAvatarContext r102 = HamletAvatarContext.Companion.getContext();
        if (r102 == null) goto L114;
        com.bytedance.live.datacontext.j<gd0.g> r103 = r102.getHamletAvatarService();
        if (r103 == null) goto L114;
        gd0.g r104 = (gd0.g) r103.getValue();
        if (r104 == null) goto L114;
        r5 = r104.Ue();
    L114:
        r101.addProperty("avatar_id", r5);
        r101.add("avatar_progress", r93);
        Unit r105 = Unit.INSTANCE;
        r81.add("avatar", r101);
        goto L189
    L116:
        if (r82.equals("multi_camera_status") == false) goto L189;
        StringBuilder r106 = new StringBuilder("multi_camera_status, hasMultiCamera, ");
        HamletAvatarContext.a r107 = HamletAvatarContext.Companion;
        HamletAvatarContext r116 = r107.getContext();
        if (r116 == null) goto L124;
        com.bytedance.live.datacontext.j<gd0.g> r117 = r116.getHamletAvatarService();
        if (r117 == null) goto L124;
        gd0.g r118 = (gd0.g) r117.getValue();
        if (r118 == null) goto L124;
        r5 = Boolean.valueOf(r118.ib());
    L124:
        r106.append(r5);
        ALogger.w("HamletAvatar", r106.toString());
        JsonObject r108 = new JsonObject();
        HamletAvatarContext r109 = r107.getContext();
        if (r109 == null) goto L133;
        com.bytedance.live.datacontext.j<gd0.g> r119 = r109.getHamletAvatarService();
        if (r119 == null) goto L133;
        gd0.g r120 = (gd0.g) r119.getValue();
        if (r120 == null) goto L133;
        if (r120.ib() != true) goto L133;
        r9 = 1;
    L133:
        r108.addProperty("multi_camera_status", Integer.valueOf(r9));
        Unit r121 = Unit.INSTANCE;
        r81.add("avatar", r108);
        goto L189
    L135:
        if (r82.equals("render") == false) goto L189;
        HamletAvatarContext.a r122 = HamletAvatarContext.Companion;
        HamletAvatarContext r123 = r122.getContext();
        if (r123 == null) goto L143;
        com.bytedance.live.datacontext.j<gd0.g> r124 = r123.getHamletAvatarService();
        if (r124 == null) goto L143;
        gd0.g r125 = (gd0.g) r124.getValue();
        if (r125 == null) goto L143;
        boolean r126 = r125.kl();
    L144:
        HamletAvatarContext r127 = r122.getContext();
        if (r127 == null) goto L151;
        com.bytedance.live.datacontext.m<Boolean> r128 = r127.isStreamRending();
        if (r128 == null) goto L151;
        if (((Boolean) r128.getValue()).booleanValue() != true) goto L151;
        int r129 = 1;
    L152:
        com.bytedance.live.datacontext.j r130 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r130 == null) goto L157;
        com.bytedance.android.live.pushstream.d r131 = (com.bytedance.android.live.pushstream.d) r130.getValue();
        if (r131 == null) goto L157;
        r5 = r131.getLiveCore();
    L157:
        if (r5 == null) goto L159;
        r10 = 1;
    L159:
        ALogger.w("HamletAvatar", "get Avatar isRender=" + r126 + "， hamletContext=" + r122.getContext());
        JsonObject r132 = new JsonObject();
        r132.addProperty("is_render", Boolean.valueOf(r126));
        HamletAvatarContext r133 = r122.getContext();
        if (r133 == null) goto L167;
        com.bytedance.live.datacontext.n<Long> r134 = r133.getCurrentSelectAvatarID();
        if (r134 == null) goto L167;
        Long r135 = (Long) r134.getValue();
        if (r135 == null) goto L167;
        String r136 = String.valueOf(r135.longValue());
        if (r136 == null) goto L167;
    L168:
        r132.addProperty("avatar_id", r136);
        r132.addProperty("is_xplay_running", Integer.valueOf(r129));
        r132.addProperty("is_anchor_cast_device", Integer.valueOf(r10));
        Unit r137 = Unit.INSTANCE;
        r81.add("avatar", r132);
    L167:
        r136 = "0";
    L151:
        r129 = 0;
    L143:
        r126 = false;
        goto L144
    L170:
        if (r82.equals("topleft_seat_frame") == false) goto L189;
        IInteractService r138 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r138 == null) goto L176;
        qd0.a r139 = r138.getAudioTalkService();
        if (r139 == null) goto L176;
        r5 = r139.getTopLeftSeatFrameInfo();
    L176:
        ALogger.w("HamletAvatar", "get topleft_seat_frame frameInfo=" + GsonProtectorUtils.toJson(GsonHelper.get(), r5));
        r81.add("avatar", r5);
        goto L189
    L178:
        if (r82.equals("default_animation_index") == false) goto L189;
        HamletAvatarContext r140 = HamletAvatarContext.Companion.getContext();
        if (r140 == null) goto L186;
        com.bytedance.live.datacontext.n<Long> r141 = r140.getCurrentSelectAnimationIndex();
        if (r141 == null) goto L186;
        Long r142 = (Long) r141.getValue();
        if (r142 == null) goto L186;
        long r143 = r142.longValue();
    L187:
        JsonObject r144 = new JsonObject();
        r144.addProperty("default_animation_index", Long.valueOf(r143));
        Unit r145 = Unit.INSTANCE;
        r81.add("avatar", r144);
    L186:
        r143 = 0;
    L189:
        return r81;
    L437:
        return null;
    L436:
        return null;
    L435:
        return null;
    L191:
        if (this.k == null) goto L438;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r146 = r17.c;
        if (r146 == null) goto L439;
        ALogger.i("MultiLinkDynamicWidget", "get status getExtraInfo=" + r146 + ", type = " + r17.getType());
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.a.b[r17.getType().ordinal()] != 1) goto L440;
        JsonObject r147 = new JsonObject();
        int r148 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("AudioChatStage", "getSubtitleStatus, subtitle_status=" + ((IInteractService) jc1.k.n(IInteractService.class)).audioSubtitleOpen());
        r147.addProperty("subtitle_status", Boolean.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).audioSubtitleOpen()));
        int r149 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        Boolean r150 = Boolean.TRUE;
        r147.addProperty("guest_subtitle_option", r150);
        InteractiveSongContext r151 = InteractiveSongContext.Companion.getContext();
        if (r151 == null) goto L205;
        com.bytedance.live.datacontext.n<fd2.v> r152 = r151.getLyricsRecognizer();
        if (r152 == null) goto L205;
        fd2.v r153 = (fd2.v) r152.getValue();
        if (r153 == null) goto L205;
        r5 = Boolean.valueOf(r153.c());
    L205:
        r147.addProperty("show_recognition_lyrics", Boolean.valueOf(Intrinsics.areEqual(r5, r150)));
        return r147;
    L440:
        return null;
    L439:
        return null;
    L438:
        return null;
    L249:
        if (this.d == null) goto L448;
        Intrinsics.checkNotNullParameter(r17, "getStatusData");
        JsonObject r154 = r17.c;
        if (r154 == null) goto L451;
        ALogger.i("MultiLinkDynamicWidget", "get status getExtraInfo=" + r154 + ", type = " + r17.getType());
        int r155 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.j0.b[r17.getType().ordinal()];
        if (r155 == 1) goto L277;
        if (r155 != 2) goto L452;
        JsonObject r156 = new JsonObject();
        JsonObject r157 = new JsonObject();
        String r158 = r154.get("type").getAsString();
        if (r158 == null) goto L449;
        if (r158.hashCode() != (-1165274194)) goto L449;
        if (r158.equals("team_fight") == false) goto L449;
        com.bytedance.android.live.liveinteract.revenue.fight.c r159 = TeamFightContext.Companion.c();
        if (r159 == null) goto L268;
        xh0.g r160 = r159.rl();
    L269:
        if (r160 == null) goto L271;
        Boolean r161 = Boolean.valueOf(r160.c);
    L272:
        r157.addProperty("enable", r161);
        if (r160 == null) goto L275;
        r5 = r160.e;
    L275:
        r157.addProperty("toast", r5);
        r156.add("create_check", r157);
        goto L449
    L271:
        r161 = null;
        goto L272
    L268:
        r160 = null;
    L449:
        return r156;
    L452:
        return null;
    L277:
        com.bytedance.android.live.liveinteract.revenue.fight.b r162 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r162 != null) goto L280;
        return null;
    L280:
        return r162.e2(r154);
    L451:
        return null;
    L448:
        return null;
    L9:
        r6 = false;
        goto L10
    }

    @Override // ih0.b
    public final void Tl(ih0.c r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator r0 = ((LinkedHashMap) this.x).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (Intrinsics.areEqual((ih0.c) ((Map.Entry) r0.next()).getValue(), r3) == false) goto L6;
        r0.remove();
        goto L6
    }

    @Override // ih0.b
    public final vlc.l U6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "listenerId");
        WeakReference r3 = (WeakReference) ((LinkedHashMap) this.s).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (vlc.l) r3.get();
    }

    @Override // ih0.b
    public final void fa(ih0.c r2) {
        e0 r0 = this.u;
        if (r0 == null) goto L6;
        r0.p(r2);
        return;
    }

    @Override // ih0.b
    public final void jc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "bizId");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r1 = this.a;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "bizId");
        r1.e.remove(r3);
        return;
    }

    @Override // ih0.b
    public final boolean jl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "bizId");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r1 = this.a;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "bizId");
        e r4 = r1.d.get(r3);
        if (r4 == null) goto L7;
        return r4.a();
    L7:
        return false;
    }

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        BehaviorSubject<List<tf0.e>> r0 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_multi_lick_dynamic_widget_start") == false) goto L13;
        Boolean r2 = (Boolean) r12.getData();
        if (r2 == null) goto L13;
        e0 r3 = this.u;
        if (r3 == null) goto L13;
        r3.r(r2.booleanValue());
    L13:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r4 = this.b;
        if (r4 == null) goto L171;
        if (r12 == null) goto L17;
        String r5 = r12.getKey();
    L19:
        if (Intrinsics.areEqual(r5, "data_multi_link_dynamic_layout_info_change") == false) goto L31;
        nh0.f r6 = (nh0.f) r12.getData();
        if (r6 == null) goto L181;
        sf0.b r7 = r6.e;
        if (r7 == null) goto L30;
        int r8 = MultiSceneEnterRoomStatisticsUtils.u;
        long r9 = 0;
        MultiSceneEnterRoomStatisticsUtils r10 = MultiSceneEnterRoomStatisticsUtils.a.a(r4.c, 0L);
        if (r10 == null) goto L28;
        r9 = r10.c();
    L28:
        ALogger.e("audience_loading_detail", "发送布局引擎计算结果LayoutInfo给Lynx耗时 use: " + (System.currentTimeMillis() - r9));
        ih0.b r13 = r4.z;
        int r14 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        r13.Dk("root", "layout_info", com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r7), false);
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.linkbase.DynamicFrameInfo");
    L181:
        return;
    L31:
        if (r12 == null) goto L33;
        String r15 = r12.getKey();
    L35:
        if (Intrinsics.areEqual(r15, "data_multi_lick_dynamic_event_change") == false) goto L62;
        ALogger.e(r4.d, "call onChanged receive DATA_MULTI_LINK_DYNAMIC_EVENT_CHANGE");
        nh0.f r16 = (nh0.f) r12.getData();
        if (r16 != null) goto L40;
        return;
    L40:
        if (Intrinsics.areEqual(r16.a, "linkmic") == false) goto L61;
        int r17 = r4.m;
        nh0.e r18 = r16.b;
        if (r18 != null) goto L44;
    L48:
        String r19 = r4.d;
        StringBuilder r20 = new StringBuilder("updateDynamicEventChange uilayout change uiLayout=");
        nh0.e r21 = r16.b;
        if (r21 == null) goto L51;
        Integer r22 = Integer.valueOf(r21.b);
    L52:
        r20.append(r22);
        r20.append("; playmode=");
        nh0.e r23 = r16.b;
        if (r23 == null) goto L55;
        List<Integer> r24 = r23.c;
    L56:
        r20.append(r24);
        ALogger.i(r19, r20.toString());
        nh0.e r25 = r16.b;
        if (r25 == null) goto L59;
        int r26 = r25.b;
    L60:
        r4.o().wq(r16, false);
        r4.l(r26);
        r4.m = r26;
        goto L62
    L59:
        r26 = 0;
        goto L60
    L55:
        r24 = null;
        goto L56
    L51:
        r22 = null;
        goto L52
    L44:
        if (r17 != r18.b) goto L48;
        if (r18.e == (-1)) goto L48;
        ALogger.i(r4.d, "updateDynamicEventChange uilayout same return");
        return;
    L61:
        r4.o().wq(r16, false);
    L62:
        if (r12 == null) goto L64;
        String r27 = r12.getKey();
    L66:
        if (Intrinsics.areEqual(r27, "data_multi_link_dynamic_guest_list_change") == false) goto L73;
        ALogger.e(r4.d, "call onChanged receive DATA_MULTI_LINK_DYNAMIC_GUEST_LIST_CHANGE");
        nh0.f r28 = (nh0.f) r12.getData();
        if (r28 != null) goto L71;
        return;
    L71:
        if (Intrinsics.areEqual(r28.a, "guest_list") == false) goto L73;
        r4.o().wq(r28, false);
    L73:
        if (r12 == null) goto L75;
        String r29 = r12.getKey();
    L77:
        if (Intrinsics.areEqual(r29, "data_multi_lick_dynamic_widget_start") == false) goto L92;
        sh0.i0 r30 = sh0.j0.a;
        DataCenter r31 = r4.c;
        int r32 = sh0.h0.a;
        sh0.j0.f(r31, "is_mic_seat_fold", new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.b0(r4));
        if (r4.b().isLiveTypeAudio() == false) goto L92;
        Integer r33 = je0.d.h();
        if (r33 == null) goto L92;
        if (r33.intValue() != 29) goto L92;
        jk0.c r34 = RadioStageContext.Companion.a();
        if (r34 != null) goto L88;
    L90:
        boolean r35 = false;
    L91:
        ALogger.i("RadioStageContainerWidget", "[sendRadioStageStateToLynx] state:" + r35);
        JsonObject r36 = new JsonObject();
        r36.addProperty("state", Boolean.valueOf(r35));
        r4.z.Dk("gift_comment_wall", "radio_stage_state", r36, false);
        goto L92
    L88:
        if (r34.qi() != true) goto L90;
        r35 = true;
    L92:
        if (r12 == null) goto L94;
        String r37 = r12.getKey();
    L96:
        if (Intrinsics.areEqual(r37, "data_multi_link_data_merge_center_init") == false) goto L135;
        Boolean r38 = (Boolean) r12.getData();
        if (r38 != null) goto L101;
        r38 = Boolean.FALSE;
    L101:
        if (r38.booleanValue() == false) goto L135;
        hd0.c.f().c(r4.w);
        LinkUserDataMergeContext.a r39 = LinkUserDataMergeContext.Companion;
        if (r39 == null) goto L111;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r40 = LinkUserDataMergeContext.a.b(r39, r4.c);
        if (r40 == null) goto L111;
        BehaviorSubject<List<LinkmicPositionItem>> r41 = r40.g();
        if (r41 == null) goto L111;
        Disposable r42 = r41.subscribe(new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.u(r4));
        if (r42 == null) goto L111;
        RxUtilKt.c(r42, r4.a);
    L111:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r43 = LinkUserDataMergeContext.a.b(r39, r4.c);
        if (r43 == null) goto L121;
        BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> r44 = r43.p1();
        if (r44 == null) goto L121;
        Observable r45 = r44.compose(RxUtil.rxSchedulerHelper());
        if (r45 == null) goto L121;
        Disposable r46 = r45.subscribe(new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.t(r4));
        if (r46 == null) goto L121;
        RxUtilKt.c(r46, r4.a);
    L121:
        if ((r4.z instanceof LifecycleOwner) == false) goto L135;
        IInteractService r47 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r47 == null) goto L126;
        x00.a r48 = r47.getThemeManager(je0.d.D(), r4.c);
    L127:
        if (r48 == null) goto L135;
        LifecycleOwner r49 = r4.z;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.a0 r50 = r4.v;
        IRoom r51 = je0.d.e(null);
        if (r51 != null) goto L131;
    L133:
        int r52 = 3;
    L134:
        r48.j(r49, r50, r52);
        goto L135
    L131:
        if (r51.isLiveTypeAudio() != true) goto L133;
        r52 = 2;
        goto L134
    L126:
        r48 = null;
    L135:
        if (r12 == null) goto L137;
        String r53 = r12.getKey();
    L139:
        if (Intrinsics.areEqual(r53, "data_multi_link_window_list_helper_init") == false) goto L173;
        Integer r110 = (Integer) r12.getData();
        if (r110 != null) goto L143;
        r110 = -1;
    L143:
        int r111 = r110.intValue();
        if (r111 == (-1)) goto L174;
        r4.l(r111);
        r4.u.clear();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L150;
        int r112 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r113 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(r4.c);
        if (r113 == null) goto L159;
        r0 = r113.el();
    L159:
        if (((MultiLinkFirstFrameOptConfigV2) u2.a.getValue()).isEnableDynamicWidgetRegisterWindowListObserveOpt() == false) goto L164;
        if (r0 == null) goto L175;
        Disposable r114 = r0.subscribe(new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.x(r4));
        if (r114 == null) goto L176;
        RxUtilKt.c(r114, r4.u);
        return;
    L176:
        return;
    L175:
        return;
    L164:
        if (r0 == null) goto L178;
        Observable r115 = RxUtilKt.h(r0);
        if (r115 == null) goto L179;
        Disposable r116 = r115.subscribe(new com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.y(r4));
        if (r116 == null) goto L180;
        RxUtilKt.c(r116, r4.u);
        return;
    L180:
        return;
    L179:
        return;
    L178:
        return;
    L150:
        tf0.o r117 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.e();
        if ((r117 instanceof BaseMultiLinkWindowManager) == true) goto L153;
        r117 = null;
    L153:
        BaseMultiLinkWindowManager r118 = (BaseMultiLinkWindowManager) r117;
        if (r118 == null) goto L159;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r119 = r118.h;
        if (r119 == null) goto L159;
        r0 = r119.b;
        goto L159
    L174:
        return;
    L173:
        return;
    L137:
        r53 = null;
        goto L139
    L94:
        r37 = null;
        goto L96
    L75:
        r29 = null;
        goto L77
    L64:
        r27 = null;
        goto L66
    L33:
        r15 = null;
        goto L35
    L17:
        r5 = null;
        goto L19
    L171:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // ih0.b
    public final Object ql(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r1 = this.b;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "userId");
        HashMap<String, tf0.d> r0 = r1.e;
        if (r0 == null) goto L7;
        return r0.get(r3);
    L7:
        return null;
    }

    @Override // ih0.b
    public final void setDynamicAnimatorListener(Function0<Unit> r2) {
        AudioLayoutDynamicHandler r0 = this.e;
        if (r0 == null) goto L6;
        r0.e = r2;
        return;
    }

    public MultiLinkDynamicWidgetNew(ViewGroup r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "mLinkRootView");
        this.y = r2;
        this.z = r3;
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new LinkedHashMap();
        this.v = new CompositeDisposable();
        this.x = new LinkedHashMap();
    }

    @Override // ih0.b
    public final void E6(String r4, ih0.g r5) {
        Intrinsics.checkNotNullParameter(r4, "bizId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r2 = this.a;
        if (r2 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "bizId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        r2.e.put(r4, r5);
        return;
    }

    @Override // ih0.b
    public final void Gb(String r2, ih0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        if (((LinkedHashMap) this.x).values().contains(r3) == true) goto L6;
        this.x.put(r2, r3);
        return;
    }

    @Override // ih0.b
    public final void oe(String r3, vlc.l r4) {
        Intrinsics.checkNotNullParameter(r3, "listenerId");
        this.s.put(r3, new WeakReference(r4));
    }

    public final void wq(nh0.f r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "event");
        JsonObject r6 = r17.a();
        if (r6 != null) goto L113;
        return;
    L113:
        JsonObject r7 = new JsonObject();     // Catch: JSONException -> L110
        r7.add("data", r6);     // Catch: JSONException -> L110
        r7.addProperty("type", r17.a);     // Catch: JSONException -> L110
        int r8 = MultiSceneEnterRoomStatisticsUtils.u;     // Catch: JSONException -> L110
        MultiSceneEnterRoomStatisticsUtils r9 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, this.z);     // Catch: JSONException -> L110
        if (r9 == null) goto L8;
        long r10 = r9.c();     // Catch: JSONException -> L110
    L9:
        ALogger.e("audience_loading_detail", "发送uiLayout给Lynx 耗时 use: " + (System.currentTimeMillis() - r10));     // Catch: JSONException -> L110
        String r5 = r17.a;     // Catch: JSONException -> L110
        String r11 = null;
        tf0.m r12 = null;
        Boolean r13 = null;
        r13 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        switch(r5.hashCode()) {
            case -1753865563: goto L48;
            case 177093645: goto L43;
            case 853251499: goto L29;
            case 2011270307: goto L14;
            default: goto L82;
        };
    L82:
        e0 r2 = this.u;     // Catch: JSONException -> L110
        if (r2 == null) goto L85;
        r2.q(r7, r18);     // Catch: JSONException -> L110
    L85:
        Iterator r3 = ((LinkedHashMap) this.x).entrySet().iterator();     // Catch: JSONException -> L110
    L88:
        if (r3.hasNext() == false) goto L91;
        ((ih0.c) ((Map.Entry) r3.next()).getValue()).sendJsEvent("onLinkmicStatusChange", r7);     // Catch: JSONException -> L110
        goto L88
    L91:
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.a() == true) goto L106;
        DataCenter r4 = ((Widget) this).dataCenter;     // Catch: JSONException -> L110
        if (r4 == null) goto L96;
        IRoom r14 = com.bytedance.android.live.core.utils.a0.o(r4);     // Catch: JSONException -> L110
        if (r14 == null) goto L96;
    L98:
        if (r14.isLiveTypeAudio() == true) goto L100;
        return;
    L100:
        if (je0.d.h() == null) goto L106;
        Integer r15 = je0.d.h();     // Catch: JSONException -> L110
        if (r15 != null) goto L105;
        return;
    L105:
        if (r15.intValue() == 0) goto L106;
        return;
    L96:
        r14 = com.bytedance.android.live.core.utils.a0.a;     // Catch: JSONException -> L110
    L106:
        jk0.c r16 = RadioStageContext.Companion.a();     // Catch: JSONException -> L110
        if (r16 == null) goto L121;
        r16.A6(r17.a, r7);     // Catch: JSONException -> L110
        return;
    L121:
        return;
    L14:
        if (r5.equals("layout_info") == false) goto L82;
        MultiSceneEnterRoomStatisticsUtils r19 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, this.z);     // Catch: JSONException -> L110
        if (r19 == null) goto L18;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r19, "native_ready_send_layout_info", 0, 2, null);     // Catch: JSONException -> L110
    L18:
        tf0.m r20 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.b();     // Catch: JSONException -> L110
        if ((r20 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) == false) goto L22;
        r12 = r20;
    L22:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r21 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) r12;     // Catch: JSONException -> L110
        if (r21 == null) goto L25;
        r21.e = System.currentTimeMillis();     // Catch: JSONException -> L110
    L25:
        Lazy r22 = MultiLinkLoadWidgetUtils.a;     // Catch: JSONException -> L110
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiLinkDynamicWidgetNew#updateDynamicEventChange", "发送LayoutInfo " + r17.e);     // Catch: JSONException -> L110
        e0 r23 = this.u;     // Catch: JSONException -> L110
        if (r23 == null) goto L82;
        r23.t(r17, r7);     // Catch: JSONException -> L110
        goto L82
    L29:
        if (r5.equals("preload_enter_info") == false) goto L82;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L41;
        MiddlewareRoomContext r24 = o3.c(((Widget) this).dataCenter);     // Catch: JSONException -> L110
        if (r24 == null) goto L38;
        com.bytedance.live.datacontext.n r25 = r24.isRoomVisible();     // Catch: JSONException -> L110
        if (r25 == null) goto L38;
        r13 = (Boolean) r25.getValue();     // Catch: JSONException -> L110
    L38:
        if (Intrinsics.areEqual(r13, Boolean.FALSE) == false) goto L41;
        MultiLinkLoadWidgetUtils.m(((Widget) this).dataCenter, "MultiLinkDynamicWidgetNew#updateDynamicEventChange", "preload enter info event but room is not visible!");     // Catch: JSONException -> L110
        return;
    L41:
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiLinkDynamicWidgetNew#updateDynamicEventChange", "发送EnterInfo " + r17.f + '}');     // Catch: JSONException -> L110
        goto L82
    L43:
        if (r5.equals("linkmic") == false) goto L82;
        Lazy r26 = MultiLinkLoadWidgetUtils.a;     // Catch: JSONException -> L110
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, "MultiLinkDynamicWidgetNew#updateDynamicEventChange", "发送LinkmicInfo " + r17.b);     // Catch: JSONException -> L110
        e0 r27 = this.u;     // Catch: JSONException -> L110
        if (r27 == null) goto L82;
        r27.t(r17, r7);     // Catch: JSONException -> L110
        goto L82
    L48:
        if (r5.equals("guest_list") == false) goto L82;
        MultiSceneEnterRoomStatisticsUtils r110 = MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) this).dataCenter, this.z);     // Catch: JSONException -> L110
        if (r110 == null) goto L52;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r110, "native_ready_send_guest_list", 0, 2, null);     // Catch: JSONException -> L110
    L52:
        List<tf0.e> r28 = r17.d;     // Catch: JSONException -> L110
        if (r28 == null) goto L62;
        Iterator<T> r29 = r28.iterator();     // Catch: JSONException -> L110
    L56:
        if (r29.hasNext() == false) goto L60;
        Object r30 = r29.next();     // Catch: JSONException -> L110
        if ((((tf0.e) r30) instanceof MultiLinkGuestViewBinder.a) == false) goto L56;
    L61:
        tf0.e r31 = (tf0.e) r30;     // Catch: JSONException -> L110
    L64:
        if ((r31 instanceof MultiLinkGuestViewBinder.a) == true) goto L66;
        r31 = null;
    L66:
        MultiLinkGuestViewBinder.a r32 = (MultiLinkGuestViewBinder.a) r31;     // Catch: JSONException -> L110
        Lazy r33 = MultiLinkLoadWidgetUtils.a;     // Catch: JSONException -> L110
        DataCenter r34 = ((Widget) this).dataCenter;     // Catch: JSONException -> L110
        StringBuilder r35 = new StringBuilder();     // Catch: JSONException -> L110
        r35.append("发送GuestList ");     // Catch: JSONException -> L110
        List<tf0.e> r36 = r17.d;     // Catch: JSONException -> L110
        if (r36 == null) goto L69;
        Integer r37 = Integer.valueOf(r36.size());     // Catch: JSONException -> L110
    L70:
        r35.append(r37);     // Catch: JSONException -> L110
        r35.append(", guest=");     // Catch: JSONException -> L110
        if (r32 == null) goto L79;
        ch0.e r38 = r32.k;     // Catch: JSONException -> L110
        if (r38 == null) goto L79;
        ILinkPlayerInfoBridge r39 = r38.a;     // Catch: JSONException -> L110
        if (r39 == null) goto L79;
        IBaseUser r40 = r39.getUser();     // Catch: JSONException -> L110
        if (r40 == null) goto L79;
        r11 = r40.getNickName();     // Catch: JSONException -> L110
    L79:
        r35.append(r11);     // Catch: JSONException -> L110
        MultiLinkLoadWidgetUtils.p(r34, "MultiLinkDynamicWidgetNew#updateDynamicEventChange", r35.toString());     // Catch: JSONException -> L110
        e0 r41 = this.u;     // Catch: JSONException -> L110
        if (r41 == null) goto L82;
        r41.t(r17, r7);     // Catch: JSONException -> L110
        goto L82
    L69:
        r37 = null;
        goto L70
    L60:
        r30 = null;
        goto L61
    L62:
        r31 = null;
        goto L64
    L8:
        r10 = 0;
    L110:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // ih0.b
    public final void B1(ih0.f r19, ih0.h r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        JsonObject r5 = r19.d;
        if (r5 != null) goto L6;
        ALogger.e("MultiLinkDynamicWidget", "update status but updateExtraInfo is empty");
        ((com.bytedance.android.live.liveinteract.jsbridge.method.j) r20).a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L6:
        String r9 = r19.c;
        if (r9.length() != 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L13;
        ALogger.e("MultiLinkDynamicWidget", "update status but fromBizId is empty");
        ((com.bytedance.android.live.liveinteract.jsbridge.method.j) r20).a(UpdateLinkmicStatusResultModel.Code.Failed, "", null);
        return;
    L13:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L17;
        IRoom r12 = com.bytedance.android.live.core.utils.a0.o(r11);
        if (r12 == null) goto L17;
    L18:
        r12.isLiveTypeAudio();
        boolean r13 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.g(r9, r19.getType()) == true) goto L22;
        ALogger.e("MultiLinkDynamicWidget", "updateStatus type=" + r19.getType() + " fromBizId=" + r9 + " not support dynamic return");
        ((com.bytedance.android.live.liveinteract.jsbridge.method.j) r20).a(UpdateLinkmicStatusResultModel.Code.Failed, "", null);
        return;
    L22:
        ALogger.i("MultiLinkDynamicWidget", "update status type=" + r19.getType() + " updateExtraInfo=" + r5);
        switch(k.a[r19.getType().ordinal()]) {
            case 1: goto L486;
            case 2: goto L486;
            case 3: goto L486;
            case 4: goto L486;
            case 5: goto L486;
            case 6: goto L486;
            case 7: goto L486;
            case 8: goto L486;
            case 9: goto L486;
            case 10: goto L486;
            case 11: goto L486;
            case 12: goto L482;
            case 13: goto L482;
            case 14: goto L456;
            case 15: goto L453;
            case 16: goto L453;
            case 17: goto L453;
            case 18: goto L453;
            case 19: goto L453;
            case 20: goto L453;
            case 21: goto L453;
            case 22: goto L453;
            case 23: goto L453;
            case 24: goto L430;
            case 25: goto L430;
            case 26: goto L407;
            case 27: goto L302;
            case 28: goto L302;
            case 29: goto L255;
            case 30: goto L87;
            case 31: goto L59;
            case 32: goto L56;
            case 33: goto L56;
            case 34: goto L56;
            case 35: goto L56;
            case 36: goto L56;
            case 37: goto L56;
            case 38: goto L56;
            case 39: goto L56;
            case 40: goto L56;
            case 41: goto L56;
            case 42: goto L56;
            case 43: goto L56;
            case 44: goto L56;
            case 45: goto L56;
            case 46: goto L56;
            case 47: goto L56;
            case 48: goto L56;
            case 49: goto L56;
            case 50: goto L56;
            case 51: goto L53;
            case 52: goto L53;
            case 53: goto L51;
            case 54: goto L51;
            case 55: goto L46;
            case 56: goto L540;
            case 57: goto L30;
            case 58: goto L27;
            default: goto L24;
        };
    L24:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r3 = this.a;
        if (r3 == null) goto L538;
        r3.f(r9, r19.getType(), r19, ((Widget) this).dataCenter);
    L538:
        ((com.bytedance.android.live.liveinteract.jsbridge.method.j) r20).a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L27:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i0 r4 = this.i;
        if (r4 == null) goto L538;
        r4.b(r19.d);
        goto L538
    L30:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i0 r6 = this.i;
        if (r6 == null) goto L538;
        r6.a(r19.d);
        goto L538
    L46:
        if (r21 == true) goto L538;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.n r7 = this.n;
        if (r7 == null) goto L538;
        r7.f(r19, r20);
        goto L538
    L53:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.h0 r8 = this.m;
        if (r8 == null) goto L538;
        r8.f(r19, r20);
        goto L538
    L56:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.q r14 = this.c;
        if (r14 == null) goto L538;
        r14.f(r19, r20);
        goto L538
    L59:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.k r15 = this.h;
        if (r15 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        JsonObject r16 = r19.d;
        if (r16 == null) goto L538;
        int r17 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.j.a[r19.getType().ordinal()];
        if (r17 != 1) goto L67;
        GuestLinkContext r0 = GuestLinkContext.Companion.getContext();
        if (r0 == null) goto L81;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.revenue.guestlink.j> r1 = r0.getWidget();
        if (r1 == null) goto L81;
        com.bytedance.android.live.liveinteract.revenue.guestlink.j r2 = (com.bytedance.android.live.liveinteract.revenue.guestlink.j) r1.getValue();
    L82:
        if (r2 == null) goto L84;
        r2.Nk(r16);
    L84:
        boolean r18 = false;
    L85:
        if (r18 == true) goto L538;
        lh0.c.a.b(r15, r20);
    L81:
        r2 = null;
        goto L82
    L67:
        if (r17 != 2) goto L84;
        JsonObject r22 = r19.d;
        if (r22 == null) goto L74;
        JsonElement r23 = r22.get("name");
        if (r23 == null) goto L74;
        String r24 = r23.getAsString();
    L75:
        new com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.a().b(r19.a, r24, (com.bytedance.android.live.liveinteract.jsbridge.method.j) r20);
        r18 = true;
    L74:
        r24 = null;
        goto L75
    L87:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.e r25 = this.g;
        if (r25 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        JsonObject r26 = r19.d;
        if (r26 == null) goto L538;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.d.a[r19.getType().ordinal()] != 1) goto L254;
        String r27 = r26.get("type").getAsString();
        JsonObject r28 = r26.get("data").getAsJsonObject();
        if (r27 == null) goto L254;
        long r29 = 0;
        switch(r27.hashCode()) {
            case -2122110968: goto L232;
            case -1904063051: goto L219;
            case -1654836382: goto L205;
            case -1621905289: goto L186;
            case -1358175835: goto L159;
            case -1341184824: goto L146;
            case -819299731: goto L135;
            case -388282860: goto L129;
            case -50370345: goto L111;
            case 1432307344: goto L102;
            default: goto L254;
        };
    L102:
        if (r27.equals("switch_camera") == false) goto L254;
        HamletAvatarContext r30 = HamletAvatarContext.Companion.getContext();
        if (r30 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r31 = r30.getHamletAvatarService();
        if (r31 == null) goto L254;
        gd0.g r32 = (gd0.g) r31.getValue();
        if (r32 == null) goto L254;
        r32.switchCamera();
        goto L254
    L111:
        if (r27.equals("director_panel_opened") == false) goto L254;
        HamletAvatarContext.a r33 = HamletAvatarContext.Companion;
        HamletAvatarContext r34 = r33.getContext();
        if (r34 == null) goto L119;
        com.bytedance.live.datacontext.j<gd0.g> r35 = r34.getHamletAvatarService();
        if (r35 == null) goto L119;
        gd0.g r36 = (gd0.g) r35.getValue();
        if (r36 == null) goto L119;
        boolean r110 = r36.yd();
    L120:
        if (r110 == true) goto L254;
        HamletAvatarContext r37 = r33.getContext();
        if (r37 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r38 = r37.getHamletAvatarService();
        if (r38 == null) goto L254;
        gd0.g r39 = (gd0.g) r38.getValue();
        if (r39 == null) goto L254;
        r39.a7();
    L119:
        r110 = false;
        goto L120
    L129:
        if (r27.equals("start_playmode") == false) goto L254;
        HamletAvatarContext r40 = HamletAvatarContext.Companion.getContext();
        if (r40 == null) goto L133;
        r40.setPlayModeStartTs(System.currentTimeMillis());
    L133:
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarOpenStart);
        goto L254
    L135:
        if (r27.equals("save_start_info") == false) goto L254;
        if (r28 == null) goto L140;
        JsonElement r41 = r28.get("avatar_id");
        if (r41 == null) goto L140;
        r29 = r41.getAsLong();
    L140:
        HamletAvatarContext r42 = HamletAvatarContext.Companion.getContext();
        if (r42 == null) goto L254;
        com.bytedance.live.datacontext.n<Long> r43 = r42.getCurrentSelectAvatarID();
        if (r43 == null) goto L254;
        r43.setValue(Long.valueOf(r29));
        goto L254
    L146:
        if (r27.equals("change_avatar") == false) goto L254;
        if (r28 == null) goto L151;
        JsonElement r44 = r28.get("item_id");
        if (r44 == null) goto L151;
        r29 = r44.getAsLong();
    L151:
        HamletAvatarContext r45 = HamletAvatarContext.Companion.getContext();
        if (r45 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r46 = r45.getHamletAvatarService();
        if (r46 == null) goto L254;
        gd0.g r47 = (gd0.g) r46.getValue();
        if (r47 == null) goto L254;
        r47.uc(r29);
        goto L254
    L159:
        if (r27.equals("change_action") == false) goto L254;
        if (r28 == null) goto L164;
        JsonElement r48 = r28.get("item_id");
        if (r48 == null) goto L164;
        long r49 = r48.getAsLong();
    L165:
        if (r28 == null) goto L170;
        JsonElement r50 = r28.get("expression_type");
        if (r50 == null) goto L170;
        r29 = r50.getAsLong();
    L170:
        if (r29 <= r25.d) goto L178;
        HamletAvatarContext r51 = HamletAvatarContext.Companion.getContext();
        if (r51 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r52 = r51.getHamletAvatarService();
        if (r52 == null) goto L254;
        gd0.g r53 = (gd0.g) r52.getValue();
        if (r53 == null) goto L254;
        r53.Ph(r49);
        goto L254
    L178:
        HamletAvatarContext r54 = HamletAvatarContext.Companion.getContext();
        if (r54 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r55 = r54.getHamletAvatarService();
        if (r55 == null) goto L254;
        gd0.g r56 = (gd0.g) r55.getValue();
        if (r56 == null) goto L254;
        r56.E7(r49);
    L164:
        r49 = 0;
        goto L165
    L186:
        if (r27.equals("send_xplay_msg") == false) goto L254;
        Objects.toString(r28);
        if (r28 == null) goto L192;
        JsonElement r57 = r28.get("msg");
        if (r57 == null) goto L192;
        r57.getAsString();
    L192:
        if (r28 == null) goto L254;
        JsonElement r58 = r28.get("msg");
        if (r58 == null) goto L254;
        String r59 = r58.getAsString();
        if (r59 == null) goto L254;
        HamletAvatarContext r60 = HamletAvatarContext.Companion.getContext();
        if (r60 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r61 = r60.getHamletAvatarService();
        if (r61 == null) goto L254;
        gd0.g r62 = (gd0.g) r61.getValue();
        if (r62 == null) goto L254;
        r62.tg(r59);
        goto L254
    L205:
        if (r27.equals("change_half") == false) goto L254;
        if (r28 == null) goto L210;
        JsonElement r63 = r28.get("open");
        if (r63 == null) goto L210;
        boolean r111 = r63.getAsBoolean();
    L211:
        HamletAvatarContext r65 = HamletAvatarContext.Companion.getContext();
        if (r65 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r66 = r65.getHamletAvatarService();
        if (r66 == null) goto L254;
        gd0.g r67 = (gd0.g) r66.getValue();
        if (r67 == null) goto L254;
        r67.eh(r111);
    L210:
        r111 = false;
        goto L211
    L219:
        if (r27.equals("change_animation") == false) goto L254;
        if (r28 == null) goto L224;
        JsonElement r68 = r28.get("item_id");
        if (r68 == null) goto L224;
        r29 = r68.getAsLong();
    L224:
        HamletAvatarContext r69 = HamletAvatarContext.Companion.getContext();
        if (r69 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r70 = r69.getHamletAvatarService();
        if (r70 == null) goto L254;
        gd0.g r71 = (gd0.g) r70.getValue();
        if (r71 == null) goto L254;
        r71.Jf(r29);
        goto L254
    L232:
        if (r27.equals("update_avatar_ids") == false) goto L254;
        if (r28 == null) goto L239;
        JsonElement r72 = r28.get("avatar_ids");
        if (r72 == null) goto L239;
        JsonArray r73 = r72.getAsJsonArray();
        if (r73 == null) goto L239;
        List r74 = CollectionsKt.toList(r73);
    L240:
        if (r74 == null) goto L245;
        List r75 = r74;
        ArrayList r76 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r75, 10));
        Iterator r77 = r75.iterator();
    L243:
        if (r77.hasNext() == false) goto L246;
        r76.add(Long.valueOf(((JsonElement) r77.next()).getAsLong()));
    L246:
        if (r76 == null) goto L254;
        HamletAvatarContext r78 = HamletAvatarContext.Companion.getContext();
        if (r78 == null) goto L254;
        com.bytedance.live.datacontext.j<gd0.g> r79 = r78.getHamletAvatarService();
        if (r79 == null) goto L254;
        gd0.g r80 = (gd0.g) r79.getValue();
        if (r80 == null) goto L254;
        r80.Yc(r76);
        goto L254
    L245:
        r76 = null;
    L239:
        r74 = null;
    L254:
        r25.a(r20, null);
        goto L538
    L255:
        PerfStrategyDynamicHandler r81 = this.l;
        if (r81 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        if (r19.d == null) goto L538;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.d0.a[r19.getType().ordinal()] == 1) goto L544;
    L262:
        boolean r112 = false;
    L300:
        if (r112 == true) goto L538;
        r81.a(r20, null);
        goto L538
    L544:
        ALogger.i("MultiLinkDynamicWidget", "MultiLinkAtomicAbility handlePerfRegister=" + r19.d);     // Catch: Exception -> L297
        tf0.r r82 = (tf0.r) GsonHelper.getDefault().fromJson(r19.d, tf0.r.class);     // Catch: Exception -> L297
        if (Intrinsics.areEqual(r82.a(), "register") == false) goto L284;
        if (r2.a(r82.c()) == false) goto L262;
        IInteractService r83 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: Exception -> L297
        if (r83 == null) goto L262;
        com.bytedance.android.live.liveinteract.plantform.performance.a r84 = r83.getMultiLinkPerfAbilityManager(true);     // Catch: Exception -> L297
        if (r84 == null) goto L262;
        String r85 = r84.b(r82.c(), r81.d);     // Catch: Exception -> L297
        JsonObject r113 = new JsonObject();     // Catch: Exception -> L297
        r113.addProperty("call_id", r85);     // Catch: Exception -> L297
        Intrinsics.checkNotNullParameter(r20, "updateCallback");     // Catch: Exception -> L297
        lh0.c.a.a(r20, r113);     // Catch: Exception -> L297
        LinkedHashMap r86 = new LinkedHashMap();     // Catch: Exception -> L297
        String r87 = r82.c();     // Catch: Exception -> L297
        String r88 = r82.c();     // Catch: Exception -> L297
        Intrinsics.checkNotNullParameter(r88, "abilityKey");     // Catch: Exception -> L297
        Map<String, BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.performance.d0>> r89 = r84.a;     // Catch: Exception -> L297
        if (r89 == null) goto L281;
        BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.performance.d0> r90 = r89.get(r88);     // Catch: Exception -> L297
        if (r90 == null) goto L281;
        com.bytedance.android.live.liveinteract.plantform.performance.d0 r91 = (com.bytedance.android.live.liveinteract.plantform.performance.d0) r90.getValue();     // Catch: Exception -> L297
        if (r91 == null) goto L281;
        Map r92 = r91.b;     // Catch: Exception -> L297
        if (r92 == null) goto L281;
    L282:
        r86.put(r87, r92);     // Catch: Exception -> L297
        r81.f(GsonHelper.getDefault().toJsonTree(r86));     // Catch: Exception -> L297
        ALogger.i("MultiLinkDynamicWidget", "MultiLinkAtomicAbility register recentMap=" + r86 + " callId=" + r85);     // Catch: Exception -> L297
    L299:
        r112 = true;
    L281:
        r92 = new LinkedHashMap();     // Catch: Exception -> L297
        goto L282
    L284:
        if (Intrinsics.areEqual(r82.a(), "unregister") == false) goto L262;
        if (r2.a(r82.b()) == false) goto L262;
        if (r2.a(r82.c()) == false) goto L262;
        IInteractService r93 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: Exception -> L297
        if (r93 == null) goto L294;
        com.bytedance.android.live.liveinteract.plantform.performance.a r94 = r93.getMultiLinkPerfAbilityManager(false);     // Catch: Exception -> L297
        if (r94 == null) goto L294;
        Boolean r95 = Boolean.valueOf(r94.c(r82.c(), r82.b()));     // Catch: Exception -> L297
    L295:
        JsonObject r96 = new JsonObject();     // Catch: Exception -> L297
        r96.addProperty("call_id", r82.b());     // Catch: Exception -> L297
        Intrinsics.checkNotNullParameter(r20, "updateCallback");     // Catch: Exception -> L297
        lh0.c.a.a(r20, r96);     // Catch: Exception -> L297
        ALogger.i("MultiLinkDynamicWidget", "MultiLinkAtomicAbility unregister callId=" + r82.b() + " result=" + r95);     // Catch: Exception -> L297
    L294:
        r95 = null;
    L297:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "MultiLinkAtomicAbility handlePerfRegister gson failed!", e);
        r81.e(r20, "MultiLinkAtomicAbility handlePerfRegister gson failed!");
        goto L299
    L302:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.b r97 = this.k;
        if (r97 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        if (r19.d == null) goto L538;
        int r98 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.a.a[r19.getType().ordinal()];
        if (r98 != 1) goto L310;
        DataCenter r99 = r97.c;
        if (r99 == null) goto L406;
        IRoom r100 = com.bytedance.android.live.core.utils.a0.n(r99);
        if (r100 == null) goto L406;
        if (r100.isLiveTypeAudio() != true) goto L406;
        JsonObject r101 = r19.d;
        if (r101 == null) goto L344;
        JsonElement r102 = r101.get("type");
        if (r102 == null) goto L344;
        int r103 = r102.getAsInt();
    L346:
        if (r103 != AudioChatStageUpdateType.AUDIO_STAGE_UPDATE_SEAT_LOCATION.ordinal()) goto L374;
        boolean r104 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.f.a(r19.d);
        JsonObject r105 = r19.d;
        if (r105 == null) goto L352;
        JsonElement r106 = r105.get("item_id");
        if (r106 == null) goto L352;
        String r107 = r106.getAsString();
    L353:
        int r108 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        StringBuilder r109 = new StringBuilder("itemId=");
        r109.append(r107);
        r109.append(", oldShowOrderSingStage=");
        InteractiveSongContext.a r114 = InteractiveSongContext.Companion;
        InteractiveSongContext r115 = r114.getContext();
        if (r115 == null) goto L358;
        com.bytedance.live.datacontext.m<Boolean> r116 = r115.getShowOrderSingStage();
        if (r116 == null) goto L358;
        Boolean r117 = (Boolean) r116.getValue();
    L359:
        r109.append(r117);
        r109.append(", newShowOrderSingStage=");
        r109.append(r104);
        com.bytedance.android.live.liveinteract.voicechat.stage.a.e("audio_stage_update_seat_location_event", r109.toString());
        if (Intrinsics.areEqual(r107, StageItemId.ORDER_SING_STAGE.getValue()) == false) goto L406;
        InteractiveSongContext r118 = r114.getContext();
        if (r118 == null) goto L367;
        com.bytedance.live.datacontext.m<Boolean> r119 = r118.getShowOrderSingStage();
        if (r119 == null) goto L367;
        if (((Boolean) r119.getValue()).booleanValue() == r104) goto L406;
    L367:
        InteractiveSongContext r120 = r114.getContext();
        if (r120 == null) goto L372;
        com.bytedance.live.datacontext.m<Boolean> r121 = r120.getShowOrderSingStage();
        if (r121 == null) goto L372;
        r121.setValue(Boolean.valueOf(r104));
    L372:
        r97.c.put("data_order_sing_stage_is_inert", Boolean.valueOf(r104));
    L358:
        r117 = null;
    L352:
        r107 = null;
        goto L353
    L374:
        if (r103 != AudioChatStageUpdateType.STAGE_IS_INSERT.ordinal()) goto L406;
        JsonObject r122 = r19.d;
        if (r122 == null) goto L380;
        JsonElement r123 = r122.get("stage_is_insert");
        if (r123 == null) goto L380;
        boolean r124 = r123.getAsBoolean();
    L381:
        JsonObject r125 = r19.d;
        if (r125 == null) goto L386;
        JsonElement r126 = r125.get("item_id");
        if (r126 == null) goto L386;
        String r127 = r126.getAsString();
    L387:
        r97.c.put("data_audio_chat_stage_is_insert", Boolean.valueOf(r124));
        ALogger.i("MultiLinkDynamicWidget", "itemId=" + r127 + ", stageIsInsert=" + r124 + ", currentUiLayout=" + je0.d.h());
        if (Intrinsics.areEqual(r127, StageItemId.Enlarge_STAGE.getValue()) == false) goto L406;
        Integer r128 = je0.d.h();
        if (r128 == null) goto L406;
        if (r128.intValue() != 30) goto L406;
        if (r124 == false) goto L405;
        JsonObject r129 = r19.d;
        if (r129 == null) goto L406;
        JsonElement r130 = r129.get("extra");
        if (r130 == null) goto L406;
        JsonElement r131 = r130.getAsJsonObject().get("frame");
        if (r131 == null) goto L406;
        JsonObject r132 = r131.getAsJsonObject();
        if (r132 == null) goto L406;
        r97.c.put("data_enlarge_stage_bottom_pos", Integer.valueOf(s1.f(r132.get("y").getAsInt()) + s1.f(r132.get("h").getAsInt())));
        goto L406
    L405:
        r97.c.put("data_enlarge_stage_bottom_pos", 0);
    L386:
        r127 = null;
    L380:
        r124 = false;
    L344:
        r103 = AudioChatStageUpdateType.UNKNOWN.ordinal();
    L406:
        r97.a(r20, null);
        goto L538
    L310:
        if (r98 != 2) goto L406;
        JsonObject r133 = r19.d;
        if (r133 == null) goto L317;
        JsonElement r134 = r133.get("type");
        if (r134 == null) goto L317;
        int r135 = r134.getAsInt();
    L319:
        if (r135 != SubtitleUpdateType.OPEN_SUBTITLE_SETTING_PANEL.ordinal()) goto L406;
        if (com.bytedance.android.live.core.utils.a0.d(r97.c, false) == false) goto L406;
        JsonObject r136 = r19.d;
        if (r136 == null) goto L329;
        JsonElement r137 = r136.get("request_page");
        if (r137 == null) goto L329;
        String r138 = r137.getAsString();
        if (r138 == null) goto L329;
    L330:
        IAudioSubtitleContent r139 = (IAudioSubtitleContent) b6.p0.getValue();
        if (r139 == null) goto L406;
        ((IInteractService) jc1.k.n(IInteractService.class)).openLinkmicSubtitleSettingDialog(com.bytedance.android.live.core.utils.a.d(), r138, r139);
    L329:
        r138 = "";
    L317:
        r135 = SubtitleUpdateType.UNKNOWN.ordinal();
        goto L319
    L407:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.g r140 = this.j;
        if (r140 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        if (r19.d == null) goto L538;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.f.a[r19.getType().ordinal()] == 1) goto L542;
    L429:
        r140.a(r20, null);
        goto L538
    L542:
        ALogger.i("MultiLinkDynamicWidget", "BARRAGE_GAME " + r19.d);     // Catch: Exception -> L427
        LinkMicGameContext r141 = LinkMicGameContext.Companion.getContext();     // Catch: Exception -> L427
        if (r141 == null) goto L419;
        r141.setHasClickFoldButtonBySelf(true);     // Catch: Exception -> L427
    L419:
        tf0.c r142 = (tf0.c) new GsonBuilder().create().fromJson(r19.d, tf0.c.class);     // Catch: Exception -> L427
        sh0.i0 r143 = sh0.j0.e(r140.c);     // Catch: Exception -> L427
        if (r143 == null) goto L429;
        int r144 = sh0.h0.a;     // Catch: Exception -> L427
        long r145 = r142.a();     // Catch: Exception -> L427
        oi0.a.a.getClass();     // Catch: Exception -> L427
        if (r145 != 2) goto L424;
        boolean r146 = true;
    L425:
        r143.b("is_mic_seat_fold", Boolean.valueOf(r146));     // Catch: Exception -> L427
        goto L429
    L424:
        r146 = false;
    L427:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "dynamicHandleLoadDuration gson failed!", e);
        r140.e(r20, "dynamicHandleLoadDuration gson failed!");
        goto L429
    L430:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.k0 r147 = this.d;
        if (r147 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        JsonObject r148 = r19.d;
        if (r148 == null) goto L538;
        int r149 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.j0.a[r19.getType().ordinal()];
        if (r149 != 1) goto L438;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r150 = LinkRoomFightContext.Companion.a();
        if (r150 == null) goto L447;
        DynamicRoomBattleRandomMatchVM r151 = r150.S7();
    L448:
        if (r151 == null) goto L450;
        r151.handleLynxCmd(r148, r20);
    L450:
        boolean r152 = true;
    L451:
        if (r152 == true) goto L538;
        lh0.c.a.b(r147, r20);
        goto L538
    L447:
        r151 = null;
        goto L448
    L438:
        if (r149 != 2) goto L443;
        com.bytedance.android.live.liveinteract.revenue.fight.c r153 = TeamFightContext.Companion.c();
        if (r153 == null) goto L443;
        r153.d6(r148);
    L443:
        r152 = false;
        goto L451
    L453:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.v r154 = this.b;
        if (r154 == null) goto L538;
        r154.p(r19, r20);
        goto L538
    L456:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.f0 r155 = this.f;
        if (r155 == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.e0.a[r19.getType().ordinal()] != 1) goto L538;
        JsonObject r156 = r19.d;
        if (r156 == null) goto L538;
        JsonElement r157 = r156.get("frame");
        if ((r157 instanceof JsonObject) == true) goto L466;
        r157 = null;
    L466:
        JsonObject r158 = (JsonObject) r157;
        if (r158 == null) goto L538;
        float r159 = r158.get("y").getAsFloat();
        float r160 = r158.get("h").getAsFloat();
        if (r160 <= 0) goto L476;
        float r161 = UtilityKotlinExtentionsKt.h(r159 + r160);
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r162 = InteractionWidgetsPosContext.a.a();
        if (r162 == null) goto L475;
        com.bytedance.live.datacontext.m r163 = r162.getAudioTalkRadioPublicScreenTopMargin();
        if (r163 == null) goto L475;
        r163.setValue(Integer.valueOf((int) r161));
    L475:
        r155.c.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "PUBLIC_SCREEN_AVOID_FRAME start"));
        goto L538
    L476:
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r164 = InteractionWidgetsPosContext.a.a();
        if (r164 == null) goto L481;
        com.bytedance.live.datacontext.m r165 = r164.getAudioTalkRadioPublicScreenTopMargin();
        if (r165 == null) goto L481;
        r165.setValue(0);
    L481:
        r155.c.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "PUBLIC_SCREEN_AVOID_FRAME reset"));
        goto L538
    L482:
        AudioLayoutDynamicHandler r166 = this.e;
        if (r166 == null) goto L538;
        r166.f(r19, r20);
        goto L538
    L540:
        JsonObject r167 = r19.d;     // Catch: Exception -> L41
        if (r167 == null) goto L42;
        JsonElement r168 = r167.get("enable");     // Catch: Exception -> L41
        if (r168 == null) goto L42;
        if (r168.getAsBoolean() != true) goto L42;
        boolean r169 = true;
    L43:
        DataCenter r170 = ((Widget) this).dataCenter;
        if (r170 == null) goto L538;
        r170.put("data_rtc_network_status_report", Boolean.valueOf(r169));
    L42:
        r169 = false;
    L41:
        ALogger.e("MultiLinkDynamicWidget", "updateStatus type=" + r19.getType() + " fromBizId=" + r9 + " not support dynamic return");
        goto L42
    L51:
        if (this.o == null) goto L538;
        Intrinsics.checkNotNullParameter(r19, "updateStatus");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        goto L538
    L486:
        if (r19.getType() != DynamicUpdateType.SET_DATA) goto L535;
        JsonObject r171 = r19.d;
        if (r171 == null) goto L535;
        String r172 = r171.get("key").getAsString();
        JsonElement r173 = r171.get("data");
        if (Intrinsics.areEqual(r172, "dynamic_consumer") == false) goto L535;
        if (r173 == null) goto L495;
        String r174 = r173.getAsString();
        if (r174 == null) goto L495;
        List r175 = StringsKt.split$default(r174, new String[]{"|"}, false, 0, 6, null);
    L496:
        DataCenter r176 = ((Widget) this).dataCenter;
        if (r176 == null) goto L500;
        IRoom r177 = com.bytedance.android.live.core.utils.a0.o(r176);
        if (r177 == null) goto L500;
    L501:
        if (r177 == null) goto L503;
        String r178 = r177.getIdStr();
    L504:
        if (r175 == null) goto L506;
        String r179 = (String) ListProtector.get(r175, 0);
    L508:
        if (Intrinsics.areEqual(r178, r179) == false) goto L535;
        if (r175 == null) goto L511;
        String r180 = (String) ListProtector.get(r175, 1);
    L513:
        switch(r180.hashCode()) {
            case -2042297787: goto L531;
            case -635354867: goto L526;
            case 131822657: goto L521;
            case 2116434720: goto L516;
            default: goto L535;
        };
    L516:
        if (r180.equals("feed_root_widget") == false) goto L535;
        e0 r181 = this.u;
        if (r181 == null) goto L535;
        JSEventConsumer r182 = JSEventConsumer.FeedRootWidget;
        Intrinsics.checkNotNullParameter(r182, "consumer");
        r181.n = r182;
        goto L535
    L521:
        if (r180.equals("root_widget") == false) goto L535;
        e0 r183 = this.u;
        if (r183 == null) goto L535;
        JSEventConsumer r184 = JSEventConsumer.RootWidget;
        Intrinsics.checkNotNullParameter(r184, "consumer");
        r183.n = r184;
        goto L535
    L526:
        if (r180.equals("render_widget") == false) goto L535;
        e0 r185 = this.u;
        if (r185 == null) goto L535;
        JSEventConsumer r186 = JSEventConsumer.RenderWidget;
        Intrinsics.checkNotNullParameter(r186, "consumer");
        r185.n = r186;
        goto L535
    L531:
        if (r180.equals("logic_widget") == false) goto L535;
        e0 r187 = this.u;
        if (r187 == null) goto L535;
        JSEventConsumer r188 = JSEventConsumer.LogicWidget;
        Intrinsics.checkNotNullParameter(r188, "consumer");
        r187.n = r188;
        goto L535
    L511:
        r180 = null;
        goto L513
    L506:
        r179 = null;
        goto L508
    L503:
        r178 = null;
    L500:
        r177 = com.bytedance.android.live.core.utils.a0.a;
    L495:
        r175 = null;
    L535:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler.i r189 = this.a;
        if (r189 == null) goto L538;
        r189.g(r19, r20);
    L17:
        r12 = com.bytedance.android.live.core.utils.a0.a;
        goto L18
    L9:
        r10 = false;
        goto L10
    }

    @Override // ih0.b
    public final void Dk(String r11, String r12, JsonObject r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "bizId");
        Intrinsics.checkNotNullParameter(r12, "eventType");
        ALogger.i("MultiLinkDynamicWidget", "sendJSEvent, bidId: " + r11 + ", eventName: " + r12 + ", content: " + r13);
        if (r13 == null) goto L5;
        r13.addProperty("biz_id", r11);
    L5:
        wq(new nh0.f(r12, null, null, null, r13, null, false, 222), r14);
    }

    @Override // ih0.b
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c Bi(Context r9, Uri r10, b7.a r11, long r12, DataCenter r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "commonLifecycle");
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(r9, r10, r11, r12, r14, 32);
    }
}
