package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room_channel.CreateChannelResponse.ResponseData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/f;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "channelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "a", "()Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "setChannelInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "createTip", "Lcom/bytedance/android/livesdkapi/message/Text;", "b", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setCreateTip", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", BuildConfig.FLAVOR, "guideToast", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGuideToast", "(Ljava/lang/String;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("channel_info")
    protected RoomChannelInfo channelInfo;

    @SerializedName("create_tips")
    protected Text createTip;

    @SerializedName("guide_toast")
    protected String guideToast;

    public f() {
    }

    public f(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.channelInfo = new RoomChannelInfo(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.createTip = _Text_ProtoDecoder.decodeStatic(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.guideToast = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final RoomChannelInfo a() {
        return this.channelInfo;
    }

    public final Text b() {
        return this.createTip;
    }

    public final String c() {
        return this.guideToast;
    }
}
