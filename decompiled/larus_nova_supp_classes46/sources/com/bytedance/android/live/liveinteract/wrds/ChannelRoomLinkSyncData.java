package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/wrds/ChannelRoomLinkSyncData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/wrds/a;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser;", "channelLinkUsers", "Ljava/util/List;", "getChannelLinkUsers", "()Ljava/util/List;", "setChannelLinkUsers", "(Ljava/util/List;)V", "", "rtcRoomIdStr", "Ljava/lang/String;", "getRtcRoomIdStr", "()Ljava/lang/String;", "setRtcRoomIdStr", "(Ljava/lang/String;)V", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChannelRoomLinkSyncData extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("channel_link_users")
    protected List<? extends IChannelLinkUser> channelLinkUsers;

    @SerializedName("rtc_room_id_str")
    protected String rtcRoomIdStr;

    public ChannelRoomLinkSyncData() {
        super(a.class);
        this.channelLinkUsers = new ArrayList();
    }

    @Override // com.bytedance.android.live.liveinteract.wrds.a
    public List<IChannelLinkUser> getChannelLinkUsers() {
        return this.channelLinkUsers;
    }

    @Override // com.bytedance.android.live.liveinteract.wrds.a
    public String getRtcRoomIdStr() {
        return this.rtcRoomIdStr;
    }

    public ChannelRoomLinkSyncData(am3.g r6) {
        super(a.class);
        this.channelLinkUsers = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.channelLinkUsers.add(vh7.f.a(r6, IChannelLinkUser.class));
        goto L3
    L8:
        if (r2 != 3) goto L9;
        this.rtcRoomIdStr = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this.channelLinkUsers.isEmpty() == false) goto L25;
        this.channelLinkUsers = new ArrayList();
        return;
    }

    public void setChannelLinkUsers(List<? extends IChannelLinkUser> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.channelLinkUsers = r2;
    }

    public void setRtcRoomIdStr(String r1) {
        this.rtcRoomIdStr = r1;
    }
}
