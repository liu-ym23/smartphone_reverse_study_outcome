package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q implements c {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof StockEntity) == false) goto L111;
        StockEntity r4 = (StockEntity) r3;
        int r0 = r4.getName().hashCode() + 0;
        String r1 = r4.getCurrentPrice();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        String r2 = r4.getHighestPrice();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        String r5 = r4.getLowestPrice();
        if (r5 == null) goto L13;
        r0 = (r0 * 31) + r5.hashCode();
    L13:
        String r6 = r4.getTradingVolume();
        if (r6 == null) goto L16;
        r0 = (r0 * 31) + r6.hashCode();
    L16:
        String r7 = r4.getTradingValue();
        if (r7 == null) goto L19;
        r0 = (r0 * 31) + r7.hashCode();
    L19:
        String r8 = r4.getPriceChangeToday();
        if (r8 == null) goto L22;
        r0 = (r0 * 31) + r8.hashCode();
    L22:
        String r9 = r4.getPriceChangePercentageToday();
        if (r9 == null) goto L25;
        r0 = (r0 * 31) + r9.hashCode();
    L25:
        String r10 = r4.getOpeningPriceToday();
        if (r10 == null) goto L28;
        r0 = (r0 * 31) + r10.hashCode();
    L28:
        String r11 = r4.getClosingPriceToday();
        if (r11 == null) goto L31;
        r0 = (r0 * 31) + r11.hashCode();
    L31:
        String r12 = r4.getNetProfitToShareholders();
        if (r12 == null) goto L34;
        r0 = (r0 * 31) + r12.hashCode();
    L34:
        String r13 = r4.getOperatingIncome();
        if (r13 == null) goto L37;
        r0 = (r0 * 31) + r13.hashCode();
    L37:
        String r14 = r4.getBasicEarningsPerShare();
        if (r14 == null) goto L40;
        r0 = (r0 * 31) + r14.hashCode();
    L40:
        String r15 = r4.getNetAssetsPerShare();
        if (r15 == null) goto L43;
        r0 = (r0 * 31) + r15.hashCode();
    L43:
        String r16 = r4.getGrossProfitMargin();
        if (r16 == null) goto L46;
        r0 = (r0 * 31) + r16.hashCode();
    L46:
        String r17 = r4.getNetProfitMargin();
        if (r17 == null) goto L49;
        r0 = (r0 * 31) + r17.hashCode();
    L49:
        String r18 = r4.getReturnOnEquity();
        if (r18 == null) goto L52;
        r0 = (r0 * 31) + r18.hashCode();
    L52:
        String r19 = r4.getDebtToAssetsRatio();
        if (r19 == null) goto L55;
        r0 = (r0 * 31) + r19.hashCode();
    L55:
        String r20 = r4.getGrossProfit();
        if (r20 == null) goto L58;
        r0 = (r0 * 31) + r20.hashCode();
    L58:
        String r21 = r4.getOperatingProfit();
        if (r21 == null) goto L61;
        r0 = (r0 * 31) + r21.hashCode();
    L61:
        String r22 = r4.getProfitAfterTax();
        if (r22 == null) goto L64;
        r0 = (r0 * 31) + r22.hashCode();
    L64:
        String r23 = r4.getTotalCurrentAssets();
        if (r23 == null) goto L67;
        r0 = (r0 * 31) + r23.hashCode();
    L67:
        String r24 = r4.getTotalNonCurrentAssets();
        if (r24 == null) goto L70;
        r0 = (r0 * 31) + r24.hashCode();
    L70:
        String r25 = r4.getTotalAssets();
        if (r25 == null) goto L73;
        r0 = (r0 * 31) + r25.hashCode();
    L73:
        String r26 = r4.getTotalCurrentLiabilities();
        if (r26 == null) goto L76;
        r0 = (r0 * 31) + r26.hashCode();
    L76:
        String r27 = r4.getTotalNonCurrentLiabilities();
        if (r27 == null) goto L79;
        r0 = (r0 * 31) + r27.hashCode();
    L79:
        String r28 = r4.getTotalLiabilities();
        if (r28 == null) goto L82;
        r0 = (r0 * 31) + r28.hashCode();
    L82:
        String r29 = r4.getShareholdersEquity();
        if (r29 == null) goto L85;
        r0 = (r0 * 31) + r29.hashCode();
    L85:
        String r30 = r4.getTotalEquity();
        if (r30 == null) goto L88;
        r0 = (r0 * 31) + r30.hashCode();
    L88:
        String r31 = r4.getNetCashFlowFromOperatingActivities();
        if (r31 == null) goto L91;
        r0 = (r0 * 31) + r31.hashCode();
    L91:
        String r32 = r4.getNetCashFlowFromInvestingActivities();
        if (r32 == null) goto L94;
        r0 = (r0 * 31) + r32.hashCode();
    L94:
        String r33 = r4.getNetCashFlowFromFinancingActivities();
        if (r33 == null) goto L97;
        r0 = (r0 * 31) + r33.hashCode();
    L97:
        String r34 = r4.getNetCash();
        if (r34 == null) goto L100;
        r0 = (r0 * 31) + r34.hashCode();
    L100:
        String r35 = r4.getCashAtEndOfPeriod();
        if (r35 == null) goto L103;
        r0 = (r0 * 31) + r35.hashCode();
    L103:
        String r36 = r4.getMarket();
        if (r36 == null) goto L106;
        r0 = (r0 * 31) + r36.hashCode();
    L106:
        String r37 = r4.getMarketStatus();
        if (r37 != null) goto L109;
        return r0;
    L109:
        return (r0 * 31) + r37.hashCode();
    L111:
        throw new IllegalStateException("Check failed.".toString());
    }
}
