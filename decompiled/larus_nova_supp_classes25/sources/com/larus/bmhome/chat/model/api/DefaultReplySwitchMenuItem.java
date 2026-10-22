package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.z1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b=\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001a\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\b\u0010A\u001a\u00020\u0003H\u0007J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010,J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010.J\u0013\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010O\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001aHÆ\u0003J\u0013\u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0010HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u009c\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00152\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010,R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b3\u0010,R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R&\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006\\"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "", "itemId", "", "name", "", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "activeIcon", "activeDarkModeIcon", "subTitleName", "showTaskTools", "redDotVersion", "", "tagList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "selectedName", "agentMode", "needLogin", "", "subscribeConfig", "Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "modelItemKey", "modelExtraParams", "", "conversationModeList", "defaultConversationMode", "defaultMode", "reasoningEffortConfig", "Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getActiveIcon", "getActiveDarkModeIcon", "getSubTitleName", "getShowTaskTools", "()Ljava/lang/Integer;", "getRedDotVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTagList", "()Ljava/util/List;", "getSelectedName", "getAgentMode", "getNeedLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSubscribeConfig", "()Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "getModelItemKey", "getModelExtraParams", "()Ljava/util/Map;", "getConversationModeList", "getDefaultConversationMode", "getDefaultMode", "getReasoningEffortConfig", "()Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;", "getDeprecatedItemId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ReasoningEffortConfig;)Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplySwitchMenuItem {

    @SerializedName("active_dark_mode_icon")
    private final DefaultReplyMenuItemIcon activeDarkModeIcon;

    @SerializedName("active_icon")
    private final DefaultReplyMenuItemIcon activeIcon;

    @SerializedName("agent_mode")
    private final Integer agentMode;

    @SerializedName("conversation_mode_list")
    private final List<String> conversationModeList;

    @SerializedName("dark_mode_icon")
    private final DefaultReplyMenuItemIcon darkModeIcon;

    @SerializedName("default_conversation_mode")
    private final String defaultConversationMode;

    @SerializedName("default_mode")
    private final String defaultMode;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("item_id")
    private final Integer itemId;

    @SerializedName("model_extra_params")
    private final Map<String, String> modelExtraParams;

    @SerializedName("model_item_key")
    private final String modelItemKey;

    @SerializedName("name")
    private final String name;

    @SerializedName("need_login")
    private final Boolean needLogin;

    @SerializedName("reasoning_effort_config")
    private final u1 reasoningEffortConfig;

    @SerializedName("red_dot_version")
    private final Long redDotVersion;

    @SerializedName("selected_name")
    private final String selectedName;

    @SerializedName("show_task_tools")
    private final Integer showTaskTools;

    @SerializedName("sub_title_name")
    private final String subTitleName;

    @SerializedName("subscribe_config")
    private final z1 subscribeConfig;

    @SerializedName("tag_list")
    private final List<DefaultReplyMenuItemTag> tagList;

    public DefaultReplySwitchMenuItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    private final Integer component1() {
        return this.itemId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplySwitchMenuItem copy$default(DefaultReplySwitchMenuItem r17, Integer r18, String r19, DefaultReplyMenuItemIcon r20, DefaultReplyMenuItemIcon r21, DefaultReplyMenuItemIcon r22, DefaultReplyMenuItemIcon r23, String r24, Integer r25, Long r26, List r27, String r28, Integer r29, Boolean r30, z1 r31, String r32, Map r33, List r34, String r35, String r36, u1 r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        Integer r2 = r17.itemId;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = r17.name;
    L11:
        if ((r38 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r4 = r17.icon;
    L15:
        if ((r38 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r5 = r17.darkModeIcon;
    L19:
        if ((r38 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r6 = r17.activeIcon;
    L23:
        if ((r38 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r7 = r17.activeDarkModeIcon;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = r17.subTitleName;
    L31:
        if ((r38 & 128) == 0) goto L33;
        Integer r9 = r17.showTaskTools;
    L35:
        if ((r38 & 256) == 0) goto L37;
        Long r10 = r17.redDotVersion;
    L39:
        if ((r38 & 512) == 0) goto L41;
        List r11 = r17.tagList;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r12 = r17.selectedName;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        Integer r13 = r17.agentMode;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        Boolean r14 = r17.needLogin;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        z1 r15 = r17.subscribeConfig;
    L58:
        z1 r310 = r15;
        if ((r38 & 16384) == 0) goto L61;
        String r16 = r17.modelItemKey;
    L62:
        String r311 = r16;
        if ((r38 & 32768) == 0) goto L65;
        Map r110 = r17.modelExtraParams;
    L66:
        Map r312 = r110;
        if ((r38 & 65536) == 0) goto L69;
        List r111 = r17.conversationModeList;
    L70:
        List r313 = r111;
        if ((r38 & 131072) == 0) goto L73;
        String r112 = r17.defaultConversationMode;
    L74:
        String r314 = r112;
        if ((r38 & 262144) == 0) goto L77;
        String r113 = r17.defaultMode;
    L79:
        if ((r38 & 524288) == 0) goto L81;
        u1 r1 = r17.reasoningEffortConfig;
    L83:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r113, r1);
    L81:
        r1 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L79
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

    public final List<DefaultReplyMenuItemTag> component10() {
        return this.tagList;
    }

    public final String component11() {
        return this.selectedName;
    }

    public final Integer component12() {
        return this.agentMode;
    }

    public final Boolean component13() {
        return this.needLogin;
    }

    public final z1 component14() {
        return this.subscribeConfig;
    }

    public final String component15() {
        return this.modelItemKey;
    }

    public final Map<String, String> component16() {
        return this.modelExtraParams;
    }

    public final List<String> component17() {
        return this.conversationModeList;
    }

    public final String component18() {
        return this.defaultConversationMode;
    }

    public final String component19() {
        return this.defaultMode;
    }

    public final String component2() {
        return this.name;
    }

    public final u1 component20() {
        return this.reasoningEffortConfig;
    }

    public final DefaultReplyMenuItemIcon component3() {
        return this.icon;
    }

    public final DefaultReplyMenuItemIcon component4() {
        return this.darkModeIcon;
    }

    public final DefaultReplyMenuItemIcon component5() {
        return this.activeIcon;
    }

    public final DefaultReplyMenuItemIcon component6() {
        return this.activeDarkModeIcon;
    }

    public final String component7() {
        return this.subTitleName;
    }

    public final Integer component8() {
        return this.showTaskTools;
    }

    public final Long component9() {
        return this.redDotVersion;
    }

    public final DefaultReplySwitchMenuItem copy(Integer r23, String r24, DefaultReplyMenuItemIcon r25, DefaultReplyMenuItemIcon r26, DefaultReplyMenuItemIcon r27, DefaultReplyMenuItemIcon r28, String r29, Integer r30, Long r31, List<DefaultReplyMenuItemTag> r32, String r33, Integer r34, Boolean r35, z1 r36, String r37, Map<String, String> r38, List<String> r39, String r40, String r41, u1 r42) {
        return new DefaultReplySwitchMenuItem(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplySwitchMenuItem) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMenuItem r6 = (DefaultReplySwitchMenuItem) r5;
        if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkModeIcon, r6.darkModeIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.activeIcon, r6.activeIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.activeDarkModeIcon, r6.activeDarkModeIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subTitleName, r6.subTitleName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.showTaskTools, r6.showTaskTools) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.redDotVersion, r6.redDotVersion) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selectedName, r6.selectedName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.agentMode, r6.agentMode) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.needLogin, r6.needLogin) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.subscribeConfig, r6.subscribeConfig) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.modelItemKey, r6.modelItemKey) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.modelExtraParams, r6.modelExtraParams) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.conversationModeList, r6.conversationModeList) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.defaultConversationMode, r6.defaultConversationMode) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.defaultMode, r6.defaultMode) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.reasoningEffortConfig, r6.reasoningEffortConfig) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.itemId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        DefaultReplyMenuItemIcon r7 = this.icon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        DefaultReplyMenuItemIcon r10 = this.darkModeIcon;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        DefaultReplyMenuItemIcon r13 = this.activeIcon;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        DefaultReplyMenuItemIcon r16 = this.activeDarkModeIcon;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.subTitleName;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.showTaskTools;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.redDotVersion;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<DefaultReplyMenuItemTag> r28 = this.tagList;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.selectedName;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.agentMode;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.needLogin;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        z1 r40 = this.subscribeConfig;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.modelItemKey;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Map<String, String> r46 = this.modelExtraParams;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        List<String> r49 = this.conversationModeList;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.defaultConversationMode;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.defaultMode;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        u1 r58 = this.reasoningEffortConfig;
        if (r58 == null) goto L83;
        r1 = r58.hashCode();
    L83:
        return r57 + r1;
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
        return "DefaultReplySwitchMenuItem(itemId=" + this.itemId + ", name=" + this.name + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", activeIcon=" + this.activeIcon + ", activeDarkModeIcon=" + this.activeDarkModeIcon + ", subTitleName=" + this.subTitleName + ", showTaskTools=" + this.showTaskTools + ", redDotVersion=" + this.redDotVersion + ", tagList=" + this.tagList + ", selectedName=" + this.selectedName + ", agentMode=" + this.agentMode + ", needLogin=" + this.needLogin + ", subscribeConfig=" + this.subscribeConfig + ", modelItemKey=" + this.modelItemKey + ", modelExtraParams=" + this.modelExtraParams + ", conversationModeList=" + this.conversationModeList + ", defaultConversationMode=" + this.defaultConversationMode + ", defaultMode=" + this.defaultMode + ", reasoningEffortConfig=" + this.reasoningEffortConfig + ')';
    }

    @Deprecated(message = "use model_item_key instead")
    public final int getDeprecatedItemId() {
        Integer r0 = this.itemId;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final DefaultReplyMenuItemIcon getActiveDarkModeIcon() {
        return this.activeDarkModeIcon;
    }

    public final DefaultReplyMenuItemIcon getActiveIcon() {
        return this.activeIcon;
    }

    public final Integer getAgentMode() {
        return this.agentMode;
    }

    public final List<String> getConversationModeList() {
        return this.conversationModeList;
    }

    public final DefaultReplyMenuItemIcon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final String getDefaultConversationMode() {
        return this.defaultConversationMode;
    }

    public final String getDefaultMode() {
        return this.defaultMode;
    }

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final Map<String, String> getModelExtraParams() {
        return this.modelExtraParams;
    }

    public final String getModelItemKey() {
        return this.modelItemKey;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNeedLogin() {
        return this.needLogin;
    }

    public final u1 getReasoningEffortConfig() {
        return this.reasoningEffortConfig;
    }

    public final Long getRedDotVersion() {
        return this.redDotVersion;
    }

    public final String getSelectedName() {
        return this.selectedName;
    }

    public final Integer getShowTaskTools() {
        return this.showTaskTools;
    }

    public final String getSubTitleName() {
        return this.subTitleName;
    }

    public final z1 getSubscribeConfig() {
        return this.subscribeConfig;
    }

    public final List<DefaultReplyMenuItemTag> getTagList() {
        return this.tagList;
    }

    public DefaultReplySwitchMenuItem(Integer r3, String r4, DefaultReplyMenuItemIcon r5, DefaultReplyMenuItemIcon r6, DefaultReplyMenuItemIcon r7, DefaultReplyMenuItemIcon r8, String r9, Integer r10, Long r11, List<DefaultReplyMenuItemTag> r12, String r13, Integer r14, Boolean r15, z1 r16, String r17, Map<String, String> r18, List<String> r19, String r20, String r21, u1 r22) {
        this.itemId = r3;
        this.name = r4;
        this.icon = r5;
        this.darkModeIcon = r6;
        this.activeIcon = r7;
        this.activeDarkModeIcon = r8;
        this.subTitleName = r9;
        this.showTaskTools = r10;
        this.redDotVersion = r11;
        this.tagList = r12;
        this.selectedName = r13;
        this.agentMode = r14;
        this.needLogin = r15;
        this.subscribeConfig = r16;
        this.modelItemKey = r17;
        this.modelExtraParams = r18;
        this.conversationModeList = r19;
        this.defaultConversationMode = r20;
        this.defaultMode = r21;
        this.reasoningEffortConfig = r22;
    }

    public /* synthetic */ DefaultReplySwitchMenuItem(Integer r22, String r23, DefaultReplyMenuItemIcon r24, DefaultReplyMenuItemIcon r25, DefaultReplyMenuItemIcon r26, DefaultReplyMenuItemIcon r27, String r28, Integer r29, Long r30, List r31, String r32, Integer r33, Boolean r34, z1 r35, String r36, Map r37, List r38, String r39, String r40, u1 r41, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        Integer r1 = null;
    L6:
        String r4 = "";
        if ((r42 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r42 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r5 = null;
    L15:
        if ((r42 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r6 = null;
    L19:
        if ((r42 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r7 = null;
    L23:
        if ((r42 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r8 = null;
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r42 & 128) == 0) goto L33;
        Integer r10 = null;
    L35:
        if ((r42 & 256) == 0) goto L37;
        Long r11 = null;
    L39:
        if ((r42 & 512) == 0) goto L41;
        List r12 = null;
    L43:
        if ((r42 & 1024) != 0) goto L47;
        r4 = r32;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        Boolean r14 = null;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        z1 r15 = null;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        Map r16 = null;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        List r17 = null;
    L71:
        if ((r42 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r42 & 524288) == 0) goto L81;
        u1 r0 = null;
    L82:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r4, r13, r14, r15, r2, r16, r17, r18, r19, r0);
        return;
    L81:
        r0 = r41;
        goto L82
    L77:
        r19 = r40;
        goto L79
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r2 = r36;
        goto L63
    L57:
        r15 = r35;
        goto L59
    L53:
        r14 = r34;
        goto L55
    L49:
        r13 = r33;
        goto L51
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r5 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L6
    }
}
