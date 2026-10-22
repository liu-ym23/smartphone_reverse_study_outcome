package w2;

import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import u8.b;
import u8.e;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpURLConnection f12966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f12969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataOutputStream f12970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GZIPOutputStream f12971g;

    public a(String r8, String r10, boolean r11, Map<String, String> r12) {
        this.f12967c = r10;
        this.f12968d = r11;
        this.f12969e = r12;
        String r13 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f12965a = r13;
        HttpURLConnection r14 = (HttpURLConnection) new URL(r8).openConnection();
        this.f12966b = r14;
        r14.setUseCaches(false);
        r14.setDoOutput(true);
        r14.setDoInput(true);
        r14.setRequestMethod(HttpMethodContrants.POST);
        r14.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + r13);
        if (r12 == null) goto L8;
        Iterator<Map.Entry<String, String>> r15 = r12.entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        Map.Entry<String, String> r16 = r15.next();
        this.f12966b.setRequestProperty(r16.getKey(), r16.getValue());
    L8:
        this.f12966b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f12965a);
        if (r11 == false) goto L11;
        this.f12966b.setRequestProperty("Content-Encoding", "gzip");
        this.f12971g = new GZIPOutputStream(this.f12966b.getOutputStream());
        return;
    L11:
        this.f12970f = new DataOutputStream(this.f12966b.getOutputStream());
    }

    @Override // u8.e
    public final void a(String r8, File r10, HashMap r11) {
        String r12 = r10.getName();
        StringBuilder r13 = new StringBuilder(100);
        r13.append("--");
        r13.append(this.f12965a);
        r13.append("\r\nContent-Disposition: form-data; name=\"");
        r13.append(r8);
        r13.append("\"; filename=\"");
        r13.append(r12);
        r13.append("\"");
        Iterator r14 = r11.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.append("; ");
        r13.append((String) r15.getKey());
        r13.append("=\"");
        r13.append((String) r15.getValue());
        r13.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(null) == true) goto L9;
        r13.append("\r\nContent-Type: null\r\n");
    L9:
        r13.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        GZIPOutputStream r16 = this.f12971g;
        DataOutputStream r17 = this.f12970f;
        byte[] r18 = r13.toString().getBytes();
        boolean r19 = this.f12968d;
        if (r19 == false) goto L12;
        r16.write(r18);
    L13:
        FileInputStream r20 = new FileInputStream(r10);
        byte[] r21 = new byte[8192];
    L14:
        int r22 = r20.read(r21);
        if (r22 == (-1)) goto L20;
        if (r19 == true) goto L18;
        r17.write(r21, 0, r22);
        goto L14
    L18:
        r16.write(r21, 0, r22);
        goto L14
    L20:
        r20.close();
        if (r19 == false) goto L23;
        r16.write("\r\n".getBytes());
        return;
    L23:
        r17.write("\r\n".getBytes());
        r17.flush();
        return;
    L12:
        r17.write(r18);
        goto L13
    }

    @Override // u8.e
    public final void b(String r8, String r10) {
        StringBuilder r11 = new StringBuilder(100);
        r11.append("--");
        r11.append(this.f12965a);
        r11.append("\r\nContent-Disposition: form-data; name=\"");
        r11.append(r8);
        r11.append("\"\r\nContent-Type: text/plain; charset=");
        r11.append(this.f12967c);
        r11.append("\r\n\r\n");
        r11.append(r10);
        r11.append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f12968d == false) goto L6;
        this.f12971g.write(r11.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f12970f.write(r11.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    @Override // u8.e
    public final b finish() {
        ArrayList r8 = new ArrayList();
        byte[] r10 = ("\r\n--" + this.f12965a + "--\r\n").getBytes();
        if (this.f12968d == false) goto L5;
        GZIPOutputStream r11 = this.f12971g;
        r11.write(r10);
        r11.finish();
        r11.close();
    L6:
        HttpURLConnection r12 = this.f12966b;
        int r13 = r12.getResponseCode();
        if (r13 != 200) goto L19;
        BufferedReader r14 = new BufferedReader(new InputStreamReader(r12.getInputStream()));
    L9:
        String r15 = r14.readLine();
        if (r15 == null) goto L12;
        r8.add(r15);
        goto L9
    L12:
        r14.close();
        r12.disconnect();
        StringBuilder r16 = new StringBuilder();
        Iterator r17 = r8.iterator();
    L14:
        if (r17.hasNext() == false) goto L17;
        r16.append((String) r17.next());
        goto L14
    L17:
        return new b(r13, r16.toString().getBytes());
    L19:
        throw new IOException(defpackage.a.d("Server returned non-OK status: ", r13));
    L5:
        DataOutputStream r18 = this.f12970f;
        r18.write(r10);
        r18.flush();
        r18.close();
        goto L6
    }
}
