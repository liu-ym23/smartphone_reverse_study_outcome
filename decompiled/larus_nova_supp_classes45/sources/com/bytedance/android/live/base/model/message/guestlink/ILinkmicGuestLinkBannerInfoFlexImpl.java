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
@ProtoMessage("webcast.im.LinkmicGuestLinkBannerInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkBannerInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/c;", "", "<set-?>", "bannerType$delegate", "Ljava/lang/Object;", "getBannerType", "()I", "setBannerType", "(I)V", "bannerType", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "channelUsers$delegate", "getChannelUsers", "()Ljava/util/List;", "setChannelUsers", "(Ljava/util/List;)V", "channelUsers", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkBannerInfoFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("banner_type")
    protected int _$$bannerType;

    @SerializedName("channel_users")
    protected List<? extends IBaseUser> _$$channelUsers;

    public ILinkmicGuestLinkBannerInfoFlexImpl() {
        super(c.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.c
    public final int getBannerType() {
        return this._$$bannerType;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.c
    public final List<IBaseUser> getChannelUsers() {
        return this._$$channelUsers;
    }

    public ILinkmicGuestLinkBannerInfoFlexImpl(am3.g r6) {
        super(c.class);
        this._$$channelUsers = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$bannerType = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$channelUsers.add(vh7.f.a(r6, IBaseUser.class));
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.c
    public final void setBannerType(int r1) {
        this._$$bannerType = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.c
    public final void setChannelUsers(List<? extends IBaseUser> r1) {
        this._$$channelUsers = r1;
    }
}
