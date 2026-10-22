package com.obric.aiproactive.impl.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteDownloadResult;", "", "ok", "", "errorCode", "", "contentType", "sizeBytes", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;J)V", "getOk", "()Z", "getErrorCode", "()Ljava/lang/String;", "getContentType", "getSizeBytes", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6421b;
    private final String c;
    private final long d;

    public l(boolean r2, String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "errorCode");
        this.f6420a = r2;
        this.f6421b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ l(boolean r7, String r8, String r9, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = "";
    L5:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = null;
    L8:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L11;
        r10 = 0;
    L11:
        this(r7, r2, r3, r10);
    }

    public final boolean a() {
        return this.f6420a;
    }

    public final String b() {
        return this.f6421b;
    }

    public final String c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, l.class) == true) goto L8;
        return false;
    L8:
        l r8 = (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.memorydata.plugin");
        if (this.f6420a == r8.f6420a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6421b, r8.f6421b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r8.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.f6420a) * 31) + this.f6421b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "RemoteDownloadResult(ok=" + this.f6420a + ", errorCode=" + this.f6421b + ", contentType=" + this.c + ", sizeBytes=" + this.d + ')';
    }
}
