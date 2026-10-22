package com.larus.bmhome.chat.bean;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b>\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003J\t\u0010L\u001a\u00020\u0012HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010N\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010:J\u008c\u0002\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00122\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0016HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u00100R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0017\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00100R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u0018\u00104R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b<\u0010:¨\u0006X"}, d2 = {"Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "", "displayText", "", "bgColorLight", "bgColorDark", "fontColorLight", "fontColorDark", "borderColorLight", "borderColorDark", "frontIcon", "Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "endIcon", "sendMessageText", "schema", "suggestedItemType", "", "isHighlightPush", "", "wcbItem", "tagList", "", "", "isRichText", "isContinueAsk", "displayRichTextConf", "Lcom/google/gson/JsonObject;", "sendRichTextConf", "icon", "position", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/List;ZLjava/lang/Boolean;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDisplayText", "()Ljava/lang/String;", "getBgColorLight", "getBgColorDark", "getFontColorLight", "getFontColorDark", "getBorderColorLight", "getBorderColorDark", "getFrontIcon", "()Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "getEndIcon", "getSendMessageText", "getSchema", "getSuggestedItemType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getWcbItem", "getTagList", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisplayRichTextConf", "()Lcom/google/gson/JsonObject;", "getSendRichTextConf", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Lcom/larus/bmhome/chat/bean/NexPulseMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/List;ZLjava/lang/Boolean;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/TextCandidateConf;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TextCandidateConf {

    @SerializedName("bg_color_dark")
    private final String bgColorDark;

    @SerializedName("bg_color_light")
    private final String bgColorLight;

    @SerializedName("border_color_dark")
    private final String borderColorDark;

    @SerializedName("border_color_light")
    private final String borderColorLight;

    @SerializedName("rich_display_text_conf")
    private final JsonObject displayRichTextConf;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("end_icon")
    private final NexPulseMedia endIcon;

    @SerializedName("font_color_dark")
    private final String fontColorDark;

    @SerializedName("font_color_light")
    private final String fontColorLight;

    @SerializedName("front_icon")
    private final NexPulseMedia frontIcon;

    @SerializedName("Icon")
    private final Integer icon;

    @SerializedName("is_continue_ask")
    private final Boolean isContinueAsk;

    @SerializedName("is_highlight_push")
    private final boolean isHighlightPush;

    @SerializedName("is_rich_text")
    private final boolean isRichText;

    @SerializedName("Position")
    private final Integer position;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("send_message_text")
    private final String sendMessageText;

    @SerializedName("rich_send_message_text_conf")
    private final JsonObject sendRichTextConf;

    @SerializedName("suggestted_item_type")
    private final Long suggestedItemType;

    @SerializedName("tag_enum_mapping")
    private final List<Integer> tagList;

    @SerializedName("wcb_item")
    private final String wcbItem;

    public TextCandidateConf() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextCandidateConf copy$default(TextCandidateConf r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, NexPulseMedia r25, NexPulseMedia r26, String r27, String r28, Long r29, boolean r30, String r31, List r32, boolean r33, Boolean r34, JsonObject r35, JsonObject r36, Integer r37, Integer r38, int r39, Object r40) {
        if ((r39 & 1) == 0) goto L5;
        String r2 = r17.displayText;
    L7:
        if ((r39 & 2) == 0) goto L9;
        String r3 = r17.bgColorLight;
    L11:
        if ((r39 & 4) == 0) goto L13;
        String r4 = r17.bgColorDark;
    L15:
        if ((r39 & 8) == 0) goto L17;
        String r5 = r17.fontColorLight;
    L19:
        if ((r39 & 16) == 0) goto L21;
        String r6 = r17.fontColorDark;
    L23:
        if ((r39 & 32) == 0) goto L25;
        String r7 = r17.borderColorLight;
    L27:
        if ((r39 & 64) == 0) goto L29;
        String r8 = r17.borderColorDark;
    L31:
        if ((r39 & 128) == 0) goto L33;
        NexPulseMedia r9 = r17.frontIcon;
    L35:
        if ((r39 & 256) == 0) goto L37;
        NexPulseMedia r10 = r17.endIcon;
    L39:
        if ((r39 & 512) == 0) goto L41;
        String r11 = r17.sendMessageText;
    L43:
        if ((r39 & 1024) == 0) goto L45;
        String r12 = r17.schema;
    L47:
        if ((r39 & 2048) == 0) goto L49;
        Long r13 = r17.suggestedItemType;
    L51:
        if ((r39 & 4096) == 0) goto L53;
        boolean r14 = r17.isHighlightPush;
    L55:
        if ((r39 & 8192) == 0) goto L57;
        String r15 = r17.wcbItem;
    L58:
        String r310 = r15;
        if ((r39 & 16384) == 0) goto L61;
        List r16 = r17.tagList;
    L62:
        List r311 = r16;
        if ((r39 & 32768) == 0) goto L65;
        boolean r110 = r17.isRichText;
    L66:
        boolean r312 = r110;
        if ((r39 & 65536) == 0) goto L69;
        Boolean r111 = r17.isContinueAsk;
    L70:
        Boolean r313 = r111;
        if ((r39 & 131072) == 0) goto L73;
        JsonObject r112 = r17.displayRichTextConf;
    L74:
        JsonObject r314 = r112;
        if ((r39 & 262144) == 0) goto L77;
        JsonObject r113 = r17.sendRichTextConf;
    L78:
        JsonObject r315 = r113;
        if ((r39 & 524288) == 0) goto L81;
        Integer r114 = r17.icon;
    L83:
        if ((r39 & 1048576) == 0) goto L85;
        Integer r1 = r17.position;
    L87:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r114, r1);
    L85:
        r1 = r38;
        goto L87
    L81:
        r114 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.displayText;
    }

    public final String component10() {
        return this.sendMessageText;
    }

    public final String component11() {
        return this.schema;
    }

    public final Long component12() {
        return this.suggestedItemType;
    }

    public final boolean component13() {
        return this.isHighlightPush;
    }

    public final String component14() {
        return this.wcbItem;
    }

    public final List<Integer> component15() {
        return this.tagList;
    }

    public final boolean component16() {
        return this.isRichText;
    }

    public final Boolean component17() {
        return this.isContinueAsk;
    }

    public final JsonObject component18() {
        return this.displayRichTextConf;
    }

    public final JsonObject component19() {
        return this.sendRichTextConf;
    }

    public final String component2() {
        return this.bgColorLight;
    }

    public final Integer component20() {
        return this.icon;
    }

    public final Integer component21() {
        return this.position;
    }

    public final String component3() {
        return this.bgColorDark;
    }

    public final String component4() {
        return this.fontColorLight;
    }

    public final String component5() {
        return this.fontColorDark;
    }

    public final String component6() {
        return this.borderColorLight;
    }

    public final String component7() {
        return this.borderColorDark;
    }

    public final NexPulseMedia component8() {
        return this.frontIcon;
    }

    public final NexPulseMedia component9() {
        return this.endIcon;
    }

    public final TextCandidateConf copy(String r24, String r25, String r26, String r27, String r28, String r29, String r30, NexPulseMedia r31, NexPulseMedia r32, String r33, String r34, Long r35, boolean r36, String r37, List<Integer> r38, boolean r39, Boolean r40, JsonObject r41, JsonObject r42, Integer r43, Integer r44) {
        return new TextCandidateConf(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextCandidateConf) == true) goto L8;
        return false;
    L8:
        TextCandidateConf r6 = (TextCandidateConf) r5;
        if (Intrinsics.areEqual(this.displayText, r6.displayText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgColorLight, r6.bgColorLight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgColorDark, r6.bgColorDark) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontColorLight, r6.fontColorLight) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontColorDark, r6.fontColorDark) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.borderColorLight, r6.borderColorLight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.borderColorDark, r6.borderColorDark) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.frontIcon, r6.frontIcon) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.endIcon, r6.endIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sendMessageText, r6.sendMessageText) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.suggestedItemType, r6.suggestedItemType) == true) goto L45;
        return false;
    L45:
        if (this.isHighlightPush == r6.isHighlightPush) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.wcbItem, r6.wcbItem) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.tagList, r6.tagList) == true) goto L54;
        return false;
    L54:
        if (this.isRichText == r6.isRichText) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.isContinueAsk, r6.isContinueAsk) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.displayRichTextConf, r6.displayRichTextConf) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.sendRichTextConf, r6.sendRichTextConf) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        String r0 = this.displayText;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bgColorLight;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.bgColorDark;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.fontColorLight;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.fontColorDark;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.borderColorLight;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.borderColorDark;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        NexPulseMedia r22 = this.frontIcon;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        NexPulseMedia r25 = this.endIcon;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.sendMessageText;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.schema;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Long r34 = this.suggestedItemType;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        int r37 = 1231;
        if (this.isHighlightPush == false) goto L53;
        int r38 = 1231;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.wcbItem;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        List<Integer> r43 = this.tagList;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        if (this.isRichText == true) goto L66;
        r37 = 1237;
    L66:
        int r46 = (r45 + r37) * 31;
        Boolean r47 = this.isContinueAsk;
        if (r47 != null) goto L69;
        int r48 = 0;
    L70:
        int r49 = (r46 + r48) * 31;
        JsonObject r50 = this.displayRichTextConf;
        if (r50 != null) goto L73;
        int r51 = 0;
    L74:
        int r52 = (r49 + r51) * 31;
        JsonObject r53 = this.sendRichTextConf;
        if (r53 != null) goto L77;
        int r54 = 0;
    L78:
        int r55 = (r52 + r54) * 31;
        Integer r56 = this.icon;
        if (r56 != null) goto L81;
        int r57 = 0;
    L82:
        int r58 = (r55 + r57) * 31;
        Integer r59 = this.position;
        if (r59 == null) goto L87;
        r1 = r59.hashCode();
    L87:
        return r58 + r1;
    L81:
        r57 = r56.hashCode();
        goto L82
    L77:
        r54 = r53.hashCode();
        goto L78
    L73:
        r51 = r50.hashCode();
        goto L74
    L69:
        r48 = r47.hashCode();
        goto L70
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = 1237;
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

    public String toString() {
        return "TextCandidateConf(displayText=" + this.displayText + ", bgColorLight=" + this.bgColorLight + ", bgColorDark=" + this.bgColorDark + ", fontColorLight=" + this.fontColorLight + ", fontColorDark=" + this.fontColorDark + ", borderColorLight=" + this.borderColorLight + ", borderColorDark=" + this.borderColorDark + ", frontIcon=" + this.frontIcon + ", endIcon=" + this.endIcon + ", sendMessageText=" + this.sendMessageText + ", schema=" + this.schema + ", suggestedItemType=" + this.suggestedItemType + ", isHighlightPush=" + this.isHighlightPush + ", wcbItem=" + this.wcbItem + ", tagList=" + this.tagList + ", isRichText=" + this.isRichText + ", isContinueAsk=" + this.isContinueAsk + ", displayRichTextConf=" + this.displayRichTextConf + ", sendRichTextConf=" + this.sendRichTextConf + ", icon=" + this.icon + ", position=" + this.position + ')';
    }

    public final String getBgColorDark() {
        return this.bgColorDark;
    }

    public final String getBgColorLight() {
        return this.bgColorLight;
    }

    public final String getBorderColorDark() {
        return this.borderColorDark;
    }

    public final String getBorderColorLight() {
        return this.borderColorLight;
    }

    public final JsonObject getDisplayRichTextConf() {
        return this.displayRichTextConf;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final NexPulseMedia getEndIcon() {
        return this.endIcon;
    }

    public final String getFontColorDark() {
        return this.fontColorDark;
    }

    public final String getFontColorLight() {
        return this.fontColorLight;
    }

    public final NexPulseMedia getFrontIcon() {
        return this.frontIcon;
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSendMessageText() {
        return this.sendMessageText;
    }

    public final JsonObject getSendRichTextConf() {
        return this.sendRichTextConf;
    }

    public final Long getSuggestedItemType() {
        return this.suggestedItemType;
    }

    public final List<Integer> getTagList() {
        return this.tagList;
    }

    public final String getWcbItem() {
        return this.wcbItem;
    }

    public final Boolean isContinueAsk() {
        return this.isContinueAsk;
    }

    public final boolean isHighlightPush() {
        return this.isHighlightPush;
    }

    public final boolean isRichText() {
        return this.isRichText;
    }

    public TextCandidateConf(String r3, String r4, String r5, String r6, String r7, String r8, String r9, NexPulseMedia r10, NexPulseMedia r11, String r12, String r13, Long r14, boolean r15, String r16, List<Integer> r17, boolean r18, Boolean r19, JsonObject r20, JsonObject r21, Integer r22, Integer r23) {
        this.displayText = r3;
        this.bgColorLight = r4;
        this.bgColorDark = r5;
        this.fontColorLight = r6;
        this.fontColorDark = r7;
        this.borderColorLight = r8;
        this.borderColorDark = r9;
        this.frontIcon = r10;
        this.endIcon = r11;
        this.sendMessageText = r12;
        this.schema = r13;
        this.suggestedItemType = r14;
        this.isHighlightPush = r15;
        this.wcbItem = r16;
        this.tagList = r17;
        this.isRichText = r18;
        this.isContinueAsk = r19;
        this.displayRichTextConf = r20;
        this.sendRichTextConf = r21;
        this.icon = r22;
        this.position = r23;
    }

    public /* synthetic */ TextCandidateConf(String r23, String r24, String r25, String r26, String r27, String r28, String r29, NexPulseMedia r30, NexPulseMedia r31, String r32, String r33, Long r34, boolean r35, String r36, List r37, boolean r38, Boolean r39, JsonObject r40, JsonObject r41, Integer r42, Integer r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r44 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r44 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r44 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r44 & 128) == 0) goto L33;
        NexPulseMedia r9 = null;
    L35:
        if ((r44 & 256) == 0) goto L37;
        NexPulseMedia r10 = null;
    L39:
        if ((r44 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        Long r13 = null;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        boolean r14 = false;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        String r2 = null;
    L59:
        if ((r44 & 16384) == 0) goto L61;
        List r15 = null;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r44 & 65536) == 0) goto L69;
        Boolean r17 = null;
    L71:
        if ((r44 & 131072) == 0) goto L73;
        JsonObject r18 = null;
    L75:
        if ((r44 & 262144) == 0) goto L77;
        JsonObject r19 = null;
    L79:
        if ((r44 & 524288) == 0) goto L81;
        Integer r20 = null;
    L83:
        if ((r44 & 1048576) == 0) goto L85;
        Integer r0 = null;
    L86:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2, r15, r16, r17, r18, r19, r20, r0);
        return;
    L85:
        r0 = r43;
        goto L86
    L81:
        r20 = r42;
        goto L83
    L77:
        r19 = r41;
        goto L79
    L73:
        r18 = r40;
        goto L75
    L69:
        r17 = r39;
        goto L71
    L65:
        r16 = r38;
        goto L67
    L61:
        r15 = r37;
        goto L63
    L57:
        r2 = r36;
        goto L59
    L53:
        r14 = r35;
        goto L55
    L49:
        r13 = r34;
        goto L51
    L45:
        r12 = r33;
        goto L47
    L41:
        r11 = r32;
        goto L43
    L37:
        r10 = r31;
        goto L39
    L33:
        r9 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }
}
