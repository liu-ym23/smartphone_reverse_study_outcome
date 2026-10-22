package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J|\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006:"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveArtifact;", "", "artifactId", "", "artifactType", "Lcom/obric/aiproactive/api/AiProactiveArtifactType;", "state", "Lcom/obric/aiproactive/api/AiProactiveArtifactState;", "displayName", "mimeType", "resource", "Lcom/obric/aiproactive/api/AiProactiveArtifactResource;", "sizeBytes", "", "durationMs", "preview", "Lcom/obric/aiproactive/api/AiProactiveArtifactPreview;", "errorCode", "<init>", "(Ljava/lang/String;Lcom/obric/aiproactive/api/AiProactiveArtifactType;Lcom/obric/aiproactive/api/AiProactiveArtifactState;Ljava/lang/String;Ljava/lang/String;Lcom/obric/aiproactive/api/AiProactiveArtifactResource;Ljava/lang/Long;Ljava/lang/Long;Lcom/obric/aiproactive/api/AiProactiveArtifactPreview;Ljava/lang/String;)V", "getArtifactId", "()Ljava/lang/String;", "getArtifactType", "()Lcom/obric/aiproactive/api/AiProactiveArtifactType;", "getState", "()Lcom/obric/aiproactive/api/AiProactiveArtifactState;", "getDisplayName", "getMimeType", "getResource", "()Lcom/obric/aiproactive/api/AiProactiveArtifactResource;", "getSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDurationMs", "getPreview", "()Lcom/obric/aiproactive/api/AiProactiveArtifactPreview;", "getErrorCode", "canOpen", "", "getCanOpen", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Lcom/obric/aiproactive/api/AiProactiveArtifactType;Lcom/obric/aiproactive/api/AiProactiveArtifactState;Ljava/lang/String;Ljava/lang/String;Lcom/obric/aiproactive/api/AiProactiveArtifactResource;Ljava/lang/Long;Ljava/lang/Long;Lcom/obric/aiproactive/api/AiProactiveArtifactPreview;Ljava/lang/String;)Lcom/obric/aiproactive/api/AiProactiveArtifact;", "equals", "other", "hashCode", "", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AiProactiveArtifactType f6256b;
    private final AiProactiveArtifactState c;
    private final String d;
    private final String e;
    private final m f;
    private final Long g;
    private final Long h;
    private final l i;
    private final String j;

    public j(String r2, AiProactiveArtifactType r3, AiProactiveArtifactState r4, String r5, String r6, m r7, Long r8, Long r9, l r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "artifactId");
        Intrinsics.checkNotNullParameter(r3, "artifactType");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "displayName");
        Intrinsics.checkNotNullParameter(r6, "mimeType");
        this.f6255a = r2;
        this.f6256b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public /* synthetic */ j(String r15, AiProactiveArtifactType r16, AiProactiveArtifactState r17, String r18, String r19, m r20, Long r21, Long r22, l r23, String r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 32) == 0) goto L5;
        m r9 = null;
    L7:
        if ((r25 & 64) == 0) goto L9;
        Long r10 = null;
    L11:
        if ((r25 & 128) == 0) goto L13;
        Long r11 = null;
    L15:
        if ((r25 & 256) == 0) goto L17;
        l r12 = null;
    L19:
        if ((r25 & 512) == 0) goto L21;
        String r13 = null;
    L22:
        this(r15, r16, r17, r18, r19, r9, r10, r11, r12, r13);
        return;
    L21:
        r13 = r24;
        goto L22
    L17:
        r12 = r23;
        goto L19
    L13:
        r11 = r22;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r9 = r20;
        goto L7
    }

    public final String a() {
        return this.f6255a;
    }

    public final AiProactiveArtifactType b() {
        return this.f6256b;
    }

    public final AiProactiveArtifactState c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6255a, r6.f6255a) == true) goto L12;
        return false;
    L12:
        if (this.f6256b == r6.f6256b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final m f() {
        return this.f;
    }

    public final Long g() {
        return this.g;
    }

    public final boolean h() {
        if (this.c == AiProactiveArtifactState.READY) goto L5;
    L9:
        return false;
    L5:
        if (this.f == null) goto L9;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.e, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.f6255a.hashCode() * 31) + this.f6256b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        m r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        l r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.j;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AiProactiveArtifact(artifactId=" + this.f6255a + ", artifactType=" + this.f6256b + ", state=" + this.c + ", displayName=" + this.d + ", mimeType=" + this.e + ", resource=" + this.f + ", sizeBytes=" + this.g + ", durationMs=" + this.h + ", preview=" + this.i + ", errorCode=" + this.j + ')';
    }
}
