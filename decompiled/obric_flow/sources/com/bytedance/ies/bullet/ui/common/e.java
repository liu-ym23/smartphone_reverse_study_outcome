package com.bytedance.ies.bullet.ui.common;

import android.view.View;
import com.bytedance.apm.ApmAgent;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.core.JSProxy;
import io.reactivex.internal.operators.flowable.w;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6204c;

    public /* synthetic */ e(long r5, Object r10, int r11) {
        this.f6202a = r11;
        this.f6203b = r5;
        this.f6204c = r10;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [io.reactivex.internal.operators.flowable.w, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r0v13, types: [io.reactivex.internal.operators.observable.h4, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6202a) {
            case 0: goto L17;
            case 1: goto L13;
            case 2: goto L26;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        this.f6204c.onTimeout(this.f6203b);
        return;
    L6:
        ((Number) this.f6204c).onTimeout(this.f6203b);
        return;
    L8:
        ((zu.d) this.f6204c).request(this.f6203b);
        return;
    L17:
        BulletContainerView r5 = (BulletContainerView) this.f6204c;
        r5.F = null;
        r5.G = null;
        if (r5.I == true) goto L30;
        r5.l();
        long r10 = this.f6203b;
        if (r10 == 0) goto L31;
        View r11 = BulletContainerView.i(r5);
        if (r11 == null) goto L32;
        r11.postDelayed(new d(r5, 0), r10);
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L26:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L25
        r12.put("looper_monitor", this.f6203b);     // Catch: JSONException -> L25
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L25
        r13.put("is_main_process", ((e6.e) ((r6.a) this.f6204c).f21695a).f16774o);     // Catch: JSONException -> L25
        ApmAgent.monitorEvent("apm_cost", r13, r12, null);     // Catch: JSONException -> L25
        return;
    L28:
        return;
    L13:
        if (this.f6203b == 0) goto L29;
        LynxLog.b(3, "LynxBackgroundRuntime", "destory wrapper " + this.f6203b);
        LynxBackgroundRuntime.b(this.f6203b);
        this.f6203b = 0;
        ((JSProxy) this.f6204c).a();
        return;
    }

    public /* synthetic */ e(Object r5, long r10, int r11) {
        this.f6202a = r11;
        this.f6204c = r5;
        this.f6203b = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(long r5, w r10) {
        this.f6202a = 4;
        this.f6203b = r5;
        this.f6204c = (Number) r10;
    }
}
