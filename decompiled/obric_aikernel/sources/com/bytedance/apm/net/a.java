package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.m;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
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
import t4.c;
import t4.g;

/* JADX INFO: loaded from: classes.dex */
class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f1015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f1018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DataOutputStream f1019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GZIPOutputStream f1020g;

    public a(String r10, String r11, boolean r12, Map<String, String> r13) {
        this.f1016c = r11;
        this.f1017d = r12;
        this.f1018e = r13;
        String r14 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f1014a = r14;
        HttpURLConnection r15 = m.a(r10);
        this.f1015b = r15;
        r15.setUseCaches(false);
        this.f1015b.setDoOutput(true);
        this.f1015b.setDoInput(true);
        this.f1015b.setRequestMethod(CloudConfig.REQUEST_TYPE_POST);
        this.f1015b.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + r14);
        if (r13 == null) goto L8;
        Iterator<Map.Entry<String, String>> r16 = r13.entrySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        Map.Entry<String, String> r17 = r16.next();
        this.f1015b.setRequestProperty(r17.getKey(), r17.getValue());
    L8:
        this.f1015b.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + this.f1014a);
        if (r12 == false) goto L11;
        this.f1015b.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        this.f1020g = new GZIPOutputStream(this.f1015b.getOutputStream());
        return;
    L11:
        this.f1019f = new DataOutputStream(this.f1015b.getOutputStream());
    }

    @Override // t4.g
    public void a(String r10, File r11, String r12, Map<String, String> r13) {
        String r14 = r11.getName();
        StringBuilder r15 = new StringBuilder(100);
        r15.append("--");
        r15.append(this.f1014a);
        r15.append("\r\n");
        r15.append("Content-Disposition: form-data; name=\"");
        r15.append(r10);
        r15.append("\"; filename=\"");
        r15.append(r14);
        r15.append("\"");
        Iterator<Map.Entry<String, String>> r16 = r13.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        Map.Entry<String, String> r17 = r16.next();
        r15.append("; ");
        r15.append(r17.getKey());
        r15.append("=\"");
        r15.append(r17.getValue());
        r15.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r15.append("\r\n");
        r15.append("Content-Type: ");
        r15.append(r12);
        r15.append("\r\n");
    L9:
        r15.append("\r\n");
        r15.append("Content-Transfer-Encoding: binary");
        r15.append("\r\n");
        r15.append("\r\n");
        if (this.f1017d == false) goto L12;
        this.f1020g.write(r15.toString().getBytes());
    L13:
        FileInputStream r18 = new FileInputStream(r11);
        byte[] r19 = new byte[8192];
    L14:
        int r20 = r18.read(r19);
        if (r20 == (-1)) goto L20;
        if (this.f1017d == true) goto L18;
        this.f1019f.write(r19, 0, r20);
        goto L14
    L18:
        this.f1020g.write(r19, 0, r20);
        goto L14
    L20:
        r18.close();
        if (this.f1017d == false) goto L23;
        this.f1020g.write("\r\n".getBytes());
        return;
    L23:
        this.f1019f.write("\r\n".getBytes());
        this.f1019f.flush();
        return;
    L12:
        this.f1019f.write(r15.toString().getBytes());
        goto L13
    }

    @Override // t4.g
    public void addFormField(String r10, String r11) {
        StringBuilder r12 = new StringBuilder(100);
        r12.append("--");
        r12.append(this.f1014a);
        r12.append("\r\n");
        r12.append("Content-Disposition: form-data; name=\"");
        r12.append(r10);
        r12.append("\"");
        r12.append("\r\n");
        r12.append("Content-Type: text/plain; charset=");
        r12.append(this.f1016c);
        r12.append("\r\n");
        r12.append("\r\n");
        r12.append(r11);
        r12.append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f1017d == false) goto L6;
        this.f1020g.write(r12.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f1019f.write(r12.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    @Override // t4.g
    public c finish() {
        ArrayList r10 = new ArrayList();
        byte[] r11 = ("\r\n--" + this.f1014a + "--\r\n").getBytes();
        if (this.f1017d == false) goto L5;
        this.f1020g.write(r11);
        this.f1020g.finish();
        this.f1020g.close();
    L6:
        int r12 = this.f1015b.getResponseCode();
        if (r12 != 200) goto L19;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(this.f1015b.getInputStream()));
    L9:
        String r14 = r13.readLine();
        if (r14 == null) goto L12;
        r10.add(r14);
        goto L9
    L12:
        r13.close();
        this.f1015b.disconnect();
        StringBuilder r15 = new StringBuilder();
        Iterator r16 = r10.iterator();
    L14:
        if (r16.hasNext() == false) goto L17;
        r15.append((String) r16.next());
        goto L14
    L17:
        return new c(r12, r15.toString().getBytes());
    L19:
        throw new IOException("Server returned non-OK status: " + r12);
    L5:
        this.f1019f.write(r11);
        this.f1019f.flush();
        this.f1019f.close();
        goto L6
    }
}
