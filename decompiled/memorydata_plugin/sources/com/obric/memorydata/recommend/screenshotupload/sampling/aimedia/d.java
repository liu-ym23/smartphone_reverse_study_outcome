package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventEnvelopeDto;", "", "eventName", "", "sequenceNumber", "", ObricMemoryConstants.KEY_SESSION_ID, "reportedPackage", "fields", "", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventFieldDto;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEventName", "()Ljava/lang/String;", "getSequenceNumber", "()J", "getSessionId", "getReportedPackage", "getFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12569b;
    private final String c;
    private final String d;
    private final List<e> e;

    public d() {
        this(null, 0, null, null, null, 31, null);
    }

    public d(String r3, long r4, String r6, String r7, List<e> r8) {
        List<e> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r7, "reportedPackage");
        Intrinsics.checkNotNullParameter(r9, "fields");
        this.f12568a = r3;
        this.f12569b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r9;
    }

    public /* synthetic */ d(String r8, long r9, String r11, String r12, List r13, int r14, DefaultConstructorMarker r15) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        String r2 = "";
        if ((r14 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r14 & 2) == 0) goto L9;
        long r3 = 0;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r14 & 8) != 0) goto L19;
        r2 = r12;
    L19:
        if ((r14 & 16) == 0) goto L21;
        r0 = CollectionsKt.emptyList();
    L21:
        this(r1, r3, r5, r2, r0);
        return;
    L13:
        r5 = r11;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r1 = r8;
        goto L7
    }

    public final String a() {
        return this.f12568a;
    }

    public final long b() {
        return this.f12569b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final List<e> e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12568a, r10.f12568a) == true) goto L12;
        return false;
    L12:
        if (this.f12569b == r10.f12569b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f12568a.hashCode() * 31) + Long.hashCode(this.f12569b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "AIMediaEventEnvelopeDto(eventName=" + this.f12568a + ", sequenceNumber=" + this.f12569b + ", sessionId=" + this.c + ", reportedPackage=" + this.d + ", fields=" + this.e + ')';
    }
}
