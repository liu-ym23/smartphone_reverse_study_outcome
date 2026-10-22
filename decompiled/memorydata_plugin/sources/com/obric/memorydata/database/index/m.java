package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/DatabaseExecutionSettlement;", "Lcom/obric/memorydata/database/index/ExecutionSettlement;", "pendingDeleted", "", "observabilityApplied", "roundClosed", "firstCompletion", "Lcom/obric/memorydata/database/index/FirstCompletionMaterialization;", "<init>", "(ZZZLcom/obric/memorydata/database/index/FirstCompletionMaterialization;)V", "getPendingDeleted", "()Z", "getObservabilityApplied", "getRoundClosed", "getFirstCompletion", "()Lcom/obric/memorydata/database/index/FirstCompletionMaterialization;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class m implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9426b;
    private final boolean c;
    private final w d;

    public m(boolean r1, boolean r2, boolean r3, w r4) {
        this.f9425a = r1;
        this.f9426b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.obric.memorydata.database.index.v
    public boolean a() {
        return this.f9425a;
    }

    @Override // com.obric.memorydata.database.index.v
    public boolean b() {
        return this.c;
    }

    public final w c() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        if (this.f9425a == r6.f9425a) goto L12;
        return false;
    L12:
        if (this.f9426b == r6.f9426b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Boolean.hashCode(this.f9425a) * 31) + Boolean.hashCode(this.f9426b)) * 31) + Boolean.hashCode(this.c)) * 31;
        w r2 = this.d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DatabaseExecutionSettlement(pendingDeleted=" + this.f9425a + ", observabilityApplied=" + this.f9426b + ", roundClosed=" + this.c + ", firstCompletion=" + this.d + ')';
    }
}
