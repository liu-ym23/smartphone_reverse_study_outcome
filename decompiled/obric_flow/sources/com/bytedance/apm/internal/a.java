package com.bytedance.apm.internal;

import com.bytedance.apm.ApmAgent;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.p0;
import com.lynx.tasm.utils.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3885c;
    public final Object d;
    public Object e;

    public a(long r5, long r10, LynxTemplateRender r11, NativeFacade r12) {
        this.f3883a = 1;
        this.f3884b = r5;
        this.f3885c = r10;
        if (r10 != 0) goto L5;
    L7:
        r11 = null;
    L8:
        this.d = r11;
        this.e = r12;
        return;
    L5:
        if (r5 == 0) goto L7;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3883a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        long r5 = this.f3885c;
        if (r5 != 0) goto L7;
    L12:
        NativeFacade r10 = (NativeFacade) this.e;
        if (r10 == null) goto L35;
        p0 r11 = r10.f10048b;
        if (r11 == null) goto L17;
        r11.onDestroy();
        r10.f10048b = null;
    L17:
        this.e = null;
        return;
    L35:
        return;
    L7:
        if (this.f3884b == 0) goto L12;
        if (LynxTemplateRender.M(r5) == false) goto L11;
        LynxTemplateRender.U(this.f3884b);
        this.f3884b = 0;
        this.f3885c = 0;
        goto L12
    L11:
        j.a().postDelayed(this, 1);
        goto L12
    L19:
        long r12 = System.currentTimeMillis();
        ApmAgent.monitorStatusRate("apm_event_stats_alog", 0, null);
        com.bytedance.ies.bullet.base.utils.b.r("begin upload alog:" + ((String) this.d) + " startTime:" + this.f3884b + " endTime:" + this.f3885c + " scene:" + ((String) this.e));
        boolean r13 = com.bytedance.apm.j.f3887a;
        JSONObject r14 = new JSONObject();
        r14.put("info", "apm context is null");     // Catch: JSONException -> L22
    L24:
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 0, com.bytedance.ies.bullet.base.utils.b.o(false, 0, null, r14));
        com.bytedance.ies.bullet.base.utils.b.r("upload end. ".concat("apm context is null"));
        JSONObject r15 = new JSONObject();
        r15.put("time", System.currentTimeMillis() - r12);     // Catch: JSONException -> L27
    L29:
        ApmAgent.monitorEvent("apm_event_stats_alog_time", null, r15, null);
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public a(long r5, String r10, long r11, String r12) {
        this.f3883a = 0;
        this.d = r10;
        this.f3884b = r5;
        this.f3885c = r11;
        this.e = r12;
    }
}
