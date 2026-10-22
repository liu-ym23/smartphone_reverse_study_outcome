package n4a;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.AutoEndConversationTime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class h3<T> {
    public final PolarisFileWrapper a;
    public boolean b;
    public final Map<String, b> c;
    public final Handler d;
    public final String e;
    public boolean f;
    public final a g;

    public class a implements Runnable {
        public final /* synthetic */ h3 a;

        public a(h3 r1) {
            this.a = r1;
        }

        public final void a() {
            h3 r0 = this.a;
            if (r0.b == true) goto L5;
            return;
        L5:
            if (r0.f == true) goto L7;
        L34:
            h3 r1 = this.a;
            Handler r2 = r1.d;
            if (r2 == null) goto L51;
            r2.postDelayed(r1.g, AutoEndConversationTime.AFTER_60_SECONDS);
            return;
        L51:
            return;
        L7:
            if (r0.g() <= 0) goto L22;
            ((ConcurrentHashMap) r0.c).size();
            if (r0.c() <= 0) goto L17;
            long r3 = SystemClock.elapsedRealtime();
            Iterator r4 = ((ConcurrentHashMap) r0.c).entrySet().iterator();
        L12:
            if (r4.hasNext() == false) goto L17;
            Map.Entry r5 = (Map.Entry) r4.next();
            if ((r3 - ((b) ((ConcurrentHashMap) r0.c).get(r5.getKey())).c) <= r0.c()) goto L12;
            r4.remove();
        L17:
            if (((ConcurrentHashMap) r0.c).size() <= r0.g()) goto L22;
            ArrayList r6 = new ArrayList(((ConcurrentHashMap) r0.c).keySet());
            Collections.sort(r6, new g3(r0));
            int r7 = (int) r0.g();
        L20:
            if (r7 >= r6.size()) goto L22;
            ((ConcurrentHashMap) r0.c).remove(ListProtector.get(r6, r7));
            r7 = r7 + 1;
        L22:
            StringBuilder r8 = new StringBuilder();
            Iterator r9 = ((ConcurrentHashMap) r0.c).entrySet().iterator();
        L24:
            if (r9.hasNext() == false) goto L30;
            Map.Entry r10 = (Map.Entry) r9.next();
            r8.append(y4.d(t3.c((((String) r10.getKey()) + "," + ((b) r10.getValue()).a + "," + ((b) r10.getValue()).b + "," + ((b) r10.getValue()).c).getBytes("UTF-8"), r0.e)) + "\n");     // Catch: UnsupportedEncodingException -> L28
        L28:
            e = move-exception;
            e.printStackTrace();
            goto L24
        L30:
            String r11 = r8.toString();
            if (TextUtils.isEmpty(r11) == true) goto L33;
            j4.h(r0.a, r11);
        L33:
            this.a.f = false;
            goto L34
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
    }

    public static class b {
        public int a;
        public long b;
        public long c;

        public b(int r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    public abstract void a(T r1, long r2);

    public abstract long c();

    public abstract String d(T r1);

    public final void e(T r11, long r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (h(r11) < 0) goto L17;
        String r0 = d(r11);
        b r1 = (b) ((ConcurrentHashMap) this.c).get(r0);
        if (r1 != null) goto L10;
        a(r11, r12);
        Map<String, b> r2 = this.c;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(r0, new b(f(r11), h(r11), r12));
        this.f = true;
        return;
    L10:
        r1.c = r12;
        if (r1.a == f(r11)) goto L14;
        a(r11, r12);
        r1.a = f(r11);
        r1.b = h(r11);
        this.f = true;
        return;
    L14:
        a(r11, r1.b);
        return;
    }

    public abstract int f(T r1);

    public abstract long g();

    public abstract long h(T r1);

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(List<T> r12) {
        long r6 = SystemClock.elapsedRealtime();
        ArrayList r13 = (ArrayList) r12;
        Iterator r0 = r13.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        e(r0.next(), r6);
        goto L4
    L7:
        if (((ConcurrentHashMap) this.c).size() < r13.size()) goto L10;
        this.f = true;
    L10:
        if (((ConcurrentHashMap) this.c).size() <= 16384) goto L12;
    L13:
        ((ConcurrentHashMap) this.c).clear();
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L20;
        Object r1 = r14.next();
        Map<String, b> r8 = this.c;
        ConcurrentHashMap r9 = (ConcurrentHashMap) r8;
        r9.put(d(r1), new b(f(r1), h(r1), r6));
        goto L15
    L20:
        return;
    L12:
        if (g() <= 0) goto L13;
    }

    public h3(Context r10, String r11, Handler r12) {
        this.b = false;
        this.c = new ConcurrentHashMap();
        this.e = null;
        this.g = new a(this);
        if (r10 != null) goto L5;
        return;
    L5:
        this.d = r12;
        if (TextUtils.isEmpty(r11) == false) goto L8;
        r11 = "unknow";
    L8:
        this.e = j4.I(r10);
        this.a = new PolarisFileWrapper(r10.getFilesDir().getPath(), r11);     // Catch: Throwable -> L11
    L32:
        Iterator r13 = ((ArrayList) j4.g(this.a)).iterator();     // Catch: Throwable -> L29
    L14:
        if (r13.hasNext() == false) goto L43;
        String[] r14 = new String(t3.e(y4.e((String) r13.next()), this.e), "UTF-8").split(",");     // Catch: Throwable -> L23
    L18:
        if (r14.length < 4) goto L20;
        long r1 = CastLongProtector.parseLong(r14[3]);     // Catch: Throwable -> L23
    L21:
        long r7 = r1;
        Map<String, b> r15 = this.c;     // Catch: Throwable -> L23
        ConcurrentHashMap r16 = (ConcurrentHashMap) r15;     // Catch: Throwable -> L23
        r16.put(r14[0], new b(CastIntegerProtector.parseInt(r14[1]), CastLongProtector.parseLong(r14[2]), r7));     // Catch: Throwable -> L23
        goto L14
    L20:
        r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (this.a.exists() == false) goto L27;
        this.a.delete();     // Catch: Throwable -> L29
    L27:
        th.printStackTrace();     // Catch: Throwable -> L29
        goto L14
    L43:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L32
    }
}
