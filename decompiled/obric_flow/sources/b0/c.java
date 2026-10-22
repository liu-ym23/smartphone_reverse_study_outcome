package b0;

import ai.p;
import android.os.Handler;
import android.util.Log;
import com.bytedance.ies.bullet.core.j;
import com.google.common.reflect.w;
import com.lynx.tasm.behavior.ui.list.UIList;
import en.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import sj.k;

/* JADX INFO: loaded from: classes.dex */
public final class c implements a, en.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f809c;
    public Object d;
    public Object e;

    public c() {
        this.f807a = -1;
    }

    @Override // en.c
    public void a() {
        b(false);
    }

    public void b(boolean r10) {
        long r5 = System.currentTimeMillis();
        if (r10 == false) goto L5;
    L7:
        this.f807a = r5;
        Handler r11 = (Handler) this.f808b;
        com.lynx.tasm.ui.image.h r12 = (com.lynx.tasm.ui.image.h) this.f809c;
        r11.removeCallbacks(r12);
        System.nanoTime();
        HashSet r13 = new HashSet();
        ArrayList r14 = new ArrayList();
        l r15 = (l) this.d;
        if (r15.getChildCount() > 0) goto L21;
        HashSet r16 = (HashSet) this.e;
        r16.removeAll(r13);
        Iterator r17 = r16.iterator();
        if (r17.hasNext() == true) goto L19;
        r16.clear();
        r16.addAll(r13);
        Iterator r18 = r14.iterator();
        if (r18.hasNext() == true) goto L17;
        int r19 = UIList.S;
        if (r10 == true) goto L23;
        r11.postDelayed(r12, 200);
        return;
    L23:
        return;
    L17:
        qo.a.i(r18.next());
        int r20 = UIList.S;
        throw null;
    L19:
        qo.a.i(r17.next());
        int r21 = UIList.S;
        throw null;
    L21:
        r15.getChildViewHolder(r15.getChildAt(0)).getClass();
        throw new ClassCastException();
    L5:
        if ((r5 - this.f807a) >= 200) goto L7;
    }

    @Override // b0.a
    public void c(z.c r10, w r11) {
        String r5 = ((h) this.f808b).a(r10);
        p r12 = (p) this.d;
        monitor-enter(r12);
        b r13 = (b) ((HashMap) r12.f287b).get(r5);     // Catch: Throwable -> L55
        if (r13 != null) goto L17;
        r6.a r14 = (r6.a) r12.f288c;     // Catch: Throwable -> L55
        ArrayDeque r15 = (ArrayDeque) r14.f21695a;     // Catch: Throwable -> L55
        monitor-enter(r15);     // Catch: Throwable -> L55
        r13 = (b) ((ArrayDeque) r14.f21695a).poll();     // Catch: Throwable -> L14
        monitor-exit(r15);     // Catch: Throwable -> L14
        if (r13 != null) goto L12;
        r13 = new b();     // Catch: Throwable -> L55
    L12:
        ((HashMap) r12.f287b).put(r5, r13);     // Catch: Throwable -> L55
        goto L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L17:
        r13.f806b++;     // Catch: Throwable -> L55
        monitor-exit(r12);     // Catch: Throwable -> L55
        r13.f805a.lock();
    L24:
        th = move-exception;
        ((p) this.d).m(r5);
        throw th;
    L21:
        if (Log.isLoggable("DiskLruCacheWrapper", 2) == false) goto L66;
        Log.v("DiskLruCacheWrapper", "Put: Obtained: " + r5 + " for for Key: " + r10);     // Catch: Throwable -> L24
    L66:
        w.c r16 = d();     // Catch: Throwable -> L24 IOException -> L44
        if (r16.m(r5) == null) goto L30;
        ((p) this.d).m(r5);
        return;
    L30:
        j r17 = r16.f(r5);     // Catch: Throwable -> L24 IOException -> L44
        if (r17 == null) goto L47;
        File r18 = r17.b();     // Catch: Throwable -> L39
        if (((z.a) r11.f9377c).g(r11.f9376b, r18, (z.f) r11.d) == false) goto L36;
        w.c.b((w.c) r17.d, r17, true);     // Catch: Throwable -> L39
        r17.f5319a = true;     // Catch: Throwable -> L39
    L36:
        if (r17.f5319a == false) goto L68;
    L51:
        ((p) this.d).m(r5);
        return;
    L68:
        r17.a();     // Catch: Throwable -> L24 IOException -> L58
    L39:
        th = move-exception;
        if (r17.f5319a == false) goto L60;
    L43:
        throw th;     // Catch: Throwable -> L24 IOException -> L44
    L60:
        r17.a();     // Catch: Throwable -> L24 IOException -> L59
        goto L43
    L47:
        throw new IllegalStateException("Had two simultaneous puts for: ".concat(r5));     // Catch: Throwable -> L24 IOException -> L44
    L44:
        e = move-exception;
        if (Log.isLoggable("DiskLruCacheWrapper", 5) == false) goto L51;
        Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);     // Catch: Throwable -> L24
    L55:
        th = move-exception;
        throw th;
    }

    public synchronized w.c d() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (((w.c) this.e) != null) goto L8;
        File r5 = (File) this.f809c;     // Catch: Throwable -> L6
        this.e = w.c.p(this.f807a, r5);     // Catch: Throwable -> L6
    L8:
        w.c r10 = (w.c) this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    @Override // b0.a
    public File h(z.c r5) {
        String r10 = ((h) this.f808b).a(r5);
        if (Log.isLoggable("DiskLruCacheWrapper", 2) == false) goto L15;
        Log.v("DiskLruCacheWrapper", "Get: Obtained: " + r10 + " for for Key: " + r5);
    L15:
        k r11 = d().m(r10);     // Catch: IOException -> L10
        if (r11 == null) goto L17;
        return ((File[]) r11.f21937a)[0];
    L17:
        return null;
    L10:
        e = move-exception;
        if (Log.isLoggable("DiskLruCacheWrapper", 5) == false) goto L18;
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
        return null;
    L18:
        return null;
    }
}
