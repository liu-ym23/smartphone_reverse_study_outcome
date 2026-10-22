package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/SkuImageTypeHelper$SelfType;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_E", "LITE", "H_FREE_CLIP", "H_FREE_PRO", "H_FREE_BUDS_PRO", "H_FREE_CLIP_HE", "GUITAR", "DOLPHIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkuImageTypeHelper$SelfType extends Enum<SkuImageTypeHelper$SelfType> {
    public static final SkuImageTypeHelper$SelfType DOLPHIN = null;
    public static final SkuImageTypeHelper$SelfType DORA_E = null;
    public static final SkuImageTypeHelper$SelfType GUITAR = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_BUDS_PRO = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_CLIP = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_CLIP_HE = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_PRO = null;
    public static final SkuImageTypeHelper$SelfType LITE = null;
    public static final /* synthetic */ SkuImageTypeHelper$SelfType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SkuImageTypeHelper$SelfType> getEntries() {
        return b;
    }

    static {
        SkuImageTypeHelper$SelfType r0 = new SkuImageTypeHelper$SelfType("DORA_E", 0);
        DORA_E = r0;
        SkuImageTypeHelper$SelfType r1 = new SkuImageTypeHelper$SelfType("LITE", 1);
        LITE = r1;
        SkuImageTypeHelper$SelfType r3 = new SkuImageTypeHelper$SelfType("H_FREE_CLIP", 2);
        H_FREE_CLIP = r3;
        SkuImageTypeHelper$SelfType r5 = new SkuImageTypeHelper$SelfType("H_FREE_PRO", 3);
        H_FREE_PRO = r5;
        SkuImageTypeHelper$SelfType r7 = new SkuImageTypeHelper$SelfType("H_FREE_BUDS_PRO", 4);
        H_FREE_BUDS_PRO = r7;
        SkuImageTypeHelper$SelfType r9 = new SkuImageTypeHelper$SelfType("H_FREE_CLIP_HE", 5);
        H_FREE_CLIP_HE = r9;
        SkuImageTypeHelper$SelfType r11 = new SkuImageTypeHelper$SelfType("GUITAR", 6);
        GUITAR = r11;
        SkuImageTypeHelper$SelfType r13 = new SkuImageTypeHelper$SelfType("DOLPHIN", 7);
        DOLPHIN = r13;
        SkuImageTypeHelper$SelfType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static SkuImageTypeHelper$SelfType[] values() {
        return (SkuImageTypeHelper$SelfType[]) a.clone();
    }

    public static SkuImageTypeHelper$SelfType valueOf(String r1) {
        return (SkuImageTypeHelper$SelfType) r27.a.a(SkuImageTypeHelper$SelfType.class, r1);
    }

    public SkuImageTypeHelper$SelfType(String r1, int r2) {
        super(r1, r2);
    }
}
