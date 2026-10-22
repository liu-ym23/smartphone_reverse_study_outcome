package com.ss.android.lark.dto.draft;

import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Draft implements Serializable {
    public transient DraftAttachmentSnapshot attachmentSnapshot;
    public String chatId;
    public RichText contentRichText;
    public long createTime;
    public String id;
    public Boolean isNeedDelete;
    public Boolean isReloadUrl;
    public Message message;
    public String messageId;
    public PartialReplyInfo partialReplyInfo;
    public RichText postRichText;
    public QueryStatusInfo queryStatusInfo;
    public String reEditMessageId;
    public ScheduleDraftInfo scheduleDraftInfo;
    public ChatChatter sender;
    public String threadId;
    public String title;
    public String topicGroupId;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DRAFT_TYPE {
        public static final int DRAFT_TYPE_CHAT_POST = 1;
        public static final int DRAFT_TYPE_CHAT_TEXT = 0;
        public static final int DRAFT_TYPE_INDIVIDUAL_TOPIC = 4;
        public static final int DRAFT_TYPE_REEDIT = 6;
        public static final int DRAFT_TYPE_REPLY_IN_THREAD_POST = 5;
        public static final int DRAFT_TYPE_REPLY_POST = 3;
        public static final int DRAFT_TYPE_REPLY_TEXT = 2;
        public static final int DRAFT_TYPE_SCHEDULE_SEND = 7;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Draft{getChatId='");
        r0.append(this.chatId);
        r0.append("', messageId='");
        r0.append(this.messageId);
        r0.append("', type=");
        r0.append(this.type);
        r0.append(", contentRichText=");
        RichText r1 = this.contentRichText;
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
    L8:
        String r3 = BuildConfig.FLAVOR;
    L9:
        r0.append(r3);
        r0.append(", title='");
        r0.append(this.title);
        r0.append("', createTime=");
        r0.append(this.createTime);
        r0.append(", postRichText=");
        RichText r4 = this.postRichText;
        if (r4 != null) goto L12;
    L15:
        r0.append(r2);
        r0.append(", scheduleDraftInfo=");
        r0.append(this.scheduleDraftInfo);
        r0.append(", queryStatusInfo=");
        r0.append(this.queryStatusInfo);
        r0.append('}');
        return r0.toString();
    L12:
        if (r4.getInnerText() == null) goto L15;
        r2 = this.postRichText.getInnerText();
        goto L15
    L5:
        if (r1.getInnerText() == null) goto L8;
        r3 = this.contentRichText.getInnerText();
        goto L9
    }

    public Draft() {
        this.reEditMessageId = BuildConfig.FLAVOR;
        Boolean r0 = Boolean.FALSE;
        this.isNeedDelete = r0;
        this.isReloadUrl = r0;
    }

    public boolean exactlyCompare(Draft r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L8;
        return true;
    L8:
        String r2 = this.chatId;
        if (r2 != null) goto L14;
        if (r5.chatId == null) goto L16;
        return false;
    L16:
        RichText r3 = this.contentRichText;
        if (r3 == null) goto L22;
        if (r3.equals(r5.contentRichText) == false) goto L23;
    L24:
        String r4 = this.title;
        if (r4 == null) goto L30;
        if (r4.equals(r5.title) == true) goto L33;
    L31:
        return false;
    L33:
        if (Objects.equals(this.scheduleDraftInfo, r5.scheduleDraftInfo) == true) goto L35;
        return false;
    L35:
        RichText r6 = this.postRichText;
        RichText r7 = r5.postRichText;
        if (r6 != null) goto L41;
        if (r7 != null) goto L42;
        return true;
    L42:
        return false;
    L41:
        return r6.equals(r7);
    L30:
        if (r5.title == null) goto L33;
    L23:
        return false;
    L22:
        if (r5.contentRichText == null) goto L24;
    L14:
        if (r2.equals(r5.chatId) == true) goto L16;
        return false;
    }
}
