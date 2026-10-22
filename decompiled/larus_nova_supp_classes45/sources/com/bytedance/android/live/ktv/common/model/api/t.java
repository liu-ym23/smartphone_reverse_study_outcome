package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/t;", "", "", "begin", "J", "a", "()J", "setBegin", "(J)V", "end", "b", "setEnd", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t implements vh7.h {

    @SerializedName("begin")
    protected long begin;

    @SerializedName("end")
    protected long end;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof t) == false) goto L10;
        t r7 = (t) r6;
        if (this.begin == r7.begin) goto L8;
        return false;
    L8:
        if (this.end == r7.end) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.begin;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.end;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "GuessWordPos(begin=" + this.begin + ", end=" + this.end + ")";
    }

    public t() {
        this.begin = 0;
        this.end = 0;
    }

    public final long a() {
        return this.begin;
    }

    public final long b() {
        return this.end;
    }

    public t(am3.g r7) {
        long r0 = r7.c();
        int r2 = 0;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L11;
        if (r3 != 1) goto L7;
        this.begin = r7.j();
        r2 = r2 | 1;
        goto L3
    L7:
        if (r3 != 2) goto L8;
        this.end = r7.j();
        r2 = r2 | 2;
        goto L3
    L8:
        am3.h.e(r7);
        goto L3
    L11:
        r7.d(r0);
        if ((r2 & 1) != 0) goto L15;
        this.begin = 0;
    L15:
        if ((r2 & 2) != 0) goto L27;
        this.end = 0;
        return;
    }
}
