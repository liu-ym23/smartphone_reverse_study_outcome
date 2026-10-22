package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/ScopeGrantedStatus;", "", "scopeName", "", "grantStatus", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getScopeName", "()Ljava/lang/String;", "getGrantStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/bridge/remote/model/ScopeGrantedStatus;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    @SerializedName("grant_status")
    private final Integer grantStatus;

    @SerializedName("scope_name")
    private final String scopeName;

    public q() {
        this(null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof q) == true) goto L8;
        return false;
    L8:
        q r11 = (q) r10;
        if (Intrinsics.areEqual(this.scopeName, r11.scopeName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.grantStatus, r11.grantStatus) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.scopeName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Integer r12 = this.grantStatus;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScopeGrantedStatus(scopeName=" + this.scopeName + ", grantStatus=" + this.grantStatus + ')';
    }

    public q(String r1, Integer r10) {
        this.scopeName = r1;
        this.grantStatus = r10;
    }
}
