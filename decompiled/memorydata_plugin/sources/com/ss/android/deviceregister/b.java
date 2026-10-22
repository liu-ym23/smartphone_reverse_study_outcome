package com.ss.android.deviceregister;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Utils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f15164a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f15165b = false;
    private static volatile boolean c = false;
    private volatile com.ss.android.common.a d;
    private volatile int e;
    private volatile String f;
    private volatile boolean g;

    static {
    }

    public b() {
        this.g = false;
    }

    @Override // com.ss.android.deviceregister.k
    public String a() {
        return AppLog.getDid();
    }

    @Override // com.ss.android.deviceregister.k
    public String a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = this.f;
        if (TextUtils.isEmpty(r0) == false) goto L8;
        if (this.d == null) goto L8;
        r0 = this.d.d();
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");     // Catch: Throwable -> L11
        this.f = r0;     // Catch: Throwable -> L11
        return r0;
    L11:
        th = move-exception;
        Logger.e("BdWrapperImpl", "getChannel", th);
        return r0;
    L16:
        return r0;
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Context r1, String r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Context r1, boolean r2, boolean r3, boolean r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Bundle r1) {
    }

    @Override // com.ss.android.deviceregister.k
    public void a(com.ss.android.deviceregister.a.i r2) {
        com.ss.android.deviceregister.a.i r1 = (com.ss.android.deviceregister.a.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.deviceregister.a.i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.k
    public void a(f.a r3) {
        final f.a r4 = (f.a) ZeusTransformUtils.wrapperContextForParams(r3, f.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        AppLog.addDataObserver(new AnonymousClass1(this, r4));
    }

    @Override // com.ss.android.deviceregister.k
    public void a(String r1) {
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Map<String, String> r2, Context r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.k
    public void a(boolean r1) {
    }

    @Override // com.ss.android.deviceregister.k
    public void a(boolean r1, long r2, q r4) {
        q r0 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.k
    public boolean a(Context r1, JSONObject r2, boolean r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        JSONObject r4 = AppLog.getHeader();
        if (r4 == null) goto L6;
        Utils.copy(r2, r4);
        return true;
    L6:
        return false;
    }

    @Override // com.ss.android.deviceregister.k
    public String b() {
        return null;
    }

    @Override // com.ss.android.deviceregister.k
    public void b(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AppLog.setUserAgent(r3);
    }

    @Override // com.ss.android.deviceregister.k
    public void b(boolean r1) {
        f15164a = r1;
    }

    @Override // com.ss.android.deviceregister.k
    public boolean b(Context r2) {
        return AppLog.isNewUserMode((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.k
    public void c() {
    }

    @Override // com.ss.android.deviceregister.k
    public void c(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.k
    public void c(boolean r1) {
    }

    @Override // com.ss.android.deviceregister.k
    public void d(boolean r1) {
    }

    @Override // com.ss.android.deviceregister.k
    public boolean d() {
        return this.g;
    }

    @Override // com.ss.android.deviceregister.k
    public int e() {
        int r0 = this.e;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        if (this.d != null) goto L7;
        return r0;
    L7:
        return this.d.i();
    }

    @Override // com.ss.android.deviceregister.k
    public boolean e(boolean r1) {
        return false;
    }

    @Override // com.ss.android.deviceregister.k
    public boolean f() {
        return false;
    }
}
