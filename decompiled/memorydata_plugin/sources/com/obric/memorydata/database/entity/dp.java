package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\u008f\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0006HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u0016\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006="}, d2 = {"Lcom/obric/memorydata/database/entity/MobileCellularEntity;", "", "dataId", "", "dataVersion", "timestamp", "", "cellId", "lac", "cellType", "", "rsrp", "pci", "carrierMcc", "carrierMnc", "carrierOperator", "carrierShortOperator", OaidModel.KEY_ID, "<init>", "(IIJJILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getCellId", "getLac", "setLac", "(I)V", "getCellType", "()Ljava/lang/String;", "setCellType", "(Ljava/lang/String;)V", "getRsrp", "getPci", "getCarrierMcc", "getCarrierMnc", "getCarrierOperator", "setCarrierOperator", "getCarrierShortOperator", "setCarrierShortOperator", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9037b;
    private final long c;
    private final long d;
    private int e;
    private String f;
    private final int g;
    private final int h;
    private final String i;
    private final String j;
    private String k;
    private String l;
    private final long m;

    public dp(int r7, int r8, long r9, long r11, int r13, String r14, int r15, int r16, String r17, String r18, String r19, String r20, long r21) {
        Intrinsics.checkNotNullParameter(r14, "cellType");
        Intrinsics.checkNotNullParameter(r19, "carrierOperator");
        Intrinsics.checkNotNullParameter(r20, "carrierShortOperator");
        this.f9036a = r7;
        this.f9037b = r8;
        this.c = r9;
        this.d = r11;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
    }

    public /* synthetic */ dp(int r21, int r22, long r23, long r25, int r27, String r28, int r29, int r30, String r31, String r32, String r33, String r34, long r35, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 64) == 0) goto L5;
        int r12 = -1;
    L7:
        if ((r37 & 128) == 0) goto L9;
        int r13 = -1;
    L11:
        if ((r37 & 256) == 0) goto L13;
        String r14 = StructuredDataId.RESERVED;
    L15:
        if ((r37 & 512) == 0) goto L17;
        String r15 = StructuredDataId.RESERVED;
    L19:
        if ((r37 & 4096) == 0) goto L21;
        long r18 = 0;
    L22:
        this(r21, r22, r23, r25, r27, r28, r12, r13, r14, r15, r33, r34, r18);
        return;
    L21:
        r18 = r35;
        goto L22
    L17:
        r15 = r32;
        goto L19
    L13:
        r14 = r31;
        goto L15
    L9:
        r13 = r30;
        goto L11
    L5:
        r12 = r29;
        goto L7
    }

    public final int a() {
        return this.f9036a;
    }

    public final int b() {
        return this.f9037b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, dp.class) == true) goto L8;
        return false;
    L8:
        dp r10 = (dp) ZeusTransformUtils.preCheckCast(r9, dp.class, "com.obric.memorydata.plugin");
        if (this.f9036a == r10.f9036a) goto L12;
        return false;
    L12:
        if (this.f9037b == r10.f9037b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r10.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Integer.hashCode(this.f9036a) * 31) + Integer.hashCode(this.f9037b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.j;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((r4 + r2) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + Long.hashCode(this.m);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final long m() {
        return this.m;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MobileCellularEntity(dataId=").append(this.f9036a).append(", dataVersion=").append(this.f9037b).append(", timestamp=").append(this.c).append(", cellId=").append(this.d).append(", lac=").append(this.e).append(", cellType=").append(this.f).append(", rsrp=").append(this.g).append(", pci=").append(this.h).append(", carrierMcc=").append(this.i).append(", carrierMnc=").append(this.j).append(", carrierOperator=").append(this.k).append(", carrierShortOperator=");
        r0.append(this.l).append(", id=").append(this.m).append(')');
        return r0.toString();
    }
}
