package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class h implements com.bytedance.applog.util.h, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f15086b;
    private volatile long c;
    private List<String> d;
    private BlockingQueue<a> e;
    private com.bytedance.common.utility.a.c f;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONArray f15088b;
        final /* synthetic */ h c;

        public a(h r1, String r2, JSONArray r3) {
            this.c = r1;
            this.f15087a = r2;
            this.f15088b = r3;
        }
    }

    public h() {
        this.f15086b = false;
        this.c = 200;
        this.e = new LinkedBlockingQueue();
    }

    private JSONArray a(JSONArray r2, JSONArray r3) {
        if (r3 != null) goto L4;
    L16:
        return r2;
    L4:
        if (r3.length() <= 0) goto L16;
        if (r2 != null) goto L8;
    L15:
        return r3;
    L8:
        if (r2.length() <= 0) goto L15;
        int r1 = 0;
    L12:
        if (r1 >= r3.length()) goto L14;
        r2.put(r3.optJSONObject(r1));
        r1 = r1 + 1;
        goto L12
    L14:
        return r2;
    }

    @Override // com.bytedance.applog.util.h
    public boolean isEnable() {
        return this.f15086b;
    }

    @Override // com.bytedance.applog.util.h
    public void putEvent(String r3, JSONArray r4) {
        if (this.f15086b == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.length() <= 0) goto L15;
        this.e.add(new a(this, r3, r4));
        return;
    L15:
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
    L86:
    L75:
        th = move-exception;
        Logger.d("EventVerifyWrapper", "out exception =", th);
        return;
    L4:
        if (Thread.interrupted() == true) goto L5;
        if (this.f15086b == false) goto L123;
        JSONObject r0 = AppLog.u();     // Catch: Throwable -> L75
        if (r0 != null) goto L12;
    L80:
        Thread.sleep(1000);     // Catch: InterruptedException -> L78 Throwable -> L75
        goto L86
    L12:
        if (r0.isNull("device_id") == true) goto L80;
        if (TextUtils.isEmpty(this.f15085a) == true) goto L80;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.e.take(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L75
        r6.add(r1);     // Catch: Throwable -> L75
        this.e.drainTo(r6);     // Catch: Throwable -> L75
        HashMap r2 = new HashMap();     // Catch: Throwable -> L75
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L75
    L18:
        if (r7.hasNext() == false) goto L82;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        if (r8 == null) goto L18;
        JSONArray r9 = r8.f15088b;     // Catch: Throwable -> L75
        if (r9 != null) goto L24;
    L49:
        r2.put(r8.f15087a, a((JSONArray) ZeusTransformUtils.preCheckCast(r2.get(r8.f15087a), JSONArray.class, "com.obric.memorydata.plugin"), r9));     // Catch: Throwable -> L75
        goto L18
    L24:
        if (r9.length() <= 0) goto L49;
        int r10 = 0;
    L27:
        if (r10 >= r9.length()) goto L49;
        JSONObject r11 = r9.optJSONObject(r10);     // Catch: Throwable -> L75
        if (r11 == null) goto L48;
        Iterator<String> r12 = r11.keys();     // Catch: Throwable -> L75
    L32:
        if (r12.hasNext() == false) goto L48;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r13) == true) goto L32;
        List<String> r14 = this.d;     // Catch: Throwable -> L75
        if (r14 == null) goto L40;
        if (r14.contains(r13) == false) goto L40;
    L41:
        String r15 = r11.optString(r13);     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r15) == true) goto L32;
        if (r15.contains("?") == false) goto L32;
        Logger.d("EventVerifyWrapper", "original value = " + r15);     // Catch: Throwable -> L75
        String r16 = Uri.encode(r15);     // Catch: Throwable -> L75
        Logger.d("EventVerifyWrapper", "encode value = " + r16);     // Catch: Throwable -> L75
        r11.put(r13, r16);     // Catch: JSONException -> L79 Throwable -> L75
    L40:
        if (r13.contains("url") == false) goto L32;
    L48:
        r10 = r10 + 1;
        goto L27
    L82:
        String r17 = y.a(Uri.parse(this.f15085a).buildUpon().toString(), true);     // Catch: Throwable -> L63
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L63
        r18.put("header", AppLog.u());     // Catch: Throwable -> L63
        r18.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Throwable -> L63
        r18.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Throwable -> L63
        r18.put("time_sync", AppLog.a(null).x());     // Catch: Throwable -> L63
        Iterator r3 = r2.entrySet().iterator();     // Catch: Throwable -> L63
    L53:
        if (r3.hasNext() == false) goto L57;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        if (r4 == null) goto L53;
        r18.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), r4.getValue());     // Catch: Throwable -> L63
        goto L53
    L57:
        byte[] r5 = r18.toString().getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L63
        Map<String, String> r19 = AppLog.D();     // Catch: Throwable -> L63
        if (AppLog.k() == false) goto L60;
        String r20 = y.a(AppLog.K(), r17, r5, null, false, null, r19, null, false, false);     // Catch: Throwable -> L63
    L61:
        Logger.d("EventVerifyWrapper", "send event verify resp: " + r20);     // Catch: Throwable -> L63
    L67:
        if (this.c <= 0) goto L86;
        Thread.sleep(this.c);     // Catch: InterruptedException -> L70 Throwable -> L75
    L70:
        e = move-exception;
        Logger.d("EventVerifyWrapper", "wait next event verify exception", e);     // Catch: Throwable -> L75
        goto L86
    L60:
        r20 = y.a(r17, r5, false, "application/octet-stream;tt-data=b", false, r19, false, false);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Logger.e("EventVerifyWrapper", "send event verify", th);     // Catch: Throwable -> L75
        goto L67
    L123:
        return;
    L5:
        Logger.d("EventVerifyWrapper", "interrupted");     // Catch: Throwable -> L75
    }

    @Override // com.bytedance.applog.util.h
    public void setEnable(boolean r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (this.f15086b != r3) goto L5;
        return;
    L5:
        this.f15086b = r3;
        if (this.f15086b == false) goto L8;
        com.bytedance.common.utility.a.c r6 = new com.bytedance.common.utility.a.c(this, "EventVerifyWrapper", true);
        this.f = r6;
        r6.a();
        return;
    L8:
        this.f = null;
    }

    @Override // com.bytedance.applog.util.h
    public void setEventVerifyUrl(String r2) {
        this.f15085a = r2 + "/service/2/app_log_test/";
    }
}
