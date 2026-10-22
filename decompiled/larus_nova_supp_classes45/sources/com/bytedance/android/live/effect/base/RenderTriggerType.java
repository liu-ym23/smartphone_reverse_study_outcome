package com.bytedance.android.live.effect.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/base/RenderTriggerType;", "", "", "code", "I", "getCode", "()I", "SelectByUser", "UnSelectByUser", "SelectByOthers", "UnSelectByOthers", "Recover", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RenderTriggerType extends Enum<RenderTriggerType> {
    public static final RenderTriggerType Recover = null;
    public static final RenderTriggerType SelectByOthers = null;
    public static final RenderTriggerType SelectByUser = null;
    public static final RenderTriggerType UnSelectByOthers = null;
    public static final RenderTriggerType UnSelectByUser = null;
    public static final /* synthetic */ RenderTriggerType[] a = null;
    private final int code;

    static {
        RenderTriggerType r1 = new RenderTriggerType("SelectByUser", 0, 0);
        SelectByUser = r1;
        RenderTriggerType r2 = new RenderTriggerType("UnSelectByUser", 1, 1);
        UnSelectByUser = r2;
        RenderTriggerType r3 = new RenderTriggerType("SelectByOthers", 2, 2);
        SelectByOthers = r3;
        RenderTriggerType r4 = new RenderTriggerType("UnSelectByOthers", 3, 3);
        UnSelectByOthers = r4;
        RenderTriggerType r5 = new RenderTriggerType("Recover", 4, 4);
        Recover = r5;
        a = new RenderTriggerType[]{r1, r2, r3, r4, r5};
    }

    public static RenderTriggerType valueOf(String r1) {
        return (RenderTriggerType) r27.a.a(RenderTriggerType.class, r1);
    }

    public static RenderTriggerType[] values() {
        return (RenderTriggerType[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public RenderTriggerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
