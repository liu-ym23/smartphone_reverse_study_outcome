package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0087\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fHÆ\u0001J\u0013\u00100\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010 R\u0016\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0016\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001e¨\u00064"}, d2 = {"Lcom/obric/memorydata/database/entity/ProactiveInspirationEntity;", "", "inspirationId", "", "taskId", "recommendId", "recommendStatus", "", "feedbackAction", "userFeedback", "recommendationSnapshot", "created", "", "updated", "isDelete", "", "timestamp", OaidModel.KEY_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZJJ)V", "getInspirationId", "()Ljava/lang/String;", "getTaskId", "getRecommendId", "getRecommendStatus", "()I", "getFeedbackAction", "getUserFeedback", "getRecommendationSnapshot", "getCreated", "()J", "getUpdated", "()Z", "getTimestamp", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class et {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9095b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final long h;
    private final long i;
    private final boolean j;
    private final long k;
    private final long l;

    public et(String r6, String r7, String r8, int r9, String r10, String r11, String r12, long r13, long r15, boolean r17, long r18, long r20) {
        Intrinsics.checkNotNullParameter(r6, "inspirationId");
        Intrinsics.checkNotNullParameter(r7, "taskId");
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        this.f9094a = r6;
        this.f9095b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r15;
        this.j = r17;
        this.k = r18;
        this.l = r20;
    }

    public /* synthetic */ et(String r21, String r22, String r23, int r24, String r25, String r26, String r27, long r28, long r30, boolean r32, long r33, long r35, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 8) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r37 & 64) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r37 & 512) == 0) goto L13;
        boolean r15 = false;
    L15:
        if ((r37 & 1024) == 0) goto L17;
        long r16 = System.currentTimeMillis();
    L19:
        if ((r37 & 2048) == 0) goto L21;
        long r18 = 0;
    L22:
        this(r21, r22, r23, r7, r25, r26, r10, r28, r30, r15, r16, r18);
        return;
    L21:
        r18 = r35;
        goto L22
    L17:
        r16 = r33;
        goto L19
    L13:
        r15 = r32;
        goto L15
    L9:
        r10 = r27;
        goto L11
    L5:
        r7 = r24;
        goto L7
    }

    public final String a() {
        return this.f9094a;
    }

    public final String b() {
        return this.f9095b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, et.class) == true) goto L8;
        return false;
    L8:
        et r10 = (et) ZeusTransformUtils.preCheckCast(r9, et.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9094a, r10.f9094a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9095b, r10.f9095b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
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
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((this.f9094a.hashCode() * 31) + this.f9095b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.g;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((((((r7 + r2) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31) + Long.hashCode(this.l);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final long i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final long k() {
        return this.k;
    }

    public final long l() {
        return this.l;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ProactiveInspirationEntity(inspirationId=").append(this.f9094a).append(", taskId=").append(this.f9095b).append(", recommendId=").append(this.c).append(", recommendStatus=").append(this.d).append(", feedbackAction=").append(this.e).append(", userFeedback=").append(this.f).append(", recommendationSnapshot=").append(this.g).append(", created=").append(this.h).append(", updated=").append(this.i).append(", isDelete=").append(this.j).append(", timestamp=").append(this.k).append(", id=");
        r0.append(this.l).append(')');
        return r0.toString();
    }
}
