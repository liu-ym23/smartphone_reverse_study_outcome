package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ CallContext b;

    public b0(e0 r1, CallContext r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void subscribe(ObservableEmitter<GetDeviceStatsResultModel> r14) {
        Intrinsics.checkNotNullParameter(r14, "emitter");
        GetDeviceStatsResultModel r0 = new GetDeviceStatsResultModel();
        r0.c(new GetDeviceStatsResultModel.a());
        if (Intrinsics.areEqual(this.a.b(), Boolean.TRUE) == false) goto L31;
        GetDeviceStatsResultModel.a r1 = r0.a();
        if (r1 == null) goto L31;
        int r10 = com.bytedance.android.annie.util.n.c;
        long r11 = System.currentTimeMillis();
        if ((r11 - com.bytedance.android.annie.util.n.a) >= 360) goto L10;
        double r12 = com.bytedance.android.annie.util.n.b;
    L30:
        r1.b(Double.valueOf(r12));
        goto L31
    L10:
        com.bytedance.android.annie.util.n.a = r11;
        long r13 = com.bytedance.android.annie.util.n.b();
        if (r13 == (-1)) goto L29;
        long r15 = com.bytedance.android.annie.util.n.c();
        if (r15 == (-1)) goto L29;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L18
        Thread.sleep(360);     // Catch: Throwable -> L18
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        long r17 = com.bytedance.android.annie.util.n.b();
        if (r17 == (-1)) goto L29;
        long r18 = com.bytedance.android.annie.util.n.c();
        if (r18 == (-1)) goto L29;
        long r19 = r18 - r15;
        if (r19 <= 0) goto L29;
        r12 = (r17 - r13) / r19;
        com.bytedance.android.annie.util.n.b = r12;
    L18:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        r12 = -1.0d;
    L31:
        Boolean r21 = this.a.d();
        Boolean r22 = Boolean.TRUE;
        if (Intrinsics.areEqual(r21, r22) == false) goto L38;
        GetDeviceStatsResultModel.a r23 = r0.a();
        if (r23 == null) goto L38;
        r23.d(Double.valueOf(y8.a.a.d(this.b.getContext())));
    L38:
        if (Intrinsics.areEqual(this.a.e(), r22) == false) goto L44;
        GetDeviceStatsResultModel.a r24 = r0.a();
        if (r24 == null) goto L44;
        r24.e(Float.valueOf(y8.a.a.a(this.b.getContext())));
    L44:
        if (Intrinsics.areEqual(this.a.a(), r22) == false) goto L71;
        GetDeviceStatsResultModel.a r25 = r0.a();
        if (r25 == null) goto L71;
        y8.a r26 = y8.a.a;
        Context r27 = this.b.getContext();
        monitor-enter(r26);
        long r28 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L67
        Map<String, Pair<Long, Object>> r29 = y8.a.b;     // Catch: Throwable -> L67
        if (r29.containsKey("battery_level") == false) goto L57;
        Object r30 = ((LinkedHashMap) r29).get("battery_level");     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r30);     // Catch: Throwable -> L67
        if ((r28 - ((Number) ((Pair) r30).getFirst()).longValue()) >= 5000) goto L57;
        Object r31 = ((LinkedHashMap) r29).get("battery_level");     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r31);     // Catch: Throwable -> L67
        Object r32 = ((Pair) r31).getSecond();     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L67
        int r33 = ((Integer) r32).intValue();     // Catch: Throwable -> L67
        monitor-exit(r26);
    L66:
        r25.a(Integer.valueOf(r33));
    L57:
        int r34 = com.bytedance.android.annie.util.n.c;     // Catch: Throwable -> L67
        if (r27 == null) goto L63;
        Intent r35 = com.bytedance.android.annie.util.n.a(r27, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L67
        if (r35 == null) goto L63;
        r33 = r35.getIntExtra("level", -1);     // Catch: Throwable -> L67
    L64:
        r29.put("battery_level", new Pair(Long.valueOf(r28), Integer.valueOf(r33)));     // Catch: Throwable -> L67
        monitor-exit(r26);
    L63:
        r33 = -1;
    L67:
        th = move-exception;
        throw th;
    L71:
        if (Intrinsics.areEqual(this.a.c(), r22) == false) goto L76;
        GetDeviceStatsResultModel.a r36 = r0.a();
        if (r36 == null) goto L76;
        y8.a r37 = y8.a.a;
        r36.c(Float.valueOf(y8.a.c()));
    L76:
        r14.onNext(r0);
        r14.onComplete();
    }
}
