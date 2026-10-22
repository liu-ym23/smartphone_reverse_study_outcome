package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jw\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00064"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryProcessUserInsightEntity;", "", OaidModel.KEY_ID, "", "profileKey", "", "summary", "description", "profileJson", "evidenceRefs", "sourceEventIds", "processedForUnion", "", "logId", "createTime", "updateTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JJ)V", "getId", "()J", "getProfileKey$annotations", "()V", "getProfileKey", "()Ljava/lang/String;", "getSummary", "getDescription", "getProfileJson$annotations", "getProfileJson", "getEvidenceRefs", "getSourceEventIds", "getProcessedForUnion", "()Z", "getLogId", "getCreateTime", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9009b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final boolean h;
    private final String i;
    private final long j;
    private final long k;

    public da(long r2, String r4, String r5, String r6, String r7, String r8, String r9, boolean r10, String r11, long r12, long r14) {
        Intrinsics.checkNotNullParameter(r4, "profileKey");
        Intrinsics.checkNotNullParameter(r5, "summary");
        Intrinsics.checkNotNullParameter(r6, "description");
        Intrinsics.checkNotNullParameter(r7, "profileJson");
        Intrinsics.checkNotNullParameter(r8, "evidenceRefs");
        Intrinsics.checkNotNullParameter(r9, "sourceEventIds");
        Intrinsics.checkNotNullParameter(r11, "logId");
        this.f9008a = r2;
        this.f9009b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r14;
    }

    public /* synthetic */ da(long r19, String r21, String r22, String r23, String r24, String r25, String r26, boolean r27, String r28, long r29, long r31, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r6 = "deprecated_user_insight_" + UUID.randomUUID();
    L11:
        if ((r33 & 16) == 0) goto L13;
        String r9 = "{}";
    L15:
        if ((r33 & 32) == 0) goto L17;
        String r10 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L19:
        if ((r33 & 64) == 0) goto L21;
        String r11 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L23:
        if ((r33 & 128) == 0) goto L25;
        boolean r12 = false;
    L27:
        if ((r33 & 256) == 0) goto L29;
        String r13 = "";
    L31:
        if ((r33 & 512) == 0) goto L33;
        long r14 = System.currentTimeMillis();
    L35:
        if ((r33 & 1024) == 0) goto L37;
        long r16 = System.currentTimeMillis();
    L38:
        this(r4, r6, r22, r23, r9, r10, r11, r12, r13, r14, r16);
        return;
    L37:
        r16 = r31;
        goto L38
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r12 = r27;
        goto L27
    L21:
        r11 = r26;
        goto L23
    L17:
        r10 = r25;
        goto L19
    L13:
        r9 = r24;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public final long a() {
        return this.f9008a;
    }

    public final String b() {
        return this.f9009b;
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
        if (ZeusTransformUtils.instanceOf(r9, da.class) == true) goto L8;
        return false;
    L8:
        da r10 = (da) ZeusTransformUtils.preCheckCast(r9, da.class, "com.obric.memorydata.plugin");
        if (this.f9008a == r10.f9008a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9009b, r10.f9009b) == true) goto L15;
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
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.f9008a) * 31) + this.f9009b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k);
    }

    public final String i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public final long k() {
        return this.k;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemoryProcessUserInsightEntity(id=").append(this.f9008a).append(", profileKey=").append(this.f9009b).append(", summary=").append(this.c).append(", description=").append(this.d).append(", profileJson=").append(this.e).append(", evidenceRefs=").append(this.f).append(", sourceEventIds=").append(this.g).append(", processedForUnion=").append(this.h).append(", logId=").append(this.i).append(", createTime=").append(this.j).append(", updateTime=").append(this.k).append(')');
        return r0.toString();
    }
}
