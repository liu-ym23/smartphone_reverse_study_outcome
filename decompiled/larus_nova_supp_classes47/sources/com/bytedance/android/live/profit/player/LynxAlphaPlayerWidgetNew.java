package com.bytedance.android.live.profit.player;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/player/LynxAlphaPlayerWidgetNew;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxAlphaPlayerWidgetNew extends LiveRecyclableWidget {
    public static final /* synthetic */ int i = 0;
    public zy0.b a;
    public com.bytedance.android.live.profit.player.a b;
    public final List<com.bytedance.android.live.profit.player.a> c;
    public final CompositeDisposable d;
    public final CompositeDisposable e;
    public q f;
    public ca0.q g;
    public long h;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ PlayerService a;

        public b(PlayerService r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.f.onNext(sh6.a.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LynxAlphaPlayerWidgetNew a;

        public c(LynxAlphaPlayerWidgetNew r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            Object r13 = sh6.c.b((sh6.b) r12);
            if (r13 == null) goto L40;
            com.bytedance.android.live.profit.player.a r14 = (com.bytedance.android.live.profit.player.a) r13;
            LynxAlphaPlayerWidgetNew r0 = this.a;
            if (r0.a != null) goto L38;
            long r1 = System.currentTimeMillis();
            ReadOnlyProperty r3 = r.b;
            KProperty[] r4 = r.a;
            LynxView r7 = null;
            String r5 = (String) r3.getValue(null, r4[0]);
            ALogger.w("LynxAlphaPlayerWidgetNew", "load card");
            if (((Widget) r0).context != null) goto L10;
            ALogger.w("LynxAlphaPlayerWidgetNew", "context is null");
            return;
        L10:
            if (r5.length() != 0) goto L12;
            boolean r6 = true;
        L13:
            if (r6 == false) goto L15;
            r0.yq("schema is empty");
            return;
        L15:
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r8 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(((Widget) r0).context, UriProtector.parse(r5), new LynxAlphaPlayerWidgetNew$loadCard$card$1(r0));
            if (r8 != null) goto L18;
            r0.yq("createCard returned null");
            return;
        L18:
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r9 = r8.d;
            if (r9 == null) goto L21;
            r9.registerMethod("dressPlayFinish", new i(r0));
        L21:
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r10 = r8.d;
            if (r10 == null) goto L24;
            r10.registerMethod("dressPlayClick", new j(r0));
        L24:
            r0.b = r14;
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r15 = r8.d;
            if (r15 == null) goto L27;
            r15.b(MapsKt.mapOf(TuplesKt.to("initPlayData", r0.Aq(r14))));
        L27:
            r0.a = r8;
            LynxView r16 = r8.c;
            if (((Boolean) r.e.getValue(null, r4[3])).booleanValue() == true) goto L31;
        L37:
            q r17 = new q(0);
            long r18 = System.currentTimeMillis();
            r17.a = r1;
            r17.b = r18;
            Unit r2 = Unit.INSTANCE;
            r0.f = r17;
            return;
        L31:
            if ((r16 instanceof LynxView) == false) goto L35;
            r7 = r16;
        L35:
            if (r7 == null) goto L37;
            LynxView r19 = r16;
            com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).injectLiveLynxCanvasTTPlayer(r19, r19.getContext(), "lynx_alpha_player");
            goto L37
        L12:
            r6 = false;
            goto L13
        L38:
            ((ArrayList) r0.c).add(r14);
            r0.wq();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LynxAlphaPlayerWidgetNew a;

        public d(LynxAlphaPlayerWidgetNew r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            LynxAlphaPlayerWidgetNew r5 = this.a;
            int r0 = LynxAlphaPlayerWidgetNew.i;
            r5.xq(false, "cleanup timer");
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566876;
    }

    public final void onUnload() {
        this.e.clear();
        xq(false, "widget unload");
    }

    public final boolean wq() {
        zy0.b r0 = this.a;
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (this.b != null) goto L15;
        if (((ArrayList) this.c).size() <= 0) goto L15;
        com.bytedance.android.live.profit.player.a r1 = (com.bytedance.android.live.profit.player.a) ListProtector.remove(this.c, 0);
        ALogger.w("LynxAlphaPlayerWidgetNew", "playing dress " + r1);
        this.d.clear();
        this.b = r1;
        q r2 = this.f;
        if (r2 == null) goto L11;
        r2.d++;
    L11:
        xy0.a<?> r3 = r0.g();
        if (r3 == null) goto L14;
        r3.sendJsEvent("DressPlay", Aq(r1));
    L14:
        return true;
    }

    public LynxAlphaPlayerWidgetNew() {
        this.c = new ArrayList();
        this.d = new CompositeDisposable();
        this.e = new CompositeDisposable();
    }

    public final JSONObject Aq(com.bytedance.android.live.profit.player.a r7) {
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("_playId", r7.a);
        r0[1] = TuplesKt.to("centerY", Float.valueOf(s1.G(((Widget) this).contentView.getHeight()) - r7.e));
        r0[2] = TuplesKt.to("dressId", r7.b);
        Handler r1 = UtilityKotlinExtentionsKt.a;
        JSONObject r2 = new JSONObject();
        Map<String, c5> r3 = r7.c;
        if (r3 == null) goto L8;
        Iterator<Map.Entry<String, c5>> r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Map.Entry<String, c5> r5 = r4.next();
        String r6 = r5.getKey();
        c5 r8 = r5.getValue();
        r2.put(r6, tv5.a.a(GsonHelper.get(), r8));
    L8:
        Unit r9 = Unit.INSTANCE;
        r0[3] = TuplesKt.to("pieceValues", r2);
        r0[4] = TuplesKt.to("avatarThumb", r7.d);
        return UtilityKotlinExtentionsKt.o(r0);
    }

    public final void onInit(Object[] r3) {
        ALogger.d("LynxAlphaPlayerWidgetNew", "onInit");
        this.h = System.currentTimeMillis();
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.live.profit.player.d r4 = yt0.c.h();
        if ((r4 instanceof PlayerService) == true) goto L5;
        r4 = null;
    L5:
        PlayerService r5 = (PlayerService) r4;
        if (r5 != null) goto L8;
        return;
    L8:
        RxUtilKt.c(r5.f.observeOn(AndroidSchedulers.mainThread()).doOnDispose(new b(r5)).subscribe(new c(this)), this.e);
    }

    public final void yq(String r3) {
        xq(true, "lynx container load failed: " + r3);
    }

    public final void xq(boolean r3, String r4) {
        zy0.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L23;
        ((ViewGroup) r1).removeAllViews();
        this.b = null;
        this.f = null;
        ca0.q r2 = this.g;
        if (r2 == null) goto L10;
        r2.clearData();
    L10:
        this.g = null;
        if (r3 == false) goto L16;
        ALogger.e("LynxAlphaPlayerWidgetNew", "cleanup with failure: " + r4);
        Iterator<T> r5 = this.c.iterator();
    L14:
        if (r5.hasNext() == false) goto L20;
        ((com.bytedance.android.live.profit.player.a) r5.next()).h.invoke(new Throwable(r4));
    L20:
        this.d.clear();
        ((ArrayList) this.c).clear();
        return;
    L16:
        ALogger.w("LynxAlphaPlayerWidgetNew", "cleanup: reason=" + r4);
        Iterator<T> r6 = this.c.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        ((com.bytedance.android.live.profit.player.a) r6.next()).g.invoke();
        goto L18
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void zq(boolean r6, String r7) {
        if (r6 == false) goto L9;
        ALogger.w("LynxAlphaPlayerWidgetNew", "play finish successfully, playingData=" + this.b);
        com.bytedance.android.live.profit.player.a r0 = this.b;
        if (r0 == null) goto L14;
        Function0<Unit> r1 = r0.g;
        if (r1 == null) goto L14;
        Unit r2 = (Unit) r1.invoke();
    L14:
        ca0.q r3 = this.g;
        if (r3 == null) goto L17;
        r3.stop();
    L17:
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("stay_room_duration", String.valueOf((System.currentTimeMillis() - this.h) / ((long) WebcastRedirectException.UNKNOWN)));
        if (r6 == false) goto L20;
        String r8 = DataType.FALSE;
    L21:
        r4.put("lynx_load_failed", r8);
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        r4.put("error_msg", r7);
        r4.put("is_perf_opt", DataType.TRUE);
        com.bytedance.android.live.profit.player.a r9 = this.b;
        if (r9 == null) goto L27;
        r4.put("dress_id", r9.b);
    L27:
        q r10 = this.f;
        if (r10 == null) goto L30;
        r4.put("lynx_init_time", String.valueOf(r10.b - r10.a));
        r4.put("lynx_loaded_time", String.valueOf(r10.c - r10.a));
        r4.put("play_times", String.valueOf(r10.d));
        r4.put("total_play_time", String.valueOf(System.currentTimeMillis() - r10.a));
    L30:
        com.bytedance.android.livesdk.revenue.service.performance.c r12 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        r4.put("cpu_rate", String.valueOf(r12.getCpuRate()));
        r4.put("gpu_used", String.valueOf(r12.getGpuUsed()));
        r4.put("mem_pss_total", String.valueOf(r12.getPssTotal() / ((long) 1024)));
        r4.put("temperature", String.valueOf(r12.getTemperature()));
        r4.put("ui_fps", String.valueOf(r12.getFps()));
        r4.put("ui_stall_rate", String.valueOf(r12.F3()));
        r4.put("battery_current", String.valueOf(r12.ql()));
        ca0.q r13 = this.g;
        if (r13 == null) goto L37;
        Map r14 = r13.c();
        if (r14 == null) goto L37;
        r4.putAll(r14);
        ca0.q r15 = this.g;
        if (r15 == null) goto L37;
        r15.clearData();
    L37:
        mz0.n r16 = new mz0.n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r17.putAll(r4);
        mz0.m r18 = new mz0.m();
        r18.b(LogCommon.ROOM);
        ((ArrayList) r16.b).addAll(r18.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3("livesdk_rd_lynx_alpha_player_metrics", r16.a, r16.b);
        IGiftService r22 = jc1.k.f(IGiftService.class);
        if (r22 == null) goto L42;
        ca0.o r23 = r22.getLiveRevenueEventCenter();
        if (r23 == null) goto L42;
        r23.a();
    L42:
        this.b = null;
        if (wq() == false) goto L45;
        return;
    L45:
        if (r.a() <= 0) goto L48;
        RxUtilKt.c(Observable.timer(r.a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)), this.d);
        return;
    L48:
        if (r.a() != 0) goto L53;
        xq(false, "cleanup timer");
        return;
    L53:
        return;
    L20:
        r8 = DataType.TRUE;
        goto L21
    L9:
        ALogger.e("LynxAlphaPlayerWidgetNew", "play failed, playingData=" + this.b + ", msg=" + r7);
        com.bytedance.android.live.profit.player.a r5 = this.b;
        if (r5 == null) goto L14;
        Function1<Throwable, Unit> r24 = r5.h;
        if (r24 == null) goto L14;
        Unit r25 = (Unit) r24.invoke(new Throwable(r7));
        goto L14
    }
}
