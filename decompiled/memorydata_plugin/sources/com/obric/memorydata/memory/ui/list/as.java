package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationConfig;", "", "enabled", "", "minCount", "", "intervalSeconds", "", "startHour", "endHour", "<init>", "(ZIJII)V", "getEnabled", "()Z", "getMinCount", "()I", "getIntervalSeconds", "()J", "getStartHour", "getEndHour", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11207b;
    private final long c;
    private final int d;
    private final int e;

    public as() {
        this(false, 0, 0, 0, 0, 31, null);
    }

    public as(boolean r1, int r2, long r3, int r5, int r6) {
        this.f11206a = r1;
        this.f11207b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ as(boolean r5, int r6, long r7, int r9, int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = 5;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = 432000;
    L11:
        long r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r9 = 10;
    L14:
        int r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = 22;
    L17:
        boolean r8 = r5;
        this(r8, r13, r0, r2, r10);
    }

    public final boolean a() {
        return this.f11206a;
    }

    public final int b() {
        return this.f11207b;
    }

    public final long c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, as.class) == true) goto L8;
        return false;
    L8:
        as r10 = (as) ZeusTransformUtils.preCheckCast(r9, as.class, "com.obric.memorydata.plugin");
        if (this.f11206a == r10.f11206a) goto L12;
        return false;
    L12:
        if (this.f11207b == r10.f11207b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f11206a) * 31) + Integer.hashCode(this.f11207b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "PendingPersonalInfoNotificationConfig(enabled=" + this.f11206a + ", minCount=" + this.f11207b + ", intervalSeconds=" + this.c + ", startHour=" + this.d + ", endHour=" + this.e + ')';
    }
}
