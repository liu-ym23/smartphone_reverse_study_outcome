package com.larus.bmhome.taskskill.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b*\b\u0080\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014HÆ\u0003Jµ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\n2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\nHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0016\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lcom/larus/bmhome/taskskill/network/ConnectorRemoteItem;", "", "connectorId", "", "name", "displayName", "description", "displayDescription", "icon", "type", "", "installStatus", "connectStatus", "enabled", "", "skillPackageId", "skillType", "recommend", "vendor", "runtimeTypes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZLjava/lang/String;IZILjava/util/List;)V", "getConnectorId", "()Ljava/lang/String;", "getName", "getDisplayName", "getDescription", "getDisplayDescription", "getIcon", "getType", "()I", "getInstallStatus", "getConnectStatus", "getEnabled", "()Z", "getSkillPackageId", "getSkillType", "getRecommend", "getVendor", "getRuntimeTypes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("connect_status")
    private final int connectStatus;

    @SerializedName("connector_id")
    private final String connectorId;

    @SerializedName("description")
    private final String description;

    @SerializedName("display_description")
    private final String displayDescription;

    @SerializedName("display_name")
    private final String displayName;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("install_status")
    private final int installStatus;

    @SerializedName("name")
    private final String name;

    @SerializedName("recommend")
    private final boolean recommend;

    @SerializedName("runtime_types")
    private final List<Integer> runtimeTypes;

    @SerializedName("skill_package_id")
    private final String skillPackageId;

    @SerializedName("skill_type")
    private final int skillType;

    @SerializedName("type")
    private final int type;

    @SerializedName("vendor")
    private final int vendor;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.connectorId, r6.connectorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayName, r6.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.displayDescription, r6.displayDescription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L27;
        return false;
    L27:
        if (this.type == r6.type) goto L30;
        return false;
    L30:
        if (this.installStatus == r6.installStatus) goto L33;
        return false;
    L33:
        if (this.connectStatus == r6.connectStatus) goto L36;
        return false;
    L36:
        if (this.enabled == r6.enabled) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.skillPackageId, r6.skillPackageId) == true) goto L42;
        return false;
    L42:
        if (this.skillType == r6.skillType) goto L45;
        return false;
    L45:
        if (this.recommend == r6.recommend) goto L48;
        return false;
    L48:
        if (this.vendor == r6.vendor) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.runtimeTypes, r6.runtimeTypes) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r0 = this.connectorId;
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
        String r7 = this.displayName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.description;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.displayDescription;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.icon;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((((((r15 + r17) * 31) + this.type) * 31) + this.installStatus) * 31) + this.connectStatus) * 31;
        int r19 = 1231;
        if (this.enabled == false) goto L29;
        int r20 = 1231;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.skillPackageId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (((r21 + r23) * 31) + this.skillType) * 31;
        if (this.recommend == true) goto L38;
        r19 = 1237;
    L38:
        int r25 = (((r24 + r19) * 31) + this.vendor) * 31;
        List<Integer> r26 = this.runtimeTypes;
        if (r26 == null) goto L43;
        r1 = r26.hashCode();
    L43:
        return r25 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = 1237;
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

    public final String toString() {
        return "ConnectorRemoteItem(connectorId=" + this.connectorId + ", name=" + this.name + ", displayName=" + this.displayName + ", description=" + this.description + ", displayDescription=" + this.displayDescription + ", icon=" + this.icon + ", type=" + this.type + ", installStatus=" + this.installStatus + ", connectStatus=" + this.connectStatus + ", enabled=" + this.enabled + ", skillPackageId=" + this.skillPackageId + ", skillType=" + this.skillType + ", recommend=" + this.recommend + ", vendor=" + this.vendor + ", runtimeTypes=" + this.runtimeTypes + ')';
    }

    public d() {
        this.connectorId = null;
        this.name = null;
        this.displayName = null;
        this.description = null;
        this.displayDescription = null;
        this.icon = null;
        this.type = 0;
        this.installStatus = 0;
        this.connectStatus = 0;
        this.enabled = false;
        this.skillPackageId = null;
        this.skillType = 0;
        this.recommend = false;
        this.vendor = 0;
        this.runtimeTypes = null;
    }

    public final int a() {
        return this.connectStatus;
    }

    public final String b() {
        return this.connectorId;
    }

    public final String c() {
        return this.description;
    }

    public final String d() {
        return this.displayDescription;
    }

    public final String e() {
        return this.displayName;
    }

    public final boolean f() {
        return this.enabled;
    }

    public final String g() {
        return this.icon;
    }

    public final int getType() {
        return this.type;
    }

    public final int h() {
        return this.installStatus;
    }

    public final String i() {
        return this.name;
    }

    public final int j() {
        return this.skillType;
    }
}
