package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.ChatLikeCount")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/base/model/message/a6;", "", "", "count", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "c", "(Ljava/lang/Long;)V", "version", "b", "d", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a6 implements vh7.h {

    @SerializedName("count")
    protected Long count;

    @SerializedName("version")
    protected Long version;

    public a6() {
    }

    public final Long a() {
        return this.count;
    }

    public final Long b() {
        return this.version;
    }

    public a6(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.count = Long.valueOf(r5.j());
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.version = Long.valueOf(r5.j());
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final void c(Long r1) {
        this.count = r1;
    }

    public final void d(Long r1) {
        this.version = r1;
    }
}
