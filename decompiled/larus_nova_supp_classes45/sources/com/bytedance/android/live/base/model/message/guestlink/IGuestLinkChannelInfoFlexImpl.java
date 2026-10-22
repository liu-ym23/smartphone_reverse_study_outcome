package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.GuestLinkChannelInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b?\u0010@R;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR;\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR+\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R/\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001d8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010'\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0007\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R+\u0010+\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0007\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R+\u0010/\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0007\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R+\u00103\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R+\u00107\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0007\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R/\u0010>\u001a\u0004\u0018\u0001082\b\u0010\u0005\u001a\u0004\u0018\u0001088V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0007\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/IGuestLinkChannelInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/a;", "", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "<set-?>", "linkedUsers$delegate", "Ljava/lang/Object;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "linkedUsers", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "channelUsers$delegate", "getChannelUsers", "setChannelUsers", "channelUsers", "", "channelId$delegate", "getChannelId", "()J", "setChannelId", "(J)V", "channelId", "score$delegate", "getScore", "setScore", "score", "", "scoreStr$delegate", "getScoreStr", "()Ljava/lang/String;", "setScoreStr", "(Ljava/lang/String;)V", "scoreStr", "callDuration$delegate", "getCallDuration", "setCallDuration", "callDuration", "startTimeMs$delegate", "getStartTimeMs", "setStartTimeMs", "startTimeMs", "version$delegate", "getVersion", "setVersion", "version", "linkThreshold$delegate", "getLinkThreshold", "setLinkThreshold", "linkThreshold", "channelUserCount$delegate", "getChannelUserCount", "setChannelUserCount", "channelUserCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "channelBackground$delegate", "getChannelBackground", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setChannelBackground", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "channelBackground", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestLinkChannelInfoFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("call_duration")
    protected long _$$callDuration;

    @SerializedName("channel_background")
    protected IVoiceLiveTheme _$$channelBackground;

    @SerializedName("channel_id")
    protected long _$$channelId;

    @SerializedName("channel_user_count")
    protected long _$$channelUserCount;

    @SerializedName("channel_users")
    protected List<? extends IBaseUser> _$$channelUsers;

    @SerializedName("link_threshold")
    protected long _$$linkThreshold;

    @SerializedName("linked_users")
    protected List<? extends k> _$$linkedUsers;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("score_str")
    protected String _$$scoreStr;

    @SerializedName("start_time_ms")
    protected long _$$startTimeMs;

    @SerializedName("version")
    protected long _$$version;

    public IGuestLinkChannelInfoFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getCallDuration() {
        return this._$$callDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final IVoiceLiveTheme getChannelBackground() {
        return this._$$channelBackground;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getChannelId() {
        return this._$$channelId;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getChannelUserCount() {
        return this._$$channelUserCount;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final List<IBaseUser> getChannelUsers() {
        return this._$$channelUsers;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getLinkThreshold() {
        return this._$$linkThreshold;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final List<k> getLinkedUsers() {
        return this._$$linkedUsers;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final String getScoreStr() {
        return this._$$scoreStr;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getStartTimeMs() {
        return this._$$startTimeMs;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final long getVersion() {
        return this._$$version;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, java.lang.Object] */
    public IGuestLinkChannelInfoFlexImpl(am3.g r5) {
        super(a.class);
        this._$$linkedUsers = new ArrayList();
        this._$$channelUsers = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L20;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this._$$channelBackground = vh7.f.a(r5, IVoiceLiveTheme.class);
        goto L3
    L9:
        this._$$scoreStr = am3.h.c(r5);
        goto L3
    L10:
        this._$$channelUserCount = r5.j();
        goto L3
    L11:
        this._$$linkThreshold = r5.j();
        goto L3
    L12:
        this._$$version = r5.j();
        goto L3
    L13:
        this._$$startTimeMs = r5.j();
        goto L3
    L14:
        this._$$callDuration = r5.j();
        goto L3
    L15:
        this._$$score = r5.j();
        goto L3
    L16:
        List r4 = this._$$channelUsers;
        Class r6 = IBaseUser.class;
    L18:
        r4.add(vh7.f.a(r5, r6));
        goto L3
    L17:
        r4 = this._$$linkedUsers;
        r6 = k.class;
        goto L18
    L19:
        this._$$channelId = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L20:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setCallDuration(long r1) {
        this._$$callDuration = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setChannelBackground(IVoiceLiveTheme r1) {
        this._$$channelBackground = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setChannelId(long r1) {
        this._$$channelId = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setChannelUserCount(long r1) {
        this._$$channelUserCount = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setChannelUsers(List<? extends IBaseUser> r1) {
        this._$$channelUsers = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setLinkThreshold(long r1) {
        this._$$linkThreshold = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setLinkedUsers(List<? extends k> r1) {
        this._$$linkedUsers = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setScore(long r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setScoreStr(String r1) {
        this._$$scoreStr = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setStartTimeMs(long r1) {
        this._$$startTimeMs = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.guestlink.a
    public final void setVersion(long r1) {
        this._$$version = r1;
    }
}
