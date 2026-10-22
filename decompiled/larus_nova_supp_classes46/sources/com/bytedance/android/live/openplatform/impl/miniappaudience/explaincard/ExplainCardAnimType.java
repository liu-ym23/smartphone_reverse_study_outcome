package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/ExplainCardAnimType;", "", "", "value", "I", "getValue", "()I", "SMALL_CARD", "SELF_CARD", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExplainCardAnimType extends Enum<ExplainCardAnimType> {
    public static final ExplainCardAnimType SELF_CARD = null;
    public static final ExplainCardAnimType SMALL_CARD = null;
    public static final /* synthetic */ ExplainCardAnimType[] a = null;
    private final int value;

    static {
        ExplainCardAnimType r2 = new ExplainCardAnimType("SMALL_CARD", 0, 1);
        SMALL_CARD = r2;
        ExplainCardAnimType r3 = new ExplainCardAnimType("SELF_CARD", 1, 2);
        SELF_CARD = r3;
        a = new ExplainCardAnimType[]{r2, r3};
    }

    public static ExplainCardAnimType valueOf(String r1) {
        return (ExplainCardAnimType) r27.a.a(ExplainCardAnimType.class, r1);
    }

    public static ExplainCardAnimType[] values() {
        return (ExplainCardAnimType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExplainCardAnimType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
