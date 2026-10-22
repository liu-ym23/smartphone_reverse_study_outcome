package com.larus.dora.api.h;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/api/h/HSKU;", "", "skuName", "", "sku", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getSkuName", "()Ljava/lang/String;", "getSku", "()I", "SILVER", "WHITE", "BLACK", "BLUE", "GRADIENT", "PURPLE", "ORANGE", "BLACKENED", "HORSE_YEAR_WHITE", "GOLD", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HSKU extends Enum<HSKU> {
    public static final HSKU BLACK = null;
    public static final HSKU BLACKENED = null;
    public static final HSKU BLUE = null;
    public static final a Companion = null;
    public static final HSKU GOLD = null;
    public static final HSKU GRADIENT = null;
    public static final HSKU HORSE_YEAR_WHITE = null;
    public static final HSKU ORANGE = null;
    public static final HSKU PURPLE = null;
    public static final HSKU SILVER = null;
    public static final HSKU WHITE = null;
    public static final /* synthetic */ HSKU[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int sku;
    private final String skuName;

    public static final class a {
        public a() {
        }

        public static HSKU a(Integer r7) {
            if (r7 == null) goto L16;
            HSKU[] r0 = HSKU.values();
            int r1 = r0.length;
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L13;
            HSKU r4 = r0[r3];
            if (r4.getSku() != r7.intValue()) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == true) goto L14;
            r3 = r3 + 1;
        L14:
            if (r4 == null) goto L16;
            return r4;
        L9:
            r5 = false;
            goto L10
        L13:
            r4 = null;
        L16:
            return HSKU.WHITE;
        }
    }

    public static EnumEntries<HSKU> getEntries() {
        return b;
    }

    static {
        HSKU r0 = new HSKU("SILVER", 0, "silver", 0);
        SILVER = r0;
        HSKU r1 = new HSKU("WHITE", 1, "white", 1);
        WHITE = r1;
        HSKU r3 = new HSKU("BLACK", 2, "black", 2);
        BLACK = r3;
        HSKU r5 = new HSKU("BLUE", 3, "blue", 5);
        BLUE = r5;
        HSKU r7 = new HSKU("GRADIENT", 4, "gradient", 6);
        GRADIENT = r7;
        HSKU r9 = new HSKU("PURPLE", 5, "purple", 7);
        PURPLE = r9;
        HSKU r12 = new HSKU("ORANGE", 6, "orange", 9);
        ORANGE = r12;
        HSKU r10 = new HSKU("BLACKENED", 7, "blackened", 14);
        BLACKENED = r10;
        HSKU r8 = new HSKU("HORSE_YEAR_WHITE", 8, "horse_year_white", 20);
        HORSE_YEAR_WHITE = r8;
        HSKU r6 = new HSKU("GOLD", 9, "gold", 23);
        GOLD = r6;
        HSKU[] r13 = {r0, r1, r3, r5, r7, r9, r12, r10, r8, r6};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static HSKU[] values() {
        return (HSKU[]) a.clone();
    }

    public final int getSku() {
        return this.sku;
    }

    public final String getSkuName() {
        return this.skuName;
    }

    public static HSKU valueOf(String r1) {
        return (HSKU) r27.a.a(HSKU.class, r1);
    }

    public HSKU(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.skuName = r3;
        this.sku = r4;
    }
}
