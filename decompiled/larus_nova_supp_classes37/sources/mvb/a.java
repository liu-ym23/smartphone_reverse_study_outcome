package mvb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmD1204FunctionConfigSetting;", "", "canStartRecordingWhenFileSync", "", "liveRecordingPriorityRetryIntervalMs", "", "<init>", "(ZJ)V", "getCanStartRecordingWhenFileSync", "()Z", "getLiveRecordingPriorityRetryIntervalMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class a {

    @SerializedName("canStartRecordingWhenFileSync")
    private final boolean canStartRecordingWhenFileSync;

    @SerializedName("liveRecordingPriorityRetryIntervalMs")
    private final long liveRecordingPriorityRetryIntervalMs;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.canStartRecordingWhenFileSync == r9.canStartRecordingWhenFileSync) goto L12;
        return false;
    L12:
        if (this.liveRecordingPriorityRetryIntervalMs == r9.liveRecordingPriorityRetryIntervalMs) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.canStartRecordingWhenFileSync == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.liveRecordingPriorityRetryIntervalMs;
        return (r0 * 31) + ((int) (r1 ^ (r1 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmD1204FunctionConfigSetting(canStartRecordingWhenFileSync=" + this.canStartRecordingWhenFileSync + ", liveRecordingPriorityRetryIntervalMs=" + this.liveRecordingPriorityRetryIntervalMs + ')';
    }

    public final boolean a() {
        return this.canStartRecordingWhenFileSync;
    }

    public a(int r3) {
        this.canStartRecordingWhenFileSync = false;
        this.liveRecordingPriorityRetryIntervalMs = 5000;
    }
}
