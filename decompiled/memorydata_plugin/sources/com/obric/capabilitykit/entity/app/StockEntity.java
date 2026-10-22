package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\bq\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\"\u0010y\u001a\u00020z2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020~H\u0016J\u0019\u0010\u007f\u001a\u00020z2\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0080\u0001\u001a\u00020~H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001c\u0010 \u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001c\u0010&\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001c\u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001c\u00101\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\u001c\u0010=\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001c\u0010@\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R\u001c\u0010C\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001c\u0010F\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010\u0010R\u001c\u0010I\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000e\"\u0004\bK\u0010\u0010R\u001c\u0010L\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010\u0010R\u001c\u0010O\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010\u0010R\u001c\u0010R\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R\u001c\u0010U\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R\u001c\u0010X\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u0010R\u001c\u0010[\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R\u001c\u0010^\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000e\"\u0004\b`\u0010\u0010R\u001c\u0010a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u000e\"\u0004\bc\u0010\u0010R\u001c\u0010d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u000e\"\u0004\bf\u0010\u0010R\u001c\u0010g\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000e\"\u0004\bi\u0010\u0010R\u001c\u0010j\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u000e\"\u0004\bl\u0010\u0010R\u001c\u0010m\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u000e\"\u0004\bo\u0010\u0010R\u001c\u0010p\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u000e\"\u0004\br\u0010\u0010R\u001c\u0010s\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u000e\"\u0004\bu\u0010\u0010R\u001c\u0010v\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u000e\"\u0004\bx\u0010\u0010¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/capabilitykit/entity/app/StockEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", ActivityLifecycle.NAME, "(Ljava/lang/String;JJLjava/lang/String;)V", "basicEarningsPerShare", "getBasicEarningsPerShare", "()Ljava/lang/String;", "setBasicEarningsPerShare", "(Ljava/lang/String;)V", "cashAtEndOfPeriod", "getCashAtEndOfPeriod", "setCashAtEndOfPeriod", "closingPriceToday", "getClosingPriceToday", "setClosingPriceToday", "currentPrice", "getCurrentPrice", "setCurrentPrice", "debtToAssetsRatio", "getDebtToAssetsRatio", "setDebtToAssetsRatio", "grossProfit", "getGrossProfit", "setGrossProfit", "grossProfitMargin", "getGrossProfitMargin", "setGrossProfitMargin", "highestPrice", "getHighestPrice", "setHighestPrice", "lowestPrice", "getLowestPrice", "setLowestPrice", "market", "getMarket", "setMarket", "marketStatus", "getMarketStatus", "setMarketStatus", "getName", "setName", "netAssetsPerShare", "getNetAssetsPerShare", "setNetAssetsPerShare", "netCash", "getNetCash", "setNetCash", "netCashFlowFromFinancingActivities", "getNetCashFlowFromFinancingActivities", "setNetCashFlowFromFinancingActivities", "netCashFlowFromInvestingActivities", "getNetCashFlowFromInvestingActivities", "setNetCashFlowFromInvestingActivities", "netCashFlowFromOperatingActivities", "getNetCashFlowFromOperatingActivities", "setNetCashFlowFromOperatingActivities", "netProfitMargin", "getNetProfitMargin", "setNetProfitMargin", "netProfitToShareholders", "getNetProfitToShareholders", "setNetProfitToShareholders", "openingPriceToday", "getOpeningPriceToday", "setOpeningPriceToday", "operatingIncome", "getOperatingIncome", "setOperatingIncome", "operatingProfit", "getOperatingProfit", "setOperatingProfit", "priceChangePercentageToday", "getPriceChangePercentageToday", "setPriceChangePercentageToday", "priceChangeToday", "getPriceChangeToday", "setPriceChangeToday", "profitAfterTax", "getProfitAfterTax", "setProfitAfterTax", "returnOnEquity", "getReturnOnEquity", "setReturnOnEquity", "shareholdersEquity", "getShareholdersEquity", "setShareholdersEquity", "totalAssets", "getTotalAssets", "setTotalAssets", "totalCurrentAssets", "getTotalCurrentAssets", "setTotalCurrentAssets", "totalCurrentLiabilities", "getTotalCurrentLiabilities", "setTotalCurrentLiabilities", "totalEquity", "getTotalEquity", "setTotalEquity", "totalLiabilities", "getTotalLiabilities", "setTotalLiabilities", "totalNonCurrentAssets", "getTotalNonCurrentAssets", "setTotalNonCurrentAssets", "totalNonCurrentLiabilities", "getTotalNonCurrentLiabilities", "setTotalNonCurrentLiabilities", "tradingValue", "getTradingValue", "setTradingValue", "tradingVolume", "getTradingVolume", "setTradingVolume", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StockEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String basicEarningsPerShare;
    private String cashAtEndOfPeriod;
    private String closingPriceToday;
    private String currentPrice;
    private String debtToAssetsRatio;
    private String grossProfit;
    private String grossProfitMargin;
    private String highestPrice;
    private String lowestPrice;
    private String market;
    private String marketStatus;
    private String name;
    private String netAssetsPerShare;
    private String netCash;
    private String netCashFlowFromFinancingActivities;
    private String netCashFlowFromInvestingActivities;
    private String netCashFlowFromOperatingActivities;
    private String netProfitMargin;
    private String netProfitToShareholders;
    private String openingPriceToday;
    private String operatingIncome;
    private String operatingProfit;
    private String priceChangePercentageToday;
    private String priceChangeToday;
    private String profitAfterTax;
    private String returnOnEquity;
    private String shareholdersEquity;
    private String totalAssets;
    private String totalCurrentAssets;
    private String totalCurrentLiabilities;
    private String totalEquity;
    private String totalLiabilities;
    private String totalNonCurrentAssets;
    private String totalNonCurrentLiabilities;
    private String tradingValue;
    private String tradingVolume;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/StockEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/StockEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/StockEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<StockEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StockEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.StockEntity");
            return (StockEntity) ZeusTransformUtils.preCheckCast(r1, StockEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StockEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StockEntity[] newArray(int r1) {
            return new StockEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ StockEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public StockEntity(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        this(EntityExtKt.readStringOrEmpty(r9), r9.readLong(), r9.readLong(), EntityExtKt.readStringOrEmpty(r9));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r9);
        int r0 = r9.readInt();
        this.currentPrice = EntityExtKt.readStringOrEmpty(r9);
        this.highestPrice = EntityExtKt.readStringOrEmpty(r9);
        this.lowestPrice = EntityExtKt.readStringOrEmpty(r9);
        this.tradingVolume = EntityExtKt.readStringOrEmpty(r9);
        this.tradingValue = EntityExtKt.readStringOrEmpty(r9);
        this.priceChangeToday = EntityExtKt.readStringOrEmpty(r9);
        this.priceChangePercentageToday = EntityExtKt.readStringOrEmpty(r9);
        this.openingPriceToday = EntityExtKt.readStringOrEmpty(r9);
        this.closingPriceToday = EntityExtKt.readStringOrEmpty(r9);
        this.netProfitToShareholders = EntityExtKt.readStringOrEmpty(r9);
        this.operatingIncome = EntityExtKt.readStringOrEmpty(r9);
        this.basicEarningsPerShare = EntityExtKt.readStringOrEmpty(r9);
        this.netAssetsPerShare = EntityExtKt.readStringOrEmpty(r9);
        this.grossProfitMargin = EntityExtKt.readStringOrEmpty(r9);
        this.netProfitMargin = EntityExtKt.readStringOrEmpty(r9);
        this.returnOnEquity = EntityExtKt.readStringOrEmpty(r9);
        this.debtToAssetsRatio = EntityExtKt.readStringOrEmpty(r9);
        this.grossProfit = EntityExtKt.readStringOrEmpty(r9);
        this.operatingProfit = EntityExtKt.readStringOrEmpty(r9);
        this.profitAfterTax = EntityExtKt.readStringOrEmpty(r9);
        this.totalCurrentAssets = EntityExtKt.readStringOrEmpty(r9);
        this.totalNonCurrentAssets = EntityExtKt.readStringOrEmpty(r9);
        this.totalAssets = EntityExtKt.readStringOrEmpty(r9);
        this.totalCurrentLiabilities = EntityExtKt.readStringOrEmpty(r9);
        this.totalNonCurrentLiabilities = EntityExtKt.readStringOrEmpty(r9);
        this.totalLiabilities = EntityExtKt.readStringOrEmpty(r9);
        this.shareholdersEquity = EntityExtKt.readStringOrEmpty(r9);
        this.totalEquity = EntityExtKt.readStringOrEmpty(r9);
        this.netCashFlowFromOperatingActivities = EntityExtKt.readStringOrEmpty(r9);
        this.netCashFlowFromInvestingActivities = EntityExtKt.readStringOrEmpty(r9);
        this.netCashFlowFromFinancingActivities = EntityExtKt.readStringOrEmpty(r9);
        this.netCash = EntityExtKt.readStringOrEmpty(r9);
        this.cashAtEndOfPeriod = EntityExtKt.readStringOrEmpty(r9);
        this.market = EntityExtKt.readStringOrEmpty(r9);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r9, 1, r0);
    }

    public StockEntity(String r9, long r10, long r12, String r14) {
        Intrinsics.checkNotNullParameter(r9, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        super(r9, r10, r12, EntityType.STOCK);
        this.name = r14;
    }

    public final String getBasicEarningsPerShare() {
        return this.basicEarningsPerShare;
    }

    public final String getCashAtEndOfPeriod() {
        return this.cashAtEndOfPeriod;
    }

    public final String getClosingPriceToday() {
        return this.closingPriceToday;
    }

    public final String getCurrentPrice() {
        return this.currentPrice;
    }

    public final String getDebtToAssetsRatio() {
        return this.debtToAssetsRatio;
    }

    public final String getGrossProfit() {
        return this.grossProfit;
    }

    public final String getGrossProfitMargin() {
        return this.grossProfitMargin;
    }

    public final String getHighestPrice() {
        return this.highestPrice;
    }

    public final String getLowestPrice() {
        return this.lowestPrice;
    }

    public final String getMarket() {
        return this.market;
    }

    public final String getMarketStatus() {
        return this.marketStatus;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNetAssetsPerShare() {
        return this.netAssetsPerShare;
    }

    public final String getNetCash() {
        return this.netCash;
    }

    public final String getNetCashFlowFromFinancingActivities() {
        return this.netCashFlowFromFinancingActivities;
    }

    public final String getNetCashFlowFromInvestingActivities() {
        return this.netCashFlowFromInvestingActivities;
    }

    public final String getNetCashFlowFromOperatingActivities() {
        return this.netCashFlowFromOperatingActivities;
    }

    public final String getNetProfitMargin() {
        return this.netProfitMargin;
    }

    public final String getNetProfitToShareholders() {
        return this.netProfitToShareholders;
    }

    public final String getOpeningPriceToday() {
        return this.openingPriceToday;
    }

    public final String getOperatingIncome() {
        return this.operatingIncome;
    }

    public final String getOperatingProfit() {
        return this.operatingProfit;
    }

    public final String getPriceChangePercentageToday() {
        return this.priceChangePercentageToday;
    }

    public final String getPriceChangeToday() {
        return this.priceChangeToday;
    }

    public final String getProfitAfterTax() {
        return this.profitAfterTax;
    }

    public final String getReturnOnEquity() {
        return this.returnOnEquity;
    }

    public final String getShareholdersEquity() {
        return this.shareholdersEquity;
    }

    public final String getTotalAssets() {
        return this.totalAssets;
    }

    public final String getTotalCurrentAssets() {
        return this.totalCurrentAssets;
    }

    public final String getTotalCurrentLiabilities() {
        return this.totalCurrentLiabilities;
    }

    public final String getTotalEquity() {
        return this.totalEquity;
    }

    public final String getTotalLiabilities() {
        return this.totalLiabilities;
    }

    public final String getTotalNonCurrentAssets() {
        return this.totalNonCurrentAssets;
    }

    public final String getTotalNonCurrentLiabilities() {
        return this.totalNonCurrentLiabilities;
    }

    public final String getTradingValue() {
        return this.tradingValue;
    }

    public final String getTradingVolume() {
        return this.tradingVolume;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L6;
        this.marketStatus = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void setBasicEarningsPerShare(String r1) {
        this.basicEarningsPerShare = r1;
    }

    public final void setCashAtEndOfPeriod(String r1) {
        this.cashAtEndOfPeriod = r1;
    }

    public final void setClosingPriceToday(String r1) {
        this.closingPriceToday = r1;
    }

    public final void setCurrentPrice(String r1) {
        this.currentPrice = r1;
    }

    public final void setDebtToAssetsRatio(String r1) {
        this.debtToAssetsRatio = r1;
    }

    public final void setGrossProfit(String r1) {
        this.grossProfit = r1;
    }

    public final void setGrossProfitMargin(String r1) {
        this.grossProfitMargin = r1;
    }

    public final void setHighestPrice(String r1) {
        this.highestPrice = r1;
    }

    public final void setLowestPrice(String r1) {
        this.lowestPrice = r1;
    }

    public final void setMarket(String r1) {
        this.market = r1;
    }

    public final void setMarketStatus(String r1) {
        this.marketStatus = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNetAssetsPerShare(String r1) {
        this.netAssetsPerShare = r1;
    }

    public final void setNetCash(String r1) {
        this.netCash = r1;
    }

    public final void setNetCashFlowFromFinancingActivities(String r1) {
        this.netCashFlowFromFinancingActivities = r1;
    }

    public final void setNetCashFlowFromInvestingActivities(String r1) {
        this.netCashFlowFromInvestingActivities = r1;
    }

    public final void setNetCashFlowFromOperatingActivities(String r1) {
        this.netCashFlowFromOperatingActivities = r1;
    }

    public final void setNetProfitMargin(String r1) {
        this.netProfitMargin = r1;
    }

    public final void setNetProfitToShareholders(String r1) {
        this.netProfitToShareholders = r1;
    }

    public final void setOpeningPriceToday(String r1) {
        this.openingPriceToday = r1;
    }

    public final void setOperatingIncome(String r1) {
        this.operatingIncome = r1;
    }

    public final void setOperatingProfit(String r1) {
        this.operatingProfit = r1;
    }

    public final void setPriceChangePercentageToday(String r1) {
        this.priceChangePercentageToday = r1;
    }

    public final void setPriceChangeToday(String r1) {
        this.priceChangeToday = r1;
    }

    public final void setProfitAfterTax(String r1) {
        this.profitAfterTax = r1;
    }

    public final void setReturnOnEquity(String r1) {
        this.returnOnEquity = r1;
    }

    public final void setShareholdersEquity(String r1) {
        this.shareholdersEquity = r1;
    }

    public final void setTotalAssets(String r1) {
        this.totalAssets = r1;
    }

    public final void setTotalCurrentAssets(String r1) {
        this.totalCurrentAssets = r1;
    }

    public final void setTotalCurrentLiabilities(String r1) {
        this.totalCurrentLiabilities = r1;
    }

    public final void setTotalEquity(String r1) {
        this.totalEquity = r1;
    }

    public final void setTotalLiabilities(String r1) {
        this.totalLiabilities = r1;
    }

    public final void setTotalNonCurrentAssets(String r1) {
        this.totalNonCurrentAssets = r1;
    }

    public final void setTotalNonCurrentLiabilities(String r1) {
        this.totalNonCurrentLiabilities = r1;
    }

    public final void setTradingValue(String r1) {
        this.tradingValue = r1;
    }

    public final void setTradingVolume(String r1) {
        this.tradingVolume = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(1);
        r1.writeString(this.currentPrice);
        r1.writeString(this.highestPrice);
        r1.writeString(this.lowestPrice);
        r1.writeString(this.tradingVolume);
        r1.writeString(this.tradingValue);
        r1.writeString(this.priceChangeToday);
        r1.writeString(this.priceChangePercentageToday);
        r1.writeString(this.openingPriceToday);
        r1.writeString(this.closingPriceToday);
        r1.writeString(this.netProfitToShareholders);
        r1.writeString(this.operatingIncome);
        r1.writeString(this.basicEarningsPerShare);
        r1.writeString(this.netAssetsPerShare);
        r1.writeString(this.grossProfitMargin);
        r1.writeString(this.netProfitMargin);
        r1.writeString(this.returnOnEquity);
        r1.writeString(this.debtToAssetsRatio);
        r1.writeString(this.grossProfit);
        r1.writeString(this.operatingProfit);
        r1.writeString(this.profitAfterTax);
        r1.writeString(this.totalCurrentAssets);
        r1.writeString(this.totalNonCurrentAssets);
        r1.writeString(this.totalAssets);
        r1.writeString(this.totalCurrentLiabilities);
        r1.writeString(this.totalNonCurrentLiabilities);
        r1.writeString(this.totalLiabilities);
        r1.writeString(this.shareholdersEquity);
        r1.writeString(this.totalEquity);
        r1.writeString(this.netCashFlowFromOperatingActivities);
        r1.writeString(this.netCashFlowFromInvestingActivities);
        r1.writeString(this.netCashFlowFromFinancingActivities);
        r1.writeString(this.netCash);
        r1.writeString(this.cashAtEndOfPeriod);
        r1.writeString(this.market);
        r1.writeValue(this.marketStatus);
    }
}
