package com.obric.aiproactive.ui.progress;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunUiItem;", "", OaidModel.KEY_ID, "", "title", "description", "timestampMillis", "", "state", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "showState", "", "linkUrl", "artifactReference", "Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/obric/aiproactive/ui/progress/AgentRunUiState;ZLjava/lang/String;Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "getTimestampMillis", "()J", "getState", "()Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "getShowState", "()Z", "getLinkUrl", "getArtifactReference", "()Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6830b;
    private final String c;
    private final long d;
    private final AgentRunUiState e;
    private final boolean f;
    private final String g;
    private final com.obric.aiproactive.api.d h;

    public l(String r2, String r3, String r4, long r5, AgentRunUiState r7, boolean r8, String r9, com.obric.aiproactive.api.d r10) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "description");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r9, "linkUrl");
        this.f6829a = r2;
        this.f6830b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public /* synthetic */ l(String r13, String r14, String r15, long r16, AgentRunUiState r18, boolean r19, String r20, com.obric.aiproactive.api.d r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 32) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r22 & 64) == 0) goto L9;
        String r10 = "";
    L11:
        if ((r22 & 128) == 0) goto L13;
        com.obric.aiproactive.api.d r11 = null;
    L14:
        this(r13, r14, r15, r16, r18, r9, r10, r11);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    public static /* synthetic */ l a(l r10, String r11, String r12, String r13, long r14, AgentRunUiState r16, boolean r17, String r18, com.obric.aiproactive.api.d r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.f6829a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.f6830b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        AgentRunUiState r7 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r8 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        com.obric.aiproactive.api.d r1 = r10.h;
    L35:
        return r10.a(r2, r3, r4, r5, r7, r8, r9, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final l a(String r12, String r13, String r14, long r15, AgentRunUiState r17, boolean r18, String r19, com.obric.aiproactive.api.d r20) {
        Intrinsics.checkNotNullParameter(r12, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r14, "description");
        Intrinsics.checkNotNullParameter(r17, "state");
        Intrinsics.checkNotNullParameter(r19, "linkUrl");
        return new l(r12, r13, r14, r15, r17, r18, r19, r20);
    }

    public final String a() {
        return this.f6830b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.g;
    }

    public final com.obric.aiproactive.api.d d() {
        return this.h;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, l.class) == true) goto L8;
        return false;
    L8:
        l r10 = (l) ZeusTransformUtils.preCheckCast(r9, l.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6829a, r10.f6829a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6830b, r10.f6830b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
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
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f6829a.hashCode() * 31) + this.f6830b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
        com.obric.aiproactive.api.d r3 = this.h;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "AgentRunUiItem(id=" + this.f6829a + ", title=" + this.f6830b + ", description=" + this.c + ", timestampMillis=" + this.d + ", state=" + this.e + ", showState=" + this.f + ", linkUrl=" + this.g + ", artifactReference=" + this.h + ')';
    }
}
