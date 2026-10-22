package com.bytedance.android.live.effect.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/base/EffectDataFetchType;", "", "", "code", "I", "getCode", "()I", "FetchAll", "FetchByCategory", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EffectDataFetchType extends Enum<EffectDataFetchType> {
    public static final EffectDataFetchType FetchAll = null;
    public static final EffectDataFetchType FetchByCategory = null;
    public static final /* synthetic */ EffectDataFetchType[] a = null;
    private final int code;

    static {
        EffectDataFetchType r1 = new EffectDataFetchType("FetchAll", 0, 0);
        FetchAll = r1;
        EffectDataFetchType r2 = new EffectDataFetchType("FetchByCategory", 1, 1);
        FetchByCategory = r2;
        a = new EffectDataFetchType[]{r1, r2};
    }

    public static EffectDataFetchType valueOf(String r1) {
        return (EffectDataFetchType) r27.a.a(EffectDataFetchType.class, r1);
    }

    public static EffectDataFetchType[] values() {
        return (EffectDataFetchType[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public EffectDataFetchType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
