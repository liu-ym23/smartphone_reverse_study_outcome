package com.bytedance.android.livesdk.interactivity.api.chatchannel.message;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.RoomChannelStateMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/o;", "Ly32/a;", BuildConfig.FLAVOR, "memberCount", "J", "G", "()J", "setMemberCount", "(J)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/user/User;", "topUserList", "Ljava/util/List;", "P", "()Ljava/util/List;", "setTopUserList", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "channelName", "Ljava/lang/String;", "getChannelName", "()Ljava/lang/String;", "setChannelName", "(Ljava/lang/String;)V", "owner", "Lcom/bytedance/android/live/base/model/user/User;", "H", "()Lcom/bytedance/android/live/base/model/user/User;", "setOwner", "(Lcom/bytedance/android/live/base/model/user/User;)V", "needApprovalUser", "getNeedApprovalUser", "setNeedApprovalUser", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o extends y32.a implements vh7.h {

    @SerializedName("channel_name")
    protected String channelName;

    @SerializedName("member_count")
    protected long memberCount;

    @SerializedName("need_approval_user")
    protected User needApprovalUser;

    @SerializedName("owner")
    protected User owner;

    @SerializedName("top_user_list")
    protected List<? extends User> topUserList;

    public o() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.RoomChannelState;
    }

    public final long G() {
        return this.memberCount;
    }

    public final User H() {
        return this.owner;
    }

    public final List<User> P() {
        return this.topUserList;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public o(am3.g r5) {
        this.topUserList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.owner = new User(r5);
        goto L3
    L8:
        this.needApprovalUser = new User(r5);
        goto L3
    L9:
        this.channelName = am3.h.c(r5);
        goto L3
    L10:
        this.topUserList.add(new User(r5));
        goto L3
    L11:
        this.memberCount = r5.j();
        goto L3
    L12:
        ((BaseMessage) this).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
