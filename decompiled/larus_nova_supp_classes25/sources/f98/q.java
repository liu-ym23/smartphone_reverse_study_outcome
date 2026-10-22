package f98;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/avlink/e/model/UploadPrefInfo;", "", "<init>", "()V", "uploadPicsDuration", "", "getUploadPicsDuration", "()Ljava/lang/Long;", "setUploadPicsDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "occlusionDetectionDuration", "getOcclusionDetectionDuration", "setOcclusionDetectionDuration", "totalDurationMs", "getTotalDurationMs", "setTotalDurationMs", "ocrPerf", "Lcom/larus/avlink/e/model/OcrPerf;", "getOcrPerf", "()Lcom/larus/avlink/e/model/OcrPerf;", "setOcrPerf", "(Lcom/larus/avlink/e/model/OcrPerf;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class q {

    @SerializedName("occlusion_detection_ms")
    private Long occlusionDetectionDuration;

    @SerializedName("ocr_perf")
    private n ocrPerf;

    @SerializedName("total_duration_ms")
    private Long totalDurationMs;

    @SerializedName("upload_pics_duration_ms")
    private Long uploadPicsDuration;

    public q() {
    }

    public final Long a() {
        return this.occlusionDetectionDuration;
    }

    public final n b() {
        return this.ocrPerf;
    }

    public final Long c() {
        return this.totalDurationMs;
    }

    public final Long d() {
        return this.uploadPicsDuration;
    }
}
