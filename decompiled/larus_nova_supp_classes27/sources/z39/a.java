package z39;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006%"}, d2 = {"Lcom/larus/dora/api/device/ota/model/OTAUpdateResponse;", "", "packageInfoList", "", "Lcom/larus/dora/api/device/ota/model/OTAUpdatePackage;", "meta", "Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "trace", "", "taskId", "<init>", "(Ljava/util/List;Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;Ljava/lang/String;Ljava/lang/String;)V", "getPackageInfoList", "()Ljava/util/List;", "setPackageInfoList", "(Ljava/util/List;)V", "getMeta", "()Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "setMeta", "(Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;)V", "getTrace", "()Ljava/lang/String;", "setTrace", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("meta")
    private OTAUpdateMeta meta;

    @SerializedName("package")
    private List<OTAUpdatePackage> packageInfoList;

    @SerializedName("taskId")
    private String taskId;

    @SerializedName("trace")
    private String trace;

    public a() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.packageInfoList, r6.packageInfoList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.meta, r6.meta) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.trace, r6.trace) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<OTAUpdatePackage> r0 = this.packageInfoList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        OTAUpdateMeta r4 = this.meta;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.trace;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.taskId;
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
        return "OTAUpdateResponse(packageInfoList=" + this.packageInfoList + ", meta=" + this.meta + ", trace=" + this.trace + ", taskId=" + this.taskId + ')';
    }

    public final OTAUpdateMeta a() {
        return this.meta;
    }

    public final List<OTAUpdatePackage> b() {
        return this.packageInfoList;
    }

    public final String c() {
        return this.taskId;
    }

    public final String d() {
        return this.trace;
    }

    public a(List<OTAUpdatePackage> r1, OTAUpdateMeta r2, String r3, String r4) {
        this.packageInfoList = r1;
        this.meta = r2;
        this.trace = r3;
        this.taskId = r4;
    }
}
