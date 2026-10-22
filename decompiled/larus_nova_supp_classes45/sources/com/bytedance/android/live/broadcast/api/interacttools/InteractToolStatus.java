package com.bytedance.android.live.broadcast.api.interacttools;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/interacttools/InteractToolStatus;", "", "START", "END", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractToolStatus extends Enum<InteractToolStatus> {
    public static final InteractToolStatus END = null;
    public static final InteractToolStatus START = null;
    public static final /* synthetic */ InteractToolStatus[] a = null;

    static {
        InteractToolStatus r1 = new InteractToolStatus("START", 0);
        START = r1;
        InteractToolStatus r2 = new InteractToolStatus("END", 1);
        END = r2;
        a = new InteractToolStatus[]{r1, r2};
    }

    public static InteractToolStatus valueOf(String r1) {
        return (InteractToolStatus) a.a(InteractToolStatus.class, r1);
    }

    public static InteractToolStatus[] values() {
        return (InteractToolStatus[]) a.clone();
    }

    public InteractToolStatus(String r1, int r2) {
        super(r1, r2);
    }
}
