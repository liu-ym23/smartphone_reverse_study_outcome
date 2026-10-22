package com.bytedance.android.live.base.model.banner;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.OperationCard.OperationMultipleRoom")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/OperationMultipleRoom;", "", "()V", "columTitle", "", "cover", "Lcom/bytedance/android/live/base/model/ImageModel;", "extra", "rooms", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "tag", "Lcom/bytedance/android/live/base/model/banner/OperationMultipleRoomTag;", "title", "type", "", "Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperationMultipleRoom implements h {

    @SerializedName("aggregate_column_title")
    public String columTitle;

    @SerializedName("cover")
    public ImageModel cover;

    @SerializedName("extra")
    public String extra;

    @SerializedName("rooms")
    public List<Room> rooms;

    @SerializedName("tag")
    public OperationMultipleRoomTag tag;

    @SerializedName("title")
    public String title;

    @SerializedName("type")
    public Integer type;

    public OperationMultipleRoom() {
    }

    public OperationMultipleRoom(g r5) {
        this.rooms = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.extra = am3.h.c(r5);
        goto L3
    L8:
        this.type = Integer.valueOf(r5.i());
        goto L3
    L9:
        this.columTitle = am3.h.c(r5);
        goto L3
    L10:
        this.rooms.add(new Room(r5));
        goto L3
    L11:
        this.tag = new OperationMultipleRoomTag(r5);
        goto L3
    L12:
        this.cover = x.a(r5);
        goto L3
    L13:
        this.title = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r0);
    }
}
