package y60;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.live.core.setting.v2.cache.ICacheManger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import ita.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final b a;
    public b b;
    public boolean c;
    public PthreadHandlerThreadV2 d;
    public Handler e;
    public String f;
    public volatile boolean g;
    public final a h;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public final void a() {
            d r0 = this.a;
            b r1 = r0.a;
            r1.getClass();
            String r2 = "-1";
            double r3 = ((double) r1.g.get()) / ((double) (r1.g.get() + r1.f.get()));     // Catch: Exception -> L5
            StringCompanionObject r5 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L5
            r2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r3)}, 1));     // Catch: Exception -> L5
            r1.f.set(0);     // Catch: Exception -> L5
            r1.g.set(0);     // Catch: Exception -> L5
        L9:
            r0.f = r2;
            if (this.a.g == false) goto L17;
            Handler r4 = this.a.e;
            if (r4 == null) goto L18;
            r4.postDelayed(this, 60000);
            return;
        L18:
            return;
        L17:
            return;
        L5:
            e = move-exception;
            Map<String, Long> r6 = a70.b.a;
            String r7 = "LiveSpStorageAction 计算缓存命中率错误：" + e;
            Intrinsics.checkNotNullParameter(r7, "msg");
            if (a70.b.c("_MAIN", r7) == false) goto L9;
            d6.c("SettingReportMonitor", r7);
            goto L9
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

        public a(d r1) {
            this.a = r1;
        }
    }

    public final void a() {
        if (this.b != null) goto L6;
        this.b = new b(a70.a.getContext(), "ttlive_sdk_shared_pref_cache_v2_test_mock");
        return;
    }

    public d() {
        Context r1 = a70.a.getContext();
        Context r2 = a70.a.getContext();
        if (r2 != null) goto L28;
    L8:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L16;
        AtomicBoolean r5 = f.a;
        if (r2 == null) goto L15;
        r2.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_flags", 0).edit().putBoolean("need_update_for_mini_process", true).apply();
    L15:
        String r3 = "ttlive_sdk_shared_pref_cache_v2_for_mini_process";
    L26:
        this.a = new b(r1, r3);
        this.f = "-1";
        this.h = new a(this);
        return;
    L16:
        if (r2 != null) goto L19;
        AtomicBoolean r6 = f.a;
    L25:
        r3 = "ttlive_sdk_shared_pref_cache_v2";
        goto L26
    L19:
        if (f.a.getAndSet(true) == true) goto L25;
        Context r7 = r2.getApplicationContext();
        if (k.i(r7) == false) goto L25;
        new Handler(Looper.getMainLooper()).postDelayed(new e(r7), 120000);
        goto L25
    L28:
        r4 = StringsKt.startsWith$default(k.c(r2), r2.getPackageName() + ":mini", false, 2, null);     // Catch: Throwable -> L7
        goto L10
    }

    public final boolean update(ICacheManger.Operation r17, Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r17, "operation");
        Intrinsics.checkNotNullParameter(r18, "map");
        int r1 = c.a[r17.ordinal()];
        if (r1 == 1) goto L20;
        if (r1 != 2) goto L19;
        SharedPreferences.Editor r2 = this.a.c();
        if (r2 == null) goto L14;
        Iterator<Map.Entry<String, ? extends Object>> r4 = r18.entrySet().iterator();
        int r7 = 0;
    L9:
        if (r4.hasNext() == false) goto L13;
        if (this.a.g(r4.next().getKey()) == false) goto L9;
        r7 = r7 + 1;
        goto L9
    L13:
        r2.apply();
    L15:
        a70.b.e("_MAIN", "SP minus： 本次总共数据条数：" + r18.size() + ", minus成功条数 " + r7);
        if (r7 == r18.size()) goto L117;
    L101:
        return false;
    L117:
        return true;
    L14:
        r7 = 0;
        goto L15
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        SharedPreferences.Editor r3 = this.a.c();
        if (r3 == null) goto L97;
        Iterator<Map.Entry<String, ? extends Object>> r8 = r18.entrySet().iterator();
        int r9 = 0;
    L24:
        if (r8.hasNext() == false) goto L83;
        Map.Entry<String, ? extends Object> r11 = r8.next();
        b r12 = this.a;
        String r13 = r11.getKey();
        Object r14 = r11.getValue();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r3, "editor");
        r12.f();
        int r15 = x60.c.a;
        boolean r16 = wa1.d.c.b;
        if ((r14 instanceof Boolean) == false) goto L36;
        r12.h(r13, ((Boolean) r14).booleanValue(), r3);
        if (wa1.d.c.d == false) goto L32;
        if (r13 == null) goto L32;
        r12.k.put(r13, (Boolean) r14);
    L32:
        if (r16 == false) goto L34;
        boolean r19 = r12.j("__origin_Type__" + r13, 4, false);
    L80:
        if (r19 == false) goto L24;
        r9 = r9 + 1;
        goto L24
    L34:
        r19 = r12.i("__origin_Type__" + r13, 4, r3);
        goto L80
    L36:
        if ((r14 instanceof String) == false) goto L43;
        r12.l(r13, (String) r14, r3);
        if (r16 == false) goto L40;
        r19 = r12.j("__origin_Type__" + r13, 3, false);
        goto L80
    L40:
        r19 = r12.i("__origin_Type__" + r13, 3, r3);
        goto L80
    L43:
        if ((r14 instanceof Integer) == false) goto L49;
        r12.k(r13, ((Number) r14).intValue(), r3);
        if (r16 == false) goto L47;
        r19 = r12.j("__origin_Type__" + r13, 2, false);
        goto L80
    L47:
        r19 = r12.i("__origin_Type__" + r13, 2, r3);
        goto L80
    L49:
        if ((r14 instanceof Long) == false) goto L55;
        r12.k(r13, ((Number) r14).longValue(), r3);
        if (r16 == false) goto L53;
        r19 = r12.j("__origin_Type__" + r13, 2, false);
        goto L80
    L53:
        r19 = r12.i("__origin_Type__" + r13, 2, r3);
        goto L80
    L55:
        if ((r14 instanceof Float) == false) goto L61;
        r12.l(r13, r14.toString(), r3);
        if (r16 == false) goto L59;
        r19 = r12.j("__origin_Type__" + r13, 3, false);
        goto L80
    L59:
        r19 = r12.i("__origin_Type__" + r13, 3, r3);
        goto L80
    L61:
        if ((r14 instanceof Double) == false) goto L67;
        r12.l(r13, r14.toString(), r3);
        if (r16 == false) goto L65;
        r19 = r12.j("__origin_Type__" + r13, 3, false);
        goto L80
    L65:
        r19 = r12.i("__origin_Type__" + r13, 3, r3);
        goto L80
    L67:
        if ((r14 instanceof LinkedTreeMap) == false) goto L74;
        r12.l(r13, GsonProtectorUtils.toJson(x60.b.a, r14), r3);
        if (r16 == false) goto L71;
        r19 = r12.j("__origin_Type__" + r13, 0, false);
        goto L80
    L71:
        r19 = r12.i("__origin_Type__" + r13, 0, r3);
        goto L80
    L74:
        if ((r14 instanceof ArrayList) == false) goto L79;
        r12.l(r13, GsonProtectorUtils.toJson(x60.b.a, r14), r3);
        if (r16 == false) goto L78;
        r19 = r12.j("__origin_Type__" + r13, 1, false);
        goto L80
    L78:
        r19 = r12.i("__origin_Type__" + r13, 1, r3);
        goto L80
    L79:
        r19 = r12.l(r13, GsonProtectorUtils.toJson(x60.b.a, r14), r3);
        goto L80
    L83:
        r3.apply();
        b r5 = this.a;
        r5.getClass();
        int r6 = x60.c.a;
        if (wa1.d.c.b == false) goto L98;
        r5.f();
        SharedPreferences r21 = r5.c;
        if (r21 == null) goto L88;
        SharedPreferences.Editor r22 = r21.edit();
    L89:
        if (r22 == null) goto L98;
        Iterator<Map.Entry<String, Integer>> r23 = r5.j.entrySet().iterator();
    L92:
        if (r23.hasNext() == false) goto L96;
        Map.Entry<String, Integer> r24 = r23.next();
        String r25 = r24.getKey();
        int r26 = r24.getValue().intValue();
        if ((r25 instanceof String) == false) goto L92;
        r22.putInt(r25, r26);
        r5.g(r25);
        goto L92
    L96:
        r22.apply();
        goto L98
    L88:
        r22 = null;
    L98:
        a70.b.e("_MAIN", "SP plus：本次总共数据条数：" + r18.size() + ", plus成功条数 " + r9);
        if (r9 != r18.size()) goto L101;
        return true;
    L97:
        r9 = 0;
        goto L98
    }
}
