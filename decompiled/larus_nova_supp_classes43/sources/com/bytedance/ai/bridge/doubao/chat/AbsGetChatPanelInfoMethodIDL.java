package com.bytedance.ai.bridge.doubao.chat;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL$ChatPanelInfoModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "EmptyMessageModel", "ChatPanelInfoModel", "ChatPanelState", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetChatPanelInfoMethodIDL extends CoreAIBridgeMethod<b, a> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/doubao/chat/AbsGetChatPanelInfoMethodIDL$ChatPanelState;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSED", "PREVIEW", "EXPANDED", "INVISIBLE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatPanelState extends Enum<ChatPanelState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ChatPanelState[] $VALUES = null;

        @SerializedName("collapsed")
        public static final ChatPanelState COLLAPSED = null;

        @SerializedName("expanded")
        public static final ChatPanelState EXPANDED = null;

        @SerializedName("invisible")
        public static final ChatPanelState INVISIBLE = null;

        @SerializedName("preview")
        public static final ChatPanelState PREVIEW = null;

        private static final /* synthetic */ ChatPanelState[] $values() {
            return new ChatPanelState[]{COLLAPSED, PREVIEW, EXPANDED, INVISIBLE};
        }

        public static EnumEntries<ChatPanelState> getEntries() {
            return $ENTRIES;
        }

        static {
            COLLAPSED = new ChatPanelState("COLLAPSED", 0);
            PREVIEW = new ChatPanelState("PREVIEW", 1);
            EXPANDED = new ChatPanelState("EXPANDED", 2);
            INVISIBLE = new ChatPanelState("INVISIBLE", 3);
            ChatPanelState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ChatPanelState[] values() {
            return (ChatPanelState[]) $VALUES.clone();
        }

        public static ChatPanelState valueOf(String r1) {
            return (ChatPanelState) r27.a.a(ChatPanelState.class, r1);
        }

        private ChatPanelState(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
        @AIBridgeParamField(keyPath = "height", required = true)
        void setHeight(int r1);

        @AIBridgeParamField(keyPath = "state", required = true)
        void setState(ChatPanelState r1);
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsGetChatPanelInfoMethodIDL() {
        this.a = "doubao.getChatPanelInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
