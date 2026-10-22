package r6;

import android.content.Context;
import he.i;
import j1.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r1.l;
import x4.b0;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile d f11534d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11536c;

    public d() {
        this.f11535b = new Object();
        this.f11536c = new LinkedHashMap();
    }

    public static a a(a r8) {
        a r10 = new a();
        r10.f11522a = r8.f11522a;
        r10.f11523b = r8.f11523b;
        r10.f11524c = r8.f11524c;
        r10.f11525d = r8.f11525d;
        r10.f11526e = r8.f11526e;
        r10.f11527f = r8.f11527f;
        r10.f11528g = r8.f11528g;
        r10.f11529h = r8.f11529h;
        r10.f11530i = r8.f11530i;
        r10.f11531j = r8.f11531j;
        return r10;
    }

    public static d b(Context r8) {
        if (f11534d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11534d != null) goto L9;
        f11534d = new d(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f11534d;
    }

    public final boolean c(l r8) {
        Object r10 = this.f11535b;
        monitor-enter(r10);
        boolean r11 = ((Map) this.f11536c).containsKey(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final t d(l r8) {
        i.f(r8, "id");
        Object r10 = this.f11535b;
        monitor-enter(r10);
        t r11 = (t) ((Map) this.f11536c).remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final List e(String r8) {
        i.f(r8, "workSpecId");
        Object r10 = this.f11535b;
        monitor-enter(r10);
        Map r11 = (Map) this.f11536c;     // Catch: Throwable -> L17
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L17
        Iterator r13 = r11.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L17
        if (i.a(((l) r14.getKey()).f11324a, r8) == false) goto L6;
        r12.put(r14.getKey(), r14.getValue());     // Catch: Throwable -> L17
        goto L6
    L10:
        Iterator r15 = r12.keySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r15.hasNext() == false) goto L14;
        l r16 = (l) r15.next();     // Catch: Throwable -> L17
        ((Map) this.f11536c).remove(r16);     // Catch: Throwable -> L17
        goto L12
    L14:
        List r17 = yd.i.n1(r12.values());     // Catch: Throwable -> L17
        monitor-exit(r10);
        return r17;
    L17:
        th = move-exception;
        throw th;
    }

    public final t f(l r8) {
        Object r10 = this.f11535b;
        monitor-enter(r10);
        Map r11 = (Map) this.f11536c;     // Catch: Throwable -> L10
        Object r12 = r11.get(r8);     // Catch: Throwable -> L10
        if (r12 != null) goto L7;
        r12 = new t(r8);     // Catch: Throwable -> L10
        r11.put(r8, r12);     // Catch: Throwable -> L10
    L7:
        t r13 = (t) r12;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return r13;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // x4.b0
    public final String get(String r8, Map r10) {
        return ((q4.a) this.f11535b).e(0, r8, (HashMap) r10, null, 0).f10145a;
    }

    @Override // x4.b0
    public final String post(String r8, byte[] r10, Map r11) {
        return ((q4.a) this.f11535b).e(1, r8, (HashMap) r11, r10, 0).f10145a;
    }

    @Override // x4.b0
    public final byte[] postStream(String r8, byte[] r10, Map r11) {
        return ((q4.a) this.f11535b).e(1, r8, (HashMap) r11, r10, 1).f10146b;
    }

    public d(Context r8) {
        this.f11536c = r8;
        this.f11535b = c.i(r8);
    }

    public d(r3.c r8) {
        this.f11536c = r8;
        this.f11535b = r8.f11397e;
    }

    public d(j0 r8) {
        this.f11536c = r8;
    }
}
