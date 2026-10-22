package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.grouplive.CollaborateWidget;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.ChangeRoomInfoKt;
import com.bytedance.android.livesdkapi.depend.model.live.IChangeRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/GroupLiveService;", "Lcom/bytedance/android/livesdk/interactivity/api/IGroupLiveService;", "()V", "anchorIdBeforeJump", BuildConfig.FLAVOR, "getAnchorIdBeforeJump", "()Ljava/lang/String;", "setAnchorIdBeforeJump", "(Ljava/lang/String;)V", "requestIdBeforeJump", "getRequestIdBeforeJump", "setRequestIdBeforeJump", "roomIdBeforeJump", BuildConfig.FLAVOR, "getRoomIdBeforeJump", "()J", "setRoomIdBeforeJump", "(J)V", "getCloudCollaborateExtraParams", BuildConfig.FLAVOR, "roomId", "getCollaborateWidgetClass", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GroupLiveService implements IGroupLiveService {
    private String anchorIdBeforeJump;
    private String requestIdBeforeJump;
    private long roomIdBeforeJump;

    public GroupLiveService() {
        this.anchorIdBeforeJump = BuildConfig.FLAVOR;
        this.requestIdBeforeJump = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public String getAnchorIdBeforeJump() {
        return this.anchorIdBeforeJump;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public Class<? extends LiveRecyclableWidget> getCollaborateWidgetClass() {
        return CollaborateWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public String getRequestIdBeforeJump() {
        return this.requestIdBeforeJump;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public long getRoomIdBeforeJump() {
        return this.roomIdBeforeJump;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public Map<String, String> getCloudCollaborateExtraParams(long r17) {
        LinkedHashMap r0 = new LinkedHashMap();
        Long r2 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, r17, 1);
        if (r1 == null) goto L71;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L71;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L71;
        RoomOthersData r5 = r4.others;
        if (r5 == null) goto L71;
        IGroupLiveData r6 = r5.getGroupData();
        if (r6 == null) goto L71;
        int r7 = r6.getGroupLiveMode();
        User r8 = r4.getOwner();
        if (r8 == null) goto L15;
        String r9 = r8.getIdString();
    L17:
        if (r7 != 4) goto L71;
        RoomOthersData r10 = r4.others;
        if (r10 == null) goto L60;
        IChangeRoomInfo r11 = r10.getChangeRoomInfo();
        if (r11 == null) goto L60;
        if (r11.getChangeRoomReason() != ChangeRoomInfoKt.getCHANGE_ROOM_REASON_CLOUD_COLLABORATE()) goto L60;
        RoomOthersData r13 = r4.others;
        if (r13 == null) goto L29;
        IChangeRoomInfo r14 = r13.getChangeRoomInfo();
        if (r14 == null) goto L29;
        long r15 = r14.getBeforeAnchorId();
    L31:
        if (r15 <= 0) goto L60;
        RoomOthersData r16 = r4.others;
        if (r16 == null) goto L37;
        IChangeRoomInfo r18 = r16.getChangeRoomInfo();
        if (r18 == null) goto L37;
        long r19 = r18.getBeforeRoomId();
    L39:
        if (r19 <= 0) goto L60;
        RoomOthersData r20 = r4.others;
        if (r20 == null) goto L45;
        IChangeRoomInfo r21 = r20.getChangeRoomInfo();
        if (r21 == null) goto L45;
        Long r23 = Long.valueOf(r21.getBeforeAnchorId());
    L46:
        r0.put("throw_user_id", String.valueOf(r23));
        RoomOthersData r24 = r4.others;
        if (r24 == null) goto L51;
        IChangeRoomInfo r25 = r24.getChangeRoomInfo();
        if (r25 == null) goto L51;
        r2 = Long.valueOf(r25.getBeforeRoomId());
    L51:
        r0.put("throw_room_id", String.valueOf(r2));
        com.bytedance.android.livesdk.log.filter.o r26 = u.l().c(Room.class);
        if (r26 == null) goto L57;
        Map r27 = r26.getMap();
        if (r27 == null) goto L57;
        String r28 = (String) r27.get("request_id");
        if (r28 == null) goto L57;
    L58:
        r0.put("link_screen_request_id", r28);
        r0.put("is_link_screen_co_rec", "2");
        r0.put("group_live_mode", "4");
    L57:
        r28 = BuildConfig.FLAVOR;
    L45:
        r23 = null;
    L37:
        r19 = 0;
    L29:
        r15 = 0;
    L60:
        if (getAnchorIdBeforeJump().length() <= 0) goto L62;
        boolean r29 = true;
    L63:
        if (r29 == false) goto L71;
        if ((!Intrinsics.areEqual(getAnchorIdBeforeJump(), "0")) == false) goto L71;
        if (getRoomIdBeforeJump() <= 0) goto L71;
        if ((!Intrinsics.areEqual(r9, getAnchorIdBeforeJump())) == false) goto L71;
        r0.put("throw_user_id", getAnchorIdBeforeJump());
        r0.put("throw_room_id", String.valueOf(getRoomIdBeforeJump()));
        r0.put("link_screen_request_id", getRequestIdBeforeJump());
        r0.put("is_link_screen_co_rec", "1");
        r0.put("group_live_mode", "4");
        goto L71
    L62:
        r29 = false;
        goto L63
    L15:
        r9 = null;
    L71:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public void setAnchorIdBeforeJump(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorIdBeforeJump = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public void setRequestIdBeforeJump(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.requestIdBeforeJump = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IGroupLiveService
    public void setRoomIdBeforeJump(long r1) {
        this.roomIdBeforeJump = r1;
    }
}
