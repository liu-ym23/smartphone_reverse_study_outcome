package ic8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J^\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0018¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/bean/GetNexPulseRequest;", "", "botId", "", "conversationId", "scene", "", "params", "Lcom/larus/bmhome/chat/bean/NexPulseParams;", "skipCache", "", "throughToken", "isFirst", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/NexPulseParams;ZLjava/lang/String;Z)V", "getBotId", "()Ljava/lang/String;", "getConversationId", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getParams", "()Lcom/larus/bmhome/chat/bean/NexPulseParams;", "getSkipCache", "()Z", "getThroughToken", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/NexPulseParams;ZLjava/lang/String;Z)Lcom/larus/bmhome/chat/bean/GetNexPulseRequest;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class s {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("is_first")
    private final boolean isFirst;

    @SerializedName("params")
    private final k0 params;

    @SerializedName("scene")
    private final Integer scene;

    @SerializedName("skip_cache")
    private final boolean skipCache;

    @SerializedName("through_token")
    private final String throughToken;

    public s() {
        this(null, null, null, null, false, null, false);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L21;
        return false;
    L21:
        if (this.skipCache == r6.skipCache) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.throughToken, r6.throughToken) == true) goto L27;
        return false;
    L27:
        if (this.isFirst == r6.isFirst) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.botId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.conversationId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.scene;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        k0 r10 = this.params;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.skipCache == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.throughToken;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        if (this.isFirst == true) goto L31;
        r13 = 1237;
    L31:
        return r17 + r13;
    L21:
        r14 = 1237;
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
        return "GetNexPulseRequest(botId=" + this.botId + ", conversationId=" + this.conversationId + ", scene=" + this.scene + ", params=" + this.params + ", skipCache=" + this.skipCache + ", throughToken=" + this.throughToken + ", isFirst=" + this.isFirst + ')';
    }

    public s(String r1, String r2, Integer r3, k0 r4, boolean r5, String r6, boolean r7) {
        this.botId = r1;
        this.conversationId = r2;
        this.scene = r3;
        this.params = r4;
        this.skipCache = r5;
        this.throughToken = r6;
        this.isFirst = r7;
    }
}
