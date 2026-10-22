package com.larus.dora.impl.dynamic;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/dynamic/PageConfig;", "", "id", "", "pageId", "name", "", "pageKey", "version", "config", "productModelCodes", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getPageId", "getName", "()Ljava/lang/String;", "getPageKey", "getVersion", "getConfig", "getProductModelCodes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class y1 {

    @SerializedName("config")
    private final String config;

    @SerializedName("id")
    private final long id;

    @SerializedName("name")
    private final String name;

    @SerializedName("page_id")
    private final long pageId;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY)
    private final String pageKey;

    @SerializedName("product_model_codes")
    private final String productModelCodes;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof y1) == true) goto L8;
        return false;
    L8:
        y1 r9 = (y1) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (this.pageId == r9.pageId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pageKey, r9.pageKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r9.version) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.config, r9.config) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.productModelCodes, r9.productModelCodes) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r0 = this.id;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.pageId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.name;
        int r5 = 0;
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.pageKey;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.version;
        if (r11 != null) goto L13;
        int r12 = 0;
    L14:
        int r13 = (r10 + r12) * 31;
        String r14 = this.config;
        if (r14 != null) goto L17;
        int r15 = 0;
    L18:
        int r16 = (r13 + r15) * 31;
        String r17 = this.productModelCodes;
        if (r17 == null) goto L23;
        r5 = r17.hashCode();
    L23:
        return r16 + r5;
    L17:
        r15 = r14.hashCode();
        goto L18
    L13:
        r12 = r11.hashCode();
        goto L14
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r6 = r4.hashCode();
        goto L6
    }

    public final String toString() {
        return "PageConfig(id=" + this.id + ", pageId=" + this.pageId + ", name=" + this.name + ", pageKey=" + this.pageKey + ", version=" + this.version + ", config=" + this.config + ", productModelCodes=" + this.productModelCodes + ')';
    }

    public y1() {
        this.id = -1;
        this.pageId = -1;
        this.name = null;
        this.pageKey = null;
        this.version = null;
        this.config = null;
        this.productModelCodes = null;
    }

    public final String a() {
        return this.config;
    }
}
