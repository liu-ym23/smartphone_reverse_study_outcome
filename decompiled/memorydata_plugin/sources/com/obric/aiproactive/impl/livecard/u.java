package com.obric.aiproactive.impl.livecard;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ScheduledEntry;", "", "expireAtMs", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "receiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "(JLcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;)V", "getExpireAtMs", "()J", "getParams", "()Lcom/obric/memorydata/ability/AbilityParams;", "getReceiver", "()Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.ability.f f6489b;
    private final com.obric.memorydata.ability.k c;

    public u(long r3, com.obric.memorydata.ability.f r5, com.obric.memorydata.ability.k r6) {
        com.obric.memorydata.ability.k r7 = (com.obric.memorydata.ability.k) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        Intrinsics.checkNotNullParameter(r7, "receiver");
        this.f6488a = r3;
        this.f6489b = r5;
        this.c = r7;
    }

    public final long a() {
        return this.f6488a;
    }

    public final com.obric.memorydata.ability.f b() {
        return this.f6489b;
    }

    public final com.obric.memorydata.ability.k c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, u.class) == true) goto L8;
        return false;
    L8:
        u r10 = (u) ZeusTransformUtils.preCheckCast(r9, u.class, "com.obric.memorydata.plugin");
        if (this.f6488a == r10.f6488a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6489b, r10.f6489b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f6488a) * 31) + this.f6489b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ScheduledEntry(expireAtMs=" + this.f6488a + ", params=" + this.f6489b + ", receiver=" + this.c + ')';
    }
}
