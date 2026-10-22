package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\bC\b\u0087\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0015HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\tHÆ\u0003J\t\u0010Q\u001a\u00020\u0015HÆ\u0003J\t\u0010R\u001a\u00020\u001aHÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0015HÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0015HÆ\u0003J\u0085\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0015HÆ\u0001J\u0013\u0010Y\u001a\u00020\u00152\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\tHÖ\u0001J\t\u0010\\\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0016\u0010\u0017\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0016\u0010\u0018\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0016\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0016\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00105R\u0016\u0010\u001d\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0016\u0010\u001f\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00105¨\u0006]"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/UpdateUnionSemanticMemoryEntityOld;", "", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "semanticType", "tagPath", "keyPhrase", "description", "embeddingContent", "sources", "userEdit", "", "evidenceCount", "productType", "useForInsight", "confidence", "", "updateResult", "isUpdated", "retryTime", "lastExecuteUpdateTimestamp", "personalDbSplitMigrated", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZFLjava/lang/String;ZIJZ)V", "getId", "()J", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "getSemanticType", "getTagPath", "getKeyPhrase", "getDescription", "getEmbeddingContent", "getSources", "getUserEdit", "()Z", "getEvidenceCount", "getProductType", "getUseForInsight", "getConfidence", "()F", "getUpdateResult", "getRetryTime", "getLastExecuteUpdateTimestamp", "getPersonalDbSplitMigrated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9497b;
    private final long c;
    private final long d;
    private final int e;
    private final long f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final boolean p;
    private final int q;
    private final int r;
    private final boolean s;
    private final float t;
    private final String u;
    private final boolean v;
    private final int w;
    private final long x;
    private final boolean y;

    public aj(long r13, String r15, long r16, long r18, int r20, long r21, String r23, int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, boolean r32, int r33, int r34, boolean r35, float r36, String r37, boolean r38, int r39, long r40, boolean r42) {
        Intrinsics.checkNotNullParameter(r15, "entityId");
        Intrinsics.checkNotNullParameter(r23, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r26, "semanticType");
        Intrinsics.checkNotNullParameter(r27, "tagPath");
        Intrinsics.checkNotNullParameter(r28, "keyPhrase");
        Intrinsics.checkNotNullParameter(r29, "description");
        Intrinsics.checkNotNullParameter(r30, "embeddingContent");
        Intrinsics.checkNotNullParameter(r31, "sources");
        Intrinsics.checkNotNullParameter(r37, "updateResult");
        this.f9496a = r13;
        this.f9497b = r15;
        this.c = r16;
        this.d = r18;
        this.e = r20;
        this.f = r21;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
        this.y = r42;
    }

    public final long a() {
        return this.f9496a;
    }

    public final String b() {
        return this.f9497b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aj.class) == true) goto L8;
        return false;
    L8:
        aj r10 = (aj) ZeusTransformUtils.preCheckCast(r9, aj.class, "com.obric.memorydata.plugin");
        if (this.f9496a == r10.f9496a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9497b, r10.f9497b) == true) goto L15;
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
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
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
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (this.r == r10.r) goto L63;
        return false;
    L63:
        if (this.s == r10.s) goto L66;
        return false;
    L66:
        if (Float.compare(this.t, r10.t) == 0) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r10.v) goto L75;
        return false;
    L75:
        if (this.w == r10.w) goto L78;
        return false;
    L78:
        if (this.x == r10.x) goto L81;
        return false;
    L81:
        if (this.y == r10.y) goto L83;
        return false;
    L83:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final int getType() {
        return this.e;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9496a) * 31) + this.f9497b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((((((((((((((((((((((r0 + r2) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + Boolean.hashCode(this.p)) * 31) + Integer.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + Boolean.hashCode(this.s)) * 31) + Float.hashCode(this.t)) * 31) + this.u.hashCode()) * 31) + Boolean.hashCode(this.v)) * 31) + Integer.hashCode(this.w)) * 31) + Long.hashCode(this.x)) * 31) + Boolean.hashCode(this.y);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String i() {
        return this.j;
    }

    public final String j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final boolean o() {
        return this.p;
    }

    public final int p() {
        return this.q;
    }

    public final int q() {
        return this.r;
    }

    public final boolean r() {
        return this.s;
    }

    public final float s() {
        return this.t;
    }

    public final String t() {
        return this.u;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UpdateUnionSemanticMemoryEntityOld(id=").append(this.f9496a).append(", entityId=").append(this.f9497b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", semanticType=").append(this.j).append(", tagPath=").append(this.k).append(", keyPhrase=");
        r0.append(this.l).append(", description=").append(this.m).append(", embeddingContent=").append(this.n).append(", sources=").append(this.o).append(", userEdit=").append(this.p).append(", evidenceCount=").append(this.q).append(", productType=").append(this.r).append(", useForInsight=").append(this.s).append(", confidence=").append(this.t).append(", updateResult=").append(this.u).append(", isUpdated=").append(this.v).append(", retryTime=").append(this.w);
        r0.append(", lastExecuteUpdateTimestamp=").append(this.x).append(", personalDbSplitMigrated=").append(this.y).append(')');
        return r0.toString();
    }

    public final boolean u() {
        return this.v;
    }

    public final int v() {
        return this.w;
    }

    public final long w() {
        return this.x;
    }

    public final boolean x() {
        return this.y;
    }
}
