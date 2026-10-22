package com.obric.memorydata.dc;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/dc/PageContextHandle;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "deferred", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/memorydata/dc/PageContextResult;", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/Deferred;)V", "getSessionId", "()Ljava/lang/String;", "getDeferred", "()Lkotlinx/coroutines/Deferred;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "deep_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ar<PageContextResult> f9847b;

    public a(String r3, ar<PageContextResult> r4) {
        ar<PageContextResult> r5 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r5, "deferred");
        this.f9846a = r3;
        this.f9847b = r5;
    }

    public final ar<PageContextResult> a() {
        return this.f9847b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9846a, r6.f9846a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9847b, r6.f9847b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f9846a.hashCode() * 31) + this.f9847b.hashCode();
    }

    public String toString() {
        return "PageContextHandle(sessionId=" + this.f9846a + ", deferred=" + this.f9847b + ')';
    }
}
