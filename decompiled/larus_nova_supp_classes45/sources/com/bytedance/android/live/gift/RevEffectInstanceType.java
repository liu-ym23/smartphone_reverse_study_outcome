package com.bytedance.android.live.gift;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/gift/RevEffectInstanceType;", "", "DEFAULT", "SPECIAL", "RENDER_FILTER", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevEffectInstanceType extends Enum<RevEffectInstanceType> {
    public static final RevEffectInstanceType DEFAULT = null;
    public static final RevEffectInstanceType RENDER_FILTER = null;
    public static final RevEffectInstanceType SPECIAL = null;
    public static final /* synthetic */ RevEffectInstanceType[] a = null;

    static {
        RevEffectInstanceType r1 = new RevEffectInstanceType("DEFAULT", 0);
        DEFAULT = r1;
        RevEffectInstanceType r2 = new RevEffectInstanceType("SPECIAL", 1);
        SPECIAL = r2;
        RevEffectInstanceType r3 = new RevEffectInstanceType("RENDER_FILTER", 2);
        RENDER_FILTER = r3;
        a = new RevEffectInstanceType[]{r1, r2, r3};
    }

    public static RevEffectInstanceType valueOf(String r1) {
        return (RevEffectInstanceType) a.a(RevEffectInstanceType.class, r1);
    }

    public static RevEffectInstanceType[] values() {
        return (RevEffectInstanceType[]) a.clone();
    }

    public RevEffectInstanceType(String r1, int r2) {
        super(r1, r2);
    }
}
