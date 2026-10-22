package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010$\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\"\u0010+\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\t\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u00103\u001a\n\u0018\u00010,j\u0004\u0018\u0001`-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\t\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00107\u001a\n\u0018\u00010,j\u0004\u0018\u0001`-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\t\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R$\u0010>\u001a\u0004\u0018\u0001088&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\t\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u00020?8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bD\u0010\t\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010H\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bG\u0010\t\u001a\u0004\bE\u0010'\"\u0004\bF\u0010)¨\u0006I"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/y0;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getGroupShowUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setGroupShowUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getGroupShowUser$annotations", "()V", "groupShowUser", BuildConfig.FLAVOR, "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getDescription$annotations", "description", "getSendButtonText", "setSendButtonText", "getSendButtonText$annotations", "sendButtonText", BuildConfig.FLAVOR, "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "getFanTicketCount$annotations", "fanTicketCount", "getCurRoundFanTicketCount", "setCurRoundFanTicketCount", "getCurRoundFanTicketCount$annotations", "curRoundFanTicketCount", "getShowEndTime", "setShowEndTime", "getShowEndTime$annotations", "showEndTime", BuildConfig.FLAVOR, "getAnchorType", "()I", "setAnchorType", "(I)V", "getAnchorType$annotations", "anchorType", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarBorder", "()Lpy/k;", "setAvatarBorder", "(Lpy/k;)V", "getAvatarBorder$annotations", "avatarBorder", "getBestShowerBgImage", "setBestShowerBgImage", "getBestShowerBgImage$annotations", "bestShowerBgImage", "Lcom/bytedance/android/livesdk/gift/model/p3;", "getShowStatusLabel", "()Lcom/bytedance/android/livesdk/gift/model/p3;", "setShowStatusLabel", "(Lcom/bytedance/android/livesdk/gift/model/p3;)V", "getShowStatusLabel$annotations", "showStatusLabel", BuildConfig.FLAVOR, "isBestUser", "()Z", "setBestUser", "(Z)V", "isBestUser$annotations", "getShowStatus", "setShowStatus", "getShowStatus$annotations", "showStatus", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y0 extends vh7.c<y0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "identity_label")
    int getAnchorType();

    @FieldName(name = "live_avatar_frame_image")
    py.k getAvatarBorder();

    @FieldName(name = "bg_image")
    py.k getBestShowerBgImage();

    @FieldName(name = "group_show_cur_round_fan_ticket_count")
    long getCurRoundFanTicketCount();

    @FieldName(name = "description")
    String getDescription();

    @FieldName(name = "group_show_fan_ticket_count")
    long getFanTicketCount();

    @FieldName(name = "group_show_user")
    IBaseUser getGroupShowUser();

    @FieldName(name = "send_button_text")
    String getSendButtonText();

    @FieldName(name = "show_end_time")
    long getShowEndTime();

    @FieldName(name = "show_status")
    int getShowStatus();

    @FieldName(name = "show_status_label")
    p3 getShowStatusLabel();

    @FieldName(name = "is_best_shower")
    boolean isBestUser();

    @FieldName(name = "identity_label#setter")
    void setAnchorType(int r1);

    @FieldName(name = "live_avatar_frame_image#setter")
    void setAvatarBorder(py.k r1);

    @FieldName(name = "bg_image#setter")
    void setBestShowerBgImage(py.k r1);

    @FieldName(name = "is_best_shower#setter")
    void setBestUser(boolean r1);

    @FieldName(name = "group_show_cur_round_fan_ticket_count#setter")
    void setCurRoundFanTicketCount(long r1);

    @FieldName(name = "description#setter")
    void setDescription(String r1);

    @FieldName(name = "group_show_fan_ticket_count#setter")
    void setFanTicketCount(long r1);

    @FieldName(name = "group_show_user#setter")
    void setGroupShowUser(IBaseUser r1);

    @FieldName(name = "send_button_text#setter")
    void setSendButtonText(String r1);

    @FieldName(name = "show_end_time#setter")
    void setShowEndTime(long r1);

    @FieldName(name = "show_status#setter")
    void setShowStatus(int r1);

    @FieldName(name = "show_status_label#setter")
    void setShowStatusLabel(p3 r1);
}
