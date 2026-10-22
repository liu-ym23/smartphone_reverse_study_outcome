package com.obric.memorydata.memory.auditory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/auditory/AuditoryNetworkPolicyState;", "", "networkAvailable", "", "wifiConnected", "cellularUploadEnabled", "<init>", "(ZZZ)V", "getNetworkAvailable", "()Z", "getWifiConnected", "getCellularUploadEnabled", "allowsUpload", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10068b;
    private final boolean c;

    public b(boolean r1, boolean r2, boolean r3) {
        this.f10067a = r1;
        this.f10068b = r2;
        this.c = r3;
    }

    public static /* synthetic */ b a(b r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f10067a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f10068b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final b a(boolean r1, boolean r2, boolean r3) {
        return new b(r1, r2, r3);
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        if (this.f10067a == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f10068b == false) goto L7;
    L8:
        return true;
    L7:
        if (this.c == false) goto L9;
        goto L8
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f10067a == r6.f10067a) goto L12;
        return false;
    L12:
        if (this.f10068b == r6.f10068b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f10067a) * 31) + Boolean.hashCode(this.f10068b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "AuditoryNetworkPolicyState(networkAvailable=" + this.f10067a + ", wifiConnected=" + this.f10068b + ", cellularUploadEnabled=" + this.c + ')';
    }
}
