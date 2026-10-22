package com.obric.aiproactive.api;

import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveArtifactResource;", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;", "locator", "", "expiresAtMs", "", "<init>", "(Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;Ljava/lang/String;Ljava/lang/Long;)V", "getKind", "()Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;", "getLocator", "()Ljava/lang/String;", "getExpiresAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Lcom/obric/aiproactive/api/AiProactiveArtifactResourceKind;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/aiproactive/api/AiProactiveArtifactResource;", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AiProactiveArtifactResourceKind f6262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6263b;
    private final Long c;

    public m(AiProactiveArtifactResourceKind r2, String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r3, "locator");
        this.f6262a = r2;
        this.f6263b = r3;
        this.c = r4;
    }

    public final AiProactiveArtifactResourceKind a() {
        return this.f6262a;
    }

    public final String b() {
        return this.f6263b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        if (this.f6262a == r6.f6262a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6263b, r6.f6263b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f6262a.hashCode() * 31) + this.f6263b.hashCode()) * 31;
        Long r2 = this.c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AiProactiveArtifactResource(kind=" + this.f6262a + ", locator=" + this.f6263b + ", expiresAtMs=" + this.c + ')';
    }
}
