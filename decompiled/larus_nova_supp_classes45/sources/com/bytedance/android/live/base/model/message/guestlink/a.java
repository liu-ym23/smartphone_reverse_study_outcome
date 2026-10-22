package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\u0011\u001a\u001e\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u00010\u0002j\u000e\u0012\b\u0012\u00060\fj\u0002`\r\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\n\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\n\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010'\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\n\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\"\u0010+\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\n\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\"\u0010/\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\n\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\"\u00103\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\n\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\"\u00107\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\n\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R$\u0010>\u001a\u0004\u0018\u0001088&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\n\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/a;", "Lvh7/c;", "", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "getLinkedUsers$annotations", "()V", "linkedUsers", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getChannelUsers", "setChannelUsers", "getChannelUsers$annotations", "channelUsers", "", "getChannelId", "()J", "setChannelId", "(J)V", "getChannelId$annotations", "channelId", "getScore", "setScore", "getScore$annotations", "score", "", "getScoreStr", "()Ljava/lang/String;", "setScoreStr", "(Ljava/lang/String;)V", "getScoreStr$annotations", "scoreStr", "getCallDuration", "setCallDuration", "getCallDuration$annotations", "callDuration", "getStartTimeMs", "setStartTimeMs", "getStartTimeMs$annotations", "startTimeMs", "getVersion", "setVersion", "getVersion$annotations", "version", "getLinkThreshold", "setLinkThreshold", "getLinkThreshold$annotations", "linkThreshold", "getChannelUserCount", "setChannelUserCount", "getChannelUserCount$annotations", "channelUserCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getChannelBackground", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setChannelBackground", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "getChannelBackground$annotations", "channelBackground", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.base.model.message.guestlink.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0013a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "call_duration")
    long getCallDuration();

    @FieldName(name = "channel_background")
    IVoiceLiveTheme getChannelBackground();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "channel_user_count")
    long getChannelUserCount();

    @FieldName(name = "channel_users")
    List<IBaseUser> getChannelUsers();

    @FieldName(name = "link_threshold")
    long getLinkThreshold();

    @FieldName(name = "linked_users")
    List<k> getLinkedUsers();

    @FieldName(name = "score")
    long getScore();

    @FieldName(name = "score_str")
    String getScoreStr();

    @FieldName(name = "start_time_ms")
    long getStartTimeMs();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "call_duration#setter")
    void setCallDuration(long r1);

    @FieldName(name = "channel_background#setter")
    void setChannelBackground(IVoiceLiveTheme r1);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r1);

    @FieldName(name = "channel_user_count#setter")
    void setChannelUserCount(long r1);

    @FieldName(name = "channel_users#setter")
    void setChannelUsers(List<? extends IBaseUser> r1);

    @FieldName(name = "link_threshold#setter")
    void setLinkThreshold(long r1);

    @FieldName(name = "linked_users#setter")
    void setLinkedUsers(List<? extends k> r1);

    @FieldName(name = "score#setter")
    void setScore(long r1);

    @FieldName(name = "score_str#setter")
    void setScoreStr(String r1);

    @FieldName(name = "start_time_ms#setter")
    void setStartTimeMs(long r1);

    @FieldName(name = "version#setter")
    void setVersion(long r1);
}
