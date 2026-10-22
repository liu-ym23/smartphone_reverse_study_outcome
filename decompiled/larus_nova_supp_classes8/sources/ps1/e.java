package ps1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lps1/e;", "", "", "entranceCardUrl", "Ljava/lang/String;", "getEntranceCardUrl", "()Ljava/lang/String;", "conversationFeedbackUrl", "getConversationFeedbackUrl", "entranceCardUrlV2", "getEntranceCardUrlV2", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("conversation_feedback_url")
    private final String conversationFeedbackUrl;

    @SerializedName("entrance_card_url")
    private final String entranceCardUrl;

    @SerializedName("annie_entrance_card_url")
    private final String entranceCardUrlV2;

    public e() {
        this.entranceCardUrl = "https://lf-dy-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/format_dh_lynx_douyin/pages/entrance_card/template.js";
        this.conversationFeedbackUrl = "https://lf-dy-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/format_dh_lynx_douyin/pages/conversation_feedback/template.js";
        this.entranceCardUrlV2 = "https://lf-dy-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/format_dh_lynx_douyin/pages/profile_card/template.js";
    }
}
