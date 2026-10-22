package mr9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/upload/ResourceUploadToken;", "", "serviceId", "", "uploadPathPrefix", "uploadHost", "auth", "Lcom/larus/platform/model/upload/ImageAuth;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/ImageAuth;)V", "getServiceId", "()Ljava/lang/String;", "getUploadPathPrefix", "getUploadHost", "getAuth", "()Lcom/larus/platform/model/upload/ImageAuth;", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class m {

    @SerializedName("auth")
    private final b auth;

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("upload_host")
    private final String uploadHost;

    @SerializedName("upload_path_prefix")
    private final String uploadPathPrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public m() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.serviceId, r6.serviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadPathPrefix, r6.uploadPathPrefix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadHost, r6.uploadHost) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.auth, r6.auth) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
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
        b r10 = this.auth;
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

    public final String toString() {
        return "[serviceId:" + this.serviceId + ", uploadPathPrefix:" + this.uploadPathPrefix + ", uploadHost:" + this.uploadHost + ", auth:" + this.auth + ']';
    }

    public final b a() {
        return this.auth;
    }

    public final String b() {
        return this.serviceId;
    }

    public final String c() {
        return this.uploadHost;
    }

    public final String d() {
        return this.uploadPathPrefix;
    }

    public /* synthetic */ m(String r5, String r6, b r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r8 & 2) == 0) goto L8;
        String r0 = "";
    L10:
        if ((r8 & 4) == 0) goto L13;
        r6 = "";
    L13:
        if ((r8 & 8) == 0) goto L15;
        r7 = null;
    L15:
        this(r5, r0, r6, r7);
        return;
    L8:
        r0 = null;
        goto L10
    }

    public m(String r1, String r2, String r3, b r4) {
        this.serviceId = r1;
        this.uploadPathPrefix = r2;
        this.uploadHost = r3;
        this.auth = r4;
    }
}
