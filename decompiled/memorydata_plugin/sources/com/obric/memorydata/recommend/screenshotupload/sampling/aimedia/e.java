package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaEventFieldDto;", "", "key", "", "valueType", "", "stringValue", "longValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;J)V", "getKey", "()Ljava/lang/String;", "getValueType", "()I", "getStringValue", "getLongValue", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12571b;
    private final String c;
    private final long d;

    public e() {
        this(null, 0, null, 0, 15, null);
    }

    public e(String r2, int r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.f12570a = r2;
        this.f12571b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ e(String r4, int r5, String r6, long r7, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = null;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = 0;
    L14:
        String r8 = r4;
        this(r8, r11, r0, r7);
    }

    public final String a() {
        return this.f12570a;
    }

    public final int b() {
        return this.f12571b;
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
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
        return false;
    L8:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12570a, r8.f12570a) == true) goto L12;
        return false;
    L12:
        if (this.f12571b == r8.f12571b) goto L15;
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
        int r0 = ((this.f12570a.hashCode() * 31) + Integer.hashCode(this.f12571b)) * 31;
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
        return "AIMediaEventFieldDto(key=" + this.f12570a + ", valueType=" + this.f12571b + ", stringValue=" + this.c + ", longValue=" + this.d + ')';
    }
}
