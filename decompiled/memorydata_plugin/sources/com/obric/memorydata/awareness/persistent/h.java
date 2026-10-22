package com.obric.memorydata.awareness.persistent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscription;", "", "ownerPackage", "", "subscriptionId", "targetType", "targetName", "condition", "lastMatched", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getOwnerPackage", "()Ljava/lang/String;", "getSubscriptionId", "getTargetType", "getTargetName", "getCondition", "getLastMatched", "()Z", "targetKey", "callbackAuthority", "logKey", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8776b;
    private final String c;
    private final String d;
    private final String e;
    private final boolean f;

    public h(String r2, String r3, String r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "ownerPackage");
        Intrinsics.checkNotNullParameter(r3, "subscriptionId");
        Intrinsics.checkNotNullParameter(r4, "targetType");
        Intrinsics.checkNotNullParameter(r5, "targetName");
        Intrinsics.checkNotNullParameter(r6, "condition");
        this.f8775a = r2;
        this.f8776b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static /* synthetic */ h a(h r4, String r5, String r6, String r7, String r8, String r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f8775a;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.f8776b;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.c;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.d;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.e;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.f;
    L20:
        String r14 = r5;
        return r4.a(r14, r13, r0, r1, r2, r10);
    }

    public final h a(String r8, String r9, String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "ownerPackage");
        Intrinsics.checkNotNullParameter(r9, "subscriptionId");
        Intrinsics.checkNotNullParameter(r10, "targetType");
        Intrinsics.checkNotNullParameter(r11, "targetName");
        Intrinsics.checkNotNullParameter(r12, "condition");
        return new h(r8, r9, r10, r11, r12, r13);
    }

    public final String a() {
        return this.f8775a;
    }

    public final String b() {
        return this.f8776b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8775a, r6.f8775a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8776b, r6.f8776b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public final String g() {
        return this.c + '#' + this.d;
    }

    public final String h() {
        return this.f8775a + ".awareness.provider";
    }

    public int hashCode() {
        return (((((((((this.f8775a.hashCode() * 31) + this.f8776b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
    }

    public final String i() {
        return "owner=" + this.f8775a + " subscriptionId=" + this.f8776b + " target=" + this.c + '/' + this.d + " condition=" + this.e + " lastMatched=" + this.f;
    }

    public String toString() {
        return "PersistentAwarenessSubscription(ownerPackage=" + this.f8775a + ", subscriptionId=" + this.f8776b + ", targetType=" + this.c + ", targetName=" + this.d + ", condition=" + this.e + ", lastMatched=" + this.f + ')';
    }
}
