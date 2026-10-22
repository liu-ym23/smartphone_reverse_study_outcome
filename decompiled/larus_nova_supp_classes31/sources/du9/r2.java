package du9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/chat/UploadVideoEntityConf;", "", "limitConf", "Lcom/larus/settings/provider/chat/UploadVideoEntityLimitConf;", "transConf", "Lcom/larus/settings/provider/chat/UploadVideoEntityTransConf;", "<init>", "(Lcom/larus/settings/provider/chat/UploadVideoEntityLimitConf;Lcom/larus/settings/provider/chat/UploadVideoEntityTransConf;)V", "getLimitConf", "()Lcom/larus/settings/provider/chat/UploadVideoEntityLimitConf;", "getTransConf", "()Lcom/larus/settings/provider/chat/UploadVideoEntityTransConf;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class r2 {

    @SerializedName("limit_conf")
    private final s2 limitConf;

    @SerializedName("trans_conf")
    private final t2 transConf;

    public r2() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r2) == true) goto L8;
        return false;
    L8:
        r2 r6 = (r2) r5;
        if (Intrinsics.areEqual(this.limitConf, r6.limitConf) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transConf, r6.transConf) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        s2 r0 = this.limitConf;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        t2 r4 = this.transConf;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadVideoEntityConf(limitConf=" + this.limitConf + ", transConf=" + this.transConf + ')';
    }

    public final s2 a() {
        return this.limitConf;
    }

    public final t2 b() {
        return this.transConf;
    }

    public r2(int r3) {
        s2 r4 = new s2(null);
        t2 r0 = new t2(0);
        this.limitConf = r4;
        this.transConf = r0;
    }
}
