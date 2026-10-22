package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/DynamicEffectType;", "", "NONE", "ADD_COMPOSER_COEXISTLIST", "SET_LOKI_EFFECT", "REMOVE_LOKI_EFFECT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicEffectType extends Enum<DynamicEffectType> {
    public static final DynamicEffectType ADD_COMPOSER_COEXISTLIST = null;
    public static final DynamicEffectType NONE = null;
    public static final DynamicEffectType REMOVE_LOKI_EFFECT = null;
    public static final DynamicEffectType SET_LOKI_EFFECT = null;
    public static final /* synthetic */ DynamicEffectType[] a = null;

    static {
        DynamicEffectType r1 = new DynamicEffectType("NONE", 0);
        NONE = r1;
        DynamicEffectType r2 = new DynamicEffectType("ADD_COMPOSER_COEXISTLIST", 1);
        ADD_COMPOSER_COEXISTLIST = r2;
        DynamicEffectType r3 = new DynamicEffectType("SET_LOKI_EFFECT", 2);
        SET_LOKI_EFFECT = r3;
        DynamicEffectType r4 = new DynamicEffectType("REMOVE_LOKI_EFFECT", 3);
        REMOVE_LOKI_EFFECT = r4;
        a = new DynamicEffectType[]{r1, r2, r3, r4};
    }

    public static DynamicEffectType valueOf(String r1) {
        return (DynamicEffectType) a.a(DynamicEffectType.class, r1);
    }

    public static DynamicEffectType[] values() {
        return (DynamicEffectType[]) a.clone();
    }

    public DynamicEffectType(String r1, int r2) {
        super(r1, r2);
    }
}
