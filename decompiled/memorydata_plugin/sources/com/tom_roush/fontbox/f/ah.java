package com.tom_roush.fontbox.f;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ah implements com.tom_roush.fontbox.b, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<String, af> f15978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f15979b;
    private int c;
    private int d;
    private final ad e;
    private Map<String, Integer> f;
    private final List<String> g;

    ah(ad r2) {
        this.c = -1;
        this.d = -1;
        this.f15978a = new HashMap();
        this.g = new ArrayList();
        this.e = r2;
    }

    private synchronized void a() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f == null) goto L6;
    L14:
        monitor-exit(this);
        return;
    L6:
        if (j() == null) goto L14;
        String[] r0 = j().a();     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        this.f = new HashMap(r0.length);     // Catch: Throwable -> L16
        int r1 = 0;
    L11:
        if (r1 >= r0.length) goto L14;
        this.f.put(r0[r1], Integer.valueOf(r1));     // Catch: Throwable -> L16
        r1 = r1 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        this.f = new HashMap();     // Catch: Throwable -> L16
        goto L14
    }

    private d b(boolean r4) {
        e r0 = q();
        if (r0 != null) goto L9;
        if (r4 == true) goto L8;
        return null;
    L8:
        throw new IOException("The TrueType font " + b() + " does not contain a 'cmap' table");
    L9:
        d r3 = r0.a(0, 4);
        if (r3 != null) goto L12;
        r3 = r0.a(3, 10);
    L12:
        if (r3 != null) goto L14;
        r3 = r0.a(0, 3);
    L14:
        if (r3 != null) goto L16;
        r3 = r0.a(3, 1);
    L16:
        if (r3 != null) goto L18;
        r3 = r0.a(3, 0);
    L18:
        if (r3 != null) goto L25;
        if (r4 == true) goto L24;
        if (r0.a().length > 0) goto L27;
        return r3;
    L27:
        return r0.a()[0];
    L24:
        throw new IOException("The TrueType font does not contain a Unicode cmap");
    L25:
        return r3;
    }

    private int e(String r6) {
        if (r6.startsWith("uni") == true) goto L5;
    L20:
        return -1;
    L5:
        if (r6.length() != 7) goto L20;
        int r5 = r6.length();
        StringBuilder r1 = new StringBuilder();
        int r2 = 3;
    L7:
        int r3 = r2 + 4;
        if (r3 > r5) goto L15;
        int r4 = Integer.parseInt(r6.substring(r2, r3), 16);     // Catch: NumberFormatException -> L21
        if (r4 > 55295) goto L12;
    L13:
        r1.append((char) r4);     // Catch: NumberFormatException -> L21
    L14:
        r2 = r3;
        goto L7
    L12:
        if (r4 < 57344) goto L14;
    L15:
        String r7 = r1.toString();     // Catch: NumberFormatException -> L21
        if (r7.length() != 0) goto L18;
        return -1;
    L18:
        return r7.codePointAt(0);
    }

    @Override // com.tom_roush.fontbox.b
    public float a(String r1) {
        return a(d(r1));
    }

    public int a(int r1) {
        m r0 = o();
        if (r0 != null) goto L5;
        return ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    L5:
        return r0.a(r1);
    }

    public c a(boolean r3) {
        d r4 = b(r3);
        if (this.g.isEmpty() == true) goto L8;
        i r0 = s();
        if (r0 == null) goto L8;
        return new ab(r4, r0, Collections.unmodifiableList(this.g));
    L8:
        return r4;
    }

    void a(float r1) {
        this.f15979b = r1;
    }

    void a(af r2) {
        this.f15978a.put(r2.j(), r2);
    }

    @Override // com.tom_roush.fontbox.b
    public String b() {
        t r0 = i();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.c();
    }

    @Override // com.tom_roush.fontbox.b
    public boolean b(String r1) {
        if (d(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized byte[] b(af r6) {
        monitor-enter(this);
        long r0 = this.e.f();     // Catch: Throwable -> L6
        this.e.a(r6.i());     // Catch: Throwable -> L6
        byte[] r7 = this.e.d((int) r6.h());     // Catch: Throwable -> L6
        this.e.a(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized af c(String r3) {
        monitor-enter(this);
        af r4 = (af) ZeusTransformUtils.preCheckCast(this.f15978a.get(r3), af.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r4 != null) goto L6;
    L8:
        monitor-exit(this);
        return r4;
    L6:
        if (r4.k() == true) goto L8;
        c(r4);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.tom_roush.fontbox.b
    public com.tom_roush.fontbox.g.a c() {
        k r0 = m();
        short r1 = r0.e();
        short r2 = r0.d();
        short r3 = r0.g();
        short r4 = r0.f();
        float r5 = 1000.0f / v();
        return new com.tom_roush.fontbox.g.a(r1 * r5, r3 * r5, r2 * r5, r4 * r5);
    }

    void c(af r7) {
        ad r0 = this.e;
        monitor-enter(r0);
        long r1 = this.e.f();     // Catch: Throwable -> L7
        this.e.a(r7.i());     // Catch: Throwable -> L7
        r7.a(this, this.e);     // Catch: Throwable -> L7
        this.e.a(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e.close();
    }

    public int d(String r4) {
        a();
        Map<String, Integer> r0 = this.f;
        if (r0 == null) goto L12;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L12;
        if (r1.intValue() <= 0) goto L12;
        if (r1.intValue() >= l().a()) goto L12;
        return r1.intValue();
    L12:
        int r5 = e(r4);
        if (r5 > (-1)) goto L15;
        return 0;
    L15:
        return a(false).a(r5);
    }

    @Override // com.tom_roush.fontbox.b
    public List<Number> d() {
        float r0 = (1000.0f / v()) * 0.001f;
        return Arrays.asList(new Number[]{Float.valueOf(r0), 0, 0, Float.valueOf(r0), 0, 0});
    }

    public j e() {
        return (j) ZeusTransformUtils.preCheckCast(c("glyf"), j.class, "com.obric.memorydata.plugin");
    }

    public void finalize() {
        super.finalize();
        close();
    }

    public Collection<af> g() {
        return this.f15978a.values();
    }

    public Map<String, af> h() {
        return this.f15978a;
    }

    public t i() {
        return (t) ZeusTransformUtils.preCheckCast(c(ActivityLifecycle.NAME), t.class, "com.obric.memorydata.plugin");
    }

    public z j() {
        return (z) ZeusTransformUtils.preCheckCast(c(CozeCloudExt.API_KEY_HTTP_POST_METHOD), z.class, "com.obric.memorydata.plugin");
    }

    public u k() {
        return (u) ZeusTransformUtils.preCheckCast(c("OS/2"), u.class, "com.obric.memorydata.plugin");
    }

    public q l() {
        return (q) ZeusTransformUtils.preCheckCast(c("maxp"), q.class, "com.obric.memorydata.plugin");
    }

    public k m() {
        return (k) ZeusTransformUtils.preCheckCast(c("head"), k.class, "com.obric.memorydata.plugin");
    }

    public l n() {
        return (l) ZeusTransformUtils.preCheckCast(c("hhea"), l.class, "com.obric.memorydata.plugin");
    }

    public m o() {
        return (m) ZeusTransformUtils.preCheckCast(c("hmtx"), m.class, "com.obric.memorydata.plugin");
    }

    public n p() {
        return (n) ZeusTransformUtils.preCheckCast(c("loca"), n.class, "com.obric.memorydata.plugin");
    }

    public e q() {
        return (e) ZeusTransformUtils.preCheckCast(c("cmap"), e.class, "com.obric.memorydata.plugin");
    }

    public ai r() {
        return (ai) ZeusTransformUtils.preCheckCast(c("vhea"), ai.class, "com.obric.memorydata.plugin");
    }

    public i s() {
        return (i) ZeusTransformUtils.preCheckCast(c("GSUB"), i.class, "com.obric.memorydata.plugin");
    }

    public long t() {
        return this.e.g();
    }

    public String toString() {
        t r2 = i();     // Catch: IOException -> L8
        if (r2 == null) goto L6;
        return r2.c();
    L6:
        return "(null)";
    L8:
        e = move-exception;
        return "(null - " + e.getMessage() + ")";
    }

    public int u() {
        if (this.c != (-1)) goto L10;
        q r0 = l();
        if (r0 == null) goto L7;
        int r1 = r0.a();
    L8:
        this.c = r1;
        goto L10
    L7:
        r1 = 0;
    L10:
        return this.c;
    }

    public int v() {
        if (this.d != (-1)) goto L10;
        k r0 = m();
        if (r0 == null) goto L7;
        int r1 = r0.c();
    L8:
        this.d = r1;
        goto L10
    L7:
        r1 = 0;
    L10:
        return this.d;
    }
}
