package com.bytedance.android.live.broadcastgame.opengame.message;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/AuditBean;", "", "md5", "", "oid", "repeat", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getMd5", "()Ljava/lang/String;", "getOid", "getRepeat", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuditBean {

    @SerializedName("md5")
    private final String md5;

    @SerializedName("oid")
    private final String oid;

    @SerializedName("repeat")
    private final int repeat;

    public static /* synthetic */ AuditBean copy$default(AuditBean r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.md5;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.oid;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.repeat;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.md5;
    }

    public final String component2() {
        return this.oid;
    }

    public final int component3() {
        return this.repeat;
    }

    public final AuditBean copy(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        Intrinsics.checkNotNullParameter(r3, "oid");
        return new AuditBean(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AuditBean) == false) goto L12;
        AuditBean r4 = (AuditBean) r3;
        if (Intrinsics.areEqual(this.md5, r4.md5) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.oid, r4.oid) == true) goto L10;
        return false;
    L10:
        if (this.repeat == r4.repeat) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.md5;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.oid;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.repeat;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AuditBean(md5=" + this.md5 + ", oid=" + this.oid + ", repeat=" + this.repeat + ")";
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getOid() {
        return this.oid;
    }

    public final int getRepeat() {
        return this.repeat;
    }

    public AuditBean(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        Intrinsics.checkNotNullParameter(r3, "oid");
        this.md5 = r2;
        this.oid = r3;
        this.repeat = r4;
    }
}
