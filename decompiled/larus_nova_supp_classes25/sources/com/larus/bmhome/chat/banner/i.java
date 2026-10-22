package com.larus.bmhome.chat.banner;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import di8.f0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jn\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001a¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerItem;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuItemPayload;", "itemType", "", "icon", "Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIcon;", "title", "Lcom/larus/bmhome/chat/banner/TextConfig;", "rightText", "rightIcon", "jumpUrl", "", "tracking", "extra", "<init>", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIcon;Lcom/larus/bmhome/chat/banner/TextConfig;Lcom/larus/bmhome/chat/banner/TextConfig;Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIcon;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getItemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIcon;", "getTitle", "()Lcom/larus/bmhome/chat/banner/TextConfig;", "getRightText", "getRightIcon", "getJumpUrl", "()Ljava/lang/String;", "getTracking", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIcon;Lcom/larus/bmhome/chat/banner/TextConfig;Lcom/larus/bmhome/chat/banner/TextConfig;Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIcon;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerItem;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class i implements f0 {

    @SerializedName("extra")
    private final String extra;

    @SerializedName("icon")
    private final f icon;

    @SerializedName("item_type")
    private final Integer itemType;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("right_icon")
    private final f rightIcon;

    @SerializedName("right_text")
    private final m rightText;

    @SerializedName("title")
    private final m title;

    @SerializedName("tracking")
    private final String tracking;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.itemType, r6.itemType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rightText, r6.rightText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rightIcon, r6.rightIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.jumpUrl, r6.jumpUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tracking, r6.tracking) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.itemType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        f r4 = this.icon;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        m r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        m r10 = this.rightText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        f r13 = this.rightIcon;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.jumpUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.tracking;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.extra;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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

    public final String toString() {
        return "ActiveSwitchBannerItem(itemType=" + this.itemType + ", icon=" + this.icon + ", title=" + this.title + ", rightText=" + this.rightText + ", rightIcon=" + this.rightIcon + ", jumpUrl=" + this.jumpUrl + ", tracking=" + this.tracking + ", extra=" + this.extra + ')';
    }

    public i() {
        this.itemType = null;
        this.icon = null;
        this.title = null;
        this.rightText = null;
        this.rightIcon = null;
        this.jumpUrl = null;
        this.tracking = null;
        this.extra = null;
    }

    public final f c() {
        return this.icon;
    }

    public final Integer d() {
        return this.itemType;
    }

    public final String e() {
        return this.jumpUrl;
    }

    public final f f() {
        return this.rightIcon;
    }

    public final m g() {
        return this.rightText;
    }

    public final m h() {
        return this.title;
    }

    public final String i() {
        return this.tracking;
    }
}
