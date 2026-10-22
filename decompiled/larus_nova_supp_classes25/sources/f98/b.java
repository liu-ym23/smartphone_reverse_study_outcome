package f98;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/avlink/e/model/DoraFileExt;", "", "<init>", "()V", "filePayload", "Lcom/larus/avlink/e/model/DoraFilePayload;", "getFilePayload", "()Lcom/larus/avlink/e/model/DoraFilePayload;", "setFilePayload", "(Lcom/larus/avlink/e/model/DoraFilePayload;)V", "picShootingTimeMs", "", "getPicShootingTimeMs", "()Ljava/lang/Long;", "setPicShootingTimeMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sessionType", "", "getSessionType", "()Ljava/lang/String;", "setSessionType", "(Ljava/lang/String;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class b {

    @SerializedName("dora_file_payload")
    private c filePayload;

    @SerializedName("pic_shooting_time_ms")
    private Long picShootingTimeMs;

    @SerializedName("session_type")
    private String sessionType;

    public b() {
    }

    public final void a(c r1) {
        this.filePayload = r1;
    }

    public final void b(Long r1) {
        this.picShootingTimeMs = r1;
    }

    public final void c(String r1) {
        this.sessionType = r1;
    }
}
