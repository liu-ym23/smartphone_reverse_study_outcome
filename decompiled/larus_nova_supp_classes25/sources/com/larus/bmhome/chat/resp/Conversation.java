package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.conversation.IconImage;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old link data")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bg\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010CJ\u0011\u0010s\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0003J\t\u0010t\u001a\u00020\u0015HÆ\u0003J\t\u0010u\u001a\u00020\u0015HÆ\u0003J\u0011\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010|\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J·\u0002\u0010\u007f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0003\u0010\u0080\u0001J\u0007\u0010\u0081\u0001\u001a\u00020\u0005J\u0016\u0010\u0082\u0001\u001a\u00020\u00152\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001HÖ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0086\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u00020\u0005R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b0\u0010*\"\u0004\b1\u0010,R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b2\u0010*\"\u0004\b3\u0010,R\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010&\"\u0004\b9\u0010(R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010&\"\u0004\b?\u0010(R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010&\"\u0004\bA\u0010(R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010L\"\u0004\bP\u0010NR&\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010H\"\u0004\bR\u0010JR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010&\"\u0004\b\\\u0010(R \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010&\"\u0004\b^\u0010(R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b_\u0010*\"\u0004\b`\u0010,R\"\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\ba\u0010*\"\u0004\bb\u0010,R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010&\"\u0004\bd\u0010(R\"\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\be\u0010*\"\u0004\bf\u0010,¨\u0006\u008c\u0001"}, d2 = {"Lcom/larus/bmhome/chat/resp/Conversation;", "Landroid/os/Parcelable;", "id", "", "conversationType", "", "messageCursor", "retentionCursor", "messageIndex", "readMessageIndex", "cmdIndex", "lastSectionId", "iconImage", "Lcom/larus/im/bean/conversation/IconImage;", "name", "botId", "updateTime", "", "tags", "", "deleted", "", "pinned", "templates", "Lcom/larus/bmhome/chat/resp/Templates;", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "bgImgUrl", "bgImgColor", "conversationContentType", "botContentType", "defaultOnboarding", "botType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/conversation/IconImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;ZZLjava/util/List;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getConversationType", "()Ljava/lang/Integer;", "setConversationType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessageCursor", "setMessageCursor", "getRetentionCursor", "setRetentionCursor", "getMessageIndex", "setMessageIndex", "getReadMessageIndex", "setReadMessageIndex", "getCmdIndex", "setCmdIndex", "getLastSectionId", "setLastSectionId", "getIconImage", "()Lcom/larus/im/bean/conversation/IconImage;", "setIconImage", "(Lcom/larus/im/bean/conversation/IconImage;)V", "getName", "setName", "getBotId", "setBotId", "getUpdateTime", "()Ljava/lang/Long;", "setUpdateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getDeleted", "()Z", "setDeleted", "(Z)V", "getPinned", "setPinned", "getTemplates", "setTemplates", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "setBotCreatorInfo", "(Lcom/larus/im/bean/bot/BotCreatorInfo;)V", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "setConversationPage", "(Lcom/larus/im/bean/bot/ConversationPage;)V", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getConversationContentType", "setConversationContentType", "getBotContentType", "setBotContentType", "getDefaultOnboarding", "setDefaultOnboarding", "getBotType", "setBotType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/conversation/IconImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;ZZLjava/util/List;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/ConversationPage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/resp/Conversation;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class Conversation implements Parcelable {
    public static final Parcelable.Creator<Conversation> CREATOR = null;

    @SerializedName("bg_img_avg_hue")
    private String bgImgColor;

    @SerializedName("bg_img_url")
    private String bgImgUrl;

    @SerializedName("content_dist_type")
    private Integer botContentType;

    @SerializedName("bot_creator_info")
    private BotCreatorInfo botCreatorInfo;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("bot_type")
    private Integer botType;

    @SerializedName("cmd_index")
    private Integer cmdIndex;

    @SerializedName("bot_conversation_type")
    private Integer conversationContentType;

    @SerializedName("conversation_page")
    private com.larus.im.bean.bot.ConversationPage conversationPage;

    @SerializedName("conversation_type")
    private Integer conversationType;

    @SerializedName("default_onboarding")
    private String defaultOnboarding;

    @SerializedName("deleted")
    private boolean deleted;

    @SerializedName("icon_image")
    private IconImage iconImage;

    @SerializedName("conversation_id")
    private String id;

    @SerializedName("last_section_id")
    private String lastSectionId;

    @SerializedName("message_cursor")
    private Integer messageCursor;

    @SerializedName("message_index")
    private Integer messageIndex;

    @SerializedName("name")
    private String name;

    @SerializedName("pinned")
    private boolean pinned;

    @SerializedName("read_message_index")
    private Integer readMessageIndex;

    @SerializedName("retention_cursor")
    private Integer retentionCursor;

    @SerializedName("tags")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<String> tags;

    @SerializedName("msg_templates")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<Templates> templates;

    @SerializedName("update_time")
    private Long updateTime;

    public static final class a implements Parcelable.Creator<Conversation> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Conversation createFromParcel(Parcel r30) {
            Intrinsics.checkNotNullParameter(r30, "parcel");
            String r3 = r30.readString();
            if (r30.readInt() != 0) goto L5;
            Integer r4 = null;
        L7:
            if (r30.readInt() != 0) goto L9;
            Integer r5 = null;
        L11:
            if (r30.readInt() != 0) goto L13;
            Integer r6 = null;
        L15:
            if (r30.readInt() != 0) goto L17;
            Integer r7 = null;
        L19:
            if (r30.readInt() != 0) goto L21;
            Integer r8 = null;
        L23:
            if (r30.readInt() != 0) goto L25;
            Integer r9 = null;
        L26:
            String r10 = r30.readString();
            IconImage r11 = r30.readSerializable();
            String r12 = r30.readString();
            String r13 = r30.readString();
            if (r30.readInt() != 0) goto L29;
            Long r14 = null;
        L30:
            ArrayList<String> r15 = r30.createStringArrayList();
            if (r30.readInt() == 0) goto L33;
            boolean r1 = true;
        L35:
            if (r30.readInt() == 0) goto L37;
            boolean r18 = true;
        L39:
            if (r30.readInt() != 0) goto L41;
            ArrayList r2 = null;
        L44:
            BotCreatorInfo r21 = r30.readSerializable();
            com.larus.im.bean.bot.ConversationPage r22 = r30.readSerializable();
            String r23 = r30.readString();
            String r24 = r30.readString();
            if (r30.readInt() != 0) goto L47;
            Integer r25 = null;
        L49:
            if (r30.readInt() != 0) goto L51;
            Integer r26 = null;
        L52:
            String r27 = r30.readString();
            if (r30.readInt() != 0) goto L55;
            Integer r0 = null;
        L57:
            return new Conversation(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1, r18, r2, r21, r22, r23, r24, r25, r26, r27, r0);
        L55:
            r0 = Integer.valueOf(r30.readInt());
            goto L57
        L51:
            r26 = Integer.valueOf(r30.readInt());
            goto L52
        L47:
            r25 = Integer.valueOf(r30.readInt());
            goto L49
        L41:
            int r16 = r30.readInt();
            r2 = new ArrayList(r16);
            int r17 = 0;
        L42:
            if (r17 == r16) goto L44;
            int r19 = r16;
            r2.add(Templates.CREATOR.createFromParcel(r30));
            r17 = r17 + 1;
            r16 = r19;
            goto L42
        L37:
            r18 = false;
            goto L39
        L33:
            r1 = false;
            goto L35
        L29:
            r14 = Long.valueOf(r30.readLong());
            goto L30
        L25:
            r9 = Integer.valueOf(r30.readInt());
            goto L26
        L21:
            r8 = Integer.valueOf(r30.readInt());
            goto L23
        L17:
            r7 = Integer.valueOf(r30.readInt());
            goto L19
        L13:
            r6 = Integer.valueOf(r30.readInt());
            goto L15
        L9:
            r5 = Integer.valueOf(r30.readInt());
            goto L11
        L5:
            r4 = Integer.valueOf(r30.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Conversation[] newArray(int r1) {
            return new Conversation[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Conversation) == true) goto L8;
        return false;
    L8:
        Conversation r6 = (Conversation) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationType, r6.conversationType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageCursor, r6.messageCursor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.retentionCursor, r6.retentionCursor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageIndex, r6.messageIndex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.readMessageIndex, r6.readMessageIndex) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cmdIndex, r6.cmdIndex) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lastSectionId, r6.lastSectionId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconImage, r6.iconImage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.updateTime, r6.updateTime) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.tags, r6.tags) == true) goto L48;
        return false;
    L48:
        if (this.deleted == r6.deleted) goto L51;
        return false;
    L51:
        if (this.pinned == r6.pinned) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.templates, r6.templates) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.botCreatorInfo, r6.botCreatorInfo) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.conversationPage, r6.conversationPage) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.bgImgUrl, r6.bgImgUrl) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bgImgColor, r6.bgImgColor) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.conversationContentType, r6.conversationContentType) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.botContentType, r6.botContentType) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.defaultOnboarding, r6.defaultOnboarding) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.botType, r6.botType) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.conversationType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.messageCursor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.retentionCursor;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.messageIndex;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.readMessageIndex;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.cmdIndex;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.lastSectionId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        IconImage r25 = this.iconImage;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.name;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.botId;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.updateTime;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        List<String> r37 = this.tags;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        int r40 = 1231;
        if (this.deleted == false) goto L57;
        int r41 = 1231;
    L58:
        int r42 = (r39 + r41) * 31;
        if (this.pinned == true) goto L62;
        r40 = 1237;
    L62:
        int r43 = (r42 + r40) * 31;
        List<Templates> r44 = this.templates;
        if (r44 != null) goto L65;
        int r45 = 0;
    L66:
        int r46 = (r43 + r45) * 31;
        BotCreatorInfo r47 = this.botCreatorInfo;
        if (r47 != null) goto L69;
        int r48 = 0;
    L70:
        int r49 = (r46 + r48) * 31;
        com.larus.im.bean.bot.ConversationPage r50 = this.conversationPage;
        if (r50 != null) goto L73;
        int r51 = 0;
    L74:
        int r52 = (r49 + r51) * 31;
        String r53 = this.bgImgUrl;
        if (r53 != null) goto L77;
        int r54 = 0;
    L78:
        int r55 = (r52 + r54) * 31;
        String r56 = this.bgImgColor;
        if (r56 != null) goto L81;
        int r57 = 0;
    L82:
        int r58 = (r55 + r57) * 31;
        Integer r59 = this.conversationContentType;
        if (r59 != null) goto L85;
        int r60 = 0;
    L86:
        int r61 = (r58 + r60) * 31;
        Integer r62 = this.botContentType;
        if (r62 != null) goto L89;
        int r63 = 0;
    L90:
        int r64 = (r61 + r63) * 31;
        String r65 = this.defaultOnboarding;
        if (r65 != null) goto L93;
        int r66 = 0;
    L94:
        int r67 = (r64 + r66) * 31;
        Integer r68 = this.botType;
        if (r68 == null) goto L99;
        r1 = r68.hashCode();
    L99:
        return r67 + r1;
    L93:
        r66 = r65.hashCode();
        goto L94
    L89:
        r63 = r62.hashCode();
        goto L90
    L85:
        r60 = r59.hashCode();
        goto L86
    L81:
        r57 = r56.hashCode();
        goto L82
    L77:
        r54 = r53.hashCode();
        goto L78
    L73:
        r51 = r50.hashCode();
        goto L74
    L69:
        r48 = r47.hashCode();
        goto L70
    L65:
        r45 = r44.hashCode();
        goto L66
    L57:
        r41 = 1237;
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Conversation(id=" + this.id + ", conversationType=" + this.conversationType + ", messageCursor=" + this.messageCursor + ", retentionCursor=" + this.retentionCursor + ", messageIndex=" + this.messageIndex + ", readMessageIndex=" + this.readMessageIndex + ", cmdIndex=" + this.cmdIndex + ", lastSectionId=" + this.lastSectionId + ", iconImage=" + this.iconImage + ", name=" + this.name + ", botId=" + this.botId + ", updateTime=" + this.updateTime + ", tags=" + this.tags + ", deleted=" + this.deleted + ", pinned=" + this.pinned + ", templates=" + this.templates + ", botCreatorInfo=" + this.botCreatorInfo + ", conversationPage=" + this.conversationPage + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", conversationContentType=" + this.conversationContentType + ", botContentType=" + this.botContentType + ", defaultOnboarding=" + this.defaultOnboarding + ", botType=" + this.botType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.id);
        Integer r0 = this.conversationType;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Integer r1 = this.messageCursor;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        Integer r2 = this.retentionCursor;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        Integer r3 = this.messageIndex;
        if (r3 != null) goto L17;
        r6.writeInt(0);
    L18:
        Integer r4 = this.readMessageIndex;
        if (r4 != null) goto L21;
        r6.writeInt(0);
    L22:
        Integer r5 = this.cmdIndex;
        if (r5 != null) goto L25;
        r6.writeInt(0);
    L26:
        r6.writeString(this.lastSectionId);
        r6.writeSerializable(this.iconImage);
        r6.writeString(this.name);
        r6.writeString(this.botId);
        Long r8 = this.updateTime;
        if (r8 != null) goto L29;
        r6.writeInt(0);
    L30:
        r6.writeStringList(this.tags);
        r6.writeInt(this.deleted ? 1 : 0);
        r6.writeInt(this.pinned ? 1 : 0);
        List<Templates> r9 = this.templates;
        if (r9 != null) goto L33;
        r6.writeInt(0);
    L37:
        r6.writeSerializable(this.botCreatorInfo);
        r6.writeSerializable(this.conversationPage);
        r6.writeString(this.bgImgUrl);
        r6.writeString(this.bgImgColor);
        Integer r10 = this.conversationContentType;
        if (r10 != null) goto L40;
        r6.writeInt(0);
    L41:
        Integer r11 = this.botContentType;
        if (r11 != null) goto L44;
        r6.writeInt(0);
    L45:
        r6.writeString(this.defaultOnboarding);
        Integer r12 = this.botType;
        if (r12 != null) goto L48;
        r6.writeInt(0);
        return;
    L48:
        r6.writeInt(1);
        r6.writeInt(r12.intValue());
        return;
    L44:
        r6.writeInt(1);
        r6.writeInt(r11.intValue());
        goto L45
    L40:
        r6.writeInt(1);
        r6.writeInt(r10.intValue());
        goto L41
    L33:
        r6.writeInt(1);
        r6.writeInt(r9.size());
        Iterator<Templates> r13 = r9.iterator();
    L35:
        if (r13.hasNext() == false) goto L37;
        r13.next().writeToParcel(r6, r7);
        goto L35
    L29:
        r6.writeInt(1);
        r6.writeLong(r8.longValue());
        goto L30
    L25:
        r6.writeInt(1);
        r6.writeInt(r5.intValue());
        goto L26
    L21:
        r6.writeInt(1);
        r6.writeInt(r4.intValue());
        goto L22
    L17:
        r6.writeInt(1);
        r6.writeInt(r3.intValue());
        goto L18
    L13:
        r6.writeInt(1);
        r6.writeInt(r2.intValue());
        goto L14
    L9:
        r6.writeInt(1);
        r6.writeInt(r1.intValue());
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.intValue());
        goto L6
    }

    public Conversation() {
        this("", 0, 1, 1, 0, 0, 0, "", null, "", "", null, null, false, false, null, null, null, null, null, 0, 0, null, null);
    }

    public final String a() {
        return this.bgImgColor;
    }

    public final String b() {
        return this.bgImgUrl;
    }

    public final String c() {
        return this.botId;
    }

    public final Integer d() {
        return this.conversationContentType;
    }

    public final String getId() {
        return this.id;
    }

    public Conversation(String r3, Integer r4, Integer r5, Integer r6, Integer r7, Integer r8, Integer r9, String r10, IconImage r11, String r12, String r13, Long r14, List<String> r15, boolean r16, boolean r17, List<Templates> r18, BotCreatorInfo r19, com.larus.im.bean.bot.ConversationPage r20, String r21, String r22, Integer r23, Integer r24, String r25, Integer r26) {
        this.id = r3;
        this.conversationType = r4;
        this.messageCursor = r5;
        this.retentionCursor = r6;
        this.messageIndex = r7;
        this.readMessageIndex = r8;
        this.cmdIndex = r9;
        this.lastSectionId = r10;
        this.iconImage = r11;
        this.name = r12;
        this.botId = r13;
        this.updateTime = r14;
        this.tags = r15;
        this.deleted = r16;
        this.pinned = r17;
        this.templates = r18;
        this.botCreatorInfo = r19;
        this.conversationPage = r20;
        this.bgImgUrl = r21;
        this.bgImgColor = r22;
        this.conversationContentType = r23;
        this.botContentType = r24;
        this.defaultOnboarding = r25;
        this.botType = r26;
    }
}
