package com.obric.memorydata.database.index;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0003\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/index/DatabasePendingMutationResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/index/PendingMutationResult;", "businessResult", "observabilityApplied", "", "replayReceipt", "Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "<init>", "(Ljava/lang/Object;ZLcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;)V", "getBusinessResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getObservabilityApplied", "()Z", "getReplayReceipt", "()Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;ZLcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;)Lcom/obric/memorydata/database/index/DatabasePendingMutationResult;", "equals", "other", "", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class n<T> implements az<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f9427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9428b;
    private final ba c;

    public n(T r3, boolean r4, ba r5) {
        ba r6 = (ba) ZeusTransformUtils.wrapperContextForParams(r5, ba.class, "com.obric.memorydata.plugin");
        this.f9427a = r3;
        this.f9428b = r4;
        this.c = r6;
    }

    public /* synthetic */ n(Object r2, boolean r3, ba r4, int r5, DefaultConstructorMarker r6) {
        ba r7 = (ba) ZeusTransformUtils.wrapperContextForParams(r4, ba.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r3, r7);
    }

    @Override // com.obric.memorydata.database.index.az
    public T a() {
        return this.f9427a;
    }

    @Override // com.obric.memorydata.database.index.az
    public ba b() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9427a, r6.f9427a) == true) goto L12;
        return false;
    L12:
        if (this.f9428b == r6.f9428b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        T r0 = this.f9427a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Boolean.hashCode(this.f9428b)) * 31;
        ba r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DatabasePendingMutationResult(businessResult=" + this.f9427a + ", observabilityApplied=" + this.f9428b + ", replayReceipt=" + this.c + ')';
    }
}
