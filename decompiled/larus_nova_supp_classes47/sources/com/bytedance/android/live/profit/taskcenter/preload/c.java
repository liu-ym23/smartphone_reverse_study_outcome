package com.bytedance.android.live.profit.taskcenter.preload;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/preload/c;", "", "", Constants.Keys.DATA, "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "timeStamp", "J", "getTimeStamp", "()J", "e", "(J)V", "roomId", "getRoomId", "d", "anchorId", "getAnchorId", "b", "userId", "getUserId", "f", "origin", "a", "setOrigin", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName(Constants.Keys.DATA)
    private String data;

    @SerializedName("origin")
    private String origin;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("cache_timestamp")
    private long timeStamp;

    @SerializedName("user_id")
    private String userId;

    public c() {
        this.data = "";
        this.roomId = "";
        this.anchorId = "";
        this.userId = "";
        this.origin = "";
    }

    public final String a() {
        return this.origin;
    }

    public final void b(String r1) {
        this.anchorId = r1;
    }

    public final void c(String r1) {
        this.data = r1;
    }

    public final void d(String r1) {
        this.roomId = r1;
    }

    public final void e(long r1) {
        this.timeStamp = r1;
    }

    public final void f(String r1) {
        this.userId = r1;
    }
}
