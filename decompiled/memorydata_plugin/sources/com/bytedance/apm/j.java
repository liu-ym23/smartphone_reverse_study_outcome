package com.bytedance.apm;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j implements com.bytedance.services.apm.api.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1390b;
    private byte[] c;
    private long d;
    private String e;

    public j() {
    }

    private static void a(File r2, byte[] r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length == 0) goto L30;
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
    L18:
        th = th;
    L19:
        IOUtils.safeClose(r0);
        throw th;
    L10:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: Throwable -> L18 Exception -> L23
    L12:
        r2.exists();     // Catch: Throwable -> L18 Exception -> L23
        FileOutputStream r1 = new FileOutputStream(r2);     // Catch: Throwable -> L18 Exception -> L23
        r1.write(r3);     // Catch: Throwable -> L15 Exception -> L17
        r1.flush();     // Catch: Throwable -> L15 Exception -> L17
        IOUtils.safeClose(r1);
        return;
    L17:
        r0 = r1;
    L15:
        th = th;
        r0 = r1;
        goto L19
    L21:
        IOUtils.safeClose(r0);
        return;
    }

    private void b() {
        if (this.f1390b == false) goto L5;
        return;
    L5:
        this.c = FileUtils.readFileToByteArray(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getFilesDir(), "monitor_dict"));
        SharedPreferences r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSharedPreferences("dict_interval", 0);
        this.d = r0.getLong("dict_interval", 0);
        this.e = r0.getString("dict_version", null);
        this.f1390b = true;
    }

    private void c() {
        HashMap r2 = new HashMap(ApmContext.getUrlParams());
        r2.put("slardar_zstd_dict_type", CommonConsts.LOG_REPORT_TYPE_DEFAULT);
        r2.put("zstd_client_code_version", "dynamic");
        r2.put(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");
        byte[] r3 = new JSONObject(r2).toString().getBytes();     // Catch: Exception -> L13
        com.bytedance.services.apm.api.c r4 = ApmContext.doPost(UrlUtils.addParamsToURL(this.f1389a, r2), r2, r3);     // Catch: Exception -> L13
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.b() == null) goto L19;
        JSONObject r5 = new JSONObject(new String(r4.b()));     // Catch: Exception -> L13
        String r6 = r5.getString("dict_version");     // Catch: Exception -> L13
        String r7 = r5.getString("dict");     // Catch: Exception -> L13
        if (r5.getInt("code") == 200) goto L10;
        return;
    L10:
        byte[] r8 = Base64.decode(r7, 0);     // Catch: Exception -> L13
        a(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getFilesDir(), "monitor_dict"), r8);     // Catch: Exception -> L13
        this.e = r6;     // Catch: Exception -> L13
        this.c = r8;     // Catch: Exception -> L13
        this.d = System.currentTimeMillis();
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", this.d).putString("dict_version", r6).commit();
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.services.apm.api.j
    public Pair<byte[], String> a() {
        b();
        byte[] r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        c();
        r0 = this.c;
    L8:
        return new Pair(r0, this.e);
    L5:
        if ((System.currentTimeMillis() - this.d) <= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS) goto L8;
        goto L6
    }

    @Override // com.bytedance.services.apm.api.j
    public void a(String r3) {
        this.f1389a = ReportConsts.HTTPS + r3 + ReportConsts.ZSTD_DICT_PATH;
    }
}
