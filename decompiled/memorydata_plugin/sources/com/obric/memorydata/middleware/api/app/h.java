package com.obric.memorydata.middleware.api.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisiteResult;", "", "ready", "", "requiresProcessRestart", "<init>", "(ZZ)V", "getReady", "()Z", "getRequiresProcessRestart", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11603b;

    public h(boolean r1, boolean r2) {
        this.f11602a = r1;
        this.f11603b = r2;
    }

    public final boolean a() {
        return this.f11602a;
    }

    public final boolean b() {
        return this.f11603b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.f11602a == r6.f11602a) goto L12;
        return false;
    L12:
        if (this.f11603b == r6.f11603b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f11602a) * 31) + Boolean.hashCode(this.f11603b);
    }

    public String toString() {
        return "TaskControllerPrerequisiteResult(ready=" + this.f11602a + ", requiresProcessRestart=" + this.f11603b + ')';
    }
}
