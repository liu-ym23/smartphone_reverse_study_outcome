package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf;

import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000b\u0010\u0005R\u001a\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/c;", "", "", "isMounted", "Z", "()Z", "", "mountedPageNum", "I", "getMountedPageNum", "()I", "isModify", "maxPageNum", "getMaxPageNum", "", "roomId", "J", "getRoomId", "()J", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("isModify")
    private final boolean isModify;

    @SerializedName("isMounted")
    private final boolean isMounted;

    @SerializedName("maxPageNum")
    private final int maxPageNum;

    @SerializedName("mountedPageNum")
    private final int mountedPageNum;

    @SerializedName("roomId")
    private final long roomId;

    public c() {
        this(false, 0, false, 0, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == false) goto L16;
        c r6 = (c) r5;
        if (this.isMounted == r6.isMounted) goto L8;
        return false;
    L8:
        if (this.mountedPageNum == r6.mountedPageNum) goto L10;
        return false;
    L10:
        if (this.isModify == r6.isModify) goto L12;
        return false;
    L12:
        if (this.maxPageNum == r6.maxPageNum) goto L14;
        return false;
    L14:
        if (this.roomId == r6.roomId) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        boolean r0 = this.isMounted;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((r2 * 31) + this.mountedPageNum) * 31;
        boolean r4 = this.isModify;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (((r3 + r1) * 31) + this.maxPageNum) * 31;
        long r6 = this.roomId;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "PageConfig(isMounted=" + this.isMounted + ", mountedPageNum=" + this.mountedPageNum + ", isModify=" + this.isModify + ", maxPageNum=" + this.maxPageNum + ", roomId=" + this.roomId + ")";
    }

    public c(boolean r3, int r4, boolean r5, long r6, int r8) {
        int r1 = 0;
        if ((r8 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r1 = ((uc1) ee0.a.getValue()).o();
    L15:
        if ((r8 & 16) == 0) goto L17;
        r6 = 0;
    L17:
        this.isMounted = r3;
        this.mountedPageNum = r4;
        this.isModify = r5;
        this.maxPageNum = r1;
        this.roomId = r6;
    }
}
