package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lls1/z;", "", "", "lossPredictMode", "I", "getLossPredictMode", "()I", "setLossPredictMode", "(I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "scheduleTimeInterval", "Ljava/util/ArrayList;", "getScheduleTimeInterval", "()Ljava/util/ArrayList;", "scheduleMode", "getScheduleMode", "isReportPredictResult", "", "scheduleIntervalTotal", "J", "a", "()J", "", "showToastEnable", "Z", "getShowToastEnable", "()Z", "setShowToastEnable", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("report_predict_result")
    private final int isReportPredictResult;

    @SerializedName("room_loss_mode")
    private int lossPredictMode;

    @SerializedName("schedule_interval_total")
    private final long scheduleIntervalTotal;

    @SerializedName("schedule_mode")
    private final int scheduleMode;

    @SerializedName("schedule_time_interval")
    private final ArrayList<Integer> scheduleTimeInterval;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public final boolean b() {
        if (this.lossPredictMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public z() {
        this.scheduleTimeInterval = CollectionsKt.arrayListOf(new Integer[]{1, 3});
        this.scheduleIntervalTotal = 60;
    }

    public final long a() {
        return this.scheduleIntervalTotal;
    }
}
