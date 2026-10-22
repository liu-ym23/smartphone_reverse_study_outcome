package com.bytedance.ai.bridge.doubao.chat;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$SetChatActionBarParamModel;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$EmptyMessageModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "SetChatActionBarParamModel", "EmptyMessageModel", "ChatActionBarItem", "ChatActionBarIcon", "ChatActionBarAction", "ChatActionBarGroupItem", "ChatActionBarItemKind", "ChatActionBarActionType", "ChatActionBarCapability", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsSetChatActionBarMethodIDL extends CoreAIBridgeMethod<b, a> {
    public final String a;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;", "", "type", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarActionType;", "prompt", "", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "capability", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarCapability;", "<init>", "(Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarActionType;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarCapability;)V", "getType", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarActionType;", "getPrompt", "()Ljava/lang/String;", "getSchema", "getCapability", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarCapability;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatActionBarAction {

        @SerializedName("capability")
        private final ChatActionBarCapability capability;

        @SerializedName("prompt")
        private final String prompt;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA)
        private final String schema;

        @SerializedName("type")
        private final ChatActionBarActionType type;

        public static /* synthetic */ ChatActionBarAction copy$default(ChatActionBarAction r0, ChatActionBarActionType r1, String r10, String r11, ChatActionBarCapability r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r10 = r0.prompt;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r11 = r0.schema;
        L12:
            if ((r13 & 8) == 0) goto L15;
            r12 = r0.capability;
        L15:
            return r0.copy(r1, r10, r11, r12);
        }

        public final ChatActionBarActionType component1() {
            return this.type;
        }

        public final String component2() {
            return this.prompt;
        }

        public final String component3() {
            return this.schema;
        }

        public final ChatActionBarCapability component4() {
            return this.capability;
        }

        public final ChatActionBarAction copy(ChatActionBarActionType r10, String r11, String r12, ChatActionBarCapability r13) {
            Intrinsics.checkNotNullParameter(r10, "type");
            return new ChatActionBarAction(r10, r11, r12, r13);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ChatActionBarAction) == true) goto L8;
            return false;
        L8:
            ChatActionBarAction r11 = (ChatActionBarAction) r10;
            if (this.type == r11.type) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.prompt, r11.prompt) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.schema, r11.schema) == true) goto L18;
            return false;
        L18:
            if (this.capability == r11.capability) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = this.type.hashCode() * 31;
            String r1 = this.prompt;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            String r13 = this.schema;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            ChatActionBarCapability r16 = this.capability;
            if (r16 == null) goto L15;
            r10 = r16.hashCode();
        L15:
            return r15 + r10;
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ChatActionBarAction(type=" + this.type + ", prompt=" + this.prompt + ", schema=" + this.schema + ", capability=" + this.capability + ')';
        }

        public final ChatActionBarCapability getCapability() {
            return this.capability;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getSchema() {
            return this.schema;
        }

        public final ChatActionBarActionType getType() {
            return this.type;
        }

        public ChatActionBarAction(ChatActionBarActionType r10, String r11, String r12, ChatActionBarCapability r13) {
            Intrinsics.checkNotNullParameter(r10, "type");
            this.type = r10;
            this.prompt = r11;
            this.schema = r12;
            this.capability = r13;
        }

        public /* synthetic */ ChatActionBarAction(ChatActionBarActionType r10, String r11, String r12, ChatActionBarCapability r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 2) == 0) goto L6;
            r11 = null;
        L6:
            if ((r14 & 4) == 0) goto L9;
            r12 = null;
        L9:
            if ((r14 & 8) == 0) goto L11;
            r13 = null;
        L11:
            this(r10, r11, r12, r13);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarActionType;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_PROMPT", "OPEN_SCHEMA", "OPEN_CAPABILITY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatActionBarActionType extends Enum<ChatActionBarActionType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ChatActionBarActionType[] $VALUES = null;

        @SerializedName("open_capability")
        public static final ChatActionBarActionType OPEN_CAPABILITY = null;

        @SerializedName("open_schema")
        public static final ChatActionBarActionType OPEN_SCHEMA = null;

        @SerializedName("send_prompt")
        public static final ChatActionBarActionType SEND_PROMPT = null;

        private static final /* synthetic */ ChatActionBarActionType[] $values() {
            return new ChatActionBarActionType[]{SEND_PROMPT, OPEN_SCHEMA, OPEN_CAPABILITY};
        }

        public static EnumEntries<ChatActionBarActionType> getEntries() {
            return $ENTRIES;
        }

        static {
            SEND_PROMPT = new ChatActionBarActionType("SEND_PROMPT", 0);
            OPEN_SCHEMA = new ChatActionBarActionType("OPEN_SCHEMA", 1);
            OPEN_CAPABILITY = new ChatActionBarActionType("OPEN_CAPABILITY", 2);
            ChatActionBarActionType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ChatActionBarActionType[] values() {
            return (ChatActionBarActionType[]) $VALUES.clone();
        }

        public static ChatActionBarActionType valueOf(String r1) {
            return (ChatActionBarActionType) r27.a.a(ChatActionBarActionType.class, r1);
        }

        private ChatActionBarActionType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarCapability;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN_CAMERA", "MUSIC_GENERATION", "IMAGE_GENERATION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatActionBarCapability extends Enum<ChatActionBarCapability> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ChatActionBarCapability[] $VALUES = null;

        @SerializedName("image_generation")
        public static final ChatActionBarCapability IMAGE_GENERATION = null;

        @SerializedName("music_generation")
        public static final ChatActionBarCapability MUSIC_GENERATION = null;

        @SerializedName("open_camera")
        public static final ChatActionBarCapability OPEN_CAMERA = null;

        private static final /* synthetic */ ChatActionBarCapability[] $values() {
            return new ChatActionBarCapability[]{OPEN_CAMERA, MUSIC_GENERATION, IMAGE_GENERATION};
        }

        public static EnumEntries<ChatActionBarCapability> getEntries() {
            return $ENTRIES;
        }

        static {
            OPEN_CAMERA = new ChatActionBarCapability("OPEN_CAMERA", 0);
            MUSIC_GENERATION = new ChatActionBarCapability("MUSIC_GENERATION", 1);
            IMAGE_GENERATION = new ChatActionBarCapability("IMAGE_GENERATION", 2);
            ChatActionBarCapability[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ChatActionBarCapability[] values() {
            return (ChatActionBarCapability[]) $VALUES.clone();
        }

        public static ChatActionBarCapability valueOf(String r1) {
            return (ChatActionBarCapability) r27.a.a(ChatActionBarCapability.class, r1);
        }

        private ChatActionBarCapability(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarGroupItem;", "", "id", "", "title", "icon", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;", "action", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;)V", "getId", "()Ljava/lang/String;", "getTitle", "getIcon", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;", "getAction", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatActionBarGroupItem {

        @SerializedName("action")
        private final ChatActionBarAction action;

        @SerializedName("icon")
        private final ChatActionBarIcon icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f8id;

        @SerializedName("title")
        private final String title;

        public static /* synthetic */ ChatActionBarGroupItem copy$default(ChatActionBarGroupItem r0, String r1, String r10, ChatActionBarIcon r11, ChatActionBarAction r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r1 = r0.f8id;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r10 = r0.title;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r11 = r0.icon;
        L12:
            if ((r13 & 8) == 0) goto L15;
            r12 = r0.action;
        L15:
            return r0.copy(r1, r10, r11, r12);
        }

        public final String component1() {
            return this.f8id;
        }

        public final String component2() {
            return this.title;
        }

        public final ChatActionBarIcon component3() {
            return this.icon;
        }

        public final ChatActionBarAction component4() {
            return this.action;
        }

        public final ChatActionBarGroupItem copy(String r10, String r11, ChatActionBarIcon r12, ChatActionBarAction r13) {
            Intrinsics.checkNotNullParameter(r10, "id");
            Intrinsics.checkNotNullParameter(r11, "title");
            Intrinsics.checkNotNullParameter(r13, "action");
            return new ChatActionBarGroupItem(r10, r11, r12, r13);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ChatActionBarGroupItem) == true) goto L8;
            return false;
        L8:
            ChatActionBarGroupItem r11 = (ChatActionBarGroupItem) r10;
            if (Intrinsics.areEqual(this.f8id, r11.f8id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r11.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.action, r11.action) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f8id.hashCode() * 31) + this.title.hashCode()) * 31;
            ChatActionBarIcon r1 = this.icon;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return ((r0 + r10) * 31) + this.action.hashCode();
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ChatActionBarGroupItem(id=" + this.f8id + ", title=" + this.title + ", icon=" + this.icon + ", action=" + this.action + ')';
        }

        public final ChatActionBarAction getAction() {
            return this.action;
        }

        public final ChatActionBarIcon getIcon() {
            return this.icon;
        }

        public final String getId() {
            return this.f8id;
        }

        public final String getTitle() {
            return this.title;
        }

        public ChatActionBarGroupItem(String r10, String r11, ChatActionBarIcon r12, ChatActionBarAction r13) {
            Intrinsics.checkNotNullParameter(r10, "id");
            Intrinsics.checkNotNullParameter(r11, "title");
            Intrinsics.checkNotNullParameter(r13, "action");
            this.f8id = r10;
            this.title = r11;
            this.icon = r12;
            this.action = r13;
        }

        public /* synthetic */ ChatActionBarGroupItem(String r1, String r10, ChatActionBarIcon r11, ChatActionBarAction r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 4) == 0) goto L5;
            r11 = null;
        L5:
            this(r1, r10, r11, r12);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;", "", "light", "", "dark", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLight", "()Ljava/lang/String;", "getDark", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatActionBarIcon {

        @SerializedName("dark")
        private final String dark;

        @SerializedName("light")
        private final String light;

        public static /* synthetic */ ChatActionBarIcon copy$default(ChatActionBarIcon r0, String r1, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.light;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.dark;
        L9:
            return r0.copy(r1, r10);
        }

        public final String component1() {
            return this.light;
        }

        public final String component2() {
            return this.dark;
        }

        public final ChatActionBarIcon copy(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "light");
            Intrinsics.checkNotNullParameter(r11, "dark");
            return new ChatActionBarIcon(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ChatActionBarIcon) == true) goto L8;
            return false;
        L8:
            ChatActionBarIcon r11 = (ChatActionBarIcon) r10;
            if (Intrinsics.areEqual(this.light, r11.light) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.dark, r11.dark) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.light.hashCode() * 31) + this.dark.hashCode();
        }

        public String toString() {
            return "ChatActionBarIcon(light=" + this.light + ", dark=" + this.dark + ')';
        }

        public final String getDark() {
            return this.dark;
        }

        public final String getLight() {
            return this.light;
        }

        public ChatActionBarIcon(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "light");
            Intrinsics.checkNotNullParameter(r11, "dark");
            this.light = r10;
            this.dark = r11;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001eJ`\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItem;", "", "id", "", "kind", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItemKind;", "title", "icon", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;", "action", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;", "items", "Ljava/util/List;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarGroupItem;", "rowCount", "", "<init>", "(Ljava/lang/String;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItemKind;Ljava/lang/String;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;Ljava/util/List;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getKind", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItemKind;", "getTitle", "getIcon", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;", "getAction", "()Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;", "getItems", "()Ljava/util/List;", "getRowCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItemKind;Ljava/lang/String;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarIcon;Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarAction;Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItem;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatActionBarItem {

        @SerializedName("action")
        private final ChatActionBarAction action;

        @SerializedName("icon")
        private final ChatActionBarIcon icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f9id;

        @SerializedName("items")
        private final List<ChatActionBarGroupItem> items;

        @SerializedName("kind")
        private final ChatActionBarItemKind kind;

        @SerializedName("rowCount")
        private final Integer rowCount;

        @SerializedName("title")
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChatActionBarItem copy$default(ChatActionBarItem r10, String r11, ChatActionBarItemKind r12, String r13, ChatActionBarIcon r14, ChatActionBarAction r15, List r16, Integer r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L6;
            r11 = r10.f9id;
        L6:
            if ((r18 & 2) == 0) goto L8;
            r12 = r10.kind;
        L8:
            ChatActionBarItemKind r110 = r12;
            if ((r18 & 4) == 0) goto L11;
            r13 = r10.title;
        L11:
            String r0 = r13;
            if ((r18 & 8) == 0) goto L14;
            r14 = r10.icon;
        L14:
            ChatActionBarIcon r1 = r14;
            if ((r18 & 16) == 0) goto L17;
            r15 = r10.action;
        L17:
            ChatActionBarAction r20 = r15;
            if ((r18 & 32) == 0) goto L20;
            r16 = r10.items;
        L20:
            List r21 = r16;
            if ((r18 & 64) == 0) goto L23;
            r17 = r10.rowCount;
        L23:
            String r22 = r11;
            return r10.copy(r22, r110, r0, r1, r20, r21, r17);
        }

        public final String component1() {
            return this.f9id;
        }

        public final ChatActionBarItemKind component2() {
            return this.kind;
        }

        public final String component3() {
            return this.title;
        }

        public final ChatActionBarIcon component4() {
            return this.icon;
        }

        public final ChatActionBarAction component5() {
            return this.action;
        }

        public final List<ChatActionBarGroupItem> component6() {
            return this.items;
        }

        public final Integer component7() {
            return this.rowCount;
        }

        public final ChatActionBarItem copy(String r10, ChatActionBarItemKind r11, String r12, ChatActionBarIcon r13, ChatActionBarAction r14, List<ChatActionBarGroupItem> r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r10, "id");
            Intrinsics.checkNotNullParameter(r11, "kind");
            Intrinsics.checkNotNullParameter(r12, "title");
            Intrinsics.checkNotNullParameter(r13, "icon");
            return new ChatActionBarItem(r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ChatActionBarItem) == true) goto L8;
            return false;
        L8:
            ChatActionBarItem r11 = (ChatActionBarItem) r10;
            if (Intrinsics.areEqual(this.f9id, r11.f9id) == true) goto L12;
            return false;
        L12:
            if (this.kind == r11.kind) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.title, r11.title) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.action, r11.action) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.items, r11.items) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.rowCount, r11.rowCount) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f9id.hashCode() * 31) + this.kind.hashCode()) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31;
            ChatActionBarAction r1 = this.action;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            List<ChatActionBarGroupItem> r13 = this.items;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.rowCount;
            if (r16 == null) goto L15;
            r10 = r16.hashCode();
        L15:
            return r15 + r10;
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ChatActionBarItem(id=" + this.f9id + ", kind=" + this.kind + ", title=" + this.title + ", icon=" + this.icon + ", action=" + this.action + ", items=" + this.items + ", rowCount=" + this.rowCount + ')';
        }

        public final ChatActionBarAction getAction() {
            return this.action;
        }

        public final ChatActionBarIcon getIcon() {
            return this.icon;
        }

        public final String getId() {
            return this.f9id;
        }

        public final List<ChatActionBarGroupItem> getItems() {
            return this.items;
        }

        public final ChatActionBarItemKind getKind() {
            return this.kind;
        }

        public final Integer getRowCount() {
            return this.rowCount;
        }

        public final String getTitle() {
            return this.title;
        }

        public ChatActionBarItem(String r10, ChatActionBarItemKind r11, String r12, ChatActionBarIcon r13, ChatActionBarAction r14, List<ChatActionBarGroupItem> r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r10, "id");
            Intrinsics.checkNotNullParameter(r11, "kind");
            Intrinsics.checkNotNullParameter(r12, "title");
            Intrinsics.checkNotNullParameter(r13, "icon");
            this.f9id = r10;
            this.kind = r11;
            this.title = r12;
            this.icon = r13;
            this.action = r14;
            this.items = r15;
            this.rowCount = r16;
        }

        public /* synthetic */ ChatActionBarItem(String r11, ChatActionBarItemKind r12, String r13, ChatActionBarIcon r14, ChatActionBarAction r15, List r16, Integer r17, int r18, DefaultConstructorMarker r19) {
            if ((r18 & 16) == 0) goto L5;
            ChatActionBarAction r10 = null;
        L7:
            if ((r18 & 32) == 0) goto L9;
            List r20 = null;
        L11:
            if ((r18 & 64) == 0) goto L13;
            Integer r21 = null;
        L14:
            this(r11, r12, r13, r14, r10, r20, r21);
            return;
        L13:
            r21 = r17;
            goto L14
        L9:
            r20 = r16;
            goto L11
        L5:
            r10 = r15;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsSetChatActionBarMethodIDL$ChatActionBarItemKind;", "", "<init>", "(Ljava/lang/String;I)V", "ACTION", "ACTION_GROUP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatActionBarItemKind extends Enum<ChatActionBarItemKind> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ChatActionBarItemKind[] $VALUES = null;

        @SerializedName("action")
        public static final ChatActionBarItemKind ACTION = null;

        @SerializedName("action_group")
        public static final ChatActionBarItemKind ACTION_GROUP = null;

        private static final /* synthetic */ ChatActionBarItemKind[] $values() {
            return new ChatActionBarItemKind[]{ACTION, ACTION_GROUP};
        }

        public static EnumEntries<ChatActionBarItemKind> getEntries() {
            return $ENTRIES;
        }

        static {
            ACTION = new ChatActionBarItemKind("ACTION", 0);
            ACTION_GROUP = new ChatActionBarItemKind("ACTION_GROUP", 1);
            ChatActionBarItemKind[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ChatActionBarItemKind[] values() {
            return (ChatActionBarItemKind[]) $VALUES.clone();
        }

        public static ChatActionBarItemKind valueOf(String r1) {
            return (ChatActionBarItemKind) r27.a.a(ChatActionBarItemKind.class, r1);
        }

        private ChatActionBarItemKind(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "items", required = true)
        List<ChatActionBarItem> getItems();
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsSetChatActionBarMethodIDL() {
        this.a = "applet.setChatActionBar";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
