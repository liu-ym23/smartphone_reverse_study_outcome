package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeDimension;", BuildConfig.FLAVOR, "ROOM", "GLOBAL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DegradeDimension extends Enum<DegradeDimension> {
    public static final DegradeDimension GLOBAL = null;
    public static final DegradeDimension ROOM = null;
    public static final /* synthetic */ DegradeDimension[] a = null;

    static {
        DegradeDimension r1 = new DegradeDimension("ROOM", 0);
        ROOM = r1;
        DegradeDimension r2 = new DegradeDimension("GLOBAL", 1);
        GLOBAL = r2;
        a = new DegradeDimension[]{r1, r2};
    }

    public static DegradeDimension valueOf(String r1) {
        return (DegradeDimension) a.a(DegradeDimension.class, r1);
    }

    public static DegradeDimension[] values() {
        return (DegradeDimension[]) a.clone();
    }

    public DegradeDimension(String r1, int r2) {
        super(r1, r2);
    }
}
