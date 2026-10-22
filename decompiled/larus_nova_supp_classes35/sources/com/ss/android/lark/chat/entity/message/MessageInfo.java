package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import com.bytedance.lark.pb.im.v1.AIRoundInfo;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.ding.entity.DingStatus;
import com.ss.android.lark.log.Log;
import f5b.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p5b.c;
import uxb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MessageInfo implements d, c, b, p5b.a, Serializable, Comparable<MessageInfo>, y28.b<MessageInfo> {
    public static final String TAG = "MessageInfo";
    private AIRecommendQuestions aiRecommendQuestions;
    private AIRoundInfo aiRoundInfo;
    private List<Message> childMessageInThread;
    private DingStatus dingStatus;
    private MessageFoldDetail foldDetail;
    private boolean isForceUpdate;
    private Boolean isTranslating;
    private long lastReplyInThreadTime;
    private List<MessageInfo> latestRepliesInThread;
    private Message mMessage;
    private ChatChatter mMessageSender;
    private boolean mNeedToAutoTranslate;
    private MessageInfo mParentMessageInfo;
    private Pin mPin;
    private ChatChatter mRecallUser;
    private MessageInfo mRootMessageInfo;
    private MessageInfo mThreadParentMessageInfo;
    private TranslateInfo mTranslateInfo;
    private UniversalPinExtra mUniversalPinExtra;
    private ArrayList<String> msgIdPathList;
    private MyAIThreadInfo myAIThreadInfo;
    private ChatChatter originalSender;
    private PartialReplyInfo partialReplyInfo;
    private List<ReactionInfo> reactionInfos;
    private int replyInThreadCount;
    private SmartReplyEntryInfo smartReplyEntryInfo;
    private List<e5b.a> threadMergeForwardSimplifyReplies;

    @Override // f5b.b
    public boolean isNoTraceDelete() {
        return false;
    }

    public void setFollow(boolean r1) {
    }

    public void setNoTraceDelete(boolean r1) {
    }

    @Override // f5b.b
    public boolean canShow() {
        return this.mMessage.canShow();
    }

    public b doCopy() {
        return new MessageInfo(this);
    }

    public String getAIAnswerRawData() {
        Message r0 = this.mMessage;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAiAnswerRawData();
    }

    public long getAIChatModeId() {
        Message r0 = this.mMessage;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getAiChatModeId();
    }

    @Override // f5b.b
    public String getId() {
        return this.mMessage.getId();
    }

    public String getParentId() {
        return this.mMessage.getParentId();
    }

    @Override // f5b.b
    public long getUpdateTime() {
        return this.mMessage.getUpdateTime();
    }

    @Override // f5b.b
    public String getcId() {
        return this.mMessage.getcId();
    }

    public int hashCode() {
        Message r0 = this.mMessage;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    @Override // f5b.b
    public boolean isIntermediateMessage() {
        return this.mMessage.isCryptoIntermediate();
    }

    @Override // f5b.b
    public boolean isPreMessage() {
        return this.mMessage.isPreMessage();
    }

    @Override // f5b.b
    public boolean isTranslating() {
        Boolean r0 = this.isTranslating;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.booleanValue() == false) goto L7;
        return true;
    }

    @Override // f5b.b
    public boolean isTranslatingInited() {
        if (this.isTranslating == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        Message r0 = this.mMessage;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        StringBuilder r2 = new StringBuilder(r1);
        r2.append(" replyInThreadCount=");
        r2.append(this.replyInThreadCount);
        r2.append(" foldDetail=");
        r2.append(this.foldDetail);
        r2.append(" smartReplyEntryInfo==null:");
        boolean r3 = true;
        if (this.smartReplyEntryInfo != null) goto L9;
        boolean r4 = true;
    L10:
        r2.append(r4);
        r2.append(" AiRecommendQuestions==null:");
        if (this.aiRecommendQuestions == null) goto L14;
        r3 = false;
    L14:
        r2.append(r3);
        return r2.toString();
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = super.toString();
        goto L6
    }

    public MessageInfo() {
        this.mNeedToAutoTranslate = true;
        this.isTranslating = null;
        this.replyInThreadCount = 0;
    }

    @Override // f5b.b
    public b clone() {
        return (b) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // f5b.b
    public List<String> getAuthFileKeys() {
        return getMessage().getAuthFileKeys();
    }

    @Override // p5b.c, f5b.b
    public /* bridge */ /* synthetic */ p5b.b getMessage() {
        return getMessage();
    }

    /* JADX INFO: renamed from: getMessageSender, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ OpenChatter m519getMessageSender() {
        return getMessageSender();
    }

    /* JADX INFO: renamed from: getOriginalSender, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ OpenChatter m521getOriginalSender() {
        return getOriginalSender();
    }

    /* JADX INFO: renamed from: getParentMessageInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m522getParentMessageInfo() {
        return getParentMessageInfo();
    }

    /* JADX INFO: renamed from: getRootMessageInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m523getRootMessageInfo() {
        return getRootMessageInfo();
    }

    /* JADX INFO: renamed from: getThreadParentMessageInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d m524getThreadParentMessageInfo() {
        return getThreadParentMessageInfo();
    }

    public Content getTranslateContent() {
        return getTranslateContent(isShowMessageOriginContent());
    }

    public boolean hasReaction() {
        if (getReactionInfoList() == null) goto L11;
        Iterator<ReactionInfo> r0 = getReactionInfoList().iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        if (r0.next().getReaction().getCount() <= 0) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    @Override // f5b.b, p5b.a
    public boolean isShowMessageOriginContent() {
        String r0 = getMessage().getTranslateLanguage();
        TranslateInfo r1 = getTranslateInfo();
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (r1 == null) goto L11;
        if (r0.equals(r1.getLanguage()) == false) goto L11;
        if (getMessage().getStatus() == Message.Status.DELETED) goto L11;
        return false;
    L11:
        return true;
    }

    public AIRecommendQuestions getAiRecommendQuestions() {
        return this.aiRecommendQuestions;
    }

    public AIRoundInfo getAiRoundInfo() {
        return this.aiRoundInfo;
    }

    public List<Message> getChildMessagesInThread() {
        return this.childMessageInThread;
    }

    public DingStatus getDingStatus() {
        return this.dingStatus;
    }

    public long getLastReplyInThreadTime() {
        return this.lastReplyInThreadTime;
    }

    public List<MessageInfo> getLatestRepliesInThread() {
        return this.latestRepliesInThread;
    }

    @Override // f5b.b
    public MessageFoldDetail getMessageFoldDetail() {
        return this.foldDetail;
    }

    @Override // f5b.b
    public ArrayList<String> getMsgIdPathList() {
        return this.msgIdPathList;
    }

    public MyAIThreadInfo getMyAIThreadInfo() {
        return this.myAIThreadInfo;
    }

    @Override // f5b.b
    public b getParent() {
        return this.mParentMessageInfo;
    }

    public PartialReplyInfo getPartialReplyInfo() {
        return this.partialReplyInfo;
    }

    @Override // f5b.b
    public Pin getPin() {
        return this.mPin;
    }

    @Override // f5b.b
    public List<ReactionInfo> getReactionInfoList() {
        return this.reactionInfos;
    }

    public ChatChatter getRecallUser() {
        return this.mRecallUser;
    }

    public int getReplyInThreadCount() {
        return this.replyInThreadCount;
    }

    public SmartReplyEntryInfo getSmartReplyEntryInfo() {
        return this.smartReplyEntryInfo;
    }

    public List<e5b.a> getThreadMergeForwardSimplifyReplies() {
        return this.threadMergeForwardSimplifyReplies;
    }

    @Override // f5b.b
    public TranslateInfo getTranslateInfo() {
        return this.mTranslateInfo;
    }

    public UniversalPinExtra getUniversalPinExtra() {
        return this.mUniversalPinExtra;
    }

    public boolean isForceUpdate() {
        return this.isForceUpdate;
    }

    public boolean isNeedToAutoTranslate() {
        return this.mNeedToAutoTranslate;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m517clone() throws CloneNotSupportedException {
        return clone();
    }

    /* JADX INFO: renamed from: getMessage, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ uxb.c m518getMessage() {
        return getMessage();
    }

    /* JADX INFO: renamed from: getMessageSender, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ uxb.a m520getMessageSender() {
        return getMessageSender();
    }

    public ChatChatter getOriginalSender() {
        return this.originalSender;
    }

    public MessageInfo getParentMessageInfo() {
        return this.mParentMessageInfo;
    }

    public MessageInfo getRootMessageInfo() {
        return this.mRootMessageInfo;
    }

    public MessageInfo getThreadParentMessageInfo() {
        return this.mThreadParentMessageInfo;
    }

    @Override // p5b.c, f5b.b
    public Message getMessage() {
        return this.mMessage;
    }

    @Override // f5b.b
    public ChatChatter getMessageSender() {
        return this.mMessageSender;
    }

    public MessageInfo(MessageInfo r3) {
        this.mNeedToAutoTranslate = true;
        this.isTranslating = null;
        this.replyInThreadCount = 0;
        this.mMessage = r3.mMessage;
        this.mMessageSender = r3.mMessageSender;
        this.mTranslateInfo = r3.mTranslateInfo;
        this.dingStatus = r3.dingStatus;
        this.reactionInfos = r3.reactionInfos;
        this.mRootMessageInfo = r3.getRootMessageInfo();
        this.mParentMessageInfo = r3.getParentMessageInfo();
        this.mRecallUser = r3.mRecallUser;
        this.mNeedToAutoTranslate = r3.isNeedToAutoTranslate();
        this.isTranslating = r3.isTranslating;
        this.mTranslateInfo = r3.getTranslateInfo();
        this.mPin = r3.getPin();
        this.originalSender = r3.originalSender;
        this.replyInThreadCount = r3.replyInThreadCount;
        this.latestRepliesInThread = r3.latestRepliesInThread;
        this.lastReplyInThreadTime = r3.lastReplyInThreadTime;
        this.foldDetail = r3.foldDetail;
        this.myAIThreadInfo = r3.myAIThreadInfo;
        this.mUniversalPinExtra = r3.mUniversalPinExtra;
        this.smartReplyEntryInfo = r3.smartReplyEntryInfo;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MessageInfo r2) {
        return this.mMessage.compareTo2(r2.getMessage());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageInfo) == true) goto L8;
        return false;
    L8:
        MessageInfo r6 = (MessageInfo) r5;
        Message r1 = this.mMessage;
        if (r1 == null) goto L14;
        if (r1.equals(r6.mMessage) == true) goto L17;
    L15:
        return false;
    L17:
        if (Objects.equals(this.myAIThreadInfo, r6.myAIThreadInfo) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(this.smartReplyEntryInfo, r6.smartReplyEntryInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        if (r6.mMessage == null) goto L17;
        goto L15
    }

    @Override // f5b.b, p5b.a
    public Content getTranslateContent(boolean r1) {
        if (r1 == false) goto L6;
        return getMessage().getContent();
    L6:
        return getTranslateInfo().getTranslateContent();
    }

    public boolean isContentSame(MessageInfo r7) {
        if (y28.a.c(this.mMessage, r7.getMessage()) == true) goto L6;
        return false;
    L6:
        if (y28.a.b(this.reactionInfos, r7.getReactionInfoList()) == true) goto L9;
        return false;
    L9:
        if (y28.a.c(this.dingStatus, r7.getDingStatus()) == true) goto L12;
        return false;
    L12:
        if (y28.a.c(this.mMessageSender, r7.getMessageSender()) == true) goto L15;
        return false;
    L15:
        if (y28.a.c(this.mRecallUser, r7.getRecallUser()) == true) goto L18;
        return false;
    L18:
        if (y28.a.c(this.mPin, r7.getPin()) == true) goto L21;
        return false;
    L21:
        if (y28.a.c(this.mUniversalPinExtra, r7.getUniversalPinExtra()) == true) goto L24;
        return false;
    L24:
        if (y28.a.c(this.foldDetail, r7.foldDetail) == true) goto L27;
        return false;
    L27:
        if (Objects.equals(this.isTranslating, r7.isTranslating) == true) goto L29;
    L47:
        return false;
    L29:
        if (Objects.equals(this.mTranslateInfo, r7.getTranslateInfo()) == false) goto L47;
        if (this.replyInThreadCount != r7.replyInThreadCount) goto L47;
        if (this.lastReplyInThreadTime != r7.lastReplyInThreadTime) goto L47;
        if (Objects.equals(this.myAIThreadInfo, r7.myAIThreadInfo) == true) goto L40;
        return false;
    L40:
        if (Objects.equals(this.smartReplyEntryInfo, r7.smartReplyEntryInfo) == true) goto L43;
        return false;
    L43:
        if (y28.a.c(this.aiRecommendQuestions, r7.aiRecommendQuestions) == false) goto L45;
        return false;
    L45:
        return true;
    }

    public boolean isItemSame(MessageInfo r2) {
        return this.mMessage.isItemSame(r2.getMessage());
    }

    public void setAiRecommendQuestions(AIRecommendQuestions r1) {
        this.aiRecommendQuestions = r1;
    }

    public void setAiRoundInfo(AIRoundInfo r1) {
        this.aiRoundInfo = r1;
    }

    public void setChildMessageInThread(List<Message> r1) {
        this.childMessageInThread = r1;
    }

    @Override // f5b.b
    public void setDingStatus(DingStatus r1) {
        this.dingStatus = r1;
    }

    @Override // f5b.b
    public void setForceUpdate(boolean r1) {
        this.isForceUpdate = r1;
    }

    @Override // f5b.b
    public void setIsTranslating(boolean r1) {
        this.isTranslating = Boolean.valueOf(r1);
    }

    public void setLastReplyInThreadTime(long r1) {
        this.lastReplyInThreadTime = r1;
    }

    public void setLatestRepliesInThread(List<MessageInfo> r1) {
        this.latestRepliesInThread = r1;
    }

    @Override // f5b.b
    public void setMessage(Message r1) {
        this.mMessage = r1;
    }

    @Override // f5b.b
    public void setMessageFoldDetail(MessageFoldDetail r1) {
        this.foldDetail = r1;
    }

    @Override // f5b.b
    public void setMessageSender(ChatChatter r1) {
        this.mMessageSender = r1;
    }

    public void setMsgIdPathList(ArrayList<String> r1) {
        this.msgIdPathList = r1;
    }

    public void setMyAIThreadInfo(MyAIThreadInfo r1) {
        this.myAIThreadInfo = r1;
    }

    public void setNeedToAutoTranslate(boolean r1) {
        this.mNeedToAutoTranslate = r1;
    }

    public void setOriginalSender(ChatChatter r1) {
        this.originalSender = r1;
    }

    public void setParentMessageInfo(MessageInfo r1) {
        this.mParentMessageInfo = r1;
    }

    public void setPartialReplyInfo(PartialReplyInfo r1) {
        this.partialReplyInfo = r1;
    }

    public void setPin(Pin r1) {
        this.mPin = r1;
    }

    public void setReactionInfoList(List<ReactionInfo> r1) {
        this.reactionInfos = r1;
    }

    public void setRecallUser(ChatChatter r1) {
        this.mRecallUser = r1;
    }

    public void setReplyInThreadCount(int r1) {
        this.replyInThreadCount = r1;
    }

    public void setRootMessageInfo(MessageInfo r1) {
        this.mRootMessageInfo = r1;
    }

    public void setSmartReplyEntryInfo(SmartReplyEntryInfo r1) {
        this.smartReplyEntryInfo = r1;
    }

    public void setThreadMergeForwardSimplifyReplies(List<e5b.a> r1) {
        this.threadMergeForwardSimplifyReplies = r1;
    }

    public void setThreadParentMessageInfo(MessageInfo r1) {
        this.mThreadParentMessageInfo = r1;
    }

    @Override // f5b.b
    public void setTranslateInfo(TranslateInfo r1) {
        this.mTranslateInfo = r1;
    }

    public void setUniversalPinExtra(UniversalPinExtra r1) {
        this.mUniversalPinExtra = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MessageInfo r1) {
        return compareTo2(r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return isContentSame((MessageInfo) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        return isItemSame((MessageInfo) r1);
    }

    public MessageInfo(Message r2, ChatChatter r3) {
        this.mNeedToAutoTranslate = true;
        this.isTranslating = null;
        this.replyInThreadCount = 0;
        this.mMessage = r2;
        this.mMessageSender = r3;
        if (r3 != null) goto L7;
        if (r2 == null) goto L8;
        Log.w("chatter is null in messageinfo, chatterid: " + r2.getFromId());
        return;
    L8:
        return;
    }
}
