package a60;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"La60/a;", "", "", "maxBatchSize", "I", "a", "()I", "setMaxBatchSize", "(I)V", "maxCacheTime", "b", "setMaxCacheTime", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("max_batch_size")
    private int maxBatchSize;

    @SerializedName("max_cache_time")
    private int maxCacheTime;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (this.maxBatchSize == r4.maxBatchSize) goto L8;
        return false;
    L8:
        if (this.maxCacheTime == r4.maxCacheTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.maxBatchSize * 31) + this.maxCacheTime;
    }

    public final String toString() {
        return "BatchConfig(maxBatchSize=" + this.maxBatchSize + ", maxCacheTime=" + this.maxCacheTime + ")";
    }

    public final int a() {
        return this.maxBatchSize;
    }

    public final int b() {
        return this.maxCacheTime;
    }

    public a(int r1) {
        this.maxBatchSize = 0;
        this.maxCacheTime = 0;
    }
}
