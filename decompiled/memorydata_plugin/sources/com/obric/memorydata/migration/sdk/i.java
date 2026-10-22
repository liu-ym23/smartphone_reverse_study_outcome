package com.obric.memorydata.migration.sdk;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/migration/sdk/KvKey;", "", ActivityLifecycle.NAME, "", "type", "Lcom/obric/memorydata/migration/sdk/KvValueType;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/migration/sdk/KvValueType;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/obric/memorydata/migration/sdk/KvValueType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KvValueType f11903b;

    public i(String r2, KvValueType r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "type");
        this.f11902a = r2;
        this.f11903b = r3;
    }

    public final String a() {
        return this.f11902a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11902a, r6.f11902a) == true) goto L12;
        return false;
    L12:
        if (this.f11903b == r6.f11903b) goto L14;
        return false;
    L14:
        return true;
    }

    public final KvValueType getType() {
        return this.f11903b;
    }

    public int hashCode() {
        return (this.f11902a.hashCode() * 31) + this.f11903b.hashCode();
    }

    public String toString() {
        return "KvKey(name=" + this.f11902a + ", type=" + this.f11903b + ')';
    }
}
