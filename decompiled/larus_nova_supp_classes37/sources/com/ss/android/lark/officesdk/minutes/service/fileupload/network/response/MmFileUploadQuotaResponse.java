package com.ss.android.lark.officesdk.minutes.service.fileupload.network.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J)\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003Jr\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R6\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/fileupload/network/response/MmFileUploadQuotaResponse;", "Ljava/io/Serializable;", "hasQuota", "", "uploadTokenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isAdmin", "noQuotaNotice", "billUrl", "denyType", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/HashMap;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;I)V", "getHasQuota", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUploadTokenMap", "()Ljava/util/HashMap;", "getNoQuotaNotice", "()Ljava/lang/String;", "getBillUrl", "getDenyType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/util/HashMap;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;I)Lcom/ss/android/lark/officesdk/minutes/service/fileupload/network/response/MmFileUploadQuotaResponse;", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmFileUploadQuotaResponse implements Serializable {

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("deny_type")
    private final int denyType;

    @SerializedName("has_quota")
    private final Boolean hasQuota;

    @SerializedName("is_admin")
    private final Boolean isAdmin;

    @SerializedName("no_quota_notice")
    private final String noQuotaNotice;

    @SerializedName("upload_token")
    private final HashMap<String, String> uploadTokenMap;

    public MmFileUploadQuotaResponse() {
        this(null, null, null, null, null, 0, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmFileUploadQuotaResponse copy$default(MmFileUploadQuotaResponse r4, Boolean r5, HashMap r6, Boolean r7, String r8, String r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.hasQuota;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.uploadTokenMap;
    L8:
        HashMap r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.isAdmin;
    L11:
        Boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.noQuotaNotice;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.billUrl;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.denyType;
    L20:
        Boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Boolean component1() {
        return this.hasQuota;
    }

    public final HashMap<String, String> component2() {
        return this.uploadTokenMap;
    }

    public final Boolean component3() {
        return this.isAdmin;
    }

    public final String component4() {
        return this.noQuotaNotice;
    }

    public final String component5() {
        return this.billUrl;
    }

    public final int component6() {
        return this.denyType;
    }

    public final MmFileUploadQuotaResponse copy(Boolean r9, HashMap<String, String> r10, Boolean r11, String r12, String r13, int r14) {
        return new MmFileUploadQuotaResponse(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmFileUploadQuotaResponse) == true) goto L8;
        return false;
    L8:
        MmFileUploadQuotaResponse r6 = (MmFileUploadQuotaResponse) r5;
        if (Intrinsics.areEqual(this.hasQuota, r6.hasQuota) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadTokenMap, r6.uploadTokenMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isAdmin, r6.isAdmin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.noQuotaNotice, r6.noQuotaNotice) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.billUrl, r6.billUrl) == true) goto L24;
        return false;
    L24:
        if (this.denyType == r6.denyType) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.hasQuota;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HashMap<String, String> r4 = this.uploadTokenMap;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isAdmin;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.noQuotaNotice;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.billUrl;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return ((r12 + r1) * 31) + this.denyType;
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
        return "MmFileUploadQuotaResponse(hasQuota=" + this.hasQuota + ", uploadTokenMap=" + this.uploadTokenMap + ", isAdmin=" + this.isAdmin + ", noQuotaNotice=" + this.noQuotaNotice + ", billUrl=" + this.billUrl + ", denyType=" + this.denyType + ')';
    }

    public final String getBillUrl() {
        return this.billUrl;
    }

    public final int getDenyType() {
        return this.denyType;
    }

    public final Boolean getHasQuota() {
        return this.hasQuota;
    }

    public final String getNoQuotaNotice() {
        return this.noQuotaNotice;
    }

    public final HashMap<String, String> getUploadTokenMap() {
        return this.uploadTokenMap;
    }

    public final Boolean isAdmin() {
        return this.isAdmin;
    }

    public MmFileUploadQuotaResponse(Boolean r1, HashMap<String, String> r2, Boolean r3, String r4, String r5, int r6) {
        this.hasQuota = r1;
        this.uploadTokenMap = r2;
        this.isAdmin = r3;
        this.noQuotaNotice = r4;
        this.billUrl = r5;
        this.denyType = r6;
    }

    public /* synthetic */ MmFileUploadQuotaResponse(Boolean r5, HashMap r6, Boolean r7, String r8, String r9, int r10, int r11, DefaultConstructorMarker r12) {
        String r0 = null;
        if ((r11 & 1) == 0) goto L5;
        Boolean r13 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        HashMap r1 = null;
    L11:
        if ((r11 & 4) == 0) goto L13;
        Boolean r2 = null;
    L15:
        if ((r11 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r11 & 16) != 0) goto L23;
        r0 = r9;
    L23:
        if ((r11 & 32) == 0) goto L25;
        int r14 = 0;
    L26:
        this(r13, r1, r2, r3, r0, r14);
        return;
    L25:
        r14 = r10;
        goto L26
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L7
    }
}
