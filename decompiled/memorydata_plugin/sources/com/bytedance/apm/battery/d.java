package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PluginBroadcastReceiver f1146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntentFilter f1147b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private long h;
    private List<com.bytedance.apm.a.InterfaceC0079a> i;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f1151a = null;

        static {
            f1151a = new d();
        }

        static /* synthetic */ d a() {
            return f1151a;
        }
    }

    public d() {
        this.d = false;
        this.f = 60;
        this.g = Scraps.BATTERY;
    }

    static /* synthetic */ long a(d r2) {
        return r2.h;
    }

    static /* synthetic */ long a(d r0, long r1) {
        r0.h = r1;
        return r1;
    }

    public static d a() {
        return a.a();
    }

    static /* synthetic */ int b(d r0) {
        return r0.f;
    }

    static /* synthetic */ boolean c(d r0) {
        return r0.d;
    }

    static /* synthetic */ boolean d(d r0) {
        return r0.e;
    }

    static /* synthetic */ List e(d r0) {
        return r0.i;
    }

    private void g() {
        if (this.c == false) goto L8;
        return;
    L8:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f1146a, this.f1147b, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        this.c = true;     // Catch: Exception -> L7
        return;
    }

    private void h() {
        if (this.c == true) goto L8;
        return;
    L8:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f1146a, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        this.c = false;     // Catch: Exception -> L7
        return;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        super.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        h();
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r4) {
        super.a(r4);
        boolean r1 = false;
        if (r4.optInt("temperature_enable_upload", 0) != 1) goto L5;
        r1 = true;
    L5:
        this.d = r1;
        this.f = r4.optInt("temperature_upload_interval", 60);
        if (this.d == false) goto L8;
        return;
    L8:
        if (this.e == true) goto L12;
        ActivityLifeObserver.getInstance().unregister(this);
        h();
        return;
    }

    public void a(boolean r1) {
        this.e = r1;
        j();
    }

    @Override // com.bytedance.apm.h.a
    public void b() {
        this.f1146a = new AnonymousClass1(this);
        this.f1147b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        g();
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        super.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        g();
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return 0;
    }
}
