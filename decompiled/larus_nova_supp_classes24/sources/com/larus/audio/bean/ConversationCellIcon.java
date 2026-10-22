package com.larus.audio.bean;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/audio/bean/ConversationCellIcon;", "Ljava/io/Serializable;", "enableBotId", "", "enabledInSubConversation", "", "iconUri", "iconUrl", "schema", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnableBotId", "()Ljava/lang/String;", "getEnabledInSubConversation", "()Z", "getIconUri", "getIconUrl", "getSchema", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ConversationCellIcon implements Serializable {

    @SerializedName("enable_bot_id")
    private final String enableBotId;

    @SerializedName("enable_in_sub_conversation")
    private final boolean enabledInSubConversation;

    @SerializedName("icon_uri")
    private final String iconUri;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("schema")
    private final String schema;

    public ConversationCellIcon() {
        this(null, false, null, null, null, 31, null);
    }

    public static /* synthetic */ ConversationCellIcon copy$default(ConversationCellIcon r3, String r4, boolean r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableBotId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enabledInSubConversation;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.iconUri;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.iconUrl;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.schema;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.enableBotId;
    }

    public final boolean component2() {
        return this.enabledInSubConversation;
    }

    public final String component3() {
        return this.iconUri;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final String component5() {
        return this.schema;
    }

    public final ConversationCellIcon copy(String r8, boolean r9, String r10, String r11, String r12) {
        return new ConversationCellIcon(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ConversationCellIcon) == true) goto L8;
        return false;
    L8:
        ConversationCellIcon r6 = (ConversationCellIcon) r5;
        if (Intrinsics.areEqual(this.enableBotId, r6.enableBotId) == true) goto L12;
        return false;
    L12:
        if (this.enabledInSubConversation == r6.enabledInSubConversation) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUri, r6.iconUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.enableBotId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.enabledInSubConversation == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.iconUri;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        String r9 = this.iconUrl;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.schema;
        if (r12 == null) goto L23;
        r1 = r12.hashCode();
    L23:
        return r11 + r1;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationCellIcon(enableBotId=" + this.enableBotId + ", enabledInSubConversation=" + this.enabledInSubConversation + ", iconUri=" + this.iconUri + ", iconUrl=" + this.iconUrl + ", schema=" + this.schema + ')';
    }

    public final String getEnableBotId() {
        return this.enableBotId;
    }

    public final boolean getEnabledInSubConversation() {
        return this.enabledInSubConversation;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getSchema() {
        return this.schema;
    }

    public ConversationCellIcon(String r1, boolean r2, String r3, String r4, String r5) {
        this.enableBotId = r1;
        this.enabledInSubConversation = r2;
        this.iconUri = r3;
        this.iconUrl = r4;
        this.schema = r5;
    }

    public /* synthetic */ ConversationCellIcon(String r5, boolean r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = "";
    L7:
        if ((r10 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = "";
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = "";
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
