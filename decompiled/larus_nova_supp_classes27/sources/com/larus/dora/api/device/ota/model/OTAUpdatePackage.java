package com.larus.dora.api.device.ota.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010+J\u0080\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/larus/dora/api/device/ota/model/OTAUpdatePackage;", "Ljava/io/Serializable;", "id", "", "md5", "", "name", "size", "type", "url", "version", "bakUrls", "", "buildTime", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "getName", "setName", "getSize", "setSize", "getType", "()I", "setType", "(I)V", "getUrl", "setUrl", "getVersion", "setVersion", "getBakUrls", "()Ljava/util/List;", "setBakUrls", "(Ljava/util/List;)V", "getBuildTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)Lcom/larus/dora/api/device/ota/model/OTAUpdatePackage;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTAUpdatePackage implements Serializable {

    @SerializedName("bak_urls")
    private List<String> bakUrls;

    @SerializedName("buildtime")
    private final Long buildTime;

    @SerializedName("id")
    private Integer id;

    @SerializedName("md5")
    private String md5;

    @SerializedName("name")
    private String name;

    @SerializedName("size")
    private Integer size;

    @SerializedName("type")
    private int type;

    @SerializedName("url")
    private String url;

    @SerializedName("version")
    private String version;

    public OTAUpdatePackage() {
        this(null, null, null, null, 0, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OTAUpdatePackage copy$default(OTAUpdatePackage r10, Integer r11, String r12, String r13, Integer r14, int r15, String r16, String r17, List r18, Long r110, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Integer r2 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.md5;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.name;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = r10.size;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = r10.type;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.url;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.version;
    L31:
        if ((r20 & 128) == 0) goto L33;
        List r9 = r10.bakUrls;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Long r1 = r10.buildTime;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r110;
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

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.md5;
    }

    public final String component3() {
        return this.name;
    }

    public final Integer component4() {
        return this.size;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.url;
    }

    public final String component7() {
        return this.version;
    }

    public final List<String> component8() {
        return this.bakUrls;
    }

    public final Long component9() {
        return this.buildTime;
    }

    public final OTAUpdatePackage copy(Integer r12, String r13, String r14, Integer r15, int r16, String r17, String r18, List<String> r110, Long r20) {
        return new OTAUpdatePackage(r12, r13, r14, r15, r16, r17, r18, r110, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OTAUpdatePackage) == true) goto L8;
        return false;
    L8:
        OTAUpdatePackage r6 = (OTAUpdatePackage) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.md5, r6.md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L21;
        return false;
    L21:
        if (this.type == r6.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bakUrls, r6.bakUrls) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.buildTime, r6.buildTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.md5;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.size;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.type) * 31;
        String r13 = this.url;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.version;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r20 = this.bakUrls;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        Long r23 = this.buildTime;
        if (r23 == null) goto L35;
        r1 = r23.hashCode();
    L35:
        return r22 + r1;
    L29:
        r21 = r20.hashCode();
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
        return "OTAUpdatePackage(id=" + this.id + ", md5=" + this.md5 + ", name=" + this.name + ", size=" + this.size + ", type=" + this.type + ", url=" + this.url + ", version=" + this.version + ", bakUrls=" + this.bakUrls + ", buildTime=" + this.buildTime + ')';
    }

    public final List<String> getBakUrls() {
        return this.bakUrls;
    }

    public final Long getBuildTime() {
        return this.buildTime;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setBakUrls(List<String> r1) {
        this.bakUrls = r1;
    }

    public final void setId(Integer r1) {
        this.id = r1;
    }

    public final void setMd5(String r1) {
        this.md5 = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setSize(Integer r1) {
        this.size = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public OTAUpdatePackage(Integer r1, String r2, String r3, Integer r4, int r5, String r6, String r7, List<String> r8, Long r9) {
        this.id = r1;
        this.md5 = r2;
        this.name = r3;
        this.size = r4;
        this.type = r5;
        this.url = r6;
        this.version = r7;
        this.bakUrls = r8;
        this.buildTime = r9;
    }

    public /* synthetic */ OTAUpdatePackage(Integer r11, String r12, String r13, Integer r14, int r15, String r16, String r17, List r18, Long r110, int r20, DefaultConstructorMarker r21) {
        Long r2 = null;
        if ((r20 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = 0;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r110;
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
