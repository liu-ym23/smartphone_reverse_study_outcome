package com.bytedance.android.live.base.model.data;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/data/b;", "", "", "msgId", "J", "b", "()J", "setMsgId", "(J)V", "likeCount", "a", "g", "", "isLike", "Z", "e", "()Z", "f", "(Z)V", "isDislike", "d", "setDislike", "version", "c", "h", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements vh7.h {

    @SerializedName("is_dislike")
    protected boolean isDislike;

    @SerializedName("is_like")
    protected boolean isLike;

    @SerializedName("like_count")
    protected long likeCount;

    @SerializedName("target_msg_id")
    protected long msgId;

    @SerializedName("version")
    protected long version;

    public b() {
    }

    public final long a() {
        return this.likeCount;
    }

    public final long b() {
        return this.msgId;
    }

    public final long c() {
        return this.version;
    }

    public final boolean d() {
        return this.isDislike;
    }

    public final boolean e() {
        return this.isLike;
    }

    public b(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.msgId = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.likeCount = r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.isLike = am3.h.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.isDislike = am3.h.a(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.version = r5.j();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }

    public final void f(boolean r1) {
        this.isLike = r1;
    }

    public final void g(long r1) {
        this.likeCount = r1;
    }

    public final void h(long r1) {
        this.version = r1;
    }
}
