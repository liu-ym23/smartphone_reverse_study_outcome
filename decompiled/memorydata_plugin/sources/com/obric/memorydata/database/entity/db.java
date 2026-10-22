package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J¥\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006<"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryReviewFeedbackEntity;", "", OaidModel.KEY_ID, "", "recordId", "", "module", "vote", "reasonsJson", "comment", "displayedCardJson", "status", "error", "traceJson", "updateTime", "serverUniqId", "serverStatus", "serverError", "serverUpdateTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "getRecordId", "()Ljava/lang/String;", "getModule", "getVote", "getReasonsJson", "getComment", "getDisplayedCardJson", "getStatus", "getError", "getTraceJson", "getUpdateTime", "getServerUniqId", "getServerStatus", "getServerError", "getServerUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9011b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final long k;
    private final String l;
    private final String m;
    private final String n;
    private final long o;

    public db(long r13, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, long r24, String r26, String r27, String r28, long r29) {
        Intrinsics.checkNotNullParameter(r15, "recordId");
        Intrinsics.checkNotNullParameter(r16, "module");
        Intrinsics.checkNotNullParameter(r17, "vote");
        Intrinsics.checkNotNullParameter(r18, "reasonsJson");
        Intrinsics.checkNotNullParameter(r19, "comment");
        Intrinsics.checkNotNullParameter(r20, "displayedCardJson");
        Intrinsics.checkNotNullParameter(r21, "status");
        Intrinsics.checkNotNullParameter(r26, "serverUniqId");
        Intrinsics.checkNotNullParameter(r27, "serverStatus");
        this.f9010a = r13;
        this.f9011b = r15;
        this.c = r16;
        this.d = r17;
        this.e = r18;
        this.f = r19;
        this.g = r20;
        this.h = r21;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
    }

    public /* synthetic */ db(long r24, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, long r35, String r37, String r38, String r39, long r40, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r42 & 256) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r42 & 512) == 0) goto L13;
        String r15 = null;
    L15:
        if ((r42 & 2048) == 0) goto L17;
        String r18 = "";
    L19:
        if ((r42 & 4096) == 0) goto L21;
        String r19 = "";
    L23:
        if ((r42 & 8192) == 0) goto L25;
        String r20 = null;
    L27:
        if ((r42 & 16384) == 0) goto L29;
        long r21 = 0;
    L30:
        this(r5, r26, r27, r28, r29, r30, r31, r32, r14, r15, r35, r18, r19, r20, r21);
        return;
    L29:
        r21 = r40;
        goto L30
    L25:
        r20 = r39;
        goto L27
    L21:
        r19 = r38;
        goto L23
    L17:
        r18 = r37;
        goto L19
    L13:
        r15 = r34;
        goto L15
    L9:
        r14 = r33;
        goto L11
    L5:
        r5 = r24;
        goto L7
    }

    public final long a() {
        return this.f9010a;
    }

    public final String b() {
        return this.f9011b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, db.class) == true) goto L8;
        return false;
    L8:
        db r10 = (db) ZeusTransformUtils.preCheckCast(r9, db.class, "com.obric.memorydata.plugin");
        if (this.f9010a == r10.f9010a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9011b, r10.f9011b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
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
        if (this.o == r10.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9010a) * 31) + this.f9011b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.j;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + Long.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        String r8 = this.n;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + Long.hashCode(this.o);
    L9:
        r6 = r5.hashCode();
        goto L10
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

    public final long k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final String n() {
        return this.n;
    }

    public final long o() {
        return this.o;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemoryReviewFeedbackEntity(id=").append(this.f9010a).append(", recordId=").append(this.f9011b).append(", module=").append(this.c).append(", vote=").append(this.d).append(", reasonsJson=").append(this.e).append(", comment=").append(this.f).append(", displayedCardJson=").append(this.g).append(", status=").append(this.h).append(", error=").append(this.i).append(", traceJson=").append(this.j).append(", updateTime=").append(this.k).append(", serverUniqId=");
        r0.append(this.l).append(", serverStatus=").append(this.m).append(", serverError=").append(this.n).append(", serverUpdateTime=").append(this.o).append(')');
        return r0.toString();
    }
}
