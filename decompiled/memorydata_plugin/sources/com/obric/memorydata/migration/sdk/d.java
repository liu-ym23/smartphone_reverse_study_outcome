package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ServerSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/migration/sdk/ConnectRequest;", "", "payload", "Lcom/obric/memorydata/migration/sdk/QrPayload;", "serverSocket", "Ljava/net/ServerSocket;", "<init>", "(Lcom/obric/memorydata/migration/sdk/QrPayload;Ljava/net/ServerSocket;)V", "getPayload", "()Lcom/obric/memorydata/migration/sdk/QrPayload;", "getServerSocket", "()Ljava/net/ServerSocket;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final QrPayload f11893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ServerSocket f11894b;

    public d(QrPayload r2, ServerSocket r3) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.f11893a = r2;
        this.f11894b = r3;
    }

    public /* synthetic */ d(QrPayload r1, ServerSocket r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final QrPayload a() {
        return this.f11893a;
    }

    public final ServerSocket b() {
        return this.f11894b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11893a, r6.f11893a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11894b, r6.f11894b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f11893a.hashCode() * 31;
        ServerSocket r1 = this.f11894b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ConnectRequest(payload=" + this.f11893a + ", serverSocket=" + this.f11894b + ')';
    }
}
