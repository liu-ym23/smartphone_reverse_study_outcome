package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/DiscardReason;", BuildConfig.FLAVOR, "UNKNOW", "INVALID", "EXPIRED", "CONFLICT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DiscardReason extends Enum<DiscardReason> {
    public static final DiscardReason CONFLICT = null;
    public static final DiscardReason EXPIRED = null;
    public static final DiscardReason INVALID = null;
    public static final DiscardReason UNKNOW = null;
    public static final /* synthetic */ DiscardReason[] a = null;

    static {
        DiscardReason r1 = new DiscardReason("UNKNOW", 0);
        UNKNOW = r1;
        DiscardReason r2 = new DiscardReason("INVALID", 1);
        INVALID = r2;
        DiscardReason r3 = new DiscardReason("EXPIRED", 2);
        EXPIRED = r3;
        DiscardReason r4 = new DiscardReason("CONFLICT", 3);
        CONFLICT = r4;
        a = new DiscardReason[]{r1, r2, r3, r4};
    }

    public static DiscardReason valueOf(String r1) {
        return (DiscardReason) a.a(DiscardReason.class, r1);
    }

    public static DiscardReason[] values() {
        return (DiscardReason[]) a.clone();
    }

    public DiscardReason(String r1, int r2) {
        super(r1, r2);
    }
}
