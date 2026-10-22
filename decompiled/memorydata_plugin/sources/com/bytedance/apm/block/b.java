package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b extends a implements com.bytedance.apm.f, com.bytedance.services.apm.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1224b;
    private l c;

    public b() {
        this.c = l.a();
    }

    public void a(long r1) {
        this.c.b(r1);
    }

    @Override // com.bytedance.apm.block.a
    public void a(long r1, long r3, long r5, long r7, boolean r9) {
        super.a(r1, r3, r5, r7, r9);
        if (this.f1224b == false) goto L6;
        this.c.c(r9);
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        d();
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void a(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.apm.f
    public void a(com.bytedance.apm.config.e r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        long r0 = r8.f();
        long r2 = r8.e();
        boolean r4 = r8.b();
        boolean r5 = r8.a();
        this.c.b(r4);
        this.c.b(r0);
        this.c.c(r2);
        this.c.f(r5);
        this.c.d(r8.h());
        l r7 = this.c;
        if (com.bytedance.apm.b.c() == false) goto L7;
    L10:
        boolean r9 = true;
    L11:
        r7.e(r9);
        return;
    L7:
        if (r8.d() == true) goto L10;
        r9 = false;
        goto L11
    }

    public void a(com.bytedance.apm.d.c r3) {
        com.bytedance.apm.d.c r4 = (com.bytedance.apm.d.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.d.c.class, "com.obric.memorydata.plugin");
        this.c.a(r4);
    }

    @Override // com.bytedance.apm.block.a
    public void a(String r2) {
        super.a(r2);
        if (this.f1224b == false) goto L6;
        this.c.a(r2);
        return;
    }

    public void a(boolean r1) {
        this.c.a(r1);
    }

    public void b() {
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.apm.g.a(this);
        this.c.b();
        com.bytedance.apm.block.a.f.a().a(this);
        com.bytedance.apm.block.a.f.a().d();
        this.f1223a = true;
        if (com.bytedance.apm.b.k() == false) goto L6;
        com.bytedance.apm.e.e.d("BlockDetector", new String[]{"BlockDetector init: "});
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        c();
    }

    public void b(boolean r1) {
        this.c.g(r1);
    }

    public void c() {
        if (this.f1223a == true) goto L5;
        return;
    L5:
        if (this.f1224b == true) goto L13;
        this.f1224b = true;
        if (com.bytedance.apm.b.k() == false) goto L12;
        com.bytedance.apm.e.e.d("BlockDetector", new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void c(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    public void c(boolean r1) {
        this.c.h(r1);
    }

    public void d() {
        if (this.f1224b == true) goto L5;
        return;
    L5:
        this.f1224b = false;
        this.c.c(false);
        if (com.bytedance.apm.b.k() == false) goto L9;
        com.bytedance.apm.e.e.d("BlockDetector", new String[]{"BlockDetector stop: "});
        return;
    }

    @Override // com.bytedance.services.apm.api.d
    public void d(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void e(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
