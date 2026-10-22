package com.bytedance.android.live.broadcastgame.opengame.message;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/UploadCheckRsp;", "", "rs", "", "", "(Ljava/util/Map;)V", "getRs", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UploadCheckRsp {

    @SerializedName("exist_etags")
    private final Map<String, String> rs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadCheckRsp copy$default(UploadCheckRsp r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.rs;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, String> component1() {
        return this.rs;
    }

    public final UploadCheckRsp copy(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "rs");
        return new UploadCheckRsp(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof UploadCheckRsp) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.rs, ((UploadCheckRsp) r2).rs) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, String> r0 = this.rs;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "UploadCheckRsp(rs=" + this.rs + ")";
    }

    public final Map<String, String> getRs() {
        return this.rs;
    }

    public UploadCheckRsp(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "rs");
        this.rs = r2;
    }
}
