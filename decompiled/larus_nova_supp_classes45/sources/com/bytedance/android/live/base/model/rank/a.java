package com.bytedance.android.live.base.model.rank;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.ranklist.Rank")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/model/rank/a;", "", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "d", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "score", "J", "getScore", "()J", "setScore", "(J)V", "rank", "b", "setRank", "", "gapDescription", "Ljava/lang/String;", "getGapDescription", "()Ljava/lang/String;", "setGapDescription", "(Ljava/lang/String;)V", "rawDdData", "getRawDdData", "setRawDdData", "Lcom/bytedance/android/live/base/model/rank/c;", NewBroadcastMonitor.PAGE.ROOM, "Lcom/bytedance/android/live/base/model/rank/c;", "c", "()Lcom/bytedance/android/live/base/model/rank/c;", "setRoom", "(Lcom/bytedance/android/live/base/model/rank/c;)V", "label", "getLabel", "setLabel", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("gap_description")
    protected String gapDescription;

    @SerializedName("label")
    protected String label;

    @SerializedName("rank")
    protected long rank;

    @SerializedName("raw_ad_data")
    protected String rawDdData;

    @SerializedName(NewBroadcastMonitor.PAGE.ROOM)
    protected c room;

    @SerializedName("score")
    protected long score;

    @SerializedName("user")
    protected User user;

    public a() {
    }

    public final Room a() {
        Room r0 = new Room();
        r0.setOwner(this.user);
        c r1 = this.room;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.setCover(r1.cover);
        c r2 = this.room;
        Intrinsics.checkNotNull(r2);
        Long r3 = r2.id;
        Intrinsics.checkNotNull(r3);
        r0.setId(r3.longValue());
        r0.setIdStr(this.room.idStr);
        c r4 = this.room;
        Intrinsics.checkNotNull(r4);
        r0.setTitle(r4.title);
        c r5 = this.room;
        Intrinsics.checkNotNull(r5);
        r0.setUserCount(r5.userCount);
        c r6 = this.room;
        Intrinsics.checkNotNull(r6);
        r0.setContentLabel(r6.contentLabel);
    L5:
        return r0;
    }

    public final long b() {
        return this.rank;
    }

    public final c c() {
        return this.room;
    }

    public final User d() {
        return this.user;
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L27;
        if (r2 != 1) goto L8;
        this.user = new User(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.score = r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.rank = r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.gapDescription = am3.h.c(r5);
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.rawDdData = am3.h.c(r5);
        goto L3
    L16:
        if (r2 != 20) goto L18;
        this.room = new c(r5);
        goto L3
    L18:
        if (r2 != 21) goto L19;
        this.label = am3.h.c(r5);
        goto L3
    L19:
        am3.h.e(r5);
        goto L3
    L27:
        r5.d(r0);
    }
}
