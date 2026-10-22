package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/u51;", "", "", "enable", "Ljava/lang/Boolean;", "", "inviterTitle", "Ljava/lang/String;", "inviterSubtitle", "inviterExplainImage", "receiverTitle", "receiverSubtitle", "receiverExplainImage", "commentIntroEnable", "commentAudienceStatusSync", "commentIntroLynxUrl", "", "commentIntroVersion", "Ljava/lang/Integer;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u51 {

    @SerializedName("intercom_comment_audience_status_sync")
    public Boolean commentAudienceStatusSync;

    @SerializedName("intercom_comment_intro_enable")
    public Boolean commentIntroEnable;

    @SerializedName("intercom_comment_intro_lynx_url")
    public String commentIntroLynxUrl;

    @SerializedName("intercom_comment_intro_version")
    public Integer commentIntroVersion;

    @SerializedName("enable")
    public Boolean enable;

    @SerializedName("inviter_explain_image")
    public String inviterExplainImage;

    @SerializedName("inviter_subtitle")
    public String inviterSubtitle;

    @SerializedName("inviter_title")
    public String inviterTitle;

    @SerializedName("receiver_explain_image")
    public String receiverExplainImage;

    @SerializedName("receiver_subtitle")
    public String receiverSubtitle;

    @SerializedName("receiver_title")
    public String receiverTitle;

    public u51() {
        Boolean r0 = Boolean.TRUE;
        this.enable = r0;
        this.inviterTitle = "";
        this.inviterSubtitle = "";
        StringBuilder r2 = new StringBuilder("https://");
        LiveCommonConstants r4 = LiveCommonConstants.INSTANCE;
        r2.append(r4.getObjectTosPath());
        r2.append("/obj/live-android/ttlive_inter_comment_caption.png");
        this.inviterExplainImage = r2.toString();
        this.receiverTitle = "";
        this.receiverSubtitle = "";
        this.receiverExplainImage = "https://" + r4.getObjectTosPath() + "/obj/live-android/ttlive_inter_comment_caption.png";
        this.commentIntroEnable = r0;
        this.commentAudienceStatusSync = Boolean.FALSE;
        this.commentIntroLynxUrl = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Fcommunity_intercom_lynx_douyin%2Fpages%2Frule_intro%2Ftemplate.js&gravity=bottom&type=popup&rate_height=365&radius=8&pull_down_close=1&pull_down_indicator_not_show=1";
        this.commentIntroVersion = 1;
    }
}
