package com.bytedance.android.ec.core.imagex;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/LoadType;", "", "FIRST_CACHE", "FIRST_REAL_DATA", "SECOND_REAL_DATA", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadType extends Enum<LoadType> {
    public static final LoadType FIRST_CACHE = null;
    public static final LoadType FIRST_REAL_DATA = null;
    public static final LoadType SECOND_REAL_DATA = null;
    public static final /* synthetic */ LoadType[] a = null;

    static {
        LoadType r1 = new LoadType("FIRST_CACHE", 0);
        FIRST_CACHE = r1;
        LoadType r10 = new LoadType("FIRST_REAL_DATA", 1);
        FIRST_REAL_DATA = r10;
        LoadType r11 = new LoadType("SECOND_REAL_DATA", 2);
        SECOND_REAL_DATA = r11;
        a = new LoadType[]{r1, r10, r11};
    }

    public static LoadType valueOf(String r1) {
        return (LoadType) r27.a.a(LoadType.class, r1);
    }

    public static LoadType[] values() {
        return (LoadType[]) a.clone();
    }

    public LoadType(String r1, int r10) {
        super(r1, r10);
    }
}
