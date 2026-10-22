package com.bytedance.android.live.broadcast.api.anchorbizpanel;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/anchorbizpanel/OperateSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "GESTURE", "PROFILE_DATA", "PROFILE_ABNORMAL_REMIND", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperateSource extends Enum<OperateSource> {
    public static final OperateSource GESTURE = null;
    public static final OperateSource PROFILE_ABNORMAL_REMIND = null;
    public static final OperateSource PROFILE_DATA = null;
    public static final /* synthetic */ OperateSource[] a = null;
    private final String value;

    static {
        OperateSource r1 = new OperateSource("GESTURE", 0, "gesture");
        GESTURE = r1;
        OperateSource r2 = new OperateSource("PROFILE_DATA", 1, "profile_data");
        PROFILE_DATA = r2;
        OperateSource r3 = new OperateSource("PROFILE_ABNORMAL_REMIND", 2, "profile_abnormal_remind");
        PROFILE_ABNORMAL_REMIND = r3;
        a = new OperateSource[]{r1, r2, r3};
    }

    public static OperateSource valueOf(String r1) {
        return (OperateSource) a.a(OperateSource.class, r1);
    }

    public static OperateSource[] values() {
        return (OperateSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public OperateSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
