package com.larus.avlink.plugins;

import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.DoraImageManager;
import com.larus.voicecall.api.bean.DoraTraceParam;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a5 {
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public String F;
    public final long G;
    public long H;
    public long I;
    public long J;
    public Long K;
    public Long L;
    public Long M;
    public Long N;
    public Long O;
    public Long P;
    public DoraTraceParam.b Q;
    public Long R;
    public Long S;
    public Long T;
    public Long U;
    public Long V;
    public Long W;
    public String X;
    public int Y;
    public long Z;
    public final boolean a;
    public long a0;
    public final boolean b;
    public int b0;
    public final int c;
    public int c0;
    public final boolean d;
    public final int e;
    public String f;
    public boolean g;
    public String h;
    public Long i;
    public Long j;
    public Long k;
    public Long l;
    public Long m;
    public boolean n;
    public Long o;
    public Long p;
    public Long q;
    public int r;
    public Long s;
    public String t;
    public String u;
    public String v;
    public Boolean w;
    public Long x;
    public Long y;
    public Long z;

    public final long a() {
        Long r0 = this.i;
        if (r0 == null) goto L8;
        r0.longValue();
        Long r1 = this.k;
        if (r1 == null) goto L8;
        r1.longValue();
        Long r2 = this.i;
        Intrinsics.checkNotNull(r2);
        long r3 = r2.longValue();
        Long r4 = this.k;
        Intrinsics.checkNotNull(r4);
        return r3 - r4.longValue();
    L8:
        return 0;
    }

    public final com.larus.avlink.model.a b() {
        Integer r1 = null;
        if (this.d == false) goto L6;
        return null;
    L6:
        if (v88.a.a(Integer.valueOf(this.e)) == false) goto L40;
        Map<String, com.larus.avlink.model.a> r0 = DoraImageManager.a;
        Integer r2 = Integer.valueOf(this.e);
        if (v88.a.c(r2) == false) goto L11;
    L13:
        int r3 = 2;
    L14:
        Map<String, com.larus.avlink.model.a> r4 = DoraImageManager.a;
        monitor-enter(r4);
    L37:
        th = move-exception;
        throw th;
    L17:
        if (r4.isEmpty() == false) goto L19;
        com.larus.avlink.model.a r5 = null;
    L35:
        monitor-exit(r4);
    L41:
        StringBuilder r6 = new StringBuilder("imageid: ");
        if (r5 == null) goto L44;
        r1 = r5.a;
    L44:
        r6.append(r1);
        com.larus.avlink.n1.d("QueryTraceModel", r6.toString());
        return r5;
    L19:
        Iterator<T> r7 = r4.values().iterator();     // Catch: Throwable -> L37
        Object r8 = null;
    L21:
        if (r7.hasNext() == false) goto L34;
        Object r9 = r7.next();     // Catch: Throwable -> L37
        com.larus.avlink.model.a r10 = (com.larus.avlink.model.a) r9;     // Catch: Throwable -> L37
        boolean r11 = false;
        if (r10.m != r3) goto L32;
        z98.d r12 = r10.M.get(DoraImageEvent.IMAGE_UPLOAD_FINISH);     // Catch: Throwable -> L37
        if (r12 != null) goto L27;
    L29:
        boolean r13 = false;
    L30:
        if (r13 == false) goto L32;
        r11 = true;
        goto L32
    L27:
        if (r12.a != true) goto L29;
        r13 = true;
    L32:
        if (r11 == false) goto L21;
        r8 = r9;
        goto L21
    L34:
        r5 = (com.larus.avlink.model.a) r8;     // Catch: Throwable -> L37
        goto L35
    L11:
        if (v88.a.b(r2) == false) goto L13;
        r3 = 17;
        goto L14
    L40:
        Map<String, com.larus.avlink.model.a> r14 = DoraImageManager.a;
        r5 = DoraImageManager.b(this.f);
        goto L41
    }

    public a5(boolean r17, boolean r18, int r19, boolean r20, int r21) {
        Intrinsics.checkNotNullParameter("", "messageId");
        this.a = r17;
        this.b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = "";
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0;
        this.s = 0L;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0L;
        this.z = 0L;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = 0;
        this.Z = -1;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
    }
}
