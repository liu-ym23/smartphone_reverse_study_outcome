package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0013\u0010F\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\fHÆ\u0003J\u0013\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010J\u001a\u0004\u0018\u00010\u001bHÆ\u0003Jþ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f2\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u000fHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b6\u0010/R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;", "", "modeId", "", "name", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "activeIcon", "activeDarkModeIcon", "subTitleName", "tagList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "showTaskTools", "", "agentMode", "selectedName", "needLogin", "", "defaultModel", "Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;", "supportModels", "conversationModeList", "defaultConversationMode", "showReasoningEffort", "modelList", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;)V", "getModeId", "()Ljava/lang/String;", "getName", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getActiveIcon", "getActiveDarkModeIcon", "getSubTitleName", "getTagList", "()Ljava/util/List;", "getShowTaskTools", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAgentMode", "getSelectedName", "getNeedLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDefaultModel", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;", "getSupportModels", "getConversationModeList", "getDefaultConversationMode", "getShowReasoningEffort", "getModelList", "()Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplyModelItemIndex;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuConfig;)Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplySwitchMenuMode {

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

    @SerializedName("default_model")
    private final DefaultReplyModelItemIndex defaultModel;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("mode_id")
    private final String modeId;

    @SerializedName("model_list")
    private final DefaultReplySwitchMenuConfig modelList;

    @SerializedName("name")
    private final String name;

    @SerializedName("need_login")
    private final Boolean needLogin;

    @SerializedName("selected_name")
    private final String selectedName;

    @SerializedName("show_reasoning_effort")
    private final Boolean showReasoningEffort;

    @SerializedName("show_task_tools")
    private final Integer showTaskTools;

    @SerializedName("sub_title_name")
    private final String subTitleName;

    @SerializedName("support_models")
    private final List<DefaultReplyModelItemIndex> supportModels;

    @SerializedName("tag_list")
    private final List<DefaultReplyMenuItemTag> tagList;

    public DefaultReplySwitchMenuMode() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplySwitchMenuMode copy$default(DefaultReplySwitchMenuMode r17, String r18, String r19, DefaultReplyMenuItemIcon r20, DefaultReplyMenuItemIcon r21, DefaultReplyMenuItemIcon r22, DefaultReplyMenuItemIcon r23, String r24, List r25, Integer r26, Integer r27, String r28, Boolean r29, DefaultReplyModelItemIndex r30, List r31, List r32, String r33, Boolean r34, DefaultReplySwitchMenuConfig r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = r17.modeId;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r17.name;
    L11:
        if ((r36 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r4 = r17.icon;
    L15:
        if ((r36 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r5 = r17.darkModeIcon;
    L19:
        if ((r36 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r6 = r17.activeIcon;
    L23:
        if ((r36 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r7 = r17.activeDarkModeIcon;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r8 = r17.subTitleName;
    L31:
        if ((r36 & 128) == 0) goto L33;
        List r9 = r17.tagList;
    L35:
        if ((r36 & 256) == 0) goto L37;
        Integer r10 = r17.showTaskTools;
    L39:
        if ((r36 & 512) == 0) goto L41;
        Integer r11 = r17.agentMode;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r12 = r17.selectedName;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        Boolean r13 = r17.needLogin;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        DefaultReplyModelItemIndex r14 = r17.defaultModel;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        List r15 = r17.supportModels;
    L58:
        List r38 = r15;
        if ((r36 & 16384) == 0) goto L61;
        List r16 = r17.conversationModeList;
    L62:
        List r39 = r16;
        if ((r36 & 32768) == 0) goto L65;
        String r110 = r17.defaultConversationMode;
    L66:
        String r310 = r110;
        if ((r36 & 65536) == 0) goto L69;
        Boolean r111 = r17.showReasoningEffort;
    L71:
        if ((r36 & 131072) == 0) goto L73;
        DefaultReplySwitchMenuConfig r1 = r17.modelList;
    L75:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r111, r1);
    L73:
        r1 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L71
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
        return this.modeId;
    }

    public final Integer component10() {
        return this.agentMode;
    }

    public final String component11() {
        return this.selectedName;
    }

    public final Boolean component12() {
        return this.needLogin;
    }

    public final DefaultReplyModelItemIndex component13() {
        return this.defaultModel;
    }

    public final List<DefaultReplyModelItemIndex> component14() {
        return this.supportModels;
    }

    public final List<String> component15() {
        return this.conversationModeList;
    }

    public final String component16() {
        return this.defaultConversationMode;
    }

    public final Boolean component17() {
        return this.showReasoningEffort;
    }

    public final DefaultReplySwitchMenuConfig component18() {
        return this.modelList;
    }

    public final String component2() {
        return this.name;
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

    public final List<DefaultReplyMenuItemTag> component8() {
        return this.tagList;
    }

    public final Integer component9() {
        return this.showTaskTools;
    }

    public final DefaultReplySwitchMenuMode copy(String r21, String r22, DefaultReplyMenuItemIcon r23, DefaultReplyMenuItemIcon r24, DefaultReplyMenuItemIcon r25, DefaultReplyMenuItemIcon r26, String r27, List<DefaultReplyMenuItemTag> r28, Integer r29, Integer r30, String r31, Boolean r32, DefaultReplyModelItemIndex r33, List<DefaultReplyModelItemIndex> r34, List<String> r35, String r36, Boolean r37, DefaultReplySwitchMenuConfig r38) {
        return new DefaultReplySwitchMenuMode(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplySwitchMenuMode) == true) goto L8;
        return false;
    L8:
        DefaultReplySwitchMenuMode r6 = (DefaultReplySwitchMenuMode) r5;
        if (Intrinsics.areEqual(this.modeId, r6.modeId) == true) goto L12;
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
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showTaskTools, r6.showTaskTools) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.agentMode, r6.agentMode) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.selectedName, r6.selectedName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.needLogin, r6.needLogin) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.defaultModel, r6.defaultModel) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.supportModels, r6.supportModels) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.conversationModeList, r6.conversationModeList) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.defaultConversationMode, r6.defaultConversationMode) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.showReasoningEffort, r6.showReasoningEffort) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.modelList, r6.modelList) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r0 = this.modeId;
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
        List<DefaultReplyMenuItemTag> r22 = this.tagList;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.showTaskTools;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.agentMode;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.selectedName;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.needLogin;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        DefaultReplyModelItemIndex r37 = this.defaultModel;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<DefaultReplyModelItemIndex> r40 = this.supportModels;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        List<String> r43 = this.conversationModeList;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.defaultConversationMode;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.showReasoningEffort;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        DefaultReplySwitchMenuConfig r52 = this.modelList;
        if (r52 == null) goto L75;
        r1 = r52.hashCode();
    L75:
        return r51 + r1;
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
        return "DefaultReplySwitchMenuMode(modeId=" + this.modeId + ", name=" + this.name + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", activeIcon=" + this.activeIcon + ", activeDarkModeIcon=" + this.activeDarkModeIcon + ", subTitleName=" + this.subTitleName + ", tagList=" + this.tagList + ", showTaskTools=" + this.showTaskTools + ", agentMode=" + this.agentMode + ", selectedName=" + this.selectedName + ", needLogin=" + this.needLogin + ", defaultModel=" + this.defaultModel + ", supportModels=" + this.supportModels + ", conversationModeList=" + this.conversationModeList + ", defaultConversationMode=" + this.defaultConversationMode + ", showReasoningEffort=" + this.showReasoningEffort + ", modelList=" + this.modelList + ')';
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

    public final DefaultReplyModelItemIndex getDefaultModel() {
        return this.defaultModel;
    }

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final String getModeId() {
        return this.modeId;
    }

    public final DefaultReplySwitchMenuConfig getModelList() {
        return this.modelList;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNeedLogin() {
        return this.needLogin;
    }

    public final String getSelectedName() {
        return this.selectedName;
    }

    public final Boolean getShowReasoningEffort() {
        return this.showReasoningEffort;
    }

    public final Integer getShowTaskTools() {
        return this.showTaskTools;
    }

    public final String getSubTitleName() {
        return this.subTitleName;
    }

    public final List<DefaultReplyModelItemIndex> getSupportModels() {
        return this.supportModels;
    }

    public final List<DefaultReplyMenuItemTag> getTagList() {
        return this.tagList;
    }

    public DefaultReplySwitchMenuMode(String r3, String r4, DefaultReplyMenuItemIcon r5, DefaultReplyMenuItemIcon r6, DefaultReplyMenuItemIcon r7, DefaultReplyMenuItemIcon r8, String r9, List<DefaultReplyMenuItemTag> r10, Integer r11, Integer r12, String r13, Boolean r14, DefaultReplyModelItemIndex r15, List<DefaultReplyModelItemIndex> r16, List<String> r17, String r18, Boolean r19, DefaultReplySwitchMenuConfig r20) {
        this.modeId = r3;
        this.name = r4;
        this.icon = r5;
        this.darkModeIcon = r6;
        this.activeIcon = r7;
        this.activeDarkModeIcon = r8;
        this.subTitleName = r9;
        this.tagList = r10;
        this.showTaskTools = r11;
        this.agentMode = r12;
        this.selectedName = r13;
        this.needLogin = r14;
        this.defaultModel = r15;
        this.supportModels = r16;
        this.conversationModeList = r17;
        this.defaultConversationMode = r18;
        this.showReasoningEffort = r19;
        this.modelList = r20;
    }

    public /* synthetic */ DefaultReplySwitchMenuMode(String r20, String r21, DefaultReplyMenuItemIcon r22, DefaultReplyMenuItemIcon r23, DefaultReplyMenuItemIcon r24, DefaultReplyMenuItemIcon r25, String r26, List r27, Integer r28, Integer r29, String r30, Boolean r31, DefaultReplyModelItemIndex r32, List r33, List r34, String r35, Boolean r36, DefaultReplySwitchMenuConfig r37, int r38, DefaultConstructorMarker r39) {
        if ((r38 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        DefaultReplyMenuItemIcon r4 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r5 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r6 = null;
    L23:
        if ((r38 & 32) == 0) goto L25;
        DefaultReplyMenuItemIcon r7 = null;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r38 & 128) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r38 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r38 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        DefaultReplyModelItemIndex r14 = null;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        List r15 = null;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        List r2 = null;
    L63:
        if ((r38 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        Boolean r17 = null;
    L71:
        if ((r38 & 131072) == 0) goto L73;
        DefaultReplySwitchMenuConfig r0 = null;
    L74:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r0);
        return;
    L73:
        r0 = r37;
        goto L74
    L69:
        r17 = r36;
        goto L71
    L65:
        r16 = r35;
        goto L67
    L61:
        r2 = r34;
        goto L63
    L57:
        r15 = r33;
        goto L59
    L53:
        r14 = r32;
        goto L55
    L49:
        r13 = r31;
        goto L51
    L45:
        r12 = r30;
        goto L47
    L41:
        r11 = r29;
        goto L43
    L37:
        r10 = r28;
        goto L39
    L33:
        r9 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
