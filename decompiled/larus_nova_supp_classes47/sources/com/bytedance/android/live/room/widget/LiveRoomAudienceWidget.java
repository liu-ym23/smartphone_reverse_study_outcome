package com.bytedance.android.live.room.widget;

import am2.x;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.adapter.AudienceListAdapter;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.es;
import com.bytedance.android.livesdk.config.i70;
import com.bytedance.android.livesdk.config.jd1;
import com.bytedance.android.livesdk.config.l61;
import com.bytedance.android.livesdk.config.o51;
import com.bytedance.android.livesdk.config.p7;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.performance.p;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import j40.f4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import r52.b4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/widget/LiveRoomAudienceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/live/room/api/rank/IAudienceWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/common/i;", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomAudienceWidget extends MiddlewareRoomRecyclableWidget implements IAudienceWidget, Observer<KVData>, com.bytedance.android.livesdk.common.i {
    public static final int w = 0;
    public static final int x = 0;
    public static final int y = 0;
    public final int a;
    public final int b;
    public final int c;
    public IRoom d;
    public boolean e;
    public boolean f;
    public RelativeLayout g;
    public View h;
    public StrokeTextView i;
    public NoTouchRecyclerView j;
    public ViewGroup k;
    public AudienceListAdapter l;
    public da1.c m;
    public int n;
    public com.bytedance.android.live.room.incentiveinfo.g o;
    public int p;
    public boolean q;
    public boolean r;
    public l61 s;
    public boolean t;
    public final CompositeDisposable u;
    public final e v;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveRoomAudienceWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public b(LiveRoomAudienceWidget r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void a() {
            LiveRoomAudienceWidget r0 = this.a;
            long r1 = this.b;
            String r3 = this.c;
            int r4 = LiveRoomAudienceWidget.w;
            r0.getClass();
            if (((Boolean) es.a.getValue()).booleanValue() == false) goto L13;
            com.bytedance.android.livesdk.sharedpref.e r2 = f4.w;
            Long r5 = (Long) r2.getValue();
            if (r5 == null) goto L10;
            if (r5.longValue() != 0) goto L10;
        L12:
            LiveRoomAudienceWidget.xq(Long.valueOf(r1), r3, null);
            com.bytedance.android.livesdk.sharedpref.f.d(r2, Long.valueOf(System.currentTimeMillis()));
            return;
        L10:
            if ((System.currentTimeMillis() - ((Number) r2.getValue()).longValue()) >= ((Integer) i70.a.getValue()).intValue()) goto L12;
        L13:
            ALogger.i("live_rd_client_online_user_info", "间隔时间：" + (System.currentTimeMillis() - ((Number) f4.w.getValue()).longValue()) + "  realCount = " + r1 + ' ');
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

    public static final class c implements Runnable {
        public final /* synthetic */ LiveRoomAudienceWidget a;

        public c(LiveRoomAudienceWidget r1) {
            this.a = r1;
        }

        public final void a() {
            LiveRoomAudienceWidget r0 = this.a;
            int r1 = LiveRoomAudienceWidget.w;
            r0.getClass();
            o r2 = o3.f();
            if (r2 == null) goto L12;
            m r3 = r2.I2();
            if (r3 == null) goto L13;
            Long r4 = (Long) r3.getValue();
            if (r4 == null) goto L14;
            long r5 = r4.longValue();
            if (r5 <= 0) goto L15;
            j0.l().sendLog("livesdk_rank_duration_monitor", MapsKt.mapOf(TuplesKt.to("user_time_from_enter", String.valueOf(System.currentTimeMillis() - r5))), new Object[]{Integer.TYPE, x.class});
            return;
        L15:
            return;
        L14:
            return;
        L13:
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

    public static final class d implements Runnable {
        public final /* synthetic */ LiveRoomAudienceWidget a;

        public d(LiveRoomAudienceWidget r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.isViewValid() == true) goto L5;
            return;
        L5:
            AudienceListAdapter r0 = this.a.l;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.getItemCount() != 1) goto L43;
            LiveRoomAudienceWidget r1 = this.a;
            r1.getClass();
            HashMap r2 = new HashMap();
            AudienceListAdapter r3 = r1.l;
            if (r3 == null) goto L19;
            List<x71.a> r4 = r3.f;
            if (r4 == null) goto L19;
            if (((ArrayList) r4).size() <= 0) goto L19;
            if (ListProtector.get(r3.f, 0) == null) goto L19;
            x71.a r5 = (x71.a) ListProtector.get(r3.f, 0);
        L20:
            if (r5 == null) goto L44;
            IBaseUser r6 = r5.a;
            if (r6 == null) goto L45;
            py.f r7 = r6.getBorder();
            if (r7 == null) goto L27;
            String r8 = r7.getDressId();
            if (r8 == null) goto L27;
        L28:
            String r9 = r6.getIdString();
            if (r9 != null) goto L31;
            r9 = "";
        L31:
            r2.put("to_user_id", r9);
            r2.put("wear_id", r8);
            r2.put("order", String.valueOf(1));
            r2.put("request_page", "top_single_room_rank");
            j0.l().sendLog("audience_show", r2, new Object[]{Integer.TYPE, x.class});
            if (TextUtils.equals(r6.getIdString(), k.n(IMiddlewareUserService.class).user().n()) == false) goto L46;
            LinkedHashMap r10 = new LinkedHashMap();
            py.f r12 = r6.getBorder();
            if (r12 == null) goto L38;
            String r13 = r12.getDressId();
            if (r13 == null) goto L38;
            r10.put("avatar_border_dress_id", r13);
        L38:
            r10.put("mystery_man", Integer.valueOf(r6.getMysteryMan()));
            r10.put("source", 2);
            ILiveExperienceProxyService r14 = (ILiveExperienceProxyService) k.f(ILiveExperienceProxyService.class);
            if (r14 == null) goto L47;
            r14.collectReportTask(r10);
            return;
        L47:
            return;
        L46:
            return;
        L27:
            r8 = "none";
            goto L28
        L45:
            return;
        L44:
            return;
        L19:
            r5 = null;
            goto L20
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

    public static final class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ LiveRoomAudienceWidget a;

        public e(LiveRoomAudienceWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = r4 - r2;
            LiveRoomAudienceWidget r12 = this.a;
            if (r1 != null) goto L5;
        L8:
            boolean r13 = false;
        L9:
            int r14 = LiveRoomAudienceWidget.w;
            if (r13 == false) goto L12;
            int r15 = -2;
        L13:
            UIUtils.updateLayout(r12.h, -3, r15);
            return;
        L12:
            r15 = r12.c;
            goto L13
        L5:
            if (r1.getVisibility() != 0) goto L8;
            if (r10 <= 0) goto L8;
            r13 = true;
            goto L9
        }
    }

    public static final class f extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ LiveRoomAudienceWidget c;

        public final void run() {
            LiveRoomAudienceWidget r0 = this.c;
            String r2 = null;
            if (r0.e == false) goto L49;
        L19:
            r0.Aq(r0.d);
            r0.runWithRoomEntered(new h(r0));
            IRoom r1 = r0.d;
            if (r1 == null) goto L42;
            da1.c r4 = r0.m;
            if (r4 == null) goto L42;
            IBaseUser r5 = r1.getOwner();
            if (r5 == null) goto L42;
            if ((!r4.e) == true) goto L29;
            r5 = null;
        L29:
            if (r5 == null) goto L42;
            long r8 = r1.getId();
            IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
            if (r6 == null) goto L38;
            com.bytedance.android.livesdk.user.e r7 = r6.user();
            if (r7 == null) goto L38;
            IBaseUser r9 = r7.b();
            if (r9 == null) goto L38;
            Intrinsics.checkNotNullParameter(r9, "$this$secUidExt");
            r2 = r9.getCastSecUid();
        L38:
            if (((Boolean) c1.g(Intrinsics.stringPlus(r2, Long.valueOf(r8))).getValue()).booleanValue() == false) goto L42;
            ILiveDouPlusService r10 = k.f(ILiveDouPlusService.class);
            if (r10 == null) goto L42;
            Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
            r10.getDouLiveIndicatorStatus(String.valueOf(r5.getCastSecUid()), r8, false, new da1.d(r4, r1));
        L42:
            RecyclerView r3 = r0.j;
            if (r3 == null) goto L47;
            ViewTreeObserver r12 = r3.getViewTreeObserver();
            if (r12 == null) goto L47;
            r12.addOnGlobalLayoutListener(new i(r0));
        L47:
            b(true);
            return;
        L49:
            String[] r13 = {"money", "fans", "nothing", "room_money"};     // Catch: Exception -> L17
            HashMap r14 = new HashMap();     // Catch: Exception -> L17
            IRoom r15 = r0.d;     // Catch: Exception -> L17
            if (r15 == null) goto L8;
            String r16 = r15.getOwnerUserIdString();     // Catch: Exception -> L17
            if (r16 == null) goto L8;
        L9:
            r14.put("anchor_id", r16);     // Catch: Exception -> L17
            IRoom r17 = r0.d;     // Catch: Exception -> L17
            if (r17 == null) goto L12;
            String r18 = r17.getIdStr();     // Catch: Exception -> L17
        L13:
            r14.put("room_id", String.valueOf(r18));     // Catch: Exception -> L17
            r14.put("rank_type", r13[3]);     // Catch: Exception -> L17
            IHostLog r19 = k.f(IHostLog.class);     // Catch: Exception -> L17
            if (r19 == null) goto L19;
            r19.logV3("livesdk_live_room_info", r14);     // Catch: Exception -> L17
            goto L19
        L12:
            r18 = null;
        L8:
            r16 = "";
        L17:
            e = move-exception;
            Logger.throwException(e);
            goto L19
        }

        public f(LiveRoomAudienceWidget r1) {
            this.c = r1;
            super("live_room_watch_widget_load");
        }
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a197";
    }

    public final String nc() {
        return "LiveRoomAudienceWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final int supportClearScene() {
        return 283;
    }

    static {
        w = s1.f(4.0f);
        x = s1.f(6.0f);
        y = s1.f(8.0f);
    }

    public final int getLayoutId() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_anchor", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        this.e = r2;
        this.p = (int) UIUtils.dip2Px(((Widget) this).context, 24.0f);
        return 2131566993;
    L7:
        r2 = false;
        goto L8
    }

    public final void onUnload() {
        ALogger.i("updateWatchUser LiveRoomWatchUserWidget onUnload", "");
        this.n = 0;
        this.f = false;
        StrokeTextView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setText("");
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        da1.c r2 = this.m;
        if (r2 == null) goto L11;
        r2.detachView();
    L11:
        AudienceListAdapter r3 = this.l;
        if (r3 == null) goto L14;
        ((ArrayList) r3.f).clear();
        r3.notifyDataSetChanged();
    L14:
        this.u.clear();
        com.bytedance.android.livesdk.sharedpref.e r4 = f4.v;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, 0L);
        com.bytedance.android.livesdk.sharedpref.e r5 = f4.w;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, 0L);
        RelativeLayout r6 = this.g;
        if (r6 == null) goto L19;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L19;
        r7.width = -2;
    L19:
        com.bytedance.android.live.room.incentiveinfo.g r8 = this.o;
        if (r8 == null) goto L22;
        ALogger.d("IncentiveInfoManager", "incentiveInfoManager release");
        r8.a();
        r8.a.setAdapter(null);
    L22:
        RelativeLayout r9 = this.g;
        if (r9 == null) goto L26;
        r9.removeOnLayoutChangeListener(this.v);
        return;
    }

    public final Animator startShowAnimation() {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(((Widget) this).contentView, "alpha", new float[]{0.0f, 1.0f});
        r0.setDuration(200);
        r0.start();
        return r0;
    }

    public final Boolean uk() {
        return Boolean.valueOf(this.f);
    }

    public final void yq() {
        if (this.e == false) goto L5;
        return;
    L5:
        int r0 = w;
        SettingKey r1 = LiveInfraSettingKeys.LIVE_PCU_MARGIN_CONFIG;
        if (((jd1) r1.getValue()).a() == false) goto L8;
        int r2 = s1.f(((jd1) r1.getValue()).b());
    L9:
        RelativeLayout r3 = this.g;
        if (r3 != null) goto L12;
    L18:
        UIUtils.updateLayoutMargin(this.h, r2, -3, r0, -3);
        return;
    L12:
        if (r3.getVisibility() != 8) goto L18;
        ViewGroup r4 = this.k;
        if (r4 == null) goto L18;
        if (r4.getVisibility() != 8) goto L18;
        r0 = 0;
        goto L18
    L8:
        r2 = -3;
        goto L9
    }

    public LiveRoomAudienceWidget() {
        this.a = (int) s1.I(6.0f);
        this.b = (int) s1.I(2.0f);
        this.c = s1.f(26.0f);
        this.q = true;
        this.r = true;
        this.u = new CompositeDisposable();
        this.v = new e(this);
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    public static final void wq(LiveRoomAudienceWidget r9) {
        r9.getClass();
        ALogger.i("LiveRoomAudienceWidget", "this room enableClickOnline  : " + r9.q);
        if (r9.q == true) goto L6;
        return;
    L6:
        if (UnLoginFeatureUtils.INSTANCE.disableUserListWhenUnLogin(r9.d) == false) goto L23;
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L13;
        if (r1.isLogin() == true) goto L23;
    L13:
        IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L44;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L45;
        Context r4 = ((Widget) r9).context;
        l.a r5 = new l.a();
        r5.e = "live_detail";
        r5.f = "click_live_rank";
        Observable r6 = r3.login(r4, new l(r5));
        if (r6 == null) goto L46;
        Observable r10 = r6.compose(r9.getAutoUnbindTransformer());
        if (r10 == null) goto L47;
        r10.subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L23:
        if (r9.t == true) goto L25;
    L35:
        DataCenter r7 = ((Widget) r9).dataCenter;
        if (r7 == null) goto L42;
        IRoom r8 = a0.n(r7);
        if (r8 == null) goto L42;
        ILiveExperienceProxyService r12 = (ILiveExperienceProxyService) k.f(ILiveExperienceProxyService.class);
        if (r12 == null) goto L42;
        r12.showUserDialog(-1, ((Widget) r9).context, ((Widget) r9).dataCenter, r8);
    L42:
        int r13 = com.bytedance.android.live.room.util.a.a;
        com.bytedance.android.live.room.util.a.a(r9.d);
        return;
    L25:
        if (((u) b4.a.getValue()).b() == false) goto L35;
        ALogger.i("LiveRoomAudienceWidget", "onOnlineInfoClick when startShowRtcRoomInfo is true");
        MiddlewareRoomContext r14 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) r9).dataCenter, 0, 2);
        if (r14 == null) goto L49;
        n r15 = r14.getRtcRoomInfo();
        if (r15 == null) goto L50;
        dh1.a r16 = (dh1.a) r15.getValue();
        if (r16 == null) goto L51;
        ILiveExperienceProxyService r17 = (ILiveExperienceProxyService) k.f(ILiveExperienceProxyService.class);
        if (r17 == null) goto L52;
        r17.showUserDialog(-1, ((Widget) r9).context, DataType.FALSE, r16.a, r16.b);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    }

    public final void Aq(IRoom r5) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L14;
        boolean r1 = false;
        if (r5.getRoomAuthStatus().isEnableRoomContributor() != true) goto L9;
        boolean r0 = true;
    L10:
        this.r = r0;
        ALogger.i("LiveRoomAudienceWidget", "this room enableContributor  : " + this.r);
        if (r5.getRoomAuthStatus().isEnableUpRightStatsFloatingLayer() != true) goto L13;
        r1 = true;
    L13:
        this.q = r1;
        ALogger.i("LiveRoomAudienceWidget", "this room enableClickOnline  : " + this.q);
        goto L14
    L9:
        r0 = false;
    L14:
        da1.c r2 = this.m;
        if (r2 == null) goto L27;
        Long r3 = null;
        if ((r5 instanceof Room) == true) goto L19;
        IRoom r4 = null;
    L20:
        Room r6 = (Room) r4;
        if (r6 == null) goto L23;
        RoomViewStats r7 = r6.viewStats;
    L24:
        if (r5 == null) goto L26;
        r3 = Long.valueOf(r5.getRoomId());
    L26:
        r2.k0(r7, r3);
        goto L27
    L23:
        r7 = null;
        goto L24
    L19:
        r4 = r5;
    L27:
        yq();
    }

    @Override // com.bytedance.android.live.room.api.rank.IAudienceWidget
    public final void ii(List<x71.a> r12) {
        if (isViewValid() == false) goto L76;
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L17;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L11;
        IRoom r5 = a0.n(r4);
        if (r5 == null) goto L11;
        long r6 = r5.getRoomId();
    L12:
        r r1 = r0.getRoomExpService(r4, r6);
        if (r1 == null) goto L17;
        n r2 = r1.q();
        if (r2 == null) goto L17;
        Boolean r3 = (Boolean) r2.getValue();
    L18:
        boolean r7 = true;
        if (((o51) j2.a.getValue()).disable_rank_duration_monitor == false) goto L21;
    L23:
        ArrayList r8 = (ArrayList) r12;
        boolean r9 = !r8.isEmpty();
        if (this.r == false) goto L27;
        if (r9 == false) goto L27;
    L28:
        if (r7 == false) goto L32;
        RecyclerView r10 = this.j;
        if (r10 == null) goto L35;
        r10.setVisibility(0);
    L35:
        IRoomContextService r13 = k.f(IRoomContextService.class);
        if (r13 == null) goto L48;
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L42;
        IRoom r15 = a0.n(r14);
        if (r15 == null) goto L42;
        long r16 = r15.getRoomId();
    L43:
        r r17 = r13.getRoomExpService(r14, r16);
        if (r17 == null) goto L48;
        n r18 = r17.q();
        if (r18 == null) goto L48;
        r18.setValue(Boolean.TRUE);
    L42:
        r16 = 0;
    L48:
        List r19 = r8.subList(0, RangesKt.coerceAtMost(r8.size(), 3));
        AudienceListAdapter r20 = this.l;
        if (r20 == null) goto L56;
        if (r19 == null) goto L56;
        ((ArrayList) r20.f).clear();
        if (CollectionUtils.isEmpty(r19) == true) goto L55;
        ((ArrayList) r20.f).addAll(r19);
    L55:
        ALogger.i("updateWatchUser setDataSet final", "roomId:" + ((IRoom) r20.a.get("data_room", null)).getRoomId() + " users : " + ((ArrayList) r20.f).size());
        r20.notifyDataSetChanged();
    L56:
        StringBuilder r22 = new StringBuilder("setDataSet, roomId = ");
        IRoom r23 = this.d;
        if (r23 == null) goto L59;
        long r24 = r23.getRoomId();
    L60:
        r22.append(r24);
        ALogger.d("LiveExperienceProxyService", r22.toString());
        RecyclerView r25 = this.j;
        if (r25 == null) goto L64;
        r25.post(new d(this));
    L64:
        if (((Boolean) es.a.getValue()).booleanValue() == false) goto L74;
        com.bytedance.android.livesdk.sharedpref.e r26 = f4.v;
        Long r27 = (Long) r26.getValue();
        if (r27 == null) goto L71;
        if (r27.longValue() != 0) goto L71;
    L73:
        xq(-1L, "-1", r12);
        com.bytedance.android.livesdk.sharedpref.f.d(r26, Long.valueOf(System.currentTimeMillis()));
        return;
    L71:
        if ((System.currentTimeMillis() - ((Number) r26.getValue()).longValue()) >= ((Integer) i70.a.getValue()).intValue()) goto L73;
    L74:
        ALogger.i("live_rd_client_online_user_info", "间隔时间：" + (System.currentTimeMillis() - ((Number) f4.v.getValue()).longValue()));
        return;
    L59:
        r24 = 0;
        goto L60
    L32:
        RecyclerView r28 = this.j;
        if (r28 == null) goto L35;
        r28.setVisibility(8);
    L27:
        r7 = false;
        goto L28
    L21:
        if ((!Intrinsics.areEqual(r3, Boolean.TRUE)) == false) goto L23;
        runWithRoomVisible(new c(this));
    L11:
        r6 = 0;
    L17:
        r3 = null;
        goto L18
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (isViewValid() == false) goto L55;
        boolean r0 = true;
        int r1 = 0;
        if (r8 == null) goto L14;
        String r2 = r8.getKey();
        if (r2 == null) goto L14;
        if (r2.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L14;
        return;
    L11:
        r3 = false;
    L14:
        if (r8 == null) goto L16;
        String r4 = r8.getKey();
    L17:
        if (r4 == null) goto L62;
        int r5 = r4.hashCode();
        if (r5 == 146203553) goto L48;
        if (r5 == 294674590) goto L38;
        if (r5 == 817781422) goto L27;
        return;
    L27:
        if (r4.equals("cmd_enable_room_contributor") == false) goto L56;
        if (r8 == null) goto L32;
        Boolean r9 = (Boolean) r8.getData();
        if (r9 == null) goto L32;
        r0 = r9.booleanValue();
    L32:
        this.r = r0;
        ALogger.i("LiveRoomAudienceWidget", "cmd  isShowContributor is :  " + this.r);
        RecyclerView r10 = this.j;
        if (this.r == true) goto L36;
        r1 = 8;
    L36:
        UIUtils.setViewVisibility(r10, r1);
        return;
    L56:
        return;
    L38:
        if (r4.equals("data_keyboard_status_douyin") == false) goto L58;
        if (r8 == null) goto L42;
        Boolean r12 = (Boolean) r8.getData();
        if (r12 == null) goto L42;
    L43:
        boolean r13 = r12.booleanValue();
        ViewGroup r6 = ((Widget) this).containerView;
        if (r13 == false) goto L46;
        r1 = 4;
    L46:
        UIUtils.setViewVisibility(r6, r1);
        return;
    L42:
        r12 = Boolean.FALSE;
        goto L43
    L58:
        return;
    L48:
        if (r4.equals("cmd_enable_click_online") == false) goto L60;
        if (r8 == null) goto L53;
        Boolean r14 = (Boolean) r8.getData();
        if (r14 == null) goto L53;
        r0 = r14.booleanValue();
    L53:
        this.q = r0;
        ALogger.i("LiveRoomAudienceWidget", "cmd  enableClickOnline is :  " + this.q);
        return;
    L60:
        return;
    L62:
        return;
    L16:
        r4 = null;
        goto L17
    }

    public final void onEnterClear(int r5) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L26;
        boolean r1 = true;
        if (r5 == 1) goto L24;
        if (r5 == 8) goto L24;
        if (r5 == 16) goto L24;
        if (r5 == 256) goto L24;
        p7 r2 = p.a;
        if (r2.enable == true) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == true) goto L20;
        return;
    L20:
        if (r5 == 2) goto L22;
        return;
    L22:
        if (2 == r0.getLayerType()) goto L29;
        r0.setLayerType(2, null);
        ALogger.i("ttlive_widget", "LiveRoomWatchUserWidget Set LAYER_TYPE_HARDWARE");
        return;
    L29:
        return;
    L15:
        if (r2.liveRoomWatchUserWidgetEnable == false) goto L17;
    L24:
        r0.setVisibility(8);
        return;
    }

    public final void onExitClear(int r6) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L27;
        boolean r2 = true;
        if (r6 != 1) goto L7;
    L25:
        r0.setVisibility(0);
        return;
    L7:
        if (r6 == 8) goto L25;
        if (r6 == 16) goto L25;
        if (r6 == 256) goto L25;
        p7 r3 = p.a;
        if (r3.enable == true) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == true) goto L21;
        return;
    L21:
        if (r6 == 2) goto L23;
        return;
    L23:
        if (2 != r0.getLayerType()) goto L30;
        r0.setLayerType(0, null);
        ALogger.i("ttlive_widget", "LiveRoomWatchUserWidget Set LAYER_TYPE_NONE");
        return;
    L30:
        return;
    L16:
        if (r3.liveRoomWatchUserWidgetEnable == false) goto L18;
    }

    public final void onInit(Object[] r7) {
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L5;
        View r9 = r8.findViewById(2131381482);
    L6:
        this.h = r9;
        View r10 = ((Widget) this).contentView;
        if (r10 == null) goto L9;
        RelativeLayout r12 = (RelativeLayout) r10.findViewById(2131381481);
    L10:
        this.g = r12;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L13;
        StrokeTextView r14 = (StrokeTextView) r13.findViewById(2131381480);
    L14:
        this.i = r14;
        View r15 = ((Widget) this).contentView;
        if (r15 == null) goto L17;
        NoTouchRecyclerView r16 = (NoTouchRecyclerView) r15.findViewById(2131393014);
    L18:
        this.j = r16;
        int r1 = 0;
        if (r16 == null) goto L21;
        r16.setNestedScrollingEnabled(false);
    L21:
        View r17 = ((Widget) this).contentView;
        if (r17 == null) goto L24;
        ViewGroup r18 = (ViewGroup) r17.findViewById(2131370089);
    L25:
        this.k = r18;
        View r19 = ((Widget) this).contentView;
        if (r19 == null) goto L30;
        ViewGroup r20 = (ViewGroup) r19.findViewById(2131362539);
        if (r20 == null) goto L30;
        r20.setVisibility(8);
    L30:
        this.m = new da1.c();
        AudienceListAdapter r22 = new AudienceListAdapter(((Widget) this).context, ((Widget) this).dataCenter, this.j);
        r22.setHasStableIds(true);
        r22.d = new com.bytedance.android.live.room.widget.d(this);
        Unit r4 = Unit.INSTANCE;
        this.l = r22;
        RecyclerView r23 = this.j;
        if (r23 == null) goto L33;
        r23.setItemAnimator(null);
        r23.setLayoutManager(new SSLinearLayoutManager(r23.getContext(), 0));
        r23.setAdapter(this.l);
    L33:
        UIUtils.setClickListener(true, this.g, new com.bytedance.android.live.room.widget.e(this));
        RecyclerView r24 = this.j;
        if (r24 == null) goto L36;
        r24.setVisibility(8);
    L36:
        l61 r25 = (l61) LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue();
        this.s = r25;
        if (r25 != null) goto L39;
        return;
    L39:
        if (r25.f() != true) goto L55;
        float r26 = com.bytedance.android.live.room.util.c.a;
        StrokeTextView r27 = this.i;
        if (r27 == null) goto L56;
        Paint r0 = new Paint();
        r0.setTextSize(r27.getTextSize());
    L44:
        if (r1 > 9) goto L49;
        float r28 = r0.measureText(String.valueOf(r1));
        if (r28 <= com.bytedance.android.live.room.util.c.a) goto L48;
        com.bytedance.android.live.room.util.c.a = r28;
    L48:
        r1 = r1 + 1;
        goto L44
    L49:
        com.bytedance.android.live.room.util.c.b = r0.measureText(".");
        com.bytedance.android.live.room.util.c.c = r0.measureText("+");
        com.bytedance.android.live.room.util.c.d = r0.measureText("万");
        return;
    L56:
        return;
    L55:
        return;
    L24:
        r18 = null;
        goto L25
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v2 ??, new type: androidx.recyclerview.widget.RecyclerView
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final void onLoad(java.lang.Object[] r24) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0310: CONST (r13v9 ?? I:??[boolean, int, float, short, byte, char]) = (1 ??[boolean, int, float, short, byte, char]) A[DECLARE_VAR] (LINE:16778000) in method: com.bytedance.android.live.room.widget.LiveRoomAudienceWidget.onLoad(java.lang.Object[]):void, file: /private/tmp/nixiang/classes47.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.live.room.widget.LiveRoomAudienceWidget.onLoad(java.lang.Object[]):void");
    }

    public final void qo(Boolean r1) {
        if (r1 == null) goto L4;
        boolean r2 = r1.booleanValue();
    L5:
        this.f = r2;
        return;
    L4:
        r2 = false;
        goto L5
    }

    public final void zq(int r12, String r13) {
        if (this.e == false) goto L11;
        StrokeTextView r14 = this.i;
        if (r14 != null) goto L7;
        return;
    L7:
        if (r12 >= 100000) goto L9;
        r14.setMinWidth(s1.j(2131169111));
        r14.setPadding(0, 0, 0, 0);
        return;
    L9:
        r14.setMinWidth(0);
        int r15 = y;
        r14.setPadding(r15, 0, r15, 0);
        return;
    L11:
        if (ev1.p.b(((Widget) this).dataCenter) == false) goto L13;
        int r0 = this.c;
    L14:
        l61 r3 = this.s;
        if (r3 != null) goto L17;
    L55:
        if (r12 >= 100) goto L57;
        int r16 = s1.j(2131169112);
    L58:
        if (r12 >= 100) goto L60;
        int r17 = 0;
    L61:
        StrokeTextView r1 = this.i;
        if (r1 != null) goto L64;
        return;
    L64:
        if (r1.getMinWidth() == r16) goto L67;
        r1.setMinWidth(r16);
    L67:
        if (r1.getPaddingLeft() == r17) goto L69;
    L70:
        r1.setPadding(r17, 0, r17, 0);
        return;
    L69:
        if (r1.getPaddingRight() != r17) goto L70;
        return;
    L60:
        r17 = x;
        goto L61
    L57:
        r16 = 0;
        goto L58
    L17:
        if (r3.f() != true) goto L55;
        float r2 = com.bytedance.android.live.room.util.c.a;
        if (r13 != null) goto L21;
        int r18 = 0;
    L38:
        if (r12 >= 100) goto L40;
        int r4 = 0;
    L41:
        int r19 = Math.max(r18 + r4, r0);
        if (r12 >= 100) goto L44;
        int r110 = 0;
    L45:
        StrokeTextView r5 = this.i;
        if (r5 != null) goto L48;
        return;
    L48:
        if (r5.getWidth() == r19) goto L51;
        r5.setWidth(r19);
    L51:
        if (r5.getPaddingLeft() == r110) goto L53;
    L54:
        r5.setPadding(r110, 0, r110, 0);
        return;
    L53:
        if (r5.getPaddingRight() != r110) goto L54;
        return;
    L44:
        r110 = this.b;
        goto L45
    L40:
        r4 = this.a * 2;
        goto L41
    L21:
        char[] r111 = r13.toCharArray();
        int r6 = r111.length;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r20 = 0;
    L22:
        if (r7 >= r6) goto L37;
        char r22 = r111[r7];
        if (r22 != '+') goto L27;
        r10 = r10 + 1;
    L36:
        r7 = r7 + 1;
        goto L22
    L27:
        if (r22 != '.') goto L30;
        r9 = r9 + 1;
        goto L36
    L30:
        if ('0' <= r22) goto L33;
    L35:
        r20 = r20 + 1;
        goto L36
    L33:
        if ('9' < r22) goto L35;
        r8 = r8 + 1;
        goto L36
    L37:
        r18 = (int) ((((r8 * com.bytedance.android.live.room.util.c.a) + (r9 * com.bytedance.android.live.room.util.c.b)) + (r10 * com.bytedance.android.live.room.util.c.c)) + (r20 * com.bytedance.android.live.room.util.c.d));
        goto L38
    L13:
        r0 = s1.j(2131169112);
        goto L14
    }

    public static void xq(Long r12, String r13, List r14) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L57
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L57
        if (r14 == null) goto L40;
        List r15 = CollectionsKt.take(r14, 3);     // Catch: Throwable -> L57
        if (r15 == null) goto L40;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L57
    L9:
        if (r16.hasNext() == false) goto L40;
        x71.a r5 = (x71.a) r16.next();     // Catch: Throwable -> L57
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L57
        IBaseUser r8 = r5.a;     // Catch: Throwable -> L57
        String r9 = null;
        if (r8 == null) goto L19;
        py.f r10 = r8.getBorder();     // Catch: Throwable -> L57
        if (r10 == null) goto L19;
        py.k r17 = r10.getIcon();     // Catch: Throwable -> L57
        if (r17 == null) goto L19;
        List r18 = r17.getUrls();     // Catch: Throwable -> L57
        if (r18 == null) goto L19;
        String r19 = (String) ListProtector.get(r18, 0);     // Catch: Throwable -> L57
    L20:
        r6.put("avatar_border_url", r19);     // Catch: Throwable -> L57
        IBaseUser r20 = r5.a;     // Catch: Throwable -> L57
        if (r20 == null) goto L27;
        py.k r22 = r20.getAvatarThumbKt();     // Catch: Throwable -> L57
        if (r22 == null) goto L27;
        List r23 = r22.getUrls();     // Catch: Throwable -> L57
        if (r23 == null) goto L27;
        r9 = (String) ListProtector.get(r23, 0);     // Catch: Throwable -> L57
    L27:
        r6.put("avatar_url", r9);     // Catch: Throwable -> L57
        IBaseUser r24 = r5.a;     // Catch: Throwable -> L57
        String r25 = "";
        if (r24 == null) goto L32;
        String r26 = r24.getIdString();     // Catch: Throwable -> L57
        if (r26 == null) goto L32;
    L33:
        r6.put("user_id", r26);     // Catch: Throwable -> L57
        IBaseUser r7 = r5.a;     // Catch: Throwable -> L57
        if (r7 == null) goto L39;
        String r27 = r7.getWebcastUid();     // Catch: Throwable -> L57
        if (r27 == null) goto L39;
        r25 = r27;
    L39:
        r6.put("webcast_id", r25);     // Catch: Throwable -> L57
        r3.put(r6);     // Catch: Throwable -> L57
    L32:
        r26 = "";
    L19:
        r19 = null;
    L40:
        j0 r110 = j0.l();     // Catch: Throwable -> L57
        Pair[] r4 = new Pair[3];     // Catch: Throwable -> L57
        long r28 = -1;
        if (r12 == null) goto L43;
        long r29 = r12.longValue();     // Catch: Throwable -> L57
    L44:
        r4[0] = TuplesKt.to("audience_count_num", String.valueOf(r29));     // Catch: Throwable -> L57
        if (r13 != null) goto L48;
        String r30 = "-1";
    L49:
        r4[1] = TuplesKt.to("audience_count_str", r30);     // Catch: Throwable -> L57
        r4[2] = TuplesKt.to("user_list", r3.toString());     // Catch: Throwable -> L57
        r110.sendLog("live_rd_client_online_user_info", MapsKt.mapOf(r4), new Object[]{Integer.TYPE, x.class});     // Catch: Throwable -> L57
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L57
        r111.append("audience_count_num : ");     // Catch: Throwable -> L57
        if (r12 == null) goto L52;
        r28 = r12.longValue();     // Catch: Throwable -> L57
    L52:
        r111.append(String.valueOf(r28));     // Catch: Throwable -> L57
        r111.append(' ');     // Catch: Throwable -> L57
        r111.append("___ audience_count_str ");     // Catch: Throwable -> L57
        if (r13 != null) goto L55;
        r13 = "-1";
    L55:
        r111.append(r13);     // Catch: Throwable -> L57
        r111.append(" ___ ");     // Catch: Throwable -> L57
        r111.append("user_list");     // Catch: Throwable -> L57
        r111.append(r3.toString());     // Catch: Throwable -> L57
        ALogger.i("live_rd_client_online_user_info", r111.toString());     // Catch: Throwable -> L57
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
        return;
    L48:
        r30 = r13;
        goto L49
    L43:
        r29 = -1;
    L57:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.live.room.api.rank.IAudienceWidget
    public final void sn(boolean r4, long r5, String r7, String r8) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        ALogger.i("LiveRoomAudienceWidget", "onNewUserCountAdapter  isHidden : " + r4 + "  realCount :  " + r5 + " middleStr :  " + r7);
        this.n = (int) r5;
        if (r4 == false) goto L8;
    L55:
        UIUtils.setViewVisibility(this.i, 8);
        UIUtils.setViewVisibility(this.g, 8);
    L56:
        runWithRoomVisible(new b(this, r5, r7));
        return;
    L8:
        if (r7 != null) goto L10;
    L15:
        UIUtils.setViewVisibility(this.i, 0);
        UIUtils.setViewVisibility(this.g, 0);
        IRoom r0 = this.d;
        CharSequence r2 = null;
        if ((r0 instanceof Room) == true) goto L18;
        r0 = null;
    L18:
        Room r1 = (Room) r0;
        if (r1 == null) goto L23;
        RoomViewStats r3 = r1.viewStats;
        if (r3 == null) goto L23;
        r3.setDisplayMiddle(r7);
        r3.setDisplayLong(r8);
    L23:
        RelativeLayout r6 = this.g;
        if (r6 == null) goto L26;
        r6.setBackground(s1.m(2131249911));
    L26:
        if (r7 != null) goto L28;
    L30:
        l61 r9 = this.s;
        if (r9 != null) goto L33;
    L43:
        StrokeTextView r10 = this.i;
        if (r10 == null) goto L46;
        r10.setText(r7);
    L46:
        zq(this.n, r7);
    L47:
        r3.c(this.i, r8, true);
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L56;
        r12.put("data_member_count_str", r8);
        r12.put("data_room_pcu", Long.valueOf(r5));
        int r13 = com.bytedance.android.live.room.util.b.a;
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        w71.a r14 = z51.a.b(r12);
        if (r14 == null) goto L52;
        r14.updateRoomDynamicMemberCount(r5);
    L52:
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        w71.a r15 = z51.a.b(r12);
        if (r15 == null) goto L56;
        r15.setShareCountText(r8);
        goto L56
    L33:
        if (r9.f() != true) goto L43;
        StrokeTextView r16 = this.i;
        if (r16 == null) goto L38;
        r2 = r16.getText();
    L38:
        if ((!Intrinsics.areEqual(r7, String.valueOf(r2))) == false) goto L47;
        StrokeTextView r17 = this.i;
        if (r17 == null) goto L42;
        r17.setText(r7);
    L42:
        zq(this.n, r7);
        goto L47
    L28:
        if (StringsKt.isBlank(r7) != true) goto L30;
    L10:
        if (r7.length() != 0) goto L12;
        boolean r18 = true;
    L13:
        if (r18 != true) goto L15;
    L12:
        r18 = false;
        goto L13
    }
}
