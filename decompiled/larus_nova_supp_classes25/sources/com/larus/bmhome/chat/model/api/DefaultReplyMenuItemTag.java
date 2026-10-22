package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "", "type", "", ChatDraftItem.TYPE_TEXT, "", "icon", "Lcom/larus/bmhome/actionbar/model/Icon;", "darkModeIcon", "tagExpireTime", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Ljava/lang/Long;)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "()Ljava/lang/String;", "getIcon", "()Lcom/larus/bmhome/actionbar/model/Icon;", "getDarkModeIcon", "getTagExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Ljava/lang/Long;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuItemTag;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DefaultReplyMenuItemTag {

    @SerializedName("dark_mode_icon")
    private final g1 darkModeIcon;

    @SerializedName("icon")
    private final g1 icon;

    @SerializedName("tag_expire_time")
    private final Long tagExpireTime;

    @SerializedName(ChatDraftItem.TYPE_TEXT)
    private final String text;

    @SerializedName("type")
    private final Integer type;

    public DefaultReplyMenuItemTag() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DefaultReplyMenuItemTag copy$default(DefaultReplyMenuItemTag r3, Integer r4, String r5, g1 r6, g1 r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.text;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.icon;
    L11:
        g1 r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.darkModeIcon;
    L14:
        g1 r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.tagExpireTime;
    L17:
        Integer r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Integer component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final g1 component3() {
        return this.icon;
    }

    public final g1 component4() {
        return this.darkModeIcon;
    }

    public final Long component5() {
        return this.tagExpireTime;
    }

    public final DefaultReplyMenuItemTag copy(Integer r8, String r9, g1 r10, g1 r11, Long r12) {
        return new DefaultReplyMenuItemTag(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultReplyMenuItemTag) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuItemTag r6 = (DefaultReplyMenuItemTag) r5;
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkModeIcon, r6.darkModeIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tagExpireTime, r6.tagExpireTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        g1 r7 = this.icon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        g1 r10 = this.darkModeIcon;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.tagExpireTime;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "DefaultReplyMenuItemTag(type=" + this.type + ", text=" + this.text + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", tagExpireTime=" + this.tagExpireTime + ')';
    }

    public final g1 getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final g1 getIcon() {
        return this.icon;
    }

    public final Long getTagExpireTime() {
        return this.tagExpireTime;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getType() {
        return this.type;
    }

    public DefaultReplyMenuItemTag(Integer r1, String r2, g1 r3, g1 r4, Long r5) {
        this.type = r1;
        this.text = r2;
        this.icon = r3;
        this.darkModeIcon = r4;
        this.tagExpireTime = r5;
    }

    public /* synthetic */ DefaultReplyMenuItemTag(Integer r5, String r6, g1 r7, g1 r8, Long r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        Integer r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        g1 r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        g1 r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Long r13 = null;
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
