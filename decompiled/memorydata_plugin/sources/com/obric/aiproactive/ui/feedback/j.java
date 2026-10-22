package com.obric.aiproactive.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueRating;", "", "amount", "", "amountSource", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueAmountSource;", "targetType", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueTargetType;", "updatedAtMillis", "", "<init>", "(ILcom/obric/aiproactive/ui/feedback/ProactiveValueAmountSource;Lcom/obric/aiproactive/ui/feedback/ProactiveValueTargetType;J)V", "getAmount", "()I", "getAmountSource", "()Lcom/obric/aiproactive/ui/feedback/ProactiveValueAmountSource;", "getTargetType", "()Lcom/obric/aiproactive/ui/feedback/ProactiveValueTargetType;", "getUpdatedAtMillis", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProactiveValueAmountSource f6664b;
    private final ProactiveValueTargetType c;
    private final long d;

    public j(int r2, ProactiveValueAmountSource r3, ProactiveValueTargetType r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "amountSource");
        Intrinsics.checkNotNullParameter(r4, "targetType");
        this.f6663a = r2;
        this.f6664b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final int a() {
        return this.f6663a;
    }

    public final ProactiveValueAmountSource b() {
        return this.f6664b;
    }

    public final ProactiveValueTargetType c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, j.class) == true) goto L8;
        return false;
    L8:
        j r8 = (j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.memorydata.plugin");
        if (this.f6663a == r8.f6663a) goto L12;
        return false;
    L12:
        if (this.f6664b == r8.f6664b) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L18;
        return false;
    L18:
        if (this.d == r8.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f6663a) * 31) + this.f6664b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "ProactiveValueRating(amount=" + this.f6663a + ", amountSource=" + this.f6664b + ", targetType=" + this.c + ", updatedAtMillis=" + this.d + ')';
    }
}
