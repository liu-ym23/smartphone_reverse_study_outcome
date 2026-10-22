package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "", "requestId", "", "pendingInspirationId", "", "stage", "Lcom/obric/aiproactive/ui/entry/StartupInspirationStage;", "<init>", "(JLjava/lang/String;Lcom/obric/aiproactive/ui/entry/StartupInspirationStage;)V", "getRequestId", "()J", "getPendingInspirationId", "()Ljava/lang/String;", "getStage", "()Lcom/obric/aiproactive/ui/entry/StartupInspirationStage;", "isIdle", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6603b;
    private final StartupInspirationStage c;

    public ac() {
        this(0, null, null, 7, null);
    }

    public ac(long r2, String r4, StartupInspirationStage r5) {
        Intrinsics.checkNotNullParameter(r5, "stage");
        this.f6602a = r2;
        this.f6603b = r4;
        this.c = r5;
    }

    public /* synthetic */ ac(long r1, String r3, StartupInspirationStage r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = StartupInspirationStage.IDLE;
    L11:
        this(r1, r3, r4);
    }

    public static /* synthetic */ ac a(ac r0, long r1, String r3, StartupInspirationStage r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f6602a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.f6603b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.c;
    L12:
        return r0.a(r1, r3, r4);
    }

    public final long a() {
        return this.f6602a;
    }

    public final ac a(long r1, String r3, StartupInspirationStage r4) {
        Intrinsics.checkNotNullParameter(r4, "stage");
        return new ac(r1, r3, r4);
    }

    public final String b() {
        return this.f6603b;
    }

    public final StartupInspirationStage c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ac.class) == true) goto L8;
        return false;
    L8:
        ac r10 = (ac) ZeusTransformUtils.preCheckCast(r9, ac.class, "com.obric.memorydata.plugin");
        if (this.f6602a == r10.f6602a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6603b, r10.f6603b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f6602a) * 31;
        String r1 = this.f6603b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "StartupInspirationCoordinatorState(requestId=" + this.f6602a + ", pendingInspirationId=" + this.f6603b + ", stage=" + this.c + ')';
    }
}
