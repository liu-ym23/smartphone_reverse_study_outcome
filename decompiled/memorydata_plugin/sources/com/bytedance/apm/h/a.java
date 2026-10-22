package com.bytedance.apm.h;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.bytedance.apm.l.b.InterfaceC0091b, com.bytedance.services.apm.api.d, com.bytedance.services.slardar.config.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1325b;
    private boolean c;
    private boolean d;
    private long e;
    protected String g;

    public a() {
    }

    private final void a() {
        if (this.d == true) goto L7;
        this.d = true;
        if (c() == false) goto L7;
        com.bytedance.apm.l.b.a().a(this);
    L7:
        e();
        this.e = System.currentTimeMillis();
    }

    @Override // com.bytedance.apm.l.b.InterfaceC0091b
    public final void a(long r5) {
        long r0 = d();
        if (r0 > 0) goto L5;
        return;
    L5:
        if ((r5 - this.e) > r0) goto L7;
        return;
    L7:
        if (this.f1324a == false) goto L12;
        e();
        this.e = System.currentTimeMillis();
        return;
    }

    public void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.f1325b = true;
        if (com.bytedance.apm.b.h() == false) goto L6;
        k();
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    public void a(com.bytedance.apm.data.a.e r1) {
        b.a(r1);
        b.a(r1, r1.e());
        com.bytedance.apm.data.pipeline.a.b().a(r1);
    }

    public void a(JSONObject r1) {
    }

    public void b() {
    }

    public void b(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.f1325b = false;
        if (com.bytedance.apm.b.h() == true) goto L5;
        return;
    L5:
        if (this.f1324a == false) goto L9;
        a();
        return;
    }

    public void b_() {
    }

    public void c(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    public abstract boolean c();

    public abstract long d();

    @Override // com.bytedance.services.apm.api.d
    public void d(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    public void e() {
    }

    @Override // com.bytedance.services.apm.api.d
    public void e(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    public final void j() {
        if (this.c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.g) == true) goto L12;
        this.c = true;
        ActivityLifeObserver.getInstance().register(this);
        this.f1325b = !ActivityLifeObserver.getInstance().isForeground();
        b();
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin")).registerConfigListener(this);
        if (com.bytedance.apm.b.k() == false) goto L13;
        com.bytedance.apm.e.e.d("AbstractPerfCollector", new String[]{"perf init: " + this.g});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("Must set collector Setting key, before init");
    }

    public final void k() {
        if (this.d == false) goto L7;
        this.d = false;
        if (c() == false) goto L7;
        com.bytedance.apm.l.b.a().b(this);
    L7:
        b_();
    }

    public boolean l() {
        return this.f1325b;
    }

    public void onReady() {
        this.f1324a = true;
        a();
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r1, boolean r2) {
        JSONObject r3 = r1.optJSONObject(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES);
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = r3.optJSONObject(this.g);
        if (r4 != null) goto L8;
        return;
    L8:
        a(r4);
    }
}
