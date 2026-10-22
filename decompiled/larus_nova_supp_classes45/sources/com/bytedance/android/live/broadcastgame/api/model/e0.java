package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.game.api.StartGameResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/e0;", "", "", "play_id", "J", "a", "()J", "setPlay_id", "(J)V", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 implements vh7.h {

    @SerializedName("play_id")
    protected long play_id;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e0) == true) goto L6;
        return false;
    L6:
        if (this.play_id == ((e0) r5).play_id) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r0 = this.play_id;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "NotifyServerGameStartResponse(play_id=" + this.play_id + ")";
    }

    public e0() {
        this.play_id = 0;
    }

    public final long a() {
        return this.play_id;
    }

    public e0(am3.g r7) {
        long r0 = r7.c();
        boolean r2 = false;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L8;
        if (r3 != 1) goto L6;
        this.play_id = r7.j();
        r2 = r2 | true;
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L8:
        r7.d(r0);
        if ((r2 & true) == true) goto L18;
        this.play_id = 0;
        return;
    }
}
