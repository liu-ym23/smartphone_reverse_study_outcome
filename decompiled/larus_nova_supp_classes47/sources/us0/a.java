package us0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lus0/a;", "", "", "noNotice", "Z", "a", "()Z", "c", "(Z)V", "", "noticeTime", "I", "b", "()I", "d", "(I)V", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("no_notice")
    private boolean noNotice;

    @SerializedName("notice_time")
    private int noticeTime;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (this.noNotice == r4.noNotice) goto L8;
        return false;
    L8:
        if (this.noticeTime == r4.noticeTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.noNotice;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (r1 * 31) + this.noticeTime;
    }

    public final String toString() {
        return "AnchorGroupPurchaseCache(noNotice=" + this.noNotice + ", noticeTime=" + this.noticeTime + ")";
    }

    public a() {
        this.noNotice = false;
        this.noticeTime = 0;
    }

    public final boolean a() {
        return this.noNotice;
    }

    public final int b() {
        return this.noticeTime;
    }

    public final void c(boolean r1) {
        this.noNotice = r1;
    }

    public final void d(int r1) {
        this.noticeTime = r1;
    }
}
