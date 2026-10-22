package fs9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/larus/profile/api/bean/ContentFromChat;", "", "messageId", "", "imageContent", "Lcom/larus/profile/api/bean/ImageContentFromChat;", "musicContent", "Lcom/larus/profile/api/bean/MusicContentFromChat;", "avatarContent", "Lcom/larus/profile/api/bean/UserAvatarContentFromChat;", "aiBeatifyContent", "Lcom/larus/profile/api/bean/AiBeatifyContentFromChat;", "videoContent", "Lcom/larus/profile/api/bean/VideoContentFromChat;", "<init>", "(Ljava/lang/String;Lcom/larus/profile/api/bean/ImageContentFromChat;Lcom/larus/profile/api/bean/MusicContentFromChat;Lcom/larus/profile/api/bean/UserAvatarContentFromChat;Lcom/larus/profile/api/bean/AiBeatifyContentFromChat;Lcom/larus/profile/api/bean/VideoContentFromChat;)V", "getMessageId", "()Ljava/lang/String;", "getImageContent", "()Lcom/larus/profile/api/bean/ImageContentFromChat;", "getMusicContent", "()Lcom/larus/profile/api/bean/MusicContentFromChat;", "getAvatarContent", "()Lcom/larus/profile/api/bean/UserAvatarContentFromChat;", "getAiBeatifyContent", "()Lcom/larus/profile/api/bean/AiBeatifyContentFromChat;", "getVideoContent", "()Lcom/larus/profile/api/bean/VideoContentFromChat;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class e {

    @SerializedName("ai_beautify_content")
    private final a aiBeatifyContent;

    @SerializedName("user_avatar_content")
    private final z avatarContent;

    @SerializedName("image_content")
    private final j imageContent;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("music_content")
    private final l musicContent;

    @SerializedName("video_content")
    private final c0 videoContent;

    public e() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageContent, r6.imageContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.musicContent, r6.musicContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarContent, r6.avatarContent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.aiBeatifyContent, r6.aiBeatifyContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoContent, r6.videoContent) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.messageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        j r4 = this.imageContent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        l r7 = this.musicContent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        z r10 = this.avatarContent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        a r13 = this.aiBeatifyContent;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        c0 r16 = this.videoContent;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "ContentFromChat(messageId=" + this.messageId + ", imageContent=" + this.imageContent + ", musicContent=" + this.musicContent + ", avatarContent=" + this.avatarContent + ", aiBeatifyContent=" + this.aiBeatifyContent + ", videoContent=" + this.videoContent + ')';
    }

    public e(String r3, j r4, l r5, z r6, a r7, c0 r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r9 & 32) == 0) goto L20;
        r8 = null;
    L20:
        this.messageId = r3;
        this.imageContent = r4;
        this.musicContent = r5;
        this.avatarContent = r6;
        this.aiBeatifyContent = r7;
        this.videoContent = r8;
    }
}
