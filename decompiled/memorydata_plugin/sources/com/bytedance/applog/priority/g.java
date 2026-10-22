package com.bytedance.applog.priority;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/applog/priority/PriorityContext;", "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/applog/priority/PriorityConfig;", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "dbDir", "", "defaultReportHost", "defaultReportPath", "(Landroid/content/Context;Lcom/bytedance/applog/priority/PriorityConfig;Lcom/bytedance/applog/log/AbsLogger;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConfig", "()Lcom/bytedance/applog/priority/PriorityConfig;", "getContext", "()Landroid/content/Context;", "getDbDir", "()Ljava/lang/String;", "getDefaultReportHost", "getDefaultReportPath", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f1790b;
    private final com.bytedance.applog.log.a c;
    private final String d;
    private final String e;
    private final String f;

    public g(Context r3, e r4, com.bytedance.applog.log.a r5, String r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.log.a r10 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r10, "logger");
        Intrinsics.checkNotNullParameter(r6, "dbDir");
        Intrinsics.checkNotNullParameter(r7, "defaultReportHost");
        Intrinsics.checkNotNullParameter(r8, "defaultReportPath");
        this.f1789a = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.f1790b = r4;
        this.c = r10;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }

    public final e a() {
        return this.f1790b;
    }

    public final com.bytedance.applog.log.a b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f1789a, r6.f1789a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1790b, r6.f1790b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final Context getContext() {
        return this.f1789a;
    }

    public int hashCode() {
        return (((((((((this.f1789a.hashCode() * 31) + this.f1790b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "PriorityContext(context=" + this.f1789a + ", config=" + this.f1790b + ", logger=" + this.c + ", dbDir=" + this.d + ", defaultReportHost=" + this.e + ", defaultReportPath=" + this.f + ')';
    }
}
