package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/InterruptReason;", BuildConfig.FLAVOR, "TheSameTypeCompWannaShow", "OtherHighPriorityCompShow", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InterruptReason extends Enum<InterruptReason> {
    public static final InterruptReason OtherHighPriorityCompShow = null;
    public static final InterruptReason TheSameTypeCompWannaShow = null;
    public static final /* synthetic */ InterruptReason[] a = null;

    static {
        InterruptReason r1 = new InterruptReason("TheSameTypeCompWannaShow", 0);
        TheSameTypeCompWannaShow = r1;
        InterruptReason r2 = new InterruptReason("OtherHighPriorityCompShow", 1);
        OtherHighPriorityCompShow = r2;
        a = new InterruptReason[]{r1, r2};
    }

    public static InterruptReason valueOf(String r1) {
        return (InterruptReason) r27.a.a(InterruptReason.class, r1);
    }

    public static InterruptReason[] values() {
        return (InterruptReason[]) a.clone();
    }

    public InterruptReason(String r1, int r2) {
        super(r1, r2);
    }
}
