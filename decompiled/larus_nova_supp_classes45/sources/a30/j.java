package a30;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectEnableResultModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import dq2.r;
import fr2.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.g6;
import w20.ne;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends g6<ne, SetEffectEnableResultModel> {
    public final vy0.c a;
    public final CompositeDisposable b;
    public final b c;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.revenue.service.effect.g {
        public b() {
        }

        public final void onResult(int r1) {
        }
    }

    public static final class c implements ca0.h {
        public final /* synthetic */ j a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ca0.i c;

        @Override // ca0.h
        public final void onResult(int r9) {
            boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
            p11.i r1 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getLinkRegionService();
            if (this.b == false) goto L9;
            if (r1 == null) goto L7;
            Pair r2 = r1.getSurfaceSize();
            if (r2 == null) goto L7;
        L8:
            this.c.k(((Number) r2.getFirst()).intValue(), ((Number) r2.getSecond()).intValue(), this.b);
            jy0.b.a("SetEffectEnableMethod", "setMixOutput, surfaceSize = " + r2);
        L7:
            r2 = new Pair(0, 0);
        L9:
            if (r1 == null) goto L11;
            Map r3 = r1.getRevStreamRegions();
        L12:
            JSONObject r4 = new JSONObject();
            JSONArray r5 = new JSONArray();
            if (r3 == null) goto L18;
            Iterator r6 = r3.entrySet().iterator();
        L16:
            if (r6.hasNext() == false) goto L18;
            Map.Entry r7 = (Map.Entry) r6.next();
            JSONObject r8 = new JSONObject();
            r8.put("areaKey", ((r) r7.getValue()).a);
            r8.put("x", Float.valueOf(((r) r7.getValue()).b));
            r8.put("y", Float.valueOf(((r) r7.getValue()).c));
            r8.put("w", Float.valueOf(((r) r7.getValue()).d));
            r8.put("h", Float.valueOf(((r) r7.getValue()).e));
            Unit r11 = Unit.INSTANCE;
            r5.put(r8);
        L18:
            r4.put("LiveGrids", r5);
            String r12 = r4.toString();
            jy0.b.a("SetEffectEnableMethod", "renderCache = " + r12);
            this.c.j(r12, this.b);
            if (r9 != 0) goto L21;
            this.a.k("enable success, callback result = " + r9);
            return;
        L21:
            this.a.j("enable failure, callback result = " + r9);
            return;
        L11:
            r3 = null;
            goto L12
        }

        public c(j r1, boolean r2, ca0.i r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements ca0.h {
        public final /* synthetic */ j a;

        public d(j r1) {
            this.a = r1;
        }

        @Override // ca0.h
        public final void onResult(int r4) {
            this.a.k("disable success, callback result = " + r4);
        }
    }

    public static final class e implements ca0.f {
        public e(j r1) {
        }
    }

    static {
    }

    public final void onTerminate() {
        this.b.dispose();
    }

    public j() {
        this.a = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        this.b = new CompositeDisposable();
        this.c = new b();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.b.dispose();
    }

    public final void j(String r5) {
        jy0.b.c("SetEffectEnableMethod", "fail: " + r5, null, 4);
        SetEffectEnableResultModel r0 = new SetEffectEnableResultModel();
        r0.a(SetEffectEnableResultModel.Code.Failed);
        r0.c(r5);
        finishWithResult(r0);
    }

    public final void k(String r4) {
        jy0.b.d("SetEffectEnableMethod", "finish: " + r4);
        SetEffectEnableResultModel r0 = new SetEffectEnableResultModel();
        r0.a(SetEffectEnableResultModel.Code.Success);
        JsonObject r1 = new JsonObject();
        r1.addProperty("message", r4);
        Unit r5 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
    }

    public final void l(ne r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        boolean r0 = m.e();
        boolean r1 = m.g();
        StringBuilder r2 = new StringBuilder("setUp, enable = ");
        r2.append(r14.a());
        r2.append(", scene = ");
        ne.a r3 = r14.b();
        Boolean r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.b();
    L6:
        r2.append(r5);
        r2.append(", isInit = ");
        r2.append(r0);
        r2.append(", isLiveCore = ");
        r2.append(r1);
        jy0.b.d("SetEffectEnableMethod", r2.toString());
        p11.i r6 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionService();
        ne.a r7 = r14.b();
        if (r7 == null) goto L10;
        String r8 = r7.b();
        if (r8 == null) goto L10;
    L11:
        ne.a r9 = r14.b();
        if (r9 == null) goto L14;
        Integer r11 = r9.c();
    L15:
        ne.a r12 = r14.b();
        if (r12 == null) goto L18;
        Boolean r13 = r12.a();
    L19:
        Boolean r15 = Boolean.TRUE;
        boolean r16 = Intrinsics.areEqual(r13, r15);
        boolean r17 = true;
        if ((!Intrinsics.areEqual(r14.a(), r15)) == false) goto L26;
        if (r0 == false) goto L24;
        if (r6 == null) goto L24;
        r6.enableRenderFilter(r8, false, r16);
    L24:
        k("disable success, linkService = " + r6);
        return;
    L26:
        if (r0 == true) goto L28;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class).providerResourceFinder();
        jy0.b.f("SetEffectEnableMethod", "resourceFilter is null", null, 4);
        return;
    L28:
        if (m.d() == false) goto L79;
        GiftContext r18 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r18 == null) goto L38;
        com.bytedance.live.datacontext.i r19 = r18.getLoadedEffectResourceMap();
        if (r19 == null) goto L38;
        Map r21 = (Map) r19.getValue();
        if (r21 == null) goto L38;
        CopyOnWriteArrayList r22 = (CopyOnWriteArrayList) r21.get(r8);
        if (r22 == null) goto L38;
        int r23 = r22.size();
    L39:
        if (r23 <= 0) goto L79;
        jy0.b.a("SetEffectEnableMethod", "remove with delay");
        Intrinsics.checkNotNullParameter(r8, "scene");
        GiftContext r24 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r24 == null) goto L45;
        com.bytedance.live.datacontext.m r25 = r24.getGiftRenderFilterWrapper();
        if (r25 == null) goto L45;
        ca0.i r26 = (ca0.i) r25.getValue();
    L47:
        if (Intrinsics.areEqual(r8, "") == false) goto L54;
        if (r26 == null) goto L54;
        if (r26.d() != true) goto L54;
        if (r26.f() == true) goto L54;
    L78:
        n(this, "removeAndEnableWithDelay");
    L83:
        if (r11 != null) goto L85;
        return;
    L85:
        if (r11.intValue() == 0) goto L105;
        GiftContext r27 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r27 == null) goto L91;
        com.bytedance.live.datacontext.m r28 = r27.getGiftRenderFilterWrapper();
        if (r28 == null) goto L91;
        ca0.i r29 = (ca0.i) r28.getValue();
    L92:
        if (r29 != null) goto L94;
        return;
    L94:
        if (r11.intValue() == 1) goto L97;
        r17 = false;
    L97:
        ne.a r110 = r14.b();
        if (r110 == null) goto L100;
        r4 = r110.a();
    L100:
        r29.m(r17, r1, r8, Intrinsics.areEqual(r4, r15));
        return;
    L91:
        r29 = null;
        goto L92
    L105:
        return;
    L54:
        GiftContext r31 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r31 == null) goto L67;
        com.bytedance.live.datacontext.i r32 = r31.getLoadedEffectResourceMap();
        if (r32 == null) goto L67;
        Map r33 = (Map) r32.getValue();
        if (r33 == null) goto L67;
        CopyOnWriteArrayList r34 = (CopyOnWriteArrayList) r33.get(r8);
        if (r34 == null) goto L67;
        Object[] r35 = r34.toArray(new String[0]);
        if (r35 == null) goto L66;
        String[] r36 = (String[]) r35;
    L68:
        if (r36 != null) goto L70;
    L77:
        RxUtilKt.c(Observable.timer(100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r8)), this.b);
        goto L78
    L70:
        if (m.g() == false) goto L74;
        ca0.b r37 = m.c();
        jy0.b.a("SetEffectEnableMethod", "removeAndEnableWithDelay, isLiveCore = true, stickerHandler = " + r37);
        if (r37 == null) goto L77;
        r37.x(r36);
        goto L77
    L74:
        or2.j r38 = m.a();
        jy0.b.a("SetEffectEnableMethod", "removeAndEnableWithDelay, isLiveCore = false, livePlayerClient = " + r38);
        if (r38 == null) goto L77;
        r38.h(r36, this.c);
        goto L77
    L66:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L67:
        r36 = null;
    L45:
        r26 = null;
    L38:
        r23 = 0;
    L79:
        jy0.b.a("SetEffectEnableMethod", "remove");
        if (r6 == null) goto L82;
        kc0.i.a.a(r6, r8);
    L82:
        k("enable success, linkService = " + r6);
        goto L83
    L18:
        r13 = null;
        goto L19
    L14:
        r11 = null;
    L10:
        r8 = "";
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    public final void m(ne r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        StringBuilder r0 = new StringBuilder("setUpNew, enable = ");
        r0.append(r15.a());
        r0.append(", scene = ");
        ne.a r1 = r15.b();
        Boolean r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.b();
    L6:
        r0.append(r3);
        jy0.b.d("SetEffectEnableMethod", r0.toString());
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.m r5 = r4.getGiftRenderFilterWrapper();
        if (r5 == null) goto L11;
        ca0.i r6 = (ca0.i) r5.getValue();
    L12:
        if (r6 != null) goto L15;
        j("giftRenderFilter is null");
        return;
    L15:
        boolean r11 = m.g();
        jy0.b.a("SetEffectEnableMethod", "isLiveCore = " + r11);
        if (r11 == false) goto L22;
        p r7 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLiveCore();
        if (r7 != null) goto L21;
        j("liveCore is null");
        return;
    L21:
        r6.e(new vc0.a(r7));
    L22:
        ne.a r8 = r15.b();
        if (r8 == null) goto L26;
        String r9 = r8.b();
        if (r9 == null) goto L26;
    L27:
        ne.a r12 = r15.b();
        if (r12 == null) goto L30;
        Integer r13 = r12.c();
    L31:
        Boolean r14 = r15.a();
        Boolean r16 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r16) == false) goto L34;
        ca0.i.a.a(r6, true, new e(this), new c(this, r11, r6), r11, r9, 32);
        n(this, "giftRenderFilter.setEnable");
    L39:
        if (r13 != null) goto L41;
        return;
    L41:
        if (r13.intValue() == 0) goto L52;
        boolean r17 = true;
        if (r13.intValue() == 1) goto L46;
        r17 = false;
    L46:
        ne.a r18 = r15.b();
        if (r18 == null) goto L49;
        r2 = r18.a();
    L49:
        r6.m(r17, r11, r9, Intrinsics.areEqual(r2, r16));
        return;
    L52:
        return;
    L34:
        d r19 = new d(this);
        ne.a r21 = r15.b();
        if (r21 == null) goto L37;
        Boolean r22 = r21.a();
    L38:
        r6.l(false, null, r19, r11, r9, Intrinsics.areEqual(r22, r16));
        n(this, "giftRenderFilter.setEnable");
        goto L39
    L37:
        r22 = null;
        goto L38
    L30:
        r13 = null;
    L26:
        r9 = "";
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static void n(j r3, String r4) {
        r3.getClass();
        RxUtilKt.c(RxUtilKt.h(Observable.timer(10000, TimeUnit.MILLISECONDS)).subscribe(new l(r3, r4)), r3.b);
    }

    public final void invoke(Object r2, CallContext r3) {
        ne r4 = (ne) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
    L8:
        th = move-exception;
        finishWithFailure(th);
        return;
    L4:
        if (com.bytedance.android.livesdk.gift.platform.core.h.q() == false) goto L6;
        m(r4);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        l(r4);     // Catch: Throwable -> L8
        goto L11
    }
}
