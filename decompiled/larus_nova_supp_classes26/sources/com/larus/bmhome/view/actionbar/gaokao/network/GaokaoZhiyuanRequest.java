package com.larus.bmhome.view.actionbar.gaokao.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoZhiyuanRequest;", "", "score", "", "province", "subject", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScore", "()Ljava/lang/String;", "getProvince", "getSubject", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoZhiyuanRequest {

    @SerializedName("province")
    private final String province;

    @SerializedName("score")
    private final String score;

    @SerializedName("subject")
    private final String subject;

    public GaokaoZhiyuanRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GaokaoZhiyuanRequest copy$default(GaokaoZhiyuanRequest r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.score;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.province;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.subject;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.score;
    }

    public final String component2() {
        return this.province;
    }

    public final String component3() {
        return this.subject;
    }

    public final GaokaoZhiyuanRequest copy(String r2, String r3, String r4) {
        return new GaokaoZhiyuanRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GaokaoZhiyuanRequest) == true) goto L8;
        return false;
    L8:
        GaokaoZhiyuanRequest r6 = (GaokaoZhiyuanRequest) r5;
        if (Intrinsics.areEqual(this.score, r6.score) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.province, r6.province) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subject, r6.subject) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.score;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.province;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.subject;
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
        return "GaokaoZhiyuanRequest(score=" + this.score + ", province=" + this.province + ", subject=" + this.subject + ')';
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getScore() {
        return this.score;
    }

    public final String getSubject() {
        return this.subject;
    }

    public GaokaoZhiyuanRequest(String r1, String r2, String r3) {
        this.score = r1;
        this.province = r2;
        this.subject = r3;
    }

    public /* synthetic */ GaokaoZhiyuanRequest(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
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
