package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0000J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/HostConfig;", "Ljava/io/Serializable;", "hostType", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "bizDomainAlias", "constHosts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getHostType", "()Ljava/lang/String;", "setHostType", "(Ljava/lang/String;)V", "getBizDomainAlias", "setBizDomainAlias", "getConstHosts", "()Ljava/util/ArrayList;", "setConstHosts", "(Ljava/util/ArrayList;)V", "copy", "toString", "component1", "component2", "component3", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostConfig implements Serializable {
    private String bizDomainAlias;
    private ArrayList<String> constHosts;
    private String hostType;

    public HostConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostConfig copy$default(HostConfig r0, String r1, String r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.hostType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.bizDomainAlias;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.constHosts;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.hostType;
    }

    public final String component2() {
        return this.bizDomainAlias;
    }

    public final ArrayList<String> component3() {
        return this.constHosts;
    }

    public final HostConfig copy(String r2, String r3, ArrayList<String> r4) {
        return new HostConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HostConfig) == true) goto L8;
        return false;
    L8:
        HostConfig r6 = (HostConfig) r5;
        if (Intrinsics.areEqual(this.hostType, r6.hostType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizDomainAlias, r6.bizDomainAlias) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.constHosts, r6.constHosts) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.hostType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bizDomainAlias;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<String> r7 = this.constHosts;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final HostConfig copy() {
        String r0 = this.hostType;
        String r1 = this.bizDomainAlias;
        ArrayList<String> r2 = this.constHosts;
        if (r2 == null) goto L5;
        ArrayList r3 = new ArrayList(r2);
    L7:
        return new HostConfig(r0, r1, r3);
    L5:
        r3 = null;
        goto L7
    }

    public String toString() {
        return "HostConfig(hostType=" + this.hostType + ", bizDomainAlias=" + this.bizDomainAlias + ", constHosts=" + this.constHosts + ')';
    }

    public final String getBizDomainAlias() {
        return this.bizDomainAlias;
    }

    public final ArrayList<String> getConstHosts() {
        return this.constHosts;
    }

    public final String getHostType() {
        return this.hostType;
    }

    public final void setBizDomainAlias(String r1) {
        this.bizDomainAlias = r1;
    }

    public final void setConstHosts(ArrayList<String> r1) {
        this.constHosts = r1;
    }

    public final void setHostType(String r1) {
        this.hostType = r1;
    }

    public HostConfig(String r1, String r2, ArrayList<String> r3) {
        this.hostType = r1;
        this.bizDomainAlias = r2;
        this.constHosts = r3;
    }

    public /* synthetic */ HostConfig(String r2, String r3, ArrayList r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
