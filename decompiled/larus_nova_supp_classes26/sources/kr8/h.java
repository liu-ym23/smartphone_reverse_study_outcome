package kr8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003Jê\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u000fHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u000e\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0016\u0010\u0015\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0016\u0010\u0016\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*¨\u0006J"}, d2 = {"Lcom/larus/bmhome/music/mob/CreateMusicResult;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "secScene", "chatType", "botId", "createWay", "videoId", "errorInfo", "title", "messageId", "enterMethod", "lyricCreateType", "isLyric", "", "model", "generationType", "duration", "messageType", "success", "successCount", "requestCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;III)V", "getMobKey", "()Ljava/lang/String;", "getSecScene", "getChatType", "getBotId", "getCreateWay", "getVideoId", "getErrorInfo", "getTitle", "getMessageId", "getEnterMethod", "getLyricCreateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getModel", "getGenerationType", "getDuration", "()I", "getMessageType", "getSuccess", "getSuccessCount", "getRequestCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;III)Lcom/larus/bmhome/music/mob/CreateMusicResult;", "equals", "", "other", "", "hashCode", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h implements l {
    public final transient String a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("create_source")
    private final String createWay;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("error_info")
    private final String errorInfo;

    @SerializedName("generation_type")
    private final String generationType;

    @SerializedName("is_lyric")
    private final Integer isLyric;

    @SerializedName("lyric_create_type")
    private final String lyricCreateType;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("message_type")
    private final String messageType;

    @SerializedName("model")
    private final String model;

    @SerializedName("request_cnt")
    private final int requestCount;

    @SerializedName("sec_scene")
    private final String secScene;

    @SerializedName("success")
    private final int success;

    @SerializedName("success_cnt")
    private final int successCount;

    @SerializedName("title")
    private final String title;

    @SerializedName("video_id")
    private final String videoId;

    public h() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 524287);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secScene, r6.secScene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatType, r6.chatType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createWay, r6.createWay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoId, r6.videoId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.errorInfo, r6.errorInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.lyricCreateType, r6.lyricCreateType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isLyric, r6.isLyric) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.generationType, r6.generationType) == true) goto L51;
        return false;
    L51:
        if (this.duration == r6.duration) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageType, r6.messageType) == true) goto L57;
        return false;
    L57:
        if (this.success == r6.success) goto L60;
        return false;
    L60:
        if (this.successCount == r6.successCount) goto L63;
        return false;
    L63:
        if (this.requestCount == r6.requestCount) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.secScene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.chatType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.botId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.createWay;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.videoId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.errorInfo;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.title;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.messageId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.enterMethod;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.lyricCreateType;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.isLyric;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.model;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.generationType;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (((r39 + r41) * 31) + this.duration) * 31;
        String r43 = this.messageType;
        if (r43 == null) goto L63;
        r1 = r43.hashCode();
    L63:
        return ((((((r42 + r1) * 31) + this.success) * 31) + this.successCount) * 31) + this.requestCount;
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
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
        return "CreateMusicResult(mobKey=" + this.a + ", secScene=" + this.secScene + ", chatType=" + this.chatType + ", botId=" + this.botId + ", createWay=" + this.createWay + ", videoId=" + this.videoId + ", errorInfo=" + this.errorInfo + ", title=" + this.title + ", messageId=" + this.messageId + ", enterMethod=" + this.enterMethod + ", lyricCreateType=" + this.lyricCreateType + ", isLyric=" + this.isLyric + ", model=" + this.model + ", generationType=" + this.generationType + ", duration=" + this.duration + ", messageType=" + this.messageType + ", success=" + this.success + ", successCount=" + this.successCount + ", requestCount=" + this.requestCount + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.a;
    }

    @Override // kr8.l
    public final void b(by7.e r1, JSONObject r2) {
        l.a.a(this, r1, r2);
    }

    public h(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, Integer r30, String r31, String r32, int r33, String r34, int r35, int r36, int r37, int r38) {
        String r3 = null;
        if ((r38 & 1) == 0) goto L5;
        String r2 = "create_music_result";
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r38 & 8) != 0) goto L19;
        r3 = r22;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r38 & 2048) == 0) goto L49;
        Integer r14 = 1;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r7 = "";
    L58:
        String r210 = r7;
        if ((r38 & 16384) == 0) goto L61;
        int r16 = e.c;
        int r17 = (int) e.a.a();
    L63:
        if ((32768 & r38) == 0) goto L65;
        String r18 = "";
    L66:
        Integer r211 = r14;
        if ((r38 & 65536) == 0) goto L69;
        int r19 = 0;
    L71:
        if ((r38 & 131072) == 0) goto L73;
        int r110 = 0;
    L75:
        if ((r38 & 262144) == 0) goto L77;
        int r1 = 0;
    L78:
        this.a = r2;
        this.secScene = r4;
        this.chatType = r5;
        this.botId = r3;
        this.createWay = r6;
        this.videoId = r8;
        this.errorInfo = r9;
        this.title = r10;
        this.messageId = r11;
        this.enterMethod = r12;
        this.lyricCreateType = r13;
        this.isLyric = r211;
        this.model = r15;
        this.generationType = r210;
        this.duration = r17;
        this.messageType = r18;
        this.success = r19;
        this.successCount = r110;
        this.requestCount = r1;
        return;
    L77:
        r1 = r37;
        goto L78
    L73:
        r110 = r36;
        goto L75
    L69:
        r19 = r35;
        goto L71
    L65:
        r18 = r34;
        goto L66
    L61:
        r17 = r33;
        goto L63
    L57:
        r7 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = null;
        goto L7
    }
}
