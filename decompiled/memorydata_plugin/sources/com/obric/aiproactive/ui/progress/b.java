package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunControlsUi;", "", "visible", "", "statusAction", "Lcom/obric/aiproactive/ui/progress/AgentRunStatusAction;", "<init>", "(ZLcom/obric/aiproactive/ui/progress/AgentRunStatusAction;)V", "getVisible", "()Z", "getStatusAction", "()Lcom/obric/aiproactive/ui/progress/AgentRunStatusAction;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AgentRunStatusAction f6802b;

    public b(boolean r2, AgentRunStatusAction r3) {
        Intrinsics.checkNotNullParameter(r3, "statusAction");
        this.f6801a = r2;
        this.f6802b = r3;
    }

    public final boolean a() {
        return this.f6801a;
    }

    public final AgentRunStatusAction b() {
        return this.f6802b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f6801a == r6.f6801a) goto L12;
        return false;
    L12:
        if (this.f6802b == r6.f6802b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f6801a) * 31) + this.f6802b.hashCode();
    }

    public String toString() {
        return "AgentRunControlsUi(visible=" + this.f6801a + ", statusAction=" + this.f6802b + ')';
    }
}
