package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.bot.BgImage;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/platform/model/bot/BotMakerDataModel;", "", "nick_name", "", "role", "icon_url", "icon_uri", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImage;)V", "getNick_name", "()Ljava/lang/String;", "setNick_name", "(Ljava/lang/String;)V", "getRole", "setRole", "getIcon_url", "setIcon_url", "getIcon_uri", "setIcon_uri", "getBgImage", "()Lcom/larus/im/bean/bot/BgImage;", "setBgImage", "(Lcom/larus/im/bean/bot/BgImage;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BotMakerDataModel {

    @SerializedName("bg_image")
    private BgImage bgImage;

    @SerializedName("icon_uri")
    private String icon_uri;

    @SerializedName("icon_url")
    private String icon_url;

    @SerializedName("name")
    private String nick_name;

    @SerializedName("role")
    private String role;

    public BotMakerDataModel() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BotMakerDataModel copy$default(BotMakerDataModel r3, String r4, String r5, String r6, String r7, BgImage r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.nick_name;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.role;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.icon_url;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.icon_uri;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.bgImage;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.nick_name;
    }

    public final String component2() {
        return this.role;
    }

    public final String component3() {
        return this.icon_url;
    }

    public final String component4() {
        return this.icon_uri;
    }

    public final BgImage component5() {
        return this.bgImage;
    }

    public final BotMakerDataModel copy(String r8, String r9, String r10, String r11, BgImage r12) {
        return new BotMakerDataModel(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotMakerDataModel) == true) goto L8;
        return false;
    L8:
        BotMakerDataModel r6 = (BotMakerDataModel) r5;
        if (Intrinsics.areEqual(this.nick_name, r6.nick_name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.role, r6.role) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon_url, r6.icon_url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon_uri, r6.icon_uri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgImage, r6.bgImage) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.nick_name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.role;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.icon_url;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.icon_uri;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        BgImage r13 = this.bgImage;
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
        return "BotMakerDataModel(nick_name=" + this.nick_name + ", role=" + this.role + ", icon_url=" + this.icon_url + ", icon_uri=" + this.icon_uri + ", bgImage=" + this.bgImage + ')';
    }

    public final BgImage getBgImage() {
        return this.bgImage;
    }

    public final String getIcon_uri() {
        return this.icon_uri;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getNick_name() {
        return this.nick_name;
    }

    public final String getRole() {
        return this.role;
    }

    public final void setBgImage(BgImage r1) {
        this.bgImage = r1;
    }

    public final void setIcon_uri(String r1) {
        this.icon_uri = r1;
    }

    public final void setIcon_url(String r1) {
        this.icon_url = r1;
    }

    public final void setNick_name(String r1) {
        this.nick_name = r1;
    }

    public final void setRole(String r1) {
        this.role = r1;
    }

    public BotMakerDataModel(String r1, String r2, String r3, String r4, BgImage r5) {
        this.nick_name = r1;
        this.role = r2;
        this.icon_url = r3;
        this.icon_uri = r4;
        this.bgImage = r5;
    }

    public /* synthetic */ BotMakerDataModel(String r4, String r5, String r6, String r7, BgImage r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r9 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r9 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r9 & 16) == 0) goto L21;
        r8 = null;
    L21:
        BgImage r12 = r8;
        this(r11, r1, r2, r0, r12);
        return;
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
