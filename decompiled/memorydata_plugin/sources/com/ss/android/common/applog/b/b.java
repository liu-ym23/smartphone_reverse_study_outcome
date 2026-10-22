package com.ss.android.common.applog.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.common.applog.ab;
import com.ss.android.common.applog.ad;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15054a;

    b(Context r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ d a(b r0) {
        return r0.b();
    }

    private void a(String r3) {
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        SharedPreferences.Editor r2 = this.f15054a.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();     // Catch: Throwable -> L6
        r2.putString("key_task_session", r3);     // Catch: Throwable -> L6
        r2.apply();     // Catch: Throwable -> L6
        return;
    }

    private d b() {
        return d.a(this.f15054a.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).getString("key_task_session", ""));
    }

    public void a() {
        com.ss.android.common.b.c.a.c("clear task session sp");
        a("");
    }

    public void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.f15054a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        ab.a(r5);
        ad.a().a(new AnonymousClass1(this));
    }

    public void a(d r1) {
        ab.a(this.f15054a).a(r1);
    }

    public void b(d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.common.b.c.a.c("saveTaskSessionToSp : " + r3);
        a(r3.e());
    }
}
