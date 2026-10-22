package com.obric.memorydata.datatransport.utils;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.datatransport.manager.ExportFailureReason;
import com.obric.memorydata.datatransport.manager.ExportStatisticsCategory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/AttachmentExportEvent;", "", EventBody.KEY_CATEGORY, "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "succeeded", "", "failureReason", "Lcom/obric/memorydata/datatransport/manager/ExportFailureReason;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;ZLcom/obric/memorydata/datatransport/manager/ExportFailureReason;)V", "getCategory", "()Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "getSucceeded", "()Z", "getFailureReason", "()Lcom/obric/memorydata/datatransport/manager/ExportFailureReason;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExportStatisticsCategory f9827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9828b;
    private final ExportFailureReason c;

    public a(ExportStatisticsCategory r2, boolean r3, ExportFailureReason r4) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_CATEGORY);
        this.f9827a = r2;
        this.f9828b = r3;
        this.c = r4;
    }

    public final ExportStatisticsCategory a() {
        return this.f9827a;
    }

    public final boolean b() {
        return this.f9828b;
    }

    public final ExportFailureReason c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f9827a == r6.f9827a) goto L12;
        return false;
    L12:
        if (this.f9828b == r6.f9828b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f9827a.hashCode() * 31) + Boolean.hashCode(this.f9828b)) * 31;
        ExportFailureReason r2 = this.c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "AttachmentExportEvent(category=" + this.f9827a + ", succeeded=" + this.f9828b + ", failureReason=" + this.c + ')';
    }
}
