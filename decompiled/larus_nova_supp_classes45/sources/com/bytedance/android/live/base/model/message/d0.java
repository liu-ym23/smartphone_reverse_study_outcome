package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.liveinteract.plantform.model.IChannelLinkUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/message/d0;", "Lvh7/c;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/IChannelLinkUser;", "getChannelLinkmicUserList", "()Ljava/util/List;", "getChannelLinkmicUserList$annotations", "()V", "channelLinkmicUserList", "", "getRtcRoomIdStr", "()Ljava/lang/String;", "getRtcRoomIdStr$annotations", "rtcRoomIdStr", "", "getVersion", "()J", "getVersion$annotations", "version", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d0 extends vh7.c<d0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "channel_linkmic_users")
    List<IChannelLinkUser> getChannelLinkmicUserList();

    @FieldName(name = "rtc_room_id_str")
    String getRtcRoomIdStr();

    @FieldName(name = "version")
    long getVersion();
}
