package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveAgentRunArtifactReferenceDto;", "", "artifactId", "", "artifactType", "Lcom/obric/aiproactive/api/AiProactiveArtifactType;", "displayName", "state", "Lcom/obric/aiproactive/api/AiProactiveArtifactState;", "<init>", "(Ljava/lang/String;Lcom/obric/aiproactive/api/AiProactiveArtifactType;Ljava/lang/String;Lcom/obric/aiproactive/api/AiProactiveArtifactState;)V", "getArtifactId", "()Ljava/lang/String;", "getArtifactType", "()Lcom/obric/aiproactive/api/AiProactiveArtifactType;", "getDisplayName", "getState", "()Lcom/obric/aiproactive/api/AiProactiveArtifactState;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AiProactiveArtifactType f6246b;
    private final String c;
    private final AiProactiveArtifactState d;

    public d(String r2, AiProactiveArtifactType r3, String r4, AiProactiveArtifactState r5) {
        Intrinsics.checkNotNullParameter(r2, "artifactId");
        Intrinsics.checkNotNullParameter(r3, "artifactType");
        Intrinsics.checkNotNullParameter(r4, "displayName");
        Intrinsics.checkNotNullParameter(r5, "state");
        this.f6245a = r2;
        this.f6246b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final String a() {
        return this.f6245a;
    }

    public final AiProactiveArtifactType b() {
        return this.f6246b;
    }

    public final String c() {
        return this.c;
    }

    public final AiProactiveArtifactState d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6245a, r6.f6245a) == true) goto L12;
        return false;
    L12:
        if (this.f6246b == r6.f6246b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f6245a.hashCode() * 31) + this.f6246b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AiProactiveAgentRunArtifactReferenceDto(artifactId=" + this.f6245a + ", artifactType=" + this.f6246b + ", displayName=" + this.c + ", state=" + this.d + ')';
    }
}
