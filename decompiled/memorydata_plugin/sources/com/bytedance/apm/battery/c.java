package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.apm.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1137a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1138b;

    static {
    }

    public c() {
        this.g = Scraps.BATTERY;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        super.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        com.bytedance.apm.l.b.a().b(this);
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.f1138b = r1;
        return;
    L5:
        if (r5.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        super.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        if (this.f1138b == false) goto L6;
        com.bytedance.apm.l.b.a().a(this);
        return;
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return this.f1138b;
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return 300000;
    }

    @Override // com.bytedance.apm.h.a
    public void e() {
        super.e();
        if (this.f1138b == true) goto L5;
        return;
    L5:
        if (l() == false) goto L8;
        return;
    L8:
        if (com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L10;
        return;
    L10:
        float r0 = com.ss.thor.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r0 >= f1137a) goto L16;
        return;
    L16:
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        r5.put("timing_current", r0);     // Catch: JSONException -> L15
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L15
        r6.put(MemoryInfoSectionEditActivity.KIND_SCENE, ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        a(new com.bytedance.apm.data.a.e(Scraps.BATTERY, "", r5, r6, null));     // Catch: JSONException -> L15
        return;
    }
}
