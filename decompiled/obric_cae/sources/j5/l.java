package j5;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
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
import x4.r;
import x4.t;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class l extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Pair<byte[], String> f8665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile Pair<String, byte[]> f8666k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f8671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ConcurrentHashMap f8672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f8673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8674i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f8675a;

        public a(l r8) {
            this.f8675a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l r8 = this.f8675a;
            String r10 = r8.f8674i;
            t.f(new b(r8), r10);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f8676a;

        public b(l r8) {
            this.f8676a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f8676a.f8673h.set(false);
        L14:
            th = move-exception;
            th.printStackTrace();
        L16:
            String r8 = "";
        L17:
            l r10 = this.f8676a;
            if ("mounted".equals(r10.f8667b) == false) goto L75;
            FileLock r11 = null;
            File r12 = new File(r10.f8671f);     // Catch: Throwable -> L33
            if (r12.exists() == false) goto L24;
        L26:
            RandomAccessFile r13 = new RandomAccessFile(new File(r10.f8671f + "/" + r10.f8669d), "rwd");     // Catch: Throwable -> L33
            r11 = r13.getChannel().lock();     // Catch: Throwable -> L31
            byte[] r14 = r10.j(r8);     // Catch: Throwable -> L31
            r13.setLength(0);     // Catch: Throwable -> L31
            r13.write(r14);     // Catch: Throwable -> L31
            if (r11 != null) goto L58;
        L56:
            r13.close();     // Catch: Exception -> L53
            return;
        L76:
            return;
        L58:
            r11.release();     // Catch: Exception -> L49
        L31:
            th = th;
        L70:
        L43:
            th = move-exception;
            if (r11 != null) goto L68;
        L46:
            if (r13 == null) goto L77;
            r13.close();     // Catch: Exception -> L52
            throw th;
        L78:
            throw th;
        L77:
            throw th;
        L68:
            r11.release();     // Catch: Exception -> L51
            goto L46
        L36:
            if ((th instanceof IOException) == true) goto L38;
            th.printStackTrace();     // Catch: Throwable -> L43
        L38:
            if (r11 != null) goto L64;
        L40:
            if (r13 != null) goto L56;
            return;
        L64:
            r11.release();     // Catch: Exception -> L50
            goto L40
        L24:
            if (r12.mkdirs() == true) goto L26;
            return;
        L33:
            th = th;
            r13 = null;
            goto L70
        L75:
            return;
        L4:
            if (this.f8676a.f8672g == null) goto L16;
            ConcurrentHashMap r15 = this.f8676a.f8672g;     // Catch: Throwable -> L14
            if (r15 == null) goto L16;
            JSONObject r16 = new JSONObject();     // Catch: Throwable -> L14
            Iterator r17 = r15.entrySet().iterator();     // Catch: Throwable -> L14
        L10:
            if (r17.hasNext() == false) goto L12;
            Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L14
            r16.put((String) r18.getKey(), r18.getValue());     // Catch: Throwable -> L14
            goto L10
        L12:
            r8 = r16.toString();     // Catch: Throwable -> L14
            goto L17
        }
    }

    public l(boolean r8, String r10, String r11, String r12, String r13) {
        this.f8673h = new AtomicBoolean(false);
        this.f8667b = Environment.getExternalStorageState();
        this.f8671f = r10;
        this.f8668c = r8;
        this.f8669d = r11;
        this.f8670e = r12;
        this.f8674i = r13;
    }

    @Override // j5.m
    public final void b(String r8, String r10) {
        l(r8, r10);
    }

    @Override // j5.m
    public final String c(String r8) {
        return k(r8);
    }

    @Override // j5.e
    public final void d(String[] r8) {
        if (r8 == null) goto L6;
        l("sim_serial_number", TextUtils.join("\n", r8));
        return;
    }

    @Override // j5.e
    public final void e(List<String> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Iterator<String> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L11;
        String r11 = r10.next();
        if (this.f8672g == null) goto L10;
        this.f8672g.remove(r11);
    L10:
        l(r11, null);
        goto L6
    L11:
        super.e(r8);
    }

    @Override // j5.e
    public final String[] f() {
        String r8 = k("sim_serial_number");
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return null;
    L7:
        return r8.split("\n");
    }

    public final String i(byte[] r8) {
        if (f8665j == null) goto L10;
        if (Arrays.equals(r8, (byte[]) f8665j.first) == false) goto L10;
        Object r10 = f8665j.second;
    L8:
        return (String) r10;
    L10:
        if (f8666k != null) goto L12;
    L21:
        String r11 = t2.b.u(this.f8670e, r8);     // Catch: Throwable -> L16
    L18:
        if (r11 == null) goto L20;
        f8665j = new Pair(r8, r11);
    L20:
        return r11;
    L16:
        th = move-exception;
        th.printStackTrace();
        r11 = null;
        goto L18
    L12:
        if (Arrays.equals(r8, (byte[]) f8666k.second) == false) goto L21;
        r10 = f8666k.first;
        goto L8
    }

    public final byte[] j(String r8) {
        if (f8666k == null) goto L10;
        if (x0.e(r8, (String) f8666k.first) == false) goto L10;
        Object r10 = f8666k.second;
    L8:
        return (byte[]) r10;
    L10:
        if (f8665j != null) goto L12;
    L21:
        byte[] r11 = t2.b.w(r8, this.f8670e);     // Catch: Throwable -> L16
    L18:
        if (r11 == null) goto L20;
        f8666k = new Pair(r8, r11);
    L20:
        return r11;
    L16:
        th = move-exception;
        th.printStackTrace();
        r11 = null;
        goto L18
    L12:
        if (x0.e(r8, (String) f8665j.second) == false) goto L21;
        r10 = f8665j.first;
        goto L8
    }

    public final String k(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (this.f8672g == null) goto L9;
        String r8 = (String) this.f8672g.get(r10);
        int r11 = r.f13543a;
        return r8;
    L9:
        if ("mounted".equals(this.f8667b) == true) goto L94;
        return null;
    L94:
    L59:
        th = th;
        RandomAccessFile r12 = null;
        FileLock r13 = null;
    L90:
    L72:
        th = move-exception;
        if (this.f8672g != null) goto L76;
        this.f8672g = new ConcurrentHashMap();
    L76:
        if (r13 != null) goto L110;
    L78:
        if (r12 == null) goto L117;
        r12.close();     // Catch: Exception -> L89
        throw th;
    L118:
        throw th;
    L117:
        throw th;
    L110:
        r13.release();     // Catch: Exception -> L88
        goto L78
    L62:
        if ((th instanceof IOException) == true) goto L65;
        th.printStackTrace();     // Catch: Throwable -> L72
    L65:
        if (this.f8672g != null) goto L67;
        this.f8672g = new ConcurrentHashMap();
    L67:
        if (r13 != null) goto L98;
    L69:
        if (r12 != null) goto L112;
    L71:
        return null;
    L112:
        r12.close();     // Catch: Exception -> L86
        goto L71
    L98:
        r13.release();     // Catch: Exception -> L87
        goto L69
    L12:
        if (new File(this.f8671f).exists() == false) goto L14;
        File r14 = new File(this.f8671f + "/" + this.f8669d);     // Catch: Throwable -> L59
        r12 = new RandomAccessFile(r14, "rwd");     // Catch: Throwable -> L59
        r13 = r12.getChannel().lock();     // Catch: Throwable -> L57
    L49:
        th = th;
        goto L90
    L20:
        if (r14.isFile() == false) goto L52;
        byte[] r15 = new byte[2049];     // Catch: Throwable -> L49
        int r16 = r12.read(r15, 0, 2049);     // Catch: Throwable -> L49
        if (r16 <= 0) goto L52;
        if (r16 >= 2049) goto L52;
        String r17 = i(Arrays.copyOf(r15, r16));     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r17) == false) goto L27;
        ConcurrentHashMap r18 = new ConcurrentHashMap();     // Catch: Throwable -> L49
    L32:
        this.f8672g = r18;     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r10) == true) goto L35;
        String r19 = (String) this.f8672g.get(r10);     // Catch: Throwable -> L49
        int r20 = r.f13543a;     // Catch: Throwable -> L49
        if (this.f8672g != null) goto L45;
        this.f8672g = new ConcurrentHashMap();
    L45:
        if (r13 != null) goto L106;
    L100:
        r12.close();     // Catch: Exception -> L84
    L48:
        return r19;
    L106:
        r13.release();     // Catch: Exception -> L83
        goto L100
    L35:
        if (this.f8672g != null) goto L37;
        this.f8672g = new ConcurrentHashMap();
    L37:
        if (r13 != null) goto L102;
    L96:
        r12.close();     // Catch: Exception -> L82
    L40:
        return null;
    L102:
        r13.release();     // Catch: Exception -> L81
        goto L96
    L27:
        JSONObject r21 = new JSONObject(r17);     // Catch: Throwable -> L49
        Iterator<String> r22 = r21.keys();     // Catch: Throwable -> L49
        ConcurrentHashMap r23 = new ConcurrentHashMap();     // Catch: Throwable -> L49
    L29:
        if (r22.hasNext() == false) goto L31;
        String r24 = r22.next();     // Catch: Throwable -> L49
        r23.put(r24, (String) r21.get(r24));     // Catch: Throwable -> L49
        goto L29
    L31:
        r18 = r23;
    L52:
        if (this.f8672g != null) goto L54;
        this.f8672g = new ConcurrentHashMap();
    L54:
        if (r13 == null) goto L112;
        r13.release();     // Catch: Exception -> L85
    L57:
        th = th;
        r13 = null;
        goto L90
    L14:
        if (this.f8672g != null) goto L16;
        this.f8672g = new ConcurrentHashMap();
    L16:
        return null;
    }

    public final void l(String r8, String r10) {
        if (this.f8672g != null) goto L8;
        k(null);
        if (this.f8672g != null) goto L8;
        this.f8672g = new ConcurrentHashMap();
    L8:
        if (x0.e((String) this.f8672g.get(r8), r10) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r10) == false) goto L16;
        if (this.f8672g.containsKey(r8) == false) goto L16;
        this.f8672g.remove(r8);
    L19:
        if (this.f8668c == true) goto L21;
        return;
    L21:
        if (this.f8673h.compareAndSet(false, true) == false) goto L25;
        t.b(this.f8674i).postDelayed(new a(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        this.f8672g.put(r8, r10);
        goto L19
    }
}
