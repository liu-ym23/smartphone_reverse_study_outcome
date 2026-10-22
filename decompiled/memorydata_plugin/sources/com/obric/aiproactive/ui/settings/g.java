package com.obric.aiproactive.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J.\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchUpdateResult;", "", "enabled", "", "applied", "changed", "<init>", "(Ljava/lang/Boolean;ZZ)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApplied", "()Z", "getChanged", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;ZZ)Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchUpdateResult;", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f6861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6862b;
    private final boolean c;

    public g(Boolean r1, boolean r2, boolean r3) {
        this.f6861a = r1;
        this.f6862b = r2;
        this.c = r3;
    }

    public final Boolean a() {
        return this.f6861a;
    }

    public final boolean b() {
        return this.f6862b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6861a, r6.f6861a) == true) goto L12;
        return false;
    L12:
        if (this.f6862b == r6.f6862b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.f6861a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + Boolean.hashCode(this.f6862b)) * 31) + Boolean.hashCode(this.c);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ProactiveFeatureSwitchUpdateResult(enabled=" + this.f6861a + ", applied=" + this.f6862b + ", changed=" + this.c + ')';
    }
}
