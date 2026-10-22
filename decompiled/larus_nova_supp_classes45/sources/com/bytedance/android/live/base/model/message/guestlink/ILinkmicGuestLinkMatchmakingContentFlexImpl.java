package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestLinkMatchmakingContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkMatchmakingContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/h;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<set-?>", "matchmakingUsers$delegate", "Ljava/lang/Object;", "getMatchmakingUsers", "()Ljava/util/List;", "setMatchmakingUsers", "(Ljava/util/List;)V", "matchmakingUsers", "", "userRole$delegate", "getUserRole", "()I", "setUserRole", "(I)V", "userRole", "", "callDuration$delegate", "getCallDuration", "()J", "setCallDuration", "(J)V", "callDuration", "linkThreshold$delegate", "getLinkThreshold", "setLinkThreshold", "linkThreshold", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkMatchmakingContentFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("call_duration")
    protected long _$$callDuration;

    @SerializedName("link_threshold")
    protected long _$$linkThreshold;

    @SerializedName("matchmaking_users")
    protected List<? extends IBaseUser> _$$matchmakingUsers;

    @SerializedName("user_role")
    protected int _$$userRole;

    public ILinkmicGuestLinkMatchmakingContentFlexImpl() {
        super(h.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final long getCallDuration() {
        return this._$$callDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final long getLinkThreshold() {
        return this._$$linkThreshold;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final List<IBaseUser> getMatchmakingUsers() {
        return this._$$matchmakingUsers;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final int getUserRole() {
        return this._$$userRole;
    }

    public ILinkmicGuestLinkMatchmakingContentFlexImpl(am3.g r6) {
        super(h.class);
        this._$$matchmakingUsers = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$matchmakingUsers.add(vh7.f.a(r6, IBaseUser.class));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$userRole = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$callDuration = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$linkThreshold = r6.j();
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final void setCallDuration(long r1) {
        this._$$callDuration = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final void setLinkThreshold(long r1) {
        this._$$linkThreshold = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final void setMatchmakingUsers(List<? extends IBaseUser> r1) {
        this._$$matchmakingUsers = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.h
    public final void setUserRole(int r1) {
        this._$$userRole = r1;
    }
}
