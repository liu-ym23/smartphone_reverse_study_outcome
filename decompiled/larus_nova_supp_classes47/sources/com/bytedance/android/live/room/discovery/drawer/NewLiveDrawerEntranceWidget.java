package com.bytedance.android.live.room.discovery.drawer;

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
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.t;
import com.bytedance.android.live.core.view.LiveCircleView;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livesdk.chatroom.MatchWidgetDurationMetric;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.ba0;
import com.bytedance.android.livesdk.config.da;
import com.bytedance.android.livesdk.config.jj1;
import com.bytedance.android.livesdk.config.m2;
import com.bytedance.android.livesdk.config.o2;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.config.q2;
import com.bytedance.android.livesdk.config.rv;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.hg;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.performance.p;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchDrawer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import com.bytedance.android.livesdkapi.drawer.UpdateDrawerEntranceEvent;
import com.bytedance.android.livesdkapi.eventbus.LogEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ls1.m;
import nm1.r;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/NewLiveDrawerEntranceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/livesdk/common/i;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NewLiveDrawerEntranceWidget extends LiveRecyclableWidget implements Observer<KVData>, WeakHandler.IHandler, com.bytedance.android.livesdk.common.i {
    public static final List<String> y = null;
    public static boolean z;
    public Boolean a;
    public long b;
    public SimpleDraweeView c;
    public TextView d;
    public View e;
    public View f;
    public SimpleDraweeView g;
    public LiveCircleView h;
    public View i;
    public Disposable j;
    public MergeDrawerViewModel k;
    public hg l;
    public final WeakHandler m;
    public boolean n;
    public com.bytedance.android.live.core.view.a o;
    public Disposable p;
    public Room q;
    public boolean r;
    public String s;
    public ScheduledFuture<?> t;
    public com.bytedance.android.live.room.discovery.drawer.c u;
    public final m v;
    public final h w;
    public final i x;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public b(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            h1 r6 = (h1) r5;
            NewLiveDrawerEntranceWidget r0 = this.a;
            Disposable r1 = r0.p;
            if (r1 == null) goto L6;
            r1.dispose();
        L6:
            if (r0.n == false) goto L21;
            int r7 = r6.a;
            if (5 != r7) goto L11;
        L18:
            r0.Jq(false);
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
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public c(NewLiveDrawerEntranceWidget r1, String r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            com.bytedance.android.livesdk.user.f r9 = jc1.k.n(IUserService.class).user();
            if (NewLiveDrawerEntranceWidget.y.contains(this.b) == true) goto L5;
        L8:
            NewLiveDrawerEntranceWidget r10 = this.a;
            Room r0 = r10.q;
            if (r0 != null) goto L11;
        L15:
            Bundle r12 = new Bundle();
            r12.putString("pull_type", "button");
            if (TextUtils.isEmpty(this.c) == true) goto L18;
        L20:
            boolean r1 = false;
        L21:
            r12.putBoolean("home_refresh", r1);
            r12.putBoolean("switch_follow", this.a.n);
            ((IRoomService) jc1.k.n(IRoomService.class)).openDrawer(ContextUtil.contextToActivity(this.a.getContext()), true, r12, ((Widget) this.a).dataCenter);
            if (this.a.n == false) goto L24;
            com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.C2;
            Long r2 = Long.valueOf(((Number) r13.getValue()).longValue() - this.d);
            r13.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r13, r2);
        L24:
            IVSPlayerService r14 = jc1.k.f(IVSPlayerService.class);
            if (r14 == null) goto L29;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r15 = r14.provideVSPlayerViewControlService(((Widget) this.a).dataCenter);
            if (r15 == null) goto L29;
            r15.setVisibilityStatus(false);
        L29:
            this.a.Jq(true);
            return;
        L18:
            if (TextUtils.equals(this.b, "homepage_fresh") == false) goto L20;
            r1 = true;
            goto L21
        L11:
            if (r0.withAggregateColumn != true) goto L15;
            MergeDrawerViewModel r16 = r10.k;
            if (r16 == null) goto L15;
            r16.setClick(true);
            goto L15
        L5:
            if (r9.isLogin() == true) goto L8;
            Context r3 = ((Widget) this.a).context;
            l.a r4 = new l.a();
            r4.a = CoreSettingUtil.getLoginPromptForFollow();
            r4.b = CoreSettingUtil.getLoginImageForFollow();
            r4.e = "live_detail";
            r4.d = "live";
            r4.c = 1;
            r9.login(r3, new l(r4)).subscribe(new com.bytedance.android.livesdk.user.h());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public d(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            NewLiveDrawerEntranceWidget r0 = this.a;
            NewLiveDrawerEntranceWidget.wq(r0, (hg) r2);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public e(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((IRoomService) jc1.k.n(IRoomService.class)).openDrawer(ContextUtil.contextToActivity(this.a.getContext()), true, new Bundle(), ((Widget) this.a).dataCenter);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public f(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            UpdateDrawerEntranceEvent r9 = (UpdateDrawerEntranceEvent) r8;
            NewLiveDrawerEntranceWidget r0 = this.a;
            int r2 = r9.getBusinessType();
            JSONObject r10 = r9.getExtra();
            List<String> r1 = NewLiveDrawerEntranceWidget.y;
            r0.getClass();
            DrawerEntranceApi r3 = (DrawerEntranceApi) com.bytedance.android.live.network.c.b().e(DrawerEntranceApi.class);
            if (r3 == null) goto L25;
            Room r4 = r0.q;
            if (r4 == null) goto L7;
            long r5 = r4.id;
        L8:
            if (r4 == null) goto L11;
            String r6 = r4.getOwnerUserIdString();
            if (r6 == null) goto L11;
        L12:
            String r7 = r6;
            if (r10 == null) goto L16;
            String r12 = r10.toString();
            if (r12 == null) goto L16;
        L17:
            Observable<com.bytedance.android.live.network.response.e<hg>> r13 = r3.getEntranceData(r2, r5, r7, r12);
            if (r13 == null) goto L26;
            Observable r14 = r13.compose(RxUtil.rxSchedulerHelper());
            if (r14 == null) goto L27;
            ObservableSubscribeProxy r15 = (ObservableSubscribeProxy) r14.as(r0.autoDispose());
            if (r15 == null) goto L28;
            r15.subscribe(new com.bytedance.android.live.room.discovery.drawer.d(r0), com.bytedance.android.live.room.discovery.drawer.e.a);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L16:
            r12 = "";
        L11:
            r6 = "-1";
            goto L12
        L7:
            r5 = -1;
            goto L8
        }
    }

    public static final class g extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ NewLiveDrawerEntranceWidget c;

        public final void run() {
            NewLiveDrawerEntranceWidget r0 = this.c;
            if (r0.n == true) goto L5;
            r0.Lq();
            String r1 = r0.Cq();
            SimpleDraweeView r7 = r0.c;
            String r8 = null;
            if (r7 == null) goto L33;
            ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        L34:
            if (r9 == null) goto L38;
            r9.height = (int) UtilityKotlinExtentionsKt.h(r0.xq());
            SimpleDraweeView r10 = r0.c;
            if (r10 == null) goto L38;
            r10.setLayoutParams(r9);
        L38:
            r0.Aq(!r0.Fq());
            if (r0.Eq() == false) goto L46;
            SimpleDraweeView r12 = r0.c;
            if (r12 == null) goto L43;
            r12.setVisibility(8);
        L43:
            View r5 = r0.e;
            if (r5 == null) goto L53;
            r5.setPadding(s1.f(11.0f), 0, 0, 0);
        L53:
            if (r0.Gq() == false) goto L72;
            Room r2 = r0.q;
            if (r2 == null) goto L107;
            EpisodeExtraInfo r3 = r2.getEpisodeExtra2();
            if (r3 == null) goto L107;
            VSConfigDrawer r4 = r3.getVsConfigDrawer();
            if (r4 == null) goto L107;
            MatchDrawer r6 = r4.drawer;
            if (r6 == null) goto L107;
            py.k r13 = r6.getEntranceIcon();
            if (r13 == null) goto L107;
            List r14 = r13.getUrls();
            if (r14 == null) goto L107;
            String r15 = (String) CollectionsKt.getOrNull(r14, 0);
            if (r15 == null) goto L107;
            AbstractDraweeController<Object, Object> r16 = Fresco.newDraweeControllerBuilder().setUri(r15).setAutoPlayAnimations(false).build();
            SimpleDraweeView r17 = r0.c;
            if (r17 == null) goto L71;
            r17.setController(r16);
        L71:
            r0.Mq(r16);
        L107:
            if (r0.b > 0) goto L109;
            r0.Iq();
        L109:
            b(true);
            return;
        L72:
            AbstractDraweeController<Object, Object> r18 = Fresco.newDraweeControllerBuilder().setUri(i2.d(r1)).setAutoPlayAnimations(false).build();
            SimpleDraweeView r19 = r0.c;
            if (r19 == null) goto L75;
            r19.setController(r18);
        L75:
            MergeDrawerViewModel r20 = r0.k;
            if (r20 != null) goto L78;
        L80:
            r0.Mq(r18);
            List r22 = pg1.b.a;
            Integer r23 = (Integer) rv.a.getValue();
            if (r23 != null) goto L84;
        L86:
            ILiveService r24 = TTLiveService.getLiveService();
            if (r24 == null) goto L92;
            ILiveOntologyInfoManager r25 = r24.getLiveOntologyRecord();
            if (r25 == null) goto L92;
            r8 = r25.getEnterFromMerge();
        L92:
            if (CollectionsKt.contains(pg1.b.a, r8) == false) goto L94;
        L102:
            long r26 = 0;
        L103:
            r0.b = r26;
            if (r26 <= 0) goto L107;
            ((ObservableSubscribeProxy) ((RelationApi) com.bytedance.android.live.network.c.b().e(RelationApi.class)).getRelationShow().compose(RxUtil.rxSchedulerHelper()).as(r0.autoDispose())).subscribe(new com.bytedance.android.live.room.discovery.drawer.f(r0), new com.bytedance.android.live.room.discovery.drawer.g(r0));
            goto L107
        L94:
            if (TextUtils.equals(r8, "inner_push") == true) goto L102;
            if (TextUtils.equals(r8, "push") == true) goto L102;
            if (jc1.k.n(IUserService.class).user().isLogin() == false) goto L102;
            r26 = pg1.b.a();
            goto L103
        L84:
            if (r23.intValue() != 0) goto L86;
        L78:
            if (r20.getMergeDrawFeed() != true) goto L80;
        L46:
            SimpleDraweeView r27 = r0.c;
            if (r27 == null) goto L49;
            r27.setVisibility(0);
        L49:
            View r28 = r0.e;
            if (r28 == null) goto L53;
            r28.setPadding(0, 0, 0, 0);
            goto L53
        L33:
            r9 = null;
            goto L34
        L5:
            if (r0.Eq() == false) goto L9;
            View r29 = r0.f;
            if (r29 == null) goto L12;
            r29.setVisibility(8);
        L12:
            TextView r30 = r0.d;
            if (r30 == null) goto L15;
            r30.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        L15:
            TextView r32 = r0.d;
            if (r32 == null) goto L18;
            r32.setMarqueeRepeatLimit(-1);
        L18:
            TextView r33 = r0.d;
            if (r33 == null) goto L21;
            r33.setFilters(new InputFilter[0]);
        L21:
            TextView r34 = r0.d;
            if (r34 == null) goto L24;
            r34.setMaxWidth(s1.f(52.0f));
        L24:
            TextView r35 = r0.d;
            if (r35 == null) goto L27;
            r35.requestFocusFromTouch();
        L27:
            com.bytedance.android.live.core.view.a r36 = r0.o;
            if (r36 == null) goto L107;
            r36.d();
            goto L107
        L9:
            View r37 = r0.f;
            if (r37 == null) goto L12;
            r37.setVisibility(0);
            goto L12
        }

        public g(NewLiveDrawerEntranceWidget r1) {
            this.c = r1;
            super("live_drawer_entrance_load");
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public h(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void a() {
            NewLiveDrawerEntranceWidget r0 = this.a;
            List<String> r1 = NewLiveDrawerEntranceWidget.y;
            r0.getClass();
            Integer r2 = (Integer) o2.a.getValue();
            if (r2 != null) goto L6;
            return;
        L6:
            if (r2.intValue() != 2) goto L44;
            da r3 = da.a;
            if (((m) r3.getValue()).k() == true) goto L42;
            IAiService r4 = jc1.k.f(IAiService.class);
            if (r4 == null) goto L45;
            IFeatureService r5 = jc1.k.f(IFeatureService.class);
            if (r5 == null) goto L46;
            List r6 = r0.v.e();
            if (r6 == null) goto L21;
            int r7 = ((Number) r5.getFeatureManager().getFeature("live_watch_count", -1)).intValue();
            if (r6.isEmpty() == true) goto L21;
            if (r6.contains(Integer.valueOf(r7)) == true) goto L21;
            return;
        L21:
            if (r0.u != null) goto L23;
            r0.u = new com.bytedance.android.live.room.discovery.drawer.c(r5, r0, r4);
        L23:
            com.bytedance.android.live.room.discovery.drawer.c r8 = r0.u;
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
            if (r0.v.g() == true) goto L37;
            return;
        L37:
            if (((Boolean) r5.getFeatureManager().getFeature("ai_engine_ready", Boolean.FALSE)).booleanValue() == false) goto L40;
            r4.triggerDrawerPredict(r9);
            return;
        L40:
            if (((m) r3.getValue()).j() == false) goto L49;
            r0.Bq();
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
            r0.Bq();
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

    public static final class i implements Runnable {
        public long a;
        public final long b;
        public final long c;
        public final /* synthetic */ NewLiveDrawerEntranceWidget d;

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
            IFeatureService r4 = jc1.k.f(IFeatureService.class);
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

        public i(NewLiveDrawerEntranceWidget r3) {
            this.d = r3;
            da r4 = da.a;
            this.b = ((m) r4.getValue()).h();
            this.c = ((m) r4.getValue()).b();
        }
    }

    public static final class j extends BaseControllerListener<Object> {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public j(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            NewLiveDrawerEntranceWidget r5 = this.a;
            List<String> r6 = NewLiveDrawerEntranceWidget.y;
            if (r5.Gq() == true) goto L5;
        L7:
            if (r4 == null) goto L10;
            r4.start();
            return;
        L10:
            return;
        L5:
            if ((r4 instanceof AnimatedDrawable2) == false) goto L7;
            ((AnimatedDrawable2) r4).setAnimationListener(new com.bytedance.android.live.room.discovery.drawer.b(r5, r4));
            goto L7
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ NewLiveDrawerEntranceWidget a;

        public k(NewLiveDrawerEntranceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            NewLiveDrawerEntranceWidget r3 = (NewLiveDrawerEntranceWidget) r2;
            NewLiveDrawerEntranceWidget r4 = this.a;
            List<String> r0 = NewLiveDrawerEntranceWidget.y;
            if (r4.Gq() == true) goto L11;
            SimpleDraweeView r5 = this.a.c;
            if (r5 == null) goto L11;
            DraweeController r6 = r5.getController();
            if (r6 == null) goto L11;
            Animatable r7 = r6.getAnimatable();
            if (r7 == null) goto L11;
            r7.stop();
        L11:
            this.a.r = true;
        }
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final int getLayoutId() {
        return 2131565268;
    }

    public final String getSpm() {
        return "a100.a100.a205";
    }

    public final String nc() {
        return "NewLiveDrawerEntranceWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final int supportClearScene() {
        return 10;
    }

    static {
        y = CollectionsKt.listOf(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        z = true;
    }

    public final void Bq() {
        IStrategyService r0 = jc1.k.f(IStrategyService.class);
        if (r0 == null) goto L7;
        LiveData r1 = IStrategyService.a.a(r0, "drawer_preload", Boolean.FALSE, false, 12);
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L12;
        HashMap r3 = new HashMap();
        r3.put("predict_action", "strategy");
        Kq(null, r3);
        u.l().sendLog("livesdk_liveai_drawer_predict", r3, new Object[0]);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final String Cq() {
        Room r0 = this.q;
        if (r0 != null) goto L5;
    L8:
        ILiveService r1 = TTLiveService.getLiveService();
        String r2 = "";
        if (r1 == null) goto L14;
        ILiveOntologyInfoManager r3 = r1.getLiveOntologyRecord();
        if (r3 == null) goto L14;
        String r4 = r3.getEnterFromMerge();
        if (r4 == null) goto L14;
    L15:
        ILiveService r5 = TTLiveService.getLiveService();
        if (r5 == null) goto L20;
        ILiveOntologyInfoManager r6 = r5.getLiveOntologyRecord();
        if (r6 == null) goto L20;
        r6.getEnterMethod();
    L20:
        ILiveService r7 = TTLiveService.getLiveService();
        if (r7 == null) goto L29;
        ILiveOntologyInfoManager r8 = r7.getLiveOntologyRecord();
        if (r8 == null) goto L29;
        String r9 = r8.getTitle();
        if (r9 == null) goto L29;
        r2 = r9;
    L29:
        if (TextUtils.isEmpty(r2) == true) goto L31;
        return "asset://com.ss.android.ies.live.sdk/ttlive_drawer_entrance_fl_webp_anim.webp";
    L31:
        if (LiveDrawerHelper.d(r4) == false) goto L33;
        return "asset://com.ss.android.ies.live.sdk/ttlive_drawer_entrance_fl_webp_anim.webp";
    L33:
        if (LiveDrawerHelper.c(r4) == true) goto L40;
        return "asset://com.ss.android.ies.live.sdk/ttlive_drawer_entrance_webp_anim.webp";
    L40:
        return "asset://com.ss.android.ies.live.sdk/ttlive_drawer_entrance_fl_webp_anim.webp";
    L14:
        r4 = "";
        goto L15
    L5:
        if (r0.withAggregateColumn != true) goto L8;
        return "asset://com.ss.android.ies.live.sdk/merge_vertical_icon.png";
    }

    public final boolean Eq() {
        return ((Boolean) ba0.a.getValue()).booleanValue();
    }

    public final boolean Gq() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isVSRoom() == false) goto L9;
        if (r0.isVSSpecialDrawer() == false) goto L9;
        return true;
    }

    public final void Iq() {
        HashMap r0 = new HashMap();
        String r2 = "";
        if (this.n == false) goto L6;
        String r1 = "follow";
    L11:
        r0.put("status", r1);
        ILiveService r3 = TTLiveService.getLiveService();
        if (r3 == null) goto L17;
        ILiveOntologyInfoManager r4 = r3.getLiveOntologyRecord();
        if (r4 == null) goto L17;
        String r5 = r4.getEnterFromMerge();
        if (r5 == null) goto L17;
    L18:
        r0.put("drawer_page", r5);
        u.l().sendLog("livesdk_more_anchor_popup", r0, new Object[]{new x(), Room.class});
        this.b = 0;
        HashMap r6 = new HashMap();
        if (e5.n() == false) goto L21;
        String r7 = "landscape";
    L22:
        r6.put("screen_direction", r7);
        r6.put("user_id", jc1.k.n(IUserService.class).user().n());
        ILiveService r8 = TTLiveService.getLiveService();
        if (r8 == null) goto L28;
        ILiveOntologyInfoManager r9 = r8.getLiveOntologyRecord();
        if (r9 == null) goto L28;
        String r10 = r9.getEnterFromMerge();
        if (r10 == null) goto L28;
    L29:
        r6.put("drawer_page", r10);
        hg r12 = this.l;
        if (r12 == null) goto L46;
        com.bytedance.android.live.base.model.moreliveentrance.b r13 = r12.a();
        if (r13 == null) goto L46;
        if (r13.l() != 11) goto L36;
        boolean r14 = true;
    L37:
        if (r14 == true) goto L40;
        r13 = null;
    L40:
        if (r13 == null) goto L46;
        r6.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        String r15 = r13.b();
        if (r15 == null) goto L45;
        r2 = r15;
    L45:
        r6.put("extra", r2);
        goto L46
    L36:
        r14 = false;
    L46:
        u.l().sendLog("livesdk_drawer_entrance_show", r6, new Object[]{x.class, Room.class});
        return;
    L28:
        r10 = "";
        goto L29
    L21:
        r7 = "portrait";
    L17:
        r5 = "";
        goto L18
    L6:
        if (TextUtils.isEmpty(this.s) == true) goto L10;
        r1 = this.s;
        if (r1 != null) goto L11;
        r1 = "";
        goto L11
    L10:
        r1 = DataType.Normal;
        goto L11
    }

    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver(this);
        com.bytedance.android.live.core.view.a r0 = this.o;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (this.n == true) goto L8;
        Jq(false);
    L8:
        Boolean r1 = Boolean.FALSE;
        this.a = r1;
        ScheduledFuture<?> r2 = this.t;
        if (r2 == null) goto L11;
        r2.cancel(true);
        this.t = null;
    L11:
        com.bytedance.android.live.room.discovery.drawer.c r3 = this.u;
        if (r3 == null) goto L19;
        IFeatureService r4 = jc1.k.f(IFeatureService.class);
        if (r4 == null) goto L18;
        z90.a r5 = r4.getFeatureManager();
        if (r5 == null) goto L18;
        r5.h(r3);
    L18:
        this.u = null;
    L19:
        i0.c().removeCallbacks(this.w);
        IFeatureService r6 = jc1.k.f(IFeatureService.class);
        if (r6 == null) goto L25;
        z90.a r7 = r6.getFeatureManager();
        if (r7 == null) goto L26;
        r7.i("drawer_preload_already", r1, FeatureType.DYNAMIC);
        return;
    L26:
        return;
    }

    public NewLiveDrawerEntranceWidget() {
        this.a = Boolean.FALSE;
        this.m = new WeakHandler(this);
        this.v = (m) da.a.getValue();
        this.w = new h(this);
        this.x = new i(this);
    }

    public boolean Fq() {
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L6;
        return false;
    L6:
        return e5.n();
    }

    public final void Lq() {
        ILiveService r0 = TTLiveService.getLiveService();
        String r1 = "";
        if (r0 == null) goto L8;
        ILiveOntologyInfoManager r2 = r0.getLiveOntologyRecord();
        if (r2 == null) goto L8;
        String r3 = r2.getEnterFromMerge();
        if (r3 == null) goto L8;
    L9:
        ILiveService r4 = TTLiveService.getLiveService();
        if (r4 == null) goto L14;
        ILiveOntologyInfoManager r5 = r4.getLiveOntologyRecord();
        if (r5 == null) goto L14;
        r5.getEnterMethod();
    L14:
        o r6 = u.l().c(x.class);
        if (r6.getMap().containsKey("enter_from_merge") == false) goto L18;
        r1 = (String) r6.getMap().get("enter_from_merge");
    L18:
        if (r6.getMap().containsKey("enter_method") == false) goto L20;
        String r7 = (String) r6.getMap().get("enter_method");
    L20:
        ILiveService r8 = TTLiveService.getLiveService();
        if (r8 == null) goto L25;
        ILiveOntologyInfoManager r9 = r8.getLiveOntologyRecord();
        if (r9 == null) goto L25;
        boolean r10 = r9.isFromMatchRoom();
    L27:
        if (Gq() == false) goto L46;
        Room r12 = this.q;
        if (r12 == null) goto L46;
        EpisodeExtraInfo r13 = r12.getEpisodeExtra2();
        if (r13 == null) goto L46;
        VSConfigDrawer r14 = r13.getVsConfigDrawer();
        if (r14 == null) goto L46;
        MatchDrawer r15 = r14.drawer;
        if (r15 == null) goto L46;
        yq(r15.getEntranceName());
        UIUtils.setText(this.d, String.valueOf(r15.getEntranceName()));
        View r16 = ((Widget) this).contentView;
        if (r16 == null) goto L66;
        r3.c(r16, r15.getEntranceName(), true);
        TextView r17 = this.d;
        if (r17 == null) goto L41;
        r17.setFocusable(false);
    L41:
        TextView r18 = this.d;
        if (r18 == null) goto L67;
        r18.setImportantForAccessibility(2);
        return;
    L67:
        return;
    L66:
        return;
    L46:
        if (TextUtils.equals("drawer_fresh", r1) == false) goto L53;
        Room r19 = this.q;
        if (r19 == null) goto L53;
        if (r19.isMediaRoom() != true) goto L53;
        UIUtils.setText(this.d, s1.B(2131911636));
        return;
    L53:
        if (r10 == true) goto L55;
        yq(this.s);
        if (r1 != null) goto L62;
    L64:
        UIUtils.setText(this.d, LiveDrawerHelper.b(r3, this.s));
        return;
    L62:
        if (StringsKt.startsWith$default(r1, "drawer_", false, 2, null) != true) goto L64;
        UIUtils.setText(this.d, LiveDrawerHelper.b(r1, this.s));
        return;
    L55:
        if (LiveDrawerHelper.e() == false) goto L57;
        UIUtils.setText(this.d, LiveDrawerHelper.b(r1, this.s));
        return;
    L57:
        UIUtils.setText(this.d, LiveDrawerHelper.b(r3, this.s));
        return;
    L25:
        r10 = false;
    L8:
        r3 = "";
        goto L9
    }

    public final Animator startShowAnimation() {
        if (com.bytedance.android.live.core.tetris.widgets.d.c() == true) goto L10;
        if (Fq() == true) goto L10;
        float r3 = 120;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(((Widget) this).contentView, "translationX", new float[]{UtilityKotlinExtentionsKt.h(r3), UtilityKotlinExtentionsKt.h(r3)}).setDuration(500);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(((Widget) this).contentView, "translationX", new float[]{UtilityKotlinExtentionsKt.h(r3), 0.0f}).setDuration(300);
        AnimatorSet r4 = new AnimatorSet();
        r4.playSequentially(new Animator[]{r0, r2});
        r4.start();
        return r4;
    L10:
        return super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.startShowAnimation();
    }

    public final float xq() {
        if (Gq() == false) goto L5;
        return 22.0f;
    L5:
        String r0 = Cq();
        int r2 = r0.hashCode();
        if (r2 == (-129634438)) goto L14;
        if (r2 == 715587467) goto L11;
    L16:
        return 20.0f;
    L11:
        if (r0.equals("asset://com.ss.android.ies.live.sdk/ttlive_drawer_entrance_fl_webp_anim.webp") == false) goto L16;
        return 11.3f;
    L14:
        if (r0.equals("asset://com.ss.android.ies.live.sdk/ttlive_drawer_entrance_webp_anim.webp") == false) goto L16;
        return 22.0f;
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    public final Boolean uk() {
        return this.a;
    }

    public final void Aq(boolean r8) {
        if (Gq() == true) goto L5;
        return;
    L5:
        if (r8 == false) goto L9;
        View r0 = this.e;
        if (r0 == null) goto L12;
        r0.setBackground(s1.m(2131248768));
    L12:
        SimpleDraweeView r1 = this.c;
        ViewGroup.LayoutParams r2 = null;
        if (r1 == null) goto L15;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L16:
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r3;
        if (r4 == null) goto L32;
        r4.height = (int) UtilityKotlinExtentionsKt.h(xq());
        r4.width = (int) UtilityKotlinExtentionsKt.h(xq());
        if (r8 == true) goto L28;
        SimpleDraweeView r5 = this.c;
        if (r5 == null) goto L23;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L24:
        if (r6 == null) goto L27;
        ((LinearLayout.LayoutParams) r6).leftMargin = s1.f(8.0f);
        r4.rightMargin = s1.f(3.0f);
        zq(this.e, -2, s1.f(24.0f));
    L29:
        SimpleDraweeView r7 = this.c;
        if (r7 == null) goto L32;
        r7.setLayoutParams(r4);
        goto L32
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L23:
        r6 = null;
        goto L24
    L28:
        r4.leftMargin = s1.f(4.0f);
        r4.rightMargin = s1.f(2.0f);
        zq(this.e, -2, s1.f(22.0f));
    L32:
        View r9 = this.i;
        if (r9 == null) goto L35;
        r2 = r9.getLayoutParams();
    L35:
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r2;
        if (r10 == null) goto L44;
        if (r8 == true) goto L39;
        r10.leftMargin = s1.f(4.0f);
        r10.rightMargin = s1.f(8.0f);
    L40:
        View r12 = this.i;
        if (r12 == null) goto L45;
        r12.setLayoutParams(r10);
        return;
    L45:
        return;
    L39:
        r10.leftMargin = s1.f(1.0f);
        r10.rightMargin = s1.f(12.0f);
        goto L40
    L44:
        return;
    L15:
        r3 = null;
        goto L16
    L9:
        View r13 = this.e;
        if (r13 == null) goto L12;
        r13.setBackground(s1.m(2131248771));
        goto L12
    }

    public final void Jq(boolean r8) {
        this.n = false;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L5;
        r1.put("data_more_entrance_follow", Boolean.FALSE);
    L5:
        Disposable r2 = this.j;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        TextView r3 = this.d;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
    L11:
        TextView r4 = this.d;
        if (r4 == null) goto L14;
        r4.setAlpha(1.0f);
    L14:
        TextView r5 = this.d;
        if (r5 == null) goto L17;
        r5.setEllipsize(null);
    L17:
        TextView r6 = this.d;
        if (r6 == null) goto L21;
        r6.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(4)});
    L21:
        if (Eq() == false) goto L28;
        SimpleDraweeView r7 = this.c;
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        View r9 = this.e;
        if (r9 == null) goto L34;
        r9.setPadding(s1.f(11.0f), 0, 0, 0);
    L34:
        SimpleDraweeView r10 = this.c;
        if (r10 == null) goto L38;
        r10.setAlpha(1.0f);
    L38:
        if (Gq() == false) goto L40;
        if (r8 == true) goto L40;
    L47:
        this.r = true;
        View r12 = this.f;
        if (r12 == null) goto L50;
        r12.setVisibility(8);
    L50:
        UIUtils.updateLayoutMargin(this.e, 0, 0, 0, 0);
        com.bytedance.android.live.core.view.a r13 = this.o;
        if (r13 == null) goto L53;
        r13.a();
    L53:
        Lq();
        return;
    L40:
        SimpleDraweeView r14 = this.c;
        if (r14 == null) goto L47;
        DraweeController r15 = r14.getController();
        if (r15 == null) goto L47;
        Animatable r16 = r15.getAnimatable();
        if (r16 == null) goto L47;
        r16.stop();
        goto L47
    L28:
        SimpleDraweeView r17 = this.c;
        if (r17 == null) goto L31;
        r17.setVisibility(0);
    L31:
        View r18 = this.e;
        if (r18 == null) goto L34;
        r18.setPadding(0, 0, 0, 0);
        goto L34
    }

    public final void Mq(AbstractDraweeController<Object, Object> r5) {
        if (this.c != null) goto L6;
        return;
    L6:
        if (Gq() == true) goto L27;
        if (Eq() == false) goto L10;
        return;
    L10:
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L17;
        ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
        if (r1 == null) goto L17;
        if (r1.getCreatedTimes() != 1) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L25;
        List r3 = pg1.b.a;
        if (pg1.b.b == true) goto L33;
        Room r4 = this.q;
        if (r4 != null) goto L24;
    L29:
        r5.addControllerListener(new j(this));
        this.j = ((ObservableSubscribeProxy) Observable.just(this).delay(30, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(getLifecycle(), Lifecycle.Event.ON_DESTROY)))).subscribe(new k(this), RxUtil.getNoOpThrowable());
        if (Gq() == true) goto L35;
        List r6 = pg1.b.a;
        pg1.b.b = true;
        return;
    L35:
        return;
    L24:
        if (r4.withAggregateColumn != true) goto L29;
        return;
    L33:
        return;
    L25:
        return;
    L17:
        r2 = false;
        goto L18
    L27:
        if (z == true) goto L29;
    }

    public final void handleMsg(Message r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (1 != r2.what) goto L8;
        Jq(false);
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (isViewValid() == false) goto L76;
        if (r7 == null) goto L77;
        Object r0 = r7.getData();
        FragmentActivity r2 = null;
        if ((r0 instanceof Object) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L93;
        boolean r3 = false;
        int r4 = 0;
        if (Intrinsics.areEqual("DATA_DRAWER_LAYOUT_IS_OPEN", r7.getKey()) == false) goto L19;
        Boolean r8 = (Boolean) r7.getData();
        if (r8 == null) goto L15;
        boolean r9 = r8.booleanValue();
    L16:
        if (r9 == false) goto L78;
        Jq(false);
        return;
    L78:
        return;
    L15:
        r9 = false;
        goto L16
    L19:
        if (Intrinsics.areEqual("data_keyboard_status_douyin", r7.getKey()) == false) goto L30;
        Boolean r10 = (Boolean) r7.getData();
        if (r10 == null) goto L23;
        boolean r12 = r10.booleanValue();
    L24:
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L80;
        if (r12 == false) goto L28;
        r4 = 8;
    L28:
        r1.setVisibility(r4);
        return;
    L80:
        return;
    L23:
        r12 = false;
        goto L24
    L30:
        if (Intrinsics.areEqual("dta_smart_client_update_drawer_feed", r7.getKey()) == false) goto L49;
        Boolean r13 = (Boolean) r7.getData();
        if (r13 == null) goto L35;
        r3 = r13.booleanValue();
    L35:
        if (((Boolean) ((Widget) this).dataCenter.get("DATA_DRAWER_LAYOUT_IS_OPEN", Boolean.FALSE)).booleanValue() == true) goto L94;
        if (r3 == false) goto L82;
        IRoomService r14 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r14 == null) goto L41;
        r14.setLiveRoomDetail(((Widget) this).dataCenter);
    L41:
        FragmentActivity r15 = ContextUtil.contextToActivity(getContext());
        if ((r15 instanceof FragmentActivity) == false) goto L45;
        r2 = r15;
    L45:
        FragmentActivity r5 = r2;
        if (r5 == null) goto L83;
        jc1.k.n(IHostFeed.class).preloadDrawerFeed(r5, LiveDrawerHelper.e());
        return;
    L83:
        return;
    L82:
        return;
    L94:
        return;
    L49:
        if (Intrinsics.areEqual("cmd_widget_loaded", r7.getKey()) == false) goto L62;
        TextView r16 = this.d;
        if (r16 != null) goto L53;
        return;
    L53:
        if (Intrinsics.areEqual(r16.getText(), pg1.a.a(1)) == true) goto L57;
        if (this.v.a() == true) goto L57;
        return;
    L57:
        if (this.v.g() == false) goto L59;
    L60:
        i0.c().postDelayed(this.w, this.v.f());
        return;
    L59:
        if (this.v.i() == true) goto L60;
        return;
    L62:
        if (Intrinsics.areEqual("data_media_introduction_showing", r7.getKey()) == false) goto L89;
        Boolean r17 = Boolean.FALSE;
        Boolean r18 = (Boolean) r7.getData(r17);
        if (r18 == null) goto L68;
        r17 = r18;
    L68:
        if (r17.booleanValue() == false) goto L72;
        View r19 = ((Widget) this).contentView;
        if (r19 == null) goto L90;
        r19.setImportantForAccessibility(4);
        return;
    L90:
        return;
    L72:
        View r20 = ((Widget) this).contentView;
        if (r20 == null) goto L92;
        r20.setImportantForAccessibility(0);
        return;
    L92:
        return;
    L89:
        return;
    L93:
        return;
    L77:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (PadConfigUtils.c() == false) goto L11;
        if (r2 == null) goto L8;
        boolean r0 = true;
        if (r2.orientation != 1) goto L8;
    L9:
        Aq(r0);
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

    public void onInit(Object[] r12) {
        View r0 = ((Widget) this).contentView;
        View r1 = null;
        if (r0 == null) goto L5;
        SimpleDraweeView r2 = (SimpleDraweeView) r0.findViewById(2131371698);
    L6:
        this.c = r2;
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L9;
        TextView r4 = (TextView) r3.findViewById(2131371712);
    L10:
        this.d = r4;
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L13;
        View r6 = r5.findViewById(2131371708);
    L14:
        this.e = r6;
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L17;
        View r8 = r7.findViewById(2131363643);
    L18:
        this.f = r8;
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L21;
        SimpleDraweeView r10 = (SimpleDraweeView) r9.findViewById(2131376019);
    L22:
        this.g = r10;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L25;
        LiveCircleView r14 = (LiveCircleView) r13.findViewById(2131376101);
    L26:
        this.h = r14;
        ViewGroup r15 = ((Widget) this).containerView;
        if (r15 == null) goto L29;
        r1 = r15.findViewById(2131371699);
    L29:
        this.i = r1;
        if (PadConfigUtils.c() == false) goto L35;
        View r16 = this.i;
        if (r16 == null) goto L35;
        a1.n(r16, s1.j(2131168967));
    L35:
        if (r12 != null) goto L37;
    L48:
        SimpleDraweeView r17 = this.g;
        com.bytedance.android.live.core.view.a r18 = new com.bytedance.android.live.core.view.a(r17, this.h);
        this.o = r18;
        r17.removeOnAttachStateChangeListener(r18.k);
        r17.addOnAttachStateChangeListener(r18.k);
        if (r18.c == false) goto L51;
        r18.c(0);
        r18.d();
    L52:
        this.p = xs2.b.a().b(h1.class).subscribe(new b(this));
        long r19 = ((Number) m2.a.getValue()).longValue() * ((long) WebcastRedirectException.UNKNOWN);
        ILiveService r110 = TTLiveService.getLiveService();
        if (r110 == null) goto L60;
        ILiveOntologyInfoManager r111 = r110.getLiveOntologyRecord();
        if (r111 == null) goto L60;
        String r112 = r111.getReqFrom();
        if (r112 == null) goto L60;
        String r20 = r112;
    L61:
        ILiveService r113 = TTLiveService.getLiveService();
        if (r113 == null) goto L69;
        ILiveOntologyInfoManager r114 = r113.getLiveOntologyRecord();
        if (r114 == null) goto L69;
        String r115 = r114.getTitle();
        if (r115 == null) goto L69;
        String r22 = r115;
    L70:
        ((Widget) this).contentView.setOnClickListener(new c(this, r20, r22, r19));
        TextView r116 = this.d;
        if (r116 == null) goto L74;
        r116.setAccessibilityDelegate(t.a);
        return;
    L74:
        return;
    L69:
        r22 = "";
    L60:
        r20 = "";
        goto L61
    L51:
        r18.a();
        r18.c(8);
        goto L52
    L37:
        if (r12.length != 0) goto L39;
        boolean r23 = true;
    L41:
        if ((!r23) != true) goto L48;
        Object r117 = r12[0];
        if ((r117 instanceof Boolean) == false) goto L48;
        if (r117 == null) goto L47;
        ((Boolean) r117).booleanValue();
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L39:
        r23 = false;
        goto L41
    L25:
        r14 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onLoad(Object[] r10) {
        this.q = (Room) ((Widget) this).dataCenter.get("data_room", null);
        r r12 = pm1.f.o();
        if (r12 == null) goto L12;
        r12.a();
        if (MultiTabManagerImpl.e.i(((Widget) this).dataCenter) != true) goto L12;
        Room r13 = this.q;
        if (r13 == null) goto L12;
        long r2 = r13.getRoomId();
        Map r14 = MatchWidgetDurationMetric.a;
        MatchWidgetDurationMetric.Type r15 = MatchWidgetDurationMetric.Type.MORE_ANCHOR;
        Intrinsics.checkNotNullParameter(r15, "type");
        if (MatchWidgetDurationMetric.b.containsKey(Long.valueOf(r2)) == false) goto L12;
        System.currentTimeMillis();
        MatchWidgetDurationMetric.b(r2, r15);
    L12:
        ((Widget) this).dataCenter.observe("DATA_DRAWER_LAYOUT_IS_OPEN", this).observeForever("data_keyboard_status_douyin", this).observe("dta_smart_client_update_drawer_feed", this).observe("cmd_widget_loaded", this).observe("data_media_introduction_showing", this);
        Activity r16 = ContextUtil.contextToActivity(getContext());
        if ((r16 instanceof FragmentActivity) == true) goto L15;
        r16 = null;
    L15:
        FragmentActivity r17 = (FragmentActivity) r16;
        if (r17 == null) goto L18;
        MergeDrawerViewModel r18 = (MergeDrawerViewModel) ViewModelProviders.of(r17).get(MergeDrawerViewModel.class);
    L19:
        this.k = r18;
        Room r19 = this.q;
        String r3 = "";
        if (r19 != null) goto L22;
    L28:
        if (r19 == null) goto L33;
        if (r19.isMediaRoom() != true) goto L33;
    L51:
        String r110 = null;
    L52:
        this.s = r110;
        if (this.n == false) goto L56;
        r3 = "follow";
    L62:
        xs2.b.a().post(new LogEvent("button", r3));
        final g r111 = new g(this);
        RoomContext.a r4 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r4, ((Widget) this).dataCenter, 0, 2);
        if (r5 == null) goto L68;
        com.bytedance.live.datacontext.j r6 = r5.getWidgetLoadTaskScheduler();
        if (r6 == null) goto L68;
        r6.c(new AnonymousClass4(this, r111));
    L68:
        if (Gq() == false) goto L70;
    L74:
        MergeDrawerViewModel r112 = this.k;
        if (r112 == null) goto L88;
        if (r112.getMergeDrawFeed() != true) goto L88;
        if (r112.getCanAutoOpenMergeDrawer() != true) goto L88;
        if (r112.isDialogOpen() == true) goto L88;
        Room r7 = this.q;
        if (r7 == null) goto L88;
        if (r7.withAggregateColumn != true) goto L88;
        ((Widget) this).contentView.callOnClick();
        r112.setCanAutoOpenMergeDrawer(false);
    L88:
        if (Fq() == true) goto L90;
    L104:
        r r113 = pm1.f.o();
        if (r113 == null) goto L111;
        r113.a();
        if (MultiTabManagerImpl.e.i(((Widget) this).dataCenter) != true) goto L111;
        Room r114 = this.q;
        if (r114 == null) goto L111;
        long r8 = r114.getRoomId();
        Map r115 = MatchWidgetDurationMetric.a;
        MatchWidgetDurationMetric.a(r8, MatchWidgetDurationMetric.Type.MORE_ANCHOR);
    L111:
        RoomContext r116 = RoomContext.a.c(r4, null, 0, 3);
        if (r116 == null) goto L114;
        ((ObservableSubscribeProxy) dc2.b.a(n3.g(r116), NewLiveDrawerEntranceWidget$onLoad$8$roomDataSyncModel$1.INSTANCE).getMoreLiveEntranceSyncData().d.as(autoDispose())).subscribe(new d(this));
    L114:
        RoomContext r117 = RoomContext.a.c(r4, ((Widget) this).dataCenter, 0, 2);
        if (r117 == null) goto L124;
        com.bytedance.live.datacontext.m r118 = r117.getOpenDrawerWhenRoomOpen();
        if (r118 == null) goto L124;
        ALogger.i("DrawerEntrance", "openDrawerWhenRoomOpen: " + ((Boolean) r118.getValue()).booleanValue());
        if (((Boolean) r118.getValue()).booleanValue() == true) goto L121;
    L123:
        r118.setValue(Boolean.FALSE);
        goto L124
    L121:
        if (((jj1) oj1.a.getValue()).j() == false) goto L123;
        i0.c().postDelayed(new e(this), 500);
    L124:
        ((ObservableSubscribeProxy) xs2.b.a().b(UpdateDrawerEntranceEvent.class).as(autoDispose())).subscribe(new f(this));
        return;
    L90:
        if (Gq() == true) goto L104;
        View r119 = this.e;
        if (r119 == null) goto L94;
        r119.setBackground(s1.m(2131248771));
    L94:
        zq(this.e, -2, s1.f(20.0f));
        zq(this.c, s1.f(25.0f), s1.f(xq()));
        View r120 = this.i;
        if (r120 == null) goto L97;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
    L98:
        if (r121 == null) goto L103;
        LinearLayout.LayoutParams r122 = (LinearLayout.LayoutParams) r121;
        r122.leftMargin = s1.f(4.0f);
        r122.rightMargin = s1.f(8.0f);
        View r9 = this.i;
        if (r9 == null) goto L104;
        r9.setLayoutParams(r122);
        goto L104
    L103:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L97:
        r121 = null;
        goto L98
    L70:
        if (RoomContext.a.c(r4, ((Widget) this).dataCenter, 0, 2) == null) goto L74;
        View r123 = this.e;
        if (r123 == null) goto L74;
        r123.setBackgroundResource(2131248768);
        goto L74
    L56:
        if (TextUtils.isEmpty(r110) == true) goto L61;
        String r124 = this.s;
        if (r124 == null) goto L62;
        r3 = r124;
        goto L62
    L61:
        r3 = DataType.Normal;
    L33:
        if (LiveDrawerHelper.e() == false) goto L51;
        Integer r125 = (Integer) q2.a.getValue();
        if (r125 != null) goto L39;
    L41:
        Room r126 = this.q;
        if (r126 != null) goto L44;
    L46:
        Room r127 = this.q;
        if (r127 == null) goto L51;
        VerticalTypeInfo r128 = r127.mVerticalTypeInfo;
        if (r128 == null) goto L51;
        r110 = r128.name;
        goto L52
    L44:
        if (r126.mVerticalTypeInfo == null) goto L46;
        int r20 = hg.a;
        this.l = hg.a.a(r126);
        Unit r129 = Unit.INSTANCE;
        goto L46
    L39:
        if (r125.intValue() != 0) goto L41;
    L22:
        if (r19.withAggregateColumn != true) goto L28;
        VerticalTypeInfo r130 = r19.mVerticalTypeInfo;
        if (r130 == null) goto L27;
        r110 = r130.name;
        if (r110 != null) goto L52;
    L27:
        r110 = "";
        goto L52
    L18:
        r18 = null;
        goto L19
    }

    public final void qo(Boolean r1) {
        this.a = r1;
    }

    public final void yq(String r3) {
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L7:
        if (r4 <= 4) goto L24;
        TextView r5 = this.d;
        if (r5 == null) goto L11;
        r5.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L11:
        TextView r6 = this.d;
        if (r6 == null) goto L14;
        r6.setMarqueeRepeatLimit(-1);
    L14:
        TextView r7 = this.d;
        if (r7 == null) goto L17;
        r7.setFilters(new InputFilter[0]);
    L17:
        TextView r8 = this.d;
        if (r8 == null) goto L20;
        r8.setMaxWidth(s1.f(52.0f));
    L20:
        TextView r9 = this.d;
        if (r9 == null) goto L25;
        r9.requestFocusFromTouch();
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r4 = 0;
        goto L7
    }

    public static final void wq(NewLiveDrawerEntranceWidget r8, hg r9) {
        r8.getClass();
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.a() == null) goto L56;
        TextView r0 = r8.d;
        String r1 = null;
        if (r0 == null) goto L10;
        CharSequence r2 = r0.getText();
    L12:
        if (TextUtils.equals(r2, "更多关注") == false) goto L14;
        return;
    L14:
        if (TextUtils.equals(r2, "更多同城") == false) goto L17;
        return;
    L17:
        if (r8.n == false) goto L20;
        return;
    L20:
        if (LiveDrawerHelper.e() == true) goto L23;
        return;
    L23:
        if (r8.l != null) goto L25;
        r8.l = r9;
    L46:
        hg r3 = r8.l;
        if (r3 == null) goto L52;
        com.bytedance.android.live.base.model.moreliveentrance.b r4 = r3.a();
        if (r4 == null) goto L51;
        r1 = r4.e();
    L51:
        r8.s = r1;
    L52:
        int r5 = hg.a;
        hg.a.b(r8.q, r9);
        r8.Lq();
        return;
    L25:
        com.bytedance.android.live.base.model.moreliveentrance.b r6 = r9.a();
        long r7 = -1;
        if (r6 == null) goto L28;
        long r10 = r6.f();
    L29:
        hg r12 = r8.l;
        if (r12 == null) goto L34;
        com.bytedance.android.live.base.model.moreliveentrance.b r13 = r12.a();
        if (r13 == null) goto L34;
        long r14 = r13.f();
    L36:
        if (r10 < r14) goto L38;
        r8.l = r9;
        goto L46
    L38:
        long r15 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        hg r16 = r8.l;
        if (r16 == null) goto L44;
        com.bytedance.android.live.base.model.moreliveentrance.b r17 = r16.a();
        if (r17 == null) goto L44;
        r7 = r17.o();
    L44:
        if (r15 <= r7) goto L46;
        r8.l = r9;
    L34:
        r14 = -1;
        goto L36
    L28:
        r10 = -1;
        goto L29
    L10:
        r2 = null;
        goto L12
    }

    public final void Kq(ArrayList<Float> r4, Map<String, String> r5) {
        ScheduledFuture<?> r0 = this.t;
        if (r0 == null) goto L5;
        r0.cancel(true);
    L5:
        if (r4 != null) goto L7;
    L13:
        this.t = TTExecutors.getScheduledThreadPool().schedule(this.x, 0, TimeUnit.SECONDS);
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
        this.t = TTExecutors.getScheduledThreadPool().schedule(this.x, r3, TimeUnit.SECONDS);
    }

    public final void zq(View r2, int r3, int r4) {
        if (r2 == null) goto L4;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
    L5:
        if (r0 == null) goto L7;
        r0.width = r3;
    L7:
        if (r0 == null) goto L9;
        r0.height = r4;
    L9:
        if (r2 == null) goto L12;
        r2.setLayoutParams(r0);
        return;
    L12:
        return;
    L4:
        r0 = null;
        goto L5
    }
}
