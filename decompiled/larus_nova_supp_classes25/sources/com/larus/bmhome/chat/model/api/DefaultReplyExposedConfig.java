package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "", "maxExposedNum", "", "icon", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "darkModeIcon", ChatDraftItem.TYPE_TEXT, "", "<init>", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;)V", "getMaxExposedNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;", "getDarkModeIcon", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemIcon;Ljava/lang/String;)Lcom/larus/bmhome/chat/model/api/DefaultReplyExposedConfig;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplyExposedConfig {

    @SerializedName("dark_mode_icon")
    private final DefaultReplyMenuItemIcon darkModeIcon;

    @SerializedName("icon")
    private final DefaultReplyMenuItemIcon icon;

    @SerializedName("max_exposed_num")
    private final Integer maxExposedNum;

    @SerializedName(ChatDraftItem.TYPE_TEXT)
    private final String text;

    public DefaultReplyExposedConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DefaultReplyExposedConfig copy$default(DefaultReplyExposedConfig r0, Integer r1, DefaultReplyMenuItemIcon r2, DefaultReplyMenuItemIcon r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.maxExposedNum;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.icon;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.darkModeIcon;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.text;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.maxExposedNum;
    }

    public final DefaultReplyMenuItemIcon component2() {
        return this.icon;
    }

    public final DefaultReplyMenuItemIcon component3() {
        return this.darkModeIcon;
    }

    public final String component4() {
        return this.text;
    }

    public final DefaultReplyExposedConfig copy(Integer r2, DefaultReplyMenuItemIcon r3, DefaultReplyMenuItemIcon r4, String r5) {
        return new DefaultReplyExposedConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplyExposedConfig) == true) goto L8;
        return false;
    L8:
        DefaultReplyExposedConfig r6 = (DefaultReplyExposedConfig) r5;
        if (Intrinsics.areEqual(this.maxExposedNum, r6.maxExposedNum) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkModeIcon, r6.darkModeIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.maxExposedNum;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        DefaultReplyMenuItemIcon r4 = this.icon;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        DefaultReplyMenuItemIcon r7 = this.darkModeIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.text;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "DefaultReplyExposedConfig(maxExposedNum=" + this.maxExposedNum + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", text=" + this.text + ')';
    }

    public final DefaultReplyMenuItemIcon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final DefaultReplyMenuItemIcon getIcon() {
        return this.icon;
    }

    public final Integer getMaxExposedNum() {
        return this.maxExposedNum;
    }

    public final String getText() {
        return this.text;
    }

    public DefaultReplyExposedConfig(Integer r1, DefaultReplyMenuItemIcon r2, DefaultReplyMenuItemIcon r3, String r4) {
        this.maxExposedNum = r1;
        this.icon = r2;
        this.darkModeIcon = r3;
        this.text = r4;
    }

    public /* synthetic */ DefaultReplyExposedConfig(Integer r2, DefaultReplyMenuItemIcon r3, DefaultReplyMenuItemIcon r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
