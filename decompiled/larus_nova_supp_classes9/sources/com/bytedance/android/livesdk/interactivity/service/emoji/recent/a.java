package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/emoji/recent/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "day", "J", "b", "()J", "count", "a", "c", "(J)V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("count")
    private long count;

    @SerializedName("day")
    private final long day;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L10;
        a r7 = (a) r6;
        if (this.day == r7.day) goto L8;
        return false;
    L8:
        if (this.count == r7.count) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.day;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.count;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "DayUseCount(day=" + this.day + ", count=" + this.count + ")";
    }

    public final long a() {
        return this.count;
    }

    public final long b() {
        return this.day;
    }

    public a(long r1) {
        this.day = r1;
        this.count = 1;
    }

    public final void c(long r1) {
        this.count = r1;
    }
}
