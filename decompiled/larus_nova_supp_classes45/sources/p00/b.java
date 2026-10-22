package p00;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lp00/b;", "", "", "category", "J", "getCategory", "()J", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "coverUri", "getCoverUri", "livebroadcastbase-api_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("category")
    private final long category;

    @SerializedName("cover_uri")
    private final String coverUri;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L12;
        b r7 = (b) r6;
        if (this.category == r7.category) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r7.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverUri, r7.coverUri) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.category;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.title;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.coverUri;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        return r5 + r3;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "GameCreateInfo(category=" + this.category + ", title=" + this.title + ", coverUri=" + this.coverUri + ")";
    }
}
