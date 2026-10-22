package ni8;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.Conversation;
import com.larus.bmhome.chat.resp.Templates;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old link data")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u001b\u0010/\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÂ\u0003Jx\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u000eHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R0\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/resp/ConversationInfo;", "", "conversation", "Lcom/larus/bmhome/chat/resp/Conversation;", "sectionTimeout", "", "profileTimeout", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "tempList", "", "Lcom/larus/bmhome/chat/resp/Templates;", "traceMap", "", "", "onBoardingMsg", "Lcom/larus/im/bean/IMMsg;", "<init>", "(Lcom/larus/bmhome/chat/resp/Conversation;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/bot/BotModel;Ljava/util/List;Ljava/util/Map;Lcom/larus/im/bean/IMMsg;)V", "getConversation", "()Lcom/larus/bmhome/chat/resp/Conversation;", "setConversation", "(Lcom/larus/bmhome/chat/resp/Conversation;)V", "getSectionTimeout", "()Ljava/lang/Long;", "setSectionTimeout", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getProfileTimeout", "setProfileTimeout", "getBotInfo", "()Lcom/larus/im/bean/bot/BotModel;", "setBotInfo", "(Lcom/larus/im/bean/bot/BotModel;)V", "getTempList", "()Ljava/util/List;", "setTempList", "(Ljava/util/List;)V", "getTraceMap", "()Ljava/util/Map;", "setTraceMap", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/bmhome/chat/resp/Conversation;Ljava/lang/Long;Ljava/lang/Long;Lcom/larus/im/bean/bot/BotModel;Ljava/util/List;Ljava/util/Map;Lcom/larus/im/bean/IMMsg;)Lcom/larus/bmhome/chat/resp/ConversationInfo;", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class d {

    @SerializedName("bot_info")
    private BotModel botInfo;

    @SerializedName("conversation")
    private Conversation conversation;

    @SerializedName("onboarding_msg")
    private IMMsg onBoardingMsg;

    @SerializedName("profile_timeout")
    @JsonAdapter(TimeTransformAdapter.class)
    private Long profileTimeout;

    @SerializedName("section_timeout")
    @JsonAdapter(TimeTransformAdapter.class)
    private Long sectionTimeout;

    @SerializedName("msg_templates")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<Templates> tempList;

    @SerializedName("trace_map")
    private Map<String, String> traceMap;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.conversation, r6.conversation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sectionTimeout, r6.sectionTimeout) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.profileTimeout, r6.profileTimeout) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botInfo, r6.botInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tempList, r6.tempList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.traceMap, r6.traceMap) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.onBoardingMsg, r6.onBoardingMsg) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Conversation r0 = this.conversation;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.sectionTimeout;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.profileTimeout;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        BotModel r10 = this.botInfo;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<Templates> r13 = this.tempList;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.traceMap;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        IMMsg r19 = this.onBoardingMsg;
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
        return "ConversationInfo(conversation=" + this.conversation + ", sectionTimeout=" + this.sectionTimeout + ", profileTimeout=" + this.profileTimeout + ", botInfo=" + this.botInfo + ", tempList=" + this.tempList + ", traceMap=" + this.traceMap + ", onBoardingMsg=" + this.onBoardingMsg + ')';
    }

    public d() {
        Map<String, String> r0 = MapsKt.emptyMap();
        this.conversation = null;
        this.sectionTimeout = null;
        this.profileTimeout = null;
        this.botInfo = null;
        this.tempList = null;
        this.traceMap = r0;
        this.onBoardingMsg = null;
    }

    public final BotModel a() {
        return this.botInfo;
    }

    public final Conversation b() {
        return this.conversation;
    }
}
