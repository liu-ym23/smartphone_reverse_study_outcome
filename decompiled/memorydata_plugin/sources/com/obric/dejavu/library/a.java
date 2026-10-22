package com.obric.dejavu.library;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000fHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006/"}, d2 = {"Lcom/obric/dejavu/library/DbIndexConfig;", "", "strategy", "Lcom/obric/dejavu/library/IndexUpgradeStrategy;", "metricType", "Lcom/obric/dejavu/library/IndexMetricType;", "searchProbe", "", "downgradeLimit", "upgradeLimit", "ivfNodeMin", "ivfNodeMax", "bspNodeSize", "pqSubDim", "pqTrainInsert", "", "(Lcom/obric/dejavu/library/IndexUpgradeStrategy;Lcom/obric/dejavu/library/IndexMetricType;IIIIIIIZ)V", "getBspNodeSize", "()I", "getDowngradeLimit", "getIvfNodeMax", "getIvfNodeMin", "getMetricType", "()Lcom/obric/dejavu/library/IndexMetricType;", "getPqSubDim", "getPqTrainInsert", "()Z", "getSearchProbe", "getStrategy", "()Lcom/obric/dejavu/library/IndexUpgradeStrategy;", "getUpgradeLimit", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IndexUpgradeStrategy f7872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IndexMetricType f7873b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final boolean j;

    public a() {
        this(null, null, 0, 0, 0, 0, 0, 0, 0, false, 1023, null);
    }

    public a(IndexUpgradeStrategy r2, IndexMetricType r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "metricType");
        this.f7872a = r2;
        this.f7873b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public /* synthetic */ a(IndexUpgradeStrategy r12, IndexMetricType r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        IndexUpgradeStrategy r1 = IndexUpgradeStrategy.Insert;
    L7:
        if ((r22 & 2) == 0) goto L9;
        IndexMetricType r2 = IndexMetricType.L2;
    L11:
        if ((r22 & 4) == 0) goto L13;
        int r3 = 3;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r4 = 4096;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r5 = 8192;
    L23:
        if ((r22 & 32) == 0) goto L25;
        int r6 = 64;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r7 = 128;
    L31:
        if ((r22 & 128) == 0) goto L33;
        int r8 = 2048;
    L34:
        boolean r10 = false;
        if ((r22 & 256) == 0) goto L37;
        int r9 = 0;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r10 = r21;
    L42:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L37:
        r9 = r20;
        goto L39
    L33:
        r8 = r19;
        goto L34
    L29:
        r7 = r18;
        goto L31
    L25:
        r6 = r17;
        goto L27
    L21:
        r5 = r16;
        goto L23
    L17:
        r4 = r15;
        goto L19
    L13:
        r3 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final IndexUpgradeStrategy a() {
        return this.f7872a;
    }

    public final IndexMetricType b() {
        return this.f7873b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f7872a == r6.f7872a) goto L12;
        return false;
    L12:
        if (this.f7873b == r6.f7873b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((((((((((((((((this.f7872a.hashCode() * 31) + this.f7873b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31;
        boolean r2 = this.j;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public final int i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public String toString() {
        return "DbIndexConfig(strategy=" + this.f7872a + ", metricType=" + this.f7873b + ", searchProbe=" + this.c + ", downgradeLimit=" + this.d + ", upgradeLimit=" + this.e + ", ivfNodeMin=" + this.f + ", ivfNodeMax=" + this.g + ", bspNodeSize=" + this.h + ", pqSubDim=" + this.i + ", pqTrainInsert=" + this.j + ')';
    }
}
