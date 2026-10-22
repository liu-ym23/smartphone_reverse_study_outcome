package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JL\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006&"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "", "success", "", "code", "", "message", "", "requestId", "", "eventRecordId", "deduplicated", "<init>", "(ZILjava/lang/String;JLjava/lang/Long;Z)V", "getSuccess", "()Z", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getRequestId", "()J", "getEventRecordId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeduplicated", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZILjava/lang/String;JLjava/lang/Long;Z)Lcom/obric/aiproactive/api/AiProactiveUserRequirementResult;", "equals", "other", "hashCode", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6283b;
    private final String c;
    private final long d;
    private final Long e;
    private final boolean f;

    public z(boolean r2, int r3, String r4, long r5, Long r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "message");
        this.f6282a = r2;
        this.f6283b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }

    public /* synthetic */ z(boolean r10, int r11, String r12, long r13, Long r15, boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        Long r7 = null;
    L7:
        if ((r17 & 32) == 0) goto L9;
        boolean r8 = false;
    L10:
        this(r10, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r16;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }

    public final boolean a() {
        return this.f6282a;
    }

    public final int b() {
        return this.f6283b;
    }

    public final long c() {
        return this.d;
    }

    public final boolean d() {
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
        if (this.f6282a == r10.f6282a) goto L12;
        return false;
    L12:
        if (this.f6283b == r10.f6283b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Boolean.hashCode(this.f6282a) * 31) + Integer.hashCode(this.f6283b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31;
        Long r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.f);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AiProactiveUserRequirementResult(success=" + this.f6282a + ", code=" + this.f6283b + ", message=" + this.c + ", requestId=" + this.d + ", eventRecordId=" + this.e + ", deduplicated=" + this.f + ')';
    }
}
