package com.bytedance.android.annie.service.appruntime;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/annie/service/appruntime/DegradeStatus;", "", "", a.KEY_STATUS, "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "liveDegrade", "lowMemory", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum DegradeStatus extends Enum<DegradeStatus> {
    public static final /* synthetic */ DegradeStatus[] a = null;
    public static final DegradeStatus liveDegrade = null;
    public static final DegradeStatus lowMemory = null;
    private final String status;

    public static DegradeStatus valueOf(String r1) {
        return (DegradeStatus) r27.a.a(DegradeStatus.class, r1);
    }

    public static DegradeStatus[] values() {
        return (DegradeStatus[]) a.clone();
    }

    static {
        DegradeStatus r0 = new DegradeStatus("liveDegrade", 0, "live_degrade");
        liveDegrade = r0;
        DegradeStatus r1 = new DegradeStatus("lowMemory", 1, "low_memory");
        lowMemory = r1;
        a = new DegradeStatus[]{r0, r1};
    }

    public final String getStatus() {
        return this.status;
    }

    public DegradeStatus(String r1, int r10, String r11) {
        super(r1, r10);
        this.status = r11;
    }
}
