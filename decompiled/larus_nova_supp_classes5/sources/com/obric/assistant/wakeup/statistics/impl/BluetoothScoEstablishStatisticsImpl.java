package com.obric.assistant.wakeup.statistics.impl;

import android.os.SystemClock;
import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/impl/BluetoothScoEstablishStatisticsImpl;", "Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI;", "<init>", "()V", "establishStartElapsedMs", "", "reported", "Ljava/util/concurrent/atomic/AtomicBoolean;", "markEstablishStart", "", "markEstablishResult", "result", "Lcom/obric/assistant/wakeup/statistics/api/IBluetoothScoEstablishStatisticsAPI$Result;", "rawScoState", "", "cancelInFlight", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BluetoothScoEstablishStatisticsImpl implements IBluetoothScoEstablishStatisticsAPI {
    public volatile long a;
    public final AtomicBoolean b;

    public static final class a {
    }

    static {
    }

    public BluetoothScoEstablishStatisticsImpl() {
        this.a = -1;
        this.b = new AtomicBoolean(false);
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI
    public final void b() {
        this.a = SystemClock.elapsedRealtime();
        this.b.set(false);
        FLogger.a.i("BTScoEstablishStat", "markEstablishStart at " + this.a);
    }

    @Override // com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI
    public final void a(IBluetoothScoEstablishStatisticsAPI.Result r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "result");
        long r4 = this.a;
        if (r4 > 0) goto L7;
        FLogger.a.i("BTScoEstablishStat", "markEstablishResult ignored: no active round, result=" + r13);
        return;
    L7:
        if (this.b.compareAndSet(false, true) == true) goto L32;
        return;
    L32:
        long r10 = SystemClock.elapsedRealtime() - r4;     // Catch: Throwable -> L25
        int r15 = b.a[r13.ordinal()];     // Catch: Throwable -> L25
        if (r15 != 1) goto L13;
        String r16 = "connected";
    L21:
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L25
        r5.put("result", r16);     // Catch: Throwable -> L25
        r5.put("raw_sco_state", r14);     // Catch: Throwable -> L25
        r5.put("establish_duration_ms", r10);     // Catch: Throwable -> L25
        FLogger.a.i("BTScoEstablishStat", "report event=bluetooth_sco_establish_trace, result=" + r16 + ", durationMs=" + r10 + ", category=" + r5);     // Catch: Throwable -> L25
        TrackParams r17 = new TrackParams().merge(r5);     // Catch: Throwable -> L25
        by7.a r18 = new by7.a("bluetooth_sco_establish_trace");     // Catch: Throwable -> L25
        r18.a.merge(r17);     // Catch: Throwable -> L25
        r18.b();     // Catch: Throwable -> L25
        if (t1.a.o0() == false) goto L27;
        g.a.monitorEventForSlardar("bluetooth_sco_establish_trace", r5, null, null);     // Catch: Throwable -> L25
    L27:
        this.a = -1;
        return;
    L13:
        if (r15 != 2) goto L15;
        r16 = "disconnected";
        goto L21
    L15:
        if (r15 != 3) goto L18;
        r16 = "error";
        goto L21
    L18:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        FLogger.a.w("BTScoEstablishStat", "markEstablishResult report failed: " + th.getMessage(), th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        this.a = -1;
        throw th;
    }
}
