package kr8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J£\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\tHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/bmhome/music/mob/MusicPlayEnd;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "showFrom", "clickFrom", "messageId", "position", "duration", "", "botId", "videoId", "musicSource", "chatType", "currentPage", "title", "isTemplate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobKey", "()Ljava/lang/String;", "getShowFrom", "getClickFrom", "getMessageId", "getPosition", "getDuration", "()I", "getBotId", "getVideoId", "getMusicSource", "getChatType", "getCurrentPage", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "", "hashCode", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w implements l {
    public final transient String a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("click_from")
    private final String clickFrom;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("is_template")
    private final String isTemplate;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("music_source")
    private final String musicSource;

    @SerializedName("position")
    private final String position;

    @SerializedName("show_from")
    private final String showFrom;

    @SerializedName("title")
    private final String title;

    @SerializedName("video_id")
    private final String videoId;

    public w() {
        this(null, null, null, null, 0, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showFrom, r6.showFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clickFrom, r6.clickFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L24;
        return false;
    L24:
        if (this.duration == r6.duration) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.videoId, r6.videoId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.musicSource, r6.musicSource) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.chatType, r6.chatType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.currentPage, r6.currentPage) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.isTemplate, r6.isTemplate) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.showFrom;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.clickFrom;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.messageId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.position;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (((r12 + r14) * 31) + this.duration) * 31;
        String r16 = this.botId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.videoId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.musicSource;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.chatType;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.currentPage;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.title;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.isTemplate;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
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
        return "MusicPlayEnd(mobKey=" + this.a + ", showFrom=" + this.showFrom + ", clickFrom=" + this.clickFrom + ", messageId=" + this.messageId + ", position=" + this.position + ", duration=" + this.duration + ", botId=" + this.botId + ", videoId=" + this.videoId + ", musicSource=" + this.musicSource + ", chatType=" + this.chatType + ", currentPage=" + this.currentPage + ", title=" + this.title + ", isTemplate=" + this.isTemplate + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.a;
    }

    @Override // kr8.l
    public final void b(by7.e r1, JSONObject r2) {
        l.a.a(this, r1, r2);
    }

    public w(String r16, String r17, String r18, String r19, int r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = "music_play_end";
    L6:
        String r4 = "";
        if ((r28 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r8 = 0;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r4 = r27;
    L54:
        this.a = r2;
        this.showFrom = r3;
        this.clickFrom = r5;
        this.messageId = r6;
        this.position = r7;
        this.duration = r8;
        this.botId = r9;
        this.videoId = r10;
        this.musicSource = r11;
        this.chatType = r12;
        this.currentPage = r13;
        this.title = r14;
        this.isTemplate = r4;
        return;
    L49:
        r14 = r26;
        goto L51
    L45:
        r13 = r25;
        goto L47
    L41:
        r12 = r24;
        goto L43
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
