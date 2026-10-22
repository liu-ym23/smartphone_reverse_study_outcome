package kq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/model/album/ImageUploadDuplicateStatConfig;", "", "enable", "", "maxCount", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class r {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("max_count")
    private final Integer maxCount;

    public r() {
        this(0);
    }

    public final Boolean a() {
        return this.enable;
    }

    public final Integer b() {
        return this.maxCount;
    }

    public r(int r2) {
        this.enable = Boolean.TRUE;
        this.maxCount = 50;
    }
}
