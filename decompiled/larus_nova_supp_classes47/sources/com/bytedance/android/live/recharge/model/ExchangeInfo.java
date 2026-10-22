package com.bytedance.android.live.recharge.model;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J¡\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001b¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/recharge/model/ExchangeInfo;", "", "exchangeBalance", "", "exchangeDiamond", "isFirstExchange", "", "flameTitle", "", "rebateLimit", "giftAmount", "leftAmount", "maxCash", "maxGoldCount", "goldBalance", "hideCombineExchange", "hideCashExchange", "giftPanelType", "disable", "equivalentCashValue", "", "(IIZLjava/lang/String;IIIIIIZZIZJ)V", "getDisable", "()Z", "getEquivalentCashValue", "()J", "getExchangeBalance", "()I", "setExchangeBalance", "(I)V", "getExchangeDiamond", "getFlameTitle", "()Ljava/lang/String;", "getGiftAmount", "getGiftPanelType", "getGoldBalance", "getHideCashExchange", "getHideCombineExchange", "getLeftAmount", "getMaxCash", "getMaxGoldCount", "getRebateLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExchangeInfo {
    private final boolean disable;
    private final long equivalentCashValue;
    private int exchangeBalance;
    private final int exchangeDiamond;
    private final String flameTitle;
    private final int giftAmount;
    private final int giftPanelType;
    private final int goldBalance;
    private final boolean hideCashExchange;
    private final boolean hideCombineExchange;
    private final boolean isFirstExchange;
    private final int leftAmount;
    private final int maxCash;
    private final int maxGoldCount;
    private final int rebateLimit;

    public static /* synthetic */ ExchangeInfo copy$default(ExchangeInfo r16, int r17, int r18, boolean r19, String r20, int r22, int r23, int r24, int r25, int r26, int r27, boolean r28, boolean r29, int r210, boolean r30, long r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        int r2 = r16.exchangeBalance;
    L7:
        if ((r33 & 2) == 0) goto L9;
        int r3 = r16.exchangeDiamond;
    L11:
        if ((r33 & 4) == 0) goto L13;
        boolean r4 = r16.isFirstExchange;
    L15:
        if ((r33 & 8) == 0) goto L17;
        String r5 = r16.flameTitle;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r6 = r16.rebateLimit;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r7 = r16.giftAmount;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r8 = r16.leftAmount;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r9 = r16.maxCash;
    L35:
        if ((r33 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        int r10 = r16.maxGoldCount;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r12 = r16.goldBalance;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        boolean r13 = r16.hideCombineExchange;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        boolean r14 = r16.hideCashExchange;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r15 = r16.giftPanelType;
    L55:
        if ((r33 & 8192) == 0) goto L57;
        boolean r110 = r16.disable;
    L58:
        int r211 = r15;
        boolean r35 = r110;
        if ((r33 & 16384) == 0) goto L61;
        long r111 = r16.equivalentCashValue;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r211, r35, r111);
    L61:
        r111 = r32;
        goto L63
    L57:
        r110 = r30;
        goto L58
    L53:
        r15 = r210;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final int component1() {
        return this.exchangeBalance;
    }

    public final int component10() {
        return this.goldBalance;
    }

    public final boolean component11() {
        return this.hideCombineExchange;
    }

    public final boolean component12() {
        return this.hideCashExchange;
    }

    public final int component13() {
        return this.giftPanelType;
    }

    public final boolean component14() {
        return this.disable;
    }

    public final long component15() {
        return this.equivalentCashValue;
    }

    public final int component2() {
        return this.exchangeDiamond;
    }

    public final boolean component3() {
        return this.isFirstExchange;
    }

    public final String component4() {
        return this.flameTitle;
    }

    public final int component5() {
        return this.rebateLimit;
    }

    public final int component6() {
        return this.giftAmount;
    }

    public final int component7() {
        return this.leftAmount;
    }

    public final int component8() {
        return this.maxCash;
    }

    public final int component9() {
        return this.maxGoldCount;
    }

    public final ExchangeInfo copy(int r19, int r20, boolean r22, String r23, int r24, int r25, int r26, int r27, int r28, int r29, boolean r210, boolean r30, int r32, boolean r33, long r34) {
        return new ExchangeInfo(r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r210, r30, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof ExchangeInfo) == false) goto L36;
        ExchangeInfo r6 = (ExchangeInfo) r5;
        if (this.exchangeBalance == r6.exchangeBalance) goto L8;
        return false;
    L8:
        if (this.exchangeDiamond == r6.exchangeDiamond) goto L10;
        return false;
    L10:
        if (this.isFirstExchange == r6.isFirstExchange) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.flameTitle, r6.flameTitle) == true) goto L14;
        return false;
    L14:
        if (this.rebateLimit == r6.rebateLimit) goto L16;
        return false;
    L16:
        if (this.giftAmount == r6.giftAmount) goto L18;
        return false;
    L18:
        if (this.leftAmount == r6.leftAmount) goto L20;
        return false;
    L20:
        if (this.maxCash == r6.maxCash) goto L22;
        return false;
    L22:
        if (this.maxGoldCount == r6.maxGoldCount) goto L24;
        return false;
    L24:
        if (this.goldBalance == r6.goldBalance) goto L26;
        return false;
    L26:
        if (this.hideCombineExchange == r6.hideCombineExchange) goto L28;
        return false;
    L28:
        if (this.hideCashExchange == r6.hideCashExchange) goto L30;
        return false;
    L30:
        if (this.giftPanelType == r6.giftPanelType) goto L32;
        return false;
    L32:
        if (this.disable == r6.disable) goto L34;
        return false;
    L34:
        if (this.equivalentCashValue == r6.equivalentCashValue) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        int r0 = ((this.exchangeBalance * 31) + this.exchangeDiamond) * 31;
        boolean r1 = this.isFirstExchange;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        String r5 = this.flameTitle;
        if (r5 == null) goto L8;
        int r6 = r5.hashCode();
    L9:
        int r7 = (((((((((((((r4 + r6) * 31) + this.rebateLimit) * 31) + this.giftAmount) * 31) + this.leftAmount) * 31) + this.maxCash) * 31) + this.maxGoldCount) * 31) + this.goldBalance) * 31;
        boolean r8 = this.hideCombineExchange;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        boolean r12 = this.hideCashExchange;
        ?? r13 = r12;
        if (r12 == false) goto L15;
        r13 = 1;
    L15:
        int r14 = (((r10 + r13) * 31) + this.giftPanelType) * 31;
        boolean r15 = this.disable;
        if (r15 == true) goto L19;
        r2 = r15;
    L19:
        long r16 = this.equivalentCashValue;
        return ((r14 + r2) * 31) + ((int) (r16 ^ (r16 >>> 32)));
    L8:
        r6 = 0;
        goto L9
    }

    public String toString() {
        return "ExchangeInfo(exchangeBalance=" + this.exchangeBalance + ", exchangeDiamond=" + this.exchangeDiamond + ", isFirstExchange=" + this.isFirstExchange + ", flameTitle=" + this.flameTitle + ", rebateLimit=" + this.rebateLimit + ", giftAmount=" + this.giftAmount + ", leftAmount=" + this.leftAmount + ", maxCash=" + this.maxCash + ", maxGoldCount=" + this.maxGoldCount + ", goldBalance=" + this.goldBalance + ", hideCombineExchange=" + this.hideCombineExchange + ", hideCashExchange=" + this.hideCashExchange + ", giftPanelType=" + this.giftPanelType + ", disable=" + this.disable + ", equivalentCashValue=" + this.equivalentCashValue + ")";
    }

    public final boolean getDisable() {
        return this.disable;
    }

    public final long getEquivalentCashValue() {
        return this.equivalentCashValue;
    }

    public final int getExchangeBalance() {
        return this.exchangeBalance;
    }

    public final int getExchangeDiamond() {
        return this.exchangeDiamond;
    }

    public final String getFlameTitle() {
        return this.flameTitle;
    }

    public final int getGiftAmount() {
        return this.giftAmount;
    }

    public final int getGiftPanelType() {
        return this.giftPanelType;
    }

    public final int getGoldBalance() {
        return this.goldBalance;
    }

    public final boolean getHideCashExchange() {
        return this.hideCashExchange;
    }

    public final boolean getHideCombineExchange() {
        return this.hideCombineExchange;
    }

    public final int getLeftAmount() {
        return this.leftAmount;
    }

    public final int getMaxCash() {
        return this.maxCash;
    }

    public final int getMaxGoldCount() {
        return this.maxGoldCount;
    }

    public final int getRebateLimit() {
        return this.rebateLimit;
    }

    public final boolean isFirstExchange() {
        return this.isFirstExchange;
    }

    public final void setExchangeBalance(int r1) {
        this.exchangeBalance = r1;
    }

    public ExchangeInfo(int r4, int r5, boolean r6, String r7, int r8, int r9, int r10, int r12, int r13, int r14, boolean r15, boolean r16, int r17, boolean r18, long r19) {
        this.exchangeBalance = r4;
        this.exchangeDiamond = r5;
        this.isFirstExchange = r6;
        this.flameTitle = r7;
        this.rebateLimit = r8;
        this.giftAmount = r9;
        this.leftAmount = r10;
        this.maxCash = r12;
        this.maxGoldCount = r13;
        this.goldBalance = r14;
        this.hideCombineExchange = r15;
        this.hideCashExchange = r16;
        this.giftPanelType = r17;
        this.disable = r18;
        this.equivalentCashValue = r19;
    }

    public /* synthetic */ ExchangeInfo(int r22, int r23, boolean r24, String r25, int r26, int r27, int r28, int r29, int r210, int r30, boolean r32, boolean r33, int r34, boolean r35, long r36, int r37, DefaultConstructorMarker r38) {
        if ((r37 & 4) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r37 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r37 & 16) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r37 & 32) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r37 & 64) == 0) goto L21;
        int r10 = 0;
    L23:
        if ((r37 & 128) == 0) goto L25;
        int r12 = 0;
    L27:
        if ((r37 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L29;
        int r13 = 0;
    L31:
        if ((r37 & 512) == 0) goto L33;
        int r14 = 0;
    L35:
        if ((r37 & 1024) == 0) goto L37;
        boolean r15 = false;
    L39:
        if ((r37 & 2048) == 0) goto L41;
        boolean r16 = false;
    L43:
        if ((r37 & 4096) == 0) goto L45;
        int r17 = 0;
    L47:
        if ((r37 & 8192) == 0) goto L49;
        boolean r18 = false;
    L51:
        if ((r37 & 16384) == 0) goto L53;
        long r19 = -1;
    L54:
        this(r22, r23, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L53:
        r19 = r36;
        goto L54
    L49:
        r18 = r35;
        goto L51
    L45:
        r17 = r34;
        goto L47
    L41:
        r16 = r33;
        goto L43
    L37:
        r15 = r32;
        goto L39
    L33:
        r14 = r30;
        goto L35
    L29:
        r13 = r210;
        goto L31
    L25:
        r12 = r29;
        goto L27
    L21:
        r10 = r28;
        goto L23
    L17:
        r9 = r27;
        goto L19
    L13:
        r8 = r26;
        goto L15
    L9:
        r7 = r25;
        goto L11
    L5:
        r6 = r24;
        goto L7
    }
}
