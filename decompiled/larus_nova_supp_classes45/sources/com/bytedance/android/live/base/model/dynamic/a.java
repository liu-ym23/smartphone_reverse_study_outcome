package com.bytedance.android.live.base.model.dynamic;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.announce.AnnouncementDynamicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.BannerInRoom;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.moment.LiveDynamicDetailsForAnchorResponse")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010GR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R*\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR*\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010,\u001a\u0004\b=\u0010.\"\u0004\b>\u00100R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/bytedance/android/live/base/model/dynamic/a;", "", "", "maxTime", "J", "getMaxTime", "()J", "setMaxTime", "(J)V", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "push_status", "getPush_status", "setPush_status", "isAnnouncementAvailable", "setAnnouncementAvailable", "hasVideoPermission", "getHasVideoPermission", "setHasVideoPermission", "pendingReleaseCount", "getPendingReleaseCount", "setPendingReleaseCount", "", "nickname", "Ljava/lang/String;", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatar", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatar", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "Lcom/bytedance/android/livesdk/announce/AnnouncementDynamicInfo;", "announcementList", "Ljava/util/List;", "getAnnouncementList", "()Ljava/util/List;", "setAnnouncementList", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/model/dynamic/e;", "noticeList", "getNoticeList", "setNoticeList", "Lcom/bytedance/android/live/base/model/dynamic/b;", "historyList", "getHistoryList", "setHistoryList", "isHideAll", "setHideAll", "Lcom/bytedance/android/livesdkapi/depend/model/live/BannerInRoom;", "bannerList", "getBannerList", "setBannerList", "Lcom/bytedance/android/live/base/model/dynamic/f;", "publishDetail", "Lcom/bytedance/android/live/base/model/dynamic/f;", "getPublishDetail", "()Lcom/bytedance/android/live/base/model/dynamic/f;", "setPublishDetail", "(Lcom/bytedance/android/live/base/model/dynamic/f;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("announcement_data")
    private List<? extends AnnouncementDynamicInfo> announcementList;

    @SerializedName("anchor_avatar")
    private ImageModel avatar;

    @SerializedName("banner")
    private List<? extends BannerInRoom> bannerList;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("has_video_permission")
    private boolean hasVideoPermission;

    @SerializedName("history_data")
    private List<b> historyList;

    @SerializedName("is_announcement_available")
    private boolean isAnnouncementAvailable;

    @SerializedName("hide_all_history")
    private boolean isHideAll;

    @SerializedName("max_time")
    private long maxTime;

    @SerializedName("anchor_nick_name")
    private String nickname;

    @SerializedName("preview_data")
    private List<e> noticeList;

    @SerializedName("pending_release_count")
    private long pendingReleaseCount;

    @SerializedName("preview_guide_publish_data")
    private f publishDetail;

    @SerializedName("push_status")
    private long push_status;

    public a() {
        this.nickname = "";
    }

    public a(am3.g r5) {
        this.nickname = "";
        long r0 = r5.c();
    L4:
        if (r5.f() == (-1)) goto L6;
        am3.h.e(r5);
        goto L4
    L6:
        r5.d(r0);
    }
}
