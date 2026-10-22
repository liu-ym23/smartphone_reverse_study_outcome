package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\nHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "", "executionId", "", "traceId", "state", "startedAtMillis", "", "updatedAtMillis", "suggestionCount", "", "steps", "", "Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJILjava/util/List;)V", "getExecutionId", "()Ljava/lang/String;", "getTraceId", "getState", "getStartedAtMillis", "()J", "getUpdatedAtMillis", "getSuggestionCount", "()I", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6252b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private final int g;
    private final List<i> h;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveAgentRunDto$Companion;", "", "<init>", "()V", "STATE_PENDING", "", "STATE_RUNNING", "STATE_WAITING", "STATE_SUCCEEDED", "STATE_FAILED", "STATE_CANCELLED", "STATE_TIMED_OUT", "STATE_ACCEPTED", "STATE_OUTCOME_UNKNOWN", "STATE_UNKNOWN", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6251a = new a(null);
    }

    public g(String r3, String r4, String r5, long r6, long r8, int r10, List<i> r11) {
        List<i> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "executionId");
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r12, "steps");
        this.f6252b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
        this.h = r12;
    }

    public static /* synthetic */ g a(g r11, String r12, String r13, String r14, long r15, long r17, int r19, List r20, int r21, Object r22) {
        List<i> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L5;
        String r2 = r11.f6252b;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r3 = r11.c;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r4 = r11.d;
    L15:
        if ((r21 & 8) == 0) goto L17;
        long r5 = r11.e;
    L19:
        if ((r21 & 16) == 0) goto L21;
        long r7 = r11.f;
    L23:
        if ((r21 & 32) == 0) goto L25;
        int r9 = r11.g;
    L27:
        if ((r21 & 64) == 0) goto L30;
        r1 = r11.h;
    L30:
        return r11.a(r2, r3, r4, r5, r7, r9, r1);
    L25:
        r9 = r19;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final g a(String r12, String r13, String r14, long r15, long r17, int r19, List<i> r20) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "executionId");
        Intrinsics.checkNotNullParameter(r13, "traceId");
        Intrinsics.checkNotNullParameter(r14, "state");
        Intrinsics.checkNotNullParameter(r10, "steps");
        return new g(r12, r13, r14, r15, r17, r19, r10);
    }

    public final String a() {
        return this.f6252b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6252b, r10.f6252b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (this.f == r10.f) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int f() {
        return this.g;
    }

    public final List<i> g() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((this.f6252b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "AiProactiveAgentRunDto(executionId=" + this.f6252b + ", traceId=" + this.c + ", state=" + this.d + ", startedAtMillis=" + this.e + ", updatedAtMillis=" + this.f + ", suggestionCount=" + this.g + ", steps=" + this.h + ')';
    }
}
