package com.obric.memorydata.personalcontext.task;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;", "", "pending", "", "syncDonateApp", "<init>", "(ZZ)V", "getPending", "()Z", "getSyncDonateApp", Ext.KEY_REQUEST, "completeIfSameAs", "expected", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0661a f12353a = null;
    private static final a d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12354b;
    private final boolean c;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.task.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;", "getEMPTY", "()Lcom/obric/memorydata/personalcontext/task/EntityConsistencyRecoveryDemand;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0661a {
        private C0661a() {
        }

        public /* synthetic */ C0661a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12353a = new C0661a(null);
        d = new a(false, false);
    }

    public a(boolean r1, boolean r2) {
        this.f12354b = r1;
        this.c = r2;
    }

    public final a a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "expected");
        if (Intrinsics.areEqual(this, r2) == true) goto L5;
        return this;
    L5:
        return a(false, false);
    }

    public final a a(boolean r3) {
        if (this.c == true) goto L7;
        if (r3 == true) goto L7;
        boolean r4 = false;
    L9:
        return a(true, r4);
    L7:
        r4 = true;
        goto L9
    }

    public final a a(boolean r1, boolean r2) {
        return new a(r1, r2);
    }

    public final boolean a() {
        return this.f12354b;
    }

    public final boolean b() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f12354b == r6.f12354b) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f12354b) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "EntityConsistencyRecoveryDemand(pending=" + this.f12354b + ", syncDonateApp=" + this.c + ')';
    }
}
