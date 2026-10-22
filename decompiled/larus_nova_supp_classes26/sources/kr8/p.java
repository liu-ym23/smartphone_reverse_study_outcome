package kr8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/music/mob/MusicCardShow;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "messageId", "position", "videoId", "showFrom", "musicSource", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getMessageId", "getPosition", "getVideoId", "getShowFrom", "getMusicSource", "getBotId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p implements l {
    public final transient String a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("music_source")
    private final String musicSource;

    @SerializedName("position")
    private final String position;

    @SerializedName("show_from")
    private final String showFrom;

    @SerializedName("video_id")
    private final String videoId;

    public p() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoId, r6.videoId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showFrom, r6.showFrom) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.musicSource, r6.musicSource) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.messageId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.position;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.videoId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.showFrom;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.musicSource;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.botId;
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

    public final String toString() {
        return "MusicCardShow(mobKey=" + this.a + ", messageId=" + this.messageId + ", position=" + this.position + ", videoId=" + this.videoId + ", showFrom=" + this.showFrom + ", musicSource=" + this.musicSource + ", botId=" + this.botId + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.a;
    }

    public final String d() {
        return this.messageId;
    }

    public final String e() {
        return this.position;
    }

    public static p c(p r8, String r9) {
        return new p(r8.a, r8.messageId, r8.position, r9, r8.showFrom, r8.musicSource, r8.botId);
    }

    @Override // kr8.l
    public final void b(by7.e r1, JSONObject r2) {
        l.a.a(this, r1, r2);
    }

    public /* synthetic */ p(String r10, String r11, String r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r0 = "music_card_show";
    L6:
        String r2 = r0;
        if ((r16 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r16 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r16 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r16 & 64) == 0) goto L29;
        String r8 = "";
    L30:
        this(r2, r3, r4, r5, r6, r7, r8);
        return;
    L29:
        r8 = r15;
        goto L30
    L25:
        r7 = r14;
        goto L27
    L21:
        r6 = r13;
        goto L23
    L17:
        r5 = r12;
        goto L19
    L13:
        r4 = r11;
        goto L15
    L9:
        r3 = r10;
        goto L11
    L5:
        r0 = null;
        goto L6
    }

    public p(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.messageId = r2;
        this.position = r3;
        this.videoId = r4;
        this.showFrom = r5;
        this.musicSource = r6;
        this.botId = r7;
    }
}
