package com.bytedance.android.live.revlink.impl.monitor;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.pk.service.f;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mz0.i;
import mz0.n;
import or2.j;
import or2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkStallReporter {
    public String a;
    public long b;
    public long c;
    public boolean d;
    public String e;
    public long f;
    public String g;
    public long h;
    public Disposable i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    public final void d() {
        if (d51.c.A0.c().getEnable() == true) goto L5;
        return;
    L5:
        j r0 = vh6.c.b(or2.e.class).getCurrentClient();
        if (r0 == null) goto L22;
        m r1 = r0.d();
        if (Intrinsics.areEqual((Boolean) r1.d().getValue(), Boolean.TRUE) == false) goto L11;
        this.b = SystemClock.uptimeMillis();
    L11:
        if (this.d == true) goto L23;
        this.d = true;
        MutableLiveData r2 = r1.getSeiUpdate();
        if (r2 == null) goto L15;
        r2.observeForever((Observer) this.j.getValue());
    L15:
        MutableLiveData r3 = r1.d();
        if (r3 == null) goto L18;
        r3.observeForever((Observer) this.k.getValue());
    L18:
        MutableLiveData r4 = r1.c();
        if (r4 == null) goto L24;
        r4.observeForever((Observer) this.l.getValue());
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void e() {
        this.b = -1;
        this.c = -1;
        this.f = -1;
        this.g = null;
        Disposable r0 = this.i;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public RevLinkStallReporter() {
        this.a = "";
        this.b = -1;
        this.c = -1;
        this.f = -1;
        this.h = -1;
        this.j = LazyKt.lazy(new RevLinkStallReporter$seiObs$2(this));
        this.k = LazyKt.lazy(new RevLinkStallReporter$onStallStart$2(this));
        this.l = LazyKt.lazy(new RevLinkStallReporter$onStallEnd$2(this));
    }

    public static final void a(RevLinkStallReporter r12, String r13) {
        long r0 = r12.f;
        long r2 = r12.c;
        long r4 = 0;
        if (1 <= r2) goto L6;
    L11:
        long r8 = r12.b;
        if (1 <= r8) goto L15;
    L19:
        Disposable r1 = r12.i;
        if (r1 == null) goto L22;
        r1.dispose();
    L22:
        r12.i = Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(new d(r12, r13), e.a);
        return;
    L15:
        if (r0 <= r8) goto L19;
        if (r2 >= 0) goto L19;
        r12.g = r13;
        return;
    L6:
        if (r0 < r2) goto L11;
        if (Math.abs(r0 - r2) >= d51.c.A0.c().x2()) goto L10;
        r4 = r12.c - r12.b;
    L10:
        r12.f(r13, r4);
        r12.e();
    }

    public static final boolean b(RevLinkStallReporter r4, String r5) {
        r4.getClass();
        if (r5 != null) goto L5;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L24;
        if (r5 != null) goto L14;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == true) goto L25;
        return false;
    L25:
        return true;
    L14:
        if (StringsKt.contains$default(r5, "\\\"ver\\\":6", false, 2, null) == true) goto L17;
        r5 = null;
    L17:
        if (r5 == null) goto L19;
        r6 = true;
        goto L20
    L24:
        return true;
    L5:
        if (StringsKt.contains$default(r5, "\\\"ver\\\":2", false, 2, null) == false) goto L7;
        String r7 = r5;
    L8:
        if (r7 == null) goto L10;
        r3 = true;
        goto L11
    L7:
        r7 = null;
        goto L8
    }

    public static final boolean c(RevLinkStallReporter r4, String r5) {
        r4.getClass();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r5, "TTLiveSDK_Android", false, 2, null) == false) goto L7;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L20;
        return true;
    L20:
        return false;
    L7:
        if (StringsKt.contains$default(r5, "TTLiveSDK_IOS", false, 2, null) == true) goto L12;
        if (StringsKt.contains$default(r5, "TTLiveSDK_Windows", false, 2, null) == true) goto L12;
        r0 = false;
        goto L13
    }

    public final void f(String r6, long r7) {
        if ((SystemClock.uptimeMillis() - this.h) >= d51.c.A0.c().g6()) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r1 == null) goto L8;
        int r2 = r1.getCurrentMode();
    L9:
        boolean r3 = v.a(r2, 4);
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r4 = null;
        f r5 = null;
        String r8 = DataType.Normal;
        if (r3 == false) goto L20;
        com.bytedance.android.live.revlink.impl.global.c r9 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r9 == null) goto L14;
        r5 = r9.Aa();
    L14:
        if (r5 == null) goto L19;
        String r10 = r5.getConnectSource();
        if (r10 == null) goto L19;
        r8 = r10;
    L19:
        r0.put("live_source", r8);
    L31:
        com.bytedance.android.live.revlink.impl.control.d r12 = com.bytedance.android.live.revlink.impl.global.b.f();
        String r13 = "";
        if (r12 == null) goto L35;
        String r14 = r12.getRequestId();
        if (r14 == null) goto L35;
    L36:
        r0.put("request_id", r14);
        r0.put("channel_id", this.a);
        d31.d r15 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r15 == null) goto L42;
        String r16 = r15.a();
        if (r16 == null) goto L42;
        r13 = r16;
    L42:
        r0.put("anchor_connect_status", r13);
        if (r7 < 0) goto L45;
        String r17 = String.valueOf(r7);
    L46:
        r0.put("connection_stuck_duration", r17);
        n r18 = new n();
        Map<String, String> r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r19.putAll(r0);
        mz0.m r20 = new mz0.m();
        r20.b(LogCommon.ROOM);
        r20.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r22 = r18.b;
        ArrayList r23 = (ArrayList) r22;
        r23.addAll(r20.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r25);
        ((i) ((f80.a) r25)).w3(r6, r18.a, r18.b);
        this.h = SystemClock.uptimeMillis();
        return;
    L45:
        r17 = DataType.FALSE;
    L35:
        r14 = "";
        goto L36
    L20:
        com.bytedance.android.live.revlink.impl.global.c r26 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r26 == null) goto L23;
        r4 = r26.rb();
    L23:
        if (r4 == null) goto L30;
        com.bytedance.live.datacontext.m<String> r27 = r4.getConnectionSource();
        if (r27 == null) goto L30;
        String r28 = (String) r27.getValue();
        if (r28 == null) goto L30;
        r8 = r28;
    L30:
        r0.put("live_source", r8);
        goto L31
    L8:
        r2 = 0;
        goto L9
    }
}
