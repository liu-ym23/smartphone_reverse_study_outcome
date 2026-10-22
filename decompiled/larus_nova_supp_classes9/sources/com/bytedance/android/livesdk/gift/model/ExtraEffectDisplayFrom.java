package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ExtraEffectDisplayFrom;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "DisplayFormDefault", "DisplayFormSequential", "DisplayFormParalell", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ExtraEffectDisplayFrom extends Enum<ExtraEffectDisplayFrom> {
    public static final ExtraEffectDisplayFrom DisplayFormDefault = null;
    public static final ExtraEffectDisplayFrom DisplayFormParalell = null;
    public static final ExtraEffectDisplayFrom DisplayFormSequential = null;
    public static final /* synthetic */ ExtraEffectDisplayFrom[] a = null;
    private final int value;

    static {
        ExtraEffectDisplayFrom r1 = new ExtraEffectDisplayFrom("DisplayFormDefault", 0, 0);
        DisplayFormDefault = r1;
        ExtraEffectDisplayFrom r2 = new ExtraEffectDisplayFrom("DisplayFormSequential", 1, 1);
        DisplayFormSequential = r2;
        ExtraEffectDisplayFrom r3 = new ExtraEffectDisplayFrom("DisplayFormParalell", 2, 2);
        DisplayFormParalell = r3;
        a = new ExtraEffectDisplayFrom[]{r1, r2, r3};
    }

    public static ExtraEffectDisplayFrom valueOf(String r1) {
        return (ExtraEffectDisplayFrom) r27.a.a(ExtraEffectDisplayFrom.class, r1);
    }

    public static ExtraEffectDisplayFrom[] values() {
        return (ExtraEffectDisplayFrom[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ExtraEffectDisplayFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
