package com.ss.android.lark.feed.shared.data.preview;

import android.text.TextUtils;
import com.ss.android.lark.doc.entity.DocMessage;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.utils.y0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocFeedPreview extends FeedPreview {
    private DocMessage.Type docMessageType;
    private DocType docType;
    private String docUrl;
    private String iconInfo;
    private String lastDocMessageId;

    public Map<String, String> buildExtra() {
        HashMap r0 = new HashMap();
        r0.put("unread_badge_count", String.valueOf(getUnreadCount()));
        r0.put("doc_message_type", String.valueOf(getDocMessageType().getNumber()));
        r0.put("click_time", String.valueOf(System.currentTimeMillis()));
        r0.put("single_top_in_forseti", String.valueOf(true));
        return r0;
    }

    public Map<String, String> buildQuerys() {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(getId()) == true) goto L6;
        r0.put("docId", getId());
    L6:
        if (TextUtils.isEmpty(getLastDocMessageId()) == true) goto L8;
        r0.put("last_doc_message_id", getLastDocMessageId());
    L8:
        return r0;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public DocFeedPreview clone() throws CloneNotSupportedException {
        DocFeedPreview r0 = (DocFeedPreview) super.clone();
        r0.docType = this.docType;
        r0.docUrl = this.docUrl;
        r0.docMessageType = this.docMessageType;
        r0.lastDocMessageId = this.lastDocMessageId;
        r0.iconInfo = this.iconInfo;
        return r0;
    }

    public DocFeedPreview() {
    }

    public DocMessage.Type getDocMessageType() {
        return this.docMessageType;
    }

    public DocType getDocType() {
        return this.docType;
    }

    public String getDocUrl() {
        return this.docUrl;
    }

    public String getIconInfo() {
        return this.iconInfo;
    }

    public String getLastDocMessageId() {
        return this.lastDocMessageId;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ UIFeedCard clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ FeedPreview clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo1165clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean exactlyCompare(Object r5) {
        if (r5 != null) goto L5;
    L27:
        return false;
    L5:
        if ((r5 instanceof DocFeedPreview) == false) goto L27;
        if (this != r5) goto L10;
        return true;
    L10:
        DocFeedPreview r1 = (DocFeedPreview) r5;
        if (r1.docType == this.docType) goto L14;
        return false;
    L14:
        if (r1.docMessageType == this.docMessageType) goto L17;
        return false;
    L17:
        if (TextUtils.equals(this.docUrl, r1.docUrl) == true) goto L20;
        return false;
    L20:
        if (TextUtils.equals(this.iconInfo, r1.iconInfo) == true) goto L23;
        return false;
    L23:
        if (y0.a(this.lastDocMessageId, r1.lastDocMessageId) == true) goto L26;
        return false;
    L26:
        return super.exactlyCompare(r5);
    }

    public void setDocMessageType(DocMessage.Type r1) {
        this.docMessageType = r1;
    }

    public void setDocType(DocType r1) {
        this.docType = r1;
    }

    public void setDocUrl(String r1) {
        this.docUrl = r1;
    }

    public void setIconInfo(String r1) {
        this.iconInfo = r1;
    }

    public void setLastDocMessageId(String r1) {
        this.lastDocMessageId = r1;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean shortcutCompare(Object r5) {
        if ((r5 instanceof DocFeedPreview) == true) goto L5;
        return false;
    L5:
        if (this != r5) goto L8;
        return true;
    L8:
        DocFeedPreview r0 = (DocFeedPreview) r5;
        if (this.docType == r0.docType) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.docUrl, r0.docUrl) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.iconInfo, r0.iconInfo) == true) goto L18;
        return false;
    L18:
        return super.shortcutCompare(r5);
    }
}
