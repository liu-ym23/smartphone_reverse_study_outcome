package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/voicecall/api/bean/SessionConfResponse;", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "conversationId", "ttsParams", "Lcom/larus/voicecall/api/bean/TtsParams;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/voicecall/api/bean/TtsParams;)V", "getBotId", "()Ljava/lang/String;", "getConversationId", "getTtsParams", "()Lcom/larus/voicecall/api/bean/TtsParams;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionConfResponse {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("tts")
    private final TtsParams ttsParams;

    public SessionConfResponse() {
        this(null, null, null, 7, null);
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final TtsParams getTtsParams() {
        return this.ttsParams;
    }

    public SessionConfResponse(String r1, String r2, TtsParams r3) {
        this.botId = r1;
        this.conversationId = r2;
        this.ttsParams = r3;
    }

    public /* synthetic */ SessionConfResponse(String r2, String r3, TtsParams r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
