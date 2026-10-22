package com.ss.android.lark.create.groupchat.dto;

import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001PBu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010)J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÂ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003Jw\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001a\u0010-\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001a\u00100\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001a\u00103\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u001a\u00106\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u001c\u00108\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001c¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/create/groupchat/dto/GroupCreateInfo;", "Ljava/io/Serializable;", "isOpenChat", BuildConfig.FLAVOR, "mode", "Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;", "isPublicInner", IPortraitService.NAME, BuildConfig.FLAVOR, "description", "fromChatId", "showGroupTypeSelector", "isCreateTopicGroup", "isCrossTenant", "isCrossWithKa", "needBadge", "<init>", "(ZLcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZ)V", "()Z", "setOpenChat", "(Z)V", "getMode", "()Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;", "setMode", "(Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getFromChatId", "setFromChatId", "getShowGroupTypeSelector", "setShowGroupTypeSelector", "setCreateTopicGroup", "setCrossTenant", "setCrossWithKa", "getNeedBadge", "setNeedBadge", "onTypeChangeListener", "Lcom/ss/android/lark/create/groupchat/dto/GroupCreateInfo$OnTypeChangeListener;", "value", "isPublic", "setPublic", "enableCreateSecretGroup", "getEnableCreateSecretGroup", "setEnableCreateSecretGroup", "enableCreatePrivateModeChat", "getEnableCreatePrivateModeChat", "setEnableCreatePrivateModeChat", "hasMultiEntity", "getHasMultiEntity", "setHasMultiEntity", "isEnableChatPreview", "setEnableChatPreview", "linkedUrl", "getLinkedUrl", "setLinkedUrl", "setTypeChangeListener", BuildConfig.FLAVOR, "listener", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "OnTypeChangeListener", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupCreateInfo implements Serializable {
    private String description;
    private boolean enableCreatePrivateModeChat;
    private boolean enableCreateSecretGroup;
    private String fromChatId;
    private boolean hasMultiEntity;
    private boolean isCreateTopicGroup;
    private boolean isCrossTenant;
    private boolean isCrossWithKa;
    private boolean isEnableChatPreview;
    private boolean isOpenChat;
    private boolean isPublic;
    private boolean isPublicInner;
    private String linkedUrl;
    private CreateGroupMode mode;
    private String name;
    private boolean needBadge;
    private boolean showGroupTypeSelector;

    public interface a {
    }

    public GroupCreateInfo() {
        this(false, null, false, null, null, null, false, false, false, false, false, 2047, null);
    }

    public static /* synthetic */ GroupCreateInfo copy$default(GroupCreateInfo r12, boolean r13, CreateGroupMode r14, boolean r15, String r16, String r17, String r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        boolean r2 = r12.isOpenChat;
    L7:
        if ((r24 & 2) == 0) goto L9;
        CreateGroupMode r3 = r12.mode;
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r4 = r12.isPublicInner;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.name;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.description;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.fromChatId;
    L27:
        if ((r24 & 64) == 0) goto L29;
        boolean r8 = r12.showGroupTypeSelector;
    L31:
        if ((r24 & 128) == 0) goto L33;
        boolean r9 = r12.isCreateTopicGroup;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r10 = r12.isCrossTenant;
    L39:
        if ((r24 & 512) == 0) goto L41;
        boolean r11 = r12.isCrossWithKa;
    L43:
        if ((r24 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        boolean r1 = r12.needBadge;
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

    public final boolean component1() {
        return this.isOpenChat;
    }

    public final boolean component10() {
        return this.isCrossWithKa;
    }

    public final boolean component11() {
        return this.needBadge;
    }

    public final CreateGroupMode component2() {
        return this.mode;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.fromChatId;
    }

    public final boolean component7() {
        return this.showGroupTypeSelector;
    }

    public final boolean component8() {
        return this.isCreateTopicGroup;
    }

    public final boolean component9() {
        return this.isCrossTenant;
    }

    public final GroupCreateInfo copy(boolean r14, CreateGroupMode r15, boolean r16, String r17, String r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r15, "mode");
        Intrinsics.checkNotNullParameter(r17, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r18, "description");
        Intrinsics.checkNotNullParameter(r19, "fromChatId");
        return new GroupCreateInfo(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GroupCreateInfo) == true) goto L8;
        return false;
    L8:
        GroupCreateInfo r6 = (GroupCreateInfo) r5;
        if (this.isOpenChat == r6.isOpenChat) goto L12;
        return false;
    L12:
        if (this.mode == r6.mode) goto L15;
        return false;
    L15:
        if (this.isPublicInner == r6.isPublicInner) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fromChatId, r6.fromChatId) == true) goto L27;
        return false;
    L27:
        if (this.showGroupTypeSelector == r6.showGroupTypeSelector) goto L30;
        return false;
    L30:
        if (this.isCreateTopicGroup == r6.isCreateTopicGroup) goto L33;
        return false;
    L33:
        if (this.isCrossTenant == r6.isCrossTenant) goto L36;
        return false;
    L36:
        if (this.isCrossWithKa == r6.isCrossWithKa) goto L39;
        return false;
    L39:
        if (this.needBadge == r6.needBadge) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isOpenChat == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.mode.hashCode()) * 31;
        if (this.isPublicInner == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((((((r2 + r3) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.fromChatId.hashCode()) * 31;
        if (this.showGroupTypeSelector == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.isCreateTopicGroup == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.isCrossTenant == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.isCrossWithKa == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.needBadge == true) goto L31;
        r1 = 1237;
    L31:
        return r12 + r1;
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final void setTypeChangeListener(a r1) {
    }

    public String toString() {
        return "GroupCreateInfo(isOpenChat=" + this.isOpenChat + ", mode=" + this.mode + ", isPublicInner=" + this.isPublicInner + ", name=" + this.name + ", description=" + this.description + ", fromChatId=" + this.fromChatId + ", showGroupTypeSelector=" + this.showGroupTypeSelector + ", isCreateTopicGroup=" + this.isCreateTopicGroup + ", isCrossTenant=" + this.isCrossTenant + ", isCrossWithKa=" + this.isCrossWithKa + ", needBadge=" + this.needBadge + ')';
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getEnableCreatePrivateModeChat() {
        return this.enableCreatePrivateModeChat;
    }

    public final boolean getEnableCreateSecretGroup() {
        return this.enableCreateSecretGroup;
    }

    public final String getFromChatId() {
        return this.fromChatId;
    }

    public final boolean getHasMultiEntity() {
        return this.hasMultiEntity;
    }

    public final String getLinkedUrl() {
        return this.linkedUrl;
    }

    public final CreateGroupMode getMode() {
        return this.mode;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedBadge() {
        return this.needBadge;
    }

    public final boolean getShowGroupTypeSelector() {
        return this.showGroupTypeSelector;
    }

    public final boolean isCreateTopicGroup() {
        return this.isCreateTopicGroup;
    }

    public final boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public final boolean isCrossWithKa() {
        return this.isCrossWithKa;
    }

    public final boolean isEnableChatPreview() {
        return this.isEnableChatPreview;
    }

    public final boolean isOpenChat() {
        return this.isOpenChat;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final void setCreateTopicGroup(boolean r1) {
        this.isCreateTopicGroup = r1;
    }

    public final void setCrossTenant(boolean r1) {
        this.isCrossTenant = r1;
    }

    public final void setCrossWithKa(boolean r1) {
        this.isCrossWithKa = r1;
    }

    public final void setDescription(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.description = r2;
    }

    public final void setEnableChatPreview(boolean r1) {
        this.isEnableChatPreview = r1;
    }

    public final void setEnableCreatePrivateModeChat(boolean r1) {
        this.enableCreatePrivateModeChat = r1;
    }

    public final void setEnableCreateSecretGroup(boolean r1) {
        this.enableCreateSecretGroup = r1;
    }

    public final void setFromChatId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fromChatId = r2;
    }

    public final void setHasMultiEntity(boolean r1) {
        this.hasMultiEntity = r1;
    }

    public final void setLinkedUrl(String r1) {
        this.linkedUrl = r1;
    }

    public final void setMode(CreateGroupMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mode = r2;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNeedBadge(boolean r1) {
        this.needBadge = r1;
    }

    public final void setOpenChat(boolean r1) {
        this.isOpenChat = r1;
    }

    public final void setPublic(boolean r1) {
        this.isPublic = r1;
        this.isPublicInner = r1;
    }

    public final void setShowGroupTypeSelector(boolean r1) {
        this.showGroupTypeSelector = r1;
    }

    public GroupCreateInfo(boolean r2, CreateGroupMode r3, boolean r4, String r5, String r6, String r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        Intrinsics.checkNotNullParameter(r5, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r6, "description");
        Intrinsics.checkNotNullParameter(r7, "fromChatId");
        this.isOpenChat = r2;
        this.mode = r3;
        this.isPublicInner = r4;
        this.name = r5;
        this.description = r6;
        this.fromChatId = r7;
        this.showGroupTypeSelector = r8;
        this.isCreateTopicGroup = r9;
        this.isCrossTenant = r10;
        this.isCrossWithKa = r11;
        this.needBadge = r12;
        this.isPublic = r4;
        this.enableCreateSecretGroup = true;
    }

    public /* synthetic */ GroupCreateInfo(boolean r14, CreateGroupMode r15, boolean r16, String r17, String r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        boolean r2 = true;
        if ((r25 & 1) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r25 & 2) == 0) goto L9;
        CreateGroupMode r3 = CreateGroupMode.CONVERSATION_MODE;
    L10:
        boolean r5 = false;
        if ((r25 & 4) == 0) goto L13;
        boolean r4 = false;
    L14:
        int r6 = r25 & 8;
        String r7 = BuildConfig.FLAVOR;
        if (r6 == 0) goto L17;
        String r8 = BuildConfig.FLAVOR;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r9 = BuildConfig.FLAVOR;
    L23:
        if ((r25 & 32) != 0) goto L27;
        r7 = r19;
    L27:
        if ((r25 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r25 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r25 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r25 & 512) != 0) goto L43;
        r5 = r23;
    L43:
        if ((r25 & ChameleonContainerUtils.MAX_URL_LENGTH) != 0) goto L46;
        r2 = r24;
    L46:
        this(r1, r3, r4, r8, r9, r7, r10, r11, r12, r5, r2);
        return;
    L37:
        r12 = r22;
        goto L39
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L14
    L9:
        r3 = r15;
        goto L10
    L5:
        r1 = r14;
        goto L7
    }
}
