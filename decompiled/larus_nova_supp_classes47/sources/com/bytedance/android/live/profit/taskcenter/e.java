package com.bytedance.android.live.profit.taskcenter;

import com.bytedance.android.live.revenue.common.HybridPropertyUtilsKt;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import wp2.q;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements o, m {
    public static final com.bytedance.android.live.profit.taskcenter.a a = null;
    public static final d b = null;
    public static final long c = 0;
    public static final com.bytedance.android.live.revenue.common.m d = null;
    public static final com.bytedance.android.live.revenue.common.m e = null;
    public static final a f = null;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "LIVE_SHIELD_INCENTIVE_PANEL", "getLIVE_SHIELD_INCENTIVE_PANEL()Ljava/util/Map;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "INCENTIVE_FEEDBACK_MANAGEMENT", "getINCENTIVE_FEEDBACK_MANAGEMENT()Ljava/util/Map;", 0))};
        }

        public a() {
        }

        public static Map a() {
            return (Map) e.e.getValue(e.f, a[1]);
        }

        public static Map b() {
            return (Map) e.d.getValue(e.f, a[0]);
        }
    }

    public e() {
    }

    @Override // yz0.m
    public final void i() {
    }

    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    static {
        f = new a();
        ReadOnlyProperty r0 = k.f;
        KProperty[] r1 = k.a;
        com.bytedance.android.live.profit.taskcenter.a r2 = (com.bytedance.android.live.profit.taskcenter.a) r0.getValue(null, r1[4]);
        a = r2;
        d r3 = (d) k.g.getValue(null, r1[5]);
        b = r3;
        c = 604800000;
        d = HybridPropertyUtilsKt.c(r2.b(), new LinkedHashMap());
        e = HybridPropertyUtilsKt.c(r3.b(), new LinkedHashMap());
    }

    public final void onStart() {
        com.bytedance.android.live.profit.taskcenter.a r0 = a;
        r0.getClass();
        d r1 = b;
        r1.getClass();
        long r2 = 0;
        if (r0.a() == false) goto L20;
        com.bytedance.live.datacontext.m r3 = o3.f().C1();
        if (r3 == null) goto L20;
        Map r4 = (Map) r3.getValue();
        if (r4 == null) goto L20;
        if (((String) r4.get("auto_open_task_panel_source")) == null) goto L20;
        f.getClass();
        Objects.toString(a.b());
        if (a.b().isEmpty() == true) goto L18;
        String r5 = (String) a.b().get("cache_timestamp");
        if (r5 == null) goto L15;
        long r6 = CastLongProtector.parseLong(r5);
    L17:
        if (r6 >= (System.currentTimeMillis() - c)) goto L20;
    L15:
        r6 = 0;
    L18:
        vh6.c.b(rq2.a.class).yc(new q(new JSONObject(), new g()));
    L20:
        if (r1.a() == false) goto L30;
        f.getClass();
        Objects.toString(a.a());
        if (a.a().isEmpty() == true) goto L28;
        String r7 = (String) a.a().get("cache_timestamp");
        if (r7 == null) goto L27;
        r2 = CastLongProtector.parseLong(r7);
    L27:
        if (r2 < (System.currentTimeMillis() - c)) goto L28;
        return;
    L28:
        vh6.c.b(rq2.a.class).yc(new wp2.e(new JSONObject(), new f()));
        return;
    }
}
