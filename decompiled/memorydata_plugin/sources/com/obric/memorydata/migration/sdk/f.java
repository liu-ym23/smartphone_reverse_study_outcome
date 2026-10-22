package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/migration/sdk/CreateRequestParams;", "", "senderUid", "", "appVersionCode", "", "protocolVersion", "exportScope", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)V", "getSenderUid", "()Ljava/lang/String;", "getAppVersionCode", "()J", "getProtocolVersion", "getExportScope", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)Lcom/obric/memorydata/migration/sdk/CreateRequestParams;", "equals", "", "other", "hashCode", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11898b;
    private final String c;
    private final Integer d;

    public f(String r2, long r3, String r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "senderUid");
        Intrinsics.checkNotNullParameter(r5, "protocolVersion");
        this.f11897a = r2;
        this.f11898b = r3;
        this.c = r5;
        this.d = r6;
    }

    public /* synthetic */ f(String r7, long r8, String r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = "2";
    L5:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L8;
        r11 = null;
    L8:
        this(r7, r8, r4, r11);
    }

    public final String a() {
        return this.f11897a;
    }

    public final long b() {
        return this.f11898b;
    }

    public final String c() {
        return this.c;
    }

    public final Integer d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11897a, r10.f11897a) == true) goto L12;
        return false;
    L12:
        if (this.f11898b == r10.f11898b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f11897a.hashCode() * 31) + Long.hashCode(this.f11898b)) * 31) + this.c.hashCode()) * 31;
        Integer r3 = this.d;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "CreateRequestParams(senderUid=" + this.f11897a + ", appVersionCode=" + this.f11898b + ", protocolVersion=" + this.c + ", exportScope=" + this.d + ')';
    }
}
