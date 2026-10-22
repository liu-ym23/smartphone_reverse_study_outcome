package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Ljava/io/Serializable;", "iconUri", "", "iconUrl", "previewUrl", "downloadUrl", "prompt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUri", "()Ljava/lang/String;", "setIconUri", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getPreviewUrl", "setPreviewUrl", "getDownloadUrl", "setDownloadUrl", "getPrompt", "setPrompt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAvatarIconData implements Serializable {

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("icon_uri")
    private String iconUri;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("prompt")
    private String prompt;

    public BotAvatarIconData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BotAvatarIconData copy$default(BotAvatarIconData r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.iconUri;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.iconUrl;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.previewUrl;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.downloadUrl;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.prompt;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.iconUri;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.previewUrl;
    }

    public final String component4() {
        return this.downloadUrl;
    }

    public final String component5() {
        return this.prompt;
    }

    public final BotAvatarIconData copy(String r8, String r9, String r10, String r11, String r12) {
        return new BotAvatarIconData(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotAvatarIconData) == true) goto L8;
        return false;
    L8:
        BotAvatarIconData r6 = (BotAvatarIconData) r5;
        if (Intrinsics.areEqual(this.iconUri, r6.iconUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewUrl, r6.previewUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.downloadUrl, r6.downloadUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.iconUri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.iconUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.previewUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.downloadUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.prompt;
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
        return "BotAvatarIconData(iconUri=" + this.iconUri + ", iconUrl=" + this.iconUrl + ", previewUrl=" + this.previewUrl + ", downloadUrl=" + this.downloadUrl + ", prompt=" + this.prompt + ')';
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final void setDownloadUrl(String r1) {
        this.downloadUrl = r1;
    }

    public final void setIconUri(String r1) {
        this.iconUri = r1;
    }

    public final void setIconUrl(String r1) {
        this.iconUrl = r1;
    }

    public final void setPreviewUrl(String r1) {
        this.previewUrl = r1;
    }

    public final void setPrompt(String r1) {
        this.prompt = r1;
    }

    public BotAvatarIconData(String r1, String r2, String r3, String r4, String r5) {
        this.iconUri = r1;
        this.iconUrl = r2;
        this.previewUrl = r3;
        this.downloadUrl = r4;
        this.prompt = r5;
    }

    public /* synthetic */ BotAvatarIconData(String r4, String r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
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
        String r12 = r8;
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
