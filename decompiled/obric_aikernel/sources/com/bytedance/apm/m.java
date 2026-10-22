package com.bytedance.apm;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m implements t4.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f1011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1013e;

    public m() {
    }

    private void c() {
        HashMap r10 = new HashMap(ApmContext.getUrlParams());
        r10.put("slardar_zstd_dict_type", CommonConsts.LOG_REPORT_TYPE_DEFAULT);
        r10.put("zstd_client_code_version", "dynamic");
        r10.put(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);
        byte[] r11 = new JSONObject(r10).toString().getBytes();     // Catch: Exception -> L13
        t4.c r12 = ApmContext.doPost(UrlUtils.addParamsToURL(this.f1009a, r10), r10, r11);     // Catch: Exception -> L13
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.b() == null) goto L19;
        JSONObject r13 = new JSONObject(new String(r12.b()));     // Catch: Exception -> L13
        String r14 = r13.getString("dict_version");     // Catch: Exception -> L13
        String r15 = r13.getString("dict");     // Catch: Exception -> L13
        if (r13.getInt("code") == 200) goto L10;
        return;
    L10:
        byte[] r16 = Base64.decode(r15, 0);     // Catch: Exception -> L13
        e(new File(ApmBaseContext.getContext().getFilesDir(), "monitor_dict"), r16);     // Catch: Exception -> L13
        this.f1013e = r14;     // Catch: Exception -> L13
        this.f1011c = r16;     // Catch: Exception -> L13
        this.f1012d = System.currentTimeMillis();
        ApmBaseContext.getContext().getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", this.f1012d).putString("dict_version", r14).commit();
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void d() {
        if (this.f1010b == false) goto L5;
        return;
    L5:
        this.f1011c = FileUtils.readFileToByteArray(new File(ApmBaseContext.getContext().getFilesDir(), "monitor_dict"));
        SharedPreferences r10 = ApmBaseContext.getContext().getSharedPreferences("dict_interval", 0);
        this.f1012d = r10.getLong("dict_interval", 0);
        this.f1013e = r10.getString("dict_version", null);
        this.f1010b = true;
    }

    private static void e(File r10, byte[] r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.length == 0) goto L30;
        r10.getParentFile().mkdirs();
        FileOutputStream r12 = null;
    L18:
        th = th;
    L19:
        IOUtils.safeClose(r12);
        throw th;
    L10:
        if (r10.exists() == false) goto L12;
        r10.delete();     // Catch: Throwable -> L18 Exception -> L23
    L12:
        r10.exists();     // Catch: Throwable -> L18 Exception -> L23
        FileOutputStream r13 = new FileOutputStream(r10);     // Catch: Throwable -> L18 Exception -> L23
        r13.write(r11);     // Catch: Throwable -> L15 Exception -> L17
        r13.flush();     // Catch: Throwable -> L15 Exception -> L17
        IOUtils.safeClose(r13);
        return;
    L17:
        r12 = r13;
    L15:
        th = th;
        r12 = r13;
        goto L19
    L21:
        IOUtils.safeClose(r12);
        return;
    }

    @Override // t4.k
    @Nullable
    public Pair<byte[], String> a() {
        d();
        byte[] r10 = this.f1011c;
        if (r10 != null) goto L5;
    L6:
        c();
        r10 = this.f1011c;
    L8:
        return new Pair(r10, this.f1013e);
    L5:
        if ((System.currentTimeMillis() - this.f1012d) <= 604800000) goto L8;
        goto L6
    }

    @Override // t4.k
    public void b(String r10) {
        this.f1009a = ReportConsts.HTTPS + r10 + ReportConsts.ZSTD_DICT_PATH;
    }
}
