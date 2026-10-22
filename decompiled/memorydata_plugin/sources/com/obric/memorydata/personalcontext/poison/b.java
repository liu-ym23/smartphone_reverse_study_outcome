package com.obric.memorydata.personalcontext.poison;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J4\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelBatch;", "", "labelVersion", "", "operations", "", "Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelOperation;", "invalidOperationCount", "<init>", "(Ljava/lang/Integer;Ljava/util/List;I)V", "getLabelVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOperations", "()Ljava/util/List;", "getInvalidOperationCount", "()I", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;I)Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelBatch;", "equals", "", "other", "hashCode", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f12246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f12247b;
    private final int c;

    public b(Integer r3, List<c> r4, int r5) {
        List<c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "operations");
        this.f12246a = r3;
        this.f12247b = r6;
        this.c = r5;
    }

    public final Integer a() {
        return this.f12246a;
    }

    public final List<c> b() {
        return this.f12247b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12246a, r6.f12246a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12247b, r6.f12247b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f12246a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.f12247b.hashCode()) * 31) + Integer.hashCode(this.c);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "EntityPoisonLabelBatch(labelVersion=" + this.f12246a + ", operations=" + this.f12247b + ", invalidOperationCount=" + this.c + ')';
    }
}
