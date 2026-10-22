package com.bytedance.android.live.base.model.media;

import com.bytedance.android.live.base.model.share.ShareSourceInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.FileUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class Media implements IPlayable {
    public static final int CELL_STYLE_A = 1;
    public static final int CELL_STYLE_B = 2;
    public static final int CELL_STYLE_C = 3;
    public static final int MEDIA_DETAIL_TYPE_AD = 1;
    public static final int MEDIA_DETAIL_TYPE_MEDIA = 0;

    @SerializedName("ad_info")
    private MediaAdInfo adInfo;

    @SerializedName("at_users")
    private List<TextExtraStruct> aiteUserItems;

    @SerializedName("allow_comment")
    private boolean allowComment;

    @SerializedName("allow_dislike")
    private boolean allowDislike;

    @SerializedName("allow_share")
    private boolean allowShare;
    private long apiTime;

    @SerializedName("author")
    private IBaseUser author;

    @SerializedName("auto_play")
    private int autoPlay;

    @SerializedName("cell_height")
    private int cellHeight;

    @SerializedName("cell_style")
    private int cellStyle;

    @SerializedName("cell_width")
    private int cellWidth;

    @SerializedName("comment_delay")
    private int commentDelay;

    @SerializedName("comment_prompts")
    private String commentPrompts;

    @SerializedName("commerce")
    private a commerce;

    @SerializedName("create_time")
    private long createTime;
    private long danmakuShowTime;

    @SerializedName("private_info")
    private MediaDebugInfo debugInfo;

    @SerializedName("description")
    private String description;

    @SerializedName("display_style")
    private int displayStyle;

    @SerializedName("enable_send_flame")
    private boolean enableSendFlame;

    @SerializedName("feed_tips")
    private String feedTips;

    @SerializedName("feed_tips_type")
    private int feedTipsType;

    @SerializedName("from_ad")
    private boolean fromAd;

    @SerializedName("guide_card_id")
    private int guideCardId;

    @SerializedName("has_free_flame")
    private boolean hasFreeFlame;

    @SerializedName("has_sync_aweme")
    private boolean hasSyncAweme;

    @SerializedName("hashtag")
    private HashTag hashTag;

    @SerializedName("hide_nickname")
    private boolean hideNickName;

    @SerializedName("id")
    private long id;
    private boolean isDeleted;

    @SerializedName("is_rich")
    private int isRich;

    @SerializedName("stats")
    private MediaItemStats itemStats;

    @SerializedName("location")
    private String location;
    private int mDetailType;

    @SerializedName("mark")
    private VideoMark mark;

    @SerializedName("recommend_reason")
    private MediaRecommendReason mediaRecommendReason;

    @SerializedName("media_type")
    private int mediaType;

    @SerializedName("song")
    private Music music;

    @SerializedName("new_cell_style")
    private int newCellStyle;
    private boolean noNeedQuery;

    @SerializedName("position")
    private String position;

    @SerializedName("share_description")
    private String shareDesc;

    @SerializedName("share_enable")
    private boolean shareEnable;

    @SerializedName("share_prompts")
    private String sharePrompts;

    @SerializedName("share_source_info")
    private ShareSourceInfo shareSourceInfo;

    @SerializedName("share_strong_guide")
    private int shareStrongGuide;

    @SerializedName("share_text")
    private String shareText;

    @SerializedName("share_tips")
    private String shareTips;

    @SerializedName("share_title")
    private String shareTitle;

    @SerializedName("share_url")
    private String shareUrl;

    @SerializedName("status")
    private int status;

    @SerializedName("title")
    private String text;

    @SerializedName("tips")
    private String tips;

    @SerializedName("tips_url")
    private String tipsUrl;

    @SerializedName("user_bury")
    private int userBury;

    @SerializedName("user_digg")
    private int userDigg;

    @SerializedName(FileUtils.VIDEO)
    private VideoModel videoModel;

    @SerializedName("video_pic_num")
    private int videoPicNum;

    @SerializedName("weibo_share_title")
    private String weiboShareTitle;

    public @interface MediaDetailType {
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public String getPlayKey() {
        return null;
    }

    public boolean isNativeAd() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public k getVideoCoverImage() {
        VideoModel r0 = this.videoModel;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getCoverType() == VideoModel.CoverType.MEDIUM) goto L8;
        return this.videoModel.getCoverModel();
    L8:
        return this.videoModel.getCoverMediumModel();
    }

    public Media() {
        this.mDetailType = 0;
        this.fromAd = false;
    }

    public String getAdStatus() {
        if (isNativeAd() == false) goto L6;
        return "ad";
    L6:
        if (isFromAd() == false) goto L8;
        return "normal";
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public boolean isBitRate() {
        if (getVideoModel() != null) goto L5;
        return false;
    L5:
        if (getVideoModel().getQualityInfo() != null) goto L7;
        return false;
    L7:
        if (getVideoModel().getQualityInfo().size() <= 1) goto L12;
        return true;
    L12:
        return false;
    }

    public MediaAdInfo getAdInfo() {
        return this.adInfo;
    }

    public List<TextExtraStruct> getAiteUserItems() {
        return this.aiteUserItems;
    }

    public long getApiTime() {
        return this.apiTime;
    }

    public IBaseUser getAuthor() {
        return this.author;
    }

    public int getAutoPlay() {
        return this.autoPlay;
    }

    public int getCellHeight() {
        return this.cellHeight;
    }

    public int getCellStyle() {
        return this.cellStyle;
    }

    public int getCellWidth() {
        return this.cellWidth;
    }

    public int getCommentDelay() {
        return this.commentDelay;
    }

    public String getCommentPrompts() {
        return this.commentPrompts;
    }

    public a getCommerce() {
        return this.commerce;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getDanmakuShowTime() {
        return this.danmakuShowTime;
    }

    public MediaDebugInfo getDebugInfo() {
        return this.debugInfo;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDetailType() {
        return this.mDetailType;
    }

    public int getDisplayStyle() {
        return this.displayStyle;
    }

    public String getFeedTips() {
        return this.feedTips;
    }

    public int getFeedTipsType() {
        return this.feedTipsType;
    }

    public int getGuideCardId() {
        return this.guideCardId;
    }

    public HashTag getHashTag() {
        return this.hashTag;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public long getId() {
        return this.id;
    }

    public int getIsRich() {
        return this.isRich;
    }

    public MediaItemStats getItemStats() {
        return this.itemStats;
    }

    public String getLocation() {
        return this.location;
    }

    public VideoMark getMark() {
        return this.mark;
    }

    public MediaRecommendReason getMediaRecommendReason() {
        return this.mediaRecommendReason;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public Music getMusic() {
        return this.music;
    }

    public int getNewCellStyle() {
        return this.newCellStyle;
    }

    public String getPosition() {
        return this.position;
    }

    public String getShareDesc() {
        return this.shareDesc;
    }

    public boolean getShareEnable() {
        return this.shareEnable;
    }

    public String getSharePrompts() {
        return this.sharePrompts;
    }

    public ShareSourceInfo getShareSourceInfo() {
        return this.shareSourceInfo;
    }

    public int getShareStrongGuide() {
        return this.shareStrongGuide;
    }

    public String getShareText() {
        return this.shareText;
    }

    public String getShareTips() {
        return this.shareTips;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public int getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public String getTips() {
        return this.tips;
    }

    public String getTipsUrl() {
        return this.tipsUrl;
    }

    public int getUserBury() {
        return this.userBury;
    }

    public int getUserDigg() {
        return this.userDigg;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public VideoModel getVideoModel() {
        return this.videoModel;
    }

    public int getVideoPicNum() {
        return this.videoPicNum;
    }

    public String getWeiboShareTitle() {
        return this.weiboShareTitle;
    }

    public boolean isAllowComment() {
        return this.allowComment;
    }

    public boolean isAllowDislike() {
        return this.allowDislike;
    }

    public boolean isAllowShare() {
        return this.allowShare;
    }

    @Override // com.bytedance.android.live.base.model.media.IPlayable
    public boolean isDeleted() {
        return this.isDeleted;
    }

    public boolean isEnableSendFlame() {
        return this.enableSendFlame;
    }

    public boolean isFromAd() {
        return this.fromAd;
    }

    public boolean isHasFreeFlame() {
        return this.hasFreeFlame;
    }

    public boolean isHasSyncAweme() {
        return this.hasSyncAweme;
    }

    public boolean isHideNickName() {
        return this.hideNickName;
    }

    public boolean isNoNeedQuery() {
        return this.noNeedQuery;
    }

    public boolean isShareEnable() {
        return this.shareEnable;
    }

    public void setAdInfo(MediaAdInfo r1) {
        this.adInfo = r1;
    }

    public void setAiteUserItems(List<TextExtraStruct> r1) {
        this.aiteUserItems = r1;
    }

    public void setAllowComment(boolean r1) {
        this.allowComment = r1;
    }

    public void setAllowDislike(boolean r1) {
        this.allowDislike = r1;
    }

    public void setAllowShare(boolean r1) {
        this.allowShare = r1;
    }

    public void setApiTime(long r1) {
        this.apiTime = r1;
    }

    public void setAuthor(IBaseUser r1) {
        this.author = r1;
    }

    public void setAutoPlay(int r1) {
        this.autoPlay = r1;
    }

    public void setCellHeight(int r1) {
        this.cellHeight = r1;
    }

    public void setCellStyle(int r3) {
        if (r3 != 1) goto L5;
    L9:
        this.cellStyle = r3;
        return;
    L5:
        if (r3 == 2) goto L9;
        if (r3 == 3) goto L9;
        r3 = 1;
        goto L9
    }

    public void setCellWidth(int r1) {
        this.cellWidth = r1;
    }

    public void setCommentDelay(int r1) {
        this.commentDelay = r1;
    }

    public void setCommentPrompts(String r1) {
        this.commentPrompts = r1;
    }

    public void setCommerce(a r1) {
        this.commerce = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setDanmakuShowTime(long r1) {
        this.danmakuShowTime = r1;
    }

    public void setDebugInfo(MediaDebugInfo r1) {
        this.debugInfo = r1;
    }

    public void setDeleted(boolean r1) {
        this.isDeleted = r1;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setDetailType(int r1) {
        this.mDetailType = r1;
    }

    public void setDisplayStyle(int r1) {
        this.displayStyle = r1;
    }

    public void setEnableSendFlame(boolean r1) {
        this.enableSendFlame = r1;
    }

    public void setFeedTips(String r1) {
        this.feedTips = r1;
    }

    public void setFeedTipsType(int r1) {
        this.feedTipsType = r1;
    }

    public void setFromAd(boolean r1) {
        this.fromAd = r1;
    }

    public void setGuideCardId(int r1) {
        this.guideCardId = r1;
    }

    public void setHasFreeFlame(boolean r1) {
        this.hasFreeFlame = r1;
    }

    public void setHasSyncAweme(boolean r1) {
        this.hasSyncAweme = r1;
    }

    public void setHashTag(HashTag r1) {
        this.hashTag = r1;
    }

    public void setHideNickName(boolean r1) {
        this.hideNickName = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setIsRich(int r1) {
        this.isRich = r1;
    }

    public void setItemStats(MediaItemStats r1) {
        this.itemStats = r1;
    }

    public void setLocation(String r1) {
        this.location = r1;
    }

    public void setMark(VideoMark r1) {
        this.mark = r1;
    }

    public void setMediaRecommendReason(MediaRecommendReason r1) {
        this.mediaRecommendReason = r1;
    }

    public void setMediaType(int r1) {
        this.mediaType = r1;
    }

    public void setMusic(Music r1) {
        this.music = r1;
    }

    public void setNewCellStyle(int r1) {
        this.newCellStyle = r1;
    }

    public void setNoNeedQuery(boolean r1) {
        this.noNeedQuery = r1;
    }

    public void setPosition(String r1) {
        this.position = r1;
    }

    public void setShareDesc(String r1) {
        this.shareDesc = r1;
    }

    public void setShareEnable(boolean r1) {
        this.shareEnable = r1;
    }

    public void setSharePrompts(String r1) {
        this.sharePrompts = r1;
    }

    public void setShareSourceInfo(ShareSourceInfo r1) {
        this.shareSourceInfo = r1;
    }

    public void setShareStrongGuide(int r1) {
        this.shareStrongGuide = r1;
    }

    public void setShareText(String r1) {
        this.shareText = r1;
    }

    public void setShareTips(String r1) {
        this.shareTips = r1;
    }

    public void setShareTitle(String r1) {
        this.shareTitle = r1;
    }

    public void setShareUrl(String r1) {
        this.shareUrl = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }

    public void setTips(String r1) {
        this.tips = r1;
    }

    public void setTipsUrl(String r1) {
        this.tipsUrl = r1;
    }

    public void setUserBury(int r1) {
        this.userBury = r1;
    }

    public void setUserDigg(int r1) {
        this.userDigg = r1;
    }

    public void setVideoModel(VideoModel r1) {
        this.videoModel = r1;
    }

    public void setVideoPicNum(int r1) {
        this.videoPicNum = r1;
    }

    public void setWeiboShareTitle(String r1) {
        this.weiboShareTitle = r1;
    }

    public void update(Media r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getId() == this.id) goto L7;
        return;
    L7:
        this.text = r6.text;
        this.createTime = r6.createTime;
        this.userDigg = r6.userDigg;
        this.userBury = r6.userBury;
        this.mediaType = r6.mediaType;
        this.status = r6.status;
        updateItemStats(r6.itemStats);
        IBaseUser r0 = r6.author;
        if (r0 == null) goto L10;
        this.author = r0;
    L10:
        VideoModel r1 = r6.videoModel;
        if (r1 == null) goto L13;
        this.videoModel = r1;
    L13:
        this.shareUrl = r6.shareUrl;
        this.shareTitle = r6.shareTitle;
        this.shareDesc = r6.shareDesc;
        this.shareEnable = r6.shareEnable;
        this.allowShare = r6.allowShare;
        this.allowComment = r6.allowComment;
        this.allowDislike = r6.allowDislike;
        this.cellStyle = r6.cellStyle;
        this.tips = r6.tips;
        this.tipsUrl = r6.tipsUrl;
        MediaDebugInfo r2 = r6.debugInfo;
        if (r2 == null) goto L16;
        this.debugInfo = r2;
    L16:
        VideoMark r3 = r6.mark;
        if (r3 == null) goto L19;
        this.mark = r3;
    L19:
        this.shareText = r6.shareText;
        this.cellHeight = r6.cellHeight;
        this.cellWidth = r6.cellWidth;
        this.feedTipsType = r6.feedTipsType;
        this.feedTips = r6.feedTips;
        this.location = r6.location;
        this.displayStyle = r6.displayStyle;
        this.commentDelay = r6.commentDelay;
        this.guideCardId = r6.guideCardId;
        this.sharePrompts = r6.sharePrompts;
        this.commentPrompts = r6.commentPrompts;
        this.weiboShareTitle = r6.weiboShareTitle;
        this.shareTips = r6.shareTips;
        this.enableSendFlame = r6.enableSendFlame;
        this.hideNickName = r6.hideNickName;
        this.music = r6.music;
        this.videoPicNum = r6.videoPicNum;
        this.apiTime = r6.getApiTime();
        this.noNeedQuery = r6.noNeedQuery;
        a r7 = r6.commerce;
        if (r7 == null) goto L23;
        this.commerce = r7;
        return;
    }

    public void updateItemStats(MediaItemStats r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        MediaItemStats r0 = this.itemStats;
        if (r0 != null) goto L7;
        this.itemStats = r4;
        return;
    L7:
        r0.setCommentCount(r4.getCommentCount());
        this.itemStats.setDiggCount(Math.max(r4.getDiggCount(), this.itemStats.getDiggCount()));
        this.itemStats.setPlayCount(Math.max(r4.getPlayCount(), this.itemStats.getPlayCount()));
        this.itemStats.setShareCount(Math.max(r4.getShareCount(), this.itemStats.getShareCount()));
    }
}
