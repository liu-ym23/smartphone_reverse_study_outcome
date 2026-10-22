package qa;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class y2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f11231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f11233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f11234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f11237g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y2 f11238a;

        public a(y2 r8) {
            this.f11238a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y2 r11 = this.f11238a;
            if (r11.f11232b == true) goto L5;
            return;
        L5:
            if (r11.f11236f == false) goto L44;
            long r8 = r11.f();
            ConcurrentHashMap r10 = r11.f11233c;
            if (r8 <= 0) goto L32;
            r10.size();
            int r12 = ((a3) r11).f10205h;
            switch(r12) {
                case 0: goto L11;
                default: goto L12;
            };
        L11:
            int r13 = 120000;
        L14:
            if (r13 <= 0) goto L27;
            long r14 = SystemClock.elapsedRealtime();
            Iterator r15 = r10.entrySet().iterator();
        L17:
            if (r15.hasNext() == false) goto L27;
            long r16 = r14 - ((b) r10.get(((Map.Entry) r15.next()).getKey())).f11241c;
            switch(r12) {
                case 0: goto L21;
                default: goto L22;
            };
        L21:
            int r17 = 120000;
        L24:
            if (r16 <= r17) goto L17;
            r15.remove();
            goto L17
        L22:
            r17 = 60000;
        L27:
            if (r10.size() <= r11.f()) goto L32;
            ArrayList r18 = new ArrayList(r10.keySet());
            Collections.sort(r18, new x2(r11));
            int r19 = (int) r11.f();
        L30:
            if (r19 >= r18.size()) goto L32;
            r10.remove(r18.get(r19));
            r19 = r19 + 1;
            goto L30
        L12:
            r13 = 60000;
        L32:
            StringBuilder r20 = new StringBuilder();
            Iterator r21 = r10.entrySet().iterator();
        L34:
            if (r21.hasNext() == false) goto L40;
            Map.Entry r22 = (Map.Entry) r21.next();
            String r23 = ((String) r22.getKey()) + "," + ((b) r22.getValue()).f11239a + "," + ((b) r22.getValue()).f11240b + "," + ((b) r22.getValue()).f11241c;
            StringBuilder r24 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L38
            r24.append(l4.d(h3.b(r11.f11235e, r23.getBytes("UTF-8"))));     // Catch: UnsupportedEncodingException -> L38
            r24.append("\n");     // Catch: UnsupportedEncodingException -> L38
            r20.append(r24.toString());     // Catch: UnsupportedEncodingException -> L38
        L38:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L40:
            String r25 = r20.toString();
            if (TextUtils.isEmpty(r25) == true) goto L43;
            y3.g(r11.f11231a, r25);
        L43:
            r11.f11236f = false;
        L44:
            Handler r26 = r11.f11234d;
            if (r26 == null) goto L61;
            r26.postDelayed(r11.f11237g, 60000);
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11241c;

        public b(int r8, long r10, long r11) {
            this.f11239a = r8;
            this.f11240b = r10;
            this.f11241c = r11;
        }
    }

    public y2(Context r11, String r12, Handler r13) {
        this.f11232b = false;
        this.f11233c = new ConcurrentHashMap();
        this.f11235e = null;
        this.f11237g = new a(this);
        if (r11 != null) goto L5;
        return;
    L5:
        this.f11234d = r13;
        if (TextUtils.isEmpty(r12) == false) goto L8;
        r12 = "unknow";
    L8:
        this.f11235e = y3.E(r11);
        this.f11231a = new File(r11.getFilesDir().getPath(), r12);     // Catch: Throwable -> L11
    L13:
        File r14 = this.f11231a;
        Iterator r15 = y3.f(r14).iterator();     // Catch: Throwable -> L30
    L15:
        if (r15.hasNext() == false) goto L44;
        byte[] r16 = l4.e((String) r15.next());     // Catch: Throwable -> L24
        String[] r17 = new String(h3.e(this.f11235e, r16), "UTF-8").split(",");     // Catch: Throwable -> L24
    L19:
        if (r17.length < 4) goto L21;
        long r8 = Long.parseLong(r17[3]);     // Catch: Throwable -> L24
    L22:
        long r10 = r8;
        this.f11233c.put(r17[0], new b(Integer.parseInt(r17[1]), Long.parseLong(r17[2]), r10));     // Catch: Throwable -> L24
        goto L15
    L21:
        r8 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r14.exists() == false) goto L28;
        r14.delete();     // Catch: Throwable -> L30
    L28:
        th.printStackTrace();     // Catch: Throwable -> L30
        goto L15
    L44:
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    public abstract void a(long r8, Object r10);

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(ArrayList r12) {
        long r8 = SystemClock.elapsedRealtime();
        Iterator r10 = r12.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        d(r8, r10.next());
        goto L4
    L6:
        ConcurrentHashMap r11 = this.f11233c;
        if (r11.size() < r12.size()) goto L10;
        this.f11236f = true;
    L10:
        if (r11.size() <= 16384) goto L12;
    L13:
        r11.clear();
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L20;
        Object r14 = r13.next();
        r11.put(c(r14), new b(e(r14), g(r14), r8));
        goto L15
    L20:
        return;
    L12:
        if (f() <= 0) goto L13;
    }

    public abstract String c(T r8);

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(long r11, Object r13) {
        if (r13 != 0) goto L4;
        return;
    L4:
        if (g(r13) < 0) goto L17;
        String r8 = c(r13);
        ConcurrentHashMap r10 = this.f11233c;
        b r12 = (b) r10.get(r8);
        if (r12 != null) goto L11;
        a(r11, r13);
        r10.put(r8, new b(e(r13), g(r13), r11));
    L9:
        this.f11236f = true;
        return;
    L11:
        r12.f11241c = r11;
        if (r12.f11239a == e(r13)) goto L14;
        a(r11, r13);
        r12.f11239a = e(r13);
        r12.f11240b = g(r13);
        goto L9
    L14:
        a(r12.f11240b, r13);
        return;
    }

    public abstract int e(T r8);

    public abstract long f();

    public abstract long g(T r8);
}
