package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/LarkDriveMenuGroupConfig;", "", "groupId", "", "visible", "", "order", "", "<init>", "(Ljava/lang/String;ZI)V", "getGroupId", "()Ljava/lang/String;", "getVisible", "()Z", "getOrder", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class f2 {

    @SerializedName("groupId")
    private final String groupId;

    @SerializedName("order")
    private final int order;

    @SerializedName("visible")
    private final boolean visible;

    public f2() {
        this(null, 0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f2) == true) goto L8;
        return false;
    L8:
        f2 r6 = (f2) r5;
        if (Intrinsics.areEqual(this.groupId, r6.groupId) == true) goto L12;
        return false;
    L12:
        if (this.visible == r6.visible) goto L15;
        return false;
    L15:
        if (this.order == r6.order) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.groupId;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.visible == false) goto L9;
        int r3 = 1231;
    L11:
        return ((r2 + r3) * 31) + this.order;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkDriveMenuGroupConfig(groupId=" + this.groupId + ", visible=" + this.visible + ", order=" + this.order + ')';
    }

    public f2(String r3, int r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        this.groupId = r3;
        this.visible = r0;
        this.order = r4;
        return;
    L8:
        r0 = false;
        goto L10
    }
}
