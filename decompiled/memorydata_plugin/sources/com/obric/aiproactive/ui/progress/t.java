package com.obric.aiproactive.ui.progress;

import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/progress/MobileUseNavigationAttempt;", "", "binding", "Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "<init>", "(Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;J)V", "getBinding", "()Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", "getGeneration", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f6847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6848b;

    public t(z r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.f6847a = r2;
        this.f6848b = r3;
    }

    public final z a() {
        return this.f6847a;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, t.class) == true) goto L8;
        return false;
    L8:
        t r8 = (t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6847a, r8.f6847a) == true) goto L12;
        return false;
    L12:
        if (this.f6848b == r8.f6848b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6847a.hashCode() * 31) + Long.hashCode(this.f6848b);
    }

    public String toString() {
        return "MobileUseNavigationAttempt(binding=" + this.f6847a + ", generation=" + this.f6848b + ')';
    }
}
