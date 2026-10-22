package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/PendingDashboardReport;", "", "windowStartUtcMs", "", "payloads", "", "Lorg/json/JSONObject;", "progress", "Lcom/obric/memorydata/database/index/IndexDashboardReportProgress;", "<init>", "(JLjava/util/List;Lcom/obric/memorydata/database/index/IndexDashboardReportProgress;)V", "getWindowStartUtcMs", "()J", "getPayloads", "()Ljava/util/List;", "getProgress", "()Lcom/obric/memorydata/database/index/IndexDashboardReportProgress;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<JSONObject> f9391b;
    private final am c;

    public aw(long r3, List<? extends JSONObject> r5, am r6) {
        List<JSONObject> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        Intrinsics.checkNotNullParameter(r6, "progress");
        this.f9390a = r3;
        this.f9391b = r7;
        this.c = r6;
    }

    public /* synthetic */ aw(long r2, List r4, am r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L5;
        r5 = new am();
    L5:
        this(r2, r8, r5);
    }

    public final long a() {
        return this.f9390a;
    }

    public final List<JSONObject> b() {
        return this.f9391b;
    }

    public final am c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aw.class) == true) goto L8;
        return false;
    L8:
        aw r10 = (aw) ZeusTransformUtils.preCheckCast(r9, aw.class, "com.obric.memorydata.plugin");
        if (this.f9390a == r10.f9390a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9391b, r10.f9391b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f9390a) * 31) + this.f9391b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PendingDashboardReport(windowStartUtcMs=" + this.f9390a + ", payloads=" + this.f9391b + ", progress=" + this.c + ')';
    }
}
