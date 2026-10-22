package com.larus.uaigc.bean.createpage;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ny9.u;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u0000 r2\u00020\u0001:\u0002rsBõ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u0017\u0012\b\b\u0002\u0010%\u001a\u00020\u0017\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b'\u0010(J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0017\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010^\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0017\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0017\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0019\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0017HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010h\u001a\u00020\u0017HÆ\u0003J\t\u0010i\u001a\u00020\u0017HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jü\u0002\u0010k\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\u00172\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020\u00172\b\u0010n\u001a\u0004\u0018\u00010oHÖ\u0003J\t\u0010p\u001a\u00020\rHÖ\u0001J\t\u0010q\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bC\u00107R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bD\u00107R!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010*R\u0011\u0010 \u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010*R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010$\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b$\u0010JR\u0011\u0010%\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bN\u0010JR\u0013\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010*¨\u0006t"}, d2 = {"Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "Ljava/io/Serializable;", "cvsId", "", "botId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "content", "scene", "txtScene", "enterMethod", "previousPage", "actionInstruction", "", "actionBarInstructionMap", "", "attachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "customMultiAttachmentInfo", "Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "hasImagePreprocessed", "", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "messageExtMap", "bizExtMap", "sendTrackExtMap", "creationSendTraceId", "actionBarCreationId", "actionBarCreationType", "localIntercepted", "localInterceptInfo", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "isReEdit", "clearInputContent", "lyricCreateType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;Ljava/lang/Boolean;Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;ZZLjava/lang/String;)V", "getCvsId", "()Ljava/lang/String;", "getBotId", "getConversation", "()Lcom/larus/im/bean/conversation/Conversation;", "getContent", "getScene", "getTxtScene", "getEnterMethod", "getPreviousPage", "getActionInstruction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActionBarInstructionMap", "()Ljava/util/Map;", "getAttachmentInfo", "()Lcom/larus/bmhome/view/AttachmentInfo;", "getCustomMultiAttachmentInfo", "()Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "getImageEditDataWithMask", "()Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "getHasImagePreprocessed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getMessageExtMap", "getBizExtMap", "getSendTrackExtMap", "getCreationSendTraceId", "getActionBarCreationId", "getActionBarCreationType", "getLocalIntercepted", "()Z", "getLocalInterceptInfo", "getChatPageContext", "()Lcom/larus/bmhome/chat/bean/ChatPageContext;", "getClearInputContent", "getLyricCreateType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;Ljava/lang/Boolean;Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;ZZLjava/lang/String;)Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "equals", "other", "", "hashCode", "toString", "Companion", "Builder", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationSendMessageConfig implements Serializable {
    public static final b Companion = null;
    private final String actionBarCreationId;
    private final String actionBarCreationType;
    private final Map<String, String> actionBarInstructionMap;
    private final Integer actionInstruction;
    private final AttachmentInfo attachmentInfo;
    private final Map<String, String> bizExtMap;
    private final String botId;
    private final ChatPageContext chatPageContext;
    private final boolean clearInputContent;
    private final String content;
    private final e conversation;
    private final String creationSendTraceId;
    private final CustomMultiAttachmentInfo customMultiAttachmentInfo;
    private final String cvsId;
    private final String enterMethod;
    private final Boolean hasImagePreprocessed;
    private final u hitPointData;
    private final ImageEditDataWithMask imageEditDataWithMask;
    private final boolean isReEdit;
    private final String localInterceptInfo;
    private final boolean localIntercepted;
    private final String lyricCreateType;
    private final Map<String, String> messageExtMap;
    private final String previousPage;
    private final String scene;
    private final Map<String, String> sendTrackExtMap;
    private final String txtScene;

    public static final class a {
        public CreationSendMessageConfig a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r16 = 0 == true ? 1 : 0;
            this.a = new CreationSendMessageConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r16, null, null, null, null, null, false, null, null, false, false, null, 134217727, null);
        }

        public final void a(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r32, null, false, null, null, false, false, null, 133693439, null);
        }

        public final void b(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r32, false, null, null, false, false, null, 133169151, null);
        }

        public final void c(Map r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217215, null);
        }

        public final void d(Integer r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217471, null);
        }

        public final void e(AttachmentInfo r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134216703, null);
        }

        public final void f(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217725, null);
        }

        public final void g(ChatPageContext r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, r32, false, false, null, 125829119, null);
        }

        public final void h(boolean r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, r32, null, 100663295, null);
        }

        public final void i(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217719, null);
        }

        public final void j(e r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217723, null);
        }

        public final void k(CustomMultiAttachmentInfo r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134215679, null);
        }

        public final void l(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217726, null);
        }

        public final void m(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217663, null);
        }

        public final void n(u r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, false, null, null, false, false, null, 134201343, null);
        }

        public final void o(String r32) {
            CreationSendMessageConfig r1 = this.a;
            if (r32 != null) goto L5;
            String r24 = "";
        L6:
            this.a = CreationSendMessageConfig.copy$default(r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, r24, null, false, false, null, 130023423, null);
            return;
        L5:
            r24 = r32;
            goto L6
        }

        public final void p(boolean r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r32, null, null, false, false, null, 132120575, null);
        }

        public final void q(Map r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, false, null, null, false, false, null, 134184959, null);
        }

        public final void r(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217599, null);
        }

        public final void s(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217711, null);
        }

        public final void t(Map r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r32, null, null, null, false, null, null, false, false, null, 134086655, null);
        }

        public final void u(String r32) {
            this.a = CreationSendMessageConfig.copy$default(this.a, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217695, null);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public CreationSendMessageConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134217727, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationSendMessageConfig copy$default(CreationSendMessageConfig r17, String r18, String r19, e r20, String r21, String r22, String r23, String r24, String r25, Integer r26, Map r27, AttachmentInfo r28, CustomMultiAttachmentInfo r29, ImageEditDataWithMask r30, Boolean r31, u r32, Map r33, Map r34, Map r35, String r36, String r37, String r38, boolean r39, String r40, ChatPageContext r41, boolean r42, boolean r43, String r44, int r45, Object r46) {
        if ((r45 & 1) == 0) goto L5;
        String r2 = r17.cvsId;
    L7:
        if ((r45 & 2) == 0) goto L9;
        String r3 = r17.botId;
    L11:
        if ((r45 & 4) == 0) goto L13;
        e r4 = r17.conversation;
    L15:
        if ((r45 & 8) == 0) goto L17;
        String r5 = r17.content;
    L19:
        if ((r45 & 16) == 0) goto L21;
        String r6 = r17.scene;
    L23:
        if ((r45 & 32) == 0) goto L25;
        String r7 = r17.txtScene;
    L27:
        if ((r45 & 64) == 0) goto L29;
        String r8 = r17.enterMethod;
    L31:
        if ((r45 & 128) == 0) goto L33;
        String r9 = r17.previousPage;
    L35:
        if ((r45 & 256) == 0) goto L37;
        Integer r10 = r17.actionInstruction;
    L39:
        if ((r45 & 512) == 0) goto L41;
        Map r11 = r17.actionBarInstructionMap;
    L43:
        if ((r45 & 1024) == 0) goto L45;
        AttachmentInfo r12 = r17.attachmentInfo;
    L47:
        if ((r45 & 2048) == 0) goto L49;
        CustomMultiAttachmentInfo r13 = r17.customMultiAttachmentInfo;
    L51:
        if ((r45 & 4096) == 0) goto L53;
        ImageEditDataWithMask r14 = r17.imageEditDataWithMask;
    L55:
        if ((r45 & 8192) == 0) goto L57;
        Boolean r15 = r17.hasImagePreprocessed;
    L58:
        Boolean r310 = r15;
        if ((r45 & 16384) == 0) goto L61;
        u r16 = r17.hitPointData;
    L62:
        u r311 = r16;
        if ((r45 & 32768) == 0) goto L65;
        Map r110 = r17.messageExtMap;
    L66:
        Map r312 = r110;
        if ((r45 & 65536) == 0) goto L69;
        Map r111 = r17.bizExtMap;
    L70:
        Map r313 = r111;
        if ((r45 & 131072) == 0) goto L73;
        Map r112 = r17.sendTrackExtMap;
    L74:
        Map r314 = r112;
        if ((r45 & 262144) == 0) goto L77;
        String r113 = r17.creationSendTraceId;
    L78:
        String r315 = r113;
        if ((r45 & 524288) == 0) goto L81;
        String r114 = r17.actionBarCreationId;
    L82:
        String r316 = r114;
        if ((r45 & 1048576) == 0) goto L85;
        String r115 = r17.actionBarCreationType;
    L86:
        String r317 = r115;
        if ((r45 & 2097152) == 0) goto L89;
        boolean r116 = r17.localIntercepted;
    L90:
        boolean r318 = r116;
        if ((r45 & 4194304) == 0) goto L93;
        String r117 = r17.localInterceptInfo;
    L94:
        String r47 = r117;
        if ((r45 & 8388608) == 0) goto L97;
        ChatPageContext r118 = r17.chatPageContext;
    L98:
        ChatPageContext r48 = r118;
        if ((r45 & 16777216) == 0) goto L101;
        boolean r119 = r17.isReEdit;
    L102:
        boolean r49 = r119;
        if ((r45 & 33554432) == 0) goto L105;
        boolean r120 = r17.clearInputContent;
    L107:
        if ((r45 & 67108864) == 0) goto L109;
        String r1 = r17.lyricCreateType;
    L111:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r47, r48, r49, r120, r1);
    L109:
        r1 = r44;
        goto L111
    L105:
        r120 = r43;
        goto L107
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
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
        return this.cvsId;
    }

    public final Map<String, String> component10() {
        return this.actionBarInstructionMap;
    }

    public final AttachmentInfo component11() {
        return this.attachmentInfo;
    }

    public final CustomMultiAttachmentInfo component12() {
        return this.customMultiAttachmentInfo;
    }

    public final ImageEditDataWithMask component13() {
        return this.imageEditDataWithMask;
    }

    public final Boolean component14() {
        return this.hasImagePreprocessed;
    }

    public final u component15() {
        return this.hitPointData;
    }

    public final Map<String, String> component16() {
        return this.messageExtMap;
    }

    public final Map<String, String> component17() {
        return this.bizExtMap;
    }

    public final Map<String, String> component18() {
        return this.sendTrackExtMap;
    }

    public final String component19() {
        return this.creationSendTraceId;
    }

    public final String component2() {
        return this.botId;
    }

    public final String component20() {
        return this.actionBarCreationId;
    }

    public final String component21() {
        return this.actionBarCreationType;
    }

    public final boolean component22() {
        return this.localIntercepted;
    }

    public final String component23() {
        return this.localInterceptInfo;
    }

    public final ChatPageContext component24() {
        return this.chatPageContext;
    }

    public final boolean component25() {
        return this.isReEdit;
    }

    public final boolean component26() {
        return this.clearInputContent;
    }

    public final String component27() {
        return this.lyricCreateType;
    }

    public final e component3() {
        return this.conversation;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.scene;
    }

    public final String component6() {
        return this.txtScene;
    }

    public final String component7() {
        return this.enterMethod;
    }

    public final String component8() {
        return this.previousPage;
    }

    public final Integer component9() {
        return this.actionInstruction;
    }

    public final CreationSendMessageConfig copy(String r30, String r31, e r32, String r33, String r34, String r35, String r36, String r37, Integer r38, Map<String, String> r39, AttachmentInfo r40, CustomMultiAttachmentInfo r41, ImageEditDataWithMask r42, Boolean r43, u r44, Map<String, String> r45, Map<String, String> r46, Map<String, String> r47, String r48, String r49, String r50, boolean r51, String r52, ChatPageContext r53, boolean r54, boolean r55, String r56) {
        Intrinsics.checkNotNullParameter(r52, "localInterceptInfo");
        return new CreationSendMessageConfig(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationSendMessageConfig) == true) goto L8;
        return false;
    L8:
        CreationSendMessageConfig r6 = (CreationSendMessageConfig) r5;
        if (Intrinsics.areEqual(this.cvsId, r6.cvsId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversation, r6.conversation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.txtScene, r6.txtScene) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.actionInstruction, r6.actionInstruction) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actionBarInstructionMap, r6.actionBarInstructionMap) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.attachmentInfo, r6.attachmentInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.customMultiAttachmentInfo, r6.customMultiAttachmentInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.imageEditDataWithMask, r6.imageEditDataWithMask) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.hasImagePreprocessed, r6.hasImagePreprocessed) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.hitPointData, r6.hitPointData) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageExtMap, r6.messageExtMap) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bizExtMap, r6.bizExtMap) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.sendTrackExtMap, r6.sendTrackExtMap) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.creationSendTraceId, r6.creationSendTraceId) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.actionBarCreationId, r6.actionBarCreationId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.actionBarCreationType, r6.actionBarCreationType) == true) goto L72;
        return false;
    L72:
        if (this.localIntercepted == r6.localIntercepted) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.localInterceptInfo, r6.localInterceptInfo) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.chatPageContext, r6.chatPageContext) == true) goto L81;
        return false;
    L81:
        if (this.isReEdit == r6.isReEdit) goto L84;
        return false;
    L84:
        if (this.clearInputContent == r6.clearInputContent) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.lyricCreateType, r6.lyricCreateType) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public int hashCode() {
        String r0 = this.cvsId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.botId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        e r7 = this.conversation;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.content;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.scene;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.txtScene;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.enterMethod;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.previousPage;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.actionInstruction;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, String> r28 = this.actionBarInstructionMap;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        AttachmentInfo r31 = this.attachmentInfo;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        CustomMultiAttachmentInfo r34 = this.customMultiAttachmentInfo;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        ImageEditDataWithMask r37 = this.imageEditDataWithMask;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.hasImagePreprocessed;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        u r43 = this.hitPointData;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Map<String, String> r46 = this.messageExtMap;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Map<String, String> r49 = this.bizExtMap;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Map<String, String> r52 = this.sendTrackExtMap;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.creationSendTraceId;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.actionBarCreationId;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.actionBarCreationType;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        int r64 = 1231;
        if (this.localIntercepted == false) goto L89;
        int r65 = 1231;
    L90:
        int r66 = (((r63 + r65) * 31) + this.localInterceptInfo.hashCode()) * 31;
        ChatPageContext r67 = this.chatPageContext;
        if (r67 != null) goto L93;
        int r68 = 0;
    L94:
        int r69 = (r66 + r68) * 31;
        if (this.isReEdit == false) goto L97;
        int r70 = 1231;
    L98:
        int r71 = (r69 + r70) * 31;
        if (this.clearInputContent == true) goto L102;
        r64 = 1237;
    L102:
        int r72 = (r71 + r64) * 31;
        String r73 = this.lyricCreateType;
        if (r73 == null) goto L107;
        r1 = r73.hashCode();
    L107:
        return r72 + r1;
    L97:
        r70 = 1237;
        goto L98
    L93:
        r68 = r67.hashCode();
        goto L94
    L89:
        r65 = 1237;
        goto L90
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
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

    public String toString() {
        return "CreationSendMessageConfig(cvsId=" + this.cvsId + ", botId=" + this.botId + ", conversation=" + this.conversation + ", content=" + this.content + ", scene=" + this.scene + ", txtScene=" + this.txtScene + ", enterMethod=" + this.enterMethod + ", previousPage=" + this.previousPage + ", actionInstruction=" + this.actionInstruction + ", actionBarInstructionMap=" + this.actionBarInstructionMap + ", attachmentInfo=" + this.attachmentInfo + ", customMultiAttachmentInfo=" + this.customMultiAttachmentInfo + ", imageEditDataWithMask=" + this.imageEditDataWithMask + ", hasImagePreprocessed=" + this.hasImagePreprocessed + ", hitPointData=" + this.hitPointData + ", messageExtMap=" + this.messageExtMap + ", bizExtMap=" + this.bizExtMap + ", sendTrackExtMap=" + this.sendTrackExtMap + ", creationSendTraceId=" + this.creationSendTraceId + ", actionBarCreationId=" + this.actionBarCreationId + ", actionBarCreationType=" + this.actionBarCreationType + ", localIntercepted=" + this.localIntercepted + ", localInterceptInfo=" + this.localInterceptInfo + ", chatPageContext=" + this.chatPageContext + ", isReEdit=" + this.isReEdit + ", clearInputContent=" + this.clearInputContent + ", lyricCreateType=" + this.lyricCreateType + ')';
    }

    public final String getActionBarCreationId() {
        return this.actionBarCreationId;
    }

    public final String getActionBarCreationType() {
        return this.actionBarCreationType;
    }

    public final Map<String, String> getActionBarInstructionMap() {
        return this.actionBarInstructionMap;
    }

    public final Integer getActionInstruction() {
        return this.actionInstruction;
    }

    public final AttachmentInfo getAttachmentInfo() {
        return this.attachmentInfo;
    }

    public final Map<String, String> getBizExtMap() {
        return this.bizExtMap;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final ChatPageContext getChatPageContext() {
        return this.chatPageContext;
    }

    public final boolean getClearInputContent() {
        return this.clearInputContent;
    }

    public final String getContent() {
        return this.content;
    }

    public final e getConversation() {
        return this.conversation;
    }

    public final String getCreationSendTraceId() {
        return this.creationSendTraceId;
    }

    public final CustomMultiAttachmentInfo getCustomMultiAttachmentInfo() {
        return this.customMultiAttachmentInfo;
    }

    public final String getCvsId() {
        return this.cvsId;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Boolean getHasImagePreprocessed() {
        return this.hasImagePreprocessed;
    }

    public final u getHitPointData() {
        return this.hitPointData;
    }

    public final ImageEditDataWithMask getImageEditDataWithMask() {
        return this.imageEditDataWithMask;
    }

    public final String getLocalInterceptInfo() {
        return this.localInterceptInfo;
    }

    public final boolean getLocalIntercepted() {
        return this.localIntercepted;
    }

    public final String getLyricCreateType() {
        return this.lyricCreateType;
    }

    public final Map<String, String> getMessageExtMap() {
        return this.messageExtMap;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Map<String, String> getSendTrackExtMap() {
        return this.sendTrackExtMap;
    }

    public final String getTxtScene() {
        return this.txtScene;
    }

    public final boolean isReEdit() {
        return this.isReEdit;
    }

    public CreationSendMessageConfig(String r4, String r5, e r6, String r7, String r8, String r9, String r10, String r11, Integer r12, Map<String, String> r13, AttachmentInfo r14, CustomMultiAttachmentInfo r15, ImageEditDataWithMask r16, Boolean r17, u r18, Map<String, String> r19, Map<String, String> r20, Map<String, String> r21, String r22, String r23, String r24, boolean r25, String r26, ChatPageContext r27, boolean r28, boolean r29, String r30) {
        Intrinsics.checkNotNullParameter(r26, "localInterceptInfo");
        this.cvsId = r4;
        this.botId = r5;
        this.conversation = r6;
        this.content = r7;
        this.scene = r8;
        this.txtScene = r9;
        this.enterMethod = r10;
        this.previousPage = r11;
        this.actionInstruction = r12;
        this.actionBarInstructionMap = r13;
        this.attachmentInfo = r14;
        this.customMultiAttachmentInfo = r15;
        this.imageEditDataWithMask = r16;
        this.hasImagePreprocessed = r17;
        this.hitPointData = r18;
        this.messageExtMap = r19;
        this.bizExtMap = r20;
        this.sendTrackExtMap = r21;
        this.creationSendTraceId = r22;
        this.actionBarCreationId = r23;
        this.actionBarCreationType = r24;
        this.localIntercepted = r25;
        this.localInterceptInfo = r26;
        this.chatPageContext = r27;
        this.isReEdit = r28;
        this.clearInputContent = r29;
        this.lyricCreateType = r30;
    }

    public /* synthetic */ CreationSendMessageConfig(String r29, String r30, e r31, String r32, String r33, String r34, String r35, String r36, Integer r37, Map r38, AttachmentInfo r39, CustomMultiAttachmentInfo r40, ImageEditDataWithMask r41, Boolean r42, u r43, Map r44, Map r45, Map r46, String r47, String r48, String r49, boolean r50, String r51, ChatPageContext r52, boolean r53, boolean r54, String r55, int r56, DefaultConstructorMarker r57) {
        if ((r56 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r56 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r56 & 4) == 0) goto L13;
        e r4 = null;
    L15:
        if ((r56 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r56 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r56 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r56 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r56 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r56 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r56 & 512) == 0) goto L41;
        Map r11 = null;
    L43:
        if ((r56 & 1024) == 0) goto L45;
        AttachmentInfo r12 = null;
    L47:
        if ((r56 & 2048) == 0) goto L49;
        CustomMultiAttachmentInfo r13 = null;
    L51:
        if ((r56 & 4096) == 0) goto L53;
        ImageEditDataWithMask r14 = null;
    L55:
        if ((r56 & 8192) == 0) goto L57;
        Boolean r15 = null;
    L59:
        if ((r56 & 16384) == 0) goto L61;
        u r2 = null;
    L63:
        if ((r56 & 32768) == 0) goto L65;
        Map r16 = null;
    L67:
        if ((r56 & 65536) == 0) goto L69;
        Map r17 = null;
    L71:
        if ((r56 & 131072) == 0) goto L73;
        Map r18 = null;
    L75:
        if ((r56 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r56 & 524288) == 0) goto L81;
        String r20 = null;
    L83:
        if ((r56 & 1048576) == 0) goto L85;
        String r21 = null;
    L86:
        boolean r23 = false;
        if ((r56 & 2097152) == 0) goto L89;
        boolean r22 = false;
    L91:
        if ((r56 & 4194304) == 0) goto L93;
        String r24 = "";
    L95:
        if ((r56 & 8388608) == 0) goto L97;
        ChatPageContext r25 = null;
    L99:
        if ((r56 & 16777216) != 0) goto L103;
        r23 = r53;
    L103:
        if ((r56 & 33554432) == 0) goto L105;
        boolean r26 = true;
    L107:
        if ((r56 & 67108864) == 0) goto L109;
        String r0 = null;
    L110:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r24, r25, r23, r26, r0);
        return;
    L109:
        r0 = r55;
        goto L110
    L105:
        r26 = r54;
        goto L107
    L97:
        r25 = r52;
        goto L99
    L93:
        r24 = r51;
        goto L95
    L89:
        r22 = r50;
        goto L91
    L85:
        r21 = r49;
        goto L86
    L81:
        r20 = r48;
        goto L83
    L77:
        r19 = r47;
        goto L79
    L73:
        r18 = r46;
        goto L75
    L69:
        r17 = r45;
        goto L71
    L65:
        r16 = r44;
        goto L67
    L61:
        r2 = r43;
        goto L63
    L57:
        r15 = r42;
        goto L59
    L53:
        r14 = r41;
        goto L55
    L49:
        r13 = r40;
        goto L51
    L45:
        r12 = r39;
        goto L47
    L41:
        r11 = r38;
        goto L43
    L37:
        r10 = r37;
        goto L39
    L33:
        r9 = r36;
        goto L35
    L29:
        r8 = r35;
        goto L31
    L25:
        r7 = r34;
        goto L27
    L21:
        r6 = r33;
        goto L23
    L17:
        r5 = r32;
        goto L19
    L13:
        r4 = r31;
        goto L15
    L9:
        r3 = r30;
        goto L11
    L5:
        r1 = r29;
        goto L7
    }
}
