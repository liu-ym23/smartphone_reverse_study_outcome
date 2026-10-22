package qz8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/larus/commercecredit/impl/entity/CreditInfo;", "", "totalCreditNum", "", "iconUrl", "", "darkModeIconUrl", "creditText", "creditDescText", "subscribeCredit", "Lcom/larus/commercecredit/impl/entity/SubscribeCredit;", "rechargeCredit", "Lcom/larus/commercecredit/impl/entity/RechargeCredit;", "bonusCredit", "Lcom/larus/commercecredit/impl/entity/BonusCredit;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/commercecredit/impl/entity/SubscribeCredit;Lcom/larus/commercecredit/impl/entity/RechargeCredit;Lcom/larus/commercecredit/impl/entity/BonusCredit;)V", "getTotalCreditNum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getIconUrl", "()Ljava/lang/String;", "getDarkModeIconUrl", "getCreditText", "getCreditDescText", "getSubscribeCredit", "()Lcom/larus/commercecredit/impl/entity/SubscribeCredit;", "getRechargeCredit", "()Lcom/larus/commercecredit/impl/entity/RechargeCredit;", "getBonusCredit", "()Lcom/larus/commercecredit/impl/entity/BonusCredit;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/commercecredit/impl/entity/SubscribeCredit;Lcom/larus/commercecredit/impl/entity/RechargeCredit;Lcom/larus/commercecredit/impl/entity/BonusCredit;)Lcom/larus/commercecredit/impl/entity/CreditInfo;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("bonus_credit")
    private final c bonusCredit;

    @SerializedName("credit_desc_text")
    private final String creditDescText;

    @SerializedName("credit_text")
    private final String creditText;

    @SerializedName("dark_mode_icon_url")
    private final String darkModeIconUrl;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("recharge_credit")
    private final n rechargeCredit;

    @SerializedName("subscribe_credit")
    private final p subscribeCredit;

    @SerializedName("total_credit_num")
    private final Long totalCreditNum;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.totalCreditNum, r6.totalCreditNum) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkModeIconUrl, r6.darkModeIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creditText, r6.creditText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creditDescText, r6.creditDescText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subscribeCredit, r6.subscribeCredit) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rechargeCredit, r6.rechargeCredit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bonusCredit, r6.bonusCredit) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.totalCreditNum;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.iconUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.darkModeIconUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.creditText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.creditDescText;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        p r16 = this.subscribeCredit;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        n r19 = this.rechargeCredit;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        c r22 = this.bonusCredit;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreditInfo(totalCreditNum=" + this.totalCreditNum + ", iconUrl=" + this.iconUrl + ", darkModeIconUrl=" + this.darkModeIconUrl + ", creditText=" + this.creditText + ", creditDescText=" + this.creditDescText + ", subscribeCredit=" + this.subscribeCredit + ", rechargeCredit=" + this.rechargeCredit + ", bonusCredit=" + this.bonusCredit + ')';
    }

    public final String b() {
        return this.creditDescText;
    }

    public final String c() {
        return this.creditText;
    }

    public final String d() {
        return this.darkModeIconUrl;
    }

    public final String e() {
        return this.iconUrl;
    }

    public final Long f() {
        return this.totalCreditNum;
    }

    public /* synthetic */ f(int r10) {
        this(null, null, null, null, null, null, null, null);
    }

    public static f a(f r9, Long r10) {
        return new f(r10, r9.iconUrl, r9.darkModeIconUrl, r9.creditText, r9.creditDescText, r9.subscribeCredit, r9.rechargeCredit, r9.bonusCredit);
    }

    public f(Long r1, String r2, String r3, String r4, String r5, p r6, n r7, c r8) {
        this.totalCreditNum = r1;
        this.iconUrl = r2;
        this.darkModeIconUrl = r3;
        this.creditText = r4;
        this.creditDescText = r5;
        this.subscribeCredit = r6;
        this.rechargeCredit = r7;
        this.bonusCredit = r8;
    }
}
