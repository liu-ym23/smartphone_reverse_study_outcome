package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import ca0.h;
import ca0.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rj0.l;
import uf2.d0;
import vm2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final Random i = null;
    public boolean a;
    public String b;
    public final List<bd0.b> c;
    public final boolean d;
    public final i e;
    public final cd0.a f;
    public final DataCenter g;
    public final ViewGroup h;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a$a, reason: collision with other inner class name */
    public static final class C0016a {
    }

    public static final class b implements h {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onResult(int r2) {
            this.a.e.g(true);
        }
    }

    public static final class c implements h {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void onResult(int r2) {
            this.a.e.g(false);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DataCenter r0 = this.a.g;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            nh0.f r1 = (nh0.f) r0.get("data_multi_link_dynamic_layout_info_change");     // Catch: Throwable -> L10
        L6:
            DataCenter r2 = this.a.g;     // Catch: Throwable -> L10
            if (r2 == null) goto L13;
            r2.put("data_multi_link_dynamic_layout_info_change", r1);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L5:
            r1 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class e implements h {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ int e;

        public final void onResult(int r11) {
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.b + ". Enable onResult:" + r11);
            boolean r3 = true;
            if (this.c == false) goto L27;
            Pair<Integer, Integer> r12 = this.a.d();
            vc0.a r4 = this.a.a();
            if (r4 == null) goto L7;
            Object r5 = r4.b;
        L9:
            if ((r5 instanceof d0) == true) goto L11;
            r5 = null;
        L11:
            d0 r6 = (d0) r5;
            if (r6 == null) goto L14;
            View r7 = r6.Y();
        L16:
            if ((r7 instanceof SurfaceView) == true) goto L18;
            r7 = null;
        L18:
            SurfaceView r8 = (SurfaceView) r7;
            i r9 = this.a.e;
            if (r8 == null) goto L21;
            int r10 = r8.getMeasuredWidth();
        L22:
            if (r8 == null) goto L24;
            int r13 = r8.getMeasuredHeight();
        L25:
            r9.k(r10, r13, true);
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.b + ". Enable use LiveCore, setMixOutput:" + r12);
            goto L27
        L24:
            r13 = ((Number) r12.getSecond()).intValue();
            goto L25
        L21:
            r10 = ((Number) r12.getFirst()).intValue();
            goto L22
        L14:
            r7 = null;
            goto L16
        L7:
            r5 = null;
        L27:
            if (((ArrayList) this.a.c).isEmpty() == true) goto L38;
            Iterator r14 = ((ArrayList) this.a.c).iterator();
        L30:
            if (r14.hasNext() == false) goto L36;
            bd0.b r15 = (bd0.b) r14.next();
            float r16 = 0;
            if (r15.d <= r16) goto L35;
            if (r15.e > r16) goto L30;
        L35:
            boolean r17 = false;
        L37:
            if (r17 == false) goto L38;
        L42:
            if (((ArrayList) this.a.c).isEmpty() == true) goto L44;
        L48:
            List<bd0.b> r18 = this.a.c;
            JSONObject r2 = new JSONObject();
            JSONArray r19 = new JSONArray();
            Iterator r110 = ((ArrayList) r18).iterator();
        L50:
            if (r110.hasNext() == false) goto L52;
            bd0.b r20 = (bd0.b) r110.next();
            r20.getClass();
            JSONObject r21 = new JSONObject();
            r21.put("areaKey", r20.a);
            r21.put("x", Float.valueOf(r20.b));
            r21.put("y", Float.valueOf(r20.c));
            r21.put("w", Float.valueOf(r20.d));
            r21.put("h", Float.valueOf(r20.e));
            r19.put(r21);
            goto L50
        L52:
            r2.put("LiveGrids", r19);
            String r111 = r2.toString();
            this.a.e.j(r111, this.c);
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.b + ". Enable setRenderCacheStringValue:" + r111);
            this.d.invoke(Boolean.TRUE);
            boolean r112 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
            if (this.e == 1) goto L56;
            r3 = false;
        L56:
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = r3;
            return;
        L44:
            if (((Boolean) k.h.getValue(null, k.a[6])).booleanValue() == true) goto L47;
            ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.b + ". Enable mStreamRegions is empty.", new Throwable());
            this.d.invoke(Boolean.FALSE);
            boolean r113 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = false;
            return;
        L47:
            ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.b + ". Enable mStreamRegions is empty. do not return", new Throwable());
            goto L48
        L36:
            r17 = true;
        L38:
            cd0.a r114 = this.a.f;
            if (r114 == null) goto L42;
            r114.Kc();
            goto L42
        }

        public e(a r1, long r2, boolean r4, Function1 r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class f implements h {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public f(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void onResult(int r4) {
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.a + ". Disable onResult:" + r4);
            this.b.invoke(Boolean.TRUE);
            boolean r5 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = false;
        }
    }

    public static final class g implements ca0.f {
        public g(long r1) {
        }
    }

    static {
        i = RandomKt.Random(System.currentTimeMillis());
    }

    public final vc0.a a() {
        if (this.d == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r0 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r0 == null) goto L44;
        hg6.g r1 = r0.R1();
        if (r1 == null) goto L44;
        ec6.b r2 = r1.R();
        if (r2 == null) goto L44;
        com.bytedance.android.live.pushstream.d r3 = gc6.b.a(r2);
        if (r3 == null) goto L44;
        d0 r4 = r3.getLiveCore();
    L45:
        if (r4 != null) goto L48;
        return null;
    L48:
        return new vc0.a(r4);
    L44:
        r4 = null;
        goto L45
    L13:
        l.n2.getClass();
        l r5 = l.a.a();
        if (r5 == null) goto L18;
        com.bytedance.android.live.pushstream.d r6 = r5.getLiveStream();
        if (r6 == null) goto L18;
        d0 r7 = r6.getLiveCore();
    L20:
        if (r7 == null) goto L22;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "acquireLiveCoreInstance not null");
    L22:
        l r8 = l.a.a();
        if (r8 == null) goto L27;
        com.bytedance.android.live.pushstream.d r9 = r8.getLiveStream();
        if (r9 == null) goto L27;
        r4 = r9.getLiveCore();
    L28:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r10 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r10 == null) goto L37;
        hg6.g r11 = r10.P2();
        if (r11 == null) goto L37;
        ec6.b r12 = r11.R();
        if (r12 == null) goto L37;
        com.bytedance.android.live.pushstream.d r13 = gc6.b.a(r12);
        if (r13 == null) goto L37;
        d0 r14 = r13.getLiveCore();
    L38:
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "acquireLiveCoreInstance " + r4 + ' ' + r14 + " null null");
        if (r4 != null) goto L41;
        r4 = r14;
    L41:
        if (r4 != null) goto L43;
        r4 = null;
    L43:
        if (r4 != null) goto L45;
    L37:
        r14 = null;
    L27:
        r4 = null;
    L18:
        r7 = null;
        goto L20
    }

    public final void b() {
        i r0 = this.e;
        if (r0 == null) goto L5;
        i.a.a(r0, false, null, new b(this), true, null, 48);
    L5:
        i r7 = this.e;
        if (r7 == null) goto L8;
        i.a.a(r7, false, null, new c(this), false, null, 48);
    L8:
        boolean r1 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = false;
    }

    public final boolean c() {
        if (this.d == true) goto L11;
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.intValue() != 2) goto L10;
    L11:
        return true;
    }

    public final Pair<Integer, Integer> d() {
        ViewGroup r0 = (ViewGroup) this.h.findViewById(2131386660);
        View r1 = this.h.findViewById(2131387772);
        int r3 = 0;
        if (r0.getChildCount() <= 0) goto L5;
        r1 = r0.getChildAt(0);
    L5:
        if (r1 == null) goto L7;
        int r2 = r1.getHeight();
    L8:
        if (r1 == null) goto L10;
        r3 = r1.getWidth();
    L10:
        if (r2 <= 0) goto L12;
        if (r3 <= 0) goto L12;
    L21:
        return TuplesKt.to(Integer.valueOf(r3), Integer.valueOf(r2));
    L12:
        r2 = ScreenUtils.getScreenHeight();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L15;
    L19:
        r3 = ScreenUtils.getScreenWidth();
        goto L21
    L15:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        Context r4 = s1.getContext();
        if (r4 == null) goto L19;
        r2 = r2 - StatusBarUtil.getStatusBarHeight(r4);
        goto L19
    L7:
        r2 = 0;
        goto L8
    }

    public a(boolean r2, i r3, cd0.a r4, DataCenter r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "mLinkRootView");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.b = "";
        this.c = new ArrayList();
    }

    public final void e(boolean r17, int r18, String r19, boolean r20, Function1<? super Boolean, Unit> r21) {
        Intrinsics.checkNotNullParameter(r19, "scene");
        Intrinsics.checkNotNullParameter(r21, "cb");
        long r2 = i.nextLong();
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r2 + ". enable:" + r17);
        boolean r10 = false;
        if (this.e != null) goto L7;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r2 + ". failed, effect interface is null.", new Throwable());
        boolean r0 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = false;
        r21.invoke(Boolean.FALSE);
        return;
    L7:
        if (r20 == true) goto L27;
        if (r17 == false) goto L18;
        if (this.b.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L16;
        r21.invoke(Boolean.FALSE);
        return;
    L16:
        this.b = r19;
    L30:
        boolean r12 = c();
        if (r12 == false) goto L41;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r2 + ". Use LiveCore.");
        vc0.a r3 = a();
        if (((Boolean) k.h.getValue(null, k.a[6])).booleanValue() == true) goto L38;
        if (r3 != null) goto L37;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r2 + ". failed, LiveCore instance is null.", new Throwable());
        r21.invoke(Boolean.FALSE);
        boolean r4 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.a = false;
        return;
    L37:
        this.e.e(r3);
        goto L41
    L38:
        if (r3 != null) goto L40;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r2 + ". failed, LiveCore instance is null. do not return", new Throwable());
        goto L41
    L40:
        this.e.e(r3);
    L41:
        if (r17 == false) goto L43;
        i.a.a(this.e, true, new g(r2), new e(this, r2, r12, r21, r18), r12, r19, 32);
    L44:
        i r5 = this.e;
        if (r18 != 1) goto L47;
        r10 = true;
    L47:
        r5.m(r10, r12, r19, r20);
        this.h.post(new d(this));
        return;
    L43:
        this.e.l(false, null, new f(r2, r21), r12, r19, r20);
        goto L44
    L12:
        r1 = false;
        goto L13
    L18:
        if (this.b.length() <= 0) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == true) goto L23;
    L26:
        this.b = "";
        goto L30
    L23:
        if ((!Intrinsics.areEqual(this.b, r19)) == false) goto L26;
        r21.invoke(Boolean.FALSE);
        return;
    L20:
        r13 = false;
        goto L21
    L27:
        if (r17 == false) goto L29;
        this.b = r19;
        goto L30
    L29:
        this.b = "";
        goto L30
    }
}
