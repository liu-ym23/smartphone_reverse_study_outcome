package com.bytedance.android.live.core.tetris.componentx.schedule;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/DependencyEnum;", "", "BEFORE", "AFTER", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DependencyEnum extends Enum<DependencyEnum> {
    public static final DependencyEnum AFTER = null;
    public static final DependencyEnum BEFORE = null;
    public static final /* synthetic */ DependencyEnum[] a = null;

    static {
        DependencyEnum r1 = new DependencyEnum("BEFORE", 0);
        BEFORE = r1;
        DependencyEnum r2 = new DependencyEnum("AFTER", 1);
        AFTER = r2;
        a = new DependencyEnum[]{r1, r2};
    }

    public static DependencyEnum valueOf(String r1) {
        return (DependencyEnum) r27.a.a(DependencyEnum.class, r1);
    }

    public static DependencyEnum[] values() {
        return (DependencyEnum[]) a.clone();
    }

    public DependencyEnum(String r1, int r2) {
        super(r1, r2);
    }
}
