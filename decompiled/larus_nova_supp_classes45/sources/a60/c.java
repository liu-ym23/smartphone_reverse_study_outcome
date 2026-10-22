package a60;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"La60/c;", "", "", "key", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "rate", "I", "b", "()I", "setRate", "(I)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {
    public transient long a;

    @SerializedName("key")
    private final String key;

    @SerializedName("rate")
    private int rate;

    public c() {
        this(null, 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (this.rate == r4.rate) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.key;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.rate;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "FilterRule(key=" + this.key + ", rate=" + this.rate + ")";
    }

    public final String a() {
        return this.key;
    }

    public final int b() {
        return this.rate;
    }

    public c(String r1, int r2) {
        this.key = r1;
        this.rate = r2;
    }
}
