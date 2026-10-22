package com.obric.memorydata.memory.review.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewServerResponse;", "", "success", "", "message", "", "code", "", "data", "logId", "<init>", "(ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getCode", "()I", "getData", "getLogId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10418b;
    private final int c;
    private final String d;
    private final String e;

    public am(boolean r2, String r3, int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "logId");
        this.f10417a = r2;
        this.f10418b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ am(boolean r7, String r8, int r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = -1;
    L5:
        int r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        String r4 = "";
    L10:
        if ((r12 & 16) == 0) goto L12;
        String r5 = "";
    L13:
        this(r7, r8, r3, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }

    public final boolean a() {
        return this.f10417a;
    }

    public final String b() {
        return this.f10418b;
    }

    public final int c() {
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
        if (ZeusTransformUtils.instanceOf(r5, am.class) == true) goto L8;
        return false;
    L8:
        am r6 = (am) ZeusTransformUtils.preCheckCast(r5, am.class, "com.obric.memorydata.plugin");
        if (this.f10417a == r6.f10417a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10418b, r6.f10418b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f10417a) * 31) + this.f10418b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "MemoryReviewServerResponse(success=" + this.f10417a + ", message=" + this.f10418b + ", code=" + this.c + ", data=" + this.d + ", logId=" + this.e + ')';
    }
}
