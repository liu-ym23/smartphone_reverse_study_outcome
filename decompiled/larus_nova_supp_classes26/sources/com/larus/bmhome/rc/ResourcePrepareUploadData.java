package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/rc/ResourcePrepareUploadData;", "", "serviceId", "", "uploadPathPrefix", "uploadHost", "uploadAuthToken", "Lcom/larus/bmhome/rc/ResourceUploadAuthToken;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/rc/ResourceUploadAuthToken;)V", "getServiceId", "()Ljava/lang/String;", "getUploadPathPrefix", "getUploadHost", "getUploadAuthToken", "()Lcom/larus/bmhome/rc/ResourceUploadAuthToken;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourcePrepareUploadData {

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("upload_auth_token")
    private final ResourceUploadAuthToken uploadAuthToken;

    @SerializedName("upload_host")
    private final String uploadHost;

    @SerializedName("upload_path_prefix")
    private final String uploadPathPrefix;

    public ResourcePrepareUploadData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResourcePrepareUploadData copy$default(ResourcePrepareUploadData r0, String r1, String r2, String r3, ResourceUploadAuthToken r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.serviceId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.uploadPathPrefix;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.uploadHost;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.uploadAuthToken;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.serviceId;
    }

    public final String component2() {
        return this.uploadPathPrefix;
    }

    public final String component3() {
        return this.uploadHost;
    }

    public final ResourceUploadAuthToken component4() {
        return this.uploadAuthToken;
    }

    public final ResourcePrepareUploadData copy(String r2, String r3, String r4, ResourceUploadAuthToken r5) {
        return new ResourcePrepareUploadData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourcePrepareUploadData) == true) goto L8;
        return false;
    L8:
        ResourcePrepareUploadData r6 = (ResourcePrepareUploadData) r5;
        if (Intrinsics.areEqual(this.serviceId, r6.serviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadPathPrefix, r6.uploadPathPrefix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadHost, r6.uploadHost) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadAuthToken, r6.uploadAuthToken) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.serviceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.uploadPathPrefix;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.uploadHost;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ResourceUploadAuthToken r10 = this.uploadAuthToken;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "ResourcePrepareUploadData(serviceId=" + this.serviceId + ", uploadPathPrefix=" + this.uploadPathPrefix + ", uploadHost=" + this.uploadHost + ", uploadAuthToken=" + this.uploadAuthToken + ')';
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public final ResourceUploadAuthToken getUploadAuthToken() {
        return this.uploadAuthToken;
    }

    public final String getUploadHost() {
        return this.uploadHost;
    }

    public final String getUploadPathPrefix() {
        return this.uploadPathPrefix;
    }

    public ResourcePrepareUploadData(String r1, String r2, String r3, ResourceUploadAuthToken r4) {
        this.serviceId = r1;
        this.uploadPathPrefix = r2;
        this.uploadHost = r3;
        this.uploadAuthToken = r4;
    }

    public /* synthetic */ ResourcePrepareUploadData(String r9, String r10, String r11, ResourceUploadAuthToken r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r9 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = null;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = new ResourceUploadAuthToken(null, null, null, null, null, 31, null);
    L14:
        this(r9, r10, r11, r12);
    }
}
