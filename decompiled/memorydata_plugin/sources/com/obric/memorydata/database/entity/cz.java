package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00064"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryProcessTriggerStateEntity;", "", "stateId", "", "businessId", "groupKey", "triggerMode", "state", "firstEventTime", "", "lastEventTime", "nextRunTime", "runMode", "pendingCount", "", "logId", "updateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;ILjava/lang/String;J)V", "getStateId", "()Ljava/lang/String;", "getBusinessId", "getGroupKey", "getTriggerMode", "getState", "getFirstEventTime", "()J", "getLastEventTime", "getNextRunTime", "getRunMode", "getPendingCount", "()I", "getLogId", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9007b;
    private final String c;
    private final String d;
    private final String e;
    private final long f;
    private final long g;
    private final long h;
    private final String i;
    private final int j;
    private final String k;
    private final long l;

    public cz(String r10, String r11, String r12, String r13, String r14, long r15, long r17, long r19, String r21, int r22, String r23, long r24) {
        Intrinsics.checkNotNullParameter(r10, "stateId");
        Intrinsics.checkNotNullParameter(r11, "businessId");
        Intrinsics.checkNotNullParameter(r12, "groupKey");
        Intrinsics.checkNotNullParameter(r13, "triggerMode");
        Intrinsics.checkNotNullParameter(r14, "state");
        Intrinsics.checkNotNullParameter(r21, "runMode");
        Intrinsics.checkNotNullParameter(r23, "logId");
        this.f9006a = r10;
        this.f9007b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r17;
        this.h = r19;
        this.i = r21;
        this.j = r22;
        this.k = r23;
        this.l = r24;
    }

    public static /* synthetic */ cz a(cz r16, String r17, String r18, String r19, String r20, String r21, long r22, long r24, long r26, String r28, int r29, String r30, long r31, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        String r2 = r16.f9006a;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r3 = r16.f9007b;
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r4 = r16.c;
    L15:
        if ((r33 & 8) == 0) goto L17;
        String r5 = r16.d;
    L19:
        if ((r33 & 16) == 0) goto L21;
        String r6 = r16.e;
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r7 = r16.f;
    L27:
        if ((r33 & 64) == 0) goto L29;
        long r9 = r16.g;
    L31:
        if ((r33 & 128) == 0) goto L33;
        long r11 = r16.h;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r13 = r16.i;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r14 = r16.j;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        String r15 = r16.k;
    L46:
        int r210 = r14;
        String r32 = r15;
        if ((r33 & 2048) == 0) goto L49;
        long r110 = r16.l;
    L51:
        return r16.a(r2, r3, r4, r5, r6, r7, r9, r11, r13, r210, r32, r110);
    L49:
        r110 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L46
    L41:
        r14 = r29;
        goto L43
    L37:
        r13 = r28;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final cz a(String r19, String r20, String r21, String r22, String r23, long r24, long r26, long r28, String r30, int r31, String r32, long r33) {
        Intrinsics.checkNotNullParameter(r19, "stateId");
        Intrinsics.checkNotNullParameter(r20, "businessId");
        Intrinsics.checkNotNullParameter(r21, "groupKey");
        Intrinsics.checkNotNullParameter(r22, "triggerMode");
        Intrinsics.checkNotNullParameter(r23, "state");
        Intrinsics.checkNotNullParameter(r30, "runMode");
        Intrinsics.checkNotNullParameter(r32, "logId");
        return new cz(r19, r20, r21, r22, r23, r24, r26, r28, r30, r31, r32, r33);
    }

    public final String a() {
        return this.f9006a;
    }

    public final String b() {
        return this.f9007b;
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
        if (ZeusTransformUtils.instanceOf(r9, cz.class) == true) goto L8;
        return false;
    L8:
        cz r10 = (cz) ZeusTransformUtils.preCheckCast(r9, cz.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9006a, r10.f9006a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9007b, r10.f9007b) == true) goto L15;
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
        if (this.f == r10.f) goto L27;
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
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.f9006a.hashCode() * 31) + this.f9007b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + Long.hashCode(this.l);
    }

    public final String i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final long l() {
        return this.l;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemoryProcessTriggerStateEntity(stateId=").append(this.f9006a).append(", businessId=").append(this.f9007b).append(", groupKey=").append(this.c).append(", triggerMode=").append(this.d).append(", state=").append(this.e).append(", firstEventTime=").append(this.f).append(", lastEventTime=").append(this.g).append(", nextRunTime=").append(this.h).append(", runMode=").append(this.i).append(", pendingCount=").append(this.j).append(", logId=").append(this.k).append(", updateTime=");
        r0.append(this.l).append(')');
        return r0.toString();
    }
}
