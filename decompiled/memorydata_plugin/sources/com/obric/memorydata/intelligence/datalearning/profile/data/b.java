package com.obric.memorydata.intelligence.datalearning.profile.data;

import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0004J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/data/MidProfile;", "", "labelMap", "", "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "", "timestamp", "", "<init>", "(Ljava/util/Map;J)V", "getLabelMap", "()Ljava/util/Map;", "getTimestamp", "()J", "setTimestamp", "(J)V", "getLabelOriginVal", AnnotatedPrivateKey.LABEL, "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<ProfileLabel, String> f9961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9962b;

    public b(Map<ProfileLabel, String> r3, long r4) {
        Map<ProfileLabel, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "labelMap");
        this.f9961a = r5;
        this.f9962b = r4;
    }

    public final Map<ProfileLabel, String> a() {
        return this.f9961a;
    }

    public final long b() {
        return this.f9962b;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
        return false;
    L8:
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9961a, r8.f9961a) == true) goto L12;
        return false;
    L12:
        if (this.f9962b == r8.f9962b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f9961a.hashCode() * 31) + Long.hashCode(this.f9962b);
    }

    public String toString() {
        return "MidProfile(labelMap=" + this.f9961a + ", timestamp=" + this.f9962b + ')';
    }
}
