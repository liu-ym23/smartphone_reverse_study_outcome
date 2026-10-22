package com.monitor.cloudmessage.b.a;

import android.os.Debug;
import android.text.TextUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g extends com.monitor.cloudmessage.b.a implements com.monitor.cloudmessage.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f5827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5828b;

    public g() {
        this.f5827a = null;
        this.f5828b = 0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public String b() {
        return "heap_oom";
    }

    @Override // com.monitor.cloudmessage.f.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f5827a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    @Override // com.monitor.cloudmessage.b.a
    public boolean d(com.monitor.cloudmessage.entity.a r14) {
        JSONObject r0 = new JSONObject(r14.a());
        if (a(r0, r14) == false) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - this.f5828b) >= 300000) goto L8;
        return false;
    L8:
        this.f5828b = System.currentTimeMillis();
        boolean r1 = r0.optBoolean("isTryToCatch", false);
        String r2 = CloudMessageManager.getDumpFileDir();
        String r4 = "本地未设置dumpFileName";
        if (TextUtils.isEmpty(r2) == false) goto L12;
        a("本地未设置dumpFileName", r14);
        return true;
    L12:
        if (r1 == true) goto L30;
    L17:
        File r3 = new File(r2);
        if (TextUtils.isEmpty(r2) == true) goto L22;
        r4 = null;
    L22:
        if (r3.exists() == true) goto L25;
        r4 = "dumpFile不存在";
    L25:
        if (TextUtils.isEmpty(r4) == true) goto L28;
        a(r4, r14);
        return true;
    L28:
        this.f5827a = r3;
        com.monitor.cloudmessage.f.b.a r5 = new com.monitor.cloudmessage.f.b.a("log_heap_oom", 0, false, r14.d(), this, null);
        r5.a(true);
        com.monitor.cloudmessage.f.a.a(r5);
        return true;
    L30:
        Debug.dumpHprofData(r2);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
