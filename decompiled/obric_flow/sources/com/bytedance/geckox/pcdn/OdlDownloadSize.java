package com.bytedance.geckox.pcdn;

import ai.j0;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/geckox/pcdn/OdlDownloadSize;", "", "p2pSize", "", "cdnSize", "(JJ)V", "getCdnSize", "()J", "getP2pSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
final class OdlDownloadSize {

    @SerializedName("cdn_size")
    private final long cdnSize;

    @SerializedName("p2p_size")
    private final long p2pSize;

    public OdlDownloadSize(long r5, long r10) {
        this.p2pSize = r5;
        this.cdnSize = r10;
    }

    public static /* synthetic */ OdlDownloadSize copy$default(OdlDownloadSize r5, long r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.p2pSize;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.cdnSize;
    L9:
        return r5.copy(r10, r11);
    }

    public final long component1() {
        return this.p2pSize;
    }

    public final long component2() {
        return this.cdnSize;
    }

    public final OdlDownloadSize copy(long r5, long r10) {
        return new OdlDownloadSize(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof OdlDownloadSize) == false) goto L10;
        OdlDownloadSize r10 = (OdlDownloadSize) r5;
        if (this.p2pSize == r10.p2pSize) goto L8;
        return false;
    L8:
        if (this.cdnSize == r10.cdnSize) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final long getCdnSize() {
        return this.cdnSize;
    }

    public final long getP2pSize() {
        return this.p2pSize;
    }

    public int hashCode() {
        long r5 = this.p2pSize;
        int r10 = ((int) (r5 ^ (r5 >>> 32))) * 31;
        long r11 = this.cdnSize;
        return r10 + ((int) ((r11 >>> 32) ^ r11));
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("OdlDownloadSize(p2pSize=");
        r5.append(this.p2pSize);
        r5.append(", cdnSize=");
        return j0.o(r5, this.cdnSize, ")");
    }
}
