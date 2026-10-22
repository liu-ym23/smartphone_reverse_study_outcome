package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.model.LinkRoomFightRoomInfo;
import com.bytedance.android.livesdk.multilink.base.model.n0;
import com.bytedance.android.livesdk.multilink.base.model.s;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightFetchListResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/s;", "", "", "Lcom/bytedance/android/livesdk/multilink/base/model/n0;", "roomLists", "Ljava/util/Map;", "getRoomLists", "()Ljava/util/Map;", "setRoomLists", "(Ljava/util/Map;)V", "<init>", "()V", "RoomList", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightFetchListResult extends FlexModelBase<s> implements s, h {

    @SerializedName("room_lists")
    protected Map<Long, n0> roomLists;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightFetchListResult$RoomList;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/n0;", "", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/model/LinkRoomFightRoomInfo;", "rooms", "Ljava/util/List;", "getRooms", "()Ljava/util/List;", "setRooms", "(Ljava/util/List;)V", "", "roomListType", "I", "getRoomListType", "()I", "setRoomListType", "(I)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class RoomList extends FlexModelBase<n0> implements n0, h {

        @SerializedName("list_type")
        protected int roomListType;

        @SerializedName("rooms")
        protected List<LinkRoomFightRoomInfo> rooms;

        public RoomList() {
            super(n0.class);
            this.rooms = new ArrayList();
        }

        public int getRoomListType() {
            return this.roomListType;
        }

        public List<LinkRoomFightRoomInfo> getRooms() {
            return this.rooms;
        }

        public RoomList(g r6) {
            super(n0.class);
            this.rooms = new ArrayList();
            setThreadSafe(false);
            long r0 = r6.c();
        L3:
            int r2 = r6.f();
            if (r2 == (-1)) goto L12;
            g.a r3 = decodeExtensionFields(r2, r6);
            if (r2 != 1) goto L8;
            this.rooms.add(new LinkRoomFightRoomInfo(r6));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.roomListType = r6.i();
            goto L3
        L9:
            am3.h.d(r3, r6);
            goto L3
        L12:
            r6.d(r0);
            setThreadSafe(true);
            if (this.rooms.isEmpty() == false) goto L25;
            this.rooms = new ArrayList();
            return;
        }

        public void setRoomListType(int r1) {
            this.roomListType = r1;
        }

        public void setRooms(List<LinkRoomFightRoomInfo> r1) {
            this.rooms = r1;
        }
    }

    public LinkRoomFightFetchListResult() {
        super(s.class);
        this.roomLists = new HashMap();
    }

    public Map<Long, n0> getRoomLists() {
        return this.roomLists;
    }

    public LinkRoomFightFetchListResult(g r11) {
        super(s.class);
        this.roomLists = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L7;
        long r6 = r11.c();
        Long r3 = null;
        Object r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = f.a(r11, n0.class);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<Long, n0> r4 = this.roomLists;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, (n0) r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r5, r11);
        goto L3
    L25:
        r11.d(r0);
        setThreadSafe(true);
        if (this.roomLists != null) goto L46;
        this.roomLists = new HashMap();
        return;
    }

    public void setRoomLists(Map<Long, n0> r1) {
        this.roomLists = r1;
    }
}
