package com.larus.account.saas.core.internal.network;

import b48.j;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "", "Lb48/j;", "toAvatarInfo", "", "component1", "component2", "component3", "uri", "tinyUrl", "originUrl", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "getTinyUrl", "getOriginUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class NetworkAvatarInfo {

    @SerializedName("origin_url")
    private final String originUrl;

    @SerializedName("tiny_url")
    private final String tinyUrl;

    @SerializedName("uri")
    private final String uri;

    public NetworkAvatarInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NetworkAvatarInfo copy$default(NetworkAvatarInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.uri;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.tinyUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.originUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.tinyUrl;
    }

    public final String component3() {
        return this.originUrl;
    }

    public final NetworkAvatarInfo copy(String r2, String r3, String r4) {
        return new NetworkAvatarInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NetworkAvatarInfo) == true) goto L8;
        return false;
    L8:
        NetworkAvatarInfo r6 = (NetworkAvatarInfo) r5;
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tinyUrl, r6.tinyUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originUrl, r6.originUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.uri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.tinyUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.originUrl;
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

    public String toString() {
        return "NetworkAvatarInfo(uri=" + this.uri + ", tinyUrl=" + this.tinyUrl + ", originUrl=" + this.originUrl + ')';
    }

    public final j toAvatarInfo() {
        return new j(this.uri, this.tinyUrl, this.originUrl);
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getTinyUrl() {
        return this.tinyUrl;
    }

    public final String getUri() {
        return this.uri;
    }

    public NetworkAvatarInfo(String r1, String r2, String r3) {
        this.uri = r1;
        this.tinyUrl = r2;
        this.originUrl = r3;
    }

    public /* synthetic */ NetworkAvatarInfo(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
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
