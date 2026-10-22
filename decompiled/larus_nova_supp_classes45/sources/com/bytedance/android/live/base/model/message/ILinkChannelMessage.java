package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001FR\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b\u001f\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0007\u001a\u0004\b$\u0010%R\u001c\u0010,\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0007\u001a\u0004\b)\u0010*R\u001c\u00101\u001a\u0004\u0018\u00010-8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0007\u001a\u0004\b.\u0010/R\u001c\u00106\u001a\u0004\u0018\u0001028&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0007\u001a\u0004\b3\u00104R\u001c\u0010;\u001a\u0004\u0018\u0001078&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b8\u00109R\u001c\u0010@\u001a\u0004\u0018\u00010<8&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0007\u001a\u0004\b=\u0010>R\u001c\u0010E\u001a\u0004\u0018\u00010A8&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0007\u001a\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkChannelMessage;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/t;", "", "getMessageType", "()J", "getMessageType$annotations", "()V", "messageType", "getLinkerId", "getLinkerId$annotations", "linkerId", "getScene", "getScene$annotations", "scene", "Lcom/bytedance/android/live/base/model/message/y;", "getCreateContent", "()Lcom/bytedance/android/live/base/model/message/y;", "getCreateContent$annotations", "createContent", "Lcom/bytedance/android/live/base/model/message/x;", "getCloseContent", "()Lcom/bytedance/android/live/base/model/message/x;", "getCloseContent$annotations", "closeContent", "Lcom/bytedance/android/live/base/model/message/a0;", "getInviteContent", "()Lcom/bytedance/android/live/base/model/message/a0;", "getInviteContent$annotations", "inviteContent", "Lcom/bytedance/android/live/base/model/message/w;", "getApplyContent", "()Lcom/bytedance/android/live/base/model/message/w;", "getApplyContent$annotations", "applyContent", "Lcom/bytedance/android/live/base/model/message/f0;", "getReplyContent", "()Lcom/bytedance/android/live/base/model/message/f0;", "getReplyContent$annotations", "replyContent", "Lcom/bytedance/android/live/base/model/message/e0;", "getPermitContent", "()Lcom/bytedance/android/live/base/model/message/e0;", "getPermitContent$annotations", "permitContent", "Lcom/bytedance/android/live/base/model/message/z;", "getEnterContent", "()Lcom/bytedance/android/live/base/model/message/z;", "getEnterContent$annotations", "enterContent", "Lcom/bytedance/android/live/base/model/message/c0;", "getLeaveContent", "()Lcom/bytedance/android/live/base/model/message/c0;", "getLeaveContent$annotations", "leaveContent", "Lcom/bytedance/android/live/base/model/message/b0;", "getKickOutContent", "()Lcom/bytedance/android/live/base/model/message/b0;", "getKickOutContent$annotations", "kickOutContent", "Lcom/bytedance/android/live/base/model/message/d0;", "getLinkedListChangeContent", "()Lcom/bytedance/android/live/base/model/message/d0;", "getLinkedListChangeContent$annotations", "linkedListChangeContent", "Lcom/bytedance/android/live/base/model/message/g0;", "getSilenceContent", "()Lcom/bytedance/android/live/base/model/message/g0;", "getSilenceContent$annotations", "silenceContent", "LinkChannelMessageType", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkChannelMessage extends vh7.c<ILinkChannelMessage>, t {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/message/ILinkChannelMessage$LinkChannelMessageType;", "", "", "value", "I", "getValue", "()I", "TYPE_LINKER_CHANNEL_UNKNOWN", "TYPE_LINKER_CHANNEL_CREATE", "TYPE_LINKER_CHANNEL_CLOSE", "TYPE_LINKER_CHANNEL_INVITE", "TYPE_LINKER_CHANNEL_REPLY", "TYPE_LINKER_CHANNEL_PERMIT", "TPYE_LINKER_CHANNEL_ENTER", "TPYE_LINKER_CHANNEL_LEAVE", "TPYE_LINKER_CHANNEL_KICK_OUT", "TYPE_LINKER_CHANNEL_LINKER_LINKED_LIST_CHANGE", "TYPE_LINKER_CHANNEL_SILENCE_STATUS", "TYPE_LINKER_CHANNEL_APPLY", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkChannelMessageType extends Enum<LinkChannelMessageType> {
        public static final LinkChannelMessageType TPYE_LINKER_CHANNEL_ENTER = null;
        public static final LinkChannelMessageType TPYE_LINKER_CHANNEL_KICK_OUT = null;
        public static final LinkChannelMessageType TPYE_LINKER_CHANNEL_LEAVE = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_APPLY = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_CLOSE = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_CREATE = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_INVITE = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_LINKER_LINKED_LIST_CHANGE = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_PERMIT = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_REPLY = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_SILENCE_STATUS = null;
        public static final LinkChannelMessageType TYPE_LINKER_CHANNEL_UNKNOWN = null;
        public static final /* synthetic */ LinkChannelMessageType[] a = null;
        private final int value;

        public static LinkChannelMessageType valueOf(String r1) {
            return (LinkChannelMessageType) r27.a.a(LinkChannelMessageType.class, r1);
        }

        public static LinkChannelMessageType[] values() {
            return (LinkChannelMessageType[]) a.clone();
        }

        static {
            LinkChannelMessageType r1 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_UNKNOWN", 0, 0);
            TYPE_LINKER_CHANNEL_UNKNOWN = r1;
            LinkChannelMessageType r2 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_CREATE", 1, 1);
            TYPE_LINKER_CHANNEL_CREATE = r2;
            LinkChannelMessageType r3 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_CLOSE", 2, 2);
            TYPE_LINKER_CHANNEL_CLOSE = r3;
            LinkChannelMessageType r4 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_INVITE", 3, 3);
            TYPE_LINKER_CHANNEL_INVITE = r4;
            LinkChannelMessageType r5 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_REPLY", 4, 4);
            TYPE_LINKER_CHANNEL_REPLY = r5;
            LinkChannelMessageType r6 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_PERMIT", 5, 5);
            TYPE_LINKER_CHANNEL_PERMIT = r6;
            LinkChannelMessageType r7 = new LinkChannelMessageType("TPYE_LINKER_CHANNEL_ENTER", 6, 6);
            TPYE_LINKER_CHANNEL_ENTER = r7;
            LinkChannelMessageType r8 = new LinkChannelMessageType("TPYE_LINKER_CHANNEL_LEAVE", 7, 7);
            TPYE_LINKER_CHANNEL_LEAVE = r8;
            LinkChannelMessageType r9 = new LinkChannelMessageType("TPYE_LINKER_CHANNEL_KICK_OUT", 8, 8);
            TPYE_LINKER_CHANNEL_KICK_OUT = r9;
            LinkChannelMessageType r11 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_LINKER_LINKED_LIST_CHANGE", 9, 9);
            TYPE_LINKER_CHANNEL_LINKER_LINKED_LIST_CHANGE = r11;
            LinkChannelMessageType r12 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_SILENCE_STATUS", 10, 10);
            TYPE_LINKER_CHANNEL_SILENCE_STATUS = r12;
            LinkChannelMessageType r13 = new LinkChannelMessageType("TYPE_LINKER_CHANNEL_APPLY", 11, 11);
            TYPE_LINKER_CHANNEL_APPLY = r13;
            a = new LinkChannelMessageType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13};
        }

        public final int getValue() {
            return this.value;
        }

        public LinkChannelMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean canText();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean currUserIsAnchor();

    @FieldName(name = "apply_content")
    w getApplyContent();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ m0 getBaseMessage();

    @FieldName(name = "close_content")
    x getCloseContent();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getConsumeTime();

    @FieldName(name = "create_content")
    y getCreateContent();

    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "enter_content")
    z getEnterContent();

    /* synthetic */ int getGeneralMessageType();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    @FieldName(name = "invite_content")
    a0 getInviteContent();

    @FieldName(name = "kick_out_content")
    b0 getKickOutContent();

    @FieldName(name = "leave_content")
    c0 getLeaveContent();

    @FieldName(name = "linked_list_change_content")
    d0 getLinkedListChangeContent();

    @FieldName(name = "linker_id")
    long getLinkerId();

    /* synthetic */ long getLocalTimestamp();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    @FieldName(name = "message_type")
    long getMessageType();

    @FieldName(name = "permit_content")
    e0 getPermitContent();

    /* synthetic */ int getPriority();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ byte[] getRawPayload();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getReceiveTime();

    @FieldName(name = "reply_content")
    f0 getReplyContent();

    /* synthetic */ long getRoomId();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "silence_status_content")
    g0 getSilenceContent();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isCurrentRoom(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFirstHistoryMessage();

    /* synthetic */ boolean isFromFirstRequest();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isFromOtherIntercomRoom();

    /* synthetic */ boolean isGlobalMessage();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isInsert();

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean isTooMuchMsg();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    /* synthetic */ void setBaseMessage(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    /* synthetic */ void setHttpSendTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setIsFirstHistoryMessage(boolean r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setLocalInsertMsg(boolean r1);

    /* synthetic */ void setMessageMethod(String r1);

    /* synthetic */ void setReceiveTime(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ void setTooMuchMsg(boolean r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);

    @Override // com.bytedance.android.live.base.model.message.t
    /* synthetic */ boolean supportDisplayText();
}
