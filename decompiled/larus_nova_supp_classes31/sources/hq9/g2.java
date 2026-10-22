package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/LarkDriveMenuItemConfig;", "", "itemId", "", "visible", "", "groupId", "order", "", "subMenuId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getVisible", "()Z", "getGroupId", "getOrder", "()I", "getSubMenuId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class g2 {

    @SerializedName("groupId")
    private final String groupId;

    @SerializedName("itemId")
    private final String itemId;

    @SerializedName("order")
    private final int order;

    @SerializedName("subMenuId")
    private final String subMenuId;

    @SerializedName("visible")
    private final boolean visible;

    public g2() {
        this(null, null, 0, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g2) == true) goto L8;
        return false;
    L8:
        g2 r6 = (g2) r5;
        if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L12;
        return false;
    L12:
        if (this.visible == r6.visible) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.groupId, r6.groupId) == true) goto L18;
        return false;
    L18:
        if (this.order == r6.order) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subMenuId, r6.subMenuId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.itemId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.visible == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.groupId;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((r5 + r7) * 31) + this.order) * 31;
        String r9 = this.subMenuId;
        if (r9 == null) goto L19;
        r1 = r9.hashCode();
    L19:
        return r8 + r1;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkDriveMenuItemConfig(itemId=" + this.itemId + ", visible=" + this.visible + ", groupId=" + this.groupId + ", order=" + this.order + ", subMenuId=" + this.subMenuId + ')';
    }

    public g2(String r5, String r6, int r7, String r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 2) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r9 & 4) == 0) goto L13;
        r6 = null;
    L13:
        if ((r9 & 8) == 0) goto L16;
        r7 = 0;
    L16:
        if ((r9 & 16) == 0) goto L18;
        r8 = null;
    L18:
        this.itemId = r5;
        this.visible = r0;
        this.groupId = r6;
        this.order = r7;
        this.subMenuId = r8;
        return;
    L8:
        r0 = false;
        goto L10
    }
}
