package com.ss.android.lark.conditional.access.auth.v2.service;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/service/IPConfig;", BuildConfig.FLAVOR, "ipConfigInfo", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Ljava/util/Map;)V", "getIpConfigInfo", "()Ljava/util/Map;", "component1", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IPConfig {
    private final Map<String, Boolean> ipConfigInfo;

    public IPConfig() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IPConfig copy$default(IPConfig r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.ipConfigInfo;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, Boolean> component1() {
        return this.ipConfigInfo;
    }

    public final IPConfig copy(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "ipConfigInfo");
        return new IPConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof IPConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.ipConfigInfo, ((IPConfig) r4).ipConfigInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.ipConfigInfo.hashCode();
    }

    public String toString() {
        return "IPConfig(ipConfigInfo=" + this.ipConfigInfo + ')';
    }

    public final Map<String, Boolean> getIpConfigInfo() {
        return this.ipConfigInfo;
    }

    public IPConfig(Map<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "ipConfigInfo");
        this.ipConfigInfo = r2;
    }

    public /* synthetic */ IPConfig(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new HashMap();
    L5:
        this(r1);
    }
}
