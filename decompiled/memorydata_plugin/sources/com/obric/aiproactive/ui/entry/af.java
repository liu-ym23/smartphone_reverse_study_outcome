package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationTransition;", "", "state", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "decision", "Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "<init>", "(Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;)V", "getState", "()Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "getDecision", "()Lcom/obric/aiproactive/ui/entry/StartupInspirationDecision;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ac f6607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ae f6608b;

    public af(ac r3, ae r4) {
        ae r5 = (ae) ZeusTransformUtils.wrapperContextForParams(r4, ae.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r5, "decision");
        this.f6607a = r3;
        this.f6608b = r5;
    }

    public final ac a() {
        return this.f6607a;
    }

    public final ae b() {
        return this.f6608b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, af.class) == true) goto L8;
        return false;
    L8:
        af r6 = (af) ZeusTransformUtils.preCheckCast(r5, af.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6607a, r6.f6607a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6608b, r6.f6608b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6607a.hashCode() * 31) + this.f6608b.hashCode();
    }

    public String toString() {
        return "StartupInspirationTransition(state=" + this.f6607a + ", decision=" + this.f6608b + ')';
    }
}
