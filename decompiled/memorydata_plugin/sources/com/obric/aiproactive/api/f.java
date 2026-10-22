package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0011HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0083\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u000eHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010#R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u00066"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveAgentRunDisplayItemDto;", "", "groupKey", "", "groupTitle", "title", "description", "timestampMillis", "", "linkUrl", "artifactReference", "Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "itemId", "ordinal", "", "state", "isCurrent", "", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;)V", "getGroupKey", "()Ljava/lang/String;", "getGroupTitle", "getTitle", "getDescription", "getTimestampMillis", "()J", "getLinkUrl", "getArtifactReference", "()Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "getItemId", "getOrdinal", "()I", "getState", "()Z", "getAction", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6250b;
    private final String c;
    private final String d;
    private final long e;
    private final String f;
    private final d g;
    private final String h;
    private final int i;
    private final String j;
    private final boolean k;
    private final String l;

    public f(String r2, String r3, String r4, String r5, long r6, String r8, d r9, String r10, int r11, String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, "groupKey");
        Intrinsics.checkNotNullParameter(r3, "groupTitle");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "description");
        Intrinsics.checkNotNullParameter(r8, "linkUrl");
        Intrinsics.checkNotNullParameter(r10, "itemId");
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r14, "action");
        this.f6249a = r2;
        this.f6250b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }

    public /* synthetic */ f(String r18, String r19, String r20, String r21, long r22, String r24, d r25, String r26, int r27, String r28, boolean r29, String r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 32) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r31 & 64) == 0) goto L9;
        d r11 = null;
    L11:
        if ((r31 & 128) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r31 & 256) == 0) goto L17;
        int r13 = 0;
    L19:
        if ((r31 & 512) == 0) goto L21;
        String r14 = "";
    L23:
        if ((r31 & 1024) == 0) goto L25;
        boolean r15 = false;
    L27:
        if ((r31 & 2048) == 0) goto L29;
        String r16 = "";
    L30:
        this(r18, r19, r20, r21, r22, r10, r11, r12, r13, r14, r15, r16);
        return;
    L29:
        r16 = r30;
        goto L30
    L25:
        r15 = r29;
        goto L27
    L21:
        r14 = r28;
        goto L23
    L17:
        r13 = r27;
        goto L19
    L13:
        r12 = r26;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r10 = r24;
        goto L7
    }

    public static /* synthetic */ f a(f r14, String r15, String r16, String r17, String r18, long r19, String r21, d r22, String r23, int r24, String r25, boolean r26, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = r14.f6249a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.f6250b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        long r6 = r14.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r8 = r14.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        d r9 = r14.g;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r10 = r14.h;
    L35:
        if ((r28 & 256) == 0) goto L37;
        int r11 = r14.i;
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r12 = r14.j;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        boolean r13 = r14.k;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r1 = r14.l;
    L51:
        return r14.a(r2, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r1);
    L49:
        r1 = r27;
        goto L51
    L45:
        r13 = r26;
        goto L47
    L41:
        r12 = r25;
        goto L43
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final f a(String r16, String r17, String r18, String r19, long r20, String r22, d r23, String r24, int r25, String r26, boolean r27, String r28) {
        Intrinsics.checkNotNullParameter(r16, "groupKey");
        Intrinsics.checkNotNullParameter(r17, "groupTitle");
        Intrinsics.checkNotNullParameter(r18, "title");
        Intrinsics.checkNotNullParameter(r19, "description");
        Intrinsics.checkNotNullParameter(r22, "linkUrl");
        Intrinsics.checkNotNullParameter(r24, "itemId");
        Intrinsics.checkNotNullParameter(r26, "state");
        Intrinsics.checkNotNullParameter(r28, "action");
        return new f(r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28);
    }

    public final String a() {
        return this.f6249a;
    }

    public final String b() {
        return this.f6250b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6249a, r10.f6249a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6250b, r10.f6250b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
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
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final d g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f6249a.hashCode() * 31) + this.f6250b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
        d r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((r0 + r2) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + Boolean.hashCode(this.k)) * 31) + this.l.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final int i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AiProactiveAgentRunDisplayItemDto(groupKey=").append(this.f6249a).append(", groupTitle=").append(this.f6250b).append(", title=").append(this.c).append(", description=").append(this.d).append(", timestampMillis=").append(this.e).append(", linkUrl=").append(this.f).append(", artifactReference=").append(this.g).append(", itemId=").append(this.h).append(", ordinal=").append(this.i).append(", state=").append(this.j).append(", isCurrent=").append(this.k).append(", action=");
        r0.append(this.l).append(')');
        return r0.toString();
    }
}
