package com.bytedance.android.live.impl.logfilter;

import android.app.Activity;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.service.RoomService;
import com.bytedance.android.live.impl.utils.TimeUtils;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.model.PlayerMultiRenderInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j40.c0;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class UserFeatureInRoomFilter extends d implements f, z90.a.b {
    public static final Deque<Long> A = null;
    public static final Deque<Long> B = null;
    public static final Deque<Long> C = null;
    public static final Deque<Long> D = null;
    public static final Deque<Long> E = null;
    public static final Deque<Long> F = null;
    public static final Deque<Long> G = null;
    public static final Deque<Long> H = null;
    public static long H0;
    public static final Deque<Long> I = null;
    public static final Deque<Long> J = null;
    public static final Deque<Long> K = null;
    public static final Deque<Long> L = null;
    public static long L0;
    public static LongSparseArray<Integer> M;
    public static LongSparseArray<Integer> N;
    public static final Deque<Long> O = null;
    public static boolean P;
    public static long P0;
    public static volatile long Q;
    public static long R;
    public static int S;
    public static int T;
    public static final SparseArray<Long> U = null;
    public static final List<String> V = null;
    public static long V0;
    public static final HashMap<Integer, String> W = null;
    public static final HashMap<Integer, String> X = null;
    public static final List<String> Y = null;
    public static long Z;
    public static int b;
    public static Disposable b1;
    public static final Deque<Long> c = null;
    public static final Deque<Long> d = null;
    public static long e;
    public static long f;
    public static int g;
    public static final Lazy g1 = null;
    public static int h;
    public static final Lazy h1 = null;
    public static int i;
    public static int j;
    public static int k;
    public static long k0;
    public static final Lazy k1 = null;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static long p0;
    public static final Lazy p1 = null;
    public static int q;
    public static int r;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public static final Lazy v1 = null;
    public static int w;
    public static int x;
    public static final Lazy x1 = null;
    public static int y;
    public static final UserFeatureInRoomFilter y1 = null;
    public static int z;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            long r0 = System.currentTimeMillis();
            UserFeatureInRoomFilter r11 = UserFeatureInRoomFilter.y1;
            final long r1 = (r0 - UserFeatureInRoomFilter.e) / ((long) 1000);
            c0 r2 = c0.a;
            List<Integer> r3 = r2.getValue().getRoomStayDurationReportList();
            if (r3 == null) goto L8;
            boolean r4 = com.bytedance.android.live.impl.utils.a.a;
            com.bytedance.android.live.impl.utils.a.a(r11.a, new UserFeatureInRoomFilter$startOrStopRoomStayDurationTimerTask$1$1(r1));
            if (r3.contains(Integer.valueOf((int) r1)) == false) goto L13;
            FeatureManager.u.c("live_watch_duration", Long.valueOf(r1));
            return;
        L13:
            return;
        L8:
            if (r1 > 0) goto L10;
            return;
        L10:
            if ((r1 % ((long) r2.getValue().getRoomStayDurationUpdateInterval())) != 0) goto L16;
            FeatureManager.u.c("live_watch_duration", Long.valueOf(r1));
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ boolean a;

        public b(boolean r1) {
            this.a = r1;
        }

        public final void a() {
            ArrayList r0 = new ArrayList();
            String r1 = UserFeatureInRoomFilter.y1.g().d("watch_room_pv_per_day", r0.toString());
            if (r1 == null) goto L38;
            SimpleDateFormat r2 = TimeUtils.a;
            String r3 = TimeUtils.b(UserFeatureInRoomFilter.Q);
            int r4 = JsonHelper.a;
            List r5 = JsonHelper.e(r1, JsonItemType.WATCH_ROOM_PV_ITEM);
            if ((r5 instanceof List) == true) goto L7;
            r5 = null;
        L7:
            if (r5 == null) goto L38;
            int r8 = 0;
            if (this.a == false) goto L20;
            Iterator r6 = r5.iterator();
            boolean r7 = false;
        L12:
            if (r6.hasNext() == false) goto L17;
            JsonItemHelper.WatchRoomPvItem r9 = (JsonItemHelper.WatchRoomPvItem) r6.next();
            if (Intrinsics.areEqual(r9.getDate(), r3) == true) goto L15;
            r0.add(JsonHelper.f(r9));
            goto L12
        L15:
            r9.setWatchCount(r9.getWatchCount() + UserFeatureInRoomFilter.T);
            r0.add(JsonHelper.f(r9));
            r9.getWatchCount();
            r7 = true;
            goto L12
        L17:
            if (r7 == true) goto L19;
            int r11 = JsonHelper.a;
            r0.add(JsonHelper.f(new JsonItemHelper.WatchRoomPvItem(r3, UserFeatureInRoomFilter.T)));
        L19:
            long r12 = 0;
        L36:
            FeatureManager r13 = FeatureManager.u;
            r13.getClass();
            r13.i("watch_room_pv_week_avg", Integer.valueOf(r8 / FeatureManager.j), FeatureType.DYNAMIC);
            UserFeatureInRoomFilter r14 = UserFeatureInRoomFilter.y1;
            r14.g().e("watch_room_pv_per_day", r0.toString());
            long r15 = Math.max(r12, r14.g().c("key_live_inner_show_total_count"));
            r14.g().e("key_live_inner_show_total_count", Long.valueOf(((long) UserFeatureInRoomFilter.T) + r15));
            z90.a.C0301a.a(r13, "live_inner_show_total_count", Long.valueOf(r15 + ((long) UserFeatureInRoomFilter.T)));
            return;
        L20:
            Iterator r16 = r5.iterator();
            int r17 = 0;
            int r18 = 0;
            long r19 = 0;
        L22:
            if (r16.hasNext() == false) goto L35;
            JsonItemHelper.WatchRoomPvItem r110 = (JsonItemHelper.WatchRoomPvItem) r16.next();
            r19 = r19 + ((long) r110.getWatchCount());
            String r111 = r110.getDate();
            if (r111 == null) goto L26;
            long r112 = TimeUtils.c(r111);
        L27:
            SimpleDateFormat r113 = TimeUtils.a;
            int r114 = UserFeatureInRoomFilter.b;
            long r21 = TimeUtils.a(r112, UserFeatureInRoomFilter.Q);
            FeatureManager.u.getClass();
            if (r21 >= FeatureManager.j) goto L33;
            r0.add(JsonHelper.f(r110));
            r18 = r18 + r110.getWatchCount();
            if (r110.getWatchCount() > 2) goto L33;
            r17 = r17 + 1;
        L33:
            if (Intrinsics.areEqual(r110.getDate(), r3) == false) goto L22;
            r8 = r110.getWatchCount() + UserFeatureInRoomFilter.T;
            goto L22
        L26:
            r112 = 0;
            goto L27
        L35:
            FeatureManager r22 = FeatureManager.u;
            Integer r23 = Integer.valueOf(r8);
            FeatureType r24 = FeatureType.DYNAMIC;
            r22.i("watch_room_pv_today", r23, r24);
            r22.i("low_vv_days_in_week", Integer.valueOf(r17), r24);
            r8 = r18;
            r12 = r19;
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

    @Override // com.bytedance.android.live.impl.logfilter.d
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "name");
    }

    public final k0 g() {
        return (k0) x1.getValue();
    }

    static {
        UserFeatureInRoomFilter r0 = new UserFeatureInRoomFilter();
        y1 = r0;
        c = new LinkedList();
        d = new ConcurrentLinkedDeque();
        A = new LinkedList();
        B = new LinkedList();
        C = new LinkedList();
        D = new LinkedList();
        E = new LinkedList();
        F = new LinkedList();
        G = new LinkedList();
        H = new LinkedList();
        I = new LinkedList();
        J = new LinkedList();
        K = new LinkedList();
        L = new LinkedList();
        M = new LongSparseArray();
        N = new LongSparseArray();
        O = new LinkedList();
        P = true;
        Q = System.currentTimeMillis();
        U = new SparseArray();
        V = CollectionsKt.listOf(new String[]{"watchLdRoomCount", "watchSdRoomCount", "watchHdRoomCount", "watchUhdRoomCount", "watchOtherRoomCount"});
        W = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(0, "标清"), TuplesKt.to(1, "高清"), TuplesKt.to(2, "超清"), TuplesKt.to(3, "蓝光"), TuplesKt.to(4, "其他")});
        X = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(0, "ld"), TuplesKt.to(1, "sd"), TuplesKt.to(2, "hd"), TuplesKt.to(3, "uhd"), TuplesKt.to(4, "other")});
        Y = CollectionsKt.listOf(new String[]{"标清", "高清", "超清", "蓝光", "其他"});
        L0 = Long.MAX_VALUE;
        P0 = Long.MAX_VALUE;
        V0 = Long.MAX_VALUE;
        g1 = LazyKt.lazy(UserFeatureInRoomFilter$normalLiveLevelMemory$2.INSTANCE);
        h1 = LazyKt.lazy(UserFeatureInRoomFilter$liveLevelMemoryTime$2.INSTANCE);
        k1 = LazyKt.lazy(UserFeatureInRoomFilter$gameLiveLevelMemory$2.INSTANCE);
        p1 = LazyKt.lazy(UserFeatureInRoomFilter$vsLiveLevelMemory$2.INSTANCE);
        v1 = LazyKt.lazy(UserFeatureInRoomFilter$lastPlayResolutionKey$2.INSTANCE);
        x1 = LazyKt.lazy(UserFeatureInRoomFilter$kevaOrSpHelper$2.INSTANCE);
        FeatureManager r2 = FeatureManager.u;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, FileUtils.FILTER);
        FeatureManager.m.add(r0);
        r2.e(r0, CollectionsKt.listOf(new String[]{"livesdk_product_entrance_click", "livesdk_redpackage_click", "livesdk_short_task_banner_click"}));
        P0 = System.currentTimeMillis();
        V0 = System.currentTimeMillis();
        k(false);
        TTExecutors.getNormalExecutor().submit(q.a);
        TTExecutors.getNormalExecutor().submit(new k(true));
        TTExecutors.getNormalExecutor().submit(new o(false));
        TTExecutors.getNormalExecutor().submit(new n(true, null));
        TTExecutors.getNormalExecutor().submit(new p(false));
        TTExecutors.getNormalExecutor().submit(new j(true, null));
        TTExecutors.getNormalExecutor().submit(new UserFeatureInRoomFilter$updateMiniWindowLoadDuration$1(true, 0));
        TTExecutors.getNormalExecutor().submit(new UserFeatureInRoomFilter$updateMiniWindowShowDuration$1(true, 0));
        TTExecutors.getNormalExecutor().submit(i.a);
        h();
        z90.a.C0301a.a(r2, "drawer_preload_count", 0);
        z90.a.C0301a.a(r2, "drawer_preload_count_app", 0);
        if (j40.d.a.getValue().f() <= 0) goto L7;
        TTExecutors.getNormalExecutor().submit(new l(true));
        return;
    }

    public static void h() {
        FeatureManager r0 = FeatureManager.u;
        Integer r1 = Integer.valueOf(b);
        FeatureType r2 = FeatureType.DYNAMIC;
        r0.i("live_watch_count", r1, r2);
        f = 0;
        z90.a.C0301a.a(r0, "live_watch_duration", 0L);
        z90.a.C0301a.a(r0, "live_watch_count_in_last_minute", 0);
        g = 0;
        r0.i("live_like_amount", 0, r2);
        ((LinkedList) A).clear();
        r0.i("live_like_amount_in_last_minute", 0, r2);
        j = 0;
        r0.i("live_gift_panel_show_count", 0, r2);
        ((LinkedList) D).clear();
        r0.i("live_gift_panel_show_count_in_last_minute", 0, r2);
        m = 0;
        r0.i("live_gift_send_count", 0, r2);
        ((LinkedList) G).clear();
        r0.i("live_gift_send_count_in_last_minute", 0, r2);
        p = 0;
        r0.i("live_recharge_count", 0, r2);
        ((LinkedList) J).clear();
        r0.i("live_recharge_count_in_last_minute", 0, r2);
        s = 0;
        r0.i("live_recharge_money_amount", 0, r2);
        r0.i("live_recharge_money_amount_in_last_minute", 0, r2);
        v = 0;
        w = 0;
        x = 0;
        y = 0;
        z = 0;
        z90.a.C0301a.a(r0, "live_comment_count", 0);
        z90.a.C0301a.a(r0, "live_ecom_popup_card_click_count", Integer.valueOf(w));
        z90.a.C0301a.a(r0, "live_ecom_live_cart_tag_click_count", Integer.valueOf(x));
        z90.a.C0301a.a(r0, "live_redpackage_click_count", Integer.valueOf(y));
        z90.a.C0301a.a(r0, "live_lucky_bag_click_count", Integer.valueOf(z));
    }

    public final ILivePlayerClient f() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.V1();
    L8:
        return null;
    }

    public UserFeatureInRoomFilter() {
    }

    public static void j(boolean r6) {
        c0 r0 = c0.a;
        if (r0.getValue().getRoomStayDurationUpdatePeriod() > 0) goto L5;
        return;
    L5:
        Disposable r1 = b1;
        if (r1 != null) goto L8;
    L12:
        b1 = null;
        if (r6 == false) goto L16;
        b1 = du2.a.d(r0.getValue().getRoomStayDurationUpdatePeriod(), TimeUnit.MILLISECONDS).observeOn(Schedulers.computation()).subscribe(a.a);
        return;
    L16:
        return;
    L8:
        if (r1.isDisposed() == true) goto L12;
        Disposable r2 = b1;
        if (r2 == null) goto L12;
        r2.dispose();
        goto L12
    }

    public static void k(boolean r2) {
        TTExecutors.getNormalExecutor().submit(new b(r2));
    }

    @Override // z90.d
    public final <T> T getFeature(String r14) {
        Intrinsics.checkNotNullParameter(r14, "name");
        long r1 = -1;
        Long r3 = -1L;
        long r4 = 0;
        String r9 = "";
        int r11 = 1;
        int r12 = 0;
        int r13 = 0;
        boolean r15 = false;
        int r16 = 0;
        int r17 = 0;
        T r18 = (T) null;
        switch(r14.hashCode()) {
            case -2070268852: goto L359;
            case -2000955474: goto L354;
            case -1617639102: goto L339;
            case -1497863113: goto L300;
            case -1460995174: goto L282;
            case -1251562551: goto L277;
            case -957611155: goto L272;
            case -873522101: goto L254;
            case -310190012: goto L245;
            case -310098556: goto L236;
            case -235635996: goto L224;
            case -184917983: goto L213;
            case -147132913: goto L203;
            case -79815283: goto L195;
            case -54763413: goto L190;
            case -41830683: goto L176;
            case 25140622: goto L170;
            case 123095211: goto L165;
            case 204445562: goto L148;
            case 338253111: goto L140;
            case 358949831: goto L130;
            case 582603389: goto L125;
            case 606730935: goto L117;
            case 677463861: goto L108;
            case 973790876: goto L96;
            case 1028143168: goto L78;
            case 1272572575: goto L70;
            case 1282049929: goto L65;
            case 1333992242: goto L58;
            case 1479612295: goto L51;
            case 1663674251: goto L35;
            case 1883375961: goto L24;
            case 1927088924: goto L14;
            case 2097108866: goto L6;
            default: goto L364;
        };
    L364:
        z90.a.C0301a.a(FeatureManager.u, r14, r18);
        return r18;
    L6:
        if (r14.equals("game_live_level_memory") == false) goto L364;
        Integer r0 = (Integer) ((Property) k1.getValue()).getValue();
        if (r0 == null) goto L10;
        r13 = r0.intValue();
    L10:
        Object r2 = Integer.valueOf(r13);
        if ((r2 instanceof Object) == false) goto L364;
    L363:
        r18 = (T) r2;
        goto L364
    L14:
        if (r14.equals("app_stay_duration") == false) goto L364;
        long r5 = System.currentTimeMillis() - P0;
        if (r5 < 0) goto L21;
        r2 = Long.valueOf(r5);
        if ((r2 instanceof Object) == true) goto L363;
    L21:
        if ((r3 instanceof Object) == false) goto L32;
    L33:
        r18 = (T) r3;
    L32:
        r3 = null;
        goto L33
    L24:
        if (r14.equals("non_live_stay_duration") == false) goto L364;
        long r6 = System.currentTimeMillis() - V0;
        if (r6 < 0) goto L31;
        r2 = Long.valueOf(r6);
        if ((r2 instanceof Object) == true) goto L363;
    L31:
        if ((r3 instanceof Object) == true) goto L33;
    L35:
        if (r14.equals("anchor_gender") == false) goto L364;
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.o r8 = IRoomContextService.a.a(r7, null, 0, 3);
        if (r8 == null) goto L41;
        Room r19 = r8.o2();
    L42:
        if (r19 == null) goto L46;
        IBaseUser r21 = r19.getOwner();
        if (r21 == null) goto L46;
        r2 = Integer.valueOf(r21.getGender());
    L48:
        if ((r2 instanceof Object) == true) goto L363;
    L46:
        r2 = null;
    L41:
        r19 = null;
        goto L42
    L51:
        if (r14.equals("live_duration") == false) goto L364;
        if ((System.currentTimeMillis() - L0) < 0) goto L364;
        r2 = Long.valueOf(System.currentTimeMillis() - L0);
        if ((r2 instanceof Object) == true) goto L363;
    L58:
        if (r14.equals("current_resolution") == false) goto L364;
        ILivePlayerClient r22 = f();
        if (r22 == null) goto L211;
        String r23 = r22.getCurrentResolution();
        if (r23 == null) goto L211;
    L174:
        r9 = r23;
    L211:
        r18 = (T) r9;
        goto L364
    L65:
        if (r14.equals("enter_inner_live_scene") == false) goto L364;
        r2 = Boolean.valueOf(!P);
        if ((r2 instanceof Object) == true) goto L363;
    L70:
        if (r14.equals("has_cellular_permission") == false) goto L364;
        IMiddlewareHostBusiness r24 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r24 == null) goto L74;
        r15 = r24.hasCellularPermission();
    L74:
        r2 = Boolean.valueOf(r15);
        if ((r2 instanceof Object) == true) goto L363;
    L78:
        if (r14.equals("follow_status") == false) goto L364;
        IRoomContextService r25 = jc1.k.f(IRoomContextService.class);
        if (r25 == null) goto L84;
        com.bytedance.android.livesdk.chatroom.o r26 = IRoomContextService.a.a(r25, null, 0, 3);
        if (r26 == null) goto L84;
        Room r27 = r26.o2();
    L85:
        if (r27 == null) goto L91;
        IBaseUser r28 = r27.getOwner();
        if (r28 == null) goto L91;
        py.j r29 = r28.getFollowInfo();
        if (r29 == null) goto L91;
        r2 = Long.valueOf(r29.getFollowStatus());
    L93:
        if ((r2 instanceof Object) == true) goto L363;
    L91:
        r2 = null;
    L84:
        r27 = null;
        goto L85
    L96:
        if (r14.equals("user_id_rem_100") == false) goto L364;
        IMiddlewareUserService r31 = jc1.k.f(IMiddlewareUserService.class);
        if (r31 == null) goto L104;
        com.bytedance.android.livesdk.user.e r32 = r31.user();
        if (r32 == null) goto L104;
        String r33 = r32.n();
        if (r33 == null) goto L104;
        r4 = CastLongProtector.parseLong(r33) % ((long) 100);
    L104:
        r2 = Long.valueOf(r4);
        if ((r2 instanceof Object) == true) goto L363;
    L108:
        if (r14.equals("has_game_cp") == false) goto L364;
        WeakReference<IRoom> r34 = RoomService.a;
        WeakReference<IRoom> r35 = RoomService.a;
        if (r35 == null) goto L364;
        IRoom r36 = r35.get();
        if (r36 == null) goto L364;
        r2 = Boolean.valueOf(r36.isGameCPRoom());
        if ((r2 instanceof Object) == true) goto L363;
    L117:
        if (r14.equals("live_watch_duration") == false) goto L364;
        if (P == true) goto L121;
        r1 = (System.currentTimeMillis() - e) / 1000;
    L121:
        r2 = Long.valueOf(r1);
        if ((r2 instanceof Object) == true) goto L363;
    L125:
        if (r14.equals("live_level_memory_time") == false) goto L364;
        r2 = Integer.valueOf((int) ((System.currentTimeMillis() - ((Number) ((Property) h1.getValue()).getValue()).longValue()) / ((long) 86400000)));
        if ((r2 instanceof Object) == true) goto L363;
    L130:
        if (r14.equals("audience_change_definition") == false) goto L364;
        if (TextUtils.isEmpty((CharSequence) ((Property) v1.getValue()).getValue()) == false) goto L136;
        r2 = Boolean.TRUE;
        if ((r2 instanceof Object) == true) goto L363;
    L136:
        r2 = Boolean.FALSE;
        if ((r2 instanceof Object) == true) goto L363;
    L140:
        if (r14.equals("normal_live_level_memory") == false) goto L364;
        Integer r37 = (Integer) ((Property) g1.getValue()).getValue();
        if (r37 == null) goto L144;
        r16 = r37.intValue();
    L144:
        r2 = Integer.valueOf(r16);
        if ((r2 instanceof Object) == true) goto L363;
    L148:
        if (r14.equals("is_ecom_live") == false) goto L364;
        WeakReference<IRoom> r38 = RoomService.a;
        WeakReference<IRoom> r39 = RoomService.a;
        if (r39 == null) goto L364;
        IRoom r41 = r39.get();
        if (r41 == null) goto L364;
        if (TextUtils.equals(r41.isEcomCart(), GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L161;
        IRoomCart r42 = r41.getRoomCart();
        if (r42 != null) goto L158;
    L160:
        r11 = 0;
        goto L161
    L158:
        if (r42.getShowCartExt() != 1) goto L160;
    L161:
        r2 = Integer.valueOf(r11);
        if ((r2 instanceof Object) == true) goto L363;
    L165:
        if (r14.equals("drawer_preload_interval_app") == false) goto L364;
        r2 = Long.valueOf(System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("drawer_preload_time_app", 0L)).longValue());
        if ((r2 instanceof Object) == true) goto L363;
    L170:
        if (r14.equals("last_play_resolution_key") == false) goto L364;
        r23 = (String) ((Property) v1.getValue()).getValue();
        if (r23 != null) goto L174;
    L176:
        if (r14.equals("anchor_id") == false) goto L364;
        IRoomContextService r43 = jc1.k.f(IRoomContextService.class);
        if (r43 == null) goto L182;
        com.bytedance.android.livesdk.chatroom.o r44 = IRoomContextService.a.a(r43, null, 0, 3);
        if (r44 == null) goto L182;
        Room r45 = r44.o2();
    L183:
        if (r45 == null) goto L185;
        r2 = r45.getAnchorId();
    L187:
        if ((r2 instanceof Object) == true) goto L363;
    L185:
        r2 = null;
    L182:
        r45 = null;
        goto L183
    L190:
        if (r14.equals("anchor_last_resolution_remember_time") == false) goto L364;
        r2 = Integer.valueOf((int) ((System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("live_anchor_resolution_save_time", 0L)).longValue()) / ((long) 86400000)));
        if ((r2 instanceof Object) == true) goto L363;
    L195:
        if (r14.equals("vs_live_level_memory") == false) goto L364;
        Integer r46 = (Integer) ((Property) p1.getValue()).getValue();
        if (r46 == null) goto L199;
        r17 = r46.intValue();
    L199:
        r2 = Integer.valueOf(r17);
        if ((r2 instanceof Object) == true) goto L363;
    L203:
        if (r14.equals("user_id") == false) goto L364;
        IMiddlewareUserService r47 = jc1.k.f(IMiddlewareUserService.class);
        if (r47 == null) goto L211;
        com.bytedance.android.livesdk.user.e r48 = r47.user();
        if (r48 == null) goto L211;
        r23 = r48.n();
        if (r23 == null) goto L211;
    L213:
        if (r14.equals("stay_live_duration") == false) goto L364;
        if (P == false) goto L217;
    L220:
        r2 = Long.valueOf(r4);
        if ((r2 instanceof Object) == true) goto L363;
    L217:
        if (R == 0) goto L219;
        r4 = System.currentTimeMillis() - R;
        goto L220
    L219:
        r4 = ((Number) FeatureManager.u.getFeature("duration_session", 0L)).longValue();
        goto L220
    L224:
        if (r14.equals("is_enable_personal_recommend") == false) goto L364;
        IMiddlewareHostBusiness r49 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r49 == null) goto L364;
        if (r49.isEnablePersonalRecommend() != true) goto L232;
        r2 = 1;
        if ((r2 instanceof Object) == true) goto L363;
    L232:
        r2 = 0;
        if ((r2 instanceof Object) == true) goto L363;
    L236:
        if (r14.equals("live_brightness") == false) goto L364;
        IMiddlewareHostApp r51 = jc1.k.f(IMiddlewareHostApp.class);
        if (r51 == null) goto L364;
        Activity r52 = r51.getMainActivity();
        if (r52 == null) goto L364;
        r2 = Integer.valueOf(jc1.k.n(IUtilsCommonService.class).liveBrightnessUtilGetSystemValue(r52));
        if ((r2 instanceof Object) == true) goto L363;
    L245:
        if (r14.equals("is_game_live") == false) goto L364;
        WeakReference<IRoom> r53 = RoomService.a;
        WeakReference<IRoom> r54 = RoomService.a;
        if (r54 == null) goto L364;
        IRoom r55 = r54.get();
        if (r55 == null) goto L364;
        r2 = Integer.valueOf(r55.isGameRoom());
        if ((r2 instanceof Object) == true) goto L363;
    L254:
        if (r14.equals("anchor_follow_count") == false) goto L364;
        IRoomContextService r56 = jc1.k.f(IRoomContextService.class);
        if (r56 == null) goto L260;
        com.bytedance.android.livesdk.chatroom.o r57 = IRoomContextService.a.a(r56, null, 0, 3);
        if (r57 == null) goto L260;
        Room r58 = r57.o2();
    L261:
        if (r58 == null) goto L267;
        IBaseUser r59 = r58.getOwner();
        if (r59 == null) goto L267;
        py.j r61 = r59.getFollowInfo();
        if (r61 == null) goto L267;
        r2 = Long.valueOf(r61.getFollowingCount());
    L269:
        if ((r2 instanceof Object) == true) goto L363;
    L267:
        r2 = null;
    L260:
        r58 = null;
        goto L261
    L272:
        if (r14.equals("live_quit_dialog_show_interval") == false) goto L364;
        r2 = Long.valueOf((System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("last_quit_dialog_show_time", 0L)).longValue()) / ((long) 1000));
        if ((r2 instanceof Object) == true) goto L363;
    L277:
        if (r14.equals("drawer_preload_interval") == false) goto L364;
        r2 = Long.valueOf(System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("drawer_preload_time", 0L)).longValue());
        if ((r2 instanceof Object) == true) goto L363;
    L282:
        if (r14.equals("anchor_fans_count") == false) goto L364;
        IRoomContextService r62 = jc1.k.f(IRoomContextService.class);
        if (r62 == null) goto L288;
        com.bytedance.android.livesdk.chatroom.o r63 = IRoomContextService.a.a(r62, null, 0, 3);
        if (r63 == null) goto L288;
        Room r64 = r63.o2();
    L289:
        if (r64 == null) goto L295;
        IBaseUser r65 = r64.getOwner();
        if (r65 == null) goto L295;
        py.j r66 = r65.getFollowInfo();
        if (r66 == null) goto L295;
        r2 = Long.valueOf(r66.getFollowerCount());
    L297:
        if ((r2 instanceof Object) == true) goto L363;
    L295:
        r2 = null;
    L288:
        r64 = null;
        goto L289
    L300:
        if (r14.equals("current_resolution_level") == false) goto L364;
        ILivePlayerClient r67 = f();
        if (r67 == null) goto L307;
        String r68 = r67.getCurrentResolution();
        if (r68 == null) goto L307;
        r9 = r68;
    L307:
        IRoomContextService r69 = jc1.k.f(IRoomContextService.class);
        if (r69 == null) goto L312;
        com.bytedance.android.livesdk.chatroom.o r71 = IRoomContextService.a.a(r69, null, 0, 3);
        if (r71 == null) goto L312;
        Room r72 = r71.o2();
    L313:
        if (r72 == null) goto L332;
        IBaseStreamUrl r73 = r72.getStreamUrl();
        if (r73 == null) goto L332;
        ILiveCoreSDKData r74 = r73.getLiveCoreSDKData();
        if (r74 == null) goto L332;
        List r75 = r74.getQualityList();
        if (r75 == null) goto L332;
        Iterator<T> r76 = r75.iterator();
    L322:
        if (r76.hasNext() == false) goto L330;
        T r77 = r76.next();
        IQuality r78 = (IQuality) r77;
        if (r78 == null) goto L326;
        String r79 = r78.getSdkKey();
    L328:
        if (Intrinsics.areEqual(r79, r9) == false) goto L322;
    L331:
        IQuality r81 = (IQuality) r77;
    L333:
        if (r81 == null) goto L335;
        r12 = r81.getLevel();
    L335:
        r2 = Integer.valueOf(r12);
        if ((r2 instanceof Object) == true) goto L363;
    L326:
        r79 = null;
        goto L328
    L330:
        r77 = null;
    L332:
        r81 = null;
    L312:
        r72 = null;
        goto L313
    L339:
        if (r14.equals("game_display_scene") == false) goto L364;
        ILivePlayerClient r82 = f();
        if (r82 == null) goto L349;
        ILivePlayerMultiRenderController r83 = r82.multiRenderController();
        if (r83 == null) goto L349;
        PlayerMultiRenderInfo r84 = r83.renderInfo();
        if (r84 == null) goto L349;
        Integer r85 = r84.getDisplayId();
        if (r85 == null) goto L349;
        r2 = String.valueOf(r85.intValue());
    L351:
        if ((r2 instanceof Object) == true) goto L363;
    L349:
        r2 = null;
        goto L351
    L354:
        if (r14.equals("drawer_open_interval_app") == false) goto L364;
        r2 = Long.valueOf(System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("drawer_open_time_app", 0L)).longValue());
        if ((r2 instanceof Object) == true) goto L363;
    L359:
        if (r14.equals("drawer_open_interval") == false) goto L364;
        r2 = Long.valueOf(System.currentTimeMillis() - ((Number) FeatureManager.u.getFeature("drawer_open_time", 0L)).longValue());
        if ((r2 instanceof Object) == true) goto L363;
        goto L363
    }

    public final void i(IRoom r5) {
        ILivePlayerClient r0 = f();
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentResolution();
        if (r1 == null) goto L6;
    L7:
        Integer r2 = null;
        if (r5 == null) goto L27;
        IBaseStreamUrl r6 = r5.getStreamUrl();
        if (r6 == null) goto L27;
        ILiveCoreSDKData r7 = r6.getLiveCoreSDKData();
        if (r7 == null) goto L27;
        List r8 = r7.getQualityList();
        if (r8 == null) goto L27;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L25;
        Object r3 = r9.next();
        IQuality r4 = (IQuality) r3;
        if (r4 == null) goto L21;
        String r11 = r4.getSdkKey();
    L23:
        if (Intrinsics.areEqual(r11, r1) == false) goto L17;
    L26:
        IQuality r12 = (IQuality) r3;
    L28:
        if (r12 == null) goto L30;
        r2 = Integer.valueOf(r12.getLevel());
    L30:
        FeatureManager.u.i("last_resolution_level", r2, FeatureType.DYNAMIC);
        return;
    L21:
        r11 = null;
        goto L23
    L25:
        r3 = null;
    L27:
        r12 = null;
    L6:
        r1 = "";
        goto L7
    }

    public static final void e(UserFeatureInRoomFilter r4, int r5) {
        r4.getClass();
        SparseArray<Long> r6 = U;
        r6.put(r5, Long.valueOf(r6.get(r5, 0L).longValue() + 1));
    }

    @Override // z90.a.b
    public final <T> void a(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        int r0 = r4.hashCode();
        String r2 = null;
        if (r0 == (-1499742021)) goto L34;
        if (r0 == (-917606481)) goto L31;
        if (r0 == 1522908064) goto L10;
        return;
    L10:
        if (r4.equals("livesdk_product_entrance_click") == false) goto L50;
        boolean r6 = r5 instanceof JSONObject;
        Object r7 = r5;
        if (r6 == true) goto L14;
        r7 = (T) null;
    L14:
        JSONObject r8 = (JSONObject) r7;
        if (r8 == null) goto L17;
        r2 = r8.optString("ecom_entrance_form");
    L17:
        if (r2 == null) goto L60;
        int r9 = r2.hashCode();
        if (r9 == (-816471058)) goto L28;
        if (r9 == 1425303542) goto L25;
        return;
    L25:
        if (r2.equals("live_popup_card") == false) goto L51;
        w++;
        FeatureManager.u.c("live_ecom_popup_card_click_count", Integer.valueOf(w));
        return;
    L51:
        return;
    L28:
        if (r2.equals("live_cart_tag") == false) goto L53;
        x++;
        FeatureManager.u.c("live_ecom_live_cart_tag_click_count", Integer.valueOf(x));
        return;
    L53:
        return;
    L60:
        return;
    L50:
        return;
    L31:
        if (r4.equals("livesdk_redpackage_click") == false) goto L55;
        y++;
        FeatureManager.u.c("live_redpackage_click_count", Integer.valueOf(y));
        return;
    L55:
        return;
    L34:
        if (r4.equals("livesdk_short_task_banner_click") == false) goto L57;
        boolean r11 = r5 instanceof JSONObject;
        Object r12 = r5;
        if (r11 == true) goto L38;
        r12 = (T) null;
    L38:
        JSONObject r13 = (JSONObject) r12;
        if (r13 == null) goto L41;
        r2 = r13.optString("task_name");
    L41:
        if (r2 != null) goto L44;
        return;
    L44:
        if (r2.hashCode() == 999644) goto L47;
        return;
    L47:
        if (r2.equals("福袋") == false) goto L58;
        z++;
        FeatureManager.u.c("live_lucky_bag_click_count", Integer.valueOf(z));
        return;
    L58:
        return;
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r24, Map<String, String> r25) {
        Intrinsics.checkNotNullParameter(r24, "eventName");
        Intrinsics.checkNotNullParameter(r25, "params");
        Q = System.currentTimeMillis();
        int r11 = 1;
        switch(r24.hashCode()) {
            case -901624339: goto L94;
            case -699337673: goto L89;
            case -566086253: goto L84;
            case -70209228: goto L78;
            case 228634976: goto L22;
            case 1375206458: goto L9;
            case 1674961070: goto L6;
            default: goto L307;
        };
    L78:
        Integer r3 = 0;
        if (r24.equals("livesdk_live_take_room_start") == false) goto L98;
        L0 = Q;
        V0 = Long.MAX_VALUE;
        if (j40.d.a.getValue().f() <= 0) goto L285;
        TTExecutors.getNormalExecutor().submit(new l(false));
    L285:
        return;
    L98:
        if (P == true) goto L285;
        Object r19 = "enter_from_merge";
        switch(r24.hashCode()) {
            case -1115849514: goto L239;
            case -993186225: goto L233;
            case -804282046: goto L230;
            case -773966155: goto L213;
            case -505186085: goto L210;
            case -222756498: goto L207;
            case 21313630: goto L182;
            case 119806760: goto L176;
            case 516631638: goto L169;
            case 1011870511: goto L163;
            case 1031616782: goto L157;
            case 1060883835: goto L150;
            case 2009019068: goto L123;
            case 2022034541: goto L110;
            case 2041791848: goto L103;
            default: goto L309;
        };
    L103:
        if (r24.equals("livesdk_like") == false) goto L309;
        int r0 = g;
        if (r0 != 0) goto L107;
        i++;
        FeatureManager.u.i("live_like_room_amount", Integer.valueOf(i), FeatureType.MONITOR);
        d.c("live_like_room_amount_in_last_minute", C, Q);
    L108:
        g++;
        FeatureManager r1 = FeatureManager.u;
        Integer r2 = Integer.valueOf(g);
        FeatureType r4 = FeatureType.MONITOR;
        r1.i("live_like_amount", r2, r4);
        d.c("live_like_amount_in_last_minute", A, Q);
        int r5 = h + 1;
        h = r5;
        r1.i("live_like_amount_total", Integer.valueOf(r5), r4);
        d.c("live_like_amount_total_in_last_minute", B, Q);
        goto L309
    L107:
        d.d("live_like_room_amount_in_last_minute", C, r0, Q);
        goto L108
    L110:
        if (r24.equals("livesdk_watch_onemin") == false) goto L309;
        f += 60;
        FeatureManager r6 = FeatureManager.u;
        Long r7 = Long.valueOf(f);
        FeatureType r8 = FeatureType.MONITOR;
        r6.i("live_watch_duration", r7, r8);
        ConcurrentLinkedDeque r9 = (ConcurrentLinkedDeque) d;
        if ((!r9.isEmpty()) == false) goto L118;
        Long r12 = (Long) r9.pollLast();
        if (r12 == null) goto L116;
        long r13 = r12.longValue();
    L117:
        r9.offerLast(Long.valueOf(r13 + 60));
    L120:
        if ((!r9.isEmpty()) == false) goto L309;
        r6.i("live_watch_duration_avg", Long.valueOf(CollectionsKt.sumOfLong(r9) / ((long) r9.size())), r8);
        goto L309
    L116:
        r13 = 0;
        goto L117
    L118:
        r9.offerLast(60L);
        goto L120
    L123:
        if (r24.equals("livesdk_recharge_success") == false) goto L309;
        int r14 = p;
        if (r14 != 0) goto L127;
        r++;
        FeatureManager.u.i("live_recharge_room_count", Integer.valueOf(r), FeatureType.MONITOR);
        d.c("live_recharge_room_count_in_last_minute", L, Q);
    L128:
        p++;
        q++;
        FeatureManager r15 = FeatureManager.u;
        Integer r16 = Integer.valueOf(p);
        FeatureType r17 = FeatureType.MONITOR;
        r15.i("live_recharge_count", r16, r17);
        r15.i("live_recharge_count_total", Integer.valueOf(q), r17);
        Deque<Long> r18 = J;
        d.c("live_recharge_count_in_last_minute", r18, Q);
        Deque<Long> r21 = K;
        d.c("live_recharge_count_total_in_last_minute", r21, Q);
        String r22 = r25.get("money_paid");
        if (r22 == null) goto L131;
        int r23 = CastIntegerProtector.parseInt(r22);
    L132:
        int r26 = s + r23;
        s = r26;
        t += r23;
        r15.i("live_recharge_money_amount", Integer.valueOf(r26), r17);
        r15.i("live_recharge_money_amount_total", Integer.valueOf(t), r17);
        M.put(((Number) ((LinkedList) r18).peekLast()).longValue(), Integer.valueOf(r23));
        N.put(((Number) ((LinkedList) r21).peekLast()).longValue(), Integer.valueOf(r23));
        if (r18.isEmpty() == true) goto L309;
        LongSparseArray<Integer> r27 = new LongSparseArray();
        int r28 = 0;
        int r29 = 0;
    L136:
        if (r28 >= M.size()) goto L141;
        long r31 = M.keyAt(r28);
        if (r31 < ((Number) ((LinkedList) J).peekFirst()).longValue()) goto L140;
        Integer r32 = M.get(r31);
        r27.put(r31, r32);
        r29 = r29 + r32.intValue();
    L140:
        r28 = r28 + 1;
        goto L136
    L141:
        M = r27;
        FeatureManager.u.i("live_recharge_money_amount_in_last_minute", Integer.valueOf(r29), FeatureType.MONITOR);
        LongSparseArray<Integer> r33 = new LongSparseArray();
        int r34 = 0;
        int r110 = 0;
    L143:
        if (r34 >= N.size()) goto L148;
        long r35 = N.keyAt(r34);
        if (r35 < ((Number) ((LinkedList) J).peekFirst()).longValue()) goto L147;
        Integer r36 = N.get(r35);
        r33.put(r35, r36);
        r110 = r110 + r36.intValue();
    L147:
        r34 = r34 + 1;
        goto L143
    L148:
        N = r33;
        FeatureManager.u.i("live_recharge_money_amount_total_in_last_minute", Integer.valueOf(r110), FeatureType.MONITOR);
        goto L309
    L131:
        r23 = 0;
        goto L132
    L127:
        d.d("live_recharge_room_count_in_last_minute", L, r14, Q);
        goto L128
    L150:
        if (r24.equals("livesdk_gift_show") == false) goto L309;
        int r37 = j;
        if (r37 != 0) goto L154;
        l++;
        FeatureManager.u.i("live_gift_panel_show_room_count", Integer.valueOf(l), FeatureType.MONITOR);
        d.c("live_gift_panel_show_room_count_in_last_minute", F, Q);
    L155:
        j++;
        k++;
        FeatureManager r38 = FeatureManager.u;
        Integer r39 = Integer.valueOf(j);
        FeatureType r41 = FeatureType.MONITOR;
        r38.i("live_gift_panel_show_count", r39, r41);
        r38.i("live_gift_panel_show_count_total", Integer.valueOf(k), r41);
        d.c("live_gift_panel_show_count_in_last_minute", D, Q);
        d.c("live_gift_panel_show_count_total_in_last_minute", E, Q);
        TTExecutors.getNormalExecutor().submit(new k(false));
        goto L309
    L154:
        d.d("live_gift_panel_show_room_count_in_last_minute", F, r37, Q);
        goto L155
    L157:
        if (r24.equals("livesdk_live_backstage_watch_duration") == false) goto L309;
        FeatureManager r42 = FeatureManager.u;
        String r43 = r25.get("is_allowed");
        if (r43 != null) goto L161;
        r43 = -1;
    L161:
        r42.i("is_backstage_allowed", r43, FeatureType.DYNAMIC);
        r42.i("is_backstage", Boolean.FALSE, FeatureType.DYNAMIC_MONITOR);
        goto L309
    L163:
        if (r24.equals("livesdk_mini_window_live_duration") == false) goto L309;
        String r44 = r25.get("duration");
        if (r44 == null) goto L167;
        FeatureManager.u.i("mini_window_show_duration", Long.valueOf(CastLongProtector.parseLong(r44)), FeatureType.DYNAMIC);
        UserFeatureInRoomFilter r45 = y1;
        long r46 = CastLongProtector.parseLong(r44);
        r45.getClass();
        TTExecutors.getNormalExecutor().submit(new UserFeatureInRoomFilter$updateMiniWindowShowDuration$1(false, r46));
    L167:
        FeatureManager.u.i("is_mini_window_status", r3, FeatureType.MONITOR);
        goto L309
    L169:
        if (r24.equals("livesdk_send_gift") == false) goto L309;
        int r47 = m;
        if (r47 != 0) goto L173;
        o++;
        FeatureManager.u.i("live_gift_send_room_count", Integer.valueOf(o), FeatureType.MONITOR);
        d.c("live_gift_send_room_count_in_last_minute", I, Q);
    L174:
        m++;
        n++;
        FeatureManager r48 = FeatureManager.u;
        Integer r49 = Integer.valueOf(m);
        FeatureType r51 = FeatureType.MONITOR;
        r48.i("live_gift_send_count", r49, r51);
        r48.i("live_gift_send_count_total", Integer.valueOf(n), r51);
        d.c("live_gift_send_count_in_last_minute", G, Q);
        d.c("live_gift_send_count_total_in_last_minute", H, Q);
        goto L309
    L173:
        d.d("live_gift_send_room_count_in_last_minute", I, r47, Q);
        goto L174
    L176:
        if (r24.equals("livesdk_live_backstage_watch_start") == false) goto L309;
        FeatureManager r52 = FeatureManager.u;
        String r53 = r25.get("is_allowed");
        if (r53 != null) goto L180;
        r53 = -1;
    L180:
        r52.i("is_backstage_allowed", r53, FeatureType.DYNAMIC);
        r52.i("is_backstage", Boolean.TRUE, FeatureType.DYNAMIC_MONITOR);
        goto L309
    L182:
        if (r24.equals("livesdk_audience_live_message") == false) goto L309;
        v++;
        FeatureManager.u.i("live_comment_count", Integer.valueOf(v), FeatureType.MONITOR);
        c0 r54 = c0.a;
        List<String> r55 = r54.getValue().getLiveFuzzyCommentStringList();
        List<String> r56 = r54.getValue().getLiveNotFuzzyCommentStringList();
        if (r55 == null) goto L309;
        Iterator<String> r57 = r55.iterator();
    L187:
        if (r57.hasNext() == false) goto L309;
        String r111 = r57.next();
        if (r25 == null) goto L191;
        String r58 = r25.get("prompt");
    L193:
        if (StringsKt.indexOf$default(String.valueOf(r58), r111, 0, false, 6, null) == (-1)) goto L187;
        if (r56 == null) goto L205;
        Iterator<String> r59 = r56.iterator();
    L197:
        if (r59.hasNext() == false) goto L205;
        String r112 = r59.next();
        if (r25 == null) goto L201;
        String r61 = r25.get("prompt");
    L203:
        if (StringsKt.indexOf$default(String.valueOf(r61), r112, 0, false, 6, null) == (-1)) goto L197;
    L201:
        r61 = null;
    L205:
        UserFeatureInRoomFilter r62 = y1;
        int r63 = r62.g().a("key_live_fuzzy_comment_count") + 1;
        z90.a.C0301a.a(FeatureManager.u, "live_fuzzy_count", Integer.valueOf(r63));
        r62.g().e("key_live_fuzzy_comment_count", Integer.valueOf(r63));
        goto L309
    L191:
        r58 = null;
        goto L193
    L207:
        if (r24.equals("livesdk_performance_definition_monitor") == false) goto L309;
        FeatureManager.u.i("definition", r25.get("definition"), FeatureType.DYNAMIC);
        TTExecutors.getNormalExecutor().submit(new n(false, r25));
        TTExecutors.getNormalExecutor().submit(new j(false, r25));
        goto L309
    L210:
        if (r24.equals("livesdk_unfollow") == false) goto L309;
        z90.a.C0301a.a(FeatureManager.u, "is_fans", Boolean.FALSE);
        goto L309
    L213:
        if (r24.equals("livesdk_live_leave") == false) goto L309;
        FeatureManager.u.g("inner_room_index");
        Iterator r64 = CollectionsKt.listOf(new String[]{"live_end", "drawer"}).iterator();
    L216:
        if (r64.hasNext() == false) goto L226;
        String r65 = (String) r64.next();
        Object r66 = r19;
        String r67 = r25.get(r66);
        if (r67 == null) goto L224;
        if (StringsKt.contains$default(r67, r65, false, 2, null) != true) goto L224;
        if (TextUtils.equals(r25.get("leave_type"), "draw") == false) goto L224;
        return;
    L224:
        r19 = r66;
        goto L216
    L226:
        if (R == 0) goto L228;
        FeatureManager.u.i("duration_session", Long.valueOf((System.currentTimeMillis() - R) / ((long) 1000)), FeatureType.DYNAMIC);
        R = 0;
    L228:
        V0 = System.currentTimeMillis();
        FeatureManager r68 = FeatureManager.u;
        r68.i("enter_inner_live_scene", Boolean.valueOf(!P), FeatureType.MONITOR);
        z90.a.C0301a.a(r68, "drawer_preload_count", r3);
        r68.g("drawer_preload_time");
        r68.g("drawer_open_time");
        b = 0;
        P = true;
        k(true);
        TTExecutors.getNormalExecutor().submit(new o(true));
        TTExecutors.getNormalExecutor().submit(new p(true));
        j(false);
        h();
        r68.g("live_selected_position");
        goto L309
    L230:
        if (r24.equals("livesdk_follow") == false) goto L309;
        z90.a.C0301a.a(FeatureManager.u, "is_fans", Boolean.TRUE);
        goto L309
    L233:
        if (r24.equals("livesdk_mini_window_live_play") == false) goto L309;
        String r69 = r25.get("duration");
        if (r69 == null) goto L237;
        FeatureManager.u.i("mini_window_load_duration", Long.valueOf(CastLongProtector.parseLong(r69)), FeatureType.DYNAMIC);
        UserFeatureInRoomFilter r71 = y1;
        long r72 = CastLongProtector.parseLong(r69);
        r71.getClass();
        TTExecutors.getNormalExecutor().submit(new UserFeatureInRoomFilter$updateMiniWindowLoadDuration$1(false, r72));
    L237:
        FeatureManager.u.i("is_mini_window_status", 1, FeatureType.MONITOR);
        goto L309
    L239:
        if (r24.equals("livesdk_live_duration") == false) goto L309;
        String r73 = r25.get("duration");
        if (r73 == null) goto L243;
        Long r74 = Long.valueOf(CastLongProtector.parseLong(r73));
    L244:
        if (r74 == null) goto L255;
        long r75 = r74.longValue() / 1000;
        FeatureManager.u.i("duration", Long.valueOf(r75), FeatureType.DYNAMIC_MONITOR);
        ((ConcurrentLinkedDeque) d).offerLast(Long.valueOf(r75));
    L246:
        ConcurrentLinkedDeque r76 = (ConcurrentLinkedDeque) d;
        int r77 = r76.size();
        FeatureManager r78 = FeatureManager.u;
        r78.getClass();
        if (r77 <= FeatureManager.g) goto L250;
        r76.pollFirst();
        goto L246
    L250:
        if ((!r76.isEmpty()) == false) goto L253;
        r78.i("live_watch_duration_avg", Long.valueOf(CollectionsKt.sumOfLong(r76) / ((long) r76.size())), FeatureType.MONITOR);
    L253:
        if (f < (FeatureManager.i * 60)) goto L255;
        int r79 = u + 1;
        u = r79;
        r78.i("live_watch_room_count", Integer.valueOf(r79), FeatureType.MONITOR);
        UserFeatureInRoomFilter r81 = y1;
        Deque<Long> r82 = O;
        long r83 = Q;
        r81.getClass();
        d.c("live_watch_room_count_in_last_minute", r82, r83);
    L255:
        d.d("live_like_room_amount_in_last_minute", C, g, Q);
        d.d("live_gift_panel_show_room_count_in_last_minute", F, j, Q);
        d.d("live_gift_send_room_count_in_last_minute", I, m, Q);
        d.d("live_recharge_room_count_in_last_minute", L, p, Q);
        FeatureManager r84 = FeatureManager.u;
        if (((Number) r84.getFeature("hotroom_transform", -1)).intValue() == (-1)) goto L262;
        Z++;
        long r85 = p0;
        if (r74 == null) goto L260;
        long r86 = r74.longValue();
    L261:
        p0 = r85 + r86;
    L267:
        long r87 = Z;
        if (r87 != 0) goto L270;
        Long r88 = null;
    L271:
        FeatureType r89 = FeatureType.DYNAMIC;
        r84.i("hotroom_watch_duration_avg", r88, r89);
        long r91 = k0;
        if (r91 != 0) goto L274;
        Long r92 = null;
    L275:
        r84.i("nothotroom_watch_duration_avg", r92, r89);
        r84.i("hotroom_transform", -1, r89);
        IRoomContextService r93 = jc1.k.f(IRoomContextService.class);
        if (r93 == null) goto L280;
        Room r94 = null;
        com.bytedance.android.livesdk.chatroom.o r95 = IRoomContextService.a.a(r93, null, 0, 3);
        if (r95 == null) goto L281;
        Room r113 = r95.o2();
    L282:
        i(r113);
        r84.g("show_cart");
        h();
        k(false);
        z90.a.C0301a.a(r84, "background_handle_enable", Boolean.TRUE);
        return;
    L281:
        r113 = r94;
        goto L282
    L280:
        r94 = null;
        goto L281
    L274:
        r92 = Long.valueOf(H0 / r91);
        goto L275
    L270:
        r88 = Long.valueOf(p0 / r87);
        goto L271
    L260:
        r86 = 0;
        goto L261
    L262:
        k0++;
        long r96 = H0;
        if (r74 == null) goto L265;
        long r97 = r74.longValue();
    L266:
        H0 = r96 + r97;
        goto L267
    L265:
        r97 = 0;
        goto L266
    L243:
        r74 = null;
    L309:
        return;
    L84:
        r3 = 0;
        if (r24.equals("livesdk_live_hotroom_transform") == false) goto L98;
        String r98 = r25.get("is_transform");
        if (r98 == null) goto L285;
        FeatureManager.u.i("hotroom_transform", Integer.valueOf(CastIntegerProtector.parseInt(r98)), FeatureType.DYNAMIC);
        goto L285
    L89:
        r3 = 0;
        if (r24.equals("livesdk_live_switch_resolution_cost") == false) goto L98;
        if ((!Intrinsics.areEqual(r25.get("errorcode"), "0")) == false) goto L285;
        FeatureManager r99 = FeatureManager.u;
        r99.i("smooth_switch_error", Integer.valueOf(((Number) r99.getFeature("smooth_switch_error", null)).intValue() + 1), FeatureType.MONITOR);
        goto L285
    L94:
        r3 = 0;
        if (r24.equals("livesdk_anchor_close_live_confirm") == false) goto L98;
        L0 = Long.MAX_VALUE;
        V0 = Q;
        goto L285
    L307:
        r3 = 0;
        goto L98
    L6:
        if (r24.equals("livesdk_more_anchor_show") == false) goto L77;
        FeatureManager r100 = FeatureManager.u;
        z90.a.C0301a.a(r100, "drawer_open_time", Long.valueOf(System.currentTimeMillis()));
        z90.a.C0301a.a(r100, "drawer_open_time_app", Long.valueOf(System.currentTimeMillis()));
        goto L285
    L77:
        r3 = 0;
        goto L98
    L9:
        if (r24.equals("livesdk_enter_room_from_window_duration") == false) goto L305;
        String r101 = r25.get("enter_method");
        if (r101 == null) goto L285;
        if (Intrinsics.areEqual(r101, "live_cell") == false) goto L285;
        String r102 = r25.get("duration");
        if (r102 == null) goto L17;
        Long r114 = Long.valueOf(CastLongProtector.parseLong(r102));
    L19:
        if (FeatureManager.u.i("preview_stay_duration", r114, FeatureType.DYNAMIC) == false) goto L285;
        UserFeatureInRoomFilter r103 = y1;
        Intrinsics.checkNotNull(r114);
        long r104 = r114.longValue();
        r103.getClass();
        TTExecutors.getNormalExecutor().submit(new m(r104));
        goto L285
    L17:
        r114 = null;
        goto L19
    L305:
        r3 = 0;
        goto L98
    L22:
        if (r24.equals("livesdk_enter_room_duration") == true) goto L24;
        r3 = 0;
        goto L98
    L24:
        if (P == false) goto L32;
        V0 = Long.MAX_VALUE;
        FeatureManager r105 = FeatureManager.u;
        Boolean r106 = Boolean.valueOf(!P);
        FeatureType r107 = FeatureType.MONITOR;
        r105.i("enter_inner_live_scene", r106, r107);
        Boolean r108 = Boolean.FALSE;
        if (((Boolean) r105.getFeature("enter_inner_live_app", r108)).booleanValue() == true) goto L28;
        r105.i("enter_inner_live_app", Boolean.TRUE, r107);
    L28:
        P = false;
        R = System.currentTimeMillis();
        if (((Boolean) r105.getFeature("live_quit_dialog_showed_already", r108)).booleanValue() == true) goto L31;
        z90.a.C0301a.a(r105, "live_quit_dialog_showed_already", r108);
    L31:
        j(true);
    L32:
        e = Q;
        FeatureManager r109 = FeatureManager.u;
        z90.a.C0301a.a(r109, "inner_room_order_app", Integer.valueOf(((Number) r109.getFeature("inner_room_order_app", 0)).intValue() + 1));
        ((ConcurrentLinkedDeque) d).offerLast(0L);
    L33:
        ConcurrentLinkedDeque r115 = (ConcurrentLinkedDeque) d;
        int r116 = r115.size();
        FeatureManager r117 = FeatureManager.u;
        r117.getClass();
        if (r116 <= FeatureManager.g) goto L36;
        r115.pollFirst();
        goto L33
    L36:
        b++;
        h();
        d.c("live_watch_count_in_last_minute", c, Q);
        T++;
        String r118 = r25.get("is_fans");
        if (r118 != null) goto L39;
    L42:
        z90.a.C0301a.a(r117, "enter_action_type", r25.get("action_type"));
        z90.a.C0301a.a(r117, "enter_from_merge", r25.get("enter_from_merge"));
        z90.a.C0301a.a(r117, "enter_method", r25.get("enter_method"));
        IRoomContextService r119 = jc1.k.f(IRoomContextService.class);
        if (r119 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.o r120 = IRoomContextService.a.a(r119, null, 0, 3);
        if (r120 == null) goto L47;
        Room r121 = r120.o2();
    L48:
        if (r121 == null) goto L50;
        String r122 = r121.isEcomCart();
    L52:
        if (TextUtils.equals(r122, GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L60;
        if (r121 == null) goto L59;
        IRoomCart r123 = r121.getRoomCart();
        if (r123 == null) goto L59;
        if (r123.getShowCartExt() == 1) goto L60;
    L59:
        r11 = 0;
    L60:
        z90.a.C0301a.a(r117, "show_cart", Integer.valueOf(r11));
        i(r121);
        ILivePlayerClient r124 = f();
        if (r124 == null) goto L67;
        LivePlayerClientContext r125 = r124.context();
        if (r125 == null) goto L67;
        ILivePlayerScene r126 = r125.getCreateScene();
        if (r126 == null) goto L67;
        String r127 = r126.getScene();
    L68:
        z90.a.C0301a.a(r117, "player_create_scene", r127);
        ILivePlayerClient r128 = f();
        if (r128 == null) goto L75;
        LivePlayerClientContext r129 = r128.context();
        if (r129 == null) goto L75;
        ILivePlayerScene r130 = r129.getUseScene();
        if (r130 == null) goto L75;
        String r131 = r130.getScene();
    L76:
        z90.a.C0301a.a(r117, "player_use_scene", r131);
        k(false);
    L75:
        r131 = null;
    L67:
        r127 = null;
        goto L68
    L50:
        r122 = null;
    L47:
        r121 = null;
        goto L48
    L39:
        if (r118.equals(GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L41;
        S++;
    L41:
        z90.a.C0301a.a(r117, "is_fans", Boolean.valueOf(TextUtils.equals(r118, GamePromoteDataContext.GAME_TYPE_MOBILE)));
        goto L42
    }
}
