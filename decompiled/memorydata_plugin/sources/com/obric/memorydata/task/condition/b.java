package com.obric.memorydata.task.condition;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/task/condition/BaseCondition;", "", "<init>", "()V", "listener", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "getListener", "()Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "setListener", "(Lcom/obric/memorydata/task/condition/ConditionChangeListener;)V", "currentStatus", "", "getCurrentStatus", "()Z", "setCurrentStatus", "(Z)V", "register", "", "isSatisfied", "getUnsatisfiedReason", "", "setConditionChangeListener", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f12875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12876b;

    public b() {
    }

    public abstract void b();

    public final void b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.f12875a = r4;
    }

    public final void b(boolean r1) {
        this.f12876b = r1;
    }

    public abstract boolean c();

    public String g() {
        String r1 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "getSimpleName(...)");
        return r1;
    }

    public final d h() {
        return this.f12875a;
    }

    public final boolean i() {
        return this.f12876b;
    }
}
