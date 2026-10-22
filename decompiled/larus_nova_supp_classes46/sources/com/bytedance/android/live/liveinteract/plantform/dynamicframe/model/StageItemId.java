package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/StageItemId;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ORDER_SING_STAGE", "SUB_TITLE_STAGE", "Enlarge_STAGE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StageItemId extends Enum<StageItemId> {
    public static final StageItemId Enlarge_STAGE = null;
    public static final StageItemId ORDER_SING_STAGE = null;
    public static final StageItemId SUB_TITLE_STAGE = null;
    public static final /* synthetic */ StageItemId[] a = null;
    private final String value;

    static {
        StageItemId r1 = new StageItemId("ORDER_SING_STAGE", 0, "orderSingStage");
        ORDER_SING_STAGE = r1;
        StageItemId r2 = new StageItemId("SUB_TITLE_STAGE", 1, "subtitleStage");
        SUB_TITLE_STAGE = r2;
        StageItemId r3 = new StageItemId("Enlarge_STAGE", 2, "enlargeStage");
        Enlarge_STAGE = r3;
        a = new StageItemId[]{r1, r2, r3};
    }

    public static StageItemId valueOf(String r1) {
        return (StageItemId) a.a(StageItemId.class, r1);
    }

    public static StageItemId[] values() {
        return (StageItemId[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public StageItemId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
