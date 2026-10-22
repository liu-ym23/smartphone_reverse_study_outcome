package com.ss.android.lark.feed.shared.data.preview;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.biz.im.api.MuteUrgentInfo;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import ieb.a;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FeedPreview extends UIFeedCard implements a {
    public transient LarkNameTag a;
    private int atInfoCount;
    private String customStatusIconKey;
    private List<DigestElement> draftDigestMessage;
    private boolean isCustomer;
    private boolean isDelayed;
    private boolean isDisplayedInDelayedFeed;
    private boolean isSimpleTenant;
    private boolean isTranslateEmojiCode;
    private String lastMessageId;
    private int lastMessagePosition;
    private String markText;
    private MuteUrgentInfo muteUrgentInfo;
    private Digest originDigest;
    private TagData tagData;

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(isRemind()), Boolean.valueOf(this.isShortCutFeed), Integer.valueOf(this.lastMessagePosition), this.lastMessageId, this.markText, Boolean.valueOf(this.isDelayed), Boolean.valueOf(this.isFlag), Boolean.valueOf(this.isDisplayedInDelayedFeed), this.muteUrgentInfo, Integer.valueOf(this.atInfoCount), Boolean.valueOf(this.isCustomer), Boolean.valueOf(this.isSimpleTenant), Boolean.valueOf(this.isTranslateEmojiCode), this.a, this.customStatusIconKey});
    }

    public FeedPreview() {
        this.isTranslateEmojiCode = false;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public FeedPreview clone() throws CloneNotSupportedException {
        FeedPreview r0 = (FeedPreview) super.clone();
        r0.originDigest = this.originDigest;
        r0.lastMessagePosition = this.lastMessagePosition;
        r0.lastMessageId = this.lastMessageId;
        r0.markText = this.markText;
        r0.isDelayed = this.isDelayed;
        r0.isDisplayedInDelayedFeed = this.isDisplayedInDelayedFeed;
        r0.muteUrgentInfo = this.muteUrgentInfo;
        r0.atInfoCount = this.atInfoCount;
        r0.isCustomer = this.isCustomer;
        r0.isSimpleTenant = this.isSimpleTenant;
        r0.tagData = this.tagData;
        r0.isTranslateEmojiCode = this.isTranslateEmojiCode;
        r0.draftDigestMessage = this.draftDigestMessage;
        r0.a = this.a;
        r0.customStatusIconKey = this.customStatusIconKey;
        return r0;
    }

    @Override // ieb.a
    public int getJumpPriority() {
        if (isRemind() == false) goto L9;
        if (getUnreadCount() <= 0) goto L9;
        return 2;
    L9:
        if (isRemind() == false) goto L11;
        return 0;
    L11:
        if (getUnreadCount() <= 0) goto L16;
        return 1;
    L16:
        return 0;
    }

    public boolean isHeaderData() {
        if (getRankPriority() > 35) goto L5;
        return true;
    L5:
        return false;
    }

    public int getAtInfoCount() {
        return this.atInfoCount;
    }

    public String getCustomStatusIconKey() {
        return this.customStatusIconKey;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public List<DigestElement> getDraftDigestMessage() {
        return this.draftDigestMessage;
    }

    public LarkNameTag getFeedNameTag() {
        return this.a;
    }

    public String getLastMessageId() {
        return this.lastMessageId;
    }

    public int getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public String getMarkText() {
        return this.markText;
    }

    public MuteUrgentInfo getMuteUrgentInfo() {
        return this.muteUrgentInfo;
    }

    public Digest getOriginDigest() {
        return this.originDigest;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public boolean isCustomer() {
        return this.isCustomer;
    }

    public boolean isDelayed() {
        return this.isDelayed;
    }

    public boolean isDisplayedInDelayedFeed() {
        return this.isDisplayedInDelayedFeed;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean isFlag() {
        return this.isFlag;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard, com.ss.android.lark.feed.app.entity.IBadgeable
    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean isSimpleTenant() {
        return this.isSimpleTenant;
    }

    public boolean isTranslateEmojiCode() {
        return this.isTranslateEmojiCode;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ UIFeedCard clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo1165clone() throws CloneNotSupportedException {
        return clone();
    }

    public FeedPreview(FeedPreview r3) {
        super(r3);
        this.isTranslateEmojiCode = false;
        setId(r3.getId());
        setFeedType(r3.getFeedType());
        setType(r3.getType());
        setDisplayTime(r3.getDisplayTime());
        setRankTime(r3.getRankTime());
        setUid(r3.getUid());
        setCheckUser(r3.isCheckUser());
        setAvatarKey(r3.getAvatarKey());
        setRemind(r3.isRemind());
        setShortCut(r3.isShortCut());
        setOriginDigest(r3.getOriginDigest());
        setMarkText(r3.getMarkText());
        setMuteUrgentInfo(r3.muteUrgentInfo);
        setAtInfoCount(r3.atInfoCount);
        setDelayed(r3.isDelayed());
        setFlag(r3.isFlag());
        setDisplayedInDelayedFeed(r3.isDisplayedInDelayedFeed());
        setTranslateEmojiCode(r3.isTranslateEmojiCode());
        setFeedNameTag(r3.getFeedNameTag());
        setCustomStatusIconKey(r3.getCustomStatusIconKey());
        setMuteNoticeType(r3.getMuteNoticeType());
        setRedBadge(r3.isRedBadge());
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L46:
        return false;
    L8:
        if (getClass() != r6.getClass()) goto L46;
        if (super.equals(r6) == true) goto L13;
        return false;
    L13:
        FeedPreview r2 = (FeedPreview) r6;
        if (this.isShortCutFeed == r2.isShortCutFeed) goto L16;
    L44:
        return false;
    L16:
        if (this.lastMessagePosition != r2.lastMessagePosition) goto L44;
        if (this.isDelayed != r2.isDelayed) goto L44;
        if (this.isFlag != r2.isFlag) goto L44;
        if (this.isDisplayedInDelayedFeed != r2.isDisplayedInDelayedFeed) goto L44;
        if (this.atInfoCount != r2.atInfoCount) goto L44;
        if (this.isCustomer != r2.isCustomer) goto L44;
        if (this.isSimpleTenant != r2.isSimpleTenant) goto L44;
        if (this.isTranslateEmojiCode != r2.isTranslateEmojiCode) goto L44;
        if (Objects.equals(this.lastMessageId, r2.lastMessageId) == false) goto L44;
        if (Objects.equals(this.markText, r2.markText) == false) goto L44;
        if (Objects.equals(this.muteUrgentInfo, r2.muteUrgentInfo) == false) goto L44;
        if (Objects.equals(this.a, r2.a) == false) goto L44;
        if (Objects.equals(this.customStatusIconKey, r2.customStatusIconKey) == false) goto L44;
        if (super.equals(r6) == false) goto L44;
        return true;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean exactlyCompare(Object r5) {
        if ((r5 instanceof FeedPreview) == true) goto L5;
        return false;
    L5:
        if (this != r5) goto L8;
        return true;
    L8:
        FeedPreview r0 = (FeedPreview) r5;
        if (TextUtils.equals(this.markText, r0.markText) == true) goto L12;
        return false;
    L12:
        if (this.muteUrgentInfo == r0.muteUrgentInfo) goto L15;
        return false;
    L15:
        if (this.isCustomer == r0.isCustomer) goto L18;
        return false;
    L18:
        if (this.isDelayed == r0.isDelayed()) goto L21;
        return false;
    L21:
        if (this.isFlag == r0.isFlag()) goto L24;
        return false;
    L24:
        if (this.isDisplayedInDelayedFeed == r0.isDisplayedInDelayedFeed()) goto L27;
        return false;
    L27:
        if (r0.isTranslateEmojiCode == this.isTranslateEmojiCode) goto L30;
        return false;
    L30:
        if (TextUtils.equals(this.customStatusIconKey, r0.customStatusIconKey) == true) goto L33;
        return false;
    L33:
        if (Objects.equals(this.a, r0.a) == true) goto L36;
        return false;
    L36:
        return super.exactlyCompare(r5);
    }

    public void setAtInfoCount(int r1) {
        this.atInfoCount = r1;
    }

    public void setCustomStatusIconKey(String r1) {
        this.customStatusIconKey = r1;
    }

    public void setCustomer(boolean r1) {
        this.isCustomer = r1;
    }

    public void setDelayed(boolean r1) {
        this.isDelayed = r1;
    }

    public void setDisplayedInDelayedFeed(boolean r1) {
        this.isDisplayedInDelayedFeed = r1;
    }

    public void setFeedNameTag(LarkNameTag r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public void setFlag(boolean r1) {
        this.isFlag = r1;
    }

    public void setLastMessageId(String r1) {
        this.lastMessageId = r1;
    }

    public void setLastMessagePosition(int r1) {
        this.lastMessagePosition = r1;
    }

    public void setMarkText(String r1) {
        this.markText = r1;
    }

    public void setMuteUrgentInfo(MuteUrgentInfo r1) {
        this.muteUrgentInfo = r1;
    }

    public void setOriginDigest(Digest r1) {
        this.originDigest = r1;
    }

    public void setSimpleTenant(boolean r1) {
        this.isSimpleTenant = r1;
    }

    public void setTagData(TagData r1) {
        this.tagData = r1;
    }

    public void setTranslateEmojiCode(boolean r1) {
        this.isTranslateEmojiCode = r1;
    }
}
