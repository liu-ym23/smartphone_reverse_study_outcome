package com.bytedance.android.live.room.discovery.drawer.template;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.moreliveentrance.DefaultTabPriority;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.setting.y3;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.t;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.view.LiveCircleView;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.room.discovery.drawer.RelationApi;
import com.bytedance.android.live.room.discovery.drawer.processor.LiveEntranceStatus;
import com.bytedance.android.live.room.discovery.drawer.processor.MARQUEE_TRIGGER_STYLE;
import com.bytedance.android.live.room.discovery.drawer.processor.MarqueeType;
import com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController;
import com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveMarqueeProcessorContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.config.ba0;
import com.bytedance.android.livesdk.config.ca0;
import com.bytedance.android.livesdk.config.da;
import com.bytedance.android.livesdk.config.gu0;
import com.bytedance.android.livesdk.config.hp;
import com.bytedance.android.livesdk.config.jj1;
import com.bytedance.android.livesdk.config.kp;
import com.bytedance.android.livesdk.config.m2;
import com.bytedance.android.livesdk.config.o2;
import com.bytedance.android.livesdk.config.o81;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.config.rv;
import com.bytedance.android.livesdk.config.z9;
import com.bytedance.android.livesdk.f8;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.performance.p;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.DrawerConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFeedData;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.eventbus.LogEvent;
import com.bytedance.android.livesdkapi.model.LiveVisionFrameDegradeConfig;
import com.bytedance.android.livesdkapi.model.ToolbarWatchLaterSettingConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import ls1.m;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeDrawer, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u0006:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/template/LiveDrawerEntranceCommonWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/livesdk/common/i;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerEntranceCommonWidget extends LiveRecyclableWidget implements Observer<KVData>, WeakHandler.IHandler, i, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public static final List<String> G = null;
    public static boolean H;
    public com.bytedance.android.live.room.discovery.drawer.template.b A;
    public final m B;
    public final g C;
    public final h D;
    public boolean E;
    public Disposable F;
    public Room a;
    public DrawerConfig b;
    public SimpleDraweeView c;
    public boolean d;
    public Disposable e;
    public TextView f;
    public View g;
    public View h;
    public SimpleDraweeView i;
    public LiveCircleView j;
    public View k;
    public com.bytedance.android.live.core.view.a l;
    public Disposable m;
    public boolean n;
    public boolean o;
    public long p;
    public final WeakHandler q;
    public MergeDrawerViewModel r;
    public Boolean s;
    public final Lazy t;
    public final o81 u;
    public MoreLiveEntranceMarqueeProcessorController v;
    public boolean w;
    public final int x;
    public boolean y;
    public ScheduledFuture<?> z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

        public b(LiveDrawerEntranceCommonWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            h1 r6 = (h1) r5;
            LiveDrawerEntranceCommonWidget r0 = this.a;
            Disposable r1 = r0.m;
            if (r1 == null) goto L6;
            r1.dispose();
        L6:
            if (r0.n == false) goto L21;
            int r7 = r6.a;
            if (5 != r7) goto L11;
        L18:
            r0.Iq(false);
            long r2 = ((Number) m2.a.getValue()).longValue() * ((long) WebcastRedirectException.UNKNOWN);
            com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.C2;
            com.bytedance.android.livesdk.sharedpref.f.d(r8, Long.valueOf(((Number) r8.getValue()).longValue() - r2));
            return;
        L11:
            if (17 == r7) goto L18;
            if (8 == r7) goto L18;
            if (78 == r7) goto L18;
            if (6 == r7) goto L18;
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerEntranceCommonWidget a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public c(LiveDrawerEntranceCommonWidget r1, String r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            LiveDrawerEntranceCommonWidget r13 = this.a;
            List<String> r0 = LiveDrawerEntranceCommonWidget.G;
            String r1 = "others";
            if (r13.Aq() == false) goto L52;
            ALogger.i("LiveDrawerEntrance", "moreLiveToLiveTab enable click");
            MoreLiveEntranceMarqueeProcessorController r14 = this.a.v;
            if (r14 == null) goto L7;
            r14.h(MarqueeType.CLICK);
        L7:
            TextView r15 = this.a.f;
            String r3 = "";
            if (r15 == null) goto L13;
            CharSequence r16 = r15.getText();
            if (r16 == null) goto L13;
            String r17 = r16.toString();
            if (r17 == null) goto L13;
        L14:
            com.bytedance.android.live.room.utils.a r5 = this.a.Bq();
            if (r5 == null) goto L37;
            LiveDrawerEntranceCommonWidget r4 = this.a;
            DataCenter r6 = ((Widget) r4).dataCenter;
            Activity r7 = ContextUtil.contextToActivity(r4.getContext());
            LiveDrawerEntranceCommonWidget r8 = this.a;
            Room r9 = r8.a;
            MoreLiveEntranceMarqueeProcessorController r10 = r8.v;
            if (r10 == null) goto L28;
            MoreLiveMarqueeProcessorContext r18 = r10.f;
            if (r18 == null) goto L28;
            Intrinsics.checkNotNullParameter(r18, "$this$tryGetWillTransferLiveEntranceInfo");
            if (r18.n != LiveEntranceStatus.DISPLAYING) goto L26;
            com.bytedance.android.live.base.model.moreliveentrance.b r19 = r18.m;
            if (r19 == null) goto L26;
        L31:
            if (this.a.y == false) goto L34;
            if (r19 == null) goto L34;
            r19.r(r17);
        L34:
            if (r19 == null) goto L36;
            Intrinsics.checkNotNullParameter(DefaultTabPriority.MORE_LIVE, "<set-?>");
        L36:
            Unit r20 = Unit.INSTANCE;
            r5.c(r6, r7, r9, r19, this.a.y);
        L26:
            if (r18.c == true) goto L28;
            com.bytedance.android.live.base.model.moreliveentrance.b r22 = new com.bytedance.android.live.base.model.moreliveentrance.b();
            r22.v();
            r22.w();
            r22.u();
        L29:
            r19 = r22;
        L28:
            r22 = null;
        L37:
            MoreLiveEntranceMarqueeProcessorController r23 = this.a.v;
            if (r23 == null) goto L43;
            MoreLiveMarqueeProcessorContext r24 = r23.f;
            if (r24 == null) goto L43;
            String r25 = r24.a;
            if (r25 == null) goto L43;
        L44:
            if (r23 == null) goto L51;
            MoreLiveMarqueeProcessorContext r26 = r23.f;
            if (r26 == null) goto L51;
            String r27 = r26.b;
            if (r27 == null) goto L51;
            r3 = r27;
        L51:
            LiveMultiTabFloatWindowStore r28 = LiveMultiTabFloatWindowStore.INSTANCE;
            r28.saveEnterFromMerge(r25);
            r28.saveEnterMethod(r3);
            r28.setEnable(this.a.u.a());
            r28.setTargetTabIdMap(this.a.u.b());
            r28.setTabChange(false);
            r28.setMoreLiveToLiveTab(true);
            com.bytedance.android.livesdk.log.g r29 = u.l();
            LinkedHashMap r30 = new LinkedHashMap();
            r30.put("tag_text", r17);
            Unit r110 = Unit.INSTANCE;
            r29.sendLog("livesdk_tablive_entrance_click", r30, new Object[]{x.class, Room.class});
        L99:
            LiveDrawerEntranceCommonWidget r111 = this.a;
            if (r111.n == false) goto L102;
            com.bytedance.android.livesdk.sharedpref.e r112 = com.bytedance.android.livesdk.sharedpref.b.C2;
            com.bytedance.android.livesdk.sharedpref.f.d(r112, Long.valueOf(((Number) r112.getValue()).longValue() - this.d));
        L111:
            IVSPlayerService r113 = k.f(IVSPlayerService.class);
            if (r113 == null) goto L116;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r114 = r113.provideVSPlayerViewControlService(((Widget) this.a).dataCenter);
            if (r114 == null) goto L116;
            r114.setVisibilityStatus(false);
        L116:
            this.a.Iq(true);
            TextView r115 = this.a.f;
            if (r115 == null) goto L120;
            r115.setAccessibilityDelegate(t.a);
            return;
        L120:
            return;
        L102:
            DrawerConfig r116 = r111.b;
            if (r116 == null) goto L110;
            DrawerConfig.SpecialDrawerConfig r117 = r116.getSpecialConfig();
            if (r117 == null) goto L110;
            String r118 = r117.getCurrentScene();
            if (r118 == null) goto L110;
            r1 = r118;
        L110:
            LiveDrawerEntranceCommonWidget.Fq("click", r1);
        L43:
            r25 = "";
        L13:
            r17 = "";
            goto L14
        L52:
            com.bytedance.android.livesdk.user.f r119 = k.n(IUserService.class).user();
            if (LiveDrawerEntranceCommonWidget.G.contains(this.b) == true) goto L55;
        L58:
            DrawerConfig r120 = this.a.b;
            if (r120 == null) goto L67;
            DrawerConfig.EntranceLayout r121 = r120.getEntranceLayout();
            if (r121 == null) goto L67;
            if (r121.getLayoutParams() != 3) goto L67;
            MergeDrawerViewModel r122 = this.a.r;
            if (r122 == null) goto L67;
            r122.setClick(true);
        L67:
            Bundle r123 = new Bundle();
            r123.putString("pull_type", "button");
            if (TextUtils.isEmpty(this.c) == true) goto L70;
        L72:
            boolean r32 = false;
        L73:
            r123.putBoolean("home_refresh", r32);
            r123.putBoolean("switch_follow", this.a.n);
            LiveDrawerEntranceCommonWidget r33 = this.a;
            if (r33.o == false) goto L97;
            DrawerConfig r34 = r33.b;
            if (r34 == null) goto L82;
            DrawerConfig.SpecialDrawerConfig r35 = r34.getSpecialConfig();
            if (r35 == null) goto L82;
            Integer r36 = r35.getDefaultLiveTab();
            if (r36 == null) goto L82;
            int r37 = r36.intValue();
        L83:
            r123.putLong("default_tab_type", r37);
            DrawerConfig r38 = this.a.b;
            if (r38 == null) goto L90;
            DrawerConfig.SpecialDrawerConfig r39 = r38.getSpecialConfig();
            if (r39 == null) goto L90;
            Integer r40 = r39.getInsertRoomReason();
            if (r40 == null) goto L90;
            r123.putInt("insert_room_reason", r40.intValue());
        L90:
            DrawerConfig r42 = this.a.b;
            if (r42 == null) goto L98;
            DrawerConfig.SpecialDrawerConfig r43 = r42.getSpecialConfig();
            if (r43 == null) goto L98;
            String r44 = r43.getCurrentScene();
            if (r44 == null) goto L98;
            r123.putString("cover_content_category", r44);
        L98:
            ((IRoomService) k.n(IRoomService.class)).openDrawer(ContextUtil.contextToActivity(this.a.getContext()), true, r123, ((Widget) this.a).dataCenter);
        L82:
            r37 = 1;
            goto L83
        L97:
            r123.putString("cover_content_category", "others");
            goto L98
        L70:
            if (TextUtils.equals(this.b, "homepage_fresh") == false) goto L72;
            r32 = true;
            goto L73
        L55:
            if (r119.isLogin() == true) goto L58;
            Context r2 = ((Widget) this.a).context;
            l.a r45 = new l.a();
            r45.a = CoreSettingUtil.getLoginPromptForFollow();
            r45.b = CoreSettingUtil.getLoginImageForFollow();
            r45.e = "live_detail";
            r45.d = "live";
            r45.c = 1;
            r119.login(r2, new l(r45)).subscribe(new com.bytedance.android.livesdk.user.h());
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

        public d(LiveDrawerEntranceCommonWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((IRoomService) k.n(IRoomService.class)).openDrawer(ContextUtil.contextToActivity(this.a.getContext()), true, new Bundle(), ((Widget) this.a).dataCenter);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements h80.a {
        public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

        public e(LiveDrawerEntranceCommonWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IRoom r4 = (IRoom) r3;
            if (r4 == null) goto L7;
            RoomExtra r5 = r4.getExtra();
            if (r5 == null) goto L7;
            Boolean r6 = Boolean.valueOf(r5.isGroupLiveScene());
        L8:
            LiveDrawerEntranceCommonWidget r0 = this.a;
            List<String> r1 = LiveDrawerEntranceCommonWidget.G;
            r0.yq(r6);
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class f extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ LiveDrawerEntranceCommonWidget c;

        public final void run() {
            LiveDrawerEntranceCommonWidget r0 = this.c;
            List<String> r1 = LiveDrawerEntranceCommonWidget.G;
            r0.getClass();
            ILiveExpOptService r2 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
            int r3 = 0;
            if (r2 == null) goto L9;
            l61.c r4 = r2.getSceneState(((Widget) r0).dataCenter, l61.d.a.c1.e);
            if (r4 == null) goto L9;
            if (r4.a() != true) goto L9;
            boolean r5 = true;
        L10:
            r0.E = r5;
            ILiveExpOptService r6 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
            String r7 = null;
            if (r6 == null) goto L13;
            Disposable r8 = r6.registerExpBizListener(l61.d.a.c1.e, new com.bytedance.android.live.room.discovery.drawer.template.c(r0));
        L14:
            r0.F = r8;
            if (r0.n == false) goto L28;
            if (r0.Cq() == false) goto L21;
            View r9 = r0.h;
            if (r9 == null) goto L24;
            r9.setVisibility(8);
        L24:
            r0.Lq(52.0f);
            com.bytedance.android.live.core.view.a r10 = r0.l;
            if (r10 == null) goto L231;
            r10.d();
        L231:
            if (r0.p > 0) goto L233;
            r0.Gq();
        L233:
            b(true);
            return;
        L21:
            View r12 = r0.h;
            if (r12 == null) goto L24;
            r12.setVisibility(0);
            goto L24
        L28:
            if (r0.w == false) goto L30;
            com.bytedance.android.live.room.discovery.drawer.processor.d.a("prepareViewOnLoad called.mShowingMarquee skip");
            goto L231
        L30:
            r0.Kq();
            ILiveService r13 = TTLiveService.getLiveService();
            String r14 = "";
            if (r13 == null) goto L36;
            ILiveOntologyInfoManager r15 = r13.getLiveOntologyRecord();
            if (r15 == null) goto L36;
            String r16 = r15.getTitle();
            if (r16 == null) goto L36;
        L38:
            if (TextUtils.isEmpty(r16) == true) goto L40;
            String r17 = "https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/webcast_native_resource_douyin/drawer/ttlive_drawer_entrance_fl_webp_anim.webp";
        L51:
            SimpleDraweeView r18 = r0.c;
            if (r18 == null) goto L54;
            ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        L55:
            if (r19 == null) goto L64;
            Float r110 = r0.wq();
            if (r110 == null) goto L59;
            int r111 = (int) UtilityKotlinExtentionsKt.h(r110.floatValue());
        L60:
            r19.height = r111;
            SimpleDraweeView r112 = r0.c;
            if (r112 == null) goto L64;
            r112.setLayoutParams(r19);
            goto L64
        L59:
            r111 = 0;
        L64:
            if (r0.Cq() == false) goto L71;
            SimpleDraweeView r113 = r0.c;
            if (r113 == null) goto L68;
            r113.setVisibility(8);
        L68:
            View r20 = r0.g;
            if (r20 == null) goto L77;
            r20.setPadding(s1.f(11.0f), 0, 0, 0);
        L77:
            AbstractDraweeController r22 = Fresco.newDraweeControllerBuilder().setUri(r17).setAutoPlayAnimations(false).build();
            SimpleDraweeView r23 = r0.c;
            if (r23 == null) goto L81;
            r23.setController(r22);
        L81:
            if (r0.c == null) goto L124;
            DrawerConfig r24 = r0.b;
            if (r24 == null) goto L90;
            DrawerConfig.EntranceIcon r25 = r24.getEntranceIcon();
            if (r25 == null) goto L90;
            if (r25.getAnimShowMethod() == 2) goto L124;
        L90:
            if (LiveDrawerEntranceCommonWidget.H == false) goto L124;
            DrawerConfig r26 = r0.b;
            if (r26 == null) goto L100;
            DrawerConfig.EntranceIcon r27 = r26.getEntranceIcon();
            if (r27 == null) goto L100;
            if (r27.getAnimShowMethod() == 0) goto L124;
        L100:
            if (r0.Cq() == true) goto L124;
            ILiveService r28 = TTLiveService.getLiveService();
            if (r28 == null) goto L108;
            ILiveOntologyInfoManager r29 = r28.getLiveOntologyRecord();
            if (r29 == null) goto L108;
            if (r29.getCreatedTimes() != 1) goto L108;
            boolean r30 = true;
        L109:
            if (r30 == false) goto L124;
            if (pg1.b.b == true) goto L124;
            if (r0.E == false) goto L116;
            SimpleAlogArgsBuilder r32 = new SimpleAlogArgsBuilder();
            r32.c("不展示更多直播入口动画");
            ExpOptLog.d(r32.b());
            goto L124
        L116:
            r22.addControllerListener(new com.bytedance.android.live.room.discovery.drawer.template.f(r0));
            r0.e = ((ObservableSubscribeProxy) Observable.just(r0).delay(30, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(r0.getLifecycle(), Lifecycle.Event.ON_DESTROY)))).subscribe(new com.bytedance.android.live.room.discovery.drawer.template.g(r0), RxUtil.getNoOpThrowable());
            DrawerConfig r33 = r0.b;
            if (r33 == null) goto L124;
            DrawerConfig.EntranceIcon r34 = r33.getEntranceIcon();
            if (r34 == null) goto L124;
            if (r34.getAnimShowMethod() != 1) goto L124;
            pg1.b.b = true;
        L108:
            r30 = false;
        L124:
            if (r0.Aq() == false) goto L126;
            ALogger.i("LiveDrawerEntrance", "moreLiveToLiveTab shouldShowFollowGuide disable");
        L142:
            boolean r35 = false;
        L143:
            if (r35 == false) goto L153;
            List r36 = pg1.b.a;
            Integer r37 = (Integer) rv.a.getValue();
            if (r37 != null) goto L148;
        L150:
            long r38 = pg1.b.a();
        L151:
            r0.p = r38;
            ((ObservableSubscribeProxy) ((RelationApi) com.bytedance.android.live.network.c.b().e(RelationApi.class)).getRelationShow().compose(RxUtil.rxSchedulerHelper()).as(r0.autoDispose())).subscribe(new com.bytedance.android.live.room.discovery.drawer.template.d(r0), new com.bytedance.android.live.room.discovery.drawer.template.e(r0));
            goto L231
        L148:
            if (r37.intValue() != 0) goto L150;
            r38 = 0;
            goto L151
        L153:
            if (r0.Aq() == false) goto L156;
            ALogger.i("LiveDrawerEntrance", "moreLiveToLiveTab shouldShowSpecialText disable");
        L188:
            boolean r39 = false;
        L190:
            if (r39 == false) goto L229;
            DrawerConfig r40 = r0.b;
            if (r40 == null) goto L231;
            DrawerConfig.SpecialDrawerConfig r42 = r40.getSpecialConfig();
            if (r42 == null) goto L231;
            DrawerConfig.FreqInfo r43 = r42.getFreqInfo();
            if (r43 == null) goto L231;
            int r44 = r43.getShowDuration();
            if (r44 <= 0) goto L231;
            DrawerConfig r114 = r0.b;
            if (r114 == null) goto L207;
            DrawerConfig.SpecialDrawerConfig r115 = r114.getSpecialConfig();
            if (r115 == null) goto L207;
            DrawerConfig.EntranceTitle r116 = r115.getTitle();
            if (r116 == null) goto L207;
            String r117 = r116.getText();
        L208:
            if (r117 == null) goto L211;
            r3 = r117.length();
        L211:
            if (r3 <= 4) goto L213;
            r0.Lq(52.0f);
        L213:
            UIUtils.setText(r0.f, r117);
            DrawerConfig r45 = r0.b;
            if (r45 == null) goto L220;
            DrawerConfig.SpecialDrawerConfig r46 = r45.getSpecialConfig();
            if (r46 == null) goto L220;
            DrawerConfig.FreqInfo r47 = r46.getFreqInfo();
            if (r47 == null) goto L220;
            r7 = r47.getFreqKey();
        L220:
            com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e(r7, 0L), Long.valueOf(SystemClock.elapsedRealtime()));
            r0.q.removeMessages(1);
            r0.q.sendEmptyMessageDelayed(1, ((long) r44) * 1000);
            r0.o = true;
            DrawerConfig r48 = r0.b;
            if (r48 == null) goto L228;
            DrawerConfig.SpecialDrawerConfig r49 = r48.getSpecialConfig();
            if (r49 == null) goto L228;
            String r50 = r49.getCurrentScene();
            if (r50 == null) goto L228;
            r14 = r50;
        L228:
            LiveDrawerEntranceCommonWidget.Fq("show", r14);
        L207:
            r117 = null;
            goto L208
        L229:
            LiveDrawerEntranceCommonWidget.Fq("show", "others");
            goto L231
        L156:
            if (((Boolean) ca0.a.getValue()).booleanValue() == false) goto L188;
            DrawerConfig r52 = r0.b;
            if (r52 == null) goto L188;
            DrawerConfig.SpecialDrawerConfig r53 = r52.getSpecialConfig();
            if (r53 == null) goto L188;
            DrawerConfig.EntranceTitle r54 = r53.getTitle();
            if (r54 == null) goto L188;
            String r55 = r54.getText();
            if (r55 == null) goto L188;
            DrawerConfig.FreqInfo r118 = r53.getFreqInfo();
            if (r118 == null) goto L188;
            String r119 = r118.getFreqKey();
            if (r119 == null) goto L188;
            DrawerConfig.FreqInfo r56 = r53.getFreqInfo();
            if (r56 == null) goto L188;
            int r57 = r56.getFreqInterval();
            if (r55.length() != 0) goto L176;
            boolean r58 = true;
        L177:
            if (r58 == true) goto L188;
            if (r119.length() != 0) goto L181;
            boolean r59 = true;
        L182:
            if (r59 == true) goto L188;
            if (r57 <= 0) goto L188;
            if ((SystemClock.elapsedRealtime() - ((Number) new com.bytedance.android.livesdk.sharedpref.e(r119, 0L).getValue()).longValue()) <= (r57 * WebcastRedirectException.UNKNOWN)) goto L188;
            r39 = true;
            goto L190
        L181:
            r59 = false;
            goto L182
        L176:
            r58 = false;
            goto L177
        L126:
            DrawerConfig r60 = r0.b;
            if (r60 == null) goto L142;
            DrawerConfig.AvatarArea r62 = r60.getAvatarArea();
            if (r62 == null) goto L142;
            if (r62.getCanShowFollow() != 1) goto L142;
            List r63 = pg1.b.a;
            Integer r64 = (Integer) rv.a.getValue();
            if (r64 != null) goto L136;
        L138:
            long r120 = pg1.b.a();
        L140:
            if (r120 <= 0) goto L142;
            r35 = true;
            goto L143
        L136:
            if (r64.intValue() != 0) goto L138;
            r120 = 0;
            goto L140
        L71:
            SimpleDraweeView r65 = r0.c;
            if (r65 == null) goto L74;
            r65.setVisibility(0);
        L74:
            View r66 = r0.g;
            if (r66 == null) goto L77;
            r66.setPadding(0, 0, 0, 0);
            goto L77
        L54:
            r19 = null;
            goto L55
        L40:
            DrawerConfig r67 = r0.b;
            if (r67 == null) goto L50;
            DrawerConfig.EntranceIcon r68 = r67.getEntranceIcon();
            if (r68 == null) goto L50;
            ImageModel r69 = r68.getImage();
            if (r69 == null) goto L50;
            List r70 = r69.mUrls;
            if (r70 == null) goto L50;
            r17 = (String) ListProtector.get(r70, 0);
            if (r17 != null) goto L51;
        L50:
            r17 = "";
        L36:
            r16 = "";
            goto L38
        L13:
            r8 = null;
        L9:
            r5 = false;
            goto L10
        }

        public f(LiveDrawerEntranceCommonWidget r1) {
            this.c = r1;
            super("live_drawer_entrance_load");
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

        public g(LiveDrawerEntranceCommonWidget r1) {
            this.a = r1;
        }

        public final void a() {
            LiveDrawerEntranceCommonWidget r0 = this.a;
            List<String> r1 = LiveDrawerEntranceCommonWidget.G;
            r0.getClass();
            Integer r2 = (Integer) o2.a.getValue();
            if (r2 != null) goto L6;
            return;
        L6:
            if (r2.intValue() != 2) goto L44;
            da r3 = da.a;
            if (((m) r3.getValue()).k() == true) goto L42;
            IAiService r4 = k.f(IAiService.class);
            if (r4 == null) goto L45;
            IFeatureService r5 = k.f(IFeatureService.class);
            if (r5 == null) goto L46;
            List r6 = r0.B.e();
            if (r6 == null) goto L21;
            int r7 = ((Number) r5.getFeatureManager().getFeature("live_watch_count", -1)).intValue();
            if (r6.isEmpty() == true) goto L21;
            if (r6.contains(Integer.valueOf(r7)) == true) goto L21;
            return;
        L21:
            if (r0.A != null) goto L23;
            r0.A = new com.bytedance.android.live.room.discovery.drawer.template.b(r5, r0, r4);
        L23:
            com.bytedance.android.live.room.discovery.drawer.template.b r8 = r0.A;
            if (r8 == null) goto L26;
            r5.getFeatureManager().e(r8, CollectionsKt.listOf("drawer_predict_value"));
        L26:
            JSONObject r9 = new JSONObject();
            r9.put("predict_action", 0);
            RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r10 == null) goto L33;
            com.bytedance.live.datacontext.m r12 = r10.getRoom();
            if (r12 == null) goto L33;
            Room r13 = (Room) r12.getValue();
            if (r13 == null) goto L33;
            long r14 = r13.getRoomId();
        L34:
            r9.put("room_id", r14);
            if (r0.B.g() == true) goto L37;
            return;
        L37:
            if (((Boolean) r5.getFeatureManager().getFeature("ai_engine_ready", Boolean.FALSE)).booleanValue() == false) goto L40;
            r4.triggerDrawerPredict(r9);
            return;
        L40:
            if (((m) r3.getValue()).j() == false) goto L49;
            r0.zq();
            return;
        L49:
            return;
        L33:
            r14 = -1;
            goto L34
        L46:
            return;
        L45:
            return;
        L42:
            r0.zq();
            return;
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

    public static final class h implements Runnable {
        public long a;
        public final long b;
        public final long c;
        public final /* synthetic */ LiveDrawerEntranceCommonWidget d;

        public final void a() {
            long r0 = System.currentTimeMillis();
            boolean r7 = false;
            if ((r0 - this.a) < Math.max(this.b, this.c)) goto L5;
            r7 = true;
        L5:
            if (r7 == false) goto L14;
            DataCenter r2 = ((Widget) this.d).dataCenter;
            if (r2 == null) goto L15;
            ALogger.d("LAI-Drawer", "will preload drawer");
            this.a = r0;
            Boolean r3 = Boolean.TRUE;
            r2.put("dta_smart_client_update_drawer_feed", r3);
            IFeatureService r4 = k.f(IFeatureService.class);
            if (r4 == null) goto L16;
            z90.a r5 = r4.getFeatureManager();
            if (r5 == null) goto L17;
            Integer r6 = Integer.valueOf(((Number) r5.getFeature("drawer_preload_count", 0)).intValue() + 1);
            FeatureType r8 = FeatureType.DYNAMIC;
            r5.i("drawer_preload_count", r6, r8);
            r5.i("drawer_preload_count_app", Integer.valueOf(((Number) r5.getFeature("drawer_preload_count_app", 0)).intValue() + 1), r8);
            r5.i("drawer_preload_time", Long.valueOf(r0), r8);
            r5.i("drawer_preload_time_app", Long.valueOf(r0), r8);
            r5.i("drawer_preload_already", r3, r8);
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
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

        public h(LiveDrawerEntranceCommonWidget r3) {
            this.d = r3;
            da r4 = da.a;
            this.b = ((m) r4.getValue()).h();
            this.c = ((m) r4.getValue()).b();
        }
    }

    public final com.bytedance.android.live.room.utils.a Bq() {
        return (com.bytedance.android.live.room.utils.a) this.t.getValue();
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final String getSpm() {
        return "a100.a100.a205";
    }

    public final String nc() {
        return "LiveDrawerEntranceCommonWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final int supportClearScene() {
        return 10;
    }

    static {
        G = CollectionsKt.listOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        H = true;
    }

    public final boolean Cq() {
        if (((Boolean) ba0.a.getValue()).booleanValue() == true) goto L30;
        int r0 = this.x;
        if (r0 != 1) goto L7;
    L10:
        DrawerConfig r1 = this.b;
        if (r1 == null) goto L16;
        DrawerConfig.EntranceLayout r2 = r1.getEntranceLayout();
        if (r2 == null) goto L16;
        if (r2.getLayoutParams() != 1) goto L16;
    L24:
        boolean r3 = true;
    L26:
        if (r3 == false) goto L31;
    L28:
        return false;
    L31:
        return true;
    L16:
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L25;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L25;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L25;
        if (r6.isMediaRoom() == true) goto L24;
    L25:
        r3 = false;
        goto L26
    L7:
        if (r0 != 2) goto L28;
        if (this.n == true) goto L28;
    L30:
        return true;
    }

    public final boolean Eq() {
        DrawerConfig r0 = this.b;
        if (r0 == null) goto L11;
        DrawerConfig.EntranceLayout r1 = r0.getEntranceLayout();
        if (r1 == null) goto L11;
        if (r1.getLayoutParams() != 1) goto L11;
        return e5.n();
    L11:
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L15;
        return false;
    L15:
        return e5.n();
    }

    public final void Gq() {
        HashMap r0 = new HashMap();
        if (this.n == false) goto L5;
        String r1 = "follow";
    L12:
        r0.put("status", r1);
        ILiveService r2 = TTLiveService.getLiveService();
        String r3 = "";
        if (r2 == null) goto L18;
        ILiveOntologyInfoManager r4 = r2.getLiveOntologyRecord();
        if (r4 == null) goto L18;
        String r5 = r4.getEnterFromMerge();
        if (r5 == null) goto L18;
    L19:
        r0.put("drawer_page", r5);
        u.l().sendLog("livesdk_more_anchor_popup", r0, new Object[]{new x(), Room.class});
        this.p = 0;
        HashMap r6 = new HashMap();
        if (e5.n() == false) goto L22;
        String r7 = "landscape";
    L23:
        r6.put("screen_direction", r7);
        r6.put("user_id", k.n(IUserService.class).user().n());
        ILiveService r8 = TTLiveService.getLiveService();
        if (r8 == null) goto L31;
        ILiveOntologyInfoManager r9 = r8.getLiveOntologyRecord();
        if (r9 == null) goto L31;
        String r10 = r9.getEnterFromMerge();
        if (r10 == null) goto L31;
        r3 = r10;
    L31:
        r6.put("drawer_page", r3);
        u.l().sendLog("livesdk_drawer_entrance_show", r6, new Object[]{x.class, Room.class});
        return;
    L22:
        r7 = "portrait";
    L18:
        r5 = "";
        goto L19
    L5:
        DrawerConfig r12 = this.b;
        if (r12 == null) goto L11;
        DrawerConfig.EntranceTitle r13 = r12.getEntranceTitle();
        if (r13 == null) goto L11;
        r1 = r13.getText();
        if (r1 != null) goto L12;
    L11:
        r1 = DataType.Normal;
        goto L12
    }

    public final int getLayoutId() {
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L5;
        return 2131565269;
    L5:
        return 2131565268;
    }

    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver(this);
        com.bytedance.android.live.core.view.a r0 = this.l;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (this.n == true) goto L8;
        Iq(false);
    L8:
        this.s = Boolean.FALSE;
        ScheduledFuture<?> r1 = this.z;
        if (r1 == null) goto L11;
        r1.cancel(true);
        this.z = null;
    L11:
        com.bytedance.android.live.room.discovery.drawer.template.b r2 = this.A;
        if (r2 == null) goto L19;
        IFeatureService r3 = k.f(IFeatureService.class);
        if (r3 == null) goto L18;
        z90.a r4 = r3.getFeatureManager();
        if (r4 == null) goto L18;
        r4.h(r2);
    L18:
        this.A = null;
    L19:
        MoreLiveEntranceMarqueeProcessorController r5 = this.v;
        if (r5 == null) goto L28;
        Job r6 = r5.b;
        if (r6 == null) goto L24;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L24:
        r5.e.removeCallbacksAndMessages(null);
        Iterator r7 = ((ArrayList) r5.d).iterator();
    L26:
        if (r7.hasNext() == false) goto L28;
        ((com.bytedance.android.live.room.discovery.drawer.behavior.a) r7.next()).a();
    L28:
        i0.c().removeCallbacks(this.C);
        IFeatureService r8 = k.f(IFeatureService.class);
        if (r8 == null) goto L33;
        z90.a r9 = r8.getFeatureManager();
        if (r9 == null) goto L33;
        r9.i("drawer_preload_already", Boolean.FALSE, FeatureType.DYNAMIC);
    L33:
        Disposable r10 = this.F;
        if (r10 == null) goto L38;
        r10.dispose();
        return;
    }

    public final Animator startShowAnimation() {
        if (this.E == false) goto L7;
        return null;
    L7:
        if (Eq() == false) goto L13;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        r0.setTranslationX(0.0f);
    L12:
        return super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.startShowAnimation();
    L13:
        float r4 = 120;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(((Widget) this).contentView, "translationX", new float[]{UtilityKotlinExtentionsKt.h(r4), UtilityKotlinExtentionsKt.h(r4)}).setDuration(500);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(((Widget) this).contentView, "translationX", new float[]{UtilityKotlinExtentionsKt.h(r4), 0.0f}).setDuration(300);
        AnimatorSet r3 = new AnimatorSet();
        r3.playSequentially(new Animator[]{r1, r2});
        r3.start();
        return r3;
    }

    public final Float wq() {
        DrawerConfig r0 = this.b;
        if (r0 == null) goto L9;
        DrawerConfig.EntranceIcon r1 = r0.getEntranceIcon();
        if (r1 == null) goto L9;
        String r2 = r1.getHeight();
        if (r2 == null) goto L9;
        return Float.valueOf(CastFloatProtector.parseFloat(r2));
    L9:
        return null;
    }

    public final void zq() {
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 == null) goto L7;
        LiveData r1 = IStrategyService.a.a(r0, "drawer_preload", Boolean.FALSE, false, 12);
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L12;
        HashMap r3 = new HashMap();
        r3.put("predict_action", "strategy");
        Jq(null, r3);
        u.l().sendLog("livesdk_liveai_drawer_predict", r3, new Object[0]);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public LiveDrawerEntranceCommonWidget() {
        this.q = new WeakHandler(this);
        this.s = Boolean.FALSE;
        this.t = LazyKt.lazy(LiveDrawerEntranceCommonWidget$liveMultiTabHandler$2.INSTANCE);
        this.u = (o81) gu0.a.getValue();
        this.x = ((LiveVisionFrameDegradeConfig) f8.a.getValue()).getSecondLineStyle();
        this.B = (m) da.a.getValue();
        this.C = new g(this);
        this.D = new h(this);
        ILiveExpOptService r0 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r0 == null) goto L9;
        l61.c r1 = r0.getSceneState(((Widget) this).dataCenter, l61.d.a.c1.e);
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.a() != true) goto L9;
    L10:
        this.E = r2;
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final boolean Aq() {
        com.bytedance.android.live.room.utils.a r0 = Bq();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.b(RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2)) != true) goto L11;
        Room r1 = this.a;
        if (r1 == null) goto L11;
        if (r1.withAggregateColumn == true) goto L11;
        return true;
    }

    public final void Kq() {
        if (Aq() == false) goto L10;
        ALogger.i("LiveDrawerEntrance", "moreLiveToLiveTab setText call");
        com.bytedance.android.live.room.utils.a r0 = Bq();
        if (r0 == null) goto L8;
        String r1 = r0.getMoreEntranceTitle();
        if (r1 == null) goto L8;
    L9:
        UIUtils.setText(this.f, r1);
        return;
    L8:
        r1 = "更多直播";
        goto L9
    L10:
        DrawerConfig r2 = this.b;
        if (r2 == null) goto L15;
        DrawerConfig.EntranceTitle r3 = r2.getEntranceTitle();
        if (r3 == null) goto L15;
        String r4 = r3.getText();
    L16:
        if (r4 == null) goto L18;
        int r5 = r4.length();
    L20:
        if (r5 <= 4) goto L22;
        Lq(52.0f);
    L22:
        UIUtils.setText(this.f, r4);
        return;
    L18:
        r5 = 0;
    L15:
        r4 = null;
        goto L16
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    public final Boolean uk() {
        return this.s;
    }

    public final void Iq(boolean r8) {
        this.n = false;
        this.w = false;
        this.y = false;
        this.o = false;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L5;
        r1.put("data_more_entrance_follow", false);
    L5:
        Disposable r2 = this.e;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        TextView r3 = this.f;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
    L11:
        TextView r4 = this.f;
        if (r4 == null) goto L14;
        r4.setAlpha(1.0f);
    L14:
        TextView r5 = this.f;
        if (r5 == null) goto L17;
        r5.setEllipsize(null);
    L17:
        TextView r6 = this.f;
        if (r6 == null) goto L21;
        r6.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(4)});
    L21:
        if (Cq() == false) goto L28;
        SimpleDraweeView r7 = this.c;
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        View r9 = this.g;
        if (r9 == null) goto L34;
        r9.setPadding(s1.f(11.0f), 0, 0, 0);
    L34:
        SimpleDraweeView r0 = this.c;
        if (r0 == null) goto L37;
        r0.setAlpha(1.0f);
    L37:
        DrawerConfig r10 = this.b;
        if (r10 == null) goto L43;
        DrawerConfig.EntranceIcon r12 = r10.getEntranceIcon();
        if (r12 == null) goto L43;
        if (r12.getAnimStopMethod() != 1) goto L43;
    L44:
        SimpleDraweeView r13 = this.c;
        if (r13 == null) goto L51;
        DraweeController r14 = r13.getController();
        if (r14 == null) goto L51;
        Animatable r15 = r14.getAnimatable();
        if (r15 == null) goto L51;
        r15.stop();
    L51:
        this.d = true;
        View r16 = this.h;
        if (r16 == null) goto L54;
        r16.setVisibility(8);
    L54:
        com.bytedance.android.live.core.view.a r17 = this.l;
        if (r17 == null) goto L57;
        r17.a();
    L57:
        Kq();
        return;
    L43:
        if (r8 == false) goto L51;
    L28:
        SimpleDraweeView r18 = this.c;
        if (r18 == null) goto L31;
        r18.setVisibility(0);
    L31:
        View r19 = this.g;
        if (r19 == null) goto L34;
        r19.setPadding(0, 0, 0, 0);
        goto L34
    }

    public final void Lq(float r3) {
        TextView r0 = this.f;
        if (r0 == null) goto L5;
        r0.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L5:
        TextView r1 = this.f;
        if (r1 == null) goto L8;
        r1.setMarqueeRepeatLimit(-1);
    L8:
        TextView r2 = this.f;
        if (r2 == null) goto L11;
        r2.setFilters(new InputFilter[0]);
    L11:
        TextView r4 = this.f;
        if (r4 == null) goto L14;
        r4.setMaxWidth(s1.f(r3));
    L14:
        TextView r5 = this.f;
        if (r5 == null) goto L18;
        r5.requestFocusFromTouch();
        return;
    }

    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L5;
        boolean r4 = z.m(r3, true);
    L7:
        return !r4;
    L5:
        r4 = true;
        goto L7
    }

    public final void handleMsg(Message r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (1 != r2.what) goto L8;
        Iq(false);
        return;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (isViewValid() == false) goto L152;
        if (r10 == null) goto L153;
        Object r0 = r10.getData();
        FragmentActivity r2 = null;
        if ((r0 instanceof Object) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L175;
        int r3 = 0;
        if (Intrinsics.areEqual("DATA_DRAWER_LAYOUT_IS_OPEN", r10.getKey()) == false) goto L19;
        Boolean r12 = (Boolean) r10.getData();
        if (r12 == null) goto L15;
        boolean r13 = r12.booleanValue();
    L16:
        if (r13 == false) goto L154;
        Iq(false);
        return;
    L154:
        return;
    L15:
        r13 = false;
        goto L16
    L19:
        if (Intrinsics.areEqual("data_keyboard_status_douyin", r10.getKey()) == false) goto L30;
        Boolean r14 = (Boolean) r10.getData();
        if (r14 == null) goto L23;
        boolean r15 = r14.booleanValue();
    L24:
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L156;
        if (r15 == false) goto L28;
        r3 = 8;
    L28:
        r1.setVisibility(r3);
        return;
    L156:
        return;
    L23:
        r15 = false;
        goto L24
    L30:
        if (Intrinsics.areEqual("dta_smart_client_update_drawer_feed", r10.getKey()) == false) goto L73;
        Boolean r16 = (Boolean) r10.getData();
        if (r16 == null) goto L34;
        boolean r17 = r16.booleanValue();
    L36:
        if (((Boolean) ((Widget) this).dataCenter.get("DATA_DRAWER_LAYOUT_IS_OPEN", Boolean.FALSE)).booleanValue() == false) goto L39;
        return;
    L39:
        if (Aq() == false) goto L45;
        com.bytedance.android.live.room.utils.a r4 = Bq();
        if (r4 == null) goto L45;
        if (r4.interceptLeftSlideOpenDrawer() != true) goto L45;
        r3 = 1;
    L45:
        if (r3 == 0) goto L47;
        ALogger.e("LiveDrawerEntrance", "interceptLeftSlideOpenDrawer intercept preOpen");
        return;
    L47:
        if (r17 == false) goto L159;
        IRoomService r18 = (IRoomService) k.f(IRoomService.class);
        if (r18 == null) goto L52;
        r18.setLiveRoomDetail(((Widget) this).dataCenter);
    L52:
        if (((Boolean) kp.a.getValue()).booleanValue() == true) goto L65;
        Integer r19 = (Integer) hp.a.getValue();
        if (r19 != null) goto L57;
    L58:
        DrawerConfig r20 = this.b;
        if (r20 == null) goto L65;
        DrawerConfig.EntranceLayout r22 = r20.getEntranceLayout();
        if (r22 == null) goto L65;
        if (r22.getLayoutParams() != 2) goto L65;
        Bundle r23 = new Bundle();
        r23.putString("pull_type", "button");
        r23.putBoolean("switch_follow", this.n);
        ((IRoomService) k.n(IRoomService.class)).preOpenLynxDrawer(ContextUtil.contextToActivity(getContext()), true, r23, ((Widget) this).dataCenter);
        return;
    L57:
        if (r19.intValue() != 0) goto L58;
    L65:
        FragmentActivity r24 = ContextUtil.contextToActivity(getContext());
        if ((r24 instanceof FragmentActivity) == false) goto L69;
        r2 = r24;
    L69:
        FragmentActivity r5 = r2;
        if (r5 == null) goto L161;
        k.n(IHostFeed.class).preloadDrawerFeed(r5, LiveDrawerHelper.e());
        return;
    L161:
        return;
    L159:
        return;
    L34:
        r17 = false;
        goto L36
    L73:
        if (Intrinsics.areEqual("cmd_widget_loaded", r10.getKey()) == false) goto L126;
        if (Aq() == false) goto L81;
        com.bytedance.android.live.room.utils.a r25 = Bq();
        if (r25 == null) goto L81;
        if (r25.interceptLeftSlideOpenDrawer() != true) goto L81;
        r3 = 1;
    L81:
        if (r3 == 0) goto L84;
        ALogger.e("LiveDrawerEntrance", "interceptLeftSlideOpenDrawer intercept predict");
        return;
    L84:
        if (((Boolean) kp.a.getValue()).booleanValue() == true) goto L114;
        Integer r26 = (Integer) hp.a.getValue();
        if (r26 == null) goto L91;
        if (r26.intValue() == 0) goto L114;
    L91:
        if (this.B.g() == false) goto L93;
    L94:
        DrawerConfig r27 = this.b;
        if (r27 == null) goto L114;
        DrawerConfig.EntranceLayout r28 = r27.getEntranceLayout();
        if (r28 == null) goto L114;
        if (r28.getLayoutParams() != 2) goto L114;
        TextView r29 = this.f;
        if (r29 == null) goto L103;
        CharSequence r30 = r29.getText();
    L105:
        if (Intrinsics.areEqual(r30, pg1.a.a(1)) == true) goto L113;
        TextView r32 = this.f;
        if (r32 == null) goto L110;
        r2 = r32.getText();
    L110:
        if (Intrinsics.areEqual(r2, pg1.a.a(2)) == true) goto L113;
        if (this.n == false) goto L114;
    L113:
        i0.c().postDelayed(this.C, this.B.f());
        return;
    L103:
        r30 = null;
        goto L105
    L93:
        if (this.B.i() == true) goto L94;
    L114:
        TextView r33 = this.f;
        if (r33 != null) goto L117;
        return;
    L117:
        if (Intrinsics.areEqual(r33.getText(), pg1.a.a(1)) == true) goto L121;
        if (this.B.a() == true) goto L121;
        return;
    L121:
        if (this.B.g() == false) goto L123;
    L124:
        i0.c().postDelayed(this.C, this.B.f());
        return;
    L123:
        if (this.B.i() == true) goto L124;
        return;
    L126:
        if (Intrinsics.areEqual("data_media_introduction_showing", r10.getKey()) == false) goto L140;
        Boolean r6 = Boolean.FALSE;
        Boolean r34 = (Boolean) r10.getData(r6);
        if (r34 == null) goto L132;
        r6 = r34;
    L132:
        if (r6.booleanValue() == false) goto L136;
        View r35 = ((Widget) this).contentView;
        if (r35 == null) goto L169;
        r35.setImportantForAccessibility(4);
        return;
    L169:
        return;
    L136:
        View r36 = ((Widget) this).contentView;
        if (r36 == null) goto L171;
        r36.setImportantForAccessibility(0);
        return;
    L171:
        return;
    L140:
        if (Intrinsics.areEqual("action_click_panel_watch_later", r10.getKey()) == false) goto L173;
        String r7 = "直播广场";
        String r37 = (String) r10.getData("直播广场");
        if (r37 == null) goto L146;
        r7 = r37;
    L146:
        if (r7.length() <= 4) goto L174;
        this.y = true;
        Lq(52.0f);
        TextView r38 = this.f;
        if (r38 == null) goto L150;
        r38.setText(r7);
    L150:
        this.q.removeMessages(1);
        this.q.sendEmptyMessageDelayed(1, ((long) ((ToolbarWatchLaterSettingConfig) z9.a.getValue()).getMarqueeTime()) * ((long) WebcastRedirectException.UNKNOWN));
        return;
    L174:
        return;
    L173:
        return;
    L175:
        return;
    L153:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (PadConfigUtils.c() == false) goto L11;
        if (r2 == null) goto L8;
        boolean r0 = true;
        if (r2.orientation != 1) goto L8;
    L9:
        xq(r0);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void onEnterClear(int r3) {
        if (r3 != 8) goto L8;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r0);
    L8:
        if (p.b() == true) goto L10;
        return;
    L10:
        View r1 = ((Widget) this).contentView;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r3 == 2) goto L15;
        return;
    L15:
        if (2 == r1.getLayerType()) goto L20;
        ((Widget) this).contentView.setLayerType(2, null);
        ALogger.i("ttlive_widget", "NewLiveDrawerEntranceWidget Set LAYER_TYPE_HARDWARE");
        return;
    }

    public final void onExitClear(int r3) {
        if (r3 != 8) goto L8;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r0);
    L8:
        if (p.b() == true) goto L10;
        return;
    L10:
        View r1 = ((Widget) this).contentView;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r3 == 2) goto L15;
        return;
    L15:
        if (2 != r1.getLayerType()) goto L20;
        ((Widget) this).contentView.setLayerType(0, null);
        ALogger.i("ttlive_widget", "NewLiveDrawerEntranceWidget Set LAYER_TYPE_NONE");
        return;
    }

    public final void onInit(Object[] r12) {
        View r13 = ((Widget) this).contentView;
        View r0 = null;
        if (r13 == null) goto L5;
        SimpleDraweeView r14 = (SimpleDraweeView) r13.findViewById(2131371698);
    L6:
        this.c = r14;
        View r15 = ((Widget) this).contentView;
        if (r15 == null) goto L9;
        TextView r16 = (TextView) r15.findViewById(2131371712);
    L10:
        this.f = r16;
        View r17 = ((Widget) this).contentView;
        if (r17 == null) goto L13;
        View r18 = r17.findViewById(2131371708);
    L14:
        this.g = r18;
        View r19 = ((Widget) this).contentView;
        if (r19 == null) goto L17;
        View r110 = r19.findViewById(2131363643);
    L18:
        this.h = r110;
        View r111 = ((Widget) this).contentView;
        if (r111 == null) goto L21;
        SimpleDraweeView r112 = (SimpleDraweeView) r111.findViewById(2131376019);
    L22:
        this.i = r112;
        View r113 = ((Widget) this).contentView;
        if (r113 == null) goto L25;
        LiveCircleView r114 = (LiveCircleView) r113.findViewById(2131376101);
    L26:
        this.j = r114;
        ViewGroup r115 = ((Widget) this).containerView;
        if (r115 == null) goto L29;
        r0 = r115.findViewById(2131371699);
    L29:
        this.k = r0;
        if (PadConfigUtils.c() == false) goto L34;
        View r116 = this.k;
        if (r116 == null) goto L34;
        a1.n(r116, s1.j(2131168967));
    L34:
        com.bytedance.android.live.core.view.a r117 = new com.bytedance.android.live.core.view.a(this.i, this.j);
        this.l = r117;
        boolean r1 = this.E;
        r117.j = r1;
        if (r1 == true) goto L37;
    L39:
        com.bytedance.android.live.core.view.a r118 = this.l;
        if (r118 == null) goto L45;
        r118.d.removeOnAttachStateChangeListener(r118.k);
        r118.d.addOnAttachStateChangeListener(r118.k);
        if (r118.c == false) goto L44;
        r118.c(0);
        r118.d();
        goto L45
    L44:
        r118.a();
        r118.c(8);
    L45:
        DrawerConfig r119 = this.b;
        if (r119 == null) goto L52;
        DrawerConfig.AvatarArea r120 = r119.getAvatarArea();
        if (r120 == null) goto L52;
        if (r120.getCanShowFollow() != 1) goto L52;
        this.m = xs2.b.a().b(h1.class).subscribe(new b(this));
    L52:
        long r8 = ((Number) m2.a.getValue()).longValue() * ((long) WebcastRedirectException.UNKNOWN);
        ILiveService r121 = TTLiveService.getLiveService();
        if (r121 == null) goto L60;
        ILiveOntologyInfoManager r122 = r121.getLiveOntologyRecord();
        if (r122 == null) goto L60;
        String r123 = r122.getReqFrom();
        if (r123 == null) goto L60;
        String r6 = r123;
    L61:
        ILiveService r124 = TTLiveService.getLiveService();
        if (r124 == null) goto L69;
        ILiveOntologyInfoManager r125 = r124.getLiveOntologyRecord();
        if (r125 == null) goto L69;
        String r126 = r125.getTitle();
        if (r126 == null) goto L69;
        String r7 = r126;
    L70:
        ((Widget) this).contentView.setOnClickListener(new c(this, r6, r7, r8));
        return;
    L69:
        r7 = "";
    L60:
        r6 = "";
        goto L61
    L37:
        if (r117.b == false) goto L39;
        r117.a();
        goto L39
    L25:
        r114 = null;
        goto L26
    L21:
        r112 = null;
        goto L22
    L17:
        r110 = null;
        goto L18
    L13:
        r18 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    public final void onLoad(Object[] r13) {
        Boolean r1 = null;
        Room r14 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        this.a = r14;
        if (r14 == null) goto L7;
        RoomFeedData r15 = r14.roomFeedData;
        if (r15 == null) goto L7;
        DrawerConfig r16 = r15.getDrawerConfig();
    L8:
        this.b = r16;
        ((Widget) this).dataCenter.observe("DATA_DRAWER_LAYOUT_IS_OPEN", this).observeForever("data_keyboard_status_douyin", this).observe("dta_smart_client_update_drawer_feed", this).observe("cmd_widget_loaded", this).observe("data_media_introduction_showing", this).observe("action_click_panel_watch_later", this);
        boolean r17 = false;
        this.w = false;
        Room r0 = this.a;
        if (r0 == null) goto L37;
        if (r0.withAggregateColumn != true) goto L37;
        DrawerConfig r2 = this.b;
        if (r2 == null) goto L37;
        DrawerConfig.EntranceLayout r4 = r2.getEntranceLayout();
        if (r4 == null) goto L17;
        r4.setLayoutParams(3);
    L17:
        DrawerConfig.EntranceTitle r5 = r2.getEntranceTitle();
        if (r5 == null) goto L27;
        Room r6 = this.a;
        if (r6 == null) goto L25;
        VerticalTypeInfo r7 = r6.mVerticalTypeInfo;
        if (r7 == null) goto L25;
        String r8 = r7.name;
        if (r8 == null) goto L25;
    L26:
        r5.setText(r8);
    L25:
        r8 = "更多直播";
    L27:
        DrawerConfig.EntranceIcon r3 = r2.getEntranceIcon();
        if (r3 == null) goto L30;
        r3.setAnimShowMethod(0);
    L30:
        if (r3 == null) goto L34;
        ImageModel r9 = r3.getImage();
        if (r9 == null) goto L34;
        r9.mUrls = CollectionsKt.listOf(i2.d("asset://com.ss.android.ies.live.sdk/merge_vertical_icon.png").toString());
    L34:
        if (r3 == null) goto L37;
        r3.setHeight("20");
    L37:
        if (this.n == false) goto L39;
        String r10 = "follow";
    L46:
        xs2.b.a().post(new LogEvent("button", r10));
        final f r12 = new f(this);
        RoomContext.a r18 = RoomContext.Companion;
        RoomContext r19 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        if (r19 == null) goto L51;
        j r20 = r19.getWidgetLoadTaskScheduler();
        if (r20 == null) goto L51;
        r20.c(new AnonymousClass2(this, r12));
    L51:
        xq(!Eq());
        Activity r22 = ContextUtil.contextToActivity(getContext());
        if ((r22 instanceof FragmentActivity) == true) goto L54;
        r22 = null;
    L54:
        FragmentActivity r23 = (FragmentActivity) r22;
        if (r23 == null) goto L57;
        MergeDrawerViewModel r24 = (MergeDrawerViewModel) ViewModelProviders.of(r23).get(MergeDrawerViewModel.class);
    L58:
        this.r = r24;
        if (r24 != null) goto L61;
    L73:
        RoomContext r25 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        if (r25 == null) goto L83;
        com.bytedance.live.datacontext.m r26 = r25.getOpenDrawerWhenRoomOpen();
        if (r26 == null) goto L83;
        ALogger.i("DrawerEntrance", "openDrawerWhenRoomOpen: " + ((Boolean) r26.getValue()).booleanValue());
        if (((Boolean) r26.getValue()).booleanValue() == true) goto L80;
    L82:
        r26.setValue(Boolean.FALSE);
        goto L83
    L80:
        if (((jj1) oj1.a.getValue()).j() == false) goto L82;
        i0.c().postDelayed(new d(this), 500);
    L83:
        com.bytedance.android.live.room.utils.a r27 = Bq();
        if (r27 != null) goto L86;
    L90:
        boolean r28 = false;
    L91:
        if (r28 == false) goto L107;
        RoomContext r29 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        MoreLiveEntranceMarqueeProcessorController r30 = this.v;
        if (r30 != null) goto L95;
        this.v = new MoreLiveEntranceMarqueeProcessorController(new MoreLiveMarqueeProcessorContext(r29, ((Widget) this).dataCenter));
    L96:
        MoreLiveEntranceMarqueeProcessorController r32 = this.v;
        if (r32 == null) goto L99;
        r32.f(new LiveDrawerEntranceCommonWidget$ensureMoreEntranceMarqueeChainRecently$1(this), new LiveDrawerEntranceCommonWidget$ensureMoreEntranceMarqueeChainRecently$2(this));
    L99:
        MoreLiveEntranceMarqueeProcessorController r33 = this.v;
        if (r33 == null) goto L102;
        r33.i();
    L102:
        StringBuilder r34 = new StringBuilder("ensureMoreEntranceMarqueeChainRecently controller: ");
        MoreLiveEntranceMarqueeProcessorController r35 = this.v;
        if (r35 == null) goto L105;
        Integer r36 = Integer.valueOf(r35.hashCode());
    L106:
        r34.append(r36);
        com.bytedance.android.live.room.discovery.drawer.processor.d.a(r34.toString());
    L108:
        com.bytedance.android.live.room.utils.a r37 = Bq();
        if (r37 != null) goto L111;
    L115:
        boolean r38 = false;
    L116:
        if (r38 == false) goto L127;
        com.bytedance.android.live.room.utils.a r39 = Bq();
        if (r39 != null) goto L120;
    L122:
        if (r17 == true) goto L127;
        MoreLiveEntranceMarqueeProcessorController r110 = this.v;
        if (r110 == null) goto L127;
        r110.a(MARQUEE_TRIGGER_STYLE.OLD_TRIGGER_STYLE, new LinkedHashMap());
        goto L127
    L120:
        if (r39.useNewShowStrategy() != true) goto L122;
        r17 = true;
    L127:
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L145;
        RoomContext r111 = RoomContext.a.c(r18, null, 0, 3);
        if (r111 != null) goto L131;
        return;
    L131:
        if (r111.isPrivateRoom() != true) goto L147;
        RoomContext r112 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        if (r112 == null) goto L141;
        com.bytedance.live.datacontext.m r113 = r112.getRoom();
        if (r113 == null) goto L141;
        Room r114 = (Room) r113.getValue();
        if (r114 == null) goto L141;
        RoomExtra r115 = r114.getExtra();
        if (r115 == null) goto L141;
        r1 = Boolean.valueOf(r115.isGroupLiveScene());
    L141:
        if (r1 != null) goto L143;
        MiddlewareRoomContext r116 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        ToolbarLoadTimeStatsVM.a r40 = ToolbarLoadTimeStatsVM.Companion;
        AutoDisposeConverter r42 = autoDispose();
        e r43 = new e(this);
        r40.getClass();
        ToolbarLoadTimeStatsVM.a.a(r42, r116, r43);
        return;
    L143:
        yq(r1);
        return;
    L147:
        return;
    L145:
        return;
    L111:
        if (r37.enableMoreEntranceMarqueeType() != true) goto L115;
        if (Aq() == false) goto L115;
        r38 = true;
        goto L116
    L105:
        r36 = null;
        goto L106
    L95:
        r30.l(r29, ((Widget) this).dataCenter);
        goto L96
    L107:
        com.bytedance.android.live.room.discovery.drawer.processor.d.a("ensureMoreEntranceMarqueeChainRecently close, will use onLine");
        goto L108
    L86:
        if (r27.enableMoreEntranceMarqueeType() != true) goto L90;
        if (Aq() == false) goto L90;
        r28 = true;
        goto L91
    L61:
        if (r24.getMergeDrawFeed() != true) goto L73;
        if (r24.getCanAutoOpenMergeDrawer() != true) goto L73;
        if (r24.isDialogOpen() == true) goto L73;
        DrawerConfig r44 = this.b;
        if (r44 == null) goto L73;
        DrawerConfig.EntranceLayout r45 = r44.getEntranceLayout();
        if (r45 == null) goto L73;
        if (r45.getLayoutParams() != 3) goto L73;
        ((Widget) this).contentView.callOnClick();
        r24.setCanAutoOpenMergeDrawer(false);
        goto L73
    L57:
        r24 = null;
        goto L58
    L39:
        DrawerConfig r46 = this.b;
        if (r46 == null) goto L45;
        DrawerConfig.EntranceTitle r47 = r46.getEntranceTitle();
        if (r47 == null) goto L45;
        r10 = r47.getText();
        if (r10 != null) goto L46;
    L45:
        r10 = DataType.Normal;
    L7:
        r16 = null;
        goto L8
    }

    public final void qo(Boolean r1) {
        this.s = r1;
    }

    public final void xq(boolean r8) {
        ViewGroup.LayoutParams r2 = null;
        if (r8 == false) goto L43;
        DrawerConfig r9 = this.b;
        if (r9 == null) goto L107;
        DrawerConfig.EntranceLayout r10 = r9.getEntranceLayout();
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.getLayoutParams() != 1) goto L112;
        View r12 = this.g;
        if (r12 == null) goto L14;
        r12.setBackground(s1.m(2131248768));
    L14:
        SimpleDraweeView r13 = this.c;
        if (r13 == null) goto L17;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L18:
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        Float r1 = wq();
        if (r1 == null) goto L29;
        float r3 = r1.floatValue();
        if (r15 == null) goto L23;
        r15.height = (int) UtilityKotlinExtentionsKt.h(r3);
    L23:
        if (r15 == null) goto L25;
        r15.width = (int) UtilityKotlinExtentionsKt.h(r3);
    L25:
        if (r15 == null) goto L27;
        r15.leftMargin = s1.f(4.0f);
    L27:
        if (r15 == null) goto L29;
        r15.rightMargin = s1.f(2.0f);
    L29:
        SimpleDraweeView r0 = this.c;
        if (r0 == null) goto L32;
        r0.setLayoutParams(r15);
    L32:
        View r16 = this.k;
        if (r16 == null) goto L35;
        r2 = r16.getLayoutParams();
    L35:
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r2;
        if (r4 == null) goto L38;
        r4.leftMargin = s1.f(1.0f);
    L38:
        if (r4 == null) goto L40;
        r4.rightMargin = s1.f(12.0f);
    L40:
        View r17 = this.k;
        if (r17 == null) goto L109;
        r17.setLayoutParams(r4);
        return;
    L109:
        return;
    L17:
        r14 = null;
        goto L18
    L112:
        return;
    L107:
        return;
    L43:
        View r18 = this.g;
        if (r18 == null) goto L46;
        r18.setBackground(s1.m(2131248771));
    L46:
        SimpleDraweeView r19 = this.c;
        if (r19 == null) goto L49;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L50:
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r20;
        View r5 = this.k;
        if (r5 == null) goto L53;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L54:
        LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r6;
        DrawerConfig r23 = this.b;
        if (r23 == null) goto L80;
        DrawerConfig.EntranceLayout r24 = r23.getEntranceLayout();
        if (r24 == null) goto L80;
        if (r24.getLayoutParams() != 1) goto L80;
        View r25 = this.g;
        int r26 = s1.f(24.0f);
        if (r25 == null) goto L63;
        r2 = r25.getLayoutParams();
    L63:
        if (r2 == null) goto L65;
        r2.width = -2;
    L65:
        if (r2 == null) goto L67;
        r2.height = r26;
    L67:
        if (r25 == null) goto L69;
        r25.setLayoutParams(r2);
    L69:
        Float r27 = wq();
        if (r27 == null) goto L96;
        float r28 = r27.floatValue();
        if (r22 == null) goto L74;
        r22.height = (int) UtilityKotlinExtentionsKt.h(r28);
    L74:
        if (r22 == null) goto L76;
        r22.width = (int) UtilityKotlinExtentionsKt.h(r28);
    L76:
        if (r22 == null) goto L78;
        r22.leftMargin = s1.f(8.0f);
    L78:
        if (r22 == null) goto L96;
        r22.rightMargin = s1.f(3.0f);
    L96:
        if (r7 == null) goto L98;
        r7.leftMargin = s1.f(4.0f);
    L98:
        if (r7 == null) goto L100;
        r7.rightMargin = s1.f(8.0f);
    L100:
        SimpleDraweeView r29 = this.c;
        if (r29 == null) goto L103;
        r29.setLayoutParams(r22);
    L103:
        View r30 = this.k;
        if (r30 == null) goto L111;
        r30.setLayoutParams(r7);
        return;
    L111:
        return;
    L80:
        View r32 = this.g;
        int r33 = s1.f(20.0f);
        if (r32 == null) goto L83;
        r2 = r32.getLayoutParams();
    L83:
        if (r2 == null) goto L85;
        r2.width = -2;
    L85:
        if (r2 == null) goto L87;
        r2.height = r33;
    L87:
        if (r32 == null) goto L89;
        r32.setLayoutParams(r2);
    L89:
        Float r34 = wq();
        if (r34 == null) goto L96;
        float r35 = r34.floatValue();
        if (r22 == null) goto L94;
        r22.height = (int) UtilityKotlinExtentionsKt.h(r35);
    L94:
        if (r22 == null) goto L96;
        r22.width = s1.f(25.0f);
        goto L96
    L53:
        r6 = null;
        goto L54
    L49:
        r20 = null;
        goto L50
    }

    public final void yq(Boolean r2) {
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L16;
        eu2.a r3 = ((Widget) this).contentView;
        if (r3 != null) goto L7;
        return;
    L7:
        if ((r3 instanceof eu2.a) == false) goto L18;
        r3.T3(new d80.c());
        View r4 = ((Widget) this).contentView;
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.getVisibility() != 0) goto L20;
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L21;
        r5.setVisibility(4);
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    }

    public static void Fq(String r3, String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("event_type", r3);
        r0.put("content_category", r4);
        u.l().sendLog("livesdk_more_link", r0, new Object[]{Room.class});
    }

    public final void Jq(ArrayList<Float> r4, Map<String, String> r5) {
        ScheduledFuture<?> r0 = this.z;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        if (r4 != null) goto L7;
    L13:
        this.z = TTExecutors.getScheduledThreadPool().schedule(this.D, 0, TimeUnit.SECONDS);
        return;
    L7:
        if (r4.isEmpty() == true) goto L13;
        Iterator<Float> r1 = r4.iterator();
        float r2 = 0.0f;
    L10:
        if (r1.hasNext() == false) goto L12;
        r2 = r2 + r1.next().floatValue();
        goto L10
    L12:
        long r3 = ((Long) Float.valueOf(r2 / r4.size())).longValue();
        ((HashMap) r5).put("range_sec", String.valueOf(r4));
        this.z = TTExecutors.getScheduledThreadPool().schedule(this.D, r3, TimeUnit.SECONDS);
    }
}
