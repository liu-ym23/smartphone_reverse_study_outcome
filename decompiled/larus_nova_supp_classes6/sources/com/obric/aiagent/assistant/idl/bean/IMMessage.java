package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVerifier;
import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b6\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0017\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0015HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0015HÆ\u0003Jñ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0015HÆ\u0001J\u0006\u0010M\u001a\u00020\u0006J\u0013\u0010N\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0006HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\u0016\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010'R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0016\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00100¨\u0006X"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "Landroid/os/Parcelable;", "conversationId", "", "senderId", "userType", "", "messageStatusLocal", "messageStatus", "contentType", "isNewBlockType", "", "content", "contentBlock", "", "Lcom/obric/aiagent/assistant/idl/bean/Block;", "ext", "", "localMessageId", "messageId", "localIndex", "", "serverIndex", "sectionId", "businessExt", "", "replyId", "bizContentType", "createTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIZLjava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;J)V", "getConversationId", "()Ljava/lang/String;", "getSenderId", "getUserType", "()I", "getMessageStatusLocal", "getMessageStatus", "getContentType", "()Z", "getContent", "getContentBlock", "()Ljava/util/List;", "getExt", "()Ljava/util/Map;", "getLocalMessageId", "getMessageId", "getLocalIndex", "()J", "getServerIndex", "getSectionId", "getBusinessExt", "getReplyId", "getBizContentType", "getCreateTime", "isBlockType", "isOldBlockType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class IMMessage implements Parcelable {
    public static final Parcelable.Creator<IMMessage> CREATOR = null;

    @SerializedName("biz_content_type")
    private final String bizContentType;

    @SerializedName("business_ext")
    private final Map<String, String> businessExt;

    @SerializedName("content")
    private final String content;

    @SerializedName("content_block")
    private final List<Block> contentBlock;

    @SerializedName("content_type")
    private final int contentType;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("ext")
    private final Map<String, String> ext;

    @SerializedName("is_new_block_type")
    private final boolean isNewBlockType;

    @SerializedName("local_index")
    private final long localIndex;

    @SerializedName("local_message_id")
    private final String localMessageId;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("message_status")
    private final int messageStatus;

    @SerializedName("message_status_local")
    private final int messageStatusLocal;

    @SerializedName("reply_id")
    private final String replyId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("sender_id")
    private final String senderId;

    @SerializedName("server_index")
    private final long serverIndex;

    @SerializedName("user_type")
    private final int userType;

    static {
        CREATOR = new a();
    }

    public IMMessage() {
        this(null, null, 0, 0, 0, 0, false, null, null, null, null, null, 0, 0, null, null, null, null, 0, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMMessage copy$default(IMMessage r17, String r18, String r19, int r20, int r21, int r22, int r23, boolean r24, String r25, List r26, Map r27, String r28, String r29, long r30, long r32, String r34, Map r35, String r36, String r37, long r38, int r40, Object r41) {
        if ((r40 & 1) == 0) goto L5;
        String r2 = r17.conversationId;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r3 = r17.senderId;
    L11:
        if ((r40 & 4) == 0) goto L13;
        int r4 = r17.userType;
    L15:
        if ((r40 & 8) == 0) goto L17;
        int r5 = r17.messageStatusLocal;
    L19:
        if ((r40 & 16) == 0) goto L21;
        int r6 = r17.messageStatus;
    L23:
        if ((r40 & 32) == 0) goto L25;
        int r7 = r17.contentType;
    L27:
        if ((r40 & 64) == 0) goto L29;
        boolean r8 = r17.isNewBlockType;
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r9 = r17.content;
    L35:
        if ((r40 & ISmModel.VERSION_0100) == 0) goto L37;
        List r10 = r17.contentBlock;
    L39:
        if ((r40 & ISmModel.VERSION_0200) == 0) goto L41;
        Map r11 = r17.ext;
    L43:
        if ((r40 & ISmModel.VERSION_0400) == 0) goto L45;
        String r12 = r17.localMessageId;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        String r13 = r17.messageId;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        long r14 = r17.localIndex;
    L54:
        long r31 = r14;
        if ((r40 & 8192) == 0) goto L57;
        long r15 = r17.serverIndex;
    L58:
        long r33 = r15;
        if ((r40 & 16384) == 0) goto L61;
        String r16 = r17.sectionId;
    L63:
        if ((32768 & r40) == 0) goto L65;
        Map r110 = r17.businessExt;
    L66:
        Map r39 = r110;
        if ((r40 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r111 = r17.replyId;
    L70:
        String r310 = r111;
        if ((r40 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) == 0) goto L73;
        String r112 = r17.bizContentType;
    L74:
        String r311 = r16;
        String r312 = r112;
        if ((r40 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) == 0) goto L77;
        long r113 = r17.createTime;
    L79:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r31, r33, r311, r39, r310, r312, r113);
    L77:
        r113 = r38;
        goto L79
    L73:
        r112 = r37;
        goto L74
    L69:
        r111 = r36;
        goto L70
    L65:
        r110 = r35;
        goto L66
    L61:
        r16 = r34;
        goto L63
    L57:
        r15 = r32;
        goto L58
    L53:
        r14 = r30;
        goto L54
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.conversationId;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component11() {
        return this.localMessageId;
    }

    public final String component12() {
        return this.messageId;
    }

    public final long component13() {
        return this.localIndex;
    }

    public final long component14() {
        return this.serverIndex;
    }

    public final String component15() {
        return this.sectionId;
    }

    public final Map<String, String> component16() {
        return this.businessExt;
    }

    public final String component17() {
        return this.replyId;
    }

    public final String component18() {
        return this.bizContentType;
    }

    public final long component19() {
        return this.createTime;
    }

    public final String component2() {
        return this.senderId;
    }

    public final int component3() {
        return this.userType;
    }

    public final int component4() {
        return this.messageStatusLocal;
    }

    public final int component5() {
        return this.messageStatus;
    }

    public final int component6() {
        return this.contentType;
    }

    public final boolean component7() {
        return this.isNewBlockType;
    }

    public final String component8() {
        return this.content;
    }

    public final List<Block> component9() {
        return this.contentBlock;
    }

    public final IMMessage copy(String r26, String r27, int r28, int r29, int r30, int r31, boolean r32, String r33, List<Block> r34, Map<String, String> r35, String r36, String r37, long r38, long r40, String r42, Map<String, String> r43, String r44, String r45, long r46) {
        Intrinsics.checkNotNullParameter(r26, "conversationId");
        Intrinsics.checkNotNullParameter(r27, "senderId");
        Intrinsics.checkNotNullParameter(r36, "localMessageId");
        Intrinsics.checkNotNullParameter(r37, "messageId");
        Intrinsics.checkNotNullParameter(r43, "businessExt");
        return new IMMessage(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r42, r43, r44, r45, r46);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IMMessage) == true) goto L8;
        return false;
    L8:
        IMMessage r9 = (IMMessage) r8;
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.senderId, r9.senderId) == true) goto L15;
        return false;
    L15:
        if (this.userType == r9.userType) goto L18;
        return false;
    L18:
        if (this.messageStatusLocal == r9.messageStatusLocal) goto L21;
        return false;
    L21:
        if (this.messageStatus == r9.messageStatus) goto L24;
        return false;
    L24:
        if (this.contentType == r9.contentType) goto L27;
        return false;
    L27:
        if (this.isNewBlockType == r9.isNewBlockType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.contentBlock, r9.contentBlock) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.localMessageId, r9.localMessageId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L45;
        return false;
    L45:
        if (this.localIndex == r9.localIndex) goto L48;
        return false;
    L48:
        if (this.serverIndex == r9.serverIndex) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sectionId, r9.sectionId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.businessExt, r9.businessExt) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.replyId, r9.replyId) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.bizContentType, r9.bizContentType) == true) goto L63;
        return false;
    L63:
        if (this.createTime == r9.createTime) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.conversationId.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.userType) * 31) + this.messageStatusLocal) * 31) + this.messageStatus) * 31) + this.contentType) * 31;
        if (this.isNewBlockType == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.content;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        List<Block> r7 = this.contentBlock;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.ext;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((((r9 + r11) * 31) + this.localMessageId.hashCode()) * 31) + this.messageId.hashCode()) * 31;
        long r13 = this.localIndex;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        long r15 = this.serverIndex;
        int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        String r17 = this.sectionId;
        if (r17 != null) goto L21;
        int r18 = 0;
    L22:
        int r19 = (((r16 + r18) * 31) + this.businessExt.hashCode()) * 31;
        String r20 = this.replyId;
        if (r20 != null) goto L25;
        int r21 = 0;
    L26:
        int r22 = (r19 + r21) * 31;
        String r23 = this.bizContentType;
        if (r23 == null) goto L30;
        r4 = r23.hashCode();
    L30:
        int r24 = (r22 + r4) * 31;
        long r25 = this.createTime;
        return r24 + ((int) (r25 ^ (r25 >>> 32)));
    L25:
        r21 = r20.hashCode();
        goto L26
    L21:
        r18 = r17.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "IMMessage(conversationId=" + this.conversationId + ", senderId=" + this.senderId + ", userType=" + this.userType + ", messageStatusLocal=" + this.messageStatusLocal + ", messageStatus=" + this.messageStatus + ", contentType=" + this.contentType + ", isNewBlockType=" + this.isNewBlockType + ", content=" + this.content + ", contentBlock=" + this.contentBlock + ", ext=" + this.ext + ", localMessageId=" + this.localMessageId + ", messageId=" + this.messageId + ", localIndex=" + this.localIndex + ", serverIndex=" + this.serverIndex + ", sectionId=" + this.sectionId + ", businessExt=" + this.businessExt + ", replyId=" + this.replyId + ", bizContentType=" + this.bizContentType + ", createTime=" + this.createTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.conversationId);
        r4.writeString(this.senderId);
        r4.writeInt(this.userType);
        r4.writeInt(this.messageStatusLocal);
        r4.writeInt(this.messageStatus);
        r4.writeInt(this.contentType);
        r4.writeInt(this.isNewBlockType ? 1 : 0);
        r4.writeString(this.content);
        List<Block> r6 = this.contentBlock;
        if (r6 != null) goto L5;
        r4.writeInt(0);
    L9:
        Map<String, String> r7 = this.ext;
        if (r7 != null) goto L12;
        r4.writeInt(0);
    L16:
        r4.writeString(this.localMessageId);
        r4.writeString(this.messageId);
        r4.writeLong(this.localIndex);
        r4.writeLong(this.serverIndex);
        r4.writeString(this.sectionId);
        Map<String, String> r8 = this.businessExt;
        r4.writeInt(r8.size());
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        Map.Entry<String, String> r0 = r9.next();
        r4.writeString(r0.getKey());
        r4.writeString(r0.getValue());
        goto L18
    L20:
        r4.writeString(this.replyId);
        r4.writeString(this.bizContentType);
        r4.writeLong(this.createTime);
        return;
    L12:
        r4.writeInt(1);
        r4.writeInt(r7.size());
        Iterator<Map.Entry<String, String>> r10 = r7.entrySet().iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        Map.Entry<String, String> r1 = r10.next();
        r4.writeString(r1.getKey());
        r4.writeString(r1.getValue());
        goto L14
    L5:
        r4.writeInt(1);
        r4.writeInt(r6.size());
        Iterator<Block> r11 = r6.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r4.writeSerializable(r11.next());
        goto L7
    }

    public final boolean isOldBlockType() {
        if (this.contentType == 9999) goto L5;
    L7:
        return false;
    L5:
        if (this.isNewBlockType == true) goto L7;
        return true;
    }

    public final boolean isBlockType() {
        if (isOldBlockType() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isNewBlockType == true) goto L8;
        return false;
    }

    public final String getBizContentType() {
        return this.bizContentType;
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Block> getContentBlock() {
        return this.contentBlock;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMessageStatus() {
        return this.messageStatus;
    }

    public final int getMessageStatusLocal() {
        return this.messageStatusLocal;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final long getServerIndex() {
        return this.serverIndex;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final boolean isNewBlockType() {
        return this.isNewBlockType;
    }

    public IMMessage(String r8, String r9, int r10, int r11, int r12, int r13, boolean r14, String r15, List<Block> r16, Map<String, String> r17, String r18, String r19, long r20, long r22, String r24, Map<String, String> r25, String r26, String r27, long r28) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r9, "senderId");
        Intrinsics.checkNotNullParameter(r18, "localMessageId");
        Intrinsics.checkNotNullParameter(r19, "messageId");
        Intrinsics.checkNotNullParameter(r25, "businessExt");
        this.conversationId = r8;
        this.senderId = r9;
        this.userType = r10;
        this.messageStatusLocal = r11;
        this.messageStatus = r12;
        this.contentType = r13;
        this.isNewBlockType = r14;
        this.content = r15;
        this.contentBlock = r16;
        this.ext = r17;
        this.localMessageId = r18;
        this.messageId = r19;
        this.localIndex = r20;
        this.serverIndex = r22;
        this.sectionId = r24;
        this.businessExt = r25;
        this.replyId = r26;
        this.bizContentType = r27;
        this.createTime = r28;
    }

    public /* synthetic */ IMMessage(String r24, String r25, int r26, int r27, int r28, int r29, boolean r30, String r31, List r32, Map r33, String r34, String r35, long r36, long r38, String r40, Map r41, String r42, String r43, long r44, int r46, DefaultConstructorMarker r47) {
        String r2 = "";
        if ((r46 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r3 = "";
    L10:
        int r5 = -1;
        if ((r46 & 4) == 0) goto L13;
        int r4 = -1;
    L15:
        if ((r46 & 8) == 0) goto L17;
        int r6 = -1;
    L19:
        if ((r46 & 16) == 0) goto L21;
        int r7 = -1;
    L23:
        if ((r46 & 32) != 0) goto L27;
        r5 = r29;
    L27:
        if ((r46 & 64) == 0) goto L29;
        boolean r8 = false;
    L30:
        String r10 = null;
        if ((r46 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r46 & ISmModel.VERSION_0100) == 0) goto L37;
        List r11 = null;
    L39:
        if ((r46 & ISmModel.VERSION_0200) == 0) goto L41;
        Map r12 = null;
    L43:
        if ((r46 & ISmModel.VERSION_0400) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r46 & 2048) != 0) goto L50;
        r2 = r35;
    L50:
        long r15 = -1;
        if ((r46 & 4096) == 0) goto L53;
        long r17 = -1;
    L55:
        if ((r46 & 8192) != 0) goto L59;
        r15 = r38;
    L59:
        if ((r46 & 16384) == 0) goto L61;
        String r14 = null;
    L63:
        if ((r46 & 32768) == 0) goto L65;
        Map r19 = new LinkedHashMap();
    L67:
        if ((r46 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) == 0) goto L69;
        String r20 = null;
    L71:
        if ((r46 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) != 0) goto L75;
        r10 = r43;
    L75:
        if ((r46 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) == 0) goto L77;
        long r21 = 0;
    L78:
        this(r1, r3, r4, r6, r7, r5, r8, r9, r11, r12, r13, r2, r17, r15, r14, r19, r20, r10, r21);
        return;
    L77:
        r21 = r44;
        goto L78
    L69:
        r20 = r42;
        goto L71
    L65:
        r19 = r41;
        goto L67
    L61:
        r14 = r40;
        goto L63
    L53:
        r17 = r36;
        goto L55
    L45:
        r13 = r34;
        goto L47
    L41:
        r12 = r33;
        goto L43
    L37:
        r11 = r32;
        goto L39
    L33:
        r9 = r31;
        goto L35
    L29:
        r8 = r30;
        goto L30
    L21:
        r7 = r28;
        goto L23
    L17:
        r6 = r27;
        goto L19
    L13:
        r4 = r26;
        goto L15
    L9:
        r3 = r25;
        goto L10
    L5:
        r1 = r24;
        goto L7
    }
}
