package com.bytedance.applog.monitor.a;

import android.util.Base64;
import com.bytedance.bdinstall.RangersHttpException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1669b;
    private final String c;
    private final long d;
    private long e;
    private boolean f;
    private int g;
    private int h;
    private long i;
    private String j;
    private com.bytedance.applog.monitor.v3.impl.b k;
    private byte[] l;

    public b(com.bytedance.applog.monitor.v3.impl.b r1, String r2, String r3) {
        this.k = r1;
        this.f1669b = r2;
        this.c = r3;
        this.d = System.currentTimeMillis();
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void a() {
        long r16 = System.currentTimeMillis() - this.d;
        JSONObject r1 = new JSONObject();
        byte[] r2 = this.l;
        if (r2 != null) goto L5;
    L10:
        this.k.a(this.f1669b, this.c, this.e, this.f, this.g, this.h, this.i, this.j, r16, r1);
        this.l = null;
        return;
    L5:
        if ("error data".equalsIgnoreCase(this.j) == true) goto L13;
        if ("emptydata".equalsIgnoreCase(this.j) == false) goto L10;
    L13:
        r1.put("req_body_first_100bytes", Base64.encodeToString(r2, 0, Math.min(r2.length, 100), 0));     // Catch: JSONException -> L12
        goto L10
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void a(int r1) {
        this.g = r1;
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void a(String r1) {
        this.j = r1;
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void a(Throwable r4) {
        StringBuilder r0 = new StringBuilder();
        if (ZeusTransformUtils.instanceOf(r4, RangersHttpException.class) == false) goto L9;
        RangersHttpException r1 = (RangersHttpException) ZeusTransformUtils.preCheckCast(r4, RangersHttpException.class, "com.obric.memorydata.plugin");
        b(r1.getResponseCode());
        r0.append("rhe:").append(r1.getMessage());
        r4 = r4.getCause();
        if (r4 != null) goto L7;
    L11:
        a(r0.toString());
        return;
    L7:
        if (r4.getMessage() == null) goto L11;
        a(r4.getMessage());
        String r2 = ",cause:";
    L10:
        r0.append(r2).append(r4.getMessage());
        goto L11
    L9:
        r2 = "e:";
        goto L10
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void a(boolean r1) {
        this.f = r1;
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void a(byte[] r3) {
        if (r3 == null) goto L5;
        this.e = r3.length;
        this.l = r3;
        return;
    }

    public void b(int r1) {
        this.h = r1;
    }

    @Override // com.bytedance.applog.monitor.a.a
    public void b(String r3) {
        if (r3 == null) goto L5;
        this.i = r3.length();
        return;
    }
}
