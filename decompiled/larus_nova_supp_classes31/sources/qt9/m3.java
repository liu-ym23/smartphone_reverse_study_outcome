package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/NewUserLaunchPageStrategy;", "", "pageId", "", "loginDaysLimit", "loginTimesLimit", "<init>", "(III)V", "getPageId", "()I", "getLoginDaysLimit", "getLoginTimesLimit", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class m3 {
    public final int a;
    public final int b;

    @SerializedName("page_id")
    private final int pageId;

    public m3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m3) == true) goto L8;
        return false;
    L8:
        m3 r6 = (m3) r5;
        if (this.pageId == r6.pageId) goto L12;
        return false;
    L12:
        if (this.a == r6.a) goto L15;
        return false;
    L15:
        if (this.b == r6.b) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.pageId * 31) + this.a) * 31) + this.b;
    }

    public final String toString() {
        return "NewUserLaunchPageStrategy(pageId=" + this.pageId + ", loginDaysLimit=" + this.a + ", loginTimesLimit=" + this.b + ')';
    }

    public final int a() {
        return this.pageId;
    }

    public m3(int r2) {
        this.pageId = 1;
        this.a = 5;
        this.b = 1;
    }
}
