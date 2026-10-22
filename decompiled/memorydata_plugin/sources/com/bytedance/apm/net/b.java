package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.services.apm.api.c;
import com.bytedance.services.apm.api.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f1433b;
    private String c;
    private boolean d;
    private Map<String, String> e;
    private DataOutputStream f;
    private GZIPOutputStream g;

    public b(String r6, String r7, boolean r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        this.c = r7;
        this.d = r8;
        this.e = r10;
        String r11 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f1432a = r11;
        HttpURLConnection r12 = k.a(r6);
        this.f1433b = r12;
        r12.setUseCaches(false);
        this.f1433b.setDoOutput(true);
        this.f1433b.setDoInput(true);
        this.f1433b.setRequestMethod("POST");
        this.f1433b.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + r11);
        if (r10 == null) goto L8;
        Iterator<Map.Entry<String, String>> r13 = r10.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.f1433b.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin"));
    L8:
        this.f1433b.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + this.f1432a);
        if (r8 == false) goto L11;
        this.f1433b.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        this.g = new GZIPOutputStream(this.f1433b.getOutputStream());
        return;
    L11:
        this.f = new DataOutputStream(this.f1433b.getOutputStream());
    }

    @Override // com.bytedance.services.apm.api.g
    public c a() {
        ArrayList r0 = new ArrayList();
        byte[] r1 = ("\r\n--" + this.f1432a + "--\r\n").getBytes();
        if (this.d == false) goto L5;
        this.g.write(r1);
        this.g.finish();
        this.g.close();
    L6:
        int r2 = this.f1433b.getResponseCode();
        if (r2 != 200) goto L19;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(this.f1433b.getInputStream()));
    L9:
        String r4 = r3.readLine();
        if (r4 == null) goto L12;
        r0.add(r4);
        goto L9
    L12:
        r3.close();
        this.f1433b.disconnect();
        StringBuilder r5 = new StringBuilder();
        Iterator r6 = r0.iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        r5.append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        goto L14
    L17:
        return new c(r2, r5.toString().getBytes());
    L19:
        throw new IOException("Server returned non-OK status: " + r2);
    L5:
        this.f.write(r1);
        this.f.flush();
        this.f.close();
        goto L6
    }

    @Override // com.bytedance.services.apm.api.g
    public void a(String r8, File r9, String r10, Map<String, String> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        String r0 = r9.getName();
        StringBuilder r2 = new StringBuilder(100);
        r2.append("--").append(this.f1432a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(r8).append("\"; filename=\"").append(r0).append("\"");
        Iterator r13 = r12.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2.append("; ").append((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin")).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin")).append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r2.append("\r\n").append("Content-Type: ").append(r10).append("\r\n");
    L9:
        r2.append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        if (this.d == false) goto L12;
        this.g.write(r2.toString().getBytes());
    L13:
        FileInputStream r15 = new FileInputStream(r9);
        byte[] r16 = new byte[8192];
    L14:
        int r17 = r15.read(r16);
        if (r17 == (-1)) goto L20;
        if (this.d == true) goto L18;
        this.f.write(r16, 0, r17);
        goto L14
    L18:
        this.g.write(r16, 0, r17);
        goto L14
    L20:
        r15.close();
        if (this.d == false) goto L23;
        this.g.write("\r\n".getBytes());
        return;
    L23:
        this.f.write("\r\n".getBytes());
        this.f.flush();
        return;
    L12:
        this.f.write(r2.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.g
    public void a(String r5, String r6) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--").append(this.f1432a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(r5).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append(this.c).append("\r\n").append("\r\n").append(r6).append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.d == false) goto L6;
        this.g.write(r0.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f.write(r0.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    @Override // com.bytedance.services.apm.api.g
    public void a(String r8, String r9, String r10, Map<String, String> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--").append(this.f1432a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(r8).append("\"; filename=\"").append(r8).append("\"");
        Iterator r13 = r12.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.append("; ").append((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin")).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.memorydata.plugin")).append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r0.append("\r\n").append("Content-Type: ").append(r10).append("\r\n");
    L9:
        r0.append("\r\n");
        if (this.d == false) goto L12;
        this.g.write(r0.toString().getBytes());
    L13:
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        if (this.d == false) goto L18;
        this.g.write(r9.getBytes());
    L20:
        if (this.d == false) goto L22;
        this.g.write("\r\n".getBytes());
        return;
    L22:
        this.f.write("\r\n".getBytes());
        this.f.flush();
        return;
    L18:
        this.f.write(r9.getBytes());
        goto L20
    L12:
        this.f.write(r0.toString().getBytes());
        goto L13
    }
}
