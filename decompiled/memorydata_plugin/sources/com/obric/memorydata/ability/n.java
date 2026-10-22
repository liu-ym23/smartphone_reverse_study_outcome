package com.obric.memorydata.ability;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003JV\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\t\u0010-\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/obric/memorydata/ability/SubscribeInfo;", "", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "dataReceiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "clientAbilityId", "", "serverAbilityId", "receiverKey", "", "requestType", "Lcom/obric/memorydata/ability/AbilityRequestType;", "refCount", "<init>", "(Lcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;Ljava/lang/Integer;ILjava/lang/String;Lcom/obric/memorydata/ability/AbilityRequestType;I)V", "getAbilityParams", "()Lcom/obric/memorydata/ability/AbilityParams;", "getDataReceiver", "()Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "getClientAbilityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getServerAbilityId", "()I", "getReceiverKey", "()Ljava/lang/String;", "getRequestType", "()Lcom/obric/memorydata/ability/AbilityRequestType;", "getRefCount", "setRefCount", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/memorydata/ability/AbilityParams;Lcom/obric/memorydata/ability/IAbilityDataReceiver;Ljava/lang/Integer;ILjava/lang/String;Lcom/obric/memorydata/ability/AbilityRequestType;I)Lcom/obric/memorydata/ability/SubscribeInfo;", "equals", "", "other", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f8421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f8422b;
    private final Integer c;
    private final int d;
    private final String e;
    private final AbilityRequestType f;
    private int g;

    public n(f r3, k r4, Integer r5, int r6, String r7, AbilityRequestType r8, int r9) {
        k r10 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Intrinsics.checkNotNullParameter(r10, "dataReceiver");
        Intrinsics.checkNotNullParameter(r7, "receiverKey");
        Intrinsics.checkNotNullParameter(r8, "requestType");
        this.f8421a = r3;
        this.f8422b = r10;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final f a() {
        return this.f8421a;
    }

    public final void a(int r1) {
        this.g = r1;
    }

    public final k b() {
        return this.f8422b;
    }

    public final Integer c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8421a, r6.f8421a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8422b, r6.f8422b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final AbilityRequestType f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public int hashCode() {
        int r0 = ((this.f8421a.hashCode() * 31) + this.f8422b.hashCode()) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((r0 + r2) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SubscribeInfo(abilityParams=" + this.f8421a + ", dataReceiver=" + this.f8422b + ", clientAbilityId=" + this.c + ", serverAbilityId=" + this.d + ", receiverKey=" + this.e + ", requestType=" + this.f + ", refCount=" + this.g + ')';
    }
}
