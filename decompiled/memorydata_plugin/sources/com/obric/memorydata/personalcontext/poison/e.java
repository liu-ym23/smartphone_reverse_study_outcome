package com.obric.memorydata.personalcontext.poison;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelUpdateResult;", "", "updatedCount", "", "skippedCount", "<init>", "(II)V", "getUpdatedCount", "()I", "getSkippedCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12252b;

    public e(int r1, int r2) {
        this.f12251a = r1;
        this.f12252b = r2;
    }

    public final int a() {
        return this.f12251a;
    }

    public final int b() {
        return this.f12252b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f12251a == r6.f12251a) goto L12;
        return false;
    L12:
        if (this.f12252b == r6.f12252b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f12251a) * 31) + Integer.hashCode(this.f12252b);
    }

    public String toString() {
        return "EntityPoisonLabelUpdateResult(updatedCount=" + this.f12251a + ", skippedCount=" + this.f12252b + ')';
    }
}
