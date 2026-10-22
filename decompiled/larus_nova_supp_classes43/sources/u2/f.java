package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantingItem;", "", "priorityLevel", "", "grantingName", "", "required", "", "permissionStatus", "relatedData", "<init>", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getPriorityLevel", "()I", "getGrantingName", "()Ljava/lang/String;", "getRequired", "()Z", "getPermissionStatus", "getRelatedData", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("grantingName")
    private final String grantingName;

    @SerializedName("permissionStatus")
    private final String permissionStatus;

    @SerializedName("priorityLevel")
    private final int priorityLevel;

    @SerializedName("relatedData")
    private final String relatedData;

    @SerializedName("required")
    private final boolean required;

    public f() {
        this(0, null, false, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.priorityLevel == r11.priorityLevel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.grantingName, r11.grantingName) == true) goto L15;
        return false;
    L15:
        if (this.required == r11.required) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.permissionStatus, r11.permissionStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.relatedData, r11.relatedData) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.priorityLevel * 31;
        String r1 = this.grantingName;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        if (this.required == false) goto L9;
        int r13 = 1231;
    L10:
        int r14 = (r12 + r13) * 31;
        String r15 = this.permissionStatus;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.relatedData;
        if (r18 == null) goto L19;
        r10 = r18.hashCode();
    L19:
        return r17 + r10;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = 1237;
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GrantingItem(priorityLevel=" + this.priorityLevel + ", grantingName=" + this.grantingName + ", required=" + this.required + ", permissionStatus=" + this.permissionStatus + ", relatedData=" + this.relatedData + ')';
    }

    public final String b() {
        return this.grantingName;
    }

    public final String c() {
        return this.permissionStatus;
    }

    public final int d() {
        return this.priorityLevel;
    }

    public final String e() {
        return this.relatedData;
    }

    public final boolean f() {
        return this.required;
    }

    public static f a(f r10, String r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        int r14 = r10.priorityLevel;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r0 = r10.grantingName;
    L10:
        String r15 = r0;
        if ((r13 & 4) == 0) goto L13;
        boolean r16 = r10.required;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = r10.permissionStatus;
    L17:
        String r17 = r11;
        if ((r13 & 16) == 0) goto L20;
        r12 = r10.relatedData;
    L20:
        r10.getClass();
        return new f(r14, r15, r16, r17, r12);
    L13:
        r16 = false;
        goto L15
    L9:
        r0 = null;
        goto L10
    L5:
        r14 = 0;
        goto L7
    }

    public f(int r1, String r10, boolean r11, String r12, String r13) {
        this.priorityLevel = r1;
        this.grantingName = r10;
        this.required = r11;
        this.permissionStatus = r12;
        this.relatedData = r13;
    }
}
