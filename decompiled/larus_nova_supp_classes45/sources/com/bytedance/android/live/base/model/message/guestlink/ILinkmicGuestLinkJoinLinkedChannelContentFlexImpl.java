package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.im.LinkmicGuestLinkJoinLinkedChannelContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR+\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR+\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR/\u0010)\u001a\u0004\u0018\u00010#2\b\u0010\u0004\u001a\u0004\u0018\u00010#8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/ILinkmicGuestLinkJoinLinkedChannelContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/g;", "", "<set-?>", "channelId$delegate", "Ljava/lang/Object;", "getChannelId", "()J", "setChannelId", "(J)V", "channelId", "", "rtcExtInfo$delegate", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "rtcExtInfo", "liveCoreInfo$delegate", "getLiveCoreInfo", "setLiveCoreInfo", "liveCoreInfo", "score$delegate", "getScore", "setScore", "score", "callDuration$delegate", "getCallDuration", "setCallDuration", "callDuration", "linkThreshold$delegate", "getLinkThreshold", "setLinkThreshold", "linkThreshold", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "channelBackground$delegate", "getChannelBackground", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setChannelBackground", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "channelBackground", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGuestLinkJoinLinkedChannelContentFlexImpl extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("call_duration")
    protected long _$$callDuration;

    @SerializedName("channel_background")
    protected IVoiceLiveTheme _$$channelBackground;

    @SerializedName("channel_id")
    protected long _$$channelId;

    @SerializedName("link_threshold")
    protected long _$$linkThreshold;

    @SerializedName("live_core_info")
    protected String _$$liveCoreInfo;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfo;

    @SerializedName("score")
    protected long _$$score;

    public ILinkmicGuestLinkJoinLinkedChannelContentFlexImpl() {
        super(g.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final long getCallDuration() {
        return this._$$callDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final IVoiceLiveTheme getChannelBackground() {
        return this._$$channelBackground;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final long getChannelId() {
        return this._$$channelId;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final long getLinkThreshold() {
        return this._$$linkThreshold;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final String getLiveCoreInfo() {
        return this._$$liveCoreInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final String getRtcExtInfo() {
        return this._$$rtcExtInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final long getScore() {
        return this._$$score;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, java.lang.Object] */
    public ILinkmicGuestLinkJoinLinkedChannelContentFlexImpl(am3.g r5) {
        super(g.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$channelBackground = vh7.f.a(r5, IVoiceLiveTheme.class);
        goto L3
    L9:
        this._$$linkThreshold = r5.j();
        goto L3
    L10:
        this._$$callDuration = r5.j();
        goto L3
    L11:
        this._$$score = r5.j();
        goto L3
    L12:
        this._$$liveCoreInfo = am3.h.c(r5);
        goto L3
    L13:
        this._$$rtcExtInfo = am3.h.c(r5);
        goto L3
    L14:
        this._$$channelId = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setCallDuration(long r1) {
        this._$$callDuration = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setChannelBackground(IVoiceLiveTheme r1) {
        this._$$channelBackground = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setChannelId(long r1) {
        this._$$channelId = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setLinkThreshold(long r1) {
        this._$$linkThreshold = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setLiveCoreInfo(String r1) {
        this._$$liveCoreInfo = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setRtcExtInfo(String r1) {
        this._$$rtcExtInfo = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.g
    public final void setScore(long r1) {
        this._$$score = r1;
    }
}
