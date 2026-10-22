package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportWarning;", "", "tableName", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTableName", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9803b;

    public v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tableName");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.f9802a = r2;
        this.f9803b = r3;
    }

    public final String a() {
        return this.f9802a;
    }

    public final String b() {
        return this.f9803b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, v.class) == true) goto L8;
        return false;
    L8:
        v r6 = (v) ZeusTransformUtils.preCheckCast(r5, v.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9802a, r6.f9802a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9803b, r6.f9803b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f9802a.hashCode() * 31) + this.f9803b.hashCode();
    }

    public String toString() {
        return "ExportWarning(tableName=" + this.f9802a + ", message=" + this.f9803b + ')';
    }
}
