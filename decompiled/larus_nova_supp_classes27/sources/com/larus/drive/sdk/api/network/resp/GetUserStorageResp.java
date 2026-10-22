package com.larus.drive.sdk.api.network.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/drive/sdk/api/network/resp/GetUserStorageResp;", "", "showSizeLimit", "", "totalSize", "", "usedSize", "<init>", "(ZJJ)V", "getShowSizeLimit", "()Z", "getTotalSize", "()J", "getUsedSize", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetUserStorageResp {

    @SerializedName("show_size_limit")
    private final boolean showSizeLimit;

    @SerializedName("total_size_limit_bytes")
    private final long totalSize;

    @SerializedName("used_size_bytes")
    private final long usedSize;

    public GetUserStorageResp() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ GetUserStorageResp copy$default(GetUserStorageResp r2, boolean r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.showSizeLimit;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.totalSize;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.usedSize;
    L11:
        boolean r5 = r3;
        return r2.copy(r5, r0, r6);
    }

    public final boolean component1() {
        return this.showSizeLimit;
    }

    public final long component2() {
        return this.totalSize;
    }

    public final long component3() {
        return this.usedSize;
    }

    public final GetUserStorageResp copy(boolean r8, long r9, long r11) {
        return new GetUserStorageResp(r8, r9, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof GetUserStorageResp) == true) goto L8;
        return false;
    L8:
        GetUserStorageResp r9 = (GetUserStorageResp) r8;
        if (this.showSizeLimit == r9.showSizeLimit) goto L12;
        return false;
    L12:
        if (this.totalSize == r9.totalSize) goto L15;
        return false;
    L15:
        if (this.usedSize == r9.usedSize) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.showSizeLimit == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.totalSize;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.usedSize;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "GetUserStorageResp(showSizeLimit=" + this.showSizeLimit + ", totalSize=" + this.totalSize + ", usedSize=" + this.usedSize + ')';
    }

    public final boolean getShowSizeLimit() {
        return this.showSizeLimit;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final long getUsedSize() {
        return this.usedSize;
    }

    public GetUserStorageResp(boolean r1, long r2, long r4) {
        this.showSizeLimit = r1;
        this.totalSize = r2;
        this.usedSize = r4;
    }

    public /* synthetic */ GetUserStorageResp(boolean r5, long r6, long r8, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r10 & 2) == 0) goto L8;
        long r2 = 0;
    L10:
        if ((r10 & 4) == 0) goto L12;
        long r12 = 0;
    L13:
        this(r5, r2, r12);
        return;
    L12:
        r12 = r8;
        goto L13
    L8:
        r2 = r6;
        goto L10
    }
}
