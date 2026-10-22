package com.obric.memorydata.memory.ui.list;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u000eHÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003J{\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010 ¨\u00060"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "", OaidModel.KEY_ID, "", Api.KEY_UUID, Params.CONTENT, "sourceSummary", "categoryLabel", "confidence", "", "modifyTime", "", "changeSeq", "conflicts", "", "isOperating", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/util/Map;Z)V", "getId", "()Ljava/lang/String;", "getUuid", "getContent", "getSourceSummary", "getCategoryLabel", "getConfidence", "()I", "getModifyTime", "()J", "getChangeSeq", "getConflicts", "()Ljava/util/Map;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11205b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final long g;
    private final long h;
    private final Map<String, Long> i;
    private final boolean j;

    public ar(String r3, String r4, String r5, String r6, String r7, int r8, long r9, long r11, Map<String, Long> r13, boolean r14) {
        Map<String, Long> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r6, "sourceSummary");
        Intrinsics.checkNotNullParameter(r7, "categoryLabel");
        Intrinsics.checkNotNullParameter(r15, "conflicts");
        this.f11204a = r3;
        this.f11205b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r11;
        this.i = r15;
        this.j = r14;
    }

    public /* synthetic */ ar(String r15, String r16, String r17, String r18, String r19, int r20, long r21, long r23, Map r25, boolean r26, int r27, DefaultConstructorMarker r28) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        if ((r27 & 512) == 0) goto L5;
        boolean r13 = false;
    L6:
        this(r15, r16, r17, r18, r19, r20, r21, r23, r12, r13);
        return;
    L5:
        r13 = r26;
        goto L6
    }

    public static /* synthetic */ ar a(ar r14, String r15, String r16, String r17, String r18, String r19, int r20, long r21, long r23, Map r25, boolean r26, int r27, Object r28) {
        Map<String, Long> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        if ((r27 & 1) == 0) goto L5;
        String r3 = r14.f11204a;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r4 = r14.f11205b;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r5 = r14.c;
    L15:
        if ((r27 & 8) == 0) goto L17;
        String r6 = r14.d;
    L19:
        if ((r27 & 16) == 0) goto L21;
        String r7 = r14.e;
    L23:
        if ((r27 & 32) == 0) goto L25;
        int r8 = r14.f;
    L27:
        if ((r27 & 64) == 0) goto L29;
        long r9 = r14.g;
    L31:
        if ((r27 & 128) == 0) goto L33;
        long r11 = r14.h;
    L35:
        if ((r27 & 256) == 0) goto L38;
        r2 = r14.i;
    L38:
        if ((r27 & 512) == 0) goto L40;
        boolean r1 = r14.j;
    L42:
        return r14.a(r3, r4, r5, r6, r7, r8, r9, r11, r2, r1);
    L40:
        r1 = r26;
        goto L42
    L33:
        r11 = r23;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public final ar a(String r15, String r16, String r17, String r18, String r19, int r20, long r21, long r23, Map<String, Long> r25, boolean r26) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r17, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r18, "sourceSummary");
        Intrinsics.checkNotNullParameter(r19, "categoryLabel");
        Intrinsics.checkNotNullParameter(r12, "conflicts");
        return new ar(r15, r16, r17, r18, r19, r20, r21, r23, r12, r26);
    }

    public final String a() {
        return this.f11204a;
    }

    public final String b() {
        return this.f11205b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final long e() {
        return this.g;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ar.class) == true) goto L8;
        return false;
    L8:
        ar r10 = (ar) ZeusTransformUtils.preCheckCast(r9, ar.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11204a, r10.f11204a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11205b, r10.f11205b) == true) goto L15;
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
        if (this.j == r10.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final long f() {
        return this.h;
    }

    public final Map<String, Long> g() {
        return this.i;
    }

    public final boolean h() {
        return this.j;
    }

    public int hashCode() {
        int r0 = this.f11204a.hashCode() * 31;
        String r1 = this.f11205b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Boolean.hashCode(this.j);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PendingPersonalInfoItem(id=" + this.f11204a + ", uuid=" + this.f11205b + ", content=" + this.c + ", sourceSummary=" + this.d + ", categoryLabel=" + this.e + ", confidence=" + this.f + ", modifyTime=" + this.g + ", changeSeq=" + this.h + ", conflicts=" + this.i + ", isOperating=" + this.j + ')';
    }
}
