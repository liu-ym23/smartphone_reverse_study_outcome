package com.obric.memorydata.memory.ui.automemory.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/RuleAuditDecision;", "", "passed", "", "message", "", "<init>", "(ZLjava/lang/String;)V", "getPassed", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10764b;

    public j(boolean r1, String r2) {
        this.f10763a = r1;
        this.f10764b = r2;
    }

    public /* synthetic */ j(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final boolean a() {
        return this.f10763a;
    }

    public final String b() {
        return this.f10764b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (this.f10763a == r6.f10763a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10764b, r6.f10764b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f10763a) * 31;
        String r1 = this.f10764b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "RuleAuditDecision(passed=" + this.f10763a + ", message=" + this.f10764b + ')';
    }
}
