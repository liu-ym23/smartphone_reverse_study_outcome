package com.larus.bmhome.chat.model.repo;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jz\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/Tile;", "", "id", "", "name", "category", "Lcom/larus/bmhome/chat/model/repo/Category;", "type", "", "iconUrl", "iconUrlDark", "noticeEnabledValue", "", "noticePermissionValue", "supplierValue", "Lcom/larus/bmhome/chat/model/repo/SupplierDetail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/repo/Category;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/repo/SupplierDetail;)V", "getId", "()Ljava/lang/String;", "getName", "getCategory", "()Lcom/larus/bmhome/chat/model/repo/Category;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconUrl", "getIconUrlDark", "getNoticeEnabledValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNoticePermissionValue", "getSupplierValue", "()Lcom/larus/bmhome/chat/model/repo/SupplierDetail;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/repo/Category;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/repo/SupplierDetail;)Lcom/larus/bmhome/chat/model/repo/Tile;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class Tile {

    @SerializedName("category")
    private final Category category;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("icon_url_dark")
    private final String iconUrlDark;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("notice_enabled_value")
    private final Boolean noticeEnabledValue;

    @SerializedName("notice_permission_value")
    private final Boolean noticePermissionValue;

    @SerializedName("supplier_value")
    private final SupplierDetail supplierValue;

    @SerializedName("type")
    private final Integer type;

    public Tile() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ Tile copy$default(Tile r10, String r11, String r12, Category r13, Integer r14, String r15, String r16, Boolean r17, Boolean r18, SupplierDetail r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.name;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Category r4 = r10.category;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = r10.type;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.iconUrl;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.iconUrlDark;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Boolean r8 = r10.noticeEnabledValue;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Boolean r9 = r10.noticePermissionValue;
    L35:
        if ((r20 & 256) == 0) goto L37;
        SupplierDetail r1 = r10.supplierValue;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Category component3() {
        return this.category;
    }

    public final Integer component4() {
        return this.type;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.iconUrlDark;
    }

    public final Boolean component7() {
        return this.noticeEnabledValue;
    }

    public final Boolean component8() {
        return this.noticePermissionValue;
    }

    public final SupplierDetail component9() {
        return this.supplierValue;
    }

    public final Tile copy(String r12, String r13, Category r14, Integer r15, String r16, String r17, Boolean r18, Boolean r19, SupplierDetail r20) {
        return new Tile(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Tile) == true) goto L8;
        return false;
    L8:
        Tile r6 = (Tile) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.category, r6.category) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUrlDark, r6.iconUrlDark) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.noticeEnabledValue, r6.noticeEnabledValue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.noticePermissionValue, r6.noticePermissionValue) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.supplierValue, r6.supplierValue) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Category r7 = this.category;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.type;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.iconUrl;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.iconUrlDark;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.noticeEnabledValue;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.noticePermissionValue;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        SupplierDetail r25 = this.supplierValue;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Tile(id=" + this.id + ", name=" + this.name + ", category=" + this.category + ", type=" + this.type + ", iconUrl=" + this.iconUrl + ", iconUrlDark=" + this.iconUrlDark + ", noticeEnabledValue=" + this.noticeEnabledValue + ", noticePermissionValue=" + this.noticePermissionValue + ", supplierValue=" + this.supplierValue + ')';
    }

    public final Category getCategory() {
        return this.category;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconUrlDark() {
        return this.iconUrlDark;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNoticeEnabledValue() {
        return this.noticeEnabledValue;
    }

    public final Boolean getNoticePermissionValue() {
        return this.noticePermissionValue;
    }

    public final SupplierDetail getSupplierValue() {
        return this.supplierValue;
    }

    public final Integer getType() {
        return this.type;
    }

    public Tile(String r1, String r2, Category r3, Integer r4, String r5, String r6, Boolean r7, Boolean r8, SupplierDetail r9) {
        this.id = r1;
        this.name = r2;
        this.category = r3;
        this.type = r4;
        this.iconUrl = r5;
        this.iconUrlDark = r6;
        this.noticeEnabledValue = r7;
        this.noticePermissionValue = r8;
        this.supplierValue = r9;
    }

    public /* synthetic */ Tile(String r11, String r12, Category r13, Integer r14, String r15, String r16, Boolean r17, Boolean r18, SupplierDetail r19, int r20, DefaultConstructorMarker r21) {
        SupplierDetail r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Category r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Boolean r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
