package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/k5;", "", "", "enable", "Z", "getEnable", "()Z", "", "priority", "I", "getPriority", "()I", "", "rom", "Ljava/lang/String;", "getRom", "()Ljava/lang/String;", "romVersion", "getRomVersion", "buildVersion", "getBuildVersion", "displayName", "getDisplayName", "layerName", "getLayerName", "layerFlag", "getLayerFlag", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k5 {

    @SerializedName("build_version")
    private final int buildVersion;

    @SerializedName("display_name")
    private final String displayName;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("layer_flag")
    private final int layerFlag;

    @SerializedName("layer_name")
    private final String layerName;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("rom")
    private final String rom;

    @SerializedName("rom_version")
    private final String romVersion;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k5) == false) goto L22;
        k5 r4 = (k5) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.priority == r4.priority) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rom, r4.rom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.romVersion, r4.romVersion) == true) goto L14;
        return false;
    L14:
        if (this.buildVersion == r4.buildVersion) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.displayName, r4.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.layerName, r4.layerName) == true) goto L20;
        return false;
    L20:
        if (this.layerFlag == r4.layerFlag) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.priority) * 31;
        String r3 = this.rom;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.romVersion;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (((r6 + r8) * 31) + this.buildVersion) * 31;
        String r10 = this.displayName;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = this.layerName;
        if (r13 == null) goto L21;
        r4 = r13.hashCode();
    L21:
        return ((r12 + r4) * 31) + this.layerFlag;
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public k5() {
        Intrinsics.checkNotNullParameter("", "rom");
        Intrinsics.checkNotNullParameter("", "romVersion");
        Intrinsics.checkNotNullParameter("", "displayName");
        Intrinsics.checkNotNullParameter("", "layerName");
        this.enable = false;
        this.priority = 0;
        this.rom = "";
        this.romVersion = "";
        this.buildVersion = -1;
        this.displayName = "";
        this.layerName = "";
        this.layerFlag = -1;
    }

    public final String toString() {
        return "FilterRomConfig(enable=" + this.enable + ", rom='" + this.rom + "', romVersion='" + this.romVersion + "', buildVersion=" + this.buildVersion + ", displayName='" + this.displayName + "', layerName='" + this.layerName + "', layerFlag=" + this.layerFlag + ')';
    }
}
