package kr8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001fJª\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u000f\u0010\u001f¨\u00067"}, d2 = {"Lcom/larus/bmhome/music/mob/CompleteCreateMusicMobEvent;", "Lcom/larus/trace/MobEvent;", "mobKey", "", "currentPage", "previousPage", "enterMethod", "model", "botId", "chatType", "createWay", "lyricCreateType", "isLyric", "success", "errorInfo", "isCreationActionBar", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getMobKey", "()Ljava/lang/String;", "getCurrentPage", "getPreviousPage", "getEnterMethod", "getModel", "getBotId", "getChatType", "getCreateWay", "getLyricCreateType", "getSuccess", "getErrorInfo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/music/mob/CompleteCreateMusicMobEvent;", "equals", "other", "", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e implements e2 {
    public static long b;
    public static final /* synthetic */ int c = 0;
    public final transient String a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("create_way")
    private final String createWay;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("error_info")
    private final String errorInfo;

    @SerializedName("is_creation_action_bar")
    private final Boolean isCreationActionBar;

    @SerializedName("is_lyric")
    private final String isLyric;

    @SerializedName("lyric_create_type")
    private final String lyricCreateType;

    @SerializedName("model")
    private final String model;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("success")
    private final String success;

    public static final class a {
        public static long a() {
            if (e.b != 0) goto L6;
            return 0;
        L6:
            return System.currentTimeMillis() - e.b;
        }
    }

    static {
    }

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentPage, r6.currentPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.chatType, r6.chatType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createWay, r6.createWay) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.lyricCreateType, r6.lyricCreateType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isLyric, r6.isLyric) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.success, r6.success) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.errorInfo, r6.errorInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.isCreationActionBar, r6.isCreationActionBar) == true) goto L47;
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
        String r4 = this.currentPage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.previousPage;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.enterMethod;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.model;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.botId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.chatType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.createWay;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.lyricCreateType;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.isLyric;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.success;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.errorInfo;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.isCreationActionBar;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
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
        return "CompleteCreateMusicMobEvent(mobKey=" + this.a + ", currentPage=" + this.currentPage + ", previousPage=" + this.previousPage + ", enterMethod=" + this.enterMethod + ", model=" + this.model + ", botId=" + this.botId + ", chatType=" + this.chatType + ", createWay=" + this.createWay + ", lyricCreateType=" + this.lyricCreateType + ", isLyric=" + this.isLyric + ", success=" + this.success + ", errorInfo=" + this.errorInfo + ", isCreationActionBar=" + this.isCreationActionBar + ')';
    }

    public final String a() {
        return this.a;
    }

    public final void b(by7.e r1, JSONObject r2) {
        e2.a.a(this, r1, r2);
    }

    public e(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Boolean r27, int r28) {
        Boolean r3 = null;
        if ((r28 & 1) == 0) goto L5;
        String r2 = "complete_create_music";
    L6:
        String r5 = "";
        if ((r28 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r28 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r11 = "chat_action_bar";
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r28 & 512) == 0) goto L41;
        String r13 = "1";
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r28 & 2048) != 0) goto L51;
        r5 = r26;
    L51:
        if ((r28 & 4096) != 0) goto L54;
        r3 = r27;
    L54:
        this.a = r2;
        this.currentPage = r4;
        this.previousPage = r6;
        this.enterMethod = r7;
        this.model = r8;
        this.botId = r9;
        this.chatType = r10;
        this.createWay = r11;
        this.lyricCreateType = r12;
        this.isLyric = r13;
        this.success = r14;
        this.errorInfo = r5;
        this.isCreationActionBar = r3;
        b = System.currentTimeMillis();
        return;
    L45:
        r14 = r25;
        goto L47
    L41:
        r13 = r24;
        goto L43
    L37:
        r12 = r23;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
