package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.z1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¢\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItem;", "", "itemId", "", "name", "", "subTitleName", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", "tagList", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "selectedName", "subscribeConfig", "Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "modelItemKey", "conversationModeList", "defaultConversationMode", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/util/List;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSubTitleName", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getTagList", "()Ljava/util/List;", "getSelectedName", "getSubscribeConfig", "()Lcom/larus/bmhome/actionbar/model/SubscribeConfig;", "getConversationModeList", "getDefaultConversationMode", "getIdentity", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/util/List;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/SubscribeConfig;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItem;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplyMenuItem {

    @SerializedName("conversation_mode_list")
    private final List<String> conversationModeList;

    @SerializedName("dark_mode_icon")
    private final DefaultReplyMenuItemIcon darkModeIcon;

    @SerializedName("default_conversation_mode")
    private final String defaultConversationMode;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("item_id")
    private final Integer itemId;

    @SerializedName("model_item_key")
    private final String modelItemKey;

    @SerializedName("name")
    private final String name;

    @SerializedName("selected_name")
    private final String selectedName;

    @SerializedName("sub_title_name")
    private final String subTitleName;

    @SerializedName("subscribe_config")
    private final z1 subscribeConfig;

    @SerializedName("tag_list")
    private final List<DefaultReplyMenuItemTag> tagList;

    public DefaultReplyMenuItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    private final Integer component1() {
        return this.itemId;
    }

    private final String component9() {
        return this.modelItemKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuItem copy$default(DefaultReplyMenuItem r12, Integer r13, String r14, String r15, DefaultReplyMenuItemIcon r16, DefaultReplyMenuItemIcon r17, List r18, String r19, z1 r20, String r21, List r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        Integer r2 = r12.itemId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.name;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.subTitleName;
    L15:
        if ((r24 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r5 = r12.icon;
    L19:
        if ((r24 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r6 = r12.darkModeIcon;
    L23:
        if ((r24 & 32) == 0) goto L25;
        List r7 = r12.tagList;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.selectedName;
    L31:
        if ((r24 & 128) == 0) goto L33;
        z1 r9 = r12.subscribeConfig;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.modelItemKey;
    L39:
        if ((r24 & 512) == 0) goto L41;
        List r11 = r12.conversationModeList;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.defaultConversationMode;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final List<String> component10() {
        return this.conversationModeList;
    }

    public final String component11() {
        return this.defaultConversationMode;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.subTitleName;
    }

    public final DefaultReplyMenuItemIcon component4() {
        return this.icon;
    }

    public final DefaultReplyMenuItemIcon component5() {
        return this.darkModeIcon;
    }

    public final List<DefaultReplyMenuItemTag> component6() {
        return this.tagList;
    }

    public final String component7() {
        return this.selectedName;
    }

    public final z1 component8() {
        return this.subscribeConfig;
    }

    public final DefaultReplyMenuItem copy(Integer r14, String r15, String r16, DefaultReplyMenuItemIcon r17, DefaultReplyMenuItemIcon r18, List<DefaultReplyMenuItemTag> r19, String r20, z1 r21, String r22, List<String> r23, String r24) {
        return new DefaultReplyMenuItem(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplyMenuItem) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuItem r6 = (DefaultReplyMenuItem) r5;
        if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subTitleName, r6.subTitleName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkModeIcon, r6.darkModeIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.selectedName, r6.selectedName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.subscribeConfig, r6.subscribeConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.modelItemKey, r6.modelItemKey) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.conversationModeList, r6.conversationModeList) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.defaultConversationMode, r6.defaultConversationMode) == true) goto L41;
        return false;
    L41:
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
        String r7 = this.subTitleName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        DefaultReplyMenuItemIcon r10 = this.icon;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        DefaultReplyMenuItemIcon r13 = this.darkModeIcon;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<DefaultReplyMenuItemTag> r16 = this.tagList;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.selectedName;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        z1 r22 = this.subscribeConfig;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.modelItemKey;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.conversationModeList;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.defaultConversationMode;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
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
        return "DefaultReplyMenuItem(itemId=" + this.itemId + ", name=" + this.name + ", subTitleName=" + this.subTitleName + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", tagList=" + this.tagList + ", selectedName=" + this.selectedName + ", subscribeConfig=" + this.subscribeConfig + ", modelItemKey=" + this.modelItemKey + ", conversationModeList=" + this.conversationModeList + ", defaultConversationMode=" + this.defaultConversationMode + ')';
    }

    public final ModelItemIdentity getIdentity() {
        String r0 = this.modelItemKey;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        if (this.itemId != null) goto L15;
        return null;
    L15:
        return new ModelItemIdentity(this.modelItemKey, this.itemId);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
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

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSelectedName() {
        return this.selectedName;
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

    public DefaultReplyMenuItem(Integer r1, String r2, String r3, DefaultReplyMenuItemIcon r4, DefaultReplyMenuItemIcon r5, List<DefaultReplyMenuItemTag> r6, String r7, z1 r8, String r9, List<String> r10, String r11) {
        this.itemId = r1;
        this.name = r2;
        this.subTitleName = r3;
        this.icon = r4;
        this.darkModeIcon = r5;
        this.tagList = r6;
        this.selectedName = r7;
        this.subscribeConfig = r8;
        this.modelItemKey = r9;
        this.conversationModeList = r10;
        this.defaultConversationMode = r11;
    }

    public /* synthetic */ DefaultReplyMenuItem(Integer r13, String r14, String r15, DefaultReplyMenuItemIcon r16, DefaultReplyMenuItemIcon r17, List r18, String r19, z1 r20, String r21, List r22, String r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        Integer r1 = 0;
    L6:
        String r3 = "";
        if ((r24 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = "";
    L14:
        String r6 = null;
        if ((r24 & 8) == 0) goto L17;
        DefaultReplyMenuItemIcon r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        DefaultReplyMenuItemIcon r7 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        List r8 = null;
    L27:
        if ((r24 & 64) != 0) goto L31;
        r3 = r19;
    L31:
        if ((r24 & 128) == 0) goto L33;
        z1 r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        List r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r6 = r23;
    L46:
        this(r1, r2, r4, r5, r7, r8, r3, r9, r10, r11, r6);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L14
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L6
    }
}
