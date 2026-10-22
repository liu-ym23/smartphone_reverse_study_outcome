package h84;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.v;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import i84.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends e {
    public static volatile Pair<byte[], String> j;
    public static volatile Pair<String, byte[]> k;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public volatile Map<String, String> g;
    public final AtomicBoolean h;
    public final String i;

    public class a implements Runnable {
        public final /* synthetic */ m a;

        @Override // java.lang.Runnable
        public final void run() {
            m r0 = this.a;     // Catch: Throwable -> L4
            String r1 = r0.i;     // Catch: Throwable -> L4
            b r2 = new b(r0);     // Catch: Throwable -> L4
            v.c(r1).execute(r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ m a;

        public final void a() {
            this.a.h.set(false);
        L14:
            th = move-exception;
            th.printStackTrace();
        L16:
            String r0 = "";
        L17:
            m r1 = this.a;
            if ("mounted".equals(r1.b) == false) goto L77;
            FileLock r2 = null;
            PolarisFileWrapper r3 = new PolarisFileWrapper(r1.f);     // Catch: Throwable -> L33
            if (r3.exists() == false) goto L24;
        L26:
            RandomAccessFile r4 = new RandomAccessFile(new PolarisFileWrapper(r1.f + "/" + r1.d), "rwd");     // Catch: Throwable -> L33
            r2 = r4.getChannel().lock();     // Catch: Throwable -> L31
            byte[] r5 = r1.j(r0);     // Catch: Throwable -> L31
            r4.setLength(0);     // Catch: Throwable -> L31
            r4.write(r5);     // Catch: Throwable -> L31
            if (r2 != null) goto L62;
        L58:
            r4.close();     // Catch: Exception -> L55
            return;
        L78:
            return;
        L62:
            r2.release();     // Catch: Exception -> L53
        L31:
            th = th;
        L72:
        L45:
            th = move-exception;
            if (r2 != null) goto L70;
        L50:
            if (r4 == null) goto L79;
            r4.close();     // Catch: Exception -> L54
            throw th;
        L80:
            throw th;
        L79:
            throw th;
        L70:
            r2.release();     // Catch: Exception -> L49
            goto L50
        L36:
            if ((th instanceof IOException) == true) goto L38;
            th.printStackTrace();     // Catch: Throwable -> L45
        L38:
            if (r2 != null) goto L66;
        L42:
            if (r4 != null) goto L58;
            return;
        L66:
            r2.release();     // Catch: Exception -> L41
            goto L42
        L24:
            if (r3.mkdirs() == true) goto L26;
            return;
        L33:
            th = th;
            r4 = null;
            goto L72
        L77:
            return;
        L4:
            if (this.a.g == null) goto L16;
            Map<String, String> r6 = this.a.g;     // Catch: Throwable -> L14
            if (r6 == null) goto L16;
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L14
            Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();     // Catch: Throwable -> L14
        L10:
            if (r8.hasNext() == false) goto L12;
            Map.Entry<String, String> r9 = r8.next();     // Catch: Throwable -> L14
            r7.put(r9.getKey(), r9.getValue());     // Catch: Throwable -> L14
            goto L10
        L12:
            r0 = r7.toString();     // Catch: Throwable -> L14
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(m r1) {
            this.a = r1;
        }
    }

    public final String[] f() {
        String r0 = k("sim_serial_number");
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    public final String a(String r1) {
        return k(r1);
    }

    public final void d(String[] r2) {
        if (r2 == null) goto L6;
        l("sim_serial_number", TextUtils.join("\n", r2));
        return;
    }

    public final void e(List<String> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r4.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        if (this.g == null) goto L10;
        this.g.remove(r1);
    L10:
        l(r1, null);
        goto L6
    L11:
        super.e(r4);
    }

    public final String i(byte[] r3) {
        if (j == null) goto L9;
        if (Arrays.equals(r3, (byte[]) j.first) == false) goto L9;
        return (String) j.second;
    L9:
        if (k != null) goto L11;
    L21:
        String r0 = s.b(r3, this.e);     // Catch: Throwable -> L16
    L18:
        if (r0 == null) goto L20;
        j = new Pair(r3, r0);
    L20:
        return r0;
    L16:
        th = move-exception;
        th.printStackTrace();
        r0 = null;
        goto L18
    L11:
        if (Arrays.equals(r3, (byte[]) k.second) == false) goto L21;
        return (String) k.first;
    }

    public final byte[] j(String r3) {
        if (k == null) goto L9;
        if (c1.f(r3, (String) k.first) == false) goto L9;
        return (byte[]) k.second;
    L9:
        if (j != null) goto L11;
    L21:
        byte[] r0 = s.c(r3, this.e);     // Catch: Throwable -> L16
    L18:
        if (r0 == null) goto L20;
        k = new Pair(r3, r0);
    L20:
        return r0;
    L16:
        th = move-exception;
        th.printStackTrace();
        r0 = null;
        goto L18
    L11:
        if (c1.f(r3, (String) j.second) == false) goto L21;
        return (byte[]) j.first;
    }

    public final String k(String r9) {
        if (TextUtils.isEmpty(r9) == true) goto L9;
        if (this.g == null) goto L9;
        String r10 = this.g.get(r9);
        int r0 = t.a;
        return r10;
    L9:
        if ("mounted".equals(this.b) == true) goto L94;
        return null;
    L94:
    L59:
        th = th;
        RandomAccessFile r2 = null;
        FileLock r3 = null;
    L102:
    L74:
        th = move-exception;
        if (this.g != null) goto L78;
        this.g = new ConcurrentHashMap();
    L78:
        if (r3 != null) goto L110;
    L82:
        if (r2 == null) goto L119;
        r2.close();     // Catch: Exception -> L91
        throw th;
    L120:
        throw th;
    L119:
        throw th;
    L110:
        r3.release();     // Catch: Exception -> L81
        goto L82
    L62:
        if ((th instanceof IOException) == true) goto L65;
        th.printStackTrace();     // Catch: Throwable -> L74
    L65:
        if (this.g != null) goto L67;
        this.g = new ConcurrentHashMap();
    L67:
        if (r3 != null) goto L96;
    L71:
        if (r2 != null) goto L112;
    L73:
        return null;
    L112:
        r2.close();     // Catch: Exception -> L90
        goto L73
    L96:
        r3.release();     // Catch: Exception -> L70
        goto L71
    L12:
        if (new PolarisFileWrapper(this.f).exists() == false) goto L14;
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.f + "/" + this.d);     // Catch: Throwable -> L59
        r2 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L59
        r3 = r2.getChannel().lock();     // Catch: Throwable -> L57
    L55:
        th = th;
        goto L102
    L20:
        if (r1.isFile() == false) goto L50;
        byte[] r4 = new byte[2049];     // Catch: Throwable -> L55
        int r5 = r2.read(r4, 0, 2049);     // Catch: Throwable -> L55
        if (r5 <= 0) goto L50;
        if (r5 >= 2049) goto L50;
        String r6 = i(Arrays.copyOf(r4, r5));     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r6) == false) goto L27;
        ConcurrentHashMap r7 = new ConcurrentHashMap();     // Catch: Throwable -> L55
    L32:
        this.g = r7;     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r9) == true) goto L35;
        String r11 = this.g.get(r9);     // Catch: Throwable -> L55
        int r8 = t.a;     // Catch: Throwable -> L55
        if (this.g != null) goto L45;
        this.g = new ConcurrentHashMap();
    L45:
        if (r3 != null) goto L108;
    L104:
        r2.close();     // Catch: Exception -> L88
    L48:
        return r11;
    L108:
        r3.release();     // Catch: Exception -> L87
        goto L104
    L35:
        if (this.g != null) goto L37;
        this.g = new ConcurrentHashMap();
    L37:
        if (r3 != null) goto L106;
    L98:
        r2.close();     // Catch: Exception -> L86
    L40:
        return null;
    L106:
        r3.release();     // Catch: Exception -> L85
        goto L98
    L27:
        JSONObject r12 = new JSONObject(r6);     // Catch: Throwable -> L55
        Iterator<String> r13 = r12.keys();     // Catch: Throwable -> L55
        ConcurrentHashMap r14 = new ConcurrentHashMap();     // Catch: Throwable -> L55
    L29:
        if (r13.hasNext() == false) goto L31;
        String r15 = r13.next();     // Catch: Throwable -> L55
        r14.put(r15, (String) r12.get(r15));     // Catch: Throwable -> L55
        goto L29
    L31:
        r7 = r14;
    L50:
        if (this.g != null) goto L52;
        this.g = new ConcurrentHashMap();
    L52:
        if (r3 == null) goto L112;
        r3.release();     // Catch: Exception -> L89
    L57:
        th = th;
        r3 = null;
        goto L102
    L14:
        if (this.g != null) goto L16;
        this.g = new ConcurrentHashMap();
    L16:
        return null;
    }

    public final void c(String r1, String r2) {
        l(r1, r2);
    }

    public final void l(String r3, String r4) {
        if (this.g != null) goto L8;
        k(null);
        if (this.g != null) goto L8;
        this.g = new ConcurrentHashMap();
    L8:
        if (c1.f(this.g.get(r3), r4) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L16;
        if (this.g.containsKey(r3) == false) goto L16;
        this.g.remove(r3);
    L19:
        if (this.c == true) goto L21;
        return;
    L21:
        if (this.h.compareAndSet(false, true) == false) goto L25;
        v.b(this.i).postDelayed(new a(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        this.g.put(r3, r4);
        goto L19
    }

    public m(boolean r3, String r4, String r5, String r6, String r7) {
        this.h = new AtomicBoolean(false);
        this.b = Environment.getExternalStorageState();
        this.f = r4;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.i = r7;
    }
}
