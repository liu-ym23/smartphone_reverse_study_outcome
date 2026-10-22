package com.bytedance.android.live.liveinteract.revenue.linkroomfight.model;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.InviteSource;
import com.bytedance.android.livesdk.multilink.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.link.ILinkInviteRoomInfo;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/model/LinkRoomFightRoomInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/x;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;", "roomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;", "getRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;", "setRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/link/ILinkInviteRoomInfo;)V", "", "inviteStatus", "I", "getInviteStatus", "()I", "setInviteStatus", "(I)V", "Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "inviteSourceType", "Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "getInviteSourceType", "()Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;", "setInviteSourceType", "(Lcom/bytedance/android/livesdk/chatroom/model/InviteSource;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRoomFightRoomInfo extends FlexModelBase<x> implements x, h {
    private InviteSource inviteSourceType;

    @SerializedName("invite_status")
    protected int inviteStatus;

    @SerializedName("room_info")
    protected ILinkInviteRoomInfo roomInfo;

    @SerializedName("user")
    protected IBaseUser user;

    public LinkRoomFightRoomInfo() {
        super(x.class);
        this.inviteSourceType = InviteSource.UNKNOWN;
    }

    public InviteSource getInviteSourceType() {
        return this.inviteSourceType;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public ILinkInviteRoomInfo getRoomInfo() {
        return this.roomInfo;
    }

    public IBaseUser getUser() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdkapi.depend.model.live.link.ILinkInviteRoomInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public LinkRoomFightRoomInfo(g r6) {
        super(x.class);
        this.inviteSourceType = InviteSource.UNKNOWN;
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.user = f.a(r6, IBaseUser.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.roomInfo = f.a(r6, ILinkInviteRoomInfo.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.inviteStatus = r6.i();
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setInviteSourceType(InviteSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inviteSourceType = r2;
    }

    public void setInviteStatus(int r1) {
        this.inviteStatus = r1;
    }

    public void setRoomInfo(ILinkInviteRoomInfo r1) {
        this.roomInfo = r1;
    }

    public void setUser(IBaseUser r1) {
        this.user = r1;
    }
}
