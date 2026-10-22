package com.obric.memorydata.ability;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JB\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/memorydata/ability/SubscribeRequest;", "", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "dataReceiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "clientAbilityId", "", "serverAbilityId", "requestType", "Lcom/obric/memorydata/ability/AbilityRequestType;", "<init>", "(Lcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;Ljava/lang/Integer;ILcom/obric/memorydata/ability/AbilityRequestType;)V", "getAbilityParams", "()Lcom/obric/memorydata/ability/AbilityParams;", "getDataReceiver", "()Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "getClientAbilityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getServerAbilityId", "()I", "getRequestType", "()Lcom/obric/memorydata/ability/AbilityRequestType;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;Ljava/lang/Integer;ILcom/obric/memorydata/ability/AbilityRequestType;)Lcom/obric/memorydata/ability/SubscribeRequest;", "equals", "", "other", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f8423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f8424b;
    private final Integer c;
    private final int d;
    private final AbilityRequestType e;

    public o(f r3, k r4, Integer r5, int r6, AbilityRequestType r7) {
        k r8 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Intrinsics.checkNotNullParameter(r8, "dataReceiver");
        Intrinsics.checkNotNullParameter(r7, "requestType");
        this.f8423a = r3;
        this.f8424b = r8;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public final f a() {
        return this.f8423a;
    }

    public final k b() {
        return this.f8424b;
    }

    public final Integer c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final AbilityRequestType e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8423a, r6.f8423a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8424b, r6.f8424b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f8423a.hashCode() * 31) + this.f8424b.hashCode()) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SubscribeRequest(abilityParams=" + this.f8423a + ", dataReceiver=" + this.f8424b + ", clientAbilityId=" + this.c + ", serverAbilityId=" + this.d + ", requestType=" + this.e + ')';
    }
}
