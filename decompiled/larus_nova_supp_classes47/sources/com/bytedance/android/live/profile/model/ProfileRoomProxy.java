package com.bytedance.android.live.profile.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileRoomProxy implements ps0.b {
    public final IRoom a;
    public final Lazy b;

    @Override // ps0.b
    public final long getId() {
        return ((Number) this.b.getValue()).longValue();
    }

    @Override // ps0.b
    public final IRoom b() {
        return this.a;
    }

    public final int c() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return (int) r0.getRoomLayout();
    }

    @Override // ps0.b
    public final Long getAutoCover() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.getAutoCover());
    }

    @Override // ps0.b
    public final String getLabels() {
        IRoom r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getLabels();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // ps0.b
    public final IBaseUser getOwner() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOwner();
    }

    @Override // ps0.b
    public final String getOwnerUserIdStr() {
        IRoom r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getOwnerUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return DataType.FALSE;
    }

    @Override // ps0.b
    public final String getRequestId() {
        IRoom r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getRequestId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // ps0.b
    public final LiveMode getStreamType() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getStreamType();
    }

    @Override // ps0.b
    public final boolean isMediaRoom() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isMediaRoom();
    }

    @Override // ps0.b
    public final boolean isVSRoom() {
        IRoom r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isMergeVSRoom() != true) goto L7;
        return true;
    }

    @Override // ps0.b
    public final IRoomOthersData k3() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomOthers();
    }

    public ProfileRoomProxy() {
        this.b = LazyKt.lazy(new ProfileRoomProxy$id$2(this));
    }

    @Override // ps0.b
    public final boolean a() {
        return os0.b.c().getIMicRoomService().isMicRoom(this.a);
    }

    public ProfileRoomProxy(IRoom r1) {
        this();
        this.a = r1;
    }
}
