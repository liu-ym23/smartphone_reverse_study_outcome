package com.larus.bmhome.video;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.conversation.IconImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/larus/bmhome/video/AuthorInfo;", "", "id", "", "openId", "nickName", "shortId", MusicAppletPage.KEY_SOURCE, "", "status", "avatar", "Lcom/larus/im/bean/conversation/IconImage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/conversation/IconImage;)V", "getId", "()Ljava/lang/String;", "getOpenId", "getNickName", "getShortId", "getSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getAvatar", "()Lcom/larus/im/bean/conversation/IconImage;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/im/bean/conversation/IconImage;)Lcom/larus/bmhome/video/AuthorInfo;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorInfo {

    @SerializedName("avatar")
    private final IconImage avatar;

    @SerializedName("id")
    private final String id;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("open_id")
    private final String openId;

    @SerializedName("short_id")
    private final String shortId;

    @SerializedName(MusicAppletPage.KEY_SOURCE)
    private final Integer source;

    @SerializedName("status")
    private final Integer status;

    public AuthorInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AuthorInfo copy$default(AuthorInfo r5, String r6, String r7, String r8, String r9, Integer r10, Integer r11, IconImage r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.openId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.nickName;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.shortId;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.source;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.status;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.avatar;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.openId;
    }

    public final String component3() {
        return this.nickName;
    }

    public final String component4() {
        return this.shortId;
    }

    public final Integer component5() {
        return this.source;
    }

    public final Integer component6() {
        return this.status;
    }

    public final IconImage component7() {
        return this.avatar;
    }

    public final AuthorInfo copy(String r10, String r11, String r12, String r13, Integer r14, Integer r15, IconImage r16) {
        return new AuthorInfo(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AuthorInfo) == true) goto L8;
        return false;
    L8:
        AuthorInfo r6 = (AuthorInfo) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openId, r6.openId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nickName, r6.nickName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shortId, r6.shortId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.openId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.nickName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.shortId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.source;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.status;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        IconImage r19 = this.avatar;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        return "AuthorInfo(id=" + this.id + ", openId=" + this.openId + ", nickName=" + this.nickName + ", shortId=" + this.shortId + ", source=" + this.source + ", status=" + this.status + ", avatar=" + this.avatar + ')';
    }

    public final IconImage getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final String getShortId() {
        return this.shortId;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public AuthorInfo(String r1, String r2, String r3, String r4, Integer r5, Integer r6, IconImage r7) {
        this.id = r1;
        this.openId = r2;
        this.nickName = r3;
        this.shortId = r4;
        this.source = r5;
        this.status = r6;
        this.avatar = r7;
    }

    public /* synthetic */ AuthorInfo(String r7, String r8, String r9, String r10, Integer r11, Integer r12, IconImage r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Integer r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        Integer r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        IconImage r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
