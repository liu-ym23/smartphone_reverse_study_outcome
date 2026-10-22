package com.bytedance.applog.priority;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\b\u0010%\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/bytedance/applog/priority/PriorityConfig;", "", "appId", "", "defaultReportUrl", "logEnabled", "", "eventUidEnabled", "encryptable", "priorityCallback", "Lcom/bytedance/applog/priority/PriorityCallback;", "eventMetaFactory", "Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "(Ljava/lang/String;Ljava/lang/String;ZZZLcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/priority/PriorityEventMetaFactory;)V", "getAppId", "()Ljava/lang/String;", "getDefaultReportUrl", "getEncryptable", "()Z", "getEventMetaFactory", "()Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "getEventUidEnabled", "getLogEnabled", "getPriorityCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1786b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final PriorityCallback f;
    private final PriorityEventMetaFactory g;

    public e(String r3, String r4, boolean r5, boolean r6, boolean r7, PriorityCallback r8, PriorityEventMetaFactory r9) {
        PriorityCallback r10 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r8, PriorityCallback.class, "com.obric.memorydata.plugin");
        PriorityEventMetaFactory r11 = (PriorityEventMetaFactory) ZeusTransformUtils.wrapperContextForParams(r9, PriorityEventMetaFactory.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "defaultReportUrl");
        Intrinsics.checkNotNullParameter(r10, "priorityCallback");
        Intrinsics.checkNotNullParameter(r11, "eventMetaFactory");
        this.f1785a = r3;
        this.f1786b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r10;
        this.g = r11;
    }

    public final String a() {
        return this.f1785a;
    }

    public final String b() {
        return this.f1786b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f1785a, r6.f1785a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1786b, r6.f1786b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final PriorityCallback f() {
        return this.f;
    }

    public final PriorityEventMetaFactory g() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = ((this.f1785a.hashCode() * 31) + this.f1786b.hashCode()) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.d;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.e;
        if (r8 == true) goto L13;
        r2 = r8;
    L13:
        return ((((r7 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "PriorityConfig(appId='" + this.f1785a + "', defaultReportUrl='" + this.f1786b + "', logEnabled=" + this.c + ", eventUidEnabled=" + this.d + ", encryptable=" + this.e + ')';
    }
}
