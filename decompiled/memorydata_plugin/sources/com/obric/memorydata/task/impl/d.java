package com.obric.memorydata.task.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/task/impl/MinuteTimeUnit;", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "long", "", "<init>", "(J)V", "getLong", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12931a;

    public d(long r2) {
        super(r2, TimeUnit.MINUTES);
        this.f12931a = r2;
    }

    @Override // com.obric.memorydata.task.impl.g
    public long a() {
        return this.f12931a;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
        return false;
    L8:
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        if (this.f12931a == r8.f12931a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.f12931a);
    }

    @Override // com.obric.memorydata.task.impl.g
    public String toString() {
        return "MinuteTimeUnit(long=" + this.f12931a + ')';
    }
}
