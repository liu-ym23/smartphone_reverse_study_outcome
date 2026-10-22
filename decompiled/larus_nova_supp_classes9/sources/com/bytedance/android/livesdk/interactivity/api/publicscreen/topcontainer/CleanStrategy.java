package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/CleanStrategy;", BuildConfig.FLAVOR, "NONE", "REMOVE_VIEWS", "REMOVE_WRAP_VIEW", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CleanStrategy extends Enum<CleanStrategy> {
    public static final CleanStrategy NONE = null;
    public static final CleanStrategy REMOVE_VIEWS = null;
    public static final CleanStrategy REMOVE_WRAP_VIEW = null;
    public static final /* synthetic */ CleanStrategy[] a = null;

    static {
        CleanStrategy r1 = new CleanStrategy("NONE", 0);
        NONE = r1;
        CleanStrategy r2 = new CleanStrategy("REMOVE_VIEWS", 1);
        REMOVE_VIEWS = r2;
        CleanStrategy r3 = new CleanStrategy("REMOVE_WRAP_VIEW", 2);
        REMOVE_WRAP_VIEW = r3;
        a = new CleanStrategy[]{r1, r2, r3};
    }

    public static CleanStrategy valueOf(String r1) {
        return (CleanStrategy) a.a(CleanStrategy.class, r1);
    }

    public static CleanStrategy[] values() {
        return (CleanStrategy[]) a.clone();
    }

    public CleanStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
