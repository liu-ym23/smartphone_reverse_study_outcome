package oq0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Loq0/c;", "", "", "recordValue", "J", "a", "()J", "c", "(J)V", "timestamp", "b", "d", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("record_value")
    private long recordValue;

    @SerializedName("timestamp")
    private long timestamp;

    public c() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L10;
        c r7 = (c) r6;
        if (this.recordValue == r7.recordValue) goto L8;
        return false;
    L8:
        if (this.timestamp == r7.timestamp) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.recordValue;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.timestamp;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "HighIntentionPrefRecordItem(recordValue=" + this.recordValue + ", timestamp=" + this.timestamp + ")";
    }

    public final long a() {
        return this.recordValue;
    }

    public final long b() {
        return this.timestamp;
    }

    public c(int r3) {
        this.recordValue = 0;
        this.timestamp = 0;
    }

    public final void c(long r1) {
        this.recordValue = r1;
    }

    public final void d(long r1) {
        this.timestamp = r1;
    }
}
