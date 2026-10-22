package com.obric.aiproactive.impl.aidb.a;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jn\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006-"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEventRecordEntity;", "", OaidModel.KEY_ID, "", "timestamp", "rawTableName", "", "rawDbId", WsConstants.KEY_EXTRA, "fullcontent", "userFullcontent", "happenedAt", "recordedAt", "<init>", "(JJLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getId", "()J", "getTimestamp", "getRawTableName", "()Ljava/lang/String;", "getRawDbId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtra", "getFullcontent", "getUserFullcontent", "getHappenedAt", "getRecordedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEventRecordEntity;", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6291b;
    private final String c;
    private final Long d;
    private final String e;
    private final String f;
    private final String g;
    private final long h;
    private final long i;

    public c(long r2, long r4, String r6, Long r7, String r8, String r9, String r10, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r9, "fullcontent");
        Intrinsics.checkNotNullParameter(r10, "userFullcontent");
        this.f6290a = r2;
        this.f6291b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r13;
    }

    public /* synthetic */ c(long r17, long r19, String r21, Long r22, String r23, String r24, String r25, long r26, long r28, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r30 & 4) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r30 & 8) == 0) goto L13;
        Long r8 = null;
    L15:
        if ((r30 & 16) == 0) goto L17;
        String r9 = null;
    L18:
        this(r3, r19, r7, r8, r9, r24, r25, r26, r28);
        return;
    L17:
        r9 = r23;
        goto L18
    L13:
        r8 = r22;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public static /* synthetic */ c a(c r15, long r16, long r18, String r20, Long r21, String r22, String r23, String r24, long r25, long r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        long r2 = r15.f6290a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        long r4 = r15.f6291b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r6 = r15.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        Long r7 = r15.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r8 = r15.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r9 = r15.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r10 = r15.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        long r11 = r15.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        long r13 = r15.i;
    L39:
        return r15.a(r2, r4, r6, r7, r8, r9, r10, r11, r13);
    L37:
        r13 = r27;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final long a() {
        return this.f6290a;
    }

    public final c a(long r16, long r18, String r20, Long r21, String r22, String r23, String r24, long r25, long r27) {
        Intrinsics.checkNotNullParameter(r23, "fullcontent");
        Intrinsics.checkNotNullParameter(r24, "userFullcontent");
        return new c(r16, r18, r20, r21, r22, r23, r24, r25, r27);
    }

    public final long b() {
        return this.f6291b;
    }

    public final String c() {
        return this.c;
    }

    public final Long d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
        if (this.f6290a == r10.f6290a) goto L12;
        return false;
    L12:
        if (this.f6291b == r10.f6291b) goto L15;
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
        if (this.i == r10.i) goto L35;
        return false;
    L35:
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
        int r0 = ((Long.hashCode(this.f6290a) * 31) + Long.hashCode(this.f6291b)) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((((r7 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i);
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

    public String toString() {
        return "AiProactiveEventRecordEntity(id=" + this.f6290a + ", timestamp=" + this.f6291b + ", rawTableName=" + this.c + ", rawDbId=" + this.d + ", extra=" + this.e + ", fullcontent=" + this.f + ", userFullcontent=" + this.g + ", happenedAt=" + this.h + ", recordedAt=" + this.i + ')';
    }
}
