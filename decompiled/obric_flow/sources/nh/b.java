package nh;

import ai.j0;
import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ies.bullet.web.pia.s;
import com.bytedance.pia.core.bridge.channel.WebViewPort$JSInterface;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.lynx.tasm.p;
import com.obric.launcher.widget.R$id;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import kotlin.Lazy;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements oj.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f20234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20235c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public b() {
        this.f20233a = null;
        this.d = null;
        this.f20234b = null;
        this.f20235c = false;
        this.e = null;
        this.f = null;
    }

    public d a() {
        com.bytedance.ies.bullet.web.pia.c r5 = (com.bytedance.ies.bullet.web.pia.c) this.f20234b;
        if (r5 == null) goto L5;
        bh.b r10 = (bh.b) r5.a(bh.b.class);
    L6:
        if (r10 != null) goto L8;
        r10 = bh.b.f914a;
    L8:
        bh.b r13 = r10;
        r13.a("initialize.start", System.currentTimeMillis());
        Lazy r11 = Settings.B;
        if (p.a().q() == true) goto L11;
        return null;
    L11:
        e();
        String r12 = (String) this.f;
        if (r12 != null) goto L14;
    L87:
        return null;
    L14:
        if (r12.isEmpty() == true) goto L87;
        if (oh.f.a((Uri) this.g) == true) goto L20;
        String r14 = "[Runtime]: url is not support. Url: " + ((String) this.d);
        Intrinsics.checkNotNullParameter(r14, "message");
        j.C(r14, null);
        return null;
    L20:
        boolean r15 = false;
        boolean r16 = ((Uri) this.g).getBooleanQueryParameter("_pia_", false);
        if (r16 == true) goto L26;
        if (((Uri) this.g).getBooleanQueryParameter("__pia_manifest__", false) == false) goto L26;
        r15 = true;
    L26:
        if (p.a().r() == false) goto L32;
        Uri r17 = (Uri) this.g;
        com.bytedance.pia.core.setting.a r18 = com.bytedance.pia.core.setting.a.f;
        com.bytedance.pia.core.setting.a r19 = io.reactivex.internal.observers.h.a(r17);
        this.e = r19;
        if (r19 != null) goto L32;
        if (r16 == false) goto L32;
        this.e = new com.bytedance.pia.core.setting.a(SetsKt.setOf("prefetch"), 14);
    L32:
        if (((com.bytedance.pia.core.setting.a) this.e) != null) goto L36;
        if (r16 == false) goto L36;
        Uri r20 = (Uri) this.g;
        com.bytedance.pia.core.setting.a r21 = com.bytedance.pia.core.setting.a.f;
        this.e = io.reactivex.internal.observers.h.a(r20);
    L36:
        if (((com.bytedance.pia.core.setting.a) this.e) != null) goto L40;
        if (r15 == false) goto L40;
        this.e = com.bytedance.pia.core.setting.a.f;
    L40:
        if (((com.bytedance.pia.core.setting.a) this.e) != null) goto L42;
        return null;
    L42:
        oh.e r22 = oh.d.f20576a;
        zg.c r23 = (zg.c) r22.f20577a.get(this.f20233a);
        if (r23 != null) goto L45;
        r23 = new zg.c();
    L45:
        fh.b r24 = r23.f23443c;
        if (r24 != null) goto L48;
        r24 = zg.b.f23439b;
    L48:
        if (r24 != null) goto L90;
    L53:
        dh.d r25 = null;
    L54:
        com.bytedance.pia.core.utils.f r26 = new com.bytedance.pia.core.utils.f(r25);
        com.bytedance.pia.core.bridge.methods.a r27 = r23.e;
        if (r27 != null) goto L57;
        r27 = zg.b.f23440c;
    L57:
        if (r27 != null) goto L88;
    L62:
        com.bytedance.ai.resource.core.net.a r28 = null;
    L63:
        if (r28 != null) goto L65;
        r28 = new com.bytedance.ai.resource.core.net.a(16);
    L65:
        com.bytedance.ai.resource.core.net.a r29 = r28;
        com.bytedance.ies.bullet.web.pia.g r30 = r23.f23442b;
        if (r30 != null) goto L68;
        Application r31 = zg.b.f23438a;
        r30 = null;
    L68:
        if (r30 != null) goto L92;
    L73:
        String r32 = null;
    L74:
        if (r32 != null) goto L76;
        r32 = "";
    L76:
        String r110 = r32;
        fh.b r33 = r23.g;
        if (r33 != null) goto L79;
        Application r34 = zg.b.f23438a;
        r33 = null;
    L79:
        if (r33 != null) goto L94;
    L84:
        Map r111 = null;
    L86:
        return new d((Uri) this.g, (String) this.f, this.f20233a, (com.bytedance.ies.bullet.web.pia.c) this.f20234b, this.f20235c, r26, r29, r110, (com.bytedance.pia.core.setting.a) this.e, r111, r13);
    L94:
        r111 = (Map) r33.a((com.bytedance.ies.bullet.web.pia.c) this.f20234b);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] create globalProps error:", "message");
        j.x("[Runtime] create globalProps error:", th);
        goto L84
    L92:
        r32 = (String) r30.create();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] create custom UserAgent error:", "message");
        j.x("[Runtime] create custom UserAgent error:", th);
        goto L73
    L88:
        r28 = new com.bytedance.ai.resource.core.net.a(17);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] create Retrofit error:", "message");
        j.x("[Runtime] create Retrofit error:", th);
        goto L62
    L90:
        r25 = (dh.d) r24.a((com.bytedance.ies.bullet.web.pia.c) this.f20234b);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] create ResourceLoader error:", "message");
        j.x("[Runtime] create ResourceLoader error:", th);
        goto L53
    L5:
        r10 = null;
        goto L6
    }

    public d b(String r10) {
        d r5 = null;
        if (r10 != null) goto L5;
    L40:
        return r5;
    L5:
        if (r10.isEmpty() == true) goto L40;
        ConcurrentHashMap r11 = h.f20259a;
        h r12 = g.f20258a;
        String r13 = this.f20233a;
        com.bytedance.ies.bullet.web.pia.c r14 = (com.bytedance.ies.bullet.web.pia.c) this.f20234b;
        r12.getClass();
        b r15 = new b();
        r15.d = r10;
        r15.f20233a = r13;
        r15.f20234b = r14;
        r15.e = null;
        String r16 = r15.e();
        if (r16 != null) goto L10;
    L30:
        if (r5 == null) goto L40;
        a r17 = (a) this.d;
        r5.D = r17;
        r17.b(r5, "ctx-pia-runtime");
        if (r5.f20253y.get() == true) goto L34;
        i.f20260b.a(r5);
        r5.i();
    L34:
        View r18 = (View) ((WeakReference) this.e).get();
        if (r18 == null) goto L37;
        r18.setTag(R$id.tag_binding_pia_runtime, r5);
        r5.d(r18);
    L37:
        s r19 = (s) this.g;
        if (r19 == null) goto L40;
        r5.g("event-on-bind-bridge-handle", new Object[]{r19});
        goto L40
    L10:
        if (r16.isEmpty() == true) goto L30;
        FutureTask r20 = (FutureTask) h.f20259a.remove(r16);
        if (r20 != null) goto L41;
        Intrinsics.checkNotNullParameter("[Runtime] lack warmup task.", "message");
        j.C("[Runtime] lack warmup task.", null);
    L29:
        r5 = r15.a();
        goto L30
    L41:
        Lazy r21 = Settings.B;     // Catch: Throwable -> L17
        Application r22 = zg.b.f23438a;     // Catch: Throwable -> L17
        boolean r23 = false;
        if (r20.isDone() == true) goto L19;
        r23 = r20.cancel(false);     // Catch: Throwable -> L17
    L19:
        if (r23 == true) goto L29;
        if (p.a().n() == false) goto L23;
        d r24 = (d) r20.get();     // Catch: Throwable -> L17
    L24:
        if (r24 == null) goto L29;
        Intrinsics.checkNotNullParameter("[Runtime] consume warmup success.", "message");     // Catch: Throwable -> L17
        j.y("[Runtime] consume warmup success.", null);     // Catch: Throwable -> L17
        r5 = r24;
        goto L30
    L23:
        r24 = (d) r20.get(p.a().a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        j.s("[Runtime] consume warmup fail. " + th);
        goto L29
    }

    public void c() {
        d r5 = (d) this.f;
        if (r5 == null) goto L26;
        com.bytedance.pia.core.tracing.b r10 = r5.s;
        if (((Boolean) r10.f7106a.getValue()).booleanValue() == true) goto L17;
        String r11 = r10.f7110i;
        if (r11 == null) goto L17;
        if (r11.length() == 0) goto L17;
        if (r10.f7107b == false) goto L15;
    L16:
        m.b(new com.bytedance.pia.core.tracing.a(r10, 0));
        goto L17
    L15:
        if (Intrinsics.areEqual(r10.f7109h, "ssr") == true) goto L16;
    L17:
        View r12 = (View) ((WeakReference) this.e).get();
        if ((r12 instanceof WebView) == false) goto L24;
        WeakHashMap r13 = WebViewPort$JSInterface.f6958c;
        WebViewPort$JSInterface r14 = (WebViewPort$JSInterface) r13.get((WebView) r12);
        if (r14 == null) goto L23;
        r14.f6959a.set(null);
        r14.f6960b = null;
    L23:
        r12.setTag(R$id.tag_binding_pia_runtime, null);
    L24:
        ((d) this.f).release();
        this.f = null;
        return;
    }

    @Override // oj.f
    public void d(File r10, String r11, HashMap r12) {
        String r5 = r10.getName();
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.x(100, "--");
        androidx.constraintlayout.motion.widget.a.C(r13, this.f20233a, "\r\nContent-Disposition: form-data; name=\"", r11, "\"; filename=\"");
        r13.append(r5);
        r13.append("\"");
        Iterator r14 = r12.entrySet().iterator();
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
        GZIPOutputStream r16 = (GZIPOutputStream) this.g;
        boolean r17 = this.f20235c;
        DataOutputStream r18 = (DataOutputStream) this.f;
        if (r17 == false) goto L12;
        r16.write(r13.toString().getBytes());
    L13:
        FileInputStream r19 = new FileInputStream(r10);
        byte[] r20 = new byte[8192];
    L14:
        int r21 = r19.read(r20);
        if (r21 == (-1)) goto L20;
        if (r17 == true) goto L18;
        r18.write(r20, 0, r21);
        goto L14
    L18:
        r16.write(r20, 0, r21);
        goto L14
    L20:
        r19.close();
        if (r17 == false) goto L23;
        r16.write("\r\n".getBytes());
        return;
    L23:
        r18.write("\r\n".getBytes());
        r18.flush();
        return;
    L12:
        r18.write(r13.toString().getBytes());
        goto L13
    }

    public String e() {
        if (TextUtils.isEmpty((String) this.d) == false) goto L5;
        return null;
    L5:
        Lazy r5 = Settings.B;
        if (p.a().r() == false) goto L8;
    L12:
        String r10 = (String) this.f;
        if (r10 == null) goto L15;
        return r10;
    L15:
        Uri r11 = Uri.parse((String) this.d);
        this.g = r11;
        String r12 = j.k(r11, null);
        this.f = r12;
        return r12;
    L8:
        if (((String) this.d).contains("__pia_manifest__") == true) goto L12;
        if (((String) this.d).contains("_pia_") == true) goto L12;
        return null;
    }

    @Override // oj.f
    public void f(String r5, HashMap r10) {
        StringBuilder r11 = androidx.constraintlayout.motion.widget.a.x(100, "--");
        r11.append(this.f20233a);
        r11.append("\r\nContent-Disposition: form-data; name=\"params.txt\"; filename=\"params.txt\"");
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.append("; ");
        r11.append((String) r13.getKey());
        r11.append("=\"");
        r11.append((String) r13.getValue());
        r11.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty("text/plain") == true) goto L9;
        r11.append("\r\nContent-Type: text/plain\r\n");
    L9:
        r11.append("\r\n");
        GZIPOutputStream r14 = (GZIPOutputStream) this.g;
        boolean r15 = this.f20235c;
        DataOutputStream r16 = (DataOutputStream) this.f;
        if (r15 == false) goto L12;
        r14.write(r11.toString().getBytes());
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        if (r15 == false) goto L17;
        r14.write(r5.getBytes());
    L18:
        if (r15 == false) goto L20;
        r14.write("\r\n".getBytes());
        return;
    L20:
        r16.write("\r\n".getBytes());
        r16.flush();
        return;
    L17:
        r16.write(r5.getBytes());
        goto L18
    L12:
        r16.write(r11.toString().getBytes());
        goto L13
    }

    @Override // oj.f
    public oj.b finish() {
        ArrayList r5 = new ArrayList();
        byte[] r10 = ("\r\n--" + this.f20233a + "--\r\n").getBytes();
        if (this.f20235c == false) goto L5;
        GZIPOutputStream r11 = (GZIPOutputStream) this.g;
        r11.write(r10);
        r11.finish();
        r11.close();
    L6:
        HttpURLConnection r12 = (HttpURLConnection) this.d;
        int r13 = r12.getResponseCode();
        if (r13 != 200) goto L19;
        BufferedReader r14 = new BufferedReader(new InputStreamReader(r12.getInputStream()));
    L9:
        String r15 = r14.readLine();
        if (r15 == null) goto L12;
        r5.add(r15);
        goto L9
    L12:
        r14.close();
        r12.disconnect();
        StringBuilder r16 = new StringBuilder();
        Iterator r17 = r5.iterator();
    L14:
        if (r17.hasNext() == false) goto L17;
        r16.append((String) r17.next());
        goto L14
    L17:
        return new oj.b(r13, r16.toString().getBytes());
    L19:
        throw new IOException(j0.g(r13, "Server returned non-OK status: "));
    L5:
        DataOutputStream r18 = (DataOutputStream) this.f;
        r18.write(r10);
        r18.flush();
        r18.close();
        goto L6
    }

    @Override // oj.f
    public void h(String r5, String r10) {
        StringBuilder r11 = androidx.constraintlayout.motion.widget.a.x(100, "--");
        androidx.constraintlayout.motion.widget.a.C(r11, this.f20233a, "\r\nContent-Disposition: form-data; name=\"", r5, "\"\r\nContent-Type: text/plain; charset=");
        androidx.constraintlayout.motion.widget.a.C(r11, (String) this.e, "\r\n\r\n", r10, "\r\n");
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f20235c == false) goto L8;
        ((GZIPOutputStream) this.g).write(r11.toString().getBytes());     // Catch: IOException -> L6
    L12:
        return;
    L8:
        ((DataOutputStream) this.f).write(r11.toString().getBytes());     // Catch: IOException -> L6
        goto L12
    }

    public b(String r5, String r10, boolean r11, Map r12) {
        this.e = r10;
        this.f20235c = r11;
        this.f20234b = r12;
        String r13 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f20233a = r13;
        HttpURLConnection r14 = com.bytedance.apm.util.g.a(r5);
        this.d = r14;
        r14.setUseCaches(false);
        r14.setDoOutput(true);
        r14.setDoInput(true);
        r14.setRequestMethod("POST");
        r14.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + r13);
        if (r12 == null) goto L8;
        Iterator r15 = r12.entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        Map.Entry r16 = (Map.Entry) r15.next();
        ((HttpURLConnection) this.d).setRequestProperty((String) r16.getKey(), (String) r16.getValue());
    L8:
        ((HttpURLConnection) this.d).setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f20233a);
        if (r11 == false) goto L11;
        ((HttpURLConnection) this.d).setRequestProperty("Content-Encoding", "gzip");
        this.g = new GZIPOutputStream(((HttpURLConnection) this.d).getOutputStream());
        return;
    L11:
        this.f = new DataOutputStream(((HttpURLConnection) this.d).getOutputStream());
    }
}
