package com.bytedance.frameworks.baselib.network.c;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.frameworks.baselib.network.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f2304b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f2305a;

    public e(int r2) {
        super(r2);
        this.f2305a = new AtomicBoolean(false);
    }

    public static e e() {
        if (f2304b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2304b != null) goto L9;
        f2304b = new e(LocationInfoConst.HALF_MINUTES);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f2304b;
    }

    public void a(JSONObject r3) {
        a(r3.optInt("qf_enter_background_time", LocationInfoConst.HALF_MINUTES));
    }

    @Override // com.bytedance.frameworks.baselib.network.b.a
    public void c() {
        this.f2305a.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.b.a
    public void d() {
        this.f2305a.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }
}
