package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001IB\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020HH\u0016R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016¨\u0006J"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "", "fps", "", "duration", "", "startX", "", "startY", "endX", "endY", "distantX", "distantY", "dropRate", "frameCount", "drop3", "drop7", "drop25", "(DJIIIIIIDIIII)V", "getDistantX", "()I", "setDistantX", "(I)V", "getDistantY", "setDistantY", "getDrop25", "setDrop25", "getDrop3", "setDrop3", "getDrop7", "setDrop7", "getDropRate", "()D", "setDropRate", "(D)V", "getDuration", "()J", "setDuration", "(J)V", "getEndX", "setEndX", "getEndY", "setEndY", "getFps", "setFps", "getFrameCount", "setFrameCount", "getStartX", "setStartX", "getStartY", "setStartY", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "recycle", "", "toString", "", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8093a = null;
    private static final Pools.SynchronizedPool<d> o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f8094b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private double j;
    private int k;
    private int l;
    private int m;
    private int n;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean$Companion;", "", "()V", "FPS_BEAN_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "obtain", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final d a() {
            d r0 = (d) ZeusTransformUtils.preCheckCast(d.g().acquire(), d.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new d(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
        }
    }

    static {
        f8093a = new a(null);
        o = new Pools.SynchronizedPool(5);
    }

    public d() {
        this(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
    }

    public d(double r4, long r6, int r8, int r9, int r10, int r11, int r12, int r13, double r14, int r16, int r17, int r18, int r19) {
        this.f8094b = r4;
        this.c = r6;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
    }

    public /* synthetic */ d(double r17, long r19, int r21, int r22, int r23, int r24, int r25, int r26, double r27, int r29, int r30, int r31, int r32, int r33, DefaultConstructorMarker r34) {
        double r2 = 0.0d;
        if ((r33 & 1) == 0) goto L5;
        double r4 = 0.0d;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r1 = 0;
    L15:
        if ((r33 & 8) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r10 = 0;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r11 = 0;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r12 = 0;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r13 = 0;
    L35:
        if ((r33 & 256) != 0) goto L39;
        r2 = r27;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r14 = 0;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        int r15 = 0;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        int r8 = 0;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r0 = 0;
    L54:
        this(r4, r6, r1, r9, r10, r11, r12, r13, r2, r14, r15, r8, r0);
        return;
    L53:
        r0 = r32;
        goto L54
    L49:
        r8 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L43
    L33:
        r13 = r26;
        goto L35
    L29:
        r12 = r25;
        goto L31
    L25:
        r11 = r24;
        goto L27
    L21:
        r10 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r1 = r21;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public static final /* synthetic */ Pools.SynchronizedPool g() {
        return o;
    }

    public final double a() {
        return this.f8094b;
    }

    public final void a(double r1) {
        this.f8094b = r1;
    }

    public final void a(int r1) {
        this.d = r1;
    }

    public final void a(long r1) {
        this.c = r1;
    }

    public final double b() {
        return this.j;
    }

    public final void b(double r1) {
        this.j = r1;
    }

    public final void b(int r1) {
        this.e = r1;
    }

    public final int c() {
        return this.l;
    }

    public final void c(int r1) {
        this.f = r1;
    }

    public final int d() {
        return this.m;
    }

    public final void d(int r1) {
        this.g = r1;
    }

    public final int e() {
        return this.n;
    }

    public final void e(int r1) {
        this.h = r1;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Double.valueOf(this.f8094b), Double.valueOf(r10.f8094b)) == true) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(Double.valueOf(this.j), Double.valueOf(r10.j)) == true) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (this.l == r10.l) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L45;
        return false;
    L45:
        if (this.n == r10.n) goto L47;
        return false;
    L47:
        return true;
    }

    public final void f() {
        this.f8094b = 0.0d;
        this.j = 0.0d;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.k = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        o.release(this);
    }

    public final void f(int r1) {
        this.i = r1;
    }

    public final void g(int r1) {
        this.k = r1;
    }

    public final void h(int r1) {
        this.l = r1;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Double.hashCode(this.f8094b) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Double.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n);
    }

    public final void i(int r1) {
        this.m = r1;
    }

    public final void j(int r1) {
        this.n = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("FpsBean(fps=").append(this.f8094b).append(", duration=").append(this.c).append(", startX=").append(this.d).append(", startY=").append(this.e).append(", endX=").append(this.f).append(", endY=").append(this.g).append(", distantX=").append(this.h).append(", distantY=").append(this.i).append(", dropRate=").append(this.j).append(", frameCount=").append(this.k).append(", drop3=").append(this.l).append(", drop7=");
        r0.append(this.m).append(", drop25=").append(this.n).append(')');
        return r0.toString();
    }
}
