package com.bytedance.android.annie.bridge.method;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/OpenActionStatus;", "", "BEFORE_OPEN", "AFTER_OPEN", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum OpenActionStatus extends Enum<OpenActionStatus> {
    public static final OpenActionStatus AFTER_OPEN = null;
    public static final OpenActionStatus BEFORE_OPEN = null;
    public static final /* synthetic */ OpenActionStatus[] a = null;

    public static OpenActionStatus valueOf(String r1) {
        return (OpenActionStatus) r27.a.a(OpenActionStatus.class, r1);
    }

    public static OpenActionStatus[] values() {
        return (OpenActionStatus[]) a.clone();
    }

    static {
        OpenActionStatus r0 = new OpenActionStatus("BEFORE_OPEN", 0);
        BEFORE_OPEN = r0;
        OpenActionStatus r1 = new OpenActionStatus("AFTER_OPEN", 1);
        AFTER_OPEN = r1;
        a = new OpenActionStatus[]{r0, r1};
    }

    public OpenActionStatus(String r1, int r10) {
        super(r1, r10);
    }
}
