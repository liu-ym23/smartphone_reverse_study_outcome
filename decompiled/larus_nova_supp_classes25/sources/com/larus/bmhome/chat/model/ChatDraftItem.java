package com.larus.bmhome.chat.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.NestedFileContent;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/model/ChatDraftItem;", "", "type", "", "content", "key", "updateTime", "", "fileName", "nestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "resourceId", "fileIdentifier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/larus/im/bean/message/NestedFileContent;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getContent", "getKey", "getUpdateTime", "()J", "getFileName", "getNestedFileContent", "()Lcom/larus/im/bean/message/NestedFileContent;", "getResourceId", "getFileIdentifier", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatDraftItem {
    public static final a Companion = null;
    private static final long DRAFT_EXPIRED_TIMTE = 0;
    public static final String TYPE_ACTION_BAR_INSTRUCTION = "action_bar_instruction";
    public static final String TYPE_ACTION_BAR_SELECTION = "action_bar_selection";
    public static final String TYPE_MSG_EXT = "msg_ext";
    public static final String TYPE_NESTED_FILE = "nested_file";
    public static final String TYPE_OBRIC_MENTION_SKILL_IDS = "obric_mention_skill_ids";
    public static final String TYPE_OBRIC_SELECTED_SKILL_IDS = "obric_selected_skill_ids";
    public static final String TYPE_REPLY = "reply";
    public static final String TYPE_SUGGESTED_ACTION_OPERATIONS = "suggested_action_operations";
    public static final String TYPE_TASK_MODE_SELECTION = "task_mode_selection";
    public static final String TYPE_TEXT = "text";

    @SerializedName("content")
    private final String content;

    @SerializedName("file_identifier")
    private final String fileIdentifier;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("key")
    private final String key;

    @SerializedName("nested_file_content")
    private final NestedFileContent nestedFileContent;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("type")
    private final String type;

    @SerializedName("update_time")
    private final long updateTime;

    public static final class a {
        public a() {
        }

        public static ChatDraftItem a(a r13, String r14, String r15, String r16, String r17, NestedFileContent r18, int r19) {
            if ((r19 & 4) == 0) goto L5;
            String r0 = "";
        L7:
            if ((r19 & 8) == 0) goto L9;
            String r9 = "";
        L11:
            if ((r19 & 16) == 0) goto L13;
            NestedFileContent r10 = null;
        L14:
            r13.getClass();
            if (r15 != null) goto L17;
            String r5 = "";
        L18:
            if (r0 != null) goto L20;
            String r6 = "";
        L22:
            return new ChatDraftItem(r14, r5, r6, System.currentTimeMillis(), r9, r10, null, null);
        L20:
            r6 = r0;
            goto L22
        L17:
            r5 = r15;
            goto L18
        L13:
            r10 = r18;
            goto L14
        L9:
            r9 = r17;
            goto L11
        L5:
            r0 = r16;
            goto L7
        }
    }

    public ChatDraftItem() {
        this(null, null, null, 0, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ChatDraftItem copy$default(ChatDraftItem r10, String r11, String r12, String r13, long r14, String r16, NestedFileContent r17, String r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.type;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.content;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.key;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = r10.updateTime;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.fileName;
    L23:
        if ((r20 & 32) == 0) goto L25;
        NestedFileContent r8 = r10.nestedFileContent;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.resourceId;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r1 = r10.fileIdentifier;
    L35:
        return r10.copy(r2, r3, r4, r5, r7, r8, r9, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.key;
    }

    public final long component4() {
        return this.updateTime;
    }

    public final String component5() {
        return this.fileName;
    }

    public final NestedFileContent component6() {
        return this.nestedFileContent;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.fileIdentifier;
    }

    public final ChatDraftItem copy(String r12, String r13, String r14, long r15, String r17, NestedFileContent r18, String r19, String r20) {
        return new ChatDraftItem(r12, r13, r14, r15, r17, r18, r19, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatDraftItem) == true) goto L8;
        return false;
    L8:
        ChatDraftItem r9 = (ChatDraftItem) r8;
        if (Intrinsics.areEqual(this.type, r9.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L18;
        return false;
    L18:
        if (this.updateTime == r9.updateTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.nestedFileContent, r9.nestedFileContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resourceId, r9.resourceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fileIdentifier, r9.fileIdentifier) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.key;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        long r10 = this.updateTime;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.fileName;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        NestedFileContent r15 = this.nestedFileContent;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        String r18 = this.resourceId;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.fileIdentifier;
        if (r21 == null) goto L31;
        r1 = r21.hashCode();
    L31:
        return r20 + r1;
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
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

    public String toString() {
        return "ChatDraftItem(type=" + this.type + ", content=" + this.content + ", key=" + this.key + ", updateTime=" + this.updateTime + ", fileName=" + this.fileName + ", nestedFileContent=" + this.nestedFileContent + ", resourceId=" + this.resourceId + ", fileIdentifier=" + this.fileIdentifier + ')';
    }

    static {
        Companion = new a();
        DRAFT_EXPIRED_TIMTE = TimeUnit.DAYS.toMillis(30);
    }

    public static final /* synthetic */ long access$getDRAFT_EXPIRED_TIMTE$cp() {
        return DRAFT_EXPIRED_TIMTE;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getKey() {
        return this.key;
    }

    public final NestedFileContent getNestedFileContent() {
        return this.nestedFileContent;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public ChatDraftItem(String r1, String r2, String r3, long r4, String r6, NestedFileContent r7, String r8, String r9) {
        this.type = r1;
        this.content = r2;
        this.key = r3;
        this.updateTime = r4;
        this.fileName = r6;
        this.nestedFileContent = r7;
        this.resourceId = r8;
        this.fileIdentifier = r9;
    }

    public /* synthetic */ ChatDraftItem(String r11, String r12, String r13, long r14, String r16, NestedFileContent r17, String r18, String r19, int r20, DefaultConstructorMarker r21) {
        String r2 = "";
        if ((r20 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = 0;
    L19:
        if ((r20 & 16) != 0) goto L22;
        r2 = r16;
    L22:
        String r8 = null;
        if ((r20 & 32) == 0) goto L25;
        NestedFileContent r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r20 & 128) != 0) goto L34;
        r8 = r19;
    L34:
        this(r1, r3, r4, r5, r2, r7, r9, r8);
        return;
    L29:
        r9 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
