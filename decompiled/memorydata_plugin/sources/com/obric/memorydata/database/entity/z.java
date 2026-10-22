package com.obric.memorydata.database.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\rHÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00065"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProRawSource;", "", OaidModel.KEY_ID, "", TypedValues.AttributesType.S_TARGET, "", "sourceType", "sourceKey", ChatMessage.TYPE_QUERY, "contentPartsJson", "timestamp", "state", "retryCount", "", "lastErrorCode", "logId", "updateTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IILjava/lang/String;J)V", "getId", "()J", "getTarget", "()Ljava/lang/String;", "getSourceType", "getSourceKey", "getQuery", "getContentPartsJson", "getTimestamp", "getState", "getRetryCount", "()I", "getLastErrorCode", "getLogId", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9303b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final long h;
    private final String i;
    private final int j;
    private final int k;
    private final String l;
    private final long m;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProRawSource$Companion;", "", "<init>", "()V", "STATE_PENDING", "", "STATE_PROCESSING", "STATE_FINISHED", "STATE_FAILED", "TARGET_CLOUD_MODEL", "TARGET_LOCAL_MODEL", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9302a = new a(null);
    }

    public z(long r11, String r13, String r14, String r15, String r16, String r17, long r18, String r20, int r21, int r22, String r23, long r24) {
        Intrinsics.checkNotNullParameter(r13, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r14, "sourceType");
        Intrinsics.checkNotNullParameter(r15, "sourceKey");
        Intrinsics.checkNotNullParameter(r16, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r17, "contentPartsJson");
        Intrinsics.checkNotNullParameter(r20, "state");
        Intrinsics.checkNotNullParameter(r23, "logId");
        this.f9303b = r11;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
    }

    public static /* synthetic */ z a(z r16, long r17, String r19, String r20, String r21, String r22, String r23, long r24, String r26, int r27, int r28, String r29, long r30, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        long r2 = r16.f9303b;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = r16.c;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = r16.d;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r6 = r16.e;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r7 = r16.f;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r8 = r16.g;
    L27:
        if ((r32 & 64) == 0) goto L29;
        long r9 = r16.h;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r11 = r16.i;
    L35:
        if ((r32 & 256) == 0) goto L37;
        int r12 = r16.j;
    L39:
        if ((r32 & 512) == 0) goto L41;
        int r13 = r16.k;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r14 = r16.l;
    L46:
        String r210 = r14;
        if ((r32 & 2048) == 0) goto L49;
        long r15 = r16.m;
    L51:
        return r16.a(r2, r4, r5, r6, r7, r8, r9, r11, r12, r13, r210, r15);
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = r29;
        goto L46
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long a() {
        return this.f9303b;
    }

    public final z a(long r18, String r20, String r21, String r22, String r23, String r24, long r25, String r27, int r28, int r29, String r30, long r31) {
        Intrinsics.checkNotNullParameter(r20, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r21, "sourceType");
        Intrinsics.checkNotNullParameter(r22, "sourceKey");
        Intrinsics.checkNotNullParameter(r23, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r24, "contentPartsJson");
        Intrinsics.checkNotNullParameter(r27, "state");
        Intrinsics.checkNotNullParameter(r30, "logId");
        return new z(r18, r20, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31);
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, z.class) == true) goto L8;
        return false;
    L8:
        z r10 = (z) ZeusTransformUtils.preCheckCast(r9, z.class, "com.obric.memorydata.plugin");
        if (this.f9303b == r10.f9303b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L33;
        return false;
    L33:
        if (this.j == r10.j) goto L36;
        return false;
    L36:
        if (this.k == r10.k) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L42;
        return false;
    L42:
        if (this.m == r10.m) goto L44;
        return false;
    L44:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final long g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        return (((((((((((((((((((((Long.hashCode(this.f9303b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + this.l.hashCode()) * 31) + Long.hashCode(this.m);
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final long l() {
        return this.m;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutoMemoryProRawSource(id=").append(this.f9303b).append(", target=").append(this.c).append(", sourceType=").append(this.d).append(", sourceKey=").append(this.e).append(", query=").append(this.f).append(", contentPartsJson=").append(this.g).append(", timestamp=").append(this.h).append(", state=").append(this.i).append(", retryCount=").append(this.j).append(", lastErrorCode=").append(this.k).append(", logId=").append(this.l).append(", updateTime=");
        r0.append(this.m).append(')');
        return r0.toString();
    }
}
