package com.bytedance.android.live.broadcastgame.opengame.message;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/UploadFileRsp;", "", "md5", "", "oid", "uri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getOid", "getUri", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UploadFileRsp {

    @SerializedName("etag")
    private final String md5;
    private final String oid;
    private final String uri;

    public static /* synthetic */ UploadFileRsp copy$default(UploadFileRsp r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.md5;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.oid;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.uri;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.md5;
    }

    public final String component2() {
        return this.oid;
    }

    public final String component3() {
        return this.uri;
    }

    public final UploadFileRsp copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        Intrinsics.checkNotNullParameter(r3, "oid");
        Intrinsics.checkNotNullParameter(r4, "uri");
        return new UploadFileRsp(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof UploadFileRsp) == false) goto L12;
        UploadFileRsp r4 = (UploadFileRsp) r3;
        if (Intrinsics.areEqual(this.md5, r4.md5) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.oid, r4.oid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L19;
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
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.uri;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "UploadFileRsp(md5=" + this.md5 + ", oid=" + this.oid + ", uri=" + this.uri + ")";
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getOid() {
        return this.oid;
    }

    public final String getUri() {
        return this.uri;
    }

    public UploadFileRsp(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        Intrinsics.checkNotNullParameter(r3, "oid");
        Intrinsics.checkNotNullParameter(r4, "uri");
        this.md5 = r2;
        this.oid = r3;
        this.uri = r4;
    }
}
