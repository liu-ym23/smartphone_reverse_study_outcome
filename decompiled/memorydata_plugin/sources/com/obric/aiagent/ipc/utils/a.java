package com.obric.aiagent.ipc.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyConfig;", "", "enabled", "", "slowCallThresholdMs", "", "frequentCallThresholdPerMinute", "", "reportLimitPerMinute", "<init>", "(ZJII)V", "getEnabled", "()Z", "getSlowCallThresholdMs", "()J", "getFrequentCallThresholdPerMinute", "()I", "getReportLimitPerMinute", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5942b;
    private final int c;
    private final int d;

    public a() {
        this(false, 0, 0, 0, 15, null);
    }

    public a(boolean r1, long r2, int r4, int r5) {
        this.f5941a = r1;
        this.f5942b = r2;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ a(boolean r4, long r5, int r7, int r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = true;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 200;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = 3000;
    L11:
        int r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = 60;
    L14:
        boolean r6 = r4;
        this(r6, r0, r11, r8);
    }

    public final boolean a() {
        return this.f5941a;
    }

    public final long b() {
        return this.f5942b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
        if (this.f5941a == r10.f5941a) goto L12;
        return false;
    L12:
        if (this.f5942b == r10.f5942b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f5941a) * 31) + Long.hashCode(this.f5942b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "IPCAnomalyConfig(enabled=" + this.f5941a + ", slowCallThresholdMs=" + this.f5942b + ", frequentCallThresholdPerMinute=" + this.c + ", reportLimitPerMinute=" + this.d + ')';
    }
}
