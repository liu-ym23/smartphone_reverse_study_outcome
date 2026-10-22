package com.bytedance.android.livesdk.drawer.relax;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.LocationResult;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.config.bc1;
import com.bytedance.android.livesdk.config.dp;
import com.bytedance.android.livesdk.config.ep;
import com.bytedance.android.livesdk.config.fp;
import com.bytedance.android.livesdk.config.jp;
import com.bytedance.android.livesdk.config.mp;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.k4;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.android.livesdkapi.recommend.IRecommendController;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.relax.RelaxView;
import com.relax.relaxframework.RelaxPage;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j40.b4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerRelaxDialog;", "Lcom/bytedance/android/live/core/widget/BaseDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerRelaxDialog extends BaseDialogFragment {
    public d03.b<com.bytedance.android.livesdk.drawer.relax.c> d;
    public Room e;
    public DataCenter f;
    public View g;
    public View h;
    public View i;
    public LiveDrawerLayout j;
    public ViewGroup k;
    public View l;
    public FrameLayout m;
    public boolean n;
    public int o;
    public boolean p;
    public f q;
    public Disposable r;
    public Disposable s;
    public Disposable t;
    public final LiveDrawerRelaxDialog$mDrawerListener$1 u;
    public final b v;

    public static final class a {
    }

    public static final class b implements ILiveDrawerLayoutInterceptor {
        public float a;
        public final List<View> b;
        public final /* synthetic */ LiveDrawerRelaxDialog c;

        public b(LiveDrawerRelaxDialog r1) {
            this.c = r1;
            this.b = new ArrayList();
        }

        public final boolean onInterceptTouchEvent(MotionEvent r7) {
            if (r7 != null) goto L35;
            return false;
        L35:
            float r2 = r7.getRawX();     // Catch: IllegalArgumentException -> L32
            float r3 = r7.getRawY();     // Catch: IllegalArgumentException -> L32
            int r8 = r7.getAction();     // Catch: IllegalArgumentException -> L32
            RelaxView r4 = null;
            if (r8 != 0) goto L9;
            this.a = r2;     // Catch: IllegalArgumentException -> L32
            ((ArrayList) this.b).clear();     // Catch: IllegalArgumentException -> L32
            d03.b<com.bytedance.android.livesdk.drawer.relax.c> r9 = this.c.d;     // Catch: IllegalArgumentException -> L32
            if (r9 == null) goto L30;
            r4 = r9.b();     // Catch: IllegalArgumentException -> L32
        L30:
            a(r4, (int) r2, (int) r3, this.b);     // Catch: IllegalArgumentException -> L32
        L34:
            return true;
        L9:
            if (r8 != 2) goto L34;
            d03.b<com.bytedance.android.livesdk.drawer.relax.c> r10 = this.c.d;     // Catch: IllegalArgumentException -> L32
            if (r10 == null) goto L15;
            r4 = r10.b();     // Catch: IllegalArgumentException -> L32
        L15:
            if (b(r4, (int) r2, (int) r3) == true) goto L18;
            return false;
        L18:
            if (r2 >= this.a) goto L20;
            return true;
        L20:
            Iterator r11 = ((ArrayList) this.b).iterator();     // Catch: IllegalArgumentException -> L32
        L22:
            if (r11.hasNext() == false) goto L26;
            if (((View) r11.next()).canScrollHorizontally(-1) == false) goto L22;
            return true;
        L26:
            return false;
        L32:
            e = move-exception;
            e.printStackTrace();
            goto L34
        }

        public final boolean b(View r6, int r7, int r8) {
            if (r6 != null) goto L5;
            return false;
        L5:
            int[] r1 = new int[2];
            r6.getLocationOnScreen(r1);
            int r2 = r1[0];
            int r3 = r1[1];
            int r4 = r6.getMeasuredWidth() + r2;
            int r9 = r6.getMeasuredHeight() + r3;
            if (r3 > r8) goto L16;
            if (r9 < r8) goto L13;
            if (r7 < r2) goto L14;
            if (r7 > r4) goto L15;
            return true;
        L15:
            return false;
        L14:
            return false;
        L13:
            return false;
        L16:
            return false;
        }

        public final void a(View r4, int r5, int r6, List<View> r7) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (b(r4, r5, r6) == false) goto L14;
            ArrayList r8 = (ArrayList) r7;
            r8.add(r4);
            if ((r4 instanceof ViewGroup) == false) goto L13;
            ViewGroup r9 = (ViewGroup) r4;
            int r0 = r9.getChildCount();
            int r1 = 0;
        L9:
            if (r1 >= r0) goto L15;
            a(r9.getChildAt(r1), r5, r6, r8);
            r1 = r1 + 1;
            goto L9
        L15:
            return;
        L13:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveDrawerRelaxDialog a;

        public c(LiveDrawerRelaxDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.V90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerRelaxDialog a;

        public d(LiveDrawerRelaxDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.V90();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LiveDrawerRelaxDialog a;

        public e(LiveDrawerRelaxDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.V90();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.LiveDrawerRelaxDialog$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements Runnable {
        public final /* synthetic */ LiveDrawerRelaxDialog a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.LiveDrawerRelaxDialog$onViewCreated$4$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ AnonymousClass4 a;

            public a(AnonymousClass4 r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                UserEvent r4 = (UserEvent) r3;
                d03.b<com.bytedance.android.livesdk.drawer.relax.c> r5 = this.a.a.d;
                if (r5 == null) goto L8;
                RelaxPage r6 = r5.a;
                if (r6 == null) goto L9;
                r6.b("userLogin", Boolean.TRUE);
                return;
            L9:
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.LiveDrawerRelaxDialog$onViewCreated$4$b */
        public static final class b<T> implements Consumer {
            public final /* synthetic */ AnonymousClass4 a;

            public b(AnonymousClass4 r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                FollowPair r5 = (FollowPair) r4;
                LinkedHashMap r0 = new LinkedHashMap();
                r0.put("type", "follow");
                r0.put("user_id", r5.getUserIdString());
                String r1 = r5.getSecUserId();
                if (r1 != null) goto L6;
                r1 = null;
            L6:
                r0.put("sec_user_id", r1);
                r0.put("follow_status", Integer.valueOf(r5.getFollowStatus()));
                d03.b<com.bytedance.android.livesdk.drawer.relax.c> r6 = this.a.a.d;
                if (r6 == null) goto L12;
                RelaxPage r7 = r6.a;
                if (r7 == null) goto L13;
                r7.b("userStatusChange", r0);
                return;
            L13:
                return;
            }
        }

        public AnonymousClass4(LiveDrawerRelaxDialog r1) {
            this.a = r1;
        }

        public final void a() {
            LiveDrawerLayout r1 = this.a.j;
            if (r1 == null) goto L6;
            r1.openDrawer(8388613);
        L6:
            if (this.a.getContext() == null) goto L167;
            LiveDrawerRelaxDialog r2 = this.a;
            LiveDrawerLayout r3 = r2.j;
            if (r3 == null) goto L10;
            r3.setDrawerLayoutInterceptor(r2.v);
        L10:
            LiveDrawerRelaxDialog r4 = this.a;
            Disposable r5 = null;
            if (r4.d != null) goto L126;
            r4.q = new f(new LiveDrawerRelaxDialog$onViewCreated$4$$special$$inlined$let$lambda$1(this), LiveDrawerRelaxDialog$onViewCreated$4$1$1.INSTANCE);
            Bundle r6 = this.a.getArguments();
            if (r6 == null) goto L15;
            boolean r12 = r6.getBoolean("switch_follow");
        L16:
            ILiveService r7 = TTLiveService.getLiveService();
            if (r7 == null) goto L19;
            ILiveOntologyInfoManager r8 = r7.getLiveOntologyRecord();
        L20:
            IHostService r9 = TTLiveSDK.hostService();
            if (r9 == null) goto L25;
            IHostContext r10 = r9.appContext();
            if (r10 == null) goto L25;
            LocationResult r11 = r10.getNearByLocation();
        L26:
            ArrayList r13 = new ArrayList();
            IHostFeed r14 = jc1.k.f(IHostFeed.class);     // Catch: Throwable -> L34
            if (r14 == null) goto L33;
            List r15 = r14.getNewDrawerTabList();     // Catch: Throwable -> L34
            if (r15 == null) goto L33;
            ArrayList r27 = new ArrayList(r15);     // Catch: Throwable -> L34
        L163:
        L36:
            if (r8 == null) goto L39;
            String r16 = r8.getEnterFromMerge();
            if (r16 == null) goto L39;
        L40:
            if (r8 == null) goto L43;
            String r17 = r8.getEnterFromMerge();
            if (r17 == null) goto L43;
        L45:
            if (r8 == null) goto L48;
            String r18 = r8.getEnterMethod();
            if (r18 == null) goto L48;
        L49:
            if (r8 == null) goto L52;
            String r19 = r8.getEnterMethod();
            if (r19 == null) goto L52;
        L53:
            if (r8 == null) goto L55;
            boolean r110 = r8.isFromMatchRoom();
        L56:
            IRecommendController r20 = jc1.k.f(IRecommendController.class);
            if (r20 != null) goto L59;
        L61:
            boolean r111 = false;
        L62:
            PadConfigUtils.c();
            boolean r112 = e5.n();
            com.bytedance.android.livesdk.chatroom.c0 r21 = com.bytedance.android.livesdk.chatroom.c0.b();
            Room r22 = this.a.e;
            r21.getClass();
            boolean r113 = com.bytedance.android.livesdk.chatroom.c0.e(r22);
            if (r11 == null) goto L68;
            String r23 = r11.cityCode;
            if (r23 == null) goto L68;
            String r114 = r23;
        L69:
            if (r11 == null) goto L74;
            String r24 = r11.city;
            if (r24 == null) goto L74;
            String r115 = r24;
        L75:
            IHostService r25 = TTLiveSDK.hostService();
            if (r25 == null) goto L83;
            IHostContext r26 = r25.appContext();
            if (r26 == null) goto L83;
            String r28 = r26.getNearbyCityCode();
            if (r28 == null) goto L83;
            String r116 = r28;
        L84:
            String r117 = com.bytedance.android.livesdk.log.a0.a();
            String r29 = com.bytedance.android.livesdk.log.c0.a();
            LiveDrawerRelaxDialog r30 = this.a;
            Room r31 = r30.e;
            if (r31 == null) goto L87;
            VerticalTypeInfo r210 = r31.mVerticalTypeInfo;
        L88:
            Bundle r32 = r30.getArguments();
            if (r32 == null) goto L91;
            int r211 = r32.getInt("insert_room_reason");
        L92:
            Bundle r33 = this.a.getArguments();
            if (r33 == null) goto L95;
            long r34 = r33.getLong("default_tab_type");
        L96:
            long r212 = r34;
            Bundle r35 = this.a.getArguments();
            if (r35 == null) goto L99;
            String r213 = r35.getString("cover_content_category");
        L100:
            RoomContext r36 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r36 == null) goto L103;
            boolean r214 = r36.isVSSpecialDrawer();
        L104:
            com.bytedance.android.livesdk.drawer.relax.d r215 = new com.bytedance.android.livesdk.drawer.relax.d(r16, r17, r18, r19, r110, r12, r111, r112, r113, r114, r115, r116, r117, r29, r210, r214, r211, r212, r213);
            ng2.c r37 = bc1.a.getValue();
            ArrayList r38 = new ArrayList(dp.a.getValue());
            ArrayList r39 = new ArrayList(ep.a.getValue());
            mp r40 = mp.a;
            if (r40.getValue() == null) goto L107;
            ArrayList r310 = new ArrayList(r40.getValue());
        L108:
            j0 r118 = new j0(r37, r38, r39, r310, new ArrayList(jp.a.getValue()));
            Context r119 = this.a.getContext();
            f r41 = this.a.q;
            JsonElement r42 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), this.a.e);
            if ((r42 instanceof JsonObject) == true) goto L111;
            r42 = null;
        L111:
            JsonObject r43 = (JsonObject) r42;
            if (r43 == null) goto L124;
            IHostBusiness r44 = jc1.k.f(IHostBusiness.class);
            if (r44 == null) goto L117;
            String r45 = r44.getDesktopParams();
            if (r45 == null) goto L117;
        L118:
            r43.addProperty("launch_method", r45);
            Unit r46 = Unit.INSTANCE;
            GsonMap r47 = UtilsKt.i(r43);
            LinkedHashMap r48 = new LinkedHashMap(MapsKt.mapCapacity(r47.size()));
            Iterator r49 = r47.b().iterator();
        L120:
            if (r49.hasNext() == false) goto L122;
            Map.Entry r50 = (Map.Entry) r49.next();
            Object r51 = r50.getKey();
            Object r52 = r50.getValue();
            Intrinsics.checkNotNull(r52);
            r48.put(r51, r52);
            goto L120
        L122:
            Map r53 = MapsKt.toMutableMap(r48);
            if (r53 == null) goto L124;
        L125:
            com.bytedance.android.livesdk.drawer.relax.c r54 = new com.bytedance.android.livesdk.drawer.relax.c(r27, r215, r118, r119, r41, r53);
        L127:
            LiveDrawerRelaxDialog r55 = this.a;
            d03.b<com.bytedance.android.livesdk.drawer.relax.c> r56 = r55.d;
            if (r56 != null) goto L148;
            int r57 = d03.c.a;
            Context r58 = r55.requireContext();
            Intrinsics.checkNotNull(r54);
            Intrinsics.checkNotNullParameter(r58, "context");
            r55.d = new d03.b(r58, r54, false, 4);
            LiveDrawerRelaxDialog r59 = this.a;
            d03.b<com.bytedance.android.livesdk.drawer.relax.c> r60 = r59.d;
            if (r60 == null) goto L132;
            r60.c(EntryKt.a, r59.m, null);
        L132:
            LiveDrawerRelaxDialog r61 = this.a;
            IUserService r62 = jc1.k.f(IUserService.class);
            if (r62 == null) goto L139;
            com.bytedance.android.livesdk.user.f r63 = r62.user();
            if (r63 == null) goto L139;
            Flowable r64 = r63.m();
            if (r64 == null) goto L139;
            Disposable r65 = r64.subscribe(new a(this));
        L140:
            r61.r = r65;
            LiveDrawerRelaxDialog r66 = this.a;
            IUserService r67 = jc1.k.f(IUserService.class);
            if (r67 == null) goto L147;
            com.bytedance.android.livesdk.user.f r68 = r67.user();
            if (r68 == null) goto L147;
            Observable r69 = r68.followStateChanged();
            if (r69 == null) goto L147;
            r5 = r69.subscribe(new b(this));
        L147:
            r66.s = r5;
            return;
        L139:
            r65 = null;
            goto L140
        L148:
            RelaxView r70 = r56.b();
            if (r70 == null) goto L151;
            ViewParent r71 = r70.getParent();
        L152:
            if (r71 == null) goto L156;
            FrameLayout r72 = this.a.m;
            if (r72 == null) goto L156;
            r72.removeAllViews();
        L156:
            LiveDrawerRelaxDialog r73 = this.a;
            FrameLayout r75 = r73.m;
            if (r75 == null) goto L169;
            d03.b<com.bytedance.android.livesdk.drawer.relax.c> r76 = r73.d;
            if (r76 == null) goto L161;
            r5 = r76.b();
        L161:
            r75.addView(r5, new RelativeLayout.LayoutParams(-1, -1));
            return;
        L169:
            return;
        L151:
            r71 = null;
        L117:
            r45 = "others";
        L124:
            r53 = new LinkedHashMap();
            goto L125
        L107:
            r310 = new ArrayList();
            goto L108
        L103:
            r214 = false;
            goto L104
        L99:
            r213 = null;
            goto L100
        L95:
            r34 = -1;
            goto L96
        L91:
            r211 = -1;
            goto L92
        L87:
            r210 = null;
        L83:
            r116 = "";
        L74:
            r115 = "";
        L68:
            r114 = "";
            goto L69
        L59:
            if (r20.getNeedPersonalRecommend() == false) goto L61;
            r111 = true;
            goto L62
        L55:
            r110 = false;
        L52:
            r19 = "drawer_cover";
        L48:
            r18 = "drawer_cover";
        L43:
            r17 = "drawer_null";
        L39:
            r16 = "drawer_null";
        L33:
            r27 = new ArrayList();     // Catch: Throwable -> L34
        L34:
            com.bytedance.android.livesdk.log.b0.o().getClass();
            com.bytedance.android.live.core.log.g.i("LiveDrawerRelaxDialog", "tabList get error ");
            r27 = r13;
        L25:
            r11 = null;
            goto L26
        L19:
            r8 = null;
            goto L20
        L15:
            r12 = false;
            goto L16
        L126:
            r54 = null;
            goto L127
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

    public final void V90() {
        DrawerLayout r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L17;
        r0.closeDrawer(8388613);
        return;
    L17:
        return;
    L7:
        if (r0.isDrawerOpen(8388613) == false) goto L9;
        r1 = true;
        goto L10
    }

    public final boolean onBackPressed() {
        DrawerLayout r0 = this.j;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
        return false;
    L7:
        if (r0.isDrawerOpen(8388613) == false) goto L13;
        r0.closeDrawer(8388613);
        return true;
    L13:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.drawer.relax.LiveDrawerRelaxDialog$mDrawerListener$1] */
    public LiveDrawerRelaxDialog() {
        this.o = -1;
        this.p = true;
        this.u = new LiveDrawerRelaxDialog$mDrawerListener$1(this);
        this.v = new b(this);
    }

    public final void U90() {
        if (b4.a() == false) goto L8;
        if (k4.e(getActivity()) == false) goto L8;
        float r0 = 24.0f;
    L12:
        if (W90() == true) goto L14;
    L16:
        float r1 = UIUtils.getScreenWidth(getContext()) - UIUtils.dip2Px(getContext(), r0);
    L17:
        ViewGroup r2 = this.k;
        if (r2 == null) goto L20;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L21:
        if (r3 == null) goto L23;
        r3.width = (int) r1;
    L23:
        ViewGroup r4 = this.k;
        if (r4 == null) goto L27;
        r4.setLayoutParams(r3);
        return;
    L27:
        return;
    L20:
        r3 = null;
        goto L21
    L14:
        if (this.o != 0) goto L16;
        r1 = (UIUtils.getScreenWidth(getContext()) - UIUtils.dip2Px(getContext(), r0)) / 2;
    L8:
        if (PadConfigUtils.c() == false) goto L10;
        r0 = s1.G(s1.y()) - 378.0f;
        goto L12
    L10:
        r0 = 12.0f;
        goto L12
    }

    public final boolean W90() {
        if (FoldScreenUtils.f() == true) goto L5;
        return false;
    L5:
        Iterator<? extends String> r0 = fp.a.getValue().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r0.next(), FoldScreenUtils.d()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.r;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.r = null;
        Disposable r1 = this.s;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.s = null;
        Disposable r2 = this.t;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.t = null;
        d03.b<com.bytedance.android.livesdk.drawer.relax.c> r3 = this.d;
        if (r3 == null) goto L17;
        RelaxPage r4 = r3.a;
        if (r4 == null) goto L16;
        r4.a();
    L16:
        r3.b = null;
        Logger.d("relax container", "destroy");
    L17:
        f r5 = this.q;
        if (r5 == null) goto L20;
        r5.a = null;
    L20:
        this.q = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FrameLayout r0 = this.m;
        if (r0 == null) goto L6;
        r0.removeAllViews();
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.p == false) goto L5;
        this.p = false;
        return;
    L5:
        f r0 = this.q;
        if (r0 == null) goto L12;
        Function1<? super Boolean, Unit> r1 = r0.a;
        if (r1 == null) goto L13;
        Unit r2 = (Unit) r1.invoke(Boolean.TRUE);
        return;
    L13:
        return;
    }

    public final void onActivityCreated(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r10);
        Dialog r11 = getDialog();
        if (r11 == null) goto L5;
        Window r12 = r11.getWindow();
    L7:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L9;
    L28:
        if (r12 == null) goto L37;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r12.addFlags(Integer.MIN_VALUE);
        r12.setNavigationBarColor(-16777216);
        r12.setLayout(-1, -1);
        if (getActivity() != null) goto L32;
        return;
    L32:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getActivity(), true, false) == false) goto L39;
        r12.clearFlags(1024);
        return;
    L39:
        return;
    L37:
        return;
    L9:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L28;
        if (r12 == null) goto L12;
        r12.clearFlags(1024);
    L12:
        if (r12 == null) goto L20;
        View r0 = r12.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r6 = ThreadMethodProxy.currentThread();
        if (r6 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r6, "getDecorView");
    L18:
        if (r0 == null) goto L20;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r0.setSystemUiVisibility(1024);
    L20:
        if (r12 == null) goto L22;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r12.addFlags(Integer.MIN_VALUE);
    L22:
        if (r12 == null) goto L24;
        r12.setStatusBarColor(0);
    L24:
        if (r12 == null) goto L26;
        r12.setNavigationBarColor(-16777216);
    L26:
        if (r12 == null) goto L35;
        r12.setLayout(-1, -1);
        return;
    L35:
        return;
    L5:
        r12 = null;
        goto L7
    }

    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r5);
        if (b4.a() == false) goto L10;
        if (this.n == k4.e(getContext())) goto L10;
        View r0 = this.g;
        if (r0 == null) goto L10;
        r0.post(new c(this));
    L10:
        if (FoldScreenUtils.f() == false) goto L26;
        int r6 = FoldScreenUtils.c(r5);
        if (r6 == this.o) goto L16;
        com.bytedance.android.livesdk.log.b0 r1 = com.bytedance.android.livesdk.log.b0.o();
        String r2 = "onConfigurationChanged: oldFoldScreenType: " + this.o + " newFoldScreenType: " + r6;
        r1.getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerRelaxDialog", r2);
        this.o = r6;
        if (W90() == false) goto L26;
        U90();
        goto L26
    L16:
        ViewGroup r7 = this.k;
        if (r7 == null) goto L26;
        if (ViewCompat.isAttachedToWindow(r7) == false) goto L26;
        if (r7.getWidth() <= UIUtils.getScreenWidth(getContext())) goto L26;
        if (W90() == false) goto L26;
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerRelaxDialog", "onConfigurationChanged: enter workaround");
        U90();
    L26:
        if (PadConfigUtils.a() == false) goto L29;
        U90();
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(0, 2131954391);
        if (PadConfigUtils.c() == false) goto L5;
        this.n = k4.e(getContext());
    L5:
        DataCenter r4 = this.f;
        Room r0 = null;
        if (r4 == null) goto L8;
        r0 = (Room) r4.get("data_room", null);
    L8:
        this.e = r0;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        if (FoldScreenUtils.f() == false) goto L5;
        this.o = FoldScreenUtils.a();
        com.bytedance.android.livesdk.log.b0 r6 = com.bytedance.android.livesdk.log.b0.o();
        String r7 = "current foldType is " + this.o;
        r6.getClass();
        com.bytedance.android.live.core.log.g.i("LiveDrawerDialog", r7);
    L5:
        View r8 = this.g;
        FrameLayout r9 = null;
        if (r8 == null) goto L8;
        View r10 = r8.findViewById(2131384208);
    L9:
        this.h = r10;
        View r11 = this.g;
        if (r11 == null) goto L12;
        View r12 = r11.findViewById(2131384212);
    L13:
        this.i = r12;
        View r13 = this.g;
        if (r13 == null) goto L16;
        LiveDrawerLayout r14 = (LiveDrawerLayout) r13.findViewById(2131384210);
    L17:
        this.j = r14;
        if (r14 == null) goto L20;
        r14.addDrawerListener(this.u);
    L20:
        List r15 = LiveDrawerHelper.a;
        if (r15 == null) goto L28;
        Iterator r16 = ((ArrayList) r15).iterator();
    L24:
        if (r16.hasNext() == false) goto L28;
        DrawerLayout.DrawerListener r0 = (DrawerLayout.DrawerListener) r16.next();
        LiveDrawerLayout r1 = this.j;
        if (r1 == null) goto L24;
        r1.addDrawerListener(r0);
    L28:
        View r17 = this.g;
        if (r17 == null) goto L31;
        ViewGroup r18 = (ViewGroup) r17.findViewById(2131384214);
    L32:
        this.k = r18;
        View r19 = this.g;
        if (r19 == null) goto L35;
        View r20 = r19.findViewById(2131384211);
    L36:
        this.l = r20;
        View r21 = this.g;
        if (r21 == null) goto L39;
        FrameLayout r22 = (FrameLayout) r21.findViewById(2131384209);
    L40:
        this.m = r22;
        LiveDrawerLayout r23 = this.j;
        if (r23 == null) goto L43;
        r23.setScrimColor(0);
    L43:
        View r24 = this.g;
        if (r24 == null) goto L46;
        r9 = (FrameLayout) r24.findViewById(2131381854);
    L46:
        if (r9 == null) goto L49;
        r9.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
    L49:
        if (PadConfigUtils.c() == false) goto L56;
        if (r9 == null) goto L52;
        r9.setBackgroundResource(2131249411);
    L52:
        ViewGroup r25 = this.k;
        if (r25 == null) goto L56;
        r25.setPadding(0, s1.f(20.0f), s1.f(20.0f), s1.f(20.0f));
    L56:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L58;
    L62:
        U90();
        View r26 = this.h;
        if (r26 == null) goto L65;
        r26.setOnClickListener(new d(this));
    L65:
        View r27 = this.i;
        if (r27 == null) goto L68;
        r27.setOnClickListener(new e(this));
    L68:
        DrawerLayout r28 = this.j;
        if (r28 == null) goto L77;
        r28.post(new AnonymousClass4(this));
        return;
    L77:
        return;
    L58:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L62;
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(-2, -2);
        r29.setMargins(0, ((int) UIUtils.dip2Px(getContext(), 52.0f)) + StatusBarUtil.getStatusBarHeight(getContext()), 0, 0);
        View r30 = this.i;
        if (r30 == null) goto L62;
        r30.setLayoutParams(r29);
        goto L62
    L39:
        r22 = null;
        goto L40
    L35:
        r20 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L16:
        r14 = null;
        goto L17
    L12:
        r12 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131567285, r3, false);
        this.g = r5;
        return r5;
    }
}
