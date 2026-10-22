package ey9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/uaigc/avatar/api/Image;", "", "url", "", "width", "", "height", "<init>", "(Ljava/lang/String;JJ)V", "getUrl", "()Ljava/lang/String;", "getWidth", "()J", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class f {

    @SerializedName("height")
    private final long height;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final long width;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L12;
        return false;
    L12:
        if (this.width == r9.width) goto L15;
        return false;
    L15:
        if (this.height == r9.height) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.url;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.width;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.height;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Image(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public f() {
        this.url = null;
        this.width = 0;
        this.height = 0;
    }

    public final long a() {
        return this.height;
    }

    public final String b() {
        return this.url;
    }

    public final long c() {
        return this.width;
    }
}
