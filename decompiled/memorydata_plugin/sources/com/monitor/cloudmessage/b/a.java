package com.monitor.cloudmessage.b;

import android.content.Context;
import com.bytedance.apm.e.e;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f5818a;

    static {
        f5818a = new ConcurrentHashMap();
    }

    public a() {
    }

    private void e(com.monitor.cloudmessage.entity.a r7) {
        com.monitor.cloudmessage.f.b.b r6 = new com.monitor.cloudmessage.f.b.b(0, false, r7.d(), null);
        r6.a(3);
        r6.a("当前云控指令已被sdk禁用");
        com.monitor.cloudmessage.f.a.a(r6);
    }

    private boolean f(com.monitor.cloudmessage.entity.a r5) {
        String r4 = r5.d();
        if (f5818a.containsKey(r4) == false) goto L8;
        long r0 = ((Long) ZeusTransformUtils.preCheckCast(f5818a.get(r4), Long.class, "com.obric.memorydata.plugin")).longValue();
        if ((System.currentTimeMillis() - r0) >= 10000) goto L8;
        return false;
    L8:
        f5818a.put(r4, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public void a(String r7, com.monitor.cloudmessage.entity.a r8) {
        com.monitor.cloudmessage.f.b.b r6 = new com.monitor.cloudmessage.f.b.b(0, false, r8.d(), null);
        r6.a(3);
        r6.a(r7);
        com.monitor.cloudmessage.f.a.a(r6);
    }

    public void a(String r7, HashMap<String, String> r8, com.monitor.cloudmessage.entity.a r9) {
        com.monitor.cloudmessage.f.b.b r6 = new com.monitor.cloudmessage.f.b.b(0, false, r9.d(), r8);
        r6.a(3);
        r6.a(r7);
        com.monitor.cloudmessage.f.a.a(r6);
    }

    public boolean a() {
        if (CloudMessageManager.getBlackListForCloudContrlInf() == null) goto L11;
        String[] r0 = CloudMessageManager.getBlackListForCloudContrlInf();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (b().equals(r0[r3]) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    @Override // com.monitor.cloudmessage.b.b
    public synchronized boolean a(com.monitor.cloudmessage.entity.a r7) {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (b().equals(r7.getType()) == true) goto L36;
        monitor-exit(this);
        return false;
    L36:
    L28:
        e = move-exception;
        a(e.getMessage(), r7);     // Catch: Throwable -> L32
        return false;
    L24:
        e = move-exception;
        a(String.format("系统错误：%s", new Object[]{com.monitor.cloudmessage.utils.b.a(e)}), r7);     // Catch: Throwable -> L32
        return false;
    L10:
        if (a() == false) goto L15;
        e(r7);     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        monitor-exit(this);
        return true;
    L15:
        if (f(r7) == true) goto L17;
    L21:
        e.d("cloudmessage", new String[]{"checkCmdInterval false: ignored for now."});     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        monitor-exit(this);
        return false;
    L17:
        if (b(r7) == false) goto L21;
        e.d("cloudmessage", new String[]{"start handle message:" + r7});     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        boolean r8 = d(r7);     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        monitor-exit(this);
        return r8;
    }

    public boolean a(JSONObject r8, com.monitor.cloudmessage.entity.a r9) {
        if (r8.optBoolean("wifiOnly", false) == true) goto L5;
    L8:
        return false;
    L5:
        if (NetworkUtils.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L8;
        com.monitor.cloudmessage.f.b.b r7 = new com.monitor.cloudmessage.f.b.b(0, false, r9.d(), null);
        r7.a(0);
        r7.a("4G环境下不执行指令");
        com.monitor.cloudmessage.f.a.a(r7);
        return true;
    }

    public abstract String b();

    public boolean b(com.monitor.cloudmessage.entity.a r3) {
        if (com.monitor.cloudmessage.e.b.a().a(r3.d()) == true) goto L5;
        return true;
    L5:
        if (NetworkUtils.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L10;
        com.monitor.cloudmessage.e.a.a("产物超过阈值，等待WiFi环境执行", r3);
        return false;
    L10:
        return true;
    }

    public void c(com.monitor.cloudmessage.entity.a r7) {
        com.monitor.cloudmessage.f.b.b r6 = new com.monitor.cloudmessage.f.b.b(0, false, r7.d(), null);
        r6.a(2);
        com.monitor.cloudmessage.f.a.a(r6);
    }

    public abstract boolean d(com.monitor.cloudmessage.entity.a r1);
}
