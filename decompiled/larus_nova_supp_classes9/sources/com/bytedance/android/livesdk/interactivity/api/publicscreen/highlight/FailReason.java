package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/FailReason;", BuildConfig.FLAVOR, "AlreadyShowing", "PriorityLower", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FailReason extends Enum<FailReason> {
    public static final FailReason AlreadyShowing = null;
    public static final FailReason PriorityLower = null;
    public static final /* synthetic */ FailReason[] a = null;

    static {
        FailReason r1 = new FailReason("AlreadyShowing", 0);
        AlreadyShowing = r1;
        FailReason r2 = new FailReason("PriorityLower", 1);
        PriorityLower = r2;
        a = new FailReason[]{r1, r2};
    }

    public static FailReason valueOf(String r1) {
        return (FailReason) r27.a.a(FailReason.class, r1);
    }

    public static FailReason[] values() {
        return (FailReason[]) a.clone();
    }

    public FailReason(String r1, int r2) {
        super(r1, r2);
    }
}
