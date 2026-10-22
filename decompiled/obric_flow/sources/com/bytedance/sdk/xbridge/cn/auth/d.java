package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AuthBridgeAccess f7339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set f7340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f7341c;
    public int d;
    public Map e;
    public String f;
    public FeAuthConfigSource g;

    public d(int r10) {
        AuthBridgeAccess r5 = AuthBridgeAccess.f7302c;
        FeAuthConfigSource r11 = FeAuthConfigSource.f7328c;
        Set r12 = SetsKt.emptySet();
        Set r13 = SetsKt.emptySet();
        Map r14 = MapsKt.emptyMap();
        if ((r10 & 64) == 0) goto L5;
        r11 = FeAuthConfigSource.d;
    L5:
        Intrinsics.checkNotNullParameter(r5, "access");
        Intrinsics.checkNotNullParameter(r12, "includedMethods");
        Intrinsics.checkNotNullParameter(r13, "excludedMethods");
        Intrinsics.checkNotNullParameter(r14, "methodCallLimits");
        Intrinsics.checkNotNullParameter("0", "feId");
        Intrinsics.checkNotNullParameter(r11, "source");
        this.f7339a = r5;
        this.f7340b = r12;
        this.f7341c = r13;
        this.d = 0;
        this.e = r14;
        this.f = "0";
        this.g = r11;
    }

    public final void a(String r5, li.a r10, FeAuthConfigSource r11) {
        Intrinsics.checkNotNullParameter(r5, "authFeId");
        Intrinsics.checkNotNullParameter(r11, "updateSource");
        this.f = r5;
        this.f7339a = r10.d;
        this.f7340b = CollectionsKt.toSet(r10.e);
        this.f7341c = CollectionsKt.toSet(r10.f);
        this.d = r10.f19636h;
        this.e = r10.g;
        this.g = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        if (this.f7339a == r10.f7339a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7340b, r10.f7340b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f7341c, r10.f7341c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f7339a.hashCode() * 31;
        int r10 = (this.f7340b.hashCode() + r5) * 31;
        int r11 = (this.f7341c.hashCode() + r10) * 31;
        int r12 = k5.d.a(this.d, r11);
        int r13 = (this.e.hashCode() + r12) * 31;
        int r14 = kk.a.b(this.f, r13, 31);
        return this.g.hashCode() + r14;
    }

    public final String toString() {
        return "FeAuthConfig(access=" + this.f7339a + ", includedMethods=" + this.f7340b + ", excludedMethods=" + this.f7341c + ", secureAuthVersion=" + this.d + ", methodCallLimits=" + this.e + ", feId=" + this.f + ", source=" + this.g + ')';
    }
}
