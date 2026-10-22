package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SeriesSendType;", BuildConfig.FLAVOR, "NONE", "ALL", "SINGLE", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeriesSendType extends Enum<SeriesSendType> {
    public static final SeriesSendType ALL = null;
    public static final SeriesSendType NONE = null;
    public static final SeriesSendType SINGLE = null;
    public static final /* synthetic */ SeriesSendType[] a = null;

    static {
        SeriesSendType r1 = new SeriesSendType("NONE", 0);
        NONE = r1;
        SeriesSendType r2 = new SeriesSendType("ALL", 1);
        ALL = r2;
        SeriesSendType r3 = new SeriesSendType("SINGLE", 2);
        SINGLE = r3;
        a = new SeriesSendType[]{r1, r2, r3};
    }

    public static SeriesSendType valueOf(String r1) {
        return (SeriesSendType) r27.a.a(SeriesSendType.class, r1);
    }

    public static SeriesSendType[] values() {
        return (SeriesSendType[]) a.clone();
    }

    public SeriesSendType(String r1, int r2) {
        super(r1, r2);
    }
}
