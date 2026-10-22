package com.bytedance.android.live.base.model.banner;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.OperationCard.OperationSingleRoom")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/OperationSingleRoom;", "", "()V", "cover", "Lcom/bytedance/android/live/base/model/ImageModel;", "extra", "", NewBroadcastMonitor.PAGE.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "title", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperationSingleRoom implements h {

    @SerializedName("cover")
    public ImageModel cover;

    @SerializedName("extra")
    public String extra;

    @SerializedName(NewBroadcastMonitor.PAGE.ROOM)
    public Room room;

    @SerializedName("title")
    public String title;

    public OperationSingleRoom() {
    }

    public OperationSingleRoom(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.title = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.cover = x.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.room = new Room(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.extra = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
