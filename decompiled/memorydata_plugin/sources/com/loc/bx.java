package com.loc;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dv f5383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private dv f5384b;
    private da c;
    private a d;
    private final List<dv> e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f5385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5386b;
        public dv c;
        public dv d;
        public dv e;
        public List<dv> f;
        public List<dv> g;

        public a() {
            this.f = new ArrayList();
            this.g = new ArrayList();
        }

        public static boolean a(dv r4, dv r5) {
            if (r4 == null) goto L48;
            if (r5 == null) goto L48;
            if (ZeusTransformUtils.instanceOf(r4, dx.class) == false) goto L17;
            if (ZeusTransformUtils.instanceOf(r5, dx.class) == false) goto L17;
            dx r6 = (dx) ZeusTransformUtils.preCheckCast(r4, dx.class, "com.obric.memorydata.plugin");
            dx r7 = (dx) ZeusTransformUtils.preCheckCast(r5, dx.class, "com.obric.memorydata.plugin");
            if (r6.j == r7.j) goto L13;
        L15:
            return false;
        L13:
            if (r6.k != r7.k) goto L15;
            return true;
        L17:
            if (ZeusTransformUtils.instanceOf(r4, dw.class) == false) goto L29;
            if (ZeusTransformUtils.instanceOf(r5, dw.class) == false) goto L29;
            dw r8 = (dw) ZeusTransformUtils.preCheckCast(r4, dw.class, "com.obric.memorydata.plugin");
            dw r9 = (dw) ZeusTransformUtils.preCheckCast(r5, dw.class, "com.obric.memorydata.plugin");
            if (r8.l == r9.l) goto L23;
        L27:
            return false;
        L23:
            if (r8.k != r9.k) goto L27;
            if (r8.j != r9.j) goto L27;
            return true;
        L29:
            if (ZeusTransformUtils.instanceOf(r4, dy.class) == false) goto L39;
            if (ZeusTransformUtils.instanceOf(r5, dy.class) == false) goto L39;
            dy r10 = (dy) ZeusTransformUtils.preCheckCast(r4, dy.class, "com.obric.memorydata.plugin");
            dy r11 = (dy) ZeusTransformUtils.preCheckCast(r5, dy.class, "com.obric.memorydata.plugin");
            if (r10.j == r11.j) goto L35;
        L37:
            return false;
        L35:
            if (r10.k != r11.k) goto L37;
            return true;
        L39:
            if (ZeusTransformUtils.instanceOf(r4, dz.class) == true) goto L41;
        L47:
            return false;
        L41:
            if (ZeusTransformUtils.instanceOf(r5, dz.class) == false) goto L47;
            dz r12 = (dz) ZeusTransformUtils.preCheckCast(r4, dz.class, "com.obric.memorydata.plugin");
            dz r13 = (dz) ZeusTransformUtils.preCheckCast(r5, dz.class, "com.obric.memorydata.plugin");
            if (r12.j != r13.j) goto L47;
            if (r12.k != r13.k) goto L47;
            return true;
        L48:
            if (r4 != null) goto L50;
            boolean r14 = true;
        L51:
            if (r5 != null) goto L53;
            boolean r15 = true;
        L54:
            if (r14 != r15) goto L56;
            return true;
        L56:
            return false;
        L53:
            r15 = false;
            goto L54
        L50:
            r14 = false;
            goto L51
        }

        public final void a() {
            this.f5385a = 0;
            this.f5386b = "";
            this.c = null;
            this.d = null;
            this.e = null;
            this.f.clear();
            this.g.clear();
        }

        public final void a(byte r3, String r4, List<dv> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            a();
            this.f5385a = r3;
            this.f5386b = r4;
            if (r6 == null) goto L17;
            this.f.addAll(r6);
            Iterator<dv> r7 = this.f.iterator();
        L6:
            if (r7.hasNext() == false) goto L17;
            dv r8 = (dv) ZeusTransformUtils.preCheckCast(r7.next(), dv.class, "com.obric.memorydata.plugin");
            if (r8.i == true) goto L13;
            if (r8.h == false) goto L13;
            this.d = r8;
        L13:
            if (r8.i == false) goto L6;
            if (r8.h == false) goto L6;
            this.e = r8;
        L17:
            dv r9 = this.d;
            if (r9 != null) goto L20;
            r9 = this.e;
        L20:
            this.c = r9;
        }

        public final String toString() {
            return "CellInfo{radio=" + this.f5385a + ", operator='" + this.f5386b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }
    }

    public bx() {
        this.d = new a();
        this.e = new ArrayList(3);
    }

    private void a(a r5) {
        List<dv> r0 = this.e;
        monitor-enter(r0);
        Iterator<dv> r6 = r5.f.iterator();     // Catch: Throwable -> L15
    L6:
        if (r6.hasNext() == false) goto L12;
        dv r1 = (dv) ZeusTransformUtils.preCheckCast(r6.next(), dv.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L6;
        if (r1.h == false) goto L6;
        dv r2 = r1.a();     // Catch: Throwable -> L15
        r2.e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        a(r2);     // Catch: Throwable -> L15
        goto L6
    L12:
        this.d.g.clear();     // Catch: Throwable -> L15
        this.d.g.addAll(this.e);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void a(dv r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r0 = this.e.size();
        if (r0 != 0) goto L8;
    L6:
        this.e.add(r10);
        return;
    L8:
        long r1 = Long.MAX_VALUE;
        int r3 = 0;
        int r4 = -1;
        int r5 = -1;
    L9:
        if (r3 >= r0) goto L19;
        dv r6 = (dv) ZeusTransformUtils.preCheckCast(this.e.get(r3), dv.class, "com.obric.memorydata.plugin");
        if (r10.equals(r6) == true) goto L13;
        r1 = Math.min(r1, r6.e);
        if (r1 != r6.e) goto L18;
        r5 = r3;
    L18:
        r3 = r3 + 1;
        goto L9
    L13:
        if (r10.c == r6.c) goto L20;
        r6.e = r10.c;
        r6.c = r10.c;
    L20:
        if (r4 >= 0) goto L22;
        return;
    L22:
        if (r0 < 3) goto L6;
        if (r10.e <= r1) goto L34;
        if (r4 >= r0) goto L35;
        this.e.remove(r4);
        this.e.add(r10);
        return;
    L35:
        return;
    L34:
        return;
    L19:
        r4 = r5;
        goto L20
    }

    private boolean a(da r3) {
        if (r3.g <= 10.0f) goto L6;
        float r0 = 2000.0f;
    L10:
        if (r3.a(this.c) <= r0) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.g <= 2.0f) goto L8;
        r0 = 500.0f;
        goto L10
    L8:
        r0 = 100.0f;
        goto L10
    }

    final a a(da r3, boolean r4, byte r5, String r6, List<dv> r7) {
        List<dv> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L6;
        this.d.a();
        return null;
    L6:
        this.d.a(r5, r6, r8);
        if (this.d.c != null) goto L10;
        return null;
    L10:
        if (this.c != null) goto L12;
    L19:
        boolean r9 = true;
    L20:
        if (r9 == false) goto L23;
        this.f5383a = this.d.d;
        this.f5384b = this.d.e;
        this.c = r3;
        cu.a(this.d.f);
        a(this.d);
        return this.d;
    L23:
        return null;
    L12:
        if (a(r3) == true) goto L19;
        if (a.a(this.d.d, this.f5383a) == false) goto L19;
        if (a.a(this.d.e, this.f5384b) == false) goto L19;
        r9 = false;
        goto L20
    }
}
