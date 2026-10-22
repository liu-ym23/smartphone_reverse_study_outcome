package com.obric.memorydata.memory.auditory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/auditory/AuditorySyncConfig;", "", "enable", "", "screenOnScheduleIntervalSeconds", "", "screenOffScheduleIntervalSeconds", "screenOffChargingScheduleIntervalSeconds", "<init>", "(ZJJJ)V", "getEnable", "()Z", "getScreenOnScheduleIntervalSeconds", "()J", "getScreenOffScheduleIntervalSeconds", "getScreenOffChargingScheduleIntervalSeconds", "hasValidIntervals", "isOperational", "toTaskParams", "Lorg/json/JSONObject;", "drainOnly", "intervalSecondsFor", "state", "Lcom/obric/memorydata/memory/auditory/AuditoryDeviceState;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10075b;
    private final long c;
    private final long d;

    public f() {
        this(false, 0, 0, 0, 15, null);
    }

    public f(boolean r1, long r2, long r4, long r6) {
        this.f10074a = r1;
        this.f10075b = r2;
        this.c = r4;
        this.d = r6;
    }

    public /* synthetic */ f(boolean r5, long r6, long r8, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = true;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = 600;
    L8:
        long r0 = r6;
        if ((r12 & 4) == 0) goto L11;
        r8 = 1800;
    L11:
        long r2 = r8;
        if ((r12 & 8) == 0) goto L14;
        r10 = 1200;
    L14:
        boolean r7 = r5;
        this(r7, r0, r2, r10);
    }

    public final long a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (r2.a() == false) goto L6;
        return this.f10075b;
    L6:
        if (r2.b() == false) goto L9;
        return this.d;
    L9:
        return this.c;
    }

    public final JSONObject a(boolean r2) {
        JSONObject r1 = new JSONObject().put("drain_only", r2);
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        return r1;
    }

    public final boolean a() {
        if (this.f10075b > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.c <= 0) goto L9;
        if (this.d <= 0) goto L9;
        return true;
    }

    public final boolean b() {
        if (this.f10074a == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == false) goto L7;
        return true;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f10074a == r10.f10074a) goto L12;
        return false;
    L12:
        if (this.f10075b == r10.f10075b) goto L15;
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
        return (((((Boolean.hashCode(this.f10074a) * 31) + Long.hashCode(this.f10075b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "AuditorySyncConfig(enable=" + this.f10074a + ", screenOnScheduleIntervalSeconds=" + this.f10075b + ", screenOffScheduleIntervalSeconds=" + this.c + ", screenOffChargingScheduleIntervalSeconds=" + this.d + ')';
    }
}
