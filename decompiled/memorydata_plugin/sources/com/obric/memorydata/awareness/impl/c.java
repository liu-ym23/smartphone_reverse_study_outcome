package com.obric.memorydata.awareness.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessEventSubscription;", "", "type", "Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;", ActivityLifecycle.NAME, "", "<init>", "(Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;Ljava/lang/String;)V", "getType", "()Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AwarenessEventTriggerType f8636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8637b;

    public c(AwarenessEventTriggerType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.f8636a = r2;
        this.f8637b = r3;
    }

    public final String a() {
        return this.f8637b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (this.f8636a == r6.f8636a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8637b, r6.f8637b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final AwarenessEventTriggerType getType() {
        return this.f8636a;
    }

    public int hashCode() {
        return (this.f8636a.hashCode() * 31) + this.f8637b.hashCode();
    }

    public String toString() {
        return "AwarenessEventSubscription(type=" + this.f8636a + ", name=" + this.f8637b + ')';
    }
}
