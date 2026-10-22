package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/entry/CollapseMeasurementDecision;", "", "action", "Lcom/obric/aiproactive/ui/entry/CollapseMeasurementAction;", "nextRetryCount", "", "<init>", "(Lcom/obric/aiproactive/ui/entry/CollapseMeasurementAction;I)V", "getAction", "()Lcom/obric/aiproactive/ui/entry/CollapseMeasurementAction;", "getNextRetryCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CollapseMeasurementAction f6610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6611b;

    public d(CollapseMeasurementAction r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.f6610a = r2;
        this.f6611b = r3;
    }

    public final CollapseMeasurementAction a() {
        return this.f6610a;
    }

    public final int b() {
        return this.f6611b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (this.f6610a == r6.f6610a) goto L12;
        return false;
    L12:
        if (this.f6611b == r6.f6611b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f6610a.hashCode() * 31) + Integer.hashCode(this.f6611b);
    }

    public String toString() {
        return "CollapseMeasurementDecision(action=" + this.f6610a + ", nextRetryCount=" + this.f6611b + ')';
    }
}
