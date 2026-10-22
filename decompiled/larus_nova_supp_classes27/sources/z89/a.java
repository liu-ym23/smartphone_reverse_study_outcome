package z89;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jµ\u0001\u0010/\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u00067"}, d2 = {"Lcom/larus/enterprise/api/apptheme/AppThemeConfig;", "", "messageBubbleColor", "", "Lcom/larus/enterprise/api/apptheme/ThemeColorMode;", "messageReceiveBubbleColor", "messageSendColor", "navibarTtsButtonColor", "messageCheckboxColor", "messageSendTextColor", "messageSendTextUnderlineColor", "messageSendTextLoadingColor", "messageAnswerActionBackgroundColor", "messageAnswerActionColor", "messageReplyTextColor", "messageReplyLineColor", "messageReplyIconColor", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;Lcom/larus/enterprise/api/apptheme/ThemeColorMode;)V", "getMessageBubbleColor", "()Ljava/util/List;", "getMessageReceiveBubbleColor", "getMessageSendColor", "()Lcom/larus/enterprise/api/apptheme/ThemeColorMode;", "getNavibarTtsButtonColor", "getMessageCheckboxColor", "getMessageSendTextColor", "getMessageSendTextUnderlineColor", "getMessageSendTextLoadingColor", "getMessageAnswerActionBackgroundColor", "getMessageAnswerActionColor", "getMessageReplyTextColor", "getMessageReplyLineColor", "getMessageReplyIconColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("message_answer_action_background_color")
    private final b messageAnswerActionBackgroundColor;

    @SerializedName("message_answer_action_color")
    private final b messageAnswerActionColor;

    @SerializedName("message_bubble_color")
    private final List<b> messageBubbleColor;

    @SerializedName("mesage_checkbox_color")
    private final b messageCheckboxColor;

    @SerializedName("message_receive_bubble_color")
    private final List<b> messageReceiveBubbleColor;

    @SerializedName("message_reply_icon_color")
    private final b messageReplyIconColor;

    @SerializedName("message_reply_line_color")
    private final b messageReplyLineColor;

    @SerializedName("message_reply_text_color")
    private final b messageReplyTextColor;

    @SerializedName("message_send_color")
    private final b messageSendColor;

    @SerializedName("message_send_text_color")
    private final b messageSendTextColor;

    @SerializedName("message_send_text_loading_color")
    private final b messageSendTextLoadingColor;

    @SerializedName("message_send_text_underline_color")
    private final b messageSendTextUnderlineColor;

    @SerializedName("navibar_tts_button_color")
    private final b navibarTtsButtonColor;

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.messageBubbleColor, r6.messageBubbleColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageReceiveBubbleColor, r6.messageReceiveBubbleColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageSendColor, r6.messageSendColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.navibarTtsButtonColor, r6.navibarTtsButtonColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageCheckboxColor, r6.messageCheckboxColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageSendTextColor, r6.messageSendTextColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.messageSendTextUnderlineColor, r6.messageSendTextUnderlineColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageSendTextLoadingColor, r6.messageSendTextLoadingColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageAnswerActionBackgroundColor, r6.messageAnswerActionBackgroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.messageAnswerActionColor, r6.messageAnswerActionColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.messageReplyTextColor, r6.messageReplyTextColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.messageReplyLineColor, r6.messageReplyLineColor) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.messageReplyIconColor, r6.messageReplyIconColor) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        List<b> r0 = this.messageBubbleColor;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<b> r4 = this.messageReceiveBubbleColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.messageSendColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        b r10 = this.navibarTtsButtonColor;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        b r13 = this.messageCheckboxColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        b r16 = this.messageSendTextColor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        b r20 = this.messageSendTextUnderlineColor;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        b r23 = this.messageSendTextLoadingColor;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        b r26 = this.messageAnswerActionBackgroundColor;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        b r30 = this.messageAnswerActionColor;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r28 + r31) * 31;
        b r33 = this.messageReplyTextColor;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        b r36 = this.messageReplyLineColor;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        b r40 = this.messageReplyIconColor;
        if (r40 == null) goto L55;
        r1 = r40.hashCode();
    L55:
        return r38 + r1;
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
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
        return "AppThemeConfig(messageBubbleColor=" + this.messageBubbleColor + ", messageReceiveBubbleColor=" + this.messageReceiveBubbleColor + ", messageSendColor=" + this.messageSendColor + ", navibarTtsButtonColor=" + this.navibarTtsButtonColor + ", messageCheckboxColor=" + this.messageCheckboxColor + ", messageSendTextColor=" + this.messageSendTextColor + ", messageSendTextUnderlineColor=" + this.messageSendTextUnderlineColor + ", messageSendTextLoadingColor=" + this.messageSendTextLoadingColor + ", messageAnswerActionBackgroundColor=" + this.messageAnswerActionBackgroundColor + ", messageAnswerActionColor=" + this.messageAnswerActionColor + ", messageReplyTextColor=" + this.messageReplyTextColor + ", messageReplyLineColor=" + this.messageReplyLineColor + ", messageReplyIconColor=" + this.messageReplyIconColor + ')';
    }

    public final b a() {
        return this.messageAnswerActionBackgroundColor;
    }

    public final b b() {
        return this.messageAnswerActionColor;
    }

    public final List<b> c() {
        return this.messageBubbleColor;
    }

    public final b d() {
        return this.messageCheckboxColor;
    }

    public final List<b> e() {
        return this.messageReceiveBubbleColor;
    }

    public final b f() {
        return this.messageReplyIconColor;
    }

    public final b g() {
        return this.messageReplyLineColor;
    }

    public final b h() {
        return this.messageReplyTextColor;
    }

    public final b i() {
        return this.messageSendColor;
    }

    public final b j() {
        return this.messageSendTextColor;
    }

    public final b k() {
        return this.messageSendTextLoadingColor;
    }

    public final b l() {
        return this.messageSendTextUnderlineColor;
    }

    public final b m() {
        return this.navibarTtsButtonColor;
    }

    public a(List<b> r1, List<b> r2, b r3, b r4, b r5, b r6, b r7, b r8, b r9, b r10, b r11, b r12, b r13) {
        this.messageBubbleColor = r1;
        this.messageReceiveBubbleColor = r2;
        this.messageSendColor = r3;
        this.navibarTtsButtonColor = r4;
        this.messageCheckboxColor = r5;
        this.messageSendTextColor = r6;
        this.messageSendTextUnderlineColor = r7;
        this.messageSendTextLoadingColor = r8;
        this.messageAnswerActionBackgroundColor = r9;
        this.messageAnswerActionColor = r10;
        this.messageReplyTextColor = r11;
        this.messageReplyLineColor = r12;
        this.messageReplyIconColor = r13;
    }
}
